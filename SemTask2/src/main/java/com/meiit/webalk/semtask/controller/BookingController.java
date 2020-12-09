package com.meiit.webalk.semtask.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meiit.webalk.semtask.model.Currency;
import com.meiit.webalk.semtask.model.Floor;
import com.meiit.webalk.semtask.model.Hotel;
import com.meiit.webalk.semtask.model.Person;
import com.meiit.webalk.semtask.model.Reservation;
import com.meiit.webalk.semtask.model.Room;
import com.meiit.webalk.semtask.model.User;
import com.meiit.webalk.semtask.model.Wing;
import com.meiit.webalk.semtask.service.FloorService;
import com.meiit.webalk.semtask.service.HotelService;
import com.meiit.webalk.semtask.service.PersonService;
import com.meiit.webalk.semtask.service.ReservationService;
import com.meiit.webalk.semtask.service.RoomService;
import com.meiit.webalk.semtask.service.UserService;
import com.meiit.webalk.semtask.service.WingService;


@Controller
public class BookingController
{

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private FloorService floorService;
	
	@Autowired
	private WingService wingService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ReservationService reservationService;
	
	
	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public ModelAndView hotels()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		List<Hotel> hotels = hotelService.getAllHotels();
		
		modelAndView.addObject("hotels", hotels);
		modelAndView.setViewName("booking/hotels");
		return modelAndView;
	}
		
	@RequestMapping(value = "/hotels", method = RequestMethod.POST)
	public ModelAndView floors(@RequestParam("id") Long id)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		Hotel hotel = hotelService.findById(id).get();
		List<Floor> floors = floorService.getAllFloors(id);
		List<Wing> wings = new ArrayList<Wing>();
		for (Floor floor : floors)
		{
			List<Wing> floorWings = wingService.getAllWings(floor.getId());
			wings.addAll(floorWings);
		}
		
		modelAndView.addObject("hotel", hotel);
		modelAndView.addObject("floors", floors);
		modelAndView.addObject("wings", wings);
		modelAndView.setViewName("booking/floors");
		return modelAndView;
	}
	
	@RequestMapping(value = "/floors", method = RequestMethod.POST)
	public ModelAndView rooms(@RequestParam("id") Long id)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		Person person = personService.findByUserId(user.getId()); 
		
		Wing wing = wingService.findById(id).get();
		Floor floor = floorService.findById(wing.getFloor().getId()).get();
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.addAll(roomService.getAllRooms(wing.getId()));
		
		modelAndView.addObject("person", person);
		modelAndView.addObject("wing", wing);
		modelAndView.addObject("floor", floor);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("booking/rooms");
		return modelAndView;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ModelAndView book(@RequestParam("id") List<Long> roomIds)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		Person person = personService.findByUserId(user.getId()); 
		
		LocalDateTime from = LocalDateTime.now();
		LocalDateTime to = from.plusDays(7); 
		
		Currency currency = user.getCurrency();
		
		for (Long roomId : roomIds)
		{
			Room room = roomService.findByRoomId(roomId).get();
			BigDecimal amount =  room.getPrice();
			
			if (person.getBalance().compareTo(amount) >= 0)
			{
				Reservation reservation = new Reservation(amount, from, to, true, true, currency, room, person);
				reservationService.saveReservation(reservation);
				
				person.setBalance(person.getBalance().subtract(amount));
				personService.savePerson(person);
			}
		}
		
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

}

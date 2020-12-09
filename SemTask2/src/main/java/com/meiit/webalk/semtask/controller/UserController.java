package com.meiit.webalk.semtask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meiit.webalk.semtask.model.Person;
import com.meiit.webalk.semtask.model.Reservation;
import com.meiit.webalk.semtask.model.User;
import com.meiit.webalk.semtask.service.PersonService;
import com.meiit.webalk.semtask.service.ReservationService;
import com.meiit.webalk.semtask.service.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("users/login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("users/login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("users/registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult)
	{
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUserName(user.getUserName());

		if (userExists != null)
		{
			bindingResult.rejectValue("userName", "error.user",
					"There is already a user registered with the user name provided");
		}

		if (bindingResult.hasErrors())
		{
			modelAndView.setViewName("users/registration");
		}
		else
		{
			Person person = new Person(user.getFirstName(), user.getLastName(), user.getBirth(), user.getBalance(), user.getCurrency(), user);
			userService.saveUser(user);
			personService.savePerson(person);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("users/login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		Person person = personService.findByUserId(user.getId());
		
		List<Reservation> reservations = reservationService.getAllReservations(person.getId());

		modelAndView.addObject("reservations", reservations);
		modelAndView.addObject("person", person);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	public ModelAndView weldPoints(@ModelAttribute("person") Person person)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		person.setUser(user);;
		
		personService.savePerson(person);
		
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}

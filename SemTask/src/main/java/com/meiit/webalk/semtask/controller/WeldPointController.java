package com.meiit.webalk.semtask.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meiit.webalk.semtask.model.WeldPoint;
import com.meiit.webalk.semtask.service.WeldPointService;

@Controller
public class WeldPointController
{
	@Autowired
	private WeldPointService weldPointService;
	
	@RequestMapping(value = "/weldpoints", method = RequestMethod.GET)
	public ModelAndView weldPoints()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		List<WeldPoint> weldPoints = weldPointService.getAllWeldPoints();
		
		modelAndView.addObject("weldpoints", weldPoints);
		modelAndView.setViewName("weldpoints/weldpoints");
		return modelAndView;
	}
		
	@RequestMapping(value = "/addweldpoint", method = RequestMethod.GET)
	public ModelAndView addWeldPoint()
	{
		ModelAndView modelAndView = new ModelAndView();
		WeldPoint weldPoint = new WeldPoint();
		
		modelAndView.addObject("weldpoint", weldPoint);
		modelAndView.setViewName("weldpoints/addweldpoint");
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveweldpoint", method = RequestMethod.POST)
	public ModelAndView saveWeldPoint(@ModelAttribute("weldpoint") WeldPoint weldPoint)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		weldPointService.saveWeldPoint(weldPoint);

		modelAndView.setViewName("redirect:/weldpoints");
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteweldpoint", method = RequestMethod.GET)
	public ModelAndView deleteWeldPoint()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<WeldPoint> weldPoints = weldPointService.getAllWeldPoints();
		List<Long> ids = new ArrayList<Long>();
		
		modelAndView.addObject("ids", ids);
		modelAndView.addObject("weldpoints", weldPoints);
		modelAndView.setViewName("weldpoints/deleteweldpoint");
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteweldpoint", method = RequestMethod.POST)
	public ModelAndView deleteWeldPointById(@RequestParam("id") List<Long> ids)
	{
		ModelAndView modelAndView = new ModelAndView();

		for (Long id : ids)
		{
			weldPointService.deleteWeldPointById(id);
		}

		modelAndView.setViewName("redirect:/deleteweldpoint");
		return modelAndView;
	}
	
	@RequestMapping(value = "/weldpoints", method = RequestMethod.POST)
	public ModelAndView selectedWeldPointById(@RequestParam("id") Long id)
	{
		ModelAndView modelAndView = new ModelAndView();
		Optional<WeldPoint> selectedWeldPoint = weldPointService.findById(id);
		
		modelAndView.addObject("weldpoint", selectedWeldPoint.get());
		modelAndView.setViewName("weldpoints/selectedweldpoint");
		return modelAndView;
	}

}

package com.palhambra.prodentalserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.palhambra.prodentalserver.dto.WorkshiftDTO;
import com.palhambra.prodentalserver.service.WorkShiftService;

@RestController
@RequestMapping(value = "/api/workshift")
public class WorkShiftController {

	@Autowired
	private WorkShiftService workShiftService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public WorkshiftDTO create(@RequestBody WorkshiftDTO workshiftDTO) {
		return workShiftService.save(workshiftDTO);
	}

}

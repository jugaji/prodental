package com.palhambra.prodentalserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palhambra.prodentalserver.dto.WorkshiftDTO;
import com.palhambra.prodentalserver.model.Activity;
import com.palhambra.prodentalserver.model.Cabinet;
import com.palhambra.prodentalserver.model.Doctor;
import com.palhambra.prodentalserver.model.WorkShift;
import com.palhambra.prodentalserver.model.WorkShiftPK;
import com.palhambra.prodentalserver.repository.ActivityRepository;
import com.palhambra.prodentalserver.repository.CabinetRepository;
import com.palhambra.prodentalserver.repository.DoctorRepository;
import com.palhambra.prodentalserver.repository.WorkShiftRepository;

@Service("workShiftService")
public class WorkShiftServiceImpl implements WorkShiftService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WorkShiftRepository workShiftRepository;

	@Autowired
	private CabinetRepository cabinetRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public WorkshiftDTO save(WorkshiftDTO workshiftDTO) {
		WorkShift workShift = new WorkShift();
		Cabinet cabinet = cabinetRepository.findOne(workshiftDTO.getCabinetId());
		Activity activity = activityRepository.findOne(workshiftDTO.getActivityId());
		Doctor doctor = doctorRepository.findOne(workshiftDTO.getDoctorId());
		
		workShift.setCabinet(cabinet);
		workShift.setActivity(activity);
		workShift.setDoctor(doctor);
		
		WorkShiftPK workShiftPK = new WorkShiftPK();
		workShiftPK.setCabinetId(workshiftDTO.getCabinetId());
		workShiftPK.setDate(workshiftDTO.getDate());
		workShiftPK.setMorning(workshiftDTO.getMorning());
		workShift.setWorkShiftPK(workShiftPK);

		WorkShift result = workShiftRepository.save(workShift);

		if (result == null) {
			logger.error("Error to create workshift cabinetId:: " + workshiftDTO.getCabinetId() + "; date: "
					+ workshiftDTO.getDate());
		}

		return workshiftDTO;
	}
}

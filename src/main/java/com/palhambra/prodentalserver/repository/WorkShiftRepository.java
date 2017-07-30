package com.palhambra.prodentalserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.WorkShift;
import com.palhambra.prodentalserver.model.WorkShiftPK;

public interface WorkShiftRepository extends CrudRepository<WorkShift, WorkShiftPK> {

}

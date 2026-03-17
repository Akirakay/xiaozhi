package com.akirakay.xiaozhi.service;

import com.akirakay.xiaozhi.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
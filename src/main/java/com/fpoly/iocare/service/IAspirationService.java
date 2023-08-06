package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.Aspiration;

public interface IAspirationService {
	/*--Hiển thị tất cả nguyện vọng--*/
	List<Aspiration> findAll();
}
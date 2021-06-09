package com.jpo.kd.biblioteka.dao;

import org.springframework.web.bind.annotation.RequestParam;

public interface WorkerDao {
	public boolean saveBorrow(int bookId,
			int ui,
			String date);
}

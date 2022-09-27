package site.metacoding.red.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.stadium.Stadium;
import site.metacoding.red.domain.stadium.StadiumDao;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumDao stadiumDao;

	public List<Stadium> 목록보기() {
		return stadiumDao.findAll();
	}

}

package site.metacoding.red.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.stadium.Stadium;
import site.metacoding.red.domain.stadium.StadiumDao;
import site.metacoding.red.web.dto.stadium.StardiumInsertReqDto;

@RequiredArgsConstructor
@Service
public class StadiumService {
	//DI
	private final StadiumDao stadiumDao;

		public void 경기장삭제(Integer id) {
			stadiumDao.deleteById(id);
		}
	
	public List<Stadium> 목록보기() {
		return stadiumDao.findAll();
	}
	
	//controller는 Dto 로 받고 Dao는 Entity로 넘기자(Insert/Update)
	public void 경기장등록(StardiumInsertReqDto stardiumInsertReqDto) {
		stadiumDao.insert(stardiumInsertReqDto.toEntity());
	}
}

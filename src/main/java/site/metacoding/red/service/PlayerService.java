package site.metacoding.red.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.player.Player;
import site.metacoding.red.domain.player.PlayerDao;
import site.metacoding.red.domain.team.Team;
import site.metacoding.red.domain.team.TeamDao;
import site.metacoding.red.web.dto.player.PlayerInsertReqDto;
import site.metacoding.red.web.dto.player.PlayerPositionRespDto;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerDao playerDao;
	private final TeamDao teamDao;

	public PlayerPositionRespDto 포지션별팀찾기() {
		PlayerPositionRespDto playerPositionRespDto = new PlayerPositionRespDto();
		List<Team> teamList = teamDao.findAll();

		makeColList(playerPositionRespDto, teamList);
		makeRowList(playerPositionRespDto, teamList);

		return playerPositionRespDto;
	}
	
	public void 선수삭제(Integer id) {
		playerDao.deleteById(id);
	}

	public List<Player> 목록보기() {
		return playerDao.findAll();
	}

	public void 선수등록(PlayerInsertReqDto playerInsertReqDto) {
		playerDao.insert(playerInsertReqDto.toEntity());
	}

	private void makeColList(PlayerPositionRespDto playerPositionRespDto, List<Team> teamList) {

		List<String> colList = new ArrayList<>();
		colList.add("포지션");
		for (Team team : teamList) {
			colList.add(team.getName());
		}
		playerPositionRespDto.setColList(colList);
	}
	//null값이 있으면 들어오다가 터져서 서버가 안돌아 간다. null이 있으면 미리 삭제하기
	private void makeRowList(PlayerPositionRespDto playerPositionRespDto, List<Team> teamList) {
		List<Map<String, Object>> positionList = playerDao.findPositionByTeam(teamList);
		List<List<String>> rowList = new ArrayList<>();

		for (int i = 0; i < positionList.size(); i++) {
			List<String> row = new ArrayList<>();
			System.out.println(positionList.get(i).get("position").toString());
			//java.lang.NullPointerException이라는  에러 발생시에 넣어줄것
			positionList.get(i).get("position").toString();
			row.add(positionList.get(i).get("position").toString());
			for (Team team : teamList) {
				row.add(positionList.get(i).get(team.getName()).toString());
			}
			rowList.add(row);
		}

		playerPositionRespDto.setRowList(rowList);
	}

}

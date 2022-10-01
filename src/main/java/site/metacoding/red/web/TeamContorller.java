package site.metacoding.red.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.stadium.Stadium;
import site.metacoding.red.domain.team.Team;
import site.metacoding.red.service.StadiumService;
import site.metacoding.red.service.TeamService;
import site.metacoding.red.web.dto.CMRespDto;
import site.metacoding.red.web.dto.team.TeamInsertReqDto;

@RequiredArgsConstructor
@Controller
public class TeamContorller {

	private final TeamService teamService;
	private final StadiumService stadiumService;

	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id) {
		teamService.팀삭제(id);
		return new CMRespDto<>(1, "팀삭제성공", null);
	}


	@GetMapping("/team")
	public String list(Model model) {
		List<Team> teamList = teamService.목록보기();
		model.addAttribute("teamList", teamList);
		return "team/list";
	}

	@GetMapping("/teamForm")
	public String teamForm(Model model) {
		List<Stadium> stadiumList = stadiumService.목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "team/saveForm";
	}

	@PostMapping("/team")
	public @ResponseBody CMRespDto<?> insert(@RequestBody TeamInsertReqDto teamInsertReqDto) {
		teamService.팀등록(teamInsertReqDto);// Dto를 그대로 넘긴다
		return new CMRespDto<>(1, "팀등록성공", null);
	}

}

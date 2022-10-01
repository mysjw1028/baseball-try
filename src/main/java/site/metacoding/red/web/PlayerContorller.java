package site.metacoding.red.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.player.Player;
import site.metacoding.red.domain.stadium.Stadium;
import site.metacoding.red.domain.team.Team;
import site.metacoding.red.service.PlayerService;
import site.metacoding.red.service.StadiumService;
import site.metacoding.red.service.TeamService;
import site.metacoding.red.web.dto.CMRespDto;
import site.metacoding.red.web.dto.team.TeamInsertReqDto;

@RequiredArgsConstructor
@Controller
public class PlayerContorller {

	private final PlayerService playerService;

	@GetMapping("/player")
	public String list(Model model) {
		List<Player> playerList = playerService.목록보기();
		model.addAttribute("playerList",playerList);
		return "player/list";
	}

	@GetMapping("/playerForm")
	public String playerForm(Model model) {
		return "player/saveForm";
	}

	@PostMapping("/player")
	public @ResponseBody CMRespDto<?> insert() {
		return new CMRespDto<>(1, "선수등록성공", null);
	}

}

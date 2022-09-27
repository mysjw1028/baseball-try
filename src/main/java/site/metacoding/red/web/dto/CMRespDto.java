package site.metacoding.red.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor//넣어둬야 나중에 편함
@Setter
@Getter
public class CMRespDto <T>{
	private Integer code;
	private String msg;
	private T data;
}

package site.metacoding.red.domain.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Stadium {
	private Integer id;
	private String name;
	private Timestamp createdAt;

	private Integer no;// db에 없는 값 뿌릴려고 만든 값

}

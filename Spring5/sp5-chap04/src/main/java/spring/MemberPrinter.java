package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	// 필드 방법 1 : @Autowired(required = false)
//	@Autowired(required = false)
//	private DateTimeFormatter dateTimeFormatter;
	
	// 필드 방법 2 : @Nullable
//	@Autowired
//	@Nullable
//	private DateTimeFormatter dateTimeFormatter;
	
	// 필드 방법 3 : Optional
//	@Autowired
//	private Optional<DateTimeFormatter> formatterOpt;
	private DateTimeFormatter dateTimeFormatter;
	
	
	public MemberPrinter() {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	public void print(Member member) {
//		DateTimeFormatter dateTimeFormatter = formatterOpt.orElse(null);
		if(dateTimeFormatter == null) {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
					);
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime())
					);
		}
	}
	
	// 설정자 방법 1: required가 false가 아니면 dateTimeFormatter가 null값이면 오류가 발생한다
	// 빈이 존재하지 않으면 메서드가 호출되지 않는다.
//	@Autowired(required = false)
//	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
	
	// 설정자 방법 2: Optional 사용
	// 자동 주입 대상 타입이 Optional일 경우, 일치하는 빈이 존재하지 않으면 값이 없는 Optional을
	// 인자로 전달하고 일치하는 빈이 존재하면 해당 빈을 값으로 갖는 Optional을 인자로 전달한다.
//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if(formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
	// 설정자 방법 3: @Nullable 붙이면 자동 주입할 빈이 존재하지 않으면 인자로 null을 전달한다.
	// 자동 주입할 빈이 없어도 메서드가 호출된다.
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

}

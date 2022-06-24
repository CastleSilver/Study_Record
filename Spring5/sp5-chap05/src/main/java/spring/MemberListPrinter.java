package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("listPrinter")
public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter() {
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//방법 1 : @Qualifier 이용
	@Autowired
	@Qualifier("summaryPrinter")
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	//방법 2 : 타입 변경
//	@Autowired
//	public void setMemberPrinter(MemberSummaryPrinter printer) {
//		this.printer = printer;
//	}
	
}

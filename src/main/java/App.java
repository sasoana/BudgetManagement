import controller.EntryController;
import repository.EntryRepository;
import repository.MemberRepository;
import controller.MemberController;
import ui.UI;

public class App {
	public static void main(String[] args) {
		
		MemberRepository memberRepository = new MemberRepository("membersF.txt");
		EntryRepository entryRepository = new EntryRepository("budgetF.txt");

		MemberController memberController = new MemberController(memberRepository);
		EntryController entryController = new EntryController(entryRepository, memberRepository);
		
		UI console = new UI(memberController, entryController);
		console.Run();
		
	}
}

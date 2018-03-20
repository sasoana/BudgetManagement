import controller.EntryController;
import repository.EntryRepository;
import repository.MemberRepository;
import controller.MemberController;
import ui.UI;;

public class App {
	public static void main(String[] args) {
		
		MemberRepository memberRepository = new MemberRepository();
		EntryRepository entryRepository = new EntryRepository();

		MemberController memberController = new MemberController(memberRepository);
		EntryController entryController = new EntryController(entryRepository);
		
		UI console = new UI(memberController, entryController);
		console.Run();
		
	}
}

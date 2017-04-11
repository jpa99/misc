import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SecuritySystem {

	private static List<HashMap<String, Date>> log=new ArrayList<HashMap<String, Date>>();
	public static void main(String[] args) throws ParseException {
		Scanner scan=new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH;mm:SS");
		int choice=0;
		while(choice!=5){
			String user, s, e;
			Date start, end;
			menu();
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice){
			case 1:
				System.out.println("\nEnter a User ID");
				user=scan.nextLine();
				access(user);
				break;
			case 2:
				latest();
				break;
			case 3:
				System.out.println("\nEnter start date [dd-MM-yyyy HH;mm:SS]: ");
				s=scan.nextLine();
				start = formatter.parse(s);
				System.out.println("Enter end date [dd-MM-yyyy HH;mm:SS]: ");
				e=scan.nextLine();
				end = formatter.parse(s);
				rangeList(start, end);
				break;
			case 4:
				list();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("\nPlease enter a valid entry");
				break;
			}
			
			
		}

	}
	public static void menu(){
		System.out.println("\n1. Access System\n"+"2. View Latest Access\n"+"3. Search for Access at Specific Time\n"+"4. Display Log\n"+"5. Exit");
	}
	
	public static void access(String user){
		HashMap<String, Date> h=new HashMap<String, Date>();
		h.put(user, new Date());
		log.add(h);
	}
	
	public static void latest(){
		String[] last=new String[2];
		HashMap<String, Date> h=new HashMap<String, Date>();
		h=log.get(log.size()-1);
		String s=(String) h.keySet().toArray()[0];
		last[0]=s;
		System.out.println("\n"+h.get(s)+": "+s);
	}
	
	public static void rangeList(Date start, Date end){
		System.out.println();
		for(HashMap<String, Date> h:log){
			String s=(String) h.keySet().toArray()[0];
			if(isWithinRange(h.get(s), start, end)){
				System.out.println("\n"+h.get(s)+": "+s);
			}
		}
	}
	
	public static boolean isWithinRange(Date test, Date start, Date end) {
		  return (test.after(start) || test.equals(start)) && (test.before(end) || test.equals(end));
	}
	
	public static void list(){
		System.out.println();
		for(HashMap<String, Date> h:log){
			String s=(String) h.keySet().toArray()[0];
			System.out.println(h.get(s)+": "+s);
		}
	}

}

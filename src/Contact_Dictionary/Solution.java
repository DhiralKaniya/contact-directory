package Contact_Dictionary;
import java.util.*;
public class Solution {
	public static void main(String[] args){
		Contact_Dictionary contact = new Contact_Dictionary();
		Scanner scan = new Scanner(System.in);
		int a = 1 ;
		while(a != 0)
		{
			System.out.println("1 -> Insert Contact \n2 -> Update Contact\n3 -> Delete Contact\n4 -> Display Contact\n5 -> Search contact\n6 -> Filter\n0 -> exit\n");
			a = scan.nextInt();
			switch(a){
				case 1 :
					contact.insertData();
					break;
				case 2:
					System.out.print("Enter Name :-");
					String name  = new String();
					scan.nextLine();
					name = scan.nextLine();
					contact.updateData(name);
					break;
				case 3:
					contact.deleteData();
					break;
				case 4:
					contact.printData();
					break;
				case 5:
					contact.searchData();
					break;			
				case 6:
					contact.filter();
					break;
				case 0:
					contact.exportData();
					System.out.println("********** Thank you so much *********"); 
				break;
			}
		}
		scan.close();
	}
}	

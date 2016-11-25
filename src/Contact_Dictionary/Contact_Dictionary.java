package Contact_Dictionary;

import java.io.*;  
import java.util.*;
import java.util.regex.Pattern;

public class Contact_Dictionary {
	//HashMap contact
	TreeMap<String,Contact> contact;
	//Br is use to fetch data from the file
	BufferedReader br;
	Scanner scan;
	
	//initialize value from the file
	Contact_Dictionary(){
		contact = new TreeMap<String,Contact>();
		//System.out.println("call");
		try{
			br = new BufferedReader( new FileReader("contact_Main.csv"));
			System.out.println("***- File Opened Successfully -***");
			String str = new String();
			while((str = br.readLine().toString()) != null ){
				String[] data = str.split("-");
				Contact obj = new Contact();
					obj.setGroup(data[1]);
					obj.setAddress(data[2]);
					obj.setMobile(data[3]);
					obj.setEmail(data[4]);
				contact.put(data[0], obj);			
			}
			br.close();
		}catch(Exception e){ 
			return ;  
		}
	}
	//Done
	public void printData(){
		//Read Data from the TreeMap and Print to the user......
		for(Map.Entry<String,Contact> a : contact.entrySet()){
		    System.out.println(a.getKey() + " || " +  a.getValue().getGroup() + " || " + a.getValue().getAddress()+ " || " + a.getValue().getMobile()  +" || "+a.getValue().getEmail() );
		}
	}
	public void filter(){//Trie Functionality is used for the searching by the name prefix...
		Trie objc = new Trie();
		for(String  key : contact.keySet()){
			objc.addWord(key);
		}
		System.out.print("Enter prefix :- ");
		scan = new Scanner(System.in); 
		String preFix = scan.nextLine(); 
		//System.out.println(contact.get(preFix));
		List<String> display = objc.search(preFix);
		System.out.println(display.size());
		if(display!= null){
			for(String str : display){
				Contact a = contact.get(str);
				  System.out.println(str + " || " +  a.getGroup() + " || " + a.getAddress()+ " || " + a.getMobile()  +" || "+a.getEmail() );
			}
		}
	}
	public TreeMap<String,Contact> fetchData(){
		BufferedReader br;
		TreeMap<String,Contact> newcontact = new TreeMap<String,Contact>();
		try{
			br = new BufferedReader( new FileReader("contact_Main.csv"));
			System.out.println("Open Successfully");
			String str = new String();
			while((str = br.readLine().toString()) != null ){
				String[] data = str.split("-");
				Contact obj = new Contact();
				obj.setGroup(data[1]);
				obj.setAddress(data[2]);
				obj.setMobile(data[3]);
				obj.setEmail(data[4]); 
				newcontact.put(data[0], obj);	
			}
			br.close();
		}catch(Exception e){ return newcontact ;  }
		return newcontact;
	}
	public void searchData(){//created by Dhiral with AVLNode
		AVLTree obj = new AVLTree();
		scan = new Scanner(System.in);
		for(Map.Entry<String,Contact> a : contact.entrySet()){
			obj.insert(a.getKey(),a.getValue());
		}
		int n = 1;
		while(n != 0){
			System.out.println("1 -> Find By Name\n2 -> Find By Address\n3 -> Find By Contact No\n4 -> Find By Email\n5 -> Find By Group\n6 -> Find By Number\n0 -> Exit ");
			n = scan.nextInt();
			scan.nextLine();
			switch(n){
				case 1:
					System.out.println("Enter Name :- ");
					String name = scan.nextLine();
					obj.findByName(name);
					break;
				case 2 :
					System.out.println("Enter Address :- ");
					String Address = scan.nextLine();
					obj.findByAddress(Address);
					break;
				case 3 :
					System.out.println("Enter Contact Number :- ");
					String Mobile = scan.nextLine();
					obj.findByMobile(Mobile);
					break;
				case 4 :
					System.out.println("Enter EmailId :- ");
					String emailId = scan.nextLine();
					obj.findByEmail(emailId);
					break;
				case 5:
					System.out.println("Enter Group :- ");
					String Group = scan.nextLine();
					obj.findByGroup(Group);
					break;
				case 6:
			//		System.out.println("Enter Number  :- ");
					this.searchViaNumber();
					break;
			}
		}
	}
	//Delete Key Done
	public void deleteData(){//Created by Sneha with the use of treeMap 
		scan = new Scanner(System.in);
		System.out.print("Enter Name which you want to Delete :-");
		String str = scan.nextLine();
		contact.remove(str);
		System.out.println("Your record has been deleted");
	}
	//Insert DOne
	public void insertData(){//created by Stuti with LinkedList
		scan = new Scanner(System.in);
		LinkedList obj = new LinkedList();
		System.out.print("Enter Name = ");		
		String name = scan.nextLine();
		boolean flag =true;
		for(Map.Entry<String,Contact> a : contact.entrySet()){
			if(a.getKey().compareTo(name) == 0){
				flag = false;
				break;
			}
			obj.insertAtLast(a.getKey(),a.getValue());
		}					
		if(flag == true){
				System.out.print("Enter Contact No = ");
				String mobile = scan.nextLine();
				System.out.print("Enter Address = ");		
				String add = scan.nextLine();
				if(add.compareTo(" ") == 0)
					add = "NA";
				System.out.print("Enter Email = ");	
				String email = scan.nextLine();
				if(email.compareTo(" ") == 0)
					email = "NA";
				System.out.print("Enter Group = ");
				String group = scan.nextLine();
				if(group.compareTo(" ") == 0)
					email = "NA";
				Contact newContact = new Contact();
				newContact.setAddress(add) ;
				newContact.setEmail(email);
				newContact.setGroup(group);
				newContact.setMobile(mobile);
				obj.insetAtMiddle(name,newContact);
				contact = obj.updatedData();
		}
		else{
			System.out.println(name + " is already Exist");
		}
	}
	public void exportData(){
		BufferedWriter bw;
		try{
			bw = new BufferedWriter(new FileWriter("contact_Main.csv"));
			for(Map.Entry<String,Contact> ob : contact.entrySet()){
				String str = new String();
				str = ob.getKey() + "-" + ob.getValue().getGroup() + "-" + ob.getValue().getAddress() + "-" + ob.getValue().getMobile() + "-"+ob.getValue().getEmail();				
				bw.write(str);
				bw.newLine();
			}
		}catch(Exception e){
			return ;
		}
		try{
			bw.close();
		}catch(Exception e){return ;}
	}
	public void searchViaNumber(){
			TreeMap<String, String> hash = new TreeMap<String, String>();
		
			hash.put("2", "(a|b|c|A|B|C)");
			hash.put("3", "(d|e|f|D|E|F)");
			hash.put("4", "(h|g|i|H|G|I)");
			hash.put("5", "(j|k|l|J|K|L)");
			hash.put("6", "(m|n|o|M|N|O)");
			hash.put("7", "(p|q|r|s|P|Q|R|S)");
			hash.put("8", "(t|u|v|T|U|V)");
			hash.put("9", "(w|x|y|z|W|X|Y|Z)");	
			System.out.print("Enter your Prefix Number :- ");
			Scanner in = new Scanner(System.in);
			String str = in.next();
			String regex ="^";
			for(char c : str.toCharArray() )
			{
				regex = regex + hash.get(c+"");
				
			}
			String []strarry = new String[contact.size()];
			int i = 0;
			for(Map.Entry<String,Contact> a : contact.entrySet()){
				strarry[i++] = a.getKey(); 
			}
			regex =regex +  ".*$";
			Pattern pattern = Pattern.compile(regex);	
			for(String str1 : strarry)
			{
				if(str1.matches(regex))
				{
					Contact obj = contact.get(str1);
					System.out.println(str1 + " || " +  obj.getGroup() + " || " + obj.getAddress()+ " || " + obj.getMobile()  +" || "+obj.getEmail() );
				}
			}
	}
	//Done
	public void updateData(String name){//Created by Mansi Shah with TreeMap
		scan = new Scanner(System.in);
		Contact updatecontact = contact.get(name);
		if(updatecontact == null){
			System.out.println("Contact does not exist");
		}
		else {
			int n = 0 ;
			do{
				System.out.println("Details of " + name);
				System.out.println("Address ->" + updatecontact.getAddress() + "(Press 1 to update)");
				System.out.println("Email ->" + updatecontact.getEmail() + "(Press 2 to update)");
				System.out.println("Group ->" + updatecontact.getGroup() + "(Press 3 to update)");
				System.out.println("Contact No ->" + updatecontact.getMobile() + "(Press 4 to update)");
				System.out.println("Name ->" + name + "(Press 5 to update)");
				int a = scan.nextInt();
				switch (a){
					case 1 ://Implementation of Address Update
						System.out.print("Enter New Address :- ");
						scan.nextLine();
						String address = scan.nextLine();
						updatecontact.setAddress(address);
						System.out.println("Your Address has been updated ");
						break;
					case 2 ://Implementation of Email
						System.out.print("Enter New Email Address :- ");
						scan.nextLine();
						String email = scan.nextLine();
						updatecontact.setEmail(email);
						System.out.println("Your Email Address has been updated ");
						break;
					case 3 ://Implementation of Group
						System.out.print("Enter New Group :- ");
						scan.nextLine();
						String grp = scan.nextLine();
						updatecontact.setGroup(grp);
						System.out.println("Your Group has been updated ");
						break;
					case 4 ://Implementation of Contact Number
						System.out.print("Enter New Number :- ");
						scan.nextLine();
						String num = scan.nextLine();
						updatecontact.setMobile(num);
						System.out.println("Your Number has been updated ");
						break;
					case 5 :
						System.out.println("Enter New Name :- ");
						scan.nextLine();
						String newName = scan.nextLine();
						contact.remove(name);
						contact.put(newName, updatecontact);
						System.out.println("Your Name has been updated ");
						name = newName;
						updatecontact = contact.get(name);
						break;
					default :
						System.out.println("Wrong input try again thanks");
						break;
				}
				if(n != 1)
				{ 	System.out.println("Do You want to continue , 0 -> YES , 1 -> NO");
					n = scan.nextInt();
					contact.put(name, updatecontact);
				}
			}while(n == 0);
		}
	}
}

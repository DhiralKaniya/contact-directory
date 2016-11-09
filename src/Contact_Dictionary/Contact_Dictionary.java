package Contact_Dictionary;

import java.io.*;
import java.util.*;

public class Contact_Dictionary {
	//HashMap contact
	TreeMap<String,Contact> contact;
	//Br is use to fetch data from the file
	BufferedReader br;
	Contact_Dictionary(){
		contact = new TreeMap<String,Contact>();
		try{
			br = new BufferedReader( new FileReader("contact_Main.csv"));
			System.out.println("Open Successfully");
			String str = new String();
			while((str = br.readLine().toString()) != null ){
				//Read data from the file and store in cotnact TreeMap;
				String[] data = str.split(",");
				Contact obj = new Contact();
				obj.Group = data[1];
				obj.Address = data[2];
				obj.Mobile = data[3];
				obj.Email = data[4];
				contact.put(data[0], obj);	
			}
		}catch(Exception e){ return ;  }
	}
	public void printData(){
		//Read Data from the TreeMap and Print to the user......
		for(Map.Entry<String,Contact> a : contact.entrySet()){
		    System.out.println(a.getKey()+" : "+a.getValue().Email + ":" + a.getValue().Address + a.getValue().Mobile);
		}
	}
	public void searchData(){
		AVLTree obj = new AVLTree();
		for(Map.Entry<String,Contact> a : contact.entrySet()){
			obj.insert(a.getKey(),a.getValue());
		}
		obj.printAVLTree();
	}
}

package Contact_Dictionary;
public class AVLTree {
	private AVLNode root;
	AVLTree(){
		root = null;
	}
	public boolean isEmpty(){
		return this.root == null ? true : false;
	}
	public void makeEmpty(){
		this.root = null;
	}
	
	public void insert(String name , Contact contact){
		root = insert(name,contact,root);
	}
	public AVLNode insert(String name,Contact contact,AVLNode node){
		if(node == null){
			node = new AVLNode(name,contact);
		}else if(name.compareTo(node.getName()) < 0){
			node.left = insert(name,contact,node.left);
			if(this.getHeight(node.left) - this.getHeight(node.right) > 1){
				if(name.compareTo(node.right.name) < 0)
					node = this.rotateLeft(node);
				else{
					node = this.doublerotateLeft(node);
				}
			}
		}else if(name.compareTo(node.getName()) > 0){
			node.right = insert(name,contact,node.right);
			if(this.getHeight(node.right) - this.getHeight(node.left) == 2 ){
				if(name.compareTo(node.left.name) > 0 ){
					node = this.rotateLeft(node);
				}else{
					node = this.doublerotateRight(node);
				}
			}
		}
		return node;
	}
	public AVLNode doublerotateLeft(AVLNode A1){
		A1.left = this.rotateRight(A1.left);
		return this.rotateLeft(A1);
	}
	public AVLNode doublerotateRight(AVLNode A1){
		A1.right = this.rotateLeft(A1.right);
		return this.rotateRight(A1);
	}
	public AVLNode rotateRight(AVLNode A1){
		AVLNode A2 = A1.right;
		A1.right = A2.left;
		A2.left = A1;
		A1.setHeight(this.getMax(this.getHeight(A1.right),this.getHeight(A1.left)) + 1);
		A2.setHeight(this.getMax(this.getHeight(A2.right),this.getHeight(A2.left)) + 1);
		return A2;
	}
	public AVLNode rotateLeft(AVLNode A1){
		AVLNode A2 = A1.left;
		A1.left = A2.right;
		A2.right = A1;
		A1.setHeight(this.getMax(this.getHeight(A1.right),this.getHeight(A1.left)) + 1);
		A2.setHeight(this.getMax(this.getHeight(A2.right), this.getHeight(A2.left)) + 1);
		return A2;
	}
	public int getHeight(AVLNode n){
		return n == null ? -1 : n.getHeight();
	}
	public int getMax(int right,int left){
		return right > left ? right : left ;
	}
	
	/* find by Name */
	public void findByName(String name){
		AVLNode temp = root;
		temp = this.findByName(name, temp);
	}
	public AVLNode findByName(String name,AVLNode node){
		if(node != null){
			this.findByName(name, node.left);
			if(name.compareTo(node.getName()) == 0){
				//System.out.println("Name || Addres || ContactNo || Email || Group");
				printAll(node.getName(),node.getContact());
				//return node;
			}
			this.findByName(name, node.right);
		}
		return node;
	}
	/* Find by Address */ 
	public void findByAddress(String Add){
		AVLNode temp = root;
		temp = this.findByAddress(Add, temp);
	}
	public AVLNode findByAddress(String Add,AVLNode node){
		if(node != null){
			this.findByAddress(Add, node.left);
			
			if(Add.compareTo(node.getContact().getAddress()) == 0){
				printAll(node.getName(),node.getContact());
			}
			this.findByAddress(Add, node.right);
		}
		return node;
	}
	/* Find by Mobile */ 
	public void findByMobile(String contact){
		AVLNode temp = root;
		temp = this.findByMobile(contact, temp);
	}
	private AVLNode findByMobile(String contact,AVLNode node){
		if(contact.compareTo(node.getName()) == 0){
			printAll(node.getName(),node.getContact());
			return node;
		}
		else if(contact.compareTo(node.getName()) < 0){
			node = findByMobile(contact,node.left);
		}
		else if(contact.compareTo(node.getName()) > 0){
			node = findByMobile(contact,node.right);
		}
		return node;
	}
	/*private AVLNode findByMobile(String contact,AVLNode node){
		if(node != null){
			this.findByMobile(contact, node.left);
			//System.out.println("Name || Addres || ContactNo || Email || Group");
			if(contact.compareTo(node.getContact().getMobile()) == 0){
				printAll(node.getName(),node.getContact());
				return node;
			}
			this.findByMobile(contact, node.right);
		}
		return node;
	}
	/* Find by Email */ 
	public void findByEmail(String email){
		AVLNode temp = root;
		temp = this.findByEmail(email, temp);
	}
	private AVLNode findByEmail(String email,AVLNode node){
		if(node != null){
			this.findByEmail(email, node.left);
			//System.out.println("Name || Addres || ContactNo || Email || Group");
			if(email.compareTo(node.getContact().getEmail()) == 0){
				printAll(node.getName(),node.getContact());
				//return node;
			}
			this.findByEmail(email, node.right);
		}
		return node;
	}
	/* Find by Group */ 
	public void findByGroup(String group){
		AVLNode temp = root;
		temp = this.findByGroup(group, temp);
	}
	private AVLNode findByGroup(String Group,AVLNode node){
		if(node != null){
			this.findByGroup(Group, node.left);
			//System.out.println("Name || Addres || ContactNo || Email || Group");
			if(Group.compareTo(node.getContact().getGroup()) == 0){
				printAll(node.getName(),node.getContact());
				//return node;
			}
			this.findByGroup(Group, node.right);
		}
		return node;
	}
	//Printing Data
	public void printAll(String name,Contact contact){
		System.out.println(name + " || " + contact.getAddress() + " || " + contact.getMobile() + " || " + contact.getEmail() + " || " + contact.getGroup());
	}
	public void printAVLTree(){
		AVLNode temp = root;
		temp = this.print(temp);
	}
	public AVLNode print(AVLNode node){
		if(node != null){
			this.print(node.left);
			System.out.println(node.getName());
			this.print(node.right);
		}
		return node;
	}
}

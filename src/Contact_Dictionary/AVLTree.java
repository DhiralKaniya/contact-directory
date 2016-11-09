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
			if(this.getHeight(node	.left) - this.getHeight(node.right) > 1){
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
					node = this.doublerotateLeft(node);
				}
			}
		}
		return node;
	}
	public AVLNode doublerotateLeft(AVLNode A1){
		A1.left = this.rotateLeft(A1.left);
		return this.rotateLeft(A1.left);
	}
	public AVLNode doublerotateRight(AVLNode A1){
		A1.right = this.rotateRight(A1.right);
		return this.rotateRight(A1.right);
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

package Contact_Dictionary;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

public class TrieNode {
	
	private char character;
	private List<TrieNode> childs;
	 boolean isEnd; 
	
	public TrieNode(char charecter) {
		this.character = charecter;
		
		this.childs = new LinkedList<TrieNode>();
	
	}
	
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public List<TrieNode> getChilds() {
		return childs;
	}
	public void setChilds(List<TrieNode> childs) {
		this.childs = childs;
	}
  
}

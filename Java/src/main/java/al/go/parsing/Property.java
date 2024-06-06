package al.go.parsing;

import java.util.List;

public class Property {
	private final String name;
	public String value;
	private List<Property> children;
	
	public Property(String name, String value, List<Property> children) {
		this.name = name;
		this.value = value;
		this.children = children;
	}
	
	public Property(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Property> getChildren() {
		return children;
	}
	
	public void setChildren(List<Property> children) {
		this.children = children;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public static void lol(){
	
	}
	
	@Override
	public String toString() {
		return "\n{" +
					   "\n\tname='" + name + '\'' +
					   ", \n\tvalue='" + value + '\'' +
					   ", \n\tchildren=" + children +
					   "\n}";
	}
}

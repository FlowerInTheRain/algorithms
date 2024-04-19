package al.go.parsing;

import java.util.List;

public class Property {
	private final String name;
	private List<Property> children;
	
	public Property(String name, List<Property> children) {
		this.name = name;
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
	
	
	@Override
	public String toString() {
		return "{" +
					   "name:'" + name + '\'' +
					   ", children=" + children +
					   '}';
	}
}

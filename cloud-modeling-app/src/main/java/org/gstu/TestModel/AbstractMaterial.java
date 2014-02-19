package org.gstu.TestModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbstractMaterial implements IMaterial {

	private String name;
	
	public AbstractMaterial(String name) {
		setName(name);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}

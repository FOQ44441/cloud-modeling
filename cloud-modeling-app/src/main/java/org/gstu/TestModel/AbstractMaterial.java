package org.gstu.TestModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbstractMaterial implements IMaterial {

    private static int currentId = 0;
    private static int getNextId() {
      int id = currentId++;
      return id;
    }
    
    
	private String name;
	private int id;
	
	public AbstractMaterial(String name) {
		setName(name);
		setId(AbstractMaterial.getNextId());
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }
}

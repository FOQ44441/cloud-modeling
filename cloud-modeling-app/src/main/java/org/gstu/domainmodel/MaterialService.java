package org.gstu.domainmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.gstu.TestModel.AbstractMaterial;
import org.gstu.TestModel.IMaterial;

public class MaterialService implements IRepository<IMaterial> {
  
  HashMap<Integer, IMaterial> materials;
  public MaterialService() {
    //TODO: создание статических значений, будет заменено на получение данных
    materials = new HashMap<>();
    IMaterial tmp = new AbstractMaterial("Сталь");
    materials.put(tmp.getId(),tmp);
    tmp = new AbstractMaterial("Свинец");
    materials.put(tmp.getId(),tmp);
    tmp = new AbstractMaterial("Медь");
    materials.put(tmp.getId(),tmp);
    tmp = new AbstractMaterial("Алюминий");
    materials.put(tmp.getId(),tmp);
  }

  @Override
  public List<IMaterial> getAll() {
    
      List<IMaterial> listMat = new ArrayList<>(materials.values());
    
      return listMat;
  }

  @Override
  public IMaterial get(int id) throws Exception {
    throw new Exception("Not emplementation");
  }

  @Override
  public IMaterial create(IMaterial obj) throws Exception {
    throw new Exception("Not emplementation");
  }

  @Override
  public void delete(IMaterial obj) throws Exception {
    throw new Exception("Not emplementation");
  }

  @Override
  public void update(IMaterial obj) throws Exception {
    throw new Exception("Not emplementation");
  }
  
  
}

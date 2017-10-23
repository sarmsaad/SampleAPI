package digitalreserve;

import java.util.ArrayList;
import java.util.List;

public class Subject{

  private String id;
  private List<String> list = new ArrayList<String>();


  public Subject(String id){
    this.id = id;
  }

  public String getId(){
    return this.id;
  }

  public List<String> getList(){
    return list;
  }

  public void addItem(String item){
    if(!list.contains(item)){
      list.add(item);
    }
  }

  public void removeItem(String item){
    list.remove(item);
  }

}

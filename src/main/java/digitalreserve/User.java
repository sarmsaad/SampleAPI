package digitalreserve;

public class User{

  String type;
  String id;
  Subjects subjectList;

  public User(String id, String type){
    this.id = id;
    this.type = type;
    this.subjectList = new Subjects();
  }

  public Subjects getSubjectList(){
    return subjectList;
  }

  public String getId(){
    return id;
  }

  public String getType(){
    return type;
  }

  public Subject addItem(String subject, String item){
    return this.subjectList.addItem(subject, item);
  }

  public Subject addSubject(String subject){
    return this.subjectList.addSubject(subject);
  }

  public Subject deleteItem(String subject, String item){
    return this.subjectList.deleteItem(subject, item);
  }

  public void deleteSubject(String subject){
    this.subjectList.deleteSubject(subject);
  }

}

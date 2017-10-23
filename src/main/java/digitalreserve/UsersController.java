package digitalreserve;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController{

  //a constant since you can't add users in the system
  User user1 = new User("me","student");
  User user2 = new User("you", "student");
  User user3 = new User("other", "teacher");
  List<User> users;

  public UsersController(){
    users = new ArrayList<User>();
    users.add(user1);
    users.add(user2);
    users.add(user3);
  }

  public int getPosition(String id){
    int length = users.size();
    if(length == 0){
      return -1;
    }else{
      for (int i = 0; i < length; i++) {
        if (users.get(i).getId().equals(id)) {
          return i;
        }
      }
      return -1;
    }
  }

  //returns the new made subject or just returns the corresponding subject
  @RequestMapping(value="/user", method = RequestMethod.GET)
  @ResponseBody
  public User displayClasses(@RequestParam(value = "user") String user){
    int pos = this.getPosition(user);
    if(pos == -1){
      //just to prevent errors nothing more
      return new User("reb","teacher");
    }else{
      return users.get(pos);
    }
  }

  //returns the new made subject or just returns the corresponding subject
  @RequestMapping(value="/user/{subject}", method = RequestMethod.POST)
  @ResponseBody
  public User addSubject(@RequestParam(value="user") String user, @RequestParam(value = "subject") String subject){
    int pos = this.getPosition(user);
    if(pos == -1){
      //just to prevent errors nothing more
      return new User("reb","teacher");
    }else{
      users.get(pos).addSubject(subject);
      return users.get(pos);
    }
  }

  //returns the update made on the subject
  @RequestMapping(value="/user/{subject}/{item}", method = RequestMethod.POST)
  @ResponseBody
  public User addItem(@RequestParam(value="user") String user, @RequestParam(value="subject") String subject, @RequestParam(value="item") String item){
    int pos = this.getPosition(user);
    if(pos == -1){
      //just to prevent errors nothing more
      return new User("reb","teacher");
    }else{
      users.get(pos).addItem(subject, item);
      return users.get(pos);
    }
  }

  //deletes one item of a given subject
  @RequestMapping(value="/user/{subject}/{item}", method = RequestMethod.DELETE)
  @ResponseBody
  public User deleteItem(@RequestParam(value="user") String user, @RequestParam(value="subject") String subject, @RequestParam(value="item") String item){
    int pos = this.getPosition(user);
    if(pos == -1){
      //just to prevent errors nothing more
      return new User("reb","teacher");
    }else{
      users.get(pos).deleteItem(subject, item);
      return users.get(pos);
    }
  }

  //deletes a whole subject
  @RequestMapping(value="/user/{subject}", method = RequestMethod.DELETE)
  @ResponseBody
  public void deleteSubject(@RequestParam(value="user") String user, @RequestParam(value="subject") String subject){
    int pos = this.getPosition(user);
    if(pos != -1){
      users.get(pos).deleteSubject(subject);
    }
  }







}

package digitalreserve;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectsController{

  Subjects subjectsList = new Subjects();

  @RequestMapping(value="/subject")
  @ResponseBody
  public List<Subject> viewSubjects(){
    return subjectsList.getListSub();
  }


  //returns the new made subject or just returns the corresponding subject
  @RequestMapping(value="/subject", method = RequestMethod.POST)
  @ResponseBody
  public Subject addSubject(@RequestParam(value = "subject") String subject){
    return subjectsList.addSubject(subject);
  }

  //returns the update made on the subject
  @RequestMapping(value="/subject/{item}", method = RequestMethod.POST)
  @ResponseBody
  public Subject addItem(@RequestParam(value="subject") String subject, @RequestParam(value="item") String item){
    return subjectsList.addItem(subject, item);
  }

  //deletes one item of a given subject
  @RequestMapping(value="/subject/{item}", method = RequestMethod.DELETE)
  @ResponseBody
  public Subject deleteItem(@RequestParam(value="subject") String subject, @RequestParam(value="item") String item){
    return subjectsList.deleteItem(subject, item);
  }

  //deletes a whole subject
  @RequestMapping(value="/subject", method = RequestMethod.DELETE)
  @ResponseBody
  public void deleteSubject(@RequestParam(value="subject") String subject){
    subjectsList.deleteSubject(subject);
  }

}

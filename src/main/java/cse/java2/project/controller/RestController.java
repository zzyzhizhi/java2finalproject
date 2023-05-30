package cse.java2.project.controller;

import cse.java2.project.entity.Question;
import cse.java2.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/")
public class RestController {

  private final QuestionService myService;

  @Autowired
  public RestController(QuestionService myService) {
    this.myService = myService;
  }

  /**
   * This method is called when the user requests the root URL ("/") or "/demo".
   * In this demo, you can visit localhost:9090 or localhost:9090/demo to see the result.
   * @return the name of the view to be rendered
   * You can find the static HTML file in src/main/resources/templates/AnswersNumber.html
   */
  @Autowired
  private SpringTemplateEngine templateEngine;

  @GetMapping("/AnswerCounts/{answerCounts}")
  public List<Question> getAnswerCountsQuestions(@PathVariable Long answerCounts){
    List<Question> a = new ArrayList<>();
    for (int i = 0; i < myService.getAllQuestions().size(); i++) {
      if (myService.getAllQuestions().get(i).answer_count==answerCounts)
        a.add(myService.getAllQuestions().get(i));
    }
    return a;
  }

  @GetMapping("/CommentCounts/{commentCounts}")
  public List<Question> getCommentCountsQuestions(@PathVariable Long commentCounts){
    List<Question> a = new ArrayList<>();
    for (int i = 0; i < myService.getAllQuestions().size(); i++) {
      if (myService.getAllQuestions().get(i).comment_count==commentCounts)
        a.add(myService.getAllQuestions().get(i));
    }
    return a;
  }

  @GetMapping("/UpvoteCount/{upvoteCount}")
  public List<Question> getUpvoteCountQuestions(@PathVariable Long upvoteCount){
    List<Question> a = new ArrayList<>();
    for (int i = 0; i < myService.getAllQuestions().size(); i++) {
      if (myService.getAllQuestions().get(i).comment_count==upvoteCount)
        a.add(myService.getAllQuestions().get(i));
    }
    return a;
  }


}

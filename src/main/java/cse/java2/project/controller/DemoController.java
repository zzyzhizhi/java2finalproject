package cse.java2.project.controller;

import cse.java2.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Controller
@RequestMapping("/api/")
public class DemoController {

  private final QuestionService myService;

  @Autowired
  public DemoController(QuestionService myService) {
    this.myService = myService;
  }

  /**
   * This method is called when the user requests the root URL ("/") or "/demo".
   * In this demo, you can visit localhost:9090 or localhost:9090/demo to see the result.
   *
   * @return the name of the view to be rendered
   * You can find the static HTML file in src/main/resources/templates/AnswersNumber.html
   */
  @Autowired
  private SpringTemplateEngine templateEngine;

  @GetMapping("/apiMost")
  public String apiMost() {
    return "apiMost";
  }


  @GetMapping("/AnswersNumber")
  public String AnswersNumber() {
    return "AnswersNumber";
  }

  @GetMapping("/AcceptAnswer")
  public String AcceptAnswer() {
    return "AcceptAnswer";
  }

  @GetMapping("/Tags")
  public String Tags() {
    return "Tags";
  }

  @GetMapping("/Users")
  public String Users() {
    return "Users";
  }


  @ResponseBody
  @GetMapping("/data")
  public Data getData() {
    Data data1 = new Data();
    data1.UnansweredQuestionRatio = myService.calculateUnansweredQuestionRatio();
    data1.MaxAnswerCount = myService.findMaxAnswerCount();
    System.out.println(data1.MaxAnswerCount);
    data1.AverageAnswerCount = myService.findAverageAnswerCount();
    data1.answerCount = myService.findAnswerCountDistribution().get("answerCounts");
    data1.questionCountToAnswerCount = myService.findAnswerCountDistribution().get("questionCounts");
    data1.PercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes = myService.findPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes();
    data1.QuestionsWithAcceptedAnswerRatio = myService.countQuestionsWithAcceptedAnswerRatio();
    data1.duringTimeHours = myService.findQuestionResolutionTimes();
    data1.TopTagsWithJava = myService.findTopTagsWithJava();
    data1.TopTagsWithJavaCount = myService.findTopTagsWithJavaCount();
    data1.MostViewCountTags = myService.findMostViewCountTags();
    data1.MostVoteCountTags = myService.findMostVoteCountTags();
    data1.distinctPostQuestionUser = myService.getdistinctPostQuestionUser();
    data1.distinctAnswerUser = myService.getdistinctAnswerUser();
    data1.distinctCommentUser = myService.getdistinctCommentUser();
    data1.userInQuestion = myService.getuserInQuestion();
    data1.userInAnswer = myService.getuserInAnswer();
    data1.userInComment = myService.getuserInComment();
    data1.userMostActive = myService.getuserMostActive();
    data1.apiList = myService.getMostApi();
    data1.apiListCount = myService.getMostApi1();
    return data1;
  }


}

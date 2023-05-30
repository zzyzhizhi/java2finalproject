package cse.java2.project.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cse.java2.project.entity.Question;
import cse.java2.project.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Component
@EnableJpaRepositories
public class QuestionService {

  static List<Question> questions = new ArrayList<>();
  private final MyRepository myRepository;

  @Autowired
  public QuestionService(MyRepository myRepository) {
    this.myRepository = myRepository;
  }

  public void saveQuestionsFromFile() throws IOException {
    // 读取文件内容
    byte[] jsonData1 = Files.readAllBytes(Paths.get("D:\\Project\\java2finalproject(1)\\questions1.json"));
    byte[] jsonData2 = Files.readAllBytes(Paths.get("D:\\Project\\java2finalproject(1)\\questions2.json"));
    byte[] jsonData3 = Files.readAllBytes(Paths.get("D:\\Project\\java2finalproject(1)\\questions3.json"));
    byte[] jsonData4 = Files.readAllBytes(Paths.get("D:\\Project\\java2finalproject(1)\\questions4.json"));
    byte[] jsonData5 = Files.readAllBytes(Paths.get("D:\\Project\\java2finalproject(1)\\questions5.json"));

    ObjectMapper objectMapper1 = new ObjectMapper();
    JsonNode rootNode1 = objectMapper1.readTree(jsonData1);
    List<Question> questions1 = objectMapper1.convertValue(rootNode1.get("items"), new TypeReference<List<Question>>() {
    });

    ObjectMapper objectMapper2 = new ObjectMapper();
    JsonNode rootNode2 = objectMapper2.readTree(jsonData2);
    List<Question> questions2 = objectMapper2.convertValue(rootNode2.get("items"), new TypeReference<List<Question>>() {
    });

    ObjectMapper objectMapper3 = new ObjectMapper();
    JsonNode rootNode3 = objectMapper3.readTree(jsonData3);
    List<Question> questions3 = objectMapper3.convertValue(rootNode3.get("items"), new TypeReference<List<Question>>() {
    });

    ObjectMapper objectMapper4 = new ObjectMapper();
    JsonNode rootNode4 = objectMapper4.readTree(jsonData4);
    List<Question> questions4 = objectMapper4.convertValue(rootNode4.get("items"), new TypeReference<List<Question>>() {
    });

    ObjectMapper objectMapper5 = new ObjectMapper();
    JsonNode rootNode5 = objectMapper5.readTree(jsonData5);
    List<Question> questions5 = objectMapper5.convertValue(rootNode5.get("items"), new TypeReference<List<Question>>() {
    });


    questions.addAll(questions1);
    questions.addAll(questions2);
    questions.addAll(questions3);
    questions.addAll(questions4);
    questions.addAll(questions5);

    // 将数据保存到数据库中
    myRepository.saveAll(questions);
    System.out.println("Number of questions: " + questions.size());
  }

  public List<Question> getAllQuestions() {
    return questions;
  }

  public double calculateUnansweredQuestionRatio() {
    long allQuestion = myRepository.countAllQuestions();
    long QuestionWithoutAnswer = myRepository.countUnansweredQuestion();
    return (double) QuestionWithoutAnswer / allQuestion;
  }

  public long findMaxAnswerCount() {
    return myRepository.findMaxAnswerCount();
  }

  public double findAverageAnswerCount() {
    return myRepository.findAverageAnswerCount();
  }

  public Map<String, List<Long>> findAnswerCountDistribution() {
    List<Long[]> results = myRepository.findAnswerCountDistribution();
    List<Long> answerCounts = new ArrayList<>();
    List<Long> questionCounts = new ArrayList<>();
    for (Long[] result : results) {
      answerCounts.add(result[0]);
      questionCounts.add(result[1]);
    }
    Map<String, List<Long>> data = new HashMap<>();
    data.put("answerCounts", answerCounts);
    data.put("questionCounts", questionCounts);
    return data;
  }

  public double countQuestionsWithAcceptedAnswerRatio() {
    long allQuestion = myRepository.countAllQuestions();
    long QuestionWithAcceptedAnswer = myRepository.countQuestionsWithAcceptedAnswer();
    return (double) QuestionWithAcceptedAnswer / allQuestion;
  }

  public List<Long> findQuestionResolutionTimes() {
    return myRepository.findQuestionResolutionTimes();
  }

  public double findPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes() {
    return myRepository.findPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes();
  }

  public List<String> findTopTagsWithJava() {
    return myRepository.findTopTagsWithJava();
  }

  public List<Long> findTopTagsWithJavaCount() {
    return myRepository.findTopTagsWithJavaCount();
  }

  public List<String> findMostVoteCountTags() {
    Map<String, Integer> map = new HashMap<>();
    List<String> s = new ArrayList<>();
    for (int i = 0; i < myRepository.findMostVoteCountTags().size(); i++) {
      if (!map.containsKey(myRepository.findMostVoteCountTags().get(i))) {
        map.put(myRepository.findMostVoteCountTags().get(i), 0);
        s.add(myRepository.findMostVoteCountTags().get(i));
      } else break;
    }
    return s;
  }

  public List<String> findMostViewCountTags() {
    Map<String, Integer> map = new HashMap<>();
    List<String> s = new ArrayList<>();
    for (int i = 0; i < myRepository.findMostViewCountTags().size(); i++) {
      if (!map.containsKey(myRepository.findMostViewCountTags().get(i))) {
        map.put(myRepository.findMostViewCountTags().get(i), 0);
        s.add(myRepository.findMostViewCountTags().get(i));
      } else break;
    }
    return s;
  }

  public Long getdistinctPostQuestionUser() {
    return myRepository.getdistinctPostQuestionUser();
  }

  public Long getdistinctCommentUser() {
    return myRepository.getdistinctCommentUser();
  }

  public Long getdistinctAnswerUser() {
    return myRepository.getdistinctAnswerUser();
  }

  public List<Long[]> getuserInQuestion() {
    return myRepository.getuserInQuestion();
  }

  public List<Long[]> getuserInComment() {
    return myRepository.getuserInComment();
  }

  public List<Long[]> getuserInAnswer() {
    return myRepository.getuserInAnswer();
  }

  public List<Long[]> getuserMostActive() {
    Map<Long, Long> map = new HashMap<>();
    List<Long[]> a = myRepository.getuserInQuestion();
    List<Long[]> b = myRepository.getuserInComment();
    List<Long[]> c = myRepository.getuserInAnswer();
    for (Long[] longs : a) {
      if (!map.containsKey(longs[0])) map.put(longs[0], longs[1]);
      else {
        Long temp = map.get(longs[0]);
        temp += longs[1];
        map.put(longs[0], temp);
      }
    }
    for (Long[] longs : b) {
      if (!map.containsKey(longs[0])) map.put(longs[0], longs[1]);
      else {
        Long temp = map.get(longs[0]);
        temp += longs[1];
        map.put(longs[0], temp);
      }
    }
    for (Long[] longs : c) {
      if (!map.containsKey(longs[0])) map.put(longs[0], longs[1]);
      else {
        Long temp = map.get(longs[0]);
        temp += longs[1];
        map.put(longs[0], temp);
      }
    }

    List<Map.Entry<Long, Long>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.<Long, Long>comparingByValue().reversed());

    List<Long[]> result = new ArrayList<>();

    int h = 0;
    for (Map.Entry<Long, Long> entry : list) {
      h++;
      Long[] m = new Long[2];
      m[0] = entry.getKey();
      m[1] = entry.getValue();
      result.add(m);
      if (h == 5) break;
    }

    return result;
  }

  public List<String> getMostApi() {
    List<String> a = myRepository.getBody();
    Map<String, Long> map = new HashMap<>();
    Map<String, Long> map1 = new HashMap<>();
    for (String str : a) {
      Pattern pattern = Pattern.compile("java\\..*$", Pattern.MULTILINE);
      Matcher matcher = pattern.matcher(str);
      while (matcher.find()) {
        if (!map.containsKey(matcher.group()))
          map.put(matcher.group(), 1L);
        else {
          Long temp = map.get(matcher.group());
          temp++;
          map.put(matcher.group(), temp);
        }
      }
    }
    List<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.<String, Long>comparingByValue().reversed());

    int h = 0;
    List<String> s = new ArrayList<>();
    List<Long> l = new ArrayList<>();
    for (Map.Entry<String, Long> entry : list) {
      h++;
      s.add(entry.getKey());
      l.add(entry.getValue());
      if (h == 5) break;
    }

    return s;
  }


  public List<Long> getMostApi1() {
    List<String> a = myRepository.getBody();
    Map<String, Long> map = new HashMap<>();
    for (String str : a) {
      Pattern pattern = Pattern.compile("java\\..*$", Pattern.MULTILINE);
      Matcher matcher = pattern.matcher(str);
      while (matcher.find()) {
        if (!map.containsKey(matcher.group()))
          map.put(matcher.group(), 1L);
        else {
          Long temp = map.get(matcher.group());
          temp++;
          map.put(matcher.group(), temp);
        }
      }
    }
    List<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.<String, Long>comparingByValue().reversed());

    int h = 0;
    List<String> s = new ArrayList<>();
    List<Long> l = new ArrayList<>();
    for (Map.Entry<String, Long> entry : list) {
      h++;
      s.add(entry.getKey());
      l.add(entry.getValue());
      if (h == 5) break;
    }

    return l;
  }
}


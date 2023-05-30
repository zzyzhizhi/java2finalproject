
package cse.java2.project.repository;

import cse.java2.project.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<Question, Long> {
  @Query("select count(q) from Question q")
  long countAllQuestions();

  @Query("select count(q) from Question q where q.answer_count = 0")
  long countUnansweredQuestion();

  @Query("SELECT MAX(q.answer_count) FROM Question q")
  long findMaxAnswerCount();

  @Query("SELECT AVG(q.answer_count) FROM Question q")
  double findAverageAnswerCount();

  @Query("SELECT q.answer_count, COUNT(q) FROM Question q GROUP BY q.answer_count")
  List<Long[]> findAnswerCountDistribution();

  @Query("SELECT COUNT(q) FROM Question q WHERE q.is_answered = true")
  long countQuestionsWithAcceptedAnswer();

  // 计算问题解决时间的分布（PostgreSQL）
  @Query("SELECT (MIN(a.last_activity_date) - q.creation_date)/3600 AS resolution_time " +
      "FROM Question q JOIN q.answers a " +
      "WHERE q.is_answered = true AND a.is_accepted = true " +
      "GROUP BY q.id")
  List<Long> findQuestionResolutionTimes();


  // 计算有非接受答案比接受答案赞更多的问题的百分比
//  @Query("SELECT AVG(CASE WHEN a2.up_vote_count > a1.up_vote_count THEN 1 ELSE 0 END)\n" +
//      "FROM Question q JOIN q.answers\n" +
//      "JOIN question_answers qa1 ON q.id = qa1.question_id\n" +
//      "JOIN Answer a1 ON qa1.answers_id = a1.id AND a1.is_accepted = true\n" +
//      "JOIN question_answers qa2 ON q.id = qa2.question_id\n" +
//      "JOIN Answer a2 ON qa2.answers_id = a2.id AND a2.is_accepted = false\n" +
//      "WHERE q.is_answered = true")
//  Double findPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes();


  @Query(value = "SELECT AVG(CASE WHEN a2.up_vote_count > a1.up_vote_count THEN 1 ELSE 0 END)\n" +
      "FROM question q\n" +
      "JOIN question_answers qa1 ON q.id = qa1.question_id\n" +
      "JOIN answer a1 ON qa1.answers_id = a1.id AND a1.is_accepted = true\n" +
      "JOIN question_answers qa2 ON q.id = qa2.question_id\n" +
      "JOIN answer a2 ON qa2.answers_id = a2.id AND a2.is_accepted = false\n" +
      "WHERE q.is_answered = true", nativeQuery = true)
  Double findPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes();

  @Query(value = "SELECT t2.tags\n" +
      "FROM question_tags t1\n" +
      "JOIN question_tags t2 ON t1.question_id = t2.question_id\n" +
      "WHERE t1.tags = 'java' AND t2.tags<> 'java'\n" +
      "GROUP BY t2.tags\n" +
      "ORDER BY count(*) DESC", nativeQuery = true)
  List<String> findTopTagsWithJava();

  @Query(value = "SELECT count(*)\n" +
      "      FROM question_tags t1\n" +
      "      JOIN question_tags t2 ON t1.question_id = t2.question_id\n" +
      "      WHERE t1.tags = 'java' AND t2.tags<> 'java'\n" +
      "      GROUP BY t2.tags\n" +
      "      ORDER BY count(*) DESC", nativeQuery = true)
  List<Long> findTopTagsWithJavaCount();


  @Query(value = "SELECT t2.tags\n" +
      "FROM question t1\n" +
      "JOIN question_tags t2 ON t1.id = t2.question_id\n" +
      "WHERE t1.up_vote_count = (SELECT MAX(up_vote_count) FROM question)\n", nativeQuery = true)
  List<String> findMostVoteCountTags();

  @Query(value = "SELECT t2.tags\n" +
      "FROM question t1\n" +
      "JOIN question_tags t2 ON t1.id = t2.question_id\n" +
      "WHERE t1.view_count = (SELECT MAX(view_count) FROM question)\n", nativeQuery = true)
  List<String> findMostViewCountTags();

  @Query(value = "SELECT COUNT(DISTINCT owner.user_id)\n" +
      "FROM question\n" +
      "JOIN owner ON question.owner_id = owner.id;", nativeQuery = true)
  Long getdistinctPostQuestionUser();

  @Query(value = "SELECT COUNT(DISTINCT owner.user_id)\n" +
      "FROM comment\n" +
      "JOIN owner ON comment.owner_id = owner.id;", nativeQuery = true)
  Long getdistinctCommentUser();

  @Query(value = "SELECT COUNT(DISTINCT owner.user_id)\n" +
      "FROM answer\n" +
      "JOIN owner ON answer.owner_id = owner.id;", nativeQuery = true)
  Long getdistinctAnswerUser();

  @Query(value = "SELECT owner.user_id, COUNT(DISTINCT question.owner_id)\n" +
      "FROM question\n" +
      "JOIN owner ON question.owner_id = owner.id\n" +
      "GROUP BY owner.user_id;", nativeQuery = true)
  List<Long[]> getuserInQuestion();

  @Query(value = "SELECT owner.user_id, COUNT(DISTINCT comment.owner_id)\n" +
      "FROM comment\n" +
      "JOIN owner ON comment.owner_id = owner.id\n" +
      "GROUP BY owner.user_id;", nativeQuery = true)
  List<Long[]> getuserInComment();

  @Query(value = "SELECT owner.user_id, COUNT(DISTINCT answer.owner_id)\n" +
      "FROM answer\n" +
      "JOIN owner ON answer.owner_id = owner.id\n" +
      "GROUP BY owner.user_id;", nativeQuery = true)
  List<Long[]> getuserInAnswer();

  @Query(value = "select question.body\n" +
      "from question", nativeQuery = true)
  List<String> getBody();
}


package cse.java2.project.controller;

import java.util.List;

public class Data {
  double UnansweredQuestionRatio;
  Long MaxAnswerCount;
  Double AverageAnswerCount;
  List<Long> answerCount;
  List<Long> questionCountToAnswerCount;
  List<Long> duringTimeHours;
  double QuestionsWithAcceptedAnswerRatio;
  double PercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes;
  List<String> TopTagsWithJava;
  List<Long> TopTagsWithJavaCount;
  List<String> MostVoteCountTags;
  List<String> MostViewCountTags;
  Long distinctPostQuestionUser;
  Long distinctCommentUser;
  Long distinctAnswerUser;
  List<Long[]> userInQuestion;
  List<Long[]> userInComment;
  List<Long[]> userInAnswer;
  List<Long[]> userMostActive;
  List<String> apiList;
  List<Long> apiListCount;

  public List<String> getApiList() {
    return apiList;
  }

  public void setApiList(List<String> apiList) {
    this.apiList = apiList;
  }

  public List<Long> getApiListCount() {
    return apiListCount;
  }

  public void setApiListCount(List<Long> apiListCount) {
    this.apiListCount = apiListCount;
  }

  public List<Long[]> getUserMostActive() {
    return userMostActive;
  }

  public void setUserMostActive(List<Long[]> userMostActive) {
    this.userMostActive = userMostActive;
  }

  public Long getDistinctPostQuestionUser() {
    return distinctPostQuestionUser;
  }

  public void setDistinctPostQuestionUser(Long distinctPostQuestionUser) {
    this.distinctPostQuestionUser = distinctPostQuestionUser;
  }

  public Long getDistinctCommentUser() {
    return distinctCommentUser;
  }

  public void setDistinctCommentUser(Long distinctCommentUser) {
    this.distinctCommentUser = distinctCommentUser;
  }

  public Long getDistinctAnswerUser() {
    return distinctAnswerUser;
  }

  public void setDistinctAnswerUser(Long distinctAnswerUser) {
    this.distinctAnswerUser = distinctAnswerUser;
  }

  public List<Long[]> getUserInQuestion() {
    return userInQuestion;
  }

  public void setUserInQuestion(List<Long[]> userInQuestion) {
    this.userInQuestion = userInQuestion;
  }

  public List<Long[]> getUserInComment() {
    return userInComment;
  }

  public void setUserInComment(List<Long[]> userInComment) {
    this.userInComment = userInComment;
  }

  public List<Long[]> getUserInAnswer() {
    return userInAnswer;
  }

  public void setUserInAnswer(List<Long[]> userInAnswer) {
    this.userInAnswer = userInAnswer;
  }

  public List<Long> getTopTagsWithJavaCount() {
    return TopTagsWithJavaCount;
  }

  public void setTopTagsWithJavaCount(List<Long> topTagsWithJavaCount) {
    TopTagsWithJavaCount = topTagsWithJavaCount;
  }

  public List<String> getMostVoteCountTags() {
    return MostVoteCountTags;
  }

  public void setMostVoteCountTags(List<String> mostVoteCountTags) {
    MostVoteCountTags = mostVoteCountTags;
  }

  public List<String> getMostViewCountTags() {
    return MostViewCountTags;
  }

  public void setMostViewCountTags(List<String> mostViewCountTags) {
    MostViewCountTags = mostViewCountTags;
  }

  public double getUnansweredQuestionRatio() {
    return UnansweredQuestionRatio;
  }

  public void setUnansweredQuestionRatio(double unansweredQuestionRatio) {
    UnansweredQuestionRatio = unansweredQuestionRatio;
  }


  public Long getMaxAnswerCount() {
    return MaxAnswerCount;
  }

  public void setMaxAnswerCount(Long maxAnswerCount) {
    MaxAnswerCount = maxAnswerCount;
  }

  public Double getAverageAnswerCount() {
    return AverageAnswerCount;
  }

  public void setAverageAnswerCount(Double averageAnswerCount) {
    AverageAnswerCount = averageAnswerCount;
  }

  public List<Long> getAnswerCount() {
    return answerCount;
  }

  public void setAnswerCount(List<Long> answerCount) {
    this.answerCount = answerCount;
  }

  public List<Long> getQuestionCountToAnswerCount() {
    return questionCountToAnswerCount;
  }

  public void setQuestionCountToAnswerCount(List<Long> questionCountToAnswerCount) {
    this.questionCountToAnswerCount = questionCountToAnswerCount;
  }

  public List<Long> getDuringTimeHours() {
    return duringTimeHours;
  }

  public void setDuringTimeHours(List<Long> duringTimeHours) {
    this.duringTimeHours = duringTimeHours;
  }

  public double getQuestionsWithAcceptedAnswerRatio() {
    return QuestionsWithAcceptedAnswerRatio;
  }

  public void setQuestionsWithAcceptedAnswerRatio(double questionsWithAcceptedAnswerRatio) {
    QuestionsWithAcceptedAnswerRatio = questionsWithAcceptedAnswerRatio;
  }

  public double getPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes() {
    return PercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes;
  }

  public void setPercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes(double percentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes) {
    PercentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes = percentageOfQuestionsWithNonAcceptedAnswersWithMoreUpvotes;
  }

  public List<String> getTopTagsWithJava() {
    return TopTagsWithJava;
  }

  public void setTopTagsWithJava(List<String> topTagsWithJava) {
    TopTagsWithJava = topTagsWithJava;
  }
}

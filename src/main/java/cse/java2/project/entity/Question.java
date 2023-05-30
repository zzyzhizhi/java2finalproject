package cse.java2.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @ElementCollection
  public List<String> tags;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Comment> comments;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Answer> answers;

  @OneToOne(cascade = CascadeType.ALL)
  public Owner owner;

  public int comment_count;
  public boolean is_answered;
  public int view_count;
  public int up_vote_count;
  public int answer_count;
  public int score;
  public long last_activity_date;
  public long creation_date;
  public long last_edit_date;
  public long question_id;
  public String link;
  public String title;

  @Column(columnDefinition = "text")
  public String body;

  // getters and setters
}

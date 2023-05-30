package cse.java2.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "answer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Comment> comments;

  @OneToOne(cascade = CascadeType.ALL)
  public Owner owner;

  public int comment_count;
  public int up_vote_count;
  public boolean is_accepted;
  public int score;
  public long last_activity_date;
}
package cse.java2.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @OneToOne(cascade = CascadeType.ALL)
  public Owner owner;

  public boolean edited;
  public int score;
  public long creation_date;
  public long post_id;
  public long comment_id;
  public String content_license;

  // getters and setters
}
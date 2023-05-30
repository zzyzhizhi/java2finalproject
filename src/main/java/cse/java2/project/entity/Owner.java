package cse.java2.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public long account_id;
  public int reputation;
  public long user_id;
  public long accept_rate;
  public String user_type;
  public String profile_image;
  public String display_name;
  public String link;

  // getters and setters
}

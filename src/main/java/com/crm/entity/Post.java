package com.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;


@Entity
@Table(name = "post")
public class Post {
  @Id
  @Column(name = "id", unique = true)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", length = 5000)
  private String description;

  @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
  private List<Comment> comments;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
package com.sp5byex.cms.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="news")
public class News {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  String id;

  String title;

  String content;

  @ManyToOne
  User author;

  @OneToMany
  Set<User> mandatoryReviewers;

  @OneToMany
  Set<Category> categories;

  @ElementCollection
  Set<Tag> tags;

  @ElementCollection
  Set<Review> reviews = new HashSet<>();

  public Review review(String userId, String status) {
    final Review rev = new Review(userId, status);
    this.reviews.add(rev);
    return rev;
  }

  public Boolean revised() {
    return this.mandatoryReviewers.stream().allMatch(
      reviewer -> this.reviews.stream().anyMatch(rev -> reviewer.id.equals(rev.userId))
    );
  }

}

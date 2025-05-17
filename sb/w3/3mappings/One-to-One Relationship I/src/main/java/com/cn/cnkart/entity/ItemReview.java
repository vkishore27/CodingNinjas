package com.cn.cnkart.entity;

import javax.persistence.*;

@Entity
@Table(name="item_review")
public class ItemReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String reviewerName;
    @Column
    private String review;
    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

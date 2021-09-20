package br.com.evergreenapi.Domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

   
    @OneToMany(mappedBy = "profile")
    private Set<Feed> feeds;

    @OneToMany(mappedBy = "profile")
    private Set<LikeProfile> Likes;

    private String avatar;
    private String nickname;

    private String WhatYouThinking;

    private Boolean supportRecycling;
    private Boolean buyProducts;
    private Boolean sellProducts;

    public Set<Feed> getFeeds() {
        return this.feeds;
    }

    public void setFeeds(Set<Feed> feeds) {
        this.feeds = feeds;
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWhatYouThinking() {
        return this.WhatYouThinking;
    }

    public void setWhatYouThinking(String WhatYouThinking) {
        this.WhatYouThinking = WhatYouThinking;
    }

    public Boolean getSupportRecycling() {
        return this.supportRecycling;
    }

    public void setSupportRecycling(Boolean supportRecycling) {
        this.supportRecycling = supportRecycling;
    }

    public Boolean getBuyProducts() {
        return this.buyProducts;
    }

    public void setBuyProducts(Boolean buyProducts) {
        this.buyProducts = buyProducts;
    }

    public Boolean getSellProducts() {
        return this.sellProducts;
    }

    public void setSellProducts(Boolean sellProducts) {
        this.sellProducts = sellProducts;
    }

    public Set<LikeProfile> getLikes() {
        return this.Likes;
    }

    public void setLikes(Set<LikeProfile> Likes) {
        this.Likes = Likes;
    }
}

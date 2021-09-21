package br.com.evergreenapi.Domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class LikeProfile {
    private Date createdAt;
    private Boolean dislike;
    private Boolean canceled;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDislike() {
        return this.dislike;
    }

    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
    }

    public Boolean getCanceled() {
        return this.canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}

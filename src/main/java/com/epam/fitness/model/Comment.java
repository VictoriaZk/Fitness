package com.epam.fitness.model;

import java.util.Objects;

/**
 * The type Comment.
 */
public class Comment implements Identifiable {

    private Long id;
    private Long clientId;
    private Long coachId;
    private String commentContent;

    /**
     * Instantiates a new Comment.
     *
     * @param clientId       the client id
     * @param coachId        the coach id
     * @param commentContent the comment content
     */
    public Comment(Long clientId, Long coachId, String commentContent){
        this.clientId = clientId;
        this.coachId = coachId;
        this.commentContent = commentContent;
    }

    /**
     * Instantiates a new Comment.
     *
     * @param id             the id
     * @param clientId       the client id
     * @param coachId        the coach id
     * @param commentContent the comment content
     */
    public Comment(Long id, Long clientId, Long coachId, String commentContent){
        this.id = id;
        this.clientId = clientId;
        this.coachId = coachId;
        this.commentContent = commentContent;
    }

    /**
     * Instantiates a new Comment.
     */
    public Comment(){}

    @Override
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets coach id.
     *
     * @return the coach id
     */
    public Long getCoachId() {
        return coachId;
    }

    /**
     * Sets coach id.
     *
     * @param coachId the coach id
     */
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    /**
     * Gets comment content.
     *
     * @return the comment content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * Sets comment content.
     *
     * @param commmentContent the commment content
     */
    public void setCommentContent(String commmentContent) {
        this.commentContent = commmentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return  Objects.equals(getId(), comment.getId()) &&
                Objects.equals(getClientId(), comment.getClientId()) &&
                Objects.equals(getCoachId(), comment.getCoachId()) &&
                Objects.equals(getCommentContent(), comment.getCommentContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getClientId(),getCoachId(),getCommentContent());
    }

}


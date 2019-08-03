package com.epam.fitness.model;

import java.util.Objects;

/**
 * The type Exercise.
 */
public class Exercise implements Identifiable {

    private Long id;

    private String name;
    private String description;
    private String image;

    /**
     * Instantiates a new Exercise.
     */
    public Exercise(){}

    /**
     * Instantiates a new Exercise.
     *
     * @param id          the id
     * @param name        the name
     * @param description the description
     * @param image       the image
     */
    public Exercise(Long id, String name, String description, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * Instantiates a new Exercise.
     *
     * @param id the id
     */
    public Exercise(Long id){
        this.id = id;
    }

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exercise exercise = (Exercise) o;
        return  Objects.equals(getId(), exercise.getId()) &&
                Objects.equals(getName(), exercise.getName()) &&
                Objects.equals(getDescription(), exercise.getDescription()) &&
                Objects.equals(getImage(), exercise.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getName(),getDescription(),getImage());
    }
}

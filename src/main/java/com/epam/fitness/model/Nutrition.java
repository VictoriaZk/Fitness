package com.epam.fitness.model;

import java.util.Objects;

/**
 * The type Nutrition.
 */
public class Nutrition implements Identifiable {

    private Long id;
    private String name;
    private String morningNutrition;
    private String lunchNutrition;
    private String dinnerNutrition;

    /**
     * Instantiates a new Nutrition.
     *
     * @param id               the id
     * @param name             the name
     * @param morningNutrition the morning nutrition
     * @param lunchNutrition   the lunch nutrition
     * @param dinnerNutrition  the dinner nutrition
     */
    public Nutrition(Long id, String name, String morningNutrition, String lunchNutrition, String dinnerNutrition){
        this.id = id;
        this.name = name;
        this.morningNutrition = morningNutrition;
        this.lunchNutrition = lunchNutrition;
        this.dinnerNutrition = dinnerNutrition;
    }

    /**
     * Instantiates a new Nutrition.
     */
    public Nutrition(){}

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
     * Gets morning nutrition.
     *
     * @return the morning nutrition
     */
    public String getMorningNutrition() {
        return morningNutrition;
    }

    /**
     * Sets morning nutrition.
     *
     * @param morningNutrition the morning nutrition
     */
    public void setMorningNutrition(String morningNutrition) {
        this.morningNutrition = morningNutrition;
    }

    /**
     * Gets lunch nutrition.
     *
     * @return the lunch nutrition
     */
    public String getLunchNutrition() {
        return lunchNutrition;
    }

    /**
     * Sets lunch nutrition.
     *
     * @param lunchNutrition the lunch nutrition
     */
    public void setLunchNutrition(String lunchNutrition) {
        this.lunchNutrition = lunchNutrition;
    }

    /**
     * Gets dinner nutrition.
     *
     * @return the dinner nutrition
     */
    public String getDinnerNutrition() {
        return dinnerNutrition;
    }

    /**
     * Sets dinner nutrition.
     *
     * @param dinnerNutrition the dinner nutrition
     */
    public void setDinnerNutrition(String dinnerNutrition) {
        this.dinnerNutrition = dinnerNutrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nutrition nutrition = (Nutrition) o;
        return  Objects.equals(getId(), nutrition.getId()) &&
                Objects.equals(getName(), nutrition.getName()) &&
                Objects.equals(getMorningNutrition(), nutrition.getMorningNutrition()) &&
                Objects.equals(getLunchNutrition(), nutrition.getLunchNutrition()) &&
                Objects.equals(getDinnerNutrition(), nutrition.getDinnerNutrition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getName(),getMorningNutrition(),getLunchNutrition(),getDinnerNutrition());
    }
}

package com.epam.fitness.model.dto;

import com.epam.fitness.model.Exercise;
import com.epam.fitness.model.Identifiable;

import java.util.Objects;

/**
 * The type Exercise dto.
 */
public class ExerciseDto implements Identifiable {

    private Long id;
    private Exercise exercise;
    private int repeatNumber;
    private int setNumber;
    private Long programId;
    private int numberTrainDay;

    /**
     * Instantiates a new Exercise dto.
     *
     * @param id             the id
     * @param exercise       the exercise
     * @param programId      the program id
     * @param repeatNumber   the repeat number
     * @param setNumber      the set number
     * @param numberTrainDay the number train day
     */
    public ExerciseDto(Long id, Exercise exercise, Long programId, int repeatNumber, int setNumber,int numberTrainDay){
        this.id = id;
        this.exercise = exercise;
        this.programId = programId;
        this.repeatNumber = repeatNumber;
        this.setNumber = setNumber;
        this.numberTrainDay = numberTrainDay;
    }

    /**
     * Instantiates a new Exercise dto.
     */
    public ExerciseDto(){}

    /**
     * Gets program id.
     *
     * @return the program id
     */
    public Long getProgramId() {
        return programId;
    }

    /**
     * Sets program id.
     *
     * @param programId the program id
     */
    public void setProgramId(long programId) {
        this.programId = programId;
    }

    /**
     * Gets exercise.
     *
     * @return the exercise
     */
    public Exercise getExercise() {
        return exercise;
    }

    /**
     * Sets exercise.
     *
     * @param exercise the exercise
     */
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    /**
     * Gets repeat number.
     *
     * @return the repeat number
     */
    public int getRepeatNumber() {
        return repeatNumber;
    }

    /**
     * Sets repeat number.
     *
     * @param repeatNumber the repeat number
     */
    public void setRepeatNumber(int repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    /**
     * Gets set number.
     *
     * @return the set number
     */
    public int getSetNumber() {
        return setNumber;
    }

    /**
     * Sets set number.
     *
     * @param setNumber the set number
     */
    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    /**
     * Gets number train day.
     *
     * @return the number train day
     */
    public int getNumberTrainDay() {
        return numberTrainDay;
    }

    /**
     * Sets number train day.
     *
     * @param numberTrainDay the number train day
     */
    public void setNumberTrainDay(int numberTrainDay) {
        this.numberTrainDay = numberTrainDay;
    }

    public Long getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExerciseDto exerciseDto = (ExerciseDto) o;
        return  Objects.equals(getId(), exerciseDto.getId()) &&
                getExercise().equals(exerciseDto.getExercise()) &&
                Objects.equals(getProgramId(), exerciseDto.getProgramId()) &&
                Objects.equals(getRepeatNumber(), exerciseDto.getRepeatNumber()) &&
                Objects.equals(getSetNumber(), exerciseDto.getSetNumber()) &&
                Objects.equals(getNumberTrainDay(), exerciseDto.getNumberTrainDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getExercise(),getProgramId(),getRepeatNumber(),getSetNumber(),getNumberTrainDay());
    }
}

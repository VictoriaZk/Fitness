package com.epam.fitness.repository.specifications.exercise.dto;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Exercise dto by id.
 */
public class ExerciseDtoById implements SqlSpecification {

    private Long id;

    /**
     * Instantiates a new Exercise dto by id.
     *
     * @param id the id
     */
    public ExerciseDtoById(Long id){
        this.id = id;
    }

    @Override
    public String getSql() {
        return "right join exercise_program on exercise.id_exercise = exercise_program.exercise_id where exercise_program.id_exercise_program=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(id);
    }
}

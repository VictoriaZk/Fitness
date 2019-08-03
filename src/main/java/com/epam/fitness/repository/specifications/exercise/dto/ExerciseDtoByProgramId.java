package com.epam.fitness.repository.specifications.exercise.dto;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Exercise dto by program id.
 */
public class ExerciseDtoByProgramId implements SqlSpecification {

    private Long programId;

    /**
     * Instantiates a new Exercise dto by program id.
     *
     * @param programId the program id
     */
    public ExerciseDtoByProgramId(Long programId){
        this.programId = programId;
    }

    @Override
    public String getSql() {
        return "left join exercise_program on exercise.id_exercise = exercise_program.exercise_id where program_id=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(programId);
    }
}

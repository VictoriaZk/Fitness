package com.epam.fitness.repository.specifications.program;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Program by id.
 */
public class ProgramById implements SqlSpecification {

    private Long programId;

    /**
     * Instantiates a new Program by id.
     *
     * @param programId the program id
     */
    public ProgramById(Long programId){
        this.programId = programId;
    }

    @Override
    public String getSql() {
        return "where id_program=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(programId);
    }
}

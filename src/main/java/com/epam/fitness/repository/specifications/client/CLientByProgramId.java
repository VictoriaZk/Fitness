package com.epam.fitness.repository.specifications.client;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type C lient by program id.
 */
public class CLientByProgramId implements SqlSpecification {

    private Long programId;

    /**
     * Instantiates a new C lient by program id.
     *
     * @param programId the program id
     */
    public CLientByProgramId(Long programId) {
        this.programId = programId;
    }

    @Override
    public String getSql() {
        return " where program_id=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(programId);
    }



}

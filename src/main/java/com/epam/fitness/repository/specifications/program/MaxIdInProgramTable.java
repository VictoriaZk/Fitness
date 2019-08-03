package com.epam.fitness.repository.specifications.program;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Collections;
import java.util.List;

/**
 * The type Max id in program table.
 */
public class MaxIdInProgramTable implements SqlSpecification {
    @Override
    public String getSql() {
        return " order by(id_program) desc limit 1";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}

package com.epam.fitness.repository;

import com.epam.fitness.builder.ProgramBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Program;
import com.epam.fitness.repository.database.constants.ProgramTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class is an implementation of {@link AbstractRepository} to access to program database and provides methods to work with it.
 */
public class ProgramRepository extends AbstractRepository<Program> {

    private static final String TABLE_NAME = "program";

    /**
     * Instantiates a new Program repository.
     *
     * @param connection the connection
     */
    public ProgramRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<Program> query(SqlSpecification specification) throws RepositoryException {
        String query = "select * from program " + specification.getSql();
        List<Program> programs = executeQuery(query,new ProgramBuilder(), specification.getParameters());
        return programs;
    }

    @Override
    public Optional<Program> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<Program> program = query(specification);
        return program.size() == 1 ?
                Optional.of(program.get(0)) :
                Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Program program) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(ProgramTableConstants.ID.getFieldName(),program.getId());
        fields.put(ProgramTableConstants.NUTRITION_ID.getFieldName(),program.getNutritionId());
        fields.put(ProgramTableConstants.TRAINS_PER_WEEK.getFieldName(),program.getTrainsPerWeek());
        return fields;
    }


}

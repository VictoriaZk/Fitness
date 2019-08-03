package com.epam.fitness.repository;

import com.epam.fitness.builder.ExerciseBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Exercise;
import com.epam.fitness.repository.database.constants.ExerciseTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class is an implementation of {@link AbstractRepository} to access to exercise database and provides methods to work with it.
 */
public class ExerciseRepository extends AbstractRepository<Exercise> {

    private static final String TABLE_NAME = "exercise";

    /**
     * Instantiates a new Exercise repository.
     *
     * @param connection the connection
     */
    public ExerciseRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<Exercise> query(SqlSpecification specification) throws RepositoryException {
        String query = "select * from exercise " + specification.getSql();
        List<Exercise> exercises = executeQuery(query,new ExerciseBuilder(), specification.getParameters());
        return exercises;
    }

    @Override
    public Optional<Exercise> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<Exercise> exercise = query(specification);
        return exercise.size() == 1 ?
                Optional.of(exercise.get(0)) :
                Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Exercise exercise) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(ExerciseTableConstants.ID.getFieldName(),exercise.getId());
        fields.put(ExerciseTableConstants.NAME.getFieldName(),exercise.getName());
        fields.put(ExerciseTableConstants.DESCRIPTION.getFieldName(),exercise.getDescription());
        fields.put(ExerciseTableConstants.IMAGE.getFieldName(),exercise.getImage());
        return fields;
    }
}

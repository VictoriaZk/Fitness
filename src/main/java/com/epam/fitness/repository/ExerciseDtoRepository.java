package com.epam.fitness.repository;

import com.epam.fitness.builder.ExerciseDtoBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.repository.database.constants.ExerciseDtoTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.*;

/**
 * Class is an implementation of {@link AbstractRepository} to access to exercise_program database and provides methods to work with it.
 */
public class ExerciseDtoRepository extends AbstractRepository<ExerciseDto> {

    private final static String TABLE_NAME = "exercise_program";

    /**
     * Instantiates a new Exercise dto repository.
     *
     * @param connection the connection
     */
    public ExerciseDtoRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<ExerciseDto> query(SqlSpecification specification) throws RepositoryException {
        String query = "select * from exercise " + specification.getSql();
        return executeQuery(query,new ExerciseDtoBuilder(), specification.getParameters());
    }

    @Override
    public Optional<ExerciseDto> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<ExerciseDto> exercise = query(specification);
        return exercise.size() == 1 ?
                Optional.of(exercise.get(0)) :
                Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(ExerciseDto exerciseDto) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(ExerciseDtoTableConstants.ID.getFieldName(),exerciseDto.getId());
        fields.put(ExerciseDtoTableConstants.PROGRAM_ID.getFieldName(),exerciseDto.getProgramId());
        fields.put(ExerciseDtoTableConstants.EXERCISE_ID.getFieldName(),exerciseDto.getExercise().getId());
        fields.put(ExerciseDtoTableConstants.REPEAT_NUMBER.getFieldName(),exerciseDto.getRepeatNumber());
        fields.put(ExerciseDtoTableConstants.SET_NUMBER.getFieldName(),exerciseDto.getSetNumber());
        fields.put(ExerciseDtoTableConstants.NUMBER_TRAIN_DAY.getFieldName(),exerciseDto.getNumberTrainDay());
        return fields;
    }

    /**
     * Delete long.
     *
     * @param exerciseDtoId the exercise dto id
     * @return the long
     * @throws RepositoryException the repository exception
     */
    public Long delete(long exerciseDtoId) throws RepositoryException {
        return executeUpdate(DELETE_QUERY,Arrays.asList(exerciseDtoId));
    }
}

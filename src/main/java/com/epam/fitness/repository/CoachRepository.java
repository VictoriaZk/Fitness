package com.epam.fitness.repository;

import com.epam.fitness.builder.CoachBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Coach;
import com.epam.fitness.repository.database.constants.CoachTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class is an implementation of {@link AbstractRepository} to access to coach database and provides methods to work with it.
 */
public class CoachRepository extends AbstractRepository<Coach> {

    private static final String TABLE_NAME = "coach";

    /**
     * Instantiates a new Coach repository.
     *
     * @param connection the connection
     */
    public CoachRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public List<Coach> query(SqlSpecification specification) throws RepositoryException {
        String query = "select * from coach " + specification.getSql();
        List<Coach> coaches = executeQuery(query,new CoachBuilder(), specification.getParameters());
        return coaches;
    }

    @Override
    public Optional<Coach> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<Coach> coach = query(specification);
        return coach.size() == 1 ?
                Optional.of(coach.get(0)) :
                Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Coach coach) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(CoachTableConstants.ID.getFieldName(),coach.getId());
        fields.put(CoachTableConstants.NAME.getFieldName(),coach.getName());
        fields.put(CoachTableConstants.SURNAME.getFieldName(),coach.getSurname());
        fields.put(CoachTableConstants.LOGIN.getFieldName(),coach.getLogin());
        fields.put(CoachTableConstants.PASSWORD.getFieldName(),coach.getPassword());
        return fields;
    }



}

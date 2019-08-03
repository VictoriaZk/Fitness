package com.epam.fitness.repository;

import com.epam.fitness.builder.NutritionBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Nutrition;
import com.epam.fitness.repository.database.constants.NutritionTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class is an implementation of {@link AbstractRepository} to access to nutrition database and provides methods to work with it.
 */
public class NutritionRepository extends AbstractRepository<Nutrition> {

    private static final String TABLE_NAME = "nutrition";

    /**
     * Instantiates a new Nutrition repository.
     *
     * @param connection the connection
     */
    public NutritionRepository(Connection connection) { super(connection); }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<Nutrition> query(SqlSpecification specification) throws RepositoryException {
        String query = "select * from nutrition " + specification.getSql();
        List<Nutrition> nutrition = executeQuery(query,new NutritionBuilder(), specification.getParameters());
        return nutrition;
    }

    @Override
    public Optional<Nutrition> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<Nutrition> nutrition = query(specification);
        return nutrition.size() == 1 ?
                Optional.of(nutrition.get(0)) :
                Optional.empty();
    }


    @Override
    protected Map<String, Object> getFields(Nutrition nutrition) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(NutritionTableConstants.ID.getFieldName(),nutrition.getId());
        fields.put(NutritionTableConstants.NAME.getFieldName(),nutrition.getName());
        fields.put(NutritionTableConstants.MORNING_NUTRITION.getFieldName(),nutrition.getMorningNutrition());
        fields.put(NutritionTableConstants.LUNCH_NUTRITION.getFieldName(),nutrition.getLunchNutrition());
        fields.put(NutritionTableConstants.DINNER_NUTRITION.getFieldName(),nutrition.getDinnerNutrition());
        return fields;
    }

}

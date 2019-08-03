package com.epam.fitness.repository.specifications.nutrition;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Nutrition by client id.
 */
public class NutritionByClientId implements SqlSpecification {

    private Long clientId;

    /**
     * Instantiates a new Nutrition by client id.
     *
     * @param clientId the client id
     */
    public NutritionByClientId(Long clientId){
        this.clientId = clientId;
    }

    @Override
    public String getSql() {
        return " join program on nutrition.id_nutrition=program.nutrition_id join client " +
                "on client.program_id = program.id_program where id_client = (?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(clientId);
    }
}

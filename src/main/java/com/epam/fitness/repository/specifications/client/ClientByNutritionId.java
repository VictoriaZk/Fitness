package com.epam.fitness.repository.specifications.client;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Client by nutrition id.
 */
public class ClientByNutritionId implements SqlSpecification {

    private Long nutritionId;

    /**
     * Instantiates a new Client by nutrition id.
     *
     * @param nutritionId the nutrition id
     */
    public ClientByNutritionId(Long nutritionId) {
        this.nutritionId = nutritionId;
    }

    @Override
    public String getSql() {
        return "  left join program on client.program_id=program.id_program where nutrition_id = (?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(nutritionId);
    }



}

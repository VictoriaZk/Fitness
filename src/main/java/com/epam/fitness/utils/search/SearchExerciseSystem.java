package com.epam.fitness.utils.search;

import com.epam.fitness.model.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Designed To find exercises that match search query
 */
public class SearchExerciseSystem implements SearchSystem<Exercise> {


    public List<Exercise> findItemsAppropriateToSearchArgument(List<Exercise> exercisesToCheck, String searchArgument){
        List<Exercise> finalListExercise = new ArrayList<>();
        for(Exercise exercise : exercisesToCheck){
            if(exerciseToLowerCase(exercise).contains(searchArgument.toLowerCase())){
                finalListExercise.add(exercise);
            }
        }
        return finalListExercise;
    }

    private String exerciseToLowerCase(Exercise exercise){
        String exerciseStringName = exercise.getName();
        return exerciseStringName.toLowerCase();
    }
}

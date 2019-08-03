package com.epam.fitness.utils.json;

import com.epam.fitness.model.Exercise;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.List;

/**
 * Designed to convert {@link Exercise} to JSON format
 */
public class JsonExerciseCreator implements JsonCreator<Exercise> {
    public String makeJSON(List<Exercise> exercises){
        JSONObject mainObject = new JSONObject();
        JSONArray exerciseArray = new JSONArray();
        for(Exercise exercise : exercises) {
            JSONObject object = new JSONObject();
            object.put("id",exercise.getId());
            object.put("name",exercise.getName());
            object.put("description",exercise.getDescription());
            object.put("image",exercise.getImage());
            exerciseArray.add(object);
        }
        mainObject.put("exercises",exerciseArray);
        return mainObject.toJSONString();
    }

}

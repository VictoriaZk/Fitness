package com.epam.fitness.utils;

import com.epam.fitness.repository.helper.QueryHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Designed to prepare {@link PreparedStatement} with parameters
 */
public class StatementUtil {
    /**
     * Prepare.
     *
     * @param preparedStatement the prepared statement
     * @param parameters        the parameters
     * @throws SQLException the sql exception
     */

    public static void prepare(PreparedStatement preparedStatement, List<Object> parameters) throws SQLException {
        int length = parameters.size();
        for (int i = 0; i < length; i++) {
            if (parameters.get(i) == null) {
                preparedStatement.setNull(i + 1, getType(parameters.get(i)));
            } else {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
        }
    }

    /**
     * Prepare.
     *
     * @param preparedStatement the prepared statement
     * @param fields            the fields
     * @param tableName         the table name
     * @throws SQLException the sql exception
     */
    public static void prepare(PreparedStatement preparedStatement, Map<String,Object> fields, String tableName) throws SQLException {
        int i = 1;
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (!key.equals(QueryHelper.ID + "_" + tableName)) {
                if (value == null) {
                    preparedStatement.setNull(i++, getType(value));
                } else {
                    preparedStatement.setString(i++, String.valueOf(value));
                }
            }
        }
        Object id = fields.get(QueryHelper.ID + "_" + tableName);
        if (id != null) {
            preparedStatement.setString(i++, String.valueOf(id));
        }
    }

    private static Integer getType(Object object){
        if(object instanceof Integer){
            return java.sql.Types.INTEGER;
        }
        if (object instanceof Float){
            return java.sql.Types.FLOAT;
        }
        if(object instanceof String){
            return java.sql.Types.VARCHAR;
        }
        else{
            return java.sql.Types.NULL;
        }
    }

}

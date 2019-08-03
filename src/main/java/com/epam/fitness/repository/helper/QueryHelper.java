package com.epam.fitness.repository.helper;

import java.util.Map;

/**
 * Designed to prepare insert and update query
 */
public class QueryHelper {
    private static final String INSERT_QUERY = "INSERT INTO ";
    private static final String VALUES = "VALUES";
    private static final String UPDATE_QUERY = "UPDATE ";
    private static final String SET = " SET ";
    /**
     * The constant ID.
     */
    public static final String ID = "id";

    /**
     * Make insert query string.
     *
     * @param fields the fields
     * @param table  the table
     * @return the string
     */
    public static String makeInsertQuery(Map<String, Object> fields, String table) {
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");

        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            if (column.equals(ID  + "_" + table)) {
                continue;
            }
            columns.append(column).append(", ");
            values.append("?, ");
        }

        values.deleteCharAt(values.lastIndexOf(","));
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.append(")");
        columns.append(")");

        return INSERT_QUERY + table + columns + VALUES + values + ";";
    }

    /**
     * Make update query string.
     *
     * @param fields the fields
     * @param table  the table
     * @return the string
     */
    public static String makeUpdateQuery(Map<String, Object> fields, String table) {
        StringBuilder where = new StringBuilder();
        StringBuilder set = new StringBuilder();
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            if (column.equals(ID + "_" + table)) {
                where.append(" WHERE " + ID + "_" + table + "=?");
            } else {
                set.append(" ").append(column).append("=?,");
            }
        }
        int lastIndexOfComma = set.lastIndexOf(",");
        set.deleteCharAt(lastIndexOfComma);
        return UPDATE_QUERY + table + SET + set + where + ";";
    }


}

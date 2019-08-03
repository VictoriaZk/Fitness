package com.epam.fitness.repository.creator;


import com.epam.fitness.connection.ConnectionPool;
import com.epam.fitness.repository.*;

import java.sql.Connection;

/**
 * Provides {@link AutoCloseable} creator of repository implementation class with connection to database for each.
 */
public class RepositoryCreator implements AutoCloseable {
    private ConnectionPool connectionPool;
    private Connection connection;

    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    /**
     *
     * @return an {@link ClientRepository} object with connection to database.
     */
    public ClientRepository getClientRepository() {
        return new ClientRepository(connection);
    }

    /**
     *
     * @return an {@link CoachRepository} object with connection to database.
     */
    public CoachRepository getCoachRepository() {
        return new CoachRepository(connection);
    }

    /**
     *
     * @return an {@link OrderInformationRepository} object with connection to database.
     */
    public OrderInformationRepository getOrderInformationRepository() {
        return new OrderInformationRepository(connection);
    }
    /**
     *
     * @return an {@link ProgramRepository} object with connection to database.
     */
    public ProgramRepository getProgramRepository(){
        return new ProgramRepository(connection);
    }
    /**
     *
     * @return an {@link ExerciseRepository} object with connection to database.
     */
    public ExerciseRepository getExerciseRepository(){
        return new ExerciseRepository(connection);
    }
    /**
     *
     * @return an {@link ExerciseDtoRepository} object with connection to database.
     */
    public ExerciseDtoRepository getExerciseDtoRepository(){ return  new ExerciseDtoRepository(connection);}
    /**
     *
     * @return an {@link NutritionRepository} object with connection to database.
     */
    public NutritionRepository getNutritionRepository(){ return  new NutritionRepository(connection);}
    /**
     *
     * @return an {@link CommentRepository} object with connection to database.
     */
    public CommentRepository getCommentRepository(){ return  new CommentRepository(connection);}

    @Override
    public void close() {
        connectionPool.releaseConnection(connection);
    }
}

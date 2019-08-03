package com.epam.fitness.repository;

import com.epam.fitness.builder.CommentBuilder;
import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Comment;
import com.epam.fitness.repository.database.constants.CommentTableConstants;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Class is an implementation of {@link AbstractRepository} to access to comment database and provides methods to work with it.
 */
public class CommentRepository extends AbstractRepository<Comment> {

    private static final String TABLE_NAME = "comment";

    /**
     * Instantiates a new Comment repository.
     *
     * @param connection the connection
     */
    public CommentRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<Comment> query(SqlSpecification specification) throws RepositoryException{
        String query = "select * from comment " + specification.getSql();
        return executeQuery(query,new CommentBuilder(), specification.getParameters());
    }

    @Override
    public Optional<Comment> queryForSingleResult(SqlSpecification specification) throws RepositoryException {
        List<Comment> comment = query(specification);
        return comment.size() == 1 ?
                Optional.of(comment.get(0)) :
                Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Comment comment) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(CommentTableConstants.ID.getFieldName(),comment.getId());
        fields.put(CommentTableConstants.CLIENT_ID.getFieldName(),comment.getClientId());
        fields.put(CommentTableConstants.COACH_ID.getFieldName(),comment.getCoachId());
        fields.put(CommentTableConstants.COMMENT_CONTENT.getFieldName(),comment.getCommentContent());
        return fields;
    }
}

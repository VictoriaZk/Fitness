package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Comment;
import com.epam.fitness.repository.CommentRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.SqlSpecification;
import com.epam.fitness.repository.specifications.comment.CommentByCoachId;

import java.util.List;
import java.util.Optional;

/**
 * Class provides methods to work with {@link Comment} objects.
 */
public class CommentService {

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Comment> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CommentRepository commentRepository = repositoryCreator.getCommentRepository();
            return commentRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param comment the comment
     * @throws ServiceException the service exception
     */
    public void save(Comment comment) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CommentRepository commentRepository = repositoryCreator.getCommentRepository();
            commentRepository.save(comment);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by coach id list.
     *
     * @param coachId the coach id
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Comment> findByCoachId(long coachId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CommentRepository commentRepository = repositoryCreator.getCommentRepository();
            SqlSpecification specification = new CommentByCoachId(coachId);
            return commentRepository.query(specification);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}

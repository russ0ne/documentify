package documentify.dao;

import java.util.List;

import documentify.model.Submission;
import documentify.model.User;

public interface SubmissionDao extends Dao<Submission,Integer> {
    public Submission findByEmail(String email, User user);
    public List<Submission> findByName(String startsWith, User user);
}

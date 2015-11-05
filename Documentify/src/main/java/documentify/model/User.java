package documentify.model;

import javax.persistence.Entity;

/**
 *
 * @author Russ
 */
@Entity
public class User extends EntityBase {

    private String userName;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;
    }
    
    
}

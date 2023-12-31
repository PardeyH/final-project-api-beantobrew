package test.server.demo.user;

import jakarta.persistence.*;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "userName" }) })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String userName;
    private String password;
    private boolean active;
    private String roles;


    @Column(name = "current_score")
    private Integer currentScore;
    @Column(name = "correctness_percentage")
    private Integer correctnessPercentage;

    public User() {
        // Per default every user receivers normal rights
        // Make sure that you prefix with ROLE_
        // Add ",ROLE_ADMIN" for additional admin rights
        this.roles = "ROLE_USER";
        // Per default each user is active
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public Integer getCorrectnessPercentage() {
        return correctnessPercentage;
    }

    public void setCorrectnessPercentage(Integer correctnessPercentage) {
        this.correctnessPercentage = correctnessPercentage;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }
}

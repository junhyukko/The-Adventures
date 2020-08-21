package com.game.lesavantures.Main;

import com.google.firebase.auth.FirebaseUser;

public class User {

    /**
     * Reference to the user's statistics object, which contains all statistics necessary for the scoreboard.
     */
    private UserStatistics userStatistics;

    /**
     * Reference to the Firebase user object, which contains much of the user's information.
     */
    private FirebaseUser firebaseUser;

    public User() {
        this.userStatistics = new UserStatistics();
    }

    public User(FirebaseUser firebaseUser) {
        this.userStatistics = new UserStatistics();
        this.firebaseUser = firebaseUser;

        // retrieve user statistics
        String id = this.getId();
        GameManager.statisticsManager.getUserStatisticsByUserId(id);
    }

    /**
     * @return the user's Firebase UID, used throughout the app and the database.
     */
    public String getId() {
        return firebaseUser.getUid();
    }

    /**
     * @return get the user's display name as is currently stored in the database. Returns the UID in case the displayName is null.
     */
    public String getDisplayName() {
        return firebaseUser.getDisplayName() + "";
    }

    public void setLevelStatistics(LevelStatistics levelStatistics) {
        this.userStatistics.setLevelStatistics(levelStatistics);
    }

    /**
     * @return the user's statistics object.
     */
    public UserStatistics getUserStatistics() {
        return this.userStatistics;
    }

    public void setUserStatistics(UserStatistics userStatistics) {
        this.userStatistics = userStatistics;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }
}

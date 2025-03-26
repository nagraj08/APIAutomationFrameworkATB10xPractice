package in.co.courage.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("id")
    @Expose(serialize = false, deserialize = true) // Exclude from request, include in response
    private String id;

    @SerializedName("createdAt")
    @Expose(serialize = false, deserialize = true) // Exclude from request, include in response
    private String createdAt;

    // Default Constructor
    public User() {}

    // Constructor for creating a user
    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}


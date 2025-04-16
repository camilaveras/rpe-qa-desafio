package br.com.rpe.dto;

public class UserDTO {
    private String name;
    private String job;

    public UserDTO() {}

    public UserDTO(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "UserDTO{name='" + name + "', job='" + job + "'}";
    }
}

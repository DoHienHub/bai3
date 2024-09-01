package iuh.fit.se;

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }

        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%5d %-10s", id, title, credit, department);
    }
}

package entity;

/**
 * Created by icons on 9.4.17.
 */
public class Review {
    private long id;
    private String text;
    private Movie movie;
    private User user;

    public Review(String text, Movie movie) {
        this.text = text;
        this.movie = movie;
    }

    public Review(long id, String text, User user, Movie movie) {
        this.id = id;
        this.text = text;
        this.movie = movie;
        this.user = user;
    }

    public Review(long id, String text, Movie movie) {
        this.id = id;
        this.text = text;
        this.movie = movie;
    }

    public Review(String text, User user, Movie movie) {
        this.text = text;
        this.movie = movie;
        this.user = user;
    }

    public Review(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Review(long id, String text) {
        this.id = id;
        this.text = text;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        return text.equals(review.text);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", movie=" + movie +
                ", user=" + user +
                '}';
    }
}


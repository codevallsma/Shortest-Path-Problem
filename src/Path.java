public class Path {
    private float distance;
    String point;

    public Path(float distance, String point) {
        this.distance = distance;
        this.point = point;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}

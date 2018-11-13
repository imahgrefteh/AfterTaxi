package hello;

import org.springframework.web.bind.annotation.RequestParam;

public class Position {

    private Double startLat;
    private Double startLag;
    private Double endLat;
    private Double endLag;

    public Position(Double startLat, Double startLag, Double endLat, Double endLag) {
        this.startLat = startLat;
        this.startLag = startLag;
        this.endLat = endLat;
        this.endLag = endLag;
    }

    public Position() {
    }

    public Double getStartLat() {
        return startLat;
    }

    public void setStartLat(Double startLat) {
        this.startLat = startLat;
    }

    public Double getStartLag() {
        return startLag;
    }

    public void setStartLag(Double startLag) {
        this.startLag = startLag;
    }

    public Double getEndLat() {
        return endLat;
    }

    public void setEndLat(Double endLat) {
        this.endLat = endLat;
    }

    public Double getEndLag() {
        return endLag;
    }

    public void setEndLag(Double endLag) {
        this.endLag = endLag;
    }
}

package baza.arerere.bazadatabaza;

public class BazaItem {

    private int imageResource;
    private String title;
    private String lake;
    private String distance;
    private String price;
    private String description;

    public BazaItem(int imageResource, String title, String lake, String distance, String price, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.lake = lake;
        this.distance = distance;
        this.price = price;
        this.description = description;
    }

    public BazaItem() {
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getLake() {
        return lake;
    }
}

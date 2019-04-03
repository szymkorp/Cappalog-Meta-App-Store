import java.util.ArrayList;
import java.util.Map;

public class APP {
    //===============================properties
    private String name, developer, link, description, platform;
    private double price;
    private Map<User, ArrayList<String>> comments;
    //===============================constructors
    public APP(String name, String developer, String link, String description, String platform, double price, Map<User, ArrayList<String>> comments) {
        this.name = name;
        this.developer = developer;
        this.link = link;
        this.description = description;
        this.platform = platform;
        this.price = price;
        this.comments = null;
    }

    //===============================getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<User, ArrayList<String>> getComments() {
        return comments;
    }

    public void setComments(Map<User, ArrayList<String>> comments) {
        this.comments = comments;
    }
}

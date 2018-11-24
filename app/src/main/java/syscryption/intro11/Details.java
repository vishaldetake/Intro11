package syscryption.intro11;

/**
 * Created by Nilima on 06-10-2018.
 */

public class Details {
    private String title;
    private String desc;
    private String image;
    private String long_desc;
    private String date;

    public Details(String title, String desc,String image,String long_desc,String date) {

        this.title = title;
        this.desc = desc;
        this.image = image;
        this.long_desc = long_desc;
        this.date=date;
    }


    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public String getDate() {
        return date;
    }

}
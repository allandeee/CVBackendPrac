import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Video {
    private String name;
    private int duration;
    private String desc;
    private String dateCreated;
    private int id;
    private String thumb;
    private String folder;  // folder path
    private String[] tags;    // will be handled accordingly in getter

    public Video (String name, int duration, String desc,
                 String dateCreated, int id, String thumb,
                 String folder, String[] tags) {
        this.name = name;
        this.duration = duration;
        this.desc = desc;
        this.dateCreated = dateCreated;
        this.id = id;
        this.thumb = thumb;
        this.folder = folder;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", description=" + desc + '\'' +
                ", dateCreated=" + dateCreated + '\'' +
                ", id=" + id + '\'' +
                ", thumbnail=" + thumb + '\'' +
                ", folder=" + folder + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}

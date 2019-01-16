import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.InputStream;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Video> parseJSONVideos (JSONArray jsonArr) {

        ArrayList<Video> allVideos = new ArrayList<Video>();

        for (int i=0; i<jsonArr.length(); i++) {
            JSONObject json = jsonArr.getJSONObject(i);
            String [] tags = new String [json.getJSONArray("tags").length()];
            for (int j=0; j<json.getJSONArray("tags").length(); j++ ) {
                tags[j] = json.getJSONArray("tags").getString(j).toLowerCase();
            }
            allVideos.add(new Video(
                    json.getString("name"),
                    json.getInt("duration"),
                    json.getString("description"),
                    json.getString("dateCreated"),
                    json.getInt("id"),
                    json.getString("thumbnail"),
                    json.getString("folder"),
                    tags
            ));
        }

        return allVideos;
    }

    public static void main (String [] args) {

        ArrayList<Video> allVideos;

//        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);

        try {
            InputStream is = Main.class.getResourceAsStream("videos.json");
            String jsonTxt = IOUtils.toString( is );
            JSONArray jsonArr = new JSONArray(jsonTxt);

            allVideos = parseJSONVideos(jsonArr);

            for (int i=0; i<allVideos.size(); i++) {
                System.out.println(allVideos.get(i));
            }

//            sc.parallelize(jsonArr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

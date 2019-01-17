import java.util.HashMap;

public class VideoMaker {

    private Directory root_dir = new Directory(new Folder("root"));

    public Video createNewVideo (String name, int duration, String desc,
                     String dateCreated, int id, String thumb,
                     String folder, String[] tags) {
        Video video = new Video(name, duration, desc, dateCreated,
                id, thumb, folder, tags);
        root_dir.addVideoToPath(video, folder);
        return video;
    }

    public HashMap<Integer, Video> retrieveAllVideos () {
        return root_dir.getAllVideos();
    }

    public void updateVideo (int id, Video video) {
        root_dir.updateVideoFromPath(id, video);
    }

    public void deleteVideo (int id, Video video) {
        root_dir.deleteVideoFromPath(id, video);
    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Directory {

    private Folder root;

    public Directory (Folder root) {
        this.root = root;
    }

    public Folder findDirPath (String path) {
        String [] folderPath = path.split("->");
        return root.goToFolder(folderPath);
    }

    public void addVideoToPath (Video video, String path) {
        Folder folder = findDirPath(path);
        folder.addVideo(video);
    }

    public HashMap<Integer, Video> getAllVideos () {
        HashMap<Integer, Video> allVideos = new HashMap<Integer, Video>();
        allVideos.putAll(root.getVideos());
        for (HashMap.Entry<String, Folder> entry : root.getSubfolders().entrySet()) {
            allVideos.putAll(entry.getValue().getVideos());
        }
        return allVideos;
    }

    public void updateVideoFromPath (int id, Video video) {
        Folder folder = findDirPath(video.getFolder());
        folder.replaceVideo(id, video);
    }

    public void deleteVideoFromPath (int id, Video video) {
        Folder folder = findDirPath(video.getFolder());
        folder.deleteVideo(id);
    }

}

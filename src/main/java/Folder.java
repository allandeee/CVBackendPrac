import java.util.ArrayList;
import java.util.HashMap;

public class Folder {

    private String name;
    private HashMap<String, Folder> subfolders;
    private HashMap<Integer, Video> videos;

    public Folder (String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public HashMap<String, Folder> getSubfolders() {
        return subfolders;
    }

    public HashMap<Integer, Video> getVideos() {
        return videos;
    }

    public void addFolder (Folder folder) {
        subfolders.put(folder.getName(), folder);
    }

    public void addVideo (Video video) {
        videos.put(video.getId(), video);
    }

    public void replaceVideo (int id, Video video) {
        videos.put(id, video);
    }

    public void deleteVideo (int id) {

    }

    // assumption: uses video ID to identify video
    public boolean containsVideo (int videoId) {
        return videos.containsKey(videoId);
    }

    // similarly, folderName is used to identify folder
    public Folder getFolder (String folderName) {
        if (!subfolders.containsKey(folderName)) {
            return null;    // may be replaced with creating the folder and returning new folder
        }
        return subfolders.get(folderName);
    }

    public Folder goToFolder (String [] path) {
        Folder currFolder = this;
        for (String folder : path) {
            Folder next = currFolder.getFolder(folder);
            if (next == null) {
                Folder newFolder = new Folder(folder);
                currFolder.addFolder(newFolder);
                next = newFolder;
            }
            currFolder = next;
        }
        return currFolder;
    }

}

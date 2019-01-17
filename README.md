# CVBackendPrac
Programming Practical for ClickView (Backend)

## Preface
Unfortunately, I was not able to complete much of the server related functionality for this project, due to my limited experience. Instead I decided to focus on the logic and structure of the Video, Folder, and Directory objects. Therefore, the project and resulting JAR focuses on those functionalities.

The following will go through certain steps to utilising the JAR, and also the rationales behind certain design choices.

## How to use the JAR
### Build the JAR from the src project
The JAR can be built following which ever process you're comfortable with. I was using Intellij IDEA, so I was following steps found [here](https://blog.jetbrains.com/idea/2010/08/quickly-create-jar-artifact/).

### Otherwise, looking at the tasks
#### Task 2: Read videos.json
As mentioned above, no web server functionality was implemented, but considerations are made below.

As for the logic, this can be found in the Main.java class. The main challenge here was parsing the JSON file and storing it into the data structure `allVideos`.

#### Task 3: CRUD API
This is where the majority of my time was spent - constructing the objects `Video`, `Folder`, and `Directory`, and exposing it through the `VideoMaker` class.

`Video` contains the data required for a video. `Folder` houses subfolders of object type `Folder` and also videos of object type `Video`. The `Directory` is used to keep track of the `root` folder, providing a Tree-like structure. For obvious reasons, this was to replicate the folder/directory structure for Task 5.



## Considerations
As mentioned previously, it would have been ideal to implement the web server in order to test this functionality.

The other important consideration here was to ensure methods were **synchronized**, due to the multi-threaded nature of web applications. One of the considerations regarding this is related to the use of **HashMaps** - since this data structure is not synchronized, it would be best to utilise the **ConcurrentHashMap** data structure instead.

Task 6 implmentation is another feature I was not able to complete. But I have provided in-code comments overviewing my approach.

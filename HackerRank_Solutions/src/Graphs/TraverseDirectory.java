package Graphs;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/*
    Traverse given directory and list out all files in it and its sub directories
 */
public class TraverseDirectory {

    public static void main(String[] args) {

        //root directory
        String rootDir = "C:\\Users";

        //since its BFS so think about a queue and you are adding stuff in it
        // create queue and enqueue the root directory
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(rootDir));

        //loop until queue is empty
        while (!queue.isEmpty()) {
            //get next file/dirctory from queue
            File current = queue.poll();

            //get list of files
            File[] listOfFiles = current.listFiles();

            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    //add back in queue
                    queue.add(file);
                }else {
                    System.out.println("file = " + file);
                }
            }
        }



    }
}

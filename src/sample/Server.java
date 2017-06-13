package sample;

import com.sun.javaws.exceptions.ExitException;

import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.net.*;

/**
 * Created by Arash on 17/06/13.
 */


class Profile implements Serializable, Comparable {
    private String username, password;
    private Image profilePicture;
    private ArrayList<Post> posts;
    private ArrayList<Profile> followers, following;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }


    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        following = new ArrayList<>();

    }

    @Override
    public int compareTo(Object o) {
        Profile tmp = (Profile) o;
        if (this.username.equals(tmp.username))
            return 0;
        else if (this.username.compareTo(tmp.username) > 0)
            return 1;
        else
            return -1;
    }
}


class Post implements Serializable, Comparable {
    private Date date;
    private Image image;
    private String caption;
    private ArrayList<Profile> likes;
    private Map<Profile, String> comments;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Post(Image image, String caption) {
        this.image = image;
        this.caption = caption;
        likes = new ArrayList<>();
        comments = new HashMap<>();
    }

    @Override
    public int compareTo(Object o) {
        Post tmp = (Post) o;
        if (this.date.equals(tmp.date))
            return 0;
        else if (this.date.compareTo(tmp.date) > 0)
            return 1;
        else
            return -1;
    }
}



class Comment implements Serializable, Comparable{
    Profile owner;
    String comment;
    Date date;


    public Comment(Profile owner, String comment, Date date) {
        this.owner = owner;
        this.comment = comment;
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        Comment tmp = (Comment) o;
        if (this.date == tmp.date)
            return 0;
        else if (this.date.compareTo(tmp.date) > 0)
            return 1;
        else
            return -1;
    }

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


class workerThread extends Thread {
    protected Socket client = null;

    public workerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

    }
}


public class Server {

//    protected int port = 8080;
//    protected ServerSocket serverSocket = null;
//    protected boolean hasStopped = false;
//    protected Thread thread = null;
//
//    private synchronized boolean hasStopped() {
//        return this.hasStopped;
//    }
//
//    public Server(int port) {
//        this.port = port;
//    }
//
//    public void openServer() {
//        try {
//            serverSocket = new ServerSocket(this.port);
//        } catch (Exception e) {
//            System.out.println("Unable to ope a server!");
//        }
//    }
//    public synchronized void stop(){
//        this.hasStopped = true;
//        try {
//            this.serverSocket.close();
//        }
//        catch (Exception e){
//            throw new RuntimeException("Server can't be stopped", e);
//        }
//    }
//
//
//    @Override
//    public void run() {
//        synchronized (this) {
//            this.thread = Thread.currentThread();
//        }
//        openServer();
//        while (!hasStopped()) {
//            Socket clientSocket = null;
//            try {
//                clientSocket = this.serverSocket.accept();
//            } catch (Exception e) {
//                if (hasStopped()) {
//                    System.out.println("Server has stopped");
//                    return;
//                }
//                throw new RuntimeException("Client Can't be connected", e);
//            }
//            new Thread(new workerThread(clientSocket)).start();
//        }
//        System.out.println("Server has stopped");
//    }
//
//
//

    public boolean signIn(String username, String password){
        return true;
    }




    public static void main(String[] args) throws IOException, ClassNotFoundException {





        ArrayList<Socket> sockets = new ArrayList<>();
        ObjectInputStream ois = null;

        ServerSocket serverSocket = null;
        Socket client  = null;

        try {
            serverSocket = new ServerSocket(2222);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        while (!Thread.interrupted()){
            try {
                client = serverSocket.accept();
                sockets.add(client);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            new workerThread(client).start();

        }


    }

}

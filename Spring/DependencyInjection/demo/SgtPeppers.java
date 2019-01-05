package demo;

import org.springframework.stereotype.Component;

/*
Component
Indicates that an annotated class is a "component".
Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
*/
@Component
public class SgtPeppers implements CompactDisc {

    private String title;
    private String artist;

    public SgtPeppers() {
        title = "Sgt. Pepper's Lonely Hearts Club Band";
        artist = "The Beatles";
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
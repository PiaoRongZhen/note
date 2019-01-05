package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
/*
Autowired
Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.

In software engineering, dependency injection is a technique whereby one object (or static method) supplies the dependencies of another object.
A dependency is an object that can be used.
An injection is the passing of a dependency to a dependent object that would use it.
*/
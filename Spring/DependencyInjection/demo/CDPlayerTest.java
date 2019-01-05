package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    // Fields are injected right after construction of a bean, before any config methods are invoked.
    // Such a config field does not have to be public.
    @Autowired
    private MediaPlayer player;

    @Test
    public void play() {
        player.play();
    }

}

package com.treefrogapps.mediasessionplayer;

import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.View.Activity.MainActivity;
import com.treefrogapps.mediasessionplayer.Utils.RuntimePermissions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {





    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        MainActivity mainActivity = new MainActivity();

        try {
            RuntimePermissions.checkPermissions(mainActivity, new String[]{"A"});
            RuntimePermissions.gainPermissions(mainActivity, new String[]{});
        } catch (IllegalArgumentException e){
            fail();
        }


    }
}
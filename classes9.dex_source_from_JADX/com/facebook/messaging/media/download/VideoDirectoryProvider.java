package com.facebook.messaging.media.download;

import android.os.Environment;
import java.io.File;

/* compiled from: mDescription */
public class VideoDirectoryProvider {
    public static File m12204a() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "Messenger/");
    }
}

package com.facebook.messaging.media.download;

import android.os.Environment;
import java.io.File;

/* compiled from: mDobYear */
public class PhotoDirectoryProvider {
    public static File m12203a() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Messenger/");
    }
}

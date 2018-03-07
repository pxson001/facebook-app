package com.facebook.omnistore;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.io.Closeable;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: mBatchSessionMetadataHelper is null */
public class Cursor extends Countable implements Closeable {
    public native void close();

    public native ByteBuffer getBlob();

    public native String getPrimaryKey();

    public native String getSortKey();

    public native boolean step();

    static {
        Prerequisites.ensure();
    }
}

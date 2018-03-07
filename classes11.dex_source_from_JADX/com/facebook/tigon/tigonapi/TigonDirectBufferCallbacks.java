package com.facebook.tigon.tigonapi;

import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: note_id */
public interface TigonDirectBufferCallbacks extends TigonBaseCallbacks {
    @DoNotStrip
    void onBody(ByteBuffer byteBuffer);
}

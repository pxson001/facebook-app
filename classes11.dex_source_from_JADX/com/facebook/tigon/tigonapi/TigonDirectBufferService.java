package com.facebook.tigon.tigonapi;

import com.facebook.tigon.iface.TigonRequest;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: non existent tab tabToShow="%s" syncTabAdded="%s" */
public interface TigonDirectBufferService extends TigonDirectBufferRelease {
    TigonRequestToken mo134a(TigonRequest tigonRequest, TigonBodyProvider tigonBodyProvider, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, Executor executor);

    TigonRequestToken mo135a(TigonRequest tigonRequest, @Nullable ByteBuffer[] byteBufferArr, int i, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, Executor executor);
}

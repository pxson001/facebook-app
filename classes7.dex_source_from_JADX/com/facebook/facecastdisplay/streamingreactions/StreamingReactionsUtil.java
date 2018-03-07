package com.facebook.facecastdisplay.streamingreactions;

import java.lang.ref.SoftReference;
import java.util.Queue;
import javax.annotation.Nullable;

/* compiled from: start() should be called before calling addSamples() */
public class StreamingReactionsUtil {
    @Nullable
    public static <E> E m4123a(Queue<SoftReference<E>> queue) {
        SoftReference softReference = (SoftReference) queue.poll();
        while (softReference != null) {
            if (softReference.get() != null) {
                return softReference.get();
            }
            softReference = (SoftReference) queue.poll();
        }
        return null;
    }
}

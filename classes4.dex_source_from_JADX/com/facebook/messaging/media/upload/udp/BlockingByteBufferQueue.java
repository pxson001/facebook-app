package com.facebook.messaging.media.upload.udp;

import com.facebook.inject.InjectorLike;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: fast_acc */
public class BlockingByteBufferQueue {
    private final BlockingQueue<UDPMessage> f12216a = new LinkedBlockingQueue(250);

    public static BlockingByteBufferQueue m12882a(InjectorLike injectorLike) {
        return new BlockingByteBufferQueue();
    }

    public final void m12884a(Collection<UDPMessage> collection) {
        this.f12216a.drainTo(collection);
    }

    public final void m12883a(UDPMessage uDPMessage) {
        this.f12216a.offer(uDPMessage);
    }

    public final boolean m12885a() {
        return this.f12216a.isEmpty();
    }
}

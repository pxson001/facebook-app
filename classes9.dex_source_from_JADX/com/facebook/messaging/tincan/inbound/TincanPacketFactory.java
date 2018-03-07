package com.facebook.messaging.tincan.inbound;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.messaging.tincan.thrift.ByteBufferBackedInputStream;
import com.facebook.messaging.tincan.thrift.Constants;
import com.facebook.messaging.tincan.thrift.Packet;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.messaging.tincan.thrift.ThriftVersionTooNewException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.google.common.annotations.VisibleForTesting;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: client_create_fail */
public class TincanPacketFactory {
    @VisibleForTesting
    static final int f17971a = Constants.f18117a.intValue();
    private static volatile TincanPacketFactory f17972c;
    private final ThriftUtil f17973b;

    public static com.facebook.messaging.tincan.inbound.TincanPacketFactory m17965a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f17972c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.inbound.TincanPacketFactory.class;
        monitor-enter(r1);
        r0 = f17972c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m17966b(r0);	 Catch:{ all -> 0x0035 }
        f17972c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17972c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.inbound.TincanPacketFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.inbound.TincanPacketFactory");
    }

    private static TincanPacketFactory m17966b(InjectorLike injectorLike) {
        return new TincanPacketFactory(ThriftUtil.a(injectorLike));
    }

    @Inject
    public TincanPacketFactory(ThriftUtil thriftUtil) {
        this.f17973b = thriftUtil;
    }

    public final TincanPacket m17967a(TincanMessage tincanMessage) {
        ByteBuffer byteBuffer = tincanMessage.f18075b;
        byte[] a = this.f17973b.a(byteBuffer.array());
        TincanPacket factory = new Factory();
        TIOStreamTransport tIOStreamTransport = new TIOStreamTransport(new ByteBufferBackedInputStream(byteBuffer));
        try {
            Packet b = Packet.m18092b(factory.a(tIOStreamTransport));
            if (b.version.intValue() > f17971a) {
                throw new ThriftVersionTooNewException(f17971a, b.version.intValue());
            }
            factory = new TincanPacket(tincanMessage.f18074a, b, a);
            return factory;
        } finally {
            tIOStreamTransport.a();
        }
    }
}

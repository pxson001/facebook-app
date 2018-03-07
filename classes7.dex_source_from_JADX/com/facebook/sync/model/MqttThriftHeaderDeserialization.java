package com.facebook.sync.model;

import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.transport.TIOStreamTransport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.inject.Singleton;

@Singleton
/* compiled from: feed_db_cache */
public class MqttThriftHeaderDeserialization {
    private static volatile MqttThriftHeaderDeserialization f14533a;

    /* compiled from: feed_db_cache */
    public class MqttThriftHeaderPayloadWrapper {
        public final MqttThriftHeader f14531a;
        public final int f14532b;

        public MqttThriftHeaderPayloadWrapper(MqttThriftHeader mqttThriftHeader, int i) {
            this.f14531a = mqttThriftHeader;
            this.f14532b = i;
        }
    }

    public static com.facebook.sync.model.MqttThriftHeaderDeserialization m18434a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14533a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.sync.model.MqttThriftHeaderDeserialization.class;
        monitor-enter(r1);
        r0 = f14533a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m18433a();	 Catch:{ all -> 0x0034 }
        f14533a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14533a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.model.MqttThriftHeaderDeserialization.a(com.facebook.inject.InjectorLike):com.facebook.sync.model.MqttThriftHeaderDeserialization");
    }

    private static MqttThriftHeaderDeserialization m18433a() {
        return new MqttThriftHeaderDeserialization();
    }

    public static MqttThriftHeaderPayloadWrapper m18432a(byte[] bArr) {
        Factory factory = new Factory();
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new MqttThriftHeaderPayloadWrapper(MqttThriftHeader.b(factory.a(new TIOStreamTransport(byteArrayInputStream))), bArr.length - byteArrayInputStream.available());
    }
}

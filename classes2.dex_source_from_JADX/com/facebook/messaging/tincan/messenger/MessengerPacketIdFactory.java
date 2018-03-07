package com.facebook.messaging.tincan.messenger;

import com.facebook.common.random.SecureRandomFix;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.database.TincanDbThreadsFetcher;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import java.security.SecureRandom;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logged_in_ */
public class MessengerPacketIdFactory {
    private static final Class<?> f16194a = MessengerPacketIdFactory.class;
    private static volatile MessengerPacketIdFactory f16195f;
    public final SecureRandomFix f16196b;
    public final TincanDbThreadsFetcher f16197c;
    public final ThriftUtil f16198d;
    public SecureRandom f16199e;

    public static com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory m23032a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16195f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory.class;
        monitor-enter(r1);
        r0 = f16195f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m23033b(r0);	 Catch:{ all -> 0x0035 }
        f16195f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16195f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory");
    }

    private static MessengerPacketIdFactory m23033b(InjectorLike injectorLike) {
        return new MessengerPacketIdFactory(SecureRandomFix.m23035a(injectorLike), TincanDbThreadsFetcher.m21906a(injectorLike), ThriftUtil.m21835a(injectorLike));
    }

    @Inject
    public MessengerPacketIdFactory(SecureRandomFix secureRandomFix, TincanDbThreadsFetcher tincanDbThreadsFetcher, ThriftUtil thriftUtil) {
        this.f16196b = secureRandomFix;
        this.f16197c = tincanDbThreadsFetcher;
        this.f16198d = thriftUtil;
    }

    public final byte[] m23034a() {
        byte[] bArr = new byte[32];
        if (this.f16199e == null) {
            this.f16196b.m23042a();
            this.f16199e = new SecureRandom();
        }
        this.f16199e.nextBytes(bArr);
        return bArr;
    }
}

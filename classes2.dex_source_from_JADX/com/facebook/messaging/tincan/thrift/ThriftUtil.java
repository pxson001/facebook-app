package com.facebook.messaging.tincan.thrift;

import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.thrift.TBase;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocolFactory;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.facebook.thrift.transport.TTransport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: mac_address */
public class ThriftUtil implements INeedInit {
    private static final Class<?> f15281a = ThriftUtil.class;
    private static volatile ThriftUtil f15282c;
    private MessageDigest f15283b;

    public static com.facebook.messaging.tincan.thrift.ThriftUtil m21835a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15282c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.thrift.ThriftUtil.class;
        monitor-enter(r1);
        r0 = f15282c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m21834a();	 Catch:{ all -> 0x0034 }
        f15282c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f15282c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.thrift.ThriftUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.thrift.ThriftUtil");
    }

    private static ThriftUtil m21834a() {
        return new ThriftUtil();
    }

    public static <T extends TBase> byte[] m21836a(T t) {
        byte[] bArr = null;
        try {
            TProtocolFactory factory = new Factory();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            t.mo3464a(factory.mo3465a(new TIOStreamTransport(byteArrayOutputStream)));
            bArr = byteArrayOutputStream.toByteArray();
        } catch (TException e) {
            BLog.b(f15281a, e.getMessage(), e);
        }
        return bArr;
    }

    public void init() {
        try {
            this.f15283b = MessageDigest.getInstance("SHA-256");
        } catch (Throwable e) {
            BLog.b(f15281a, e.getMessage(), e);
        }
    }

    public final byte[] m21838a(byte[] bArr) {
        if (this.f15283b != null) {
            return this.f15283b.digest(bArr);
        }
        BLog.b(f15281a, "No SHA256 available");
        return new byte[1];
    }

    @Nullable
    public static Salamander m21837b(byte[] bArr) {
        Throwable e;
        TProtocolFactory factory = new Factory();
        TTransport tIOStreamTransport = new TIOStreamTransport(new ByteArrayInputStream(bArr));
        try {
            Salamander b = Salamander.b(factory.mo3465a(tIOStreamTransport));
            tIOStreamTransport.m31918a();
            return b;
        } catch (TException e2) {
            e = e2;
            try {
                BLog.b(f15281a, e.getMessage(), e);
                return null;
            } finally {
                tIOStreamTransport.m31918a();
            }
        } catch (RuntimeException e3) {
            e = e3;
            BLog.b(f15281a, e.getMessage(), e);
            return null;
        }
    }
}

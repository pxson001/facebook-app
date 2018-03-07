package com.facebook.keyguardtype;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unrecognized FormData part. */
public class KeyguardTypeFromDevicePolicyManagerPasswordType {
    private static final Map<Integer, KeyguardType> f10416a = ImmutableMap.builder().b(Integer.valueOf(262144), KeyguardType.ALPHABETIC).b(Integer.valueOf(131072), KeyguardType.NUMERIC).b(Integer.valueOf(327680), KeyguardType.ALPHANUMERIC).b(Integer.valueOf(65536), KeyguardType.AOSP_NONE).b(Integer.valueOf(32768), KeyguardType.BIOMETRIC_WITH_UNKNOWN_BACKUP).b(Integer.valueOf(393216), KeyguardType.COMPLEX).b(Integer.valueOf(0), KeyguardType.UNSPECIFIED_PROBABLY_OEM_INSECURE).b();
    private static volatile KeyguardTypeFromDevicePolicyManagerPasswordType f10417b;

    public static com.facebook.keyguardtype.KeyguardTypeFromDevicePolicyManagerPasswordType m10822a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10417b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.keyguardtype.KeyguardTypeFromDevicePolicyManagerPasswordType.class;
        monitor-enter(r1);
        r0 = f10417b;	 Catch:{ all -> 0x0039 }
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
        r0 = m10821a();	 Catch:{ all -> 0x0034 }
        f10417b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10417b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.keyguardtype.KeyguardTypeFromDevicePolicyManagerPasswordType.a(com.facebook.inject.InjectorLike):com.facebook.keyguardtype.KeyguardTypeFromDevicePolicyManagerPasswordType");
    }

    private static KeyguardTypeFromDevicePolicyManagerPasswordType m10821a() {
        return new KeyguardTypeFromDevicePolicyManagerPasswordType();
    }
}

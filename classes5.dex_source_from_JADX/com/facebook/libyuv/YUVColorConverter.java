package com.facebook.libyuv;

import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TENNIS */
public class YUVColorConverter {
    private static volatile YUVColorConverter f14217b;
    private final YuvLib f14218a;

    public static com.facebook.libyuv.YUVColorConverter m23557a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14217b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.libyuv.YUVColorConverter.class;
        monitor-enter(r1);
        r0 = f14217b;	 Catch:{ all -> 0x003a }
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
        r0 = m23559b(r0);	 Catch:{ all -> 0x0035 }
        f14217b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14217b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.libyuv.YUVColorConverter.a(com.facebook.inject.InjectorLike):com.facebook.libyuv.YUVColorConverter");
    }

    private static native int nativeConvertARGBToI420(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, int i5, int i6);

    private static native int nativeConvertARGBToNV21(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    private static native int nativeConvertI420ToNV21(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, int i6, int i7);

    private static native int nativeConvertNV12ToARGB(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    private static native int nativeConvertNV21ToARGB(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    private static native int nativeConvertNV21ToI420(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, int i6, int i7);

    private static native int nativeScaleI420(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, ByteBuffer byteBuffer4, int i6, ByteBuffer byteBuffer5, int i7, ByteBuffer byteBuffer6, int i8, int i9, int i10, int i11);

    private static YUVColorConverter m23559b(InjectorLike injectorLike) {
        return new YUVColorConverter(YuvLib.m23560a(injectorLike));
    }

    @Inject
    YUVColorConverter(YuvLib yuvLib) {
        this.f14218a = yuvLib;
        this.f14218a.b();
    }

    public static int m23555a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5) {
        Preconditions.checkArgument(byteBuffer.isDirect());
        Preconditions.checkArgument(byteBuffer2.isDirect());
        Preconditions.checkArgument(byteBuffer3.isDirect());
        return nativeConvertARGBToNV21(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, i4, i5);
    }

    public static int m23556a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, int i5, int i6) {
        Preconditions.checkArgument(byteBuffer.isDirect());
        Preconditions.checkArgument(byteBuffer2.isDirect());
        Preconditions.checkArgument(byteBuffer3.isDirect());
        Preconditions.checkArgument(byteBuffer4.isDirect());
        return nativeConvertARGBToI420(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, byteBuffer4, i4, i5, i6);
    }

    public static int m23558b(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5) {
        Preconditions.checkArgument(byteBuffer.isDirect());
        Preconditions.checkArgument(byteBuffer2.isDirect());
        Preconditions.checkArgument(byteBuffer3.isDirect());
        return nativeConvertNV12ToARGB(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, i4, i5);
    }
}

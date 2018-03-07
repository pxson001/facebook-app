package com.facebook.ui.images.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.bitmaps.NativeImageLibraries;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: p2p_android_risk_native */
public class AnimatedImageDecoder {
    private static final Class<?> f10655a = AnimatedImageDecoder.class;
    private static volatile AnimatedImageDecoder f10656c;
    private final NativeImageLibraries f10657b;

    public static com.facebook.ui.images.webp.AnimatedImageDecoder m15924a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10656c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.webp.AnimatedImageDecoder.class;
        monitor-enter(r1);
        r0 = f10656c;	 Catch:{ all -> 0x003a }
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
        r0 = m15927b(r0);	 Catch:{ all -> 0x0035 }
        f10656c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10656c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.webp.AnimatedImageDecoder.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.webp.AnimatedImageDecoder");
    }

    @DoNotStrip
    private static native TranscodedWebPImageWrapper nativeDecode(byte[] bArr, int i, int i2, int i3);

    private static AnimatedImageDecoder m15927b(InjectorLike injectorLike) {
        return new AnimatedImageDecoder(NativeImageLibraries.m15933a(injectorLike));
    }

    @Inject
    public AnimatedImageDecoder(NativeImageLibraries nativeImageLibraries) {
        this.f10657b = nativeImageLibraries;
    }

    public final boolean m15932a() {
        return this.f10657b.ah_();
    }

    private static boolean m15925a(byte[] bArr) {
        byte[] bArr2 = new byte[]{(byte) 70, (byte) 66, (byte) 65, (byte) 49};
        if (bArr.length < 8) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    private static int m15926b(byte[] bArr) {
        return ((bArr[4] & 255) << 8) | (bArr[5] & 255);
    }

    private static int m15928c(byte[] bArr) {
        return ((bArr[6] & 255) << 8) | (bArr[7] & 255);
    }

    public final AnimatedImage m15931a(byte[] bArr, int i, int i2, int i3) {
        if (!m15932a()) {
            return null;
        }
        int c;
        int i4;
        if (m15925a(bArr)) {
            int b = m15926b(bArr);
            c = m15928c(bArr);
            Object obj = new byte[(bArr.length - 8)];
            System.arraycopy(bArr, 8, obj, 0, bArr.length - 8);
            i4 = c;
            bArr = obj;
            c = b;
        } else {
            i4 = -1;
            c = -1;
        }
        TranscodedWebPImageWrapper nativeDecode = nativeDecode(bArr, bArr.length, i, 75);
        if (nativeDecode == null) {
            return null;
        }
        boolean z;
        boolean z2;
        int i5 = nativeDecode.width;
        int i6 = nativeDecode.height;
        boolean z3 = nativeDecode.isAnimated;
        boolean z4 = nativeDecode.isLooped;
        List jpegFrames = nativeDecode.getJpegFrames();
        int[] iArr = nativeDecode.frameDurations;
        float f = 1.0f;
        float f2 = 1.0f;
        if (i2 > 0 && i2 < i5) {
            f = ((float) i2) / ((float) i5);
        }
        if (i3 > 0 && i3 < i6) {
            f2 = ((float) i3) / ((float) i6);
        }
        f = Math.min(f, f2);
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        if (c >= 0) {
            b = c;
        } else {
            b = i5;
        }
        if (jpegFrames.size() > 1) {
            Options options = new Options();
            options.inInputShareable = true;
            options.inPurgeable = true;
            options.inSampleSize = (int) (1.0f / f);
            for (i5 = 0; i5 < jpegFrames.size(); i5++) {
                byte[] bArr2 = (byte[]) jpegFrames.get(i5);
                builder.m1069c(FbBitmapFactory.a(bArr2, 0, bArr2.length, options));
                builder2.m1069c(Integer.valueOf(iArr[i5]));
            }
            z = z4;
            z2 = z3;
        } else {
            Bitmap a = FbBitmapFactory.a((byte[]) jpegFrames.get(0), 0, ((byte[]) jpegFrames.get(0)).length);
            boolean z5 = i4 >= 0;
            if (i4 == -1) {
                i4 = 12;
            }
            int width = a.getWidth() / b;
            for (i5 = 0; i5 < width; i5++) {
                Bitmap createBitmap = Bitmap.createBitmap(a, b * i5, 0, b, i6);
                if (f < 1.0f) {
                    builder.m1069c(Bitmap.createScaledBitmap(createBitmap, (int) (((float) b) * f), (int) (((float) i6) * f), true));
                } else {
                    builder.m1069c(createBitmap);
                }
                builder2.m1069c(Integer.valueOf(1000 / i4));
            }
            z = z5;
            z2 = z5;
        }
        return new AnimatedImage(b, i6, z2, z, builder.m1068b(), builder2.m1068b());
    }

    public final AnimatedImage m15930a(InputStream inputStream, int i, int i2, int i3) {
        return m15931a(ByteStreams.a(inputStream), i, i2, i3);
    }

    public final AnimatedImage m15929a(File file, int i, int i2, int i3) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            AnimatedImage a = m15930a(fileInputStream, i, i2, i3);
            return a;
        } finally {
            fileInputStream.close();
        }
    }
}

package com.facebook.facedetection.detector;

import android.graphics.Bitmap;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.device.CpuCapabilities;
import com.facebook.facedetection.DataBanksLoader;
import com.facebook.facedetection.FaceDetectionAnalyticsLogger;
import com.facebook.facedetection.FaceDetectionAssetDownloader;
import com.facebook.facedetection.model.TagDescriptor;
import com.facebook.facedetection.models.FaceDescriptor;
import com.facebook.facedetection.models.FaceDescriptors;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: numFreeMessagesRemaining */
public class MacerFaceDetector implements InternalFaceDetector {
    private final MacerFaceDetectorConfiguration f9803a;
    private final FaceDetectionAssetDownloader f9804b;
    private final FaceDetectionAnalyticsLogger f9805c;
    private final PlatformBitmapFactory f9806d;
    private final FaceDetectorCropUtil f9807e;
    private NativePeer f9808f;

    /* compiled from: numFreeMessagesRemaining */
    class NativePeer {
        @DoNotStrip
        private final HybridData mHybridData = initHybrid();

        private static native HybridData initHybrid();

        native byte[] detect(Bitmap bitmap, byte[] bArr);

        static {
            SoLoader.a("fb_tracker");
        }

        NativePeer() {
        }
    }

    @javax.annotation.Nullable
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> m15551a(android.graphics.Bitmap r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r4 = 0;
        r1 = 0;
        r6 = 3866629; // 0x3b0005 float:5.418301E-39 double:1.9103686E-317;
        if (r10 != 0) goto L_0x0010;
    L_0x0007:
        r0 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.a();
        r0 = com.facebook.common.references.CloseableReference.a(r9, r0);
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r8.f9805c;
        r2 = com.facebook.quicklog.identifiers.Facerec.a(r6);
        r0.m15533a(r6, r2);
        r0 = new android.graphics.Rect;
        r2 = r9.getWidth();
        r3 = r9.getHeight();
        r0.<init>(r4, r4, r2, r3);
        r2 = new android.graphics.RectF;
        r2.<init>(r0);
        r3 = new android.graphics.Matrix;
        r3.<init>();
        r0 = (float) r10;
        r3.postRotate(r0);
        r3.mapRect(r2);
        r0 = r8.f9806d;	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r4 = r2.width();	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r4 = java.lang.Math.round(r4);	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r5 = r2.height();	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r5 = java.lang.Math.round(r5);	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r4 = r0.a(r4, r5);	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r5 = new android.graphics.Canvas;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = r4.a();	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r5.<init>(r0);	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = r2.left;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = -r0;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r2 = r2.top;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r2 = -r2;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r5.translate(r0, r2);	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = 0;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r5.drawBitmap(r9, r3, r0);	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = 0;	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r5.setBitmap(r0);	 Catch:{ all -> 0x00b2, all -> 0x007e }
        r0 = r4.b();	 Catch:{ all -> 0x00b2, all -> 0x007e }
        if (r4 == 0) goto L_0x0072;
    L_0x006f:
        r4.close();	 Catch:{  }
    L_0x0072:
        r1 = r8.f9805c;
        r2 = com.facebook.quicklog.identifiers.Facerec.a(r6);
        r1.m15536b(r6, r2);
        goto L_0x000f;
    L_0x007c:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00b2, all -> 0x007e }
    L_0x007e:
        r2 = move-exception;
        r7 = r2;
        r2 = r0;
        r0 = r7;
    L_0x0082:
        if (r4 == 0) goto L_0x0089;
    L_0x0084:
        if (r2 == 0) goto L_0x00ae;
    L_0x0086:
        r4.close();	 Catch:{ Throwable -> 0x009e }
    L_0x0089:
        throw r0;	 Catch:{  }
    L_0x008a:
        r0 = move-exception;
        r0 = r8.f9805c;	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r2 = "OutOfMemory: getZeroOrientedBitmap";	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r0.m15534a(r2);	 Catch:{ OutOfMemoryError -> 0x008a, all -> 0x00a3 }
        r0 = r8.f9805c;
        r2 = com.facebook.quicklog.identifiers.Facerec.a(r6);
        r0.m15536b(r6, r2);
        r0 = r1;
        goto L_0x000f;
    L_0x009e:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0089;
    L_0x00a3:
        r0 = move-exception;
        r1 = r8.f9805c;
        r2 = com.facebook.quicklog.identifiers.Facerec.a(r6);
        r1.m15536b(r6, r2);
        throw r0;
    L_0x00ae:
        r4.close();	 Catch:{  }
        goto L_0x0089;
    L_0x00b2:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.detector.MacerFaceDetector.a(android.graphics.Bitmap, int):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>");
    }

    public static MacerFaceDetector m15554b(InjectorLike injectorLike) {
        return new MacerFaceDetector(new MacerFaceDetectorConfiguration(CpuCapabilities.a(injectorLike)), FaceDetectionAssetDownloader.m15537b(injectorLike), FaceDetectionAnalyticsLogger.m15525a(injectorLike), new FaceDetectorCropUtil(PlatformBitmapFactoryMethodAutoProvider.a(injectorLike), FaceDetectionAnalyticsLogger.m15525a(injectorLike)), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MacerFaceDetector(MacerFaceDetectorConfiguration macerFaceDetectorConfiguration, FaceDetectionAssetDownloader faceDetectionAssetDownloader, FaceDetectionAnalyticsLogger faceDetectionAnalyticsLogger, FaceDetectorCropUtil faceDetectorCropUtil, PlatformBitmapFactory platformBitmapFactory) {
        this.f9803a = macerFaceDetectorConfiguration;
        this.f9804b = faceDetectionAssetDownloader;
        this.f9805c = faceDetectionAnalyticsLogger;
        this.f9807e = faceDetectorCropUtil;
        this.f9806d = platformBitmapFactory;
    }

    public final boolean mo1020a() {
        return true;
    }

    public final List<TagDescriptor> mo1018a(Bitmap bitmap, int i, boolean z) {
        Throwable th = null;
        if (Math.min(bitmap.getWidth(), bitmap.getHeight()) < 64) {
            return new ArrayList();
        }
        List<TagDescriptor> a;
        CloseableReference a2 = m15551a(bitmap, i);
        if (a2 != null) {
            try {
                if (a2.a() != null) {
                    this.f9805c.m15533a(3866627, "face_detection_tracker");
                    NativePeer b = m15553b();
                    if (b != null) {
                        try {
                            byte[] detect = b.detect((Bitmap) a2.a(), this.f9803a.m15559a());
                            if (detect != null) {
                                a = m15552a(detect, (Bitmap) a2.a(), z);
                                this.f9805c.m15536b(3866627, "face_detection_tracker");
                                if (a == null) {
                                    a = new ArrayList();
                                }
                                if (a2 != null) {
                                    return a;
                                }
                                a2.close();
                                return a;
                            }
                        } catch (RuntimeException e) {
                            this.f9805c.m15534a(e.getMessage());
                        }
                    }
                    a = null;
                    this.f9805c.m15536b(3866627, "face_detection_tracker");
                    if (a == null) {
                        a = new ArrayList();
                    }
                    if (a2 != null) {
                        return a;
                    }
                    a2.close();
                    return a;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                th2 = th;
                th = th3;
            }
        }
        a = new ArrayList();
        if (a2 == null) {
            return a;
        }
        a2.close();
        return a;
        if (a2 != null) {
            if (th2 != null) {
                try {
                    a2.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th2, th4);
                }
            } else {
                a2.close();
            }
        }
        throw th;
        throw th;
    }

    @Nullable
    private synchronized NativePeer m15553b() {
        if (this.f9808f == null) {
            try {
                this.f9808f = new NativePeer();
                this.f9804b.m15539a();
                DataBanksLoader dataBanksLoader = new DataBanksLoader(this.f9804b);
            } catch (IOException e) {
                this.f9805c.m15534a("IOException " + e.getMessage());
            } catch (OutOfMemoryError e2) {
                this.f9805c.m15534a("OutOfMemory");
            } catch (BufferOverflowException e3) {
                this.f9805c.m15534a("BufferOverflow");
            }
        }
        return this.f9808f;
    }

    private List<TagDescriptor> m15552a(byte[] bArr, Bitmap bitmap, boolean z) {
        List arrayList = new ArrayList();
        FaceDescriptors a = FaceDescriptors.m15582a(ByteBuffer.wrap(bArr));
        FaceDescriptor faceDescriptor = new FaceDescriptor();
        for (int i = 0; i < a.m15583a(); i++) {
            byte[] a2;
            a.m15584a(faceDescriptor, i);
            Object obj = (!z || faceDescriptor.m15580e() == (byte) 1 || faceDescriptor.m15580e() == (byte) 13) ? null : 1;
            float a3 = (faceDescriptor.m15576a() + faceDescriptor.m15578c()) / 2.0f;
            float d = (faceDescriptor.m15579d() + faceDescriptor.m15577b()) / 2.0f;
            float a4 = faceDescriptor.m15576a();
            float b = faceDescriptor.m15577b();
            float c = faceDescriptor.m15578c();
            float d2 = faceDescriptor.m15579d();
            byte e = faceDescriptor.m15580e();
            float f = faceDescriptor.m15581f();
            if (obj != null) {
                a2 = this.f9807e.m15547a(faceDescriptor, bitmap);
            } else {
                a2 = null;
            }
            arrayList.add(new TagDescriptor(-1.0f, a3, d, a4, b, c, d2, 1, e, f, a2, 0, 0));
        }
        return arrayList;
    }

    public final List<TagDescriptor> mo1019a(String str, int i, int i2, boolean z) {
        throw new UnsupportedOperationException();
    }
}

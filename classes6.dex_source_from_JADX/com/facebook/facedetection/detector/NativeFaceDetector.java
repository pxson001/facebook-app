package com.facebook.facedetection.detector;

import android.graphics.Bitmap;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.NativeImageLibraries;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.debug.log.BLog;
import com.facebook.device.CpuCapabilities;
import com.facebook.facedetection.DataBanksLoader;
import com.facebook.facedetection.FaceDetectionAnalyticsLogger;
import com.facebook.facedetection.FaceDetectionAssetDownloader;
import com.facebook.facedetection.model.TagDescriptor;
import com.facebook.facerec.abtest.ExperimentsForFaceRecAbTestModule;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.qe.api.QeAccessor;
import com.facebook.soloader.SoLoader;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

@DoNotStrip
/* compiled from: null_state_nudge */
public class NativeFaceDetector implements InternalFaceDetector {
    private final CpuCapabilities f9814a;
    private final QeAccessor f9815b;
    private FaceDetectionAnalyticsLogger f9816c;
    private final ImageResizer f9817d;
    private final NativeImageLibraries f9818e;
    public Semaphore f9819f;
    public boolean f9820g;

    /* compiled from: null_state_nudge */
    public enum ModelsUsed {
        MODELS_USED_SINGLE_CLASS,
        MODELS_USED_5_CLASSES,
        MODELS_USED_7_CLASSES
    }

    /* compiled from: null_state_nudge */
    public enum ResizeAlgorithm {
        RESIZE_NN,
        RESIZE_BL,
        RESIZE_SS
    }

    /* compiled from: null_state_nudge */
    public enum ScalesUsed {
        SCALES_USED_EXHAUSTIVE,
        SCALES_USED_QUICKMODE
    }

    private native boolean init(int i);

    private native int[] matchTagsNative(float[] fArr, int i, int i2);

    private native TagDescriptor[] putBitmapNative(Bitmap bitmap, int i, boolean z);

    private native TagDescriptor[] putFrameNative(byte[] bArr, int i, int i2, int i3, boolean z);

    private native TagDescriptor[] putPhotoNative(String str, int i, int i2, boolean z);

    private native void setMaxDetectionDim(int i);

    private native void stop();

    public native void setDetectionScheme(boolean z, int i, int i2, int i3, int i4);

    public NativeFaceDetector(Boolean bool, final FaceDetectionAssetDownloader faceDetectionAssetDownloader, CpuCapabilities cpuCapabilities, FaceDetectionAnalyticsLogger faceDetectionAnalyticsLogger, ImageResizer imageResizer, NativeImageLibraries nativeImageLibraries, ExecutorService executorService, QeAccessor qeAccessor) {
        this.f9814a = cpuCapabilities;
        this.f9816c = (FaceDetectionAnalyticsLogger) Preconditions.checkNotNull(faceDetectionAnalyticsLogger);
        this.f9815b = qeAccessor;
        this.f9817d = imageResizer;
        this.f9818e = nativeImageLibraries;
        if (!bool.booleanValue()) {
            return;
        }
        if (m15564b()) {
            this.f9820g = false;
            this.f9819f = new Semaphore(1);
            this.f9819f.acquireUninterruptibly();
            ExecutorDetour.a(executorService, new NamedRunnable(this, "NativeFaceDetector", "InitializeDetector") {
                final /* synthetic */ NativeFaceDetector f9813d;

                public void run() {
                    faceDetectionAssetDownloader.m15539a();
                    this.f9813d.f9820g = this.f9813d.m15561a(faceDetectionAssetDownloader);
                    this.f9813d.f9819f.release();
                }
            }, -923191407);
            return;
        }
        throw new InstantiationException("Loading native libraries failed");
    }

    private boolean m15564b() {
        try {
            if (this.f9814a.a() || this.f9814a.b()) {
                if (this.f9818e.ah_()) {
                    SoLoader.a("fb_tracker");
                    return true;
                }
                return false;
            }
            String str = "NEON not supported";
            BLog.b("NativeFaceDetector", str);
            this.f9816c.m15534a(str);
            return false;
        } catch (Throwable e) {
            BLog.b("NativeFaceDetector", "failed to create NativeDetector ", e);
            this.f9816c.m15534a("UnsatisfiedLinkError");
        }
    }

    private boolean m15561a(FaceDetectionAssetDownloader faceDetectionAssetDownloader) {
        try {
            DataBanksLoader dataBanksLoader = new DataBanksLoader(faceDetectionAssetDownloader);
            if (init(1)) {
                boolean a = this.f9815b.a(ExperimentsForFaceRecAbTestModule.f9835b, false);
                setDetectionScheme(a, 600, ResizeAlgorithm.RESIZE_NN.ordinal(), ModelsUsed.MODELS_USED_7_CLASSES.ordinal(), ScalesUsed.SCALES_USED_EXHAUSTIVE.ordinal());
                Boolean.valueOf(a);
                return true;
            }
            String str = "NativeTracker allocation failed";
            BLog.b("NativeFaceDetector", str);
            throw new OutOfMemoryError(str);
        } catch (Throwable e) {
            BLog.b("NativeFaceDetector", e, "IOException in initializing detector", new Object[0]);
            this.f9816c.m15534a("IOException");
            return false;
        } catch (Throwable e2) {
            BLog.b("NativeFaceDetector", e2, "OOM in initializing detector", new Object[0]);
            this.f9816c.m15534a("OutOfMemory");
            return false;
        } catch (Throwable e22) {
            BLog.b("NativeFaceDetector", e22, "BufferOverflowException in initializing detector", new Object[0]);
            this.f9816c.m15534a("BufferOverflow");
            return false;
        }
    }

    public final boolean mo1020a() {
        this.f9819f.acquireUninterruptibly();
        this.f9819f.release();
        return this.f9820g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.facebook.facedetection.model.TagDescriptor> mo1018a(android.graphics.Bitmap r8, int r9, boolean r10) {
        /*
        r7 = this;
        r0 = 0;
        r1 = com.google.common.collect.Lists.a();
        r2 = r8.isRecycled();
        if (r2 != 0) goto L_0x002c;
    L_0x000b:
        r2 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.DetectionSource.BITMAP;
        r2 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.m15526a(r2);
        r3 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.DetectionSource.BITMAP;
        r3 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.m15528b(r3);
        r4 = r7.f9816c;
        r4.m15533a(r3, r2);
        r4 = r7.putBitmapNative(r8, r9, r10);	 Catch:{ OutOfMemoryError -> 0x003f }
        if (r4 != 0) goto L_0x002d;
    L_0x0022:
        r0 = r7.f9816c;	 Catch:{ OutOfMemoryError -> 0x003f }
        r0.m15535b();	 Catch:{ OutOfMemoryError -> 0x003f }
    L_0x0027:
        r0 = r7.f9816c;
        r0.m15536b(r3, r2);
    L_0x002c:
        return r1;
    L_0x002d:
        r5 = r7.f9816c;	 Catch:{  }
        r5.m15532a();	 Catch:{  }
        r5 = r4.length;	 Catch:{  }
    L_0x0033:
        if (r0 >= r5) goto L_0x0027;
    L_0x0035:
        r6 = r4[r0];	 Catch:{  }
        if (r6 == 0) goto L_0x003c;
    L_0x0039:
        r1.add(r6);	 Catch:{  }
    L_0x003c:
        r0 = r0 + 1;
        goto L_0x0033;
    L_0x003f:
        r0 = move-exception;
        r4 = "NativeFaceDetector";
        r5 = "OOME in detection";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0050 }
        com.facebook.debug.log.BLog.a(r4, r0, r5, r6);	 Catch:{ all -> 0x0050 }
        r0 = r7.f9816c;
        r0.m15536b(r3, r2);
        goto L_0x002c;
    L_0x0050:
        r0 = move-exception;
        r1 = r7.f9816c;
        r1.m15536b(r3, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.detector.NativeFaceDetector.a(android.graphics.Bitmap, int, boolean):java.util.List<com.facebook.facedetection.model.TagDescriptor>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.facebook.facedetection.model.TagDescriptor> mo1019a(java.lang.String r11, int r12, int r13, boolean r14) {
        /*
        r10 = this;
        r6 = 0;
        r7 = com.google.common.collect.Lists.a();
        r0 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.DetectionSource.FILE;
        r8 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.m15526a(r0);
        r0 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.DetectionSource.FILE;
        r9 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.m15528b(r0);
        r0 = r10.f9816c;
        r0.m15533a(r9, r8);
        r0 = com.facebook.imageformat.ImageFormatChecker.a(r11);	 Catch:{ OutOfMemoryError -> 0x006a }
        r1 = com.facebook.imageformat.ImageFormat.JPEG;	 Catch:{ OutOfMemoryError -> 0x006a }
        if (r0 != r1) goto L_0x0030;
    L_0x001e:
        r0 = r10.putPhotoNative(r11, r12, r13, r14);	 Catch:{ OutOfMemoryError -> 0x006a }
        r1 = r0;
    L_0x0023:
        if (r1 != 0) goto L_0x0057;
    L_0x0025:
        r0 = r10.f9816c;	 Catch:{ OutOfMemoryError -> 0x006a }
        r0.m15535b();	 Catch:{ OutOfMemoryError -> 0x006a }
    L_0x002a:
        r0 = r10.f9816c;
        r0.m15536b(r9, r8);
    L_0x002f:
        return r7;
    L_0x0030:
        r1 = com.facebook.imageformat.ImageFormat.PNG;	 Catch:{  }
        if (r0 != r1) goto L_0x0052;
    L_0x0034:
        r0 = r10.f9817d;	 Catch:{ ImageResizingException -> 0x0045 }
        r5 = 0;
        r1 = r11;
        r2 = r12;
        r3 = r13;
        r4 = r13;
        r0 = r0.a(r1, r2, r3, r4, r5);	 Catch:{ ImageResizingException -> 0x0045 }
        r0 = r10.putBitmapNative(r0, r12, r14);	 Catch:{ ImageResizingException -> 0x0045 }
        r1 = r0;
        goto L_0x0023;
    L_0x0045:
        r0 = move-exception;
        r1 = "NativeFaceDetector";
        r2 = r0.getMessage();	 Catch:{  }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{  }
        com.facebook.debug.log.BLog.a(r1, r0, r2, r3);	 Catch:{  }
    L_0x0052:
        r0 = 0;
        r0 = new com.facebook.facedetection.model.TagDescriptor[r0];	 Catch:{  }
        r1 = r0;
        goto L_0x0023;
    L_0x0057:
        r0 = r10.f9816c;	 Catch:{  }
        r0.m15532a();	 Catch:{  }
        r2 = r1.length;	 Catch:{  }
        r0 = r6;
    L_0x005e:
        if (r0 >= r2) goto L_0x002a;
    L_0x0060:
        r3 = r1[r0];	 Catch:{  }
        if (r3 == 0) goto L_0x0067;
    L_0x0064:
        r7.add(r3);	 Catch:{  }
    L_0x0067:
        r0 = r0 + 1;
        goto L_0x005e;
    L_0x006a:
        r0 = move-exception;
        r1 = "NativeFaceDetector";
        r2 = "OOME in detection";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x007b }
        com.facebook.debug.log.BLog.a(r1, r0, r2, r3);	 Catch:{ all -> 0x007b }
        r0 = r10.f9816c;
        r0.m15536b(r9, r8);
        goto L_0x002f;
    L_0x007b:
        r0 = move-exception;
        r1 = r10.f9816c;
        r1.m15536b(r9, r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.detector.NativeFaceDetector.a(java.lang.String, int, int, boolean):java.util.List<com.facebook.facedetection.model.TagDescriptor>");
    }
}

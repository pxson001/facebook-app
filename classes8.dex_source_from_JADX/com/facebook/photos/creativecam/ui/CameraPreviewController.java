package com.facebook.photos.creativecam.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.bitmaps.BitmapException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.ImageResizer.ImageResizingInputFileException;
import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.CreativeCamMediaSource;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.Callback;
import com.facebook.optic.Callback2;
import com.facebook.optic.CameraDevice;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraPreviewView;
import com.facebook.optic.CameraPreviewView.CameraInitialisedCallback;
import com.facebook.optic.CameraPreviewView.FocusCallback;
import com.facebook.optic.CameraPreviewView.FocusCallback.FocusState;
import com.facebook.optic.PhotoCaptureInfo;
import com.facebook.optic.VideoCaptureInfo;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.8;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: state_error_state */
public class CameraPreviewController {
    public static final String f2168a = CameraPreviewController.class.getSimpleName();
    public final 8 f2169b;
    public final CameraPreviewView f2170c;
    public final CreativeCamCaptureButton f2171d;
    private final NativeImageProcessor f2172e;
    private final Lazy<PlatformBitmapFactory> f2173f;
    private final BitmapUtils f2174g;
    public final MonotonicClock f2175h;
    public final Lazy<TempFileManager> f2176i;
    private final DefaultAndroidThreadUtil f2177j;
    public final Toaster f2178k;
    @ForegroundExecutorService
    public final ListeningExecutorService f2179l;
    @ForUiThread
    public final ExecutorService f2180m;
    public final AbstractFbErrorReporter f2181n;
    public final CreativeCamSource f2182o;
    public final FocusView f2183p;
    public final CameraFacing f2184q;
    public boolean f2185r;
    public boolean f2186s;
    public CreativeEditingLogger f2187t;
    public File f2188u;
    public final FutureCallback<File> f2189v = new C02556(this);

    /* compiled from: state_error_state */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f2150a = new int[FocusState.values().length];

        static {
            try {
                f2150a[FocusState.FOCUSSING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2150a[FocusState.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2150a[FocusState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2150a[FocusState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: state_error_state */
    public class C02471 implements CameraInitialisedCallback {
        final /* synthetic */ CameraPreviewController f2151a;

        public C02471(CameraPreviewController cameraPreviewController) {
            this.f2151a = cameraPreviewController;
        }

        public final void m2340a() {
            this.f2151a.f2185r = true;
            8 8 = this.f2151a.f2169b;
            if (8.a.aF != null) {
                if (CameraDevice.b.e()) {
                    FlashButtonController flashButtonController = 8.a.aF;
                    List<String> supportedFlashModes = 8.a.az.f2170c.getSupportedFlashModes();
                    if (supportedFlashModes == null || supportedFlashModes.isEmpty() || !flashButtonController.f2252d) {
                        flashButtonController.f2249a.setVisibility(8);
                    } else {
                        flashButtonController.f2249a.setVisibility(0);
                        List arrayList = new ArrayList();
                        for (String str : supportedFlashModes) {
                            if (str.equals("auto")) {
                                arrayList.add(Maps.a(str, Integer.valueOf(2130840389)));
                            } else if (str.equals("on")) {
                                arrayList.add(Maps.a(str, Integer.valueOf(2130840392)));
                            } else if (str.equals("off")) {
                                arrayList.add(Maps.a(str, Integer.valueOf(2130840391)));
                            } else if (str.equals("red-eye")) {
                                arrayList.add(Maps.a(str, Integer.valueOf(2130840393)));
                            }
                        }
                        flashButtonController.f2249a.setStates(arrayList);
                        if (flashButtonController.f2250b.a.az.m2355e()) {
                            flashButtonController.f2249a.setCurrentState("off");
                        } else {
                            String flashMode;
                            MultiStateToggleImageButton multiStateToggleImageButton = flashButtonController.f2249a;
                            CameraPreviewController cameraPreviewController = flashButtonController.f2250b.a.az;
                            if (CameraDevice.b.e()) {
                                flashMode = cameraPreviewController.f2170c.getFlashMode();
                            } else {
                                flashMode = "off";
                            }
                            multiStateToggleImageButton.setCurrentState(flashMode);
                        }
                    }
                } else {
                    BLog.b(CreativeEditingCameraFragment.c, "Flash not ready");
                    8.a.aF.f2249a.setVisibility(8);
                }
            }
            this.f2151a.f2170c.t = true;
        }

        public final void m2341a(Exception exception) {
            this.f2151a.f2181n.b(CameraPreviewController.f2168a, "failed to initialize camera", exception);
        }
    }

    /* compiled from: state_error_state */
    public class C02482 implements FocusCallback {
        final /* synthetic */ CameraPreviewController f2152a;

        public C02482(CameraPreviewController cameraPreviewController) {
            this.f2152a = cameraPreviewController;
        }

        public final void m2342a(FocusState focusState, Point point) {
            switch (AnonymousClass12.f2150a[focusState.ordinal()]) {
                case 1:
                    this.f2152a.f2183p.m2405a(point.x, point.y);
                    return;
                case 2:
                    this.f2152a.f2183p.m2404a();
                    return;
                case 3:
                    this.f2152a.f2183p.m2406b();
                    return;
                case 4:
                    this.f2152a.f2183p.m2407c();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: state_error_state */
    public class C02493 implements Callback<CameraFacing> {
        final /* synthetic */ CameraPreviewController f2153a;

        public C02493(CameraPreviewController cameraPreviewController) {
            this.f2153a = cameraPreviewController;
        }

        public final void m2344a(Object obj) {
            CameraFacing cameraFacing = (CameraFacing) obj;
            this.f2153a.f2170c.p = cameraFacing;
            8 8 = this.f2153a.f2169b;
            8.a.au.c(8.a.aS, cameraFacing.name());
        }

        public final void m2343a(Exception exception) {
            BLog.b(CameraPreviewController.f2168a, "failed to switch camera", exception);
        }
    }

    /* compiled from: state_error_state */
    public class C02524 implements Callback2<byte[], PhotoCaptureInfo> {
        final /* synthetic */ CameraPreviewController f2158a;

        /* compiled from: state_error_state */
        class C02512 implements FutureCallback<Uri> {
            final /* synthetic */ C02524 f2157a;

            C02512(C02524 c02524) {
                this.f2157a = c02524;
            }

            public void onSuccess(@Nullable Object obj) {
                Uri uri = (Uri) obj;
                8 8 = this.f2157a.f2158a.f2169b;
                8.a.aJ = uri;
                if (8.a.ar.d) {
                    CreativeEditingCameraFragment.a(8.a, uri);
                }
                this.f2157a.f2158a.f2186s = false;
            }

            public void onFailure(Throwable th) {
                BLog.b(CameraPreviewController.f2168a, "photo save failed, %s", new Object[]{th.getMessage()});
                this.f2157a.f2158a.f2186s = false;
            }
        }

        public C02524(CameraPreviewController cameraPreviewController) {
            this.f2158a = cameraPreviewController;
        }

        public final void m2346a(Object obj, Object obj2) {
            final byte[] bArr = (byte[]) obj;
            final PhotoCaptureInfo photoCaptureInfo = (PhotoCaptureInfo) obj2;
            Futures.a(this.f2158a.f2179l.a(new Callable<Uri>(this) {
                final /* synthetic */ C02524 f2156c;

                public Object call() {
                    return CameraPreviewController.m2351a(this.f2156c.f2158a, bArr, photoCaptureInfo);
                }
            }), new C02512(this), this.f2158a.f2180m);
        }

        public final void m2345a(Exception exception) {
            BLog.b(CameraPreviewController.f2168a, "Photo capture failed", exception);
        }
    }

    /* compiled from: state_error_state */
    class C02556 implements FutureCallback<File> {
        final /* synthetic */ CameraPreviewController f2164a;

        /* compiled from: state_error_state */
        class C02541 implements Callback<VideoCaptureInfo> {
            final /* synthetic */ C02556 f2163a;

            C02541(C02556 c02556) {
                this.f2163a = c02556;
            }

            public final void m2348a(Object obj) {
                this.f2163a.f2164a.f2171d.setOnClickListener(new OnClickListener(this.f2163a.f2164a) {
                    final /* synthetic */ CameraPreviewController f2148a;

                    {
                        this.f2148a = r1;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1929240423);
                        this.f2148a.m2356j();
                        Logger.a(2, EntryType.UI_INPUT_END, 1817493575, a);
                    }
                });
                8 8 = this.f2163a.f2164a.f2169b;
                ProgressBarController progressBarController = 8.a.aH;
                progressBarController.f2281d.setProgress(0);
                progressBarController.f2281d.setVisibility(0);
                progressBarController.f2279b.setText(DateUtils.formatElapsedTime(0));
                progressBarController.f2279b.setVisibility(0);
                progressBarController.f2282e.setVisibility(4);
                progressBarController.f2283f = progressBarController.f2280c.now();
                progressBarController.f2284g.a(progressBarController.f2285h);
                if (8.a.aP.supportsPhotos() && 8.a.aP.supportsVideos()) {
                    8.a.i.setVisibility(8);
                }
                8.a.an.setVisibility(8);
            }

            public final void m2347a(Exception exception) {
                BLog.b(CameraPreviewController.f2168a, "Failed to start recording a video", exception);
            }
        }

        C02556(CameraPreviewController cameraPreviewController) {
            this.f2164a = cameraPreviewController;
        }

        public void onSuccess(@Nullable Object obj) {
            File file = (File) obj;
            this.f2164a.f2188u = file;
            this.f2164a.f2170c.a(new C02541(this), file);
        }

        public void onFailure(Throwable th) {
            this.f2164a.f2178k.a(new ToastBuilder(2131234474));
        }
    }

    /* compiled from: state_error_state */
    class C02567 implements Callback<VideoCaptureInfo> {
        final /* synthetic */ CameraPreviewController f2165a;

        C02567(CameraPreviewController cameraPreviewController) {
            this.f2165a = cameraPreviewController;
        }

        public final void m2350a(Object obj) {
            this.f2165a.f2169b.a(true);
            8 8 = this.f2165a.f2169b;
            8.a.aQ.b(Uri.fromFile(this.f2165a.f2188u), new CreativeCamCaptureInfo(8.a.az.m2355e() ? CreativeCamMediaSource.CREATIVE_CAM_FRONT : CreativeCamMediaSource.CREATIVE_CAM_BACK, 8.a.at, 8.a.aD.m2390a(), 8.a.aD.m2392b()));
            this.f2165a.f2171d.setOnClickListener(this.f2165a.m2357l());
        }

        public final void m2349a(Exception exception) {
            if (this.f2165a.f2188u != null) {
                this.f2165a.f2188u.deleteOnExit();
            }
            this.f2165a.f2169b.a(false);
            this.f2165a.f2171d.setOnClickListener(this.f2165a.m2357l());
            BLog.b(CameraPreviewController.f2168a, "Error stopping the recording", exception);
        }
    }

    /* compiled from: state_error_state */
    public class C02578 implements OnClickListener {
        final /* synthetic */ CameraPreviewController f2166a;

        public C02578(CameraPreviewController cameraPreviewController) {
            this.f2166a = cameraPreviewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1018530819);
            CameraPreviewController cameraPreviewController = this.f2166a;
            if (!cameraPreviewController.f2186s) {
                cameraPreviewController.f2186s = true;
                cameraPreviewController.f2170c.a(new C02524(cameraPreviewController));
            }
            this.f2166a.f2187t.d(this.f2166a.f2182o);
            Logger.a(2, EntryType.UI_INPUT_END, -176766093, a);
        }
    }

    /* compiled from: state_error_state */
    class C02589 implements OnClickListener {
        final /* synthetic */ CameraPreviewController f2167a;

        C02589(CameraPreviewController cameraPreviewController) {
            this.f2167a = cameraPreviewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1259077184);
            CameraPreviewController cameraPreviewController = this.f2167a;
            cameraPreviewController.f2171d.m2366a();
            cameraPreviewController.f2171d.setOnClickListener(null);
            if (!CameraPreviewView.f()) {
                Futures.a(cameraPreviewController.f2179l.a(new Callable<File>(cameraPreviewController) {
                    final /* synthetic */ CameraPreviewController f2149a;

                    {
                        this.f2149a = r1;
                    }

                    public Object call() {
                        return ((TempFileManager) this.f2149a.f2176i.get()).a("creativecam_video_" + this.f2149a.f2175h.now(), ".mp4", Privacy.REQUIRE_SDCARD);
                    }
                }), cameraPreviewController.f2189v, cameraPreviewController.f2180m);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1110298558, a);
        }
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public CameraPreviewController(@Assisted Delegate delegate, @Assisted CameraPreviewView cameraPreviewView, @Assisted FocusView focusView, @Assisted CameraFacing cameraFacing, @Assisted CreativeCamCaptureButton creativeCamCaptureButton, @Assisted CreativeEditingLogger creativeEditingLogger, @Assisted CreativeCamSource creativeCamSource, NativeImageProcessor nativeImageProcessor, Lazy<PlatformBitmapFactory> lazy, BitmapUtils bitmapUtils, Lazy<TempFileManager> lazy2, MonotonicClock monotonicClock, AndroidThreadUtil androidThreadUtil, Toaster toaster, ListeningExecutorService listeningExecutorService, ExecutorService executorService, FbErrorReporter fbErrorReporter) {
        this.f2169b = (8) Preconditions.checkNotNull(delegate);
        this.f2170c = (CameraPreviewView) Preconditions.checkNotNull(cameraPreviewView);
        this.f2172e = nativeImageProcessor;
        this.f2173f = lazy;
        this.f2174g = bitmapUtils;
        this.f2176i = lazy2;
        this.f2175h = monotonicClock;
        this.f2177j = androidThreadUtil;
        this.f2178k = toaster;
        this.f2179l = listeningExecutorService;
        this.f2180m = executorService;
        this.f2171d = creativeCamCaptureButton;
        this.f2187t = creativeEditingLogger;
        this.f2181n = fbErrorReporter;
        this.f2182o = creativeCamSource;
        this.f2183p = focusView;
        this.f2184q = cameraFacing;
    }

    public final boolean m2355e() {
        return this.f2170c.getCameraFacing() == CameraFacing.FRONT;
    }

    public static Uri m2351a(CameraPreviewController cameraPreviewController, byte[] bArr, final PhotoCaptureInfo photoCaptureInfo) {
        Closeable bufferedOutputStream;
        Throwable e;
        final int b;
        final Uri fromFile;
        File a;
        Options options;
        Bitmap decodeStream;
        Matrix matrix;
        Canvas canvas;
        Paint paint;
        CloseableReference closeableReference = null;
        Preconditions.checkNotNull(bArr);
        cameraPreviewController.f2177j.b();
        File a2 = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_intermediate_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
        File a3 = ((TempFileManager) cameraPreviewController.f2176i.get()).a("FB_IMG_", ".jpg", Privacy.REQUIRE_PRIVATE);
        Preconditions.checkNotNull(a2);
        Preconditions.checkNotNull(a3);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a2));
            try {
                bufferedOutputStream.write(bArr);
                m2354a(bufferedOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    BLog.b(f2168a, "File not found while storing", e);
                    m2354a(bufferedOutputStream);
                    b = BitmapUtils.b(a2.getPath());
                    fromFile = Uri.fromFile(a2);
                    cameraPreviewController.f2170c.post(new Runnable(cameraPreviewController) {
                        final /* synthetic */ CameraPreviewController f2162d;

                        public void run() {
                            8 8 = this.f2162d.f2169b;
                            Uri uri = fromFile;
                            PhotoCaptureInfo photoCaptureInfo = photoCaptureInfo;
                            int i = b;
                            8.a.aK = uri;
                            if (!8.a.ar.d) {
                                CreativeEditingCameraFragment.a(8.a, uri, photoCaptureInfo, i);
                            }
                        }
                    });
                    if (CameraFacing.FRONT.equals(cameraPreviewController.f2170c.getCameraFacing())) {
                        cameraPreviewController.m2353a(photoCaptureInfo, b, a2, a3);
                    } else {
                        a = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_working_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
                        try {
                            options = new Options();
                            options.inPreferredConfig = Config.ARGB_8888;
                            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(a2)), null, options);
                            matrix = new Matrix();
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) decodeStream.getWidth(), 0.0f);
                            if (b > 0) {
                                matrix.postRotate((float) (b * -1), (float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2));
                            }
                            closeableReference = ((PlatformBitmapFactory) cameraPreviewController.f2173f.get()).a(decodeStream.getWidth(), decodeStream.getHeight());
                            canvas = new Canvas();
                            paint = new Paint();
                            paint.setFilterBitmap(false);
                            canvas.setBitmap((Bitmap) closeableReference.a());
                            canvas.drawBitmap(decodeStream, matrix, paint);
                            canvas.setBitmap(null);
                            BitmapUtils.a((Bitmap) closeableReference.a(), CompressFormat.JPEG, 100, a);
                            cameraPreviewController.m2353a(photoCaptureInfo, b, a, a3);
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        } catch (Throwable e3) {
                            BLog.b(f2168a, "File not found while reading", e3);
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        } catch (Throwable e32) {
                            BLog.b(f2168a, "IO exception while storing", e32);
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        } catch (BitmapException e4) {
                            BLog.b(f2168a, "Bitmap exception while storing", e4);
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        } catch (TooManyBitmapsException e5) {
                            BLog.b(f2168a, "Bitmap pool is full, preventing allocation for the mirrored bitmap", e5);
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        } catch (Throwable th) {
                            a.delete();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                        }
                    }
                    return Uri.fromFile(a3);
                } catch (Throwable th2) {
                    e32 = th2;
                    m2354a(bufferedOutputStream);
                    throw e32;
                }
            } catch (IOException e6) {
                e32 = e6;
                BLog.b(f2168a, "IO Exception while writing to file", e32);
                m2354a(bufferedOutputStream);
                b = BitmapUtils.b(a2.getPath());
                fromFile = Uri.fromFile(a2);
                cameraPreviewController.f2170c.post(/* anonymous class already generated */);
                if (CameraFacing.FRONT.equals(cameraPreviewController.f2170c.getCameraFacing())) {
                    a = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_working_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
                    options = new Options();
                    options.inPreferredConfig = Config.ARGB_8888;
                    decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(a2)), null, options);
                    matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    matrix.postTranslate((float) decodeStream.getWidth(), 0.0f);
                    if (b > 0) {
                        matrix.postRotate((float) (b * -1), (float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2));
                    }
                    closeableReference = ((PlatformBitmapFactory) cameraPreviewController.f2173f.get()).a(decodeStream.getWidth(), decodeStream.getHeight());
                    canvas = new Canvas();
                    paint = new Paint();
                    paint.setFilterBitmap(false);
                    canvas.setBitmap((Bitmap) closeableReference.a());
                    canvas.drawBitmap(decodeStream, matrix, paint);
                    canvas.setBitmap(null);
                    BitmapUtils.a((Bitmap) closeableReference.a(), CompressFormat.JPEG, 100, a);
                    cameraPreviewController.m2353a(photoCaptureInfo, b, a, a3);
                    a.delete();
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                } else {
                    cameraPreviewController.m2353a(photoCaptureInfo, b, a2, a3);
                }
                return Uri.fromFile(a3);
            }
        } catch (FileNotFoundException e7) {
            e32 = e7;
            bufferedOutputStream = closeableReference;
            BLog.b(f2168a, "File not found while storing", e32);
            m2354a(bufferedOutputStream);
            b = BitmapUtils.b(a2.getPath());
            fromFile = Uri.fromFile(a2);
            cameraPreviewController.f2170c.post(/* anonymous class already generated */);
            if (CameraFacing.FRONT.equals(cameraPreviewController.f2170c.getCameraFacing())) {
                cameraPreviewController.m2353a(photoCaptureInfo, b, a2, a3);
            } else {
                a = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_working_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
                options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(a2)), null, options);
                matrix = new Matrix();
                matrix.postScale(-1.0f, 1.0f);
                matrix.postTranslate((float) decodeStream.getWidth(), 0.0f);
                if (b > 0) {
                    matrix.postRotate((float) (b * -1), (float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2));
                }
                closeableReference = ((PlatformBitmapFactory) cameraPreviewController.f2173f.get()).a(decodeStream.getWidth(), decodeStream.getHeight());
                canvas = new Canvas();
                paint = new Paint();
                paint.setFilterBitmap(false);
                canvas.setBitmap((Bitmap) closeableReference.a());
                canvas.drawBitmap(decodeStream, matrix, paint);
                canvas.setBitmap(null);
                BitmapUtils.a((Bitmap) closeableReference.a(), CompressFormat.JPEG, 100, a);
                cameraPreviewController.m2353a(photoCaptureInfo, b, a, a3);
                a.delete();
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
            return Uri.fromFile(a3);
        } catch (IOException e8) {
            e32 = e8;
            bufferedOutputStream = closeableReference;
            BLog.b(f2168a, "IO Exception while writing to file", e32);
            m2354a(bufferedOutputStream);
            b = BitmapUtils.b(a2.getPath());
            fromFile = Uri.fromFile(a2);
            cameraPreviewController.f2170c.post(/* anonymous class already generated */);
            if (CameraFacing.FRONT.equals(cameraPreviewController.f2170c.getCameraFacing())) {
                a = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_working_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
                options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(a2)), null, options);
                matrix = new Matrix();
                matrix.postScale(-1.0f, 1.0f);
                matrix.postTranslate((float) decodeStream.getWidth(), 0.0f);
                if (b > 0) {
                    matrix.postRotate((float) (b * -1), (float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2));
                }
                closeableReference = ((PlatformBitmapFactory) cameraPreviewController.f2173f.get()).a(decodeStream.getWidth(), decodeStream.getHeight());
                canvas = new Canvas();
                paint = new Paint();
                paint.setFilterBitmap(false);
                canvas.setBitmap((Bitmap) closeableReference.a());
                canvas.drawBitmap(decodeStream, matrix, paint);
                canvas.setBitmap(null);
                BitmapUtils.a((Bitmap) closeableReference.a(), CompressFormat.JPEG, 100, a);
                cameraPreviewController.m2353a(photoCaptureInfo, b, a, a3);
                a.delete();
                if (closeableReference != null) {
                    closeableReference.close();
                }
            } else {
                cameraPreviewController.m2353a(photoCaptureInfo, b, a2, a3);
            }
            return Uri.fromFile(a3);
        } catch (Throwable th3) {
            e32 = th3;
            bufferedOutputStream = closeableReference;
            m2354a(bufferedOutputStream);
            throw e32;
        }
        b = BitmapUtils.b(a2.getPath());
        fromFile = Uri.fromFile(a2);
        cameraPreviewController.f2170c.post(/* anonymous class already generated */);
        if (CameraFacing.FRONT.equals(cameraPreviewController.f2170c.getCameraFacing())) {
            a = ((TempFileManager) cameraPreviewController.f2176i.get()).a("creativecam_working_image_" + cameraPreviewController.f2175h.now(), ".jpg", Privacy.REQUIRE_PRIVATE);
            options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(a2)), null, options);
            matrix = new Matrix();
            matrix.postScale(-1.0f, 1.0f);
            matrix.postTranslate((float) decodeStream.getWidth(), 0.0f);
            if (b > 0) {
                matrix.postRotate((float) (b * -1), (float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2));
            }
            closeableReference = ((PlatformBitmapFactory) cameraPreviewController.f2173f.get()).a(decodeStream.getWidth(), decodeStream.getHeight());
            canvas = new Canvas();
            paint = new Paint();
            paint.setFilterBitmap(false);
            canvas.setBitmap((Bitmap) closeableReference.a());
            canvas.drawBitmap(decodeStream, matrix, paint);
            canvas.setBitmap(null);
            BitmapUtils.a((Bitmap) closeableReference.a(), CompressFormat.JPEG, 100, a);
            cameraPreviewController.m2353a(photoCaptureInfo, b, a, a3);
            a.delete();
            if (closeableReference != null) {
                closeableReference.close();
            }
        } else {
            cameraPreviewController.m2353a(photoCaptureInfo, b, a2, a3);
        }
        return Uri.fromFile(a3);
    }

    private void m2353a(PhotoCaptureInfo photoCaptureInfo, int i, File file, File file2) {
        Rect a = photoCaptureInfo.a(i);
        Rect rect = photoCaptureInfo.a;
        try {
            NativeImageProcessor.a(file.getPath(), i, new RectF(((float) a.left) / ((float) rect.width()), ((float) a.top) / ((float) rect.height()), ((float) a.right) / ((float) rect.width()), ((float) a.bottom) / ((float) rect.height())), file2.getPath());
        } catch (ImageResizingInputFileException e) {
            file2.delete();
            BLog.b(f2168a, "Image crop failed", e);
        } catch (Throwable e2) {
            file2.delete();
            BLog.b(f2168a, "IO Exception while writing to file", e2);
        }
    }

    private static void m2354a(Closeable closeable) {
        if (closeable != null) {
            try {
                Closeables.a(closeable, false);
            } catch (Throwable e) {
                BLog.b(f2168a, "IO Exception, couldnt close stream", e);
            }
        }
    }

    public static void m2352a(Uri uri) {
        if (uri != null) {
            new File(uri.getEncodedPath()).delete();
        }
    }

    public final void m2356j() {
        this.f2170c.a(new C02567(this), null);
    }

    public final OnClickListener m2357l() {
        return new C02589(this);
    }
}

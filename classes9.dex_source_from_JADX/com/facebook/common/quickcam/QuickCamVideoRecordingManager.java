package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: promote_website_key */
public class QuickCamVideoRecordingManager {
    private static final Class<?> f6091a = QuickCamVideoRecordingManager.class;
    private final ExecutorService f6092b;
    private final TempFileManager f6093c;
    private final AbstractFbErrorReporter f6094d;
    public volatile QuickCamCameraManager f6095e;
    private QuickCamVideoLogger f6096f;
    public Toaster f6097g;
    private CameraUtil f6098h;
    private MediaRecorder f6099i;
    private boolean f6100j;
    private boolean f6101k;
    private File f6102l;
    private CamcorderProfile f6103m;
    private boolean f6104n = false;
    private AtomicBoolean f6105o = new AtomicBoolean();
    private AtomicBoolean f6106p = new AtomicBoolean();

    /* compiled from: promote_website_key */
    public enum Cause {
        CANCELLED,
        SUCCESS,
        TIME_LIMIT_REACHED_SUCCESS,
        TIME_LIMIT_REACHED_CANCELLED,
        ERROR
    }

    /* compiled from: promote_website_key */
    public class RecordedVideo {
        public final Uri f6088a;
        public final CamcorderProfile f6089b;
        public final boolean f6090c;

        public RecordedVideo(Uri uri, CamcorderProfile camcorderProfile, boolean z) {
            this.f6088a = uri;
            this.f6089b = camcorderProfile;
            this.f6090c = z;
        }
    }

    public static QuickCamVideoRecordingManager m6445b(InjectorLike injectorLike) {
        return new QuickCamVideoRecordingManager((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new QuickCamVideoLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), Toaster.b(injectorLike), CameraUtil.m6329b(injectorLike));
    }

    @Inject
    public QuickCamVideoRecordingManager(ExecutorService executorService, TempFileManager tempFileManager, AbstractFbErrorReporter abstractFbErrorReporter, QuickCamVideoLogger quickCamVideoLogger, Toaster toaster, CameraUtil cameraUtil) {
        this.f6092b = executorService;
        this.f6093c = tempFileManager;
        this.f6094d = abstractFbErrorReporter;
        this.f6096f = quickCamVideoLogger;
        this.f6097g = toaster;
        this.f6098h = cameraUtil;
    }

    public final boolean m6450a(QuickCamPreviewHolder quickCamPreviewHolder, int i, int i2) {
        if (this.f6105o.getAndSet(true)) {
            return false;
        }
        this.f6106p.set(true);
        this.f6103m = this.f6098h.m6331a(this.f6095e.m6406e(), i2);
        this.f6102l = this.f6093c.a("orca-video-", ".mp4", Privacy.REQUIRE_PRIVATE);
        this.f6095e.m6408i();
        this.f6099i = new MediaRecorder();
        this.f6095e.m6400a(this.f6099i);
        this.f6099i.setAudioSource(5);
        this.f6099i.setVideoSource(1);
        this.f6099i.setProfile(this.f6103m);
        Integer.valueOf(this.f6103m.videoFrameWidth);
        Integer.valueOf(this.f6103m.videoFrameHeight);
        this.f6095e.m6401a(this.f6099i, i);
        this.f6099i.setOutputFile(this.f6102l.getAbsolutePath());
        quickCamPreviewHolder.mo235a(this.f6099i);
        try {
            this.f6099i.prepare();
            this.f6099i.start();
            this.f6101k = false;
            this.f6100j = true;
            this.f6096f.m6441a(m6448e());
            return true;
        } catch (Throwable e) {
            this.f6094d.a(QuickCamVideoRecordingManager.class.getSimpleName(), e);
            m6447d();
            return false;
        } catch (Throwable e2) {
            this.f6094d.a(QuickCamVideoRecordingManager.class.getSimpleName(), e2);
            m6447d();
            ExecutorDetour.a(this.f6092b, new Runnable(this, 2131232194) {
                final /* synthetic */ QuickCamVideoRecordingManager f6087b;

                public void run() {
                    Toaster toaster = this.f6087b.f6097g;
                    ToastBuilder toastBuilder = new ToastBuilder(2131232194);
                    toastBuilder.b = 17;
                    toaster.b(toastBuilder);
                }
            }, -972091143);
            return false;
        }
    }

    public final void m6449a() {
        try {
            if (this.f6100j) {
                this.f6099i.stop();
                this.f6095e.m6403b();
                this.f6100j = false;
            }
        } catch (RuntimeException e) {
            this.f6101k = true;
        }
        this.f6104n = true;
    }

    public final void m6451b() {
        m6444a(this.f6104n ? Cause.TIME_LIMIT_REACHED_CANCELLED : Cause.CANCELLED);
    }

    public final RecordedVideo m6452c() {
        return m6444a(this.f6104n ? Cause.TIME_LIMIT_REACHED_SUCCESS : Cause.SUCCESS);
    }

    private void m6447d() {
        m6444a(Cause.ERROR);
    }

    private RecordedVideo m6444a(Cause cause) {
        RecordedVideo recordedVideo = null;
        if (this.f6106p.getAndSet(false)) {
            try {
                if (this.f6099i != null) {
                    Uri uri;
                    try {
                        if (this.f6100j) {
                            this.f6099i.stop();
                        }
                        if (m6446b(cause) && !this.f6101k) {
                            recordedVideo = Uri.fromFile(this.f6102l);
                        }
                        this.f6100j = false;
                        this.f6099i.reset();
                        this.f6099i.release();
                        this.f6099i = null;
                        uri = recordedVideo;
                    } catch (RuntimeException e) {
                        this.f6100j = false;
                        this.f6099i.reset();
                        this.f6099i.release();
                        this.f6099i = null;
                        uri = null;
                    } catch (Throwable th) {
                        this.f6100j = false;
                        this.f6099i.reset();
                        this.f6099i.release();
                        this.f6099i = null;
                    }
                    this.f6095e.m6407h();
                    if (cause == Cause.ERROR) {
                        this.f6096f.m6443a(m6448e(), cause, this.f6103m);
                    } else {
                        this.f6096f.m6442a(m6448e(), cause);
                    }
                    this.f6104n = false;
                    recordedVideo = new RecordedVideo(uri, this.f6103m, this.f6095e.m6409j());
                    this.f6105o.set(false);
                }
            } finally {
                this.f6105o.set(false);
            }
        }
        return recordedVideo;
    }

    private String m6448e() {
        return this.f6095e.m6409j() ? "front_camera" : "back_camera";
    }

    private static boolean m6446b(Cause cause) {
        return cause == Cause.SUCCESS || cause == Cause.TIME_LIMIT_REACHED_SUCCESS;
    }
}

package com.facebook.camera.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.device.CameraHolder.PreviewAndPictureSize;
import com.facebook.camera.prefs.CameraPrefKeys;
import com.facebook.camera.utils.CameraUIContainer;
import com.facebook.camera.utils.CameraUIContainer.CameraUIContainerHolder;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.activity.media.Fb4aCameraFlowLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity.DisplayPolicy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.WaterfallIdGenerator;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import java.lang.ref.SoftReference;
import java.util.List;
import javax.inject.Inject;

@Deprecated
/* compiled from: android */
public final class CameraActivity extends FbFragmentActivity implements AnalyticsActivity, CameraUIContainerHolder, IAuthNotRequired, ChatHeadsControlActivity {
    private static final Class<?> f10784p = CameraActivity.class;
    private static SoftReference<CameraPhotoData> f10785t;
    private static volatile Uri f10786u;
    private static final Object f10787v = new Object();
    private CameraFlowLogger f10788q;
    private CameraUIContainer f10789r;
    private boolean f10790s;

    /* compiled from: android */
    public class CameraPhotoData {
        public final byte[] f10782a;
        public final int f10783b;

        CameraPhotoData(byte[] bArr, int i) {
            this.f10782a = bArr;
            this.f10783b = i;
        }
    }

    private static <T extends Context> void m18816a(Class<T> cls, T t) {
        m18817a((Object) t, (Context) t);
    }

    public static void m18817a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CameraActivity) obj).m18815a((CameraFlowLogger) new Fb4aCameraFlowLogger(DefaultPhotoFlowLogger.b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), WaterfallIdGenerator.a(injectorLike)), CameraUIContainer.m19007b(injectorLike));
    }

    private static void m18819b(byte[] bArr, int i) {
        synchronized (f10787v) {
            f10785t = new SoftReference(new CameraPhotoData(bArr, i));
        }
    }

    public final void mo1132b(int i) {
        setRequestedOrientation(i);
    }

    public final void mo1133d(int i) {
        setResult(i);
    }

    private static void m18818b(Uri uri) {
        synchronized (f10787v) {
            f10786u = uri;
        }
    }

    public static Uri m18820i() {
        Uri uri;
        synchronized (f10787v) {
            uri = f10786u;
        }
        return uri;
    }

    private static void m18821m() {
        synchronized (f10787v) {
            f10785t = null;
            f10786u = null;
        }
    }

    public final Activity mo1134j() {
        return this;
    }

    public final Context mo1135k() {
        return this;
    }

    protected final void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 140496672);
        super.onResume();
        this.f10789r.m19046i();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 840578809, a);
    }

    protected final void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 176610767);
        this.f10789r.m19047j();
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1904919780, a);
    }

    public final void onUserInteraction() {
        super.onUserInteraction();
        if (this.f10789r != null) {
            CameraUIContainer cameraUIContainer = this.f10789r;
            if (cameraUIContainer.f11030Y != null) {
                cameraUIContainer.f11030Y.a(180000);
            }
        }
    }

    private void m18822n() {
        startActivityForResult(new Intent(this, CameraFallbackActivity.class), 1338);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f10788q.mo1141a(bundle);
    }

    public final void m18828b(Bundle bundle) {
        super.b(bundle);
        Class cls = CameraActivity.class;
        m18817a((Object) this, (Context) this);
        Intent intent = getIntent();
        this.f10790s = intent.getBooleanExtra("return_after_snap", false);
        String stringExtra = intent.getStringExtra("photo_flow_id");
        if (stringExtra != null) {
            this.f10788q.mo1152b(stringExtra);
        }
        CameraUIContainer cameraUIContainer = this.f10789r;
        Class cls2 = f10784p;
        CameraFlowLogger cameraFlowLogger = this.f10788q;
        cameraUIContainer.f11033b = cls2;
        cameraUIContainer.f11034c = intent;
        cameraUIContainer.ab = cameraFlowLogger;
        cameraUIContainer.f11035d = this;
        setContentView(this.f10789r.m19024a(bundle));
        this.f10789r.m19028a(findViewById(2131560155));
        this.f10789r.m19040c(true);
    }

    @Inject
    private void m18815a(CameraFlowLogger cameraFlowLogger, CameraUIContainer cameraUIContainer) {
        this.f10788q = cameraFlowLogger;
        this.f10789r = cameraUIContainer;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        m18821m();
        this.f10789r.m19026a(i, i2, intent);
    }

    public final boolean onSearchRequested() {
        return false;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 84:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public final void onBackPressed() {
        CameraUIContainer cameraUIContainer = this.f10789r;
        boolean z = false;
        if (cameraUIContainer.ar.f10860k) {
            cameraUIContainer.ar.m18926h();
            CameraUIContainer.m19012f(cameraUIContainer, false);
        }
        if (!CameraUIContainer.m19022y(cameraUIContainer)) {
            cameraUIContainer.ab.mo1146a("back_pressed");
            z = true;
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public final void mo1136l() {
        m18822n();
    }

    public final void mo1131a(byte[] bArr, int i) {
        m18819b(bArr, i);
    }

    public final void mo1129a(Uri uri) {
        m18818b(uri);
        if (this.f10790s) {
            setResult(5);
            finish();
        }
    }

    public final void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 18159575);
        super.onStop();
        if (this.f10789r != null) {
            CameraUIContainer cameraUIContainer = this.f10789r;
            Editor edit = cameraUIContainer.aq.edit();
            CameraHolder cameraHolder = cameraUIContainer.ar;
            edit.a(CameraPrefKeys.f10973c, cameraHolder.f10873x);
            edit.a(CameraPrefKeys.f10972b, cameraHolder.f10855f.f10805g);
            edit.commit();
            if (!cameraUIContainer.av || cameraUIContainer.ac.m18856l() >= 1.0f) {
                cameraUIContainer.ab.mo1143a(cameraUIContainer.ac);
            }
            if (cameraUIContainer.f11008C != null) {
                cameraUIContainer.f11008C.cancel();
                cameraUIContainer.f11008C = null;
            }
            cameraUIContainer.f11044n.m19065b();
            cameraUIContainer.f11045o.m19065b();
            cameraUIContainer.ac.m18855a();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 899561121, a);
    }

    public final void mo1130a(List<Size> list, List<Size> list2, PreviewAndPictureSize previewAndPictureSize, Point point) {
        previewAndPictureSize.f10825a = CameraUtils.m19054a((List) list, point);
        previewAndPictureSize.f10826b = CameraUtils.m19054a((List) list2, point);
    }

    public final DisplayPolicy m18823a() {
        return DisplayPolicy.HIDE;
    }

    public final String am_() {
        return "camera";
    }
}

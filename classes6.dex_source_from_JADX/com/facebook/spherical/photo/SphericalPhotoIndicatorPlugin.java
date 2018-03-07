package com.facebook.spherical.photo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.inject.FbInjector;
import com.facebook.photos.sphericalphoto.SphericalPhotoFragment;
import com.facebook.spherical.HasGlToUIBridge;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.ui.Spherical360GyroAnimationView;
import com.facebook.spherical.ui.Spherical360PhoneAnimationView;
import com.facebook.spherical.ui.SphericalHeadingIndicatorPlugin;
import com.facebook.spherical.ui.SphericalNuxAnimationController;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: error creating cursor */
public class SphericalPhotoIndicatorPlugin extends FrameLayout implements HasGlToUIBridge {
    @Inject
    public SphericalPhotoAnalyticsLogger f16253a;
    public final Spherical360GyroAnimationView f16254b;
    public final Spherical360PhoneAnimationView f16255c;
    public final SphericalNuxAnimationController f16256d;
    public final Runnable f16257e;
    private final Runnable f16258f;
    public boolean f16259g;
    public boolean f16260h;
    public boolean f16261i;
    public boolean f16262j;
    public AsyncTask f16263k;
    public Handler f16264l;
    public SphericalPhotoTextureView f16265m;
    public SphericalHeadingIndicatorPlugin f16266n;
    public SphericalPhotoFragment f16267o;
    public float f16268p;
    public float f16269q;
    public float f16270r;
    public float f16271s;
    public float f16272t;
    public boolean f16273u;

    /* compiled from: error creating cursor */
    class C11431 implements Runnable {
        final /* synthetic */ SphericalPhotoIndicatorPlugin f16250a;

        C11431(SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin) {
            this.f16250a = sphericalPhotoIndicatorPlugin;
        }

        public void run() {
            this.f16250a.f16263k = new UpdateMobileOrientationTask(this.f16250a);
            this.f16250a.f16263k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* compiled from: error creating cursor */
    class C11442 implements Runnable {
        final /* synthetic */ SphericalPhotoIndicatorPlugin f16251a;

        C11442(SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin) {
            this.f16251a = sphericalPhotoIndicatorPlugin;
        }

        public void run() {
            if (this.f16251a.f16261i) {
                this.f16251a.f16253a.d();
                this.f16251a.f16255c.setVisibility(0);
                SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin = this.f16251a;
                sphericalPhotoIndicatorPlugin.f16256d.m23871a(sphericalPhotoIndicatorPlugin.f16255c, 300, 300, 2000, 0);
                sphericalPhotoIndicatorPlugin.f16256d.m23875h();
                this.f16251a.f16261i = false;
            }
        }
    }

    /* compiled from: error creating cursor */
    class UpdateMobileOrientationTask extends FbAsyncTask<Object, String, Void> {
        final /* synthetic */ SphericalPhotoIndicatorPlugin f16252a;

        public UpdateMobileOrientationTask(SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin) {
            this.f16252a = sphericalPhotoIndicatorPlugin;
        }

        protected final Object m23791a(Object[] objArr) {
            Object obj;
            SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin = this.f16252a;
            if ((sphericalPhotoIndicatorPlugin.f16271s >= 0.0f || sphericalPhotoIndicatorPlugin.f16265m == null || sphericalPhotoIndicatorPlugin.f16265m.getYaw() == 0.0f || sphericalPhotoIndicatorPlugin.f16265m.getPitch() == 0.0f) && sphericalPhotoIndicatorPlugin.f16272t >= 0.0f) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f16252a.f16268p = this.f16252a.f16265m.getPitch();
                this.f16252a.f16269q = this.f16252a.f16265m.getYaw();
                this.f16252a.f16270r = this.f16252a.f16265m.getRoll();
                this.f16252a.f16271s = 0.0f;
                this.f16252a.f16272t = 0.0f;
            } else if (this.f16252a.f16265m != null) {
                float yaw = this.f16252a.f16265m.getYaw() - this.f16252a.f16269q;
                float pitch = this.f16252a.f16265m.getPitch() - this.f16252a.f16268p;
                this.f16252a.f16272t = Math.abs(this.f16252a.f16265m.getRoll() - this.f16252a.f16270r);
                this.f16252a.f16271s = (float) Math.sqrt((double) ((yaw * yaw) + (pitch * pitch)));
            }
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (this.f16252a.m23793a()) {
                float pitch = this.f16252a.get360TextureView().getPitch();
                this.f16252a.f16266n.m23864a(this.f16252a.get360TextureView().getYaw(), pitch, this.f16252a.get360TextureView().getFov(), 0);
            }
            if (this.f16252a.f16271s > 30.0f) {
                this.f16252a.m23797k();
                this.f16252a.f16261i = false;
            }
            if (this.f16252a.f16272t > 30.0f && this.f16252a.f16262j && this.f16252a.f16267o != null) {
                SphericalPhotoFragment sphericalPhotoFragment = this.f16252a.f16267o;
                if (sphericalPhotoFragment.ao != null) {
                    sphericalPhotoFragment.ao.m20368d();
                }
            }
            if (this.f16252a.f16273u) {
                HandlerDetour.b(this.f16252a.f16264l, this.f16252a.f16257e, 150, -1338099570);
            }
        }
    }

    public static void m23792a(Object obj, Context context) {
        ((SphericalPhotoIndicatorPlugin) obj).f16253a = SphericalPhotoAnalyticsLogger.b(FbInjector.get(context));
    }

    public SphericalPhotoIndicatorPlugin(Context context) {
        this(context, null);
    }

    private SphericalPhotoIndicatorPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SphericalPhotoIndicatorPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16257e = new C11431(this);
        this.f16258f = new C11442(this);
        this.f16259g = false;
        this.f16260h = false;
        this.f16261i = true;
        this.f16262j = false;
        this.f16268p = 0.0f;
        this.f16269q = 0.0f;
        this.f16270r = 0.0f;
        this.f16271s = -1.0f;
        this.f16272t = -1.0f;
        Class cls = SphericalPhotoIndicatorPlugin.class;
        m23792a(this, getContext());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130907186, this, true);
        this.f16254b = (Spherical360GyroAnimationView) findViewById(2131567560);
        this.f16255c = (Spherical360PhoneAnimationView) findViewById(2131567561);
        this.f16256d = new SphericalNuxAnimationController();
        this.f16264l = new Handler();
        m23794c();
    }

    public final void m23794c() {
        this.f16255c.setVisibility(8);
    }

    public final void m23795g() {
        this.f16256d.m23870a(this.f16254b, 0, 300, 2000, -1);
        this.f16256d.m23874g();
    }

    public final void m23796i() {
        m23799m();
        this.f16256d.m23873c();
        this.f16256d.m23872b();
        this.f16273u = false;
        HandlerDetour.a(this.f16264l, this.f16258f);
    }

    public final void m23797k() {
        SphericalNuxAnimationController sphericalNuxAnimationController = this.f16256d;
        if (sphericalNuxAnimationController.f16387e != null) {
            sphericalNuxAnimationController.f16387e.cancel();
        }
    }

    public final void m23798l() {
        m23801o();
        HandlerDetour.b(this.f16264l, this.f16258f, 4000, -2070413705);
    }

    public final void m23799m() {
        if (!this.f16262j) {
            this.f16261i = true;
        }
        m23800n();
        this.f16273u = false;
        HandlerDetour.a(this.f16264l, this.f16258f);
    }

    public final void m23800n() {
        this.f16268p = 0.0f;
        this.f16269q = 0.0f;
        this.f16270r = 0.0f;
        this.f16271s = -1.0f;
        this.f16272t = -1.0f;
    }

    public final boolean m23793a() {
        return this.f16265m != null;
    }

    public SphericalMediaTextureView get360TextureView() {
        return this.f16265m;
    }

    public final void m23801o() {
        this.f16273u = true;
        HandlerDetour.a(this.f16264l, this.f16257e, 2039283671);
    }
}

package com.facebook.spherical.photo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.facebook.inject.FbInjector;
import com.facebook.spherical.HasGlToUIBridge;
import com.facebook.spherical.SphericalMediaAnimationHelper;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.ui.SphericalHeadingIndicatorPlugin;
import com.facebook.spherical.ui.SphericalHeadingIndicatorPlugin.HeadingListener;
import com.facebook.spherical.ui.SphericalNuxAnimationController;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: error_class */
public class PhotoHeadingPlugin extends CustomRelativeLayout implements HasGlToUIBridge {
    @Inject
    public SphericalPhotoAnalyticsLogger f16224a;
    public SphericalPhotoIndicatorPlugin f16225b;
    public SphericalPhotoParams f16226c;
    public SphericalMediaAnimationHelper f16227d;
    public PhotoHeadingIndicatorListener f16228e;
    public SphericalPhotoTextureView f16229f;
    public SphericalHeadingIndicatorPlugin f16230g;

    /* compiled from: error_class */
    class PhotoHeadingIndicatorListener implements HeadingListener {
        final /* synthetic */ PhotoHeadingPlugin f16223a;

        public PhotoHeadingIndicatorListener(PhotoHeadingPlugin photoHeadingPlugin) {
            this.f16223a = photoHeadingPlugin;
        }

        public final void mo1251a() {
        }

        public final void mo1252a(float f, float f2, int i) {
        }

        public final void mo1253a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f16223a.f16224a.e();
            if (this.f16223a.f16225b != null) {
                SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin = this.f16223a.f16225b;
                if (sphericalPhotoIndicatorPlugin.f16256d != null) {
                    SphericalNuxAnimationController sphericalNuxAnimationController = sphericalPhotoIndicatorPlugin.f16256d;
                    if (sphericalNuxAnimationController.f16385c != null && sphericalNuxAnimationController.f16385c.isRunning()) {
                        sphericalNuxAnimationController.f16385c.end();
                    }
                }
                sphericalPhotoIndicatorPlugin.f16261i = false;
            }
            this.f16223a.f16227d.a((float) i, (float) i2, i7, this.f16223a);
        }
    }

    public static void m23779a(Object obj, Context context) {
        ((PhotoHeadingPlugin) obj).f16224a = SphericalPhotoAnalyticsLogger.b(FbInjector.get(context));
    }

    public PhotoHeadingPlugin(Context context) {
        this(context, null);
    }

    private PhotoHeadingPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PhotoHeadingPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PhotoHeadingPlugin.class;
        m23779a(this, getContext());
        setContentView(2130906185);
        this.f16230g = (SphericalHeadingIndicatorPlugin) a(2131565874);
        this.f16230g.m23866b();
        this.f16227d = new SphericalMediaAnimationHelper();
        this.f16228e = new PhotoHeadingIndicatorListener(this);
    }

    public final boolean m23780a() {
        return this.f16229f != null;
    }

    public SphericalMediaTextureView get360TextureView() {
        return this.f16229f;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f16230g.m23867c();
    }
}

package com.facebook.messaging.media.imagepipelinewrapper;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: is_from_featured_tag */
public class ImagePipelineWrapper$1 extends BaseControllerListener {
    final /* synthetic */ ControllerListener f12072a;
    final /* synthetic */ Map f12073b;
    final /* synthetic */ ImagePipelineWrapper f12074c;

    public ImagePipelineWrapper$1(ImagePipelineWrapper imagePipelineWrapper, ControllerListener controllerListener, Map map) {
        this.f12074c = imagePipelineWrapper;
        this.f12072a = controllerListener;
        this.f12073b = map;
    }

    public final void m18994a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        CloseableImage closeableImage = (CloseableImage) obj;
        this.f12074c.g.a(this.f12073b);
        if (this.f12072a != null) {
            this.f12072a.a(str, closeableImage, animatable);
        }
    }

    public final void m18996b(String str, @Nullable Object obj) {
        CloseableImage closeableImage = (CloseableImage) obj;
        if (this.f12072a != null) {
            this.f12072a.b(str, closeableImage);
        }
    }

    public final void m18992a(String str) {
        if (this.f12072a != null) {
            this.f12072a.a(str);
        }
    }

    public final void m18995a(String str, Throwable th) {
        if (this.f12072a != null) {
            this.f12072a.a(str, th);
        }
    }

    public final void m18993a(String str, Object obj) {
        if (this.f12072a != null) {
            this.f12072a.a(str, obj);
        }
    }

    public final void m18997b(String str, Throwable th) {
        this.f12074c.g.a(this.f12073b, th);
        if (this.f12072a != null) {
            this.f12072a.b(str, th);
        }
    }
}

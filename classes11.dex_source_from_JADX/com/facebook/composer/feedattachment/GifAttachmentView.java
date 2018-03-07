package com.facebook.composer.feedattachment;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group/ */
public class GifAttachmentView extends CustomFrameLayout {
    public static final CallerContext f6442b = CallerContext.a(GifAttachmentView.class);
    @Inject
    public FbDraweeControllerBuilder f6443a;
    private final View f6444c;
    public final FbDraweeView f6445d;
    public final ControllerListener<ImageInfo> f6446e = new C08131(this);
    public String f6447f;

    /* compiled from: group/ */
    class C08131 extends BaseControllerListener {
        final /* synthetic */ GifAttachmentView f6441a;

        C08131(GifAttachmentView gifAttachmentView) {
            this.f6441a = gifAttachmentView;
        }

        public final void m7872a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            if (closeableImage != null) {
                if (animatable != null) {
                    animatable.start();
                }
                if (closeableImage.g() != 0) {
                    this.f6441a.f6445d.setAspectRatio(((float) closeableImage.f()) / (((float) closeableImage.g()) * 1.0f));
                }
            }
        }
    }

    public static void m7873a(Object obj, Context context) {
        ((GifAttachmentView) obj).f6443a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public GifAttachmentView(Context context) {
        super(context);
        Class cls = GifAttachmentView.class;
        m7873a(this, getContext());
        setContentView(2130903675);
        this.f6444c = c(2131560526);
        this.f6445d = (FbDraweeView) c(2131560525);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(context.getResources().getDrawable(2130843434), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.f = autoRotateDrawable;
        this.f6445d.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setRemoveButtonClickListener(OnClickListener onClickListener) {
        this.f6444c.setOnClickListener(onClickListener);
    }
}

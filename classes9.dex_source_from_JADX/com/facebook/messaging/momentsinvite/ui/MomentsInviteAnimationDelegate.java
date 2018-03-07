package com.facebook.messaging.momentsinvite.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.messaging.momentsinvite.kenburns.KenBurnsSlideShowAnimationDelegate;
import javax.annotation.Nullable;

/* compiled from: item_count */
public class MomentsInviteAnimationDelegate implements KenBurnsSlideShowAnimationDelegate {
    private static final CallerContext f12325a = CallerContext.a(KenBurnsSlideShowAnimationDelegate.class, "thread_view_module");
    private final FbDraweeControllerBuilder f12326b;
    private final GenericDraweeHierarchyBuilder f12327c;
    private final GenericDraweeView f12328d;
    private final int f12329e;
    @Nullable
    public MomentsInviteImageLoadingListener f12330f;

    public MomentsInviteAnimationDelegate(FbDraweeControllerBuilder fbDraweeControllerBuilder, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, GenericDraweeView genericDraweeView, int i) {
        this.f12326b = fbDraweeControllerBuilder;
        this.f12327c = genericDraweeHierarchyBuilder;
        this.f12328d = genericDraweeView;
        this.f12329e = i;
    }

    public final void mo463a(@Nullable final Uri uri) {
        Uri uri2;
        Drawable colorDrawable = new ColorDrawable(this.f12329e);
        GenericDraweeView genericDraweeView = this.f12328d;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.f12327c;
        genericDraweeHierarchyBuilder.f = colorDrawable;
        genericDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
        FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) this.f12326b.a(f12325a).b(this.f12328d.getController());
        if (uri == null || !uri.isAbsolute()) {
            uri2 = null;
        } else {
            uri2 = uri;
        }
        this.f12328d.setController(((FbDraweeControllerBuilder) fbDraweeControllerBuilder.b(uri2).a(new BaseControllerListener<ImageInfo>(this) {
            final /* synthetic */ MomentsInviteAnimationDelegate f12324b;

            public final void m12794b(String str, Throwable th) {
                if (this.f12324b.f12330f != null && uri != null) {
                    this.f12324b.f12330f.mo466a(uri, th);
                }
            }
        })).s());
        this.f12328d.setVisibility(0);
        this.f12328d.setAlpha(1.0f);
    }

    public final void mo460a() {
        this.f12328d.setController(null);
        this.f12328d.setVisibility(8);
    }

    public final void mo462a(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.f12328d.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f12328d.setLayoutParams(layoutParams);
    }

    public final void mo461a(float f, float f2, float f3, float f4, float f5, boolean z, float f6) {
        this.f12328d.setTranslationX(f4);
        this.f12328d.setTranslationY(f5);
        this.f12328d.setPivotX(f);
        this.f12328d.setPivotY(f2);
        this.f12328d.setScaleX(f3);
        this.f12328d.setScaleY(f3);
        this.f12328d.setVisibility(z ? 0 : 8);
        this.f12328d.setAlpha(f6);
    }
}

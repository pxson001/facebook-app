package com.facebook.messaging.composershortcuts;

import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: message_object */
public class PlatformContentViewHolder extends ViewHolder {
    public static final CallerContext f10161l = CallerContext.a(PlatformContentViewHolder.class);
    public final FbDraweeControllerBuilder f10162m;
    public final FbDraweeView f10163n;

    /* compiled from: message_object */
    public class C11741 extends BaseControllerListener {
        final /* synthetic */ PlatformContentViewHolder f10160a;

        public C11741(PlatformContentViewHolder platformContentViewHolder) {
            this.f10160a = platformContentViewHolder;
        }

        public final void m10616a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    @Inject
    public PlatformContentViewHolder(@Assisted FbDraweeView fbDraweeView, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(fbDraweeView);
        this.f10162m = fbDraweeControllerBuilder;
        this.f10163n = fbDraweeView;
    }
}

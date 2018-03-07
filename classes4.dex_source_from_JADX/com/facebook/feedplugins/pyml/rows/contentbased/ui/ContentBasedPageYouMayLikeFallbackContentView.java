package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import javax.annotation.Nullable;

/* compiled from: notifications_disabled_thread */
public class ContentBasedPageYouMayLikeFallbackContentView extends ContentBasedPageYouMayLikeView {
    public final FbDraweeView f6726d = ((FbDraweeView) c(2131560754));

    public ContentBasedPageYouMayLikeFallbackContentView(Context context) {
        super(context, 2130903784);
    }

    public void setPageCoverPhotoOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f6726d.setOnClickListener(onClickListener);
    }
}

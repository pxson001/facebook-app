package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: notificationsGetSettingsParams */
public class ContentBasedPageYouMayLikePhotoContentView extends ContentBasedPageYouMayLikeView {
    private final View f6743d = c(2131560755);
    public final ImmutableList<FbDraweeView> f6744e = ImmutableList.of((FbDraweeView) c(2131560756), (FbDraweeView) c(2131560757), (FbDraweeView) c(2131560758), (FbDraweeView) c(2131560759));

    public ContentBasedPageYouMayLikePhotoContentView(Context context) {
        super(context, 2130903785);
    }

    public void setPagePhotoGridOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f6743d.setOnClickListener(onClickListener);
    }
}

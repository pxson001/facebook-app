package com.facebook.messaging.photos.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.ultralight.Inject;

/* compiled from: registration_login_start */
public class SlideshowMediaViewHolder extends ViewHolder {
    public final FbDraweeControllerBuilder f3653l;
    public final FbDraweeView f3654m;

    @Inject
    public SlideshowMediaViewHolder(FbDraweeControllerBuilder fbDraweeControllerBuilder, @Assisted View view) {
        super(view);
        this.f3653l = fbDraweeControllerBuilder;
        this.f3654m = (FbDraweeView) view.findViewById(2131562910);
    }
}

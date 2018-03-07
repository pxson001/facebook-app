package com.facebook.friendsharing.gif.activity;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: SECTIONS */
public class GifViewHolder extends ViewHolder {
    private final FbDraweeView f23916l;
    private final View f23917m;
    public final ProgressBar f23918n;

    public GifViewHolder(View view) {
        super(view);
        this.f23916l = (FbDraweeView) view.findViewById(2131567475);
        this.f23918n = (ProgressBar) view.findViewById(2131567476);
        this.f23917m = view;
    }

    public final View m26044w() {
        return this.f23917m;
    }

    public final FbDraweeView m26045x() {
        return this.f23916l;
    }

    public final ProgressBar m26046y() {
        return this.f23918n;
    }
}

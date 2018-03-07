package com.facebook.timeline.profilevideo.view;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import javax.annotation.Nullable;

/* compiled from: mFirstSix */
public class SimpleNewsFeedAdapter extends Adapter<ViewHolder> {
    @Nullable
    public ImageView f9494a;
    @Nullable
    private Bitmap f9495b;

    /* compiled from: mFirstSix */
    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ImageView f9493l;

        public ViewHolder(View view) {
            super(view);
            this.f9493l = (ImageView) view.findViewById(2131567457);
        }
    }

    public final void m11206a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (1 == i) {
            viewHolder2.f9493l.setVisibility(0);
            this.f9494a = viewHolder2.f9493l;
            m11203d();
            return;
        }
        viewHolder2.f9493l.setVisibility(4);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m11204a(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907109, viewGroup, false));
    }

    public final int aZ_() {
        return 3;
    }

    public final void m11205a(Bitmap bitmap) {
        this.f9495b = bitmap;
        m11203d();
    }

    private void m11203d() {
        if (this.f9494a != null && this.f9495b != null) {
            this.f9494a.setImageBitmap(this.f9495b);
        }
    }
}

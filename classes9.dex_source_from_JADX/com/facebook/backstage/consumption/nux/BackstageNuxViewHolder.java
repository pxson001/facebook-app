package com.facebook.backstage.consumption.nux;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.backstage.consumption.HolderListener;

/* compiled from: ride_requests */
public class BackstageNuxViewHolder {
    private final Activity f4848a;
    private final ViewGroup f4849b;
    public BackstageNuxView f4850c;

    /* compiled from: ride_requests */
    class C04991 implements HolderListener {
        final /* synthetic */ BackstageNuxViewHolder f4847a;

        C04991(BackstageNuxViewHolder backstageNuxViewHolder) {
            this.f4847a = backstageNuxViewHolder;
        }

        public final void mo143a() {
            BackstageNuxViewHolder backstageNuxViewHolder = this.f4847a;
            if (backstageNuxViewHolder.f4850c != null) {
                ((ViewGroup) backstageNuxViewHolder.f4850c.getParent()).removeView(backstageNuxViewHolder.f4850c);
                backstageNuxViewHolder.f4850c = null;
            }
        }
    }

    public BackstageNuxViewHolder(Activity activity, ViewGroup viewGroup) {
        this.f4848a = activity;
        this.f4849b = viewGroup;
    }

    public final BackstageNuxView m4731c() {
        if (this.f4850c != null) {
            return this.f4850c;
        }
        this.f4850c = new BackstageNuxView(this.f4848a);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        this.f4850c.setLayoutParams(layoutParams);
        this.f4850c.setVisibility(8);
        this.f4850c.f4844g = new C04991(this);
        this.f4849b.addView(this.f4850c);
        return this.f4850c;
    }
}

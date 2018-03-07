package com.facebook.photos.simplepicker.controller;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.inject.Assisted;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;
import javax.inject.Inject;

/* compiled from: share_copied_link */
public class SimplePickerHeaderHolder extends ViewHolder {
    public final CustomViewPager f3141l;
    public final HScrollCirclePageIndicator f3142m;

    @Inject
    public SimplePickerHeaderHolder(@Assisted View view) {
        super(view);
        this.f3141l = (CustomViewPager) view.findViewById(2131567551);
        this.f3142m = (HScrollCirclePageIndicator) view.findViewById(2131567552);
    }
}

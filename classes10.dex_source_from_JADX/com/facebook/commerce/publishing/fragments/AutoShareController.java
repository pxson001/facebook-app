package com.facebook.commerce.publishing.fragments;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: cymk_click_profile */
public class AutoShareController {
    public CompoundButton f15570a;
    public View f15571b;
    public final boolean f15572c;

    /* compiled from: cymk_click_profile */
    public class C21621 implements OnCheckedChangeListener {
        final /* synthetic */ AutoShareController f15569a;

        public C21621(AutoShareController autoShareController) {
            this.f15569a = autoShareController;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f15569a.f15571b.setVisibility(z ? 0 : 8);
        }
    }

    @Inject
    public AutoShareController(@Assisted boolean z) {
        this.f15572c = z;
    }
}

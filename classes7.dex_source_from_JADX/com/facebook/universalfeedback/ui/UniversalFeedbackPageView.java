package com.facebook.universalfeedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: edit_gallery_fetch_image_temp */
public class UniversalFeedbackPageView extends CustomLinearLayout {
    public NavigationListener f15372a;

    /* compiled from: edit_gallery_fetch_image_temp */
    public interface NavigationListener {
        void mo1190a();

        void mo1191b();
    }

    public UniversalFeedbackPageView(Context context) {
        super(context);
    }

    public UniversalFeedbackPageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UniversalFeedbackPageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void m19391b() {
        if (this.f15372a != null) {
            this.f15372a.mo1190a();
        }
    }

    protected final void m19392c() {
        if (this.f15372a != null) {
            this.f15372a.mo1191b();
        }
    }
}

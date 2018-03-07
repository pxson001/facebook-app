package com.facebook.photos.simplepicker.controller;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerConfiguration;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: shadowOffset */
public class SlideshowErrorMessageController {
    private final int f3159a;
    private final int f3160b;
    private Resources f3161c;
    private ViewStub f3162d;
    public View f3163e;
    private FbTextView f3164f;
    private ObjectAnimator f3165g;

    /* compiled from: shadowOffset */
    public class C04071 implements AnimatorListener {
        final /* synthetic */ SlideshowErrorMessageController f3157a;

        public C04071(SlideshowErrorMessageController slideshowErrorMessageController) {
            this.f3157a = slideshowErrorMessageController;
        }

        public void onAnimationStart(Animator animator) {
            this.f3157a.f3163e.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: shadowOffset */
    public class C04082 implements AnimatorListener {
        final /* synthetic */ SlideshowErrorMessageController f3158a;

        public C04082(SlideshowErrorMessageController slideshowErrorMessageController) {
            this.f3158a = slideshowErrorMessageController;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f3158a.f3163e.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public SlideshowErrorMessageController(View view, SimplePickerConfiguration simplePickerConfiguration) {
        this.f3159a = simplePickerConfiguration.t;
        this.f3160b = simplePickerConfiguration.u;
        this.f3161c = view.getResources();
        this.f3162d = (ViewStub) view.findViewById(2131567471);
    }

    public final void m3157a(boolean z, ImmutableList<MediaItem> immutableList) {
        if (!z) {
            m3155a();
        } else if (immutableList.size() < this.f3159a) {
            m3156a(this.f3161c.getString(2131234439, new Object[]{Integer.valueOf(this.f3159a)}));
        } else if (immutableList.size() > this.f3160b) {
            m3156a(this.f3161c.getString(2131234440, new Object[]{Integer.valueOf(this.f3160b)}));
        } else {
            m3155a();
        }
    }

    private void m3156a(String str) {
        if (this.f3165g != null && this.f3165g.isRunning()) {
            this.f3165g.end();
        }
        if (this.f3163e == null) {
            this.f3163e = this.f3162d.inflate();
            this.f3164f = (FbTextView) this.f3163e.findViewById(2131567495);
        }
        if (this.f3163e.getVisibility() != 0 || !this.f3164f.getText().equals(str)) {
            this.f3164f.setText(str);
            this.f3163e.measure(0, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3163e, "translationY", new float[]{(float) this.f3163e.getMeasuredHeight(), 0.0f});
            ofFloat.addListener(new C04071(this));
            this.f3165g = ofFloat;
            this.f3165g.start();
        }
    }

    private void m3155a() {
        if (this.f3165g != null && this.f3165g.isRunning()) {
            this.f3165g.end();
        }
        if (this.f3163e != null && this.f3163e.getVisibility() != 8) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3163e, "translationY", new float[]{(float) this.f3163e.getHeight()});
            ofFloat.addListener(new C04082(this));
            this.f3165g = ofFloat;
            this.f3165g.start();
        }
    }
}

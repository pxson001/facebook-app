package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: restore_param_in_memory_stickers */
public class CommentRowViewController {
    private final View f5192a;
    private final CommentBackgroundUtil f5193b;
    public OnTouchListener f5194c;

    @Inject
    public CommentRowViewController(@Assisted View view, CommentBackgroundUtil commentBackgroundUtil) {
        this.f5192a = view;
        this.f5193b = commentBackgroundUtil;
    }

    public final void m5642a() {
        this.f5192a.setBackgroundDrawable(this.f5193b.m4813a(this.f5192a.getContext()));
    }

    public final void m5643a(ValueAnimator valueAnimator) {
        CommentBackgroundUtil.m4809a(this.f5192a.getBackground(), valueAnimator);
    }

    public final boolean m5644a(MotionEvent motionEvent) {
        this.f5192a.onTouchEvent(motionEvent);
        if (this.f5194c != null) {
            this.f5194c.onTouch(this.f5192a, motionEvent);
        }
        return false;
    }
}

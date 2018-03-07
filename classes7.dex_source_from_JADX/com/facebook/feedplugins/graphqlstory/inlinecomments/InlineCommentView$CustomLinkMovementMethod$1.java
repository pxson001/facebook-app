package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.view.MotionEvent;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentView.CustomLinkMovementMethod;

/* compiled from: Selected overlay not in list */
class InlineCommentView$CustomLinkMovementMethod$1 implements Runnable {
    final /* synthetic */ MotionEvent f23352a;
    final /* synthetic */ CustomLinkMovementMethod f23353b;

    InlineCommentView$CustomLinkMovementMethod$1(CustomLinkMovementMethod customLinkMovementMethod, MotionEvent motionEvent) {
        this.f23353b = customLinkMovementMethod;
        this.f23352a = motionEvent;
    }

    public void run() {
        this.f23353b.a.dispatchTouchEvent(this.f23352a);
    }
}

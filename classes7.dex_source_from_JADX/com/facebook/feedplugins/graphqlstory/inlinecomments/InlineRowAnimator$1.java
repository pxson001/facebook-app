package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;

/* compiled from: See original post from  */
public class InlineRowAnimator$1 implements Runnable {
    final /* synthetic */ View f23357a;
    final /* synthetic */ int f23358b;
    final /* synthetic */ InlineCommentPersistentState f23359c;
    final /* synthetic */ InlineRowAnimator f23360d;

    public InlineRowAnimator$1(InlineRowAnimator inlineRowAnimator, View view, int i, InlineCommentPersistentState inlineCommentPersistentState) {
        this.f23360d = inlineRowAnimator;
        this.f23357a = view;
        this.f23358b = i;
        this.f23359c = inlineCommentPersistentState;
    }

    public void run() {
        Animator a = this.f23360d.a.a(this.f23357a, 0, this.f23358b);
        a.setDuration(400);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a);
        animatorSet.start();
        this.f23359c.f23349a = true;
    }
}

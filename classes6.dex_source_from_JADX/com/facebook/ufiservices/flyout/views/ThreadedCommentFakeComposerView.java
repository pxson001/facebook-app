package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: current_promo */
public class ThreadedCommentFakeComposerView extends ImageBlockLayout {
    private static final CallerContext f18205i = CallerContext.a(ThreadedCommentFakeComposerView.class, "story_feedback_flyout");
    @Inject
    public LoggedInUserSessionManager f18206h;

    private static <T extends View> void m26728a(Class<T> cls, T t) {
        m26729a((Object) t, t.getContext());
    }

    private static void m26729a(Object obj, Context context) {
        ((ThreadedCommentFakeComposerView) obj).f18206h = LoggedInUserSessionManager.a(FbInjector.get(context));
    }

    public ThreadedCommentFakeComposerView(Context context) {
        this(context, null, 0);
    }

    public ThreadedCommentFakeComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadedCommentFakeComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26727a();
    }

    private void m26727a() {
        m26728a(ThreadedCommentFakeComposerView.class, (View) this);
        setContentView(2130903623);
        ((FbDraweeView) findViewById(2131560431)).a(Uri.parse(this.f18206h.c().x()), f18205i);
    }
}

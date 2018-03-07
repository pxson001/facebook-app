package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feedback.ui.CommentComposerPostButton;
import com.facebook.feedback.ui.CommentComposerPostButton.Listener;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: resized_stickers_count */
public class InlineReplyComposerView extends ImageBlockLayout {
    private static final CallerContext f5218h = CallerContext.a(InlineReplyComposerView.class, "story_feedback_flyout");
    @Inject
    public LoggedInUserSessionManager f5219i;
    public MentionsAutoCompleteTextView f5220j;
    public CommentComposerPostButton f5221k;

    public static void m5661a(Object obj, Context context) {
        ((InlineReplyComposerView) obj).f5219i = LoggedInUserSessionManager.a(FbInjector.get(context));
    }

    public InlineReplyComposerView(Context context) {
        this(context, null, 0);
    }

    private InlineReplyComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = InlineReplyComposerView.class;
        m5661a(this, getContext());
        setContentView(2130904907);
        User c = this.f5219i.c();
        ((FbDraweeView) getView(2131563161)).a(Uri.parse(c.x()), f5218h);
        ((FbTextView) getView(2131563162)).setText(c.j());
        this.f5220j = (MentionsAutoCompleteTextView) getView(2131563163);
        this.f5221k = (CommentComposerPostButton) getView(2131563164);
    }

    public void setPostButtonListener(Listener listener) {
        this.f5221k.f4200e = listener;
    }

    public final void m5662g() {
        this.f5220j.getText().clear();
    }
}

package com.facebook.feedback.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.common.util.StringUtil;
import com.facebook.feedback.ui.CommentComposerPostButton.Listener;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.rows.views.InlineReplyComposerView;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.ufiservices.cache.PendingCommentInputCache;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ultralight.Inject;
import javax.annotation.Nullable;

/* compiled from: row */
public class InlineReplyComposerController implements TextWatcher, Listener {
    private final PendingCommentInputCache f4589a;
    @Nullable
    public BaseCommentsEnvironment f4590b;
    @Nullable
    public GraphQLFeedback f4591c;
    @Nullable
    private InlineReplyComposerView f4592d;

    @Inject
    public InlineReplyComposerController(PendingCommentInputCache pendingCommentInputCache) {
        this.f4589a = pendingCommentInputCache;
    }

    public final void m5144a(@Nullable InlineReplyComposerView inlineReplyComposerView) {
        this.f4592d = inlineReplyComposerView;
        m5140c();
    }

    public final void m5143a() {
        PendingCommentInputEntry h = m5142h();
        if (h != null) {
            this.f4589a.a(h.b, h);
        }
    }

    public final void m5145b() {
        if (this.f4592d != null && this.f4591c != null) {
            this.f4592d.m5662g();
            PendingCommentInputEntry a = this.f4589a.a(this.f4591c.j());
            if (a != null) {
                InlineReplyComposerView inlineReplyComposerView = this.f4592d;
                inlineReplyComposerView.f5220j.setText(a.c);
                InlineReplyComposerView inlineReplyComposerView2 = this.f4592d;
                inlineReplyComposerView2.f5220j.setSelection(inlineReplyComposerView2.f5220j.getText().length());
                m5140c();
            }
        }
    }

    public final void mo231d() {
        m5141g();
    }

    public final void mo232e() {
    }

    public final void mo233f() {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        m5140c();
    }

    private void m5140c() {
        if (this.f4592d != null) {
            boolean z;
            InlineReplyComposerView inlineReplyComposerView = this.f4592d;
            CommentComposerPostButton commentComposerPostButton = inlineReplyComposerView.f5221k;
            if (StringUtil.c(inlineReplyComposerView.f5220j.getEncodedText())) {
                z = false;
            } else {
                z = true;
            }
            commentComposerPostButton.setEnabled(z);
        }
    }

    private void m5141g() {
        if (this.f4590b != null && this.f4592d != null) {
            PendingCommentInputEntry h = m5142h();
            if (h != null) {
                KeyboardUtils.a(this.f4592d.getContext(), this.f4592d);
                this.f4592d.m5662g();
                BaseCommentsEnvironment baseCommentsEnvironment = this.f4590b;
                GraphQLFeedback graphQLFeedback = this.f4591c;
                CommentDelegate commentDelegate = baseCommentsEnvironment.f4806c;
                commentDelegate.f4227d.m5068a(h, graphQLFeedback, commentDelegate.f4248y);
            }
        }
    }

    @Nullable
    private PendingCommentInputEntry m5142h() {
        return (this.f4591c == null || this.f4591c.z_() == null || this.f4592d == null) ? null : new PendingCommentInputEntry(this.f4591c.z_(), this.f4591c.j(), this.f4592d.f5220j.getEncodedText(), true, false, null, null, false, 0);
    }
}

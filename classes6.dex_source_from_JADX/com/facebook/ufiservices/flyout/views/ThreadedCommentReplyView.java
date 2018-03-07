package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.FbInjector;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.ui.emoji.EmojiUtil;
import javax.inject.Inject;

/* compiled from: current_product_price */
public class ThreadedCommentReplyView extends ImageBlockLayout {
    private static final CallerContext f18207i = CallerContext.a(ThreadedCommentReplyView.class, "story_feedback_flyout");
    @Inject
    public EmojiUtil f18208h;
    private GraphQLComment f18209j;

    private static <T extends View> void m26732a(Class<T> cls, T t) {
        m26733a((Object) t, t.getContext());
    }

    private static void m26733a(Object obj, Context context) {
        ((ThreadedCommentReplyView) obj).f18208h = EmojiUtil.a(FbInjector.get(context));
    }

    private void m26731a(EmojiUtil emojiUtil) {
        this.f18208h = emojiUtil;
    }

    public ThreadedCommentReplyView(Context context) {
        this(context, null, 0);
    }

    public ThreadedCommentReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadedCommentReplyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26730a();
    }

    private void m26730a() {
        m26732a(ThreadedCommentReplyView.class, (View) this);
        setContentView(2130903635);
    }

    public final void m26735a(GraphQLComment graphQLComment, boolean z) {
        this.f18209j = graphQLComment;
        m26734f();
        setupCommentBody(z);
    }

    private void m26734f() {
        TextView textView = (TextView) findViewById(2131560457);
        textView.setText(GraphQLCommentHelper.a(this.f18209j));
        TextViewUtils.a(textView, null, null, this.f18209j.A() ? getResources().getDrawable(2130843879) : null, null);
        if (this.f18209j.r() != null && this.f18209j.r().ai() != null && this.f18209j.r().ai().b() != null) {
            ((FbDraweeView) findViewById(2131560431)).a(Uri.parse(this.f18209j.r().ai().b()), f18207i);
        }
    }

    private void setupCommentBody(boolean z) {
        TextView textView = (TextView) findViewById(2131560432);
        Resources resources = getResources();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (z) {
            spannableStringBuilder.append(resources.getString(2131233299));
        } else if (this.f18209j.s() != null && !StringUtil.a(this.f18209j.s().a())) {
            spannableStringBuilder.append(this.f18209j.s().a());
            this.f18208h.a(spannableStringBuilder, (int) textView.getTextSize());
        } else if (GraphQLCommentHelper.g(this.f18209j)) {
            spannableStringBuilder.append(resources.getString(2131233301));
        } else {
            GraphQLStoryAttachment c = GraphQLCommentHelper.c(this.f18209j);
            if (c != null && GraphQLStoryAttachmentUtil.j(c)) {
                spannableStringBuilder.append(resources.getString(2131233300));
            } else if (c == null || !GraphQLStoryAttachmentUtil.b(c)) {
                spannableStringBuilder.append(resources.getString(2131233299));
            } else {
                spannableStringBuilder.append(resources.getString(2131233302));
            }
        }
        textView.setText(spannableStringBuilder);
    }
}

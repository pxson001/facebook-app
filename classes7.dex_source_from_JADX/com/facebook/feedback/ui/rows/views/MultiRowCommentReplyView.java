package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.flyout.views.ThreadedCommentReplyView;
import javax.inject.Inject;

/* compiled from: residueType greater than 2 is not decodable */
public class MultiRowCommentReplyView extends ThreadedCommentReplyView {
    @Inject
    public CommentRowViewControllerProvider f5222i;
    private final CommentRowViewController f5223j;

    public static void m5663a(Object obj, Context context) {
        ((MultiRowCommentReplyView) obj).f5222i = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public MultiRowCommentReplyView(Context context) {
        this(context, null);
    }

    private MultiRowCommentReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MultiRowCommentReplyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MultiRowCommentReplyView.class;
        m5663a(this, getContext());
        this.f5223j = this.f5222i.m5645a(this);
        this.f5223j.m5642a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}

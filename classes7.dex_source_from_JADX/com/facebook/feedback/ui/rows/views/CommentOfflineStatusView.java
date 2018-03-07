package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.facebook.inject.FbInjector;
import com.facebook.widget.FlowLayout;
import javax.inject.Inject;

/* compiled from: result_recieved_at_millis */
public class CommentOfflineStatusView extends FlowLayout implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5183a;
    private final CommentRowViewController f5184b;

    public static void m5636a(Object obj, Context context) {
        ((CommentOfflineStatusView) obj).f5183a = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentOfflineStatusView(Context context) {
        this(context, null, 0);
    }

    private CommentOfflineStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentOfflineStatusView.class;
        m5636a(this, getContext());
        LayoutInflater.from(getContext()).inflate(2130905535, this);
        this.f5184b = this.f5183a.m5645a(this);
        this.f5184b.m5642a();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5184b.m5643a(valueAnimator);
    }
}

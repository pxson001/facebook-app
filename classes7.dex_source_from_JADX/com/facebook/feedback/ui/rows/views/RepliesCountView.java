package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reshowFlow */
public class RepliesCountView extends FbTextView {
    @Inject
    public CommentRowViewControllerProvider f5224a;
    private final CommentRowViewController f5225b;

    public static void m5664a(Object obj, Context context) {
        ((RepliesCountView) obj).f5224a = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public RepliesCountView(Context context) {
        this(context, null, 0);
    }

    private RepliesCountView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = RepliesCountView.class;
        m5664a(this, getContext());
        this.f5225b = this.f5224a.m5645a(this);
        this.f5225b.m5642a();
        setTextAppearance(context, 2131625258);
        int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
        setPadding(0, applyDimension, 0, applyDimension);
    }
}

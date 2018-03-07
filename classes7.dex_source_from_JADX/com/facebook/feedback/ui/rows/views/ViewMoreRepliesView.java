package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reshare */
public class ViewMoreRepliesView extends FbTextView {
    @Inject
    public CommentBackgroundUtil f5230a;

    public static void m5666a(Object obj, Context context) {
        ((ViewMoreRepliesView) obj).f5230a = CommentBackgroundUtil.m4807a(FbInjector.get(context));
    }

    public ViewMoreRepliesView(Context context) {
        this(context, null);
    }

    private ViewMoreRepliesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ViewMoreRepliesView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ViewMoreRepliesView.class;
        m5666a(this, getContext());
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773287, typedValue, true);
        setTextAppearance(context, typedValue.resourceId);
        setBackgroundDrawable(this.f5230a.m4813a(context));
    }
}

package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.FbInjector;
import com.facebook.widget.accessibility.AccessibleTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: custom_properties */
public class CommentMetadataView extends AccessibleTextView {
    @Inject
    public CommentMetadataSpannableUtil f18153a;
    private CommentMetadataSpannableBuilderParams f18154b;
    private boolean f18155c;

    private static <T extends View> void m26705a(Class<T> cls, T t) {
        m26706a((Object) t, t.getContext());
    }

    private static void m26706a(Object obj, Context context) {
        ((CommentMetadataView) obj).f18153a = CommentMetadataSpannableUtil.m26698b(FbInjector.get(context));
    }

    private void m26704a(CommentMetadataSpannableUtil commentMetadataSpannableUtil) {
        this.f18153a = commentMetadataSpannableUtil;
    }

    public CommentMetadataView(Context context) {
        this(context, null);
    }

    public CommentMetadataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentMetadataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26705a(CommentMetadataView.class, (View) this);
        this.f18154b = new CommentMetadataSpannableBuilderParams(getContext());
        this.f18155c = m26707a();
    }

    public void setDelegate(CommentMetadataSpannableBuilder$Delegate commentMetadataSpannableBuilder$Delegate) {
        this.f18154b.f18145b = commentMetadataSpannableBuilder$Delegate;
    }

    public final void m26708a(GraphQLComment graphQLComment) {
        Preconditions.checkNotNull(graphQLComment);
        setTextSize(0, getResources().getDimension(2131428739));
        setText(this.f18153a.m26699a(this.f18154b, graphQLComment, this.f18155c));
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private boolean m26707a() {
        return ViewCompat.h(this) == 1;
    }
}

package com.facebook.resources.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: top_reactions */
public class FbAutoCompleteTextView extends FbResourcesAutoCompleteTextView {
    @Inject
    public InteractionEventListenerDispatcher f910a;

    private static <T extends View> void m1236a(Class<T> cls, T t) {
        m1237a((Object) t, t.getContext());
    }

    private static void m1237a(Object obj, Context context) {
        ((FbAutoCompleteTextView) obj).f910a = InteractionEventListenerDispatcher.a(FbInjector.get(context));
    }

    public FbAutoCompleteTextView(Context context) {
        super(context);
    }

    public FbAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1234a();
    }

    public FbAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1234a();
    }

    private void m1234a() {
        m1236a(FbAutoCompleteTextView.class, (View) this);
        addTextChangedListener(this.f910a);
    }

    private void m1235a(InteractionEventListenerDispatcher interactionEventListenerDispatcher) {
        this.f910a = interactionEventListenerDispatcher;
    }
}

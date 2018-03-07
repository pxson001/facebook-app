package com.facebook.resources.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: report_sticky_upsell_action */
public class FbEditText extends FbResourcesEditText {
    @Inject
    public InteractionEventListenerDispatcher f7463a;

    private static <T extends View> void m12079a(Class<T> cls, T t) {
        m12080a((Object) t, t.getContext());
    }

    private static void m12080a(Object obj, Context context) {
        ((FbEditText) obj).f7463a = InteractionEventListenerDispatcher.m6205a(FbInjector.get(context));
    }

    public FbEditText(Context context) {
        super(context);
    }

    public FbEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1661a();
    }

    public FbEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1661a();
    }

    private void mo1661a() {
        m12079a(FbEditText.class, (View) this);
        addTextChangedListener(this.f7463a);
    }

    private void m12078a(InteractionEventListenerDispatcher interactionEventListenerDispatcher) {
        this.f7463a = interactionEventListenerDispatcher;
    }
}

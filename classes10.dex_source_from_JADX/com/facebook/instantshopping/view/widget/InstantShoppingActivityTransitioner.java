package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule;
import com.facebook.richdocument.view.widget.RichDocumentActivityTransitioner;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SHOW_INCALL */
public class InstantShoppingActivityTransitioner extends RichDocumentActivityTransitioner {
    @Inject
    public AutoQESpecForInstantShoppingAbtestModule f23874e;

    private static <T extends View> void m25152a(Class<T> cls, T t) {
        m25153a((Object) t, t.getContext());
    }

    private static void m25153a(Object obj, Context context) {
        ((InstantShoppingActivityTransitioner) obj).f23874e = AutoQESpecForInstantShoppingAbtestModule.a(FbInjector.get(context));
    }

    public InstantShoppingActivityTransitioner(Context context) {
        super(context);
        m25152a(InstantShoppingActivityTransitioner.class, (View) this);
    }

    public InstantShoppingActivityTransitioner(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m25152a(InstantShoppingActivityTransitioner.class, (View) this);
    }

    private void m25151a(AutoQESpecForInstantShoppingAbtestModule autoQESpecForInstantShoppingAbtestModule) {
        this.f23874e = autoQESpecForInstantShoppingAbtestModule;
    }

    public InstantShoppingActivityTransitioner(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25152a(InstantShoppingActivityTransitioner.class, (View) this);
    }

    public final boolean m25154a() {
        if (this.f23874e.b().a.a("disable_swipe_to_close", false)) {
            return false;
        }
        return true;
    }
}

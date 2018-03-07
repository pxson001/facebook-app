package com.facebook.richdocument.view.transition;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: originalWebsite */
public class TransitionSpring implements InjectableComponentWithContext {
    private static final SpringConfig f6985b = SpringConfig.b((double) RichDocumentUIConfig.f6548a, (double) RichDocumentUIConfig.f6549b);
    @Inject
    public SpringSystem f6986a;
    public Spring f6987c;
    private final Context f6988d;
    public TransitionState f6989e;

    public static void m7285a(Object obj, Context context) {
        ((TransitionSpring) obj).f6986a = SpringSystem.b(FbInjector.get(context));
    }

    public TransitionSpring(Context context) {
        this.f6988d = context;
        Class cls = TransitionSpring.class;
        m7285a(this, getContext());
        Spring c = this.f6986a.a().a(f6985b).c(0.0d);
        c.l = (double) RichDocumentUIConfig.f6550c;
        c = c;
        c.c = false;
        this.f6987c = c.l();
    }

    public Context getContext() {
        return this.f6988d;
    }
}

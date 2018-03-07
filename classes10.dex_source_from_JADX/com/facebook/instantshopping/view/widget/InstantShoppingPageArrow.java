package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.android.maps.internal.ValueAnimator;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorUpdateListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SHARING */
public class InstantShoppingPageArrow extends ScrollValueChangedEventSubscriber {
    private static InstantShoppingPageArrow f23885i;
    private static final Object f23886j = new Object();
    private final Display f23887a;
    private final Point f23888b = new Point();
    private final RichDocumentEventBus f23889c;
    public ImageView f23890d;
    private final Context f23891e;
    public final int f23892f;
    private final ValueAnimator f23893g = ValueAnimator.a(0.0f, 1.0f);
    private int f23894h;

    /* compiled from: SHARING */
    class C34271 implements AnimatorUpdateListener {
        final /* synthetic */ InstantShoppingPageArrow f23884a;

        C34271(InstantShoppingPageArrow instantShoppingPageArrow) {
            this.f23884a = instantShoppingPageArrow;
        }

        public final void m25171a(ValueAnimator valueAnimator) {
            double d = (double) this.f23884a.f23892f;
            this.f23884a.f23890d.setTranslationY((float) ((int) Math.round(Math.sin((((double) valueAnimator.C) * 3.141592653589793d) * 2.0d) * d)));
        }
    }

    private static InstantShoppingPageArrow m25173b(InjectorLike injectorLike) {
        return new InstantShoppingPageArrow((Context) injectorLike.getInstance(Context.class), RichDocumentEventBus.a(injectorLike));
    }

    public final void m25175b(FbEvent fbEvent) {
        this.f23894h += ((ScrollValueChangedEvent) fbEvent).b;
        float f = (float) (this.f23888b.y / 10);
        this.f23890d.setAlpha((f - Math.min(f, (float) this.f23894h)) / f);
        this.f23890d.requestLayout();
        if (this.f23890d.getAlpha() == 0.0f && this.f23893g.e()) {
            this.f23893g.d();
        } else if (this.f23890d.getAlpha() > 0.0f && !this.f23893g.e()) {
            this.f23893g.c();
        }
    }

    @Inject
    public InstantShoppingPageArrow(Context context, RichDocumentEventBus richDocumentEventBus) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f23889c = richDocumentEventBus;
        this.f23889c.a(this);
        this.f23887a = windowManager.getDefaultDisplay();
        this.f23891e = context;
        this.f23892f = Math.round(TypedValue.applyDimension(1, (float) RichDocumentUIConfig.p, this.f23891e.getResources().getDisplayMetrics()));
    }

    public final void m25174a(View view) {
        this.f23890d = (ImageView) view.findViewById(2131563310);
        this.f23893g.a(new LinearInterpolator());
        this.f23893g.x = -1;
        this.f23893g.a((long) RichDocumentUIConfig.o);
        this.f23893g.A = this.f23890d;
        this.f23893g.a(new C34271(this));
        this.f23887a.getSize(this.f23888b);
    }

    public static InstantShoppingPageArrow m25172a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingPageArrow b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23886j) {
                InstantShoppingPageArrow instantShoppingPageArrow;
                if (a2 != null) {
                    instantShoppingPageArrow = (InstantShoppingPageArrow) a2.a(f23886j);
                } else {
                    instantShoppingPageArrow = f23885i;
                }
                if (instantShoppingPageArrow == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25173b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23886j, b3);
                        } else {
                            f23885i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingPageArrow;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

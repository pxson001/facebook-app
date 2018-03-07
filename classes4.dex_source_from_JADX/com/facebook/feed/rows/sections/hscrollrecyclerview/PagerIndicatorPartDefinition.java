package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.PageIndicatorCurrentPositionState;
import com.facebook.feed.rows.core.persistence.PageIndicatorCurrentPositionStateKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;
import javax.inject.Inject;

@ContextScoped
/* compiled from: og_post_id */
public class PagerIndicatorPartDefinition extends BaseSinglePartDefinition<Props, State, HasPersistentState, RowViewPagerIndicator> {
    private static PagerIndicatorPartDefinition f6286b;
    private static final Object f6287c = new Object();
    private final Context f6288a;

    private static PagerIndicatorPartDefinition m6747b(InjectorLike injectorLike) {
        return new PagerIndicatorPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    private static void m6748b(RowViewPagerIndicator rowViewPagerIndicator, int i, int i2, int i3, int i4, int i5, PageIndicatorCurrentPositionState pageIndicatorCurrentPositionState) {
        pageIndicatorCurrentPositionState.a = i2;
        if (rowViewPagerIndicator != null) {
            HScrollCirclePageIndicator hScrollCirclePageIndicator = rowViewPagerIndicator.b;
            boolean z = i == 0 || i == i5 - 1;
            hScrollCirclePageIndicator.setCount(i4);
            hScrollCirclePageIndicator.a(i3, i2, z);
        }
    }

    public final Object m6749a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        OnPageChangedListener onPageChangedListener = props.d;
        onPageChangedListener.a = props.b;
        onPageChangedListener.b = props.c;
        Style style = props.e;
        float f = this.f6288a.getResources().getDisplayMetrics().density * 3.0f;
        GradientDrawable a = m6742a(style);
        onPageChangedListener.e = (PageIndicatorCurrentPositionState) hasPersistentState.a(new PageIndicatorCurrentPositionStateKey(props.a));
        int i = onPageChangedListener.a % style.e;
        int i2 = onPageChangedListener.e.a;
        PageIndicatorCurrentPositionState pageIndicatorCurrentPositionState = onPageChangedListener.e;
        if (i2 < 0 || onPageChangedListener.a <= 0) {
            i2 = i;
        }
        pageIndicatorCurrentPositionState.a = i2;
        return new State(a, f, style);
    }

    public final /* bridge */ /* synthetic */ void m6750a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1535802983);
        m6744a((Props) obj, (State) obj2, (RowViewPagerIndicator) view);
        Logger.a(8, EntryType.MARK_POP, 372778080, a);
    }

    public final void m6751b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Props) obj).d.d = null;
    }

    public static PagerIndicatorPartDefinition m6743a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagerIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6287c) {
                PagerIndicatorPartDefinition pagerIndicatorPartDefinition;
                if (a2 != null) {
                    pagerIndicatorPartDefinition = (PagerIndicatorPartDefinition) a2.a(f6287c);
                } else {
                    pagerIndicatorPartDefinition = f6286b;
                }
                if (pagerIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6747b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6287c, b3);
                        } else {
                            f6286b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagerIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagerIndicatorPartDefinition(Context context) {
        this.f6288a = context;
    }

    private void m6744a(Props props, State state, RowViewPagerIndicator rowViewPagerIndicator) {
        props.d.d = rowViewPagerIndicator;
        props.d.c = state.c.e;
        HScrollCirclePageIndicator hScrollCirclePageIndicator = rowViewPagerIndicator.b;
        PageIndicatorCurrentPositionState pageIndicatorCurrentPositionState = props.d.e;
        m6748b(rowViewPagerIndicator, pageIndicatorCurrentPositionState.a, pageIndicatorCurrentPositionState.a, props.d.a, props.d.b, state.c.e, pageIndicatorCurrentPositionState);
        float f = state.b;
        Drawable drawable = state.a;
        Style style = state.c;
        hScrollCirclePageIndicator.setFillColor(style.a);
        hScrollCirclePageIndicator.setPageColor(style.b);
        hScrollCirclePageIndicator.setStrokeWidth(0.0f);
        hScrollCirclePageIndicator.setRadius(f);
        hScrollCirclePageIndicator.setArrowStrokeWidth(2);
        hScrollCirclePageIndicator.setArrowColor(style.a);
        hScrollCirclePageIndicator.s = 25;
        hScrollCirclePageIndicator.q = 1.0f;
        hScrollCirclePageIndicator.setMaxCircles(style.e);
        hScrollCirclePageIndicator.r = 4.0f;
        CustomViewUtils.b(hScrollCirclePageIndicator, drawable);
    }

    private GradientDrawable m6742a(Style style) {
        int dimensionPixelSize = this.f6288a.getResources().getDimensionPixelSize(2131428931);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(0, style.c);
        float[] fArr = new float[8];
        int i = 0;
        while (i < 8) {
            fArr[i] = i >= 4 ? (float) dimensionPixelSize : 0.1f;
            i++;
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(style.d);
        return gradientDrawable;
    }

    public static int m6746b(int i, int i2, int i3, int i4) {
        int i5;
        if (i3 > i) {
            if (i2 < i4 - 1) {
                i2++;
            }
            i5 = i2;
        } else if (i3 < i) {
            if (i2 > 0) {
                i2--;
            }
            i5 = i2;
        } else {
            i5 = i2;
        }
        if (i3 == 0) {
            return 0;
        }
        return i5;
    }
}

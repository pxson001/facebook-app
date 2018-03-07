package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerIndicatorPartDefinition.OnPageChangedListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerIndicatorPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ok_clicked */
public class FeedUnitPagerIndicatorPartDefinition<T extends ScrollableItemListFeedUnit, E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<T>, Void, E, RowViewPagerIndicator> {
    private static FeedUnitPagerIndicatorPartDefinition f6281d;
    private static final Object f6282e = new Object();
    private final PagerIndicatorPartDefinition f6283a;
    private final BackgroundPartDefinition f6284b;
    private final PaddingStyle f6285c;

    private static FeedUnitPagerIndicatorPartDefinition m6737b(InjectorLike injectorLike) {
        return new FeedUnitPagerIndicatorPartDefinition(PagerIndicatorPartDefinition.m6743a(injectorLike), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m6740a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = (FeedUnitAndChangePageListener) obj;
        subParts.a(this.f6283a, new Props(((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.f6289a.a).g(), ((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.f6289a.a).ac_(), ((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.f6289a.a).v().size(), feedUnitAndChangePageListener.f6290b));
        subParts.a(this.f6284b, new StylingData(feedUnitAndChangePageListener.f6289a, this.f6285c, Position.BOTTOM));
        return null;
    }

    @Inject
    public FeedUnitPagerIndicatorPartDefinition(PagerIndicatorPartDefinition pagerIndicatorPartDefinition, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f6283a = pagerIndicatorPartDefinition;
        this.f6284b = backgroundPartDefinition;
        Builder e = Builder.e();
        e.d = 0.0f;
        e = e;
        e.b = 0.0f;
        e = e;
        e.c = defaultPaddingStyleResolver.c() - defaultPaddingStyleResolver.e();
        this.f6285c = e.i();
    }

    public final ViewType m6739a() {
        return RowViewPagerIndicator.a;
    }

    public final boolean m6741a(Object obj) {
        return true;
    }

    public static FeedUnitPagerIndicatorPartDefinition m6736a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedUnitPagerIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6282e) {
                FeedUnitPagerIndicatorPartDefinition feedUnitPagerIndicatorPartDefinition;
                if (a2 != null) {
                    feedUnitPagerIndicatorPartDefinition = (FeedUnitPagerIndicatorPartDefinition) a2.a(f6282e);
                } else {
                    feedUnitPagerIndicatorPartDefinition = f6281d;
                }
                if (feedUnitPagerIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6737b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6282e, b3);
                        } else {
                            f6281d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedUnitPagerIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static OnPageChangedListener m6738b() {
        return new OnPageChangedListener();
    }
}

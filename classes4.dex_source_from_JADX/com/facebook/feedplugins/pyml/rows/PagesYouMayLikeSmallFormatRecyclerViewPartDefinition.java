package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onPrepared for %s */
public class PagesYouMayLikeSmallFormatRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLCreativePagesYouMayLikeFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PagesYouMayLikeSmallFormatRecyclerViewPartDefinition f6135b;
    private static final Object f6136c = new Object();
    private final PagesYouMayLikeSmallFormatHScrollPartDefinition<HScrollRecyclerView, E> f6137a;

    private static PagesYouMayLikeSmallFormatRecyclerViewPartDefinition m6613b(InjectorLike injectorLike) {
        return new PagesYouMayLikeSmallFormatRecyclerViewPartDefinition(PagesYouMayLikeSmallFormatHScrollPartDefinition.m6617a(injectorLike));
    }

    public final Object m6615a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6137a, (FeedProps) obj);
        return null;
    }

    @Inject
    public PagesYouMayLikeSmallFormatRecyclerViewPartDefinition(PagesYouMayLikeSmallFormatHScrollPartDefinition pagesYouMayLikeSmallFormatHScrollPartDefinition) {
        this.f6137a = pagesYouMayLikeSmallFormatHScrollPartDefinition;
    }

    public final ViewType m6614a() {
        return HScrollRecyclerViewRowType.f11901a;
    }

    public final boolean m6616a(Object obj) {
        return true;
    }

    public static PagesYouMayLikeSmallFormatRecyclerViewPartDefinition m6612a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeSmallFormatRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6136c) {
                PagesYouMayLikeSmallFormatRecyclerViewPartDefinition pagesYouMayLikeSmallFormatRecyclerViewPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeSmallFormatRecyclerViewPartDefinition = (PagesYouMayLikeSmallFormatRecyclerViewPartDefinition) a2.a(f6136c);
                } else {
                    pagesYouMayLikeSmallFormatRecyclerViewPartDefinition = f6135b;
                }
                if (pagesYouMayLikeSmallFormatRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6613b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6136c, b3);
                        } else {
                            f6135b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeSmallFormatRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

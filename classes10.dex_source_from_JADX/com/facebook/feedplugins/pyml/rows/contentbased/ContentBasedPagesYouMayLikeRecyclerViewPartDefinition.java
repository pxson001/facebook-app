package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
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
/* compiled from: android.intent.extra.NOT_UNKNOWN_SOURCE */
public class ContentBasedPagesYouMayLikeRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPagesYouMayLikeFeedUnit>, Void, E, HScrollRecyclerView> {
    private static ContentBasedPagesYouMayLikeRecyclerViewPartDefinition f19871b;
    private static final Object f19872c = new Object();
    private final ContentBasedPagesYouMayLikeHScrollPartDefinition<HScrollRecyclerView, E> f19873a;

    private static ContentBasedPagesYouMayLikeRecyclerViewPartDefinition m20087b(InjectorLike injectorLike) {
        return new ContentBasedPagesYouMayLikeRecyclerViewPartDefinition(ContentBasedPagesYouMayLikeHScrollPartDefinition.m20072a(injectorLike));
    }

    public final Object m20089a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f19873a, (FeedProps) obj);
        return null;
    }

    @Inject
    public ContentBasedPagesYouMayLikeRecyclerViewPartDefinition(ContentBasedPagesYouMayLikeHScrollPartDefinition contentBasedPagesYouMayLikeHScrollPartDefinition) {
        this.f19873a = contentBasedPagesYouMayLikeHScrollPartDefinition;
    }

    public final ViewType m20088a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m20090a(Object obj) {
        return true;
    }

    public static ContentBasedPagesYouMayLikeRecyclerViewPartDefinition m20086a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPagesYouMayLikeRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19872c) {
                ContentBasedPagesYouMayLikeRecyclerViewPartDefinition contentBasedPagesYouMayLikeRecyclerViewPartDefinition;
                if (a2 != null) {
                    contentBasedPagesYouMayLikeRecyclerViewPartDefinition = (ContentBasedPagesYouMayLikeRecyclerViewPartDefinition) a2.a(f19872c);
                } else {
                    contentBasedPagesYouMayLikeRecyclerViewPartDefinition = f19871b;
                }
                if (contentBasedPagesYouMayLikeRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20087b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19872c, b3);
                        } else {
                            f19871b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPagesYouMayLikeRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

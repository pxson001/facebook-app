package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onSizeChanged() called on unbound View */
public class PagesYouMayLikeSmallFormatPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider & HasPersistentState & HasContext> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLCreativePagesYouMayLikeFeedUnit>, Void, E> {
    private static PagesYouMayLikeSmallFormatPartDefinition f6126c;
    private static final Object f6127d = new Object();
    private final PagesYouMayLikeSmallFormatHeaderPartDefinition<E> f6128a;
    private final PagesYouMayLikeSmallFormatRecyclerViewPartDefinition<E> f6129b;

    private static PagesYouMayLikeSmallFormatPartDefinition m6603b(InjectorLike injectorLike) {
        return new PagesYouMayLikeSmallFormatPartDefinition(PagesYouMayLikeSmallFormatHeaderPartDefinition.m6606a(injectorLike), PagesYouMayLikeSmallFormatRecyclerViewPartDefinition.m6612a(injectorLike));
    }

    public final Object m6604a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f6128a, feedProps);
        baseMultiRowSubParts.a(this.f6129b, feedProps);
        return null;
    }

    @Inject
    public PagesYouMayLikeSmallFormatPartDefinition(PagesYouMayLikeSmallFormatHeaderPartDefinition pagesYouMayLikeSmallFormatHeaderPartDefinition, PagesYouMayLikeSmallFormatRecyclerViewPartDefinition pagesYouMayLikeSmallFormatRecyclerViewPartDefinition) {
        this.f6128a = pagesYouMayLikeSmallFormatHeaderPartDefinition;
        this.f6129b = pagesYouMayLikeSmallFormatRecyclerViewPartDefinition;
    }

    public final boolean m6605a(Object obj) {
        return true;
    }

    public static PagesYouMayLikeSmallFormatPartDefinition m6602a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeSmallFormatPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6127d) {
                PagesYouMayLikeSmallFormatPartDefinition pagesYouMayLikeSmallFormatPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeSmallFormatPartDefinition = (PagesYouMayLikeSmallFormatPartDefinition) a2.a(f6127d);
                } else {
                    pagesYouMayLikeSmallFormatPartDefinition = f6126c;
                }
                if (pagesYouMayLikeSmallFormatPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6603b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6127d, b3);
                        } else {
                            f6126c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeSmallFormatPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

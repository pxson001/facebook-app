package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
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
/* compiled from: android.intent.extra.REFERRER */
public class ContentBasedPagesYouMayLikePartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPagesYouMayLikeFeedUnit>, Void, FeedEnvironment> {
    private static ContentBasedPagesYouMayLikePartDefinition f19866d;
    private static final Object f19867e = new Object();
    private final ContentBasedPagesYouMayLikeHeaderPartDefinition<FeedEnvironment> f19868a;
    private final ContentBasedPagesYouMayLikeRecyclerViewPartDefinition<FeedEnvironment> f19869b;
    private final ContentBasedPagesYouMayLikeFooterPartDefinition f19870c;

    private static ContentBasedPagesYouMayLikePartDefinition m20083b(InjectorLike injectorLike) {
        return new ContentBasedPagesYouMayLikePartDefinition(ContentBasedPagesYouMayLikeHeaderPartDefinition.m20076a(injectorLike), ContentBasedPagesYouMayLikeRecyclerViewPartDefinition.m20086a(injectorLike), ContentBasedPagesYouMayLikeFooterPartDefinition.m20065a(injectorLike));
    }

    public final Object m20084a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f19868a, feedProps);
        baseMultiRowSubParts.a(this.f19869b, feedProps);
        baseMultiRowSubParts.a(this.f19870c, graphQLPagesYouMayLikeFeedUnit);
        return null;
    }

    @Inject
    public ContentBasedPagesYouMayLikePartDefinition(ContentBasedPagesYouMayLikeHeaderPartDefinition contentBasedPagesYouMayLikeHeaderPartDefinition, ContentBasedPagesYouMayLikeRecyclerViewPartDefinition contentBasedPagesYouMayLikeRecyclerViewPartDefinition, ContentBasedPagesYouMayLikeFooterPartDefinition contentBasedPagesYouMayLikeFooterPartDefinition) {
        this.f19868a = contentBasedPagesYouMayLikeHeaderPartDefinition;
        this.f19869b = contentBasedPagesYouMayLikeRecyclerViewPartDefinition;
        this.f19870c = contentBasedPagesYouMayLikeFooterPartDefinition;
    }

    public final boolean m20085a(Object obj) {
        return true;
    }

    public static ContentBasedPagesYouMayLikePartDefinition m20082a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPagesYouMayLikePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19867e) {
                ContentBasedPagesYouMayLikePartDefinition contentBasedPagesYouMayLikePartDefinition;
                if (a2 != null) {
                    contentBasedPagesYouMayLikePartDefinition = (ContentBasedPagesYouMayLikePartDefinition) a2.a(f19867e);
                } else {
                    contentBasedPagesYouMayLikePartDefinition = f19866d;
                }
                if (contentBasedPagesYouMayLikePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20083b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19867e, b3);
                        } else {
                            f19866d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPagesYouMayLikePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

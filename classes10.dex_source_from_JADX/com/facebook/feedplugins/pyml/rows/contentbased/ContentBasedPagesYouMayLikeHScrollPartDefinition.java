package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.PymlSeeAllPagePartDefinition;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnitItemContentConnection;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.messenger.threadlist_background_loader.theme_attr_resolution_failed */
public class ContentBasedPagesYouMayLikeHScrollPartDefinition<V extends View, E extends HasPositionInformation & HasPersistentState & HasContext> extends BaseSinglePartDefinition<FeedProps<GraphQLPagesYouMayLikeFeedUnit>, Void, E, V> {
    public static final CallerContext f19852a = CallerContext.a(ContentBasedPagesYouMayLikeHScrollPartDefinition.class, "native_newsfeed", "actor_photo");
    private static ContentBasedPagesYouMayLikeHScrollPartDefinition f19853i;
    private static final Object f19854j = new Object();
    private final BackgroundPartDefinition f19855b;
    public final PymlFallbackPagePartDefinition f19856c;
    public final PymlPhotoPagePartDefinition f19857d;
    public final PymlSharePagePartDefinition f19858e;
    public final PymlSeeAllPagePartDefinition f19859f;
    private final PersistentRecyclerPartDefinition<Object, E> f19860g;
    private final PageStyleFactory f19861h;

    private static ContentBasedPagesYouMayLikeHScrollPartDefinition m20074b(InjectorLike injectorLike) {
        return new ContentBasedPagesYouMayLikeHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PymlFallbackPagePartDefinition.a(injectorLike), PymlPhotoPagePartDefinition.a(injectorLike), PymlSharePagePartDefinition.a(injectorLike), PymlSeeAllPagePartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike));
    }

    public final Object m20075a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) feedProps.a;
        PaddingStyle paddingStyle = PageStyle.a;
        final ImmutableList a = m20073a(graphQLPagesYouMayLikeFeedUnit.r());
        subParts.a(this.f19855b, new StylingData(feedProps, paddingStyle));
        subParts.a(this.f19860g, new Props(this.f19861h.a(paddingStyle), graphQLPagesYouMayLikeFeedUnit.ac_(), new SimpleCallbacks<E>(this) {
            final /* synthetic */ ContentBasedPagesYouMayLikeHScrollPartDefinition f19851c;

            public final void m20070a(PageSubParts<E> pageSubParts) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    SuggestedPageUnitItem suggestedPageUnitItem = (SuggestedPageUnitItem) a.get(i);
                    if (suggestedPageUnitItem.r()) {
                        pageSubParts.a(this.f19851c.f19859f, suggestedPageUnitItem);
                    } else {
                        PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps = new PagesYouMayLikeItemViewModelProps(graphQLPagesYouMayLikeFeedUnit, suggestedPageUnitItem);
                        GraphQLPagesYouMayLikeFeedUnitItemContentConnection q = suggestedPageUnitItem.q();
                        if (q != null) {
                            int i2;
                            if (q == null || q.a() == null || q.a().isEmpty() || ((GraphQLNode) q.a().get(0)).j() == null) {
                                i2 = 0;
                            } else {
                                i2 = ((GraphQLNode) q.a().get(0)).j().g();
                            }
                            switch (i2) {
                                case 77090322:
                                    pageSubParts.a(this.f19851c.f19857d, pagesYouMayLikeItemViewModelProps);
                                    continue;
                                case 80218325:
                                    pageSubParts.a(this.f19851c.f19858e, pagesYouMayLikeItemViewModelProps);
                                    continue;
                            }
                        }
                        pageSubParts.a(this.f19851c.f19856c, pagesYouMayLikeItemViewModelProps);
                    }
                }
            }

            public final void m20071c(int i) {
                VisibleItemHelper.a(graphQLPagesYouMayLikeFeedUnit, a, i);
            }
        }, graphQLPagesYouMayLikeFeedUnit.g(), graphQLPagesYouMayLikeFeedUnit));
        return null;
    }

    public static ContentBasedPagesYouMayLikeHScrollPartDefinition m20072a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPagesYouMayLikeHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19854j) {
                ContentBasedPagesYouMayLikeHScrollPartDefinition contentBasedPagesYouMayLikeHScrollPartDefinition;
                if (a2 != null) {
                    contentBasedPagesYouMayLikeHScrollPartDefinition = (ContentBasedPagesYouMayLikeHScrollPartDefinition) a2.a(f19854j);
                } else {
                    contentBasedPagesYouMayLikeHScrollPartDefinition = f19853i;
                }
                if (contentBasedPagesYouMayLikeHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20074b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19854j, b3);
                        } else {
                            f19853i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPagesYouMayLikeHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ContentBasedPagesYouMayLikeHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PymlFallbackPagePartDefinition pymlFallbackPagePartDefinition, PymlPhotoPagePartDefinition pymlPhotoPagePartDefinition, PymlSharePagePartDefinition pymlSharePagePartDefinition, PymlSeeAllPagePartDefinition pymlSeeAllPagePartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition) {
        this.f19855b = backgroundPartDefinition;
        this.f19856c = pymlFallbackPagePartDefinition;
        this.f19857d = pymlPhotoPagePartDefinition;
        this.f19858e = pymlSharePagePartDefinition;
        this.f19859f = pymlSeeAllPagePartDefinition;
        this.f19861h = pageStyleFactory;
        this.f19860g = persistentRecyclerPartDefinition;
    }

    private static ImmutableList<SuggestedPageUnitItem> m20073a(ImmutableList<SuggestedPageUnitItem> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SuggestedPageUnitItem suggestedPageUnitItem = (SuggestedPageUnitItem) immutableList.get(i);
            if (suggestedPageUnitItem.m() != null || suggestedPageUnitItem.r()) {
                builder.c(suggestedPageUnitItem);
            }
        }
        return builder.b();
    }
}

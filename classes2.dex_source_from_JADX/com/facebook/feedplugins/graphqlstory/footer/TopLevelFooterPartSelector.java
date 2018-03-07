package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.footer.components.DefaultFooterComponentPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.components.DefaultReactionsFooterComponentPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hash */
public class TopLevelFooterPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TopLevelFooterPartSelector f21220i;
    private static final Object f21221j = new Object();
    private final Lazy<FindFriendsFooterPartDefinition> f21222a;
    private final LiveVideoFooterPartDefinition<FeedEnvironment> f21223b;
    private final Lazy<LiveVideoCommercialBreakFooterPartDefinition> f21224c;
    private final Lazy<StoryEmptyFooterPartDefinition> f21225d;
    private final Lazy<DefaultReactionsFooterPartDefinition<FeedEnvironment>> f21226e;
    private final Lazy<DefaultFooterPartDefinition<FeedEnvironment>> f21227f;
    private final Lazy<DefaultFooterComponentPartDefinition<FeedEnvironment>> f21228g;
    private final Lazy<DefaultReactionsFooterComponentPartDefinition<FeedEnvironment>> f21229h;

    private static TopLevelFooterPartSelector m28949b(InjectorLike injectorLike) {
        return new TopLevelFooterPartSelector(IdBasedLazy.m1808a(injectorLike, 1866), IdBasedLazy.m1808a(injectorLike, 6306), IdBasedLazy.m1808a(injectorLike, 1869), LiveVideoFooterPartDefinition.m28952a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6304), IdBasedLazy.m1808a(injectorLike, 1865), IdBasedLazy.m1808a(injectorLike, 6307), IdBasedLazy.m1808a(injectorLike, 1874));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        boolean z;
        obj = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) obj.f13444a;
        FeedListType c = ((FeedEnvironment) anyEnvironment).mo2446c();
        if (c == null || c.mo2419a() != FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 == null) {
            z = true;
        } else {
            z = false;
        }
        SubPartsSelector.m19117a(baseMultiRowSubParts, z, this.f21222a, graphQLStory).m19121a(z, this.f21229h, obj).m19121a(z, this.f21226e, obj).m19118a(this.f21223b, obj).m19119a(this.f21224c, obj).m19121a(z, this.f21228g, obj).m19121a(z, this.f21227f, obj).m19119a(this.f21225d, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return m28948a((FeedProps) obj);
    }

    @Inject
    public TopLevelFooterPartSelector(Lazy<DefaultReactionsFooterPartDefinition> lazy, Lazy<StoryEmptyFooterPartDefinition> lazy2, Lazy<FindFriendsFooterPartDefinition> lazy3, LiveVideoFooterPartDefinition liveVideoFooterPartDefinition, Lazy<LiveVideoCommercialBreakFooterPartDefinition> lazy4, Lazy<DefaultFooterPartDefinition> lazy5, Lazy<DefaultFooterComponentPartDefinition> lazy6, Lazy<DefaultReactionsFooterComponentPartDefinition> lazy7) {
        this.f21222a = lazy3;
        this.f21223b = liveVideoFooterPartDefinition;
        this.f21224c = lazy4;
        this.f21225d = lazy2;
        this.f21228g = lazy6;
        this.f21229h = lazy7;
        this.f21226e = lazy;
        this.f21227f = lazy5;
    }

    public static TopLevelFooterPartSelector m28947a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopLevelFooterPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21221j) {
                TopLevelFooterPartSelector topLevelFooterPartSelector;
                if (a2 != null) {
                    topLevelFooterPartSelector = (TopLevelFooterPartSelector) a2.mo818a(f21221j);
                } else {
                    topLevelFooterPartSelector = f21220i;
                }
                if (topLevelFooterPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28949b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21221j, b3);
                        } else {
                            f21220i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = topLevelFooterPartSelector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static boolean m28948a(FeedProps<GraphQLStory> feedProps) {
        return !StoryProps.m27463k(feedProps);
    }
}

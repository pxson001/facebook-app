package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.FollowableHeaderComponentPartDefinition;
import com.facebook.feed.rows.sections.header.components.HeaderWithSeeFirstComponentPartDefinition;
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
/* compiled from: initial capacity was already set to %s */
public class HeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static HeaderSelectorPartDefinition f20056j;
    private static final Object f20057k = new Object();
    private final Lazy<DefaultHeaderSelectorPartDefinition> f20058a;
    private final Lazy<FollowableHeaderPartDefinition<FeedEnvironment>> f20059b;
    private final Lazy<FollowableHeaderComponentPartDefinition<FeedEnvironment>> f20060c;
    private final Lazy<FriendableHeaderPartDefinition> f20061d;
    private final Lazy<HeaderWithSeeFirstComponentPartDefinition<FeedEnvironment>> f20062e;
    private final Lazy<HeaderWithSeeFirstLayoutPartDefinition<FeedEnvironment>> f20063f;
    private final Lazy<LikableHeaderSelectorPartDefinition> f20064g;
    private final Lazy<HeaderWithClientRankBumpedLayoutPartDefinition<FeedEnvironment>> f20065h;
    private final Lazy<PageOutcomeButtonHeaderPartDefinition<FeedEnvironment>> f20066i;

    private static HeaderSelectorPartDefinition m27778b(InjectorLike injectorLike) {
        return new HeaderSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1591), IdBasedLazy.m1808a(injectorLike, 1601), IdBasedLazy.m1808a(injectorLike, 1640), IdBasedLazy.m1808a(injectorLike, 1602), IdBasedLazy.m1808a(injectorLike, 1657), IdBasedLazy.m1808a(injectorLike, 1608), IdBasedLazy.m1808a(injectorLike, 1610), IdBasedLazy.m1808a(injectorLike, 1607), IdBasedLazy.m1808a(injectorLike, 1613));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        SubPartsSelector a = SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20064g, obj).m19119a(this.f20060c, obj);
        if (feedEnvironment.mo2446c().mo2419a() == FeedListName.FEED) {
            z = true;
        } else {
            z = false;
        }
        a.m19121a(z, this.f20066i, obj).m19119a(this.f20059b, obj).m19119a(this.f20061d, obj).m19119a(this.f20062e, obj).m19119a(this.f20063f, obj).m19119a(this.f20065h, obj).m19119a(this.f20058a, obj);
        return null;
    }

    @Inject
    public HeaderSelectorPartDefinition(Lazy<DefaultHeaderSelectorPartDefinition> lazy, Lazy<FollowableHeaderPartDefinition> lazy2, Lazy<FollowableHeaderComponentPartDefinition> lazy3, Lazy<FriendableHeaderPartDefinition> lazy4, Lazy<HeaderWithSeeFirstComponentPartDefinition> lazy5, Lazy<HeaderWithSeeFirstLayoutPartDefinition> lazy6, Lazy<LikableHeaderSelectorPartDefinition> lazy7, Lazy<HeaderWithClientRankBumpedLayoutPartDefinition> lazy8, Lazy<PageOutcomeButtonHeaderPartDefinition> lazy9) {
        this.f20058a = lazy;
        this.f20059b = lazy2;
        this.f20060c = lazy3;
        this.f20061d = lazy4;
        this.f20062e = lazy5;
        this.f20063f = lazy6;
        this.f20064g = lazy7;
        this.f20065h = lazy8;
        this.f20066i = lazy9;
    }

    public static HeaderSelectorPartDefinition m27777a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20057k) {
                HeaderSelectorPartDefinition headerSelectorPartDefinition;
                if (a2 != null) {
                    headerSelectorPartDefinition = (HeaderSelectorPartDefinition) a2.mo818a(f20057k);
                } else {
                    headerSelectorPartDefinition = f20056j;
                }
                if (headerSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27778b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20057k, b3);
                        } else {
                            f20056j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }
}

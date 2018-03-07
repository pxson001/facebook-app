package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
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
/* compiled from: com.facebook.catalyst.react.dialog.DialogModule */
public class FriendsLocationsPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLFriendsLocationsFeedUnit>, Void, FeedEnvironment> {
    private static FriendsLocationsPartDefinition f8508e;
    private static final Object f8509f = new Object();
    private final FriendsLocationHScrollPartDefinition<FeedEnvironment> f8510a;
    private final FriendsLocationsFooterPartDefinition f8511b;
    private final FriendsLocationsSubtitlePartDefinition f8512c;
    private final FriendsLocationsHeaderPartDefinition<FeedEnvironment> f8513d;

    private static FriendsLocationsPartDefinition m9384b(InjectorLike injectorLike) {
        return new FriendsLocationsPartDefinition(FriendsLocationsHeaderPartDefinition.m9377a(injectorLike), FriendsLocationsSubtitlePartDefinition.m9399a(injectorLike), FriendsLocationsFooterPartDefinition.m9372a(injectorLike), FriendsLocationHScrollPartDefinition.m9343a(injectorLike));
    }

    public final Object m9385a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f8513d, feedProps);
        baseMultiRowSubParts.a(this.f8512c, feedProps);
        baseMultiRowSubParts.a(this.f8510a, feedProps);
        baseMultiRowSubParts.a(this.f8511b, graphQLFriendsLocationsFeedUnit);
        return null;
    }

    public final boolean m9386a(Object obj) {
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) ((FeedProps) obj).a;
        return (graphQLFriendsLocationsFeedUnit == null || ScrollableItemListFeedUnitImpl.a(graphQLFriendsLocationsFeedUnit).isEmpty()) ? false : true;
    }

    @Inject
    public FriendsLocationsPartDefinition(FriendsLocationsHeaderPartDefinition friendsLocationsHeaderPartDefinition, FriendsLocationsSubtitlePartDefinition friendsLocationsSubtitlePartDefinition, FriendsLocationsFooterPartDefinition friendsLocationsFooterPartDefinition, FriendsLocationHScrollPartDefinition friendsLocationHScrollPartDefinition) {
        this.f8510a = friendsLocationHScrollPartDefinition;
        this.f8511b = friendsLocationsFooterPartDefinition;
        this.f8512c = friendsLocationsSubtitlePartDefinition;
        this.f8513d = friendsLocationsHeaderPartDefinition;
    }

    public static FriendsLocationsPartDefinition m9383a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8509f) {
                FriendsLocationsPartDefinition friendsLocationsPartDefinition;
                if (a2 != null) {
                    friendsLocationsPartDefinition = (FriendsLocationsPartDefinition) a2.a(f8509f);
                } else {
                    friendsLocationsPartDefinition = f8508e;
                }
                if (friendsLocationsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9384b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8509f, b3);
                        } else {
                            f8508e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

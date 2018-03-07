package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
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
/* compiled from: creation_tab_upsell */
public class InstagramPhotosFromFriendsPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, Void, FeedEnvironment> {
    private static InstagramPhotosFromFriendsPartDefinition f7914d;
    private static final Object f7915e = new Object();
    private final InstagramPhotosFromFriendsFooterPartDefinition f7916a;
    private final InstagramPhotosFromFriendsHScrollPartDefinition<FeedEnvironment> f7917b;
    private final InstagramPhotosFromFriendsHeaderPartDefinition f7918c;

    private static InstagramPhotosFromFriendsPartDefinition m9007b(InjectorLike injectorLike) {
        return new InstagramPhotosFromFriendsPartDefinition(InstagramPhotosFromFriendsHeaderPartDefinition.m9000a(injectorLike), InstagramPhotosFromFriendsHScrollPartDefinition.m8995a(injectorLike), InstagramPhotosFromFriendsFooterPartDefinition.m8984a(injectorLike));
    }

    public final Object m9008a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f7918c, feedProps);
        baseMultiRowSubParts.a(this.f7917b, feedProps);
        baseMultiRowSubParts.a(this.f7916a, feedProps.a);
        return null;
    }

    @Inject
    public InstagramPhotosFromFriendsPartDefinition(InstagramPhotosFromFriendsHeaderPartDefinition instagramPhotosFromFriendsHeaderPartDefinition, InstagramPhotosFromFriendsHScrollPartDefinition instagramPhotosFromFriendsHScrollPartDefinition, InstagramPhotosFromFriendsFooterPartDefinition instagramPhotosFromFriendsFooterPartDefinition) {
        this.f7916a = instagramPhotosFromFriendsFooterPartDefinition;
        this.f7917b = instagramPhotosFromFriendsHScrollPartDefinition;
        this.f7918c = instagramPhotosFromFriendsHeaderPartDefinition;
    }

    public final boolean m9009a(Object obj) {
        return true;
    }

    public static InstagramPhotosFromFriendsPartDefinition m9006a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotosFromFriendsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7915e) {
                InstagramPhotosFromFriendsPartDefinition instagramPhotosFromFriendsPartDefinition;
                if (a2 != null) {
                    instagramPhotosFromFriendsPartDefinition = (InstagramPhotosFromFriendsPartDefinition) a2.a(f7915e);
                } else {
                    instagramPhotosFromFriendsPartDefinition = f7914d;
                }
                if (instagramPhotosFromFriendsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9007b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7915e, b3);
                        } else {
                            f7914d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotosFromFriendsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

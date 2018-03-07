package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cta_action */
public class InstagramPhotosFromFriendsHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, Void, HasPositionInformation, InstagramPhotosFromFriendsHeaderView> {
    private static InstagramPhotosFromFriendsHeaderPartDefinition f7906e;
    private static final Object f7907f = new Object();
    private final Context f7908a;
    private final InstagramUtils f7909b;
    private final BackgroundPartDefinition f7910c;
    private final TextPartDefinition f7911d;

    private static InstagramPhotosFromFriendsHeaderPartDefinition m9001b(InjectorLike injectorLike) {
        return new InstagramPhotosFromFriendsHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), InstagramUtils.a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m9003a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object string;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) feedProps.a;
        this.f7909b.b(InstagramEntryPoint.Ego);
        if (this.f7909b.d() > 0) {
            string = this.f7908a.getResources().getString(2131233572, new Object[]{Integer.valueOf(r1)});
        } else {
            int size = graphQLInstagramPhotosFromFriendsFeedUnit.l().size();
            string = this.f7908a.getResources().getString(2131233568, new Object[]{Integer.valueOf(size)});
        }
        subParts.a(this.f7910c, new StylingData(feedProps, PaddingStyle.j));
        subParts.a(2131562912, this.f7911d, string);
        return null;
    }

    @Inject
    public InstagramPhotosFromFriendsHeaderPartDefinition(Context context, InstagramUtils instagramUtils, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f7908a = context;
        this.f7909b = instagramUtils;
        this.f7910c = backgroundPartDefinition;
        this.f7911d = textPartDefinition;
    }

    public final ViewType m9002a() {
        return InstagramPhotosFromFriendsHeaderView.f7912a;
    }

    public final boolean m9004a(Object obj) {
        return true;
    }

    public static InstagramPhotosFromFriendsHeaderPartDefinition m9000a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotosFromFriendsHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7907f) {
                InstagramPhotosFromFriendsHeaderPartDefinition instagramPhotosFromFriendsHeaderPartDefinition;
                if (a2 != null) {
                    instagramPhotosFromFriendsHeaderPartDefinition = (InstagramPhotosFromFriendsHeaderPartDefinition) a2.a(f7907f);
                } else {
                    instagramPhotosFromFriendsHeaderPartDefinition = f7906e;
                }
                if (instagramPhotosFromFriendsHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9001b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7907f, b3);
                        } else {
                            f7906e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotosFromFriendsHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

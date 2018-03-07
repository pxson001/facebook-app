package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.graphql.model.InstagramPhotosFromFriendsPhoto;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: curr_selected_payment_method_index */
public class InstagramPhotosFromFriendsFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLInstagramPhotosFromFriendsFeedUnit, Void, HasPositionInformation, InstagramPhotosFromFriendsFooterView> {
    private static InstagramPhotosFromFriendsFooterPartDefinition f7883g;
    private static final Object f7884h = new Object();
    private final Context f7885a;
    public final InstagramUtils f7886b;
    public final NewsFeedAnalyticsEventBuilder f7887c;
    private final ClickListenerPartDefinition f7888d;
    private final OneButtonFooterStylerPartDefinition f7889e;
    private final TextPartDefinition f7890f;

    private static InstagramPhotosFromFriendsFooterPartDefinition m8985b(InjectorLike injectorLike) {
        return new InstagramPhotosFromFriendsFooterPartDefinition(InstagramUtils.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m8987a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object string;
        final GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) obj;
        subParts.a(this.f7888d, new OnClickListener(this) {
            final /* synthetic */ InstagramPhotosFromFriendsFooterPartDefinition f7882b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -43087471);
                ArrayNode a2 = ((InstagramPhotosFromFriendsPhoto) ScrollableItemListFeedUnitImpl.a(graphQLInstagramPhotosFromFriendsFeedUnit).get(0)).a();
                this.f7882b.f7886b.a(view.getContext(), InstagramEntryPoint.Ego, null, a2);
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f7882b.f7887c;
                this.f7882b.f7886b.a(view.getContext(), NewsFeedAnalyticsEventBuilder.l(a2));
                Logger.a(2, EntryType.UI_INPUT_END, -1769423883, a);
            }
        });
        subParts.a(this.f7889e, null);
        if (this.f7886b.e()) {
            string = this.f7885a.getResources().getString(2131233573);
        } else {
            string = this.f7885a.getResources().getString(2131233566);
        }
        subParts.a(2131563200, this.f7890f, string);
        return null;
    }

    @Inject
    public InstagramPhotosFromFriendsFooterPartDefinition(InstagramUtils instagramUtils, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, ClickListenerPartDefinition clickListenerPartDefinition, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, TextPartDefinition textPartDefinition, Context context) {
        this.f7886b = instagramUtils;
        this.f7887c = newsFeedAnalyticsEventBuilder;
        this.f7888d = clickListenerPartDefinition;
        this.f7889e = oneButtonFooterStylerPartDefinition;
        this.f7890f = textPartDefinition;
        this.f7885a = context;
    }

    public final ViewType m8986a() {
        return InstagramPhotosFromFriendsFooterView.f7891a;
    }

    public static InstagramPhotosFromFriendsFooterPartDefinition m8984a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotosFromFriendsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7884h) {
                InstagramPhotosFromFriendsFooterPartDefinition instagramPhotosFromFriendsFooterPartDefinition;
                if (a2 != null) {
                    instagramPhotosFromFriendsFooterPartDefinition = (InstagramPhotosFromFriendsFooterPartDefinition) a2.a(f7884h);
                } else {
                    instagramPhotosFromFriendsFooterPartDefinition = f7883g;
                }
                if (instagramPhotosFromFriendsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8985b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7884h, b3);
                        } else {
                            f7883g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotosFromFriendsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m8988a(Object obj) {
        return true;
    }
}

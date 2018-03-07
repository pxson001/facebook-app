package com.facebook.feedplugins.graphqlstory.location;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.checkin.rows.BaseCheckinStoryPartDefinition;
import com.facebook.checkin.rows.BaseCheckinStoryPartDefinition.Props;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.feedplugins.graphqlstory.location.ui.ZeroLocationView;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.rows.TravelStoryHelper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: new_tab */
public class ZeroLocationPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, HoneyClientEvent, HasPositionInformation, ZeroLocationView> {
    public static final ViewType f7112a = new C03401();
    private static final PaddingStyle f7113b;
    private static ZeroLocationPartDefinition f7114i;
    private static final Object f7115j = new Object();
    private final BackgroundPartDefinition f7116c;
    private final CommonEventsBuilder f7117d;
    private final TextLinkPartDefinition f7118e;
    private final Provider<FbZeroFeatureVisibilityHelper> f7119f;
    private final BaseCheckinStoryPartDefinition f7120g;
    private final TravelStoryHelper f7121h;

    /* compiled from: new_tab */
    final class C03401 extends ViewType {
        C03401() {
        }

        public final View m7444a(Context context) {
            return new ZeroLocationView(context);
        }
    }

    private static ZeroLocationPartDefinition m7439b(InjectorLike injectorLike) {
        return new ZeroLocationPartDefinition(BackgroundPartDefinition.a(injectorLike), CommonEventsBuilder.b(injectorLike), TextLinkPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3754), BaseCheckinStoryPartDefinition.m7445a(injectorLike), TravelStoryHelper.b(injectorLike));
    }

    public final Object m7441a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps e = AttachmentProps.e((FeedProps) obj);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        GraphQLPlace a = m7437a(graphQLStory);
        subParts.a(this.f7116c, new StylingData(e, f7113b));
        subParts.a(this.f7118e, e);
        subParts.a(2131562015, this.f7120g, new Props(graphQLStory, a, true));
        return m7435a(e, a);
    }

    public final /* bridge */ /* synthetic */ void m7442a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2048977254);
        m7438a((FeedProps) obj, (HoneyClientEvent) obj2, (ZeroLocationView) view);
        Logger.a(8, EntryType.MARK_POP, 1204022459, a);
    }

    static {
        Builder g = Builder.g();
        g.b = 8.0f;
        g = g;
        g.c = 8.0f;
        f7113b = g.i();
    }

    public static ZeroLocationPartDefinition m7436a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ZeroLocationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7115j) {
                ZeroLocationPartDefinition zeroLocationPartDefinition;
                if (a2 != null) {
                    zeroLocationPartDefinition = (ZeroLocationPartDefinition) a2.a(f7115j);
                } else {
                    zeroLocationPartDefinition = f7114i;
                }
                if (zeroLocationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7439b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7115j, b3);
                        } else {
                            f7114i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = zeroLocationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ZeroLocationPartDefinition(BackgroundPartDefinition backgroundPartDefinition, CommonEventsBuilder commonEventsBuilder, TextLinkPartDefinition textLinkPartDefinition, Provider<FbZeroFeatureVisibilityHelper> provider, BaseCheckinStoryPartDefinition baseCheckinStoryPartDefinition, TravelStoryHelper travelStoryHelper) {
        this.f7116c = backgroundPartDefinition;
        this.f7117d = commonEventsBuilder;
        this.f7118e = textLinkPartDefinition;
        this.f7119f = provider;
        this.f7120g = baseCheckinStoryPartDefinition;
        this.f7121h = travelStoryHelper;
    }

    public final ViewType m7440a() {
        return f7112a;
    }

    public final boolean m7443a(Object obj) {
        return ((FbZeroFeatureVisibilityHelper) this.f7119f.get()).a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL);
    }

    private void m7438a(FeedProps<GraphQLStoryAttachment> feedProps, HoneyClientEvent honeyClientEvent, ZeroLocationView zeroLocationView) {
        FeedProps e = AttachmentProps.e(feedProps);
        zeroLocationView.a.m14450a(e, m7437a((GraphQLStory) e.a), honeyClientEvent);
    }

    private HoneyClientEvent m7435a(FeedProps<GraphQLStory> feedProps, GraphQLPlace graphQLPlace) {
        return this.f7117d.a(graphQLPlace.X(), StoryProps.p(feedProps), TrackableFeedProps.a(feedProps), "native_newsfeed");
    }

    private GraphQLPlace m7437a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o != null && this.f7121h.a(graphQLStory)) {
            return TravelStoryHelper.a(o.z());
        }
        if (GraphQLHelper.m(graphQLStory)) {
            return graphQLStory.Y();
        }
        if (GraphQLHelper.n(graphQLStory)) {
            return TravelStoryHelper.a(o.z());
        }
        return null;
    }
}

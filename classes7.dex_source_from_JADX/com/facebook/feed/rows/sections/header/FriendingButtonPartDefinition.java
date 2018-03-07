package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.fallback.annotations.FallbackSpec;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.ui.FriendingButton;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
@FallbackSpec(mountType = FriendingButton.class)
/* compiled from: Unsupported action type  */
public class FriendingButtonPartDefinition<E extends CanFriendPerson & HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, GraphQLFriendshipStatus, E, FriendingButton> {
    private static FriendingButtonPartDefinition f21151e;
    private static final Object f21152f = new Object();
    public final AnalyticsLogger f21153a;
    private final ClickListenerPartDefinition f21154b;
    public final NewsFeedAnalyticsEventBuilder f21155c;
    private final FriendingEventBus f21156d;

    /* compiled from: Unsupported action type  */
    final class C17941 implements FriendingButtonControllerCallback {
        final /* synthetic */ CanFriendPerson f21140a;
        final /* synthetic */ FriendshipStatusKey f21141b;
        final /* synthetic */ GraphQLFriendshipStatus f21142c;
        final /* synthetic */ FeedProps f21143d;

        C17941(CanFriendPerson canFriendPerson, FriendshipStatusKey friendshipStatusKey, GraphQLFriendshipStatus graphQLFriendshipStatus, FeedProps feedProps) {
            this.f21140a = canFriendPerson;
            this.f21141b = friendshipStatusKey;
            this.f21142c = graphQLFriendshipStatus;
            this.f21143d = feedProps;
        }

        public final void m23998a() {
            ((HasPersistentState) this.f21140a).a(this.f21141b, this.f21142c);
            ((HasInvalidate) this.f21140a).a(new FeedProps[]{this.f21143d});
        }
    }

    /* compiled from: Unsupported action type  */
    class FriendingStatusChanged<E extends HasInvalidate & HasPersistentState> extends FriendshipStatusChangedEventSubscriber {
        private final WeakReference<FeedProps<GraphQLStory>> f21147a;
        private final WeakReference<E> f21148b;

        public final void m23999b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            FeedProps feedProps = (FeedProps) this.f21147a.get();
            HasInvalidate hasInvalidate = (HasInvalidate) this.f21148b.get();
            if (feedProps != null && hasInvalidate != null && friendshipStatusChangedEvent != null) {
                GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                GraphQLProfile a = FeedUnitItemProfileHelper.a(graphQLStory);
                if (String.valueOf(friendshipStatusChangedEvent.a).equals(a.b())) {
                    FriendshipStatusKey friendshipStatusKey = new FriendshipStatusKey(a);
                    if (!friendshipStatusChangedEvent.b.equals((GraphQLFriendshipStatus) ((HasPersistentState) hasInvalidate).a(friendshipStatusKey, graphQLStory))) {
                        ((HasPersistentState) hasInvalidate).a(friendshipStatusKey, friendshipStatusChangedEvent.b);
                        hasInvalidate.a(new FeedProps[]{feedProps});
                    }
                }
            }
        }

        public FriendingStatusChanged(WeakReference<FeedProps<GraphQLStory>> weakReference, WeakReference<E> weakReference2) {
            this.f21147a = weakReference;
            this.f21148b = weakReference2;
        }
    }

    /* compiled from: Unsupported action type  */
    public class FriendshipStatusKey implements ContextStateKey<String, GraphQLFriendshipStatus> {
        private final String f21149a;
        private final GraphQLFriendshipStatus f21150b;

        public FriendshipStatusKey(GraphQLProfile graphQLProfile) {
            this.f21149a = FriendshipStatusKey.class.getSimpleName() + graphQLProfile.b();
            this.f21150b = graphQLProfile.J();
        }

        public final Object m24001b() {
            return this.f21149a;
        }

        public final Object m24000a() {
            return this.f21150b;
        }
    }

    private static FriendingButtonPartDefinition m24004b(InjectorLike injectorLike) {
        return new FriendingButtonPartDefinition(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), FriendingEventBus.a(injectorLike));
    }

    public final Object m24005a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        final CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLProfile a = FeedUnitItemProfileHelper.a(graphQLStory);
        subParts.a(this.f21154b, new OnClickListener(this) {
            final /* synthetic */ FriendingButtonPartDefinition f21146c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 623511602);
                FriendingButtonPartDefinition.m24003a(feedProps, canFriendPerson, this.f21146c.f21155c, this.f21146c.f21153a);
                Logger.a(2, EntryType.UI_INPUT_END, -1629268494, a);
            }
        });
        this.f21156d.a(new FriendingStatusChanged(new WeakReference(feedProps), new WeakReference(canFriendPerson)));
        return (GraphQLFriendshipStatus) ((HasPersistentState) canFriendPerson).a(new FriendshipStatusKey(a), graphQLStory);
    }

    public static FriendingButtonPartDefinition m24002a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendingButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21152f) {
                FriendingButtonPartDefinition friendingButtonPartDefinition;
                if (a2 != null) {
                    friendingButtonPartDefinition = (FriendingButtonPartDefinition) a2.a(f21152f);
                } else {
                    friendingButtonPartDefinition = f21151e;
                }
                if (friendingButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24004b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21152f, b3);
                        } else {
                            f21151e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendingButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static <E extends CanFriendPerson & HasInvalidate & HasPersistentState> void m24003a(FeedProps<GraphQLStory> feedProps, E e, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLProfile a = FeedUnitItemProfileHelper.a(graphQLStory);
        FriendshipStatusKey friendshipStatusKey = new FriendshipStatusKey(a);
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) ((HasPersistentState) e).a(friendshipStatusKey, graphQLStory);
        FriendshipStatus a2 = e.a(a.b(), a.U(), FriendingLocation.FEED_FRIENDABLE_HEADER, graphQLFriendshipStatus, new C17941(e, friendshipStatusKey, graphQLFriendshipStatus, feedProps));
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus)) {
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            ArrayNode a3 = TrackableFeedProps.a(feedProps);
            if (NewsFeedAnalyticsEventBuilder.B(a3)) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent a4 = new HoneyClientEvent("feed_friendable_header_add").a("tracking", a3);
                a4.c = "native_newsfeed";
                honeyAnalyticsEvent = a4;
            }
            analyticsLogger.c(honeyAnalyticsEvent);
        }
        ((HasPersistentState) e).a(friendshipStatusKey, a2.a);
        ((HasInvalidate) e).a(new FeedProps[]{feedProps});
    }

    @Inject
    public FriendingButtonPartDefinition(AnalyticsLogger analyticsLogger, ClickListenerPartDefinition clickListenerPartDefinition, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FriendingEventBus friendingEventBus) {
        this.f21153a = analyticsLogger;
        this.f21154b = clickListenerPartDefinition;
        this.f21155c = newsFeedAnalyticsEventBuilder;
        this.f21156d = friendingEventBus;
    }
}

package com.facebook.fbreact.events;

import android.content.Intent;
import android.net.Uri;
import android.text.format.DateUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardBirthdaysComposerController;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchEventCommonQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.actionbar.ActionItemEdit;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.fbreact.navigation.FbReactNavigationJavaModule;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: facecast_info */
public class FBEventsNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final Date f7265a = new Date();
    private final ContactIterators f7266b;
    private final EventPermalinkController f7267c;
    private final SecureContextHelper f7268d;
    private final ActionItemInvite f7269e;
    public final ActionItemEdit f7270f;
    private final EventsDashboardBirthdaysComposerController f7271g;
    private final GraphQLQueryExecutor f7272h;
    private final ExecutorService f7273i;
    private final EventsEventBus f7274j;
    private final EventCreatedEventSubscriber f7275k = new EventCreatedEventSubscriber(this);
    private final EventUpdatedEventSubscriber f7276l = new EventUpdatedEventSubscriber(this);
    private final Provider<EventEventLogger> f7277m;
    @Nullable
    public String f7278n;

    /* compiled from: facecast_info */
    abstract class EventFetchingCallback {
        public abstract void mo217a(Event event);

        public void mo216a() {
        }
    }

    /* compiled from: facecast_info */
    class EventCreatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventCreatedEventSubscriber {
        final /* synthetic */ FBEventsNativeModule f7263a;

        public EventCreatedEventSubscriber(FBEventsNativeModule fBEventsNativeModule) {
            this.f7263a = fBEventsNativeModule;
        }

        public final void m8481b(FbEvent fbEvent) {
            ReactApplicationContext b = this.f7263a.a;
            if (b.i() && b.b()) {
                ((RCTNativeAppEventEmitter) b.a(RCTNativeAppEventEmitter.class)).emit("EventsDashboardRefresh", null);
            }
        }
    }

    /* compiled from: facecast_info */
    class EventUpdatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUpdatedEventSubscriber {
        final /* synthetic */ FBEventsNativeModule f7264a;

        public EventUpdatedEventSubscriber(FBEventsNativeModule fBEventsNativeModule) {
            this.f7264a = fBEventsNativeModule;
        }

        public final void m8482b(FbEvent fbEvent) {
            ReactApplicationContext c = this.f7264a.a;
            if (c.i() && c.b()) {
                ((RCTNativeAppEventEmitter) c.a(RCTNativeAppEventEmitter.class)).emit("EventsDashboardRefresh", null);
            }
        }
    }

    @Inject
    public FBEventsNativeModule(@Assisted ReactApplicationContext reactApplicationContext, ContactIterators contactIterators, EventPermalinkController eventPermalinkController, SecureContextHelper secureContextHelper, ActionItemInvite actionItemInvite, ActionItemEdit actionItemEdit, EventsDashboardBirthdaysComposerController eventsDashboardBirthdaysComposerController, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, EventsEventBus eventsEventBus, Provider<EventEventLogger> provider) {
        super(reactApplicationContext);
        this.a.a(this);
        this.f7266b = contactIterators;
        this.f7267c = eventPermalinkController;
        this.f7268d = secureContextHelper;
        this.f7269e = actionItemInvite;
        this.f7270f = actionItemEdit;
        this.f7271g = eventsDashboardBirthdaysComposerController;
        this.f7272h = graphQLQueryExecutor;
        this.f7273i = executorService;
        this.f7274j = eventsEventBus;
        this.f7277m = provider;
        m8487r();
    }

    private void m8487r() {
        this.f7269e.a = EventAnalyticsParams.a;
    }

    public final void m8490c() {
        super.c();
        this.f7274j.a(this.f7275k);
        this.f7274j.a(this.f7276l);
    }

    public final void m8491e() {
        super.e();
        this.f7274j.b(this.f7275k);
        this.f7274j.b(this.f7276l);
    }

    public String getName() {
        return "FBEventsNativeModule";
    }

    @ReactMethod
    public void openCreateEvent(int i) {
        this.f7267c.b(this.a, EventAnalyticsParams.a, ActionMechanism.DASHBOARD_HEADER);
    }

    @ReactMethod
    public void openEventPermalink(int i, String str) {
        ((FbReactNavigationJavaModule) this.a.b(FbReactNavigationJavaModule.class)).a(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.t, str)));
    }

    @ReactMethod
    public void openInviteToEvent(String str, String str2, String str3, boolean z) {
        this.f7269e.a(str, str2, GraphQLEventPrivacyType.fromString(str3), z, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS.toString(), 501, q());
    }

    @ReactMethod
    public void openEditEvent(int i, ReadableMap readableMap, final Callback callback) {
        String string = readableMap.getString("id");
        final EventAnalyticsParams eventAnalyticsParams = new EventAnalyticsParams(EventActionContext.b, "unknown", "event_dashboard", null);
        m8484a(string, new EventFetchingCallback(this) {
            final /* synthetic */ FBEventsNativeModule f7260c;

            public final void mo217a(Event event) {
                callback.a(new Object[0]);
                this.f7260c.f7270f.a(event, eventAnalyticsParams);
                this.f7260c.f7270f.b(ActionMechanism.DASHBOARD_ROW_GUEST_STATUS);
            }

            public final void mo216a() {
                callback.a(new Object[0]);
            }
        });
    }

    @ReactMethod
    public void openAllBirthdaysListView(int i) {
        this.f7267c.b(this.a);
    }

    @ReactMethod
    public void openComposerToPerson(int i, String str) {
        ContactIterator a = this.f7266b.a(ContactCursorsQuery.a(str).d(ImmutableList.of(ContactLinkType.FRIEND)));
        try {
            if (a.hasNext()) {
                Contact contact = (Contact) a.next();
                a.close();
                Calendar a2 = EventsBirthdayTimeFormatUtil.a(f7265a, TimeZone.getDefault(), contact.D(), contact.E());
                this.f7271g.a(str, contact.e().g(), contact.g(), DateUtils.isToday(a2.getTimeInMillis()), q());
            }
        } finally {
            a.close();
        }
    }

    @ReactMethod
    public void openDiscoveryListViewForCutType(int i, String str, String str2) {
        this.f7267c.a(this.a, str, str2, EventActionContext.b, "event_suggestions");
    }

    @ReactMethod
    public void openSubscribedEvents(int i, String str) {
        this.f7267c.b(this.a, EventActionContext.b, "event_subscriptions");
    }

    @ReactMethod
    public void reportEventsDashboardLoadedEvent(String str, int i) {
        ((EventEventLogger) this.f7277m.get()).a(str, i, this.f7278n, ActionSource.MOBILE_BOOKMARK_TAB.getParamValue());
    }

    public final void m8488a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 501:
                    this.f7269e.a(i, i2, intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m8489a(String str) {
        this.f7278n = str;
    }

    private void m8484a(String str, final EventFetchingCallback eventFetchingCallback) {
        FetchEventCommonQueryString d = EventsGraphQL.d();
        d.a("event_id", str);
        Futures.a(this.f7272h.a(GraphQLRequest.a(d)), new FutureCallback<GraphQLResult<EventCommonFragmentModel>>(this) {
            final /* synthetic */ FBEventsNativeModule f7262b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    eventFetchingCallback.mo216a();
                    return;
                }
                eventFetchingCallback.mo217a(EventGraphQLModelHelper.b((EventCommonFragment) graphQLResult.e));
            }

            public void onFailure(Throwable th) {
                eventFetchingCallback.mo216a();
            }
        }, this.f7273i);
    }
}

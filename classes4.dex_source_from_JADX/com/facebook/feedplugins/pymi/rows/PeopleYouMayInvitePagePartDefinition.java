package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.Events;
import com.facebook.feedplugins.pymi.views.ContactYouMayInviteView;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: now= */
public class PeopleYouMayInvitePagePartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinitionWithViewType<Props, ContactYouMayInvitePersistentKey, E, ContactYouMayInviteView> {
    public static final ViewType<ContactYouMayInviteView> f6670a = new C03061();
    private static PeopleYouMayInvitePagePartDefinition f6671n;
    private static final Object f6672o = new Object();
    public final NewsFeedAnalyticsEventBuilder f6673b;
    public final AnalyticsLogger f6674c;
    private final ClickListenerPartDefinition f6675d;
    public final FeedUnitCacheMutator f6676e;
    public final PeopleYouMayInviteFeedUnitFetcher f6677f;
    public final PeopleYouMayInviteLogger f6678g;
    public final FriendingClient f6679h;
    private final FbObjectMapper f6680i;
    private final ListeningScheduledExecutorService f6681j;
    public final TasksManager f6682k;
    private final TextPartDefinition f6683l;
    public final Toaster f6684m;

    /* compiled from: now= */
    final class C03061 extends ViewType<ContactYouMayInviteView> {
        C03061() {
        }

        public final View m7081a(Context context) {
            return new ContactYouMayInviteView(context);
        }
    }

    private static PeopleYouMayInvitePagePartDefinition m7076b(InjectorLike injectorLike) {
        return new PeopleYouMayInvitePagePartDefinition(NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FeedUnitCacheMutator.a(injectorLike), PeopleYouMayInviteFeedUnitFetcher.a(injectorLike), PeopleYouMayInviteLogger.a(injectorLike), FriendingClient.b(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), TextPartDefinition.a(injectorLike), Toaster.b(injectorLike));
    }

    public final Object m7079a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = props.a;
        if (graphQLPeopleYouMayInviteFeedUnitContactsEdge == null) {
            return null;
        }
        subParts.a(2131560723, this.f6675d, new 2(this, props, hasInvalidate));
        subParts.a(2131560724, this.f6675d, new 3(this, props));
        subParts.a(2131560721, this.f6683l, graphQLPeopleYouMayInviteFeedUnitContactsEdge.j());
        subParts.a(2131560722, this.f6683l, graphQLPeopleYouMayInviteFeedUnitContactsEdge.l());
        return new ContactYouMayInvitePersistentKey(props.a);
    }

    public static PeopleYouMayInvitePagePartDefinition m7073a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayInvitePagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6672o) {
                PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition;
                if (a2 != null) {
                    peopleYouMayInvitePagePartDefinition = (PeopleYouMayInvitePagePartDefinition) a2.a(f6672o);
                } else {
                    peopleYouMayInvitePagePartDefinition = f6671n;
                }
                if (peopleYouMayInvitePagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7076b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6672o, b3);
                        } else {
                            f6671n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayInvitePagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayInvitePagePartDefinition(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, ClickListenerPartDefinition clickListenerPartDefinition, FeedUnitCacheMutator feedUnitCacheMutator, PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher, PeopleYouMayInviteLogger peopleYouMayInviteLogger, FriendingClient friendingClient, FbObjectMapper fbObjectMapper, ListeningScheduledExecutorService listeningScheduledExecutorService, TasksManager tasksManager, TextPartDefinition textPartDefinition, Toaster toaster) {
        this.f6673b = newsFeedAnalyticsEventBuilder;
        this.f6674c = analyticsLogger;
        this.f6675d = clickListenerPartDefinition;
        this.f6676e = feedUnitCacheMutator;
        this.f6677f = peopleYouMayInviteFeedUnitFetcher;
        this.f6678g = peopleYouMayInviteLogger;
        this.f6679h = friendingClient;
        this.f6680i = fbObjectMapper;
        this.f6681j = listeningScheduledExecutorService;
        this.f6682k = tasksManager;
        this.f6683l = textPartDefinition;
        this.f6684m = toaster;
    }

    public final ViewType<ContactYouMayInviteView> m7078a() {
        return f6670a;
    }

    private static void m7075a(Props props, ContactYouMayInvitePersistentKey contactYouMayInvitePersistentKey, E e, ContactYouMayInviteView contactYouMayInviteView) {
        ContactYouMayInvitePersistentState contactYouMayInvitePersistentState = (ContactYouMayInvitePersistentState) ((HasPersistentState) e).a(contactYouMayInvitePersistentKey, props.a);
        if (props.a.n().a) {
            contactYouMayInviteView.f();
        } else if (contactYouMayInvitePersistentState.b) {
            contactYouMayInviteView.e();
        } else {
            contactYouMayInviteView.b();
        }
    }

    public static void m7077b(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, Props props, HasInvalidate hasInvalidate) {
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = props.a;
        ContactYouMayInvitePersistentKey contactYouMayInvitePersistentKey = new ContactYouMayInvitePersistentKey(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
        ContactYouMayInvitePersistentState contactYouMayInvitePersistentState = (ContactYouMayInvitePersistentState) ((HasPersistentState) hasInvalidate).a(contactYouMayInvitePersistentKey, graphQLPeopleYouMayInviteFeedUnitContactsEdge);
        if (!props.a.n().a) {
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            HoneyClientEvent a;
            if (contactYouMayInvitePersistentState.b) {
                ArrayNode a2 = GraphQLHelper.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge, props.b);
                if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                    honeyAnalyticsEvent = null;
                } else {
                    a = new HoneyClientEvent("pymi_cancel").a("tracking", a2);
                    a.c = "native_newsfeed";
                    honeyAnalyticsEvent = a;
                }
                peopleYouMayInvitePagePartDefinition.f6674c.c(honeyAnalyticsEvent);
                peopleYouMayInvitePagePartDefinition.f6678g.a(Events.UNDO);
                if (contactYouMayInvitePersistentState.a != null) {
                    contactYouMayInvitePersistentState.a.cancel(true);
                }
                ((HasPersistentState) hasInvalidate).a(contactYouMayInvitePersistentKey, new ContactYouMayInvitePersistentState(null, false));
            } else {
                ArrayNode a3 = GraphQLHelper.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge, props.b);
                if (NewsFeedAnalyticsEventBuilder.B(a3)) {
                    honeyAnalyticsEvent = null;
                } else {
                    a = new HoneyClientEvent("pymi_invite").a("tracking", a3);
                    a.c = "native_newsfeed";
                    honeyAnalyticsEvent = a;
                }
                peopleYouMayInvitePagePartDefinition.f6674c.c(honeyAnalyticsEvent);
                peopleYouMayInvitePagePartDefinition.f6678g.a();
                peopleYouMayInvitePagePartDefinition.f6678g.a("send_invite");
                peopleYouMayInvitePagePartDefinition.f6678g.a(Events.INVITE);
                ((HasPersistentState) hasInvalidate).a(contactYouMayInvitePersistentKey, new ContactYouMayInvitePersistentState(peopleYouMayInvitePagePartDefinition.f6681j.a(new 4(peopleYouMayInvitePagePartDefinition, props, hasInvalidate), 4, TimeUnit.SECONDS), true));
            }
            hasInvalidate.a(new Object[]{props.b});
        }
    }

    @Nullable
    public static String m7074a(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, String str) {
        String str2 = null;
        try {
            JsonNode a = peopleYouMayInvitePagePartDefinition.f6680i.a(str);
            if (a.d("ego_id")) {
                str2 = a.f("ego_id").B();
            }
        } catch (IOException e) {
        }
        return str2;
    }
}

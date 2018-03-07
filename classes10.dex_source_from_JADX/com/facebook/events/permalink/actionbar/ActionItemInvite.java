package com.facebook.events.permalink.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.eventsevents.EventsEvents.SendingInviteEvent;
import com.facebook.events.eventsevents.EventsEvents.SendingInviteFailedEvent;
import com.facebook.events.graphql.EventsMutations.EventInviteMutationString;
import com.facebook.events.graphql.EventsMutations.EventUnifiedInviteMutationString;
import com.facebook.events.invite.common.EventInviteNavigationHelper;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.graphql.calls.EventInviteInputData;
import com.facebook.graphql.calls.EventInviteInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventInviteInputData.InviteNotificationType;
import com.facebook.graphql.calls.EventUnifiedInviteInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: came_from_suggested_bio */
public class ActionItemInvite {
    private static ActionItemInvite f17955p;
    private static final Object f17956q = new Object();
    public EventAnalyticsParams f17957a;
    private PrefKey f17958b;
    private final Context f17959c;
    public final EventsDashboardTimeFormatUtil f17960d;
    private final EventInviteNavigationHelper f17961e;
    private final Boolean f17962f;
    private final SecureContextHelper f17963g;
    private final TasksManager f17964h;
    public final EventsEventBus f17965i;
    private final GraphQLQueryExecutor f17966j;
    private final MessengerAppUtils f17967k;
    private final QeAccessor f17968l;
    private final SendAsMessageUtil f17969m;
    private final UriIntentMapper f17970n;
    private final FbSharedPreferences f17971o;

    private static ActionItemInvite m18365b(InjectorLike injectorLike) {
        return new ActionItemInvite((Context) injectorLike.getInstance(Context.class), EventsDashboardTimeFormatUtil.a(injectorLike), EventInviteNavigationHelper.b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.b(injectorLike), EventsEventBus.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), MessengerAppUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SendAsMessageUtil.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    public static ActionItemInvite m18355a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionItemInvite b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17956q) {
                ActionItemInvite actionItemInvite;
                if (a2 != null) {
                    actionItemInvite = (ActionItemInvite) a2.a(f17956q);
                } else {
                    actionItemInvite = f17955p;
                }
                if (actionItemInvite == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18365b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17956q, b3);
                        } else {
                            f17955p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = actionItemInvite;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ActionItemInvite(Context context, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, EventInviteNavigationHelper eventInviteNavigationHelper, Boolean bool, SecureContextHelper secureContextHelper, TasksManager tasksManager, EventsEventBus eventsEventBus, GraphQLQueryExecutor graphQLQueryExecutor, MessengerAppUtils messengerAppUtils, QeAccessor qeAccessor, SendAsMessageUtil sendAsMessageUtil, UriIntentMapper uriIntentMapper, FbSharedPreferences fbSharedPreferences, Provider<String> provider) {
        this.f17959c = context;
        this.f17960d = eventsDashboardTimeFormatUtil;
        this.f17961e = eventInviteNavigationHelper;
        this.f17962f = bool;
        this.f17963g = secureContextHelper;
        this.f17964h = tasksManager;
        this.f17965i = eventsEventBus;
        this.f17966j = graphQLQueryExecutor;
        this.f17967k = messengerAppUtils;
        this.f17968l = qeAccessor;
        this.f17969m = sendAsMessageUtil;
        this.f17970n = uriIntentMapper;
        this.f17971o = fbSharedPreferences;
        this.f17958b = GrowthPrefKeys.a((String) provider.get());
    }

    public final void m18367a(Event event, String str) {
        if (event != null) {
            Intent a = this.f17961e.a(event.a, event.s, event.d, event.a(EventViewerCapability.ADMIN), str);
            if (a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("extra_event_name", event.b);
                if (event.W != null) {
                    bundle.putString("extra_event_cover_photo_uri", event.W.toString());
                }
                bundle.putString("extra_event_location_name", event.P);
                bundle.putLong("extra_event_start_time", m18354a(event.J()));
                bundle.putLong("extra_event_end_time", m18354a(event.L()));
                a.putExtra("extra_invite_configuration_bundle", bundle);
                this.f17963g.a(a, 501, (Activity) ContextUtils.a(this.f17959c, Activity.class));
            }
        }
    }

    public final void m18368a(String str, String str2, GraphQLEventPrivacyType graphQLEventPrivacyType, boolean z, String str3, int i, Activity activity) {
        Intent a = this.f17961e.a(str, str2, graphQLEventPrivacyType, z, str3);
        if (a != null) {
            this.f17963g.a(a, i, activity);
        }
    }

    private static long m18354a(Date date) {
        return date == null ? Long.MIN_VALUE : date.getTime();
    }

    private static Date m18356a(long j) {
        return j == Long.MIN_VALUE ? null : new Date(j);
    }

    public final void m18366a(int i, int i2, Intent intent) {
        Preconditions.checkArgument(i == 501);
        if (i2 == -1 && intent.hasExtra("profiles")) {
            String stringExtra = intent.getStringExtra("event_id");
            String stringExtra2 = intent.getStringExtra("extra_invite_action_mechanism");
            if (intent.getBooleanExtra("extra_enable_extended_invite", false)) {
                String[] stringArrayExtra = intent.getStringArrayExtra("profiles");
                if (stringArrayExtra.length > 0 && !Strings.isNullOrEmpty(stringExtra)) {
                    m18362a(stringExtra, intent.hasExtra("extra_events_note_text") ? intent.getStringExtra("extra_events_note_text") : null, stringExtra2, Arrays.asList(stringArrayExtra));
                    return;
                }
                return;
            }
            long[] longArrayExtra = intent.getLongArrayExtra("profiles");
            if (longArrayExtra.length > 0 && !Strings.isNullOrEmpty(stringExtra)) {
                if (intent.getBooleanExtra("extra_redirect_to_messenger", false)) {
                    m18361a(stringExtra, stringExtra2, intent.getBundleExtra("extra_invite_configuration_bundle"), ImmutableSet.copyOf(Longs.a(longArrayExtra)));
                } else {
                    m18369a(stringExtra, stringExtra2, ImmutableSet.copyOf(Longs.a(longArrayExtra)));
                }
            }
        }
    }

    private void m18360a(String str, Bundle bundle, ImmutableSet<Long> immutableSet) {
        if (bundle != null) {
            SendAsMessageUtil sendAsMessageUtil = this.f17969m;
            Activity activity = (Activity) ContextUtils.a(this.f17959c, Activity.class);
            String string = bundle.getString("extra_event_name");
            String string2 = bundle.getString("extra_event_cover_photo_uri");
            String string3 = bundle.getString("extra_event_location_name");
            Date a = m18356a(bundle.getLong("extra_event_start_time"));
            sendAsMessageUtil.a(activity, str, string, string2, string3, a != null ? this.f17960d.a(false, a, m18356a(bundle.getLong("extra_event_end_time"))) : null, m18357a((ImmutableSet) immutableSet), "event", 100);
        }
    }

    private static Set<String> m18357a(ImmutableSet<Long> immutableSet) {
        Set hashSet = new HashSet(immutableSet.size());
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.toString(((Long) it.next()).longValue()));
        }
        return hashSet;
    }

    private void m18361a(String str, String str2, Bundle bundle, ImmutableSet<Long> immutableSet) {
        m18358a(InviteNotificationType.SUPPRESS_PUSH, str, str2, (ImmutableSet) immutableSet);
        m18360a(str, bundle, (ImmutableSet) immutableSet);
    }

    public final void m18369a(String str, String str2, ImmutableSet<Long> immutableSet) {
        m18358a(InviteNotificationType.NORMAL, str, str2, (ImmutableSet) immutableSet);
    }

    private void m18358a(InviteNotificationType inviteNotificationType, String str, String str2, ImmutableSet<Long> immutableSet) {
        String str3;
        m18359a(str2);
        DisposableFutureCallback b = m18364b(str);
        this.f17965i.a(new SendingInviteEvent());
        List a = Lists.a(immutableSet.size());
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            a.add(String.valueOf((Long) it.next()));
        }
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.f17957a.c);
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(this.f17957a.d);
        eventActionHistory2.a("mechanism", str2);
        if (m18363a()) {
            str3 = "contacts_upload_on";
        } else {
            str3 = "contacts_upload_off";
        }
        eventActionHistory2.a("extra_data", str3);
        EventInviteInputData.Context context = new EventInviteInputData.Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
        EventInviteInputData eventInviteInputData = new EventInviteInputData();
        eventInviteInputData.a("context", context);
        GraphQlCallInput graphQlCallInput = eventInviteInputData;
        graphQlCallInput.a("event_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("invitee_ids", a);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("invite_notification_type", inviteNotificationType);
        this.f17964h.a("tasks-inviteToEvent:" + str, this.f17966j.a(GraphQLRequest.a((EventInviteMutationString) new EventInviteMutationString().a("input", graphQlCallInput))), b);
    }

    private void m18362a(String str, @Nullable String str2, String str3, List<String> list) {
        String str4;
        m18359a(str3);
        DisposableFutureCallback b = m18364b(str);
        this.f17965i.a(new SendingInviteEvent());
        EventUnifiedInviteInputData.Context.EventActionHistory eventActionHistory = new EventUnifiedInviteInputData.Context.EventActionHistory();
        eventActionHistory.a(this.f17957a.c);
        EventUnifiedInviteInputData.Context.EventActionHistory eventActionHistory2 = new EventUnifiedInviteInputData.Context.EventActionHistory();
        eventActionHistory2.a(this.f17957a.d);
        eventActionHistory2.a("mechanism", str3);
        if (m18363a()) {
            str4 = "contacts_upload_on";
        } else {
            str4 = "contacts_upload_off";
        }
        eventActionHistory2.a("extra_data", str4);
        EventUnifiedInviteInputData.Context context = new EventUnifiedInviteInputData.Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
        EventUnifiedInviteInputData eventUnifiedInviteInputData = new EventUnifiedInviteInputData();
        eventUnifiedInviteInputData.a("context", context);
        GraphQlCallInput graphQlCallInput = eventUnifiedInviteInputData;
        graphQlCallInput.a("event_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("tokens", list);
        graphQlCallInput = graphQlCallInput;
        if (!StringUtil.a(str2)) {
            graphQlCallInput.a("message", str2);
        }
        this.f17964h.a("tasks-unifiedInviteToEvent:" + str, this.f17966j.a(GraphQLRequest.a((EventUnifiedInviteMutationString) new EventUnifiedInviteMutationString().a("input", graphQlCallInput))), b);
    }

    private void m18359a(String str) {
        if (this.f17957a == null) {
            throw new IllegalStateException("mEventAnalyticsParams is not set");
        } else if (str == null) {
            throw new IllegalStateException("actionMechanism is not set");
        }
    }

    private DisposableFutureCallback<GraphQLResult<?>> m18364b(final String str) {
        final Resources resources = this.f17959c.getResources();
        final Toast makeText = Toast.makeText(this.f17959c, resources.getString(2131237264), 0);
        makeText.show();
        return new AbstractDisposableFutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ ActionItemInvite f17954d;

            protected final void m18352a(Object obj) {
                this.f17954d.f17965i.a(new EventUpdatedEvent(str));
                makeText.setText(resources.getString(2131237265));
                makeText.show();
            }

            protected final void m18353a(Throwable th) {
                this.f17954d.f17965i.a(new SendingInviteFailedEvent());
                makeText.setText(resources.getString(2131237266));
                makeText.show();
            }
        };
    }

    private boolean m18363a() {
        return this.f17971o.a(this.f17958b, false);
    }
}

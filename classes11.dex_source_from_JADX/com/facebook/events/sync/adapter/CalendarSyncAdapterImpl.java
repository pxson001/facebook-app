package com.facebook.events.sync.adapter;

import android.accounts.Account;
import android.accounts.OperationCanceledException;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchUpcomingEventsQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel;
import com.facebook.events.sync.FacebookCalendar;
import com.facebook.events.sync.FacebookCalendar.SyncEntry;
import com.facebook.events.sync.FacebookCalendarEvent;
import com.facebook.events.sync.FacebookCalendarFactory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: failure_conditions */
public class CalendarSyncAdapterImpl extends AbstractThreadedSyncAdapter {
    private final LoggedInUserSessionManager f7241a;
    private final FacebookCalendarFactory f7242b;
    private GraphQLQueryExecutor f7243c;
    private ExecutorService f7244d;
    private Clock f7245e;

    @Inject
    public CalendarSyncAdapterImpl(Context context, LoggedInUserSessionManager loggedInUserSessionManager, FacebookCalendarFactory facebookCalendarFactory, GraphQLQueryExecutor graphQLQueryExecutor, Clock clock, ExecutorService executorService) {
        super(context, true);
        this.f7241a = loggedInUserSessionManager;
        this.f7242b = facebookCalendarFactory;
        this.f7243c = graphQLQueryExecutor;
        this.f7245e = clock;
        this.f7244d = executorService;
    }

    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, final SyncResult syncResult) {
        Date date = new Date();
        this.f7242b.f7238e = account;
        this.f7242b.f7237d = contentProviderClient;
        ContentResolver.addPeriodicSync(account, "com.android.calendar", new Bundle(), 10800);
        if (this.f7241a.b()) {
            String.valueOf(this.f7245e.a() / 1000);
            Futures.a(this.f7243c.a(GraphQLRequest.a(EventsGraphQL.f()).a(new FetchUpcomingEventsQueryString().a)), new FutureCallback<GraphQLResult<FetchUpcomingEventsQueryModel>>(this) {
                final /* synthetic */ CalendarSyncAdapterImpl f7240b;

                public void onSuccess(Object obj) {
                    try {
                        CalendarSyncAdapterImpl.m8461a(this.f7240b, syncResult, (FetchUpcomingEventsQueryModel) ((GraphQLResult) obj).d());
                    } catch (OperationCanceledException e) {
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b("CalendarSyncAdapterImpl", "Failure in fetch request:", th);
                }
            }, this.f7244d);
        }
    }

    public static void m8461a(CalendarSyncAdapterImpl calendarSyncAdapterImpl, SyncResult syncResult, FetchUpcomingEventsQueryModel fetchUpcomingEventsQueryModel) {
        FacebookCalendar a = calendarSyncAdapterImpl.f7242b.m8458a();
        if (a != null) {
            ArrayList a2 = Lists.a();
            HashMap a3 = m8459a(a, syncResult.fullSyncRequested);
            List<FacebookCalendarEvent> a4 = m8460a(fetchUpcomingEventsQueryModel);
            ArrayList a5 = Lists.a();
            for (FacebookCalendarEvent facebookCalendarEvent : a4) {
                a2.add(facebookCalendarEvent.f7229e);
                if (a3.containsKey(facebookCalendarEvent.f7229e)) {
                    a5.add(a.m8448a(facebookCalendarEvent, ((Long) a3.get(facebookCalendarEvent.f7229e)).longValue()));
                } else {
                    a5.add(a.m8447a(facebookCalendarEvent));
                }
                if (a5.size() >= 50) {
                    if (a.m8451a(a5)) {
                        syncResult.madeSomeProgress();
                    }
                    a5.clear();
                }
            }
            if (!a5.isEmpty() && a.m8451a(a5)) {
                syncResult.madeSomeProgress();
            }
            for (Entry entry : a3.entrySet()) {
                if (!a2.contains((String) entry.getKey())) {
                    a.m8450a(((Long) entry.getValue()).longValue());
                }
            }
        }
    }

    private static HashMap<String, Long> m8459a(FacebookCalendar facebookCalendar, boolean z) {
        HashMap<String, Long> c = Maps.c();
        for (SyncEntry syncEntry : facebookCalendar.m8449a()) {
            if (z) {
                facebookCalendar.m8450a(syncEntry.f7216a);
            }
            c.put(String.valueOf(syncEntry.f7217b), Long.valueOf(syncEntry.f7216a));
        }
        return c;
    }

    private static List<FacebookCalendarEvent> m8460a(FetchUpcomingEventsQueryModel fetchUpcomingEventsQueryModel) {
        List<FacebookCalendarEvent> a = Lists.a();
        if (!(fetchUpcomingEventsQueryModel.a() == null || fetchUpcomingEventsQueryModel.a().a() == null)) {
            ImmutableList a2 = fetchUpcomingEventsQueryModel.a().a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                a.add(new FacebookCalendarEvent((EventCommonFragment) a2.get(i)));
            }
        }
        return a;
    }
}

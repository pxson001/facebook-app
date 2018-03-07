package com.facebook.events.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.data.EventsDAO;
import com.facebook.events.model.Event;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.wearable.internal.IFileDescriptorReceiver */
public class EventsDiscoveryDashboardEventsLoader {
    public Context f16773a;
    public EventsCommonContract f16774b;
    private EventsDashboardSequenceLogger f16775c;
    private ListeningExecutorService f16776d;
    public int f16777e;
    private EventsDAO f16778f;
    private ImmutableList<Event> f16779g;

    public static EventsDiscoveryDashboardEventsLoader m17163b(InjectorLike injectorLike) {
        return new EventsDiscoveryDashboardEventsLoader((Context) injectorLike.getInstance(Context.class), EventsCommonContract.b(injectorLike), EventsDAO.a(injectorLike), EventsDashboardSequenceLogger.m17147a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventsDiscoveryDashboardEventsLoader(Context context, EventsCommonContract eventsCommonContract, EventsDAO eventsDAO, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, ListeningExecutorService listeningExecutorService) {
        this.f16773a = context;
        this.f16774b = eventsCommonContract;
        this.f16778f = eventsDAO;
        this.f16775c = eventsDashboardSequenceLogger;
        this.f16776d = listeningExecutorService;
    }

    public static EventsDiscoveryDashboardEventsLoader m17162a(InjectorLike injectorLike) {
        return m17163b(injectorLike);
    }

    public final ListenableFuture<Cursor> m17165a(final DashboardFilterType dashboardFilterType) {
        this.f16775c.m17151a(LoadingState.DB_FETCH);
        return this.f16776d.a(new Callable<Cursor>(this) {
            final /* synthetic */ EventsDiscoveryDashboardEventsLoader f16771b;

            public Object call() {
                Uri uri;
                String e;
                EventsDiscoveryDashboardEventsLoader eventsDiscoveryDashboardEventsLoader = this.f16771b;
                switch (dashboardFilterType) {
                    case PAST:
                        uri = eventsDiscoveryDashboardEventsLoader.f16774b.e;
                        break;
                    case INVITED:
                        uri = eventsDiscoveryDashboardEventsLoader.f16774b.f;
                        break;
                    case HOSTING:
                        uri = eventsDiscoveryDashboardEventsLoader.f16774b.g;
                        break;
                    default:
                        uri = eventsDiscoveryDashboardEventsLoader.f16774b.d;
                        break;
                }
                Uri uri2 = uri;
                if (dashboardFilterType == DashboardFilterType.PAST) {
                    e = Columns.H.e();
                } else {
                    e = null;
                }
                Cursor query = this.f16771b.f16773a.getContentResolver().query(uri2, null, null, null, e);
                if (query != null) {
                    query.getCount();
                }
                return query;
            }
        });
    }

    public final ImmutableList<Event> m17164a(Cursor cursor, int i) {
        Builder builder = new Builder();
        this.f16778f.a(cursor);
        while (this.f16777e < this.f16778f.b() && i > 0) {
            this.f16778f.a(this.f16777e);
            builder.c(this.f16778f.d());
            this.f16777e++;
            i--;
        }
        this.f16777e = 0;
        if (!(cursor == null || cursor.isClosed())) {
            cursor.close();
        }
        this.f16779g = builder.b();
        return this.f16779g;
    }
}

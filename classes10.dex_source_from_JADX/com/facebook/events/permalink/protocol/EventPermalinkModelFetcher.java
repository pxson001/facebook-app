package com.facebook.events.permalink.protocol;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.events.data.EventsDAO;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchEventPermalinkQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: background_location_traveling_nux_should_show_traveling_nux_fetch_fail */
public class EventPermalinkModelFetcher {
    private final ScreenUtil f18797a;
    public final ListeningExecutorService f18798b;
    private final GraphQLQueryExecutor f18799c;
    private final QeAccessor f18800d;
    private final AutomaticPhotoCaptioningUtils f18801e;

    /* compiled from: background_location_traveling_nux_should_show_traveling_nux_fetch_fail */
    public class C26701 implements Callable<Event> {
        final /* synthetic */ Context f18794a;
        final /* synthetic */ Uri f18795b;
        final /* synthetic */ EventPermalinkModelFetcher f18796c;

        public C26701(EventPermalinkModelFetcher eventPermalinkModelFetcher, Context context, Uri uri) {
            this.f18796c = eventPermalinkModelFetcher;
            this.f18794a = context;
            this.f18795b = uri;
        }

        public Object call() {
            Throwable th;
            Cursor cursor = null;
            try {
                Cursor query = this.f18794a.getContentResolver().query(this.f18795b, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            EventsDAO eventsDAO = new EventsDAO(query);
                            eventsDAO.a();
                            Object d = eventsDAO.d();
                            if (query == null) {
                                return d;
                            }
                            query.close();
                            return d;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public static EventPermalinkModelFetcher m19102b(InjectorLike injectorLike) {
        return new EventPermalinkModelFetcher(ScreenUtil.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    public static EventPermalinkModelFetcher m19101a(InjectorLike injectorLike) {
        return m19102b(injectorLike);
    }

    @Inject
    public EventPermalinkModelFetcher(ScreenUtil screenUtil, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f18797a = screenUtil;
        this.f18798b = listeningExecutorService;
        this.f18799c = graphQLQueryExecutor;
        this.f18800d = qeAccessor;
        this.f18801e = automaticPhotoCaptioningUtils;
    }

    public final ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>> m19103a(Context context, String str) {
        FetchEventPermalinkQueryString fetchEventPermalinkQueryString = new FetchEventPermalinkQueryString();
        fetchEventPermalinkQueryString.a("event_id", str);
        fetchEventPermalinkQueryString.a("profile_image_size", String.valueOf(context.getResources().getDimensionPixelSize(2131431132)));
        fetchEventPermalinkQueryString.a("cover_image_portrait_size", Integer.valueOf(this.f18797a.f()));
        fetchEventPermalinkQueryString.a("cover_image_landscape_size", Integer.valueOf(this.f18797a.g()));
        fetchEventPermalinkQueryString.a("fetch_attending_activity", Boolean.valueOf(this.f18800d.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForEventsGatingModule.k, false)));
        fetchEventPermalinkQueryString.a("should_fetch_ticket_tiers", Boolean.valueOf(this.f18800d.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForEventsGatingModule.i, false)));
        fetchEventPermalinkQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f18801e.a()));
        GraphQLRequest a = GraphQLRequest.a(EventsGraphQL.b()).a(GraphQLCachePolicy.d);
        a.b = true;
        return this.f18799c.a(a.a(fetchEventPermalinkQueryString.a));
    }
}

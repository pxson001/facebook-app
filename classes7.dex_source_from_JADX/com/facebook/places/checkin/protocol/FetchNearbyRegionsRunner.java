package com.facebook.places.checkin.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.Query;
import com.facebook.fql.FqlQueryRunner;
import com.facebook.ipc.katana.model.GeoRegion;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: initial_titan_sequence_id */
public class FetchNearbyRegionsRunner {
    public static final Field f11075a = new Field("abbr_name");
    public static final Field f11076b = new Field("type");
    public static final Field f11077c = new Field("page_fbid");
    public static final Field f11078d = new Field("latitude");
    public static final Field f11079e = new Field("longitude");
    public final FqlQueryRunner f11080f;
    public final ListeningExecutorService f11081g;

    /* compiled from: initial_titan_sequence_id */
    public class C09731 implements Callable<ImmutableList<GeoRegion>> {
        final /* synthetic */ Query f11073a;
        final /* synthetic */ FetchNearbyRegionsRunner f11074b;

        public C09731(FetchNearbyRegionsRunner fetchNearbyRegionsRunner, Query query) {
            this.f11074b = fetchNearbyRegionsRunner;
            this.f11073a = query;
        }

        public Object call() {
            return this.f11074b.f11080f.a(this.f11073a, GeoRegion.class, CallerContext.a(getClass()));
        }
    }

    @Inject
    public FetchNearbyRegionsRunner(FqlQueryRunner fqlQueryRunner, ListeningExecutorService listeningExecutorService) {
        this.f11080f = fqlQueryRunner;
        this.f11081g = listeningExecutorService;
    }
}

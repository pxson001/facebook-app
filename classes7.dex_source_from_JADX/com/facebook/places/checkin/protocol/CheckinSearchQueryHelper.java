package com.facebook.places.checkin.protocol;

import android.content.res.Resources;
import android.location.Location;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.calls.ContextInputSearchType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQL;
import com.facebook.places.graphql.PlacesGraphQL.CheckinSearchQueryString;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inner_error_code */
public class CheckinSearchQueryHelper {
    private static volatile CheckinSearchQueryHelper f11053d;
    public final Clock f11054a;
    private final Resources f11055b;
    public final LocationExtraDataRetriever f11056c;

    /* compiled from: inner_error_code */
    public /* synthetic */ class C09661 {
        public static final /* synthetic */ int[] f11052a = new int[SearchType.values().length];

        static {
            try {
                f11052a[SearchType.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11052a[SearchType.FORSALE_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11052a[SearchType.HIDE_GEOHUBS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11052a[SearchType.SOCIAL_SEARCH_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11052a[SearchType.SOCIAL_SEARCH_CONVERSION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static com.facebook.places.checkin.protocol.CheckinSearchQueryHelper m13026a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11053d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.checkin.protocol.CheckinSearchQueryHelper.class;
        monitor-enter(r1);
        r0 = f11053d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13027b(r0);	 Catch:{ all -> 0x0035 }
        f11053d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11053d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.protocol.CheckinSearchQueryHelper.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.protocol.CheckinSearchQueryHelper");
    }

    private static CheckinSearchQueryHelper m13027b(InjectorLike injectorLike) {
        return new CheckinSearchQueryHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), LocationExtraDataRetriever.m13051b(injectorLike));
    }

    @Inject
    public CheckinSearchQueryHelper(Clock clock, Resources resources, LocationExtraDataRetriever locationExtraDataRetriever) {
        this.f11054a = clock;
        this.f11055b = resources;
        this.f11056c = locationExtraDataRetriever;
    }

    public final GraphQLRequest m13028a(PlacePickerFetchParams placePickerFetchParams) {
        ContextInputSearchType contextInputSearchType;
        CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
        checkinSearchQueryInputCheckinSearchQuery.a(placePickerFetchParams.f11108a);
        Location location = placePickerFetchParams.f11109b;
        if (location != null) {
            double d;
            ViewerCoordinates c = new ViewerCoordinates().a(Double.valueOf(location.getLatitude())).b(Double.valueOf(location.getLongitude())).c(Double.valueOf((double) location.getAccuracy()));
            if (placePickerFetchParams.f11111d) {
                d = 0.0d;
            } else {
                d = (((double) (this.f11054a.a() - location.getTime())) * 1.0d) / 1000.0d;
            }
            ViewerCoordinates e = c.e(Double.valueOf(d));
            if (location.hasSpeed()) {
                e.d(Double.valueOf((double) location.getSpeed()));
            }
            checkinSearchQueryInputCheckinSearchQuery.a(e);
        }
        checkinSearchQueryInputCheckinSearchQuery.a("composer_entrypoint", placePickerFetchParams.f11114g.toString());
        if (StringUtil.a(placePickerFetchParams.f11108a)) {
            this.f11056c.m13053a(checkinSearchQueryInputCheckinSearchQuery);
        }
        CheckinSearchQueryString a = PlacesGraphQL.a();
        GraphQlQueryString a2 = a.a("query", checkinSearchQueryInputCheckinSearchQuery).a("num_results", Integer.valueOf(15));
        String str = "search_context";
        switch (C09661.f11052a[placePickerFetchParams.f11110c.ordinal()]) {
            case 1:
                contextInputSearchType = ContextInputSearchType.COMPOSER;
                break;
            case 2:
                contextInputSearchType = ContextInputSearchType.FORSALE_POST;
                break;
            case 3:
                contextInputSearchType = ContextInputSearchType.NON_GEOHUB_PLACES;
                break;
            case 4:
                contextInputSearchType = ContextInputSearchType.SOCIAL_SEARCH_COMMENT;
                break;
            case 5:
                contextInputSearchType = ContextInputSearchType.SOCIAL_SEARCH_CONVERSION;
                break;
            default:
                contextInputSearchType = ContextInputSearchType.CHECKIN;
                break;
        }
        a2.a(str, contextInputSearchType).a("fetch_address", "true");
        if (!StringUtil.a(placePickerFetchParams.f11112e)) {
            a.a("story_id", placePickerFetchParams.f11112e);
        }
        if (!StringUtil.a(placePickerFetchParams.f11113f)) {
            a.a("comment_id", placePickerFetchParams.f11113f);
        }
        return GraphQLRequest.a(PlacesGraphQL.a()).a(a.a);
    }
}

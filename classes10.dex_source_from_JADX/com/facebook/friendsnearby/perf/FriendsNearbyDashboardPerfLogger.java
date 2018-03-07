package com.facebook.friendsnearby.perf;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;

/* compiled from: ^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$ */
public class FriendsNearbyDashboardPerfLogger {
    public final PerformanceLogger f20612a;

    /* compiled from: ^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$ */
    public enum Marker {
        DASHBOARD_INIT_LOCATION(3145729, "FriendsNearbyDashboardInitLocation"),
        DASHBOARD_REFRESH_LOCATION(3145730, "FriendsNearbyDashboardRefreshLocation"),
        DASHBOARD_FETCH_DATA(3145731, "FriendsNearbyDashboardFetchData"),
        DASHBOARD_FETCH_DATA1(3145732, "FriendsNearbyDashboardFetchData1"),
        DASHBOARD_FETCH_DATA2(3145733, "FriendsNearbyDashboardFetchData2"),
        DASHBOARD_VIEW_RENDER(3145734, "FriendsNearbyDashboardViewRender"),
        DASHBOARD_INIT(3145735, "FriendsNearbyDashboardInit"),
        DASHBOARD_TTI(3145736, "FriendsNearbyDashboardTTI");
        
        public final int markerId;
        public final String markerName;

        private Marker(int i, String str) {
            this.markerId = i;
            this.markerName = str;
        }
    }

    public static FriendsNearbyDashboardPerfLogger m21025a(InjectorLike injectorLike) {
        return new FriendsNearbyDashboardPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public FriendsNearbyDashboardPerfLogger(PerformanceLogger performanceLogger) {
        this.f20612a = performanceLogger;
    }

    public final void m21026a(Marker marker) {
        if (marker == Marker.DASHBOARD_TTI) {
            PerformanceLogger performanceLogger = this.f20612a;
            MarkerConfig a = new MarkerConfig(marker.markerId, marker.markerName).a(new String[]{"friends_nearby"});
            a.n = true;
            performanceLogger.c(a);
            return;
        }
        this.f20612a.d(marker.markerId, marker.markerName);
    }

    public final void m21027b(Marker marker) {
        this.f20612a.c(marker.markerId, marker.markerName);
    }

    public final void m21028c(Marker marker) {
        this.f20612a.f(marker.markerId, marker.markerName);
    }
}

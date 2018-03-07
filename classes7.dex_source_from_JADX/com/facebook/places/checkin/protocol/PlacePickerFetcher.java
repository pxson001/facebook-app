package com.facebook.places.checkin.protocol;

import android.os.Handler;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.protocol.CheckinHistoryLoader.C09621;
import com.facebook.places.common.MockDeps;
import com.facebook.places.future.PlacesTasksManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tracked_packages_v2/ */
public class PlacePickerFetcher {
    public static final String f11122a = PlacePickerFetcher.class.getCanonicalName();
    public final PlacesPerformanceLogger f11123b;
    public final CheckinSearchResultsLoader f11124c;
    public final PlacePickerAnalytics f11125d;
    public final CheckinHistoryLoader f11126e;
    public final PlacesTasksManager<Task> f11127f;
    public final QeAccessor f11128g;
    public final Handler f11129h = ((Handler) MockDeps.a(Handler.class, new Handler()));
    private final PerfTestConfig f11130i;
    public View f11131j;
    public Runnable f11132k;
    public Runnable f11133l;

    /* compiled from: tracked_packages_v2/ */
    public interface View {
        void mo60a();

        void mo61a(SearchResults searchResults);

        void mo62b();
    }

    /* compiled from: tracked_packages_v2/ */
    class C09781 implements Runnable {
        final /* synthetic */ PlacePickerFetcher f11115a;

        C09781(PlacePickerFetcher placePickerFetcher) {
            this.f11115a = placePickerFetcher;
        }

        public void run() {
            PlacePickerFetcher.m13064i(this.f11115a);
            PlacePickerFetcher.m13063g(this.f11115a);
        }
    }

    /* compiled from: tracked_packages_v2/ */
    public class C09803 implements Runnable {
        final /* synthetic */ PlacePickerFetchParams f11118a;
        final /* synthetic */ PlacePickerFetcher f11119b;

        public C09803(PlacePickerFetcher placePickerFetcher, PlacePickerFetchParams placePickerFetchParams) {
            this.f11119b = placePickerFetcher;
            this.f11118a = placePickerFetchParams;
        }

        public void run() {
            this.f11119b.f11132k = null;
            this.f11119b.m13066a(this.f11118a, true);
        }
    }

    /* compiled from: tracked_packages_v2/ */
    class C09814 implements Callable<ListenableFuture<SearchResults>> {
        final /* synthetic */ PlacePickerFetcher f11120a;

        C09814(PlacePickerFetcher placePickerFetcher) {
            this.f11120a = placePickerFetcher;
        }

        public Object call() {
            CheckinHistoryLoader checkinHistoryLoader = this.f11120a.f11126e;
            return checkinHistoryLoader.f11031b.a(new C09621(checkinHistoryLoader));
        }
    }

    /* compiled from: tracked_packages_v2/ */
    class C09825 extends AbstractDisposableFutureCallback<SearchResults> {
        final /* synthetic */ PlacePickerFetcher f11121a;

        C09825(PlacePickerFetcher placePickerFetcher) {
            this.f11121a = placePickerFetcher;
        }

        protected final void m13058a(Object obj) {
            SearchResults searchResults = (SearchResults) obj;
            this.f11121a.f11125d.c(false);
            this.f11121a.f11123b.a();
            this.f11121a.f11131j.mo61a(searchResults);
            this.f11121a.f11131j.mo60a();
        }

        protected final void m13059a(Throwable th) {
            this.f11121a.f11131j.mo60a();
            BLog.b(PlacePickerFetcher.f11122a, "Error getting checkin history", th);
        }
    }

    /* compiled from: tracked_packages_v2/ */
    enum Task {
        NEARBY,
        MOST_RECENT
    }

    public static PlacePickerFetcher m13061b(InjectorLike injectorLike) {
        return new PlacePickerFetcher(PlacesPerformanceLogger.a(injectorLike), PlacePickerAnalytics.a(injectorLike), CheckinHistoryLoader.m13012a(injectorLike), PlacesTasksManager.c(injectorLike), CheckinSearchResultsLoader.m13043b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PerfTestConfig.a(injectorLike));
    }

    public static PlacePickerFetcher m13060a(InjectorLike injectorLike) {
        return m13061b(injectorLike);
    }

    @Inject
    public PlacePickerFetcher(PlacesPerformanceLogger placesPerformanceLogger, PlacePickerAnalytics placePickerAnalytics, CheckinHistoryLoader checkinHistoryLoader, PlacesTasksManager placesTasksManager, CheckinSearchResultsLoader checkinSearchResultsLoader, QeAccessor qeAccessor, PerfTestConfig perfTestConfig) {
        this.f11124c = (CheckinSearchResultsLoader) MockDeps.a(CheckinSearchResultsLoader.class, checkinSearchResultsLoader);
        this.f11123b = (PlacesPerformanceLogger) MockDeps.a(PlacesPerformanceLogger.class, placesPerformanceLogger);
        this.f11125d = (PlacePickerAnalytics) MockDeps.a(PlacePickerAnalytics.class, placePickerAnalytics);
        this.f11126e = (CheckinHistoryLoader) MockDeps.a(CheckinHistoryLoader.class, checkinHistoryLoader);
        this.f11127f = (PlacesTasksManager) MockDeps.a(PlacesTasksManager.class, placesTasksManager);
        this.f11128g = (QeAccessor) MockDeps.a(QeAccessor.class, qeAccessor);
        this.f11130i = perfTestConfig;
    }

    public final void m13066a(PlacePickerFetchParams placePickerFetchParams, boolean z) {
        boolean isSocialSearchType = placePickerFetchParams.f11110c.isSocialSearchType();
        if (placePickerFetchParams.f11109b == null && StringUtil.c(placePickerFetchParams.f11108a) && !isSocialSearchType) {
            this.f11124c.m13046b();
            m13062f();
            m13063g(this);
            return;
        }
        m13064i(this);
        if (!z) {
            this.f11123b.b(placePickerFetchParams.f11110c);
        }
        if (!z) {
            this.f11133l = new C09781(this);
            Handler handler = this.f11129h;
            Runnable runnable = this.f11133l;
            SearchType searchType = placePickerFetchParams.f11110c;
            long j = PerfTestConfigBase.l;
            if (j == 0) {
                Object obj = (searchType == SearchType.STATUS || searchType == SearchType.PHOTO || searchType == SearchType.VIDEO) ? 1 : null;
                j = obj != null ? 0 : 5000;
            }
            HandlerDetour.b(handler, runnable, j, -1366682486);
        }
        CheckinSearchResultsLoader checkinSearchResultsLoader = this.f11124c;
        final SearchType searchType2 = placePickerFetchParams.f11110c;
        checkinSearchResultsLoader.m13044a(placePickerFetchParams, (FutureCallback) new FutureCallback<SearchResults>(this) {
            final /* synthetic */ PlacePickerFetcher f11117b;

            public void onSuccess(@Nullable Object obj) {
                SearchResults searchResults = (SearchResults) obj;
                if (this.f11117b.f11128g.a(ExperimentsForCheckinAbTestModule.k, false)) {
                    this.f11117b.f11127f.c(Task.MOST_RECENT);
                }
                if (this.f11117b.f11133l != null) {
                    HandlerDetour.a(this.f11117b.f11129h, this.f11117b.f11133l);
                    this.f11117b.f11133l = null;
                }
                this.f11117b.f11123b.c(searchType2);
                this.f11117b.f11131j.mo61a(searchResults);
                this.f11117b.f11131j.mo60a();
            }

            public void onFailure(Throwable th) {
                if (this.f11117b.f11133l != null) {
                    HandlerDetour.a(this.f11117b.f11129h, this.f11117b.f11133l);
                    this.f11117b.f11133l = null;
                }
                BLog.b(PlacePickerFetcher.f11122a, "Error getting nearby places", th);
                this.f11117b.f11125d.g();
                this.f11117b.f11123b.a();
                this.f11117b.f11131j.mo62b();
            }
        });
        this.f11131j.mo60a();
    }

    private void m13062f() {
        if (this.f11132k != null) {
            HandlerDetour.a(this.f11129h, this.f11132k);
            this.f11132k = null;
        }
        this.f11131j.mo60a();
    }

    public static void m13063g(PlacePickerFetcher placePickerFetcher) {
        placePickerFetcher.f11127f.a(Task.MOST_RECENT, new C09814(placePickerFetcher), new C09825(placePickerFetcher));
        placePickerFetcher.f11131j.mo60a();
    }

    public final void m13065a() {
        m13062f();
        HandlerDetour.a(this.f11129h, this.f11133l);
        m13064i(this);
    }

    public static void m13064i(PlacePickerFetcher placePickerFetcher) {
        placePickerFetcher.f11127f.c();
        placePickerFetcher.f11124c.m13046b();
    }
}

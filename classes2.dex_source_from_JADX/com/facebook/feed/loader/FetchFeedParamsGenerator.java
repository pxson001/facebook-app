package com.facebook.feed.loader;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.util.FeedUtils;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.logging.viewport.RecentVpvs;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: send */
public class FetchFeedParamsGenerator {
    public final User f5676a;
    public final Clock f5677b;
    private final RecentVpvs f5678c;
    private final FbNetworkManager f5679d;
    private final GatekeeperStoreImpl f5680e;
    @Nullable
    public CallerContext f5681f;

    public static FetchFeedParamsGenerator m9794b(InjectorLike injectorLike) {
        return new FetchFeedParamsGenerator(User_LoggedInUserMethodAutoProvider.m5748b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), RecentVpvs.m9803a(injectorLike), FbNetworkManager.m3811a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public FetchFeedParamsGenerator(User user, Clock clock, RecentVpvs recentVpvs, FbNetworkManager fbNetworkManager, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f5676a = user;
        this.f5677b = clock;
        this.f5678c = recentVpvs;
        this.f5679d = fbNetworkManager;
        this.f5680e = gatekeeperStoreImpl;
    }

    public static FetchFeedParamsGenerator m9792a(InjectorLike injectorLike) {
        return m9794b(injectorLike);
    }

    public final void m9801a(CallerContext callerContext) {
        this.f5681f = callerContext;
    }

    public final FetchFeedParams m9799a(FeedType feedType, String str, int i, boolean z, DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause) {
        if (str == null && feedType.m8964e() != CachePolicy.NO_CACHE) {
            str = "cold_start_cursor";
        }
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.f5799a = dataFreshnessParam;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5800b = feedType;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5801c = i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5805g = str;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.m9925a(fetchFeedCause);
        fetchFeedParamsBuilder.f5808j = z;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5814p = true;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5809k = FetchTypeForLogging.HEAD;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        m9793a(fetchFeedParamsBuilder);
        return fetchFeedParamsBuilder.m9930q();
    }

    public final FetchFeedParams m9798a(FeedType feedType, String str, int i, DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause) {
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.f5799a = dataFreshnessParam;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5800b = feedType;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5801c = i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5805g = str;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.m9925a(fetchFeedCause);
        fetchFeedParamsBuilder.f5809k = FetchTypeForLogging.HEAD;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        m9793a(fetchFeedParamsBuilder);
        return fetchFeedParamsBuilder.m9930q();
    }

    public final FetchFeedParams m9802b(FeedType feedType, String str, int i, DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause) {
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.f5799a = dataFreshnessParam;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5800b = feedType;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5801c = i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5804f = str;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.m9925a(fetchFeedCause);
        fetchFeedParamsBuilder.f5809k = FetchTypeForLogging.TAIL;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        m9793a(fetchFeedParamsBuilder);
        return fetchFeedParamsBuilder.m9930q();
    }

    public static FetchFeedParams m9791a(FeedType feedType, int i, FetchFeedCause fetchFeedCause, long j) {
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.f5799a = DataFreshnessParam.STALE_DATA_OKAY;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5800b = feedType;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5801c = i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.m9925a(fetchFeedCause);
        fetchFeedParamsBuilder.f5808j = false;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5809k = FetchTypeForLogging.HEAD;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5803e = j;
        return fetchFeedParamsBuilder.m9930q();
    }

    private void m9793a(FetchFeedParamsBuilder fetchFeedParamsBuilder) {
        m9795b(fetchFeedParamsBuilder);
        m9797d(fetchFeedParamsBuilder);
    }

    private void m9795b(FetchFeedParamsBuilder fetchFeedParamsBuilder) {
        RecentVpvs recentVpvs = this.f5678c;
        int i = 120;
        List a = Lists.m1296a();
        for (Entry key : recentVpvs.f5684b.m9849c().entrySet()) {
            a.add(key.getKey());
        }
        List a2 = Lists.m1301a(a);
        Builder builder = new Builder();
        int size = i == 0 ? a2.size() : Math.min(i, a2.size());
        for (int i2 = 0; i2 < size; i2++) {
            builder.m1069c(a2.get(i2));
        }
        fetchFeedParamsBuilder.f5812n = builder.m1068b();
    }

    public final FetchFeedParams m9800a(FeedType feedType, String str, int i, boolean z, DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z2, boolean z3, long j) {
        boolean z4;
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.f5799a = dataFreshnessParam;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5800b = feedType;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5801c = i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5804f = str;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.m9925a(fetchFeedCause);
        fetchFeedParamsBuilder.f5808j = z;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5809k = FetchTypeForLogging.TAIL;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f5813o = z2;
        FetchFeedParamsBuilder fetchFeedParamsBuilder2 = fetchFeedParamsBuilder;
        if (!z3 || this.f5679d.m3828d()) {
            z4 = false;
        } else {
            z4 = true;
        }
        fetchFeedParamsBuilder2.f5814p = z4;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder2;
        fetchFeedParamsBuilder.f5803e = j;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        m9796c(fetchFeedParamsBuilder);
        return fetchFeedParamsBuilder.m9930q();
    }

    private void m9796c(FetchFeedParamsBuilder fetchFeedParamsBuilder) {
        if (this.f5680e.m2189a(1118, false)) {
            m9795b(fetchFeedParamsBuilder);
        }
        m9797d(fetchFeedParamsBuilder);
    }

    private void m9797d(FetchFeedParamsBuilder fetchFeedParamsBuilder) {
        String str;
        if (this.f5676a != null) {
            str = this.f5676a.f3598a;
        } else {
            str = "0";
        }
        fetchFeedParamsBuilder.f5806h = FeedUtils.m11182a(str, this.f5677b);
        fetchFeedParamsBuilder.f5811m = this.f5681f;
    }
}

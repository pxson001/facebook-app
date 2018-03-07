package com.facebook.feed.loader;

import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchRequestState;
import com.facebook.api.feedtype.FeedType;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: setupPbufferSurface */
public interface IFeedDataLoader {
    FetchRequestState mo1290a(DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z);

    String mo1312a();

    void mo1313a(FeedType feedType);

    void mo1291a(FeedDataLoaderListener feedDataLoaderListener);

    void mo1292a(StoryRankingTimeTracker storyRankingTimeTracker);

    void mo1314a(boolean z);

    boolean mo1293a(FetchFeedCause fetchFeedCause);

    boolean mo1294a(FeedDataLoaderInitializationParams feedDataLoaderInitializationParams);

    void mo1295b();

    void mo1296b(DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z);

    void mo1297b(FeedDataLoaderListener feedDataLoaderListener);

    FeedUnitCollection mo1315c();

    boolean mo1298d();

    boolean mo1299e();

    void mo1300f();

    boolean mo1301g();

    boolean mo1302h();

    void mo1316i();

    void mo1317j();

    void mo1304k();

    FeedType mo1318l();

    void mo1319m();

    boolean mo1320n();

    boolean mo1305o();

    boolean mo1306p();

    boolean mo1321q();

    void mo1307r();

    int mo1308s();

    void mo1309t();
}

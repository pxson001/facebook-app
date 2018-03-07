package com.facebook.timeline.datafetcher;

import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import javax.annotation.Nullable;

/* compiled from: groupInformation or groupId is null in reportGroup */
public class TimelineEarlyFetchFutures {
    public final HeaderFetchFutures f10453a;
    @Nullable
    public final FetchContactCacheTask f10454b;
    @Nullable
    public final FirstUnitsObservables f10455c;

    public TimelineEarlyFetchFutures(HeaderFetchFutures headerFetchFutures, @Nullable FetchContactCacheTask fetchContactCacheTask, @Nullable FirstUnitsObservables firstUnitsObservables) {
        this.f10453a = headerFetchFutures;
        this.f10454b = fetchContactCacheTask;
        this.f10455c = firstUnitsObservables;
    }
}

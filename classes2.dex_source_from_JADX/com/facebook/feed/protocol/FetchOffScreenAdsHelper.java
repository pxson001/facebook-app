package com.facebook.feed.protocol;

import com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig;
import com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader;
import javax.inject.Inject;

/* compiled from: responseObject should either be JsonParser or InputStream */
public class FetchOffScreenAdsHelper {
    public final FeedOffScreenAdsFetchXConfigReader f7013a;

    @Inject
    public FetchOffScreenAdsHelper(FeedOffScreenAdsFetchXConfigReader feedOffScreenAdsFetchXConfigReader) {
        this.f7013a = feedOffScreenAdsFetchXConfigReader;
    }

    public final int m11574b() {
        FeedOffScreenAdsFetchXConfigReader feedOffScreenAdsFetchXConfigReader = this.f7013a;
        if (!feedOffScreenAdsFetchXConfigReader.f7017c) {
            feedOffScreenAdsFetchXConfigReader.f7021g = feedOffScreenAdsFetchXConfigReader.f7015a.m2686a(FeedOffScreenAdsFetchXConfig.f7027g, false);
            feedOffScreenAdsFetchXConfigReader.f7017c = true;
        }
        if (!feedOffScreenAdsFetchXConfigReader.f7021g) {
            return this.f7013a.m11577a();
        }
        feedOffScreenAdsFetchXConfigReader = this.f7013a;
        if (feedOffScreenAdsFetchXConfigReader.f7022h == -1) {
            feedOffScreenAdsFetchXConfigReader.f7022h = feedOffScreenAdsFetchXConfigReader.f7015a.m2683a(FeedOffScreenAdsFetchXConfig.f7028h, feedOffScreenAdsFetchXConfigReader.m11577a());
        }
        return feedOffScreenAdsFetchXConfigReader.f7022h;
    }
}

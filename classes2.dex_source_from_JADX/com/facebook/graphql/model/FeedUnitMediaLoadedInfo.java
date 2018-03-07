package com.facebook.graphql.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: max_comments */
public class FeedUnitMediaLoadedInfo {
    public final List<MediaLoadedInfo> f14911a;

    public FeedUnitMediaLoadedInfo(List<MediaLoadedInfo> list) {
        this.f14911a = list;
    }

    public FeedUnitMediaLoadedInfo() {
        this.f14911a = new ArrayList();
    }

    public final int m21356a() {
        int i = 0;
        for (MediaLoadedInfo mediaLoadedInfo : this.f14911a) {
            i = mediaLoadedInfo.f15044a + i;
        }
        return i;
    }
}

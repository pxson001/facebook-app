package com.facebook.feed.data.freshfeed.ranking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nullable;

/* compiled from: good_friends */
public class ClientRankingSignal {
    @JsonIgnore
    public boolean f22199a;
    @JsonProperty("client_weight")
    public double mClientWeight;
    @JsonProperty("features_meta")
    @Nullable
    public String mFeaturesMeta;
    @JsonProperty("feched_at")
    public long mFetchedAt;
    @JsonProperty("image_cache_state")
    public int mImageCacheState;
    @JsonProperty("live_video_state")
    public int mLiveVideoState;
    @JsonProperty("weight")
    public double mRankingWeight;
    @JsonProperty("client_seen_state")
    public int mSeenState;

    public final void m30078a(int i) {
        if (i != this.mSeenState) {
            this.f22199a = true;
        }
        this.mSeenState = i;
    }

    public final void m30082b(int i) {
        if (i != this.mImageCacheState) {
            this.f22199a = true;
        }
        this.mImageCacheState = i;
    }

    public final void m30081b(double d) {
        if (d != this.mRankingWeight) {
            this.f22199a = true;
        }
        this.mRankingWeight = d;
    }

    public final void m30079a(long j) {
        if (j != this.mFetchedAt) {
            this.f22199a = true;
        }
        this.mFetchedAt = j;
    }

    public final void m30080a(String str) {
        if (!((str == null && this.mFeaturesMeta == null) || str == null || str.equals(this.mFeaturesMeta))) {
            this.f22199a = true;
        }
        this.mFeaturesMeta = str;
    }

    public final void m30083c(int i) {
        if (i != this.mLiveVideoState) {
            this.f22199a = true;
        }
        this.mLiveVideoState = i;
    }
}

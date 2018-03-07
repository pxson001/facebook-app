package com.facebook.video.chromecast;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoPlayerParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mAddress */
public class VideoCastParams implements VideoPlaybackAnalyticsParams {
    public final String f9665a;
    public final String f9666b;
    public final String f9667c;
    public final String f9668d;
    public final ArrayNode f9669e;
    public final boolean f9670f;
    private final boolean f9671g;
    private final boolean f9672h;
    private final int f9673i;
    @Nullable
    public final PlayerOrigin f9674j;
    @Nullable
    public final ImageRequest f9675k;
    @Nullable
    public final ImageRequest f9676l;
    @Nullable
    public ImmutableList<VideoDataSource> f9677m;
    public int f9678n;
    public int f9679o;
    public int f9680p;

    /* compiled from: mAddress */
    public class Builder {
        public String f9652a = "";
        private boolean f9653b = false;
        private String f9654c = "";
        public String f9655d = "";
        public String f9656e = "";
        private ArrayNode f9657f = new ArrayNode(JsonNodeFactory.a);
        private int f9658g;
        private boolean f9659h = false;
        private boolean f9660i = false;
        @Nullable
        public ImageRequest f9661j = null;
        @Nullable
        public ImageRequest f9662k;
        @Nullable
        public PlayerOrigin f9663l = PlayerOrigin.UNKNOWN;
        @Nullable
        private ImmutableList<VideoDataSource> f9664m = null;

        public static Builder m11382a(VideoPlayerParams videoPlayerParams) {
            Builder builder = new Builder();
            builder.f9664m = videoPlayerParams.a;
            builder.f9652a = videoPlayerParams.b;
            builder.f9657f = videoPlayerParams.e;
            builder.f9653b = videoPlayerParams.f;
            builder.f9659h = videoPlayerParams.h;
            builder.f9660i = videoPlayerParams.g;
            builder.f9658g = videoPlayerParams.c > 0 ? videoPlayerParams.c : 0;
            return builder;
        }

        public final Builder m11383a(String str) {
            if (str != null) {
                this.f9654c = str;
            }
            return this;
        }

        public final VideoCastParams m11384a() {
            return new VideoCastParams(this.f9652a, this.f9664m, this.f9654c, this.f9655d, this.f9656e, this.f9661j, this.f9662k, this.f9657f, this.f9653b, this.f9660i, this.f9659h, this.f9663l, this.f9658g);
        }
    }

    private VideoCastParams(String str, ImmutableList<VideoDataSource> immutableList, String str2, String str3, String str4, ImageRequest imageRequest, ImageRequest imageRequest2, ArrayNode arrayNode, boolean z, boolean z2, boolean z3, PlayerOrigin playerOrigin, int i) {
        if (immutableList == null || immutableList.isEmpty()) {
            this.f9680p = -1;
        } else {
            this.f9677m = immutableList;
            this.f9680p = 0;
        }
        this.f9665a = str;
        this.f9675k = imageRequest;
        this.f9676l = imageRequest2;
        this.f9666b = str2;
        this.f9667c = str3;
        this.f9668d = str4;
        this.f9669e = arrayNode;
        this.f9670f = z;
        this.f9671g = z2;
        this.f9672h = z3;
        this.f9674j = playerOrigin;
        this.f9673i = i;
    }

    public final int m11388d() {
        return this.f9673i;
    }

    public final String m11389h() {
        return this.f9665a;
    }

    @Nullable
    public final ArrayNode m11390m() {
        return this.f9669e;
    }

    public final boolean m11391n() {
        return this.f9670f;
    }

    public final boolean m11385a() {
        return this.f9672h;
    }

    public final boolean m11386b() {
        return this.f9671g;
    }

    public final String m11387c() {
        return "";
    }

    @Nullable
    public final PlayerOrigin m11392o() {
        return this.f9674j;
    }

    public final int m11393p() {
        return this.f9679o;
    }
}

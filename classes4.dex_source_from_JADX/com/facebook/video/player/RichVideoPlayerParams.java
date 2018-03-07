package com.facebook.video.player;

import com.facebook.video.engine.VideoPlayerParams;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: phoneticName */
public class RichVideoPlayerParams {
    public final VideoPlayerParams f4962a;
    public final ImmutableMap<String, ?> f4963b;
    public final ImmutableSet<String> f4964c;

    /* compiled from: phoneticName */
    public class Builder {
        public VideoPlayerParams f4958a;
        private final Map<String, Object> f4959b = new HashMap();
        private final Set<String> f4960c = new HashSet();
        private boolean f4961d;

        public static Builder m5349a(RichVideoPlayerParams richVideoPlayerParams) {
            Builder builder = new Builder();
            if (richVideoPlayerParams != null) {
                builder.m5354b(richVideoPlayerParams);
            }
            return builder;
        }

        public final Builder m5351a(VideoPlayerParams videoPlayerParams) {
            this.f4958a = videoPlayerParams;
            return this;
        }

        public final Builder m5352a(ImmutableMap<String, ?> immutableMap) {
            this.f4959b.clear();
            this.f4959b.putAll(immutableMap);
            return this;
        }

        public final Builder m5354b(RichVideoPlayerParams richVideoPlayerParams) {
            if (richVideoPlayerParams.f4962a != null) {
                this.f4958a = richVideoPlayerParams.f4962a;
            }
            if (richVideoPlayerParams.f4963b != null) {
                this.f4959b.putAll(richVideoPlayerParams.f4963b);
            }
            if (richVideoPlayerParams.f4964c != null) {
                this.f4960c.addAll(richVideoPlayerParams.f4964c);
            }
            return this;
        }

        public final Builder m5353a(String str, Object obj) {
            this.f4959b.put(str, obj);
            this.f4960c.remove(str);
            return this;
        }

        public final Builder m5350a() {
            this.f4961d = true;
            return this;
        }

        public final RichVideoPlayerParams m5355b() {
            if (this.f4961d) {
                for (String remove : this.f4960c) {
                    this.f4959b.remove(remove);
                }
                this.f4960c.clear();
            }
            return new RichVideoPlayerParams(this.f4958a, ImmutableMap.copyOf(this.f4959b), ImmutableSet.copyOf(this.f4960c));
        }
    }

    public RichVideoPlayerParams(VideoPlayerParams videoPlayerParams, ImmutableMap<String, ?> immutableMap, ImmutableSet<String> immutableSet) {
        this.f4962a = videoPlayerParams;
        this.f4963b = immutableMap;
        this.f4964c = immutableSet;
    }

    public final boolean m5356a() {
        return this.f4962a != null && this.f4962a.f4839h;
    }

    public final boolean m5357b() {
        Double d = (Double) this.f4963b.get("VideoAspectRatioKey");
        return d != null && d.doubleValue() < 0.9d;
    }

    public final boolean m5358c() {
        return (this.f4962a == null || this.f4962a.f4850s == null) ? false : true;
    }

    public final Builder m5359d() {
        return Builder.m5349a(this);
    }
}

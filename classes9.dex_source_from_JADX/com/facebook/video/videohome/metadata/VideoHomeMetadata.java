package com.facebook.video.videohome.metadata;

import com.facebook.graphql.enums.GraphQLVideoHomeBadgeUpdateReason;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: source_latitude */
public class VideoHomeMetadata {
    public final int f2980a;
    public final int f2981b;
    public final int f2982c;
    public final long f2983d;
    public final long f2984e;
    @Nullable
    public final GraphQLVideoHomeBadgeUpdateReason f2985f;

    /* compiled from: source_latitude */
    public class Builder {
        public int f2974a;
        public int f2975b;
        public int f2976c;
        public long f2977d;
        public long f2978e;
        @Nullable
        public GraphQLVideoHomeBadgeUpdateReason f2979f;

        public final VideoHomeMetadata m2884a() {
            return new VideoHomeMetadata(this.f2974a, this.f2975b, this.f2976c, this.f2977d, this.f2978e, this.f2979f);
        }
    }

    public VideoHomeMetadata(int i, int i2, int i3, long j, long j2, @Nullable GraphQLVideoHomeBadgeUpdateReason graphQLVideoHomeBadgeUpdateReason) {
        this.f2983d = j;
        this.f2980a = i;
        this.f2981b = i2;
        this.f2982c = i3;
        this.f2984e = j2;
        this.f2985f = graphQLVideoHomeBadgeUpdateReason;
    }
}

package com.facebook.api.feedcache.db;

import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbRequest;
import com.facebook.graphql.model.FeedUnit;
import javax.annotation.Nullable;

/* compiled from: mp4 */
public class FeedDbMutationService$FeedDbMutationRequest implements FeedDbRequest {
    public final FeedUnit f9785a;
    public final String f9786b;
    public final String f9787c;
    public final String f9788d;
    public final String f9789e;
    @Nullable
    public final byte[] f9790f;
    @Nullable
    public final byte[] f9791g;

    public FeedDbMutationService$FeedDbMutationRequest(FeedUnit feedUnit, String str, String str2, String str3, String str4, byte[] bArr, byte[] bArr2) {
        this.f9785a = feedUnit;
        this.f9786b = str;
        this.f9787c = str2;
        this.f9789e = str4;
        this.f9788d = str3;
        this.f9790f = bArr;
        this.f9791g = bArr2;
    }
}

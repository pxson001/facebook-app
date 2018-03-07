package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: result_categories */
public class PageHeaderEarlyFetchIdentifier {
    public final long f2480a;

    public PageHeaderEarlyFetchIdentifier(long j) {
        this.f2480a = j;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PageHeaderEarlyFetchIdentifier) && ((PageHeaderEarlyFetchIdentifier) obj).f2480a == this.f2480a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f2480a)});
    }
}

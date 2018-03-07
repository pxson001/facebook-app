package com.facebook.vault.protocol;

import java.util.Set;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d AND timestamp <= %2$d */
public class VaultGetSyncedImageStatusParams {
    public final long f1860a;
    public final Set<String> f1861b;
    private long f1862c;

    public VaultGetSyncedImageStatusParams(long j, Set<String> set, long j2) {
        this.f1860a = j;
        this.f1861b = set;
        this.f1862c = j2;
    }

    public final String m1940c() {
        return Long.toString(this.f1862c);
    }
}

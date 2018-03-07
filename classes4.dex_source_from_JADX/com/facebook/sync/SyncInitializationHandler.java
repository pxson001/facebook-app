package com.facebook.sync;

import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: frameSystemTimeBuffer */
public interface SyncInitializationHandler {

    /* compiled from: frameSystemTimeBuffer */
    public enum EnsureSyncTrigger {
        NORMAL,
        GATEKEEPER_CHANGED,
        PREFKEY_CHANGED
    }

    void mo839a(EnsureSyncTrigger ensureSyncTrigger);

    boolean mo840a();

    ImmutableList<PrefKey> mo841b();

    void mo842b(EnsureSyncTrigger ensureSyncTrigger);

    ImmutableList<Integer> mo843c();

    @Nullable
    String mo844d();

    void mo845e();
}

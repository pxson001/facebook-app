package com.facebook.messaging.sync.delta.handlerbase;

import android.os.Bundle;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.sync.delta.BaseDeltaHandler;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;

/* compiled from: profile_qr?source={%s %s} */
public abstract class AbstractMessagesDeltaHandler implements BaseDeltaHandler {
    public abstract Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId);

    public abstract ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper);

    public abstract boolean mo127b(DeltaWrapper deltaWrapper);

    public ImmutableMap<ThreadKey, String> mo128c(DeltaWrapper deltaWrapper) {
        return RegularImmutableBiMap.a;
    }

    public boolean mo130e(DeltaWrapper deltaWrapper) {
        return false;
    }

    public boolean mo129d(DeltaWrapper deltaWrapper) {
        return false;
    }
}

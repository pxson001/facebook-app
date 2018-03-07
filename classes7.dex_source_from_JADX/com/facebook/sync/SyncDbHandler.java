package com.facebook.sync;

import android.os.Bundle;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.google.common.collect.ImmutableMap;
import java.util.List;

/* compiled from: feeling */
public interface SyncDbHandler<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> {
    long m18318a();

    Bundle m18319a(PREFETCH_DATA_TYPE prefetch_data_type, DeltaWithSequenceId<DELTA_WRAPPER_TYPE> deltaWithSequenceId);

    ImmutableMap<Long, Bundle> m18320a(PREFETCH_DATA_TYPE prefetch_data_type, List<DeltaWithSequenceId<DELTA_WRAPPER_TYPE>> list);

    void m18321a(long j);

    void m18322a(boolean z, FullRefreshReason fullRefreshReason);

    void m18323b(long j);

    boolean m18324b();

    FullRefreshReason m18325c();

    long m18326d();

    String m18327e();

    boolean m18328f();
}

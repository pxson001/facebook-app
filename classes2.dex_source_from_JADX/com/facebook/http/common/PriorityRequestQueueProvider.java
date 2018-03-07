package com.facebook.http.common;

import com.facebook.http.common.prioritization.PolicyChecker;
import com.facebook.http.common.prioritization.PrioritizationPolicy;
import com.facebook.http.common.prioritization.UnblockableRequestChecker;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: recent_save_info_unread_count */
public class PriorityRequestQueueProvider extends AbstractAssistedProvider<PriorityRequestQueue> {
    public final PriorityRequestQueue m12469a(PrioritizationPolicy prioritizationPolicy) {
        return new PriorityRequestQueue(PriorityInflightRequests.m12511a((InjectorLike) this), PolicyChecker.m12527a(this), UnblockableRequestChecker.m12530a((InjectorLike) this), prioritizationPolicy);
    }
}

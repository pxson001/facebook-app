package com.facebook.backgroundtasks;

import com.google.common.base.Optional;

/* compiled from: suggest_text_2_url */
class RadioBasedBackgroundTaskRunner$RunnableNode implements Comparable<RadioBasedBackgroundTaskRunner$RunnableNode> {
    public final Runnable f2407a;
    public final Optional<Long> f2408b;
    final /* synthetic */ RadioBasedBackgroundTaskRunner f2409c;

    public int compareTo(Object obj) {
        return Long.valueOf(m3311a()).compareTo(Long.valueOf(((RadioBasedBackgroundTaskRunner$RunnableNode) obj).m3311a()));
    }

    public RadioBasedBackgroundTaskRunner$RunnableNode(RadioBasedBackgroundTaskRunner radioBasedBackgroundTaskRunner, Runnable runnable, Optional<Long> optional) {
        this.f2409c = radioBasedBackgroundTaskRunner;
        this.f2407a = runnable;
        this.f2408b = optional;
    }

    private long m3311a() {
        return this.f2408b.isPresent() ? ((Long) this.f2408b.get()).longValue() : Long.MAX_VALUE;
    }
}

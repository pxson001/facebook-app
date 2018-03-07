package com.facebook.common.executors;

/* compiled from: voip_country_blacklist */
public abstract class WrappingQueueingListeningExecutorService extends WrappingListeningExecutorService implements QueueingListeningExecutorService {
    private final QueueingListeningExecutorService f962a;

    public WrappingQueueingListeningExecutorService(QueueingListeningExecutorService queueingListeningExecutorService) {
        super(queueingListeningExecutorService);
        this.f962a = queueingListeningExecutorService;
    }

    public final void mo304d() {
        this.f962a.mo304d();
    }
}

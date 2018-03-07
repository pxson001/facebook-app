package com.facebook.common.executors;

/* compiled from: voip_enable_people_tab */
public abstract class WrappingConstrainedListeningExecutorService extends WrappingQueueingListeningExecutorService implements ConstrainedListeningExecutorService {
    private final ConstrainedListeningExecutorService f961a;

    public WrappingConstrainedListeningExecutorService(ConstrainedListeningExecutorService constrainedListeningExecutorService) {
        super(constrainedListeningExecutorService);
        this.f961a = constrainedListeningExecutorService;
    }

    public final int mo299a() {
        return this.f961a.mo299a();
    }

    public final int mo301b() {
        return this.f961a.mo301b();
    }

    public final void mo300a(int i) {
        this.f961a.mo300a(i);
    }
}

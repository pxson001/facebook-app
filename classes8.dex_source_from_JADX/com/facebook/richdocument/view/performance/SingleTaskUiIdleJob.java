package com.facebook.richdocument.view.performance;

/* compiled from: page_call_to_action_fields_extra */
public class SingleTaskUiIdleJob implements IncrementalUiIdleJob {
    private final Runnable f6916a;
    private boolean f6917b = false;

    public SingleTaskUiIdleJob(Runnable runnable) {
        this.f6916a = runnable;
    }

    public final boolean mo409i() {
        return !this.f6917b;
    }

    public final void mo410j() {
        this.f6916a.run();
        this.f6917b = true;
    }
}

package com.facebook.presence;

/* compiled from: download_task_marshal_io_exception */
public enum PayForPlayPresence {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean mShowPresence;

    private PayForPlayPresence(boolean z) {
        this.mShowPresence = z;
    }

    public final boolean shouldShowPresence() {
        return this.mShowPresence;
    }
}

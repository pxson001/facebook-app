package com.facebook.fbuploader;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: new_review_length */
public final class CompositeListener implements Listener {
    final Iterable<Listener> f10038a;
    private final AtomicBoolean f10039b = new AtomicBoolean(false);

    public CompositeListener(Iterable<Listener> iterable) {
        this.f10038a = iterable;
    }

    public final void mo1026a() {
        this.f10039b.set(false);
        for (Listener a : this.f10038a) {
            a.mo1026a();
        }
    }

    public final void mo1027a(float f) {
        for (Listener a : this.f10038a) {
            a.mo1027a(f);
        }
    }

    public final void mo1028a(UploadFailureException uploadFailureException) {
        if (!this.f10039b.getAndSet(true)) {
            for (Listener a : this.f10038a) {
                a.mo1028a(uploadFailureException);
            }
        }
    }

    public final void mo1030b() {
        if (!this.f10039b.getAndSet(true)) {
            for (Listener b : this.f10038a) {
                b.mo1030b();
            }
        }
    }

    public final void mo1029a(UploadResult uploadResult) {
        if (!this.f10039b.getAndSet(true)) {
            for (Listener a : this.f10038a) {
                a.mo1029a(uploadResult);
            }
        }
    }
}

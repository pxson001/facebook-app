package com.facebook.composer.savedsession;

import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: fetchRelayCache */
class ComposerSavedSessionStore$1 extends OperationResultFutureCallback2 {
    final /* synthetic */ Optional f6941a;
    final /* synthetic */ ComposerSavedSessionStore f6942b;

    ComposerSavedSessionStore$1(ComposerSavedSessionStore composerSavedSessionStore, Optional optional) {
        this.f6942b = composerSavedSessionStore;
        this.f6941a = optional;
    }

    protected final void m8262a(OperationResult operationResult) {
        if (!this.f6942b.h) {
            ComposerSavedSessionStore.b(this.f6942b, this.f6941a);
        }
    }

    protected final void m8264a(Throwable th) {
        this.f6942b.g.a("composer_session_save_failed", th);
        ComposerSavedSessionStore.b(this.f6942b, Absent.INSTANCE);
    }
}

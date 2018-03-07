package com.facebook.composer.savedsession;

import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: fetchRelayCache */
class ComposerSavedSessionStore$2 extends OperationResultFutureCallback2 {
    final /* synthetic */ ComposerSavedSessionStore f6943a;

    ComposerSavedSessionStore$2(ComposerSavedSessionStore composerSavedSessionStore) {
        this.f6943a = composerSavedSessionStore;
    }

    protected final void m8265a(OperationResult operationResult) {
        this.f6943a.h = false;
    }

    protected final void m8267a(Throwable th) {
        this.f6943a.h = false;
        this.f6943a.g.a("composer_session_delete_failed", th);
    }
}

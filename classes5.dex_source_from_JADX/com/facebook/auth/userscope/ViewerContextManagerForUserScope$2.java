package com.facebook.auth.userscope;

import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;

/* compiled from: suggested_event_context_sentence */
class ViewerContextManagerForUserScope$2 implements PushedViewerContext {
    final /* synthetic */ ViewerContext f2403b;
    final /* synthetic */ ViewerContextManagerForUserScope f2404c;

    ViewerContextManagerForUserScope$2(ViewerContextManagerForUserScope viewerContextManagerForUserScope, ViewerContext viewerContext) {
        this.f2404c = viewerContextManagerForUserScope;
        this.f2403b = viewerContext;
    }

    public void close() {
        if (this.f2404c.d().mUserId.equals(this.f2403b.mUserId)) {
            this.f2404c.f();
            return;
        }
        throw new IllegalStateException("Attempting to close a PushedViewerContext while  another was pushed");
    }
}

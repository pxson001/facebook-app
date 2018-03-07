package com.facebook.auth.module;

import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;

/* compiled from: in_experiment */
class ViewerContextManagerImpl$2 implements PushedViewerContext {
    final /* synthetic */ ViewerContext f10404b;
    final /* synthetic */ ViewerContextManagerImpl f10405c;

    ViewerContextManagerImpl$2(ViewerContextManagerImpl viewerContextManagerImpl, ViewerContext viewerContext) {
        this.f10405c = viewerContextManagerImpl;
        this.f10404b = viewerContext;
    }

    public void close() {
        if (this.f10405c.d().mUserId.equals(this.f10404b.mUserId)) {
            this.f10405c.f();
            return;
        }
        throw new IllegalStateException("Attempting to close a PushedViewerContext while  another was pushed");
    }
}

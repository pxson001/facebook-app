package com.facebook.auth.userscope;

import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import javax.annotation.Nullable;

/* compiled from: wifi_scan_include_frequency */
public class EmptyViewerContextManager implements ViewerContextManager {
    public static final ViewerContext f763a;

    static {
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.f764a = "0";
        newBuilder = newBuilder;
        newBuilder.f765b = "";
        f763a = newBuilder.m1532h();
    }

    public final ViewerContext mo212a() {
        return f763a;
    }

    @Nullable
    public final ViewerContext mo215b() {
        return null;
    }

    public final ViewerContext mo216c() {
        return f763a;
    }

    public final void mo213a(ViewerContext viewerContext) {
    }

    public final ViewerContext mo217d() {
        return f763a;
    }

    public final ViewerContext mo218e() {
        return null;
    }

    public final PushedViewerContext mo214b(ViewerContext viewerContext) {
        return PushedViewerContext.f14985a;
    }

    public final void mo219f() {
    }
}

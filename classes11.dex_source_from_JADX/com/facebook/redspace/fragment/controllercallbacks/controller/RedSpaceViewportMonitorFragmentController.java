package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: PageServiceAddEditPickerNativeModule */
public class RedSpaceViewportMonitorFragmentController<Dispatcher extends ViewportEventListener> extends BaseController implements FragmentCreateDestroyCallbacks {
    public final ViewportMonitor f12108a;
    public Dispatcher f12109b;

    @Inject
    public RedSpaceViewportMonitorFragmentController(@Assisted ViewportMonitor viewportMonitor) {
        this.f12108a = viewportMonitor;
    }

    public final void m12558b() {
        this.f12108a.b(this.f12109b);
    }
}

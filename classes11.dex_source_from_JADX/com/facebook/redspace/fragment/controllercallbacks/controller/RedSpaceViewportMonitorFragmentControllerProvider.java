package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: PageSecondaryCardsBatchRequest */
public class RedSpaceViewportMonitorFragmentControllerProvider extends AbstractAssistedProvider<RedSpaceViewportMonitorFragmentController> {
    public static <Dispatcher extends ViewportEventListener> RedSpaceViewportMonitorFragmentController<Dispatcher> m12559a(ViewportMonitor viewportMonitor) {
        return new RedSpaceViewportMonitorFragmentController(viewportMonitor);
    }
}

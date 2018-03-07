package com.facebook.common.appstate.dispatcher;

import com.facebook.inject.AbstractProvider;

/* compiled from: no vault cursor */
public class AppStateChangeEventDispatcherMethodAutoProvider extends AbstractProvider<AppStateChangeEventDispatcher> {
    public Object get() {
        return AppStateChangeEventDispatcherImpl.a(this);
    }
}

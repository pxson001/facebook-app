package com.facebook.common.appstate;

import com.facebook.inject.AbstractProvider;

/* compiled from: voip/ */
public class Boolean_IsAppInBackgroundMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return AppStateModule.c(AppStateManager.a(this));
    }
}

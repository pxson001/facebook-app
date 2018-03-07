package com.facebook.fbreact.abtest;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: vps */
public class Boolean_IsFb4aReactNativeEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbReactAbTestModule.a(IdBasedProvider.a(this, 3968));
    }
}

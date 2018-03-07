package com.facebook.zero.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.zero.common.constants.FbZeroTokenType;

/* compiled from: vjit_window */
public class FbZeroTokenType_CurrentlyActiveTokenTypeMethodAutoProvider extends AbstractProvider<FbZeroTokenType> {
    public Object get() {
        return ZeroCommonModule.a(IdBasedProvider.a(this, 3954));
    }
}

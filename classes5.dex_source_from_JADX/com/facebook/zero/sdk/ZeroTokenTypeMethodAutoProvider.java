package com.facebook.zero.sdk;

import com.facebook.inject.AbstractProvider;
import com.facebook.zero.sdk.constants.ZeroTokenType;

/* compiled from: com.facebook.fbservice.service.IBlueService */
public class ZeroTokenTypeMethodAutoProvider extends AbstractProvider<ZeroTokenType> {
    public Object get() {
        return ZeroTokenType.NORMAL;
    }
}

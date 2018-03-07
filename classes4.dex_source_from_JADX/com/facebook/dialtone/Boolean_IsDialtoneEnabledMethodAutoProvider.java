package com.facebook.dialtone;

import com.facebook.inject.AbstractProvider;

/* compiled from: voip_bwe_logging */
public class Boolean_IsDialtoneEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return DialtoneModule.a((DialtoneController) DialtoneControllerImpl.a(this));
    }
}

package com.facebook.dialtone;

import com.facebook.inject.AbstractProvider;

/* compiled from: visible */
public class Boolean_IsDialtonePhotoCapFeatureEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return DialtoneModule.d((DialtoneController) DialtoneControllerImpl.a(this));
    }
}

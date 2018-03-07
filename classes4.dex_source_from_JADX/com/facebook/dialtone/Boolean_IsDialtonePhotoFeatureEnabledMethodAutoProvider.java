package com.facebook.dialtone;

import com.facebook.inject.AbstractProvider;

/* compiled from: user_not_alerted_ */
public class Boolean_IsDialtonePhotoFeatureEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return DialtoneModule.c((DialtoneController) DialtoneControllerImpl.a(this));
    }
}

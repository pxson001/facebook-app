package com.facebook.dialtone;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: ^[0-9]+L$ */
public class Boolean_IsDialtoneFacewebFeatureEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m19814b(InjectorLike injectorLike) {
        return DialtoneModule.f((DialtoneController) DialtoneControllerImpl.a(injectorLike));
    }

    public Object get() {
        return DialtoneModule.f((DialtoneController) DialtoneControllerImpl.a(this));
    }
}

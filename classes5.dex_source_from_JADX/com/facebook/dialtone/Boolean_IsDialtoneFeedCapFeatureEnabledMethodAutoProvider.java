package com.facebook.dialtone;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: ]] */
public class Boolean_IsDialtoneFeedCapFeatureEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m19815b(InjectorLike injectorLike) {
        return DialtoneModule.e((DialtoneController) DialtoneControllerImpl.a(injectorLike));
    }

    public Object get() {
        return DialtoneModule.e((DialtoneController) DialtoneControllerImpl.a(this));
    }
}

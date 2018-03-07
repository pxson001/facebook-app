package com.facebook.config.application;

import com.facebook.common.build.SignatureType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: user_attributes */
public class SignatureTypeMethodAutoProvider extends AbstractProvider<SignatureType> {
    public static SignatureType m2801b(InjectorLike injectorLike) {
        return FbAppTypeModule.m1446b((FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    public Object get() {
        return FbAppTypeModule.m1446b((FbAppType) getInstance(FbAppType.class));
    }

    public static SignatureType m2800a(InjectorLike injectorLike) {
        return m2801b(injectorLike);
    }
}

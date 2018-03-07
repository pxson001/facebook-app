package com.facebook.messaging.quickcam;

import com.facebook.common.quickcam.CameraUtil;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: dequeueIntputBuffer failed */
public class Boolean_IsQuickCamVideoEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagingQuickCamModule.m16478a(IdBasedProvider.a(this, 4198), CameraUtil.m6329b((InjectorLike) this));
    }
}

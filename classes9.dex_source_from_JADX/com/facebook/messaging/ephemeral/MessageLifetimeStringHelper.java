package com.facebook.messaging.ephemeral;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mThemeList */
public class MessageLifetimeStringHelper {
    public final Resources f11022a;

    public static MessageLifetimeStringHelper m11436b(InjectorLike injectorLike) {
        return new MessageLifetimeStringHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessageLifetimeStringHelper(Resources resources) {
        this.f11022a = resources;
    }
}

package com.facebook.messaging.linkhandling;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: onChangeCapture */
public class ComponentName_ForSecureIntentHandlerActivityMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m9455b(InjectorLike injectorLike) {
        return LinkHandlingModule.m9459a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return LinkHandlingModule.m9459a((Context) getInstance(Context.class));
    }
}

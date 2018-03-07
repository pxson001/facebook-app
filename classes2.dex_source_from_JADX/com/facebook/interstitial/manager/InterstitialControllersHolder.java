package com.facebook.interstitial.manager;

import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: social_actor_photo */
public abstract class InterstitialControllersHolder {
    @Nullable
    public abstract InterstitialController mo1202a(String str);

    public abstract Collection<String> mo1203a();

    public abstract Collection<String> mo1204a(Action action);

    public abstract Collection<String> mo1205b();

    @Nullable
    public final <T extends InterstitialController> T m8135a(String str, Class<T> cls) {
        T a = mo1202a(str);
        return cls.isInstance(a) ? a : null;
    }
}

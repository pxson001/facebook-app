package com.facebook.interstitial.manager;

import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: TOPIC_FEED */
public class EmptyInterstitialControllersHolder extends InterstitialControllersHolder {
    public static EmptyInterstitialControllersHolder m23237a(InjectorLike injectorLike) {
        return new EmptyInterstitialControllersHolder();
    }

    public final Collection<String> m23239a() {
        return Collections.emptyList();
    }

    public final Collection<String> m23240a(Action action) {
        return Collections.emptyList();
    }

    public final Collection<String> m23241b() {
        return Collections.emptyList();
    }

    @Nullable
    public final InterstitialController m23238a(String str) {
        return null;
    }
}

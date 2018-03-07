package com.facebook.groups.fb4a.docsandfiles.intent;

import android.content.ComponentName;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Trying to open thread settings with a null stored user */
public class Fb4aGroupFilesIntentBuilder {
    private final Provider<ComponentName> f21962a;

    private static Fb4aGroupFilesIntentBuilder m23081b(InjectorLike injectorLike) {
        return new Fb4aGroupFilesIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public Fb4aGroupFilesIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f21962a = provider;
    }
}

package com.facebook.groups.docsandfiles.intent;

import android.content.ComponentName;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unsupported send-message serialization protocol */
public class GroupDocsAndFilesIntentBuilder {
    public final Provider<ComponentName> f21438a;

    public static GroupDocsAndFilesIntentBuilder m22380b(InjectorLike injectorLike) {
        return new GroupDocsAndFilesIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public GroupDocsAndFilesIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f21438a = provider;
    }
}

package com.facebook.saved.contextmenu.interfaces;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.saved.contextmenu.SavedArchiveMenuItem;
import com.facebook.saved.contextmenu.SavedDeleteMenuItem;
import com.facebook.saved.contextmenu.SavedReviewMenuItem;
import com.facebook.saved.contextmenu.SavedShareMenuItem;
import com.facebook.saved.contextmenu.SavedUnarchiveMenuItem;
import com.facebook.saved.contextmenu.SavedViewPostMenuItem;
import com.facebook.saved.launcher.SavedReviewComposerLauncherWithResult;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class STATICDI_MULTIBIND_PROVIDER$SavedContextMenuItem implements MultiBindIndexedProvider<SavedContextMenuItem>, Provider<Set<SavedContextMenuItem>> {
    private final InjectorLike f8998a;

    public STATICDI_MULTIBIND_PROVIDER$SavedContextMenuItem(InjectorLike injectorLike) {
        this.f8998a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8998a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return SavedArchiveMenuItem.m8953a((InjectorLike) injector);
            case 1:
                return SavedDeleteMenuItem.m8968a((InjectorLike) injector);
            case 2:
                return new SavedReviewMenuItem(ResourcesMethodAutoProvider.a(injector), SavedReviewComposerLauncherWithResult.m9220b(injector));
            case 3:
                return new SavedShareMenuItem(ResourcesMethodAutoProvider.a(injector), (ComposerLauncher) ComposerLauncherImpl.a(injector), ComposerConfigurationFactory.b(injector));
            case 4:
                return SavedUnarchiveMenuItem.m8993a((InjectorLike) injector);
            case 5:
                return new SavedViewPostMenuItem(ResourcesMethodAutoProvider.a(injector), ViewPermalinkIntentFactory.a(injector), (SecureContextHelper) DefaultSecureContextHelper.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

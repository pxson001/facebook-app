package com.facebook.saved.contextmenu;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.analytics.CurationMechanism;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.saved.contextmenu.interfaces.SavedContextMenuItem;
import com.facebook.saved.contextmenu.interfaces.SharableItemWrapper;
import com.facebook.saved.intent.RequestCode;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: is_self_profile */
public class SavedShareMenuItem implements SavedContextMenuItem<SharableItemWrapper> {
    private final Resources f8983a;
    private final ComposerLauncher f8984b;
    private final ComposerConfigurationFactory f8985c;

    public final boolean mo411a(Object obj, Fragment fragment) {
        this.f8984b.a(null, ComposerConfigurationFactory.c(ComposerSourceType.SAVED_DASHBOARD, Builder.a(((SharableItemWrapper) obj).mo432i()).b()).setIsFireAndForget(true).a(), RequestCode.SHARE_ITEM.ordinal(), fragment);
        return true;
    }

    public final boolean mo413b(Object obj) {
        return ((SharableItemWrapper) obj).mo432i() != null;
    }

    @Inject
    public SavedShareMenuItem(Resources resources, ComposerLauncher composerLauncher, ComposerConfigurationFactory composerConfigurationFactory) {
        this.f8983a = resources;
        this.f8984b = composerLauncher;
        this.f8985c = composerConfigurationFactory;
    }

    public final Class<SharableItemWrapper> mo409a() {
        return SharableItemWrapper.class;
    }

    public final String mo412b() {
        return this.f8983a.getString(2131238180);
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.SHARE_BUTTON;
    }

    public final String mo410a(Object obj) {
        return null;
    }

    public final int mo415d() {
        return 2130843246;
    }
}

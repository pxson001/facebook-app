package com.facebook.pages.identity.intent.uri;

import android.content.Intent;
import com.facebook.attachments.angora.actionbutton.SavedOfflineSnackbarActionControllerProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.TriState;
import com.facebook.offlinemode.intentchecker.OfflineIntentChecker;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_reaction_initial_fetch_tag */
public class PagesOfflineIntentChecker implements OfflineIntentChecker {
    private final Provider<TriState> f4145a;
    private final SavedOfflineSnackbarActionControllerProvider f4146b;

    @Inject
    public PagesOfflineIntentChecker(SavedOfflineSnackbarActionControllerProvider savedOfflineSnackbarActionControllerProvider, Provider<TriState> provider) {
        this.f4146b = savedOfflineSnackbarActionControllerProvider;
        this.f4145a = provider;
    }

    public final boolean m5097a(Intent intent) {
        return intent.getIntExtra("target_fragment", -1) == ContentFragmentType.NATIVE_PAGES_FRAGMENT.ordinal();
    }

    public final boolean m5096a() {
        return true;
    }

    @Nullable
    public final OfflineSnackbarActionController m5098b(Intent intent) {
        if (!((TriState) this.f4145a.get()).asBoolean(false) || intent == null || !intent.hasExtra("com.facebook.katana.profile.id")) {
            return null;
        }
        return this.f4146b.a(null, String.valueOf(Long.valueOf(intent.getLongExtra("com.facebook.katana.profile.id", -1))), null, RegularImmutableList.a, null);
    }
}

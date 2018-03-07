package com.facebook.crowdsourcing.suggestedits.data;

import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: collapsable */
public class SuggestEditsHeaderHolderProvider extends AbstractAssistedProvider<SuggestEditsHeaderHolder> {
    public final SuggestEditsHeaderHolder m21515a(Fragment fragment, SuggestEditsController suggestEditsController, View view, SuggestEditsHeaderState suggestEditsHeaderState, String str) {
        return new SuggestEditsHeaderHolder(fragment, suggestEditsController, view, suggestEditsHeaderState, str, SuggestEditsViewControllerManager.m21665a((InjectorLike) this));
    }
}

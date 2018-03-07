package com.facebook.crowdsourcing.suggestedits.data;

import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: com.amazon.mp3.album */
public class SuggestEditsFieldHolderProvider extends AbstractAssistedProvider<SuggestEditsFieldHolder> {
    public final SuggestEditsFieldHolder m21490a(Fragment fragment, SuggestEditsController suggestEditsController, SuggestEditsField suggestEditsField, SuggestEditsInputType suggestEditsInputType, View view, SuggestEditsListViewType suggestEditsListViewType, String str) {
        return new SuggestEditsFieldHolder(SuggestEditsViewControllerManager.m21665a((InjectorLike) this), fragment, suggestEditsController, suggestEditsField, suggestEditsInputType, view, suggestEditsListViewType, str);
    }
}

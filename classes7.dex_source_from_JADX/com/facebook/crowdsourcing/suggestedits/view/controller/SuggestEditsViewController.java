package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestionEditedListener;
import javax.annotation.Nullable;

/* compiled from: claim */
public interface SuggestEditsViewController<ViewType extends View, ModelType> {
    ViewType mo1370a(ViewGroup viewGroup);

    SuggestEditsListViewType mo1371a();

    ModelType mo1372a(ViewType viewType, ModelType modelType, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener);

    void mo1373a(ViewType viewType, ModelType modelType, @Nullable ModelType modelType2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestionEditedListener suggestionEditedListener, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str);
}

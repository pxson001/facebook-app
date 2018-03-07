package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import javax.annotation.Nullable;

/* compiled from: city_placeholder_text */
public class SuggestEditsEmptyHeaderViewController implements SuggestEditsViewController<View, Object> {
    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.NO_SECTION_HEADER;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        View view = new View(viewGroup.getContext());
        view.setVisibility(8);
        return view;
    }

    public final void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        view.setVisibility(8);
    }

    public final Object mo1372a(View view, Object obj, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        return obj;
    }
}

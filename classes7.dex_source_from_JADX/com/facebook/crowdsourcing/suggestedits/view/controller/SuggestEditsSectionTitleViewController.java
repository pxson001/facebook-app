package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import javax.annotation.Nullable;

/* compiled from: checkbox_key */
public class SuggestEditsSectionTitleViewController implements SuggestEditsViewController<TextView, String> {
    public final Object mo1372a(View view, Object obj, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        return (String) obj;
    }

    public final void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        ((TextView) view).setText((String) obj);
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.SECTION_TITLE;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907309, viewGroup, false);
    }
}

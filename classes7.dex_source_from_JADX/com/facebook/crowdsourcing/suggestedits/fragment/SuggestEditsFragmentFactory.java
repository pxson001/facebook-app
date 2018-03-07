package com.facebook.crowdsourcing.suggestedits.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: close_action */
public class SuggestEditsFragmentFactory implements IFragmentFactory {
    public final Fragment m21528a(Intent intent) {
        SuggestEditsFragment suggestEditsFragment = new SuggestEditsFragment();
        suggestEditsFragment.g(intent.getExtras());
        return suggestEditsFragment;
    }
}

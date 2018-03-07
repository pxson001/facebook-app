package com.facebook.uberbar.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.analytics.InteractionLogger;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper;
import javax.inject.Inject;

/* compiled from: nearby_tiles_version */
public class NativeUberbarFragmentDelegate extends NativeUberbarDelegate {
    @Inject
    public NativeUberbarFragmentDelegate(InteractionLogger interactionLogger, FragmentActivity fragmentActivity, UberbarResultsAnalyticHelper uberbarResultsAnalyticHelper) {
        super(interactionLogger, fragmentActivity, uberbarResultsAnalyticHelper, null);
    }

    public final void mo148a(EditText editText, ViewGroup viewGroup, TextWatcher textWatcher) {
        this.f5087d = editText;
        this.e = viewGroup;
        m6373a(textWatcher);
        this.c = true;
    }
}

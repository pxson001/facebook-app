package com.facebook.groups.widget.preferenceview;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: preview/ */
public class GeneralPreferenceView extends CustomFrameLayout {
    public FbTextView f6060a = ((FbTextView) c(2131562504));

    public GeneralPreferenceView(Context context) {
        super(context);
        Class cls = GeneralPreferenceView.class;
        FbInjector.get(getContext());
        setContentView(2130904579);
        setBackgroundDrawable(getResources().getDrawable(2130840707));
    }

    public final void m7851a(String str) {
        this.f6060a.setText(str);
    }
}

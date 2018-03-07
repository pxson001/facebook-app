package com.facebook.groups.fb4a.react;

import android.view.View;
import com.facebook.groups.gysc.ReactGYSCRowView;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/* compiled from: payments_add_card_save_button_click */
public class ReactGYSCViewManager extends SimpleViewManager<ReactGYSCRowView> {
    public final String m7208a() {
        return "RCTGYSCView";
    }

    protected final View m7207a(ThemedReactContext themedReactContext) {
        return new ReactGYSCRowView(themedReactContext);
    }
}

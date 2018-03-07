package com.facebook.widget.prefs;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: com.facebook.work */
public class CheckBoxOrSwitchPreference extends SwitchCompatPreference {

    /* compiled from: com.facebook.work */
    public enum TogglePreferenceType {
        CHECKBOX,
        SWITCH_COMPAT
    }

    public CheckBoxOrSwitchPreference(Context context) {
        super(context);
    }

    public void setWidgetLayoutResource(int i) {
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(2130772841, typedValue, true)) {
            z = false;
        } else if (typedValue.data != TogglePreferenceType.SWITCH_COMPAT.ordinal()) {
            z = false;
        }
        if (z) {
            super.setWidgetLayoutResource(i);
        }
    }
}

package com.facebook.debug.uitools;

import android.content.Context;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: picker_screen_fragment_tag */
public class FigAdoptionPreference extends CheckBoxOrSwitchPreference {
    public FigAdoptionPreference(Context context) {
        super(context);
        a(UIToolsPrefs.f6595c);
        setDefaultValue(Boolean.valueOf(false));
        setTitle("FIG Adoption");
        setSummary("Highlight parts of the app that uses FIG components");
    }
}

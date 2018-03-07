package com.facebook.http.prefs;

import android.content.Context;
import com.facebook.widget.prefs.EditTextPreferenceWithSummaryValue;

/* compiled from: viewer_count */
public class HttpPreferencesFactory {
    public static EditTextPreferenceWithSummaryValue m512c(Context context) {
        EditTextPreferenceWithSummaryValue editTextPreferenceWithSummaryValue = new EditTextPreferenceWithSummaryValue(context);
        editTextPreferenceWithSummaryValue.a(InternalHttpPrefKeys.l);
        editTextPreferenceWithSummaryValue.setTitle(2131241483);
        editTextPreferenceWithSummaryValue.b = context.getString(2131241484);
        EditTextPreferenceWithSummaryValue.b(editTextPreferenceWithSummaryValue);
        editTextPreferenceWithSummaryValue.setDialogTitle(2131241485);
        editTextPreferenceWithSummaryValue.getEditText().setHint(2131241486);
        editTextPreferenceWithSummaryValue.getEditText().setSingleLine(true);
        editTextPreferenceWithSummaryValue.getEditText().setInputType(1);
        return editTextPreferenceWithSummaryValue;
    }
}

package com.facebook.reportaproblem.base;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: shortcutAlertText */
public class ReportAProblemKeyboardHelper {
    public static void m7036a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

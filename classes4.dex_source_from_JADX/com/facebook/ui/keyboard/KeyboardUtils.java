package com.facebook.ui.keyboard;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: trim_to_min_time */
public class KeyboardUtils {
    public static void m1055a(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            m1056a(activity, activity.getWindow().getDecorView());
        }
    }

    public static void m1056a(Context context, View view) {
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static void m1057b(Context context, View view) {
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager == null) {
                return;
            }
            if (null == null) {
                inputMethodManager.showSoftInput(view, 1);
            } else if (configuration.keyboard == 1 || configuration.hardKeyboardHidden != 1) {
                inputMethodManager.showSoftInput(view, 2);
            }
        }
    }
}

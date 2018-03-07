package com.facebook.feed.rows.util;

import android.app.Application;
import android.content.Context;

/* compiled from: groups/photos/{%s} */
public class ContextPrecondition {
    public static void m29275a(Context context) {
        if (context instanceof Application) {
            throw new AssertionError("Context " + context + " is an application context");
        }
    }
}

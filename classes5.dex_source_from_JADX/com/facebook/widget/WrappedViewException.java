package com.facebook.widget;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.view.View;
import com.google.common.base.Throwables;

/* compiled from: com.fasterxml.jackson.core */
public class WrappedViewException extends RuntimeException {
    private WrappedViewException(View view, int i, Throwable th) {
        super(m10567b(view, i, th));
        initCause(th);
    }

    public static void m10565a(View view, int i, Throwable th) {
        Throwables.propagateIfInstanceOf(th, WrappedViewException.class);
        throw new WrappedViewException(view, i, th);
    }

    private static String m10567b(View view, int i, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        Resources resources = view.getResources();
        stringBuilder.append("\nView Hierarchy:");
        do {
            String simpleName = view.getClass().getSimpleName();
            stringBuilder.append("\n  Class = ");
            stringBuilder.append(simpleName);
            m10566a(view, stringBuilder, resources);
            if (i > 0) {
                simpleName = resources.getResourceName(i);
                stringBuilder.append(", Layout = ");
                stringBuilder.append(simpleName);
            }
            if (view.getParent() instanceof View) {
                view = (View) view.getParent();
                continue;
            } else {
                view = null;
                continue;
            }
        } while (view != null);
        if (Log.getStackTraceString(th).contains("line #-1 (sorry, not yet implemented)")) {
            stringBuilder.append("\n  TESTING NOTE:  If you receive this error in a test, you might not have a theme set on the activity.  This can be set in the testing manifest or by adding a call to setTheme(R.style.Theme_FBUi) when creating the activity");
        }
        stringBuilder.append("\n  Original Throwable: ");
        stringBuilder.append(Log.getStackTraceString(th));
        return stringBuilder.toString();
    }

    public static void m10566a(View view, StringBuilder stringBuilder, Resources resources) {
        if (view.getId() > 0) {
            stringBuilder.append(", ID = ");
            try {
                stringBuilder.append(resources.getResourceEntryName(view.getId()));
            } catch (NotFoundException e) {
                stringBuilder.append("(unnamed)");
            }
        }
    }
}

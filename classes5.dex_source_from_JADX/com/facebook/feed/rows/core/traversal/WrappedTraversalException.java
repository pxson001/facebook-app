package com.facebook.feed.rows.core.traversal;

import android.util.Log;
import com.facebook.feed.rows.core.parts.WrappedCorePartException;
import com.google.common.base.Throwables;

/* compiled from: WWW_SEARCH_LOCAL_PLACES_TAB */
public class WrappedTraversalException extends RuntimeException {
    public static void m20304a(SinglePartHolder singlePartHolder, Throwable th, String str) {
        Throwables.propagateIfInstanceOf(th, WrappedTraversalException.class);
        throw new WrappedTraversalException(singlePartHolder, th, str);
    }

    private WrappedTraversalException(SinglePartHolder singlePartHolder, Throwable th, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nException thrown while ");
        if (th instanceof WrappedCorePartException) {
            stringBuilder.append(((WrappedCorePartException) th).stage);
        } else {
            stringBuilder.append(str);
        }
        stringBuilder.append(" a part definition");
        if (th instanceof WrappedCorePartException) {
            int i = 0;
            while (i < ((WrappedCorePartException) th).parts.size()) {
                stringBuilder.append(i == 0 ? "\nThrown from " : "\nWith parent ");
                stringBuilder.append((String) ((WrappedCorePartException) th).parts.get(i));
                i++;
            }
            stringBuilder.append("\nWith parent ");
            stringBuilder.append(singlePartHolder.a.getClass().getCanonicalName());
        } else {
            stringBuilder.append("\nThrown from ");
            stringBuilder.append(singlePartHolder.a.getClass().getCanonicalName());
        }
        for (GroupPartHolder groupPartHolder = singlePartHolder.b; groupPartHolder != null; groupPartHolder = groupPartHolder.b) {
            stringBuilder.append("\nWith parent ");
            stringBuilder.append(groupPartHolder.a.getClass().getCanonicalName());
        }
        m20305a(th, stringBuilder);
        super(stringBuilder.toString());
        initCause(th);
    }

    public static void m20305a(Throwable th, StringBuilder stringBuilder) {
        stringBuilder.append("\n  Original Throwable: ");
        if (th instanceof WrappedCorePartException) {
            stringBuilder.append(Log.getStackTraceString(((WrappedCorePartException) th).originalException));
        } else {
            stringBuilder.append(Log.getStackTraceString(th));
        }
    }
}

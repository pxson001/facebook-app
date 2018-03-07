package com.facebook.analytics.util;

import android.content.Context;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.FbInjector;
import com.google.common.base.Preconditions;

/* compiled from: release_previous_result @ onNewResult */
public final class LoggerUtils {
    public static NavigationLogger m12200a(Context context) {
        Preconditions.checkNotNull(context);
        return NavigationLogger.m5475a(FbInjector.get(context));
    }

    public static ConnectionStatusLogger m12201b(Context context) {
        Preconditions.checkNotNull(context);
        return ConnectionStatusLogger.m12202a(FbInjector.get(context));
    }
}

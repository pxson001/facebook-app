package com.facebook.katana.app.module.common;

import com.facebook.common.build.BuildConstants;
import com.facebook.common.process.PrivateProcessName;
import com.facebook.common.process.ProcessName;
import com.google.common.base.Strings;
import java.util.Locale;

/* compiled from: zero_optout */
public enum FbandroidProcessName {
    MAIN,
    DASH,
    DASH_SERVICE,
    BROWSER;

    public static FbandroidProcessName convertProcessNameToProcessEnum(ProcessName processName) {
        if (!processName.a()) {
            return convertProcessNameToProcessEnum(processName.c);
        }
        throw new IllegalStateException("Invalid process name: unknown.");
    }

    public static FbandroidProcessName convertProcessNameToProcessEnum(PrivateProcessName privateProcessName) {
        if (privateProcessName.b()) {
            return MAIN;
        }
        try {
            return valueOf(Strings.nullToEmpty(privateProcessName.a()).toUpperCase(Locale.ENGLISH));
        } catch (Throwable e) {
            throw new IllegalStateException("Unrecognized process name: " + privateProcessName.a(), e);
        }
    }

    public final ProcessName getProcessName() {
        String n;
        if (equals(MAIN)) {
            n = BuildConstants.n();
        } else {
            n = BuildConstants.n() + ":" + name().toLowerCase(Locale.ENGLISH);
        }
        return ProcessName.a(n);
    }
}

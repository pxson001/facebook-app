package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Binder;
import java.util.List;

public class zzny {
    public static String m352a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            String str;
            if (i + 4 >= stackTrace.length) {
                str = "<bottom of call stack>";
            } else {
                StackTraceElement stackTraceElement = stackTrace[i + 4];
                str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
            }
            stringBuffer.append(str).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    public static String m353a(Context context) {
        return m354a(context, Binder.getCallingPid());
    }

    public static String m354a(Context context, int i) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}

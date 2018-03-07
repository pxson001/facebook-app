package com.google.android.gms.internal;

public final class zznz {
    public static String m12895a() {
        int i;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        stringBuilder.append("Async stack trace:");
        for (Object append : stackTrace) {
            stringBuilder.append("\n\tat ").append(append);
        }
        StackTraceElement[] stackTraceElementArr = stackTrace;
        Throwable cause = th.getCause();
        while (cause != null) {
            stringBuilder.append("\nCaused by: ");
            stringBuilder.append(cause);
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            int i3 = 0;
            int length = stackTraceElementArr.length;
            int length2 = stackTrace2.length;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                length--;
                if (length < 0 || !stackTraceElementArr[length].equals(stackTrace2[length2])) {
                    break;
                }
                i3++;
            }
            i2 = i3;
            for (i = 0; i < stackTrace2.length - i2; i++) {
                stringBuilder.append("\n\tat " + stackTrace2[i]);
            }
            if (i2 > 0) {
                stringBuilder.append("\n\t... " + i2 + " more");
            }
            cause = cause.getCause();
            stackTraceElementArr = stackTrace2;
        }
        return stringBuilder.toString();
    }
}

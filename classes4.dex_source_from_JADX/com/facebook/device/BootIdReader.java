package com.facebook.device;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.debug.log.BLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

/* compiled from: handleLogin can only be used with LoggedInUserSessionManager */
public class BootIdReader {
    private static final String f10906a = BootIdReader.class.getSimpleName();

    private BootIdReader() {
    }

    public static UUID m11337a() {
        Throwable th;
        Throwable th2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            try {
                UUID fromString = UUID.fromString(bufferedReader.readLine());
                bufferedReader.close();
                return fromString;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                th3 = th2;
                th2 = th4;
            }
            throw th2;
            if (th3 != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th5) {
                    AndroidCompat.addSuppressed(th3, th5);
                }
            } else {
                bufferedReader.close();
            }
            throw th2;
        } catch (Throwable th22) {
            BLog.b(f10906a, "Error reading boot_id from procfs", th22);
            return null;
        }
    }
}

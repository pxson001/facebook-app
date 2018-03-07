package com.facebook.rtc.helpers;

import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: application/vnd.wap.slc */
public class ThreadUtils {
    public static boolean m19556a(CountDownLatch countDownLatch, long j) {
        boolean z = false;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = null;
        long j2 = j;
        do {
            try {
                z = countDownLatch.await(j2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                obj = 1;
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j2 <= 0) {
                }
            }
        } while (j2 <= 0);
        if (obj != null) {
            Thread.currentThread().interrupt();
        }
        return z;
    }
}

package com.facebook.analytics2.beacon.idgenerator;

import com.facebook.common.iolite.FileLocker;
import com.facebook.debug.log.BLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: t_sm */
public class BeaconIdGenerator {
    private final File f3484a;
    private final File f3485b;
    private final File f3486c;
    private final Random f3487d = new Random();

    public BeaconIdGenerator(File file) {
        this.f3484a = file;
        this.f3485b = new File(file, "beacon_id.lock");
        this.f3486c = new File(file, "beacon_id");
    }

    public final long m5689a() {
        try {
            return m5683b();
        } catch (Throwable e) {
            BLog.a("BeaconIdGenerator", e, "Failed to increment beacon id", new Object[0]);
            return m5688f();
        }
    }

    public static int m5680a(long j) {
        return (int) (j >> 32);
    }

    public static int m5682b(long j) {
        return (int) (-1 & j);
    }

    private synchronized long m5683b() {
        long d;
        m5684c();
        FileLocker a = FileLocker.m5690a(this.f3485b);
        try {
            d = m5686d();
            if (d == 0) {
                d = m5688f();
            } else {
                int i = (int) (d >> 32);
                int i2 = (int) (d & -1);
                if (i == Integer.MAX_VALUE) {
                    d = m5688f();
                } else {
                    d = m5681a(i + 1, i2);
                }
            }
            m5685c(d);
        } finally {
            a.close();
        }
        return d;
    }

    private void m5684c() {
        if (!this.f3485b.exists() && !this.f3486c.exists() && !this.f3484a.exists() && !this.f3484a.mkdirs()) {
            throw new IOException("Cannot create " + this.f3484a);
        }
    }

    private long m5686d() {
        long j = 0;
        if (this.f3486c.exists()) {
            try {
                j = m5687e();
            } catch (Throwable e) {
                BLog.a("BeaconIdGenerator", e, "Failure reading beacon id file %s", new Object[]{this.f3486c});
            }
        }
        return j;
    }

    private long m5687e() {
        long fileInputStream = new FileInputStream(this.f3486c);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(fileInputStream, 16));
        try {
            int readInt = dataInputStream.readInt();
            if (readInt != 1) {
                throw new IOException("expected 1; got " + readInt);
            }
            fileInputStream = dataInputStream.readLong();
            return fileInputStream;
        } finally {
            dataInputStream.close();
        }
    }

    private void m5685c(long j) {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.f3486c), 16));
        try {
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(j);
        } finally {
            dataOutputStream.close();
        }
    }

    private long m5688f() {
        return m5681a(0, this.f3487d.nextInt());
    }

    private static long m5681a(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }
}

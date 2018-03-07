package com.facebook.appupdate;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: UPDATE  */
public class AppUpdatePersistenceHelper {
    @Nullable
    private Long f23793a;
    private final AppUpdatePersistence f23794b;

    public AppUpdatePersistenceHelper(@Nullable Long l, AppUpdatePersistence appUpdatePersistence) {
        this.f23793a = l;
        this.f23794b = appUpdatePersistence;
    }

    public final void m25807a(AppUpdateState appUpdateState) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(appUpdateState);
                objectOutputStream.close();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (this.f23793a == null) {
                    this.f23793a = Long.valueOf(this.f23794b.a(toByteArray));
                } else {
                    this.f23794b.a(this.f23793a.longValue(), toByteArray);
                }
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw th;
        }
    }

    public final void m25806a() {
        if (this.f23793a != null) {
            this.f23794b.a(this.f23793a.longValue());
        }
    }
}

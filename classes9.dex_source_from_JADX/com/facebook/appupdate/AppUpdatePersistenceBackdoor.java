package com.facebook.appupdate;

import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UPDATE %s SET %s = %s */
public class AppUpdatePersistenceBackdoor {
    private final AppUpdatePersistence f23792a;

    public AppUpdatePersistenceBackdoor(AppUpdatePersistence appUpdatePersistence) {
        this.f23792a = appUpdatePersistence;
    }

    public final List<AppUpdateState> m25805a() {
        List<AppUpdateState> arrayList = new ArrayList();
        for (Pair pair : this.f23792a.a()) {
            try {
                arrayList.add(m25804a((byte[]) pair.second));
            } catch (ClassNotFoundException e) {
            } catch (IOException e2) {
            }
        }
        return arrayList;
    }

    private static AppUpdateState m25804a(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                AppUpdateState appUpdateState = (AppUpdateState) objectInputStream.readObject();
                objectInputStream.close();
                return appUpdateState;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }
}

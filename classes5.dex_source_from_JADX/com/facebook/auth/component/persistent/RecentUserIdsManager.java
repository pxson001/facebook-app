package com.facebook.auth.component.persistent;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.iolite.Closeables;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tagged_and_mentioned_users */
public class RecentUserIdsManager {
    private final Context f2255a;

    public static RecentUserIdsManager m3168b(InjectorLike injectorLike) {
        return new RecentUserIdsManager((Context) injectorLike.getInstance(Context.class, ForAppContext.class));
    }

    @Inject
    public RecentUserIdsManager(@ForAppContext Context context) {
        this.f2255a = context;
    }

    @Nullable
    public final synchronized List<String> m3169a(String str, String str2, int i) {
        List<String> list = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str2)) {
                ArrayList a;
                ArrayList arrayList;
                File a2 = m3165a(str);
                try {
                    a = m3166a(a2);
                } catch (Throwable e) {
                    BLog.b(getClass(), "File read failure", e);
                    a = null;
                }
                if (a == null) {
                    arrayList = new ArrayList(1);
                } else {
                    arrayList = a;
                }
                arrayList.remove(str2);
                arrayList.add(0, str2);
                try {
                    m3167a(a2, arrayList, Math.min(arrayList.size(), i));
                } catch (Throwable e2) {
                    BLog.b(getClass(), "File write failure", e2);
                }
                if (arrayList.size() > i) {
                    list = arrayList.subList(i, arrayList.size());
                }
            }
        }
        return list;
    }

    private ArrayList<String> m3166a(File file) {
        Closeable dataInputStream;
        Throwable th;
        ArrayList<String> arrayList = null;
        if (file.exists()) {
            try {
                dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    if ("user_id_state".equals(dataInputStream.readUTF())) {
                        int readInt = dataInputStream.readInt();
                        arrayList = new ArrayList(readInt);
                        for (int i = 0; i < readInt; i++) {
                            arrayList.add(dataInputStream.readUTF());
                        }
                        Closeables.a(dataInputStream, false);
                    } else {
                        BLog.c(getClass(), "Invalid signature: %s", new Object[]{dataInputStream.readUTF()});
                        Closeables.a(dataInputStream, true);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.a(dataInputStream, true);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                dataInputStream = null;
                th = th4;
                Closeables.a(dataInputStream, true);
                throw th;
            }
        }
        return arrayList;
    }

    private static void m3167a(File file, ArrayList<String> arrayList, int i) {
        Throwable th;
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            try {
                dataOutputStream.writeUTF("user_id_state");
                dataOutputStream.writeInt(i);
                for (int i2 = 0; i2 < i; i2++) {
                    dataOutputStream.writeUTF((String) arrayList.get(i2));
                }
                Closeables.a(dataOutputStream, false);
            } catch (Throwable th2) {
                th = th2;
                Closeables.a(dataOutputStream, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            Closeables.a(dataOutputStream, true);
            throw th;
        }
    }

    private File m3165a(String str) {
        return new File(this.f2255a.getDir("config_experiment", 0), str);
    }
}

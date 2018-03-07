package com.facebook.loom.config.coldstart;

import android.content.Context;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.loom.config.Config;
import com.facebook.loom.config.ConfigProvider;
import com.facebook.loom.config.ConfigProvider.ConfigUpdateListener;
import com.facebook.loom.config.DefaultConfigProvider;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/default_optin/secondary_button_action_key */
public class InitFileConfigProvider implements ConfigProvider {
    @Nullable
    private final InitFileConfig f435a;

    public InitFileConfigProvider(Context context) {
        this.f435a = m914b(context);
    }

    @Nullable
    @VisibleForTesting
    private static InitFileConfig m914b(Context context) {
        Throwable th;
        Throwable th2;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(context.getCacheDir(), "LoomInitFileConfig"));
            try {
                byte[] bArr = new byte[256];
                int read = fileInputStream.read(bArr, 0, 256);
                if (read == 0) {
                    fileInputStream.close();
                    return null;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() != 3) {
                    fileInputStream.close();
                    return null;
                }
                long j = wrap.getLong();
                int i = wrap.getInt();
                if (((i * 192) + HTTPTransportCallback.BODY_BYTES_RECEIVED) / 8 != read) {
                    fileInputStream.close();
                    return null;
                }
                InitFileConfigData[] initFileConfigDataArr = new InitFileConfigData[i];
                for (int i2 = 0; i2 < i; i2++) {
                    initFileConfigDataArr[i2] = new InitFileConfigData(wrap.getInt(), wrap.getInt(), wrap.getInt(), wrap.getInt(), wrap.getInt(), wrap.getInt());
                }
                InitFileConfig initFileConfig = new InitFileConfig(j, initFileConfigDataArr);
                fileInputStream.close();
                return initFileConfig;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileInputStream.close();
            }
            throw th;
            throw th;
        } catch (IOException e) {
            return null;
        }
    }

    public static void m912a(Context context, long j, ArrayList<InitFileConfigData> arrayList) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable iOException;
        if (!arrayList.isEmpty()) {
            File file = new File(context.getCacheDir(), "LoomInitFileConfig");
            File createTempFile = File.createTempFile("LoomInitFileConfig", ".tmp", context.getFilesDir());
            fileOutputStream = new FileOutputStream(createTempFile);
            th = null;
            try {
                byte[] bArr = new byte[256];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.putInt(3).putLong(j).putInt(arrayList.size());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    InitFileConfigData initFileConfigData = (InitFileConfigData) arrayList.get(i);
                    wrap.putInt(initFileConfigData.a).putInt(initFileConfigData.b).putInt(initFileConfigData.c).putInt(initFileConfigData.d).putInt(initFileConfigData.e).putInt(initFileConfigData.f);
                }
                fileOutputStream.write(bArr, 0, wrap.position());
                fileOutputStream.close();
                if (!createTempFile.renameTo(file)) {
                    iOException = new IOException("Could not rename config temp file to final location");
                    if (createTempFile.delete()) {
                        throw iOException;
                    }
                    throw new IOException("Could not remove config temp file " + createTempFile.getAbsolutePath(), iOException);
                }
                return;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                th2 = iOException;
                iOException = th3;
            }
        } else {
            return;
        }
        if (th2 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th2, th4);
            }
        } else {
            fileOutputStream.close();
        }
        throw iOException;
        throw iOException;
    }

    public static void m911a(Context context) {
        String str = "";
        File file = new File(context.getFilesDir(), "LoomColdStartConfig");
        File file2 = new File(context.getCacheDir(), "LoomInitFileConfig");
        if (!m913a(file)) {
            str = str + " " + file.getAbsolutePath();
        }
        if (!m913a(file2)) {
            str = str + " " + file2.getAbsolutePath();
        }
        if (!str.isEmpty()) {
            throw new IOException("Could not delete Loom config file(s):" + str);
        }
    }

    private static boolean m913a(File file) {
        if (!file.exists() || file.delete()) {
            return true;
        }
        file.deleteOnExit();
        return false;
    }

    public final void mo63a(@Nullable ConfigUpdateListener configUpdateListener) {
    }

    public final Config mo64b() {
        if (this.f435a != null) {
            return this.f435a;
        }
        return DefaultConfigProvider.f449a;
    }

    public final int m915a() {
        if (this.f435a == null) {
            return 0;
        }
        int i;
        ColdStartControllerConfig coldStartControllerConfig = (ColdStartControllerConfig) this.f435a.b.a(8);
        if (coldStartControllerConfig != null) {
            i = coldStartControllerConfig.f485c;
        } else {
            i = 0;
        }
        return i;
    }
}

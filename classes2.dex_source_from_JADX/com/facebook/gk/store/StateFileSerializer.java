package com.facebook.gk.store;

import com.facebook.common.iolite.Closeables;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.AtomicFileHelper.FileSerializer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: videohome/ */
class StateFileSerializer implements FileSerializer<StateFileContent> {
    @Nullable
    public final Object mo330a(File file) {
        Throwable th;
        boolean z;
        boolean z2 = true;
        Closeable dataInputStream;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                if ("GK_STATE".equals(dataInputStream.readUTF())) {
                    int readInt = dataInputStream.readInt();
                    if (readInt != 1) {
                        BLog.c("StateFileSerializer", "Cannot read gatekeepers state, invalid version: %s", new Object[]{Integer.valueOf(readInt)});
                        Closeables.m2789a(dataInputStream, true);
                        return null;
                    }
                    String readUTF = dataInputStream.readUTF();
                    int readInt2 = dataInputStream.readInt();
                    byte[] bArr = new byte[readInt2];
                    dataInputStream.readFully(bArr);
                    Integer.valueOf(readInt);
                    Integer.valueOf(readInt2);
                    try {
                        StateFileContent stateFileContent = new StateFileContent(readUTF, bArr);
                        Closeables.m2789a(dataInputStream, false);
                        return stateFileContent;
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                        if (z) {
                            z2 = false;
                        }
                        Closeables.m2789a(dataInputStream, z2);
                        throw th;
                    }
                }
                BLog.c("StateFileSerializer", "Cannot read gatekeepers state, invalid signature: %s", new Object[]{dataInputStream.readUTF()});
                Closeables.m2789a(dataInputStream, true);
                return null;
            } catch (Throwable th3) {
                th = th3;
                z = false;
                if (z) {
                    z2 = false;
                }
                Closeables.m2789a(dataInputStream, z2);
                throw th;
            }
        } catch (Throwable th4) {
            z = false;
            th = th4;
            dataInputStream = null;
            if (z) {
                z2 = false;
            }
            Closeables.m2789a(dataInputStream, z2);
            throw th;
        }
    }

    public final void mo331a(File file, Object obj) {
        StateFileContent stateFileContent = (StateFileContent) obj;
        Closeable dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1024));
        try {
            dataOutputStream.writeUTF("GK_STATE");
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF(stateFileContent.f1449a);
            dataOutputStream.writeInt(stateFileContent.f1450b.length);
            dataOutputStream.write(stateFileContent.f1450b);
        } finally {
            Closeables.m2789a(dataOutputStream, true);
        }
    }

    StateFileSerializer() {
    }
}

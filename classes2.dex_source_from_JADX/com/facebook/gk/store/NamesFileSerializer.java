package com.facebook.gk.store;

import com.facebook.common.iolite.Closeables;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.AtomicFileHelper.FileSerializer;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: videohome */
class NamesFileSerializer implements FileSerializer<NamesFileContent> {
    @Nullable
    public final Object mo330a(File file) {
        Throwable th;
        boolean z;
        boolean z2 = true;
        Closeable dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            if ("GK_NAMES".equals(dataInputStream.readUTF())) {
                if (dataInputStream.readInt() != 1) {
                    BLog.c("NamesFileSerializer", "Cannot read gatekeepers, invalid version: %s", new Object[]{Integer.valueOf(dataInputStream.readInt())});
                    Closeables.m2789a(dataInputStream, true);
                    return null;
                }
                String readUTF = dataInputStream.readUTF();
                int readInt = dataInputStream.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    arrayList.add(dataInputStream.readUTF());
                }
                try {
                    NamesFileContent namesFileContent = new NamesFileContent(readUTF, arrayList);
                    Closeables.m2789a(dataInputStream, false);
                    return namesFileContent;
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
            BLog.b("NamesFileSerializer", "Cannot read gatekeepers, invalid signature: %s", new Object[]{dataInputStream.readUTF()});
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
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo331a(java.io.File r7, java.lang.Object r8) {
        /*
        r6 = this;
        r8 = (com.facebook.gk.store.NamesFileContent) r8;
        r5 = 1;
        r2 = 0;
        r3 = new java.io.DataOutputStream;
        r0 = new java.io.BufferedOutputStream;
        r1 = new java.io.FileOutputStream;
        r1.<init>(r7);
        r0.<init>(r1);
        r3.<init>(r0);
        r0 = "GK_NAMES";
        r3.writeUTF(r0);	 Catch:{ all -> 0x0040 }
        r0 = 1;
        r3.writeInt(r0);	 Catch:{ all -> 0x0040 }
        r0 = r8.a;	 Catch:{ all -> 0x0040 }
        r3.writeUTF(r0);	 Catch:{ all -> 0x0040 }
        r0 = r8.b;	 Catch:{ all -> 0x0040 }
        r4 = r0.size();	 Catch:{ all -> 0x0040 }
        r3.writeInt(r4);	 Catch:{ all -> 0x0040 }
        r1 = r2;
    L_0x002b:
        if (r1 >= r4) goto L_0x003c;
    L_0x002d:
        r0 = r8.b;	 Catch:{ all -> 0x0040 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0040 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0040 }
        r3.writeUTF(r0);	 Catch:{ all -> 0x0040 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x002b;
    L_0x003c:
        com.facebook.common.iolite.Closeables.m2789a(r3, r2);
        return;
    L_0x0040:
        r0 = move-exception;
        com.facebook.common.iolite.Closeables.m2789a(r3, r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gk.store.NamesFileSerializer.a(java.io.File, java.lang.Object):void");
    }

    NamesFileSerializer() {
    }
}

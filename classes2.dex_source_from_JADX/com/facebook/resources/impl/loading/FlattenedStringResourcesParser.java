package com.facebook.resources.impl.loading;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.resources.impl.model.FbstrLanguagePack;
import com.facebook.resources.impl.model.PluralsCollection;
import com.facebook.resources.impl.model.PluralsCollection.GenderedPluralEntry;
import com.facebook.resources.impl.model.PluralsCollection.PluralEntry;
import com.facebook.resources.impl.model.StringArraysCollection;
import com.facebook.resources.impl.model.StringArraysCollection.GenderedStringArrayEntry;
import com.facebook.resources.impl.model.StringArraysCollection.StringArrayEntry;
import com.facebook.resources.impl.model.StringResources;
import com.facebook.resources.impl.model.StringResourcesUtil;
import com.facebook.resources.impl.model.StringsCollection;
import com.facebook.resources.impl.model.StringsCollection.StringEntry;
import com.google.common.base.Throwables;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import javax.inject.Singleton;

@Singleton
/* compiled from: this while onDestroyEntered == false */
public class FlattenedStringResourcesParser {
    private static volatile FlattenedStringResourcesParser f3050a;

    public static com.facebook.resources.impl.loading.FlattenedStringResourcesParser m5045a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3050a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.FlattenedStringResourcesParser.class;
        monitor-enter(r1);
        r0 = f3050a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m5044a();	 Catch:{ all -> 0x0034 }
        f3050a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f3050a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.FlattenedStringResourcesParser.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.FlattenedStringResourcesParser");
    }

    private static FlattenedStringResourcesParser m5044a() {
        return new FlattenedStringResourcesParser();
    }

    public final StringResources m5050a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 65536));
        try {
            int readInt = dataInputStream.readInt();
            if (readInt == 2) {
                return new StringResources(new FbstrLanguagePack(m5046a(dataInputStream), m5048b(dataInputStream), m5049c(dataInputStream)));
            }
            throw new UnsupportedStringFileFormatException(readInt);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    private static StringsCollection m5046a(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        if (readInt == 0) {
            return StringsCollection.f3083a;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        int readInt2 = dataInputStream.readInt();
        int i = 0;
        int i2 = 0;
        while (i < readInt) {
            int readShort = readInt2 + dataInputStream.readShort();
            byte readByte = dataInputStream.readByte();
            SparseIntArray sparseIntArray = new SparseIntArray(readByte);
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                byte readByte2 = dataInputStream.readByte();
                short readShort2 = dataInputStream.readShort();
                sparseIntArray.append(readByte2, readShort2);
                i3 += readShort2;
            }
            sparseArray.append(readShort, new StringEntry(i2, sparseIntArray));
            i++;
            i2 = i3 + i2;
            readInt2 = readShort;
        }
        byte[] bArr = new byte[i2];
        StringResourcesUtil.m5073a((InputStream) dataInputStream, bArr, "string");
        return new StringsCollection(sparseArray, bArr);
    }

    private PluralsCollection m5048b(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        if (readInt == 0) {
            return PluralsCollection.f3090a;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        int i = 0;
        int readInt2 = dataInputStream.readInt();
        int i2 = 0;
        while (i < readInt) {
            int readShort = dataInputStream.readShort() + readInt2;
            byte readByte = dataInputStream.readByte();
            SparseArray sparseArray2 = new SparseArray(readByte);
            readInt2 = i2;
            for (byte b = (byte) 0; b < readByte; b++) {
                readInt2 += m5043a(dataInputStream, sparseArray2, dataInputStream.readByte(), readInt2);
            }
            sparseArray.append(readShort, new GenderedPluralEntry(sparseArray2));
            i++;
            i2 = readInt2;
            readInt2 = readShort;
        }
        byte[] bArr = new byte[i2];
        StringResourcesUtil.m5073a((InputStream) dataInputStream, bArr, "plural");
        return new PluralsCollection(sparseArray, bArr);
    }

    private static int m5043a(DataInputStream dataInputStream, SparseArray<PluralEntry> sparseArray, int i, int i2) {
        byte b = (byte) 0;
        byte readByte = dataInputStream.readByte();
        int[] iArr = new int[readByte];
        int[] iArr2 = new int[readByte];
        int i3 = 0;
        while (b < readByte) {
            iArr[b] = dataInputStream.readByte();
            iArr2[b] = dataInputStream.readShort();
            i3 += iArr2[b];
            b++;
        }
        sparseArray.append(i, new PluralEntry(i2, iArr, iArr2));
        return i3;
    }

    private StringArraysCollection m5049c(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        if (readInt == 0) {
            return StringArraysCollection.f3096a;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        int i = 0;
        int readInt2 = dataInputStream.readInt();
        int i2 = 0;
        while (i < readInt) {
            int readShort = dataInputStream.readShort() + readInt2;
            byte readByte = dataInputStream.readByte();
            SparseArray sparseArray2 = new SparseArray(readByte);
            readInt2 = i2;
            for (byte b = (byte) 0; b < readByte; b++) {
                readInt2 += m5047b(dataInputStream, sparseArray2, dataInputStream.readByte(), readInt2);
            }
            sparseArray.append(readShort, new GenderedStringArrayEntry(sparseArray2));
            i++;
            i2 = readInt2;
            readInt2 = readShort;
        }
        byte[] bArr = new byte[i2];
        StringResourcesUtil.m5073a((InputStream) dataInputStream, bArr, "string-array");
        return new StringArraysCollection(sparseArray, bArr);
    }

    private static int m5047b(DataInputStream dataInputStream, SparseArray<StringArrayEntry> sparseArray, int i, int i2) {
        byte b = (byte) 0;
        byte readByte = dataInputStream.readByte();
        int[] iArr = new int[readByte];
        int i3 = 0;
        while (b < readByte) {
            iArr[b] = dataInputStream.readShort();
            i3 += iArr[b];
            b++;
        }
        sparseArray.append(i, new StringArrayEntry(i2, iArr));
        return i3;
    }
}

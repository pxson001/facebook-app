package com.facebook.saved2.ui.itemadapters;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.facebook.inject.InjectorLike;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.video.downloadmanager.DownloadManager;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inconceivable exception */
public class Saved2DownloadItemsHelper {
    private static volatile Saved2DownloadItemsHelper f9622d;
    public DownloadManager f9623a;
    public int f9624b;
    public Cursor f9625c;

    /* compiled from: inconceivable exception */
    class ReorderedCursor extends CursorWrapper {
        private Cursor f9620a;
        private ArrayList<Integer> f9621b;

        public ReorderedCursor(Cursor cursor, ArrayList<Integer> arrayList) {
            super(cursor);
            this.f9620a = cursor;
            this.f9621b = arrayList;
        }

        public boolean moveToPosition(int i) {
            return this.f9620a.moveToPosition(((Integer) this.f9621b.get(i)).intValue());
        }

        public int getPosition() {
            return this.f9621b.indexOf(Integer.valueOf(this.f9620a.getPosition()));
        }
    }

    public static com.facebook.saved2.ui.itemadapters.Saved2DownloadItemsHelper m9869a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f9622d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved2.ui.itemadapters.Saved2DownloadItemsHelper.class;
        monitor-enter(r1);
        r0 = f9622d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9870b(r0);	 Catch:{ all -> 0x0035 }
        f9622d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9622d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved2.ui.itemadapters.Saved2DownloadItemsHelper.a(com.facebook.inject.InjectorLike):com.facebook.saved2.ui.itemadapters.Saved2DownloadItemsHelper");
    }

    private static Saved2DownloadItemsHelper m9870b(InjectorLike injectorLike) {
        return new Saved2DownloadItemsHelper(DownloadManager.a(injectorLike));
    }

    @Inject
    public Saved2DownloadItemsHelper(DownloadManager downloadManager) {
        this.f9623a = downloadManager;
    }

    public final Cursor m9871a(Cursor cursor, BaseQueryDAO baseQueryDAO) {
        if (baseQueryDAO == null || !cursor.moveToFirst()) {
            return cursor;
        }
        if (cursor instanceof ReorderedCursor) {
            cursor = ((ReorderedCursor) cursor).getWrappedCursor();
        }
        ArrayList arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (int i = 0; i < cursor.getCount(); i++) {
            boolean z;
            if (baseQueryDAO.w() == null || !baseQueryDAO.t()) {
                z = false;
            } else {
                z = this.f9623a.e(baseQueryDAO.w());
            }
            if (z) {
                arrayList.add(Integer.valueOf(i));
            } else {
                arrayList2.add(Integer.valueOf(i));
            }
            cursor.moveToNext();
        }
        this.f9624b = arrayList.size();
        if (this.f9624b == 0) {
            this.f9625c = cursor;
            return cursor;
        }
        arrayList.addAll(arrayList2);
        this.f9625c = new ReorderedCursor(cursor, arrayList);
        return this.f9625c;
    }
}

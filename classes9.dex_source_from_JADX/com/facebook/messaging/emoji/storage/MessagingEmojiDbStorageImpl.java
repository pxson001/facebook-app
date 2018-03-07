package com.facebook.messaging.emoji.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.emoji.storage.MessagingEmojiDbSchemaPart.RecentEmojiTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mUaProfTagName */
public class MessagingEmojiDbStorageImpl {
    private static volatile MessagingEmojiDbStorageImpl f11013c;
    private final EmojiDbSerialization f11014a;
    private final MessagingEmojiDatabaseSupplier f11015b;

    public static com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl m11426a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11013c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl.class;
        monitor-enter(r1);
        r0 = f11013c;	 Catch:{ all -> 0x003a }
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
        r0 = m11427b(r0);	 Catch:{ all -> 0x0035 }
        f11013c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11013c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl.a(com.facebook.inject.InjectorLike):com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl");
    }

    private static MessagingEmojiDbStorageImpl m11427b(InjectorLike injectorLike) {
        return new MessagingEmojiDbStorageImpl(EmojiDbSerialization.m11417a(injectorLike), MessagingEmojiDatabaseSupplier.m11424a(injectorLike));
    }

    @Inject
    public MessagingEmojiDbStorageImpl(EmojiDbSerialization emojiDbSerialization, MessagingEmojiDatabaseSupplier messagingEmojiDatabaseSupplier) {
        this.f11014a = emojiDbSerialization;
        this.f11015b = messagingEmojiDatabaseSupplier;
    }

    public final ImmutableList<Emoji> m11428a() {
        SQLiteDatabase a = this.f11015b.a();
        SQLiteDetour.a(a, 133984579);
        Cursor query = a.query("recent_emoji", null, null, null, null, null, null);
        ImmutableList<Emoji> of = ImmutableList.of();
        try {
            if (query.moveToFirst()) {
                of = this.f11014a.m11420a(query.getString(Columns.f11011a.a(query)));
                a.setTransactionSuccessful();
            }
            query.close();
            SQLiteDetour.b(a, -1460904503);
            return of;
        } catch (Throwable th) {
            query.close();
            SQLiteDetour.b(a, 1514967615);
        }
    }

    public final void m11429a(List<Emoji> list) {
        String a = EmojiDbSerialization.m11418a(ImmutableList.copyOf(list));
        SQLiteDatabase a2 = this.f11015b.a();
        SQLiteDetour.a(a2, -878919232);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f11011a.a(), a);
            if (a2.update("recent_emoji", contentValues, null, new String[0]) == 0) {
                SQLiteDetour.a(-1563033028);
                a2.insertOrThrow("recent_emoji", null, contentValues);
                SQLiteDetour.a(1170751581);
            }
            a2.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a2, -1918430507);
        }
    }
}

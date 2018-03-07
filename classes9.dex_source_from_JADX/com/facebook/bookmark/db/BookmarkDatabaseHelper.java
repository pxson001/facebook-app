package com.facebook.bookmark.db;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkGroupOrderTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkSyncStatusTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkSyncStatusTable.Columns;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: register_payload */
public class BookmarkDatabaseHelper {
    private static volatile BookmarkDatabaseHelper f5635b;
    public final ContentResolver f5636a;

    public static com.facebook.bookmark.db.BookmarkDatabaseHelper m5834a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5635b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bookmark.db.BookmarkDatabaseHelper.class;
        monitor-enter(r1);
        r0 = f5635b;	 Catch:{ all -> 0x003a }
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
        r0 = m5839b(r0);	 Catch:{ all -> 0x0035 }
        f5635b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5635b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bookmark.db.BookmarkDatabaseHelper.a(com.facebook.inject.InjectorLike):com.facebook.bookmark.db.BookmarkDatabaseHelper");
    }

    private static BookmarkDatabaseHelper m5839b(InjectorLike injectorLike) {
        return new BookmarkDatabaseHelper(ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public BookmarkDatabaseHelper(ContentResolver contentResolver) {
        this.f5636a = (ContentResolver) Preconditions.checkNotNull(contentResolver);
    }

    public final long m5841a() {
        Throwable th;
        Cursor cursor;
        try {
            Cursor query = this.f5636a.query(BookmarkContract$BookmarkSyncStatusTable.f5653a, new String[]{Columns.f5652b.a()}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        long j = query.getLong(0);
                        if (query == null) {
                            return j;
                        }
                        query.close();
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean m5838a(long j) {
        Throwable th;
        Cursor query;
        try {
            query = this.f5636a.query(BookmarkContract$BookmarksTable.f5666a, null, BookmarkContract$BookmarksTable.Columns.f5655b.a() + "=?", new String[]{String.valueOf(j)}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final boolean m5844a(long j, int i) {
        if (!m5838a(j)) {
            return false;
        }
        ArrayList a = Lists.a();
        a.add(ContentProviderOperation.newUpdate(BookmarkContract$BookmarksTable.f5667b).withValue(BookmarkContract$BookmarksTable.Columns.f5660g.d, Integer.valueOf(i)).withSelection(BookmarkContract$BookmarksTable.Columns.f5655b.a() + "=?", new String[]{String.valueOf(j)}).build());
        a.add(ContentProviderOperation.newUpdate(BookmarkContract$BookmarkSyncStatusTable.f5653a).withValue(Columns.f5652b.a(), Long.valueOf(System.currentTimeMillis() / 1000)).withExpectedCount(1).build());
        if (this.f5636a.applyBatch(BookmarkContract.a, a)[0].count.intValue() > 0) {
            return true;
        }
        return false;
    }

    public final void m5843a(List<BookmarksGroup> list, long j) {
        ArrayList a = Lists.a();
        a.add(ContentProviderOperation.newDelete(BookmarkContract$BookmarksTable.f5666a).build());
        a.add(ContentProviderOperation.newDelete(BookmarkContract$BookmarkGroupOrderTable.f5650a).build());
        a.add(ContentProviderOperation.newUpdate(BookmarkContract$BookmarkSyncStatusTable.f5653a).withValue(Columns.f5651a.d, Long.valueOf(j)).withValue(Columns.f5652b.d, Integer.valueOf(0)).build());
        int i = 0;
        for (BookmarksGroup bookmarksGroup : list) {
            int i2 = i + 1;
            a.add(ContentProviderOperation.newInsert(BookmarkContract$BookmarkGroupOrderTable.f5650a).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5645a.d, bookmarksGroup.id).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5647c.d, Integer.valueOf(i)).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5646b.d, bookmarksGroup.name).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5648d.d, Integer.valueOf(bookmarksGroup.m5873a())).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5649e.d, Integer.valueOf(bookmarksGroup.m5877b())).build());
            m5837a(a, bookmarksGroup);
            i = i2;
        }
        this.f5636a.applyBatch(BookmarkContract.a, a);
    }

    public final long m5845b() {
        Throwable th;
        Cursor query;
        try {
            query = this.f5636a.query(BookmarkContract$BookmarkSyncStatusTable.f5653a, new String[]{Columns.f5651a.a()}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        long j = query.getLong(0);
                        if (query != null) {
                            query.close();
                        }
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            throw new SQLException("Can not query " + BookmarkContract$BookmarkSyncStatusTable.f5653a);
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final Collection<Bookmark> m5842a(String str) {
        Cursor query;
        Throwable th;
        ConjunctionExpression a = SqlExpression.a(new Expression[]{SqlExpression.a(BookmarkContract$BookmarksTable.Columns.f5663j.a(), str), SqlExpression.a(BookmarkContract$BookmarksTable.Columns.f5665l.a(), "0")});
        try {
            query = this.f5636a.query(BookmarkContract$BookmarksTable.f5666a, null, a.a(), a.b(), BookmarkContract$BookmarksTable.Columns.f5664k.a());
            if (query == null) {
                try {
                    throw new SQLException("Can not query " + BookmarkContract$BookmarksTable.f5666a);
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            Builder builder = ImmutableList.builder();
            while (query.moveToNext()) {
                builder.c(m5835a(query));
            }
            ImmutableList b = builder.b();
            if (query != null) {
                query.close();
            }
            return b;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List<BookmarksGroup> m5846c() {
        return m5836a(m5840d());
    }

    private List<BookmarksGroup> m5836a(Multimap<String, Bookmark> multimap) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor2 = this.f5636a.query(BookmarkContract$BookmarkGroupOrderTable.f5650a, null, null, null, null);
            if (cursor2 == null) {
                try {
                    throw new SQLException("Can not query " + BookmarkContract$BookmarkGroupOrderTable.f5650a);
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            final Map c = Maps.c();
            List<BookmarksGroup> a = Lists.a();
            int a2 = BookmarkContract$BookmarkGroupOrderTable.Columns.f5645a.a(cursor2);
            int a3 = BookmarkContract$BookmarkGroupOrderTable.Columns.f5647c.a(cursor2);
            int a4 = BookmarkContract$BookmarkGroupOrderTable.Columns.f5646b.a(cursor2);
            int a5 = BookmarkContract$BookmarkGroupOrderTable.Columns.f5648d.a(cursor2);
            int a6 = BookmarkContract$BookmarkGroupOrderTable.Columns.f5649e.a(cursor2);
            while (cursor2.moveToNext()) {
                String string = cursor2.getString(a2);
                Integer valueOf = Integer.valueOf(cursor2.getInt(a3));
                String string2 = cursor2.getString(a4);
                int i = cursor2.getInt(a5);
                c.put(string, valueOf);
                a.add(new BookmarksGroup(cursor2.getString(a2), string2, cursor2.getInt(a6), i, (List) multimap.c(string)));
            }
            Collections.sort(a, new Comparator<BookmarksGroup>(this) {
                final /* synthetic */ BookmarkDatabaseHelper f5634b;

                public int compare(Object obj, Object obj2) {
                    BookmarksGroup bookmarksGroup = (BookmarksGroup) obj;
                    BookmarksGroup bookmarksGroup2 = (BookmarksGroup) obj2;
                    Integer num = (Integer) c.get(bookmarksGroup.id);
                    Integer num2 = (Integer) c.get(bookmarksGroup2.id);
                    if (num != null && num2 != null) {
                        return num.compareTo(num2);
                    }
                    throw new SQLException("Can not find the order information of group " + bookmarksGroup.id + " or " + bookmarksGroup2.id);
                }
            });
            if (cursor2 != null) {
                cursor2.close();
            }
            return a;
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private Multimap<String, Bookmark> m5840d() {
        Throwable th;
        Expression a = SqlExpression.a(BookmarkContract$BookmarksTable.Columns.f5665l.a(), "1");
        Cursor query;
        try {
            query = this.f5636a.query(BookmarkContract$BookmarksTable.f5666a, null, a.a(), a.b(), BookmarkContract$BookmarksTable.Columns.f5664k.a());
            if (query == null) {
                try {
                    throw new SQLException("Can not query " + BookmarkContract$BookmarksTable.f5666a);
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            int a2 = BookmarkContract$BookmarksTable.Columns.f5663j.a(query);
            ArrayListMultimap t = ArrayListMultimap.t();
            while (query.moveToNext()) {
                t.a(query.getString(a2), m5835a(query));
            }
            if (query != null) {
                query.close();
            }
            return t;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static Bookmark m5835a(Cursor cursor) {
        int a = BookmarkContract$BookmarksTable.Columns.f5655b.a(cursor);
        int a2 = BookmarkContract$BookmarksTable.Columns.f5656c.a(cursor);
        int a3 = BookmarkContract$BookmarksTable.Columns.f5657d.a(cursor);
        int a4 = BookmarkContract$BookmarksTable.Columns.f5658e.a(cursor);
        int a5 = BookmarkContract$BookmarksTable.Columns.f5659f.a(cursor);
        int a6 = BookmarkContract$BookmarksTable.Columns.f5662i.a(cursor);
        return new Bookmark(cursor.getLong(a), cursor.getString(a2), cursor.getString(a3), cursor.getInt(BookmarkContract$BookmarksTable.Columns.f5660g.a(cursor)), cursor.getString(BookmarkContract$BookmarksTable.Columns.f5661h.a(cursor)), cursor.getString(a4), cursor.getString(a5), cursor.getString(a6));
    }

    private static void m5837a(ArrayList<ContentProviderOperation> arrayList, BookmarksGroup bookmarksGroup) {
        int b = bookmarksGroup.m5877b();
        int i = 0;
        for (Bookmark bookmark : bookmarksGroup.m5882d()) {
            boolean z;
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(BookmarkContract$BookmarksTable.f5666a);
            if (i < b) {
                z = true;
            } else {
                z = false;
            }
            int i2 = i + 1;
            arrayList.add(newInsert.withValues(m5833a(bookmark, bookmarksGroup, z, i)).build());
            i = i2;
        }
    }

    public static ContentValues m5833a(Bookmark bookmark, BookmarksGroup bookmarksGroup, boolean z, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5655b.d, Long.valueOf(bookmark.id));
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5656c.d, bookmark.name);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5658e.d, bookmark.pic);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5659f.d, bookmark.type);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5657d.d, bookmark.url);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5662i.d, bookmark.clientToken);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5660g.d, Integer.valueOf(bookmark.m5863b()));
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5661h.d, bookmark.m5864c());
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5663j.d, bookmarksGroup.id);
        contentValues.put(BookmarkContract$BookmarksTable.Columns.f5664k.d, Integer.valueOf(i));
        String str = BookmarkContract$BookmarksTable.Columns.f5665l.d;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        return contentValues;
    }
}

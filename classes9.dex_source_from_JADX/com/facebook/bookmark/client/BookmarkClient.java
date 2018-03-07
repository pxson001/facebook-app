package com.facebook.bookmark.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.BookmarkManager.BookmarkCallback;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable.Columns;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: releaseGl start */
public class BookmarkClient extends BroadcastReceiver implements BookmarkManager {
    public static final Class<BookmarkClient> f5615a = BookmarkClient.class;
    private static volatile BookmarkClient f5616q;
    private final Context f5617b;
    private final DefaultBlueServiceOperationFactory f5618c;
    private final ListeningExecutorService f5619d;
    private final ExecutorService f5620e;
    public final BookmarkDatabaseHelper f5621f;
    private List<BookmarksGroup> f5622g = Lists.a();
    private Map<Long, Bookmark> f5623h = Maps.c();
    public final Set<Long> f5624i = new HashSet();
    public long f5625j = -1;
    public int f5626k = 0;
    @GuardedBy("BookmarkClient.this")
    public ListenableFuture f5627l;
    @GuardedBy("BookmarkClient.this")
    public ListenableFuture f5628m;
    @GuardedBy("BookmarkClient.this")
    public final Map<String, ListenableFuture> f5629n = Maps.c();
    public final Handler f5630o;
    private final Set<BookmarkCallback> f5631p;

    /* compiled from: releaseGl start */
    class C05942 implements FutureCallback<OperationResult> {
        final /* synthetic */ BookmarkClient f5605a;

        C05942(BookmarkClient bookmarkClient) {
            this.f5605a = bookmarkClient;
        }

        public void onSuccess(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            this.f5605a.f5627l = null;
            FetchBookmarksResult fetchBookmarksResult = (FetchBookmarksResult) operationResult.k();
            this.f5605a.f5626k = operationResult.d.getInt("bookmarks_expire_time", -1);
            if (this.f5605a.f5626k < 0) {
                BLog.b(BookmarkClient.f5615a, "The expire time is not set or not correct!");
            }
            if (fetchBookmarksResult.freshness != DataFreshnessResult.FROM_SERVER) {
                BookmarkClient.m5811a(this.f5605a, fetchBookmarksResult);
                this.f5605a.f5625j = fetchBookmarksResult.clientTimeMs;
            }
        }

        public void onFailure(Throwable th) {
            this.f5605a.f5627l = null;
            BookmarkClient.m5812a(this.f5605a, th, "syncWithDb");
        }
    }

    /* compiled from: releaseGl start */
    class C05975 implements FutureCallback<OperationResult> {
        final /* synthetic */ BookmarkClient f5610a;

        C05975(BookmarkClient bookmarkClient) {
            this.f5610a = bookmarkClient;
        }

        public void onFailure(Throwable th) {
            this.f5610a.f5628m = null;
            BookmarkClient.m5812a(this.f5610a, th, "syncWithServer");
        }

        public void onSuccess(Object obj) {
            this.f5610a.f5628m = null;
        }
    }

    /* compiled from: releaseGl start */
    class C05986 implements FutureCallback<OperationResult> {
        final /* synthetic */ BookmarkClient f5611a;

        C05986(BookmarkClient bookmarkClient) {
            this.f5611a = bookmarkClient;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            BookmarkClient.m5812a(this.f5611a, th, "updateBookmarkUnreadCount");
        }
    }

    public static com.facebook.bookmark.client.BookmarkClient m5806a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5616q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bookmark.client.BookmarkClient.class;
        monitor-enter(r1);
        r0 = f5616q;	 Catch:{ all -> 0x003a }
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
        r0 = m5813b(r0);	 Catch:{ all -> 0x0035 }
        f5616q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5616q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bookmark.client.BookmarkClient.a(com.facebook.inject.InjectorLike):com.facebook.bookmark.client.BookmarkClient");
    }

    private static BookmarkClient m5813b(InjectorLike injectorLike) {
        return new BookmarkClient((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), BookmarkDatabaseHelper.m5834a(injectorLike));
    }

    @Inject
    public BookmarkClient(Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ListeningExecutorService listeningExecutorService, ExecutorService executorService, BookmarkDatabaseHelper bookmarkDatabaseHelper) {
        this.f5617b = context;
        this.f5618c = defaultBlueServiceOperationFactory;
        this.f5619d = listeningExecutorService;
        this.f5620e = executorService;
        this.f5621f = bookmarkDatabaseHelper;
        this.f5631p = Sets.a();
        this.f5630o = new Handler(this.f5617b.getMainLooper());
        IntentFilter intentFilter = new IntentFilter(BookmarkContract.c);
        try {
            intentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.bookmark");
            intentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.favorites");
            intentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count");
            LocalBroadcastManager.a(this.f5617b).a(this, intentFilter);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void m5810a(FetchBookmarksResult fetchBookmarksResult, boolean z) {
        ImmutableList j = m5817j(this);
        int size = j.size();
        for (int i = 0; i < size; i++) {
            ((BookmarkCallback) j.get(i)).mo211a(fetchBookmarksResult, z);
        }
    }

    public final synchronized List<BookmarksGroup> mo218b() {
        return Lists.a(this.f5622g);
    }

    public final FetchBookmarksResult mo222e() {
        return new FetchBookmarksResult(mo221d(), this.f5625j, ImmutableList.copyOf(this.f5622g));
    }

    public final synchronized ListenableFuture<OperationResult> mo220c() {
        ListenableFuture<OperationResult> listenableFuture;
        if (this.f5627l != null) {
            listenableFuture = this.f5627l;
        } else {
            listenableFuture = BlueServiceOperationFactoryDetour.a(this.f5618c, "syncWithDB", new Bundle(), -1751639998).c();
            this.f5627l = listenableFuture;
            Futures.a(listenableFuture, new C05942(this), this.f5620e);
        }
        return listenableFuture;
    }

    public final synchronized ListenableFuture<Collection<Bookmark>> mo214a(final String str) {
        ListenableFuture<Collection<Bookmark>> listenableFuture;
        if (this.f5629n.containsKey(str)) {
            listenableFuture = (ListenableFuture) this.f5629n.get(str);
        } else {
            listenableFuture = this.f5619d.a(new Callable<Collection<Bookmark>>(this) {
                final /* synthetic */ BookmarkClient f5607b;

                public Object call() {
                    return this.f5607b.f5621f.m5842a(str);
                }
            });
            Futures.a(listenableFuture, new FutureCallback<Collection<Bookmark>>(this) {
                final /* synthetic */ BookmarkClient f5609b;

                public void onFailure(Throwable th) {
                    this.f5609b.f5629n.remove(str);
                    BookmarkClient.m5812a(this.f5609b, th, "loadHiddenBookmarksFromDB");
                }

                public void onSuccess(Object obj) {
                    this.f5609b.f5629n.remove(str);
                }
            }, this.f5619d);
            this.f5629n.put(str, listenableFuture);
        }
        return listenableFuture;
    }

    public static void m5812a(BookmarkClient bookmarkClient, Throwable th, String str) {
        if (th instanceof ServiceException) {
            final ServiceException serviceException = (ServiceException) th;
            Bundle bundle = serviceException.result.d;
            if (bundle != null) {
                BLog.b(f5615a, str + " Failed , " + bundle.get("originalExceptionMessage") + ", " + bundle.get("originalExceptionStack"));
            } else {
                BLog.b(f5615a, th, "%s %s", new Object[]{str, "Failed"});
            }
            HandlerDetour.a(bookmarkClient.f5630o, new Runnable(bookmarkClient) {
                final /* synthetic */ BookmarkClient f5604b;

                public void run() {
                    ImmutableList j = BookmarkClient.m5817j(this.f5604b);
                    int size = j.size();
                    for (int i = 0; i < size; i++) {
                        j.get(i);
                    }
                }
            }, -1672667377);
            return;
        }
        BLog.a(f5615a, th, "%s %s", new Object[]{str, " Failed for other reasons."});
    }

    public final synchronized DataFreshnessResult mo221d() {
        DataFreshnessResult dataFreshnessResult;
        if (this.f5622g.isEmpty()) {
            dataFreshnessResult = DataFreshnessResult.NO_DATA;
        } else if (this.f5625j == -1 || this.f5625j + ((long) this.f5626k) < System.currentTimeMillis()) {
            dataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
        } else {
            dataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        }
        return dataFreshnessResult;
    }

    public final synchronized void mo215a() {
        if (this.f5628m == null) {
            OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f5618c, "syncWithServer", new Bundle(), 1189846717).c();
            this.f5628m = c;
            Futures.a(c, new C05975(this), this.f5620e);
        }
    }

    public final void mo216a(long j, int i) {
        Bundle bundle = new Bundle();
        bundle.putLong(Columns.f5655b.d, j);
        bundle.putInt(Columns.f5660g.d, i);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f5618c, "updateUnreadCount", bundle, 1791214514).c(), new C05986(this), this.f5620e);
    }

    @Nullable
    public final ListenableFuture<OperationResult> m5819a(final Bookmark bookmark) {
        BookmarksGroup a = m5807a(true);
        if (a == null) {
            BLog.b(f5615a, "No favorite group in BookmarkClient");
            return null;
        } else if (a.m5878b(bookmark.id)) {
            BLog.b(f5615a, "Shouldn't see add to favorites when group is already in favorites");
            return null;
        } else {
            a.m5875a(bookmark);
            this.f5624i.add(Long.valueOf(bookmark.id));
            ListenableFuture a2 = m5808a(a, false);
            final ListenableFuture<OperationResult> f = SettableFuture.f();
            Futures.a(a2, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ BookmarkClient f5614c;

                public void onSuccess(@Nullable Object obj) {
                    FutureDetour.a(f, (OperationResult) obj, -232213180);
                }

                public void onFailure(Throwable th) {
                    BookmarkClient bookmarkClient = this.f5614c;
                    bookmarkClient.f5624i.remove(Long.valueOf(bookmark.id));
                    BookmarkClient.m5812a(bookmarkClient, th, "handleAddToFavoritesFailure");
                    f.a(th);
                }
            });
            return f;
        }
    }

    @Nullable
    public final ListenableFuture<OperationResult> m5818a(final long j) {
        BookmarksGroup a = m5807a(true);
        if (a == null) {
            BLog.b(f5615a, "No favorite group in BookmarkClient");
            return null;
        } else if (a.m5878b(j)) {
            a.m5874a(j);
            this.f5624i.remove(Long.valueOf(j));
            ListenableFuture a2 = m5808a(a, false);
            final ListenableFuture<OperationResult> f = SettableFuture.f();
            Futures.a(a2, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ BookmarkClient f5602c;

                public void onSuccess(@Nullable Object obj) {
                    FutureDetour.a(f, (OperationResult) obj, -2034788714);
                }

                public void onFailure(Throwable th) {
                    BookmarkClient bookmarkClient = this.f5602c;
                    bookmarkClient.f5624i.add(Long.valueOf(j));
                    BookmarkClient.m5812a(bookmarkClient, th, "handleRemoveFromFavoritesFailure");
                    f.a(th);
                }
            });
            return f;
        } else {
            BLog.b(f5615a, "Shouldn't see add to favorites when group is already in favorites");
            return null;
        }
    }

    public final boolean m5826b(long j) {
        if (!this.f5624i.isEmpty()) {
            return this.f5624i.contains(Long.valueOf(j));
        }
        m5816i();
        return this.f5624i.contains(Long.valueOf(j));
    }

    public final boolean m5831g() {
        if (!this.f5624i.isEmpty()) {
            return true;
        }
        m5816i();
        if (this.f5624i.isEmpty()) {
            return false;
        }
        return true;
    }

    public synchronized void clearUserData() {
        this.f5622g.clear();
        this.f5623h.clear();
        this.f5624i.clear();
        this.f5626k = 0;
        this.f5625j = -1;
    }

    public final synchronized void mo217a(BookmarkCallback bookmarkCallback) {
        this.f5631p.add(Preconditions.checkNotNull(bookmarkCallback));
    }

    public final synchronized void mo219b(BookmarkCallback bookmarkCallback) {
        this.f5631p.remove(bookmarkCallback);
    }

    public synchronized void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -605405712);
        String type = intent.getType();
        if ("vnd.android.cursor.item/vnd.facebook.katana.bookmark".equals(type)) {
            m5815c(intent);
        } else if ("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count".equals(type)) {
            m5814b(intent);
        } else if ("vnd.android.cursor.item/vnd.facebook.katana.favorites".equals(type)) {
            m5809a(intent);
        } else {
            BLog.b(f5615a, "unexpected broadcast type: " + type);
        }
        LogUtils.a(intent, -391151789, a);
    }

    private void m5816i() {
        BookmarksGroup a = m5807a(false);
        if (a != null) {
            for (Bookmark bookmark : a.m5882d()) {
                this.f5624i.add(Long.valueOf(bookmark.id));
            }
        }
    }

    private void m5809a(Intent intent) {
        BookmarksGroup bookmarksGroup = (BookmarksGroup) intent.getParcelableExtra("bookmark_new_favorites");
        if (bookmarksGroup == null) {
            BLog.b(f5615a, "Invalid favorites bookmarks broadcast!");
            return;
        }
        for (int i = 0; i < this.f5622g.size(); i++) {
            if (Objects.equal(((BookmarksGroup) this.f5622g.get(i)).id, bookmarksGroup.id)) {
                this.f5622g.set(i, bookmarksGroup);
                break;
            }
        }
        ImmutableList j = m5817j(this);
        int size = j.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((BookmarkCallback) j.get(i2)).mo213a(bookmarksGroup);
        }
    }

    private void m5814b(Intent intent) {
        long longExtra = intent.getLongExtra("bookmark_fbid", 0);
        int intExtra = intent.getIntExtra("bookmark_unread_count", -1);
        if (longExtra == 0 || intExtra == -1) {
            BLog.b(f5615a, "Bookmark unread count update broadcast has invalid data.");
            return;
        }
        Bookmark bookmark = (Bookmark) this.f5623h.get(Long.valueOf(longExtra));
        if (bookmark == null) {
            BLog.b(f5615a, "Bookmark unread count update broadcast has invalid bookmark fbid: " + longExtra);
        } else if (bookmark.m5863b() != intExtra) {
            bookmark.m5860a(intExtra);
            ImmutableList j = m5817j(this);
            int size = j.size();
            for (int i = 0; i < size; i++) {
                ((BookmarkCallback) j.get(i)).mo212a(bookmark);
            }
        }
    }

    private void m5815c(Intent intent) {
        FetchBookmarksResult fetchBookmarksResult = (FetchBookmarksResult) intent.getParcelableExtra("bookmark_groups");
        if (fetchBookmarksResult == null) {
            BLog.b(f5615a, "Invalid bookmark content broadcast!");
            return;
        }
        this.f5625j = fetchBookmarksResult.clientTimeMs;
        m5811a(this, fetchBookmarksResult);
    }

    public static void m5811a(BookmarkClient bookmarkClient, FetchBookmarksResult fetchBookmarksResult) {
        if (fetchBookmarksResult.f5597a == null) {
            bookmarkClient.m5810a(new FetchBookmarksResult(fetchBookmarksResult.freshness, fetchBookmarksResult.clientTimeMs, ImmutableList.copyOf(bookmarkClient.f5622g)), false);
        } else if (BookmarksGroup.m5870a(bookmarkClient.f5622g, (List) fetchBookmarksResult.f5597a)) {
            bookmarkClient.m5810a(fetchBookmarksResult, false);
        } else {
            bookmarkClient.f5622g = Lists.a(fetchBookmarksResult.f5597a);
            bookmarkClient.f5623h.clear();
            for (BookmarksGroup bookmarksGroup : bookmarkClient.f5622g) {
                for (Bookmark bookmark : bookmarksGroup.m5883e()) {
                    bookmarkClient.f5623h.put(Long.valueOf(bookmark.id), bookmark);
                }
                for (Bookmark bookmark2 : bookmarksGroup.m5882d()) {
                    bookmarkClient.f5623h.put(Long.valueOf(bookmark2.id), bookmark2);
                }
            }
            bookmarkClient.m5810a(fetchBookmarksResult, true);
        }
    }

    public static synchronized ImmutableList m5817j(BookmarkClient bookmarkClient) {
        ImmutableList copyOf;
        synchronized (bookmarkClient) {
            copyOf = ImmutableList.copyOf(bookmarkClient.f5631p);
        }
        return copyOf;
    }

    @Nullable
    private BookmarksGroup m5807a(boolean z) {
        for (BookmarksGroup bookmarksGroup : this.f5622g) {
            if ("pinned".equals(bookmarksGroup.id)) {
                if (z) {
                    return bookmarksGroup.m5884f();
                }
                return bookmarksGroup;
            }
        }
        BLog.a(f5615a, "The favorite bookmark group was not found in BookmarkManager.");
        return null;
    }

    private ListenableFuture<OperationResult> m5808a(BookmarksGroup bookmarksGroup, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("newFavoriteBookmarksGroup", bookmarksGroup);
        Operation a = BlueServiceOperationFactoryDetour.a(this.f5618c, "setFavoriteBookmarks", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(BookmarkClient.class), -1460324151);
        return z ? a.c() : a.b();
    }

    public final void mo223f() {
        this.f5625j = -1;
    }
}

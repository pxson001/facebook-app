package com.facebook.graphql.connection;

import android.os.Bundle;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager.LoaderCallbacks;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.cursor.database.GraphCursorDatabase.BufferRows;
import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.Assisted;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: word_kerning */
public class ConnectionTailLoaderManager implements LoaderCallbacks {
    public final String f207a;
    private final BatchConfiguration f208b;
    public final Callbacks f209c;
    public RowIterator f210d;
    private final Clock f211e;
    private final GraphQLQueryExecutor f212f;
    public final Executor f213g;
    private final Executor f214h;
    public final GraphCursorDatabase f215i;
    public final DefaultAndroidThreadUtil f216j;
    private final QuickPerformanceLogger f217k;
    public boolean f218l = false;
    public TailFetchLocation f219m = null;
    public final AtomicBoolean f220n = new AtomicBoolean(false);
    private long f221o = 0;
    public long f222p = 0;
    private ConnectionFetcherState f223q = null;
    private final Runnable f224r = new C00282(this);
    private final Runnable f225s = new C00293(this);

    /* compiled from: word_kerning */
    class C00271 implements Runnable {
        final /* synthetic */ ConnectionTailLoaderManager f198a;

        C00271(ConnectionTailLoaderManager connectionTailLoaderManager) {
            this.f198a = connectionTailLoaderManager;
        }

        public void run() {
            this.f198a.f215i.a(this.f198a.f207a, (BufferRows) Preconditions.checkNotNull(this.f198a.f210d), true);
            this.f198a.f210d = null;
            ConnectionTailLoaderManager.m194e(this.f198a);
            this.f198a.f220n.set(false);
            ConnectionTailLoaderManager.m195f(this.f198a);
            this.f198a.m196a();
        }
    }

    /* compiled from: word_kerning */
    class C00282 implements Runnable {
        final /* synthetic */ ConnectionTailLoaderManager f199a;

        C00282(ConnectionTailLoaderManager connectionTailLoaderManager) {
            this.f199a = connectionTailLoaderManager;
        }

        public void run() {
            this.f199a.f216j.a();
            this.f199a.f209c.mo10a(true);
        }
    }

    /* compiled from: word_kerning */
    class C00293 implements Runnable {
        final /* synthetic */ ConnectionTailLoaderManager f200a;

        C00293(ConnectionTailLoaderManager connectionTailLoaderManager) {
            this.f200a = connectionTailLoaderManager;
        }

        public void run() {
            this.f200a.f216j.a();
            this.f200a.f209c.mo10a(false);
        }
    }

    /* compiled from: word_kerning */
    public @interface CachePolicy {
    }

    /* compiled from: word_kerning */
    public interface Callbacks {
        void mo8a(ModelCursor modelCursor);

        void mo9a(Throwable th);

        void mo10a(boolean z);
    }

    /* compiled from: word_kerning */
    public class ConnectionFetcherState {
        final /* synthetic */ ConnectionTailLoaderManager f203a;
        private final boolean f204b;
        private boolean f205c = false;
        private boolean f206d = true;

        public ConnectionFetcherState(ConnectionTailLoaderManager connectionTailLoaderManager, boolean z) {
            this.f203a = connectionTailLoaderManager;
            this.f204b = z;
        }

        public final void m185a() {
            this.f205c = true;
        }

        public final void m186a(RowIterator rowIterator) {
            this.f203a.f216j.b();
            if (!this.f205c) {
                boolean z = this.f204b && this.f206d && rowIterator.mo15e();
                if (rowIterator.mo15e()) {
                    this.f206d = false;
                }
                this.f203a.f222p = this.f203a.f215i.a(this.f203a.f207a, rowIterator, z).getLong("CHANGE_NUMBER");
                Long.valueOf(this.f203a.f222p);
                this.f203a.f218l = true;
                ConnectionTailLoaderManager.m194e(this.f203a);
            }
        }

        public final void m187a(final Throwable th) {
            this.f203a.f216j.b();
            if (!this.f205c) {
                BLog.b(ConnectionTailLoaderManager.class, th, "Error loading rows from network", new Object[0]);
                ExecutorDetour.a(this.f203a.f213g, new Runnable(this) {
                    final /* synthetic */ ConnectionFetcherState f202b;

                    public void run() {
                        this.f202b.f203a.f216j.a();
                        this.f202b.f203a.f209c.mo9a(th);
                    }
                }, -419781001);
            }
        }

        public final void m188b() {
            this.f203a.f216j.b();
            if (!this.f205c) {
                this.f203a.f220n.set(false);
                ConnectionTailLoaderManager.m195f(this.f203a);
            }
        }
    }

    /* compiled from: word_kerning */
    @interface DataFreshness {
    }

    /* compiled from: word_kerning */
    public interface RowIterator extends BufferRows {
        TailFetchLocation mo14d();

        boolean mo15e();
    }

    @Inject
    public ConnectionTailLoaderManager(@Assisted String str, @Assisted BatchConfiguration batchConfiguration, @Assisted Callbacks callbacks, @Nullable @Assisted RowIterator rowIterator, Clock clock, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, Executor executor2, GraphCursorDatabase graphCursorDatabase, DefaultAndroidThreadUtil defaultAndroidThreadUtil, QuickPerformanceLogger quickPerformanceLogger) {
        this.f207a = (String) Preconditions.checkNotNull(str);
        this.f208b = (BatchConfiguration) Preconditions.checkNotNull(batchConfiguration);
        this.f209c = (Callbacks) Preconditions.checkNotNull(callbacks);
        this.f210d = rowIterator;
        this.f211e = clock;
        this.f212f = graphQLQueryExecutor;
        this.f213g = executor;
        this.f214h = executor2;
        this.f215i = graphCursorDatabase;
        this.f216j = defaultAndroidThreadUtil;
        this.f217k = quickPerformanceLogger;
    }

    public final void m197a(@Nullable ModelCursor modelCursor) {
        switch (m193b(modelCursor)) {
            case -1:
                return;
            case 1:
                if (this.f208b.mo13b() == 2) {
                    this.f218l = true;
                    break;
                }
                return;
            case 2:
                this.f218l = true;
                break;
        }
        this.f216j.a();
        this.f209c.mo8a(modelCursor);
        m195f(this);
    }

    @DataFreshness
    private int m193b(ModelCursor modelCursor) {
        if (modelCursor == null) {
            return -2;
        }
        Bundle bundle = (Bundle) Preconditions.checkNotNull(modelCursor.getExtras());
        List parcelableArrayList = bundle.getParcelableArrayList("CHUNKS");
        if (!this.f218l) {
            boolean z;
            if (!modelCursor.moveToFirst() || parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                z = false;
            } else {
                if (this.f211e.a() - ((PageInfo) parcelableArrayList.get(0)).h < this.f208b.mo11a() * 1000) {
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z) {
                if (this.f210d == null) {
                    m196a();
                    return z;
                } else if (!this.f220n.compareAndSet(false, true)) {
                    return -1;
                } else {
                    m195f(this);
                    ExecutorDetour.a(this.f214h, new C00271(this), -1357551312);
                    return -1;
                }
            }
        }
        this.f221o = bundle.getLong("CHANGE_NUMBER");
        Long.valueOf(this.f221o);
        m191a(parcelableArrayList);
        return 2;
    }

    private void m191a(List<PageInfo> list) {
        String str = null;
        boolean z = false;
        Preconditions.checkArgument(list != null);
        Integer.valueOf(list.size());
        if (list.isEmpty()) {
            this.f219m = TailFetchLocation.m238a(this.f211e.a());
            return;
        }
        String str2;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            PageInfo pageInfo = (PageInfo) it.next();
            String str3 = pageInfo.b;
            str = pageInfo.d;
            z = pageInfo.f;
            str2 = str;
            str = str3;
        } else {
            str2 = null;
        }
        this.f219m = new TailFetchLocation(str, str2, z);
    }

    public final synchronized void m196a() {
        if (!this.f220n.get() || this.f218l) {
            this.f220n.set(false);
            if (this.f223q != null) {
                this.f223q.m185a();
                this.f223q = null;
            }
            m192a(TailFetchLocation.m238a(this.f211e.a()), true);
        }
    }

    public final synchronized boolean m198b() {
        boolean z = false;
        synchronized (this) {
            if (this.f218l && this.f219m != null && this.f222p <= this.f221o && this.f219m.f262c) {
                z = m192a(this.f219m, false);
            }
        }
        return z;
    }

    public final boolean m199c() {
        return this.f220n.get();
    }

    private boolean m192a(TailFetchLocation tailFetchLocation, boolean z) {
        Preconditions.checkNotNull(tailFetchLocation);
        if (!this.f220n.compareAndSet(false, true)) {
            return false;
        }
        m195f(this);
        if (this.f223q != null) {
            this.f223q.m185a();
            this.f223q = null;
        }
        this.f223q = new ConnectionFetcherState(this, z);
        this.f212f.a(this.f208b.mo12a(this.f217k, this.f223q, DirectExecutor.INSTANCE, tailFetchLocation));
        return true;
    }

    public static void m194e(ConnectionTailLoaderManager connectionTailLoaderManager) {
        LocalModelCursorLoaderManager.a(connectionTailLoaderManager.f207a, Bundle.EMPTY);
    }

    public static void m195f(ConnectionTailLoaderManager connectionTailLoaderManager) {
        if (connectionTailLoaderManager.m199c()) {
            ExecutorDetour.a(connectionTailLoaderManager.f213g, connectionTailLoaderManager.f224r, -1597162499);
        } else {
            ExecutorDetour.a(connectionTailLoaderManager.f213g, connectionTailLoaderManager.f225s, 2089323577);
        }
    }
}

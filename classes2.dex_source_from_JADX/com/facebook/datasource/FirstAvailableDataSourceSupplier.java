package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: graph_search_keyword_type */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> f22008a;

    @ThreadSafe
    /* compiled from: graph_search_keyword_type */
    class FirstAvailableDataSource extends AbstractDataSource<T> {
        final /* synthetic */ FirstAvailableDataSourceSupplier f22045a;
        private int f22046b = 0;
        private DataSource<T> f22047c = null;
        private DataSource<T> f22048d = null;

        /* compiled from: graph_search_keyword_type */
        class InternalDataSubscriber implements DataSubscriber<T> {
            final /* synthetic */ FirstAvailableDataSource f22049a;

            public InternalDataSubscriber(FirstAvailableDataSource firstAvailableDataSource) {
                this.f22049a = firstAvailableDataSource;
            }

            public final void mo2806b(DataSource<T> dataSource) {
                FirstAvailableDataSource.m29823c(this.f22049a, dataSource);
            }

            public final void mo2807c(DataSource<T> dataSource) {
            }

            public final void mo2805a(DataSource<T> dataSource) {
                if (dataSource.mo2785c()) {
                    FirstAvailableDataSource.m29824d(this.f22049a, dataSource);
                } else if (dataSource.mo2784b()) {
                    FirstAvailableDataSource.m29823c(this.f22049a, dataSource);
                }
            }

            public final void mo2802d(DataSource<T> dataSource) {
                this.f22049a.m20884a(Math.max(this.f22049a.mo2787f(), dataSource.mo2787f()));
            }
        }

        public FirstAvailableDataSource(FirstAvailableDataSourceSupplier firstAvailableDataSourceSupplier) {
            this.f22045a = firstAvailableDataSourceSupplier;
            if (!m29826h()) {
                m20886a(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Nullable
        public final synchronized T mo2781d() {
            DataSource j;
            j = m29828j();
            return j != null ? j.mo2781d() : null;
        }

        public final synchronized boolean mo2785c() {
            boolean z;
            DataSource j = m29828j();
            z = j != null && j.mo2785c();
            return z;
        }

        public final boolean mo2782g() {
            synchronized (this) {
                if (super.mo2782g()) {
                    DataSource dataSource = this.f22047c;
                    this.f22047c = null;
                    DataSource dataSource2 = this.f22048d;
                    this.f22048d = null;
                    m29825e(dataSource2);
                    m29825e(dataSource);
                    return true;
                }
                return false;
            }
        }

        private boolean m29826h() {
            Supplier i = m29827i();
            DataSource dataSource = i != null ? (DataSource) i.mo2058a() : null;
            if (!m29821a(dataSource) || dataSource == null) {
                m29825e(dataSource);
                return false;
            }
            dataSource.mo2783a(new InternalDataSubscriber(this), CallerThreadExecutor.f14746a);
            return true;
        }

        @Nullable
        private synchronized Supplier<DataSource<T>> m29827i() {
            Supplier<DataSource<T>> supplier;
            if (m20883a() || this.f22046b >= this.f22045a.f22008a.size()) {
                supplier = null;
            } else {
                List list = this.f22045a.f22008a;
                int i = this.f22046b;
                this.f22046b = i + 1;
                supplier = (Supplier) list.get(i);
            }
            return supplier;
        }

        private synchronized boolean m29821a(DataSource<T> dataSource) {
            boolean z;
            if (m20883a()) {
                z = false;
            } else {
                this.f22047c = dataSource;
                z = true;
            }
            return z;
        }

        private synchronized boolean m29822b(DataSource<T> dataSource) {
            boolean z;
            if (m20883a() || dataSource != this.f22047c) {
                z = false;
            } else {
                this.f22047c = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized DataSource<T> m29828j() {
            return this.f22048d;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m29820a(com.facebook.datasource.DataSource<T> r3, boolean r4) {
            /*
            r2 = this;
            r0 = 0;
            monitor-enter(r2);
            r1 = r2.f22047c;	 Catch:{ all -> 0x001b }
            if (r3 != r1) goto L_0x000a;
        L_0x0006:
            r1 = r2.f22048d;	 Catch:{ all -> 0x001b }
            if (r3 != r1) goto L_0x000c;
        L_0x000a:
            monitor-exit(r2);	 Catch:{ all -> 0x001b }
        L_0x000b:
            return;
        L_0x000c:
            r1 = r2.f22048d;	 Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0012;
        L_0x0010:
            if (r4 == 0) goto L_0x0016;
        L_0x0012:
            r0 = r2.f22048d;	 Catch:{ all -> 0x001b }
            r2.f22048d = r3;	 Catch:{ all -> 0x001b }
        L_0x0016:
            monitor-exit(r2);	 Catch:{ all -> 0x001b }
            m29825e(r0);
            goto L_0x000b;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.a(com.facebook.datasource.DataSource, boolean):void");
        }

        public static void m29823c(FirstAvailableDataSource firstAvailableDataSource, DataSource dataSource) {
            if (firstAvailableDataSource.m29822b(dataSource)) {
                if (dataSource != firstAvailableDataSource.m29828j()) {
                    m29825e(dataSource);
                }
                if (!firstAvailableDataSource.m29826h()) {
                    firstAvailableDataSource.m20886a(dataSource.mo2786e());
                }
            }
        }

        public static void m29824d(FirstAvailableDataSource firstAvailableDataSource, DataSource dataSource) {
            firstAvailableDataSource.m29820a(dataSource, dataSource.mo2784b());
            if (dataSource == firstAvailableDataSource.m29828j()) {
                firstAvailableDataSource.m20885a(null, dataSource.mo2784b());
            }
        }

        private static void m29825e(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.mo2782g();
            }
        }
    }

    public final /* synthetic */ Object mo2058a() {
        return m29788b();
    }

    private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Preconditions.a(!list.isEmpty(), "List of suppliers is empty!");
        this.f22008a = list;
    }

    public static <T> FirstAvailableDataSourceSupplier<T> m29786a(List<Supplier<DataSource<T>>> list) {
        return new FirstAvailableDataSourceSupplier(list);
    }

    public final DataSource<T> m29788b() {
        return new FirstAvailableDataSource(this);
    }

    public int hashCode() {
        return this.f22008a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return false;
        }
        return Objects.m20538a(this.f22008a, ((FirstAvailableDataSourceSupplier) obj).f22008a);
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20544a("list", this.f22008a).toString();
    }
}

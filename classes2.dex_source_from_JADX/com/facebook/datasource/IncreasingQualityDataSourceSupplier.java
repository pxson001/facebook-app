package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: graph_search_feed_type */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> f22009a;

    @ThreadSafe
    /* compiled from: graph_search_feed_type */
    class IncreasingQualityDataSource extends AbstractDataSource<T> {
        final /* synthetic */ IncreasingQualityDataSourceSupplier f22042a;
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<DataSource<T>> f22043b;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int f22044c;

        /* compiled from: graph_search_feed_type */
        class InternalDataSubscriber implements DataSubscriber<T> {
            final /* synthetic */ IncreasingQualityDataSource f22050a;
            private int f22051b;

            public InternalDataSubscriber(IncreasingQualityDataSource increasingQualityDataSource, int i) {
                this.f22050a = increasingQualityDataSource;
                this.f22051b = i;
            }

            public final void mo2805a(DataSource<T> dataSource) {
                if (dataSource.mo2785c()) {
                    IncreasingQualityDataSource.m29812a(this.f22050a, this.f22051b, (DataSource) dataSource);
                } else if (dataSource.mo2784b()) {
                    IncreasingQualityDataSource.m29814b(this.f22050a, this.f22051b, dataSource);
                }
            }

            public final void mo2806b(DataSource<T> dataSource) {
                IncreasingQualityDataSource.m29814b(this.f22050a, this.f22051b, dataSource);
            }

            public final void mo2807c(DataSource<T> dataSource) {
            }

            public final void mo2802d(DataSource<T> dataSource) {
                if (this.f22051b == 0) {
                    this.f22050a.m20884a(dataSource.mo2787f());
                }
            }
        }

        public IncreasingQualityDataSource(IncreasingQualityDataSourceSupplier increasingQualityDataSourceSupplier) {
            this.f22042a = increasingQualityDataSourceSupplier;
            int size = increasingQualityDataSourceSupplier.f22009a.size();
            this.f22044c = size;
            this.f22043b = new ArrayList(size);
            int i = 0;
            while (i < size) {
                DataSource dataSource = (DataSource) ((Supplier) increasingQualityDataSourceSupplier.f22009a.get(i)).mo2058a();
                this.f22043b.add(dataSource);
                dataSource.mo2783a(new InternalDataSubscriber(this, i), CallerThreadExecutor.f14746a);
                if (!dataSource.mo2785c()) {
                    i++;
                } else {
                    return;
                }
            }
        }

        @Nullable
        private synchronized DataSource<T> m29809a(int i) {
            DataSource<T> dataSource;
            dataSource = (this.f22043b == null || i >= this.f22043b.size()) ? null : (DataSource) this.f22043b.get(i);
            return dataSource;
        }

        @Nullable
        private synchronized DataSource<T> m29813b(int i) {
            DataSource<T> dataSource = null;
            synchronized (this) {
                if (this.f22043b != null && i < this.f22043b.size()) {
                    dataSource = (DataSource) this.f22043b.set(i, null);
                }
            }
            return dataSource;
        }

        @Nullable
        private synchronized DataSource<T> m29816h() {
            return m29809a(this.f22044c);
        }

        @Nullable
        public final synchronized T mo2781d() {
            DataSource h;
            h = m29816h();
            return h != null ? h.mo2781d() : null;
        }

        public final synchronized boolean mo2785c() {
            boolean z;
            DataSource h = m29816h();
            z = h != null && h.mo2785c();
            return z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean mo2782g() {
            /*
            r3 = this;
            r0 = 0;
            monitor-enter(r3);
            r1 = super.mo2782g();	 Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x000a;
        L_0x0008:
            monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        L_0x0009:
            return r0;
        L_0x000a:
            r2 = r3.f22043b;	 Catch:{ all -> 0x0026 }
            r1 = 0;
            r3.f22043b = r1;	 Catch:{ all -> 0x0026 }
            monitor-exit(r3);	 Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0029;
        L_0x0012:
            r1 = r0;
        L_0x0013:
            r0 = r2.size();
            if (r1 >= r0) goto L_0x0029;
        L_0x0019:
            r0 = r2.get(r1);
            r0 = (com.facebook.datasource.DataSource) r0;
            m29811a(r0);
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0013;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
        L_0x0029:
            r0 = 1;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.g():boolean");
        }

        public static void m29812a(IncreasingQualityDataSource increasingQualityDataSource, int i, DataSource dataSource) {
            increasingQualityDataSource.m29810a(i, dataSource, dataSource.mo2784b());
            if (dataSource == increasingQualityDataSource.m29816h()) {
                boolean z = i == 0 && dataSource.mo2784b();
                increasingQualityDataSource.m20885a(null, z);
            }
        }

        public static void m29814b(IncreasingQualityDataSource increasingQualityDataSource, int i, DataSource dataSource) {
            m29811a(increasingQualityDataSource.m29815c(i, dataSource));
            if (i == 0) {
                increasingQualityDataSource.m20886a(dataSource.mo2786e());
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m29810a(int r4, com.facebook.datasource.DataSource<T> r5, boolean r6) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f22044c;	 Catch:{ all -> 0x002c }
            r1 = r3.f22044c;	 Catch:{ all -> 0x002c }
            r2 = r3.m29809a(r4);	 Catch:{ all -> 0x002c }
            if (r5 != r2) goto L_0x000f;
        L_0x000b:
            r2 = r3.f22044c;	 Catch:{ all -> 0x002c }
            if (r4 != r2) goto L_0x0011;
        L_0x000f:
            monitor-exit(r3);	 Catch:{ all -> 0x002c }
        L_0x0010:
            return;
        L_0x0011:
            r2 = r3.m29816h();	 Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x001d;
        L_0x0017:
            if (r6 == 0) goto L_0x002f;
        L_0x0019:
            r2 = r3.f22044c;	 Catch:{ all -> 0x002c }
            if (r4 >= r2) goto L_0x002f;
        L_0x001d:
            r3.f22044c = r4;	 Catch:{ all -> 0x002c }
        L_0x001f:
            monitor-exit(r3);	 Catch:{ all -> 0x002c }
        L_0x0020:
            if (r0 <= r4) goto L_0x0010;
        L_0x0022:
            r1 = r3.m29813b(r0);
            m29811a(r1);
            r0 = r0 + -1;
            goto L_0x0020;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
        L_0x002f:
            r4 = r1;
            goto L_0x001f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.a(int, com.facebook.datasource.DataSource, boolean):void");
        }

        @Nullable
        private synchronized DataSource<T> m29815c(int i, DataSource<T> dataSource) {
            if (dataSource == m29816h()) {
                dataSource = null;
            } else if (dataSource == m29809a(i)) {
                dataSource = m29813b(i);
            }
            return dataSource;
        }

        private static void m29811a(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.mo2782g();
            }
        }
    }

    public final /* synthetic */ Object mo2058a() {
        return m29791b();
    }

    private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Preconditions.a(!list.isEmpty(), "List of suppliers is empty!");
        this.f22009a = list;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> m29789a(List<Supplier<DataSource<T>>> list) {
        return new IncreasingQualityDataSourceSupplier(list);
    }

    public final DataSource<T> m29791b() {
        return new IncreasingQualityDataSource(this);
    }

    public int hashCode() {
        return this.f22009a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return Objects.m20538a(this.f22009a, ((IncreasingQualityDataSourceSupplier) obj).f22009a);
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20544a("list", this.f22009a).toString();
    }
}

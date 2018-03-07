package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: TRAIN_STATION */
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    public final DataSource<CloseableReference<T>>[] f13701a;
    @GuardedBy("this")
    private int f13702b = 0;

    /* compiled from: TRAIN_STATION */
    class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        @GuardedBy("InternalDataSubscriber.this")
        boolean f13699a = false;
        final /* synthetic */ ListDataSource f13700b;

        public InternalDataSubscriber(ListDataSource listDataSource) {
            this.f13700b = listDataSource;
        }

        private synchronized boolean m23021a() {
            boolean z = true;
            synchronized (this) {
                if (this.f13699a) {
                    z = false;
                } else {
                    this.f13699a = true;
                }
            }
            return z;
        }

        public final void m23023b(DataSource<CloseableReference<T>> dataSource) {
            this.f13700b.a(dataSource.e());
        }

        public final void m23024c(DataSource<CloseableReference<T>> dataSource) {
            this.f13700b.a(new CancellationException());
        }

        public final void m23022a(DataSource<CloseableReference<T>> dataSource) {
            if (dataSource.b() && m23021a()) {
                ListDataSource.m23027i(this.f13700b);
            }
        }

        public final void m23025d(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource listDataSource = this.f13700b;
            float f = 0.0f;
            for (DataSource f2 : listDataSource.f13701a) {
                f += f2.f();
            }
            listDataSource.a(f / ((float) listDataSource.f13701a.length));
        }
    }

    private ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.f13701a = dataSourceArr;
    }

    public static <T> ListDataSource<T> m23026a(DataSource<CloseableReference<T>>... dataSourceArr) {
        boolean z;
        Preconditions.a(dataSourceArr);
        if (dataSourceArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.b(z);
        ListDataSource<T> listDataSource = new ListDataSource(dataSourceArr);
        for (DataSource dataSource : dataSourceArr) {
            if (dataSource != null) {
                listDataSource.getClass();
                dataSource.a(new InternalDataSubscriber(listDataSource), CallerThreadExecutor.a);
            }
        }
        return listDataSource;
    }

    @Nullable
    public final Object m23030d() {
        Object arrayList;
        synchronized (this) {
            if (c()) {
                arrayList = new ArrayList(this.f13701a.length);
                for (DataSource d : this.f13701a) {
                    arrayList.add(d.d());
                }
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }

    public final synchronized boolean m23029c() {
        boolean z;
        z = !a() && this.f13702b == this.f13701a.length;
        return z;
    }

    public final boolean m23031g() {
        int i = 0;
        if (!super.g()) {
            return false;
        }
        DataSource[] dataSourceArr = this.f13701a;
        int length = dataSourceArr.length;
        while (i < length) {
            dataSourceArr[i].g();
            i++;
        }
        return true;
    }

    public static void m23027i(ListDataSource listDataSource) {
        if (listDataSource.m23028j()) {
            listDataSource.a(null, true);
        }
    }

    private synchronized boolean m23028j() {
        int i;
        i = this.f13702b + 1;
        this.f13702b = i;
        return i == this.f13701a.length;
    }
}

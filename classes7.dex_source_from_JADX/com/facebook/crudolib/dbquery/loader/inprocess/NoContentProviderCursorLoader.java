package com.facebook.crudolib.dbquery.loader.inprocess;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.facebook.crudolib.dbquery.QueryProvider;
import com.facebook.crudolib.dbquery.direct.DirectQueryExecutor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: ccu_upload_fail */
class NoContentProviderCursorLoader extends ExecutorLoader<Cursor> {
    private final DirectQueryExecutor f17862a;
    private final QueryProvider<?> f17863b;
    private Cursor f17864c;
    @Nullable
    private ForceLoadSubcriber f17865d;
    private final AtomicInteger f17866e = new AtomicInteger(0);

    /* compiled from: ccu_upload_fail */
    public class ForceLoadSubcriber {
        public final /* synthetic */ NoContentProviderCursorLoader f17861a;

        public ForceLoadSubcriber(NoContentProviderCursorLoader noContentProviderCursorLoader) {
            this.f17861a = noContentProviderCursorLoader;
        }
    }

    @MainThread
    public final void mo1381a(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @MainThread
    public final /* synthetic */ void m21709b(Object obj) {
        m21705a((Cursor) obj);
    }

    public NoContentProviderCursorLoader(Context context, ExecutorService executorService, DirectQueryExecutor directQueryExecutor, QueryProvider<?> queryProvider) {
        super(context, executorService);
        this.f17862a = directQueryExecutor;
        this.f17863b = queryProvider;
    }

    @WorkerThread
    public final Object mo1382b() {
        this.f17866e.getAndIncrement();
        Cursor b = this.f17862a.m21698b(this.f17863b);
        if (b != null) {
            b.getCount();
        }
        return b;
    }

    @MainThread
    protected final void m21710g() {
        if (this.f17864c != null) {
            m21705a(this.f17864c);
        }
        if (t() || this.f17864c == null) {
            a();
        }
        if (this.f17865d == null) {
            this.f17865d = new ForceLoadSubcriber(this);
            for (Object a : this.f17863b.m21695a()) {
                NoContentResolver.f17873a.m21719a(a, this.f17865d);
            }
        }
    }

    @MainThread
    protected final void m21711h() {
        m21704c();
    }

    @MainThread
    protected final void m21712i() {
        super.i();
        m21711h();
        if (!(this.f17864c == null || this.f17864c.isClosed())) {
            this.f17864c.close();
        }
        this.f17864c = null;
        if (this.f17865d != null) {
            for (Object b : this.f17863b.m21695a()) {
                NoContentResolver.f17873a.m21720b(b, this.f17865d);
            }
            this.f17865d = null;
        }
    }

    public final void m21707a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.println(str + "mQueryProvider=" + this.f17863b.getClass().getName());
        printWriter.println(str + "mCursor=" + this.f17864c);
        printWriter.println(str + "mLoadInvocationCount=" + this.f17866e.get());
    }

    @MainThread
    private void m21705a(Cursor cursor) {
        if (!this.r) {
            Cursor cursor2 = this.f17864c;
            this.f17864c = cursor;
            if (this.p) {
                super.b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }
}

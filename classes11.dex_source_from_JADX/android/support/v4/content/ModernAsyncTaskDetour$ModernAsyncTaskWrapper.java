package android.support.v4.content;

import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: metabox_enabled */
public class ModernAsyncTaskDetour$ModernAsyncTaskWrapper extends ModernAsyncTask {
    private final ModernAsyncTask f5408a;
    private final int f5409b;
    private int f5410c;

    public ModernAsyncTaskDetour$ModernAsyncTaskWrapper(ModernAsyncTask modernAsyncTask, int i, int i2) {
        this.f5408a = modernAsyncTask;
        this.f5409b = i;
        this.f5410c = i2;
    }

    protected final void m6638b() {
        this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_PRE, this.f5409b, this.f5410c);
        try {
            this.f5408a.b();
        } finally {
            this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_END, this.f5409b, this.f5410c);
        }
    }

    protected final Object m6636a(Object[] objArr) {
        this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_BACKGROUND, this.f5409b, this.f5410c);
        try {
            Object a = this.f5408a.a(objArr);
            return a;
        } finally {
            this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_END, this.f5409b, this.f5410c);
        }
    }

    protected final void m6637a(Object obj) {
        this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_POST, this.f5409b, this.f5410c);
        try {
            this.f5408a.a(obj);
        } finally {
            this.f5410c = Logger.a(1, EntryType.ASYNC_TASK_END, this.f5409b, this.f5410c);
        }
    }
}

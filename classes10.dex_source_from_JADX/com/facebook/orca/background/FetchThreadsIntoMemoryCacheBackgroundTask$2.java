package com.facebook.orca.background;

import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.FetchThreadResult;

/* compiled from: pageProps */
class FetchThreadsIntoMemoryCacheBackgroundTask$2 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ int f5250a;
    final /* synthetic */ ThreadKey f5251b;
    final /* synthetic */ FetchThreadsIntoMemoryCacheBackgroundTask f5252c;

    FetchThreadsIntoMemoryCacheBackgroundTask$2(FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask, Class cls, int i, ThreadKey threadKey) {
        this.f5252c = fetchThreadsIntoMemoryCacheBackgroundTask;
        this.f5250a = i;
        this.f5251b = threadKey;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4687a((OperationResult) obj);
    }

    public final void m4687a(OperationResult operationResult) {
        char c = '0';
        super.a(operationResult);
        this.f5252c.q.n(this.f5250a);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) operationResult.k();
        StringBuilder append = new StringBuilder(200).append(this.f5251b);
        if (fetchThreadResult != null) {
            char c2;
            int g = fetchThreadResult.d != null ? fetchThreadResult.d.g() : -1;
            StringBuilder append2 = append.append('-').append(fetchThreadResult.b.l).append('-').append(fetchThreadResult.b.m).append('-').append(fetchThreadResult.b.n).append('-').append(fetchThreadResult.b.o).append('-').append(fetchThreadResult.b.p).append('-').append(fetchThreadResult.b.q).append('-').append(fetchThreadResult.b.r).append('-');
            if (fetchThreadResult.c == null) {
                c2 = '0';
            } else {
                c2 = '1';
            }
            append2.append(c2).append('-').append(g).append('-').append(fetchThreadResult.f).append('-');
            if (!fetchThreadResult.a()) {
                this.f5252c.h.remove(this.f5251b);
                append.append("purged-");
            }
        }
        DataCache dataCache = (DataCache) this.f5252c.b.get();
        StringBuilder append3 = append.append(dataCache.a(this.f5251b) == null ? '0' : '1').append('-');
        if (dataCache.b(this.f5251b) != null) {
            c = '1';
        }
        append3.append(c);
        String stringBuilder = append.toString();
        this.f5252c.k.a(stringBuilder, stringBuilder);
    }

    public void onFailure(Throwable th) {
        super.onFailure(th);
        Object obj = this.f5251b + "-" + this.f5252c.f.a() + "-" + th;
        if (th instanceof ServiceException) {
            OperationResult operationResult = ((ServiceException) th).result;
            if (operationResult != null) {
                obj = obj + "-" + operationResult.g;
            }
        }
        this.f5252c.i.a(obj, obj);
        this.f5252c.q.o(this.f5250a);
    }
}

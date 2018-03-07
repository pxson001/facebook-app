package com.facebook.messaging.database.threads;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.BaseColumns;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.providers.ViewerContextHelperForContentProviders;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: max_transactions */
public class MessagesDbContract {
    private static final Object f10544g = new Object();
    public final String f10545a;
    public final Uri f10546b = Uri.parse("content://" + this.f10545a);
    public final ThreadsTable f10547c = new ThreadsTable(this);
    public final MessagesTable f10548d = new MessagesTable(this);
    public final DatabaseOperations f10549e = new DatabaseOperations(this);
    public final Provider<ViewerContextHelperForContentProviders> f10550f;

    /* compiled from: max_transactions */
    public final class DatabaseOperations {
        public final Uri f10540a = Uri.withAppendedPath(this.f10541b.f10546b, "clear_all_data");
        final /* synthetic */ MessagesDbContract f10541b;

        public DatabaseOperations(MessagesDbContract messagesDbContract) {
            this.f10541b = messagesDbContract;
        }
    }

    /* compiled from: max_transactions */
    public class MessagesTable implements BaseColumns {
        final /* synthetic */ MessagesDbContract f10542a;

        public MessagesTable(MessagesDbContract messagesDbContract) {
            this.f10542a = messagesDbContract;
        }

        public final Uri m11141a() {
            return ((ViewerContextHelperForContentProviders) this.f10542a.f10550f.get()).m16460a(Uri.withAppendedPath(this.f10542a.f10546b, "messages"), new Builder());
        }
    }

    /* compiled from: max_transactions */
    public class ThreadsTable implements BaseColumns {
        final /* synthetic */ MessagesDbContract f10543a;

        public ThreadsTable(MessagesDbContract messagesDbContract) {
            this.f10543a = messagesDbContract;
        }

        public final Uri m11142a() {
            return ((ViewerContextHelperForContentProviders) this.f10543a.f10550f.get()).m16460a(Uri.withAppendedPath(this.f10543a.f10546b, "thread_summaries"), new Builder());
        }
    }

    private static MessagesDbContract m11144b(InjectorLike injectorLike) {
        return new MessagesDbContract((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 8307));
    }

    @Inject
    public MessagesDbContract(Context context, Provider<ViewerContextHelperForContentProviders> provider) {
        this.f10545a = context.getPackageName() + ".messages";
        this.f10550f = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.database.threads.MessagesDbContract m11143a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10544g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11144b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10544g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.MessagesDbContract) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.database.threads.MessagesDbContract) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10544g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.MessagesDbContract) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.MessagesDbContract.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.MessagesDbContract");
    }
}

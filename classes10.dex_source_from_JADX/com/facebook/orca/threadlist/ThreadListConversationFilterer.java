package com.facebook.orca.threadlist;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ArchiveThreadManager;
import com.facebook.messaging.cache.SpamThreadManager;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageTestHelper;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import javax.inject.Inject;

@UserScoped
/* compiled from: native_post */
public class ThreadListConversationFilterer {
    private static final Object f6589d = new Object();
    public final ArchiveThreadManager f6590a;
    public final MontageTestHelper f6591b;
    public final SpamThreadManager f6592c;

    /* compiled from: native_post */
    class C09921 implements Predicate<ThreadSummary> {
        final /* synthetic */ ThreadListConversationFilterer f6586a;

        C09921(ThreadListConversationFilterer threadListConversationFilterer) {
            this.f6586a = threadListConversationFilterer;
        }

        public boolean apply(Object obj) {
            return this.f6586a.f6591b.c(((ThreadSummary) obj).a);
        }
    }

    /* compiled from: native_post */
    class C09932 implements Predicate<ThreadSummary> {
        final /* synthetic */ ThreadListConversationFilterer f6587a;

        C09932(ThreadListConversationFilterer threadListConversationFilterer) {
            this.f6587a = threadListConversationFilterer;
        }

        public boolean apply(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            ArchiveThreadManager archiveThreadManager = this.f6587a.f6590a;
            return archiveThreadManager.c.contains(threadSummary.a);
        }
    }

    /* compiled from: native_post */
    class C09943 implements Predicate<ThreadSummary> {
        final /* synthetic */ ThreadListConversationFilterer f6588a;

        C09943(ThreadListConversationFilterer threadListConversationFilterer) {
            this.f6588a = threadListConversationFilterer;
        }

        public boolean apply(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            SpamThreadManager spamThreadManager = this.f6588a.f6592c;
            return spamThreadManager.c.contains(threadSummary.a);
        }
    }

    private static ThreadListConversationFilterer m6278b(InjectorLike injectorLike) {
        return new ThreadListConversationFilterer(ArchiveThreadManager.a(injectorLike), MontageTestHelper.b(injectorLike), SpamThreadManager.a(injectorLike));
    }

    @Inject
    ThreadListConversationFilterer(ArchiveThreadManager archiveThreadManager, MontageTestHelper montageTestHelper, SpamThreadManager spamThreadManager) {
        this.f6590a = archiveThreadManager;
        this.f6591b = montageTestHelper;
        this.f6592c = spamThreadManager;
    }

    public final Iterable<ThreadSummary> m6282a(Iterable<ThreadSummary> iterable) {
        return m6279b(m6280c(m6281d(iterable)));
    }

    private Iterable<ThreadSummary> m6279b(Iterable<ThreadSummary> iterable) {
        return !this.f6591b.b() ? iterable : m6277a(iterable, new C09921(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadlist.ThreadListConversationFilterer m6276a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f6589d;	 Catch:{ all -> 0x006c }
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
        r1 = m6278b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6589d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadListConversationFilterer) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.threadlist.ThreadListConversationFilterer) r0;	 Catch:{  }
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
        r0 = f6589d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadListConversationFilterer) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadListConversationFilterer.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadlist.ThreadListConversationFilterer");
    }

    private Iterable<ThreadSummary> m6280c(Iterable<ThreadSummary> iterable) {
        return (!this.f6590a.c.isEmpty() ? 1 : null) == null ? iterable : m6277a(iterable, new C09932(this));
    }

    private Iterable<ThreadSummary> m6281d(Iterable<ThreadSummary> iterable) {
        return (!this.f6592c.c.isEmpty() ? 1 : null) == null ? iterable : m6277a(iterable, new C09943(this));
    }

    private static Iterable<ThreadSummary> m6277a(Iterable<ThreadSummary> iterable, Predicate<ThreadSummary> predicate) {
        return Iterables.c(iterable, Predicates.not(predicate));
    }
}

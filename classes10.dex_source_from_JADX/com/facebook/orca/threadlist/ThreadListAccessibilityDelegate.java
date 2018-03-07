package com.facebook.orca.threadlist;

import com.facebook.accessibility.UpdatableListAccessibilityDelegate;
import com.facebook.accessibility.UpdatableListAccessibilityDelegate.UpdateCollection;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* compiled from: native_view_report_url */
public class ThreadListAccessibilityDelegate extends UpdatableListAccessibilityDelegate<ThreadSummary> {
    public Map<ThreadKey, ThreadSummary> f6540d;
    private Provider<User> f6541e;

    /* compiled from: native_view_report_url */
    class C09821 implements UpdateCollection<ThreadSummary> {
        final /* synthetic */ ThreadListAccessibilityDelegate f6539a;

        C09821(ThreadListAccessibilityDelegate threadListAccessibilityDelegate) {
            this.f6539a = threadListAccessibilityDelegate;
        }

        public final void m6237a(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            this.f6539a.f6540d.put(threadSummary.a, threadSummary);
        }

        public final boolean m6238a() {
            return this.f6539a.f6540d.isEmpty();
        }

        public final void m6239b() {
            this.f6539a.f6540d.clear();
        }
    }

    public static ThreadListAccessibilityDelegate m6240a(InjectorLike injectorLike) {
        return new ThreadListAccessibilityDelegate(ViewAccessibilityHelper.a(injectorLike), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    protected final boolean m6241b(Object obj) {
        ThreadSummary threadSummary = (ThreadSummary) obj;
        return threadSummary != null && ((threadSummary.r == null || !Objects.equal(threadSummary.r.b, ((User) this.f6541e.get()).T)) && threadSummary.f() && (!this.f6540d.containsKey(threadSummary.a) || ((ThreadSummary) this.f6540d.get(threadSummary.a)).k < threadSummary.k));
    }

    @Inject
    public ThreadListAccessibilityDelegate(ViewAccessibilityHelper viewAccessibilityHelper, ScheduledExecutorService scheduledExecutorService, Provider<User> provider) {
        super(viewAccessibilityHelper, scheduledExecutorService);
        this.f6541e = provider;
    }

    protected final CharSequence m6243f() {
        Set c = Sets.c();
        for (ThreadSummary threadSummary : this.f6540d.values()) {
            if (threadSummary.g != null) {
                c.add(threadSummary.g);
            } else if (threadSummary.a.a == Type.ONE_TO_ONE) {
                c.add(threadSummary.a(ThreadKey.a(threadSummary.a)).e());
            } else if (threadSummary.a.a == Type.GROUP) {
                if (threadSummary.r != null) {
                    c.add(threadSummary.r.c);
                } else {
                    c.add(null);
                }
            }
        }
        if (c.iterator().next() == null) {
            return this.d.getResources().getQuantityString(2131689766, c.size());
        }
        if (c.size() == 1) {
            return this.d.getResources().getString(2131240210, new Object[]{c.iterator().next()});
        }
        return this.d.getResources().getQuantityString(2131689765, c.size() - 1, new Object[]{c.iterator().next(), Integer.valueOf(c.size() - 1)});
    }

    protected final UpdateCollection<ThreadSummary> m6242e() {
        this.f6540d = Maps.d();
        return new C09821(this);
    }
}

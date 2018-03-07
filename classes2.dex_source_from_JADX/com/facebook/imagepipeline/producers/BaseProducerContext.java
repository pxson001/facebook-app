package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: mediaset/oa.%s */
public class BaseProducerContext {
    public final ImageRequest f14480a;
    public final String f14481b;
    public final ProducerListener f14482c;
    public final Object f14483d;
    public final RequestLevel f14484e;
    @GuardedBy("this")
    private boolean f14485f;
    @GuardedBy("this")
    private Priority f14486g;
    @GuardedBy("this")
    private boolean f14487h;
    @GuardedBy("this")
    private boolean f14488i = false;
    @GuardedBy("this")
    private final List<ProducerContextCallbacks> f14489j = new ArrayList();

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.f14480a = imageRequest;
        this.f14481b = str;
        this.f14482c = producerListener;
        this.f14483d = obj;
        this.f14484e = requestLevel;
        this.f14485f = z;
        this.f14486g = priority;
        this.f14487h = z2;
    }

    public final ImageRequest m20853a() {
        return this.f14480a;
    }

    public final String m20857b() {
        return this.f14481b;
    }

    public final ProducerListener m20859c() {
        return this.f14482c;
    }

    public final Object m20860d() {
        return this.f14483d;
    }

    public final RequestLevel m20861e() {
        return this.f14484e;
    }

    public final synchronized boolean m20862f() {
        return this.f14485f;
    }

    public final synchronized Priority m20863g() {
        return this.f14486g;
    }

    public final synchronized boolean m20864h() {
        return this.f14487h;
    }

    public final void m20856a(BaseProducerContextCallbacks baseProducerContextCallbacks) {
        Object obj = null;
        synchronized (this) {
            this.f14489j.add(baseProducerContextCallbacks);
            if (this.f14488i) {
                obj = 1;
            }
        }
        if (obj != null) {
            baseProducerContextCallbacks.mo2801a();
        }
    }

    public final void m20865i() {
        List<BaseProducerContextCallbacks> j = m20852j();
        if (j != null) {
            for (BaseProducerContextCallbacks a : j) {
                a.mo2801a();
            }
        }
    }

    @Nullable
    public final synchronized List<ProducerContextCallbacks> m20855a(boolean z) {
        List<ProducerContextCallbacks> list;
        if (z == this.f14485f) {
            list = null;
        } else {
            this.f14485f = z;
            list = new ArrayList(this.f14489j);
        }
        return list;
    }

    @Nullable
    public final synchronized List<ProducerContextCallbacks> m20854a(Priority priority) {
        List<ProducerContextCallbacks> list;
        if (priority == this.f14486g) {
            list = null;
        } else {
            this.f14486g = priority;
            list = new ArrayList(this.f14489j);
        }
        return list;
    }

    @Nullable
    public final synchronized List<ProducerContextCallbacks> m20858b(boolean z) {
        List<ProducerContextCallbacks> list;
        if (z == this.f14487h) {
            list = null;
        } else {
            this.f14487h = z;
            list = new ArrayList(this.f14489j);
        }
        return list;
    }

    @Nullable
    private synchronized List<ProducerContextCallbacks> m20852j() {
        List<ProducerContextCallbacks> list;
        if (this.f14488i) {
            list = null;
        } else {
            this.f14488i = true;
            list = new ArrayList(this.f14489j);
        }
        return list;
    }

    public static void m20849a(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BaseProducerContextCallbacks) it.next()).mo2816b();
            }
        }
    }

    public static void m20850b(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BaseProducerContextCallbacks) it.next()).mo2817c();
            }
        }
    }

    public static void m20851c(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BaseProducerContextCallbacks) it.next()).mo2818d();
            }
        }
    }
}

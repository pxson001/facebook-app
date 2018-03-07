package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: memePrompt */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    @GuardedBy("this")
    @VisibleForTesting
    final Map<K, Multiplexer> f14464a = new HashMap();
    public final Producer<T> f14465b;

    @VisibleForTesting
    /* compiled from: memePrompt */
    class Multiplexer {
        final /* synthetic */ MultiplexProducer f14603a;
        private final K f14604b;
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> f14605c = new CopyOnWriteArraySet();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T f14606d;
        @GuardedBy("Multiplexer.this")
        private float f14607e;
        @GuardedBy("Multiplexer.this")
        @Nullable
        public BaseProducerContext f14608f;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer f14609g;

        /* compiled from: memePrompt */
        class ForwardingConsumer extends BaseConsumer<T> {
            final /* synthetic */ Multiplexer f14612a;

            public ForwardingConsumer(Multiplexer multiplexer) {
                this.f14612a = multiplexer;
            }

            protected final void mo2788a(Object obj, boolean z) {
                this.f14612a.m21018a(this, (Closeable) obj, z);
            }

            protected final void mo2790b(Throwable th) {
                this.f14612a.m21019a(this, th);
            }

            protected final void mo2791c() {
                this.f14612a.m21016a(this);
            }

            protected final void mo2789b(float f) {
                this.f14612a.m21017a(this, f);
            }
        }

        public Multiplexer(MultiplexProducer multiplexProducer, K k) {
            this.f14603a = multiplexProducer;
            this.f14604b = k;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean m21020a(com.facebook.imagepipeline.producers.Consumer<T> r7, com.facebook.imagepipeline.producers.ProducerContext r8) {
            /*
            r6 = this;
            r0 = 0;
            r1 = android.util.Pair.create(r7, r8);
            monitor-enter(r6);
            r2 = r6.f14603a;	 Catch:{ all -> 0x0050 }
            r3 = r6.f14604b;	 Catch:{ all -> 0x0050 }
            r2 = com.facebook.imagepipeline.producers.MultiplexProducer.m20833a(r2, r3);	 Catch:{ all -> 0x0050 }
            if (r2 == r6) goto L_0x0012;
        L_0x0010:
            monitor-exit(r6);	 Catch:{ all -> 0x0050 }
        L_0x0011:
            return r0;
        L_0x0012:
            r0 = r6.f14605c;	 Catch:{ all -> 0x0050 }
            r0.add(r1);	 Catch:{ all -> 0x0050 }
            r2 = m21010b(r6);	 Catch:{ all -> 0x0050 }
            r3 = m21014f(r6);	 Catch:{ all -> 0x0050 }
            r4 = m21012d(r6);	 Catch:{ all -> 0x0050 }
            r0 = r6.f14606d;	 Catch:{ all -> 0x0050 }
            r5 = r6.f14607e;	 Catch:{ all -> 0x0050 }
            monitor-exit(r6);	 Catch:{ all -> 0x0050 }
            com.facebook.imagepipeline.producers.BaseProducerContext.m20849a(r2);
            com.facebook.imagepipeline.producers.BaseProducerContext.m20851c(r3);
            com.facebook.imagepipeline.producers.BaseProducerContext.m20850b(r4);
            monitor-enter(r1);
            monitor-enter(r6);	 Catch:{ all -> 0x005f }
            r2 = r6.f14606d;	 Catch:{ all -> 0x005c }
            if (r0 == r2) goto L_0x0053;
        L_0x0037:
            r0 = 0;
        L_0x0038:
            monitor-exit(r6);	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x004a;
        L_0x003b:
            r2 = 0;
            r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0043;
        L_0x0040:
            r7.m20905a(r5);	 Catch:{  }
        L_0x0043:
            r2 = 0;
            r7.m20910b(r0, r2);	 Catch:{  }
            m21009a(r0);	 Catch:{  }
        L_0x004a:
            monitor-exit(r1);	 Catch:{  }
            r6.m21007a(r1, r8);
            r0 = 1;
            goto L_0x0011;
        L_0x0050:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{  }
            throw r0;
        L_0x0053:
            if (r0 == 0) goto L_0x0038;
        L_0x0055:
            r2 = r6.f14603a;	 Catch:{  }
            r0 = r2.mo2775a(r0);	 Catch:{  }
            goto L_0x0038;
        L_0x005c:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.a(com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.BaseProducerContext):boolean");
        }

        private void m21007a(final Pair<Consumer<T>, ProducerContext> pair, ProducerContext producerContext) {
            producerContext.m20856a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ Multiplexer f14611b;

                public final void mo2801a() {
                    List list;
                    List list2;
                    BaseProducerContext baseProducerContext;
                    List list3 = null;
                    synchronized (this.f14611b) {
                        boolean remove = this.f14611b.f14605c.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            baseProducerContext = null;
                        } else if (this.f14611b.f14605c.isEmpty()) {
                            list2 = null;
                            baseProducerContext = this.f14611b.f14608f;
                            list = null;
                        } else {
                            List b = Multiplexer.m21010b(this.f14611b);
                            list2 = Multiplexer.m21014f(this.f14611b);
                            list = list2;
                            list2 = b;
                            baseProducerContext = null;
                            list3 = Multiplexer.m21012d(this.f14611b);
                        }
                    }
                    BaseProducerContext.m20849a(list2);
                    BaseProducerContext.m20851c(list);
                    BaseProducerContext.m20850b(list3);
                    if (baseProducerContext != null) {
                        baseProducerContext.m20865i();
                    }
                    if (remove) {
                        ((BaseConsumer) pair.first).m20908b();
                    }
                }

                public final void mo2816b() {
                    BaseProducerContext.m20849a(Multiplexer.m21010b(this.f14611b));
                }

                public final void mo2817c() {
                    BaseProducerContext.m20850b(Multiplexer.m21012d(this.f14611b));
                }

                public final void mo2818d() {
                    BaseProducerContext.m20851c(Multiplexer.m21014f(this.f14611b));
                }
            });
        }

        public static void m21008a(Multiplexer multiplexer) {
            boolean z = true;
            synchronized (multiplexer) {
                Preconditions.a(multiplexer.f14608f == null);
                if (multiplexer.f14609g != null) {
                    z = false;
                }
                Preconditions.a(z);
                if (multiplexer.f14605c.isEmpty()) {
                    MultiplexProducer.m20834a(multiplexer.f14603a, multiplexer.f14604b, multiplexer);
                    return;
                }
                BaseProducerContext baseProducerContext = (BaseProducerContext) ((Pair) multiplexer.f14605c.iterator().next()).second;
                multiplexer.f14608f = new BaseProducerContext(baseProducerContext.m20853a(), baseProducerContext.m20857b(), baseProducerContext.m20859c(), baseProducerContext.m20860d(), baseProducerContext.m20861e(), multiplexer.m21011c(), multiplexer.m21013e(), multiplexer.m21015g());
                multiplexer.f14609g = new ForwardingConsumer(multiplexer);
                BaseProducerContext baseProducerContext2 = multiplexer.f14608f;
                BaseConsumer baseConsumer = multiplexer.f14609g;
                multiplexer.f14603a.f14465b.mo2774a(baseConsumer, baseProducerContext2);
            }
        }

        @Nullable
        public static synchronized List m21010b(Multiplexer multiplexer) {
            List list;
            synchronized (multiplexer) {
                if (multiplexer.f14608f == null) {
                    list = null;
                } else {
                    list = multiplexer.f14608f.m20855a(multiplexer.m21011c());
                }
            }
            return list;
        }

        private synchronized boolean m21011c() {
            boolean z;
            Iterator it = this.f14605c.iterator();
            while (it.hasNext()) {
                if (!((BaseProducerContext) ((Pair) it.next()).second).m20862f()) {
                    z = false;
                    break;
                }
            }
            z = true;
            return z;
        }

        @Nullable
        public static synchronized List m21012d(Multiplexer multiplexer) {
            List list;
            synchronized (multiplexer) {
                if (multiplexer.f14608f == null) {
                    list = null;
                } else {
                    list = multiplexer.f14608f.m20858b(multiplexer.m21013e());
                }
            }
            return list;
        }

        private synchronized boolean m21013e() {
            boolean z;
            Iterator it = this.f14605c.iterator();
            while (it.hasNext()) {
                if (((BaseProducerContext) ((Pair) it.next()).second).m20864h()) {
                    z = true;
                    break;
                }
            }
            z = false;
            return z;
        }

        @Nullable
        public static synchronized List m21014f(Multiplexer multiplexer) {
            List list;
            synchronized (multiplexer) {
                if (multiplexer.f14608f == null) {
                    list = null;
                } else {
                    list = multiplexer.f14608f.m20854a(multiplexer.m21015g());
                }
            }
            return list;
        }

        private synchronized Priority m21015g() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator it = this.f14605c.iterator();
            priority = priority2;
            while (it.hasNext()) {
                priority = Priority.getHigherPriority(priority, ((BaseProducerContext) ((Pair) it.next()).second).m20863g());
            }
            return priority;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m21019a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r4, java.lang.Throwable r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f14609g;	 Catch:{ all -> 0x003c }
            if (r0 == r4) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x003c }
        L_0x0006:
            return;
        L_0x0007:
            r0 = r3.f14605c;	 Catch:{ all -> 0x003c }
            r2 = r0.iterator();	 Catch:{ all -> 0x003c }
            r0 = r3.f14605c;	 Catch:{ all -> 0x003c }
            r0.clear();	 Catch:{ all -> 0x003c }
            r0 = r3.f14603a;	 Catch:{ all -> 0x003c }
            r1 = r3.f14604b;	 Catch:{ all -> 0x003c }
            com.facebook.imagepipeline.producers.MultiplexProducer.m20834a(r0, r1, r3);	 Catch:{ all -> 0x003c }
            r0 = r3.f14606d;	 Catch:{ all -> 0x003c }
            m21009a(r0);	 Catch:{ all -> 0x003c }
            r0 = 0;
            r3.f14606d = r0;	 Catch:{ all -> 0x003c }
            monitor-exit(r3);	 Catch:{ all -> 0x003c }
        L_0x0022:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x0006;
        L_0x0028:
            r0 = r2.next();
            r1 = r0;
            r1 = (android.util.Pair) r1;
            monitor-enter(r1);
            r0 = r1.first;	 Catch:{ all -> 0x0039 }
            r0 = (com.facebook.imagepipeline.producers.BaseConsumer) r0;	 Catch:{ all -> 0x0039 }
            r0.m20907a(r5);	 Catch:{ all -> 0x0039 }
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0022;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, java.lang.Throwable):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m21018a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r4, T r5, boolean r6) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f14609g;	 Catch:{ all -> 0x0047 }
            if (r0 == r4) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
        L_0x0006:
            return;
        L_0x0007:
            r0 = r3.f14606d;	 Catch:{ all -> 0x0047 }
            m21009a(r0);	 Catch:{ all -> 0x0047 }
            r0 = 0;
            r3.f14606d = r0;	 Catch:{ all -> 0x0047 }
            r0 = r3.f14605c;	 Catch:{ all -> 0x0047 }
            r2 = r0.iterator();	 Catch:{ all -> 0x0047 }
            if (r6 != 0) goto L_0x003a;
        L_0x0017:
            r0 = r3.f14603a;	 Catch:{ all -> 0x0047 }
            r0 = r0.mo2775a(r5);	 Catch:{ all -> 0x0047 }
            r3.f14606d = r0;	 Catch:{ all -> 0x0047 }
        L_0x001f:
            monitor-exit(r3);	 Catch:{ all -> 0x0047 }
        L_0x0020:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x0006;
        L_0x0026:
            r0 = r2.next();
            r1 = r0;
            r1 = (android.util.Pair) r1;
            monitor-enter(r1);
            r0 = r1.first;	 Catch:{ all -> 0x0037 }
            r0 = (com.facebook.imagepipeline.producers.BaseConsumer) r0;	 Catch:{ all -> 0x0037 }
            r0.m20910b(r5, r6);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0020;
        L_0x0037:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            throw r0;
        L_0x003a:
            r0 = r3.f14605c;	 Catch:{  }
            r0.clear();	 Catch:{  }
            r0 = r3.f14603a;	 Catch:{  }
            r1 = r3.f14604b;	 Catch:{  }
            com.facebook.imagepipeline.producers.MultiplexProducer.m20834a(r0, r1, r3);	 Catch:{  }
            goto L_0x001f;
        L_0x0047:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, java.io.Closeable, boolean):void");
        }

        public final void m21016a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer forwardingConsumer) {
            synchronized (this) {
                if (this.f14609g != forwardingConsumer) {
                    return;
                }
                this.f14609g = null;
                this.f14608f = null;
                m21009a(this.f14606d);
                this.f14606d = null;
                m21008a(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m21017a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r4, float r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f14609g;	 Catch:{ all -> 0x002a }
            if (r0 == r4) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x002a }
        L_0x0006:
            return;
        L_0x0007:
            r3.f14607e = r5;	 Catch:{ all -> 0x002a }
            r0 = r3.f14605c;	 Catch:{ all -> 0x002a }
            r2 = r0.iterator();	 Catch:{ all -> 0x002a }
            monitor-exit(r3);	 Catch:{ all -> 0x002a }
        L_0x0010:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x0006;
        L_0x0016:
            r0 = r2.next();
            r1 = r0;
            r1 = (android.util.Pair) r1;
            monitor-enter(r1);
            r0 = r1.first;	 Catch:{ all -> 0x0027 }
            r0 = (com.facebook.imagepipeline.producers.BaseConsumer) r0;	 Catch:{ all -> 0x0027 }
            r0.m20905a(r5);	 Catch:{ all -> 0x0027 }
            monitor-exit(r1);	 Catch:{ all -> 0x0027 }
            goto L_0x0010;
        L_0x0027:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0027 }
            throw r0;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.a(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, float):void");
        }

        private static void m21009a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected abstract T mo2775a(T t);

    protected abstract K mo2776a(ProducerContext producerContext);

    protected MultiplexProducer(Producer<T> producer) {
        this.f14465b = producer;
    }

    public final void mo2774a(Consumer<T> consumer, ProducerContext producerContext) {
        Object a = mo2776a((BaseProducerContext) producerContext);
        Multiplexer a2;
        do {
            Object obj = null;
            synchronized (this) {
                a2 = m20833a(this, a);
                if (a2 == null) {
                    a2 = m20835b(a);
                    obj = 1;
                }
            }
        } while (!a2.m21020a((BaseConsumer) consumer, (BaseProducerContext) producerContext));
        if (obj != null) {
            Multiplexer.m21008a(a2);
        }
    }

    public static synchronized Multiplexer m20833a(MultiplexProducer multiplexProducer, Object obj) {
        Multiplexer multiplexer;
        synchronized (multiplexProducer) {
            multiplexer = (Multiplexer) multiplexProducer.f14464a.get(obj);
        }
        return multiplexer;
    }

    private synchronized Multiplexer m20835b(K k) {
        Multiplexer multiplexer;
        multiplexer = new Multiplexer(this, k);
        this.f14464a.put(k, multiplexer);
        return multiplexer;
    }

    public static synchronized void m20834a(MultiplexProducer multiplexProducer, Object obj, Multiplexer multiplexer) {
        synchronized (multiplexProducer) {
            if (multiplexProducer.f14464a.get(obj) == multiplexer) {
                multiplexProducer.f14464a.remove(obj);
            }
        }
    }
}

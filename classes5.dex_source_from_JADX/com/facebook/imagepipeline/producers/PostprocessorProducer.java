package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: TOPIC_LOCAL */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    private final Producer<CloseableReference<CloseableImage>> f13820a;
    public final PlatformBitmapFactory f13821b;
    public final Executor f13822c;

    /* compiled from: TOPIC_LOCAL */
    class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        final /* synthetic */ PostprocessorProducer f13805a;
        private final ProducerListener f13806b;
        private final String f13807c;
        private final Postprocessor f13808d;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean f13809e;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> f13810f = null;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean f13811g = false;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean f13812h = false;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean f13813i = false;

        /* compiled from: TOPIC_LOCAL */
        class C13142 implements Runnable {
            final /* synthetic */ PostprocessorConsumer f13804a;

            C13142(PostprocessorConsumer postprocessorConsumer) {
                this.f13804a = postprocessorConsumer;
            }

            public void run() {
                synchronized (this.f13804a) {
                    CloseableReference closeableReference = this.f13804a.f13810f;
                    boolean z = this.f13804a.f13811g;
                    this.f13804a.f13810f = null;
                    this.f13804a.f13812h = false;
                }
                if (CloseableReference.a(closeableReference)) {
                    try {
                        PostprocessorConsumer.m23175c(this.f13804a, closeableReference, z);
                    } finally {
                        CloseableReference.c(closeableReference);
                    }
                }
                PostprocessorConsumer.m23178e(this.f13804a);
            }
        }

        protected final void m23183a(Object obj, boolean z) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (CloseableReference.a(closeableReference)) {
                m23174b(closeableReference, z);
            } else if (z) {
                m23177d(null, true);
            }
        }

        public PostprocessorConsumer(final PostprocessorProducer postprocessorProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            this.f13805a = postprocessorProducer;
            super(consumer);
            this.f13806b = producerListener;
            this.f13807c = str;
            this.f13808d = postprocessor;
            producerContext.a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ PostprocessorConsumer f13803b;

                public final void m23167a() {
                    PostprocessorConsumer.m23180g(this.f13803b);
                }
            });
        }

        protected final void m23184b(Throwable th) {
            m23176c(th);
        }

        protected final void m23185c() {
            m23180g(this);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m23174b(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r3, boolean r4) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.f13809e;	 Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        L_0x0006:
            return;
        L_0x0007:
            r0 = r2.f13810f;	 Catch:{ all -> 0x0022 }
            r1 = com.facebook.common.references.CloseableReference.b(r3);	 Catch:{ all -> 0x0022 }
            r2.f13810f = r1;	 Catch:{ all -> 0x0022 }
            r2.f13811g = r4;	 Catch:{ all -> 0x0022 }
            r1 = 1;
            r2.f13812h = r1;	 Catch:{ all -> 0x0022 }
            r1 = r2.m23179f();	 Catch:{ all -> 0x0022 }
            monitor-exit(r2);	 Catch:{ all -> 0x0022 }
            com.facebook.common.references.CloseableReference.c(r0);
            if (r1 == 0) goto L_0x0006;
        L_0x001e:
            r2.m23170a();
            goto L_0x0006;
        L_0x0022:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.b(com.facebook.common.references.CloseableReference, boolean):void");
        }

        private void m23170a() {
            ExecutorDetour.a(this.f13805a.f13822c, new C13142(this), 1696794265);
        }

        public static void m23178e(PostprocessorConsumer postprocessorConsumer) {
            synchronized (postprocessorConsumer) {
                postprocessorConsumer.f13813i = false;
                boolean f = postprocessorConsumer.m23179f();
            }
            if (f) {
                postprocessorConsumer.m23170a();
            }
        }

        private synchronized boolean m23179f() {
            boolean z = true;
            synchronized (this) {
                if (this.f13809e || !this.f13812h || this.f13813i || !CloseableReference.a(this.f13810f)) {
                    z = false;
                } else {
                    this.f13813i = true;
                }
            }
            return z;
        }

        public static void m23175c(PostprocessorConsumer postprocessorConsumer, CloseableReference closeableReference, boolean z) {
            CloseableReference closeableReference2 = null;
            Preconditions.a(CloseableReference.a(closeableReference));
            if (m23171a((CloseableImage) closeableReference.a())) {
                postprocessorConsumer.f13806b.a(postprocessorConsumer.f13807c, "PostprocessorProducer");
                try {
                    closeableReference2 = postprocessorConsumer.m23173b((CloseableImage) closeableReference.a());
                    try {
                        postprocessorConsumer.f13806b.a(postprocessorConsumer.f13807c, "PostprocessorProducer", m23169a(postprocessorConsumer.f13806b, postprocessorConsumer.f13807c, postprocessorConsumer.f13808d));
                        postprocessorConsumer.m23177d(closeableReference2, z);
                        return;
                    } finally {
                        CloseableReference.c(closeableReference2);
                    }
                } catch (Throwable e) {
                    postprocessorConsumer.f13806b.a(postprocessorConsumer.f13807c, "PostprocessorProducer", e, m23169a(postprocessorConsumer.f13806b, postprocessorConsumer.f13807c, postprocessorConsumer.f13808d));
                    postprocessorConsumer.m23176c(e);
                    CloseableReference.c(closeableReference2);
                    return;
                }
            }
            postprocessorConsumer.m23177d(closeableReference, z);
        }

        private static Map<String, String> m23169a(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            if (producerListener.a(str)) {
                return ImmutableMap.a("Postprocessor", postprocessor.a());
            }
            return null;
        }

        private static boolean m23171a(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private CloseableReference<CloseableImage> m23173b(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference a = this.f13808d.a(closeableStaticBitmap.a(), this.f13805a.f13821b);
            try {
                CloseableReference<CloseableImage> a2 = CloseableReference.a(new CloseableStaticBitmap(a, closeableImage.d(), closeableStaticBitmap.h()));
                return a2;
            } finally {
                CloseableReference.c(a);
            }
        }

        private void m23177d(CloseableReference<CloseableImage> closeableReference, boolean z) {
            if ((!z && !m23181h()) || (z && m23182i())) {
                this.a.b(closeableReference, z);
            }
        }

        private void m23176c(Throwable th) {
            if (m23182i()) {
                this.a.a(th);
            }
        }

        public static void m23180g(PostprocessorConsumer postprocessorConsumer) {
            if (postprocessorConsumer.m23182i()) {
                postprocessorConsumer.a.b();
            }
        }

        private synchronized boolean m23181h() {
            return this.f13809e;
        }

        private boolean m23182i() {
            boolean z = true;
            synchronized (this) {
                if (this.f13809e) {
                    z = false;
                } else {
                    CloseableReference closeableReference = this.f13810f;
                    this.f13810f = null;
                    this.f13809e = true;
                    CloseableReference.c(closeableReference);
                }
            }
            return z;
        }
    }

    /* compiled from: TOPIC_LOCAL */
    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        final /* synthetic */ PostprocessorProducer f13816a;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean f13817b = false;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private CloseableReference<CloseableImage> f13818c = null;

        protected final void m23191a(Object obj, boolean z) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (z) {
                m23187a(closeableReference);
                m23188e();
            }
        }

        public RepeatedPostprocessorConsumer(final PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, BaseRepeatedPostProcessor baseRepeatedPostProcessor, BaseProducerContext baseProducerContext) {
            this.f13816a = postprocessorProducer;
            super(postprocessorConsumer);
            baseRepeatedPostProcessor.m23229a(this);
            baseProducerContext.a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ RepeatedPostprocessorConsumer f13815b;

                public final void m23186a() {
                    if (RepeatedPostprocessorConsumer.m23189f(this.f13815b)) {
                        this.f13815b.a.b();
                    }
                }
            });
        }

        protected final void m23192b(Throwable th) {
            if (m23189f(this)) {
                this.a.a(th);
            }
        }

        protected final void m23193c() {
            if (m23189f(this)) {
                this.a.b();
            }
        }

        public final synchronized void m23190a() {
            m23188e();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m23188e() {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f13817b;	 Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x001a }
        L_0x0006:
            return;
        L_0x0007:
            r0 = r3.f13818c;	 Catch:{ all -> 0x001a }
            r1 = com.facebook.common.references.CloseableReference.b(r0);	 Catch:{ all -> 0x001a }
            monitor-exit(r3);	 Catch:{ all -> 0x001a }
            r0 = r3.d();	 Catch:{ all -> 0x001d }
            r2 = 0;
            r0.b(r1, r2);	 Catch:{ all -> 0x001d }
            com.facebook.common.references.CloseableReference.c(r1);
            goto L_0x0006;
        L_0x001a:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
        L_0x001d:
            r0 = move-exception;
            com.facebook.common.references.CloseableReference.c(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.e():void");
        }

        private void m23187a(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.f13817b) {
                    return;
                }
                CloseableReference closeableReference2 = this.f13818c;
                this.f13818c = CloseableReference.b(closeableReference);
                CloseableReference.c(closeableReference2);
            }
        }

        public static boolean m23189f(RepeatedPostprocessorConsumer repeatedPostprocessorConsumer) {
            boolean z = true;
            synchronized (repeatedPostprocessorConsumer) {
                if (repeatedPostprocessorConsumer.f13817b) {
                    z = false;
                } else {
                    CloseableReference closeableReference = repeatedPostprocessorConsumer.f13818c;
                    repeatedPostprocessorConsumer.f13818c = null;
                    repeatedPostprocessorConsumer.f13817b = true;
                    CloseableReference.c(closeableReference);
                }
            }
            return z;
        }
    }

    /* compiled from: TOPIC_LOCAL */
    class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        final /* synthetic */ PostprocessorProducer f13819a;

        protected final void m23194a(Object obj, boolean z) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (z) {
                this.a.b(closeableReference, z);
            }
        }

        public SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer) {
            this.f13819a = postprocessorProducer;
            super(postprocessorConsumer);
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.f13820a = (Producer) Preconditions.a(producer);
        this.f13821b = platformBitmapFactory;
        this.f13822c = (Executor) Preconditions.a(executor);
    }

    public final void m23195a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        BaseConsumer repeatedPostprocessorConsumer;
        ProducerListener producerListener = producerContext.c;
        Postprocessor postprocessor = producerContext.a.l;
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(this, consumer, producerListener, producerContext.b, postprocessor, producerContext);
        if (postprocessor instanceof BaseRepeatedPostProcessor) {
            Object obj = null;
            repeatedPostprocessorConsumer = new RepeatedPostprocessorConsumer(this, postprocessorConsumer, (BaseRepeatedPostProcessor) postprocessor, producerContext);
        } else {
            repeatedPostprocessorConsumer = new SingleUsePostprocessorConsumer(this, postprocessorConsumer);
        }
        this.f13820a.a(repeatedPostprocessorConsumer, producerContext);
    }
}

package com.facebook.messaging.business.common.analytics;

import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.viewport.MessageEnterListener;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: new_size */
public class BusinessMessageImpressionListener {
    private static volatile BusinessMessageImpressionListener f8697e;
    public final MessageEnterListener<ThreadSummary> f8698a = new C09921(this);
    public final MessageEnterListener<Message> f8699b = new C09932(this);
    public final MessageEnterListener<ThreadSummary> f8700c = new C09943(this);
    public final Set<BusinessMessageImpressionLogger> f8701d;

    /* compiled from: new_size */
    class C09921 implements MessageEnterListener<ThreadSummary> {
        final /* synthetic */ BusinessMessageImpressionListener f8694a;

        C09921(BusinessMessageImpressionListener businessMessageImpressionListener) {
            this.f8694a = businessMessageImpressionListener;
        }

        public final void mo315a(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            if (threadSummary.O != null) {
                for (BusinessMessageImpressionLogger a : this.f8694a.f8701d) {
                    a.mo317a(threadSummary);
                }
            }
        }
    }

    /* compiled from: new_size */
    class C09932 implements MessageEnterListener<Message> {
        final /* synthetic */ BusinessMessageImpressionListener f8695a;

        C09932(BusinessMessageImpressionListener businessMessageImpressionListener) {
            this.f8695a = businessMessageImpressionListener;
        }

        public final void mo315a(Object obj) {
            Message message = (Message) obj;
            if (message.N != null) {
                for (BusinessMessageImpressionLogger a : this.f8695a.f8701d) {
                    a.mo316a(message);
                }
            }
        }
    }

    /* compiled from: new_size */
    class C09943 implements MessageEnterListener<ThreadSummary> {
        final /* synthetic */ BusinessMessageImpressionListener f8696a;

        C09943(BusinessMessageImpressionListener businessMessageImpressionListener) {
            this.f8696a = businessMessageImpressionListener;
        }

        public final void mo315a(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            if (threadSummary.O != null) {
                for (BusinessMessageImpressionLogger b : this.f8696a.f8701d) {
                    b.mo318b(threadSummary);
                }
            }
        }
    }

    public static com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener m8904a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8697e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener.class;
        monitor-enter(r1);
        r0 = f8697e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8905b(r0);	 Catch:{ all -> 0x0035 }
        f8697e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8697e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener.a(com.facebook.inject.InjectorLike):com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener");
    }

    private static BusinessMessageImpressionListener m8905b(InjectorLike injectorLike) {
        return new BusinessMessageImpressionListener(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BusinessMessageImpressionLogger(injectorLike)));
    }

    @Inject
    public BusinessMessageImpressionListener(Set<BusinessMessageImpressionLogger> set) {
        this.f8701d = set;
    }
}

package com.facebook.messaging.service.methods;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.analytics.reliability.NetworkChannel;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.zero.MessageCapAccessor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: creating OpenGL ES 2.0 context */
public class WebMarkThreadsHandler {
    private static volatile WebMarkThreadsHandler f16993j;
    private final ApiMethodRunnerImpl f16994a;
    private final MarkArchivedThreadMethod f16995b;
    private final MarkReadThreadMethod f16996c;
    private final MarkSpamThreadMethod f16997d;
    public final MessagesReliabilityLogger f16998e;
    public final DefaultMqttMarkThreadHandler f16999f;
    private final Provider<Boolean> f17000g;
    private final Provider<MessageCapAccessor> f17001h;
    public final GatekeeperStoreImpl f17002i;

    public static com.facebook.messaging.service.methods.WebMarkThreadsHandler m17076a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16993j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.service.methods.WebMarkThreadsHandler.class;
        monitor-enter(r1);
        r0 = f16993j;	 Catch:{ all -> 0x003a }
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
        r0 = m17077b(r0);	 Catch:{ all -> 0x0035 }
        f16993j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16993j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.service.methods.WebMarkThreadsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.service.methods.WebMarkThreadsHandler");
    }

    private static WebMarkThreadsHandler m17077b(InjectorLike injectorLike) {
        return new WebMarkThreadsHandler(ApiMethodRunnerImpl.a(injectorLike), MarkArchivedThreadMethod.m16961a(injectorLike), MarkReadThreadMethod.m16966b(injectorLike), MarkSpamThreadMethod.m16967a(injectorLike), MessagesReliabilityLogger.m7941b(injectorLike), DefaultMqttMarkThreadHandler.m16875b(injectorLike), IdBasedProvider.a(injectorLike, 4068), IdBasedProvider.a(injectorLike, 11785), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WebMarkThreadsHandler(ApiMethodRunner apiMethodRunner, MarkArchivedThreadMethod markArchivedThreadMethod, MarkReadThreadMethod markReadThreadMethod, MarkSpamThreadMethod markSpamThreadMethod, MessagesReliabilityLogger messagesReliabilityLogger, MqttMarkThreadHandler mqttMarkThreadHandler, Provider<Boolean> provider, Provider<MessageCapAccessor> provider2, GatekeeperStore gatekeeperStore) {
        this.f16994a = apiMethodRunner;
        this.f16995b = markArchivedThreadMethod;
        this.f16996c = markReadThreadMethod;
        this.f16997d = markSpamThreadMethod;
        this.f16998e = messagesReliabilityLogger;
        this.f16999f = mqttMarkThreadHandler;
        this.f17000g = provider;
        this.f17001h = provider2;
        this.f17002i = gatekeeperStore;
    }

    public final void m17080a(MarkThreadsParams markThreadsParams) {
        int i = 0;
        if (markThreadsParams.f17216b) {
            this.f17001h.get();
            if (null == null) {
                boolean booleanValue = ((Boolean) this.f17000g.get()).booleanValue();
                if ((markThreadsParams.f17217c.size() == 1 ? 1 : 0) != 0) {
                    MarkThreadFields markThreadFields = (MarkThreadFields) markThreadsParams.f17217c.get(0);
                    if (booleanValue) {
                        boolean b;
                        Mark mark = markThreadsParams.f17215a;
                        this.f16998e.m7948a(mark, markThreadFields, NetworkChannel.MQTT);
                        if (this.f17002i.a(355, false)) {
                            b = this.f16999f.m16878b(mark, markThreadFields);
                        } else {
                            MqttResponse a = this.f16999f.m16877a(mark, markThreadFields);
                            b = a.a && ((MqttMarkThreadResponse) a.b).f16951a;
                        }
                        i = b;
                    }
                    if (i == 0) {
                        m17078b(markThreadsParams.f17215a, markThreadFields);
                        return;
                    }
                    return;
                }
                m17079b(markThreadsParams);
            }
        }
    }

    private void m17079b(MarkThreadsParams markThreadsParams) {
        Mark mark = markThreadsParams.f17215a;
        Batch a = this.f16994a.a();
        for (int i = 0; i < markThreadsParams.f17217c.size(); i++) {
            MarkThreadFields markThreadFields = (MarkThreadFields) markThreadsParams.f17217c.get(i);
            this.f16998e.m7948a(mark, markThreadFields, NetworkChannel.GRAPH);
            Builder a2 = BatchOperation.a(m17075a(mark), markThreadFields);
            a2.c = "mark-thread-" + i + "-" + mark.getApiName();
            a.a(a2.a());
        }
        a.a("markMultipleThreads", CallerContext.a(getClass()));
    }

    private void m17078b(Mark mark, MarkThreadFields markThreadFields) {
        this.f16998e.m7948a(mark, markThreadFields, NetworkChannel.GRAPH);
        this.f16994a.a(m17075a(mark), markThreadFields);
    }

    private AbstractMarkThreadMethod m17075a(Mark mark) {
        if (mark == Mark.ARCHIVED) {
            return this.f16995b;
        }
        if (mark == Mark.READ) {
            return this.f16996c;
        }
        if (mark == Mark.SPAM) {
            return this.f16997d;
        }
        throw new IllegalArgumentException();
    }
}

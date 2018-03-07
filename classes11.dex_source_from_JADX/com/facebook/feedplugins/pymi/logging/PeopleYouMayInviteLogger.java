package com.facebook.feedplugins.pymi.logging;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: cold_launch */
public class PeopleYouMayInviteLogger {
    private static volatile PeopleYouMayInviteLogger f8688e;
    public final Clock f8689a;
    public final FunnelLoggerImpl f8690b;
    public boolean f8691c = false;
    public long f8692d = -1;

    /* compiled from: cold_launch */
    public enum Events {
        XOUT("xout"),
        UNDO("undo"),
        INVITE("invite"),
        INVITE_MORE("invite_more"),
        SCROLL_INVITES("scroll_invites");
        
        private final String mEventName;

        private Events(String str) {
            this.mEventName = str;
        }

        public final String getEventName() {
            return this.mEventName;
        }
    }

    public static com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger m9512a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8688e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.class;
        monitor-enter(r1);
        r0 = f8688e;	 Catch:{ all -> 0x003a }
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
        r0 = m9513b(r0);	 Catch:{ all -> 0x0035 }
        f8688e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8688e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger");
    }

    private static PeopleYouMayInviteLogger m9513b(InjectorLike injectorLike) {
        return new PeopleYouMayInviteLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public PeopleYouMayInviteLogger(Clock clock, FunnelLoggerImpl funnelLoggerImpl) {
        this.f8689a = clock;
        this.f8690b = funnelLoggerImpl;
    }

    public final void m9514a() {
        boolean z = false;
        if (this.f8691c) {
            if (this.f8689a.a() - this.f8692d > 300000) {
                this.f8691c = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            FunnelDefinition funnelDefinition = FunnelRegistry.s;
            funnelDefinition.d = false;
            funnelDefinition.c = 300;
            this.f8690b.a(FunnelRegistry.s);
            this.f8691c = true;
            this.f8692d = this.f8689a.a();
        }
    }

    public final void m9516a(String str) {
        this.f8690b.a(FunnelRegistry.s, str);
        this.f8692d = this.f8689a.a();
    }

    public final void m9515a(Events events) {
        this.f8690b.b(FunnelRegistry.s, events.getEventName());
        this.f8692d = this.f8689a.a();
    }
}

package com.facebook.events.invite;

import android.annotation.SuppressLint;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: check_in_bubble */
public class InviteSessionLogger {
    private static volatile InviteSessionLogger f17717g;
    private InviteSubSession f17718a = new InviteSubSession(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
    private InviteSubSession f17719b = new InviteSubSession(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
    private InviteSubSession f17720c = new InviteSubSession(InviteSubSessionTypes.CONTACTS);
    private InviteSubSession f17721d = new InviteSubSession(InviteSubSessionTypes.INVITE_SEARCH);
    private InviteSubSession f17722e = new InviteSubSession(InviteSubSessionTypes.REVIEW);
    private boolean f17723f = false;

    public static com.facebook.events.invite.InviteSessionLogger m18047a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f17717g;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.events.invite.InviteSessionLogger.class;
        monitor-enter(r1);
        r0 = f17717g;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m18049c();	 Catch:{ all -> 0x0034 }
        f17717g = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17717g;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.invite.InviteSessionLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.invite.InviteSessionLogger");
    }

    private static InviteSessionLogger m18049c() {
        return new InviteSessionLogger();
    }

    private InviteSubSession m18050d(InviteSubSessionTypes inviteSubSessionTypes) {
        switch (inviteSubSessionTypes) {
            case INVITE_SEARCH:
                return this.f17721d;
            case ALL_CANDIDATES_ALPHABETICAL:
                return this.f17719b;
            case ALL_CANDIDATES_SUGGESTED:
                return this.f17718a;
            case CONTACTS:
                return this.f17720c;
            case REVIEW:
                return this.f17722e;
            default:
                return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static Map<String, String> m18048a(InviteSubSession inviteSubSession) {
        String toLowerCase = inviteSubSession.f17724a.name().toLowerCase();
        return ImmutableMap.of(toLowerCase.concat("_count"), String.valueOf(inviteSubSession.f17726c), toLowerCase.concat("_selections"), String.valueOf(inviteSubSession.f17727d), toLowerCase.concat("_deselections"), String.valueOf(inviteSubSession.f17728e), toLowerCase.concat("_time_spent"), String.valueOf(inviteSubSession.f17729f));
    }

    public final void m18052a(InviteSubSessionTypes inviteSubSessionTypes) {
        InviteSubSession d = m18050d(inviteSubSessionTypes);
        d.f17730g = AwakeTimeSinceBootClock.INSTANCE.now();
        d.f17725b = true;
    }

    public final void m18055b(InviteSubSessionTypes inviteSubSessionTypes) {
        InviteSubSession d = m18050d(inviteSubSessionTypes);
        d.m18058a();
        d.m18059e();
    }

    public final void m18057c(InviteSubSessionTypes inviteSubSessionTypes) {
        InviteSubSession d = m18050d(inviteSubSessionTypes);
        if (d.f17725b) {
            d.m18058a();
        }
        if (d.f17725b) {
            d.m18059e();
        }
    }

    public final void m18053a(InviteSubSessionTypes inviteSubSessionTypes, int i) {
        InviteSubSession d = m18050d(inviteSubSessionTypes);
        d.f17727d += i;
    }

    public final void m18056b(InviteSubSessionTypes inviteSubSessionTypes, int i) {
        InviteSubSession d = m18050d(inviteSubSessionTypes);
        d.f17728e += i;
    }

    public final Map<String, String> m18051a() {
        Map<String, String> c = Maps.c();
        c.putAll(m18048a(this.f17719b));
        c.putAll(m18048a(this.f17718a));
        c.putAll(m18048a(this.f17720c));
        c.putAll(m18048a(this.f17721d));
        c.putAll(m18048a(this.f17722e));
        return c;
    }

    public final void m18054b() {
        this.f17718a = new InviteSubSession(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
        this.f17719b = new InviteSubSession(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
        this.f17720c = new InviteSubSession(InviteSubSessionTypes.CONTACTS);
        this.f17721d = new InviteSubSession(InviteSubSessionTypes.INVITE_SEARCH);
        this.f17722e = new InviteSubSession(InviteSubSessionTypes.REVIEW);
    }
}

package com.facebook.groups.logging;

import com.facebook.groups.logging.GroupsFeedSequences.GroupsFeedTTISequence;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.EnumSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: f4817c3b63f3c1a1a75dd030a3932323 */
public class GroupsSequenceLogger {
    private static volatile GroupsSequenceLogger f14169o;
    public final SequenceLogger f14170a;
    private final InteractionTTILogger f14171b;
    private boolean f14172c;
    private boolean f14173d;
    private boolean f14174e;
    private boolean f14175f;
    private boolean f14176g;
    public EnumSet<GroupsFeedSequences> f14177h = EnumSet.noneOf(GroupsFeedSequences.class);
    private boolean f14178i;
    private boolean f14179j;
    private boolean f14180k;
    private boolean f14181l;
    private EnumSet<GroupsTabSequences> f14182m = EnumSet.noneOf(GroupsTabSequences.class);
    private boolean f14183n;

    public static com.facebook.groups.logging.GroupsSequenceLogger m15718a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14169o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.logging.GroupsSequenceLogger.class;
        monitor-enter(r1);
        r0 = f14169o;	 Catch:{ all -> 0x003a }
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
        r0 = m15722b(r0);	 Catch:{ all -> 0x0035 }
        f14169o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14169o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.logging.GroupsSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.groups.logging.GroupsSequenceLogger");
    }

    private static GroupsSequenceLogger m15722b(InjectorLike injectorLike) {
        return new GroupsSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public GroupsSequenceLogger(SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger) {
        this.f14170a = sequenceLogger;
        this.f14171b = interactionTTILogger;
    }

    public final void m15728a(long j) {
        this.f14172c = false;
        this.f14173d = false;
        this.f14174e = false;
        this.f14175f = false;
        this.f14176g = false;
        this.f14170a.a(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE, null, j);
        GroupsFeedSequences groupsFeedSequences = GroupsFeedSequences.INITIAL_STORIES;
        if (!this.f14177h.contains(groupsFeedSequences)) {
            Sequence e = this.f14170a.e(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
            if (e != null) {
                SequenceLoggerDetour.a(e, groupsFeedSequences.getName(), null, null, j, 1263001001);
                this.f14177h.add(groupsFeedSequences);
            }
        }
    }

    public final void m15726a() {
        this.f14172c = false;
        this.f14173d = false;
        this.f14174e = false;
        this.f14175f = false;
        this.f14176g = false;
        m15723b(GroupsFeedSequences.CACHED_HEADER);
        m15723b(GroupsFeedSequences.CACHED_STORIES);
        m15723b(GroupsFeedSequences.FRESH_HEADER);
        m15723b(GroupsFeedSequences.FRESH_STORIES);
        m15723b(GroupsFeedSequences.INITIAL_STORIES);
        m15724b(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
    }

    public final void m15729b() {
        m15719a(GroupsFeedSequences.CACHED_HEADER);
    }

    public final void m15731c() {
        m15719a(GroupsFeedSequences.FRESH_HEADER);
    }

    public final void m15732d() {
        this.f14172c = true;
        m15720a(GroupsFeedSequences.CACHED_HEADER, null);
    }

    public final void m15733e() {
        m15723b(GroupsFeedSequences.CACHED_HEADER);
    }

    public final void m15734f() {
        m15723b(GroupsFeedSequences.FRESH_HEADER);
    }

    public final void m15735g() {
        this.f14173d = true;
        m15720a(GroupsFeedSequences.FRESH_HEADER, null);
    }

    public final void m15736h() {
        m15719a(GroupsFeedSequences.CACHED_STORIES);
    }

    public final void m15737i() {
        m15719a(GroupsFeedSequences.FRESH_STORIES);
    }

    public final void m15727a(int i) {
        boolean z = this.f14176g || i > 0;
        this.f14176g = z;
        this.f14174e = true;
        m15720a(GroupsFeedSequences.CACHED_STORIES, new Builder().b("stories_count", String.valueOf(i)).b());
    }

    public final void m15730b(int i) {
        boolean z = this.f14176g || i > 0;
        this.f14176g = z;
        this.f14175f = true;
        m15720a(GroupsFeedSequences.FRESH_STORIES, new Builder().b("stories_count", String.valueOf(i)).b());
    }

    public final void m15738j() {
        m15725c(GroupsFeedSequences.CACHED_HEADER);
        m15725c(GroupsFeedSequences.FRESH_HEADER);
    }

    public final void m15739k() {
        m15725c(GroupsFeedSequences.CACHED_STORIES);
    }

    public final void m15740l() {
        m15725c(GroupsFeedSequences.FRESH_STORIES);
    }

    public final Boolean m15741m() {
        boolean z = (this.f14172c || this.f14173d) && this.f14174e && this.f14175f;
        if (this.f14176g) {
            m15720a(GroupsFeedSequences.INITIAL_STORIES, null);
        }
        if (z) {
            GroupsFeedTTISequence groupsFeedTTISequence = GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE;
            if (this.f14170a.e(groupsFeedTTISequence) != null) {
                this.f14170a.b(groupsFeedTTISequence);
            }
            this.f14171b.b("LoadGroupsFeed");
        }
        return Boolean.valueOf(z);
    }

    public final void m15742n() {
        if (this.f14183n) {
            this.f14183n = false;
            this.f14178i = false;
            this.f14179j = false;
            this.f14181l = false;
            this.f14180k = false;
            m15721a(GroupsTabSequences.RANKED_BOOKMARKS_SECTION);
            m15721a(GroupsTabSequences.EVENTS_SECTION);
            m15721a(GroupsTabSequences.GROUPS_SECTION);
            m15721a(GroupsTabSequences.POG_SECTION);
            m15724b(GroupsTabSequences.GROUPS_TAB_TTI_SEQUENCE);
        }
    }

    private void m15724b(AbstractSequenceDefinition abstractSequenceDefinition) {
        if (this.f14170a.e(abstractSequenceDefinition) != null) {
            this.f14170a.d(abstractSequenceDefinition);
        }
    }

    private void m15719a(GroupsFeedSequences groupsFeedSequences) {
        if (!this.f14177h.contains(groupsFeedSequences)) {
            Sequence e = this.f14170a.e(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
            if (e != null) {
                SequenceLoggerDetour.a(e, groupsFeedSequences.getName(), 116765473);
                this.f14177h.add(groupsFeedSequences);
            }
        }
    }

    private void m15723b(GroupsFeedSequences groupsFeedSequences) {
        if (this.f14177h.contains(groupsFeedSequences)) {
            Sequence e = this.f14170a.e(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
            if (e != null) {
                SequenceLoggerDetour.d(e, groupsFeedSequences.getName(), 775027013);
                this.f14177h.remove(groupsFeedSequences);
            }
        }
    }

    private void m15720a(GroupsFeedSequences groupsFeedSequences, @Nullable ImmutableMap<String, String> immutableMap) {
        if (this.f14177h.contains(groupsFeedSequences)) {
            Sequence e = this.f14170a.e(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
            if (e != null) {
                if (immutableMap == null) {
                    SequenceLoggerDetour.b(e, groupsFeedSequences.getName(), -1850055119);
                } else {
                    SequenceLoggerDetour.b(e, groupsFeedSequences.getName(), null, immutableMap, -1094422568);
                }
                this.f14177h.remove(groupsFeedSequences);
            }
        }
    }

    private void m15725c(GroupsFeedSequences groupsFeedSequences) {
        if (this.f14177h.contains(groupsFeedSequences)) {
            Sequence e = this.f14170a.e(GroupsFeedSequences.GROUPS_FEED_TTI_SEQUENCE);
            if (e != null) {
                SequenceLoggerDetour.c(e, groupsFeedSequences.getName(), 1794887016);
                this.f14177h.remove(groupsFeedSequences);
            }
        }
    }

    private void m15721a(GroupsTabSequences groupsTabSequences) {
        if (this.f14182m.contains(groupsTabSequences)) {
            Sequence e = this.f14170a.e(GroupsTabSequences.GROUPS_TAB_TTI_SEQUENCE);
            if (e != null) {
                SequenceLoggerDetour.d(e, groupsTabSequences.getName(), 594733119);
                this.f14182m.remove(groupsTabSequences);
            }
        }
    }
}

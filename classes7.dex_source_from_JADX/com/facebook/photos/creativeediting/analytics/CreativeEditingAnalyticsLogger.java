package com.facebook.photos.creativeediting.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: mWidth */
public class CreativeEditingAnalyticsLogger {
    public static final CreativeEditingSequence f9509a = new CreativeEditingSequence();
    private static volatile CreativeEditingAnalyticsLogger f9510e;
    public final SequenceLogger f9511b;
    private final MonotonicClock f9512c;
    public final int f9513d;

    /* compiled from: mWidth */
    class CreativeEditingSequence extends AbstractSequenceDefinition {
        public CreativeEditingSequence() {
            super(2228225, "CreativeEditingSequence");
        }
    }

    /* compiled from: mWidth */
    public enum Events {
        STICKER_EDIT_FLOW("sticker_edit_flow"),
        STICKER_REMOVED("sticker_removed"),
        STICKER_ADDED("sticker_added"),
        STICKER_PICKER_OPENED("sticker_picker_opened"),
        STICKER_PICKER_CLOSED("sticker_picker_closed"),
        ENTER_STICKER_STORE("enter_sticker_store"),
        ATTACHMENT_ADDED("attachment_added"),
        ATTACHMENT_REMOVED("attachment_removed");
        
        public final String name;

        private Events(String str) {
            this.name = str;
        }
    }

    public static com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger m11459a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9510e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f9510e;	 Catch:{ all -> 0x003a }
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
        r0 = m11460b(r0);	 Catch:{ all -> 0x0035 }
        f9510e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9510e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger");
    }

    private static CreativeEditingAnalyticsLogger m11460b(InjectorLike injectorLike) {
        return new CreativeEditingAnalyticsLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public CreativeEditingAnalyticsLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock, XConfigReader xConfigReader) {
        this.f9511b = sequenceLogger;
        this.f9512c = monotonicClock;
        this.f9513d = xConfigReader.a(CreativeEditingAnalyticsLoggingXConfig.c, 4);
    }

    public final void m11461a(String str, int i) {
        Object obj;
        if (HashCodeUtil.a(str) % this.f9513d == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ImmutableBiMap b = ImmutableBiMap.b("numOfAttachments", Integer.toString(i));
            this.f9511b.a(f9509a, str, b, this.f9512c.now());
        }
    }

    public final void m11463b(String str, int i) {
        if (this.f9511b.b(f9509a, str) != null) {
            ImmutableMap of = ImmutableMap.of("numOfAttachments", Integer.toString(i), "composerSessionId", str, "failed", "false");
            this.f9511b.b(f9509a, str, of, this.f9512c.now());
        }
    }

    public final void m11464c(String str, int i) {
        if (this.f9511b.b(f9509a, str) != null) {
            ImmutableMap of = ImmutableMap.of("numOfAttachments", Integer.toString(i), "composerSessionId", str, "cancelled", "true");
            this.f9511b.b(f9509a, str, of, this.f9512c.now());
        }
    }

    public final void m11465d(String str, int i) {
        Sequence b = this.f9511b.b(f9509a, str);
        if (b != null) {
            SequenceLoggerDetour.b(b, Events.STICKER_EDIT_FLOW.name, null, ImmutableBiMap.b("numOfStickers", Integer.toString(i)), this.f9512c.now(), -127415038);
        }
    }

    public final void m11462a(String str, Events events) {
        Sequence b = this.f9511b.b(f9509a, str);
        if (b != null && events != null) {
            SequenceLoggerDetour.e(b, events.name, -15692135);
        }
    }
}

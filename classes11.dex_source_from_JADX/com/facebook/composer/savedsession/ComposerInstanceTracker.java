package com.facebook.composer.savedsession;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: final_count */
public class ComposerInstanceTracker {
    private static final Class<?> f6908a = ComposerInstanceTracker.class;
    private static volatile ComposerInstanceTracker f6909e;
    @GuardedBy("this")
    private final Map<String, ComposerInstance> f6910b = new HashMap();
    private final Clock f6911c;
    private FbObjectMapper f6912d;

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = ComposerInstanceTracker_ComposerInstanceDeserializer.class)
    @JsonSerialize(using = ComposerInstanceTracker_ComposerInstanceSerializer.class)
    /* compiled from: final_count */
    class ComposerInstance {
        @JsonProperty("configuration")
        public final ComposerConfiguration configuration;
        @JsonProperty("last_saved_session")
        public final ComposerSavedSession lastSavedSession;
        @JsonProperty("start_time")
        public final long startTime;

        private ComposerInstance() {
            this.startTime = 0;
            this.configuration = null;
            this.lastSavedSession = null;
        }

        public ComposerInstance(long j, ComposerConfiguration composerConfiguration, ComposerSavedSession composerSavedSession) {
            this.startTime = j;
            this.configuration = composerConfiguration;
            this.lastSavedSession = composerSavedSession;
        }
    }

    public static com.facebook.composer.savedsession.ComposerInstanceTracker m8225a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6909e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.savedsession.ComposerInstanceTracker.class;
        monitor-enter(r1);
        r0 = f6909e;	 Catch:{ all -> 0x003a }
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
        r0 = m8226b(r0);	 Catch:{ all -> 0x0035 }
        f6909e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6909e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.savedsession.ComposerInstanceTracker.a(com.facebook.inject.InjectorLike):com.facebook.composer.savedsession.ComposerInstanceTracker");
    }

    private static ComposerInstanceTracker m8226b(InjectorLike injectorLike) {
        return new ComposerInstanceTracker((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerInstanceTracker(Clock clock, FbObjectMapper fbObjectMapper) {
        this.f6911c = clock;
        this.f6912d = fbObjectMapper;
    }

    public final synchronized void m8230a(String str, ComposerConfiguration composerConfiguration) {
        this.f6910b.put(str, new ComposerInstance(this.f6911c.a(), composerConfiguration, null));
    }

    public final synchronized void m8229a(String str) {
        this.f6910b.remove(str);
    }

    public final synchronized void m8228a(ComposerSavedSession composerSavedSession) {
        String str = composerSavedSession.sessionId;
        ComposerInstance composerInstance = (ComposerInstance) this.f6910b.get(str);
        if (composerInstance != null) {
            this.f6910b.put(str, new ComposerInstance(composerInstance.startTime, composerInstance.configuration, composerSavedSession));
        }
    }

    public final synchronized String m8227a() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        try {
            for (String stringBuilder3 : this.f6910b.keySet()) {
                stringBuilder2.append(stringBuilder3).append("=").append(this.f6912d.a(this.f6910b.get(stringBuilder3))).append("\n");
            }
            stringBuilder3 = stringBuilder2.toString();
        } catch (JsonProcessingException e) {
            BLog.a(f6908a, "Couldn't dump composer instances", e);
            stringBuilder3 = "";
        }
        return stringBuilder3;
    }
}

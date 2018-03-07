package com.facebook.transliteration;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_gif_picker_launcher_settings */
public class TransliterateAnalyticsLogger {
    private static volatile TransliterateAnalyticsLogger f15066b;
    private final AnalyticsLogger f15067a;

    /* compiled from: extra_gif_picker_launcher_settings */
    enum EventType {
        BACK_BUTTON("transliterator_back_pressed"),
        DICTIONARY_LOAD_FAILED("transliterator_dictionary_load_failed"),
        DICTIONARY_MODIFICATION_FAILED("transliterator_dictionary_mod_failed"),
        DOWNLOAD_FAILED("transliterator_download_failed"),
        FINISHED("transliterator_finished"),
        HELP_CANCELLED("transliterator_help_cancelled"),
        HELP_OPENED("transliterator_help_opened"),
        HELP_USED("transliterator_help_used"),
        OPENED("transliterator_opened"),
        MORE_CANCELLED("transliterator_more_cancelled"),
        MORE_OPENED("transliterator_more_opened"),
        WORD_TRANSLITERATED("transliterator_word_transliterated"),
        COMMENT_POSTED("transliterator_comment_posted"),
        PREFERENCE_CHANGED("transliterator_preference_changed");
        
        public final String eventName;

        private EventType(String str) {
            this.eventName = str;
        }
    }

    public static com.facebook.transliteration.TransliterateAnalyticsLogger m19046a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15066b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.transliteration.TransliterateAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f15066b;	 Catch:{ all -> 0x003a }
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
        r0 = m19049b(r0);	 Catch:{ all -> 0x0035 }
        f15066b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15066b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.transliteration.TransliterateAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.transliteration.TransliterateAnalyticsLogger");
    }

    private static TransliterateAnalyticsLogger m19049b(InjectorLike injectorLike) {
        return new TransliterateAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TransliterateAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f15067a = analyticsLogger;
    }

    private void m19047a(String str) {
        AnalyticsLogger analyticsLogger = this.f15067a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "transliteration_composer";
        analyticsLogger.a(honeyClientEvent);
    }

    private void m19048a(String str, Map<String, String> map) {
        AnalyticsLogger analyticsLogger = this.f15067a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "transliteration_composer";
        analyticsLogger.a(honeyClientEvent.a(map));
    }

    public final void m19054a(String str, Algorithm algorithm, int i) {
        Map hashMap = new HashMap();
        hashMap.put("entry_point", str);
        hashMap.put("algorithm", algorithm.name());
        hashMap.put("version", String.valueOf(i));
        m19048a(EventType.OPENED.eventName, hashMap);
    }

    public final void m19050a() {
        m19047a(EventType.HELP_OPENED.eventName);
    }

    public final void m19057b() {
        m19047a(EventType.HELP_CANCELLED.eventName);
    }

    public final void m19059c() {
        m19047a(EventType.MORE_OPENED.eventName);
    }

    public final void m19061d() {
        m19047a(EventType.MORE_CANCELLED.eventName);
    }

    public final void m19058b(String str, Algorithm algorithm, int i) {
        Map hashMap = new HashMap();
        hashMap.put("algorithm", algorithm.name());
        hashMap.put("character", str);
        hashMap.put("version", String.valueOf(i));
        m19048a(EventType.HELP_USED.eventName, hashMap);
    }

    public final void m19060c(String str, Algorithm algorithm, int i) {
        Map hashMap = new HashMap();
        hashMap.put("final_text", str);
        hashMap.put("algorithm", algorithm.name());
        hashMap.put("version", String.valueOf(i));
        m19048a(EventType.FINISHED.eventName, hashMap);
    }

    public final void m19052a(Algorithm algorithm, int i) {
        Map hashMap = new HashMap();
        hashMap.put("algorithm", algorithm.name());
        hashMap.put("version", String.valueOf(i));
        m19048a(EventType.BACK_BUTTON.eventName, hashMap);
    }

    public final void m19056a(String str, String str2, int i, Algorithm algorithm, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("target", str2);
        hashMap.put("algorithm", algorithm.name());
        hashMap.put("version", String.valueOf(i2));
        hashMap.put("index", String.valueOf(i));
        m19048a(EventType.WORD_TRANSLITERATED.eventName, hashMap);
    }

    public final void m19062e() {
        m19047a(EventType.COMMENT_POSTED.eventName);
    }

    public final void m19051a(Algorithm algorithm) {
        Map hashMap = new HashMap();
        hashMap.put("algorithm", algorithm.name());
        m19048a(EventType.DICTIONARY_LOAD_FAILED.eventName, hashMap);
    }

    public final void m19055a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("target", str2);
        m19048a(EventType.DICTIONARY_MODIFICATION_FAILED.eventName, hashMap);
    }

    public final void m19063f() {
        m19047a(EventType.DOWNLOAD_FAILED.eventName);
    }

    public final void m19053a(Boolean bool, Boolean bool2) {
        Map hashMap = new HashMap();
        hashMap.put("old", bool.toString());
        hashMap.put("new", bool2.toString());
        m19048a(EventType.PREFERENCE_CHANGED.eventName, hashMap);
    }
}

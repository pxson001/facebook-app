package com.facebook.photos.base.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: intent_cmd */
public class ProfilePhotoPromptLogger {
    private static volatile ProfilePhotoPromptLogger f12644c;
    private final AnalyticsLogger f12645a;
    private final WaterfallIdGenerator f12646b;

    /* compiled from: intent_cmd */
    enum Event {
        PROFILE_PHOTO_PROMPT_CLICKED("profile_photo_prompt_clicked"),
        PROFILE_PHOTO_PROMPT_DISMISSED("profile_photo_prompt_dismissed"),
        PROFILE_PHOTO_PROMPT_DISPLAYED("profile_photo_prompt_displayed"),
        PROFILE_PHOTO_PROMPT_UPLOADED("profile_photo_prompt_uploaded"),
        PROFILE_PHOTO_PROMPT_CANCELED("profile_photo_prompt_canceled");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }

    public static com.facebook.photos.base.analytics.ProfilePhotoPromptLogger m19994a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12644c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.base.analytics.ProfilePhotoPromptLogger.class;
        monitor-enter(r1);
        r0 = f12644c;	 Catch:{ all -> 0x003a }
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
        r0 = m19996b(r0);	 Catch:{ all -> 0x0035 }
        f12644c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12644c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.base.analytics.ProfilePhotoPromptLogger.a(com.facebook.inject.InjectorLike):com.facebook.photos.base.analytics.ProfilePhotoPromptLogger");
    }

    private static ProfilePhotoPromptLogger m19996b(InjectorLike injectorLike) {
        return new ProfilePhotoPromptLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), WaterfallIdGenerator.m20066a(injectorLike));
    }

    @Inject
    public ProfilePhotoPromptLogger(AnalyticsLogger analyticsLogger, WaterfallIdGenerator waterfallIdGenerator) {
        this.f12645a = analyticsLogger;
        this.f12646b = waterfallIdGenerator;
    }

    public final String m19997a(int i, int i2, String str) {
        String a = WaterfallIdGenerator.m20067a();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PROFILE_PHOTO_PROMPT_DISPLAYED.getName());
        honeyClientEvent.a("photo_num_likes", i).a("photo_num_comments", i2).b("photo_fbid", str);
        m19995a(honeyClientEvent, a);
        return a;
    }

    public final void m19998a(String str) {
        m19995a(new HoneyClientEvent(Event.PROFILE_PHOTO_PROMPT_CLICKED.getName()), str);
    }

    public final void m19999b(String str) {
        m19995a(new HoneyClientEvent(Event.PROFILE_PHOTO_PROMPT_DISMISSED.getName()), str);
    }

    private void m19995a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.f = str;
        this.f12645a.a(honeyClientEvent);
    }
}

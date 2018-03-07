package com.facebook.privacy.audience;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.audience.InlinePrivacySurveyConfig.Builder;
import com.facebook.privacy.protocol.C0164x41da8659;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_nux_blocks */
public class InlinePrivacySurveyManager {
    private static volatile InlinePrivacySurveyManager f2062e;
    private final AbstractFbErrorReporter f2063a;
    private final FbSharedPreferences f2064b;
    private final ObjectMapper f2065c;
    private InlinePrivacySurveyConfig f2066d;

    public static com.facebook.privacy.audience.InlinePrivacySurveyManager m2145a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2062e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.audience.InlinePrivacySurveyManager.class;
        monitor-enter(r1);
        r0 = f2062e;	 Catch:{ all -> 0x003a }
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
        r0 = m2147b(r0);	 Catch:{ all -> 0x0035 }
        f2062e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2062e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.audience.InlinePrivacySurveyManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.audience.InlinePrivacySurveyManager");
    }

    private static InlinePrivacySurveyManager m2147b(InjectorLike injectorLike) {
        return new InlinePrivacySurveyManager((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InlinePrivacySurveyManager(AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper) {
        this.f2063a = abstractFbErrorReporter;
        this.f2064b = fbSharedPreferences;
        this.f2065c = objectMapper;
    }

    public final InlinePrivacySurveyConfig m2150a() {
        if (this.f2066d == null) {
            m2148c();
        }
        return this.f2066d;
    }

    public final void m2152b() {
        Builder builder = new Builder();
        builder.f3549a = false;
        builder = builder;
        builder.f3550b = null;
        builder = builder;
        builder.f3551c = null;
        builder = builder;
        builder.f3552d = null;
        m2146a(builder.m3940a());
    }

    public final void m2151a(C0164x41da8659 c0164x41da8659) {
        if (c0164x41da8659 == null) {
            m2152b();
            return;
        }
        Builder builder = new Builder();
        builder.f3549a = c0164x41da8659.m3936a();
        builder = builder;
        builder.f3550b = c0164x41da8659.m3939l();
        builder = builder;
        builder.f3551c = c0164x41da8659.m3937j();
        builder = builder;
        builder.f3552d = c0164x41da8659.m3938k();
        m2146a(builder.m3940a());
    }

    private void m2146a(InlinePrivacySurveyConfig inlinePrivacySurveyConfig) {
        String a;
        this.f2066d = inlinePrivacySurveyConfig;
        try {
            a = this.f2065c.a(inlinePrivacySurveyConfig);
        } catch (Throwable e) {
            this.f2063a.b("inline_privacy_survey_serialization", "Can't serialize InlinePrivacySurveyConfig", e);
            a = null;
        }
        if (a != null) {
            this.f2064b.edit().a(PrivacyPrefKeys.f2173o, a).commit();
        }
    }

    private void m2148c() {
        String a = this.f2064b.a(PrivacyPrefKeys.f2173o, null);
        if (a == null) {
            m2149d();
            return;
        }
        try {
            this.f2066d = (InlinePrivacySurveyConfig) this.f2065c.a(a, InlinePrivacySurveyConfig.class);
        } catch (Throwable e) {
            this.f2063a.b("inline_privacy_survey_deserialization", "Can't deserialize InlinePrivacySurveyConfig", e);
            m2149d();
        }
    }

    private void m2149d() {
        Builder builder = new Builder();
        builder.f3549a = false;
        builder = builder;
        builder.f3550b = null;
        builder = builder;
        builder.f3551c = null;
        builder = builder;
        builder.f3552d = null;
        m2146a(builder.m3940a());
    }
}

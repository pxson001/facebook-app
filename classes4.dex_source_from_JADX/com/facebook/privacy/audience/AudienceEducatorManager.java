package com.facebook.privacy.audience;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.protocol.FetchAudienceInfoModels$AudienceInfoFieldsModel;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams.AudienceAlignmentOnlyMeEvent;
import com.facebook.privacy.protocol.ReportAAATuxActionParams.AudienceAlignmentTuxEvent;
import com.facebook.privacy.protocol.ReportNASActionParams.NewcomerAudienceSelectorEvent;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_nux_complete */
public class AudienceEducatorManager {
    private static volatile AudienceEducatorManager f2048n;
    public String f2049a;
    public final FbSharedPreferences f2050b;
    private final InlinePrivacySurveyManager f2051c;
    private final Lazy<PrivacyOperationsClient> f2052d;
    public final Lazy<Clock> f2053e;
    public final Lazy<FbErrorReporter> f2054f;
    public boolean f2055g = false;
    public boolean f2056h = false;
    private boolean f2057i;
    public GraphQLPrivacyOption f2058j;
    public GraphQLPrivacyOption f2059k;
    public GraphQLPrivacyOption f2060l;
    public ImmutableMap<AudienceEducatorType, AudienceEducatorStateTracker> f2061m = new Builder().b(AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR, new AudienceAlignmentStateTracker(this)).b(AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR, new AudienceAlignmentOnlyMeStateTracker(this)).b(AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR, new NewcomerAudienceStateTracker(this)).b();

    /* compiled from: sms_nux_complete */
    public enum AudienceEducatorType {
        AUDIENCE_ALIGNMENT_EDUCATOR,
        AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR,
        NEWCOMER_AUDIENCE_EDUCATOR,
        INLINE_PRIVACY_SURVEY,
        NONE
    }

    /* compiled from: sms_nux_complete */
    class AudienceAlignmentStateTracker implements AudienceEducatorStateTracker {
        final /* synthetic */ AudienceEducatorManager f2071a;

        public AudienceAlignmentStateTracker(AudienceEducatorManager audienceEducatorManager) {
            this.f2071a = audienceEducatorManager;
        }

        public final boolean mo144a() {
            return this.f2071a.f2050b.a(PrivacyPrefKeys.f2166h, false);
        }

        public final boolean mo145b() {
            return false;
        }

        public final boolean mo146c() {
            return true;
        }

        public final void mo147d() {
            this.f2071a.f2050b.edit().putBoolean(PrivacyPrefKeys.f2166h, false).commit();
        }
    }

    /* compiled from: sms_nux_complete */
    public interface AudienceEducatorStateTracker {
        boolean mo144a();

        boolean mo145b();

        boolean mo146c();

        void mo147d();
    }

    /* compiled from: sms_nux_complete */
    class AudienceAlignmentOnlyMeStateTracker implements AudienceEducatorStateTracker {
        final /* synthetic */ AudienceEducatorManager f2074a;

        public AudienceAlignmentOnlyMeStateTracker(AudienceEducatorManager audienceEducatorManager) {
            this.f2074a = audienceEducatorManager;
        }

        public final boolean mo144a() {
            return this.f2074a.f2050b.a(PrivacyPrefKeys.f2167i, false);
        }

        public final boolean mo145b() {
            return false;
        }

        public final boolean mo146c() {
            return true;
        }

        public final void mo147d() {
            this.f2074a.f2050b.edit().putBoolean(PrivacyPrefKeys.f2167i, false).commit();
        }
    }

    /* compiled from: sms_nux_complete */
    public class NewcomerAudienceStateTracker implements AudienceEducatorStateTracker {
        public final /* synthetic */ AudienceEducatorManager f2075a;

        public NewcomerAudienceStateTracker(AudienceEducatorManager audienceEducatorManager) {
            this.f2075a = audienceEducatorManager;
        }

        public final boolean mo145b() {
            return false;
        }

        public final boolean mo146c() {
            return true;
        }

        public final boolean mo144a() {
            if (this.f2075a.f2050b.a(PrivacyPrefKeys.f2168j, false)) {
                if ((this.f2075a.f2050b.a(PrivacyPrefKeys.f2169k, 0) != 0 ? 1 : null) == null) {
                    return true;
                }
            }
            return false;
        }

        public final void mo147d() {
            this.f2075a.f2050b.edit().a(PrivacyPrefKeys.f2169k, ((Clock) this.f2075a.f2053e.get()).a()).commit();
        }
    }

    public static com.facebook.privacy.audience.AudienceEducatorManager m2134a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2048n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.audience.AudienceEducatorManager.class;
        monitor-enter(r1);
        r0 = f2048n;	 Catch:{ all -> 0x003a }
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
        r0 = m2135b(r0);	 Catch:{ all -> 0x0035 }
        f2048n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2048n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.audience.AudienceEducatorManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.audience.AudienceEducatorManager");
    }

    private static AudienceEducatorManager m2135b(InjectorLike injectorLike) {
        return new AudienceEducatorManager((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InlinePrivacySurveyManager.m2145a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9683), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    AudienceEducatorManager(FbSharedPreferences fbSharedPreferences, InlinePrivacySurveyManager inlinePrivacySurveyManager, Lazy<PrivacyOperationsClient> lazy, Lazy<Clock> lazy2, Lazy<FbErrorReporter> lazy3) {
        this.f2050b = fbSharedPreferences;
        this.f2051c = inlinePrivacySurveyManager;
        this.f2052d = lazy;
        this.f2053e = lazy2;
        this.f2054f = lazy3;
    }

    public final void m2140a(String str) {
        if (!Objects.equal(str, this.f2049a)) {
            this.f2049a = str;
            this.f2057i = false;
        }
    }

    public final boolean m2143b(String str) {
        return Objects.equal(this.f2049a, str);
    }

    public final boolean m2142b(AudienceEducatorType audienceEducatorType) {
        AudienceEducatorStateTracker audienceEducatorStateTracker = (AudienceEducatorStateTracker) this.f2061m.get(audienceEducatorType);
        if (audienceEducatorStateTracker == null) {
            return false;
        }
        return audienceEducatorStateTracker.mo144a();
    }

    public final boolean m2144c(AudienceEducatorType audienceEducatorType) {
        AudienceEducatorStateTracker audienceEducatorStateTracker = (AudienceEducatorStateTracker) this.f2061m.get(audienceEducatorType);
        if (audienceEducatorStateTracker == null) {
            return false;
        }
        return audienceEducatorStateTracker.mo145b();
    }

    public final void m2136a(FetchAudienceInfoModels$AudienceInfoFieldsModel fetchAudienceInfoModels$AudienceInfoFieldsModel) {
        if (fetchAudienceInfoModels$AudienceInfoFieldsModel != null) {
            this.f2050b.edit().putBoolean(PrivacyPrefKeys.f2168j, fetchAudienceInfoModels$AudienceInfoFieldsModel.m2315k()).putBoolean(PrivacyPrefKeys.f2172n, fetchAudienceInfoModels$AudienceInfoFieldsModel.m2316l()).a(PrivacyPrefKeys.f2171m).commit();
        }
    }

    public final void m2141b(FetchAudienceInfoModels$AudienceInfoFieldsModel fetchAudienceInfoModels$AudienceInfoFieldsModel) {
        if (fetchAudienceInfoModels$AudienceInfoFieldsModel != null) {
            m2136a(fetchAudienceInfoModels$AudienceInfoFieldsModel);
            this.f2050b.edit().putBoolean(PrivacyPrefKeys.f2166h, fetchAudienceInfoModels$AudienceInfoFieldsModel.m2313a()).putBoolean(PrivacyPrefKeys.f2167i, fetchAudienceInfoModels$AudienceInfoFieldsModel.m2314j()).commit();
            this.f2051c.m2151a(fetchAudienceInfoModels$AudienceInfoFieldsModel.m2317m());
        }
    }

    public final void m2138a(AudienceAlignmentTuxEvent audienceAlignmentTuxEvent, String str) {
        if (audienceAlignmentTuxEvent == AudienceAlignmentTuxEvent.EXPOSED) {
            if (!this.f2057i) {
                this.f2057i = true;
            } else {
                return;
            }
        }
        ((PrivacyOperationsClient) this.f2052d.get()).a(audienceAlignmentTuxEvent, ((Clock) this.f2053e.get()).a() / 1000, str);
    }

    public final void m2137a(AudienceAlignmentOnlyMeEvent audienceAlignmentOnlyMeEvent, String str) {
        if (audienceAlignmentOnlyMeEvent == AudienceAlignmentOnlyMeEvent.EXPOSED) {
            if (!this.f2057i) {
                this.f2057i = true;
            } else {
                return;
            }
        }
        ((PrivacyOperationsClient) this.f2052d.get()).a(audienceAlignmentOnlyMeEvent, ((Clock) this.f2053e.get()).a() / 1000, str);
    }

    public final void m2139a(NewcomerAudienceSelectorEvent newcomerAudienceSelectorEvent, String str) {
        if (newcomerAudienceSelectorEvent == NewcomerAudienceSelectorEvent.EXPOSED) {
            if (!this.f2057i) {
                this.f2057i = true;
            } else {
                return;
            }
        }
        ((PrivacyOperationsClient) this.f2052d.get()).a(newcomerAudienceSelectorEvent, ((Clock) this.f2053e.get()).a() / 1000, false, null, str);
    }
}

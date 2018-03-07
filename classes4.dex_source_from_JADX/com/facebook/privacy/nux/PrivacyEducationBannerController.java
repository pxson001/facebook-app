package com.facebook.privacy.nux;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.model.GraphQLPrivacyEducationInfo;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.protocol.SetPrivacyEducationStateParams.EducationStateOperation;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: report-request */
public class PrivacyEducationBannerController {
    private static volatile PrivacyEducationBannerController f3459j;
    private final Lazy<FbSharedPreferences> f3460a;
    private final Lazy<Clock> f3461b;
    private final Lazy<PrivacyOperationsClient> f3462c;
    private final Lazy<FbErrorReporter> f3463d;
    public final Lazy<PrivacyAnalyticsLogger> f3464e;
    private final Lazy<ObjectMapper> f3465f;
    private final Lazy<Resources> f3466g;
    private final Lazy<GlyphColorizer> f3467h;
    private PrivacyEducationBannerConfig f3468i;

    public static com.facebook.privacy.nux.PrivacyEducationBannerController m3707a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3459j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.nux.PrivacyEducationBannerController.class;
        monitor-enter(r1);
        r0 = f3459j;	 Catch:{ all -> 0x003a }
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
        r0 = m3712b(r0);	 Catch:{ all -> 0x0035 }
        f3459j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3459j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.nux.PrivacyEducationBannerController.a(com.facebook.inject.InjectorLike):com.facebook.privacy.nux.PrivacyEducationBannerController");
    }

    private static PrivacyEducationBannerController m3712b(InjectorLike injectorLike) {
        return new PrivacyEducationBannerController(IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 9683), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 3115), IdBasedSingletonScopeProvider.b(injectorLike, 572), IdBasedSingletonScopeProvider.b(injectorLike, 30), IdBasedSingletonScopeProvider.b(injectorLike, 1275));
    }

    @Inject
    public PrivacyEducationBannerController(Lazy<FbSharedPreferences> lazy, Lazy<Clock> lazy2, Lazy<PrivacyOperationsClient> lazy3, Lazy<FbErrorReporter> lazy4, Lazy<PrivacyAnalyticsLogger> lazy5, Lazy<ObjectMapper> lazy6, Lazy<Resources> lazy7, Lazy<GlyphColorizer> lazy8) {
        this.f3460a = lazy;
        this.f3461b = lazy2;
        this.f3462c = lazy3;
        this.f3463d = lazy4;
        this.f3464e = lazy5;
        this.f3465f = lazy6;
        this.f3466g = lazy7;
        this.f3467h = lazy8;
    }

    private static String m3708a(String str) {
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str));
    }

    public final EducationInfo m3715a(GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo) {
        if (graphQLPrivacyEducationInfo.k() != null && graphQLPrivacyEducationInfo.k().j()) {
            return new EducationInfo(this, EducationType.ReshareEducation, ((Resources) this.f3466g.get()).getString(2131234239), graphQLPrivacyEducationInfo.k().a(), ((Resources) this.f3466g.get()).getString(2131230747), m3708a("https://m.facebook.com/help/mobile-touch/569567333138410"), graphQLPrivacyEducationInfo.k().k(), ((GlyphColorizer) this.f3467h.get()).a(2130840086, ((Resources) this.f3466g.get()).getColor(2131361920)), ((GlyphColorizer) this.f3467h.get()).a(2130840086, ((Resources) this.f3466g.get()).getColor(2131361917)));
        } else if (graphQLPrivacyEducationInfo.l() != null && graphQLPrivacyEducationInfo.l().j()) {
            return new EducationInfo(this, EducationType.TagExpansionEducation, ((Resources) this.f3466g.get()).getString(2131234240), graphQLPrivacyEducationInfo.l().a(), ((Resources) this.f3466g.get()).getString(2131234242), FBLinks.cI, graphQLPrivacyEducationInfo.l().k(), ((GlyphColorizer) this.f3467h.get()).a(2130840122, ((Resources) this.f3466g.get()).getColor(2131361920)), ((GlyphColorizer) this.f3467h.get()).a(2130840122, ((Resources) this.f3466g.get()).getColor(2131361917)));
        } else if (graphQLPrivacyEducationInfo.a() != null && graphQLPrivacyEducationInfo.a().j()) {
            return new EducationInfo(this, EducationType.FullIndexEducation, ((Resources) this.f3466g.get()).getString(2131234241), graphQLPrivacyEducationInfo.a().a(), ((Resources) this.f3466g.get()).getString(2131230747), m3708a(graphQLPrivacyEducationInfo.a().k()), graphQLPrivacyEducationInfo.a().l(), ((GlyphColorizer) this.f3467h.get()).a(2130839905, ((Resources) this.f3466g.get()).getColor(2131361920)), ((GlyphColorizer) this.f3467h.get()).a(2130839905, ((Resources) this.f3466g.get()).getColor(2131361917)));
        } else if (graphQLPrivacyEducationInfo.m() == null || !graphQLPrivacyEducationInfo.m().j()) {
            return null;
        } else {
            return new EducationInfo(this, EducationType.GroupMallAdsEducation, ((Resources) this.f3466g.get()).getString(2131234250), graphQLPrivacyEducationInfo.m().a(), "", "", graphQLPrivacyEducationInfo.m().k(), ((GlyphColorizer) this.f3467h.get()).a(2130839943, ((Resources) this.f3466g.get()).getColor(2131361920)), ((GlyphColorizer) this.f3467h.get()).a(2130839943, ((Resources) this.f3466g.get()).getColor(2131361917)));
        }
    }

    public final void m3716a(EducationType educationType, boolean z) {
        if (!z && m3718b(educationType)) {
            m3709a(educationType, EducationStateOperation.Dismissed);
            m3711b().a(educationType, z);
            m3714c();
        }
    }

    public final void m3717b(EducationType educationType, boolean z) {
        if (z) {
            m3711b().a(educationType, m3713c(educationType) + 1);
            m3714c();
            m3709a(educationType, EducationStateOperation.Seen);
            return;
        }
        ((PrivacyAnalyticsLogger) this.f3464e.get()).m2370b("permalink", educationType.toString());
    }

    public static boolean m3710a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return false;
        }
        GraphQLPrivacyScope c = GraphQLStoryHelper.c(graphQLStory);
        boolean z = (c == null || c.k() == null) ? false : true;
        if (!z) {
            return false;
        }
        if (c.k().k() == null || !c.k().k().j()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        if (c.k().l() == null || !c.k().l().j()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        if (c.k().a() == null || !c.k().a().j()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        if (c.k().m() == null || !c.k().m().j()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    private int m3713c(EducationType educationType) {
        return m3711b().a(educationType);
    }

    public final boolean m3718b(EducationType educationType) {
        return m3711b().b(educationType);
    }

    private void m3709a(EducationType educationType, EducationStateOperation educationStateOperation) {
        ((PrivacyOperationsClient) this.f3462c.get()).a(educationType.toString(), educationStateOperation, Long.valueOf(((Clock) this.f3461b.get()).a() / 1000));
    }

    private PrivacyEducationBannerConfig m3711b() {
        if (this.f3468i != null) {
            return this.f3468i;
        }
        String a = ((FbSharedPreferences) this.f3460a.get()).a(PrivacyPrefKeys.f2165g, null);
        if (a == null) {
            this.f3468i = new PrivacyEducationBannerConfig();
        } else {
            try {
                this.f3468i = (PrivacyEducationBannerConfig) ((ObjectMapper) this.f3465f.get()).a(a, PrivacyEducationBannerConfig.class);
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f3463d.get()).b("privacy_education_banner_controller_deserialize_error", e);
                this.f3468i = new PrivacyEducationBannerConfig();
            }
        }
        return this.f3468i;
    }

    private void m3714c() {
        String a;
        try {
            a = ((ObjectMapper) this.f3465f.get()).a(m3711b());
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f3463d.get()).b("privacy_education_banner_controller_deserialize_error", e);
            a = null;
        }
        if (a != null) {
            ((FbSharedPreferences) this.f3460a.get()).edit().a(PrivacyPrefKeys.f2165g, a).commit();
        }
    }
}

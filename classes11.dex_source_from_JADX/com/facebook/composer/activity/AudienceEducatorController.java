package com.facebook.composer.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass38;
import com.facebook.composer.activity.ComposerFragment.C07573;
import com.facebook.composer.activity.ComposerFragment.C07584;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorAction;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorPrivacyType;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorStateTracker;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.facebook.privacy.educator.AudienceEducatorActivity;
import com.facebook.privacy.educator.AudienceEducatorTooltipGenerator;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams.AudienceAlignmentOnlyMeEvent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_facecast_nux_showing */
public class AudienceEducatorController {
    public WeakReference<ResultHandlerCallback> f5998a;
    public boolean f5999b = false;
    public final AudienceEducatorManager f6000c;
    private final FbNetworkManager f6001d;
    private final Lazy<FbErrorReporter> f6002e;
    public final Lazy<PrivacyOperationsClient> f6003f;
    private final Lazy<AudienceEducatorTooltipGenerator> f6004g;
    private final Lazy<Resources> f6005h;
    public Provider<TriState> f6006i;
    public Provider<TriState> f6007j;
    public Provider<TriState> f6008k;
    public Provider<TriState> f6009l;
    private QuickExperimentController f6010m;
    private WeakReference<DataProvider> f6011n;
    private ImmutableList<AudienceEducationEligibility> f6012o = ImmutableList.of(new NewcomerAudienceSelectorEligibility(this), new AudienceAlignmentAwarenessTUXEligibility(this), new AudienceAlignmentAwarenessTUXOnlyMeEligibility(this));

    /* compiled from: is_facecast_nux_showing */
    /* synthetic */ class C07541 {
        static final /* synthetic */ int[] f5994a = new int[AudienceEducatorAction.values().length];

        static {
            try {
                f5994a[AudienceEducatorAction.SET_PRIVACY_TO_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5994a[AudienceEducatorAction.OPEN_MORE_OPTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5994a[AudienceEducatorAction.SET_PRIVACY_TO_WIDEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5994a[AudienceEducatorAction.SET_PRIVACY_TO_ONLY_ME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5994a[AudienceEducatorAction.SET_PRIVACY_TO_OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: is_facecast_nux_showing */
    interface AudienceEducationEligibility {
        boolean mo179a();

        AudienceEducatorType mo180b();

        Class mo181c();
    }

    /* compiled from: is_facecast_nux_showing */
    class AudienceAlignmentAwarenessTUXEligibility implements AudienceEducationEligibility {
        final /* synthetic */ AudienceEducatorController f5995a;

        AudienceAlignmentAwarenessTUXEligibility(AudienceEducatorController audienceEducatorController) {
            this.f5995a = audienceEducatorController;
        }

        public final boolean mo179a() {
            if (!AudienceEducatorController.m7387a(this.f5995a, false)) {
                return false;
            }
            if (AudienceEducatorController.m7386a(this.f5995a, GraphQLPrivacyOptionType.EVERYONE) || ((TriState) this.f5995a.f6006i.get()).asBoolean(false)) {
                return this.f5995a.f6000c.b(mo180b()) && ((TriState) this.f5995a.f6008k.get()).asBoolean(false);
            } else {
                return false;
            }
        }

        public final AudienceEducatorType mo180b() {
            return AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR;
        }

        public final Class mo181c() {
            return AudienceEducatorActivity.class;
        }
    }

    /* compiled from: is_facecast_nux_showing */
    class AudienceAlignmentAwarenessTUXOnlyMeEligibility implements AudienceEducationEligibility {
        final /* synthetic */ AudienceEducatorController f5996a;

        AudienceAlignmentAwarenessTUXOnlyMeEligibility(AudienceEducatorController audienceEducatorController) {
            this.f5996a = audienceEducatorController;
        }

        public final boolean mo179a() {
            if (!AudienceEducatorController.m7387a(this.f5996a, true)) {
                return false;
            }
            if (!AudienceEducatorController.m7386a(this.f5996a, GraphQLPrivacyOptionType.ONLY_ME) && !((TriState) this.f5996a.f6006i.get()).asBoolean(false)) {
                return false;
            }
            if (!this.f5996a.f6000c.b(mo180b())) {
                return false;
            }
            if (((TriState) this.f5996a.f6009l.get()).asBoolean(false)) {
                return true;
            }
            return false;
        }

        public final AudienceEducatorType mo180b() {
            return AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR;
        }

        public final Class mo181c() {
            return AudienceEducatorActivity.class;
        }
    }

    /* compiled from: is_facecast_nux_showing */
    class NewcomerAudienceSelectorEligibility implements AudienceEducationEligibility {
        final /* synthetic */ AudienceEducatorController f5997a;

        NewcomerAudienceSelectorEligibility(AudienceEducatorController audienceEducatorController) {
            this.f5997a = audienceEducatorController;
        }

        public final boolean mo179a() {
            if (!AudienceEducatorController.m7387a(this.f5997a, false)) {
                return false;
            }
            if (AudienceEducatorController.m7386a(this.f5997a, GraphQLPrivacyOptionType.FRIENDS) || ((TriState) this.f5997a.f6006i.get()).asBoolean(false)) {
                return this.f5997a.f6000c.b(mo180b()) ? ((TriState) this.f5997a.f6007j.get()).asBoolean(false) : false;
            } else {
                return false;
            }
        }

        public final AudienceEducatorType mo180b() {
            return AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR;
        }

        public final Class mo181c() {
            return AudienceEducatorActivity.class;
        }
    }

    @Inject
    public AudienceEducatorController(AudienceEducatorManager audienceEducatorManager, FbNetworkManager fbNetworkManager, Lazy<FbErrorReporter> lazy, Lazy<PrivacyOperationsClient> lazy2, Lazy<AudienceEducatorTooltipGenerator> lazy3, Lazy<Resources> lazy4, Provider<TriState> provider, Provider<TriState> provider2, Provider<TriState> provider3, Provider<TriState> provider4, QuickExperimentController quickExperimentController, @Assisted DataProvider dataProvider) {
        this.f6000c = audienceEducatorManager;
        this.f6001d = fbNetworkManager;
        this.f6002e = lazy;
        this.f6003f = lazy2;
        this.f6004g = lazy3;
        this.f6005h = lazy4;
        this.f6006i = provider;
        this.f6007j = provider2;
        this.f6008k = provider3;
        this.f6009l = provider4;
        this.f6010m = quickExperimentController;
        this.f6011n = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    public final boolean m7393a(Context context, C07573 c07573) {
        if (this.f6000c.g) {
            return false;
        }
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
        if (anonymousClass38 == null) {
            return false;
        }
        AudienceEducationEligibility c = m7388c();
        if (c == null) {
            return false;
        }
        Object obj;
        this.f6000c.a(anonymousClass38.m7475a());
        AudienceEducatorManager audienceEducatorManager = this.f6000c;
        SelectablePrivacyData selectablePrivacyData = anonymousClass38.m7477e().b;
        audienceEducatorManager.j = selectablePrivacyData.a.a();
        audienceEducatorManager.k = selectablePrivacyData.a.a(GraphQLPrivacyOptionType.FRIENDS);
        audienceEducatorManager.l = selectablePrivacyData.a.a(GraphQLPrivacyOptionType.ONLY_ME);
        if (audienceEducatorManager.j == null || audienceEducatorManager.k == null || audienceEducatorManager.l == null) {
            ((AbstractFbErrorReporter) audienceEducatorManager.f.get()).b("audience_educator_manager_save_suggested", "Can't find option of type widest, friends, or only me.");
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return false;
        }
        Intent intent = new Intent(context, c.mo181c());
        AudienceEducatorType b = c.mo180b();
        boolean c2 = this.f6000c.c(c.mo180b());
        Builder builder = new Builder(c07573.f6071a.aS.az());
        builder.e = b;
        builder = builder;
        builder.h = c2;
        c07573.f6071a.aU.m7630b(ComposerFragment.cn).m7663a(builder.a()).m7689a();
        this.f6000c.g = true;
        intent.putExtra("extra_audience_educator_type", c.mo180b());
        intent.putExtra("audience_educator_source_extra", "traditional_composer");
        AudienceEducatorManager audienceEducatorManager2 = this.f6000c;
        AudienceEducatorType b2 = c.mo180b();
        if (((AudienceEducatorStateTracker) audienceEducatorManager2.m.get(b2)) == null) {
            ((AbstractFbErrorReporter) audienceEducatorManager2.f.get()).a("audience_educator_manager_activity_launch", "Adding data to intent for unrecognized educator type: " + b2.toString());
        }
        ((SecureContextHelper) c07573.f6071a.bP.get()).a(intent, 7, c07573.f6071a);
        c07573.f6071a.ao().overridePendingTransition(17432576, 17432577);
        return true;
    }

    private AudienceEducationEligibility m7388c() {
        if (!m7389d()) {
            return null;
        }
        int size = this.f6012o.size();
        for (int i = 0; i < size; i++) {
            AudienceEducationEligibility audienceEducationEligibility = (AudienceEducationEligibility) this.f6012o.get(i);
            if (audienceEducationEligibility.mo179a()) {
                return audienceEducationEligibility;
            }
        }
        return null;
    }

    public final void m7392a(int i, Intent intent, C07584 c07584) {
        GraphQLPrivacyOption graphQLPrivacyOption = null;
        boolean z = true;
        this.f6000c.g = false;
        if (i == -1) {
            this.f5998a = new WeakReference(c07584);
            if (intent.hasExtra("audience_educator_composer_action")) {
                ComposerAudienceEducatorData d;
                AudienceEducatorAction audienceEducatorAction = (AudienceEducatorAction) intent.getSerializableExtra("audience_educator_composer_action");
                AudienceEducatorPrivacyType audienceEducatorPrivacyType = (AudienceEducatorPrivacyType) intent.getSerializableExtra("audience_educator_privacy_type_extra");
                AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
                if (anonymousClass38 != null) {
                    d = anonymousClass38.m7476d();
                } else {
                    d = null;
                }
                if (d == null) {
                    ((AbstractFbErrorReporter) this.f6002e.get()).b("audience_educator_controller_no_educator_data", new StringBuilder("AudienceEducatorController: educator data is empty. ").append(anonymousClass38).toString() == null ? "Provider was null" : "Provider was not null");
                    return;
                }
                switch (C07541.f5994a[audienceEducatorAction.ordinal()]) {
                    case 1:
                        graphQLPrivacyOption = this.f6000c.k;
                        Preconditions.checkNotNull(graphQLPrivacyOption);
                        m7384a(c07584, audienceEducatorAction, graphQLPrivacyOption, audienceEducatorPrivacyType, d);
                        break;
                    case 2:
                        boolean z2;
                        ComposerFragment.bd(c07584.f6083a);
                        Builder a = c07584.f6083a.aS.az().a();
                        a.f = true;
                        c07584.f6083a.aU.m7630b(ComposerFragment.cn).m7663a(a.a()).m7689a();
                        if (this.f6000c.c(d.e)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.f5999b = true;
                        z = z2;
                        break;
                    case 3:
                        graphQLPrivacyOption = this.f6000c.j;
                        Preconditions.checkNotNull(graphQLPrivacyOption);
                        m7384a(c07584, audienceEducatorAction, graphQLPrivacyOption, audienceEducatorPrivacyType, d);
                        break;
                    case 4:
                        graphQLPrivacyOption = this.f6000c.l;
                        Preconditions.checkNotNull(graphQLPrivacyOption);
                        m7384a(c07584, audienceEducatorAction, graphQLPrivacyOption, audienceEducatorPrivacyType, d);
                        break;
                    case 5:
                        graphQLPrivacyOption = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option");
                        Preconditions.checkNotNull(graphQLPrivacyOption);
                        m7384a(c07584, audienceEducatorAction, graphQLPrivacyOption, audienceEducatorPrivacyType, d);
                        break;
                }
                m7385a(audienceEducatorAction, c07584, graphQLPrivacyOption);
                if (z) {
                    AudienceEducatorManager audienceEducatorManager = this.f6000c;
                    AudienceEducatorType audienceEducatorType = d.e;
                    if (((AudienceEducatorStateTracker) audienceEducatorManager.m.get(audienceEducatorType)) != null) {
                        ((AudienceEducatorStateTracker) audienceEducatorManager.m.get(audienceEducatorType)).d();
                    }
                    return;
                }
                return;
            }
            ((AbstractFbErrorReporter) this.f6002e.get()).b("audience_educator_controller_activity_result_missing_field", "AudienceEducatorActivity didn't have AUDIENCE_EDUCATOR_ACTION_EXTRA.");
        }
    }

    private void m7384a(C07584 c07584, AudienceEducatorAction audienceEducatorAction, GraphQLPrivacyOption graphQLPrivacyOption, AudienceEducatorPrivacyType audienceEducatorPrivacyType, ComposerAudienceEducatorData composerAudienceEducatorData) {
        if (audienceEducatorPrivacyType == AudienceEducatorPrivacyType.STICKY) {
            ((PrivacyOperationsClient) this.f6003f.get()).b(graphQLPrivacyOption);
        } else {
            ((PrivacyOperationsClient) this.f6003f.get()).c(graphQLPrivacyOption);
            this.f6000c.b.edit().putBoolean(PrivacyPrefKeys.m, true).commit();
        }
        ComposerFragment.m7539a(c07584.f6083a, graphQLPrivacyOption);
        Builder a = c07584.f6083a.aS.az().a();
        a.c = graphQLPrivacyOption.d();
        a = a;
        a.g = false;
        a = a;
        a.f = false;
        c07584.f6083a.aU.m7630b(ComposerFragment.cn).m7663a(a.a()).m7700d(false).m7689a();
    }

    private void m7385a(AudienceEducatorAction audienceEducatorAction, C07584 c07584, GraphQLPrivacyOption graphQLPrivacyOption) {
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
        if (anonymousClass38 != null) {
            String str;
            Map a = ((AudienceEducatorTooltipGenerator) this.f6004g.get()).m11664a(audienceEducatorAction, anonymousClass38.m7476d().e, graphQLPrivacyOption);
            String str2 = "";
            if (a.containsKey("tooltip_title")) {
                str = (String) a.get("tooltip_title");
            } else {
                str = str2;
            }
            str2 = "";
            if (a.containsKey("tooltip_body")) {
                str2 = (String) a.get("tooltip_body");
            }
            Builder a2 = c07584.f6083a.aS.az().a();
            a2.a = str;
            a2 = a2;
            a2.b = str2;
            c07584.f6083a.aU.m7630b(ComposerFragment.cn).m7663a(a2.a()).m7689a();
        }
    }

    public final void m7395b(@Nullable GraphQLPrivacyOption graphQLPrivacyOption) {
        if (this.f5998a != null && !this.f5999b) {
            C07584 c07584 = (C07584) this.f5998a.get();
            AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
            if (c07584 != null && anonymousClass38 != null) {
                ComposerAudienceEducatorData d = anonymousClass38.m7476d();
                if (d.f) {
                    boolean z;
                    AudienceEducatorManager audienceEducatorManager = this.f6000c;
                    AudienceEducatorStateTracker audienceEducatorStateTracker = (AudienceEducatorStateTracker) audienceEducatorManager.m.get(d.e);
                    if (audienceEducatorStateTracker == null) {
                        z = false;
                    } else {
                        z = audienceEducatorStateTracker.c();
                    }
                    if (z) {
                        if (graphQLPrivacyOption == null) {
                            ((AbstractFbErrorReporter) this.f6002e.get()).b("audience_educator_controller_null_selected_privacy", "Trying to set a privacy for this person but they don't have one!");
                        } else {
                            m7383a(c07584, graphQLPrivacyOption, d);
                            if (this.f6000c.h) {
                                this.f6000c.a(AudienceAlignmentOnlyMeEvent.CUSTOM_SELECTION, "traditional_composer");
                            }
                        }
                        this.f5998a.clear();
                    }
                }
                c07584.m7491a(d.e);
                this.f5998a.clear();
            }
        }
    }

    private void m7383a(C07584 c07584, GraphQLPrivacyOption graphQLPrivacyOption, ComposerAudienceEducatorData composerAudienceEducatorData) {
        m7384a(c07584, AudienceEducatorAction.CHOSE_OPTION_FROM_SELECTOR, graphQLPrivacyOption, AudienceEducatorPrivacyType.STICKY, composerAudienceEducatorData);
        c07584.m7491a(composerAudienceEducatorData.e);
    }

    public static boolean m7387a(AudienceEducatorController audienceEducatorController, boolean z) {
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) audienceEducatorController.f6011n.get();
        if (anonymousClass38 == null) {
            return false;
        }
        BooleanGetter booleanGetter = anonymousClass38.f6069a.aL.T;
        if (booleanGetter != null) {
            return z && booleanGetter.a();
        } else {
            return true;
        }
    }

    private boolean m7389d() {
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
        if (anonymousClass38 == null) {
            return false;
        }
        if (this.f6001d.d() && !this.f6000c.b(anonymousClass38.m7475a())) {
            Object obj = null;
            if (!(anonymousClass38.m7476d() == null || anonymousClass38.f6069a.aS.m7445w())) {
                obj = 1;
            }
            if (obj != null && m7390e()) {
                return true;
            }
        }
        return false;
    }

    private boolean m7390e() {
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) this.f6011n.get();
        if (anonymousClass38 == null) {
            return false;
        }
        ComposerPrivacyData e = anonymousClass38.m7477e();
        return (e == null || e.b == null || e.b.a == null || e.b.d == null || (!e.b.a.isResultFromServer && !anonymousClass38.m7476d().g && !anonymousClass38.f6069a.cV.m7747b())) ? false : true;
    }

    public static boolean m7386a(AudienceEducatorController audienceEducatorController, GraphQLPrivacyOptionType graphQLPrivacyOptionType) {
        if (!audienceEducatorController.m7390e()) {
            return false;
        }
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) audienceEducatorController.f6011n.get();
        if (anonymousClass38 == null) {
            return false;
        }
        return PrivacyOptionHelper.a(anonymousClass38.m7477e().b.d) == graphQLPrivacyOptionType;
    }

    public final void m7391a() {
        if (this.f6000c.h) {
            this.f6000c.a(AudienceAlignmentOnlyMeEvent.POSTED, null);
            this.f6000c.h = false;
        }
    }

    public final void m7394b() {
        this.f6000c.h = false;
    }
}

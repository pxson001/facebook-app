package com.facebook.composer.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.style.StyleSpan;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass27;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass28;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.Builder;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.TagExpansionExplanationType;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.facebook.privacy.audience.InlinePrivacySurveyConfig;
import com.facebook.privacy.audience.InlinePrivacySurveyLoggingController;
import com.facebook.privacy.audience.InlinePrivacySurveyManager;
import com.facebook.privacy.educator.InlinePrivacySurveyDialog;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams.InlinePrivacySurveyEvent;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: install/?file= */
public class InlinePrivacySurveyController {
    public String f6199a;
    public WeakReference<DataProvider> f6200b;
    public WeakReference<PostSurveyActions> f6201c;
    public InlinePrivacySurveyConfig f6202d;
    public boolean f6203e;
    private final AudienceEducatorManager f6204f;
    private final Context f6205g;
    private final AbstractFbErrorReporter f6206h;
    public final InlinePrivacySurveyLoggingController f6207i;
    private final InlinePrivacySurveyManager f6208j;
    private final Provider<TriState> f6209k;
    private final PrivacyAnalyticsLogger f6210l;
    private final C07701 f6211m = new C07701(this);

    /* compiled from: install/?file= */
    public class C07701 {
        public final /* synthetic */ InlinePrivacySurveyController f6191a;

        C07701(InlinePrivacySurveyController inlinePrivacySurveyController) {
            this.f6191a = inlinePrivacySurveyController;
        }
    }

    /* compiled from: install/?file= */
    public /* synthetic */ class C07734 {
        public static final /* synthetic */ int[] f6198a = new int[GraphQLPrivacyOptionTagExpansionType.values().length];

        static {
            try {
                f6198a[GraphQLPrivacyOptionTagExpansionType.TAGGEES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6198a[GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static InlinePrivacySurveyController m7639b(InjectorLike injectorLike) {
        return new InlinePrivacySurveyController(AudienceEducatorManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new InlinePrivacySurveyLoggingController((Clock) SystemClockMethodAutoProvider.a(injectorLike), PrivacyOperationsClient.a(injectorLike)), InlinePrivacySurveyManager.a(injectorLike), IdBasedProvider.a(injectorLike, 745), PrivacyAnalyticsLogger.b(injectorLike));
    }

    @Inject
    public InlinePrivacySurveyController(AudienceEducatorManager audienceEducatorManager, Context context, FbErrorReporter fbErrorReporter, InlinePrivacySurveyLoggingController inlinePrivacySurveyLoggingController, InlinePrivacySurveyManager inlinePrivacySurveyManager, Provider<TriState> provider, PrivacyAnalyticsLogger privacyAnalyticsLogger) {
        this.f6204f = audienceEducatorManager;
        this.f6205g = context;
        this.f6206h = fbErrorReporter;
        this.f6207i = inlinePrivacySurveyLoggingController;
        this.f6208j = inlinePrivacySurveyManager;
        this.f6209k = provider;
        this.f6210l = privacyAnalyticsLogger;
    }

    public final boolean m7643a() {
        Preconditions.checkNotNull(this.f6199a);
        Preconditions.checkNotNull(this.f6200b);
        if (!((TriState) this.f6209k.get()).asBoolean(false)) {
            return false;
        }
        this.f6202d = this.f6208j.a();
        if (this.f6202d == null || !this.f6202d.mEligible) {
            return false;
        }
        if (this.f6204f.b(this.f6199a)) {
            this.f6210l.a(Events.INLINE_PRIVACY_SURVEY_HIDE_TO_DEDUP);
            return false;
        }
        AnonymousClass27 c = m7640c();
        if (c == null) {
            return false;
        }
        return PrivacyOptionHelper.a(c.m7461a().d, this.f6202d.mTriggerPrivacyOption);
    }

    public final void m7644b() {
        Preconditions.checkNotNull(this.f6202d);
        Preconditions.checkNotNull(this.f6199a);
        Preconditions.checkNotNull(this.f6200b);
        Preconditions.checkNotNull(this.f6201c);
        final AnonymousClass27 c = m7640c();
        final AnonymousClass28 d = m7641d();
        if (c != null && d != null) {
            InlinePrivacySurveyDialog inlinePrivacySurveyDialog = new InlinePrivacySurveyDialog();
            inlinePrivacySurveyDialog.a(1, 2131626684);
            final InlinePrivacySurveyDialog inlinePrivacySurveyDialog2 = inlinePrivacySurveyDialog;
            inlinePrivacySurveyDialog2.ao = (C07701) Preconditions.checkNotNull(this.f6211m);
            inlinePrivacySurveyDialog2.ap = (C07712) Preconditions.checkNotNull(new Object(this) {
                public final /* synthetic */ InlinePrivacySurveyController f6195d;
            });
            inlinePrivacySurveyDialog2.a(((FragmentActivity) this.f6205g).kO_(), "inline_privacy_survey_dialog");
            this.f6207i.a(this.f6202d.mTriggerPrivacyOption, "traditional_composer");
            this.f6208j.b();
            this.f6204f.a(this.f6199a);
        }
    }

    public final void m7642a(GraphQLPrivacyOption graphQLPrivacyOption) {
        if (this.f6203e) {
            this.f6203e = false;
            this.f6207i.a(InlinePrivacySurveyEvent.CHOSE_OTHER_OPTION, this.f6202d.mTriggerPrivacyOption, graphQLPrivacyOption, "traditional_composer");
            AnonymousClass28 d = m7641d();
            Builder a = d.f6058a.aS.az().a();
            a.e = AudienceEducatorType.INLINE_PRIVACY_SURVEY;
            a = a;
            a.c = graphQLPrivacyOption.d();
            d.f6058a.aU.m7630b(ComposerFragment.cn).m7663a(a.a()).m7689a();
            d.f6058a.aU.m7627a(ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY, ComposerFragment.cn);
        }
    }

    public static void m7637a(InlinePrivacySurveyController inlinePrivacySurveyController, GraphQLPrivacyOption graphQLPrivacyOption, AnonymousClass27 anonymousClass27, final AnonymousClass28 anonymousClass28) {
        if (PrivacyOptionHelper.a(graphQLPrivacyOption, anonymousClass27.m7461a().d)) {
            inlinePrivacySurveyController.m7638a(graphQLPrivacyOption, new OnClickListener(inlinePrivacySurveyController) {
                final /* synthetic */ InlinePrivacySurveyController f6197b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    anonymousClass28.m7463a();
                }
            });
            return;
        }
        TagExpansionExplanationType tagExpansionExplanationType;
        AnonymousClass27 anonymousClass272 = (AnonymousClass27) inlinePrivacySurveyController.f6200b.get();
        if (anonymousClass272 == null || anonymousClass272.m7461a() == null || anonymousClass272.m7461a().a == null) {
            tagExpansionExplanationType = TagExpansionExplanationType.NONE;
        } else {
            GraphQLPrivacyOption a = anonymousClass272.m7461a().a.a(graphQLPrivacyOption);
            if (a == null) {
                tagExpansionExplanationType = TagExpansionExplanationType.NONE;
            } else {
                tagExpansionExplanationType = m7636a(anonymousClass272.m7462b(), anonymousClass272.m7461a().b, a.E_());
            }
        }
        TagExpansionExplanationType tagExpansionExplanationType2 = tagExpansionExplanationType;
        ComposerFragment.m7539a(anonymousClass28.f6058a, graphQLPrivacyOption);
        Builder a2 = anonymousClass28.f6058a.aS.az().a();
        a2.e = AudienceEducatorType.INLINE_PRIVACY_SURVEY;
        a2 = a2;
        a2.c = graphQLPrivacyOption.d();
        a2 = a2;
        a2.d = tagExpansionExplanationType2;
        anonymousClass28.f6058a.aU.m7630b(ComposerFragment.cn).m7663a(a2.a()).m7689a();
        anonymousClass28.f6058a.aU.m7627a(ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY, ComposerFragment.cn);
    }

    private void m7638a(GraphQLPrivacyOption graphQLPrivacyOption, OnClickListener onClickListener) {
        int i;
        AnonymousClass27 c = m7640c();
        CharSequence string = this.f6205g.getResources().getString(2131234735);
        if (c.m7462b()) {
            int i2;
            SelectablePrivacyData a = c.m7461a();
            switch (C07734.f6198a[a.d.E_().ordinal()]) {
                case 1:
                    i2 = 2131234738;
                    break;
                case 2:
                    if (!a.b) {
                        i2 = 2131234737;
                        break;
                    } else {
                        i2 = 2131234738;
                        break;
                    }
                default:
                    i2 = 2131234736;
                    break;
            }
            i = i2;
        } else {
            i = 2131234736;
        }
        new FbAlertDialogBuilder(this.f6205g).b(new StyledStringBuilder(this.f6205g.getResources()).a(string).a("\n\n").a(new StyleSpan(1), 33).a(this.f6205g.getResources().getString(i, new Object[]{graphQLPrivacyOption.d()})).a().b()).a(false).a(2131230756, onClickListener).b();
    }

    private AnonymousClass27 m7640c() {
        AnonymousClass27 anonymousClass27 = (AnonymousClass27) this.f6200b.get();
        if (anonymousClass27 != null) {
            return anonymousClass27;
        }
        this.f6206h.b("inline_privacy_survey_data_provider", "DataProvider is garbage collected. Double-check the caller to strongly reference the passed-in provider.");
        return null;
    }

    private AnonymousClass28 m7641d() {
        AnonymousClass28 anonymousClass28 = (AnonymousClass28) this.f6201c.get();
        if (anonymousClass28 != null) {
            return anonymousClass28;
        }
        this.f6206h.b("inline_privacy_survey_post_survey_actions", "PostSurveyActions is garbage collected. Double-check the caller to strongly reference the passed in callback.");
        return null;
    }

    public static TagExpansionExplanationType m7636a(boolean z, boolean z2, GraphQLPrivacyOptionTagExpansionType graphQLPrivacyOptionTagExpansionType) {
        if (!z) {
            return TagExpansionExplanationType.NONE;
        }
        if (graphQLPrivacyOptionTagExpansionType == GraphQLPrivacyOptionTagExpansionType.NONE || graphQLPrivacyOptionTagExpansionType == GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return TagExpansionExplanationType.NONE;
        }
        if (z2) {
            return TagExpansionExplanationType.TAGGEES;
        }
        return graphQLPrivacyOptionTagExpansionType == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES ? TagExpansionExplanationType.FRIENDS_OF_TAGGEES : TagExpansionExplanationType.TAGGEES;
    }
}

package com.facebook.composer.tip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.style.StyleSpan;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.39;
import com.facebook.composer.activity.ComposerFragment.7;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.ComposerStickyGuardrailConfig;
import com.facebook.privacy.audience.InlinePrivacySurveyConfig;
import com.facebook.privacy.audience.InlinePrivacySurveyManager;
import com.facebook.privacy.audience.StickyGuardrailManager;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.ReportStickyGuardrailActionParams.StickyGuardrailEvent;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composer_group_undefined_privacy */
public class StickyGuardrailInterstitialController implements ComposerTip {
    private final Resources f17037a;
    private final Lazy<StickyGuardrailManager> f17038b;
    public final InlinePrivacySurveyManager f17039c;
    public final PrivacyOperationsClient f17040d;
    private final Clock f17041e;
    private Context f17042f;
    private final AudienceEducatorManager f17043g;
    private final GatekeeperStoreImpl f17044h;
    public final Provider<TriState> f17045i;
    private 39 f17046j;
    public ComposerStickyGuardrailConfig f17047k;
    public boolean f17048l = false;
    public 7 f17049m;
    private AlertDialog f17050n;
    private final OnClickListener f17051o = new C13771(this);
    private final OnClickListener f17052p = new C13782(this);
    private final OnCancelListener f17053q = new C13793(this);

    /* compiled from: composer_group_undefined_privacy */
    class C13771 implements OnClickListener {
        final /* synthetic */ StickyGuardrailInterstitialController f17033a;

        C13771(StickyGuardrailInterstitialController stickyGuardrailInterstitialController) {
            this.f17033a = stickyGuardrailInterstitialController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            GraphQLPrivacyOption c = this.f17033a.f17047k.c();
            this.f17033a.f17040d.b(c);
            ComposerFragment.a(this.f17033a.f17049m.a, c);
            StickyGuardrailInterstitialController.m20982a(this.f17033a, StickyGuardrailEvent.ACCEPTED);
            StickyGuardrailInterstitialController.m20991n(this.f17033a);
        }
    }

    /* compiled from: composer_group_undefined_privacy */
    class C13782 implements OnClickListener {
        final /* synthetic */ StickyGuardrailInterstitialController f17034a;

        C13782(StickyGuardrailInterstitialController stickyGuardrailInterstitialController) {
            this.f17034a = stickyGuardrailInterstitialController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            StickyGuardrailInterstitialController.m20982a(this.f17034a, StickyGuardrailEvent.DECLINED);
            StickyGuardrailInterstitialController.m20991n(this.f17034a);
        }
    }

    /* compiled from: composer_group_undefined_privacy */
    class C13793 implements OnCancelListener {
        final /* synthetic */ StickyGuardrailInterstitialController f17035a;

        C13793(StickyGuardrailInterstitialController stickyGuardrailInterstitialController) {
            this.f17035a = stickyGuardrailInterstitialController;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (!this.f17035a.f17048l) {
                StickyGuardrailInterstitialController.m20982a(this.f17035a, StickyGuardrailEvent.DISMISSED);
                StickyGuardrailInterstitialController.m20991n(this.f17035a);
            }
        }
    }

    /* compiled from: composer_group_undefined_privacy */
    /* synthetic */ class C13804 {
        static final /* synthetic */ int[] f17036a = new int[ComposerEvent.values().length];

        static {
            try {
                f17036a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public StickyGuardrailInterstitialController(Resources resources, Lazy<StickyGuardrailManager> lazy, InlinePrivacySurveyManager inlinePrivacySurveyManager, PrivacyOperationsClient privacyOperationsClient, Clock clock, Context context, AudienceEducatorManager audienceEducatorManager, Provider<TriState> provider, GatekeeperStore gatekeeperStore, @Assisted DataProvider dataProvider, @Assisted StickyGuardrailCallback stickyGuardrailCallback) {
        this.f17037a = resources;
        this.f17038b = lazy;
        this.f17039c = inlinePrivacySurveyManager;
        this.f17040d = privacyOperationsClient;
        this.f17041e = clock;
        this.f17042f = context;
        this.f17043g = audienceEducatorManager;
        this.f17045i = provider;
        this.f17044h = gatekeeperStore;
        this.f17046j = dataProvider;
        this.f17049m = stickyGuardrailCallback;
    }

    public final void hG_() {
        this.f17048l = false;
        this.f17050n = new Builder(this.f17042f).a(m20986f()).b(m20987g()).b(this.f17037a.getString(2131234731), this.f17052p).a(this.f17037a.getString(2131234730), this.f17051o).a(this.f17053q).a();
        this.f17050n.show();
        m20982a(this, StickyGuardrailEvent.EXPOSED);
    }

    public final boolean hH_() {
        if (this.f17050n == null) {
            return false;
        }
        return this.f17050n.isShowing();
    }

    public final void m20993a() {
        if (this.f17050n != null) {
            this.f17050n.dismiss();
        }
        this.f17042f = null;
        this.f17046j = null;
        this.f17049m = null;
    }

    public final void m20994a(boolean z) {
        if (hH_()) {
            this.f17050n.hide();
        }
    }

    public final ComposerTip$Action m20992a(ComposerEvent composerEvent) {
        switch (C13804.f17036a[composerEvent.ordinal()]) {
            case 1:
                if (m20984d()) {
                    return ComposerTip$Action.SHOW;
                }
                break;
        }
        return ComposerTip$Action.NONE;
    }

    private boolean m20984d() {
        boolean z = false;
        if (!(hH_() || this.f17043g.g || !this.f17044h.a(ComposerGatekeepers.d, false))) {
            boolean z2;
            if (((TriState) this.f17045i.get()).asBoolean(false)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && m20988i() && m20989k()) {
                Object obj;
                InlinePrivacySurveyConfig a = this.f17039c.a();
                if (a == null || !a.mEligible) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    z = true;
                }
            }
        }
        if (z) {
            m20990m();
        }
        return z;
    }

    private boolean m20985e() {
        ComposerStickyGuardrailConfig a = this.f17047k != null ? this.f17047k : ((StickyGuardrailManager) this.f17038b.get()).a();
        return (a == null || a.b() == null || PrivacyOptionHelper.a(a.b()) != GraphQLPrivacyOptionType.ONLY_ME) ? false : true;
    }

    private CharSequence m20986f() {
        if (m20985e()) {
            return this.f17037a.getString(2131234726);
        }
        return this.f17037a.getString(2131234725, new Object[]{this.f17047k.c().d()});
    }

    private CharSequence m20987g() {
        return m20985e() ? new StyledStringBuilder(this.f17037a).a(2131234727).a("\n\n").a(2131234729).a("%1$s", this.f17047k.b().d(), new StyleSpan(1), 33).a("%2$s", this.f17047k.c().d(), new StyleSpan(1), 33).b() : new StyledStringBuilder(this.f17037a).a(2131234727).a("\n\n").a(2131234728).a("%1$s", this.f17047k.c().d(), new StyleSpan(1), 33).a("%2$s", this.f17047k.b().d(), new StyleSpan(1), 33).b();
    }

    private boolean m20988i() {
        ComposerStickyGuardrailConfig a = ((StickyGuardrailManager) this.f17038b.get()).a();
        if (!a.a() || a.mSuggestedPrivacyOption == null) {
            return false;
        }
        return m20983a(a);
    }

    private boolean m20983a(ComposerStickyGuardrailConfig composerStickyGuardrailConfig) {
        if (!(this.f17046j.b() == null || this.f17046j.b().f2001b == null || this.f17046j.b().f2001b.a == null || this.f17046j.b().f2001b.d == null || (!this.f17046j.b().f2001b.a.isResultFromServer && !this.f17046j.a.cV.b()))) {
            if (StringUtil.a(this.f17046j.b().f2001b.d.c(), composerStickyGuardrailConfig.b().c())) {
                if (!StringUtil.a(new CharSequence[]{composerStickyGuardrailConfig.b().d(), composerStickyGuardrailConfig.c().d()})) {
                    return true;
                }
            }
            ((StickyGuardrailManager) this.f17038b.get()).b();
            m20990m();
        }
        return false;
    }

    private boolean m20989k() {
        ComposerType composerType = this.f17046j.a.aS.o().getComposerType();
        if ((composerType == ComposerType.STATUS || (composerType == ComposerType.SHARE && m20985e())) && !this.f17046j.a.aS.w()) {
            return true;
        }
        return false;
    }

    private void m20990m() {
        this.f17047k = ((StickyGuardrailManager) this.f17038b.get()).a();
    }

    public static void m20991n(StickyGuardrailInterstitialController stickyGuardrailInterstitialController) {
        stickyGuardrailInterstitialController.f17048l = true;
        ((StickyGuardrailManager) stickyGuardrailInterstitialController.f17038b.get()).b();
        stickyGuardrailInterstitialController.m20990m();
        stickyGuardrailInterstitialController.f17049m.a.am.m21008a(Tip.INTERSTITIAL_NUX, true);
    }

    public static void m20982a(StickyGuardrailInterstitialController stickyGuardrailInterstitialController, StickyGuardrailEvent stickyGuardrailEvent) {
        stickyGuardrailInterstitialController.f17040d.a(stickyGuardrailEvent, Long.valueOf(stickyGuardrailInterstitialController.f17041e.a() / 1000), Long.valueOf(stickyGuardrailInterstitialController.f17047k.d()), stickyGuardrailInterstitialController.f17047k.b() != null ? stickyGuardrailInterstitialController.f17047k.b().c() : null, stickyGuardrailInterstitialController.f17047k.c() != null ? stickyGuardrailInterstitialController.f17047k.c().c() : null);
    }
}

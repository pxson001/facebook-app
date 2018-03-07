package com.facebook.privacy.audience;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams.StickyUpsellEvent;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams.StickyUpsellSurface;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetchPost */
public class PostPrivacyUpsellDialogController {
    public final Resources f14981a;
    public final PrivacyOperationsClient f14982b;
    private final QuickExperimentController f14983c;
    public final AbstractFbErrorReporter f14984d;
    private final FbNetworkManager f14985e;
    private final Provider<TriState> f14986f;
    private final Provider<TriState> f14987g;
    private final Clock f14988h;
    public GraphQLPrivacyOption f14989i;
    public EntryPoint f14990j;
    public boolean f14991k = false;
    public final OnCancelListener f14992l = new C10011(this);
    public final OnClickListener f14993m = new C10022(this);
    public final OnClickListener f14994n = new C10033(this);
    private final String f14995o = "post_privacy_upsell_dialog_controller";

    /* compiled from: fetchPost */
    class C10011 implements OnCancelListener {
        final /* synthetic */ PostPrivacyUpsellDialogController f14977a;

        C10011(PostPrivacyUpsellDialogController postPrivacyUpsellDialogController) {
            this.f14977a = postPrivacyUpsellDialogController;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (!this.f14977a.f14991k) {
                PostPrivacyUpsellDialogController.m22584a(this.f14977a, StickyUpsellEvent.DISMISSED);
            }
        }
    }

    /* compiled from: fetchPost */
    class C10022 implements OnClickListener {
        final /* synthetic */ PostPrivacyUpsellDialogController f14978a;

        C10022(PostPrivacyUpsellDialogController postPrivacyUpsellDialogController) {
            this.f14978a = postPrivacyUpsellDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PostPrivacyUpsellDialogController.m22584a(this.f14978a, StickyUpsellEvent.ACCEPTED);
            this.f14978a.f14982b.m22566b(this.f14978a.f14989i);
        }
    }

    /* compiled from: fetchPost */
    class C10033 implements OnClickListener {
        final /* synthetic */ PostPrivacyUpsellDialogController f14979a;

        C10033(PostPrivacyUpsellDialogController postPrivacyUpsellDialogController) {
            this.f14979a = postPrivacyUpsellDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PostPrivacyUpsellDialogController.m22584a(this.f14979a, StickyUpsellEvent.DECLINED);
        }
    }

    /* compiled from: fetchPost */
    public /* synthetic */ class C10044 {
        public static final /* synthetic */ int[] f14980a = new int[EntryPoint.values().length];

        static {
            try {
                f14980a[EntryPoint.NEWSFEED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14980a[EntryPoint.TIMELINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14980a[EntryPoint.PERMALINK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public PostPrivacyUpsellDialogController(Resources resources, PrivacyOperationsClient privacyOperationsClient, QuickExperimentController quickExperimentController, FbErrorReporter fbErrorReporter, FbNetworkManager fbNetworkManager, Provider<TriState> provider, Provider<TriState> provider2, Clock clock) {
        this.f14981a = resources;
        this.f14982b = privacyOperationsClient;
        this.f14983c = quickExperimentController;
        this.f14984d = fbErrorReporter;
        this.f14985e = fbNetworkManager;
        this.f14986f = provider;
        this.f14987g = provider2;
        this.f14988h = clock;
    }

    public final void m22585a(Context context, ViewGroup viewGroup, GraphQLPrivacyOption graphQLPrivacyOption, EntryPoint entryPoint) {
        this.f14990j = entryPoint;
        if (graphQLPrivacyOption == null) {
            this.f14984d.a("post_privacy_upsell_dialog_controller", "null suggested privacy passed to Post Privacy Upsell.");
        } else if (viewGroup == null) {
            this.f14984d.a("post_privacy_upsell_dialog_controller", "null parentView passed in, not showing dialog.");
        } else {
            if (StringUtil.a(new CharSequence[]{graphQLPrivacyOption.d()})) {
                this.f14984d.a("post_privacy_upsell_dialog_controller", "privacy option passed to upsell is missing name");
            } else if (this.f14985e.d() && !((TriState) this.f14986f.get()).asBoolean(false) && ((TriState) this.f14987g.get()).asBoolean(false)) {
                this.f14989i = graphQLPrivacyOption;
                this.f14991k = false;
                new Builder(context).a(new StyledStringBuilder(this.f14981a).a(2131234247).a("%1$s", this.f14989i.d(), new StyleSpan(1), 33).b()).b(new StyledStringBuilder(this.f14981a).a(2131234248).a("%1$s", this.f14989i.d(), new StyleSpan(1), 33).b()).b(this.f14981a.getString(2131234246), this.f14994n).a(this.f14981a.getString(2131234249), this.f14993m).a(this.f14992l).a().show();
                m22584a(this, StickyUpsellEvent.EXPOSED);
            }
        }
    }

    public static void m22584a(PostPrivacyUpsellDialogController postPrivacyUpsellDialogController, StickyUpsellEvent stickyUpsellEvent) {
        String c;
        StickyUpsellSurface stickyUpsellSurface;
        PrivacyOperationsClient privacyOperationsClient = postPrivacyUpsellDialogController.f14982b;
        Long valueOf = Long.valueOf(postPrivacyUpsellDialogController.f14988h.a());
        if (postPrivacyUpsellDialogController.f14989i != null) {
            c = postPrivacyUpsellDialogController.f14989i.c();
        } else {
            c = null;
        }
        switch (C10044.f14980a[postPrivacyUpsellDialogController.f14990j.ordinal()]) {
            case 1:
                stickyUpsellSurface = StickyUpsellSurface.NEWSFEED;
                break;
            case 2:
                stickyUpsellSurface = StickyUpsellSurface.TIMELINE;
                break;
            case 3:
                stickyUpsellSurface = StickyUpsellSurface.PERMALINK;
                break;
            default:
                postPrivacyUpsellDialogController.f14984d.b("post_privacy_upsell_dialog_controller", "Unable to convert surface to report param: " + postPrivacyUpsellDialogController.f14990j.name());
                stickyUpsellSurface = null;
                break;
        }
        privacyOperationsClient.m22558a(stickyUpsellEvent, valueOf, c, stickyUpsellSurface);
        if (stickyUpsellEvent == StickyUpsellEvent.CLOSED || stickyUpsellEvent == StickyUpsellEvent.DECLINED || stickyUpsellEvent == StickyUpsellEvent.DISMISSED || stickyUpsellEvent == StickyUpsellEvent.ACCEPTED) {
            postPrivacyUpsellDialogController.f14991k = true;
        }
    }
}

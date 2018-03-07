package com.facebook.greetingcards.create;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCardGraphQL.FetchPrefilledGreetingCardQueryString;
import com.facebook.greetingcards.model.GreetingCardGraphQLModels.FetchPrefilledGreetingCardQueryModel;
import com.facebook.greetingcards.render.FoldingPopoverFragment;
import com.facebook.greetingcards.render.GreetingCardPopoverFragment;
import com.facebook.greetingcards.render.RenderCardFragment;
import com.facebook.greetingcards.render.RenderCardFragment.AbstractRenderCardFragmentBuilder;
import com.facebook.greetingcards.render.SafelyDismissable;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.intent.SharePreview.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: {# */
public class PreviewCardFragment extends RenderCardFragment {
    public static final Class<?> f160c = PreviewCardFragment.class;
    private ComposerLauncher al;
    private BlueServiceFragment am;
    private PendingIntent an;
    private boolean ao = false;
    private NotificationManager f161d;
    public GraphQLQueryExecutor f162e;
    public SecureContextHelper f163f;
    public GraphQLImageHelper f164g;
    public AnalyticsLogger f165h;
    private GreetingCardUploadNotificationListenerProvider f166i;

    /* compiled from: {# */
    class C00281 implements VerveActionListener {
        final /* synthetic */ PreviewCardFragment f145a;

        C00281(PreviewCardFragment previewCardFragment) {
            this.f145a = previewCardFragment;
        }

        public final void m158a(VMAction vMAction, View view) {
            if ("button1".equals(vMAction.type)) {
                PreviewCardFragment.ax(this.f145a);
            } else if ("button2".equals(vMAction.type)) {
                RenderCardFragment renderCardFragment = this.f145a;
                renderCardFragment.f152a = GreetingCard.a(renderCardFragment.f152a);
                renderCardFragment.f165h.a(new HoneyClientEvent("greeting_card_edit").b("greeting_card_id", renderCardFragment.f152a.f));
                renderCardFragment.f163f.a(GreetingCardEditorActivity.m79a(renderCardFragment.getContext(), renderCardFragment.f152a), 7, renderCardFragment);
            }
        }
    }

    /* compiled from: {# */
    public class C00292 {
        public final /* synthetic */ PreviewCardFragment f146a;

        C00292(PreviewCardFragment previewCardFragment) {
            this.f146a = previewCardFragment;
        }
    }

    /* compiled from: {# */
    public class C00303 implements FutureCallback<GraphQLResult<FetchPrefilledGreetingCardQueryModel>> {
        final /* synthetic */ PreviewCardFragment f147a;

        public C00303(PreviewCardFragment previewCardFragment) {
            this.f147a = previewCardFragment;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(@javax.annotation.Nullable java.lang.Object r14) {
            /*
            r13 = this;
            r14 = (com.facebook.graphql.executor.GraphQLResult) r14;
            r2 = r14.e;
            r0 = r2;
            r0 = (com.facebook.greetingcards.model.GreetingCardGraphQLModels.FetchPrefilledGreetingCardQueryModel) r0;
            r0 = r0.a();
            r2 = 0;
            r8 = 0;
            r7 = com.google.common.collect.ImmutableList.builder();
            r3 = r0.j();
            r9 = r3.a();
            r10 = r9.size();
            r6 = r2;
            r4 = r2;
            r5 = r8;
            r3 = r8;
        L_0x0021:
            if (r6 >= r10) goto L_0x0058;
        L_0x0023:
            r2 = r9.get(r6);
            r2 = (com.facebook.greetingcards.model.GreetingCardGraphQLModels.PrefilledGreetingCardFieldsModel.SlidesModel.NodesModel) r2;
            r11 = r2.k();
            r12 = com.facebook.greetingcards.model.GreetingCardModelUtil.1.a;
            r11 = r11.ordinal();
            r11 = r12[r11];
            switch(r11) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0044;
                case 3: goto L_0x0052;
                default: goto L_0x0038;
            };
        L_0x0038:
            r2 = r4;
        L_0x0039:
            r4 = r6 + 1;
            r6 = r4;
            r4 = r2;
            goto L_0x0021;
        L_0x003e:
            r3 = com.facebook.greetingcards.model.GreetingCardModelUtil.a(r2);
            r2 = r4;
            goto L_0x0039;
        L_0x0044:
            r11 = 8;
            if (r4 >= r11) goto L_0x0038;
        L_0x0048:
            r2 = com.facebook.greetingcards.model.GreetingCardModelUtil.a(r2);
            r7.c(r2);
            r2 = r4 + 1;
            goto L_0x0039;
        L_0x0052:
            r5 = com.facebook.greetingcards.model.GreetingCardModelUtil.a(r2);
            r2 = r4;
            goto L_0x0039;
        L_0x0058:
            r2 = new com.facebook.greetingcards.model.GreetingCard;
            r4 = r7.b();
            r6 = r0.a();
            r6 = r6.j();
            r7 = r0.k();
            r2.<init>(r3, r4, r5, r6, r7, r8);
            r0 = r2;
            r1 = r13.f147a;
            r1.m175a(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.greetingcards.create.PreviewCardFragment.3.onSuccess(java.lang.Object):void");
        }

        public void onFailure(Throwable th) {
            BLog.b(PreviewCardFragment.f160c, "Failure loading prefilled card.");
        }
    }

    /* compiled from: {# */
    class C00314 implements OnClickListener {
        final /* synthetic */ PreviewCardFragment f148a;

        C00314(PreviewCardFragment previewCardFragment) {
            this.f148a = previewCardFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Fragment fragment = this.f148a.G;
            if (fragment instanceof FoldingPopoverFragment) {
                ((FoldingPopoverFragment) fragment).ar();
            } else if (fragment instanceof GreetingCardPopoverFragment) {
                ((GreetingCardPopoverFragment) fragment).a();
            }
        }
    }

    /* compiled from: {# */
    public class PreviewCardFragmentBuilder extends AbstractRenderCardFragmentBuilder<PreviewCardFragment> {
        public PreviewCardFragmentBuilder() {
            super(0);
        }

        protected final RenderCardFragment mo5a() {
            return new PreviewCardFragment();
        }
    }

    public static void m182a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PreviewCardFragment) obj).m180a(NotificationManagerMethodAutoProvider.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GraphQLImageHelper.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), (GreetingCardUploadNotificationListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GreetingCardUploadNotificationListenerProvider.class), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector));
    }

    @Inject
    private void m180a(NotificationManager notificationManager, GraphQLQueryExecutor graphQLQueryExecutor, SecureContextHelper secureContextHelper, GraphQLImageHelper graphQLImageHelper, AnalyticsLogger analyticsLogger, GreetingCardUploadNotificationListenerProvider greetingCardUploadNotificationListenerProvider, ComposerLauncher composerLauncher) {
        this.f161d = notificationManager;
        this.f162e = graphQLQueryExecutor;
        this.f163f = secureContextHelper;
        this.f164g = graphQLImageHelper;
        this.f165h = analyticsLogger;
        this.f166i = greetingCardUploadNotificationListenerProvider;
        this.al = composerLauncher;
    }

    public final void mo8c(Bundle bundle) {
        super.mo8c(bundle);
        Class cls = PreviewCardFragment.class;
        m182a(this, getContext());
        this.ap = new C00281(this);
        this.ao = new C00292(this);
        if (this.f152a == null) {
            GraphQlQueryString fetchPrefilledGreetingCardQueryString = new FetchPrefilledGreetingCardQueryString();
            fetchPrefilledGreetingCardQueryString.a("size_large", this.f164g.f()).a("size_medium", this.f164g.g());
            Futures.a(this.f162e.a(GraphQLRequest.a(fetchPrefilledGreetingCardQueryString).a(3600)), new C00303(this), this.f153b);
        }
        this.am = BlueServiceFragment.a(this.E.p(), "upload_card");
        this.an = PendingIntent.getActivity(o(), 0, new Intent(), 134217728);
    }

    public static void ax(PreviewCardFragment previewCardFragment) {
        String str;
        previewCardFragment.a = GreetingCard.a(previewCardFragment.f152a);
        previewCardFragment.f165h.a(new HoneyClientEvent("greeting_card_share").b("greeting_card_id", previewCardFragment.f152a.f).a("edited", previewCardFragment.ao));
        GreetingCard greetingCard = previewCardFragment.f152a;
        Builder builder = new Builder();
        builder.a = greetingCard.a.a;
        builder = builder;
        builder.b = greetingCard.c.b;
        builder = builder;
        if (greetingCard.a.c.isEmpty()) {
            str = null;
        } else {
            str = ((CardPhoto) greetingCard.a.c.get(0)).a.toString();
        }
        builder.d = str;
        SharePreview a = builder.a();
        ComposerConfiguration.Builder nectarModule = ComposerConfiguration.newBuilder().setComposerType(ComposerType.GREETING_CARD).setSourceType(ComposerSourceType.GREETING_CARD).setInitialText(GraphQLHelper.a(previewCardFragment.jW_().getString(2131241458))).setNectarModule("greeting_card_composer");
        ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a();
        a2.d = a;
        previewCardFragment.al.a(null, nectarModule.setInitialShareParams(a2.b()).setPluginConfig(new DefaultPluginConfigSerializer().a(Factory.f58a)).a(), 8, previewCardFragment);
    }

    public final void m183a(int i, int i2, Intent intent) {
        if (i == 8) {
            if (i2 == -1) {
                this.f165h.a(new HoneyClientEvent("greeting_share_completed").b("greeting_card_id", this.f152a.f));
                m181a((PublishPostParams) intent.getParcelableExtra("publishPostParams"));
                if (this.G != null && (this.G instanceof SafelyDismissable)) {
                    ((SafelyDismissable) this.G).aq();
                    return;
                }
                return;
            }
            this.f165h.a(new HoneyClientEvent("greeting_share_cancelled").b("greeting_card_id", this.f152a.f));
        } else if (i == 7 && i2 == -1) {
            this.ao = true;
            m175a((GreetingCard) intent.getParcelableExtra("args_greeting_card"));
        }
    }

    private void m181a(PublishPostParams publishPostParams) {
        GreetingCard greetingCard = this.f152a;
        NotificationCompat.Builder b = new NotificationCompat.Builder(getContext()).a(0, 0, true).a(jW_().getString(2131241462, new Object[]{greetingCard.a.a})).b(jW_().getString(2131241463));
        b.d = this.an;
        b = b.a(2130843532).a(true);
        this.f161d.notify(9, b.c());
        Bundle bundle = new Bundle();
        bundle.putParcelable("greeting_card", greetingCard);
        bundle.putParcelable("post_params", publishPostParams);
        this.am.a("upload_card", bundle);
        BlueServiceFragment blueServiceFragment = this.am;
        GreetingCardUploadNotificationListenerProvider greetingCardUploadNotificationListenerProvider = this.f166i;
        blueServiceFragment.b = new GreetingCardUploadNotificationListener((Context) greetingCardUploadNotificationListenerProvider.getInstance(Context.class), NotificationManagerMethodAutoProvider.b(greetingCardUploadNotificationListenerProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(greetingCardUploadNotificationListenerProvider), b);
    }

    public final boolean mo6e() {
        if (!this.ao) {
            return false;
        }
        new AlertDialog.Builder(getContext()).b(2131230727, null).a(2131241461, new C00314(this)).b(jW_().getString(2131241460)).b();
        return true;
    }

    public final String am_() {
        return "tinsel_preview_card";
    }
}

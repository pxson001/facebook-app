package com.facebook.backgroundlocation.nux;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxAnalyticsLogger.MoreInfoType;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxDataFetcher.C20641;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxDataFetcher.C20652;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxDataFetcher.C20663;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxDataFetcher.C20674;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQL.BackgroundLocationNowNuxQueryString;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQL.BackgroundLocationNuxInviterProfileQueryString;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLInterfaces.BackgroundLocationNowNuxQuery.Actor;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLInterfaces.BackgroundLocationNuxFriendsSharingLocation;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLModels.BackgroundLocationNowNuxQueryModel.ActorModel;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLModels.BackgroundLocationNuxFriendsSharingLocationModel;
import com.facebook.backgroundlocation.privacypicker.BackgroundLocationPrivacyPickerOptionsAdapter;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLInterfaces.BackgroundLocationPrivacyPickerOption;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLInterfaces.BackgroundLocationPrivacyPickerOptions;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionEdgeModel;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionModel;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionsModel;
import com.facebook.backgroundlocation.settings.write.BackgroundLocationUpdateSettingsParams;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellFacepileUtil;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellText;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SpannableStringFormatter;
import com.facebook.common.util.SpannableStringSubstitution;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverSpinner;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dogs */
public class BackgroundLocationOnePageNuxActivity extends FbFragmentActivity {
    public static final Class<?> f14791B = BackgroundLocationOnePageNuxActivity.class;
    public static final CallerContext f14792C = CallerContext.a(BackgroundLocationOnePageNuxActivity.class);
    private static final String f14793D = StringFormatUtil.a(FBLinks.ct, new Object[]{"/tour/locationsharing/learnmore"});
    @Inject
    TasksManager f14794A;
    private View f14795E;
    private View f14796F;
    private GlyphView f14797G;
    private TextView f14798H;
    public FacepileView f14799I;
    public View f14800J;
    public PopoverSpinner f14801K;
    private TextView f14802L;
    private Button f14803M;
    private Button f14804N;
    public ImageView f14805O;
    public TextView f14806P;
    public View f14807Q;
    public FbDraweeView f14808R;
    public TextView f14809S;
    public View f14810T;
    public boolean f14811U;
    private boolean f14812V;
    public BackgroundLocationUpsellProfileModel f14813W;
    private FutureAndCallbackHolder<Boolean> f14814X;
    public BackgroundLocationPrivacyPickerOptionModel f14815Y;
    public BackgroundLocationPrivacyPickerOptionsAdapter f14816Z;
    public final OnItemSelectedListener aa = new C20691(this);
    @Inject
    BackgroundLocationNuxDataFetcher f14817p;
    @Inject
    BackgroundLocationUpsellText f14818q;
    @Inject
    BackgroundLocationNuxStatusManager f14819r;
    @Inject
    BackgroundLocationNuxAnalyticsLogger f14820s;
    @Inject
    public DefaultBlueServiceOperationFactory f14821t;
    @Inject
    @ForUiThreadImmediate
    ExecutorService f14822u;
    @Inject
    FacebookOnlyIntentActionFactory f14823v;
    @Inject
    AbstractFbErrorReporter f14824w;
    @Inject
    FbUriIntentHandler f14825x;
    @Inject
    Toaster f14826y;
    @Inject
    SecureContextHelper f14827z;

    /* compiled from: dogs */
    class C20691 implements OnItemSelectedListener {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14776a;

        C20691(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14776a = backgroundLocationOnePageNuxActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            BackgroundLocationPrivacyPickerOptionModel b = BackgroundLocationOnePageNuxActivity.m15163b(this.f14776a, i);
            if (b != null) {
                this.f14776a.f14820s.m15115b(b);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: dogs */
    class C20702 implements OnClickListener {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14777a;

        C20702(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14777a = backgroundLocationOnePageNuxActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 965813789);
            BackgroundLocationPrivacyPickerOptionModel b = BackgroundLocationOnePageNuxActivity.m15163b(this.f14777a, this.f14777a.f14801K.getSelectedItemPosition());
            if (b == null) {
                this.f14777a.f14824w.a("background_location_one_page_nux_select_privacy_failure", "selected privacy option is empty");
                Logger.a(2, EntryType.UI_INPUT_END, 543677409, a);
                return;
            }
            this.f14777a.m15159a(b);
            this.f14777a.f14820s.m15113a(b);
            LogUtils.a(-1830221031, a);
        }
    }

    /* compiled from: dogs */
    class C20713 implements OnClickListener {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14778a;

        C20713(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14778a = backgroundLocationOnePageNuxActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 974331679);
            Preconditions.checkState(!this.f14778a.f14811U);
            BackgroundLocationOnePageNuxActivity.m15198r(this.f14778a);
            this.f14778a.f14820s.m15114b();
            LogUtils.a(-611241815, a);
        }
    }

    /* compiled from: dogs */
    class C20724 extends AbstractDisposableFutureCallback<Boolean> {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14779a;

        C20724(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14779a = backgroundLocationOnePageNuxActivity;
        }

        protected final void m15139a(Object obj) {
            Boolean bool = (Boolean) obj;
            this.f14779a.f14799I;
            this.f14779a.m15167b(bool.booleanValue());
        }

        protected final void m15140a(Throwable th) {
            BLog.b(BackgroundLocationOnePageNuxActivity.f14791B, "failed to get if should show traveling NUX", th);
            this.f14779a.f14824w.a("background_location_traveling_nux_should_show_traveling_nux_fetch_fail", th);
        }
    }

    /* compiled from: dogs */
    class C20735 extends AbstractDisposableFutureCallback<Actor> {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14780a;

        C20735(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14780a = backgroundLocationOnePageNuxActivity;
        }

        protected final void m15141a(@Nullable Object obj) {
            ActorModel actorModel = (ActorModel) obj;
            if (actorModel == null || actorModel.m15221b() == null || actorModel.m15221b().b() == null || actorModel.m15218a() == null) {
                this.f14780a.f14824w.a("background_location_traveling_nux_actor_info_abnormal", "traveling nux does not have profile pic uri or viewer name");
                return;
            }
            this.f14780a.f14808R.a(Uri.parse(actorModel.m15221b().b()), BackgroundLocationOnePageNuxActivity.f14792C);
            String a = (!this.f14780a.f14816Z || actorModel.m15222c() == null) ? actorModel.m15218a() : actorModel.m15222c();
            this.f14780a.f14809S.setText(this.f14780a.f14818q.m15571a(2131241844, a, 2131241845, 2131361973, 2131361917));
            this.f14780a.f14807Q.setVisibility(0);
            this.f14780a.f14810T.setVisibility(0);
        }

        protected final void m15142a(Throwable th) {
            BLog.b(BackgroundLocationOnePageNuxActivity.f14791B, "failed to get actor info", th);
            this.f14780a.f14824w.a("background_location_traveling_nux_actor_info_fetch_fail", th);
        }
    }

    /* compiled from: dogs */
    class C20746 extends AbstractDisposableFutureCallback<GraphQLResult<BackgroundLocationUpsellProfileModel>> {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14781a;

        C20746(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14781a = backgroundLocationOnePageNuxActivity;
        }

        protected final void m15143a(Object obj) {
            BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity = this.f14781a;
            if (graphQLResult == null) {
                backgroundLocationUpsellProfileModel = null;
            } else {
                backgroundLocationUpsellProfileModel = (BackgroundLocationUpsellProfileModel) graphQLResult.e;
            }
            backgroundLocationOnePageNuxActivity.f14813W = backgroundLocationUpsellProfileModel;
            this.f14781a.f14799I;
            this.f14781a.m15167b(false);
        }

        protected final void m15144a(Throwable th) {
            BLog.b(BackgroundLocationOnePageNuxActivity.f14791B, "failed to get inviter short name", th);
            this.f14781a.f14824w.a("background_location_notification_nux_inviter_short_name_fetch_fail", th);
        }
    }

    /* compiled from: dogs */
    class C20768 extends AbstractDisposableFutureCallback<BackgroundLocationPrivacyPickerOptions> {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14784a;

        C20768(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
            this.f14784a = backgroundLocationOnePageNuxActivity;
        }

        protected final void m15147a(Object obj) {
            BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel = null;
            ImmutableList a = ((BackgroundLocationPrivacyPickerOptionsModel) obj).m15321a();
            Builder builder = ImmutableList.builder();
            this.f14784a.f14815Y = null;
            int size = a.size();
            int i = 0;
            Object obj2 = null;
            while (i < size) {
                BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel2;
                BackgroundLocationPrivacyPickerOptionEdgeModel backgroundLocationPrivacyPickerOptionEdgeModel = (BackgroundLocationPrivacyPickerOptionEdgeModel) a.get(i);
                BackgroundLocationPrivacyPickerOptionModel c = backgroundLocationPrivacyPickerOptionEdgeModel.m15308c();
                builder.c(c);
                if (backgroundLocationPrivacyPickerOptionEdgeModel.m15306a()) {
                    this.f14784a.f14815Y = c;
                }
                if (backgroundLocationPrivacyPickerOptionEdgeModel.m15307b()) {
                    obj2 = c;
                }
                if ("friends".equals(c.m15315b().d())) {
                    backgroundLocationPrivacyPickerOptionModel2 = c;
                } else {
                    backgroundLocationPrivacyPickerOptionModel2 = backgroundLocationPrivacyPickerOptionModel;
                }
                i++;
                backgroundLocationPrivacyPickerOptionModel = backgroundLocationPrivacyPickerOptionModel2;
            }
            if (this.f14784a.f14811U && this.f14784a.f14815Y == null) {
                this.f14784a.f14824w.a("background_location_one_page_nux_status_abnormal", "informational nux does not have selected privacy option");
            }
            if (this.f14784a.f14815Y != null) {
                obj2 = this.f14784a.f14815Y;
            } else if (obj2 == null) {
                BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel3 = backgroundLocationPrivacyPickerOptionModel;
            }
            ImmutableList b = builder.b();
            this.f14784a.f14801K.setOnItemSelectedListener(this.f14784a.aa);
            this.f14784a.f14816Z = new BackgroundLocationPrivacyPickerOptionsAdapter();
            this.f14784a.f14816Z.f14852b = false;
            this.f14784a.f14816Z.m15299a(b);
            this.f14784a.f14801K.setAdapter(this.f14784a.f14816Z);
            int indexOf = b.indexOf(obj2);
            if (indexOf != -1) {
                this.f14784a.f14801K.setSelection(indexOf);
            }
            this.f14784a.f14800J.setVisibility(8);
            this.f14784a.f14801K.setVisibility(0);
        }

        protected final void m15148a(Throwable th) {
            BLog.b(BackgroundLocationOnePageNuxActivity.f14791B, "failed to get privacy options", th);
            this.f14784a.f14824w.a("background_location_one_page_nux_privacy_data_fetch_fail", th);
            this.f14784a.f14826y.a(new ToastBuilder(2131230758));
        }
    }

    /* compiled from: dogs */
    class LinkSpan extends ClickableSpan {
        final /* synthetic */ BackgroundLocationOnePageNuxActivity f14788a;
        private final String f14789b;
        private final MoreInfoType f14790c;

        public LinkSpan(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity, String str, MoreInfoType moreInfoType) {
            this.f14788a = backgroundLocationOnePageNuxActivity;
            this.f14789b = str;
            this.f14790c = moreInfoType;
        }

        public void onClick(View view) {
            this.f14788a.f14825x.a(this.f14788a, this.f14789b);
            this.f14788a.f14820s.m15112a(this.f14790c);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    private static <T extends Context> void m15160a(Class<T> cls, T t) {
        m15161a((Object) t, (Context) t);
    }

    public static void m15161a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackgroundLocationOnePageNuxActivity) obj).m15156a(BackgroundLocationNuxDataFetcher.m15117a(injectorLike), BackgroundLocationUpsellText.m15563a(injectorLike), BackgroundLocationNuxStatusManager.m15132a(injectorLike), BackgroundLocationNuxAnalyticsLogger.m15109a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), Toaster.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.b(injectorLike));
    }

    protected final void m15201b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = BackgroundLocationOnePageNuxActivity.class;
        m15161a((Object) this, (Context) this);
        getWindow().setFlags(1024, 1024);
        this.f14811U = getIntent().getBooleanExtra("informational", false);
        String stringExtra = getIntent().getStringExtra("source");
        boolean z = stringExtra != null && stringExtra.startsWith("notification");
        this.f14812V = z;
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        ImmutableLocation a = backgroundLocationNuxDataFetcher.f14752b.a();
        GraphQlQueryString backgroundLocationNowNuxQueryString = new BackgroundLocationNowNuxQueryString();
        backgroundLocationNowNuxQueryString.a("image_scale", GraphQlQueryDefaults.a());
        backgroundLocationNowNuxQueryString.a("image_size", Integer.valueOf(64));
        backgroundLocationNowNuxQueryString.a("n_upsell_results", Integer.valueOf(11));
        if (a != null) {
            backgroundLocationNowNuxQueryString.a("viewer_latitude", Double.valueOf(a.a()));
            backgroundLocationNowNuxQueryString.a("viewer_longitude", Double.valueOf(a.b()));
        }
        backgroundLocationNuxDataFetcher.f14754d = backgroundLocationNuxDataFetcher.f14751a.a(GraphQLRequest.a(backgroundLocationNowNuxQueryString));
        setContentView(2130903340);
        this.f14795E = a(2131559810);
        this.f14796F = a(2131559802);
        this.f14797G = (GlyphView) a(2131559812);
        this.f14798H = (TextView) a(2131559813);
        this.f14805O = (ImageView) a(2131559803);
        this.f14806P = (TextView) a(2131559804);
        this.f14807Q = a(2131559805);
        this.f14808R = (FbDraweeView) a(2131559806);
        this.f14809S = (TextView) a(2131559807);
        this.f14810T = a(2131559808);
        this.f14799I = (FacepileView) a(2131559809);
        this.f14800J = a(2131559797);
        this.f14801K = (PopoverSpinner) a(2131559798);
        this.f14802L = (TextView) a(2131559799);
        this.f14803M = (Button) a(2131559801);
        this.f14804N = (Button) a(2131559800);
        m15199s();
        this.f14803M.setOnClickListener(new C20702(this));
        this.f14804N.setOnClickListener(new C20713(this));
        if (this.f14811U) {
            this.f14804N.setVisibility(8);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131434166);
            layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.f14803M.setLayoutParams(layoutParams);
            this.f14803M.setText(getResources().getString(2131230726));
            m15167b(false);
        } else if (this.f14812V) {
            m15186k();
            m15166b(stringExtra.split(":")[1]);
        } else {
            m15186k();
            m15190m();
        }
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1765292575);
        super.onStop();
        if (this.f14814X != null) {
            this.f14814X.a(false);
            this.f14814X = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1356774374, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 315753010);
        super.onDestroy();
        if (this.f14794A != null) {
            this.f14794A.c();
        }
        if (this.f14817p != null) {
            BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
            backgroundLocationNuxDataFetcher.f14754d.cancel(false);
            backgroundLocationNuxDataFetcher.f14754d = null;
            if (backgroundLocationNuxDataFetcher.f14755e != null) {
                backgroundLocationNuxDataFetcher.f14755e.cancel(false);
                backgroundLocationNuxDataFetcher.f14755e = null;
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1595169577, a);
    }

    public void onBackPressed() {
        this.f14820s.m15116c();
        super.onBackPressed();
    }

    private void m15167b(boolean z) {
        String str;
        BackgroundLocationNuxAnalyticsLogger backgroundLocationNuxAnalyticsLogger = this.f14820s;
        String stringExtra = getIntent().getStringExtra("source");
        boolean z2 = this.f14811U;
        if (z) {
            str = "traveling";
        } else {
            str = "one_page";
        }
        backgroundLocationNuxAnalyticsLogger.f14741c = backgroundLocationNuxAnalyticsLogger.f14740b.now();
        backgroundLocationNuxAnalyticsLogger.f14742d = stringExtra;
        backgroundLocationNuxAnalyticsLogger.f14743e = z2;
        backgroundLocationNuxAnalyticsLogger.f14744f = str;
        this.f14820s.m15111a();
        if (z) {
            this.f14796F.setBackgroundResource(2130837766);
            this.f14797G.setImageResource(2130839722);
            this.f14798H.setText(this.f14816Z ? 2131241839 : 2131241843);
            this.f14798H.setTextSize(0, (float) getResources().getDimensionPixelSize(m15196p() ? 2131427406 : 2131427410));
            m15192n();
        } else {
            this.f14796F.setBackgroundResource(2130837758);
            this.f14797G.setImageResource(2130839998);
            CharSequence string = (!this.f14812V || this.f14813W == null) ? getResources().getString(2131241839) : getResources().getString(2131241846, new Object[]{this.f14813W.m15590d()});
            this.f14798H.setText(string);
        }
        m15171c(z);
        m15197q();
    }

    private void m15186k() {
        this.f14795E.setVisibility(0);
        this.f14796F.setVisibility(8);
    }

    public static void m15188l(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
        backgroundLocationOnePageNuxActivity.f14795E.setVisibility(8);
        backgroundLocationOnePageNuxActivity.f14796F.setVisibility(0);
    }

    private void m15190m() {
        ListenableFuture a;
        TasksManager tasksManager = this.f14794A;
        String str = "fetch_should_show_traveling_nux";
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        if (backgroundLocationNuxDataFetcher.f14753c.a(388, false)) {
            Preconditions.checkNotNull(backgroundLocationNuxDataFetcher.f14754d);
            a = Futures.a(backgroundLocationNuxDataFetcher.f14754d, new C20641(backgroundLocationNuxDataFetcher), DirectExecutor.INSTANCE);
        } else {
            a = Futures.a(Boolean.valueOf(false));
        }
        tasksManager.a(str, a, new C20724(this));
    }

    private void m15192n() {
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        Preconditions.checkNotNull(backgroundLocationNuxDataFetcher.f14754d);
        this.f14794A.a("fetch_actor_info", Futures.a(backgroundLocationNuxDataFetcher.f14754d, new C20652(backgroundLocationNuxDataFetcher), DirectExecutor.INSTANCE), new C20735(this));
    }

    private void m15166b(String str) {
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        GraphQlQueryString backgroundLocationNuxInviterProfileQueryString = new BackgroundLocationNuxInviterProfileQueryString();
        backgroundLocationNuxInviterProfileQueryString.a("id", str);
        backgroundLocationNuxInviterProfileQueryString.a("image_scale", GraphQlQueryDefaults.a());
        backgroundLocationNuxInviterProfileQueryString.a("image_size", Integer.valueOf(64));
        backgroundLocationNuxDataFetcher.f14755e = backgroundLocationNuxDataFetcher.f14751a.a(GraphQLRequest.a(backgroundLocationNuxInviterProfileQueryString));
        this.f14794A.a("fetch_inviter_proifile", backgroundLocationNuxDataFetcher.f14755e, new C20746(this));
    }

    private void m15171c(final boolean z) {
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        Preconditions.checkNotNull(backgroundLocationNuxDataFetcher.f14754d);
        this.f14794A.a("fetch_upsell_data", Futures.a(backgroundLocationNuxDataFetcher.f14754d, new C20674(backgroundLocationNuxDataFetcher), MoreExecutors.a()), new AbstractDisposableFutureCallback<BackgroundLocationNuxFriendsSharingLocation>(this) {
            final /* synthetic */ BackgroundLocationOnePageNuxActivity f14783b;

            protected final void m15145a(Object obj) {
                BackgroundLocationNuxFriendsSharingLocationModel backgroundLocationNuxFriendsSharingLocationModel = (BackgroundLocationNuxFriendsSharingLocationModel) obj;
                if (backgroundLocationNuxFriendsSharingLocationModel == null || backgroundLocationNuxFriendsSharingLocationModel.m15274a() == null || backgroundLocationNuxFriendsSharingLocationModel.m15274a().m15270b().size() < 2) {
                    this.f14783b.m15174d(z);
                    return;
                }
                ImmutableList a = this.f14783b.m15155a(backgroundLocationNuxFriendsSharingLocationModel.m15274a().m15270b());
                if (!z) {
                    this.f14783b.f14805O.setVisibility(8);
                    this.f14783b.f14806P.setVisibility(0);
                    this.f14783b.f14806P.setText(this.f14783b.f14818q.m15570a(backgroundLocationNuxFriendsSharingLocationModel.m15274a().m15266a(), a, 2131361917));
                }
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    int dimensionPixelSize = this.f14783b.getResources().getDimensionPixelSize(2131434187);
                    layoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                } else {
                    layoutParams.setMargins(0, this.f14783b.getResources().getDimensionPixelSize(2131434173), 0, this.f14783b.getResources().getDimensionPixelSize(2131434174));
                }
                this.f14783b.f14799I.setLayoutParams(layoutParams);
                BackgroundLocationUpsellFacepileUtil.m15557b(this.f14783b.f14799I, a);
                this.f14783b.f14799I.setVisibility(0);
            }

            protected final void m15146a(Throwable th) {
                this.f14783b.m15174d(z);
                BLog.b(BackgroundLocationOnePageNuxActivity.f14791B, "failed to get upsell data", th);
                this.f14783b.f14824w.a("background_location_one_nux_upsell_data_fetch_fail", th);
            }
        });
    }

    public static boolean m15194o(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
        DisplayMetrics displayMetrics = backgroundLocationOnePageNuxActivity.getResources().getDisplayMetrics();
        return ((float) displayMetrics.heightPixels) / displayMetrics.density < 500.0f;
    }

    private boolean m15196p() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return ((float) displayMetrics.heightPixels) / displayMetrics.density >= 500.0f && ((float) displayMetrics.heightPixels) / displayMetrics.density < 600.0f;
    }

    private void m15174d(boolean z) {
        if (!z) {
            this.f14805O.setVisibility(0);
            this.f14806P.setVisibility(8);
            this.f14799I.setVisibility(8);
        }
    }

    private ImmutableList<? extends BackgroundLocationUpsellProfile> m15155a(ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        if (!this.f14812V) {
            return immutableList;
        }
        String b = this.f14813W.m15588b();
        Collection arrayList = new ArrayList();
        arrayList.add(this.f14813W);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel = (BackgroundLocationUpsellProfileModel) immutableList.get(i);
            if (!b.equals(backgroundLocationUpsellProfileModel.m15588b())) {
                arrayList.add(backgroundLocationUpsellProfileModel);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    private void m15197q() {
        BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher = this.f14817p;
        Preconditions.checkNotNull(backgroundLocationNuxDataFetcher.f14754d);
        this.f14794A.a("fetch_privacy_options", Futures.a(backgroundLocationNuxDataFetcher.f14754d, new C20663(backgroundLocationNuxDataFetcher), MoreExecutors.a()), new C20768(this));
    }

    private void m15159a(BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        m15162a(true, backgroundLocationPrivacyPickerOptionModel);
    }

    public static void m15198r(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity) {
        backgroundLocationOnePageNuxActivity.m15162a(false, null);
    }

    private void m15162a(final boolean z, @Nullable BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        ListenableFuture listenableFuture;
        final DialogFragment a = ProgressDialogFragment.a(2131230739, true, false, true);
        a.a(kO_(), "save_nux_decision");
        if (this.f14814X != null) {
            this.f14814X.a(false);
            this.f14814X = null;
        }
        if (this.f14811U) {
            boolean z2;
            ListenableFuture a2;
            Preconditions.checkNotNull(backgroundLocationPrivacyPickerOptionModel);
            BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel2 = this.f14815Y;
            if ((backgroundLocationPrivacyPickerOptionModel == null && backgroundLocationPrivacyPickerOptionModel2 != null) || (backgroundLocationPrivacyPickerOptionModel != null && backgroundLocationPrivacyPickerOptionModel2 == null)) {
                z2 = false;
            } else if (backgroundLocationPrivacyPickerOptionModel == backgroundLocationPrivacyPickerOptionModel2) {
                z2 = true;
            } else {
                z2 = backgroundLocationPrivacyPickerOptionModel.m15316c().equals(backgroundLocationPrivacyPickerOptionModel2.m15316c());
            }
            if (z2) {
                a2 = Futures.a(Boolean.valueOf(true));
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable("BackgroundLocationUpdateSettingsParams", BackgroundLocationUpdateSettingsParams.a(backgroundLocationPrivacyPickerOptionModel.m15316c()));
                a2 = Futures.a(BlueServiceOperationFactoryDetour.a(this.f14821t, "background_location_update_settings", bundle, ErrorPropagation.BY_EXCEPTION, f14792C, -1825418233).a(), new Function<OperationResult, Boolean>(this) {
                    final /* synthetic */ BackgroundLocationOnePageNuxActivity f14775a;

                    {
                        this.f14775a = r1;
                    }

                    @Nullable
                    public Object apply(@Nullable Object obj) {
                        return Boolean.valueOf(true);
                    }
                }, MoreExecutors.a());
            }
            listenableFuture = a2;
        } else {
            listenableFuture = m15164b(z, backgroundLocationPrivacyPickerOptionModel);
        }
        C20779 c20779 = new AbstractDisposableFutureCallback<Boolean>(this) {
            final /* synthetic */ BackgroundLocationOnePageNuxActivity f14787c;

            protected final void m15149a(Object obj) {
                a.a();
                BackgroundLocationOnePageNuxActivity.m15177f(this.f14787c, z);
                BackgroundLocationOnePageNuxActivity.m15176e(this.f14787c, z);
            }

            protected final void m15150a(Throwable th) {
                a.a();
                BLog.a(BackgroundLocationOnePageNuxActivity.f14791B, "Failed to save NUX status", th);
                this.f14787c.f14826y.b(new ToastBuilder(2131230758));
            }
        };
        this.f14814X = FutureAndCallbackHolder.a(listenableFuture, c20779);
        Futures.a(listenableFuture, c20779, this.f14822u);
    }

    private ListenableFuture<Boolean> m15164b(boolean z, @Nullable BackgroundLocationPrivacyPickerOption backgroundLocationPrivacyPickerOption) {
        BackgroundLocationNuxStep backgroundLocationNuxStep = BackgroundLocationNuxStep.SHARING_UPSELL;
        if (!z) {
            return this.f14819r.m15135a(backgroundLocationNuxStep);
        }
        Preconditions.checkNotNull(backgroundLocationPrivacyPickerOption);
        return this.f14819r.m15136a(backgroundLocationNuxStep, backgroundLocationPrivacyPickerOption.m15316c());
    }

    @Nullable
    public static BackgroundLocationPrivacyPickerOptionModel m15163b(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity, int i) {
        if (backgroundLocationOnePageNuxActivity.f14801K.getVisibility() != 0 || i < 0 || i >= backgroundLocationOnePageNuxActivity.f14816Z.getCount()) {
            return null;
        }
        return backgroundLocationOnePageNuxActivity.f14816Z.m15297a(i);
    }

    public static void m15176e(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity, boolean z) {
        Intent intent = new Intent(backgroundLocationOnePageNuxActivity.f14823v.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION"));
        intent.putExtra("expected_location_history_setting", z);
        backgroundLocationOnePageNuxActivity.sendBroadcast(intent);
    }

    private void m15199s() {
        this.f14802L.setText(SpannableStringFormatter.a(getResources(), 2131241841, new SpannableStringSubstitution[]{new SpannableStringSubstitution(2131241842, new LinkSpan(this, f14793D, MoreInfoType.LEARN_MORE), 33)}));
        this.f14802L.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m15156a(BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher, BackgroundLocationUpsellText backgroundLocationUpsellText, BackgroundLocationNuxStatusManager backgroundLocationNuxStatusManager, BackgroundLocationNuxAnalyticsLogger backgroundLocationNuxAnalyticsLogger, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, AbstractFbErrorReporter abstractFbErrorReporter, FbUriIntentHandler fbUriIntentHandler, Toaster toaster, SecureContextHelper secureContextHelper, TasksManager tasksManager) {
        this.f14817p = backgroundLocationNuxDataFetcher;
        this.f14818q = backgroundLocationUpsellText;
        this.f14819r = backgroundLocationNuxStatusManager;
        this.f14820s = backgroundLocationNuxAnalyticsLogger;
        this.f14821t = defaultBlueServiceOperationFactory;
        this.f14822u = executorService;
        this.f14823v = facebookOnlyIntentActionFactory;
        this.f14824w = abstractFbErrorReporter;
        this.f14825x = fbUriIntentHandler;
        this.f14826y = toaster;
        this.f14827z = secureContextHelper;
        this.f14794A = tasksManager;
    }

    public static void m15177f(BackgroundLocationOnePageNuxActivity backgroundLocationOnePageNuxActivity, boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, "one_page_nux")));
            if (backgroundLocationOnePageNuxActivity.m15200t()) {
                backgroundLocationOnePageNuxActivity.f14827z.a(intent, backgroundLocationOnePageNuxActivity);
            }
            backgroundLocationOnePageNuxActivity.setResult(1, intent);
        } else {
            backgroundLocationOnePageNuxActivity.setResult(2);
        }
        backgroundLocationOnePageNuxActivity.finish();
    }

    private boolean m15200t() {
        return getIntent().getBooleanExtra("redirect_after_accept", false);
    }
}

package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.abtest.PrivacyCheckupMobileXConfig;
import com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager;
import com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager.C12991;
import com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager.C13002;
import com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager.Task;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.Event;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepAdapter.PrivacyCheckupActionCallbackInterface;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SearchNearbyPlaces */
public final class PrivacyCheckupSingleStepActivity extends FbFragmentActivity {
    private static final CallerContext f11148p = CallerContext.a(PrivacyCheckupSingleStepActivity.class);
    private static int f11149q;
    private static int f11150r;
    public CountDownTimer f11151A;
    public String f11152B;
    private ListView f11153C;
    public PrivacyCheckupStepAdapter f11154D;
    public HashMap<String, PrivacyOptionFieldsWithExplanation> f11155E;
    public View f11156F;
    private View f11157G;
    public View f11158H;
    public View f11159I;
    public PrivacyCheckupStepData f11160J;
    private long f11161K = 0;
    private int f11162L = 0;
    private int f11163M = 0;
    private int f11164N = 0;
    public final AbstractDisposableFutureCallback<PrivacyCheckupStepData> f11165O = new C13261(this);
    private final OnScrollListener f11166P = new C13272(this);
    private final PrivacyCheckupActionCallbackInterface f11167Q = new C13283(this);
    private final OnGlobalLayoutListener f11168R = new C13294(this);
    private Context f11169s;
    public PrivacyCheckupSingleStepManager f11170t;
    private PrivacyCheckupStepAdapterProvider f11171u;
    private PrivacyCheckupAnalyticsLogger f11172v;
    private Clock f11173w;
    private Lazy<FbErrorReporter> f11174x;
    public Toaster f11175y;
    private XConfigReader f11176z;

    /* compiled from: SearchNearbyPlaces */
    class C13261 extends AbstractDisposableFutureCallback<PrivacyCheckupStepData> {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11137a;

        C13261(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11137a = privacyCheckupSingleStepActivity;
        }

        protected final void m11525a(Object obj) {
            PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) obj;
            if (privacyCheckupStepData != null) {
                this.f11137a.m11542a(privacyCheckupStepData);
            }
            AdapterDetour.a(this.f11137a.f11154D, 1163407303);
        }

        protected final void m11526a(Throwable th) {
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13272 implements OnScrollListener {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11138a;

        C13272(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11138a = privacyCheckupSingleStepActivity;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if ((i + i2) + 8 > i3 && this.f11138a.f11160J.f10975k) {
                PrivacyCheckupSingleStepManager privacyCheckupSingleStepManager = this.f11138a.f11170t;
                String str = this.f11138a.f11152B;
                String str2 = this.f11138a.f11160J.f10974j;
                privacyCheckupSingleStepManager.f10940a.a(Task.FETCH_REVIEW_DATA, new C12991(privacyCheckupSingleStepManager, str, str2, 15), this.f11138a.f11165O);
            }
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13283 implements PrivacyCheckupActionCallbackInterface {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11139a;

        C13283(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11139a = privacyCheckupSingleStepActivity;
        }

        public final void mo297a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
            this.f11139a.f11155E.put(str, privacyOptionFieldsWithExplanation);
        }

        public final void mo298a(String str, boolean z) {
        }

        public final boolean mo299a() {
            return false;
        }

        public final void mo300b() {
        }

        public final SelectablePrivacyData mo301c() {
            return null;
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13294 implements OnGlobalLayoutListener {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11140a;

        C13294(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11140a = privacyCheckupSingleStepActivity;
        }

        public void onGlobalLayout() {
            if (this.f11140a.f11158H != null) {
                this.f11140a.f11158H.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LayoutParams layoutParams = (LayoutParams) this.f11140a.f11159I.getLayoutParams();
                int dimensionPixelOffset = this.f11140a.getResources().getDimensionPixelOffset(2131434447);
                layoutParams.setMargins((this.f11140a.f11158H.getWidth() / 2) - (dimensionPixelOffset / 2), ((this.f11140a.f11158H.getTop() + this.f11140a.f11156F.getTop()) - (dimensionPixelOffset / 2)) - this.f11140a.getResources().getDimensionPixelOffset(2131434446), 0, 0);
                this.f11140a.f11159I.setVisibility(0);
            }
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13305 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11141a;

        C13305(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11141a = privacyCheckupSingleStepActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1136442154);
            this.f11141a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -424699594, a);
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13316 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11142a;

        C13316(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11142a = privacyCheckupSingleStepActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1378203876);
            PrivacyCheckupSingleStepActivity.m11570q(this.f11142a);
            Logger.a(2, EntryType.UI_INPUT_END, 1886522308, a);
        }
    }

    /* compiled from: SearchNearbyPlaces */
    class C13349 implements DialogInterface.OnClickListener {
        final /* synthetic */ PrivacyCheckupSingleStepActivity f11147a;

        C13349(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
            this.f11147a = privacyCheckupSingleStepActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11147a.m11543a(Event.PRIVACY_REVIEW_CANCEL, false);
            this.f11147a.finish();
        }
    }

    private static <T extends Context> void m11547a(Class<T> cls, T t) {
        m11548a((Object) t, (Context) t);
    }

    public static void m11548a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PrivacyCheckupSingleStepActivity) obj).m11540a((Context) fbInjector.getInstance(Context.class), PrivacyCheckupSingleStepManager.m11364a(fbInjector), (PrivacyCheckupStepAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PrivacyCheckupStepAdapterProvider.class), PrivacyCheckupAnalyticsLogger.m11461b(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), Toaster.b(fbInjector), XConfigReader.a(fbInjector));
    }

    @Inject
    private void m11540a(Context context, PrivacyCheckupSingleStepManager privacyCheckupSingleStepManager, PrivacyCheckupStepAdapterProvider privacyCheckupStepAdapterProvider, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, Clock clock, Lazy<FbErrorReporter> lazy, Toaster toaster, XConfigReader xConfigReader) {
        this.f11169s = context;
        this.f11170t = privacyCheckupSingleStepManager;
        this.f11171u = privacyCheckupStepAdapterProvider;
        this.f11172v = privacyCheckupAnalyticsLogger;
        this.f11173w = clock;
        this.f11174x = lazy;
        this.f11175y = toaster;
        this.f11176z = xConfigReader;
    }

    protected final void m11574b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = PrivacyCheckupSingleStepActivity.class;
        m11548a((Object) this, (Context) this);
        f11149q = this.f11176z.a(PrivacyCheckupMobileXConfig.f, 3);
        f11150r = this.f11176z.a(PrivacyCheckupMobileXConfig.e, 10000);
        this.f11152B = getIntent().getStringExtra("checkup_type");
        Preconditions.checkArgument(!TextUtils.isEmpty(this.f11152B), "PrivacyCheckupSingleStepActivity started without type");
        setContentView(2130906382);
        this.f11160J = new PrivacyCheckupStepData(PrivacyCheckupStepType.GENERIC_STEP);
        this.f11155E = new HashMap();
        m11557i();
    }

    private void m11557i() {
        this.f11153C = (ListView) findViewById(2131566242);
        m11563l();
        m11558j();
        this.f11154D = this.f11171u.m11576a(this.f11167Q, this.f11160J);
        this.f11153C.setAdapter(this.f11154D);
        this.f11153C.setOnScrollListener(this.f11166P);
        this.f11156F = findViewById(2131562154);
        this.f11158H = findViewById(2131559974);
        this.f11159I = findViewById(2131559442);
        m11561k();
    }

    private void m11558j() {
        this.f11157G = getLayoutInflater().inflate(2130906383, this.f11153C, false);
        this.f11153C.addHeaderView(this.f11157G);
        this.f11157G.setVisibility(8);
    }

    private void m11561k() {
        if (TextUtils.isEmpty(this.f11160J.f10972h)) {
            this.f11158H.setVisibility(8);
            this.f11159I.setVisibility(8);
            return;
        }
        ((TextView) this.f11158H).setText(this.f11160J.f10972h);
        this.f11158H.getViewTreeObserver().addOnGlobalLayoutListener(this.f11168R);
        this.f11158H.setVisibility(0);
    }

    protected final void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1440560749);
        super.onDestroy();
        if (this.f11151A != null) {
            this.f11151A.cancel();
        }
        this.f11151A = null;
        this.f11154D = null;
        this.f11157G = null;
        this.f11160J = null;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1021481972, a);
    }

    public final void onBackPressed() {
        this.f11170t.f10940a.c(Task.FETCH_REVIEW_DATA);
        this.f11170t.m11366b();
        ImmutableList p = m11569p();
        if (p == null || p.isEmpty()) {
            m11543a(Event.PRIVACY_REVIEW_CANCEL, false);
            finish();
            return;
        }
        m11571r();
    }

    private void m11542a(PrivacyCheckupStepData privacyCheckupStepData) {
        this.f11160J.m11368a(privacyCheckupStepData);
        m11564m();
        m11567n();
        m11568o();
        m11561k();
    }

    private void m11563l() {
        ((GlyphView) findViewById(2131566239)).setOnClickListener(new C13305(this));
    }

    private void m11564m() {
        TextView textView = (TextView) findViewById(2131566240);
        textView.setText(TextUtils.isEmpty(this.f11160J.f10976l) ? getString(2131234228) : this.f11160J.f10976l);
        textView.setOnClickListener(new C13316(this));
    }

    private void m11567n() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f11160J.f10969e) ? 1 : 0;
        FbDraweeView fbDraweeView = (FbDraweeView) findViewById(2131566241);
        if (i2 != 0) {
            fbDraweeView.a(Uri.parse(this.f11160J.f10969e), f11148p);
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(ScaleType.f);
        }
        if (i2 == 0) {
            i = 8;
        }
        fbDraweeView.setVisibility(i);
    }

    private void m11568o() {
        int i = 8;
        if (this.f11157G != null) {
            int i2;
            int i3;
            if (TextUtils.isEmpty(this.f11160J.f10970f)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (TextUtils.isEmpty(this.f11160J.f10971g)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i2 == 0 && i3 == 0) {
                this.f11157G.setVisibility(8);
                return;
            }
            TextView textView = (TextView) this.f11157G.findViewById(2131558927);
            TextView textView2 = (TextView) this.f11157G.findViewById(2131559627);
            if (i2 != 0) {
                textView.setText(this.f11160J.f10970f);
            }
            if (i3 != 0) {
                textView2.setText(this.f11160J.f10971g);
            }
            if (i2 != 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (i3 != 0) {
                i = 0;
            }
            textView2.setVisibility(i);
            this.f11157G.setVisibility(0);
        }
    }

    private ImmutableList<ObjectPrivacyEdit> m11569p() {
        if (this.f11155E.isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        for (Entry entry : this.f11155E.entrySet()) {
            String str = (String) entry.getKey();
            if (this.f11160J.f10966b.containsKey(str)) {
                PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) this.f11160J.f10966b.get(str);
                if (privacyCheckupItemRow.f10961f.a((PrivacyOptionFieldsWithExplanation) entry.getValue()) != privacyCheckupItemRow.f10961f.a(privacyCheckupItemRow.f10961f.b())) {
                    builder.c(new ObjectPrivacyEdit(privacyCheckupItemRow.f10956a, this.f11173w.a(), privacyCheckupItemRow.f10957b, ((PrivacyOptionFieldsWithExplanation) entry.getValue()).c()));
                }
            } else {
                ((AbstractFbErrorReporter) this.f11174x.get()).b("privacy_checkup_single_step_manager_missing_privacy_edit", "Could not find key for object: " + str + " in checkup data!");
            }
        }
        return builder.b();
    }

    public static void m11570q(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
        ImmutableList p = privacyCheckupSingleStepActivity.m11569p();
        if (p == null || p.isEmpty()) {
            privacyCheckupSingleStepActivity.finish();
            return;
        }
        privacyCheckupSingleStepActivity.m11573t();
        final DialogFragment a = ProgressDialogFragment.a(2131234227, true, true, false);
        a.a(privacyCheckupSingleStepActivity.kO_(), null);
        privacyCheckupSingleStepActivity.f11151A = new CountDownTimer(privacyCheckupSingleStepActivity, (long) f11150r, (long) f11150r) {
            final /* synthetic */ PrivacyCheckupSingleStepActivity f11144b;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.f11144b.m11541a(a);
            }
        }.start();
        PrivacyCheckupSingleStepManager privacyCheckupSingleStepManager = privacyCheckupSingleStepActivity.f11170t;
        String str = privacyCheckupSingleStepActivity.f11152B;
        boolean a2 = privacyCheckupSingleStepManager.f10940a.a(Task.SEND_PRIVACY_EDITS, new C13002(privacyCheckupSingleStepManager, str, p), new AbstractDisposableFutureCallback<OperationResult>(privacyCheckupSingleStepActivity) {
            final /* synthetic */ PrivacyCheckupSingleStepActivity f11146b;

            protected final void m11537a(Object obj) {
                if (this.f11146b.f11151A != null) {
                    this.f11146b.f11151A.cancel();
                }
                a.a();
                this.f11146b.m11543a(Event.PRIVACY_REVIEW_WRITE_SUCCESS, true);
                this.f11146b.finish();
            }

            protected final void m11538a(Throwable th) {
                if (this.f11146b.f11151A != null) {
                    this.f11146b.f11151A.cancel();
                }
                a.a();
                this.f11146b.f11162L = this.f11146b.f11162L + 1;
                this.f11146b.m11543a(Event.PRIVACY_REVIEW_WRITE_FAILURE, true);
                if (!PrivacyCheckupSingleStepActivity.m11572s(this.f11146b)) {
                    this.f11146b.f11175y.b(new ToastBuilder(2131242311));
                }
            }
        });
    }

    private void m11571r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f11169s);
        builder.a(true);
        builder.a(getString(2131234229));
        builder.b(getString(2131234230));
        builder.a(getString(2131234231), new C13349(this));
        builder.b(getString(2131234232), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ PrivacyCheckupSingleStepActivity f11134a;

            {
                this.f11134a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.a().show();
    }

    private void m11541a(DialogFragment dialogFragment) {
        this.f11170t.m11366b();
        dialogFragment.a();
        this.f11163M++;
        m11543a(Event.PRIVACY_REVIEW_WRITE_TIMEOUT, true);
        if (!m11572s(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f11169s);
            builder.a(true);
            builder.b(2131242313);
            builder.b(getString(2131230767), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ PrivacyCheckupSingleStepActivity f11135a;

                {
                    this.f11135a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    PrivacyCheckupSingleStepActivity.m11570q(this.f11135a);
                }
            });
            builder.a(getString(2131230728), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ PrivacyCheckupSingleStepActivity f11136a;

                {
                    this.f11136a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f11136a.m11543a(Event.PRIVACY_REVIEW_WRITE_EXIT_ON_FAILURE, false);
                    dialogInterface.dismiss();
                }
            });
            builder.a().show();
        }
    }

    public static boolean m11572s(PrivacyCheckupSingleStepActivity privacyCheckupSingleStepActivity) {
        if (privacyCheckupSingleStepActivity.f11162L + privacyCheckupSingleStepActivity.f11163M <= f11149q) {
            return false;
        }
        privacyCheckupSingleStepActivity.f11175y.b(new ToastBuilder(2131242312));
        return true;
    }

    private void m11573t() {
        this.f11161K = this.f11173w.a();
        if (this.f11162L == 0 && this.f11163M == 0 && this.f11164N == 0) {
            m11543a(Event.PRIVACY_REVIEW_WRITE_SENT, false);
            return;
        }
        this.f11164N++;
        m11543a(Event.PRIVACY_REVIEW_WRITE_RETRY, false);
    }

    private void m11543a(Event event, boolean z) {
        this.f11172v.m11463a(event, this.f11162L, this.f11163M, this.f11164N, z ? Long.valueOf(this.f11173w.a() - this.f11161K) : null);
    }
}

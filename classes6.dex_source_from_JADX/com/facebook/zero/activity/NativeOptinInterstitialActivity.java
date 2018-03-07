package com.facebook.zero.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify.TransformFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.text.linkify.SafeLinkifier;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestParams;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestResult;
import com.facebook.zero.sdk.request.ZeroOptinParams;
import com.facebook.zero.sdk.request.ZeroOptinResult;
import com.facebook.zero.sdk.request.ZeroOptoutParams;
import com.facebook.zero.sdk.request.ZeroOptoutResult;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: com.facebook.photos.photogallery. */
public class NativeOptinInterstitialActivity extends FbFragmentActivity {
    private static final CallerContext f20349p = CallerContext.a(NativeOptinInterstitialActivity.class, "zero_optin_interstitial");
    private FbTextView f20350A;
    private DefaultBlueServiceOperationFactory f20351B;
    private DefaultAndroidThreadUtil f20352C;
    private Lazy<ZeroNetworkAndTelephonyHelper> f20353D;
    public BaseFbBroadcastManager f20354E;
    public BaseFbBroadcastManager f20355F;
    private ScheduledExecutorService f20356G;
    private Lazy<ZeroRequestHandler> f20357H;
    public FetchZeroOptinContentRequestResult f20358I;
    private ProgressBar f20359q;
    private LinearLayout f20360r;
    private FbButton f20361s;
    private FbButton f20362t;
    private ScrollView f20363u;
    private FbTextView f20364v;
    private FbTextView f20365w;
    private FbDraweeView f20366x;
    private FbTextView f20367y;
    private FacepileView f20368z;

    /* compiled from: com.facebook.photos.photogallery. */
    class C15521 implements OnClickListener {
        final /* synthetic */ NativeOptinInterstitialActivity f20340a;

        C15521(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20340a = nativeOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1643217802);
            NativeOptinInterstitialActivity.m28951n(this.f20340a);
            Logger.a(2, EntryType.UI_INPUT_END, 1065790498, a);
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15532 implements OnClickListener {
        final /* synthetic */ NativeOptinInterstitialActivity f20341a;

        C15532(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20341a = nativeOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -713909799);
            NativeOptinInterstitialActivity.m28947j(this.f20341a);
            Logger.a(2, EntryType.UI_INPUT_END, -172083816, a);
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15543 implements FutureCallback<FetchZeroOptinContentRequestResult> {
        final /* synthetic */ NativeOptinInterstitialActivity f20342a;

        C15543(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20342a = nativeOptinInterstitialActivity;
        }

        public void onSuccess(Object obj) {
            this.f20342a.f20358I = (FetchZeroOptinContentRequestResult) obj;
            NativeOptinInterstitialActivity.m28949l(this.f20342a);
        }

        public void onFailure(Throwable th) {
            this.f20342a.finish();
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15554 implements FutureCallback<ZeroOptinResult> {
        final /* synthetic */ NativeOptinInterstitialActivity f20343a;

        C15554(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20343a = nativeOptinInterstitialActivity;
        }

        public void onSuccess(Object obj) {
            if (((ZeroOptinResult) obj).a().equals("optin")) {
                NativeOptinInterstitialActivity.m28956s(this.f20343a);
            }
            this.f20343a.finish();
        }

        public void onFailure(Throwable th) {
            this.f20343a.finish();
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15565 implements FutureCallback<ZeroOptoutResult> {
        final /* synthetic */ NativeOptinInterstitialActivity f20344a;

        C15565(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20344a = nativeOptinInterstitialActivity;
        }

        public void onSuccess(Object obj) {
            if (((ZeroOptoutResult) obj).a().equals("optout")) {
                NativeOptinInterstitialActivity.m28956s(this.f20344a);
            }
            this.f20344a.finish();
        }

        public void onFailure(Throwable th) {
            this.f20344a.finish();
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15576 implements DialogInterface.OnClickListener {
        final /* synthetic */ NativeOptinInterstitialActivity f20345a;

        C15576(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20345a = nativeOptinInterstitialActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15587 implements DialogInterface.OnClickListener {
        final /* synthetic */ NativeOptinInterstitialActivity f20346a;

        C15587(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20346a = nativeOptinInterstitialActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NativeOptinInterstitialActivity.m28948k(this.f20346a);
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15598 implements TransformFilter {
        final /* synthetic */ NativeOptinInterstitialActivity f20347a;

        C15598(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20347a = nativeOptinInterstitialActivity;
        }

        public String transformUrl(Matcher matcher, String str) {
            return this.f20347a.f20358I.h().toString();
        }
    }

    /* compiled from: com.facebook.photos.photogallery. */
    class C15609 implements Runnable {
        final /* synthetic */ NativeOptinInterstitialActivity f20348a;

        C15609(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
            this.f20348a = nativeOptinInterstitialActivity;
        }

        public void run() {
            this.f20348a.f20354E.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.OPTIN));
            this.f20348a.f20355F.a("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
        }
    }

    private static <T extends Context> void m28937a(Class<T> cls, T t) {
        m28938a((Object) t, (Context) t);
    }

    public static void m28938a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NativeOptinInterstitialActivity) obj).m28935a(DefaultBlueServiceOperationFactory.b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), IdBasedLazy.a(fbInjector, 3799), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 3804));
    }

    @Inject
    private void m28935a(BlueServiceOperationFactory blueServiceOperationFactory, AndroidThreadUtil androidThreadUtil, Lazy<ZeroNetworkAndTelephonyHelper> lazy, FbBroadcastManager fbBroadcastManager, FbBroadcastManager fbBroadcastManager2, ScheduledExecutorService scheduledExecutorService, Lazy<ZeroRequestHandler> lazy2) {
        this.f20351B = blueServiceOperationFactory;
        this.f20352C = androidThreadUtil;
        this.f20353D = lazy;
        this.f20354E = fbBroadcastManager;
        this.f20355F = fbBroadcastManager2;
        this.f20356G = scheduledExecutorService;
        this.f20357H = lazy2;
    }

    protected final void m28957b(Bundle bundle) {
        super.b(bundle);
        Class cls = NativeOptinInterstitialActivity.class;
        m28938a((Object) this, (Context) this);
        setTheme(2131624474);
        setContentView(2130905368);
        this.f20359q = (ProgressBar) a(2131560985);
        this.f20363u = (ScrollView) a(2131564046);
        this.f20364v = (FbTextView) a(2131560987);
        this.f20365w = (FbTextView) a(2131560989);
        this.f20366x = (FbDraweeView) a(2131564047);
        this.f20367y = (FbTextView) a(2131564048);
        this.f20368z = (FacepileView) a(2131560992);
        this.f20350A = (FbTextView) a(2131564049);
        this.f20360r = (LinearLayout) a(2131560991);
        this.f20361s = (FbButton) a(2131564044);
        this.f20361s.setOnClickListener(new C15521(this));
        this.f20362t = (FbButton) a(2131564045);
        this.f20362t.setOnClickListener(new C15532(this));
        m28946i();
    }

    public void onBackPressed() {
        m28951n(this);
    }

    private void m28946i() {
        this.f20358I = null;
        m28950m();
        ((ZeroRequestHandler) this.f20357H.get()).a(m28952o(), new C15543(this));
    }

    public static void m28947j(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
        nativeOptinInterstitialActivity.m28950m();
        ((ZeroRequestHandler) nativeOptinInterstitialActivity.f20357H.get()).a(nativeOptinInterstitialActivity.m28953p(), new C15554(nativeOptinInterstitialActivity));
    }

    public static void m28948k(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
        nativeOptinInterstitialActivity.m28950m();
        ((ZeroRequestHandler) nativeOptinInterstitialActivity.f20357H.get()).a(nativeOptinInterstitialActivity.m28954q(), new C15565(nativeOptinInterstitialActivity));
    }

    public static void m28949l(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
        if (nativeOptinInterstitialActivity.f20358I == null) {
            nativeOptinInterstitialActivity.finish();
        }
        nativeOptinInterstitialActivity.f20359q.setVisibility(8);
        nativeOptinInterstitialActivity.f20361s.setText(nativeOptinInterstitialActivity.f20358I.n());
        nativeOptinInterstitialActivity.f20361s.setContentDescription(nativeOptinInterstitialActivity.f20358I.n());
        nativeOptinInterstitialActivity.f20362t.setText(nativeOptinInterstitialActivity.f20358I.m());
        nativeOptinInterstitialActivity.f20362t.setContentDescription(nativeOptinInterstitialActivity.f20358I.m());
        nativeOptinInterstitialActivity.f20364v.setText(nativeOptinInterstitialActivity.f20358I.a());
        nativeOptinInterstitialActivity.f20364v.setContentDescription(nativeOptinInterstitialActivity.f20358I.a());
        nativeOptinInterstitialActivity.f20365w.setText(nativeOptinInterstitialActivity.f20358I.b());
        nativeOptinInterstitialActivity.f20365w.setContentDescription(nativeOptinInterstitialActivity.f20358I.b());
        if (!StringUtil.a(nativeOptinInterstitialActivity.f20358I.c().toString())) {
            nativeOptinInterstitialActivity.f20366x.a(nativeOptinInterstitialActivity.f20358I.c(), f20349p);
        }
        nativeOptinInterstitialActivity.f20367y.setVisibility(8);
        if (!StringUtil.a(nativeOptinInterstitialActivity.f20358I.d())) {
            nativeOptinInterstitialActivity.f20367y.setText(nativeOptinInterstitialActivity.f20358I.d());
            nativeOptinInterstitialActivity.f20367y.setContentDescription(nativeOptinInterstitialActivity.f20358I.d());
            nativeOptinInterstitialActivity.f20367y.setVisibility(0);
        }
        nativeOptinInterstitialActivity.f20368z.setVisibility(8);
        if (!nativeOptinInterstitialActivity.f20358I.e().isEmpty()) {
            nativeOptinInterstitialActivity.f20368z.setFaceStrings(nativeOptinInterstitialActivity.f20358I.e());
            nativeOptinInterstitialActivity.f20368z.setVisibility(0);
        }
        nativeOptinInterstitialActivity.f20350A.setText(nativeOptinInterstitialActivity.f20358I.f());
        nativeOptinInterstitialActivity.f20350A.setContentDescription(nativeOptinInterstitialActivity.f20358I.f());
        nativeOptinInterstitialActivity.m28955r();
        nativeOptinInterstitialActivity.f20360r.setVisibility(0);
        nativeOptinInterstitialActivity.f20363u.setVisibility(0);
    }

    private void m28950m() {
        this.f20360r.setVisibility(8);
        this.f20363u.setVisibility(8);
        this.f20359q.setVisibility(0);
    }

    public static void m28951n(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
        if (nativeOptinInterstitialActivity.f20358I != null) {
            new FbAlertDialogBuilder(nativeOptinInterstitialActivity, 1).a(nativeOptinInterstitialActivity.f20358I.i()).b(nativeOptinInterstitialActivity.f20358I.j()).a(nativeOptinInterstitialActivity.f20358I.k(), new C15587(nativeOptinInterstitialActivity)).b(nativeOptinInterstitialActivity.f20358I.l(), new C15576(nativeOptinInterstitialActivity)).b();
        }
    }

    private FetchZeroOptinContentRequestParams m28952o() {
        return new FetchZeroOptinContentRequestParams(((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).b(), SizeUtil.a(getResources()));
    }

    private ZeroOptinParams m28953p() {
        return new ZeroOptinParams(((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).b(), "");
    }

    private ZeroOptoutParams m28954q() {
        return new ZeroOptoutParams(((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f20353D.get()).b());
    }

    private void m28955r() {
        SafeLinkifier.m25594a(this.f20350A, Pattern.compile(Pattern.quote(this.f20358I.g())), null, null, new C15598(this));
    }

    public static void m28956s(NativeOptinInterstitialActivity nativeOptinInterstitialActivity) {
        nativeOptinInterstitialActivity.f20356G.schedule(new C15609(nativeOptinInterstitialActivity), 15000, TimeUnit.MILLISECONDS);
    }
}

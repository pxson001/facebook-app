package com.facebook.facecast.plugin;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.privacy.common.ComposerEventPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPageAdminPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecast.plugin.tipjar.FacecastTipJarSettingDialog;
import com.facebook.facecast.plugin.tipjar.TipJarOptionView;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.selector.AudienceFragmentDialog;
import com.facebook.privacy.selector.AudienceFragmentDialog.OnAudienceSelectedListener;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.privacy.ui.PrivacyOptionView;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: boxNone */
public class FacecastEditTitlePlugin extends FacecastBasePlugin {
    private static final String f18257n = FacecastEditTitlePlugin.class.getName();
    @Inject
    FacecastAvatarHelper f18258c;
    @Inject
    AudienceSelectorPerformanceLogger f18259d;
    @Inject
    PrivacyOperationsClient f18260e;
    @Inject
    DefaultAndroidThreadUtil f18261f;
    @Inject
    ComposerGroupPrivacyDelegateProvider f18262g;
    @Inject
    ComposerPageAdminPrivacyDelegateProvider f18263h;
    @Inject
    AbstractFbErrorReporter f18264i;
    @Inject
    ComposerEventPrivacyDelegateProvider f18265j;
    @Inject
    InputMethodManager f18266k;
    @Inject
    PrivacyIcons f18267l;
    @Inject
    public QeAccessor f18268m;
    public final PrivacyOptionView f18269o;
    public final TipJarOptionView f18270p;
    public final BetterEditTextView f18271q;
    public final LinearLayout f18272r;
    public final LinearLayout f18273s;
    @Nullable
    public SelectablePrivacyData f18274t;
    @Nullable
    public ComposerFixedPrivacyData f18275u;
    @Nullable
    public FacecastEditTitleListener f18276v;
    public int f18277w;
    public int f18278x;
    private final PrivacyUpdatedHandler f18279y;

    /* compiled from: boxNone */
    class C15391 implements OnLayoutChangeListener {
        final /* synthetic */ FacecastEditTitlePlugin f18245a;

        C15391(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18245a = facecastEditTitlePlugin;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f18245a.f18278x < 0) {
                this.f18245a.f18278x = (this.f18245a.f18273s.getHeight() + this.f18245a.f18269o.getHeight()) + (this.f18245a.getResources().getDimensionPixelOffset(2131432280) * 2);
            }
            int height = this.f18245a.f18272r.getHeight();
            if (height != this.f18245a.f18277w) {
                this.f18245a.f18277w = height;
                this.f18245a.f18271q.setMaxHeight(this.f18245a.f18277w - this.f18245a.f18278x);
            }
        }
    }

    /* compiled from: boxNone */
    class C15402 implements OnClickListener {
        final /* synthetic */ FacecastEditTitlePlugin f18246a;

        C15402(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18246a = facecastEditTitlePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1715231857);
            if (this.f18246a.f18274t != null) {
                AudienceFragmentDialog audienceFragmentDialog = new AudienceFragmentDialog();
                audienceFragmentDialog.ao = new AudienceDataProvider(this.f18246a);
                audienceFragmentDialog.a(new AudienceSelectorListener(this.f18246a));
                audienceFragmentDialog.aq = this.f18246a.getResources().getString(2131234251);
                this.f18246a.f18259d.a(Caller.FACECAST_ACTIVITY);
                audienceFragmentDialog.a(((FragmentActivity) this.f18246a.getContext()).kO_(), "FACECAST_AUDIENCE_FRAGMENT_TAG");
            }
            Logger.a(2, EntryType.UI_INPUT_END, 455378577, a);
        }
    }

    /* compiled from: boxNone */
    class C15413 implements PrivacyUpdatedHandler {
        final /* synthetic */ FacecastEditTitlePlugin f18247a;

        C15413(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18247a = facecastEditTitlePlugin;
        }

        public final void mo487a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f18247a.f18275u = composerPrivacyData.f2000a;
            this.f18247a.f18269o.a(this.f18247a.f18275u.f1977b, this.f18247a.f18267l.a(this.f18247a.f18275u.f1976a, Size.PILL));
        }
    }

    /* compiled from: boxNone */
    class C15424 extends AbstractDisposableFutureCallback<PrivacyOptionsResult> {
        final /* synthetic */ FacecastEditTitlePlugin f18248a;

        C15424(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18248a = facecastEditTitlePlugin;
        }

        protected final void m22001a(Object obj) {
            PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
            FacecastEditTitlePlugin facecastEditTitlePlugin = this.f18248a;
            Builder builder = new Builder();
            builder.a = privacyOptionsResult;
            facecastEditTitlePlugin.f18274t = builder.a(privacyOptionsResult.selectedPrivacyOption).b();
            this.f18248a.f18269o.setPrivacyOption(privacyOptionsResult.selectedPrivacyOption);
            FacecastEditTitlePlugin.m22010j(this.f18248a);
            if (this.f18248a.f18276v != null) {
                this.f18248a.f18276v.mo1428a(true);
            }
        }

        protected final void m22002a(Throwable th) {
            if (this.f18248a.f18276v != null) {
                this.f18248a.f18276v.mo1428a(false);
            }
        }
    }

    /* compiled from: boxNone */
    public class C15435 implements OnClickListener {
        final /* synthetic */ FacecastEditTitlePlugin f18249a;

        public C15435(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18249a = facecastEditTitlePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1913802299);
            new FacecastTipJarSettingDialog().a(((FragmentActivity) this.f18249a.getContext()).kO_(), "FACECAST_TIP_JAR_SETTING_FRAGMENT_TAG");
            Logger.a(2, EntryType.UI_INPUT_END, -334202365, a);
        }
    }

    /* compiled from: boxNone */
    class C15446 implements Runnable {
        final /* synthetic */ FacecastEditTitlePlugin f18250a;

        C15446(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18250a = facecastEditTitlePlugin;
        }

        public void run() {
            if (!this.f18250a.f18266k.showSoftInput(this.f18250a.f18271q, 0)) {
                this.f18250a.m22013i();
                this.f18250a.f18266k.toggleSoftInput(0, 0);
                this.f18250a.f18266k.showSoftInput(this.f18250a.f18271q, 0);
            }
        }
    }

    /* compiled from: boxNone */
    /* synthetic */ class C15457 {
        static final /* synthetic */ int[] f18251a = new int[TargetType.values().length];

        static {
            try {
                f18251a[TargetType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18251a[TargetType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18251a[TargetType.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18251a[TargetType.UNDIRECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: boxNone */
    class AudienceDataProvider implements DataProvider {
        final /* synthetic */ FacecastEditTitlePlugin f18252a;

        public AudienceDataProvider(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18252a = facecastEditTitlePlugin;
        }

        public final SelectablePrivacyData m22003a() {
            return this.f18252a.f18274t;
        }

        public final boolean m22004b() {
            return false;
        }
    }

    /* compiled from: boxNone */
    class AudienceSelectorListener implements OnAudienceSelectedListener {
        final /* synthetic */ FacecastEditTitlePlugin f18253a;

        public AudienceSelectorListener(FacecastEditTitlePlugin facecastEditTitlePlugin) {
            this.f18253a = facecastEditTitlePlugin;
        }

        public final void m22005a(SelectablePrivacyData selectablePrivacyData) {
            this.f18253a.m22011a(selectablePrivacyData, null);
            this.f18253a.m22012h();
        }
    }

    /* compiled from: boxNone */
    public interface FacecastEditTitleListener {
        void mo1428a(boolean z);
    }

    /* compiled from: boxNone */
    class FacecastPreviewOverlayDrawable extends ShapeDrawable {
        public FacecastPreviewOverlayDrawable() {
            super(new RectShape());
            setShaderFactory(m22007a());
        }

        private ShaderFactory m22007a() {
            final int[] iArr = new int[]{1275068416, 1929379840, -16777216};
            final float[] fArr = new float[]{0.0f, 0.5f, 1.0f};
            return new ShaderFactory(this) {
                final /* synthetic */ FacecastPreviewOverlayDrawable f18256c;

                public Shader resize(int i, int i2) {
                    return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
                }
            };
        }
    }

    public static void m22009a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacecastEditTitlePlugin) obj).m22008a(FacecastAvatarHelper.m21967b(fbInjector), AudienceSelectorPerformanceLogger.a(fbInjector), PrivacyOperationsClient.a(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), (ComposerGroupPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerGroupPrivacyDelegateProvider.class), (ComposerPageAdminPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerPageAdminPrivacyDelegateProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (ComposerEventPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerEventPrivacyDelegateProvider.class), InputMethodManagerMethodAutoProvider.b(fbInjector), PrivacyIcons.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m22008a(FacecastAvatarHelper facecastAvatarHelper, AudienceSelectorPerformanceLogger audienceSelectorPerformanceLogger, PrivacyOperationsClient privacyOperationsClient, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ComposerGroupPrivacyDelegateProvider composerGroupPrivacyDelegateProvider, ComposerPageAdminPrivacyDelegateProvider composerPageAdminPrivacyDelegateProvider, AbstractFbErrorReporter abstractFbErrorReporter, ComposerEventPrivacyDelegateProvider composerEventPrivacyDelegateProvider, InputMethodManager inputMethodManager, PrivacyIcons privacyIcons, QeAccessor qeAccessor) {
        this.f18258c = facecastAvatarHelper;
        this.f18259d = audienceSelectorPerformanceLogger;
        this.f18260e = privacyOperationsClient;
        this.f18261f = defaultAndroidThreadUtil;
        this.f18262g = composerGroupPrivacyDelegateProvider;
        this.f18263h = composerPageAdminPrivacyDelegateProvider;
        this.f18264i = abstractFbErrorReporter;
        this.f18265j = composerEventPrivacyDelegateProvider;
        this.f18266k = inputMethodManager;
        this.f18267l = privacyIcons;
        this.f18268m = qeAccessor;
    }

    public FacecastEditTitlePlugin(Context context) {
        this(context, null);
    }

    private FacecastEditTitlePlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(18)
    private FacecastEditTitlePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18278x = -1;
        this.f18279y = new C15413(this);
        setContentView(2130904202);
        a(2131561634).setBackgroundDrawable(new FacecastPreviewOverlayDrawable());
        Class cls = FacecastEditTitlePlugin.class;
        m22009a((Object) this, getContext());
        this.f18269o = (PrivacyOptionView) a(2131561643);
        this.f18270p = (TipJarOptionView) a(2131561644);
        this.f18271q = (BetterEditTextView) a(2131561642);
        this.f18272r = (LinearLayout) a(2131561636);
        this.f18273s = (LinearLayout) a(2131561639);
        if (this.f18268m.a(ExperimentsForFacecastAbtestModule.f2785f, false)) {
            this.f18270p.setVisibility(0);
            this.f18270p.setOnClickListener(new C15435(this));
        } else {
            this.f18270p.setVisibility(8);
        }
        this.f18271q.setMovementMethod(new ScrollingMovementMethod());
        this.f18272r.addOnLayoutChangeListener(new C15391(this));
    }

    public void setUpProfile(ComposerTargetData composerTargetData) {
        String j;
        BetterTextView betterTextView = (BetterTextView) a(2131561641);
        ((UserTileView) a(2131561640)).setParams(this.f18258c.m21968a(composerTargetData, getResources().getDimensionPixelSize(2131432281)));
        FacecastAvatarHelper facecastAvatarHelper = this.f18258c;
        if (composerTargetData == null || composerTargetData.targetType != TargetType.PAGE) {
            j = facecastAvatarHelper.f18208a.j();
        } else {
            j = composerTargetData.targetName;
        }
        betterTextView.setText(j);
    }

    public static void m22010j(FacecastEditTitlePlugin facecastEditTitlePlugin) {
        facecastEditTitlePlugin.f18269o.setOnClickListener(new C15402(facecastEditTitlePlugin));
    }

    public final void m22011a(@Nullable SelectablePrivacyData selectablePrivacyData, ComposerTargetData composerTargetData) {
        if (selectablePrivacyData != null) {
            this.f18274t = selectablePrivacyData;
            this.f18269o.setPrivacyOption(selectablePrivacyData.d);
            m22010j(this);
            return;
        }
        this.f18269o.setText(getResources().getString(2131230739));
        if (composerTargetData != null) {
            switch (C15457.f18251a[composerTargetData.targetType.ordinal()]) {
                case 1:
                    this.f18262g.m1934a(this.f18279y, Long.valueOf(composerTargetData.targetId), composerTargetData.targetName).mo91a();
                    return;
                case 2:
                    this.f18263h.m1939a(this.f18279y, getResources().getString(2131234252), composerTargetData.targetName).mo91a();
                    return;
                case 3:
                    this.f18265j.m1925a(this.f18279y, Long.valueOf(composerTargetData.targetId), composerTargetData.targetName, composerTargetData.targetPrivacy).mo91a();
                    return;
                case 4:
                    this.f18261f.a(this.f18260e.a(DataFreshnessParam.STALE_DATA_OKAY), new C15424(this));
                    return;
                default:
                    this.f18264i.a(f18257n + "_updatePrivacySelector", "Unsupported type " + composerTargetData.targetType);
                    return;
            }
        }
    }

    public final void m22012h() {
        if (!this.f18266k.showSoftInput(this.f18271q, 0)) {
            postDelayed(new C15446(this), 100);
        }
    }

    public final void m22013i() {
        this.f18266k.hideSoftInputFromWindow(this.f18271q.getWindowToken(), 0);
    }
}

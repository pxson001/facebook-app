package com.facebook.stickers.keyboard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.tabbedpager.TabListAdapter;
import com.facebook.messaging.tabbedpager.TabbedPager;
import com.facebook.messaging.tabbedpager.TabbedPager.Listener;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.stickers.analytics.StickerLogger;
import com.facebook.stickers.client.StickerAssetManager;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.data.StickerInterfaceTranslator;
import com.facebook.stickers.gridlayout.StickerGridSizingParams;
import com.facebook.stickers.keyboard.StickerKeyboardPackPopupTabItem.TabType;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.search.ExpandableFrameLayout;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.stickers.store.StickerStoreActivity;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: edit_story_privacy_fragment_option_fetch_error */
public class StickerKeyboardView extends CustomFrameLayout {
    static final StickerKeyboardTabItem f16665a = new StickerKeyboardTabItem("recentStickers");
    static final StickerKeyboardTabItem f16666b = new StickerKeyboardTabItem("stickerSearch");
    public static final Class<?> f16667c = StickerKeyboardView.class;
    public static final CallerContext f16668d = CallerContext.b(StickerKeyboardView.class, "sticker_keyboard_selected");
    public List<Sticker> f16669A;
    public List<StickerPack> f16670B;
    public List<StickerPack> f16671C;
    public List<StickerKeyboardTabItem> f16672D;
    @Nullable
    public StickerPack f16673E;
    public int f16674F;
    public boolean f16675G;
    public SequenceLogger f16676H;
    private GatekeeperStoreImpl f16677I;
    private boolean f16678J;
    public StickerDownloadManager f16679K;
    private BaseFbBroadcastManager f16680L;
    private SelfRegistrableReceiverImpl f16681M;
    private ActionReceiver f16682N;
    public StickerInterface f16683O;
    public StickerAssetManager f16684e;
    public StickerKeyboardListener f16685f;
    public TabbedPager f16686g;
    private Sizes f16687h;
    public ListeningExecutorService f16688i;
    private StickerTabbedPagerAdapterProvider f16689j;
    public StickerTabbedPagerAdapter f16690k;
    public AbstractFbErrorReporter f16691l;
    public StickerKeyboardIntentUtil f16692m;
    public StickerKeyboardLogger f16693n;
    public DefaultBlueServiceOperationFactory f16694o;
    public FbSharedPreferences f16695p;
    private AnalyticsTagger f16696q;
    public FutureAndCallbackHolder<OperationResult> f16697r;
    public FutureAndCallbackHolder<OperationResult> f16698s;
    public FutureAndCallbackHolder<OperationResult> f16699t;
    public String f16700u;
    private Provider<Boolean> f16701v;
    private Provider<Boolean> f16702w;
    public DefaultAppChoreographer f16703x;
    public StickerKeyboardMetadataLoader f16704y;
    private boolean f16705z;

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    class C11631 implements Listener {
        final /* synthetic */ StickerKeyboardView f16652a;

        C11631(StickerKeyboardView stickerKeyboardView) {
            this.f16652a = stickerKeyboardView;
        }

        public final void mo1270a(Object obj) {
            StickerKeyboardTabItem stickerKeyboardTabItem = (StickerKeyboardTabItem) obj;
            this.f16652a.f16700u = stickerKeyboardTabItem.f16645c;
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    public class C11642 {
        public final /* synthetic */ StickerKeyboardView f16653a;

        C11642(StickerKeyboardView stickerKeyboardView) {
            this.f16653a = stickerKeyboardView;
        }

        public final void m24480a(Sticker sticker, String str) {
            StickerKeyboardView stickerKeyboardView = this.f16653a;
            if (stickerKeyboardView.f16685f != null) {
                StickerKeyboardLogger stickerKeyboardLogger = stickerKeyboardView.f16693n;
                HoneyClientEvent a = StickerLogger.m23897a("sticker_keyboard");
                a.b("action", "sticker_selected");
                a.b("sticker", sticker.f4938a);
                a.b("sticker_pack", str);
                stickerKeyboardLogger.f16635a.m23900a(a);
                stickerKeyboardView.m24509a(sticker);
                stickerKeyboardView.f16684e.m23926a(sticker, StickerKeyboardView.f16668d);
                stickerKeyboardView.f16685f.m24495a(sticker);
            }
        }

        public final void m24482b(StickerPack stickerPack) {
            this.f16653a.f16679K.m23936a(stickerPack);
        }

        public final void m24483c() {
            if (this.f16653a.f16685f != null) {
                this.f16653a.f16685f.m24497b();
            }
        }

        public final void m24481a(String str) {
            if (this.f16653a.f16685f != null) {
                this.f16653a.f16685f.m24496a(str);
            }
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    class C11653 implements ActionReceiver {
        final /* synthetic */ StickerKeyboardView f16654a;

        C11653(StickerKeyboardView stickerKeyboardView) {
            this.f16654a = stickerKeyboardView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -226021946);
            String action = intent.getAction();
            if ("com.facebook.orca.stickers.DOWNLOAD_QUEUED".equals(action)) {
                StickerPack stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
                this.f16654a.f16700u = stickerPack.f4955a;
            } else if ("com.facebook.orca.stickers.STICKER_CONFIG_CHANGED".equals(action)) {
                this.f16654a.f16704y.a();
                StickerKeyboardView.m24505h(this.f16654a);
            }
            LogUtils.e(884380168, a);
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    class C11674 implements Callback<StickerKeyboardMetadataLoader$Params, StickerKeyboardMetadataLoader$Results, Throwable> {
        final /* synthetic */ StickerKeyboardView f16657a;

        C11674(StickerKeyboardView stickerKeyboardView) {
            this.f16657a = stickerKeyboardView;
        }

        public final void m24486b(Object obj, Object obj2) {
            final StickerKeyboardMetadataLoader$Results stickerKeyboardMetadataLoader$Results = (StickerKeyboardMetadataLoader$Results) obj2;
            BLog.b(StickerKeyboardView.f16667c, "fetchStickerMetadataWithLoader succeeded");
            this.f16657a.findViewById(2131565132).setVisibility(4);
            ExecutorDetour.a(this.f16657a.f16688i, new Runnable(this) {
                final /* synthetic */ C11674 f16656b;

                public void run() {
                    this.f16656b.f16657a.f16669A.clear();
                    this.f16656b.f16657a.f16669A.addAll(stickerKeyboardMetadataLoader$Results.f16644c);
                    this.f16656b.f16657a.f16670B = stickerKeyboardMetadataLoader$Results.f16642a;
                    this.f16656b.f16657a.f16671C = Lists.a(stickerKeyboardMetadataLoader$Results.f16643b);
                    StickerKeyboardView.m24506i(this.f16656b.f16657a);
                }
            }, 633024005);
        }

        public final void m24487c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            BLog.b(StickerKeyboardView.f16667c, "fetchStickerMetadataWithLoader failed");
            this.f16657a.f16691l.a(StickerKeyboardView.f16667c.getName(), "fetch sticker metadata failed", th);
            Sequence e = this.f16657a.f16676H.e(StickerSequences.f16770a);
            if (e != null) {
                SequenceLoggerDetour.c(e, "StickerPackLoadForPopup", 1817809053);
            }
        }

        public final void m24484a(Object obj, ListenableFuture listenableFuture) {
            this.f16657a.f16703x.a(listenableFuture);
            this.f16657a.findViewById(2131565132).setVisibility(0);
            if (this.f16657a.f16685f != null) {
                this.f16657a.f16685f.m24498c();
            }
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    class C11685 implements OnClickListener {
        final /* synthetic */ StickerKeyboardView f16658a;

        C11685(StickerKeyboardView stickerKeyboardView) {
            this.f16658a = stickerKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1888515895);
            StickerKeyboardIntentUtil stickerKeyboardIntentUtil = this.f16658a.f16692m;
            Serializable serializable = this.f16658a.f16683O;
            StickerKeyboardLogger stickerKeyboardLogger = stickerKeyboardIntentUtil.f16632c;
            HoneyClientEvent a2 = StickerLogger.m23897a("sticker_keyboard");
            a2.b("action", "sticker_store_opened");
            stickerKeyboardLogger.f16635a.m23900a(a2);
            Intent intent = new Intent(stickerKeyboardIntentUtil.f16630a, StickerStoreActivity.class);
            intent.putExtra("stickerContext", serializable);
            if (serializable == StickerInterface.COMMENTS) {
                stickerKeyboardIntentUtil.f16634e.a(StickerSequences.f16772c);
            }
            stickerKeyboardIntentUtil.f16631b.a(intent, stickerKeyboardIntentUtil.f16630a);
            StickerKeyboardView.m24508k(this.f16658a);
            Logger.a(2, EntryType.UI_INPUT_END, 51674673, a);
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    public class C11696 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ StickerPack f16659a;
        final /* synthetic */ StickerKeyboardView f16660b;

        public C11696(StickerKeyboardView stickerKeyboardView, StickerPack stickerPack) {
            this.f16660b = stickerKeyboardView;
            this.f16659a = stickerPack;
        }

        protected final void m24488a(Object obj) {
            this.f16660b.f16698s = null;
        }

        protected final void m24489a(Throwable th) {
            BLog.b(StickerKeyboardView.f16667c, th, "Unable to close sticker pack %s", new Object[]{this.f16659a.f4955a});
            this.f16660b.f16698s = null;
            this.f16660b.f16691l.a(StickerKeyboardView.f16667c.getName(), "Marking sticker pack as closed failed", th);
        }
    }

    /* compiled from: edit_story_privacy_fragment_option_fetch_error */
    public interface StickerKeyboardListener {
        void m24494a();

        void m24495a(Sticker sticker);

        void m24496a(String str);

        void m24497b();

        void m24498c();
    }

    private static <T extends View> void m24501a(Class<T> cls, T t) {
        m24502a((Object) t, t.getContext());
    }

    private static void m24502a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        StickerKeyboardView stickerKeyboardView = (StickerKeyboardView) obj;
        StickerAssetManager a = StickerAssetManager.m23923a(injectorLike);
        StickerTabbedPagerAdapterProvider stickerTabbedPagerAdapterProvider = (StickerTabbedPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StickerTabbedPagerAdapterProvider.class);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        StickerKeyboardIntentUtil a2 = StickerKeyboardIntentUtil.m24475a(injectorLike);
        StickerKeyboardLogger a3 = StickerKeyboardLogger.m24476a(injectorLike);
        DefaultBlueServiceOperationFactory a4 = DefaultBlueServiceOperationFactory.a(injectorLike);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        AnalyticsTagger a5 = AnalyticsTagger.a(injectorLike);
        IdBasedProvider.a(injectorLike, 4340);
        stickerKeyboardView.m24500a(a, stickerTabbedPagerAdapterProvider, abstractFbErrorReporter, a2, a3, a4, fbSharedPreferences, a5, IdBasedProvider.a(injectorLike, 4338), IdBasedProvider.a(injectorLike, 4341), DefaultAppChoreographer.a(injectorLike), StickerKeyboardMetadataLoader.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), StickerDownloadManager.m23933a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public StickerKeyboardView(Context context) {
        this(context, null);
    }

    private StickerKeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StickerKeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(ContextUtils.a(context, 2130773088, 2131625134), attributeSet, i);
        m24504g();
    }

    public void setInterface(StickerInterface stickerInterface) {
        if (this.f16683O != stickerInterface) {
            this.f16683O = stickerInterface;
            if (this.f16690k != null) {
                this.f16690k.m24545a(stickerInterface);
                if (this.f16687h != null) {
                    this.f16704y.a();
                    m24505h(this);
                }
            }
        }
    }

    private void m24504g() {
        boolean z = true;
        m24501a(StickerKeyboardView.class, (View) this);
        TracerDetour.a("StickerKeyboard create view", -339048714);
        try {
            LayoutInflater layoutInflater = 292622587;
            TracerDetour.a("StickerKeyboard onCreateView layoutInflation", 292622587);
            try {
                boolean z2;
                layoutInflater = LayoutInflater.from(getContext());
                layoutInflater.inflate(2130905855, this, true);
                TracerDetour.a(2130905855);
                this.f16686g = (TabbedPager) c(2131564505);
                ((FbTextView) this.f16686g.findViewById(2131564429)).setText("");
                this.f16696q.a(this, "sticker_keyboard", getClass());
                setFocusableInTouchMode(true);
                this.f16705z = false;
                this.f16669A = Lists.a();
                this.f16686g.setListener(new C11631(this));
                this.f16690k = this.f16689j.m24551a(getContext(), layoutInflater);
                this.f16690k.m24544a(new C11642(this));
                this.f16690k.m24545a(this.f16683O);
                this.f16686g.setAdapter(this.f16690k);
                this.f16682N = new C11653(this);
                this.f16681M = this.f16680L.a().a("com.facebook.orca.stickers.DOWNLOAD_QUEUED", this.f16682N).a("com.facebook.orca.stickers.STICKER_CONFIG_CHANGED", this.f16682N).a();
                if (this.f16677I == null || !this.f16677I.a(36, false)) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                this.f16678J = z2;
            } finally {
                z = true;
                TracerDetour.a(283087851);
            }
        } finally {
            z = true;
            TracerDetour.a(1322138276);
        }
    }

    @Inject
    private void m24500a(StickerAssetManager stickerAssetManager, StickerTabbedPagerAdapterProvider stickerTabbedPagerAdapterProvider, FbErrorReporter fbErrorReporter, StickerKeyboardIntentUtil stickerKeyboardIntentUtil, StickerKeyboardLogger stickerKeyboardLogger, BlueServiceOperationFactory blueServiceOperationFactory, FbSharedPreferences fbSharedPreferences, AnalyticsTagger analyticsTagger, Provider<Boolean> provider, Provider<Boolean> provider2, AppChoreographer appChoreographer, StickerKeyboardMetadataLoader stickerKeyboardMetadataLoader, ListeningExecutorService listeningExecutorService, SequenceLogger sequenceLogger, StickerDownloadManager stickerDownloadManager, FbBroadcastManager fbBroadcastManager, GatekeeperStore gatekeeperStore) {
        this.f16684e = stickerAssetManager;
        this.f16689j = stickerTabbedPagerAdapterProvider;
        this.f16691l = fbErrorReporter;
        this.f16692m = stickerKeyboardIntentUtil;
        this.f16693n = stickerKeyboardLogger;
        this.f16694o = blueServiceOperationFactory;
        this.f16695p = fbSharedPreferences;
        this.f16696q = analyticsTagger;
        this.f16701v = provider;
        this.f16702w = provider2;
        this.f16703x = appChoreographer;
        this.f16704y = stickerKeyboardMetadataLoader;
        this.f16688i = listeningExecutorService;
        this.f16676H = sequenceLogger;
        this.f16679K = stickerDownloadManager;
        this.f16680L = fbBroadcastManager;
        this.f16677I = gatekeeperStore;
    }

    public final void m24510a(String str) {
        this.f16700u = str;
        this.f16695p.edit().a(StickerPrefKeys.c, str).commit();
        if (this.f16686g != null && this.f16686g.f12149n) {
            this.f16686g.m19087a(str);
        }
    }

    public final void m24511e() {
        StickerTabbedPagerAdapter stickerTabbedPagerAdapter = this.f16690k;
        if (stickerTabbedPagerAdapter.f16765t != null && stickerTabbedPagerAdapter.f16765t.f16782g) {
            ExpandableFrameLayout expandableFrameLayout = stickerTabbedPagerAdapter.f16765t;
            ((InputMethodManager) expandableFrameLayout.getContext().getSystemService("input_method")).hideSoftInputFromWindow(expandableFrameLayout.f16776a.getWindowToken(), 0);
            ExpandableFrameLayout.m24556f(expandableFrameLayout);
            expandableFrameLayout.f16777b.b(0.0d);
            expandableFrameLayout.f16777b.l();
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        boolean z2 = true;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Preconditions.checkArgument(mode == 1073741824);
        if (mode2 == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        mode = MeasureSpec.getSize(i);
        mode2 = MeasureSpec.getSize(i2);
        if (mode > 0 && mode2 > 0) {
            Resources resources = getResources();
            if (this.f16687h != null) {
                z2 = false;
            }
            this.f16687h = new GridSizingCalculator(resources, new StickerGridSizingParams()).m11042a(mode, mode2 - resources.getDimensionPixelSize(2131427864), false);
            if (z2) {
                m24505h(this);
            }
            this.f16690k.f16759n = this.f16687h;
        }
        super.onMeasure(i, i2);
    }

    public static void m24505h(StickerKeyboardView stickerKeyboardView) {
        Tracer.b("fetchStickerMetadataWithLoader started");
        stickerKeyboardView.f16704y.a(new C11674(stickerKeyboardView));
        Sequence e = stickerKeyboardView.f16676H.e(StickerSequences.f16770a);
        if (e != null) {
            SequenceLoggerDetour.a(e, "StickerPackLoadForPopup", 1430731853);
        }
        stickerKeyboardView.f16704y.a(new StickerKeyboardMetadataLoader$Params(false, stickerKeyboardView.f16683O));
    }

    public static void m24506i(StickerKeyboardView stickerKeyboardView) {
        TracerDetour.a("StickerKeyboard updateStickerPacks", -1325051643);
        try {
            Sequence e = stickerKeyboardView.f16676H.e(StickerSequences.f16770a);
            if (e != null) {
                SequenceLoggerDetour.a(e, "StickerKeyboardPopulatePacks", -443174883);
            }
            try {
                String str;
                Set a = Sets.a();
                stickerKeyboardView.f16672D = Lists.a();
                if (stickerKeyboardView.f16700u != null) {
                    str = stickerKeyboardView.f16700u;
                } else {
                    str = stickerKeyboardView.f16695p.a(StickerPrefKeys.c, null);
                }
                int a2 = stickerKeyboardView.f16695p.a(StickerPrefKeys.e, 0);
                stickerKeyboardView.f16686g.m19085a();
                if ((((Boolean) stickerKeyboardView.f16701v.get()).booleanValue() && stickerKeyboardView.f16683O != StickerInterface.COMMENTS) || (stickerKeyboardView.f16678J && stickerKeyboardView.f16683O == StickerInterface.COMMENTS)) {
                    stickerKeyboardView.f16672D.add(f16666b);
                }
                if (!stickerKeyboardView.f16669A.isEmpty()) {
                    stickerKeyboardView.f16705z = true;
                    stickerKeyboardView.f16672D.add(f16665a);
                }
                stickerKeyboardView.f16690k.m24546a(stickerKeyboardView.f16669A);
                stickerKeyboardView.f16674F = stickerKeyboardView.f16672D.size();
                if (stickerKeyboardView.f16673E == null || !stickerKeyboardView.f16673E.m7725a(stickerKeyboardView.f16683O) || StickerUtil.m7772b(stickerKeyboardView.f16670B, stickerKeyboardView.f16673E.m7724a())) {
                    stickerKeyboardView.f16673E = null;
                } else {
                    stickerKeyboardView.f16672D.add(new StickerKeyboardPackPopupTabItem(stickerKeyboardView.f16673E, TabType.PULSING_DOWNLOAD_PREVIEW));
                }
                for (StickerPack stickerPack : stickerKeyboardView.f16670B) {
                    if (stickerPack.m7725a(stickerKeyboardView.f16683O)) {
                        a.add(stickerPack.m7724a());
                        stickerKeyboardView.f16672D.add(new StickerKeyboardPackPopupTabItem(stickerPack, TabType.DOWNLOADED));
                    }
                }
                stickerKeyboardView.f16686g.setShowStartTabButton(false);
                stickerKeyboardView.f16686g.setShowEndTabButton(true);
                stickerKeyboardView.f16686g.setEndTabButtonOnClickListener(new C11685(stickerKeyboardView));
                stickerKeyboardView.f16686g.setEndTabButtonContentDescription(stickerKeyboardView.getContext().getString(2131231302));
                stickerKeyboardView.m24499a(stickerKeyboardView.f16695p.a(StickerPrefKeys.h, 0));
                if (((Boolean) stickerKeyboardView.f16702w.get()).booleanValue()) {
                    for (StickerPack stickerPack2 : stickerKeyboardView.f16671C) {
                        if (stickerPack2.m7725a(stickerKeyboardView.f16683O) && (stickerKeyboardView.f16673E == null || !stickerPack2.m7724a().equals(stickerKeyboardView.f16673E.m7724a()))) {
                            a.add(stickerPack2.m7724a());
                            stickerKeyboardView.f16672D.add(new StickerKeyboardPackPopupTabItem(stickerPack2, TabType.DOWNLOAD_PREVIEW));
                        }
                    }
                } else {
                    stickerKeyboardView.m24507j();
                }
                stickerKeyboardView.f16686g.setItems(stickerKeyboardView.f16672D);
                stickerKeyboardView.f16686g.m19087a(str);
                stickerKeyboardView.f16686g.m19088a(str, a2);
            } catch (Throwable th) {
                Sequence e2 = stickerKeyboardView.f16676H.e(StickerSequences.f16770a);
                if (e2 != null) {
                    SequenceLoggerDetour.c(e2, "StickerKeyboardPopulatePacks", -817058292);
                    SequenceLoggerDetour.c(e2, "StickerPackLoadForPopup", -727863971);
                    stickerKeyboardView.f16676H.b(StickerSequences.f16770a);
                }
            }
        } finally {
            TracerDetour.a(1877786254);
        }
    }

    private void m24507j() {
        Set a = Sets.a();
        for (StickerKeyboardTabItem stickerKeyboardTabItem : this.f16672D) {
            a.add(stickerKeyboardTabItem.f16645c);
        }
        final Set set = a;
        Builder builder = new Builder(StickerPackType.STORE_PACKS, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        builder.c = StickerInterfaceTranslator.m23958a(this.f16683O);
        FetchStickerPacksParams a2 = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a2);
        OperationFuture a3 = BlueServiceOperationFactoryDetour.a(this.f16694o, "fetch_sticker_packs", bundle, 1193995831).a();
        C11707 c11707 = new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ StickerKeyboardView f16662b;

            public final void m24490a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                Class cls = StickerKeyboardView.f16667c;
                this.f16662b.f16697r = null;
                ImmutableList immutableList = (ImmutableList) ((FetchStickerPacksResult) operationResult.h()).b.get();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    StickerPack stickerPack = (StickerPack) immutableList.get(i);
                    if (!set.contains(stickerPack.f4955a) && stickerPack.m7725a(this.f16662b.f16683O) && stickerPack.f4971q) {
                        this.f16662b.f16672D.add(new StickerKeyboardPackPopupTabItem(stickerPack, TabType.PROMOTED));
                    }
                }
                this.f16662b.f16686g.setItems(this.f16662b.f16672D);
                Sequence e = this.f16662b.f16676H.e(StickerSequences.f16770a);
                if (e != null) {
                    SequenceLoggerDetour.b(e, "StickerKeyboardPopulatePacks", 1106631704);
                    SequenceLoggerDetour.b(e, "StickerPackLoadForPopup", 518881848);
                    this.f16662b.f16676H.b(StickerSequences.f16770a);
                }
            }

            public final void m24491a(Throwable th) {
                BLog.b(StickerKeyboardView.f16667c, "Fetching promoted sticker packs failed", th);
                this.f16662b.f16697r = null;
                Sequence e = this.f16662b.f16676H.e(StickerSequences.f16770a);
                if (e != null) {
                    SequenceLoggerDetour.c(e, "StickerKeyboardPopulatePacks", 2035170415);
                    SequenceLoggerDetour.c(e, "StickerPackLoadForPopup", -1253767549);
                    this.f16662b.f16676H.b(StickerSequences.f16770a);
                }
                this.f16662b.f16691l.a(StickerKeyboardView.f16667c.getName(), "Fetching promoted sticker packs failed", th);
            }
        };
        this.f16697r = FutureAndCallbackHolder.a(a3, c11707);
        Futures.a(a3, c11707, this.f16688i);
    }

    private void m24499a(int i) {
        String num;
        boolean z;
        if (i <= 9) {
            num = Integer.toString(i);
        } else {
            num = getResources().getString(2131231710, new Object[]{Integer.valueOf(9)});
        }
        this.f16686g.setEndTabButtonBadgeText(num);
        TabbedPager tabbedPager = this.f16686g;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        tabbedPager.setEndTabButtonBadgeVisibility(z);
    }

    public static void m24508k(StickerKeyboardView stickerKeyboardView) {
        if (stickerKeyboardView.f16685f != null) {
            stickerKeyboardView.f16685f.m24494a();
        }
    }

    public final void m24509a(final Sticker sticker) {
        Object obj;
        if (!this.f16705z) {
            int indexOf = this.f16672D.indexOf(f16666b);
            indexOf = indexOf >= 0 ? indexOf + 1 : 0;
            this.f16672D.add(indexOf, f16665a);
            this.f16686g.m19086a(indexOf, f16665a);
            this.f16705z = true;
            this.f16674F++;
        }
        List<Sticker> list = this.f16669A;
        String str = sticker.f4938a;
        for (Sticker sticker2 : list) {
            if (sticker2.f4938a.equals(str)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null && this.f16705z) {
            this.f16669A.add(0, sticker);
            if (this.f16669A.size() > 16) {
                this.f16669A.subList(16, this.f16669A.size()).clear();
            }
        }
        this.f16690k.m24546a(this.f16669A);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sticker", sticker);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f16694o, "update_recent_stickers", bundle, -426865412).a();
        C11718 c11718 = new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ StickerKeyboardView f16664b;

            public final void m24492a(Object obj) {
                Class cls = StickerKeyboardView.f16667c;
                new StringBuilder("Sticker added to recent list: ").append(sticker.f4938a);
                this.f16664b.f16699t = null;
            }

            public final void m24493a(Throwable th) {
                BLog.b(StickerKeyboardView.f16667c, "Updating recent stickers failed", th);
                this.f16664b.f16699t = null;
                this.f16664b.f16691l.a(StickerKeyboardView.f16667c.getName(), "Updating recent stickers failed", th);
            }
        };
        this.f16699t = FutureAndCallbackHolder.a(a, c11718);
        Futures.a(a, c11718, this.f16688i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1415528532);
        super.onAttachedToWindow();
        this.f16681M.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -489403319, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1699479448);
        super.onDetachedFromWindow();
        this.f16681M.c();
        if (!StringUtil.a(this.f16700u)) {
            this.f16695p.edit().a(StickerPrefKeys.c, this.f16700u).a(StickerPrefKeys.e, this.f16686g.getTabContainerScrollOffsetToRestore()).commit();
        }
        if (this.f16697r != null) {
            this.f16697r.a(false);
            this.f16697r = null;
        }
        if (this.f16699t != null) {
            this.f16699t.a(false);
            this.f16699t = null;
        }
        if (this.f16698s != null) {
            this.f16698s.a(false);
            this.f16698s = null;
        }
        this.f16704y.a();
        this.f16704y.a(null);
        this.f16686g.f12151p = null;
        this.f16690k.f16760o = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1553560253, a);
    }

    public static void m24503c(StickerKeyboardView stickerKeyboardView, StickerPack stickerPack) {
        TabListAdapter tabListAdapter = stickerKeyboardView.f16686g.f12137b;
        String str = stickerPack.f4955a;
        int i = -1;
        if (tabListAdapter.f12121c != null) {
            int size = tabListAdapter.f12122d.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabListAdapter.f12121c.mo1279a(tabListAdapter.f12122d.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
        }
        int i3 = i;
        if (i3 >= 0) {
            if (stickerKeyboardView.f16673E != null && stickerPack.f4955a.equals(stickerKeyboardView.f16673E.f4955a)) {
                stickerKeyboardView.f16673E = null;
            }
            stickerKeyboardView.f16686g.m19090c(i3);
            stickerKeyboardView.f16672D.remove(i3);
        }
    }
}

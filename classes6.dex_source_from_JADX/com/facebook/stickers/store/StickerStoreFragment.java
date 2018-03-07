package com.facebook.stickers.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.stickers.analytics.StickerLogger;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.data.StickerInterfaceTranslator;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.listview.DragSortListView.DropListener;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
public class StickerStoreFragment extends FbFragment implements NavigableFragment, ActionReceiver {
    public static final Class<?> f16961a = StickerStoreFragment.class;
    public StickerStoreListAdapter aA;
    public LinkedHashMap<String, StickerPack> aB;
    public LinkedHashMap<String, StickerPack> aC;
    private boolean aD;
    public TabType aE;
    public TabType aF;
    public boolean aG;
    public Optional<StickerInterface> aH = Absent.INSTANCE;
    private Clock aI;
    private StickerLogger al;
    private AnalyticsTagger am;
    public MonotonicClock an;
    public SequenceLogger ao;
    public ErrorDialogs ap;
    private FbTitleBar aq;
    private TitleBarButtonSpec ar;
    private TitleBarButtonSpec as;
    private boolean at;
    private TextView au;
    private TextView av;
    private TextView aw;
    private ViewGroup ax;
    private StickerStoreListView ay;
    private EmptyListViewItem az;
    private Context f16962b;
    private BaseFbBroadcastManager f16963c;
    public AbstractFbErrorReporter f16964d;
    private Listener f16965e;
    private DefaultBlueServiceOperationFactory f16966f;
    private SelfRegistrableReceiverImpl f16967g;
    private StickerDownloadManager f16968h;
    private FbSharedPreferences f16969i;

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12151 implements OnClickListener {
        final /* synthetic */ StickerStoreFragment f16949a;

        C12151(StickerStoreFragment stickerStoreFragment) {
            this.f16949a = stickerStoreFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2091088095);
            Activity ao = this.f16949a.ao();
            if (ao != null) {
                ao.onBackPressed();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1931116344, a);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    public class C12162 {
        final /* synthetic */ StickerStoreFragment f16950a;

        C12162(StickerStoreFragment stickerStoreFragment) {
            this.f16950a = stickerStoreFragment;
        }

        public final void m24650a(StickerPack stickerPack, boolean z, String str) {
            this.f16950a.m24661a(stickerPack, z, str);
        }

        public final void m24649a(StickerPack stickerPack, StickerStoreListAdapter stickerStoreListAdapter, boolean z, StickerStoreListItemView stickerStoreListItemView) {
            this.f16950a.m24659a(stickerPack, stickerStoreListAdapter, z, stickerStoreListItemView);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12173 implements DropListener {
        final /* synthetic */ StickerStoreFragment f16951a;

        C12173(StickerStoreFragment stickerStoreFragment) {
            this.f16951a = stickerStoreFragment;
        }

        public final void mo1288a(int i, int i2) {
            StickerStoreListAdapter stickerStoreListAdapter = this.f16951a.aA;
            StickerPack stickerPack = (StickerPack) stickerStoreListAdapter.getItem(i);
            stickerStoreListAdapter.remove(stickerPack);
            stickerStoreListAdapter.insert(stickerPack, i2);
            stickerStoreListAdapter.f16980d = true;
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12184 implements OnClickListener {
        final /* synthetic */ StickerStoreFragment f16952a;

        C12184(StickerStoreFragment stickerStoreFragment) {
            this.f16952a = stickerStoreFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1526447086);
            this.f16952a.m24680b(false);
            Logger.a(2, EntryType.UI_INPUT_END, 1862915842, a);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12195 implements OnClickListener {
        final /* synthetic */ StickerStoreFragment f16953a;

        C12195(StickerStoreFragment stickerStoreFragment) {
            this.f16953a = stickerStoreFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -432552801);
            StickerStoreFragment.m24697h(this.f16953a, false);
            Logger.a(2, EntryType.UI_INPUT_END, 1331826871, a);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12206 implements OnClickListener {
        final /* synthetic */ StickerStoreFragment f16954a;

        C12206(StickerStoreFragment stickerStoreFragment) {
            this.f16954a = stickerStoreFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1896940780);
            StickerStoreFragment.m24699i(this.f16954a, false);
            Logger.a(2, EntryType.UI_INPUT_END, -1322636903, a);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    class C12217 implements FutureCallback<OperationResult> {
        final /* synthetic */ StickerStoreFragment f16955a;

        C12217(StickerStoreFragment stickerStoreFragment) {
            this.f16955a = stickerStoreFragment;
        }

        public void onSuccess(Object obj) {
            ImmutableList immutableList = (ImmutableList) ((FetchStickerPacksResult) ((OperationResult) obj).h()).b.get();
            this.f16955a.aB.clear();
            this.f16955a.aC.clear();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                StickerPack stickerPack = (StickerPack) immutableList.get(i);
                if (stickerPack.m7725a((StickerInterface) this.f16955a.aH.get())) {
                    this.f16955a.aB.put(stickerPack.f4955a, stickerPack);
                } else {
                    this.f16955a.aC.put(stickerPack.f4955a, stickerPack);
                }
            }
            this.f16955a.aG = true;
            this.f16955a.m24673a(true);
            Sequence e = this.f16955a.ao.e(StickerSequences.f16772c);
            if (e != null) {
                SequenceLoggerDetour.b(e, "StickerFetchingStickerPacks", null, null, this.f16955a.an.now(), 631739863);
            }
            this.f16955a.ao.b(StickerSequences.f16772c);
        }

        public void onFailure(Throwable th) {
            BLog.b(StickerStoreFragment.f16961a, "Fetching downloaded sticker packs failed", th);
            this.f16955a.f16964d.a(StickerStoreFragment.f16961a.getName(), "Fetching downloaded sticker packs failed", th);
            this.f16955a.m24673a(true);
            Sequence e = this.f16955a.ao.e(StickerSequences.f16772c);
            if (e != null) {
                SequenceLoggerDetour.c(e, "StickerFetchingStickerPacks", null, null, this.f16955a.an.now(), -464007618);
            }
            this.f16955a.ao.b(StickerSequences.f16772c);
        }
    }

    /* compiled from: e3a64b7a90255550e915b5f07aa1e8ea */
    enum TabType {
        FEATURED,
        AVAILABLE,
        OWNED
    }

    private static <T extends InjectableComponentWithContext> void m24668a(Class<T> cls, T t) {
        m24669a((Object) t, t.getContext());
    }

    private static void m24669a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerStoreFragment) obj).m24656a(AnalyticsTagger.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), StickerDownloadManager.m23933a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), StickerLogger.m23898a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), ErrorDialogs.a(injectorLike));
    }

    public final View m24702a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1784353841);
        m24668a(StickerStoreFragment.class, (InjectableComponentWithContext) this);
        this.f16962b = ContextUtils.a(getContext(), 2130773101, 2131625136);
        View inflate = LayoutInflater.from(this.f16962b).inflate(2130905863, viewGroup, false);
        this.am.a(inflate, "sticker_store", this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1263073623, a);
        return inflate;
    }

    @Inject
    private void m24656a(AnalyticsTagger analyticsTagger, BaseFbBroadcastManager baseFbBroadcastManager, AbstractFbErrorReporter abstractFbErrorReporter, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, StickerDownloadManager stickerDownloadManager, FbSharedPreferences fbSharedPreferences, StickerLogger stickerLogger, Clock clock, MonotonicClock monotonicClock, SequenceLogger sequenceLogger, ErrorDialogs errorDialogs) {
        this.am = analyticsTagger;
        this.f16963c = baseFbBroadcastManager;
        this.f16964d = abstractFbErrorReporter;
        this.f16966f = defaultBlueServiceOperationFactory;
        this.f16968h = stickerDownloadManager;
        this.f16969i = fbSharedPreferences;
        this.al = stickerLogger;
        this.aI = clock;
        this.aE = TabType.FEATURED;
        this.an = monotonicClock;
        this.ao = sequenceLogger;
        this.ap = errorDialogs;
    }

    public final void m24707d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1066896158);
        super.d(bundle);
        if (ao() instanceof StickerStoreActivity) {
            this.aq = ((StickerStoreActivity) ao()).f16929A;
            this.aq.a(new C12151(this));
            this.aH = Optional.of(((StickerStoreActivity) ao()).f16941y);
        }
        Builder a2 = TitleBarButtonSpec.a();
        a2.a = 1;
        a2 = a2;
        a2.g = jW_().getString(2131231299);
        a2 = a2;
        a2.f = "sticker_store_edit";
        a2 = a2;
        a2.h = -2;
        this.ar = a2.a();
        a2 = TitleBarButtonSpec.a();
        a2.a = 2;
        a2 = a2;
        a2.g = jW_().getString(2131231300);
        a2 = a2;
        a2.f = "sticker_store_done";
        a2 = a2;
        a2.h = -2;
        this.as = a2.a();
        this.at = false;
        this.au = (TextView) e(2131565152);
        this.av = (TextView) e(2131565153);
        this.aw = (TextView) e(2131565154);
        this.ax = (ViewGroup) e(2131565155);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f16962b).inflate(2130905867, this.ax, true);
        this.ay = (StickerStoreListView) FindViewUtil.b(viewGroup, 2131565166);
        this.az = (EmptyListViewItem) FindViewUtil.b(viewGroup, 2131565167);
        this.az.setBackgroundColor(jW_().getColor(17170445));
        this.ay.setEmptyView(this.az);
        this.aA = new StickerStoreListAdapter(this.f16962b, (StickerInterface) this.aH.get());
        this.aA.f16977a = new C12162(this);
        this.ay.setAdapter(this.aA);
        this.ay.f6021m = new C12173(this);
        aq();
        this.f16967g = this.f16963c.a().a("com.facebook.orca.stickers.DOWNLOAD_PROGRESS", this).a("com.facebook.orca.stickers.DOWNLOAD_SUCCESS", this).a("com.facebook.orca.stickers.DOWNLOAD_FAILURE", this).a();
        this.f16967g.b();
        this.aB = Maps.d();
        this.aC = Maps.d();
        ar();
        Sequence e = this.ao.e(StickerSequences.f16772c);
        if (e != null) {
            SequenceLoggerDetour.b(e, "StickerCreateStickerStoreActivity", null, null, this.an.now(), -798715026);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1477673034, a);
    }

    public final void m24701I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1067813506);
        if (this.f16967g != null) {
            this.f16967g.c();
            this.f16967g = null;
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1617030337, a);
    }

    public final void m24706c(boolean z) {
        super.c(z);
        if (!z) {
            m24673a(false);
            aq();
        }
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 427922237);
        StickerPack stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
        if (stickerPack == null) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1678399233, a);
            return;
        }
        if ("com.facebook.orca.stickers.DOWNLOAD_SUCCESS".equals(intent.getAction())) {
            if (this.aH.isPresent() && stickerPack.m7725a((StickerInterface) this.aH.get())) {
                this.aB.put(stickerPack.f4955a, stickerPack);
            } else {
                this.aC.put(stickerPack.f4955a, stickerPack);
            }
            BaseAdapter baseAdapter = this.aA;
            if (1 != 0) {
                baseAdapter.f16978b.put(stickerPack.f4955a, stickerPack);
            } else if (baseAdapter.f16978b.containsKey(stickerPack.f4955a)) {
                baseAdapter.f16978b.remove(stickerPack.f4955a);
            }
            AdapterDetour.a(baseAdapter, 1802283755);
        }
        LogUtils.e(332469304, a);
    }

    public final void m24703a(Listener listener) {
        this.f16965e = listener;
    }

    private void aq() {
        this.au.setOnClickListener(new C12184(this));
        this.av.setOnClickListener(new C12195(this));
        this.aw.setOnClickListener(new C12206(this));
        TypedValue typedValue = new TypedValue();
        this.f16962b.getTheme().resolveAttribute(2130773113, typedValue, false);
        if (typedValue.type == 18 && Boolean.valueOf(typedValue.coerceToString().toString()).booleanValue()) {
            this.au.setText(this.au.getText().toString().toUpperCase(Locale.getDefault()));
            this.av.setText(this.av.getText().toString().toUpperCase(Locale.getDefault()));
            this.aw.setText(this.aw.getText().toString().toUpperCase(Locale.getDefault()));
        }
    }

    private void ar() {
        Sequence e = this.ao.e(StickerSequences.f16772c);
        if (e != null) {
            SequenceLoggerDetour.a(e, "StickerFetchingStickerPacks", null, null, this.an.now(), -2004652811);
        }
        Futures.a(m24653a(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE), new C12217(this));
    }

    private void m24673a(boolean z) {
        switch (this.aE) {
            case FEATURED:
                m24680b(z);
                return;
            case AVAILABLE:
                m24697h(this, z);
                return;
            case OWNED:
                m24699i(this, z);
                return;
            default:
                BLog.b(f16961a, "Unknown tab specified for reload: %s", new Object[]{this.aE});
                return;
        }
    }

    private void m24680b(boolean z) {
        this.at = false;
        if (this.aE != TabType.FEATURED || z) {
            as();
            m24662a(StickerPackType.STORE_PACKS, TabType.FEATURED);
            m24676b(TabType.FEATURED);
        }
    }

    public static void m24697h(StickerStoreFragment stickerStoreFragment, boolean z) {
        stickerStoreFragment.at = false;
        if (stickerStoreFragment.aE != TabType.AVAILABLE || z) {
            stickerStoreFragment.as();
            stickerStoreFragment.m24662a(StickerPackType.STORE_PACKS, TabType.AVAILABLE);
            stickerStoreFragment.m24676b(TabType.AVAILABLE);
        }
    }

    public static void m24699i(StickerStoreFragment stickerStoreFragment, boolean z) {
        if (stickerStoreFragment.at) {
            stickerStoreFragment.aq.setButtonSpecs(ImmutableList.of(stickerStoreFragment.as));
        } else {
            stickerStoreFragment.aq.setButtonSpecs(ImmutableList.of(stickerStoreFragment.ar));
        }
        if (stickerStoreFragment.aE != TabType.OWNED || z) {
            stickerStoreFragment.m24662a(StickerPackType.OWNED_PACKS, TabType.OWNED);
            stickerStoreFragment.m24676b(TabType.OWNED);
        }
    }

    private void m24676b(TabType tabType) {
        boolean z;
        boolean z2 = true;
        this.aE = tabType;
        TextView textView = this.au;
        if (tabType == TabType.FEATURED) {
            z = true;
        } else {
            z = false;
        }
        textView.setSelected(z);
        textView = this.av;
        if (tabType == TabType.AVAILABLE) {
            z = true;
        } else {
            z = false;
        }
        textView.setSelected(z);
        TextView textView2 = this.aw;
        if (tabType != TabType.OWNED) {
            z2 = false;
        }
        textView2.setSelected(z2);
    }

    private void m24662a(final StickerPackType stickerPackType, final TabType tabType) {
        DataFreshnessParam dataFreshnessParam;
        if (this.aD || stickerPackType != StickerPackType.STORE_PACKS) {
            dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        } else {
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            this.aD = true;
        }
        OperationFuture a = m24653a(stickerPackType, dataFreshnessParam);
        if (this.aF != tabType) {
            m24672a((List) RegularImmutableList.a, false);
            av();
        }
        if (this.aG) {
            Futures.a(a, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ StickerStoreFragment f16958c;

                public void onSuccess(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    int i = 0;
                    if (this.f16958c.aE == tabType) {
                        StickerPack stickerPack;
                        List list = (ImmutableList) ((FetchStickerPacksResult) operationResult.h()).b.get();
                        if (stickerPackType == StickerPackType.DOWNLOADED_PACKS) {
                            this.f16958c.aB.clear();
                            this.f16958c.aC.clear();
                            int size = list.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                stickerPack = (StickerPack) list.get(i2);
                                if (stickerPack.m7725a((StickerInterface) this.f16958c.aH.get())) {
                                    this.f16958c.aB.put(stickerPack.f4955a, stickerPack);
                                } else {
                                    this.f16958c.aC.put(stickerPack.f4955a, stickerPack);
                                }
                            }
                        }
                        if (tabType == TabType.FEATURED || tabType == TabType.AVAILABLE) {
                            ImmutableList.Builder builder = new ImmutableList.Builder();
                            ImmutableList.Builder builder2 = new ImmutableList.Builder();
                            int size2 = list.size();
                            while (i < size2) {
                                stickerPack = (StickerPack) list.get(i);
                                if (tabType == TabType.AVAILABLE || stickerPack.f4970p) {
                                    if (stickerPack.m7725a((StickerInterface) this.f16958c.aH.get())) {
                                        builder.c(stickerPack);
                                    } else {
                                        builder2.c(stickerPack);
                                    }
                                }
                                i++;
                            }
                            list = builder.b(builder2.b()).b();
                        }
                        this.f16958c.m24671a(list);
                        this.f16958c.aF = tabType;
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(StickerStoreFragment.f16961a, th, "Fetching store packs tab failed: %s", new Object[]{tabType});
                    this.f16958c.f16964d.a(StickerStoreFragment.f16961a.getName(), "Fetching store packs tab failed: " + tabType, th);
                    this.f16958c.m24704a(tabType);
                    this.f16958c.m24670a(th);
                }
            });
        }
    }

    private OperationFuture m24653a(StickerPackType stickerPackType, DataFreshnessParam dataFreshnessParam) {
        FetchStickerPacksParams.Builder builder = new FetchStickerPacksParams.Builder(stickerPackType, dataFreshnessParam);
        builder.c = StickerInterfaceTranslator.m23958a((StickerInterface) this.aH.get());
        FetchStickerPacksParams a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        return BlueServiceOperationFactoryDetour.a(this.f16966f, "fetch_sticker_packs", bundle, 1405247658).a();
    }

    private void m24671a(final List<StickerPack> list) {
        TracerDetour.a("StickerStoreFragment loadListViewContent", -860692268);
        try {
            au();
            m24672a((List) list, false);
            this.f16969i.edit().a(StickerPrefKeys.g, this.aI.a() / 1000).a(StickerPrefKeys.h, 0).commit();
            if (this.aq != null) {
                this.aq.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
                    final /* synthetic */ StickerStoreFragment f16960b;

                    public final void m24652a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        switch (titleBarButtonSpec.c) {
                            case 1:
                                this.f16960b.m24679b(StickerStoreFragment.ax(this.f16960b));
                                return;
                            case 2:
                                if (this.f16960b.aA.f16980d) {
                                    StickerStoreFragment stickerStoreFragment = this.f16960b;
                                    StickerStoreListAdapter stickerStoreListAdapter = this.f16960b.aA;
                                    List a = Lists.a();
                                    for (int i = 0; i < stickerStoreListAdapter.getCount(); i++) {
                                        a.add(stickerStoreListAdapter.getItem(i));
                                    }
                                    StickerStoreFragment.m24691e(stickerStoreFragment, a);
                                }
                                this.f16960b.m24684c(list);
                                return;
                            default:
                                return;
                        }
                    }
                });
                if (this.aE == TabType.OWNED) {
                    this.aq.setButtonSpecs(ImmutableList.of(this.ar));
                } else {
                    as();
                }
            }
            TracerDetour.a(-961883689);
        } catch (Throwable th) {
            TracerDetour.a(1296577207);
        }
    }

    private void as() {
        if (this.aq != null) {
            this.aq.setButtonSpecs(RegularImmutableList.a);
        }
    }

    private void m24679b(List<StickerPack> list) {
        this.at = true;
        this.aq.setButtonSpecs(ImmutableList.of(this.as));
        m24672a((List) list, true);
    }

    private void m24684c(List<StickerPack> list) {
        this.at = false;
        this.aq.setButtonSpecs(ImmutableList.of(this.ar));
        m24672a((List) list, false);
    }

    private void at() {
        av();
    }

    private void au() {
        m24695g(2131231292);
    }

    private void m24670a(Throwable th) {
        int i = 2131230758;
        if ((th instanceof ServiceException) && ((ServiceException) th).errorCode == ErrorCode.CONNECTION_FAILURE) {
            i = 2131231301;
        }
        m24695g(i);
    }

    private void m24695g(int i) {
        this.az.setMessage(i);
        this.az.m8598a(false);
    }

    private void av() {
        this.az.setMessage(null);
        this.az.m8598a(true);
    }

    private void m24661a(StickerPack stickerPack, boolean z, String str) {
        if (this.f16965e != null) {
            m24657a(stickerPack);
            as();
            Intent intent = new Intent();
            intent.putExtra("stickerPack", stickerPack);
            intent.putExtra("isDownloaded", z);
            intent.putExtra("price", str);
            intent.putExtra("stickerContext", (Serializable) this.aH.get());
            this.f16965e.a(this, intent);
        }
    }

    private void m24659a(StickerPack stickerPack, StickerStoreListAdapter stickerStoreListAdapter, boolean z, StickerStoreListItemView stickerStoreListItemView) {
        if (z) {
            m24658a(stickerPack, stickerStoreListAdapter);
        } else {
            m24660a(stickerPack, stickerStoreListItemView);
        }
    }

    private void m24672a(List<StickerPack> list, boolean z) {
        if (this.aE == TabType.OWNED) {
            this.aA.m24708a(m24686d((List) list), aw(), z);
        } else if (this.aE == TabType.AVAILABLE) {
            List arrayList = new ArrayList(list);
            Collections.sort(arrayList, new Comparator<StickerPack>(this) {
                final /* synthetic */ StickerStoreFragment f16943a;

                {
                    this.f16943a = r1;
                }

                public int compare(Object obj, Object obj2) {
                    String str;
                    String str2;
                    StickerPack stickerPack = (StickerPack) obj;
                    StickerPack stickerPack2 = (StickerPack) obj2;
                    if (stickerPack == null || stickerPack.f4956b == null) {
                        str = "";
                    } else {
                        str = stickerPack.f4956b;
                    }
                    if (stickerPack2 == null || stickerPack2.f4956b == null) {
                        str2 = "";
                    } else {
                        str2 = stickerPack2.f4956b;
                    }
                    return str.compareTo(str2);
                }
            });
            this.aA.m24708a(arrayList, aw(), z);
        } else {
            this.aA.m24708a(list, aw(), z);
        }
    }

    private LinkedHashMap<String, StickerPack> aw() {
        LinkedHashMap<String, StickerPack> linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.aB);
        linkedHashMap.putAll(this.aC);
        return linkedHashMap;
    }

    private List<StickerPack> m24686d(List<StickerPack> list) {
        List b = Lists.b();
        Collection b2 = Lists.b();
        b.addAll(ay());
        b2.addAll(az());
        for (StickerPack stickerPack : list) {
            if (!this.aB.containsKey(stickerPack.f4955a) && stickerPack.m7725a((StickerInterface) this.aH.get())) {
                b.add(stickerPack);
            } else if (!(this.aC.containsKey(stickerPack.f4955a) || stickerPack.m7725a((StickerInterface) this.aH.get()))) {
                b2.add(stickerPack);
            }
        }
        b.addAll(b2);
        return b;
    }

    public static ImmutableList ax(StickerStoreFragment stickerStoreFragment) {
        ImmutableList ay = stickerStoreFragment.ay();
        ImmutableList az = stickerStoreFragment.az();
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.b(ay);
        builder.b(az);
        return builder.b();
    }

    private ImmutableList<StickerPack> ay() {
        ImmutableList.Builder builder = ImmutableList.builder();
        Object[] toArray = this.aB.keySet().toArray();
        for (Object obj : toArray) {
            builder.c((StickerPack) this.aB.get(obj));
        }
        return builder.b();
    }

    private ImmutableList<StickerPack> az() {
        ImmutableList.Builder builder = ImmutableList.builder();
        Object[] toArray = this.aC.keySet().toArray();
        for (Object obj : toArray) {
            builder.c((StickerPack) this.aC.get(obj));
        }
        return builder.b();
    }

    public static void m24691e(StickerStoreFragment stickerStoreFragment, List list) {
        LinkedHashMap d = Maps.d();
        LinkedHashMap d2 = Maps.d();
        for (StickerPack stickerPack : list) {
            if (stickerStoreFragment.aB.containsKey(stickerPack.f4955a)) {
                d.put(stickerPack.f4955a, stickerPack);
            } else if (stickerStoreFragment.aC.containsKey(stickerPack.f4955a)) {
                d2.put(stickerPack.f4955a, stickerPack);
            }
        }
        stickerStoreFragment.aB = d;
        stickerStoreFragment.aC = d2;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("stickerPacks", Lists.a(list));
        Futures.a(BlueServiceOperationFactoryDetour.a(stickerStoreFragment.f16966f, "set_downloaded_sticker_packs", bundle, -1693510596).a(), new FutureCallback<OperationResult>(stickerStoreFragment) {
            final /* synthetic */ StickerStoreFragment f16944a;

            {
                this.f16944a = r1;
            }

            public void onSuccess(Object obj) {
                this.f16944a.m24705b();
            }

            public void onFailure(Throwable th) {
                this.f16944a.ap.a(ErrorDialogParams.a(this.f16944a.jW_()).a(2131230721).b(2131230758).l());
                this.f16944a.f16964d.a(StickerStoreFragment.f16961a.getName(), "Reordering downloaded sticker pack failed", th);
            }
        });
    }

    private void m24658a(final StickerPack stickerPack, final StickerStoreListAdapter stickerStoreListAdapter) {
        stickerStoreListAdapter.remove(stickerPack);
        if (stickerPack.m7725a((StickerInterface) this.aH.get())) {
            this.aB.remove(stickerPack.f4955a);
        } else {
            this.aC.remove(stickerPack.f4955a);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("stickerPacks", Lists.a(aw().values()));
        bundle.putParcelableArrayList("deletedStickerPacks", Lists.a(new StickerPack[]{stickerPack}));
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f16966f, "set_downloaded_sticker_packs", bundle, 936078897).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ StickerStoreFragment f16947c;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                stickerStoreListAdapter.add(stickerPack);
                if (stickerPack.m7725a((StickerInterface) this.f16947c.aH.get())) {
                    this.f16947c.aB.put(stickerPack.f4955a, stickerPack);
                } else {
                    this.f16947c.aC.put(stickerPack.f4955a, stickerPack);
                }
                this.f16947c.ap.a(ErrorDialogParams.a(this.f16947c.jW_()).a(2131230721).b(2131230758).l());
                BLog.b(StickerStoreFragment.f16961a, "Deleting downloaded sticker pack failed", th);
                this.f16947c.f16964d.a(StickerStoreFragment.f16961a.getName(), "Deleting downloaded sticker pack failed", th);
            }
        });
    }

    private void m24660a(StickerPack stickerPack, StickerStoreListItemView stickerStoreListItemView) {
        Object obj;
        if (this.aB.containsKey(stickerPack.f4955a) || this.aC.containsKey(stickerPack.f4955a)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m24675b(stickerPack);
            this.f16968h.m23936a(stickerPack);
            stickerStoreListItemView.m24714a();
        }
    }

    protected final void m24704a(TabType tabType) {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_store");
        a.b("action", "sticker_store_tab_load_error");
        a.b("store_tab", tabType.toString());
        this.al.m23900a(a);
    }

    private void m24657a(StickerPack stickerPack) {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_store");
        a.b("action", "sticker_pack_selected");
        a.b("sticker_pack", stickerPack.f4955a);
        a.b("store_tab", this.aE.toString());
        this.al.m23900a(a);
    }

    private void m24675b(StickerPack stickerPack) {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_store");
        a.b("action", "sticker_pack_obtained");
        a.b("sticker_pack", stickerPack.f4955a);
        a.b("store_tab", this.aE.toString());
        this.al.m23900a(a);
    }

    protected final void m24705b() {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_store");
        a.b("action", "sticker_packs_reordered");
        a.b("store_tab", this.aE.toString());
        this.al.m23900a(a);
    }
}

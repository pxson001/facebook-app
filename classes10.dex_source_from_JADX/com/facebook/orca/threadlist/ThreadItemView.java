package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.infer.annotation.SuppressFieldNotInitialized;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.montage.MontageTileView;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.seenheads.ThreadItemSeenHeadsDrawableController;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.messaging.ui.threaditem.ThreadItemDividerDrawer;
import com.facebook.orca.threadlist.abtest.ExperimentsForThreadListExperimentsModule;
import com.facebook.orca.threadview.ThreadViewLoader;
import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.Params;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.tiles.ThreadTileView;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: nativegdp/ */
public class ThreadItemView extends CustomRelativeLayout {
    private static final Class<?> f6500a = ThreadItemView.class;
    private ImageView f6501A;
    private ProgressBar f6502B;
    private FbTextView f6503C;
    public MontageTileView f6504D;
    private View f6505E;
    private ViewStubHolder<View> f6506F;
    public ThreadSummary f6507G;
    private int f6508H;
    public ThreadItemViewListener f6509I;
    private final Typeface f6510J;
    private ThreadViewLoader f6511K;
    private SelfRegistrableReceiverImpl f6512L;
    @Nullable
    private ThreadItemSeenHeadsDrawableController f6513M;
    @Inject
    private MessengerThreadNameViewDataFactory f6514b;
    @Inject
    private MessengerThreadTileViewDataFactory f6515c;
    @Inject
    private MontageTestHelper f6516d;
    @Inject
    private ThreadUnreadCountUtil f6517e;
    @Inject
    private SeenHeadsEligibilityChecker f6518f;
    @Inject
    private Provider<ThreadViewLoader> f6519g;
    @Inject
    public MontageMessagesHelper f6520h;
    @Inject
    @LocalBroadcast
    private BaseFbBroadcastManager f6521i;
    @Inject
    private QeAccessor f6522j;
    @Inject
    private ThreadItemDividerDrawer f6523k;
    @Inject
    @LoggedInUserKey
    private Provider<UserKey> f6524l;
    @Inject
    private FbSharedPreferences f6525m;
    @Inject
    private Lazy<ThreadItemSeenHeadsDrawableController> f6526n;
    @Inject
    private ThreadListItemBackgroundLoader f6527o;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<RtcCallHandler> f6528p;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<SendMessageManager> f6529q;
    private final int f6530r;
    private final boolean f6531s;
    private final ColorStateList f6532t;
    private final ThreadNameView f6533u;
    public final ThreadTileView f6534v;
    private final TextView f6535w;
    private final TextView f6536x;
    private ViewStub f6537y;
    private View f6538z;

    /* compiled from: nativegdp/ */
    class C09781 implements OnInflateListener<View> {
        final /* synthetic */ ThreadItemView f6494a;

        /* compiled from: nativegdp/ */
        class C09771 implements OnClickListener {
            final /* synthetic */ C09781 f6493a;

            C09771(C09781 c09781) {
                this.f6493a = c09781;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -279210230);
                ((RtcCallHandler) this.f6493a.f6494a.f6528p.get()).a(this.f6493a.f6494a.getContext(), ThreadKey.a(this.f6493a.f6494a.f6507G.a), "thread_list_inline_call_back");
                Logger.a(2, EntryType.UI_INPUT_END, -1995200868, a);
            }
        }

        C09781(ThreadItemView threadItemView) {
            this.f6494a = threadItemView;
        }

        public final void m6200a(View view) {
            view.setOnClickListener(new C09771(this));
        }
    }

    /* compiled from: nativegdp/ */
    class C09792 implements ActionReceiver {
        final /* synthetic */ ThreadItemView f6495a;

        C09792(ThreadItemView threadItemView) {
            this.f6495a = threadItemView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 797678592);
            this.f6495a.m6221b(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1557390708, a);
        }
    }

    /* compiled from: nativegdp/ */
    class C09803 implements ActionReceiver {
        final /* synthetic */ ThreadItemView f6496a;

        C09803(ThreadItemView threadItemView) {
            this.f6496a = threadItemView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1437167383);
            this.f6496a.m6208a(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2041519986, a);
        }
    }

    /* compiled from: nativegdp/ */
    class MontageThreadViewLoaderCallback extends AbstractFbLoaderCallback<Params, Result, Error> {
        final /* synthetic */ ThreadItemView f6499a;

        public MontageThreadViewLoaderCallback(ThreadItemView threadItemView) {
            this.f6499a = threadItemView;
        }

        public final void m6201b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            if (this.f6499a.f6520h.b(result.f7613c)) {
                if (this.f6499a.f6504D == null) {
                    this.f6499a.f6504D = new MontageTileView(this.f6499a.getContext());
                    this.f6499a.f6504D.setId(this.f6499a.f6534v.getId());
                }
                this.f6499a.f6504D.a(result.f7611a, result.f7613c);
                final ThreadKey threadKey = result.f7611a.a;
                this.f6499a.f6504D.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MontageThreadViewLoaderCallback f6498b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1012767466);
                        if (this.f6498b.f6499a.f6509I != null) {
                            this.f6498b.f6499a.f6509I.mo235a(threadKey);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -1261432895, a);
                    }
                });
                ThreadItemView.setTileView(this.f6499a, this.f6499a.f6504D);
                return;
            }
            ThreadItemView.setTileView(this.f6499a, this.f6499a.f6534v);
        }
    }

    /* compiled from: nativegdp/ */
    public interface ThreadItemViewListener {
        void mo235a(ThreadKey threadKey);
    }

    @Deprecated
    private static <T> void m6214a(Class<T> cls, T t, Context context) {
        m6215a((Object) t, context);
    }

    public static void m6215a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadItemView) obj).m6210a(MessengerThreadNameViewDataFactory.a(injectorLike), MessengerThreadTileViewDataFactory.a(injectorLike), MontageTestHelper.a(injectorLike), ThreadUnreadCountUtil.a(injectorLike), SeenHeadsEligibilityChecker.m8295a(injectorLike), IdBasedProvider.a(injectorLike, 8862), MontageMessagesHelper.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ThreadItemDividerDrawer.m4412a(injectorLike), IdBasedProvider.a(injectorLike, 3597), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 8337), ThreadListItemBackgroundLoader.m6384a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3342), IdBasedLazy.a(injectorLike, 8347));
    }

    @SuppressFieldNotInitialized
    private ThreadItemView(Context context, boolean z) {
        super(context, null, 2130773031);
        this.f6528p = UltralightRuntime.b;
        this.f6529q = UltralightRuntime.b;
        this.f6530r = 0;
        this.f6531s = false;
        this.f6532t = null;
        this.f6533u = null;
        this.f6534v = null;
        this.f6535w = null;
        this.f6536x = null;
        this.f6510J = null;
    }

    private void m6210a(MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, MessengerThreadTileViewDataFactory messengerThreadTileViewDataFactory, MontageTestHelper montageTestHelper, ThreadUnreadCountUtil threadUnreadCountUtil, SeenHeadsEligibilityChecker seenHeadsEligibilityChecker, Provider<ThreadViewLoader> provider, MontageMessagesHelper montageMessagesHelper, FbBroadcastManager fbBroadcastManager, QeAccessor qeAccessor, ThreadItemDividerDrawer threadItemDividerDrawer, Provider<UserKey> provider2, FbSharedPreferences fbSharedPreferences, Lazy<ThreadItemSeenHeadsDrawableController> lazy, ThreadListItemBackgroundLoader threadListItemBackgroundLoader, Lazy<RtcCallHandler> lazy2, Lazy<SendMessageManager> lazy3) {
        this.f6514b = messengerThreadNameViewDataFactory;
        this.f6515c = messengerThreadTileViewDataFactory;
        this.f6516d = montageTestHelper;
        this.f6517e = threadUnreadCountUtil;
        this.f6518f = seenHeadsEligibilityChecker;
        this.f6519g = provider;
        this.f6520h = montageMessagesHelper;
        this.f6521i = fbBroadcastManager;
        this.f6522j = qeAccessor;
        this.f6523k = threadItemDividerDrawer;
        this.f6524l = provider2;
        this.f6525m = fbSharedPreferences;
        this.f6526n = lazy;
        this.f6527o = threadListItemBackgroundLoader;
        this.f6528p = lazy2;
        this.f6529q = lazy3;
    }

    public ThreadItemView(Context context) {
        this(context, null, 2130773031);
    }

    public ThreadItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773031);
    }

    public ThreadItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet, i);
        this.f6528p = UltralightRuntime.b();
        this.f6529q = UltralightRuntime.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThreadItemView, i, 0);
        this.f6530r = obtainStyledAttributes.getInteger(4, 0);
        this.f6531s = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
        TracerDetour.a("ThreadItemView.init", 1416832553);
        try {
            m6207a(getContext());
            this.f6523k.m4413a(context, attributeSet, i);
            if (!this.f6523k.m4415a()) {
                z = true;
            }
            setWillNotDraw(z);
            setContentView(2130905884);
            this.f6533u = (ThreadNameView) a(2131563877);
            this.f6534v = (ThreadTileView) a(2131564465);
            this.f6505E = this.f6534v;
            this.f6535w = (TextView) a(2131565205);
            this.f6532t = this.f6535w.getTextColors();
            this.f6510J = this.f6535w.getTypeface();
            this.f6536x = (TextView) a(2131565204);
            this.f6537y = (ViewStub) a(2131565206);
            this.f6506F = ViewStubHolder.a((ViewStubCompat) a(2131565207));
            this.f6506F.a(new C09781(this));
        } finally {
            TracerDetour.a(-495500015);
        }
    }

    private void m6207a(Context context) {
        Class cls = ThreadItemView.class;
        m6215a((Object) this, context);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -748878378);
        TracerDetour.a("ThreadItemView.onAttachedToWindow", 1842456789);
        super.onAttachedToWindow();
        try {
            if (this.f6513M != null) {
                this.f6513M.b();
            }
            if (this.f6516d.b()) {
                if (this.f6512L == null) {
                    m6234i();
                }
                this.f6512L.b();
            }
            TracerDetour.a(1823351685);
            LogUtils.g(-471112682, a);
        } catch (Throwable th) {
            TracerDetour.a(-1978219779);
            LogUtils.g(1888078657, a);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -735087301);
        super.onDetachedFromWindow();
        if (this.f6513M != null) {
            this.f6513M.c();
        }
        if (this.f6512L != null) {
            this.f6512L.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -889359391, a);
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("ThreadItemView.onMeasure", -875025370);
        try {
            super.onMeasure(i, i2);
        } finally {
            TracerDetour.a(-1635288334);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TracerDetour.a("ThreadItemView.onLayout", 1957224172);
        try {
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            TracerDetour.a(1816306265);
        }
    }

    public void setUseInbox2AlternateBadges(boolean z) {
        this.f6534v.setUseInbox2AlternateBadges(z);
    }

    public void setThreadItemViewListener(ThreadItemViewListener threadItemViewListener) {
        this.f6509I = threadItemViewListener;
    }

    public ThreadKey getThreadKey() {
        return this.f6507G != null ? this.f6507G.a : null;
    }

    private void m6220b() {
        this.f6534v.setThreadTileViewData(this.f6515c.a(this.f6507G));
    }

    public void setThreadSummary(ThreadSummary threadSummary) {
        TracerDetour.a("ThreadItemView.setThreadSummary", -695034579);
        try {
            if (ThreadKey.e(threadSummary.a) && !this.f6525m.a(SmsPrefKeys.l, false)) {
                this.f6525m.edit().putBoolean(SmsPrefKeys.l, true).putBoolean(SmsPrefKeys.r, true).commit();
            }
            MessengerThreadNameViewData a = this.f6514b.a(threadSummary);
            int a2 = m6203a(a);
            if (m6217a(threadSummary, this.f6507G) && a2 == this.f6508H) {
                m6236a();
            } else {
                m6206a(this.f6507G);
                m6206a(threadSummary);
                this.f6507G = threadSummary;
                m6209a(a, a2);
            }
            TracerDetour.a(-1243658600);
        } catch (Throwable th) {
            TracerDetour.a(505157266);
        }
    }

    private static int m6203a(MessengerThreadNameViewData messengerThreadNameViewData) {
        return Objects.hashCode(new Object[]{messengerThreadNameViewData.a, Long.valueOf(messengerThreadNameViewData.b()), Boolean.valueOf(messengerThreadNameViewData.a), messengerThreadNameViewData.c, messengerThreadNameViewData.b});
    }

    private static boolean m6217a(ThreadSummary threadSummary, @Nullable ThreadSummary threadSummary2) {
        if (threadSummary == threadSummary2) {
            return true;
        }
        if (threadSummary == null || threadSummary2 == null) {
            return false;
        }
        if (Objects.equal(threadSummary.a, threadSummary2.a) && Objects.equal(Long.valueOf(threadSummary.c), Long.valueOf(threadSummary2.c)) && Objects.equal(Long.valueOf(threadSummary.f), Long.valueOf(threadSummary2.f)) && Objects.equal(Long.valueOf(threadSummary.k), Long.valueOf(threadSummary2.k)) && Objects.equal(Boolean.valueOf(threadSummary.f()), Boolean.valueOf(threadSummary2.f())) && Objects.equal(threadSummary.p, threadSummary2.p) && Objects.equal(threadSummary.q, threadSummary2.q) && Objects.equal(threadSummary.r, threadSummary2.r) && Objects.equal(threadSummary.g, threadSummary2.g) && Objects.equal(threadSummary.s, threadSummary2.s) && Objects.equal(threadSummary.o, threadSummary2.o) && Objects.equal(Boolean.valueOf(threadSummary.z), Boolean.valueOf(threadSummary2.z)) && m6218a(threadSummary.h, threadSummary2.h)) {
            return true;
        }
        return false;
    }

    private static boolean m6218a(List<ThreadParticipant> list, List<ThreadParticipant> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            ThreadParticipant threadParticipant = (ThreadParticipant) it.next();
            ThreadParticipant threadParticipant2 = (ThreadParticipant) it2.next();
            if (!Objects.equal(threadParticipant.a, threadParticipant2.a)) {
                return false;
            }
            if (threadParticipant.b == threadParticipant2.b) {
                if (threadParticipant.d != threadParticipant2.d) {
                }
            }
            return false;
        }
        return true;
    }

    ThreadSummary getThreadSummary() {
        return this.f6507G;
    }

    final void m6236a() {
        TracerDetour.a("invalidateCachedThreadItemUiState", -1737732970);
        try {
            m6213a(this.f6527o.m6390a(getContext(), this.f6507G, (int) this.f6535w.getTextSize()));
            m6216a(this.f6517e.a(this.f6507G));
            m6235j();
        } finally {
            TracerDetour.a(-1075595576);
        }
    }

    private static String m6206a(@Nullable ThreadSummary threadSummary) {
        return threadSummary != null ? threadSummary.a.toString() : "<null>";
    }

    private void m6209a(MessengerThreadNameViewData messengerThreadNameViewData, int i) {
        TracerDetour.a("ThreadItemView.update", -309624514);
        try {
            this.f6508H = i;
            this.f6533u.setData(messengerThreadNameViewData);
            this.f6534v.setThreadTileViewData(this.f6515c.a(this.f6507G));
            setTileView(this, this.f6534v);
            PrefetchedData a = this.f6527o.m6390a(getContext(), this.f6507G, (int) this.f6535w.getTextSize());
            m6213a(a);
            m6223b(a);
            m6232g();
            m6216a(this.f6517e.a(this.f6507G));
            m6233h();
            m6220b();
            m6235j();
            boolean a2 = this.f6518f.m8297a(this.f6507G.h.size(), this.f6507G.A);
            if (this.f6531s && this.f6507G.K) {
                m6225c();
                this.f6538z.setVisibility(0);
                this.f6501A.setVisibility(8);
                this.f6502B.setVisibility(8);
                this.f6503C.setVisibility(0);
                this.f6503C.setTextColor(this.f6536x.getTextColors());
                this.f6503C.setTypeface(this.f6536x.getTypeface());
                this.f6503C.setText(getContext().getString(2131231828));
            } else if (((SendMessageManager) this.f6529q.get()).a(this.f6507G.a) && !a2) {
                m6225c();
                this.f6538z.setVisibility(0);
                this.f6501A.setVisibility(8);
                this.f6502B.setVisibility(0);
                this.f6503C.setVisibility(8);
            } else if (this.f6507G.x && !a2) {
                m6225c();
                m6227d();
                this.f6538z.setVisibility(0);
                this.f6501A.setVisibility(0);
                this.f6502B.setVisibility(8);
                this.f6503C.setVisibility(8);
            } else if (m6231f()) {
                m6225c();
                m6229e();
                this.f6538z.setVisibility(0);
                this.f6501A.setVisibility(0);
                this.f6502B.setVisibility(8);
                this.f6503C.setVisibility(8);
            } else if (this.f6538z != null) {
                this.f6538z.setVisibility(8);
            }
            TracerDetour.a(40308272);
        } catch (Throwable th) {
            TracerDetour.a(628233145);
        }
    }

    private void m6225c() {
        if (this.f6537y != null) {
            View inflate = this.f6537y.inflate();
            this.f6501A = (ImageView) inflate.findViewById(2131565199);
            this.f6502B = (ProgressBar) inflate.findViewById(2131565200);
            this.f6503C = (FbTextView) inflate.findViewById(2131565201);
            this.f6538z = inflate;
            this.f6537y = null;
        }
    }

    private void m6227d() {
        if (this.f6501A != null) {
            this.f6501A.setImageResource(2130842336);
        }
    }

    private void m6229e() {
        if (this.f6501A != null) {
            this.f6501A.setImageResource(2130841802);
        }
    }

    private void m6213a(PrefetchedData prefetchedData) {
        TracerDetour.a("ThreadItemView.updateLastMessage", 1091528370);
        try {
            Drawable drawable = prefetchedData.f6683c;
            if (!(drawable != null || prefetchedData.f6684d == null || prefetchedData.f6684d.isEmpty())) {
                this.f6513M = (ThreadItemSeenHeadsDrawableController) this.f6526n.get();
                this.f6513M.a(prefetchedData.f6684d);
                drawable = this.f6513M.a();
            }
            this.f6535w.setTextColor(this.f6532t.getDefaultColor());
            this.f6535w.setText(prefetchedData.f6682b);
            if (this.f6530r == 1) {
                this.f6535w.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            } else {
                this.f6535w.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            }
            m6231f();
        } finally {
            TracerDetour.a(-1744525985);
        }
    }

    private boolean m6231f() {
        QeAccessor qeAccessor = this.f6522j;
        Liveness liveness = Liveness.Cached;
        if (qeAccessor.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.t, false) || !this.f6507G.y || !this.f6507G.f() || this.f6507G.r == null) {
            return false;
        }
        if (Objects.equal(this.f6507G.r.b, (UserKey) this.f6524l.get())) {
            return false;
        }
        Optional b = ContextUtils.b(getContext(), 2130773044);
        if (b.isPresent()) {
            this.f6535w.setTextColor(((Integer) b.get()).intValue());
        }
        return true;
    }

    private void m6223b(PrefetchedData prefetchedData) {
        TracerDetour.a("ThreadItemView.updateTime", 831254361);
        try {
            if (!Objects.equal(prefetchedData.f6685e, this.f6536x.getText())) {
                this.f6536x.setText(prefetchedData.f6685e);
            }
            TracerDetour.a(-2074698401);
        } catch (Throwable th) {
            TracerDetour.a(-1126700568);
        }
    }

    private void m6232g() {
        ThreadKey b = this.f6516d.b(getThreadKey());
        if (b != null) {
            if (this.f6511K == null) {
                this.f6511K = (ThreadViewLoader) this.f6519g.get();
                this.f6511K.m7350a(new MontageThreadViewLoaderCallback(this));
            }
            this.f6511K.m7351a(b);
            this.f6511K.m7352a(Params.m7325a(false, false, true));
            return;
        }
        setTileView(this, this.f6534v);
    }

    private void m6216a(boolean z) {
        Optional b;
        Optional b2;
        Optional b3;
        Optional e;
        Optional optional;
        Optional b4;
        if (z) {
            b = ContextUtils.b(getContext(), 2130773043);
            b2 = ContextUtils.b(getContext(), 2130773046);
            b3 = ContextUtils.b(getContext(), 2130773048);
            e = ContextUtils.e(getContext(), 2130773050);
            optional = b;
            b = b2;
            b2 = b3;
            b3 = e;
            e = ContextUtils.b(getContext(), 2130773052);
            b4 = ContextUtils.b(getContext(), 2130773054);
        } else {
            b = ContextUtils.b(getContext(), 2130773042);
            b2 = ContextUtils.b(getContext(), 2130773045);
            b3 = ContextUtils.b(getContext(), 2130773047);
            e = ContextUtils.e(getContext(), 2130773049);
            optional = b;
            b = b2;
            b2 = b3;
            b3 = e;
            e = ContextUtils.b(getContext(), 2130773051);
            b4 = ContextUtils.b(getContext(), 2130773053);
        }
        if (optional.isPresent()) {
            int intValue = ((Integer) optional.get()).intValue();
            this.f6533u.setTextColor(intValue);
            if (!b.isPresent()) {
                this.f6535w.setTextColor(intValue);
            }
        }
        if (b.isPresent()) {
            this.f6535w.setTextColor(((Integer) b.get()).intValue());
        }
        if (b2.isPresent()) {
            this.f6536x.setTextColor(((Integer) b2.get()).intValue());
        }
        if (b3.isPresent() && VERSION.SDK_INT >= 16) {
            this.f6536x.setTypeface(Typeface.create(((CharSequence) b3.get()).toString(), b4.isPresent() ? ((Integer) b4.get()).intValue() : 0));
        }
        if (e.isPresent()) {
            Integer num = (Integer) e.get();
            this.f6533u.a(this.f6533u.g, num.intValue());
            this.f6535w.setTypeface(this.f6510J, num.intValue());
        }
        m6231f();
    }

    private void m6233h() {
        if (this.f6507G.A == FolderName.INBOX && this.f6507G.y && this.f6522j.a(ExperimentsForThreadListExperimentsModule.f6754a, false)) {
            this.f6506F.f();
        } else {
            this.f6506F.e();
        }
    }

    public static void setTileView(ThreadItemView threadItemView, View view) {
        if (threadItemView.f6505E != view) {
            int indexOfChild = threadItemView.indexOfChild(threadItemView.f6505E);
            LayoutParams layoutParams = (LayoutParams) threadItemView.f6505E.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(layoutParams);
            int[] rules = layoutParams.getRules();
            for (int i = 0; i < rules.length; i++) {
                layoutParams2.addRule(i, rules[i]);
            }
            ViewGroup.LayoutParams layoutParams3 = layoutParams2;
            threadItemView.removeView(threadItemView.f6505E);
            threadItemView.f6505E = view;
            threadItemView.addView(threadItemView.f6505E, indexOfChild, layoutParams3);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f6523k.m4414a(canvas, getWidth(), getHeight());
    }

    public void setAlphaForTileAndTextViews(float f) {
        this.f6534v.setAlpha(f);
        this.f6533u.setAlpha(f);
        this.f6536x.setAlpha(f);
        this.f6535w.setAlpha(f);
    }

    private void m6234i() {
        this.f6512L = this.f6521i.a().a(MessagesBroadcastIntents.b, new C09803(this)).a(MessagesBroadcastIntents.d, new C09792(this)).a();
    }

    private void m6208a(Intent intent) {
        ThreadKey b = this.f6516d.b(getThreadKey());
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
        if (b != null && parcelableArrayListExtra.contains(b)) {
            m6232g();
        }
    }

    private void m6221b(Intent intent) {
        ThreadKey b = this.f6516d.b(getThreadKey());
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
        if (b != null && parcelableArrayListExtra.contains(b)) {
            setTileView(this, this.f6534v);
        }
    }

    private void m6235j() {
        if (ThreadKey.e(getThreadKey())) {
            this.f6536x.setVisibility(8);
            this.f6533u.a(this.f6533u.g, 1);
            return;
        }
        this.f6536x.setVisibility(0);
    }
}

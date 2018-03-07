package com.facebook.photos.pandora.common.ui.feedadapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.environment.impl.CanShowVideoInFullScreenImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache.MemoryCacheEntryKey;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraStoryPagedCollection;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.adapter.AbstractPandoraChildAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererCollection;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererCacheConfig;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererMultiPhotosRowEntryCache;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererCaptionRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraStoryHeaderRow;
import com.facebook.photos.pandora.common.ui.views.BasePandoraMultiMediaRowView;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.photos.pandora.common.ui.views.PandoraCaptionRowView;
import com.facebook.photos.pandora.common.ui.views.PandoraFourMediaRowView;
import com.facebook.photos.pandora.common.ui.views.PandoraHeaderView;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironment;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.common.ui.views.PandoraSingleMediaRowView;
import com.facebook.photos.pandora.common.ui.views.PandoraThreeMediaRowView;
import com.facebook.photos.pandora.common.ui.views.PandoraTwoMediaRowView;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: com.instagram.boomerang */
public abstract class PandoraBasicFeedAdapter extends AbstractPandoraChildAdapter {
    private static final Object f17447u = new Object();
    private static final Object f17448v = new Object();
    public final PandoraRendererConfiguration f17449a;
    protected final Lazy<PandoraStoryMemoryCache> f17450b;
    public final Lazy<TasksManager> f17451c;
    public final Lazy<FbErrorReporter> f17452d;
    protected final PandoraInlineVideoEnvironmentProvider f17453e;
    protected MemoryCacheEntryKey f17454f;
    public PandoraRendererCacheConfig f17455g;
    public PandoraStoryPagedCollection f17456h;
    public PandoraRendererCollection f17457i;
    public String f17458j;
    protected String f17459k;
    public PandoraInstanceId f17460l;
    public boolean f17461m = true;
    public String f17462n;
    public boolean f17463o;
    public boolean f17464p;
    public PandoraSequenceLogger f17465q;
    public boolean f17466r;
    @Nullable
    protected PandoraInlineVideoEnvironment f17467s;
    private final Lazy<PandoraRendererController> f17468t;

    /* compiled from: com.instagram.boomerang */
    class C18531 implements Runnable {
        final /* synthetic */ PandoraBasicFeedAdapter f17438a;

        C18531(PandoraBasicFeedAdapter pandoraBasicFeedAdapter) {
            this.f17438a = pandoraBasicFeedAdapter;
        }

        public void run() {
            AdapterDetour.a(this.f17438a, 2039730368);
        }
    }

    /* compiled from: com.instagram.boomerang */
    public class ViewType {
        @IdRes
        public static final int f17439a = 2131558620;
        @IdRes
        public static final int f17440b = 2131558621;
        @IdRes
        public static final int f17441c = 2131558622;
        @IdRes
        public static final int f17442d = 2131558623;
        @IdRes
        public static final int f17443e = 2131558624;
        @IdRes
        public static final int f17444f = 2131558625;
        @IdRes
        public static final int f17445g = 2131558626;
        @IdRes
        public static final int f17446h = 2131558627;
    }

    public abstract void mo1054d();

    public abstract String mo1055e();

    public abstract PandoraRequestSource mo1056f();

    public PandoraBasicFeedAdapter(Lazy<PandoraStoryMemoryCache> lazy, Lazy<TasksManager> lazy2, Lazy<PandoraRendererController> lazy3, PandoraRendererConfiguration pandoraRendererConfiguration, Lazy<FbErrorReporter> lazy4, String str, PandoraSequenceLogger pandoraSequenceLogger, PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider) {
        this.f17450b = lazy;
        this.f17468t = lazy3;
        this.f17449a = pandoraRendererConfiguration;
        this.f17451c = lazy2;
        this.f17452d = lazy4;
        this.f17459k = str;
        this.f17458j = str;
        this.f17465q = pandoraSequenceLogger;
        this.f17453e = pandoraInlineVideoEnvironmentProvider;
    }

    public void mo1053a(String str, String str2, boolean z, boolean z2, boolean z3) {
        m21428a(str, new SimplePandoraInstanceId(str), str2, z, z2, z3);
    }

    public final void m21428a(String str, PandoraInstanceId pandoraInstanceId, String str2, boolean z, boolean z2, boolean z3) {
        this.f17462n = str2;
        this.f17463o = z;
        this.f17464p = z2;
        this.f17466r = z3;
        if ((!Objects.equal(str, this.f17458j) || this.f17457i == null || this.f17457i.f17469a == null || this.f17457i.f17469a.isEmpty() || this.f17456h == null || this.f17456h.f17363b == null || this.f17456h.f17363b.isEmpty()) && !Strings.isNullOrEmpty(str)) {
            this.f17458j = str;
            this.f17460l = pandoraInstanceId;
            this.f17456h = ((PandoraStoryMemoryCache) this.f17450b.get()).m21363a(m21436h());
            this.f17457i = new PandoraRendererCollection();
            if (this.f17466r) {
                PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider = this.f17453e;
                this.f17467s = new PandoraInlineVideoEnvironment(new C18531(this), HasPersistentStateImpl.b(pandoraInlineVideoEnvironmentProvider), (HasInvalidateImplProvider) pandoraInlineVideoEnvironmentProvider.getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), CanShowVideoInFullScreenImpl.a(pandoraInlineVideoEnvironmentProvider));
            }
            m21423o();
        }
    }

    public final boolean m21431b() {
        if (this.f17456h == null || this.f17456h.f17363b == null || this.f17456h.f17363b.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void m21432c() {
        m21437i();
        this.f17461m = true;
        this.f17456h = ((PandoraStoryMemoryCache) this.f17450b.get()).m21363a(m21436h());
        this.f17457i = new PandoraRendererCollection();
        m21423o();
    }

    public int getCount() {
        Object obj;
        int i = 1;
        int i2 = mo1057j() ? 1 : 0;
        if (!mo1058m()) {
            i = 0;
        }
        if (this.f17457i == null || this.f17457i.f17469a == null || this.f17457i.f17469a.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return i2 + i;
        }
        return (i2 + this.f17457i.f17469a.size()) + i;
    }

    public Object getItem(int i) {
        if (i == 0 && mo1057j()) {
            return f17447u;
        }
        if (mo1058m() && i == getCount() - 1) {
            return f17448v;
        }
        if (mo1057j()) {
            i--;
        }
        if (this.f17457i == null || this.f17457i.f17469a == null || this.f17457i.f17469a.isEmpty() || i < 0 || i >= this.f17457i.f17469a.size()) {
            return null;
        }
        return this.f17457i.f17469a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public final ImmutableList<? extends Class<? extends View>> mo1043a() {
        return ImmutableList.of(PandoraHeaderView.class, PandoraBennyLoadingSpinnerView.class, PandoraSingleMediaRowView.class, PandoraTwoMediaRowView.class, PandoraThreeMediaRowView.class, PandoraFourMediaRowView.class, PandoraCaptionRowView.class);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<? extends android.view.View> mo1044a(int r5) {
        /*
        r4 = this;
        r2 = 0;
        r1 = r4.getItem(r5);
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        r0 = r2;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r1 instanceof com.facebook.photos.pandora.common.ui.renderer.rows.PandoraStoryHeaderRow;
        if (r0 != 0) goto L_0x0011;
    L_0x000d:
        r0 = f17447u;
        if (r1 != r0) goto L_0x0014;
    L_0x0011:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraHeaderView.class;
        goto L_0x0008;
    L_0x0014:
        r0 = f17448v;
        if (r1 != r0) goto L_0x001b;
    L_0x0018:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView.class;
        goto L_0x0008;
    L_0x001b:
        r0 = r1 instanceof com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
        if (r0 == 0) goto L_0x002b;
    L_0x001f:
        r0 = r1;
        r0 = (com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow) r0;
        r3 = r0.f17502a;
        r3 = r3.size();
        switch(r3) {
            case 1: goto L_0x0032;
            case 2: goto L_0x004b;
            case 3: goto L_0x0054;
            case 4: goto L_0x0057;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = r1 instanceof com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererCaptionRow;
        if (r0 == 0) goto L_0x005a;
    L_0x002f:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraCaptionRowView.class;
        goto L_0x0008;
    L_0x0032:
        r0 = r0.f17502a;
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry) r0;
        r0 = r0.f17501d;
        if (r0 != 0) goto L_0x0048;
    L_0x003f:
        r0 = r4.mo1060l();
        if (r0 != 0) goto L_0x0048;
    L_0x0045:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraThreeMediaRowView.class;
        goto L_0x0008;
    L_0x0048:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraSingleMediaRowView.class;
        goto L_0x0008;
    L_0x004b:
        r0 = r4.mo1059k();
        if (r0 == 0) goto L_0x0054;
    L_0x0051:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraTwoMediaRowView.class;
        goto L_0x0008;
    L_0x0054:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraThreeMediaRowView.class;
        goto L_0x0008;
    L_0x0057:
        r0 = com.facebook.photos.pandora.common.ui.views.PandoraFourMediaRowView.class;
        goto L_0x0008;
    L_0x005a:
        r0 = r2;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.a(int):java.lang.Class<? extends android.view.View>");
    }

    public final int m21430b(int i) {
        if (i == 0 && mo1057j()) {
            return ViewType.f17440b;
        }
        if (mo1058m() && i == getCount() - 1) {
            return ViewType.f17441c;
        }
        if (mo1057j()) {
            i--;
        }
        if (this.f17457i == null || this.f17457i.f17469a == null || this.f17457i.f17469a.isEmpty() || i < 0 || i >= this.f17457i.f17469a.size()) {
            return ViewType.f17439a;
        }
        PandoraRendererRow pandoraRendererRow = (PandoraRendererRow) this.f17457i.f17469a.get(i);
        if (pandoraRendererRow instanceof PandoraStoryHeaderRow) {
            return ViewType.f17440b;
        }
        if (pandoraRendererRow instanceof PandoraRendererCaptionRow) {
            return ViewType.f17446h;
        }
        PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow = (PandoraRendererMultiMediaRow) pandoraRendererRow;
        switch (pandoraRendererMultiMediaRow.f17502a.size()) {
            case 1:
                int i2;
                if (((PandoraMultiMediaStoryEntry) pandoraRendererMultiMediaRow.f17502a.get(0)).f17501d || mo1060l()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                return i2 != 0 ? ViewType.f17442d : ViewType.f17444f;
            case 2:
                if (mo1059k()) {
                    return ViewType.f17443e;
                }
                return ViewType.f17444f;
            case 3:
                return ViewType.f17444f;
            case 4:
                return ViewType.f17445g;
            default:
                throw new RuntimeException("MPK we have a problem - multiPhotoRow has no photos to render");
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int b = m21430b(i);
        if (b == ViewType.f17439a) {
            return null;
        }
        if (b == ViewType.f17440b) {
            return m21419b(view, viewGroup);
        }
        if (b == ViewType.f17441c) {
            return m21415a(view, viewGroup);
        }
        if (b == ViewType.f17446h) {
            return m21417a(view, viewGroup, (PandoraRendererCaptionRow) getItem(i));
        }
        if (b == ViewType.f17442d) {
            return m21418a(view, viewGroup, (PandoraRendererMultiMediaRow) getItem(i));
        }
        if (b == ViewType.f17443e) {
            return m21420b(view, viewGroup, (PandoraRendererMultiMediaRow) getItem(i));
        }
        if (b == ViewType.f17444f) {
            return m21421c(view, viewGroup, (PandoraRendererMultiMediaRow) getItem(i));
        }
        if (b == ViewType.f17445g) {
            return m21422d(view, viewGroup, (PandoraRendererMultiMediaRow) getItem(i));
        }
        throw new RuntimeException("MPK we have a problem - multiPhotoRow has no photos to render");
    }

    public final View m21425a(ViewGroup viewGroup, int i) {
        if (i == ViewType.f17439a) {
            return null;
        }
        if (i == ViewType.f17440b) {
            return m21419b(null, viewGroup);
        }
        if (i == ViewType.f17441c) {
            return new PandoraBennyLoadingSpinnerView(viewGroup.getContext());
        }
        if (i == ViewType.f17446h) {
            return m21416a(viewGroup.getContext());
        }
        if (i == ViewType.f17442d) {
            return new PandoraSingleMediaRowView(viewGroup.getContext());
        }
        if (i == ViewType.f17443e) {
            return new PandoraTwoMediaRowView(viewGroup.getContext());
        }
        if (i == ViewType.f17444f) {
            return new PandoraThreeMediaRowView(viewGroup.getContext());
        }
        if (i == ViewType.f17445g) {
            return new PandoraFourMediaRowView(viewGroup.getContext());
        }
        throw new RuntimeException("MPK we have a problem - multiPhotoRow has no photos to render");
    }

    private static PandoraCaptionRowView m21417a(View view, ViewGroup viewGroup, PandoraRendererCaptionRow pandoraRendererCaptionRow) {
        if (view != null) {
            view = (PandoraCaptionRowView) view;
        } else {
            view = m21416a(viewGroup.getContext());
        }
        view.f17537a = pandoraRendererCaptionRow.f17497a;
        if (Strings.isNullOrEmpty(view.f17537a)) {
            view.setText("");
        } else {
            view.setText(view.f17537a);
        }
        return view;
    }

    private static PandoraCaptionRowView m21416a(Context context) {
        PandoraCaptionRowView pandoraCaptionRowView = new PandoraCaptionRowView(context);
        pandoraCaptionRowView.setLayoutParams(new LayoutParams(-1, -2));
        return pandoraCaptionRowView;
    }

    private PandoraSingleMediaRowView m21418a(View view, ViewGroup viewGroup, PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
        BasePandoraMultiMediaRowView basePandoraMultiMediaRowView;
        if (view != null) {
            basePandoraMultiMediaRowView = (PandoraSingleMediaRowView) view;
        } else {
            basePandoraMultiMediaRowView = new PandoraSingleMediaRowView(viewGroup.getContext());
        }
        basePandoraMultiMediaRowView.mo1049a(pandoraRendererMultiMediaRow, this.f17460l, mo1056f(), this.f17462n, this.f17463o, this.f17464p, this.f17466r, this.f17467s);
        return basePandoraMultiMediaRowView;
    }

    private PandoraTwoMediaRowView m21420b(View view, ViewGroup viewGroup, PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
        BasePandoraMultiMediaRowView pandoraTwoMediaRowView = view == null ? new PandoraTwoMediaRowView(viewGroup.getContext()) : (PandoraTwoMediaRowView) view;
        pandoraTwoMediaRowView.mo1049a(pandoraRendererMultiMediaRow, this.f17460l, mo1056f(), this.f17462n, this.f17463o, this.f17464p, this.f17466r, this.f17467s);
        return pandoraTwoMediaRowView;
    }

    private PandoraThreeMediaRowView m21421c(View view, ViewGroup viewGroup, PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
        BasePandoraMultiMediaRowView basePandoraMultiMediaRowView;
        if (view != null) {
            basePandoraMultiMediaRowView = (PandoraThreeMediaRowView) view;
        } else {
            basePandoraMultiMediaRowView = new PandoraThreeMediaRowView(viewGroup.getContext());
        }
        basePandoraMultiMediaRowView.mo1049a(pandoraRendererMultiMediaRow, this.f17460l, mo1056f(), this.f17462n, this.f17463o, this.f17464p, this.f17466r, this.f17467s);
        return basePandoraMultiMediaRowView;
    }

    private PandoraFourMediaRowView m21422d(View view, ViewGroup viewGroup, PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
        BasePandoraMultiMediaRowView basePandoraMultiMediaRowView;
        if (view != null) {
            basePandoraMultiMediaRowView = (PandoraFourMediaRowView) view;
        } else {
            basePandoraMultiMediaRowView = new PandoraFourMediaRowView(viewGroup.getContext());
        }
        basePandoraMultiMediaRowView.mo1049a(pandoraRendererMultiMediaRow, this.f17460l, mo1056f(), this.f17462n, this.f17463o, this.f17464p, this.f17466r, this.f17467s);
        return basePandoraMultiMediaRowView;
    }

    private static PandoraBennyLoadingSpinnerView m21415a(View view, ViewGroup viewGroup) {
        if (view != null) {
            return (PandoraBennyLoadingSpinnerView) view;
        }
        return new PandoraBennyLoadingSpinnerView(viewGroup.getContext());
    }

    private void m21423o() {
        if (this.f17456h.f17363b == null || this.f17456h.f17363b.isEmpty()) {
            mo1054d();
        } else {
            PandoraRendererController pandoraRendererController = (PandoraRendererController) this.f17468t.get();
            if (this.f17455g == null) {
                this.f17455g = new PandoraRendererCacheConfig(this.f17460l, mo1056f(), this.f17461m);
            }
            this.f17457i.m21442a(pandoraRendererController.m21447a(this.f17455g, this.f17449a, this.f17456h.f17363b, true));
        }
        AdapterDetour.a(this, -1086227536);
    }

    public final MemoryCacheEntryKey m21436h() {
        if (this.f17454f == null) {
            if (this.f17460l == null) {
                ((AbstractFbErrorReporter) this.f17452d.get()).b(PandoraBasicFeedAdapter.class.getSimpleName(), "mPandoraInstanceId was null when trying to create MemoryCacheEntryKey");
            }
            this.f17454f = new MemoryCacheEntryKey(this.f17460l, mo1056f());
        }
        return this.f17454f;
    }

    public final void m21437i() {
        if (this.f17457i != null) {
            this.f17457i.f17469a = null;
        }
        if (this.f17456h != null) {
            PandoraStoryPagedCollection pandoraStoryPagedCollection = this.f17456h;
            pandoraStoryPagedCollection.f17364c = true;
            pandoraStoryPagedCollection.f17365d = null;
            pandoraStoryPagedCollection.f17363b = null;
            this.f17456h = null;
        }
        ((PandoraRendererMultiPhotosRowEntryCache) ((PandoraRendererController) this.f17468t.get()).f17471a.get()).clearUserData();
        this.f17455g = null;
        this.f17450b.get();
        MemoryCacheEntryKey h = m21436h();
        if (h != null) {
            PandoraStoryMemoryCache.f17354b.b(h);
        }
        this.f17454f = null;
        ((TasksManager) this.f17451c.get()).c(mo1055e());
        AdapterDetour.a(this, -513771451);
    }

    protected boolean mo1057j() {
        return false;
    }

    protected boolean mo1059k() {
        return false;
    }

    protected boolean mo1060l() {
        return false;
    }

    private View m21419b(View view, View view2) {
        Preconditions.checkState(mo1057j());
        return mo1052a(view, view2);
    }

    protected View mo1052a(View view, View view2) {
        return null;
    }

    protected boolean mo1058m() {
        return false;
    }
}

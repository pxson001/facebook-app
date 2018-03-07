package com.facebook.timeline.header;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController.IntroViewType;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderProfileIntroCardFieldsModel.ActionLinksModel;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: friend_id */
public class TimelineIntroCardAdapter extends TimelineHeaderAbstractAdapter implements TimelineHeaderCachedBindAdapter {
    public final TimelineHeaderViewController f11457e;
    public final IntroCardBinder f11458f;
    private final IntroCardBioBinder f11459g;
    private final TimelineIntroMegaphoneViewBinder f11460h;
    public final TimelineBioNuxController f11461i;
    public final Lazy<NuxBorderDrawingHelper> f11462j;
    public final IntroCardCollapseController f11463k;
    public final FeaturedContainersHeaderData f11464l;
    public final boolean f11465m;
    public final TimelineHeaderDataLogger f11466n;
    public final Lazy<UriIntentMapper> f11467o;
    public final Lazy<SecureContextHelper> f11468p;
    private C16522 f11469q;
    public C16533 f11470r;
    private C16544 f11471s;
    public TimelineIntroCardMultiAdapter f11472t;
    private int f11473u = -1;
    private final int[] f11474v = new int[Part.cachedValues().length];

    /* compiled from: friend_id */
    public class C16522 {
        public final /* synthetic */ TimelineIntroCardAdapter f11442a;

        C16522(TimelineIntroCardAdapter timelineIntroCardAdapter) {
            this.f11442a = timelineIntroCardAdapter;
        }
    }

    /* compiled from: friend_id */
    public class C16533 {
        public final /* synthetic */ TimelineIntroCardAdapter f11443a;

        public C16533(TimelineIntroCardAdapter timelineIntroCardAdapter) {
            this.f11443a = timelineIntroCardAdapter;
        }
    }

    /* compiled from: friend_id */
    public class C16544 {
        public final /* synthetic */ TimelineIntroCardAdapter f11444a;

        C16544(TimelineIntroCardAdapter timelineIntroCardAdapter) {
            this.f11444a = timelineIntroCardAdapter;
        }
    }

    /* compiled from: friend_id */
    public enum BottomPaddingAndNuxPart {
        BOTTOM_PADDING_AND_NUX_PART,
        NON_SELF_PROFILE_INTRO_CTA;
        
        private static BottomPaddingAndNuxPart[] mValues;

        public static BottomPaddingAndNuxPart[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    /* compiled from: friend_id */
    public class BottomPaddingAndNuxView extends View {
        private static final BordersSpec f11447b = new BordersSpec(true, true, false, true);
        public int f11448a;
        private final Lazy<NuxBorderDrawingHelper> f11449c;
        public boolean f11450d;

        BottomPaddingAndNuxView(Context context, Lazy<NuxBorderDrawingHelper> lazy, int i) {
            super(context);
            this.f11449c = lazy;
            this.f11448a = i;
        }

        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(i, MeasureSpec.getSize(this.f11448a));
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f11450d) {
                ((NuxBorderDrawingHelper) this.f11449c.get()).m12028a(this, canvas, f11447b);
            }
        }
    }

    /* compiled from: friend_id */
    public enum CollapseState {
        UNKNOWN,
        COLLAPSED,
        EXPANDED
    }

    /* compiled from: friend_id */
    public class IntroCardBottomPaddingAndNuxBorderAdapter extends TimelineHeaderAbstractAdapter implements TimelineHeaderCachedBindAdapter {
        final /* synthetic */ TimelineIntroCardAdapter f11453e;
        private int f11454f = -1;
        private final int[] f11455g = new int[BottomPaddingAndNuxPart.cachedValues().length];
        public OnClickListener f11456h;

        public IntroCardBottomPaddingAndNuxBorderAdapter(TimelineIntroCardAdapter timelineIntroCardAdapter) {
            this.f11453e = timelineIntroCardAdapter;
            super(timelineIntroCardAdapter.f11327a, timelineIntroCardAdapter.f11328b, timelineIntroCardAdapter.f11329c, timelineIntroCardAdapter.f11330d);
        }

        public final View m11492a(int i, ViewGroup viewGroup) {
            switch (BottomPaddingAndNuxPart.cachedValues()[i]) {
                case BOTTOM_PADDING_AND_NUX_PART:
                    View bottomPaddingAndNuxView = new BottomPaddingAndNuxView(this.f11327a, this.f11453e.f11462j, this.f11453e.f11458f.f11238B);
                    bottomPaddingAndNuxView.setBackgroundResource(2131361920);
                    return bottomPaddingAndNuxView;
                case NON_SELF_PROFILE_INTRO_CTA:
                    return LayoutInflater.from(viewGroup.getContext()).inflate(2130907464, viewGroup, false);
                default:
                    return TimelineHeaderAbstractAdapter.m11411b(i);
            }
        }

        protected final boolean mo523a(View view, int i) {
            BottomPaddingAndNuxPart bottomPaddingAndNuxPart = BottomPaddingAndNuxPart.cachedValues()[i];
            int i2 = this.f11327a.getResources().getConfiguration().orientation;
            if (this.f11454f == i2 && this.f11455g[bottomPaddingAndNuxPart.ordinal()] == this.f11330d.c) {
                return false;
            }
            this.f11454f = i2;
            this.f11455g[bottomPaddingAndNuxPart.ordinal()] = this.f11330d.c;
            if (bottomPaddingAndNuxPart == BottomPaddingAndNuxPart.BOTTOM_PADDING_AND_NUX_PART) {
                BottomPaddingAndNuxView bottomPaddingAndNuxView = (BottomPaddingAndNuxView) view;
                int i3 = this.f11453e.f11458f.f11238B;
                if (i3 != bottomPaddingAndNuxView.f11448a) {
                    bottomPaddingAndNuxView.f11448a = i3;
                    bottomPaddingAndNuxView.requestLayout();
                }
                if (this.f11453e.f11465m || !this.f11453e.f11461i.m11674a(this.f11329c, this.f11330d)) {
                    bottomPaddingAndNuxView.f11450d = false;
                    bottomPaddingAndNuxView.invalidate();
                } else {
                    bottomPaddingAndNuxView.f11450d = true;
                    bottomPaddingAndNuxView.invalidate();
                }
                return false;
            } else if (bottomPaddingAndNuxPart != BottomPaddingAndNuxPart.NON_SELF_PROFILE_INTRO_CTA) {
                return TimelineHeaderAbstractAdapter.m11412c(i);
            } else {
                TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11453e.f11466n;
                if (!timelineHeaderDataLogger.f11387v) {
                    timelineHeaderDataLogger.f11387v = true;
                    timelineHeaderDataLogger.f11370e.e(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b);
                }
                ActionLinksModel d = m11490d();
                View findViewById = view.findViewById(2131567967);
                final String d2 = d.d();
                if (this.f11456h == null) {
                    this.f11456h = new OnClickListener(this) {
                        final /* synthetic */ IntroCardBottomPaddingAndNuxBorderAdapter f11452b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1841277609);
                            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11452b.f11453e.f11466n;
                            if (!timelineHeaderDataLogger.f11386u) {
                                timelineHeaderDataLogger.f11386u = true;
                                timelineHeaderDataLogger.f11370e.d(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b);
                            }
                            Intent a2 = ((UriIntentMapper) this.f11452b.f11453e.f11467o.get()).a(view.getContext(), d2);
                            if (a2 != null) {
                                ((SecureContextHelper) this.f11452b.f11453e.f11468p.get()).a(a2, view.getContext());
                            }
                            Logger.a(2, EntryType.UI_INPUT_END, 2021781863, a);
                        }
                    };
                }
                findViewById.setOnClickListener(this.f11456h);
                ((Button) view.findViewById(2131567967)).setText(d.c());
                ((FbTextView) view.findViewById(2131567966)).setText(d.b().a());
                return false;
            }
        }

        protected final Object mo521a(int i) {
            return BottomPaddingAndNuxPart.cachedValues()[i];
        }

        protected final int mo520a() {
            return BottomPaddingAndNuxPart.cachedValues().length;
        }

        public int getViewTypeCount() {
            return BottomPaddingAndNuxPart.cachedValues().length;
        }

        public int getItemViewType(int i) {
            return ((BottomPaddingAndNuxPart) getItem(i)).ordinal();
        }

        protected final void mo522a(boolean[] zArr) {
            boolean z;
            this.f11453e.getCount();
            CollapseState a = this.f11453e.f11463k.m11668a(this.f11329c, this.f11330d, this.f11453e.f11464l);
            int ordinal = BottomPaddingAndNuxPart.NON_SELF_PROFILE_INTRO_CTA.ordinal();
            if (!this.f11330d.j() && a == CollapseState.EXPANDED && m11489c()) {
                z = true;
            } else {
                z = false;
            }
            zArr[ordinal] = z;
            zArr[BottomPaddingAndNuxPart.BOTTOM_PADDING_AND_NUX_PART.ordinal()] = this.f11453e.m11418d(Part.INTRO_CARD.ordinal());
        }

        private boolean m11489c() {
            if (this.f11330d.b == null || this.f11330d.b.a() == null || this.f11330d.b.a().isEmpty()) {
                return false;
            }
            ActionLinksModel d = m11490d();
            if (d.a() == null || d.a().g() != -1260727392 || d.b() == null || StringUtil.c(d.b().a()) || StringUtil.c(d.c())) {
                return false;
            }
            return true;
        }

        private ActionLinksModel m11490d() {
            return (ActionLinksModel) this.f11330d.b.a().get(0);
        }

        public final void mo528b() {
            this.f11454f = -1;
            for (int i = 0; i < this.f11455g.length; i++) {
                this.f11455g[i] = 0;
            }
        }
    }

    /* compiled from: friend_id */
    public enum Part {
        MEGAPHONE,
        BIO,
        INTRO_CARD;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public TimelineIntroCardAdapter(IntroCardBinderProvider introCardBinderProvider, IntroCardBioBinderProvider introCardBioBinderProvider, TimelineHeaderViewController timelineHeaderViewController, TimelineBioNuxController timelineBioNuxController, QeAccessor qeAccessor, TimelineIntroMegaphoneViewBinder timelineIntroMegaphoneViewBinder, Lazy<NuxBorderDrawingHelper> lazy, IntroCardCollapseController introCardCollapseController, FeaturedContainersHeaderData featuredContainersHeaderData, Lazy<UriIntentMapper> lazy2, Lazy<SecureContextHelper> lazy3, @Assisted Context context, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Assisted TimelineUserContext timelineUserContext, @Assisted boolean z, @Assisted TimelineHeaderDataLogger timelineHeaderDataLogger) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
        this.f11457e = timelineHeaderViewController;
        this.f11461i = timelineBioNuxController;
        this.f11462j = lazy;
        this.f11463k = introCardCollapseController;
        this.f11464l = featuredContainersHeaderData;
        this.f11465m = z;
        this.f11466n = timelineHeaderDataLogger;
        this.f11467o = lazy2;
        this.f11468p = lazy3;
        this.f11460h = timelineIntroMegaphoneViewBinder;
        this.f11458f = introCardBinderProvider.m11384a(m11503l(), timelineHeaderUserData, timelineTaggedMediaSetData, timelineUserContext);
        this.f11459g = introCardBioBinderProvider.m11393a(m11501i(), timelineHeaderUserData, timelineUserContext);
    }

    public final View m11505a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case MEGAPHONE:
                return m11497b(2130907434, viewGroup);
            case BIO:
                return m11497b(2130907463, viewGroup);
            case INTRO_CARD:
                return m11497b(2130907462, viewGroup);
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    private View m11497b(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f11327a).inflate(i, viewGroup, false);
    }

    public final boolean mo523a(final View view, int i) {
        boolean z = false;
        Part part = Part.cachedValues()[i];
        int i2 = this.f11327a.getResources().getConfiguration().orientation;
        if (this.f11473u == i2 && this.f11474v[part.ordinal()] == this.f11330d.c) {
            return false;
        }
        this.f11473u = i2;
        this.f11474v[part.ordinal()] = this.f11330d.c;
        part.toString();
        if (part == Part.MEGAPHONE) {
            TimelineIntroMegaphoneViewBinder timelineIntroMegaphoneViewBinder = this.f11460h;
            TimelineIntroMegaphoneView timelineIntroMegaphoneView = (TimelineIntroMegaphoneView) view;
            if (this.f11470r == null) {
                this.f11470r = new C16533(this);
            }
            timelineIntroMegaphoneViewBinder.m11566a(timelineIntroMegaphoneView, this.f11470r, this.f11329c);
            return true;
        } else if (part == Part.BIO) {
            IntroCardBioBinder introCardBioBinder = this.f11459g;
            TimelineIntroCardBioView timelineIntroCardBioView = (TimelineIntroCardBioView) view;
            boolean z2 = !this.f11465m && this.f11461i.m11674a(this.f11329c, this.f11330d);
            introCardBioBinder.m11392a(timelineIntroCardBioView, z2);
            return true;
        } else if (part != Part.INTRO_CARD) {
            return TimelineHeaderAbstractAdapter.m11412c(i);
        } else {
            IntroCardBinder introCardBinder = this.f11458f;
            TimelineIntroCardView timelineIntroCardView = (TimelineIntroCardView) view;
            boolean z3 = !m11498d();
            if (!this.f11465m && this.f11461i.m11674a(this.f11329c, this.f11330d)) {
                z = true;
            }
            introCardBinder.m11383a(timelineIntroCardView, z3, z);
            view.post(new Runnable(this) {
                final /* synthetic */ TimelineIntroCardAdapter f11441b;

                public void run() {
                    this.f11441b.f11466n.m11440a((TimelineIntroCardView) view);
                }
            });
            return true;
        }
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        int ordinal;
        boolean z = true;
        if (this.f11330d.j()) {
            zArr[Part.MEGAPHONE.ordinal()] = false;
            zArr[Part.BIO.ordinal()] = false;
            ordinal = Part.INTRO_CARD.ordinal();
        } else {
            boolean z2;
            int ordinal2 = Part.MEGAPHONE.ordinal();
            if (this.f11465m || !this.f11461i.m11674a(this.f11329c, this.f11330d)) {
                z2 = false;
            } else {
                z2 = true;
            }
            zArr[ordinal2] = z2;
            zArr[Part.BIO.ordinal()] = m11498d();
            ordinal = Part.INTRO_CARD.ordinal();
            if (!m11499f()) {
                if (m11500g()) {
                }
            }
            zArr[ordinal] = z;
        }
        z = false;
        zArr[ordinal] = z;
    }

    protected final Object mo521a(int i) {
        return Part.cachedValues()[i];
    }

    public int getViewTypeCount() {
        return Part.cachedValues().length;
    }

    public int getItemViewType(int i) {
        return ((Part) getItem(i)).ordinal();
    }

    private boolean m11498d() {
        return this.f11457e.m11691a(this.f11330d, this.f11329c, this.f11457e.m11692a(this.f11329c)) != IntroViewType.NONE;
    }

    private boolean m11499f() {
        boolean z;
        TimelineHeaderViewController timelineHeaderViewController = this.f11457e;
        TimelineContext timelineContext = this.f11329c;
        TimelineHeaderUserData timelineHeaderUserData = this.f11330d;
        FeaturedContainersHeaderData featuredContainersHeaderData = this.f11464l;
        CollapseState a = this.f11463k.m11668a(this.f11329c, this.f11330d, this.f11464l);
        if (TimelineHeaderViewController.m11685a(timelineHeaderUserData.b) > 0) {
            z = true;
        } else if (a == CollapseState.COLLAPSED) {
            z = TimelineHeaderViewController.m11688b(timelineContext, timelineHeaderUserData, featuredContainersHeaderData);
        } else {
            z = timelineContext.i();
        }
        return z;
    }

    private boolean m11500g() {
        return this.f11457e.m11690a(this.f11330d, this.f11329c, this.f11463k.m11668a(this.f11329c, this.f11330d, this.f11464l)) != IntroViewType.NONE;
    }

    public final void mo528b() {
        this.f11473u = -1;
        for (int i = 0; i < this.f11474v.length; i++) {
            this.f11474v[i] = 0;
        }
    }

    private C16522 m11501i() {
        if (this.f11469q == null) {
            this.f11469q = new C16522(this);
        }
        return this.f11469q;
    }

    public static void m11502k(TimelineIntroCardAdapter timelineIntroCardAdapter) {
        TimelineBioNuxController timelineBioNuxController = timelineIntroCardAdapter.f11461i;
        timelineIntroCardAdapter.f11330d.c = false;
        timelineBioNuxController.f11633c = true;
        timelineBioNuxController.f11631a.a().d("3621");
        timelineIntroCardAdapter.f11472t.m11536d();
        AdapterDetour.a(timelineIntroCardAdapter, -2039168787);
    }

    private C16544 m11503l() {
        if (this.f11471s == null) {
            this.f11471s = new C16544(this);
        }
        return this.f11471s;
    }
}

package com.facebook.timeline.viewfeaturedcontainers.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.editfeaturedcontainers.ui.AddFeaturedContainerActivity;
import com.facebook.timeline.header.TimelineHeaderAbstractAdapter;
import com.facebook.timeline.header.TimelineHeaderCachedBindAdapter;
import com.facebook.timeline.header.TimelineIntroCardAdapter.CollapseState;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.TimelineHeaderFeaturedPhotosMosaicView;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_events_discovery_fragment_category_filters */
public class FeaturedHeaderAdapter extends TimelineHeaderAbstractAdapter implements TimelineHeaderCachedBindAdapter {
    private final FeaturedContainersHeaderData f12868e;
    public final FeaturedHeaderNuxController f12869f;
    private final IntroCardCollapseController f12870g;
    private final FeaturedHeaderCollageBinder f12871h;
    public final Provider<SecureContextHelper> f12872i;
    private final boolean f12873j;
    private int f12874k = -1;
    private final int[] f12875l = new int[Part.cachedValues().length];
    private boolean f12876m;
    public OnClickListener f12877n;
    public OnClickListener f12878o;
    public OnClickListener f12879p;

    /* compiled from: extra_events_discovery_fragment_category_filters */
    public class C17981 implements OnClickListener {
        final /* synthetic */ FeaturedHeaderAdapter f12864a;

        public C17981(FeaturedHeaderAdapter featuredHeaderAdapter) {
            this.f12864a = featuredHeaderAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1013976945);
            this.f12864a.f12869f.m11367g();
            this.f12864a.mo528b();
            AdapterDetour.a(this.f12864a, -455646252);
            Logger.a(2, EntryType.UI_INPUT_END, -1699949395, a);
        }
    }

    /* compiled from: extra_events_discovery_fragment_category_filters */
    public class C17992 implements OnClickListener {
        final /* synthetic */ FeaturedHeaderAdapter f12865a;

        public C17992(FeaturedHeaderAdapter featuredHeaderAdapter) {
            this.f12865a = featuredHeaderAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 608231544);
            ((SecureContextHelper) this.f12865a.f12872i.get()).a(new Intent(view.getContext(), AddFeaturedContainerActivity.class), 1823, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -1938500654, a);
        }
    }

    /* compiled from: extra_events_discovery_fragment_category_filters */
    public class C18003 implements OnClickListener {
        final /* synthetic */ FeaturedHeaderAdapter f12866a;

        public C18003(FeaturedHeaderAdapter featuredHeaderAdapter) {
            this.f12866a = featuredHeaderAdapter;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -1888063265, Logger.a(2, EntryType.UI_INPUT_START, -669234957));
        }
    }

    /* compiled from: extra_events_discovery_fragment_category_filters */
    public enum Part {
        NUX,
        BUTTON_BAR,
        COLLAGE;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public FeaturedHeaderAdapter(QeAccessor qeAccessor, FeaturedContainersHeaderData featuredContainersHeaderData, FeaturedHeaderNuxController featuredHeaderNuxController, IntroCardCollapseController introCardCollapseController, FeaturedHeaderCollageBinder featuredHeaderCollageBinder, Provider<SecureContextHelper> provider, @Assisted Context context, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineUserContext timelineUserContext, @Assisted boolean z) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
        this.f12868e = featuredContainersHeaderData;
        this.f12869f = featuredHeaderNuxController;
        this.f12870g = introCardCollapseController;
        this.f12871h = featuredHeaderCollageBinder;
        this.f12872i = provider;
        this.f12873j = z;
    }

    public final View m12881a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case NUX:
                return new FeaturedHeaderNuxView(viewGroup.getContext());
            case BUTTON_BAR:
                return new FeaturedHeaderButtonBarView(viewGroup.getContext());
            case COLLAGE:
                View timelineHeaderFeaturedPhotosMosaicView = new TimelineHeaderFeaturedPhotosMosaicView(viewGroup.getContext());
                timelineHeaderFeaturedPhotosMosaicView.setBackgroundResource(2131361920);
                return timelineHeaderFeaturedPhotosMosaicView;
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    public final boolean mo523a(View view, int i) {
        Part part = Part.cachedValues()[i];
        int i2 = this.f11327a.getResources().getConfiguration().orientation;
        if (this.f12874k == i2 && this.f12875l[part.ordinal()] == this.f12868e.f12837c) {
            return false;
        }
        this.f12874k = i2;
        this.f12875l[part.ordinal()] = this.f12868e.f12837c;
        part.toString();
        if (part == Part.NUX) {
            if (!this.f12876m) {
                this.f12869f.m11366f();
                this.f12876m = true;
            }
            FeaturedHeaderNuxView featuredHeaderNuxView = (FeaturedHeaderNuxView) view;
            if (this.f12877n == null) {
                this.f12877n = new C17981(this);
            }
            featuredHeaderNuxView.f12893a.setOnClickListener(this.f12877n);
            return false;
        } else if (part == Part.BUTTON_BAR) {
            FeaturedHeaderButtonBarView featuredHeaderButtonBarView = (FeaturedHeaderButtonBarView) view;
            if (this.f12878o == null) {
                this.f12878o = new C17992(this);
            }
            featuredHeaderButtonBarView.f12884e.setOnClickListener(this.f12878o);
            if (this.f12879p == null) {
                this.f12879p = new C18003(this);
            }
            featuredHeaderButtonBarView.f12886g.setOnClickListener(this.f12879p);
            if (m11418d(Part.NUX.ordinal())) {
                featuredHeaderButtonBarView.f12883d = true;
                return false;
            }
            featuredHeaderButtonBarView.f12883d = false;
            return false;
        } else if (part != Part.COLLAGE) {
            return TimelineHeaderAbstractAdapter.m11412c(i);
        } else {
            this.f12871h.m12889a((TimelineHeaderFeaturedPhotosMosaicView) view, this.f12868e);
            return false;
        }
    }

    public final void mo528b() {
        this.f12874k = -1;
        for (int i = 0; i < this.f12875l.length; i++) {
            this.f12875l[i] = 0;
        }
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        boolean z = true;
        CollapseState a = this.f12870g.m11668a(this.f11329c, this.f11330d, this.f12868e);
        int ordinal = Part.NUX.ordinal();
        boolean z2 = !this.f12873j && a == CollapseState.EXPANDED && this.f11329c.i() && this.f12868e.m12781a() && this.f12869f.mo533e();
        zArr[ordinal] = z2;
        ordinal = Part.BUTTON_BAR.ordinal();
        if (a == CollapseState.EXPANDED && this.f11329c.i() && this.f12868e.m12781a()) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[ordinal] = z2;
        int ordinal2 = Part.COLLAGE.ordinal();
        if (!(a == CollapseState.EXPANDED && this.f12868e.m12781a() && !this.f12868e.f12836b.isEmpty())) {
            z = false;
        }
        zArr[ordinal2] = z;
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
}

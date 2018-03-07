package com.facebook.timeline.header;

import android.content.Context;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController.IntroViewType;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.externalLinks.IntroCardExternalLinksView;
import com.facebook.timeline.header.externalLinks.IntroCardExternalLinksViewBinderProvider;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.TimelineIntroCardEmptySectionWithBordersView;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.ExternalLink;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ExternalLinkModel;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_nearby_dashboard_map_interaction */
public class TimelineIntroCardExternalLinksAdapter extends TimelineHeaderAbstractAdapter implements TimelineHeaderCachedBindAdapter {
    private final IntroCardExternalLinksViewBinderProvider f11486e;
    private final Provider<AllCapsTransformationMethod> f11487f;
    private final TimelineHeaderViewController f11488g;
    private final TimelineBioNuxController f11489h;
    private final Lazy<NuxBorderDrawingHelper> f11490i;
    private final IntroCardCollapseController f11491j;
    private final FeaturedContainersHeaderData f11492k;
    public final ProfileControllerDelegate f11493l;
    public final Provider<FbUriIntentHandler> f11494m;
    public final Provider<TimelineAnalyticsLogger> f11495n;
    private final boolean f11496o;
    private int f11497p = -1;
    private final int[] f11498q = new int[Part.cachedValues().length];
    public OnClickListener f11499r;

    /* compiled from: friends_nearby_dashboard_map_interaction */
    public class C16571 implements OnClickListener {
        final /* synthetic */ TimelineIntroCardExternalLinksAdapter f11483a;

        public C16571(TimelineIntroCardExternalLinksAdapter timelineIntroCardExternalLinksAdapter) {
            this.f11483a = timelineIntroCardExternalLinksAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -51444960);
            ((TimelineAnalyticsLogger) this.f11483a.f11495n.get()).q(this.f11483a.f11329c.b);
            this.f11483a.f11493l.mn_();
            ((FbUriIntentHandler) this.f11483a.f11494m.get()).a(this.f11483a.f11327a, FBLinks.bb);
            Logger.a(2, EntryType.UI_INPUT_END, 329363808, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_map_interaction */
    public enum Part {
        EMPTY,
        CONTENT;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public TimelineIntroCardExternalLinksAdapter(QeAccessor qeAccessor, IntroCardExternalLinksViewBinderProvider introCardExternalLinksViewBinderProvider, Provider<AllCapsTransformationMethod> provider, TimelineHeaderViewController timelineHeaderViewController, TimelineBioNuxController timelineBioNuxController, Lazy<NuxBorderDrawingHelper> lazy, IntroCardCollapseController introCardCollapseController, FeaturedContainersHeaderData featuredContainersHeaderData, ProfileControllerDelegate profileControllerDelegate, Provider<FbUriIntentHandler> provider2, Provider<TimelineAnalyticsLogger> provider3, @Assisted Context context, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineUserContext timelineUserContext, @Assisted boolean z) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
        this.f11486e = introCardExternalLinksViewBinderProvider;
        this.f11487f = provider;
        this.f11488g = timelineHeaderViewController;
        this.f11489h = timelineBioNuxController;
        this.f11490i = lazy;
        this.f11491j = introCardCollapseController;
        this.f11492k = featuredContainersHeaderData;
        this.f11493l = profileControllerDelegate;
        this.f11494m = provider2;
        this.f11495n = provider3;
        this.f11496o = z;
    }

    public final View m11530a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case EMPTY:
                IntroCardExternalLinkWrappingView introCardExternalLinkWrappingView = new IntroCardExternalLinkWrappingView(this.f11327a, this.f11490i);
                introCardExternalLinkWrappingView.m11394a(this.f11328b.a(ExperimentsForTimelineAbTestModule.am, false) ? m11527b(introCardExternalLinkWrappingView) : m11524a(introCardExternalLinkWrappingView));
                return introCardExternalLinkWrappingView;
            case CONTENT:
                View introCardExternalLinkWrappingView2 = new IntroCardExternalLinkWrappingView(this.f11327a, this.f11490i);
                introCardExternalLinkWrappingView2.m11394a(m11526b(2130907444, introCardExternalLinkWrappingView2));
                return introCardExternalLinkWrappingView2;
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    private View m11526b(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f11327a).inflate(i, viewGroup, false);
    }

    private View m11524a(IntroCardExternalLinkWrappingView introCardExternalLinkWrappingView) {
        TextView textView = (TextView) m11526b(2130907445, introCardExternalLinkWrappingView);
        textView.setTransformationMethod((TransformationMethod) this.f11487f.get());
        return textView;
    }

    private View m11527b(IntroCardExternalLinkWrappingView introCardExternalLinkWrappingView) {
        TimelineIntroCardEmptySectionWithBordersView timelineIntroCardEmptySectionWithBordersView = (TimelineIntroCardEmptySectionWithBordersView) m11526b(2130907458, introCardExternalLinkWrappingView);
        timelineIntroCardEmptySectionWithBordersView.setGlyph(2130840032);
        timelineIntroCardEmptySectionWithBordersView.setText(2131235027);
        return timelineIntroCardEmptySectionWithBordersView;
    }

    public final boolean mo523a(View view, int i) {
        Part part = Part.cachedValues()[i];
        int i2 = this.f11327a.getResources().getConfiguration().orientation;
        if (this.f11497p == i2 && this.f11498q[part.ordinal()] == this.f11330d.c) {
            return false;
        }
        this.f11497p = i2;
        this.f11498q[part.ordinal()] = this.f11330d.c;
        part.toString();
        IntroCardExternalLinkWrappingView introCardExternalLinkWrappingView;
        if (part == Part.EMPTY) {
            ((TimelineAnalyticsLogger) this.f11495n.get()).r(this.f11329c.b);
            introCardExternalLinkWrappingView = (IntroCardExternalLinkWrappingView) view;
            View view2 = introCardExternalLinkWrappingView.f11287c;
            if (this.f11499r == null) {
                this.f11499r = new C16571(this);
            }
            view2.setOnClickListener(this.f11499r);
            m11528c(introCardExternalLinkWrappingView);
            return true;
        } else if (part != Part.CONTENT) {
            return TimelineHeaderAbstractAdapter.m11412c(i);
        } else {
            m11525a(this.f11330d.ac());
            introCardExternalLinkWrappingView = (IntroCardExternalLinkWrappingView) view;
            m11528c(introCardExternalLinkWrappingView);
            this.f11486e.m11784a(this.f11329c).m11783a((IntroCardExternalLinksView) introCardExternalLinkWrappingView.f11287c, this.f11330d.ac());
            return true;
        }
    }

    private void m11528c(IntroCardExternalLinkWrappingView introCardExternalLinkWrappingView) {
        if (this.f11496o || !this.f11489h.m11674a(this.f11329c, this.f11330d)) {
            introCardExternalLinkWrappingView.f11288d = false;
            introCardExternalLinkWrappingView.invalidate();
            return;
        }
        introCardExternalLinkWrappingView.f11288d = true;
        introCardExternalLinkWrappingView.invalidate();
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        if (this.f11330d.j()) {
            zArr[Part.EMPTY.ordinal()] = false;
            zArr[Part.CONTENT.ordinal()] = false;
            return;
        }
        IntroViewType b = this.f11488g.m11693b(this.f11330d, this.f11329c, this.f11491j.m11668a(this.f11329c, this.f11330d, this.f11492k));
        switch (b) {
            case NONE:
                zArr[Part.EMPTY.ordinal()] = false;
                zArr[Part.CONTENT.ordinal()] = false;
                return;
            case EMPTY:
                zArr[Part.EMPTY.ordinal()] = true;
                zArr[Part.CONTENT.ordinal()] = false;
                return;
            case CONTENT:
                zArr[Part.EMPTY.ordinal()] = false;
                zArr[Part.CONTENT.ordinal()] = true;
                return;
            default:
                throw new IllegalArgumentException("not supported intro view type: " + b);
        }
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

    public final void mo528b() {
        this.f11497p = -1;
        for (int i = 0; i < this.f11498q.length; i++) {
            this.f11498q[i] = 0;
        }
    }

    private void m11525a(ImmutableList<? extends ExternalLink> immutableList) {
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            ExternalLinkModel externalLinkModel = (ExternalLinkModel) immutableList.get(i);
            String a = externalLinkModel.b() == null ? null : externalLinkModel.b().a();
            if (a == null || !a.equals("Website")) {
                i3 = i2;
            } else {
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        ((TimelineAnalyticsLogger) this.f11495n.get()).a(this.f11329c.b, i2, immutableList.size() - i2);
    }
}

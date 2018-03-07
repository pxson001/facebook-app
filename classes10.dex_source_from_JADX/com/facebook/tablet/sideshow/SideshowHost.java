package com.facebook.tablet.sideshow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.OverlayScrollable;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hasClickedOnCohostSelector */
public class SideshowHost extends FbFragment implements LoaderCallbacks<Void> {
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService f10105a;
    @Inject
    public Set<SideshowUnitType> f10106b;
    @Inject
    public SideshowAnalyticsLogger f10107c;
    private LoadingIndicatorView f10108d;
    public ScrollView f10109e;
    public LinearLayout f10110f;
    private List<SideshowUnitWrapper> f10111g;

    /* compiled from: hasClickedOnCohostSelector */
    public class HostInterfaceImpl {
        public SideshowUnitWrapper f10103a;
        public final /* synthetic */ SideshowHost f10104b;

        public HostInterfaceImpl(SideshowHost sideshowHost) {
            this.f10104b = sideshowHost;
        }
    }

    public static void m10171a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SideshowHost sideshowHost = (SideshowHost) obj;
        ListeningExecutorService a = ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        Set multiBinderSet = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SideshowUnitType(fbInjector));
        SideshowAnalyticsLogger a2 = SideshowAnalyticsLogger.m10181a(fbInjector);
        sideshowHost.f10105a = a;
        sideshowHost.f10106b = multiBinderSet;
        sideshowHost.f10107c = a2;
    }

    public final void m10177c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = SideshowHost.class;
        m10171a((Object) this, getContext());
    }

    public final View m10175a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ContentFragmentType q;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -857945429);
        this.f10108d = (LoadingIndicatorView) layoutInflater.inflate(2130907096, null);
        this.f10109e = (ScrollView) this.f10108d.findViewById(2131567445);
        this.f10110f = (LinearLayout) this.f10109e.findViewById(2131567446);
        if (o() instanceof TypedSideshowFragmentContainer) {
            q = ((TypedSideshowFragmentContainer) o()).q();
        } else {
            q = null;
        }
        List<SideshowUnitType> arrayList = new ArrayList(this.f10106b.size());
        arrayList.addAll(this.f10106b);
        Collections.sort(arrayList, new Comparator<SideshowUnitType>(this) {
            final /* synthetic */ SideshowHost f10102b;

            public int compare(Object obj, Object obj2) {
                return ((SideshowUnitType) obj).a(q) - ((SideshowUnitType) obj2).a(q);
            }
        });
        List arrayList2 = new ArrayList();
        for (SideshowUnitType sideshowUnitType : arrayList) {
            if (sideshowUnitType.a(q) != 0) {
                HostInterfaceImpl hostInterfaceImpl = new HostInterfaceImpl(this);
                SideshowUnitWrapper sideshowUnitWrapper = new SideshowUnitWrapper(sideshowUnitType.a(hostInterfaceImpl));
                hostInterfaceImpl.f10103a = sideshowUnitWrapper;
                arrayList2.add(sideshowUnitWrapper);
            }
        }
        this.f10111g = arrayList2;
        aq();
        LoadingIndicatorView loadingIndicatorView = this.f10108d;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1078566980, a);
        return loadingIndicatorView;
    }

    public final void m10173G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -43507984);
        super.G();
        if (o() instanceof OverlayScrollable) {
            OverlayScrollable overlayScrollable = (OverlayScrollable) o();
            int a2 = overlayScrollable.a();
            int b = overlayScrollable.b();
            if (a2 > 0 || b > 0) {
                this.f10109e.setClipToPadding(false);
                this.f10109e.setPadding(this.f10109e.getPaddingLeft(), b + a2, this.f10109e.getPaddingRight(), this.f10109e.getPaddingBottom());
            }
        } else {
            this.f10109e.setClipToPadding(false);
            this.f10109e.setPadding(this.f10109e.getPaddingLeft(), jW_().getDimensionPixelOffset(2131430869), this.f10109e.getPaddingRight(), this.f10109e.getPaddingBottom());
        }
        for (SideshowUnitWrapper b2 : this.f10111g) {
            b2.m10178b();
        }
        LogUtils.f(2112221853, a);
    }

    public final void m10174H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1324212172);
        super.H();
        for (SideshowUnitWrapper c : this.f10111g) {
            c.m10179c();
        }
        LogUtils.f(-406799297, a);
    }

    public final Loader<Void> n_(int i) {
        switch (i) {
            case 1:
                return new SideshowLoader(getContext(), this.f10105a, this.f10111g);
            default:
                return null;
        }
    }

    public final void gA_() {
    }

    public final void m10176a(Loader loader, Object obj) {
        List arrayList = new ArrayList(this.f10111g.size());
        for (SideshowUnitWrapper sideshowUnitWrapper : this.f10111g) {
            SideshowAnalyticsLogger sideshowAnalyticsLogger;
            HoneyClientEvent honeyClientEvent;
            if (sideshowUnitWrapper.f10113b != LoadResult.ERROR) {
                arrayList.add(sideshowUnitWrapper);
                sideshowAnalyticsLogger = this.f10107c;
                String g = sideshowUnitWrapper.m10180g();
                long j = sideshowUnitWrapper.f10117f;
                honeyClientEvent = new HoneyClientEvent("sideshow_load_success");
                honeyClientEvent.c = "sideshow";
                sideshowAnalyticsLogger.f10119a.a(honeyClientEvent.b("sideshow_name", g).a("loading_time", j));
            } else {
                sideshowAnalyticsLogger = this.f10107c;
                String g2 = sideshowUnitWrapper.m10180g();
                honeyClientEvent = new HoneyClientEvent("sideshow_load_fail");
                honeyClientEvent.c = "sideshow";
                sideshowAnalyticsLogger.f10119a.a(honeyClientEvent.b("sideshow_name", g2));
            }
        }
        if (!arrayList.isEmpty()) {
            this.f10108d.b();
            m10172a(arrayList);
        }
    }

    private void m10172a(List<SideshowUnitWrapper> list) {
        this.f10110f.removeAllViews();
        for (SideshowUnitWrapper sideshowUnitWrapper : list) {
            View view;
            ViewGroup viewGroup = (ViewGroup) b(null).inflate(2130907099, this.f10110f, false);
            Context context = getContext();
            boolean z = true;
            if (sideshowUnitWrapper.f10115d != 0) {
                if (sideshowUnitWrapper.f10114c == null) {
                    z = false;
                }
                Preconditions.checkArgument(z, "View should have already been created.");
                view = sideshowUnitWrapper.f10114c;
            } else {
                sideshowUnitWrapper.f10115d = 1;
                sideshowUnitWrapper.f10114c = sideshowUnitWrapper.f10112a.a(context, viewGroup);
                sideshowUnitWrapper.m10178b();
                view = sideshowUnitWrapper.f10114c;
            }
            this.f10110f.addView(view);
        }
    }

    private void aq() {
        E().a(1, null, this);
        this.f10108d.a();
    }
}

package com.facebook.katana.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.apptab.interfaces.AppTabHost;
import com.facebook.apptab.state.NavigationMemoryConfig;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.apptab.state.TabTag;
import com.facebook.apptab.ui.AppTabBarBroadcaster;
import com.facebook.apptab.ui.chrome.FragmentCoordinatorLogger;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.cache.FbFragmentStackTracker;
import com.facebook.common.activity.IFbMainTabActivity;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.sideshow.SideshowHost;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.ScrollableListContainer;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: profile_image_big_size */
public class FbChromeFragment extends FbFragment implements AppTabHost, FragmentWithDebugInfo {
    private BaseFbBroadcastManager f8862a;
    public ColumnWidthConfig aA;
    private ArrayList<String> aB = new ArrayList();
    private FrameLayout aC;
    public int al = 2;
    public ListenableFutureTask<?> am;
    public String an;
    private TabTag ao;
    private Intent ap;
    private FbFragmentStackTracker aq;
    public NavigationLogger ar;
    public ImpressionManager as;
    private FragmentCoordinatorLogger at;
    private FragmentFactoryMap au;
    public NavigationMemoryConfig av;
    private boolean aw;
    public boolean ax;
    private boolean ay;
    private TabletColumnLayoutManager az;
    private AppTabBarBroadcaster f8863b;
    private SelfRegistrableReceiverImpl f8864c;
    private AbstractFbErrorReporter f8865d;
    private boolean f8866e = true;
    public DefaultAppChoreographer f8867f;
    public ResourceManager f8868g;
    private AppTabBarBroadcaster f8869h;
    private TodayExperimentController f8870i;

    /* compiled from: profile_image_big_size */
    class C03962 implements ActionReceiver {
        final /* synthetic */ FbChromeFragment f8952a;

        C03962(FbChromeFragment fbChromeFragment) {
            this.f8952a = fbChromeFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -714104328);
            FbChromeFragment fbChromeFragment = this.f8952a;
            if (Objects.equal(AppTabBarBroadcaster.m6551a(intent), fbChromeFragment.an)) {
                Object obj;
                if (fbChromeFragment.aq() != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    fbChromeFragment.m13745a(false);
                } else {
                    Fragment aq = fbChromeFragment.aq();
                    if (!((aq instanceof NewsFeedSwitcherFragment) && ((NewsFeedSwitcherFragment) aq).a())) {
                        Fragment aq2 = fbChromeFragment.aq();
                        if (aq2 != null) {
                            Object obj2;
                            Fragment aq3 = fbChromeFragment.aq();
                            if (!(aq3 instanceof ScrollableListContainer) || (!aq3.f107K && aq3.f137y && ((ScrollableListContainer) aq3).gC_())) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if (obj2 == null) {
                                ((ScrollableListContainer) aq2).gB_();
                            }
                        }
                    }
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 523467389, a);
        }
    }

    private void m13739a(FragmentTransaction fragmentTransaction) {
        if (av()) {
            this.f8862a.m2955a("broadcast_new_fragment_transaction_in_current_tab");
            Fragment a = m279s().mo841a("chromeless:content:fragment:tag");
            if (a == null || !a.m282z()) {
                a = null;
            }
            Fragment fragment = a;
            if (fragment != null) {
                fragmentTransaction.mo1844a(fragment);
            }
        }
    }

    private void m13740b(Fragment fragment) {
        this.aq.m13802a(this, 1);
        if (av()) {
            this.f8862a.m2955a("broadcast_after_fragment_pushed_in_current_tab");
            this.as.m5538a(m278o());
            if ((fragment instanceof AnalyticsFragment) && m225D()) {
                this.ar.m5506a(fragment, m278o());
            }
        }
    }

    public final void mo1859c(@Nullable Bundle bundle) {
        int i = 0;
        super.mo1859c(bundle);
        if (bundle != null) {
            ArrayList stringArrayList = bundle.getStringArrayList("fbchromefragment_eventlog");
            if (stringArrayList != null) {
                stringArrayList.addAll(this.aB);
                this.aB = stringArrayList;
            }
        }
        Bundle bundle2 = this.f131s;
        this.an = bundle2.getString("current_tab_name_in_focus");
        this.ao = TabTag.fromName(this.an);
        this.ap = (Intent) bundle2.getParcelable("tab_root_intent");
        InjectorLike an = an();
        this.az = TabletColumnLayoutManager.m8710a(an);
        this.ay = this.az.m8716a(this.ao.contentFragmentType);
        this.au = FragmentFactoryMapImpl.m13795a(an);
        this.aq = FbFragmentStackTracker.m13800a(an);
        this.ar = NavigationLogger.m5475a(an);
        this.as = ImpressionManager.m5536a(an);
        this.at = FragmentCoordinatorLogger.m4277a(an);
        this.f8862a = LocalFbBroadcastManager.m2946a(an);
        this.f8863b = AppTabBarBroadcaster.m6550a(an);
        this.av = TabBarStateManager.m6591a(an).m6598c();
        this.f8867f = DefaultAppChoreographer.m1621a(an);
        this.f8868g = ResourceManager.m9199a(an);
        this.f8869h = AppTabBarBroadcaster.m6550a(an);
        this.f8865d = FbErrorReporterImpl.m2317a(an);
        this.f8870i = TodayExperimentController.m8720a(an);
        final StartupPerfLogger b = StartupPerfLogger.m3414b(an);
        this.aq.m13802a(this, 0);
        if (bundle != null) {
            this.aw = bundle.getBoolean("has_root_fragment_inited");
            FbFragmentStackTracker fbFragmentStackTracker = this.aq;
            if (this.aw) {
                i = 1;
            }
            fbFragmentStackTracker.m13802a(this, i);
        }
        this.f8864c = this.f8862a.m2951a().mo506a("com.facebook.apptab.ui.TAB_BAR_ITEM_TAP", new C03962(this)).mo506a("com.facebook.apptab.ui.MAINTAB_CHROME_DRAWN", new ActionReceiver(this) {
            final /* synthetic */ FbChromeFragment f8954b;

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2144231573);
                b.m3446c(655485, "MainTabActivityChromeDrawn");
                this.f8954b.ax = true;
                this.f8954b.m13745a(false);
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -936002519, a);
            }
        }).mo503a();
        this.f8864c.m3296b();
    }

    public final View mo1857a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1319154880);
        View inflate = layoutInflater.inflate(this.ay ? 2130905155 : 2130905156, viewGroup, false);
        if (this.ay) {
            this.aC = (FrameLayout) inflate.findViewById(2131562126);
        }
        this.f8869h.f3953a.m2955a("com.facebook.apptab.ui.TAB_WAITING_FOR_DRAW");
        inflate.setId(FbRootViewUtil.m13816b(getContext()));
        ar();
        LogUtils.f(1350312227, a);
        return inflate;
    }

    private void ar() {
        if (!this.ay) {
            this.aA = null;
        } else if (this.aC == null) {
            this.aA = null;
        } else {
            this.aA = this.az.m8718b(this.ao.contentFragmentType);
            if (this.aA.m12008a()) {
                ((LayoutParams) this.aC.getLayoutParams()).width = this.aA.m12009g();
                this.aC.setVisibility(0);
                this.aC.setPadding(0, 0, this.aA.f7376e, 0);
                return;
            }
            this.aC.setVisibility(8);
        }
    }

    public final void mo20e(Bundle bundle) {
        super.mo20e(bundle);
        bundle.putBoolean("has_root_fragment_inited", this.aw);
        bundle.putStringArrayList("fbchromefragment_eventlog", this.aB);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 428949816);
        super.mY_();
        this.aC = null;
        this.ax = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -118413607, a);
    }

    public final void mo18d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1240783886);
        super.mo18d(bundle);
        if (bundle != null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1825071924, a);
            return;
        }
        if (this.an.equals(TabTag.Feed.name())) {
            m13745a(true);
        } else if (TabTag.isNotificationsTabTag(this.ao)) {
            if ((this.al == 2 || this.f8868g == null || this.f8868g.f5329o.getMemoryClass() >= this.av.lowMemoryOptimizationThresholdMb) && this.f8867f != null) {
                this.am = this.f8867f.m1634a("FbChromeFragment Preload", new 3(this), AppChoreographer$Priority.APPLICATION_LOADED_UI_IDLE, AppChoreographer$ThreadType.UI);
            }
        }
        LogUtils.f(1919915265, a);
    }

    public final void m13745a(boolean z) {
        if (this.aw || !this.ax) {
            return;
        }
        if (this.al == 2 || z) {
            int intExtra = this.ap.getIntExtra("target_fragment", -1);
            Preconditions.checkArgument(intExtra != -1, "Cannot load fragment, type not specified");
            FragmentManager s = m279s();
            if (s.mo851c()) {
                ar();
                FragmentCoordinatorLogger fragmentCoordinatorLogger = this.at;
                Bundle extras = this.ap.getExtras();
                if (!(extras == null || extras.isEmpty())) {
                    fragmentCoordinatorLogger.f2094a.m4284a(StringFormatUtil.formatStrLocaleSafe("IntentAction: (%s)", extras.toString()));
                }
                Fragment a = this.au.mo1879a(intExtra).mo1883a(this.ap);
                a.mo1860g(m225D());
                FragmentTransaction a2 = s.mo842a();
                a2.mo1848b(2131558429, a);
                if (this.ay) {
                    a2.mo1848b(2131562126, Fragment.m220a(getContext(), SideshowHost.class.getName()));
                }
                m13739a(a2);
                a2.mo1847b();
                s.mo849b();
                m13740b(a);
                this.aw = true;
            }
        }
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -186045719);
        super.mj_();
        if (this.am != null) {
            this.am.cancel(false);
            this.am = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 505058392, a);
    }

    public final void mo1856I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1348752279);
        super.mo1856I();
        if (this.f8864c != null) {
            this.f8864c.m3297c();
            this.f8864c = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1693518781, a);
    }

    public final void mo1858a(int i, int i2, @Nullable Intent intent) {
        Fragment aq = aq();
        if (aq != null) {
            aq.mo1858a(i, i2, intent);
        } else {
            this.f8865d.m2350b("fragment coordinator", "Current fragment is null onActivityResult() -- maybe failed to restore fragment from saved state?");
        }
    }

    public Map<String, String> getDebugInfo() {
        Fragment aq = aq();
        if (aq instanceof FragmentWithDebugInfo) {
            return ((FragmentWithDebugInfo) aq).getDebugInfo();
        }
        return null;
    }

    public final void mo785a(TabTag tabTag, Tooltip tooltip) {
        if (av()) {
            ((AppTabHost) ao()).mo785a(tabTag, tooltip);
        }
    }

    public final void mo1860g(boolean z) {
        super.mo1860g(z);
        if (this.aw) {
            Fragment aq = aq();
            if (aq != null) {
                aq.mo1860g(z);
            }
        }
    }

    private boolean av() {
        IFbMainTabActivity iFbMainTabActivity = (IFbMainTabActivity) ao();
        return iFbMainTabActivity != null && iFbMainTabActivity.mo788a(this);
    }

    @Nullable
    public final Fragment aq() {
        if (this.aw && mx_()) {
            return m279s().mo839a(2131558429);
        }
        return null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ar();
    }

    public final View m13748e() {
        return this.f116T;
    }
}

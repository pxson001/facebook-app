package com.facebook.friendsnearby.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.MapsInitializer;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.CircleOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.SizeUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.DataSource;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder.Listener;
import com.facebook.friendsnearby.model.FriendsNearbyNewMapRow;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.ui.FriendsNearbyRowView.OnClickListener;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapFragmentDelegate;
import com.facebook.maps.MapMarkerPositionAnimator;
import com.facebook.maps.UrlImageMarkerController;
import com.facebook.maps.delegate.CameraUpdateDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.CircleDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.13;
import com.facebook.maps.delegate.MapDelegate.14;
import com.facebook.maps.delegate.MapDelegate.17;
import com.facebook.maps.delegate.MapDelegate.18;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.MapDelegate.OnMarkerClickListener;
import com.facebook.maps.delegate.MapUtils;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.maps.delegate.UiSettingsDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WebServiceHandler received unsupported operation of type  */
public class FriendsNearbyMapFragment extends FbFragment {
    private UrlImageMarkerController f20971a;
    private CameraPosition aA;
    public boolean aB = false;
    public FriendsNearbyNewDataHolder aC;
    public final List<String> aD = Lists.a();
    private final Map<String, MarkerDelegate> aE = Maps.c();
    private CircleDelegate al;
    public View am;
    public View an;
    public View ao;
    public FbMapFragmentDelegate ap;
    public View aq;
    public TextView ar;
    private boolean as;
    public FriendsNearbyFragment at;
    private OnClickListener au;
    private int av = 0;
    public MapState aw;
    public ObjectAnimator ax;
    public ObjectAnimator ay;
    @Nullable
    public String az;
    private FriendsNearbyMapMarkerImageTransformation f20972b;
    private MapMarkerPositionAnimator f20973c;
    public SecureContextHelper f20974d;
    private ScheduledExecutorService f20975e;
    public Toaster f20976f;
    public ImmutableList<? extends FriendsNearbyMapPingAction> f20977g;
    public FriendsNearbyDashboardAnalyticsLogger f20978h;
    public FriendsNearbyRowView f20979i;

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29731 implements Listener {
        final /* synthetic */ FriendsNearbyMapFragment f20951a;

        public C29731(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20951a = friendsNearbyMapFragment;
        }

        public final void mo924a() {
            FriendsNearbyMapFragment.m21952e(this.f20951a);
        }

        public final void mo926b() {
            FriendsNearbyMapFragment.m21952e(this.f20951a);
        }

        public final void mo925a(String str) {
            FriendsNearbyMapFragment.m21943a(this.f20951a, str);
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    class C29753 implements Runnable {
        final /* synthetic */ FriendsNearbyMapFragment f20956a;

        C29753(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20956a = friendsNearbyMapFragment;
        }

        public void run() {
            FriendsNearbyMapFragment friendsNearbyMapFragment = this.f20956a;
            int height = friendsNearbyMapFragment.f20979i.getHeight();
            friendsNearbyMapFragment.aB = false;
            friendsNearbyMapFragment.f20979i.setVisibility(8);
            friendsNearbyMapFragment.ay = ObjectAnimator.ofFloat(friendsNearbyMapFragment.f20979i, "translationY", new float[]{(float) (-height), 0.0f});
            friendsNearbyMapFragment.ay.addListener(new C29764(friendsNearbyMapFragment));
            friendsNearbyMapFragment.ax = ObjectAnimator.ofFloat(friendsNearbyMapFragment.f20979i, "translationY", new float[]{0.0f, (float) (-height)});
            friendsNearbyMapFragment.ax.addListener(new C29775(friendsNearbyMapFragment));
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29764 implements AnimatorListener {
        final /* synthetic */ FriendsNearbyMapFragment f20957a;

        public C29764(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20957a = friendsNearbyMapFragment;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f20957a.aB) {
                this.f20957a.f20979i.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29775 implements AnimatorListener {
        final /* synthetic */ FriendsNearbyMapFragment f20958a;

        public C29775(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20958a = friendsNearbyMapFragment;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f20958a.aB) {
                this.f20958a.f20979i.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29786 implements View.OnClickListener {
        final /* synthetic */ FriendsNearbyMapFragment f20959a;

        public C29786(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20959a = friendsNearbyMapFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1107222645);
            this.f20959a.f20978h.m21709d("previous_button");
            this.f20959a.m21959a(true);
            Logger.a(2, EntryType.UI_INPUT_END, 1706783498, a);
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29797 implements View.OnClickListener {
        final /* synthetic */ FriendsNearbyMapFragment f20960a;

        public C29797(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20960a = friendsNearbyMapFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1646839370);
            this.f20960a.f20978h.m21709d("next_button");
            this.f20960a.m21960b(true);
            Logger.a(2, EntryType.UI_INPUT_END, 458199701, a);
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29808 implements View.OnClickListener {
        final /* synthetic */ FriendsNearbyMapFragment f20961a;

        public C29808(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20961a = friendsNearbyMapFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1029938950);
            this.f20961a.f20978h.m21709d("location_button");
            ImmutableLocation b = ImmutableLocation.b(FriendsNearbyMapFragment.ax(this.f20961a).d());
            if (b == null) {
                this.f20961a.f20976f.b(new ToastBuilder(2131242003));
                Logger.a(2, EntryType.UI_INPUT_END, 2020288603, a);
                return;
            }
            FriendsNearbyMapFragment.m21939a(this.f20961a, 750);
            FriendsNearbyMapFragment.m21941a(this.f20961a, new LatLng(b.a(), b.b()), 750, null);
            LogUtils.a(1513678893, a);
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class C29819 implements OnMapClickListener {
        final /* synthetic */ FriendsNearbyMapFragment f20962a;

        public C29819(FriendsNearbyMapFragment friendsNearbyMapFragment) {
            this.f20962a = friendsNearbyMapFragment;
        }

        public final void m21935a() {
            if (this.f20962a.aw == MapState.EXPANDED) {
                FriendsNearbyMapFragment.m21939a(this.f20962a, 750);
                return;
            }
            this.f20962a.f20978h.m21724r();
            this.f20962a.m21957a(MapState.EXPANDED);
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public enum MapState {
        HEADER,
        EXPANDED
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class PingActionFragment extends DialogFragment {
        private String al;
        private ImmutableLocation am;
        public SecureContextHelper an;
        private ImmutableList<? extends FriendsNearbyMapPingAction> ao;
        public FriendsNearbyDashboardAnalyticsLogger ap;

        public final void m21936a(String str, ImmutableLocation immutableLocation, SecureContextHelper secureContextHelper, ImmutableList<? extends FriendsNearbyMapPingAction> immutableList, FriendsNearbyDashboardAnalyticsLogger friendsNearbyDashboardAnalyticsLogger) {
            this.al = str;
            this.am = immutableLocation;
            this.an = secureContextHelper;
            this.ao = immutableList;
            this.ap = friendsNearbyDashboardAnalyticsLogger;
        }

        public final Dialog m21937c(Bundle bundle) {
            Builder builder = ImmutableList.builder();
            Builder builder2 = ImmutableList.builder();
            Builder builder3 = ImmutableList.builder();
            int size = this.ao.size();
            for (int i = 0; i < size; i++) {
                FriendsNearbyMapPingAction friendsNearbyMapPingAction = (FriendsNearbyMapPingAction) this.ao.get(i);
                Optional a = friendsNearbyMapPingAction.m21964a(getContext(), this.am, this.al);
                if (a.isPresent()) {
                    builder.c(a.get());
                    builder2.c(friendsNearbyMapPingAction.mo948a());
                    builder3.c(friendsNearbyMapPingAction.mo949b());
                }
            }
            final ImmutableList b = builder.b();
            final ImmutableList b2 = builder3.b();
            AlertDialog a2 = new AlertDialog.Builder(getContext()).a(2131242021).a((CharSequence[]) builder2.b().toArray(new CharSequence[0]), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ PingActionFragment f20965c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f20965c.ap.m21711e((String) b2.get(i));
                    PingActionFragment pingActionFragment = this.f20965c;
                    pingActionFragment.an.b((Intent) b.get(i), pingActionFragment.getContext());
                }
            }).a();
            a2.setCanceledOnTouchOutside(true);
            return a2;
        }
    }

    /* compiled from: WebServiceHandler received unsupported operation of type  */
    public class VisibleArea {
        public final int f20966a;
        public final int f20967b;
        public final int f20968c;
        public final int f20969d;
        public final long f20970e;

        public VisibleArea(int i, int i2, int i3, int i4, long j) {
            this.f20966a = i;
            this.f20967b = i2;
            this.f20968c = i3;
            this.f20969d = i4;
            this.f20970e = j;
        }
    }

    public static void m21947a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsNearbyMapFragment) obj).m21945a(new UrlImageMarkerController(ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike)), FriendsNearbyMapMarkerImageTransformation.m21963b(injectorLike), MapMarkerPositionAnimator.b(injectorLike), FriendsNearbyDashboardAnalyticsLogger.m21698a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), FriendsNearbyMapPingOpenInUberAction.m21972b(injectorLike), FriendsNearbyMapPingOpenInMapAction.m21968b(injectorLike));
    }

    @Inject
    private void m21945a(UrlImageMarkerController urlImageMarkerController, FriendsNearbyMapMarkerImageTransformation friendsNearbyMapMarkerImageTransformation, MapMarkerPositionAnimator mapMarkerPositionAnimator, FriendsNearbyDashboardAnalyticsLogger friendsNearbyDashboardAnalyticsLogger, SecureContextHelper secureContextHelper, ScheduledExecutorService scheduledExecutorService, Toaster toaster, FriendsNearbyMapPingOpenInUberAction friendsNearbyMapPingOpenInUberAction, FriendsNearbyMapPingOpenInMapAction friendsNearbyMapPingOpenInMapAction) {
        this.f20971a = urlImageMarkerController;
        this.f20972b = friendsNearbyMapMarkerImageTransformation;
        this.f20973c = mapMarkerPositionAnimator;
        this.f20978h = friendsNearbyDashboardAnalyticsLogger;
        this.f20974d = secureContextHelper;
        this.f20975e = scheduledExecutorService;
        this.f20976f = toaster;
        this.f20977g = ImmutableList.of(friendsNearbyMapPingOpenInUberAction, friendsNearbyMapPingOpenInMapAction);
    }

    public final void m21956a(FriendsNearbyFragment friendsNearbyFragment) {
        this.at = friendsNearbyFragment;
    }

    public final void m21958a(OnClickListener onClickListener) {
        this.au = onClickListener;
    }

    private static ImmutableSet<String> m21938a(FriendsNearbySection friendsNearbySection) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (FriendsNearbyRow a : friendsNearbySection.e()) {
            builder.c(a.mo908a());
        }
        return builder.b();
    }

    public static void m21952e(FriendsNearbyMapFragment friendsNearbyMapFragment) {
        if (friendsNearbyMapFragment.ap != null && friendsNearbyMapFragment.ap.a() != null && friendsNearbyMapFragment.ap.a().b() != null) {
            FriendsNearbySection e = friendsNearbyMapFragment.aC.m20892e();
            boolean a = friendsNearbyMapFragment.m21949a(m21938a(e));
            friendsNearbyMapFragment.aD.clear();
            MapDelegate ax = ax(friendsNearbyMapFragment);
            boolean z = a;
            for (FriendsNearbyRow friendsNearbyRow : e.e()) {
                String a2 = friendsNearbyRow.mo908a();
                friendsNearbyMapFragment.aD.add(a2);
                FriendsNearbyNewMapRow friendsNearbyNewMapRow = (FriendsNearbyNewMapRow) friendsNearbyRow;
                LatLng latLng = new LatLng(friendsNearbyNewMapRow.m20917j().a(), friendsNearbyNewMapRow.m20917j().b());
                MarkerDelegate markerDelegate = (MarkerDelegate) friendsNearbyMapFragment.aE.get(a2);
                if (markerDelegate != null) {
                    a = ax.b().a().e.a(markerDelegate.a());
                    boolean a3 = ax.b().a().e.a(latLng);
                    markerDelegate.a(latLng);
                    markerDelegate.a(a2);
                    if (a3 != a) {
                        a = true;
                    } else {
                        a = z;
                    }
                    z = a;
                } else {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.b = latLng;
                    markerOptions = markerOptions;
                    markerOptions.h = a2;
                    markerOptions = markerOptions;
                    markerOptions.c = BitmapDescriptorFactory.a(2130840475);
                    markerDelegate = ax.a(markerOptions.a(0.5f, 0.5f));
                    friendsNearbyMapFragment.f20971a.a(markerDelegate, friendsNearbyRow.mo911b(), friendsNearbyMapFragment.f20972b);
                    friendsNearbyMapFragment.aE.put(a2, markerDelegate);
                    if (ax.b().a().e.a(latLng)) {
                        a = z;
                    } else {
                        a = true;
                    }
                    z = a;
                }
            }
            if (z) {
                friendsNearbyMapFragment.aA = null;
            }
            ImmutableList f = friendsNearbyMapFragment.aC.m20893f();
            if (f != null && f.size() == 1) {
                String str = (String) f.get(0);
                if (str != null) {
                    friendsNearbyMapFragment.az = str;
                    friendsNearbyMapFragment.aC.m20894g();
                    friendsNearbyMapFragment.aw = MapState.EXPANDED;
                }
            }
            if (friendsNearbyMapFragment.az != null) {
                int indexOf = friendsNearbyMapFragment.aD.indexOf(friendsNearbyMapFragment.az);
                if (indexOf == -1) {
                    friendsNearbyMapFragment.av = 0;
                    friendsNearbyMapFragment.az = null;
                } else {
                    friendsNearbyMapFragment.av = indexOf;
                }
            }
            friendsNearbyMapFragment.m21957a(friendsNearbyMapFragment.aw);
        }
    }

    public static void m21943a(FriendsNearbyMapFragment friendsNearbyMapFragment, final String str) {
        MarkerDelegate markerDelegate = (MarkerDelegate) friendsNearbyMapFragment.aE.get(str);
        if (markerDelegate != null) {
            FriendsNearbyRow e = friendsNearbyMapFragment.aC.m20891e(str);
            if (e != null) {
                final ImmutableLocation immutableLocation = e.f20518a;
                final LatLng latLng = new LatLng(immutableLocation.a(), immutableLocation.b());
                if (Objects.equal(friendsNearbyMapFragment.az, str)) {
                    friendsNearbyMapFragment.au();
                    friendsNearbyMapFragment.m21946a(CameraUpdateFactoryDelegate.a(latLng), 750, null);
                    friendsNearbyMapFragment.f20979i.m21986a(e, friendsNearbyMapFragment.au);
                }
                friendsNearbyMapFragment.f20973c.a(markerDelegate, latLng, 750, ax(friendsNearbyMapFragment), new Object(friendsNearbyMapFragment) {
                    public final /* synthetic */ FriendsNearbyMapFragment f20955d;
                });
            }
        }
    }

    public final void m21957a(MapState mapState) {
        m21942a(this, mapState, this.az);
    }

    public static void m21942a(FriendsNearbyMapFragment friendsNearbyMapFragment, @Nullable MapState mapState, String str) {
        MapDelegate ax = ax(friendsNearbyMapFragment);
        if (ax != null) {
            friendsNearbyMapFragment.aw = mapState;
            VisibleArea a = friendsNearbyMapFragment.at.m21874a(mapState);
            switch (friendsNearbyMapFragment.aw) {
                case HEADER:
                    friendsNearbyMapFragment.am.setVisibility(4);
                    ax.c().a(false);
                    ax.a(a.f20966a, a.f20967b, a.f20968c, a.f20969d);
                    break;
                case EXPANDED:
                    friendsNearbyMapFragment.am.setVisibility(0);
                    ax.c().a(true);
                    ax.a(a.f20966a, friendsNearbyMapFragment.f20979i.getHeight() + a.f20967b, a.f20968c, (friendsNearbyMapFragment.T.getHeight() - friendsNearbyMapFragment.am.getTop()) + a.f20969d);
                    break;
            }
            m21944a(friendsNearbyMapFragment, str, a.f20970e);
            if (friendsNearbyMapFragment.aE.size() <= 1 || friendsNearbyMapFragment.aw != MapState.EXPANDED) {
                friendsNearbyMapFragment.an.setVisibility(8);
                friendsNearbyMapFragment.ao.setVisibility(8);
                return;
            }
            friendsNearbyMapFragment.an.setVisibility(0);
            friendsNearbyMapFragment.ao.setVisibility(0);
        }
    }

    public final void m21959a(boolean z) {
        aw();
        if (this.az == null && this.av == 0) {
            aw();
        }
        m21944a(this, m21953g(this.av), z ? 750 : 0);
    }

    public final void m21960b(boolean z) {
        av();
        if (this.az == null && this.av == 0) {
            av();
        }
        m21944a(this, m21953g(this.av), z ? 750 : 0);
    }

    public final View m21955a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2097756483);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130904532, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 276297295, a);
        return inflate;
    }

    public final void m21961c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendsNearbyMapFragment.class;
        m21947a((Object) this, getContext());
        MapsInitializer.a(o());
        this.aw = MapState.HEADER;
        if (this.aC != null) {
            this.f20978h.m21702a(m21938a(this.aC.m20892e()));
        }
    }

    public final void m21962d(Bundle bundle) {
        FbMapFragmentDelegate a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -39121583);
        super.d(bundle);
        this.f20979i = (FriendsNearbyRowView) e(2131562381);
        this.f20979i.post(new C29753(this));
        this.am = e(2131562382);
        this.an = e(2131562383);
        this.ao = e(2131562384);
        this.aq = b(bundle).inflate(2130904531, null);
        this.ar = (TextView) b(bundle).inflate(2130904533, null);
        this.an.setOnClickListener(new C29786(this));
        this.ao.setOnClickListener(new C29797(this));
        this.am.setOnClickListener(new C29808(this));
        Fragment a3 = s().a("map_fragment");
        if (a3 == null) {
            FacebookMapOptions facebookMapOptions = new FacebookMapOptions();
            facebookMapOptions.m = "friends_nearby";
            a = FbMapFragmentDelegate.a(facebookMapOptions);
        } else {
            a = (FbMapFragmentDelegate) a3;
        }
        this.ap = a;
        s().a().b(2131559301, this.ap, "map_fragment").b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1203206217, a2);
    }

    public final void m21954G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1890724607);
        super.G();
        if (!this.as) {
            MapDelegate ax = ax(this);
            if (ax != null) {
                ax.a(true);
                ax.c().c(false);
                UiSettingsDelegate c = ax.c();
                if (c.a != null) {
                    c.a.f(false);
                } else {
                    c.b.a(false);
                }
                ax.c().b(true);
                ax.a(new C29819(this));
                ax.a(new OnMarkerClickListener(this) {
                    final /* synthetic */ FriendsNearbyMapFragment f20945a;

                    {
                        this.f20945a = r1;
                    }

                    public final boolean m21928a(MarkerDelegate markerDelegate) {
                        this.f20945a.f20978h.m21709d("marker_tap");
                        String b = markerDelegate.b();
                        if (this.f20945a.aw == MapState.EXPANDED) {
                            FriendsNearbyMapFragment.m21944a(this.f20945a, b, 750);
                        } else {
                            FriendsNearbyMapFragment.m21942a(this.f20945a, MapState.EXPANDED, b);
                        }
                        return true;
                    }
                });
                AnonymousClass11 anonymousClass11 = new Object(this) {
                    final /* synthetic */ FriendsNearbyMapFragment f20946a;

                    {
                        this.f20946a = r1;
                    }

                    public final void m21929a(MarkerDelegate markerDelegate) {
                        String b = markerDelegate.b();
                        FriendsNearbyMapFragment friendsNearbyMapFragment = this.f20946a;
                        PingActionFragment pingActionFragment = new PingActionFragment();
                        pingActionFragment.m21936a(friendsNearbyMapFragment.aC.m20888c(b).k(), friendsNearbyMapFragment.aC.m20891e(b).f20518a, friendsNearbyMapFragment.f20974d, friendsNearbyMapFragment.f20977g, friendsNearbyMapFragment.f20978h);
                        pingActionFragment.a(friendsNearbyMapFragment.ap.D, "pingActions");
                    }
                };
                if (ax.a != null) {
                    ax.a.o = new 13(ax, anonymousClass11);
                } else if (ax.b != null) {
                    ax.b.a(new 14(ax, anonymousClass11));
                }
                AnonymousClass12 anonymousClass12 = new Object(this) {
                    final /* synthetic */ FriendsNearbyMapFragment f20947a;

                    {
                        this.f20947a = r1;
                    }

                    public final View m21931b(MarkerDelegate markerDelegate) {
                        String b = markerDelegate.b();
                        if (this.f20947a.aw == MapState.EXPANDED) {
                            Object obj;
                            FriendsNearbyMapFragment friendsNearbyMapFragment = this.f20947a;
                            int size = friendsNearbyMapFragment.f20977g.size();
                            for (int i = 0; i < size; i++) {
                                if (((FriendsNearbyMapPingAction) friendsNearbyMapFragment.f20977g.get(i)).m21964a(friendsNearbyMapFragment.getContext(), friendsNearbyMapFragment.aC.m20891e(b).f20518a, friendsNearbyMapFragment.aC.m20888c(b).k()).isPresent()) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                return null;
                            }
                        }
                        return this.f20947a.aq;
                    }

                    public final View m21930a(MarkerDelegate markerDelegate) {
                        User c = this.f20947a.aC.m20888c(markerDelegate.b());
                        this.f20947a.ar.setText(this.f20947a.a(2131242019, new Object[]{c.k()}));
                        return this.f20947a.ar;
                    }
                };
                if (ax.a != null) {
                    ax.a.N = new 17(ax, anonymousClass12);
                } else if (ax.b != null) {
                    ax.b.a(new 18(ax, anonymousClass12));
                }
            } else if (this.at != null) {
                this.at.aq();
            }
            this.as = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -30656165, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -963049686);
        super.mY_();
        this.aE.clear();
        UrlImageMarkerController urlImageMarkerController = this.f20971a;
        for (DataSource g : urlImageMarkerController.d) {
            g.g();
        }
        urlImageMarkerController.d.clear();
        urlImageMarkerController.e.clear();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1811843464, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1890208657);
        super.mi_();
        UrlImageMarkerController urlImageMarkerController = this.f20971a;
        urlImageMarkerController.f = true;
        urlImageMarkerController.g = false;
        if (this.f20971a.g) {
            m21952e(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1025604592, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1614263650);
        super.mj_();
        UrlImageMarkerController urlImageMarkerController = this.f20971a;
        urlImageMarkerController.f = false;
        for (CloseableReference c : urlImageMarkerController.e) {
            CloseableReference.c(c);
        }
        if (!urlImageMarkerController.e.isEmpty()) {
            urlImageMarkerController.g = true;
        }
        urlImageMarkerController.e.clear();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1582051106, a);
    }

    private boolean m21949a(ImmutableSet<String> immutableSet) {
        boolean z = false;
        for (String str : ImmutableList.copyOf(this.aE.keySet())) {
            boolean z2;
            if (immutableSet.contains(str)) {
                z2 = z;
            } else {
                MarkerDelegate markerDelegate = (MarkerDelegate) this.aE.get(str);
                if (markerDelegate.a != null) {
                    markerDelegate.a.l();
                } else {
                    markerDelegate.b.a();
                }
                this.aE.remove(str);
                z2 = true;
            }
            z = z2;
        }
        return z;
    }

    public static void m21944a(@Nullable FriendsNearbyMapFragment friendsNearbyMapFragment, String str, long j) {
        if (str == null) {
            m21939a(friendsNearbyMapFragment, j);
            friendsNearbyMapFragment.m21950b(j);
            return;
        }
        int i;
        if (friendsNearbyMapFragment.az != null) {
            ((MarkerDelegate) friendsNearbyMapFragment.aE.get(friendsNearbyMapFragment.az)).e();
        }
        if (friendsNearbyMapFragment.aw != MapState.EXPANDED) {
            friendsNearbyMapFragment.m21951d(j);
        } else if (!friendsNearbyMapFragment.aB) {
            friendsNearbyMapFragment.aB = true;
            friendsNearbyMapFragment.ay.setDuration(j).start();
        }
        FriendsNearbyRow e = friendsNearbyMapFragment.aC.m20891e(str);
        final MarkerDelegate markerDelegate = (MarkerDelegate) friendsNearbyMapFragment.aE.get(str);
        m21940a(friendsNearbyMapFragment, markerDelegate.a(), (double) ((Float) e.f20518a.c().get()).floatValue());
        friendsNearbyMapFragment.f20979i.m21986a(e, friendsNearbyMapFragment.au);
        if (str == null) {
            i = 0;
        } else {
            i = friendsNearbyMapFragment.aD.indexOf(str) + 1;
        }
        friendsNearbyMapFragment.av = i;
        m21941a(friendsNearbyMapFragment, markerDelegate.a(), j, new Runnable(friendsNearbyMapFragment) {
            final /* synthetic */ FriendsNearbyMapFragment f20949b;

            public void run() {
                markerDelegate.d();
            }
        });
        friendsNearbyMapFragment.az = str;
    }

    public static void m21939a(FriendsNearbyMapFragment friendsNearbyMapFragment, long j) {
        friendsNearbyMapFragment.m21951d(j);
        if (friendsNearbyMapFragment.az != null) {
            ((MarkerDelegate) friendsNearbyMapFragment.aE.get(friendsNearbyMapFragment.az)).e();
        }
        friendsNearbyMapFragment.au();
        friendsNearbyMapFragment.az = null;
    }

    public static void m21941a(FriendsNearbyMapFragment friendsNearbyMapFragment, LatLng latLng, @Nullable long j, Runnable runnable) {
        if (ax(friendsNearbyMapFragment).e().b >= 14.0f) {
            friendsNearbyMapFragment.m21946a(CameraUpdateFactoryDelegate.a(latLng), j, runnable);
        } else {
            friendsNearbyMapFragment.m21946a(CameraUpdateFactoryDelegate.a(latLng, 14.0f), j, runnable);
        }
    }

    private void m21950b(long j) {
        MapDelegate ax = ax(this);
        if (this.aA != null) {
            m21946a(CameraUpdateFactoryDelegate.a(this.aA), j, null);
        } else {
            m21948a(this.aE.values(), ImmutableLocation.b(ax.d()));
        }
    }

    private void m21946a(CameraUpdateDelegate cameraUpdateDelegate, long j, @Nullable Runnable runnable) {
        MapDelegate ax = ax(this);
        if (j == 0) {
            ax.a(cameraUpdateDelegate);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        ax.a(cameraUpdateDelegate, (int) j, null);
        if (runnable != null) {
            this.f20975e.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    private void m21948a(Collection<MarkerDelegate> collection, @Nullable ImmutableLocation immutableLocation) {
        MarkerDelegate markerDelegate;
        MapDelegate ax = ax(this);
        LatLngBounds.Builder a = LatLngBounds.a();
        if (immutableLocation != null) {
            a.a(new LatLng(immutableLocation.a(), immutableLocation.b()));
        }
        for (MarkerDelegate markerDelegate2 : collection) {
            a.a(markerDelegate2.a());
        }
        if (immutableLocation == null && collection.isEmpty()) {
            a.a(new LatLng(0.0d, 0.0d));
        }
        LatLngBounds a2 = a.a();
        ax.a(CameraUpdateFactoryDelegate.a(a2, SizeUtil.a(getContext(), 32.0f)));
        LatLngBounds latLngBounds = ax.b().a().e;
        if (!latLngBounds.a(a2.b) || !latLngBounds.a(a2.c)) {
            markerDelegate2 = (MarkerDelegate) collection.iterator().next();
            if (collection.size() == 1) {
                ax.a(CameraUpdateFactoryDelegate.a(markerDelegate2.a(), 14.0f));
            } else if (immutableLocation != null) {
                ax.a(CameraUpdateFactoryDelegate.a(new LatLng(immutableLocation.a(), immutableLocation.b())));
            } else {
                ax.a(CameraUpdateFactoryDelegate.a(markerDelegate2.a()));
            }
        } else if (ax.e().b > 14.0f) {
            ax.a(CameraUpdateFactoryDelegate.a(a2.b(), 14.0f));
        }
        this.aA = ax.e();
    }

    private void m21951d(long j) {
        if (this.aB) {
            this.aB = false;
            this.ax.setDuration(j).start();
        }
    }

    public static void m21940a(FriendsNearbyMapFragment friendsNearbyMapFragment, LatLng latLng, double d) {
        if (friendsNearbyMapFragment.al != null) {
            CircleDelegate circleDelegate = friendsNearbyMapFragment.al;
            if (circleDelegate.a != null) {
                circleDelegate.a.a(latLng);
            } else {
                circleDelegate.b.a(MapUtils.a(latLng));
            }
            circleDelegate = friendsNearbyMapFragment.al;
            if (circleDelegate.a != null) {
                circleDelegate.a.a(d);
            } else {
                circleDelegate.b.a(d);
            }
            friendsNearbyMapFragment.al.a(true);
            return;
        }
        MapDelegate ax = ax(friendsNearbyMapFragment);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.b = friendsNearbyMapFragment.jW_().getColor(2131363926);
        circleOptions = circleOptions;
        circleOptions.d = friendsNearbyMapFragment.jW_().getColor(2131363925);
        circleOptions = circleOptions;
        circleOptions.e = (float) friendsNearbyMapFragment.jW_().getDimensionPixelSize(2131427382);
        circleOptions = circleOptions;
        circleOptions.a = latLng;
        circleOptions = circleOptions;
        circleOptions.c = d;
        friendsNearbyMapFragment.al = ax.a(circleOptions);
    }

    private void au() {
        if (this.al != null) {
            this.al.a(false);
        }
    }

    private void av() {
        this.av++;
        if (this.av == this.aD.size() + 1) {
            this.av = 0;
        }
    }

    private void aw() {
        this.av--;
        if (this.av == -1) {
            this.av = this.aD.size();
        }
    }

    @Nullable
    private String m21953g(int i) {
        if (i == 0) {
            return null;
        }
        return (String) this.aD.get(i - 1);
    }

    public static MapDelegate ax(FriendsNearbyMapFragment friendsNearbyMapFragment) {
        return friendsNearbyMapFragment.ap.a();
    }
}

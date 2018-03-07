package com.facebook.nearby.maps;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.mappin.MapPinHelper;
import com.facebook.maps.GoogleMapFragment.GoogleMapOverlayElement;
import com.facebook.maps.GoogleMapFragment.SelectableOverlayItem;
import com.facebook.maps.Locations;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragment.MapOverlayElement;
import com.facebook.maps.MapFragment.MapOverlayElement.OnSelectedListener;
import com.facebook.maps.MapFragment.OnMapReadyListener;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics;
import com.facebook.nearby.cluster.MapDisplayData;
import com.facebook.nearby.cluster.MapPinViewSizeHelperV1;
import com.facebook.nearby.cluster.NearbyPlaceCluster;
import com.facebook.nearby.data.MapPinTransition;
import com.facebook.nearby.data.NearbyMapTransitionGenerator;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.places.NearbyMapAreaFragment;
import com.facebook.nearby.places.NearbyMapAreaFragment.AnonymousClass12;
import com.facebook.nearby.places.NearbyMapAreaFragment.C00699;
import com.facebook.nearby.places.NearbyMapAreaFragment.MapPinSelectState;
import com.google.android.maps.GeoPoint;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: updated_stories_count */
public class NearbyMapController {
    private static final Class<?> f367a = NearbyMapController.class;
    private static final CallerContext f368b = CallerContext.a(NearbyMapController.class, "nearby_map");
    private final NearbyMapTransitionGenerator f369c = new NearbyMapTransitionGenerator();
    private final GenericDraweeHierarchyBuilder f370d;
    private final FbDraweeControllerBuilder f371e;
    private final MapCoordinateHelper f372f = new MapCoordinateHelper();
    public final MapPinHelper f373g;
    public MapDisplayData f374h;
    private List<MapOverlayElement> f375i = new ArrayList();
    public List<MapOverlayElement> f376j = new ArrayList();
    public NearbyMapAreaFragment f377k;
    public MapFragment f378l;

    @Inject
    public NearbyMapController(FbDraweeControllerBuilder fbDraweeControllerBuilder, Context context) {
        this.f373g = new MapPinHelper(context.getResources());
        this.f370d = new GenericDraweeHierarchyBuilder(context.getResources());
        this.f371e = fbDraweeControllerBuilder;
    }

    public final MapPinViewSizeHelperV1 m480l() {
        return new MapPinViewSizeHelperV1(this.f378l.ay());
    }

    public final void m467a(Fragment fragment) {
        this.f378l = (MapFragment) fragment;
    }

    public final void m481m() {
        if (this.f374h != null) {
            List list = this.f375i;
            MapDisplayData mapDisplayData = this.f374h;
            Set hashSet = new HashSet();
            hashSet.addAll(mapDisplayData.f303c);
            hashSet.addAll(mapDisplayData.f302b);
            for (NearbyPlaceCluster nearbyPlaceCluster : mapDisplayData.f301a) {
                hashSet.addAll(nearbyPlaceCluster.f305a);
            }
            m454a(list, new ArrayList(hashSet));
        }
    }

    public final void m482o() {
        this.f378l.a(null);
    }

    public final ListenableFuture<Void> m465a(RectF rectF) {
        Location a = Locations.a((double) ((rectF.top + rectF.bottom) / 2.0f), (double) ((rectF.right + rectF.left) / 2.0f));
        int abs = (int) (((double) Math.abs(rectF.top - rectF.bottom)) * 1000000.0d);
        int abs2 = (int) (((double) Math.abs(rectF.right - rectF.left)) * 1000000.0d);
        this.f378l.a(a);
        this.f378l.a(abs, abs2);
        return Futures.a(null);
    }

    @Nullable
    public final Set<NearbyPlaceEdgeWrapper> m479j() {
        if (this.f374h == null) {
            return null;
        }
        MapCoordinateHelper mapCoordinateHelper = this.f372f;
        MapPinViewSizeHelperV1 l = m480l();
        Point a = m463a(m476d());
        Point a2 = m463a(m477e());
        RectF rectF = new RectF(((float) a.x) - ((float) null), ((float) a.y) - ((float) null), ((float) a2.x) + ((float) null), ((float) a2.y) + ((float) null));
        Set<NearbyPlaceEdgeWrapper> hashSet = new HashSet();
        for (NearbyPlaceCluster nearbyPlaceCluster : MapCoordinateHelper.m441a(l, rectF, this.f374h.f301a)) {
            hashSet.addAll(nearbyPlaceCluster.f305a);
        }
        hashSet.addAll(MapCoordinateHelper.m442a(l, rectF, this.f374h.f302b, this.f374h.f303c));
        return hashSet;
    }

    public final ListenableFuture<Void> m474b(Location location) {
        return this.f378l.b(location);
    }

    public final boolean m478h() {
        return this.f378l.az();
    }

    public final void m469a(OnMapReadyListener onMapReadyListener) {
        this.f378l.a(onMapReadyListener);
    }

    public final void m471a(AnonymousClass12 anonymousClass12) {
        this.f378l.a(anonymousClass12);
    }

    public final void m472a(C00699 c00699) {
        this.f378l.a(c00699);
    }

    public final void m468a(OnTouchListener onTouchListener) {
        this.f378l.a(onTouchListener);
    }

    public final void m466a() {
        this.f378l.as();
    }

    public final double m473b() {
        return this.f378l.e();
    }

    public final RectF m475c() {
        return this.f378l.ax();
    }

    public final Location m476d() {
        return this.f378l.at();
    }

    public final Location m477e() {
        return this.f378l.aw();
    }

    public final Point m463a(Location location) {
        return this.f378l.ay().toPixels(Locations.a(location), null);
    }

    public final Location m464a(Point point) {
        return Locations.a(this.f378l.ay().fromPixels(point.x, point.y));
    }

    public final void m470a(MapDisplayData mapDisplayData) {
        MapPinTransition a = NearbyMapTransitionGenerator.m398a(this.f374h, mapDisplayData);
        this.f374h = mapDisplayData;
        m455a(a);
    }

    private List<MapOverlayElement> m454a(List<MapOverlayElement> list, List<NearbyPlaceEdgeWrapper> list2) {
        List<MapOverlayElement> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleMapOverlayElement googleMapOverlayElement = (GoogleMapOverlayElement) it.next();
            Object obj = null;
            for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : list2) {
                Object obj2;
                Object obj3;
                GeoPoint point = googleMapOverlayElement.b.getPoint();
                GeoPoint a = Locations.a(nearbyPlaceEdgeWrapper.m502f());
                if (point.getLatitudeE6() == a.getLatitudeE6() && point.getLongitudeE6() == a.getLongitudeE6()) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    this.f378l.b(googleMapOverlayElement);
                    googleMapOverlayElement.b();
                    obj3 = 1;
                } else {
                    obj3 = obj;
                }
                obj = obj3;
            }
            if (obj == null) {
                arrayList.add(googleMapOverlayElement);
            }
        }
        return arrayList;
    }

    private void m457a(List<NearbyPlaceEdgeWrapper> list) {
        this.f375i = m454a(this.f375i, (List) list);
    }

    private void m458b(List<NearbyPlaceEdgeWrapper> list) {
        this.f376j = m454a(this.f376j, (List) list);
    }

    private void m459c(List<NearbyPlaceCluster> list) {
        List arrayList = new ArrayList();
        for (NearbyPlaceCluster nearbyPlaceCluster : list) {
            arrayList.add(nearbyPlaceCluster.f308d);
        }
        m457a(arrayList);
    }

    private void m460d(List<NearbyPlaceCluster> list) {
        for (final NearbyPlaceCluster nearbyPlaceCluster : list) {
            boolean z;
            Drawable a;
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = nearbyPlaceCluster.f308d;
            double b = m473b();
            NearbyMapAreaFragment nearbyMapAreaFragment = this.f377k;
            if (b >= ((double) 13)) {
                z = true;
            } else {
                z = false;
            }
            int c = nearbyPlaceCluster.m397c();
            if (z) {
                a = this.f373g.a(c);
            } else {
                a = MapPinHelper.c(this.f373g.a.getDrawable(2130841153));
            }
            GoogleMapOverlayElement a2 = this.f378l.a(nearbyPlaceEdgeWrapper.m500d(), nearbyPlaceEdgeWrapper.m503g(), a);
            m456a(nearbyPlaceEdgeWrapper, (OnSelectedListener) new OnSelectedListener(this) {
                final /* synthetic */ NearbyMapController f364b;

                public final void m447a() {
                    NearbyMapAreaFragment nearbyMapAreaFragment = this.f364b.f377k;
                    NearbyPlaceCluster nearbyPlaceCluster = nearbyPlaceCluster;
                    NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = nearbyPlaceCluster.f308d;
                    HoneyClientEventFast a;
                    if (nearbyMapAreaFragment.aB.m473b() < 13.0d) {
                        NearbyBrowseAnalytics nearbyBrowseAnalytics = nearbyMapAreaFragment.f449h;
                        String str = nearbyMapAreaFragment.at;
                        a = nearbyBrowseAnalytics.f297a.a("cluster_tapped_to_zoom_in", true);
                        if (a.a()) {
                            a.a("places_recommendations").a("session_id", str);
                            a.b();
                        }
                        nearbyMapAreaFragment.an.a(nearbyMapAreaFragment.aB.m474b(nearbyPlaceEdgeWrapper.m502f()), new FutureCallback<Void>(nearbyMapAreaFragment) {
                            final /* synthetic */ NearbyMapAreaFragment f418a;

                            {
                                this.f418a = r1;
                            }

                            public void onSuccess(Object obj) {
                                this.f418a.aB.m466a();
                            }

                            public void onFailure(Throwable th) {
                            }
                        });
                        return;
                    }
                    NearbyBrowseAnalytics nearbyBrowseAnalytics2 = nearbyMapAreaFragment.f449h;
                    String str2 = nearbyMapAreaFragment.at;
                    List a2 = Lists.a();
                    for (NearbyPlaceEdgeWrapper c : nearbyPlaceCluster.f305a) {
                        a2.add(c.m499c());
                    }
                    List list = a2;
                    String c2 = nearbyPlaceCluster.f308d.m499c();
                    a = nearbyBrowseAnalytics2.f297a.a("cluster_tapped_to_open_places_list", true);
                    if (a.a()) {
                        a.a("places_recommendations").a("session_id", str2).a("pages_ids", Joiner.on(", ").join(list)).a("front_photo_page_id", c2);
                        a.b();
                    }
                    if (nearbyMapAreaFragment.aO != null) {
                        nearbyMapAreaFragment.aO.d();
                    }
                    MapPinViewSizeHelperV1 l = nearbyMapAreaFragment.aB.m480l();
                    Point toPixels = l.f304a.toPixels(Locations.a(nearbyPlaceCluster.f307c), null);
                    nearbyMapAreaFragment.an.a(nearbyMapAreaFragment.aB.m474b(Locations.a(l.f304a.fromPixels(toPixels.x, toPixels.y - 60))), new FutureCallback<Void>(nearbyMapAreaFragment) {
                        final /* synthetic */ NearbyMapAreaFragment f419a;

                        {
                            this.f419a = r1;
                        }

                        public void onSuccess(Object obj) {
                            NearbyMapAreaFragment.aH(this.f419a);
                        }

                        public void onFailure(Throwable th) {
                        }
                    });
                    NearbyMapAreaFragment.aL(nearbyMapAreaFragment);
                    nearbyMapAreaFragment.aP.m594a(nearbyPlaceCluster.f305a);
                    nearbyMapAreaFragment.aw = MapPinSelectState.CLUSTER_SELECTED;
                }

                public final void m448b() {
                    this.f364b.f377k.aw = MapPinSelectState.NONE_SELECTED;
                }
            }, m452a(nearbyPlaceEdgeWrapper.m508m(), z, c, a2), a2);
        }
    }

    private void m461e(List<NearbyPlaceEdgeWrapper> list) {
        for (final NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : list) {
            GoogleMapOverlayElement a = this.f378l.a(nearbyPlaceEdgeWrapper.m500d(), nearbyPlaceEdgeWrapper.m503g(), MapPinHelper.c(this.f373g.a.getDrawable(2130841148)));
            m456a(nearbyPlaceEdgeWrapper, (OnSelectedListener) new OnSelectedListener(this) {
                final /* synthetic */ NearbyMapController f366b;

                public final void m449a() {
                    this.f366b.f377k.m552b(nearbyPlaceEdgeWrapper);
                }

                public final void m450b() {
                    this.f366b.f377k.aw = MapPinSelectState.NONE_SELECTED;
                }
            }, m451a(nearbyPlaceEdgeWrapper.m508m(), a), a);
        }
    }

    private void m462f(List<NearbyPlaceEdgeWrapper> list) {
        for (final NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : list) {
            OnSelectedListener c00481 = new OnSelectedListener(this) {
                final /* synthetic */ NearbyMapController f362b;

                public final void m445a() {
                    this.f362b.f377k.m550a(nearbyPlaceEdgeWrapper);
                }

                public final void m446b() {
                    this.f362b.f377k.aw = MapPinSelectState.NONE_SELECTED;
                }
            };
            GoogleMapOverlayElement a = this.f378l.a(nearbyPlaceEdgeWrapper.m500d(), nearbyPlaceEdgeWrapper.m503g(), MapPinHelper.c(this.f373g.a.getDrawable(2130841147)));
            a.a(c00481);
            this.f376j.add(a);
        }
    }

    private void m456a(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper, OnSelectedListener onSelectedListener, Drawable drawable, GoogleMapOverlayElement googleMapOverlayElement) {
        if (drawable == null) {
            BLog.a(f367a, "Error downloading image");
            return;
        }
        googleMapOverlayElement.a(onSelectedListener);
        this.f375i.add(googleMapOverlayElement);
        if (!TextUtils.isEmpty(nearbyPlaceEdgeWrapper.m508m())) {
            googleMapOverlayElement.b();
            googleMapOverlayElement.b.setMarker(drawable);
            SelectableOverlayItem selectableOverlayItem = googleMapOverlayElement.b;
            if (selectableOverlayItem.c != null) {
                selectableOverlayItem.c.b();
            }
            googleMapOverlayElement.a.c.invalidate();
        }
    }

    private void m455a(MapPinTransition mapPinTransition) {
        m459c(new ArrayList(mapPinTransition.f310b));
        m457a(new ArrayList(mapPinTransition.f312d));
        m458b(new ArrayList(mapPinTransition.f314f));
        m460d(new ArrayList(mapPinTransition.f309a));
        m461e(new ArrayList(mapPinTransition.f311c));
        m462f(new ArrayList(mapPinTransition.f313e));
    }

    private Drawable m452a(String str, boolean z, int i, GoogleMapOverlayElement googleMapOverlayElement) {
        DraweeHolder a = m453a(str);
        googleMapOverlayElement.a(a);
        if (z) {
            return this.f373g.a(a.h(), i);
        }
        return this.f373g.b(a.h());
    }

    private DraweeHolder<GenericDraweeHierarchy> m453a(String str) {
        DraweeHolder<GenericDraweeHierarchy> draweeHolder = new DraweeHolder(this.f370d.u());
        draweeHolder.a(this.f371e.a(f368b).a(str).s());
        return draweeHolder;
    }

    private Drawable m451a(String str, GoogleMapOverlayElement googleMapOverlayElement) {
        DraweeHolder a = m453a(str);
        googleMapOverlayElement.a(a);
        return this.f373g.a(a.h());
    }
}

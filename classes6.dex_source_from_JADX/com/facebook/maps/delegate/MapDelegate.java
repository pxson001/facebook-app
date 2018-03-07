package com.facebook.maps.delegate;

import android.location.Location;
import android.view.View;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.Circle;
import com.facebook.android.maps.model.CircleOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.android.maps.model.Polyline;
import com.facebook.android.maps.model.PolylineOptions;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.11;
import com.facebook.friendsnearby.ui.FriendsNearbyMapFragment.12;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;

/* compiled from: writeTo was not called on time after getMetadata! */
public class MapDelegate {
    public FacebookMap f383a;
    public GoogleMap f384b;
    private UiSettingsDelegate f385c;

    /* compiled from: writeTo was not called on time after getMetadata! */
    public interface OnMapClickListener {
        void mo5a();
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public interface OnMyLocationChangeListener {
        void mo10a(Location location);
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public class AnonymousClass13 {
        public final /* synthetic */ 11 f359a;
        final /* synthetic */ MapDelegate f360b;

        public AnonymousClass13(MapDelegate mapDelegate, 11 11) {
            this.f360b = mapDelegate;
            this.f359a = 11;
        }
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public class AnonymousClass14 implements OnInfoWindowClickListener {
        final /* synthetic */ 11 f361a;
        final /* synthetic */ MapDelegate f362b;

        public AnonymousClass14(MapDelegate mapDelegate, 11 11) {
            this.f362b = mapDelegate;
            this.f361a = 11;
        }

        public final void mo41a(Marker marker) {
            this.f361a.a(MarkerDelegate.m360a(marker));
        }
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public class AnonymousClass17 {
        public final /* synthetic */ 12 f363a;
        final /* synthetic */ MapDelegate f364b;

        public AnonymousClass17(MapDelegate mapDelegate, 12 12) {
            this.f364b = mapDelegate;
            this.f363a = 12;
        }
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public class AnonymousClass18 implements InfoWindowAdapter {
        final /* synthetic */ 12 f365a;
        final /* synthetic */ MapDelegate f366b;

        public AnonymousClass18(MapDelegate mapDelegate, 12 12) {
            this.f366b = mapDelegate;
            this.f365a = 12;
        }

        public final View mo42a(Marker marker) {
            return this.f365a.b(MarkerDelegate.m360a(marker));
        }

        public final View mo43b(Marker marker) {
            return this.f365a.a(MarkerDelegate.m360a(marker));
        }
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public interface CancelableCallback {
        void m322a();

        void m323b();
    }

    /* compiled from: writeTo was not called on time after getMetadata! */
    public interface OnMarkerClickListener {
        boolean m324a(MarkerDelegate markerDelegate);
    }

    public MapDelegate(FacebookMap facebookMap) {
        this.f383a = facebookMap;
    }

    public MapDelegate(GoogleMap googleMap) {
        this.f384b = googleMap;
    }

    public final CircleDelegate m325a(CircleOptions circleOptions) {
        if (this.f383a != null) {
            FacebookMap facebookMap = this.f383a;
            return new CircleDelegate((Circle) facebookMap.a(new Circle(facebookMap, circleOptions)));
        } else if (this.f384b == null) {
            return null;
        } else {
            com.google.android.gms.maps.model.CircleOptions circleOptions2;
            GoogleMap googleMap = this.f384b;
            if (circleOptions == null) {
                circleOptions2 = null;
            } else {
                circleOptions2 = new com.google.android.gms.maps.model.CircleOptions();
                circleOptions2.f6727b = MapUtils.m353a(circleOptions.a);
                circleOptions2 = circleOptions2;
                circleOptions2.f6731f = circleOptions.b;
                circleOptions2 = circleOptions2;
                circleOptions2.f6728c = circleOptions.c;
                circleOptions2 = circleOptions2;
                circleOptions2.f6730e = circleOptions.d;
                circleOptions2 = circleOptions2;
                circleOptions2.f6729d = circleOptions.e;
                circleOptions2 = circleOptions2;
                circleOptions2.f6733h = circleOptions.f;
                circleOptions2 = circleOptions2;
                circleOptions2.f6732g = circleOptions.g;
                circleOptions2 = circleOptions2;
            }
            return new CircleDelegate(googleMap.m9175a(circleOptions2));
        }
    }

    public final MarkerDelegate m326a(MarkerOptions markerOptions) {
        if (this.f383a != null) {
            return MarkerDelegate.m359a(this.f383a.a(markerOptions));
        }
        if (this.f384b == null) {
            return null;
        }
        com.google.android.gms.maps.model.MarkerOptions markerOptions2;
        GoogleMap googleMap = this.f384b;
        if (markerOptions == null) {
            markerOptions2 = null;
        } else {
            markerOptions2 = new com.google.android.gms.maps.model.MarkerOptions();
            markerOptions2.f6770n = markerOptions.d;
            markerOptions2 = markerOptions2;
            float b = markerOptions.b();
            float c = markerOptions.c();
            markerOptions2.f6762f = b;
            markerOptions2.f6763g = c;
            markerOptions2 = markerOptions2;
            markerOptions2.f6764h = markerOptions.e;
            markerOptions2 = markerOptions2;
            markerOptions2.f6766j = markerOptions.f;
            markerOptions2 = markerOptions2;
            markerOptions2.f6761e = MapUtils.m351a(markerOptions.c);
            markerOptions2 = markerOptions2;
            b = markerOptions.e();
            c = markerOptions.f();
            markerOptions2.f6768l = b;
            markerOptions2.f6769m = c;
            markerOptions2 = markerOptions2;
            markerOptions2.f6758b = MapUtils.m353a(markerOptions.b);
            markerOptions2 = markerOptions2;
            markerOptions2.f6767k = markerOptions.g;
            markerOptions2 = markerOptions2;
            markerOptions2.f6760d = markerOptions.h;
            markerOptions2 = markerOptions2;
            markerOptions2.f6759c = markerOptions.i;
            markerOptions2 = markerOptions2;
            markerOptions2.f6765i = markerOptions.k;
            markerOptions2 = markerOptions2;
        }
        return MarkerDelegate.m360a(googleMap.m9176a(markerOptions2));
    }

    public final PolylineDelegate m327a(PolylineOptions polylineOptions) {
        if (this.f383a != null) {
            FacebookMap facebookMap = this.f383a;
            return new PolylineDelegate((Polyline) facebookMap.a(new Polyline(facebookMap, polylineOptions)));
        } else if (this.f384b == null) {
            return null;
        } else {
            com.google.android.gms.maps.model.PolylineOptions polylineOptions2;
            GoogleMap googleMap = this.f384b;
            if (polylineOptions == null) {
                polylineOptions2 = null;
            } else {
                polylineOptions2 = new com.google.android.gms.maps.model.PolylineOptions();
                polylineOptions2.f6790f = polylineOptions.d;
                polylineOptions2 = polylineOptions2;
                polylineOptions2.f6791g = polylineOptions.b;
                polylineOptions2 = polylineOptions2;
                polylineOptions2.f6787c = polylineOptions.e;
                polylineOptions2 = polylineOptions2;
                polylineOptions2.f6789e = polylineOptions.f;
                polylineOptions2 = polylineOptions2;
                polylineOptions2.f6788d = polylineOptions.a;
                com.google.android.gms.maps.model.PolylineOptions polylineOptions3 = polylineOptions2;
                for (LatLng a : polylineOptions.c) {
                    polylineOptions3.f6786b.add(MapUtils.m353a(a));
                }
                polylineOptions2 = polylineOptions3;
            }
            return new PolylineDelegate(googleMap.m9177a(polylineOptions2));
        }
    }

    public final void m328a() {
        if (this.f383a != null) {
            this.f383a.b();
        } else if (this.f384b != null) {
            this.f384b.m9189c();
        }
    }

    public final ProjectionDelegate m337b() {
        if (this.f383a != null) {
            return new ProjectionDelegate(this.f383a.k);
        }
        if (this.f384b != null) {
            return new ProjectionDelegate(this.f384b.m9192f());
        }
        return null;
    }

    public final UiSettingsDelegate m338c() {
        if (this.f383a != null && this.f385c == null) {
            this.f385c = new UiSettingsDelegate(this.f383a.E);
        } else if (this.f384b != null && this.f385c == null) {
            this.f385c = new UiSettingsDelegate(this.f384b.m9191e());
        }
        return this.f385c;
    }

    public final Location m339d() {
        if (this.f383a != null) {
            return this.f383a.e();
        }
        if (this.f384b != null) {
            return this.f384b.m9190d();
        }
        return null;
    }

    public final CameraPosition m340e() {
        if (this.f383a != null) {
            return this.f383a.c();
        }
        if (this.f384b != null) {
            return MapUtils.m348a(this.f384b.m9188b());
        }
        return null;
    }

    public final void m329a(int i, int i2, int i3, int i4) {
        if (this.f383a != null) {
            this.f383a.a(i, i2, i3, i4);
        } else if (this.f384b != null) {
            this.f384b.m9178a(i, i2, i3, i4);
        }
    }

    public final void m336a(boolean z) {
        if (this.f383a != null) {
            this.f383a.a(z);
        } else if (this.f384b != null) {
            this.f384b.m9187a(z);
        }
    }

    public final void m335a(final OnMyLocationChangeListener onMyLocationChangeListener) {
        if (this.f383a != null) {
            FacebookMap facebookMap = this.f383a;
            facebookMap.O = new com.facebook.android.maps.FacebookMap.OnMyLocationChangeListener(this) {
                final /* synthetic */ MapDelegate f370b;

                public final void m310a(Location location) {
                    onMyLocationChangeListener.mo10a(location);
                }
            };
            if (facebookMap.O != null && facebookMap.j.d != null && facebookMap.j.e) {
                facebookMap.O.a(facebookMap.j.d);
            }
        } else if (this.f384b != null) {
            this.f384b.m9186a(new com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener(this) {
                final /* synthetic */ MapDelegate f374b;

                public final void mo46a(Location location) {
                    onMyLocationChangeListener.mo10a(location);
                }
            });
        }
    }

    public final void m333a(final OnMapClickListener onMapClickListener) {
        if (this.f383a != null) {
            this.f383a.p = new Object(this) {
                final /* synthetic */ MapDelegate f376b;
            };
        } else if (this.f384b != null) {
            this.f384b.m9184a(new com.google.android.gms.maps.GoogleMap.OnMapClickListener(this) {
                final /* synthetic */ MapDelegate f378b;

                public final void mo47a(com.google.android.gms.maps.model.LatLng latLng) {
                    OnMapClickListener onMapClickListener = onMapClickListener;
                    MapUtils.m349a(latLng);
                    onMapClickListener.mo5a();
                }
            });
        }
    }

    public final void m330a(final OnCameraChangeListener onCameraChangeListener) {
        if (this.f383a != null) {
            this.f383a.g = onCameraChangeListener;
        } else if (this.f384b != null) {
            this.f384b.m9182a(new GoogleMap.OnCameraChangeListener(this) {
                final /* synthetic */ MapDelegate f380b;

                public final void mo48a(com.google.android.gms.maps.model.CameraPosition cameraPosition) {
                    onCameraChangeListener.a(MapUtils.m348a(cameraPosition));
                }
            });
        }
    }

    public final void m334a(final OnMarkerClickListener onMarkerClickListener) {
        if (this.f383a != null) {
            this.f383a.m = new com.facebook.android.maps.FacebookMap.OnMarkerClickListener(this) {
                final /* synthetic */ MapDelegate f382b;

                public final boolean m321a(com.facebook.android.maps.model.Marker marker) {
                    return onMarkerClickListener.m324a(MarkerDelegate.m359a(marker));
                }
            };
        } else if (this.f384b != null) {
            this.f384b.m9185a(new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener(this) {
                final /* synthetic */ MapDelegate f358b;

                public final boolean mo40a(Marker marker) {
                    return onMarkerClickListener.m324a(MarkerDelegate.m360a(marker));
                }
            });
        }
    }

    public final void m331a(CameraUpdateDelegate cameraUpdateDelegate) {
        if (this.f383a != null) {
            this.f383a.b(cameraUpdateDelegate.m294a());
        } else if (this.f384b != null) {
            this.f384b.m9179a(cameraUpdateDelegate.m295b());
        }
    }

    public final void m332a(CameraUpdateDelegate cameraUpdateDelegate, int i, final CancelableCallback cancelableCallback) {
        com.google.android.gms.maps.GoogleMap.CancelableCallback cancelableCallback2 = null;
        if (this.f383a != null) {
            AnonymousClass19 anonymousClass19;
            if (cancelableCallback != null) {
                anonymousClass19 = new Object(this) {
                    final /* synthetic */ MapDelegate f368b;

                    public final void m309b() {
                        cancelableCallback.m323b();
                    }
                };
            }
            this.f383a.a(cameraUpdateDelegate.m294a(), i, anonymousClass19);
        } else if (this.f384b != null) {
            if (cancelableCallback != null) {
                cancelableCallback2 = new com.google.android.gms.maps.GoogleMap.CancelableCallback(this) {
                    final /* synthetic */ MapDelegate f372b;

                    public final void mo44a() {
                        cancelableCallback.m323b();
                    }

                    public final void mo45b() {
                        cancelableCallback.m322a();
                    }
                };
            }
            this.f384b.m9180a(cameraUpdateDelegate.m295b(), i, cancelableCallback2);
        }
    }
}

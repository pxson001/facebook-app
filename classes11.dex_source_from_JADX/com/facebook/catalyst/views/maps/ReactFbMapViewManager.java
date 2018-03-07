package com.facebook.catalyst.views.maps;

import android.os.Bundle;
import android.view.View;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.UiSettings;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.catalyst.views.maps.ReactFbMapView.C07291;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: last_saved_session */
public class ReactFbMapViewManager extends SimpleViewManager<MapView> {
    private static final Bundle f5865a = new Bundle();
    public static boolean f5866b;
    public static boolean f5867c;
    public static boolean f5868d;
    public static boolean f5869e;
    public static boolean f5870f;

    public final void m7273a(View view) {
        MapView mapView = (MapView) view;
        ((ReactContext) mapView.getContext()).b((ReactFbMapView) mapView);
    }

    public static void m7265b(UiSettings uiSettings) {
        f5867c = uiSettings.e;
        f5868d = uiSettings.b;
        f5869e = uiSettings.c;
        f5870f = uiSettings.d;
    }

    public final String m7272a() {
        return "RCTFbMap";
    }

    protected final View m7271a(ThemedReactContext themedReactContext) {
        final Object reactFbMapView = new ReactFbMapView(themedReactContext);
        reactFbMapView.a(f5865a);
        reactFbMapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5854b;

            public final void m7256a(final FacebookMap facebookMap) {
                reactFbMapView.m7252a(facebookMap, facebookMap.c());
                facebookMap.g = new OnCameraChangeListener(this) {
                    final /* synthetic */ C07321 f5852b;

                    public final void m7255a(CameraPosition cameraPosition) {
                        reactFbMapView.m7252a(facebookMap, cameraPosition);
                    }
                };
                if (!ReactFbMapViewManager.f5866b) {
                    ReactFbMapViewManager.f5866b = true;
                    ReactFbMapViewManager.m7265b(facebookMap.E);
                }
            }
        });
        themedReactContext.a(reactFbMapView);
        return reactFbMapView;
    }

    @ReactProp(name = "showsUserLocation")
    public void setShowsUserLocation(MapView mapView, final boolean z) {
        mapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5856b;

            public final void m7257a(FacebookMap facebookMap) {
                facebookMap.a(z);
            }
        });
    }

    @ReactProp(name = "zoomEnabled")
    public void setZoomEnabled(MapView mapView, @Nullable final Boolean bool) {
        mapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5858b;

            public final void m7258a(FacebookMap facebookMap) {
                boolean z;
                UiSettings uiSettings = facebookMap.E;
                if (bool == null) {
                    z = ReactFbMapViewManager.f5867c;
                } else {
                    z = bool.booleanValue();
                }
                uiSettings.e = z;
            }
        });
    }

    @ReactProp(name = "rotateEnabled")
    public void setRotateEnabled(MapView mapView, @Nullable final Boolean bool) {
        mapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5860b;

            public final void m7259a(FacebookMap facebookMap) {
                boolean z;
                UiSettings uiSettings = facebookMap.E;
                if (bool == null) {
                    z = ReactFbMapViewManager.f5868d;
                } else {
                    z = bool.booleanValue();
                }
                uiSettings.b = z;
            }
        });
    }

    @ReactProp(name = "scrollEnabled")
    public void setScrollEnabled(MapView mapView, @Nullable final Boolean bool) {
        mapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5862b;

            public final void m7260a(FacebookMap facebookMap) {
                boolean z;
                UiSettings uiSettings = facebookMap.E;
                if (bool == null) {
                    z = ReactFbMapViewManager.f5869e;
                } else {
                    z = bool.booleanValue();
                }
                uiSettings.c = z;
            }
        });
    }

    @ReactProp(name = "pitchEnabled")
    public void setPitchEnabled(MapView mapView, @Nullable final Boolean bool) {
        mapView.a(new OnMapReadyCallback(this) {
            final /* synthetic */ ReactFbMapViewManager f5864b;

            public final void m7261a(FacebookMap facebookMap) {
                boolean z;
                UiSettings uiSettings = facebookMap.E;
                if (bool == null) {
                    z = ReactFbMapViewManager.f5870f;
                } else {
                    z = bool.booleanValue();
                }
                uiSettings.d = z;
            }
        });
    }

    @ReactProp(name = "region")
    public void setRegion(MapView mapView, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            ReactFbMapView reactFbMapView = (ReactFbMapView) mapView;
            reactFbMapView.a(new C07291(reactFbMapView, m7262a(readableMap)));
        }
    }

    @ReactProp(d = true, name = "active")
    public void setActive(MapView mapView, boolean z) {
        if (!z) {
        }
    }

    private static LatLngBounds m7262a(ReadableMap readableMap) {
        if (readableMap.hasKey("latitude") && readableMap.hasKey("latitudeDelta") && readableMap.hasKey("longitude") && readableMap.hasKey("longitudeDelta")) {
            double d = readableMap.getDouble("latitude");
            double d2 = readableMap.getDouble("longitude");
            double d3 = readableMap.getDouble("latitudeDelta");
            double d4 = readableMap.getDouble("longitudeDelta");
            return LatLngBounds.a().a(new LatLng(d - (0.5d * d3), d2 - (0.5d * d4))).a(new LatLng(d + (d3 * 0.5d), d2 + (0.5d * d4))).a();
        }
        throw new JSApplicationIllegalArgumentException("Region description is invalid");
    }
}

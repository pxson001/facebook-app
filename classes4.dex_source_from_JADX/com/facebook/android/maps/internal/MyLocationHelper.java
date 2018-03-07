package com.facebook.android.maps.internal;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.android.maps.FacebookMap.OnMyLocationChangeListener;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.maps.MapsRuntimePermissionManager;
import com.facebook.maps.MapsRuntimePermissionManager.1;
import java.util.List;

/* compiled from: dump_([^_]*_[0-9]*)\.hprof.* */
public class MyLocationHelper implements LocationListener {
    private static final String[] f13501a = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private final Context f13502b;
    private final LocationManager f13503c = ((LocationManager) this.f13502b.getSystemService("location"));
    public Location f13504d;
    public boolean f13505e;
    public OnMyLocationChangeListener f13506f;
    public MyLocationHelper f13507g;

    public MyLocationHelper(Context context) {
        this.f13502b = context;
    }

    public final void m14380a(boolean z) {
        if (this.f13507g == null) {
            this.f13507g = this;
        }
        this.f13505e = z;
        if (!z || VERSION.SDK_INT < 23 || (this.f13502b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && this.f13502b.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) {
            if (this.f13505e) {
                this.f13507g.m14379a();
            } else {
                this.f13507g.m14381b();
            }
        } else if (!(this.f13502b instanceof Activity)) {
            AnalyticsEvent.f13535v.m14392a("Context is not an instance of activity");
        } else if (MapConfig.f13477d == null) {
            AnalyticsEvent.f13535v.m14392a("Runtime permission manager not provided");
        } else {
            MapsRuntimePermissionManager mapsRuntimePermissionManager = MapConfig.f13477d;
            Activity activity = (Activity) this.f13502b;
            mapsRuntimePermissionManager.f13473b.m13233a(activity).a(f13501a, new 1(mapsRuntimePermissionManager, new 1(this)));
        }
    }

    public void onLocationChanged(Location location) {
        if (m14378a(location, this.f13504d)) {
            this.f13504d = location;
            if (this.f13506f != null) {
                this.f13506f.a(this.f13504d);
            }
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }

    public final void m14379a() {
        Location location;
        List<String> providers = this.f13503c.getProviders(true);
        Location location2 = this.f13504d;
        if (providers != null) {
            location = location2;
            for (String lastKnownLocation : providers) {
                location2 = this.f13503c.getLastKnownLocation(lastKnownLocation);
                if (!m14378a(location2, location)) {
                    location2 = location;
                }
                location = location2;
            }
        } else {
            location = location2;
        }
        if (location == null || System.currentTimeMillis() - location.getTime() >= 7200000) {
            this.f13504d = null;
        } else {
            this.f13504d = location;
            if (this.f13506f != null) {
                this.f13506f.a(this.f13504d);
            }
        }
        Criteria criteria = new Criteria();
        try {
            criteria.setAccuracy(1);
            this.f13503c.requestLocationUpdates(this.f13503c.getBestProvider(criteria, true), 50, 0.0f, this);
        } catch (Exception e) {
        }
        try {
            criteria.setAccuracy(2);
            this.f13503c.requestLocationUpdates(this.f13503c.getBestProvider(criteria, true), 50, 0.0f, this);
        } catch (Exception e2) {
        }
    }

    public final void m14381b() {
        this.f13503c.removeUpdates(this);
    }

    static boolean m14378a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        if (time > 120000) {
            return true;
        }
        if (time < -120000) {
            return false;
        }
        boolean z;
        boolean z2 = time > 0;
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        if (accuracy <= 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z3;
        if (accuracy > 200) {
            z3 = true;
        } else {
            z3 = false;
        }
        String provider = location.getProvider();
        String provider2 = location2.getProvider();
        boolean equals = provider == null ? provider2 == null : provider.equals(provider2);
        if (z || (z2 && !r3 && r4)) {
            return true;
        }
        return false;
    }
}

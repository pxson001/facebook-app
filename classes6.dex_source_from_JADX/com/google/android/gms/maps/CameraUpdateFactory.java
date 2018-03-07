package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate f6619a;

    private CameraUpdateFactory() {
    }

    public static CameraUpdate m9143a() {
        try {
            return new CameraUpdate(m9155c().mo539a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9144a(float f) {
        try {
            return new CameraUpdate(m9155c().mo540a(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9145a(float f, float f2) {
        try {
            return new CameraUpdate(m9155c().mo541a(f, f2));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9146a(float f, Point point) {
        try {
            return new CameraUpdate(m9155c().mo542a(f, point.x, point.y));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9147a(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(m9155c().mo543a(cameraPosition));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9148a(LatLng latLng) {
        try {
            return new CameraUpdate(m9155c().mo544a(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9149a(LatLng latLng, float f) {
        try {
            return new CameraUpdate(m9155c().mo545a(latLng, f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9150a(LatLngBounds latLngBounds, int i) {
        try {
            return new CameraUpdate(m9155c().mo546a(latLngBounds, i));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9151a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        try {
            return new CameraUpdate(m9155c().mo547a(latLngBounds, i, i2, i3));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void m9152a(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        f6619a = (ICameraUpdateFactoryDelegate) zzx.a(iCameraUpdateFactoryDelegate);
    }

    public static CameraUpdate m9153b() {
        try {
            return new CameraUpdate(m9155c().mo548b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate m9154b(float f) {
        try {
            return new CameraUpdate(m9155c().mo549b(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static ICameraUpdateFactoryDelegate m9155c() {
        return (ICameraUpdateFactoryDelegate) zzx.a(f6619a, "CameraUpdateFactory is not initialized");
    }
}

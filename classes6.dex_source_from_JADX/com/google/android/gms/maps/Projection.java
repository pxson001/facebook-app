package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate f6662a;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.f6662a = iProjectionDelegate;
    }

    public final LatLng m9217a(Point point) {
        try {
            return this.f6662a.mo633a(zze.a(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final VisibleRegion m9218a() {
        try {
            return this.f6662a.mo634a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}

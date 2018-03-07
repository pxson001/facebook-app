package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public final class Polyline {
    private final IPolylineDelegate f6784a;

    public Polyline(IPolylineDelegate iPolylineDelegate) {
        this.f6784a = (IPolylineDelegate) zzx.a(iPolylineDelegate);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f6784a.mo726a(((Polyline) obj).f6784a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f6784a.mo736i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}

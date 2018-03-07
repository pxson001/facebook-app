package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate f6683a;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f6683a = iUiSettingsDelegate;
    }

    public final void m9244a(boolean z) {
        try {
            this.f6683a.mo676a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean m9245a() {
        try {
            return this.f6683a.mo683d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9246b(boolean z) {
        try {
            this.f6683a.mo678b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean m9247b() {
        try {
            return this.f6683a.mo685e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9248c(boolean z) {
        try {
            this.f6683a.mo680c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean m9249c() {
        try {
            return this.f6683a.mo687f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9250d(boolean z) {
        try {
            this.f6683a.mo682d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean m9251d() {
        try {
            return this.f6683a.mo689g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9252e(boolean z) {
        try {
            this.f6683a.mo684e(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9253f(boolean z) {
        try {
            this.f6683a.mo686f(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9254g(boolean z) {
        try {
            this.f6683a.mo688g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}

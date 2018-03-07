package com.facebook.maps.delegate;

import com.facebook.android.maps.UiSettings;

/* compiled from: vnd.android.cursor.item/note */
public class UiSettingsDelegate {
    public final UiSettings f406a;
    public final com.google.android.gms.maps.UiSettings f407b;

    public UiSettingsDelegate(UiSettings uiSettings) {
        this.f406a = uiSettings;
        this.f407b = null;
    }

    public UiSettingsDelegate(com.google.android.gms.maps.UiSettings uiSettings) {
        this.f406a = null;
        this.f407b = uiSettings;
    }

    public final void m370b(boolean z) {
        if (this.f406a != null) {
            this.f406a.a(z);
        } else {
            this.f407b.m9246b(z);
        }
    }

    public final void m371c(boolean z) {
        if (this.f406a != null) {
            UiSettings uiSettings = this.f406a;
            uiSettings.a = z;
            uiSettings.e();
            return;
        }
        this.f407b.m9248c(z);
    }

    public final void m369a(boolean z) {
        if (this.f406a != null) {
            this.f406a.b = z;
        } else {
            this.f407b.m9254g(z);
        }
        if (this.f406a != null) {
            this.f406a.c = z;
        } else {
            this.f407b.m9250d(z);
        }
        if (this.f406a != null) {
            this.f406a.d = z;
        } else {
            this.f407b.m9253f(z);
        }
        if (this.f406a != null) {
            this.f406a.e = z;
        } else {
            this.f407b.m9252e(z);
        }
    }
}

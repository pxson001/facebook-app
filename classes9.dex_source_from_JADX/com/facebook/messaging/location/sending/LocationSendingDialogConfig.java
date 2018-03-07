package com.facebook.messaging.location.sending;

import com.facebook.android.maps.model.LatLng;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;

/* compiled from: mP2pCreditCard */
public class LocationSendingDialogConfig {
    final ButtonStyle f11388a;
    final FullScreenDialogParams f11389b;
    final LatLng f11390c;
    final NearbyPlace f11391d;
    final boolean f11392e;

    /* compiled from: mP2pCreditCard */
    public class Builder {
        public ButtonStyle f11383a;
        public final FullScreenDialogParams f11384b;
        public LatLng f11385c;
        public NearbyPlace f11386d;
        public boolean f11387e = true;

        public Builder(FullScreenDialogParams fullScreenDialogParams) {
            this.f11384b = fullScreenDialogParams;
        }

        public final Builder m11974b() {
            this.f11383a = ButtonStyle.SELECT;
            return this;
        }

        public final LocationSendingDialogConfig m11975d() {
            if (this.f11385c == null || this.f11386d == null) {
                return new LocationSendingDialogConfig(this);
            }
            throw new IllegalStateException("Cant set both initialLocation and initialNearbyPlace");
        }
    }

    /* compiled from: mP2pCreditCard */
    public enum ButtonStyle {
        SEND,
        SELECT
    }

    public LocationSendingDialogConfig(Builder builder) {
        this.f11388a = builder.f11383a;
        this.f11389b = builder.f11384b;
        this.f11390c = builder.f11385c;
        this.f11391d = builder.f11386d;
        this.f11392e = builder.f11387e;
    }

    public static Builder m11976a(FullScreenDialogParams fullScreenDialogParams) {
        return new Builder(fullScreenDialogParams);
    }
}

package com.facebook.messaging.montage.composer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.Builder;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment.Listener;
import com.facebook.messaging.location.sending.NearbyPlace;

/* compiled from: is_optional_destination_enabled */
public class MontageLocationCanvasFragment extends AbstractMontageCanvasFragment implements CanHandleBackPressed, MontageComposerCanvas {
    public MontageComposerController f12527a;
    private LocationSendingDialogFragment f12528b;

    /* compiled from: is_optional_destination_enabled */
    class C13921 implements Listener {
        final /* synthetic */ MontageLocationCanvasFragment f12526a;

        C13921(MontageLocationCanvasFragment montageLocationCanvasFragment) {
            this.f12526a = montageLocationCanvasFragment;
        }

        public final void mo428a(LatLng latLng) {
            if (this.f12526a.f12527a != null) {
                this.f12526a.f12527a.f12477l.m12969e();
            }
        }

        public final void mo430b(LatLng latLng) {
            if (this.f12526a.f12527a != null) {
                this.f12526a.f12527a.f12477l.m12969e();
            }
        }

        public final void mo429a(NearbyPlace nearbyPlace) {
            if (this.f12526a.f12527a != null) {
                this.f12526a.f12527a.f12477l.m12969e();
            }
        }
    }

    public final View m12996a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 538508384);
        View inflate = layoutInflater.inflate(2130905324, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2065758720, a);
        return inflate;
    }

    public final void mo476a(View view, @Nullable Bundle bundle) {
        super.mo476a(view, bundle);
        Builder b = LocationSendingDialogConfig.m11976a(FullScreenDialogParams.a(this)).m11974b();
        b.f11387e = false;
        this.f12528b = LocationSendingDialogFragment.m11987a(b.m11975d());
        this.f12528b.ar = new C13921(this);
        s().a().b(2131558429, this.f12528b).b();
    }

    public final boolean lV_() {
        return false;
    }

    public final boolean O_() {
        return this.f12528b != null && this.f12528b.O_();
    }

    public final void m12995I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1302590028);
        this.f12527a = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1034589140, a);
    }

    protected final void mo475a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }
}

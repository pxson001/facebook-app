package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.location.Address;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.geocoder.FbGeocoder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.enums.RideLocationType;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.business.ride.view.RideRequestFragment.C10987;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: moments_invite_failed_to_load_image */
public class RideLocationHelper {
    public static final String f9168a = RideLocationHelper.class.getSimpleName();
    private final Context f9169b;
    public final AbstractFbErrorReporter f9170c;
    private final FbGeocoder f9171d;
    private final ExecutorService f9172e;
    public ListenableFuture<ImmutableList<Address>> f9173f;
    @GuardedBy("ui-thread")
    public C10987 f9174g;

    /* compiled from: moments_invite_failed_to_load_image */
    class C10511 implements FutureCallback<List<Address>> {
        final /* synthetic */ RideLocationHelper f9167a;

        C10511(RideLocationHelper rideLocationHelper) {
            this.f9167a = rideLocationHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            List list = (List) obj;
            if (list == null || list.isEmpty()) {
                this.f9167a.f9170c.a(RideLocationHelper.f9168a, "Geocoder return wrong result");
                return;
            }
            C10987 c10987 = this.f9167a.f9174g;
            String a = this.f9167a.m9704a((Address) list.get(0));
            if (!Strings.isNullOrEmpty(a) && c10987.f9400a.mx_()) {
                RideRequestFragment.m9847a(c10987.f9400a, a, RideLocationType.ORIGIN);
            }
        }

        public void onFailure(Throwable th) {
            if (!this.f9167a.f9173f.isCancelled()) {
                this.f9167a.f9170c.a(RideLocationHelper.f9168a, "Can't get address line from location", th);
            }
        }
    }

    public static RideLocationHelper m9703b(InjectorLike injectorLike) {
        return new RideLocationHelper((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbGeocoder.m7032a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RideLocationHelper(Context context, AbstractFbErrorReporter abstractFbErrorReporter, FbGeocoder fbGeocoder, ExecutorService executorService) {
        this.f9169b = context;
        this.f9170c = abstractFbErrorReporter;
        this.f9171d = fbGeocoder;
        this.f9172e = executorService;
    }

    public final void m9706a(double d, double d2) {
        m9705a();
        this.f9173f = this.f9171d.m7034a(d, d2, 1);
        Futures.a(this.f9173f, new C10511(this), this.f9172e);
    }

    public final void m9705a() {
        if (this.f9173f != null && !this.f9173f.isDone() && !this.f9173f.isCancelled()) {
            this.f9173f.cancel(true);
        }
    }

    @Nullable
    public final String m9704a(Address address) {
        int i;
        int i2 = (address.getMaxAddressLineIndex() < 0 || Strings.isNullOrEmpty(address.getAddressLine(0))) ? 0 : 1;
        if (Strings.isNullOrEmpty(address.getLocality())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i2 != 0 && i != 0) {
            return this.f9169b.getString(2131240754, new Object[]{address.getAddressLine(0), address.getLocality()});
        } else if (i2 != 0) {
            return address.getAddressLine(0);
        } else {
            if (i != 0) {
                return address.getLocality();
            }
            return null;
        }
    }
}

package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.location.Address;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.geocoder.FbGeocoder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.view.RideRequestFragment.C10932;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: money_penny_item_params */
public final class RideAddressTriggerHelper {
    public static final String f9142a = RideAddressTriggerHelper.class.getSimpleName();
    private final Provider<Boolean> f9143b;
    public final Lazy<LinkHandlingHelper> f9144c;
    public final RideOauthHelper f9145d;
    public final FbGeocoder f9146e;
    public final ExecutorService f9147f;
    public final AbstractFbErrorReporter f9148g;
    public final GatekeeperStoreImpl f9149h;
    private final XConfigReader f9150i;
    @Nullable
    public ListenableFuture<ImmutableList<Address>> f9151j;

    /* compiled from: money_penny_item_params */
    public class C10481 implements FutureCallback<ImmutableList<Address>> {
        final /* synthetic */ String f9133a;
        final /* synthetic */ C10932 f9134b;
        final /* synthetic */ RideAddressTriggerHelper f9135c;

        public C10481(RideAddressTriggerHelper rideAddressTriggerHelper, String str, C10932 c10932) {
            this.f9135c = rideAddressTriggerHelper;
            this.f9133a = str;
            this.f9134b = c10932;
        }

        public void onSuccess(@Nullable Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            Address address = null;
            if (immutableList == null || immutableList.isEmpty()) {
                this.f9135c.f9148g.a(RideAddressTriggerHelper.f9142a, "Geocoder returned no results for address: " + this.f9133a);
            } else {
                address = (Address) immutableList.get(0);
            }
            this.f9134b.m9831a(address);
        }

        public void onFailure(Throwable th) {
            this.f9134b.m9831a(null);
            if (!this.f9135c.f9151j.isCancelled()) {
                this.f9135c.f9148g.a(RideAddressTriggerHelper.f9142a, "Can't geocode address line: " + this.f9133a, th);
            }
        }
    }

    /* compiled from: money_penny_item_params */
    final class RideTriggerClickableSpan extends ClickableSpan {
        final /* synthetic */ RideAddressTriggerHelper f9137a;
        public final Context f9138b;
        public final ThreadKey f9139c;
        public final Uri f9140d;
        public final String f9141e;

        /* compiled from: money_penny_item_params */
        class C10491 implements OnMenuItemClickListener {
            final /* synthetic */ RideTriggerClickableSpan f9136a;

            C10491(RideTriggerClickableSpan rideTriggerClickableSpan) {
                this.f9136a = rideTriggerClickableSpan;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == 2131568684) {
                    ((LinkHandlingHelper) this.f9136a.f9137a.f9144c.get()).a(this.f9136a.f9138b, this.f9136a.f9140d);
                } else if (menuItem.getItemId() == 2131568682) {
                    r0 = this.f9136a.f9137a.f9145d;
                    r1 = RideServiceParams.newBuilder();
                    r1.f9299a = "address_trigger";
                    r1 = r1;
                    r1.f9301c = this.f9136a.f9141e;
                    r1 = r1;
                    r1.f9300b = this.f9136a.f9139c;
                    r1 = r1;
                    r1.f9302d = "uber";
                    r0.m9735a(r1.m9767j());
                } else if (menuItem.getItemId() == 2131568683) {
                    r0 = this.f9136a.f9137a.f9145d;
                    r1 = RideServiceParams.newBuilder();
                    r1.f9299a = "address_trigger";
                    r1 = r1;
                    r1.f9301c = this.f9136a.f9141e;
                    r1 = r1;
                    r1.f9300b = this.f9136a.f9139c;
                    r1 = r1;
                    r1.f9302d = "lyft";
                    r0.m9735a(r1.m9767j());
                }
                return true;
            }
        }

        public RideTriggerClickableSpan(RideAddressTriggerHelper rideAddressTriggerHelper, Context context, ThreadKey threadKey, Uri uri, String str) {
            this.f9137a = rideAddressTriggerHelper;
            this.f9138b = context;
            this.f9139c = threadKey;
            this.f9140d = uri;
            this.f9141e = str;
        }

        public final void onClick(View view) {
            PopupMenu popupMenu = new PopupMenu(this.f9138b, view);
            popupMenu.getMenuInflater().inflate(2131820585, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new C10491(this));
            if (!this.f9137a.f9149h.a(306, false)) {
                popupMenu.getMenu().findItem(2131568682).setVisible(false);
            }
            if (!this.f9137a.f9149h.a(305, false)) {
                popupMenu.getMenu().findItem(2131568683).setVisible(false);
            }
            popupMenu.show();
        }
    }

    public static RideAddressTriggerHelper m9694b(InjectorLike injectorLike) {
        return new RideAddressTriggerHelper(IdBasedProvider.a(injectorLike, 4121), IdBasedSingletonScopeProvider.b(injectorLike, 7898), RideOauthHelper.m9729b(injectorLike), FbGeocoder.m7032a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike));
    }

    public static RideAddressTriggerHelper m9693a(InjectorLike injectorLike) {
        return m9694b(injectorLike);
    }

    @Inject
    public RideAddressTriggerHelper(Provider<Boolean> provider, Lazy<LinkHandlingHelper> lazy, RideOauthHelper rideOauthHelper, FbGeocoder fbGeocoder, ExecutorService executorService, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore, XConfigReader xConfigReader) {
        this.f9143b = provider;
        this.f9144c = lazy;
        this.f9145d = rideOauthHelper;
        this.f9146e = fbGeocoder;
        this.f9147f = executorService;
        this.f9148g = fbErrorReporter;
        this.f9149h = gatekeeperStore;
        this.f9150i = xConfigReader;
    }

    public final void m9695a() {
        if (this.f9151j != null && !this.f9151j.isDone() && !this.f9151j.isCancelled()) {
            this.f9151j.cancel(true);
        }
    }

    public final boolean m9696a(Context context, ThreadKey threadKey, Spannable spannable) {
        if (!((Boolean) this.f9143b.get()).booleanValue() || !(spannable instanceof SpannableString)) {
            return false;
        }
        SpannableString spannableString = (SpannableString) spannable;
        boolean z = false;
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannable.length(), URLSpan.class)) {
            Uri parse = !Strings.isNullOrEmpty(uRLSpan.getURL()) ? Uri.parse(uRLSpan.getURL()) : null;
            if (!(parse == null || parse.getScheme() == null || !parse.getScheme().equals("geo"))) {
                int spanStart = spannableString.getSpanStart(uRLSpan);
                int spanEnd = spannableString.getSpanEnd(uRLSpan);
                if (spanStart >= 0 && spanStart < spannableString.length() && spanEnd >= 0 && spanEnd <= spannableString.length() && spanStart < spanEnd) {
                    spannable.setSpan(new RideTriggerClickableSpan(this, context, threadKey, parse, spannableString.subSequence(spanStart, spanEnd).toString()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
                    spannable.removeSpan(uRLSpan);
                    z = true;
                }
            }
        }
        return z;
    }
}

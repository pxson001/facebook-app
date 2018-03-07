package com.facebook.offers.logging;

import android.util.Base64;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.model.OfferOrCoupon;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: current_image_uri */
public class OffersEventUtil {
    private final Clock f16520a;
    public final Provider<String> f16521b;

    public static OffersEventUtil m19445b(InjectorLike injectorLike) {
        return new OffersEventUtil((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public OffersEventUtil(Clock clock, Provider<String> provider) {
        this.f16520a = clock;
        this.f16521b = provider;
    }

    public final HoneyClientEvent m19447a(String str, OfferOrCoupon offerOrCoupon, @Nullable String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "offers";
        if (offerOrCoupon.m19467r()) {
            honeyClientEvent.b("offer_claim_fbid", offerOrCoupon.m19462k());
            honeyClientEvent.b("share_fbid", m19444a(offerOrCoupon.f16522a));
            honeyClientEvent.b("offer_fbid", offerOrCoupon.f16522a.mo1009x().jQ_());
            honeyClientEvent.a("seconds_since_claim", (this.f16520a.a() - (offerOrCoupon.f16522a.mo1005t() * 1000)) / 1000);
            if (offerOrCoupon.m19468s()) {
                honeyClientEvent.b("offer_view_fbid", offerOrCoupon.m19470u().m19289b());
            }
        } else {
            honeyClientEvent.b("coupon_fbid", offerOrCoupon.m19462k());
        }
        honeyClientEvent.b("user_fbid", (String) this.f16521b.get());
        honeyClientEvent.b("page_fbid", offerOrCoupon.m19456e().m19244c());
        if (str2 != null) {
            honeyClientEvent.b("offer_location", str2);
        }
        honeyClientEvent.a("seconds_until_expires", ((offerOrCoupon.m19459h() * 1000) - this.f16520a.a()) / 1000);
        return honeyClientEvent;
    }

    @Nullable
    public static String m19444a(OfferClaimData offerClaimData) {
        String str = null;
        if (offerClaimData.mo1002B() != null) {
            try {
                String[] split = new String(Base64.decode(offerClaimData.mo1002B().m19280c(), 0)).split(":");
                str = split[split.length - 1];
            } catch (Throwable e) {
                BLog.a("OffersEventUtil", "Could not get share_id out of the offer claim", e);
            }
        }
        return str;
    }

    public final HoneyAnalyticsEvent m19446a(OfferOrCoupon offerOrCoupon, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("offer_notif_response");
        honeyClientEvent.c = "offer_notifications";
        honeyClientEvent.b("user_fbid", (String) this.f16521b.get());
        honeyClientEvent.b("page_fbid", offerOrCoupon.m19456e().m19244c());
        honeyClientEvent.b("offer_claim_fbid", offerOrCoupon.m19462k());
        honeyClientEvent.b("share_fbid", m19444a(offerOrCoupon.f16522a));
        honeyClientEvent.b("offer_fbid", offerOrCoupon.f16522a.mo1009x().jQ_());
        honeyClientEvent.b("notif_trigger", str);
        honeyClientEvent.b("notif_medium", str2);
        honeyClientEvent.b("notif_rule", str3);
        if (offerOrCoupon.m19468s()) {
            honeyClientEvent.b("offer_view_fbid", offerOrCoupon.m19470u().m19289b());
        }
        return honeyClientEvent;
    }
}

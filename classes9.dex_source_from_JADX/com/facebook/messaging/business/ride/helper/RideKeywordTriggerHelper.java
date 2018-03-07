package com.facebook.messaging.business.ride.helper;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.config.BusinessRideXConfig;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: moments_invite_impression */
public final class RideKeywordTriggerHelper {
    private static ImmutableMap<String, Pattern> f9163a;
    private final Provider<Boolean> f9164b;
    public final RideOauthHelper f9165c;
    private final XConfigReader f9166d;

    /* compiled from: moments_invite_impression */
    final class RideKeywordClickableSpan extends ClickableSpan {
        final /* synthetic */ RideKeywordTriggerHelper f9159a;
        private final String f9160b;
        private final ThreadKey f9161c;
        private final List<String> f9162d = new ArrayList();

        public RideKeywordClickableSpan(RideKeywordTriggerHelper rideKeywordTriggerHelper, String str, ThreadKey threadKey) {
            this.f9159a = rideKeywordTriggerHelper;
            this.f9160b = str;
            this.f9161c = threadKey;
        }

        public final void m9699a(String str) {
            this.f9162d.add(str);
        }

        public final void onClick(View view) {
            String str;
            RideOauthHelper rideOauthHelper = this.f9159a.f9165c;
            RideServiceParamsBuilder newBuilder = RideServiceParams.newBuilder();
            newBuilder.f9299a = "keyword_trigger";
            newBuilder = newBuilder;
            newBuilder.f9300b = this.f9161c;
            RideServiceParamsBuilder rideServiceParamsBuilder = newBuilder;
            if (this.f9162d.size() == 1) {
                str = (String) this.f9162d.get(0);
            } else {
                str = null;
            }
            rideServiceParamsBuilder.f9302d = str;
            newBuilder = rideServiceParamsBuilder;
            newBuilder.f9304f = this.f9160b;
            rideOauthHelper.m9735a(newBuilder.m9767j());
        }
    }

    public static RideKeywordTriggerHelper m9700a(InjectorLike injectorLike) {
        return new RideKeywordTriggerHelper(IdBasedProvider.a(injectorLike, 4121), RideOauthHelper.m9729b(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public RideKeywordTriggerHelper(Provider<Boolean> provider, RideOauthHelper rideOauthHelper, XConfigReader xConfigReader) {
        this.f9164b = provider;
        this.f9165c = rideOauthHelper;
        this.f9166d = xConfigReader;
    }

    public final boolean m9702a(Spannable spannable, ThreadKey threadKey) {
        if (!((Boolean) this.f9164b.get()).booleanValue() || !(spannable instanceof SpannableString)) {
            return false;
        }
        SpannableString spannableString = (SpannableString) spannable;
        String obj = spannable.toString();
        Iterator it = m9701a(this.f9166d).entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Matcher matcher = ((Pattern) entry.getValue()).matcher(spannable);
            boolean z2 = z;
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                RideKeywordClickableSpan[] rideKeywordClickableSpanArr = (RideKeywordClickableSpan[]) spannableString.getSpans(start, end, RideKeywordClickableSpan.class);
                if (rideKeywordClickableSpanArr.length == 0) {
                    RideKeywordClickableSpan rideKeywordClickableSpan = new RideKeywordClickableSpan(this, obj.substring(start, end), threadKey);
                    rideKeywordClickableSpan.m9699a((String) entry.getKey());
                    spannable.setSpan(rideKeywordClickableSpan, start, end, 33);
                } else {
                    rideKeywordClickableSpanArr[0].m9699a((String) entry.getKey());
                }
                z2 = true;
            }
            z = z2;
        }
        return z;
    }

    private static ImmutableMap<String, Pattern> m9701a(XConfigReader xConfigReader) {
        if (f9163a != null) {
            return f9163a;
        }
        ImmutableMap a = BusinessRideXConfig.a(xConfigReader.a(BusinessRideXConfig.c, "{}"));
        Map hashMap = new HashMap();
        Iterator it = a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put(entry.getKey(), Pattern.compile((String) entry.getValue(), 2));
        }
        ImmutableMap<String, Pattern> copyOf = ImmutableMap.copyOf(hashMap);
        f9163a = copyOf;
        return copyOf;
    }
}

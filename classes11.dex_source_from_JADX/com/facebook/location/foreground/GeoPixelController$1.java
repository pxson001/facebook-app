package com.facebook.location.foreground;

import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Splitter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Unknown collection type in getLongString() */
public class GeoPixelController$1 implements Callable<Map<String, Object>> {
    final /* synthetic */ GeoPixelController f10441a;

    /* compiled from: Unknown collection type in getLongString() */
    class C12291 implements ResponseHandler<Integer> {
        final /* synthetic */ GeoPixelController$1 f10440a;

        C12291(GeoPixelController$1 geoPixelController$1) {
            this.f10440a = geoPixelController$1;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            return GeoPixelController.b(httpResponse);
        }
    }

    public GeoPixelController$1(GeoPixelController geoPixelController) {
        this.f10441a = geoPixelController;
    }

    public Object call() {
        Map hashMap;
        Map b = ((CellDiagnosticsSerializer) this.f10441a.l.get()).b();
        if (b == null) {
            hashMap = new HashMap();
        } else {
            hashMap = b;
        }
        List<String> splitToList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(this.f10441a.f.a(GeoPixelXConfig.c, ""));
        if (!splitToList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : splitToList) {
                try {
                    Integer num = (Integer) this.f10441a.p.a(FbHttpRequest.newBuilder().a(new HttpGet(StringFormatUtil.formatStrLocaleSafe("http://scontent-%s.xx.fbcdn.net/?rand=%d", str, Long.valueOf(GeoPixelController.c.nextLong())))).a(GeoPixelController.b).a(GeoPixelController.a).a(RequestPriority.NON_INTERACTIVE).a(new C12291(this)).a());
                    if (num != null) {
                        jSONArray.put(new JSONObject().put("region_code", str).put("rtt_ms", num));
                    }
                } catch (Throwable e) {
                    this.f10441a.j.a(GeoPixelController.a, e);
                }
            }
            hashMap.put("rtt_results", jSONArray);
        }
        String str2 = "facebook.com";
        if (!splitToList.isEmpty()) {
            str2 = StringFormatUtil.formatStrLocaleSafe("scontent-%s.xx.fbcdn.net", splitToList.get(0));
        }
        if (this.f10441a.i.a(ExperimentsForForegroundLocationModule.p, false)) {
            hashMap.put("ping_results", GeoPixelController.a(this.f10441a.i.a(ExperimentsForForegroundLocationModule.q, 2), this.f10441a.i.a(ExperimentsForForegroundLocationModule.o, 5), str2, this.f10441a.i.a(ExperimentsForForegroundLocationModule.s, 0.5f), this.f10441a.i.a(ExperimentsForForegroundLocationModule.r, 0.2f), this.f10441a.h));
        }
        TimeZone timeZone = TimeZone.getDefault();
        hashMap.put("time_zone_short_name", timeZone.getDisplayName(false, 0, Locale.US));
        hashMap.put("time_zone_long_name", timeZone.getDisplayName(false, 1, Locale.US));
        hashMap.put("phone_line_one_area_code", GeoPixelController.a(this.f10441a, 0));
        hashMap.put("phone_line_two_area_code", GeoPixelController.a(this.f10441a, 1));
        return hashMap;
    }
}

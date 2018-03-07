package com.facebook.zero.protocol.methods;

import com.facebook.zero.sdk.request.ZeroRequestBaseParams;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: field_path */
public abstract class ZeroBaseMethod {
    protected static List<NameValuePair> m32153a(ZeroRequestBaseParams zeroRequestBaseParams) {
        CarrierAndSimMccMnc carrierAndSimMccMnc = zeroRequestBaseParams.f23534a;
        String str = zeroRequestBaseParams.f23535b;
        List<NameValuePair> a = Lists.m1296a();
        a.add(new BasicNameValuePair("carrier_mcc", carrierAndSimMccMnc.f23518b.f23520a));
        a.add(new BasicNameValuePair("carrier_mnc", carrierAndSimMccMnc.f23518b.f23521b));
        a.add(new BasicNameValuePair("sim_mcc", carrierAndSimMccMnc.f23519c.f23520a));
        a.add(new BasicNameValuePair("sim_mnc", carrierAndSimMccMnc.f23519c.f23521b));
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("interface", str));
        return a;
    }
}

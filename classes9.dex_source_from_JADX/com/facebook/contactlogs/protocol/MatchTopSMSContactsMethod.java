package com.facebook.contactlogs.protocol;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: profile_nux_step_types */
public class MatchTopSMSContactsMethod implements ApiMethod<ImmutableList<PhonebookContact>, ArrayList<Bundle>> {
    private final JsonFactory f6167a;
    private final TelephonyManager f6168b;
    private final Provider<String> f6169c;

    public final ApiRequest m6505a(Object obj) {
        ImmutableList immutableList = (ImmutableList) obj;
        List arrayList = new ArrayList();
        String str = (String) this.f6169c.get();
        Object simCountryIso = this.f6168b.getSimCountryIso();
        Object networkCountryIso = this.f6168b.getNetworkCountryIso();
        if (!StringUtil.a(str)) {
            arrayList.add(new BasicNameValuePair("country_code", str));
        }
        if (!StringUtil.a(simCountryIso)) {
            arrayList.add(new BasicNameValuePair("sim_country", simCountryIso));
        }
        if (!StringUtil.a(networkCountryIso)) {
            arrayList.add(new BasicNameValuePair("network_country", networkCountryIso));
        }
        arrayList.add(new BasicNameValuePair("top_contacts", m6504b(immutableList)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "MatchTopSMSContacts";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/top_contact_logs_contacts";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public MatchTopSMSContactsMethod(Provider<String> provider, JsonFactory jsonFactory, TelephonyManager telephonyManager) {
        this.f6169c = provider;
        this.f6167a = jsonFactory;
        this.f6168b = telephonyManager;
    }

    public final Object m6506a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        ArrayList arrayList = new ArrayList();
        if (!c.d("top_contacts")) {
            return arrayList;
        }
        Iterator it = c.b("top_contacts").iterator();
        while (it.hasNext()) {
            c = (JsonNode) it.next();
            Bundle bundle = new Bundle();
            if (c.d("id")) {
                bundle.putString("id", c.b("id").B());
            }
            if (c.d("name")) {
                bundle.putString("name", c.b("name").B());
            }
            if (c.d("profile_pic")) {
                bundle.putString("profile_pic", c.b("profile_pic").B());
            }
            if (c.d("phone_number")) {
                bundle.putString("phone_number", c.b("phone_number").B());
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private String m6504b(ImmutableList<PhonebookContact> immutableList) {
        Writer stringWriter = new StringWriter();
        JsonGenerator a = this.f6167a.a(stringWriter);
        a.d();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PhonebookContact phonebookContact = (PhonebookContact) immutableList.get(i);
            a.f();
            a.g("name");
            a.a("formatted", phonebookContact.b);
            Object obj = phonebookContact.c;
            if (!StringUtil.a(obj)) {
                a.a("first", obj);
            }
            obj = phonebookContact.d;
            if (!StringUtil.a(obj)) {
                a.a("last", obj);
            }
            a.g();
            ImmutableList<PhonebookPhoneNumber> immutableList2 = phonebookContact.m;
            if (!immutableList2.isEmpty()) {
                a.f("phones");
                for (PhonebookPhoneNumber phonebookPhoneNumber : immutableList2) {
                    a.f();
                    a.a("type", phonebookPhoneNumber.a());
                    a.a("number", phonebookPhoneNumber.a);
                    a.g();
                }
                a.e();
            }
            a.g();
        }
        a.e();
        a.flush();
        return stringWriter.toString();
    }
}

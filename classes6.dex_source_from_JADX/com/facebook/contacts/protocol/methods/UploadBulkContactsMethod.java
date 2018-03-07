package com.facebook.contacts.protocol.methods;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.contacts.server.UploadBulkContactChange;
import com.facebook.contacts.server.UploadBulkContactChangeResult;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Confidence;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Type;
import com.facebook.contacts.server.UploadBulkContactFieldMatch;
import com.facebook.contacts.server.UploadBulkContactFieldMatch.MatchType;
import com.facebook.contacts.server.UploadBulkContactFieldMatch.ValueType;
import com.facebook.contacts.server.UploadBulkContactsParams;
import com.facebook.contacts.server.UploadBulkContactsResult;
import com.facebook.contacts.util.DeviceUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: page_photos_tab */
public class UploadBulkContactsMethod implements ApiMethod<UploadBulkContactsParams, UploadBulkContactsResult> {
    private static final Class<?> f8391a = UploadBulkContactsMethod.class;
    private final Context f8392b;
    private final DeviceUtil f8393c;
    private final JsonFactory f8394d;
    private final TelephonyManager f8395e;
    private final Provider<TriState> f8396f;

    public static UploadBulkContactsMethod m12245a(InjectorLike injectorLike) {
        return new UploadBulkContactsMethod((Context) injectorLike.getInstance(Context.class), DeviceUtil.m12328b(injectorLike), JsonFactoryMethodAutoProvider.a(injectorLike), TelephonyManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 656));
    }

    public final ApiRequest m12250a(Object obj) {
        UploadBulkContactsParams uploadBulkContactsParams = (UploadBulkContactsParams) obj;
        List a = Lists.a();
        if (uploadBulkContactsParams.f8475a != null) {
            a.add(new BasicNameValuePair("import_id", uploadBulkContactsParams.f8475a));
        }
        Object simCountryIso = this.f8395e.getSimCountryIso();
        Object networkCountryIso = this.f8395e.getNetworkCountryIso();
        if (!StringUtil.a(simCountryIso)) {
            a.add(new BasicNameValuePair("sim_country", simCountryIso));
        }
        if (!StringUtil.a(networkCountryIso)) {
            a.add(new BasicNameValuePair("network_country", networkCountryIso));
        }
        a.add(new BasicNameValuePair("contact_changes", m12247a(uploadBulkContactsParams.f8476b)));
        a.add(new BasicNameValuePair("contacts_surface", uploadBulkContactsParams.f8477c.name()));
        a.add(new BasicNameValuePair("android_id", DeviceUtil.m12327a(this.f8392b)));
        a.add(new BasicNameValuePair("phone_id", this.f8393c.m12329a()));
        new StringBuilder("Uploading contacts: ").append(a);
        return new ApiRequest("graphUploadBulkContacts", "POST", "me/bulkcontacts", a, ApiResponseType.JSON);
    }

    @Inject
    public UploadBulkContactsMethod(Context context, DeviceUtil deviceUtil, JsonFactory jsonFactory, TelephonyManager telephonyManager, Provider<TriState> provider) {
        this.f8392b = context;
        this.f8393c = deviceUtil;
        this.f8394d = jsonFactory;
        this.f8395e = telephonyManager;
        this.f8396f = provider;
    }

    private static UploadBulkContactsResult m12246a(ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        new StringBuilder("Got response: ").append(c);
        String b = JSONUtil.b(c.b("import_id"));
        Builder builder = ImmutableList.builder();
        Iterator H = c.b("contact_changes").H();
        while (H.hasNext()) {
            Type type;
            Confidence confidence;
            Entry entry = (Entry) H.next();
            String str = (String) entry.getKey();
            c = (JsonNode) entry.getValue();
            String b2 = JSONUtil.b(c.b("update_type"));
            if (b2.equals("add")) {
                type = Type.ADD;
            } else if (b2.equals("modify")) {
                type = Type.MODIFY;
            } else if (b2.equals("remove")) {
                type = Type.REMOVE;
            } else if (b2.equals("none")) {
                type = Type.NONE;
            } else {
                BLog.b(f8391a, "Unrecognized contact change type: " + b2 + ", skipping");
            }
            String b3 = JSONUtil.b(c.b("contact").b("id"));
            Builder builder2 = ImmutableList.builder();
            Iterator it = c.b("field_matches").iterator();
            while (it.hasNext()) {
                MatchType matchType;
                ValueType valueType;
                JsonNode jsonNode = (JsonNode) it.next();
                String b4 = JSONUtil.b(jsonNode.b("match_type"));
                if (b4.equals("hard")) {
                    matchType = MatchType.HARD;
                } else if (b4.equals("soft")) {
                    matchType = MatchType.SOFT;
                } else {
                    BLog.b(f8391a, "Unrecognized contact field match type: " + b4 + ", skipping");
                }
                String b5 = JSONUtil.b(jsonNode.b("value_type"));
                if (b5.equals("name")) {
                    valueType = ValueType.NAME;
                } else if (b5.equals("email")) {
                    valueType = ValueType.EMAIL;
                } else if (b5.equals("phone")) {
                    valueType = ValueType.PHONE;
                } else if (b5.equals("email_public_hash")) {
                    valueType = ValueType.EMAIL_PUBLIC_HASH;
                } else if (b5.equals("phone_public_hash")) {
                    valueType = ValueType.PHONE_PUBLIC_HASH;
                } else {
                    BLog.b(f8391a, "Unrecognized contact field value type: " + b5 + ", skipping");
                }
                builder2.c(new UploadBulkContactFieldMatch(matchType, valueType));
            }
            String b6 = JSONUtil.b(c.b("match_confidence"));
            if (b6.equals("high")) {
                confidence = Confidence.HIGH;
            } else if (b6.equals("medium")) {
                confidence = Confidence.MEDIUM;
            } else if (b6.equals("low")) {
                confidence = Confidence.LOW;
            } else if (b6.equals("very_low")) {
                confidence = Confidence.VERY_LOW;
            } else if (b6.equals("unknown")) {
                confidence = Confidence.UNKNOWN;
            } else {
                BLog.b(f8391a, "Unrecognized confidence type: " + b6);
                confidence = Confidence.UNKNOWN;
            }
            builder.c(new UploadBulkContactChangeResult(type, str, b3, builder2.b(), confidence));
        }
        return new UploadBulkContactsResult(b, builder.b(), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
    }

    private String m12247a(ImmutableList<UploadBulkContactChange> immutableList) {
        Writer stringWriter = new StringWriter();
        JsonGenerator a = this.f8394d.a(stringWriter);
        a.d();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m12249a((UploadBulkContactChange) immutableList.get(i), a);
        }
        a.e();
        a.flush();
        return stringWriter.toString();
    }

    private void m12249a(UploadBulkContactChange uploadBulkContactChange, JsonGenerator jsonGenerator) {
        String str;
        jsonGenerator.f();
        jsonGenerator.a("client_contact_id", uploadBulkContactChange.f8464a);
        String str2 = "update_type";
        switch (uploadBulkContactChange.f8467d) {
            case ADD:
                str = "add";
                break;
            case MODIFY:
                str = "modify";
                break;
            case DELETE:
                str = "delete";
                break;
            default:
                str = null;
                break;
        }
        jsonGenerator.a(str2, str);
        if (uploadBulkContactChange.f8467d != UploadBulkContactChange.Type.DELETE) {
            m12248a(uploadBulkContactChange.f8466c, jsonGenerator);
        } else {
            PhonebookContact.Builder builder = new PhonebookContact.Builder(uploadBulkContactChange.f8464a);
            builder.f8267b = "None";
            m12248a(builder.m12105c(), jsonGenerator);
        }
        jsonGenerator.g();
    }

    private void m12248a(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        jsonGenerator.g("contact");
        jsonGenerator.g("name");
        jsonGenerator.a("formatted", phonebookContact.f8290b);
        Object obj = phonebookContact.f8291c;
        if (!StringUtil.a(obj)) {
            jsonGenerator.a("first", obj);
        }
        obj = phonebookContact.f8292d;
        if (!StringUtil.a(obj)) {
            jsonGenerator.a("last", obj);
        }
        jsonGenerator.g();
        ImmutableList<PhonebookPhoneNumber> immutableList = phonebookContact.f8301m;
        if (!immutableList.isEmpty()) {
            jsonGenerator.f("phones");
            for (PhonebookPhoneNumber phonebookPhoneNumber : immutableList) {
                jsonGenerator.f();
                jsonGenerator.a("type", phonebookPhoneNumber.m12111a());
                jsonGenerator.a("number", phonebookPhoneNumber.f8335a);
                jsonGenerator.g();
            }
            jsonGenerator.e();
        }
        if (((TriState) this.f8396f.get()).asBoolean(false)) {
            ImmutableList<PhonebookEmailAddress> immutableList2 = phonebookContact.f8302n;
            if (!immutableList2.isEmpty()) {
                jsonGenerator.f("emails");
                for (PhonebookEmailAddress phonebookEmailAddress : immutableList2) {
                    String str;
                    jsonGenerator.f();
                    String str2 = "type";
                    if (phonebookEmailAddress.f8256i == 1) {
                        str = "home";
                    } else if (phonebookEmailAddress.f8256i == 2) {
                        str = "work";
                    } else if (phonebookEmailAddress.f8256i == 4) {
                        str = "mobile";
                    } else {
                        str = "other";
                    }
                    jsonGenerator.a(str2, str);
                    jsonGenerator.a("email", phonebookEmailAddress.f8321a);
                    jsonGenerator.g();
                }
                jsonGenerator.e();
            }
        }
        jsonGenerator.g();
    }
}

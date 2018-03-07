package com.facebook.contacts.protocol.methods;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.model.PhonebookAddress;
import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookContact.Builder;
import com.facebook.contacts.model.PhonebookContactField;
import com.facebook.contacts.model.PhonebookContactMetadata;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookEvent;
import com.facebook.contacts.model.PhonebookInstantMessaging;
import com.facebook.contacts.model.PhonebookNickname;
import com.facebook.contacts.model.PhonebookOrganization;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.contacts.model.PhonebookRelation;
import com.facebook.contacts.model.PhonebookWebsite;
import com.facebook.contacts.model.PhonebookWhatsappProfile;
import com.facebook.contacts.server.UploadBulkContactChange;
import com.facebook.contacts.server.UploadBulkContactChange.Type;
import com.facebook.contacts.server.UploadFriendFinderContactsParams;
import com.facebook.contacts.server.UploadFriendFinderContactsResult;
import com.facebook.contacts.server.UploadFriendFinderContactsResult.ServerStatusCode;
import com.facebook.contacts.util.DeviceUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: page_photo_only */
public class UploadFriendFinderContactsMethod implements ApiMethod<UploadFriendFinderContactsParams, UploadFriendFinderContactsResult> {
    private static final Class<?> f8398a = UploadFriendFinderContactsMethod.class;
    private static final SimpleDateFormat f8399b = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final SimpleDateFormat f8400c = new SimpleDateFormat("--MM-dd", Locale.US);
    private static final Calendar f8401d = Calendar.getInstance();
    private final Context f8402e;
    private final DeviceUtil f8403f;
    private final JsonFactory f8404g;
    private final Provider<Boolean> f8405h;
    private final Provider<TriState> f8406i;
    private final TelephonyManager f8407j;

    public static UploadFriendFinderContactsMethod m12252a(InjectorLike injectorLike) {
        return new UploadFriendFinderContactsMethod((Context) injectorLike.getInstance(Context.class), DeviceUtil.m12328b(injectorLike), JsonFactoryMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3943), IdBasedProvider.a(injectorLike, 655), TelephonyManagerMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m12282a(Object obj) {
        UploadFriendFinderContactsParams uploadFriendFinderContactsParams = (UploadFriendFinderContactsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        if (uploadFriendFinderContactsParams.f8485b != null) {
            a.add(new BasicNameValuePair("import_id", uploadFriendFinderContactsParams.f8485b));
        }
        Object simCountryIso = this.f8407j.getSimCountryIso();
        Object networkCountryIso = this.f8407j.getNetworkCountryIso();
        if (!StringUtil.a(simCountryIso)) {
            a.add(new BasicNameValuePair("sim_country", simCountryIso));
        }
        if (!StringUtil.a(networkCountryIso)) {
            a.add(new BasicNameValuePair("network_country", networkCountryIso));
        }
        if (uploadFriendFinderContactsParams.f8484a != null) {
            a.add(new BasicNameValuePair("flow", uploadFriendFinderContactsParams.f8484a.name()));
        }
        a.add(new BasicNameValuePair("is_full_upload", String.valueOf(uploadFriendFinderContactsParams.f8487d)));
        a.add(new BasicNameValuePair("contacts", m12263a(uploadFriendFinderContactsParams.f8486c)));
        a.add(new BasicNameValuePair("android_id", DeviceUtil.m12327a(this.f8402e)));
        a.add(new BasicNameValuePair("phone_id", this.f8403f.m12329a()));
        return new ApiRequest("FriendFinderMobileContinuousSync", "POST", "method/friendFinder.mobilecontinuoussync", a, ApiResponseType.JSON);
    }

    @Inject
    public UploadFriendFinderContactsMethod(Context context, DeviceUtil deviceUtil, JsonFactory jsonFactory, Provider<Boolean> provider, Provider<TriState> provider2, TelephonyManager telephonyManager) {
        this.f8402e = context;
        this.f8403f = deviceUtil;
        this.f8404g = jsonFactory;
        this.f8405h = provider;
        this.f8406i = provider2;
        this.f8407j = telephonyManager;
    }

    public final Object m12283a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("import_id"));
        int d = JSONUtil.d(c.b("server_status"));
        ServerStatusCode serverStatusCode = ServerStatusCode.UNKNOWN;
        if (d < ServerStatusCode.values().length) {
            serverStatusCode = ServerStatusCode.values()[d];
        }
        return new UploadFriendFinderContactsResult(b, serverStatusCode);
    }

    private String m12263a(ImmutableList<UploadBulkContactChange> immutableList) {
        Writer stringWriter = new StringWriter();
        JsonGenerator a = this.f8404g.a(stringWriter);
        a.d();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m12266a((UploadBulkContactChange) immutableList.get(i), a);
        }
        a.e();
        a.flush();
        return stringWriter.toString();
    }

    private void m12266a(UploadBulkContactChange uploadBulkContactChange, JsonGenerator jsonGenerator) {
        try {
            jsonGenerator.f();
            jsonGenerator.a("record_id", uploadBulkContactChange.m12296a());
            jsonGenerator.a("modifier", m12262a(uploadBulkContactChange));
            jsonGenerator.a("signature", uploadBulkContactChange.m12297b());
            if (uploadBulkContactChange.m12299d() != Type.DELETE) {
                m12265a(uploadBulkContactChange.m12298c(), jsonGenerator);
            } else {
                m12265a(new Builder(uploadBulkContactChange.m12296a()).m12104a("None").m12105c(), jsonGenerator);
            }
            jsonGenerator.g();
        } catch (Throwable e) {
            m12270a(e, "appendContactChange", uploadBulkContactChange.m12296a());
        }
    }

    private static String m12262a(UploadBulkContactChange uploadBulkContactChange) {
        switch (uploadBulkContactChange.f8467d) {
            case ADD:
                return "0";
            case MODIFY:
                return "1";
            case DELETE:
                return "2";
            default:
                return null;
        }
    }

    private void m12265a(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        String str = phonebookContact.f8290b;
        if (str != null) {
            m12267a(jsonGenerator, "name", str);
        }
        m12272c(phonebookContact, jsonGenerator);
        m12271b(phonebookContact, jsonGenerator);
        if (((Boolean) this.f8405h.get()).booleanValue()) {
            m12267a(jsonGenerator, "photo", m12264a(phonebookContact.f8299k));
            m12267a(jsonGenerator, "note", m12264a(phonebookContact.f8300l));
            m12267a(jsonGenerator, "first_name", phonebookContact.f8291c);
            m12267a(jsonGenerator, "last_name", phonebookContact.f8292d);
            m12267a(jsonGenerator, "prefix", phonebookContact.f8293e);
            m12267a(jsonGenerator, "middle_name", phonebookContact.f8294f);
            m12267a(jsonGenerator, "suffix", phonebookContact.f8295g);
            m12267a(jsonGenerator, "phonetic_first_name", phonebookContact.f8296h);
            m12267a(jsonGenerator, "phonetic_last_name", phonebookContact.f8298j);
            m12267a(jsonGenerator, "phonetic_middle_name", phonebookContact.f8297i);
            m12273e(phonebookContact, jsonGenerator);
            m12274f(phonebookContact, jsonGenerator);
            m12275g(phonebookContact, jsonGenerator);
            m12276h(phonebookContact, jsonGenerator);
            m12277i(phonebookContact, jsonGenerator);
            m12278j(phonebookContact, jsonGenerator);
            m12279k(phonebookContact, jsonGenerator);
            m12281m(phonebookContact, jsonGenerator);
            m12280l(phonebookContact, jsonGenerator);
        }
    }

    private void m12271b(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8302n;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            if (((TriState) this.f8406i.get()).asBoolean(true)) {
                m12269a(immutableList, arrayNode);
            } else {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    arrayNode.a(m12253a((PhonebookEmailAddress) immutableList.get(i)));
                }
            }
            try {
                jsonGenerator.a("emails", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookEmailAddress", phonebookContact.m12107a());
            }
        }
    }

    private void m12272c(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8301m;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            if (((TriState) this.f8406i.get()).asBoolean(true)) {
                m12269a(immutableList, arrayNode);
            } else {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    arrayNode.a(m12254a((PhonebookPhoneNumber) immutableList.get(i)));
                }
            }
            try {
                jsonGenerator.a("phones", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookPhoneNumber", phonebookContact.m12107a());
            }
        }
    }

    private static void m12269a(ImmutableList<? extends PhonebookContactField> immutableList, ArrayNode arrayNode) {
        HashMultimap u = HashMultimap.u();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PhonebookContactField phonebookContactField = (PhonebookContactField) immutableList.get(i);
            if (phonebookContactField instanceof PhonebookPhoneNumber) {
                PhonebookPhoneNumber phonebookPhoneNumber = (PhonebookPhoneNumber) phonebookContactField;
                u.a(m12254a(phonebookPhoneNumber), phonebookPhoneNumber.f8336b);
            } else if (phonebookContactField instanceof PhonebookEmailAddress) {
                PhonebookEmailAddress phonebookEmailAddress = (PhonebookEmailAddress) phonebookContactField;
                u.a(m12253a(phonebookEmailAddress), phonebookEmailAddress.f8322b);
            }
        }
        for (ObjectNode objectNode : u.p()) {
            arrayNode.a(objectNode.a("sources", TextUtils.join(";", u.c(objectNode))));
        }
    }

    private static ObjectNode m12253a(PhonebookEmailAddress phonebookEmailAddress) {
        String str;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        String str2 = "label";
        int i = phonebookEmailAddress.f8256i;
        if (i == 1) {
            str = "home";
        } else if (i == 2) {
            str = "work";
        } else {
            str = "other";
        }
        return objectNode.a(str2, str).a("raw", phonebookEmailAddress.f8321a);
    }

    private static ObjectNode m12254a(PhonebookPhoneNumber phonebookPhoneNumber) {
        String str;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        String str2 = "label";
        int i = phonebookPhoneNumber.f8256i;
        if (i == 1) {
            str = "home";
        } else if (i == 3) {
            str = "work";
        } else if (i == 2) {
            str = "mobile";
        } else if (i == 5) {
            str = "fax_home";
        } else if (i == 4) {
            str = "fax_work";
        } else if (i == 13) {
            str = "fax_other";
        } else if (i == 6) {
            str = "pager";
        } else {
            str = "other";
        }
        return objectNode.a(str2, str).a("raw", phonebookPhoneNumber.f8335a);
    }

    private static void m12273e(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8303o;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookInstantMessaging phonebookInstantMessaging = (PhonebookInstantMessaging) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12257a(phonebookInstantMessaging));
                m12268a(a, "data", phonebookInstantMessaging.f8324a);
                m12268a(a, "label", phonebookInstantMessaging.f8257j);
                m12268a(a, "protocol", phonebookInstantMessaging.f8325b);
                m12268a(a, "custom_protocol", phonebookInstantMessaging.f8326c);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("instant_messaging", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookInstantMessaging", phonebookContact.m12107a());
            }
        }
    }

    private static void m12274f(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8304p;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookNickname phonebookNickname = (PhonebookNickname) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12258a(phonebookNickname));
                m12268a(a, "name", phonebookNickname.f8327a);
                m12268a(a, "label", phonebookNickname.f8257j);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("nick_names", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookNickname", phonebookContact.m12107a());
            }
        }
    }

    private static void m12275g(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8305q;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookAddress phonebookAddress = (PhonebookAddress) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12255a(phonebookAddress));
                m12268a(a, "label", phonebookAddress.f8257j);
                m12268a(a, "formatted_address", phonebookAddress.f8258a);
                m12268a(a, "street", phonebookAddress.f8259b);
                m12268a(a, "po_box", phonebookAddress.f8260c);
                m12268a(a, "neighborhood", phonebookAddress.f8261d);
                m12268a(a, "city", phonebookAddress.f8262e);
                m12268a(a, "region", phonebookAddress.f8263f);
                m12268a(a, "post_code", phonebookAddress.f8264g);
                m12268a(a, "country", phonebookAddress.f8265h);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("address", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookAddress", phonebookContact.m12107a());
            }
        }
    }

    private static void m12276h(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8306r;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookWebsite phonebookWebsite = (PhonebookWebsite) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12261a(phonebookWebsite));
                m12268a(a, "URL", phonebookWebsite.f8338a);
                m12268a(a, "label", phonebookWebsite.f8257j);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("website", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookWebsite", phonebookContact.m12107a());
            }
        }
    }

    private static void m12277i(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8307s;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookRelation phonebookRelation = (PhonebookRelation) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12260a(phonebookRelation));
                m12268a(a, "name", phonebookRelation.f8337a);
                m12268a(a, "label", phonebookRelation.f8257j);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("relation", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookRelation", phonebookContact.m12107a());
            }
        }
    }

    private static void m12278j(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8308t;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookOrganization phonebookOrganization = (PhonebookOrganization) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12259a(phonebookOrganization));
                m12268a(a, "label", phonebookOrganization.f8257j);
                m12268a(a, "company", phonebookOrganization.f8328a);
                m12268a(a, "department", phonebookOrganization.f8330c);
                m12268a(a, "job_title", phonebookOrganization.f8329b);
                m12268a(a, "job_description", phonebookOrganization.f8331d);
                m12268a(a, "symbol", phonebookOrganization.f8332e);
                m12268a(a, "phonetic_name", phonebookOrganization.f8333f);
                m12268a(a, "office_location", phonebookOrganization.f8334g);
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("organization", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookOrganization", phonebookContact.m12107a());
            }
        }
    }

    private static void m12279k(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8310v;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookContactMetadata phonebookContactMetadata = (PhonebookContactMetadata) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("number_times_contacted", String.valueOf(phonebookContactMetadata.f8313b)).a("starred", m12264a(phonebookContactMetadata.f8314c)).a("last_time_contacted", String.valueOf(phonebookContactMetadata.f8315d)).a("custom_ringtone", m12264a(phonebookContactMetadata.f8316e)).a("in_visible_group", m12264a(phonebookContactMetadata.f8317f)).a("send_to_voicemail", m12264a(phonebookContactMetadata.f8318g)).a("is_user_profile", m12264a(phonebookContactMetadata.f8319h));
                m12268a(a, "contact_id", phonebookContactMetadata.f8312a);
                m12268a(a, "account_type", phonebookContactMetadata.m12109a());
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("meta_data", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookContactMetadata", phonebookContact.m12107a());
            }
        }
    }

    private static void m12280l(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8311w;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookWhatsappProfile phonebookWhatsappProfile = (PhonebookWhatsappProfile) immutableList.get(i);
                arrayNode.a(new ObjectNode(JsonNodeFactory.a).a("username", phonebookWhatsappProfile.f8339a).a("phone_number", phonebookWhatsappProfile.f8340b));
            }
            try {
                jsonGenerator.a("whatsapp_profile", arrayNode);
            } catch (Throwable e) {
                m12270a(e, "appendPhonebookWhatsappProfile", phonebookContact.m12107a());
            }
        }
    }

    private static void m12281m(PhonebookContact phonebookContact, JsonGenerator jsonGenerator) {
        ImmutableList immutableList = phonebookContact.f8309u;
        if (!immutableList.isEmpty()) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhonebookEvent phonebookEvent = (PhonebookEvent) immutableList.get(i);
                ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("type", m12256a(phonebookEvent));
                m12268a(a, "label", phonebookEvent.f8257j);
                try {
                    if (phonebookEvent.f8323a.length() == 7) {
                        f8401d.setTimeInMillis(f8400c.parse(phonebookEvent.f8323a).getTime());
                    } else {
                        f8401d.setTimeInMillis(f8399b.parse(phonebookEvent.f8323a).getTime());
                        if (!phonebookContact.m12108b()) {
                            a.a("date", String.valueOf(f8401d.getTimeInMillis() / 1000));
                            a.a("year", String.valueOf(f8401d.get(1)));
                        }
                    }
                    a.a("month", String.valueOf(f8401d.get(2) + 1));
                    a.a("day", String.valueOf(f8401d.get(5)));
                } catch (Throwable e) {
                    m12270a(e, "appendPhonebookEvent", phonebookContact.m12107a());
                }
                arrayNode.a(a);
            }
            try {
                jsonGenerator.a("event", arrayNode);
            } catch (Throwable e2) {
                m12270a(e2, "appendPhonebookEvent", phonebookContact.m12107a());
            }
        }
    }

    private static void m12270a(Throwable th, Object... objArr) {
        BLog.a(f8398a, th, "Got Exception when %s for contact %s", objArr);
    }

    private static void m12268a(ObjectNode objectNode, String str, String str2) {
        if (!StringUtil.a(str2)) {
            objectNode.a(str, str2);
        }
    }

    public static void m12267a(JsonGenerator jsonGenerator, String str, String str2) {
        if (!StringUtil.a(str2)) {
            try {
                jsonGenerator.a(str, str2);
            } catch (Throwable e) {
                BLog.a(f8398a, e, "Got IOException when adding contact field key %s value %s", new Object[]{str, str2});
            }
        }
    }

    private static String m12257a(PhonebookInstantMessaging phonebookInstantMessaging) {
        int i = phonebookInstantMessaging.f8256i;
        if (i == 1) {
            return "home";
        }
        if (i == 2) {
            return "work";
        }
        return "other";
    }

    private static String m12258a(PhonebookNickname phonebookNickname) {
        int i = phonebookNickname.f8256i;
        if (i == 1) {
            return "default";
        }
        if (i == 3) {
            return "maiden";
        }
        if (i == 5) {
            return "initials";
        }
        if (i == 4) {
            return "short";
        }
        return "other";
    }

    private static String m12255a(PhonebookAddress phonebookAddress) {
        int i = phonebookAddress.f8256i;
        if (i == 1) {
            return "home";
        }
        if (i == 2) {
            return "work";
        }
        return "other";
    }

    private static String m12261a(PhonebookWebsite phonebookWebsite) {
        int i = phonebookWebsite.f8256i;
        if (i == 1) {
            return "homepage";
        }
        if (i == 2) {
            return "blog";
        }
        if (i == 3) {
            return "profile";
        }
        if (i == 4) {
            return "home";
        }
        if (i == 5) {
            return "work";
        }
        if (i == 6) {
            return "ftp";
        }
        return "other";
    }

    private static String m12260a(PhonebookRelation phonebookRelation) {
        int i = phonebookRelation.f8256i;
        if (i == 1) {
            return "assistant";
        }
        if (i == 2) {
            return "brother";
        }
        if (i == 3) {
            return "child";
        }
        if (i == 4) {
            return "domestic_partner";
        }
        if (i == 5) {
            return "father";
        }
        if (i == 6) {
            return "friend";
        }
        if (i == 7) {
            return "manager";
        }
        if (i == 8) {
            return "mother";
        }
        if (i == 9) {
            return "parent";
        }
        if (i == 10) {
            return "partner";
        }
        if (i == 11) {
            return "referred_by";
        }
        if (i == 12) {
            return "relative";
        }
        if (i == 13) {
            return "sister";
        }
        if (i == 14) {
            return "spouse";
        }
        return "other";
    }

    private static String m12259a(PhonebookOrganization phonebookOrganization) {
        if (phonebookOrganization.f8256i == 1) {
            return "work";
        }
        return "other";
    }

    private static String m12256a(PhonebookEvent phonebookEvent) {
        int i = phonebookEvent.f8256i;
        if (i == 1) {
            return "anniversary";
        }
        if (i == 3) {
            return "birthday";
        }
        return "other";
    }

    private static String m12264a(boolean z) {
        return z ? "1" : "0";
    }
}

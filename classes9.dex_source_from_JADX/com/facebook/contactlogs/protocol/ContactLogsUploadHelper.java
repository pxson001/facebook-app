package com.facebook.contactlogs.protocol;

import com.facebook.contactlogs.data.ContactLogMetadata;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: profile_photo_method_not_set */
public class ContactLogsUploadHelper {
    private final JsonFactory f6166a;

    @Inject
    public ContactLogsUploadHelper(JsonFactory jsonFactory) {
        this.f6166a = jsonFactory;
    }

    final List<NameValuePair> m6503a(ImmutableMap<String, ImmutableList<ContactLogMetadata>> immutableMap) {
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("call_logs", m6502a((ImmutableList) immutableMap.get("call_logs"))));
        arrayList.add(new BasicNameValuePair("mms_logs", m6502a((ImmutableList) immutableMap.get("mms_logs"))));
        arrayList.add(new BasicNameValuePair("sms_logs", m6502a((ImmutableList) immutableMap.get("sms_logs"))));
        return arrayList;
    }

    private String m6502a(ImmutableList<ContactLogMetadata> immutableList) {
        Writer stringWriter = new StringWriter();
        JsonGenerator a = this.f6166a.a(stringWriter);
        a.d();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.a(((ContactLogMetadata) immutableList.get(i)).f6135b);
        }
        a.e();
        a.flush();
        return stringWriter.toString();
    }
}

package com.facebook.analytics;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: textbox_clicked_hot */
public class HoneyAnalyticsEvent implements Parcelable {
    public static final Creator<HoneyAnalyticsEvent> CREATOR = new C01971();
    private static final String[] f3108c = new String[]{"name", "log_type", "time", "uid", "bg", "data"};
    public final String f3109a;
    @VisibleForTesting
    Map<String, String> f3110b;
    public String f3111d;
    public long f3112e = -1;
    public String f3113f = "AUTO_SET";
    public boolean f3114g;
    public String f3115h;
    public String f3116i = "AUTO_SET";
    private String f3117j;
    public ArrayNode f3118k;

    /* compiled from: textbox_clicked_hot */
    final class C01971 implements Creator<HoneyAnalyticsEvent> {
        C01971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new HoneyAnalyticsEvent(parcel);
        }

        public final Object[] newArray(int i) {
            return new HoneyAnalyticsEvent[i];
        }
    }

    public HoneyAnalyticsEvent(String str, String str2) {
        this.f3109a = str;
        this.f3113f = "AUTO_SET";
        this.f3111d = str2;
    }

    public String toString() {
        return this.f3109a;
    }

    public final long m5107a() {
        return this.f3112e;
    }

    public final String m5110b() {
        return this.f3113f;
    }

    public final HoneyAnalyticsEvent m5108a(long j) {
        this.f3112e = j;
        return this;
    }

    public final HoneyAnalyticsEvent m5114d(String str) {
        this.f3113f = str;
        return this;
    }

    public final String m5112c() {
        return this.f3115h;
    }

    public final String m5117h() {
        return this.f3116i;
    }

    public final <T extends HoneyAnalyticsEvent> T m5109a(String str, String str2) {
        mo699b(true).put(str, str2);
        return this;
    }

    public final boolean m5111b(String str) {
        Map b = mo699b(false);
        if (b != null) {
            return b.containsKey(str);
        }
        return false;
    }

    public final String m5113c(String str) {
        Map b = mo699b(false);
        if (b != null) {
            return (String) b.get(str);
        }
        return null;
    }

    public String mo700d() {
        return toString();
    }

    private Set<String> mo732l() {
        Map b = mo699b(false);
        if (b != null) {
            return b.keySet();
        }
        return Collections.emptySet();
    }

    private synchronized Map<String, String> mo699b(boolean z) {
        if (this.f3110b == null && z) {
            this.f3110b = Maps.m838c();
        }
        return this.f3110b;
    }

    public final String m5116e() {
        if (this.f3117j == null) {
            this.f3117j = mo702j();
        }
        return this.f3117j;
    }

    protected String mo702j() {
        throw new UnsupportedOperationException();
    }

    public final String m5119k() {
        return this.f3111d;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3109a, mo732l());
    }

    public int describeContents() {
        return 0;
    }

    public HoneyAnalyticsEvent(Parcel parcel) {
        try {
            JsonNode a = FbObjectMapper.m6612i().m6636a(parcel.readString());
            String[] strArr = f3108c;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (a.mo730d(str)) {
                    i++;
                } else {
                    throw new ParcelFormatException("Missing required field " + str);
                }
            }
            this.f3111d = a.mo709b("name").mo728s();
            this.f3109a = a.mo709b("log_type").mo728s();
            this.f3115h = a.mo709b("session_id").mo728s();
            this.f3112e = a.mo709b("time").mo1284x();
            this.f3113f = a.mo709b("uid").mo728s();
            this.f3114g = a.mo709b("bg").mo1647u();
            this.f3117j = a.mo709b("data").mo728s();
            if (a.mo730d("tags")) {
                JsonNode b = a.mo709b("tags");
                Map b2 = mo699b(true);
                Iterator H = b.mo705H();
                while (H.hasNext()) {
                    Entry entry = (Entry) H.next();
                    b2.put(entry.getKey(), ((JsonNode) entry.getValue()).mo728s());
                }
            }
        } catch (JsonProcessingException e) {
            throw new ParcelFormatException("Failed to process event " + e.toString());
        } catch (IOException e2) {
            throw new ParcelFormatException("Failed to process event " + e2.toString());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("name", this.f3111d);
        objectNode.m5137a("log_type", this.f3109a);
        objectNode.m5137a("session_id", this.f3115h);
        objectNode.m5130a("time", this.f3112e);
        objectNode.m5137a("uid", this.f3113f);
        objectNode.m5138a("bg", this.f3114g);
        objectNode.m5137a("data", m5116e());
        if (this.f3110b != null && this.f3110b.size() > 0) {
            JsonNode objectNode2 = new ObjectNode(JsonNodeFactory.f3121a);
            for (Entry entry : this.f3110b.entrySet()) {
                objectNode2.m5137a((String) entry.getKey(), (String) entry.getValue());
            }
            objectNode.m5143c("tags", objectNode2);
        }
        parcel.writeString(objectNode.toString());
    }
}

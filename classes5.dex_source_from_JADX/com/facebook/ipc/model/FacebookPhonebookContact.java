package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookPhonebookContactDeserializer.class)
/* compiled from: TEXT_WITH_CLEARBUTTON */
public class FacebookPhonebookContact implements Parcelable {
    public static final Creator<FacebookPhonebookContact> CREATOR = new C13571();
    private static final Class<?> f14122c = FacebookPhonebookContact.class;
    public List<String> f14123a;
    public List<String> f14124b;
    @JsonProperty("email")
    public final String email;
    @JsonProperty("is_friend")
    public final boolean isFriend;
    @JsonProperty("name")
    public String name;
    @JsonProperty("native_name")
    public final String nativeName;
    @JsonProperty("ordinal")
    public final long ordinal;
    @JsonProperty("cell")
    public final String phone;
    @JsonProperty("record_id")
    public final long recordId;
    @JsonProperty("uid")
    public final long userId;

    /* compiled from: TEXT_WITH_CLEARBUTTON */
    final class C13571 implements Creator<FacebookPhonebookContact> {
        C13571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookPhonebookContact(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookPhonebookContact[i];
        }
    }

    private FacebookPhonebookContact() {
        this.name = null;
        this.recordId = -1;
        this.isFriend = false;
        this.userId = -1;
        this.phone = null;
        this.f14123a = null;
        this.email = null;
        this.f14124b = null;
        this.ordinal = 0;
        this.nativeName = null;
    }

    public FacebookPhonebookContact(Parcel parcel) {
        this.name = parcel.readString();
        this.recordId = parcel.readLong();
        this.isFriend = parcel.readInt() != 0;
        this.userId = parcel.readLong();
        this.phone = parcel.readString();
        this.f14123a = parcel.readArrayList(String.class.getClassLoader());
        this.email = parcel.readString();
        this.f14124b = parcel.readArrayList(String.class.getClassLoader());
        this.ordinal = parcel.readLong();
        this.nativeName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.recordId);
        parcel.writeInt(this.isFriend ? 1 : 0);
        parcel.writeLong(this.userId);
        parcel.writeString(this.phone);
        parcel.writeList(this.f14123a);
        parcel.writeString(this.email);
        parcel.writeList(this.f14124b);
        parcel.writeLong(this.ordinal);
        parcel.writeString(this.nativeName);
    }

    public FacebookPhonebookContact(String str, long j, List<String> list, List<String> list2) {
        this.name = str;
        this.recordId = j;
        this.f14124b = list;
        if (this.f14124b == null || this.f14124b.size() <= 0) {
            this.email = null;
        } else {
            this.email = (String) this.f14124b.get(0);
        }
        this.f14123a = list2;
        if (this.f14123a == null || this.f14123a.size() <= 0) {
            this.phone = null;
        } else {
            this.phone = (String) this.f14123a.get(0);
        }
        this.userId = -1;
        this.isFriend = false;
        this.ordinal = 0;
        this.nativeName = null;
    }

    public static String m23497a(List<FacebookPhonebookContact> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (FacebookPhonebookContact facebookPhonebookContact : list) {
                JSONArray jSONArray2;
                JSONObject jSONObject = new JSONObject();
                if (facebookPhonebookContact.name != null) {
                    jSONObject.put("name", facebookPhonebookContact.name);
                }
                List<String> list2 = facebookPhonebookContact.f14124b;
                if (list2 != null && list2.size() > 0) {
                    jSONArray2 = new JSONArray();
                    for (String put : list2) {
                        jSONArray2.put(put);
                    }
                    jSONObject.put("emails", jSONArray2);
                }
                list2 = facebookPhonebookContact.f14123a;
                if (list2 != null && list2.size() > 0) {
                    jSONArray2 = new JSONArray();
                    for (String put2 : list2) {
                        jSONArray2.put(put2);
                    }
                    jSONObject.put("phones", jSONArray2);
                }
                if (facebookPhonebookContact.recordId != -1) {
                    jSONObject.put("record_id", String.valueOf(facebookPhonebookContact.recordId));
                }
                if (facebookPhonebookContact.nativeName != null) {
                    jSONObject.put("native_name", facebookPhonebookContact.nativeName);
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            BLog.b(f14122c, StringFormatUtil.formatStrLocaleSafe("How do we get a JSONException when *encoding* data? %s", e.getMessage()));
            return "";
        }
    }

    public final String m23498a() {
        String str = "";
        if (this.email != null) {
            return this.email;
        }
        if (this.phone != null) {
            return this.phone;
        }
        if (this.f14124b != null && !this.f14124b.isEmpty()) {
            return (String) this.f14124b.get(0);
        }
        if (this.f14123a == null || this.f14123a.isEmpty()) {
            return str;
        }
        return (String) this.f14123a.get(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FacebookPhonebookContact facebookPhonebookContact = (FacebookPhonebookContact) obj;
        if (this.isFriend != facebookPhonebookContact.isFriend) {
            return false;
        }
        if (this.ordinal != facebookPhonebookContact.ordinal) {
            return false;
        }
        if (this.recordId != facebookPhonebookContact.recordId) {
            return false;
        }
        if (this.userId != facebookPhonebookContact.userId) {
            return false;
        }
        if (!this.f14124b.equals(facebookPhonebookContact.f14124b)) {
            return false;
        }
        if (!this.name.equals(facebookPhonebookContact.name)) {
            return false;
        }
        if (this.f14123a.equals(facebookPhonebookContact.f14123a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.name, Long.valueOf(this.recordId), Long.valueOf(this.userId), Boolean.valueOf(this.isFriend), Long.valueOf(this.ordinal), this.f14123a, this.f14124b});
    }
}

package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.concurrent.Immutable;
import org.apache.http.message.BasicNameValuePair;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = MinutiaeTagDeserializer.class)
@Immutable
@JsonSerialize(using = MinutiaeTagSerializer.class)
/* compiled from: TIMELINE_LHC */
public class MinutiaeTag implements Parcelable {
    public static final Creator<MinutiaeTag> CREATOR = new C13371();
    public static final MinutiaeTag f13999a = new MinutiaeTag(null, null, null, null, false, null);
    public static final MinutiaeTag f14000b = new MinutiaeTag("0", null, null, null, false, null);
    @JsonProperty("og_action_type_id")
    public final String ogActionTypeId;
    @JsonProperty("oh_hide_attachment")
    public final boolean ogHideAttachment;
    @JsonProperty("og_icon_id")
    public final String ogIconId;
    @JsonProperty("og_object_id")
    public final String ogObjectId;
    @JsonProperty("og_phrase")
    public final String ogPhrase;
    @JsonProperty("og_suggestion_mechanism")
    public final String ogSuggestionMechanism;

    /* compiled from: TIMELINE_LHC */
    final class C13371 implements Creator<MinutiaeTag> {
        C13371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MinutiaeTag(parcel);
        }

        public final Object[] newArray(int i) {
            return new MinutiaeTag[0];
        }
    }

    public MinutiaeTag() {
        this.ogActionTypeId = null;
        this.ogObjectId = null;
        this.ogPhrase = null;
        this.ogIconId = null;
        this.ogHideAttachment = false;
        this.ogSuggestionMechanism = null;
    }

    private MinutiaeTag(String str, String str2, String str3, String str4, boolean z, String str5) {
        this.ogActionTypeId = str;
        this.ogObjectId = str2;
        this.ogPhrase = str3;
        this.ogIconId = str4;
        this.ogHideAttachment = z;
        this.ogSuggestionMechanism = str5;
    }

    public static MinutiaeTag m23381a(String str, String str2, String str3, String str4) {
        return new MinutiaeTag(str, str2, null, str3, false, str4);
    }

    public static MinutiaeTag m23382b(String str, String str2, String str3, String str4) {
        return new MinutiaeTag(str, str2, null, str3, true, str4);
    }

    public static MinutiaeTag m23383c(String str, String str2, String str3, String str4) {
        return new MinutiaeTag(str, null, str2, str3, false, str4);
    }

    public MinutiaeTag(Parcel parcel) {
        this.ogActionTypeId = parcel.readString();
        this.ogObjectId = parcel.readString();
        this.ogPhrase = parcel.readString();
        this.ogIconId = parcel.readString();
        this.ogHideAttachment = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.ogSuggestionMechanism = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ogActionTypeId);
        parcel.writeString(this.ogObjectId);
        parcel.writeString(this.ogPhrase);
        parcel.writeString(this.ogIconId);
        parcel.writeValue(Boolean.valueOf(this.ogHideAttachment));
        parcel.writeString(this.ogSuggestionMechanism);
    }

    public final ImmutableList<BasicNameValuePair> m23384a() {
        Builder builder = new Builder();
        if (this.ogActionTypeId != null) {
            builder.c(new BasicNameValuePair("og_action_type_id", this.ogActionTypeId));
        }
        if (this.ogObjectId != null) {
            builder.c(new BasicNameValuePair("og_object_id", this.ogObjectId));
        }
        if (this.ogPhrase != null) {
            builder.c(new BasicNameValuePair("og_phrase", this.ogPhrase));
        }
        if (this.ogIconId != null) {
            builder.c(new BasicNameValuePair("og_icon_id", this.ogIconId));
        }
        if (this.ogHideAttachment) {
            builder.c(new BasicNameValuePair("og_hide_object_attachment", "true"));
        }
        if (this.ogSuggestionMechanism != null) {
            builder.c(new BasicNameValuePair("og_suggestion_mechanism", this.ogSuggestionMechanism));
        }
        return builder.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MinutiaeTag minutiaeTag = (MinutiaeTag) obj;
        if (Objects.equal(this.ogActionTypeId, minutiaeTag.ogActionTypeId) && Objects.equal(this.ogObjectId, minutiaeTag.ogObjectId) && Objects.equal(this.ogPhrase, minutiaeTag.ogPhrase) && Objects.equal(this.ogIconId, minutiaeTag.ogIconId) && Objects.equal(Boolean.valueOf(this.ogHideAttachment), Boolean.valueOf(minutiaeTag.ogHideAttachment))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.ogActionTypeId, this.ogObjectId, this.ogPhrase, this.ogIconId, Boolean.valueOf(this.ogHideAttachment)});
    }
}

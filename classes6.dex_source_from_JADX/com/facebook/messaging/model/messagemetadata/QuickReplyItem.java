package com.facebook.messaging.model.messagemetadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONArray;
import org.json.JSONException;

@Immutable
/* compiled from: upsell_dialog_cancel */
public class QuickReplyItem implements Parcelable {
    public static final Creator<QuickReplyItem> CREATOR = new C00871();
    @Nullable
    public final String f1946a;
    @Nullable
    public final Type f1947b;
    @Nullable
    public final String f1948c;

    /* compiled from: upsell_dialog_cancel */
    final class C00871 implements Creator<QuickReplyItem> {
        C00871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickReplyItem(parcel.readString(), Type.fromDbValue(parcel.readString()), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new QuickReplyItem[i];
        }
    }

    /* compiled from: upsell_dialog_cancel */
    public enum Type {
        TEXT("TEXT"),
        M("M");
        
        public final String dbValue;

        private Type(String str) {
            this.dbValue = str;
        }

        @Nullable
        public static Type fromDbValue(String str) {
            if (Strings.isNullOrEmpty(str)) {
                return null;
            }
            for (Type type : values()) {
                if (Objects.equal(type.dbValue, str.toUpperCase())) {
                    return type;
                }
            }
            return null;
        }
    }

    public QuickReplyItem(@Nullable String str, @Nullable Type type, @Nullable String str2) {
        this.f1946a = str;
        this.f1947b = type;
        this.f1948c = str2;
    }

    @Nullable
    public static QuickReplyItem m3299a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            return null;
        }
        Type fromDbValue = Type.fromDbValue(str2);
        if (fromDbValue != null) {
            return new QuickReplyItem(str, fromDbValue, str3);
        }
        return null;
    }

    public static ImmutableList<QuickReplyItem> m3300a(String str) {
        if (StringUtil.a(str)) {
            return ImmutableList.of();
        }
        Builder builder = ImmutableList.builder();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                QuickReplyItem a = m3299a(jSONArray.getString(i), "M", null);
                if (a != null) {
                    builder.c(a);
                }
            }
        } catch (JSONException e) {
        }
        return builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1946a);
        parcel.writeString(this.f1947b == null ? "" : this.f1947b.dbValue);
        parcel.writeString(this.f1948c);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1946a, this.f1947b, this.f1948c});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QuickReplyItem)) {
            return false;
        }
        QuickReplyItem quickReplyItem = (QuickReplyItem) obj;
        if (Objects.equal(this.f1946a, quickReplyItem.f1946a) && Objects.equal(this.f1947b, quickReplyItem.f1947b) && Objects.equal(this.f1948c, quickReplyItem.f1948c)) {
            return true;
        }
        return false;
    }
}

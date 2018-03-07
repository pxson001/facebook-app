package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: stickerParams */
public class ReportPrivacyCheckupActionsParams implements Parcelable {
    public static final Creator<ReportPrivacyCheckupActionsParams> CREATOR = new C02411();
    public ImmutableList<PrivacyCheckupItem> f4176a;
    public final String f4177b;
    public final long f4178c;

    /* compiled from: stickerParams */
    final class C02411 implements Creator<ReportPrivacyCheckupActionsParams> {
        C02411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportPrivacyCheckupActionsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportPrivacyCheckupActionsParams[i];
        }
    }

    /* compiled from: stickerParams */
    public enum PrivacyCheckupAction {
        DELETE_APP_ONLY("delete_app_only"),
        DELETE_APP_AND_POSTS("delete_app_and_posts"),
        CHANGE_PRIVACY("change_privacy");
        
        private final String actionName;

        private PrivacyCheckupAction(String str) {
            this.actionName = str;
        }

        public final String toString() {
            return this.actionName;
        }
    }

    /* compiled from: stickerParams */
    public enum PrivacyCheckupEvent {
        MUTATION("mutation"),
        INTRO_STEP_EXPOSED("intro_step_exposed"),
        COMPOSER_STEP_EXPOSED("composer_step_exposed"),
        PROFILE_STEP_EXPOSED("profile_step_exposed"),
        APP_STEP_EXPOSED("app_step_exposed"),
        REVIEW_STEP_EXPOSED("review_step_exposed"),
        INTRO_STEP_CLOSED("intro_step_closed"),
        REVIEW_STEP_CLOSED("review_step_closed");
        
        private final String eventName;

        private PrivacyCheckupEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    /* compiled from: stickerParams */
    public class PrivacyCheckupItem implements Parcelable {
        public static final Creator<PrivacyCheckupItem> CREATOR = new C02421();
        public PrivacyCheckupEvent f4169a;
        public Long f4170b;
        @Nullable
        public String f4171c;
        @Nullable
        public GraphQLEditablePrivacyScopeType f4172d;
        @Nullable
        public PrivacyCheckupAction f4173e;
        @Nullable
        public String f4174f;
        @Nullable
        public String f4175g;

        /* compiled from: stickerParams */
        final class C02421 implements Creator<PrivacyCheckupItem> {
            C02421() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PrivacyCheckupItem(parcel);
            }

            public final Object[] newArray(int i) {
                return new PrivacyCheckupItem[i];
            }
        }

        /* compiled from: stickerParams */
        public class Builder {
            public PrivacyCheckupEvent f4162a;
            public Long f4163b;
            public String f4164c;
            public GraphQLEditablePrivacyScopeType f4165d;
            public PrivacyCheckupAction f4166e;
            public String f4167f;
            public String f4168g;

            public final PrivacyCheckupItem m6119a() {
                return new PrivacyCheckupItem(this.f4162a, this.f4163b, this.f4164c, this.f4165d, this.f4166e, this.f4167f, this.f4168g);
            }
        }

        private PrivacyCheckupItem(PrivacyCheckupEvent privacyCheckupEvent, Long l, @Nullable String str, @Nullable GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType, @Nullable PrivacyCheckupAction privacyCheckupAction, @Nullable String str2, @Nullable String str3) {
            this.f4169a = privacyCheckupEvent;
            this.f4170b = l;
            this.f4171c = str;
            this.f4172d = graphQLEditablePrivacyScopeType;
            this.f4173e = privacyCheckupAction;
            this.f4174f = str2;
            this.f4175g = str3;
        }

        public PrivacyCheckupItem(Parcel parcel) {
            String str = null;
            this.f4169a = PrivacyCheckupEvent.valueOf(parcel.readString().toUpperCase(Locale.US));
            this.f4170b = Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            if (StringUtil.a(readString)) {
                readString = null;
            }
            this.f4171c = readString;
            Object readString2 = parcel.readString();
            this.f4172d = StringUtil.a(readString2) ? null : GraphQLEditablePrivacyScopeType.valueOf(readString2.toUpperCase(Locale.US));
            readString2 = parcel.readString();
            this.f4173e = StringUtil.a(readString2) ? null : PrivacyCheckupAction.valueOf(readString2.toUpperCase(Locale.US));
            readString = parcel.readString();
            if (StringUtil.a(readString)) {
                readString = null;
            }
            this.f4174f = readString;
            CharSequence readString3 = parcel.readString();
            if (!StringUtil.a(readString3)) {
                CharSequence charSequence = readString3;
            }
            this.f4175g = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4169a.toString());
            parcel.writeLong(this.f4170b.longValue());
            parcel.writeString(this.f4171c == null ? "" : this.f4171c);
            parcel.writeString(this.f4172d == null ? "" : this.f4172d.toString());
            parcel.writeString(this.f4173e == null ? "" : this.f4173e.toString());
            parcel.writeString(this.f4174f == null ? "" : this.f4174f);
            parcel.writeString(this.f4175g == null ? "" : this.f4175g);
        }

        public int describeContents() {
            return 0;
        }

        public final String m6120a() {
            Map hashMap = new HashMap();
            hashMap.put("event", this.f4169a.toString());
            hashMap.put("client_time", this.f4170b.toString());
            if (!StringUtil.a(this.f4171c)) {
                hashMap.put("fbid", this.f4171c);
            }
            if (this.f4172d != null) {
                hashMap.put("type", this.f4172d.toString());
            }
            if (this.f4173e != null) {
                hashMap.put("action", this.f4173e.toString());
            }
            if (!StringUtil.a(this.f4174f)) {
                hashMap.put("privacy", this.f4174f);
            }
            if (!StringUtil.a(this.f4175g)) {
                hashMap.put("source", this.f4175g);
            }
            return new JSONObject(hashMap).toString();
        }
    }

    public ReportPrivacyCheckupActionsParams(ImmutableList<PrivacyCheckupItem> immutableList, String str, long j) {
        this.f4176a = immutableList;
        this.f4177b = str;
        this.f4178c = j;
    }

    public ReportPrivacyCheckupActionsParams(Parcel parcel) {
        int readInt = parcel.readInt();
        Builder builder = new Builder();
        for (int i = 0; i < readInt; i++) {
            builder.c((PrivacyCheckupItem) parcel.readParcelable(PrivacyCheckupItem.class.getClassLoader()));
        }
        this.f4176a = builder.b();
        this.f4177b = parcel.readString();
        this.f4178c = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4176a.size());
        int size = this.f4176a.size();
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((PrivacyCheckupItem) this.f4176a.get(i2), i);
        }
        parcel.writeString(this.f4177b);
        parcel.writeLong(this.f4178c);
    }

    public int describeContents() {
        return 0;
    }
}

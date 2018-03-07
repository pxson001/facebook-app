package com.facebook.growth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: p2p_remove_card_fail */
public class FriendFinderMethod implements ApiMethod<Params, Result> {

    /* compiled from: p2p_remove_card_fail */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C08361();
        public final List<FacebookPhonebookContact> f7507a;
        public final String f7508b;
        public final int f7509c;
        public final CIFlow f7510d;
        public final String f7511e;
        public final int f7512f;
        public final int f7513g;
        public final int f7514h;
        public final int f7515i;

        /* compiled from: p2p_remove_card_fail */
        final class C08361 implements Creator<Params> {
            C08361() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(List<FacebookPhonebookContact> list, String str, int i, CIFlow cIFlow, String str2, int i2, int i3, int i4, int i5) {
            this.f7507a = list;
            this.f7508b = str;
            this.f7509c = i;
            this.f7510d = cIFlow;
            this.f7511e = str2;
            this.f7512f = i2;
            this.f7513g = i3;
            this.f7514h = i4;
            this.f7515i = i5;
        }

        public Params(Parcel parcel) {
            this.f7507a = Lists.a();
            parcel.readTypedList(this.f7507a, FacebookPhonebookContact.CREATOR);
            this.f7508b = parcel.readString();
            this.f7509c = parcel.readInt();
            this.f7510d = (CIFlow) parcel.readSerializable();
            this.f7511e = parcel.readString();
            this.f7512f = parcel.readInt();
            this.f7513g = parcel.readInt();
            this.f7514h = parcel.readInt();
            this.f7515i = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.f7507a);
            parcel.writeString(this.f7508b);
            parcel.writeInt(this.f7509c);
            parcel.writeSerializable(this.f7510d);
            parcel.writeString(this.f7511e);
            parcel.writeInt(this.f7512f);
            parcel.writeInt(this.f7513g);
            parcel.writeInt(this.f7514h);
            parcel.writeInt(this.f7515i);
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FriendFinderMethod_ResultDeserializer.class)
    /* compiled from: p2p_remove_card_fail */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C08371();
        @JsonProperty("friendable")
        private final List<PhonebookLookupResultContact> mContacts;
        @JsonProperty("cursor")
        private final int mCursor;
        @JsonProperty("invitable")
        private final List<Invites> mInvites;

        /* compiled from: p2p_remove_card_fail */
        final class C08371 implements Creator<Result> {
            C08371() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        @AutoGenJsonDeserializer
        @JsonDeserialize(using = FriendFinderMethod_Result_InvitesDeserializer.class)
        /* compiled from: p2p_remove_card_fail */
        public class Invites implements Parcelable {
            public static final Creator<Invites> CREATOR = new C08381();
            @JsonProperty("record_id")
            private final long mRecordId;

            /* compiled from: p2p_remove_card_fail */
            final class C08381 implements Creator<Invites> {
                C08381() {
                }

                public final Object createFromParcel(Parcel parcel) {
                    return new Invites(parcel);
                }

                public final Object[] newArray(int i) {
                    return new Invites[i];
                }
            }

            public Invites() {
                this.mRecordId = 0;
            }

            public Invites(Parcel parcel) {
                this.mRecordId = parcel.readLong();
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeLong(this.mRecordId);
            }

            public final long m7807a() {
                return this.mRecordId;
            }
        }

        public Result() {
            this.mContacts = RegularImmutableList.a;
            this.mInvites = RegularImmutableList.a;
            this.mCursor = -1;
        }

        public Result(Parcel parcel) {
            this.mContacts = Lists.a();
            parcel.readTypedList(this.mContacts, PhonebookLookupResultContact.CREATOR);
            this.mInvites = Lists.a();
            parcel.readTypedList(this.mInvites, Invites.CREATOR);
            this.mCursor = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.mContacts);
            parcel.writeTypedList(this.mInvites);
            parcel.writeInt(this.mCursor);
        }

        public final List<PhonebookLookupResultContact> m7808a() {
            return ImmutableList.copyOf(this.mContacts);
        }

        public final List<Invites> m7809b() {
            return ImmutableList.copyOf(this.mInvites);
        }

        public final int m7810c() {
            return this.mCursor;
        }
    }

    public final ApiRequest m7811a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        String str = params.f7508b;
        if (!StringUtil.a(str)) {
            a.add(new BasicNameValuePair("country_code", str));
        }
        a.add(new BasicNameValuePair("pic_size", Integer.toString(params.f7509c)));
        a.add(new BasicNameValuePair("session_ID", params.f7511e));
        int i = params.f7515i;
        if (i > 0) {
            a.add(new BasicNameValuePair("cursor", Integer.toString(i)));
        } else {
            a.add(new BasicNameValuePair("contacts", FacebookPhonebookContact.a(ImmutableList.copyOf(params.f7507a))));
        }
        CIFlow cIFlow = params.f7510d;
        if (!(cIFlow == null || cIFlow.equals(CIFlow.UNKNOWN))) {
            a.add(new BasicNameValuePair("flow", cIFlow.value));
        }
        a.add(new BasicNameValuePair("batch_index", Integer.toString(params.f7512f)));
        i = params.f7513g;
        if (i > 0) {
            a.add(new BasicNameValuePair("batch_size", Integer.toString(i)));
        }
        i = params.f7514h;
        if (i > 0) {
            a.add(new BasicNameValuePair("pagination_size", Integer.toString(i)));
        }
        return new ApiRequest("FriendFinderMobile", "POST", "method/friendfinder.mobile", a, ApiResponseType.JSONPARSER);
    }

    public final Object m7812a(Object obj, ApiResponse apiResponse) {
        return (Result) apiResponse.d().a(Result.class);
    }
}

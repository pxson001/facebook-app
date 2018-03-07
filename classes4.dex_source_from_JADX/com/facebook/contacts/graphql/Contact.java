package com.facebook.contacts.graphql;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel.NameEntriesModel;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.user.model.Name;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ContactDeserializer.class)
@Immutable
@JsonSerialize(using = ContactSerializer.class)
/* compiled from: recent_search_cache_tag */
public class Contact implements Parcelable, Postprocessable<Contact> {
    public static final Creator<Contact> CREATOR = new C01711();
    @JsonProperty("addedTime")
    final long mAddedTimeInMS;
    @JsonProperty("bigPictureSize")
    final int mBigPictureSize;
    @JsonProperty("bigPictureUrl")
    final String mBigPictureUrl;
    @JsonProperty("birthdayDay")
    final int mBirthdayDay;
    @JsonProperty("birthdayMonth")
    final int mBirthdayMonth;
    @JsonProperty("canMessage")
    final boolean mCanMessage;
    @JsonProperty("canSeeViewerMontageThread")
    final boolean mCanSeeViewerMontageThread;
    @JsonProperty("cityName")
    final String mCityName;
    @JsonProperty("communicationRank")
    final float mCommunicationRank;
    @JsonProperty("contactId")
    final String mContactId;
    @JsonProperty("contactType")
    final ContactProfileType mContactProfileType;
    @JsonProperty("friendshipStatus")
    final GraphQLFriendshipStatus mFriendshipStatus;
    @JsonProperty("graphApiWriteId")
    final String mGraphApiWriteId;
    @JsonProperty("hugePictureSize")
    final int mHugePictureSize;
    @JsonProperty("hugePictureUrl")
    final String mHugePictureUrl;
    @JsonProperty("isMemorialized")
    final boolean mIsMemorialized;
    @JsonProperty("isMessageBlockedByViewer")
    final boolean mIsMessageBlockedByViewer;
    @JsonProperty("isMessengerUser")
    final boolean mIsMessengerUser;
    @JsonProperty("isMobilePushable")
    final TriState mIsMobilePushable;
    @JsonProperty("isOnViewerContactList")
    final boolean mIsOnViewerContactList;
    @JsonProperty("isPartial")
    final boolean mIsPartial;
    @JsonProperty("lastFetchTime")
    final long mLastFetchTime;
    @JsonProperty("messengerInstallTime")
    final long mMessengerInstallTimeInMS;
    @JsonProperty("messengerInvitePriority")
    final float mMessengerInvitePriority;
    @JsonProperty("montageThreadFBID")
    final long mMontageThreadFBID;
    @JsonProperty("name")
    final Name mName;
    @JsonProperty("nameEntries")
    final ImmutableList<NameEntriesModel> mNameEntries;
    @JsonProperty("nameSearchTokens")
    final ImmutableList<String> mNameSearchTokens;
    @JsonProperty("phatRank")
    final float mPhatRank;
    @JsonProperty("phones")
    final ImmutableList<ContactPhone> mPhones;
    @JsonProperty("phoneticName")
    final Name mPhoneticName;
    @JsonProperty("profileFbid")
    final String mProfileFbid;
    @JsonProperty("smallPictureSize")
    final int mSmallPictureSize;
    @JsonProperty("smallPictureUrl")
    final String mSmallPictureUrl;
    @JsonProperty("subscribeStatus")
    final GraphQLSubscribeStatus mSubscribeStatus;
    @JsonProperty("timelineCoverPhoto")
    final ContactGraphQLModels$CoverPhotoModel mTimelineCoverPhoto;
    @JsonProperty("username")
    final String mUsername;
    @JsonProperty("withTaggingRank")
    final float mWithTaggingRank;

    /* compiled from: recent_search_cache_tag */
    final class C01711 implements Creator<Contact> {
        C01711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Contact(parcel);
        }

        public final Object[] newArray(int i) {
            return new Contact[i];
        }
    }

    private static Name m4052a(ContactBuilder contactBuilder) {
        if (contactBuilder.f3642d != null) {
            return contactBuilder.f3642d;
        }
        return new Name(contactBuilder.f3644f, contactBuilder.f3645g, contactBuilder.f3643e);
    }

    Contact(ContactBuilder contactBuilder) {
        ContactProfileType contactProfileType;
        this.mContactId = contactBuilder.f3639a;
        this.mProfileFbid = contactBuilder.f3640b;
        this.mGraphApiWriteId = contactBuilder.f3641c;
        this.mName = m4052a(contactBuilder);
        this.mPhoneticName = contactBuilder.f3646h;
        this.mSmallPictureUrl = contactBuilder.f3647i;
        this.mBigPictureUrl = contactBuilder.f3648j;
        this.mHugePictureUrl = contactBuilder.f3649k;
        this.mSmallPictureSize = contactBuilder.f3650l;
        this.mBigPictureSize = contactBuilder.f3651m;
        this.mHugePictureSize = contactBuilder.f3652n;
        this.mCommunicationRank = contactBuilder.f3653o;
        this.mWithTaggingRank = contactBuilder.f3654p;
        this.mPhones = contactBuilder.f3655q;
        this.mIsMessageBlockedByViewer = contactBuilder.f3656r;
        this.mCanMessage = contactBuilder.f3657s;
        this.mIsMobilePushable = contactBuilder.f3660v;
        this.mIsMessengerUser = contactBuilder.f3661w;
        this.mMessengerInstallTimeInMS = contactBuilder.f3662x;
        this.mIsMemorialized = contactBuilder.f3663y;
        this.mIsOnViewerContactList = contactBuilder.f3664z;
        this.mFriendshipStatus = contactBuilder.f3658t;
        this.mSubscribeStatus = contactBuilder.f3659u;
        if (contactBuilder.f3624A != null) {
            contactProfileType = contactBuilder.f3624A;
        } else {
            contactProfileType = ContactProfileType.UNMATCHED;
        }
        this.mContactProfileType = contactProfileType;
        this.mTimelineCoverPhoto = contactBuilder.f3625B;
        this.mNameEntries = contactBuilder.f3626C;
        this.mNameSearchTokens = contactBuilder.f3627D;
        this.mAddedTimeInMS = contactBuilder.f3628E;
        this.mBirthdayDay = contactBuilder.f3630G;
        this.mBirthdayMonth = contactBuilder.f3629F;
        this.mCityName = contactBuilder.f3631H;
        this.mIsPartial = contactBuilder.f3632I;
        this.mLastFetchTime = contactBuilder.f3633J;
        this.mMontageThreadFBID = contactBuilder.f3634K;
        this.mCanSeeViewerMontageThread = contactBuilder.f3635L;
        this.mPhatRank = contactBuilder.f3636M;
        this.mUsername = contactBuilder.f3637N;
        this.mMessengerInvitePriority = contactBuilder.f3638O;
        m4051O();
    }

    public Contact(Parcel parcel) {
        this.mContactId = parcel.readString();
        this.mProfileFbid = parcel.readString();
        this.mGraphApiWriteId = parcel.readString();
        this.mName = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.mPhoneticName = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.mSmallPictureUrl = parcel.readString();
        this.mBigPictureUrl = parcel.readString();
        this.mHugePictureUrl = parcel.readString();
        this.mSmallPictureSize = parcel.readInt();
        this.mBigPictureSize = parcel.readInt();
        this.mHugePictureSize = parcel.readInt();
        this.mCommunicationRank = parcel.readFloat();
        this.mWithTaggingRank = parcel.readFloat();
        this.mPhones = ImmutableList.copyOf(parcel.readArrayList(ContactPhone.class.getClassLoader()));
        this.mIsMessageBlockedByViewer = ParcelUtil.a(parcel);
        this.mCanMessage = ParcelUtil.a(parcel);
        this.mIsMobilePushable = (TriState) Enum.valueOf(TriState.class, parcel.readString());
        this.mIsMessengerUser = ParcelUtil.a(parcel);
        this.mMessengerInstallTimeInMS = parcel.readLong();
        this.mIsMemorialized = ParcelUtil.a(parcel);
        this.mIsOnViewerContactList = ParcelUtil.a(parcel);
        this.mFriendshipStatus = (GraphQLFriendshipStatus) parcel.readSerializable();
        this.mSubscribeStatus = (GraphQLSubscribeStatus) parcel.readSerializable();
        this.mContactProfileType = (ContactProfileType) Enum.valueOf(ContactProfileType.class, parcel.readString());
        this.mTimelineCoverPhoto = (ContactGraphQLModels$CoverPhotoModel) FlatBufferModelHelper.a(parcel);
        this.mNameEntries = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
        this.mNameSearchTokens = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
        this.mAddedTimeInMS = parcel.readLong();
        this.mBirthdayMonth = parcel.readInt();
        this.mBirthdayDay = parcel.readInt();
        this.mCityName = parcel.readString();
        this.mIsPartial = ParcelUtil.a(parcel);
        this.mLastFetchTime = parcel.readLong();
        this.mMontageThreadFBID = parcel.readLong();
        this.mCanSeeViewerMontageThread = ParcelUtil.a(parcel);
        this.mPhatRank = parcel.readFloat();
        this.mUsername = parcel.readString();
        this.mMessengerInvitePriority = parcel.readFloat();
    }

    private Contact() {
        this.mContactId = null;
        this.mProfileFbid = null;
        this.mGraphApiWriteId = null;
        this.mName = null;
        this.mPhoneticName = null;
        this.mSmallPictureUrl = null;
        this.mBigPictureUrl = null;
        this.mHugePictureUrl = null;
        this.mSmallPictureSize = -1;
        this.mBigPictureSize = -1;
        this.mHugePictureSize = -1;
        this.mCommunicationRank = 0.0f;
        this.mWithTaggingRank = 0.0f;
        this.mPhones = null;
        this.mIsMessageBlockedByViewer = false;
        this.mCanMessage = false;
        this.mIsMobilePushable = null;
        this.mIsMessengerUser = false;
        this.mMessengerInstallTimeInMS = 0;
        this.mIsMemorialized = false;
        this.mIsOnViewerContactList = false;
        this.mFriendshipStatus = null;
        this.mSubscribeStatus = null;
        this.mContactProfileType = ContactProfileType.UNMATCHED;
        this.mTimelineCoverPhoto = null;
        this.mNameEntries = null;
        this.mNameSearchTokens = null;
        this.mAddedTimeInMS = 0;
        this.mBirthdayMonth = 0;
        this.mBirthdayDay = 0;
        this.mCityName = null;
        this.mIsPartial = false;
        this.mLastFetchTime = 0;
        this.mMontageThreadFBID = 0;
        this.mCanSeeViewerMontageThread = false;
        this.mPhatRank = 0.0f;
        this.mUsername = null;
        this.mMessengerInvitePriority = 0.0f;
    }

    public final Object m4066a() {
        m4051O();
        return this;
    }

    private void m4051O() {
        Preconditions.checkNotNull(this.mName);
        if (this.mCanMessage) {
            Preconditions.checkNotNull(this.mProfileFbid, "if contact.canMessage, fbid cannot be null");
        }
        if (this.mProfileFbid == null) {
            Preconditions.checkArgument(this.mContactProfileType == ContactProfileType.UNMATCHED, "If contact has not fbid its profile type must be UNMATCHED");
        }
    }

    public static ContactBuilder newBuilder() {
        return new ContactBuilder();
    }

    public final String m4067b() {
        return this.mContactId;
    }

    public final String m4068c() {
        return this.mProfileFbid;
    }

    public final String m4069d() {
        return this.mGraphApiWriteId;
    }

    public final Name m4070e() {
        return this.mName;
    }

    public final Name m4071f() {
        return this.mPhoneticName;
    }

    public final String m4072g() {
        return this.mSmallPictureUrl;
    }

    public final String m4073h() {
        return this.mBigPictureUrl;
    }

    public final String m4074i() {
        return this.mHugePictureUrl;
    }

    public final int m4075j() {
        return this.mSmallPictureSize;
    }

    public final int m4076k() {
        return this.mBigPictureSize;
    }

    public final int m4077l() {
        return this.mHugePictureSize;
    }

    public final float m4078m() {
        return this.mCommunicationRank;
    }

    public final float m4079n() {
        return this.mWithTaggingRank;
    }

    public final ImmutableList<ContactPhone> m4080o() {
        return this.mPhones;
    }

    public final boolean m4081p() {
        return this.mIsMessageBlockedByViewer;
    }

    public final boolean m4082q() {
        return this.mCanMessage;
    }

    public final TriState m4083r() {
        return this.mIsMobilePushable;
    }

    public final boolean m4084s() {
        return this.mIsMessengerUser;
    }

    public final long m4085t() {
        return this.mMessengerInstallTimeInMS;
    }

    public final boolean m4086u() {
        return this.mIsMemorialized;
    }

    public final boolean m4087v() {
        return this.mIsOnViewerContactList;
    }

    public final long m4088w() {
        return this.mAddedTimeInMS;
    }

    public final GraphQLFriendshipStatus m4089x() {
        return this.mFriendshipStatus;
    }

    public final GraphQLSubscribeStatus m4090y() {
        return this.mSubscribeStatus;
    }

    public final ImmutableList<String> m4091z() {
        return this.mNameSearchTokens;
    }

    public final ContactProfileType m4053A() {
        return this.mContactProfileType;
    }

    public final ContactGraphQLModels$CoverPhotoModel m4054B() {
        return this.mTimelineCoverPhoto;
    }

    public final ImmutableList<NameEntriesModel> m4055C() {
        return this.mNameEntries;
    }

    public final int m4056D() {
        return this.mBirthdayDay;
    }

    public final int m4057E() {
        return this.mBirthdayMonth;
    }

    public final boolean m4058F() {
        return this.mIsPartial;
    }

    public final long m4059G() {
        return this.mLastFetchTime;
    }

    public final String m4060H() {
        return this.mCityName;
    }

    public final long m4061I() {
        return this.mMontageThreadFBID;
    }

    public final boolean m4062J() {
        return this.mCanSeeViewerMontageThread;
    }

    public final float m4063K() {
        return this.mPhatRank;
    }

    public final String m4064L() {
        return this.mUsername;
    }

    public final float m4065M() {
        return this.mMessengerInvitePriority;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mContactId);
        parcel.writeString(this.mProfileFbid);
        parcel.writeString(this.mGraphApiWriteId);
        parcel.writeParcelable(this.mName, i);
        parcel.writeParcelable(this.mPhoneticName, i);
        parcel.writeString(this.mSmallPictureUrl);
        parcel.writeString(this.mBigPictureUrl);
        parcel.writeString(this.mHugePictureUrl);
        parcel.writeInt(this.mSmallPictureSize);
        parcel.writeInt(this.mBigPictureSize);
        parcel.writeInt(this.mHugePictureSize);
        parcel.writeFloat(this.mCommunicationRank);
        parcel.writeFloat(this.mWithTaggingRank);
        parcel.writeList(this.mPhones);
        ParcelUtil.a(parcel, this.mIsMessageBlockedByViewer);
        ParcelUtil.a(parcel, this.mCanMessage);
        parcel.writeString(this.mIsMobilePushable.toString());
        ParcelUtil.a(parcel, this.mIsMessengerUser);
        parcel.writeLong(this.mMessengerInstallTimeInMS);
        ParcelUtil.a(parcel, this.mIsMemorialized);
        ParcelUtil.a(parcel, this.mIsOnViewerContactList);
        parcel.writeSerializable(this.mFriendshipStatus);
        parcel.writeSerializable(this.mSubscribeStatus);
        parcel.writeString(this.mContactProfileType.toString());
        FlatBufferModelHelper.a(parcel, this.mTimelineCoverPhoto);
        FlatBufferModelHelper.a(parcel, this.mNameEntries);
        parcel.writeList(this.mNameSearchTokens);
        parcel.writeLong(this.mAddedTimeInMS);
        parcel.writeInt(this.mBirthdayMonth);
        parcel.writeInt(this.mBirthdayDay);
        parcel.writeString(this.mCityName);
        ParcelUtil.a(parcel, this.mIsPartial);
        parcel.writeLong(this.mLastFetchTime);
        parcel.writeLong(this.mMontageThreadFBID);
        ParcelUtil.a(parcel, this.mCanSeeViewerMontageThread);
        parcel.writeFloat(this.mPhatRank);
        parcel.writeString(this.mUsername);
        parcel.writeFloat(this.mMessengerInvitePriority);
    }

    public String toString() {
        return m4070e() + " (phonetic name: " + m4071f() + ") <contactId:" + m4067b() + "> <profileFbid:" + m4068c() + "> <commRank:" + m4078m() + "> <canMessage:" + m4082q() + "> <isMemorialized:" + this.mIsMemorialized + "><contactType:" + this.mContactProfileType + ">";
    }
}

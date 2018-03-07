package com.facebook.contacts.graphql;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: rear_camera */
public class ContactSerializer extends JsonSerializer<Contact> {
    public final void m4176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Contact contact = (Contact) obj;
        if (contact == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4175b(contact, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(Contact.class, new ContactSerializer());
    }

    private static void m4175b(Contact contact, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10234a(jsonGenerator, "contactId", contact.mContactId);
        AutoGenJsonHelper.m10234a(jsonGenerator, "profileFbid", contact.mProfileFbid);
        AutoGenJsonHelper.m10234a(jsonGenerator, "graphApiWriteId", contact.mGraphApiWriteId);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "name", contact.mName);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "phoneticName", contact.mPhoneticName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "smallPictureUrl", contact.mSmallPictureUrl);
        AutoGenJsonHelper.m10234a(jsonGenerator, "bigPictureUrl", contact.mBigPictureUrl);
        AutoGenJsonHelper.m10234a(jsonGenerator, "hugePictureUrl", contact.mHugePictureUrl);
        AutoGenJsonHelper.m10232a(jsonGenerator, "smallPictureSize", Integer.valueOf(contact.mSmallPictureSize));
        AutoGenJsonHelper.m10232a(jsonGenerator, "bigPictureSize", Integer.valueOf(contact.mBigPictureSize));
        AutoGenJsonHelper.m10232a(jsonGenerator, "hugePictureSize", Integer.valueOf(contact.mHugePictureSize));
        AutoGenJsonHelper.m10231a(jsonGenerator, "communicationRank", Float.valueOf(contact.mCommunicationRank));
        AutoGenJsonHelper.m10231a(jsonGenerator, "withTaggingRank", Float.valueOf(contact.mWithTaggingRank));
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "phones", contact.mPhones);
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "nameSearchTokens", contact.mNameSearchTokens);
        AutoGenJsonHelper.m10229a(jsonGenerator, "isMessageBlockedByViewer", Boolean.valueOf(contact.mIsMessageBlockedByViewer));
        AutoGenJsonHelper.m10229a(jsonGenerator, "canMessage", Boolean.valueOf(contact.mCanMessage));
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "isMobilePushable", contact.mIsMobilePushable);
        AutoGenJsonHelper.m10229a(jsonGenerator, "isMessengerUser", Boolean.valueOf(contact.mIsMessengerUser));
        AutoGenJsonHelper.m10233a(jsonGenerator, "messengerInstallTime", Long.valueOf(contact.mMessengerInstallTimeInMS));
        AutoGenJsonHelper.m10229a(jsonGenerator, "isMemorialized", Boolean.valueOf(contact.mIsMemorialized));
        AutoGenJsonHelper.m10229a(jsonGenerator, "isOnViewerContactList", Boolean.valueOf(contact.mIsOnViewerContactList));
        AutoGenJsonHelper.m10233a(jsonGenerator, "addedTime", Long.valueOf(contact.mAddedTimeInMS));
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "friendshipStatus", contact.mFriendshipStatus);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "subscribeStatus", contact.mSubscribeStatus);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "contactType", contact.mContactProfileType);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "timelineCoverPhoto", contact.mTimelineCoverPhoto);
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "nameEntries", contact.mNameEntries);
        AutoGenJsonHelper.m10232a(jsonGenerator, "birthdayDay", Integer.valueOf(contact.mBirthdayDay));
        AutoGenJsonHelper.m10232a(jsonGenerator, "birthdayMonth", Integer.valueOf(contact.mBirthdayMonth));
        AutoGenJsonHelper.m10234a(jsonGenerator, "cityName", contact.mCityName);
        AutoGenJsonHelper.m10229a(jsonGenerator, "isPartial", Boolean.valueOf(contact.mIsPartial));
        AutoGenJsonHelper.m10233a(jsonGenerator, "lastFetchTime", Long.valueOf(contact.mLastFetchTime));
        AutoGenJsonHelper.m10233a(jsonGenerator, "montageThreadFBID", Long.valueOf(contact.mMontageThreadFBID));
        AutoGenJsonHelper.m10229a(jsonGenerator, "canSeeViewerMontageThread", Boolean.valueOf(contact.mCanSeeViewerMontageThread));
        AutoGenJsonHelper.m10231a(jsonGenerator, "phatRank", Float.valueOf(contact.mPhatRank));
        AutoGenJsonHelper.m10234a(jsonGenerator, "username", contact.mUsername);
        AutoGenJsonHelper.m10231a(jsonGenerator, "messengerInvitePriority", Float.valueOf(contact.mMessengerInvitePriority));
    }
}

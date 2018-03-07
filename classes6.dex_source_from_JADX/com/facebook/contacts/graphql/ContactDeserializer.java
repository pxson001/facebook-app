package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.NameEntriesModel;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: photo_attributions */
public class ContactDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8158a;

    static {
        GlobalAutoGenDeserializerCache.a(Contact.class, new ContactDeserializer());
        m11754e();
    }

    public ContactDeserializer() {
        a(Contact.class);
    }

    private static synchronized Map<String, FbJsonField> m11754e() {
        Map<String, FbJsonField> map;
        synchronized (ContactDeserializer.class) {
            if (f8158a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("contactId", FbJsonField.jsonField(Contact.class.getDeclaredField("mContactId")));
                    builder.b("profileFbid", FbJsonField.jsonField(Contact.class.getDeclaredField("mProfileFbid")));
                    builder.b("graphApiWriteId", FbJsonField.jsonField(Contact.class.getDeclaredField("mGraphApiWriteId")));
                    builder.b("name", FbJsonField.jsonField(Contact.class.getDeclaredField("mName")));
                    builder.b("phoneticName", FbJsonField.jsonField(Contact.class.getDeclaredField("mPhoneticName")));
                    builder.b("smallPictureUrl", FbJsonField.jsonField(Contact.class.getDeclaredField("mSmallPictureUrl")));
                    builder.b("bigPictureUrl", FbJsonField.jsonField(Contact.class.getDeclaredField("mBigPictureUrl")));
                    builder.b("hugePictureUrl", FbJsonField.jsonField(Contact.class.getDeclaredField("mHugePictureUrl")));
                    builder.b("smallPictureSize", FbJsonField.jsonField(Contact.class.getDeclaredField("mSmallPictureSize")));
                    builder.b("bigPictureSize", FbJsonField.jsonField(Contact.class.getDeclaredField("mBigPictureSize")));
                    builder.b("hugePictureSize", FbJsonField.jsonField(Contact.class.getDeclaredField("mHugePictureSize")));
                    builder.b("communicationRank", FbJsonField.jsonField(Contact.class.getDeclaredField("mCommunicationRank")));
                    builder.b("withTaggingRank", FbJsonField.jsonField(Contact.class.getDeclaredField("mWithTaggingRank")));
                    builder.b("phones", FbJsonField.jsonField(Contact.class.getDeclaredField("mPhones"), ContactPhone.class));
                    builder.b("nameSearchTokens", FbJsonField.jsonField(Contact.class.getDeclaredField("mNameSearchTokens"), String.class));
                    builder.b("isMessageBlockedByViewer", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsMessageBlockedByViewer")));
                    builder.b("canMessage", FbJsonField.jsonField(Contact.class.getDeclaredField("mCanMessage")));
                    builder.b("isMobilePushable", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsMobilePushable")));
                    builder.b("isMessengerUser", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsMessengerUser")));
                    builder.b("messengerInstallTime", FbJsonField.jsonField(Contact.class.getDeclaredField("mMessengerInstallTimeInMS")));
                    builder.b("isMemorialized", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsMemorialized")));
                    builder.b("isOnViewerContactList", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsOnViewerContactList")));
                    builder.b("addedTime", FbJsonField.jsonField(Contact.class.getDeclaredField("mAddedTimeInMS")));
                    builder.b("friendshipStatus", FbJsonField.jsonField(Contact.class.getDeclaredField("mFriendshipStatus")));
                    builder.b("subscribeStatus", FbJsonField.jsonField(Contact.class.getDeclaredField("mSubscribeStatus")));
                    builder.b("contactType", FbJsonField.jsonField(Contact.class.getDeclaredField("mContactProfileType")));
                    builder.b("timelineCoverPhoto", FbJsonField.jsonField(Contact.class.getDeclaredField("mTimelineCoverPhoto")));
                    builder.b("nameEntries", FbJsonField.jsonField(Contact.class.getDeclaredField("mNameEntries"), NameEntriesModel.class));
                    builder.b("birthdayDay", FbJsonField.jsonField(Contact.class.getDeclaredField("mBirthdayDay")));
                    builder.b("birthdayMonth", FbJsonField.jsonField(Contact.class.getDeclaredField("mBirthdayMonth")));
                    builder.b("cityName", FbJsonField.jsonField(Contact.class.getDeclaredField("mCityName")));
                    builder.b("isPartial", FbJsonField.jsonField(Contact.class.getDeclaredField("mIsPartial")));
                    builder.b("lastFetchTime", FbJsonField.jsonField(Contact.class.getDeclaredField("mLastFetchTime")));
                    builder.b("montageThreadFBID", FbJsonField.jsonField(Contact.class.getDeclaredField("mMontageThreadFBID")));
                    builder.b("canSeeViewerMontageThread", FbJsonField.jsonField(Contact.class.getDeclaredField("mCanSeeViewerMontageThread")));
                    builder.b("phatRank", FbJsonField.jsonField(Contact.class.getDeclaredField("mPhatRank")));
                    builder.b("username", FbJsonField.jsonField(Contact.class.getDeclaredField("mUsername")));
                    builder.b("messengerInvitePriority", FbJsonField.jsonField(Contact.class.getDeclaredField("mMessengerInvitePriority")));
                    f8158a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8158a;
        }
        return map;
    }

    public final FbJsonField m11755a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11754e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11754e().keySet());
    }
}

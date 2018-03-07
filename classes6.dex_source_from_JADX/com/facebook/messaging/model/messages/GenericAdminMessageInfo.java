package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.graphql.enums.GraphQLMessengerAdPropertyType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: uploaded_videos */
public class GenericAdminMessageInfo implements Parcelable {
    public static final Creator<GenericAdminMessageInfo> CREATOR = new C00901();
    private static final ImmutableBiMap<GraphQLExtensibleMessageAdminTextType, Integer> f1951a;
    public static final ImmutableBiMap<Integer, GraphQLExtensibleMessageAdminTextType> f1952b;
    public final GraphQLExtensibleMessageAdminTextType f1953c;
    public final int f1954d;
    @Nullable
    private final String f1955e;
    @Nullable
    private final String f1956f;
    @Nullable
    public final String f1957g;
    private final int f1958h;
    @Nullable
    public final ImmutableList<String> f1959i;
    @Nullable
    public final ImmutableList<String> f1960j;
    @Nullable
    public final ImmutableList<NicknameChoice> f1961k;
    @Nullable
    public final ImmutableList<BotChoice> f1962l;
    @Nullable
    public String f1963m;
    @Nullable
    public String f1964n;
    public boolean f1965o;
    @Nullable
    public String f1966p;
    @Nullable
    public AdProperties f1967q;
    @Nullable
    public String f1968r;
    private int f1969s;
    public boolean f1970t;
    @Nullable
    private EventReminderProperties f1971u;
    public JoinableEventType f1972v;

    /* compiled from: uploaded_videos */
    final class C00901 implements Creator<GenericAdminMessageInfo> {
        C00901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GenericAdminMessageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GenericAdminMessageInfo[i];
        }
    }

    /* compiled from: uploaded_videos */
    public class AdProperties implements Parcelable {
        public static final Creator<AdProperties> CREATOR = new C00911();
        @JsonProperty("is_offsite_ad")
        public final boolean isOffsiteAd;
        @JsonProperty("preference_link")
        public final String preferenceLink;

        /* compiled from: uploaded_videos */
        final class C00911 implements Creator<AdProperties> {
            C00911() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new AdProperties(parcel);
            }

            public final Object[] newArray(int i) {
                return new AdProperties[i];
            }
        }

        @JsonCreator
        public AdProperties(@JsonProperty("preferenceLink") String str, @JsonProperty("is_offsite_ad") boolean z) {
            this.preferenceLink = str;
            this.isOffsiteAd = z;
        }

        public static AdProperties m3305a(@Nullable String str, @Nullable String str2) {
            boolean z = false;
            if (Strings.isNullOrEmpty(str) && Strings.isNullOrEmpty(str2)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (GraphQLMessengerAdPropertyType.fromString(jSONArray.getString(i)) == GraphQLMessengerAdPropertyType.OFFSITE_AD) {
                        z = true;
                    }
                }
            } catch (JSONException e) {
            }
            return new AdProperties(str, z);
        }

        public AdProperties(Parcel parcel) {
            this.preferenceLink = parcel.readString();
            this.isOffsiteAd = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.preferenceLink);
            parcel.writeInt(this.isOffsiteAd ? 1 : 0);
        }
    }

    /* compiled from: uploaded_videos */
    public class BotChoice implements Parcelable {
        public static final Creator<BotChoice> CREATOR = new C00921();
        @JsonProperty("description")
        public final String description;
        @JsonProperty("icon")
        public final String iconUri;
        @JsonProperty("botID")
        public final long id;
        @JsonProperty("title")
        public final String title;

        /* compiled from: uploaded_videos */
        final class C00921 implements Creator<BotChoice> {
            C00921() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new BotChoice(parcel);
            }

            public final Object[] newArray(int i) {
                return new BotChoice[i];
            }
        }

        @JsonCreator
        public BotChoice(@JsonProperty("botID") long j, @JsonProperty("title") String str, @JsonProperty("description") String str2, @JsonProperty("icon") String str3) {
            this.id = j;
            this.title = str;
            this.description = str2;
            this.iconUri = str3;
        }

        public BotChoice(Parcel parcel) {
            this.id = parcel.readLong();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.iconUri = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.id);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.iconUri);
        }
    }

    /* compiled from: uploaded_videos */
    public class EventReminderProperties implements Parcelable {
        public static final Creator<EventReminderProperties> CREATOR = new C00931();
        @JsonProperty("event_id")
        public final String eventId;
        @JsonProperty("event_time")
        public final String eventTime;
        @JsonProperty("event_title")
        public final String eventTitle;
        @JsonProperty("event_track_rsvp")
        public final String eventTrackRsvp;
        @JsonProperty("guest_id")
        public final String guestId;
        @JsonProperty("guest_status")
        public final String guestStatus;

        /* compiled from: uploaded_videos */
        final class C00931 implements Creator<EventReminderProperties> {
            C00931() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new EventReminderProperties(parcel);
            }

            public final Object[] newArray(int i) {
                return new EventReminderProperties[i];
            }
        }

        @JsonCreator
        public EventReminderProperties(@JsonProperty("event_id") String str, @JsonProperty("event_time") String str2, @JsonProperty("event_title") String str3, @JsonProperty("guest_id") String str4, @JsonProperty("guest_status") String str5, @JsonProperty("event_track_rsvp") String str6) {
            this.eventId = str;
            this.eventTime = str2;
            this.eventTitle = str3;
            this.guestId = str4;
            this.guestStatus = str5;
            this.eventTrackRsvp = str6;
        }

        public static EventReminderProperties m3306a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            if (Strings.isNullOrEmpty(str)) {
                return null;
            }
            return new EventReminderProperties(str, str2, str3, str4, str5, str6);
        }

        public EventReminderProperties(Parcel parcel) {
            this.eventId = parcel.readString();
            this.eventTime = parcel.readString();
            this.eventTitle = parcel.readString();
            this.guestId = parcel.readString();
            this.guestStatus = parcel.readString();
            this.eventTrackRsvp = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.eventId);
            parcel.writeString(this.eventTime);
            parcel.writeString(this.eventTitle);
            parcel.writeString(this.guestId);
            parcel.writeString(this.guestStatus);
            parcel.writeString(this.eventTrackRsvp);
        }
    }

    /* compiled from: uploaded_videos */
    public enum JoinableEventType {
        TURN_ON_JOINABLE_BY_OWNER("turn_on_joinable_by_owner"),
        TURN_ON_JOINABLE_BY_USER("turn_on_joinable_by_user"),
        TURN_OFF_JOINABLE_BY_OWNER("turn_off_joinable_by_owner"),
        TURN_OFF_ON_LAST_OWNER_UNSUBSCRIBED("turn_off_on_last_owner_unsubscribed"),
        TURN_OFF_ON_LAST_OWNER_REMOVED("turn_off_on_last_owner_removed"),
        UNKNOWN("unknown");
        
        private final String serverEventName;

        private JoinableEventType(String str) {
            this.serverEventName = str;
        }

        public final String toDbValue() {
            return this.serverEventName;
        }

        public static JoinableEventType fromValue(@Nullable String str) {
            for (JoinableEventType joinableEventType : values()) {
                if (joinableEventType.serverEventName.equals(str)) {
                    return joinableEventType;
                }
            }
            return UNKNOWN;
        }
    }

    /* compiled from: uploaded_videos */
    public class NicknameChoice implements Parcelable {
        public static final Creator<NicknameChoice> CREATOR = new C00941();
        @JsonProperty("participantId")
        public final String participantId;
        @JsonProperty("suggestions")
        public final ImmutableList<String> suggestions;

        /* compiled from: uploaded_videos */
        final class C00941 implements Creator<NicknameChoice> {
            C00941() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new NicknameChoice(parcel);
            }

            public final Object[] newArray(int i) {
                return new NicknameChoice[i];
            }
        }

        @JsonCreator
        public NicknameChoice(@JsonProperty("participantId") String str, @JsonProperty("suggestions") ImmutableList<String> immutableList) {
            this.participantId = str;
            this.suggestions = immutableList;
        }

        public NicknameChoice(Parcel parcel) {
            this.participantId = parcel.readString();
            this.suggestions = ParcelUtil.h(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.participantId);
            parcel.writeStringList(this.suggestions);
        }

        public int describeContents() {
            return 0;
        }
    }

    static {
        ImmutableBiMap a = ImmutableBiMap.d().a(GraphQLExtensibleMessageAdminTextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE, Integer.valueOf(-1)).a(GraphQLExtensibleMessageAdminTextType.CONFIRM_FRIEND_REQUEST, Integer.valueOf(0)).a(GraphQLExtensibleMessageAdminTextType.ACCEPT_PENDING_THREAD, Integer.valueOf(1)).a(GraphQLExtensibleMessageAdminTextType.RAMP_UP_WELCOME_MESSAGE, Integer.valueOf(2)).a(GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_THEME, Integer.valueOf(3)).a(GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_ICON, Integer.valueOf(4)).a(GraphQLExtensibleMessageAdminTextType.GROUP_THREAD_CREATED, Integer.valueOf(5)).a(GraphQLExtensibleMessageAdminTextType.THREAD_EPHEMERAL_SEND_MODE, Integer.valueOf(6)).a(GraphQLExtensibleMessageAdminTextType.INVITE_ACCEPTED, Integer.valueOf(7)).a(GraphQLExtensibleMessageAdminTextType.MESSENGER_INVITE_SENT, Integer.valueOf(8)).a(GraphQLExtensibleMessageAdminTextType.TURN_ON_PUSH, Integer.valueOf(9)).a(GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_COLOR, Integer.valueOf(10)).a(GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_LIKE, Integer.valueOf(11)).a(GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME, Integer.valueOf(12)).a(GraphQLExtensibleMessageAdminTextType.RIDE_ORDERED_MESSAGE, Integer.valueOf(13)).a(GraphQLExtensibleMessageAdminTextType.RTC_CALL_LOG, Integer.valueOf(14)).a(GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_NICKNAME, Integer.valueOf(15)).a(GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_SETUP, Integer.valueOf(16)).a(GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT, Integer.valueOf(17)).a(GraphQLExtensibleMessageAdminTextType.AD_MANAGE_MESSAGE, Integer.valueOf(18)).a(GraphQLExtensibleMessageAdminTextType.GAME_SCORE, Integer.valueOf(19)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_CREATE, Integer.valueOf(20)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_DELETE, Integer.valueOf(21)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_NOTIFY, Integer.valueOf(22)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE, Integer.valueOf(23)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TIME, Integer.valueOf(24)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TITLE, Integer.valueOf(25)).a(GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_RSVP, Integer.valueOf(26)).a(GraphQLExtensibleMessageAdminTextType.CHANGE_JOINABLE_SETTING, Integer.valueOf(27)).a();
        f1951a = a;
        f1952b = a.e();
    }

    public static GenericAdminMessageInfoBuilder newBuilder() {
        return new GenericAdminMessageInfoBuilder();
    }

    GenericAdminMessageInfo(GraphQLExtensibleMessageAdminTextType graphQLExtensibleMessageAdminTextType, int i, String str, String str2, String str3, int i2, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, ImmutableList<NicknameChoice> immutableList3, ImmutableList<BotChoice> immutableList4, String str4, String str5, boolean z, String str6, AdProperties adProperties, @Nullable String str7, int i3, boolean z2, EventReminderProperties eventReminderProperties, JoinableEventType joinableEventType) {
        this.f1953c = graphQLExtensibleMessageAdminTextType;
        this.f1954d = i;
        this.f1955e = str;
        this.f1956f = str2;
        this.f1957g = str3;
        this.f1958h = i2;
        this.f1959i = immutableList;
        this.f1960j = immutableList2;
        this.f1961k = immutableList3;
        this.f1962l = immutableList4;
        this.f1963m = str4;
        this.f1964n = str5;
        this.f1965o = z;
        this.f1966p = str6;
        this.f1967q = adProperties;
        this.f1968r = str7;
        this.f1969s = i3;
        this.f1970t = z2;
        this.f1971u = eventReminderProperties;
        this.f1972v = joinableEventType;
    }

    public final int m3325a() {
        return (f1951a.containsKey(this.f1953c) ? (Integer) f1951a.get(this.f1953c) : (Integer) f1951a.get(GraphQLExtensibleMessageAdminTextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)).intValue();
    }

    public final boolean m3326c() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_THEME;
    }

    public final boolean m3327d() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_ICON;
    }

    public final boolean m3328e() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.CHANGE_THREAD_NICKNAME;
    }

    public final boolean m3329g() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.THREAD_EPHEMERAL_SEND_MODE;
    }

    public final boolean m3330o() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.RTC_CALL_LOG;
    }

    public final boolean m3331q() {
        return this.f1953c == GraphQLExtensibleMessageAdminTextType.GAME_SCORE;
    }

    public GenericAdminMessageInfo(Parcel parcel) {
        boolean z;
        ImmutableList a;
        boolean z2 = true;
        this.f1953c = (GraphQLExtensibleMessageAdminTextType) parcel.readSerializable();
        this.f1954d = parcel.readInt();
        this.f1955e = parcel.readString();
        this.f1956f = parcel.readString();
        this.f1957g = parcel.readString();
        this.f1958h = parcel.readInt();
        if (parcel.readInt() >= 0) {
            Collection arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f1959i = ImmutableList.copyOf(arrayList);
        } else {
            this.f1959i = null;
        }
        if (parcel.readInt() >= 0) {
            arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f1960j = ImmutableList.copyOf(arrayList);
        } else {
            this.f1960j = null;
        }
        if (parcel.readInt() >= 0) {
            this.f1961k = ParcelUtil.a(parcel, NicknameChoice.CREATOR);
        } else {
            this.f1961k = null;
        }
        if (parcel.readInt() >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            a = ParcelUtil.a(parcel, BotChoice.CREATOR);
        } else {
            a = null;
        }
        this.f1962l = a;
        this.f1963m = parcel.readString();
        this.f1964n = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f1965o = z;
        this.f1966p = parcel.readString();
        this.f1967q = (AdProperties) parcel.readParcelable(AdProperties.class.getClassLoader());
        this.f1968r = parcel.readString();
        this.f1969s = parcel.readInt();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f1970t = z2;
        this.f1971u = (EventReminderProperties) parcel.readParcelable(EventReminderProperties.class.getClassLoader());
        this.f1972v = (JoinableEventType) parcel.readSerializable();
    }

    public final int m3332z() {
        return this.f1954d;
    }

    @Nullable
    public final String m3307A() {
        return this.f1955e;
    }

    @Nullable
    public final String m3308B() {
        return this.f1956f;
    }

    @Nullable
    public final String m3309C() {
        return this.f1957g;
    }

    public final int m3310D() {
        return this.f1958h;
    }

    @Nullable
    public final ImmutableList<String> m3311E() {
        return this.f1959i;
    }

    @Nullable
    public final ImmutableList<String> m3312F() {
        return this.f1960j;
    }

    @Nullable
    public final ImmutableList<NicknameChoice> m3313G() {
        return this.f1961k;
    }

    @Nullable
    public final ImmutableList<BotChoice> m3314H() {
        return this.f1962l;
    }

    @Nullable
    public final String m3315I() {
        return this.f1963m;
    }

    @Nullable
    public final String m3316J() {
        return this.f1964n;
    }

    public final boolean m3317K() {
        return this.f1965o;
    }

    @Nullable
    public final String m3318L() {
        return this.f1966p;
    }

    @Nullable
    public final String m3319M() {
        return this.f1968r;
    }

    public final int m3320N() {
        return this.f1969s;
    }

    public final boolean m3321O() {
        return this.f1970t;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdProperties m3322P() {
        return this.f1967q;
    }

    @Nullable
    public final EventReminderProperties m3323Q() {
        return this.f1971u;
    }

    @Nullable
    public final JoinableEventType m3324R() {
        return this.f1972v;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size;
        int i2 = 1;
        int i3 = -1;
        parcel.writeSerializable(this.f1953c);
        parcel.writeInt(this.f1954d);
        parcel.writeString(this.f1955e);
        parcel.writeString(this.f1956f);
        parcel.writeString(this.f1957g);
        parcel.writeInt(this.f1958h);
        parcel.writeInt(this.f1959i != null ? this.f1959i.size() : -1);
        if (this.f1959i != null) {
            parcel.writeStringList(this.f1959i);
        }
        if (this.f1960j != null) {
            size = this.f1960j.size();
        } else {
            size = -1;
        }
        parcel.writeInt(size);
        if (this.f1960j != null) {
            parcel.writeStringList(this.f1960j);
        }
        if (this.f1961k != null) {
            size = this.f1961k.size();
        } else {
            size = -1;
        }
        parcel.writeInt(size);
        if (this.f1961k != null) {
            parcel.writeTypedList(this.f1961k);
        }
        if (this.f1962l != null) {
            i3 = this.f1962l.size();
        }
        parcel.writeInt(i3);
        if (this.f1962l != null) {
            parcel.writeTypedList(this.f1962l);
        }
        parcel.writeString(this.f1963m);
        parcel.writeString(this.f1964n);
        if (this.f1965o) {
            size = 1;
        } else {
            size = 0;
        }
        parcel.writeInt(size);
        parcel.writeString(this.f1966p);
        parcel.writeParcelable(this.f1967q, i);
        parcel.writeString(this.f1968r);
        parcel.writeInt(this.f1969s);
        if (!this.f1970t) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f1971u, i);
        parcel.writeSerializable(this.f1972v);
    }
}

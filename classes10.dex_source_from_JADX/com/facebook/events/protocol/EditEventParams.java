package com.facebook.events.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.protocol.ContextParams.Builder;
import com.facebook.graphql.calls.EventEditInputData;
import com.facebook.graphql.calls.EventEditInputData.InvitePolicy;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Immutable
/* compiled from: audio_popup */
public class EditEventParams extends ContextParams {
    public static final Creator<EditEventParams> CREATOR = new C26981();
    public final String f19046a;
    @Nullable
    private String f19047b;
    @Nullable
    public String f19048c;
    @Nullable
    public Long f19049d;
    @Nullable
    public String f19050e;
    public Boolean f19051f;
    @Nullable
    private String f19052g;
    private boolean f19053h;
    @Nullable
    private String f19054i;
    @Nullable
    public PrivacyType f19055j;
    @Nullable
    public Boolean f19056k;

    /* compiled from: audio_popup */
    final class C26981 implements Creator<EditEventParams> {
        C26981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditEventParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditEventParams[i];
        }
    }

    public EditEventParams(EventActionContext eventActionContext, Event event, Event event2) {
        Builder builder = new Builder();
        builder.f19018a = eventActionContext;
        super(builder);
        if (event.a.equals(event2.a)) {
            this.f19046a = event.a;
            m19254a(event.b, event2.b);
            EventCommonTextWithEntitiesModel eventCommonTextWithEntitiesModel = event.c;
            DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = event2.c;
            if (!Objects.equal(eventCommonTextWithEntitiesModel, defaultTextWithEntitiesLongFields)) {
                if (defaultTextWithEntitiesLongFields == null || StringUtil.a(defaultTextWithEntitiesLongFields.a())) {
                    this.f19048c = "";
                } else {
                    this.f19048c = MentionsUtils.a(defaultTextWithEntitiesLongFields);
                }
            }
            if (!(Objects.equal(Long.valueOf(event.O), Long.valueOf(event2.O)) && (Event.b(event.O) || Objects.equal(event.P, event2.P)))) {
                long j;
                if (Event.b(event2.O)) {
                    j = event2.O;
                } else {
                    j = 0;
                }
                this.f19049d = Long.valueOf(j);
                if (this.f19049d.longValue() == 0) {
                    this.f19051f = Boolean.valueOf(StringUtil.a(event2.P));
                    this.f19050e = event2.P;
                }
            }
            m19256b(event, event2);
            PrivacyType privacyType = event.f;
            PrivacyType privacyType2 = event2.f;
            if (!(privacyType == null || privacyType2 == null || privacyType == privacyType2)) {
                this.f19055j = privacyType2;
            }
            boolean z = event.h;
            boolean z2 = event2.h;
            if (z != z2) {
                this.f19056k = Boolean.valueOf(z2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Old and new events need to have same Event Id: " + event.a + " != " + event2.a);
    }

    public final void m19258a(EventEditInputData eventEditInputData) {
        String str;
        eventEditInputData.a(this.f19046a);
        if (this.f19047b != null) {
            eventEditInputData.a("name", this.f19047b);
        }
        if (this.f19049d != null) {
            eventEditInputData.a("location_id", Long.toString(this.f19049d.longValue()));
        }
        if (this.f19051f != null) {
            if (this.f19051f.booleanValue()) {
                str = "";
            } else {
                str = this.f19050e;
            }
            eventEditInputData.a("location_name", str);
        }
        if (this.f19052g != null) {
            eventEditInputData.a("start_time", this.f19052g);
        }
        if (this.f19053h && this.f19054i != null) {
            eventEditInputData.a("end_time", this.f19054i);
        }
        if (this.f19048c != null) {
            if (Strings.isNullOrEmpty(this.f19048c)) {
                str = "";
            } else {
                str = this.f19048c;
            }
            eventEditInputData.a("description", str);
        }
        if (this.f19055j != null) {
            eventEditInputData.a("event_visibility", PrivacyType.getPrivacyTypeForEventEditInputData(this.f19055j));
        }
        if (this.f19056k != null) {
            Enum enumR;
            if (this.f19056k.booleanValue()) {
                enumR = InvitePolicy.CAN_INVITE_FRIENDS;
            } else {
                enumR = InvitePolicy.CANNOT_INVITE_FRIENDS;
            }
            eventEditInputData.a("invite_policy", enumR);
        }
    }

    public final List<NameValuePair> mo855a() {
        List<NameValuePair> a = super.mo855a();
        m19255a(a, "name", this.f19047b);
        m19255a(a, "location_id", this.f19049d);
        if (this.f19051f != null) {
            m19255a(a, "location", this.f19051f.booleanValue() ? Integer.valueOf(0) : this.f19050e);
        }
        m19255a(a, "start_time", this.f19052g);
        if (this.f19053h) {
            m19255a(a, "end_time", this.f19054i);
        }
        if (this.f19048c != null) {
            m19255a(a, "description", Strings.isNullOrEmpty(this.f19048c) ? Integer.valueOf(0) : this.f19048c);
        }
        if (this.f19055j != null) {
            a.add(new BasicNameValuePair("privacy_type", EventsApiConstants.m19287a(this.f19055j)));
        }
        if (this.f19056k != null) {
            a.add(new BasicNameValuePair("can_guests_invite_friends", Boolean.toString(this.f19056k.booleanValue())));
        }
        return a;
    }

    private void m19254a(String str, String str2) {
        if (Strings.isNullOrEmpty(str2)) {
            throw new IllegalArgumentException("New name of event can not be empty.");
        } else if (!str2.equals(str)) {
            this.f19047b = str2;
        }
    }

    private void m19256b(Event event, Event event2) {
        String a = EventsApiConstants.m19286a(event);
        String a2 = EventsApiConstants.m19286a(event2);
        if (!Objects.equal(a, a2)) {
            this.f19052g = a2;
        }
        a2 = EventsApiConstants.m19290b(event);
        a = EventsApiConstants.m19290b(event2);
        if (!Objects.equal(a2, a)) {
            this.f19053h = true;
            if (a == null) {
                a = "0";
            }
            this.f19054i = a;
        }
    }

    private static void m19255a(List<NameValuePair> list, String str, Object obj) {
        if (obj != null) {
            list.add(new BasicNameValuePair(str, obj.toString()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Parcel parcel2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f19046a);
        parcel.writeString(this.f19047b);
        parcel.writeString(this.f19048c);
        parcel.writeInt(this.f19049d == null ? 0 : 1);
        if (this.f19049d != null) {
            parcel.writeLong(this.f19049d.longValue());
        }
        parcel.writeString(this.f19050e);
        if (this.f19051f == null) {
            i2 = -1;
            parcel2 = parcel;
        } else if (this.f19051f.booleanValue()) {
            i2 = 1;
            parcel2 = parcel;
        } else {
            i2 = 0;
            parcel2 = parcel;
        }
        parcel2.writeInt(i2);
        parcel.writeString(this.f19052g);
        if (this.f19053h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f19053h) {
            parcel.writeString(this.f19054i);
        }
        if (this.f19055j == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.f19055j != null) {
            parcel.writeString(this.f19055j.name());
        }
        if (this.f19056k == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.f19056k != null) {
            if (!this.f19056k.booleanValue()) {
                i3 = 0;
            }
            parcel.writeInt(i3);
        }
    }

    public EditEventParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(new Builder(parcel));
        this.f19046a = parcel.readString();
        this.f19047b = parcel.readString();
        this.f19048c = parcel.readString();
        this.f19049d = parcel.readInt() == 1 ? Long.valueOf(parcel.readLong()) : null;
        this.f19050e = parcel.readString();
        if (parcel.readInt() != -1) {
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f19051f = Boolean.valueOf(z);
        }
        this.f19052g = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19053h = z;
        if (this.f19053h) {
            this.f19054i = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            this.f19055j = PrivacyType.valueOf(parcel.readString());
        }
        if (parcel.readInt() == 1) {
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f19056k = Boolean.valueOf(z2);
        }
    }
}

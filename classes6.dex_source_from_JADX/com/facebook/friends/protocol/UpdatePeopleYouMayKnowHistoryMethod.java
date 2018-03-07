package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: mSuggestedTime */
public class UpdatePeopleYouMayKnowHistoryMethod implements ApiMethod<Params, Boolean> {

    /* compiled from: mSuggestedTime */
    public enum Event {
        CLICK("CLICK"),
        IMPRESSION("IMP");
        
        public final String value;

        private Event(String str) {
            this.value = str;
        }
    }

    /* compiled from: mSuggestedTime */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C06661();
        public final String f10831a;
        public final Event f10832b;
        public final PeopleYouMayKnowLocation f10833c;

        /* compiled from: mSuggestedTime */
        final class C06661 implements Creator<Params> {
            C06661() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, Event event, PeopleYouMayKnowLocation peopleYouMayKnowLocation) {
            this.f10831a = str;
            this.f10832b = event;
            this.f10833c = peopleYouMayKnowLocation;
        }

        public Params(Parcel parcel) {
            this.f10831a = parcel.readString();
            this.f10832b = Event.valueOf(parcel.readString());
            this.f10833c = PeopleYouMayKnowLocation.valueOf(parcel.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10831a);
            parcel.writeString(this.f10832b.name());
            parcel.writeString(this.f10833c.name());
        }
    }

    public final ApiRequest m17414a(Object obj) {
        List a = Lists.a(new NameValuePair[]{new BasicNameValuePair("event", r8.f10832b.value), new BasicNameValuePair("location", r8.f10833c.value), new BasicNameValuePair("suggestion_ids", ((Params) obj).f10831a), new BasicNameValuePair("format", "json")});
        if (((Params) obj).f10832b == Event.CLICK) {
            a.add(new BasicNameValuePair("click_type", "FRIENDED"));
        }
        return new ApiRequest("updatePeopleYouMayKnowHistory", "POST", "method/user.updatepeopleyoumayknowhistory", RequestPriority.CAN_WAIT, a, ApiResponseType.JSON);
    }

    public final Object m17415a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().F());
    }
}

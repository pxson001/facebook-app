package com.facebook.quickinvite.protocol.methods;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: lightweight_event_rsvp */
public class SendInviteMethod implements ApiMethod<Params, Void> {

    /* compiled from: lightweight_event_rsvp */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C12931();
        public final InvitationProduct f8671a;
        public final String f8672b;
        public final String f8673c;
        public final String f8674d;
        public final String f8675e;
        public final ImmutableMap<String, String> f8676f;

        /* compiled from: lightweight_event_rsvp */
        final class C12931 implements Creator<Params> {
            C12931() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        /* compiled from: lightweight_event_rsvp */
        public enum InvitationProduct {
            MESSENGER("256002347743983");
            
            public final String appId;

            private InvitationProduct(String str) {
                this.appId = str;
            }
        }

        public Params(Parcel parcel) {
            this.f8671a = InvitationProduct.valueOf(parcel.readString());
            this.f8672b = parcel.readString();
            this.f8673c = parcel.readString();
            this.f8674d = parcel.readString();
            this.f8675e = parcel.readString();
            this.f8676f = ImmutableMap.copyOf(parcel.readHashMap(SendInviteMethod.class.getClassLoader()));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8671a.name());
            parcel.writeString(this.f8672b);
            parcel.writeString(this.f8673c);
            parcel.writeString(this.f8674d);
            parcel.writeString(this.f8675e);
            parcel.writeMap(this.f8676f);
        }
    }

    public final ApiRequest m8686a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params.f8671a, "Product required");
        boolean z = (params.f8672b == null && params.f8675e == null && params.f8674d == null) ? false : true;
        Preconditions.checkArgument(z, "Recipient required");
        List a = Lists.a();
        if (params.f8672b != null) {
            a.add(new BasicNameValuePair("recipient_id", params.f8672b));
        }
        if (params.f8673c != null) {
            a.add(new BasicNameValuePair("message", params.f8673c));
        }
        if (params.f8674d != null) {
            a.add(new BasicNameValuePair("phone", params.f8674d));
        }
        if (params.f8675e != null) {
            a.add(new BasicNameValuePair("email", params.f8675e));
        }
        if (!(params.f8676f == null || params.f8676f.isEmpty())) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            Iterator it = params.f8676f.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                objectNode.a((String) entry.getKey(), (String) entry.getValue());
            }
            a.add(new BasicNameValuePair("context", objectNode.toString()));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "graphQuickInviteSendInvite";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.a("%s/invites", new Object[]{Uri.encode(params.f8671a.appId)});
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSONPARSER;
        return newBuilder.C();
    }

    public final Object m8687a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

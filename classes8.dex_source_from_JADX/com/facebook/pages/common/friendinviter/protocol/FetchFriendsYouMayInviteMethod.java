package com.facebook.pages.common.friendinviter.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInvite.FriendsYouMayInviteQueryString;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInviteInterfaces.FriendsYouMayInviteQuery.FriendsYouMayInvite;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInviteModels.FriendsYouMayInviteQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: cta_icon_size */
public class FetchFriendsYouMayInviteMethod extends AbstractPersistedGraphQlApiMethod<Params, FriendsYouMayInvite> {

    /* compiled from: cta_icon_size */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C17941();
        public final String f16556a;
        public final int f16557b;
        public final int f16558c;

        /* compiled from: cta_icon_size */
        final class C17941 implements Creator<Params> {
            C17941() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, int i, int i2) {
            this.f16556a = str;
            this.f16557b = i;
            this.f16558c = i2;
        }

        public Params(Parcel parcel) {
            this.f16556a = parcel.readString();
            this.f16557b = parcel.readInt();
            this.f16558c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f16556a);
            parcel.writeInt(this.f16557b);
            parcel.writeInt(this.f16558c);
        }

        public int describeContents() {
            return 0;
        }
    }

    public final GraphQlQueryString m19536f(Object obj) {
        Params params = (Params) obj;
        return new FriendsYouMayInviteQueryString().a("page_id", String.valueOf(params.f16556a)).a("profile_image_size", String.valueOf(params.f16557b)).a("num_friends_you_may_invite", String.valueOf(params.f16558c));
    }

    @Inject
    public FetchFriendsYouMayInviteMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m19534a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        FriendsYouMayInviteQueryModel friendsYouMayInviteQueryModel = (FriendsYouMayInviteQueryModel) jsonParser.a(FriendsYouMayInviteQueryModel.class);
        if (friendsYouMayInviteQueryModel != null && friendsYouMayInviteQueryModel.m19558a() != null) {
            return friendsYouMayInviteQueryModel.m19558a();
        }
        throw new RuntimeException("Invalid JSON result");
    }

    public final int m19535b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}

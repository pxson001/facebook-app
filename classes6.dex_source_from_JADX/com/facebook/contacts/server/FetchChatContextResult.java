package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_link_menus */
public class FetchChatContextResult extends BaseResult implements Parcelable {
    public static final Creator<FetchChatContextResult> CREATOR = new C05361();
    public final ImmutableMap<UserKey, ChatContextForUser> f8439a;

    /* compiled from: page_link_menus */
    final class C05361 implements Creator<FetchChatContextResult> {
        C05361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchChatContextResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchChatContextResult[i];
        }
    }

    public FetchChatContextResult(DataFreshnessResult dataFreshnessResult, long j, ImmutableMap<UserKey, ChatContextForUser> immutableMap) {
        super(dataFreshnessResult, j);
        this.f8439a = immutableMap;
    }

    public FetchChatContextResult(Parcel parcel) {
        super(parcel);
        this.f8439a = ImmutableMap.copyOf(parcel.readHashMap(ChatContextForUser.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeMap(this.f8439a);
    }
}

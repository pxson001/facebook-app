package com.facebook.redspace.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceFriendsWithFriendsResult;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PrivacyCheckupProfileViewCreation */
public class RedSpaceFriendsSearchCollection extends RedSpaceFriendsCollection {
    public static final Creator<RedSpaceFriendsSearchCollection> CREATOR = new C13981();
    String f11803b;
    String f11804c;
    public Set<String> f11805d;
    public Set<String> f11806e;
    public Set<String> f11807f;

    /* compiled from: PrivacyCheckupProfileViewCreation */
    final class C13981 implements Creator<RedSpaceFriendsSearchCollection> {
        C13981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RedSpaceFriendsSearchCollection(parcel);
        }

        public final Object[] newArray(int i) {
            return new RedSpaceFriendsSearchCollection[i];
        }
    }

    @Inject
    public RedSpaceFriendsSearchCollection() {
        this.f11805d = new HashSet();
        this.f11806e = new HashSet();
        this.f11807f = new HashSet();
        this.f11804c = "top";
    }

    final String m12236a(String str) {
        return StringUtil.a(str, this.f11803b) ? this.f11804c : "top";
    }

    final String m12237a(String str, String str2) {
        return (StringUtil.a(str2, this.f11803b) && StringUtil.a(str, this.f11804c)) ? super.m12219b() : null;
    }

    final boolean m12239b(String str) {
        return !StringUtil.a(str, this.f11803b) || super.m12218a();
    }

    public final void m12238a(String str, RedSpaceFriendsWithFriendsResult redSpaceFriendsWithFriendsResult) {
        if (!StringUtil.a(this.f11803b, str)) {
            mo333g();
        }
        this.f11803b = str;
        if (!(redSpaceFriendsWithFriendsResult.a() == null || redSpaceFriendsWithFriendsResult.a().e == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithFriendsResult.a().e).j() == null)) {
            super.m12214a(RedSpaceFriendsFetchResult.m12225a(redSpaceFriendsWithFriendsResult.a(), null));
            RedSpaceFriendsQueryModel redSpaceFriendsQueryModel = (RedSpaceFriendsQueryModel) redSpaceFriendsWithFriendsResult.a().e;
            if (redSpaceFriendsQueryModel.j().a() != null) {
                ImmutableList a = redSpaceFriendsQueryModel.j().a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    m12240d((RedSpaceFeedProfileFragmentModel) a.get(i));
                }
            }
        }
        if (redSpaceFriendsWithFriendsResult.b() != null && redSpaceFriendsWithFriendsResult.b().e != null && ((RedSpaceFriendsQueryModel) redSpaceFriendsWithFriendsResult.b().e).j() != null) {
            super.m12214a(RedSpaceFriendsFetchResult.m12225a(redSpaceFriendsWithFriendsResult.b(), null));
            this.f11804c = "others";
        }
    }

    public final void m12240d(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        this.f11805d.add(redSpaceFeedProfileFragmentModel.k());
    }

    public final void m12242h(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        this.f11807f.remove(redSpaceFeedProfileFragmentModel.k());
    }

    public final boolean m12243i(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        return this.f11807f.contains(redSpaceFeedProfileFragmentModel.k());
    }

    public final void mo333g() {
        super.mo333g();
        this.f11805d.clear();
        this.f11804c = "top";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        ParcelUtil.a(parcel, this.f11805d);
        ParcelUtil.a(parcel, this.f11807f);
        ParcelUtil.a(parcel, this.f11806e);
        parcel.writeString(this.f11803b);
        parcel.writeString(this.f11804c);
    }

    protected RedSpaceFriendsSearchCollection(Parcel parcel) {
        super(parcel);
        this.f11805d = ParcelUtil.b(parcel);
        this.f11807f = ParcelUtil.b(parcel);
        this.f11806e = ParcelUtil.b(parcel);
        this.f11803b = parcel.readString();
        this.f11804c = parcel.readString();
    }
}

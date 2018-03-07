package com.facebook.account.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountCandidateModelDeserializer.class)
/* compiled from: loading */
public class AccountCandidateModel implements Parcelable, AccountSearchListItem {
    public static final Creator<AccountCandidateModel> CREATOR = new C10911();
    @JsonIgnore
    private final List<String> f10305a;
    @JsonIgnore
    private final List<String> f10306b;
    @JsonIgnore
    private final List<String> f10307c;
    @JsonProperty("contactpoints")
    private AccountCandidateContactPointList contactPoints;
    @JsonIgnore
    private final List<String> f10308d;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("network_info")
    private String networkName;
    @JsonProperty("profile_pic_uri")
    private String profilePictureUri;

    /* compiled from: loading */
    final class C10911 implements Creator<AccountCandidateModel> {
        C10911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountCandidateModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountCandidateModel[i];
        }
    }

    public AccountCandidateModel() {
        this.f10305a = Lists.a();
        this.f10306b = Lists.a();
        this.f10307c = Lists.a();
        this.f10308d = Lists.a();
        this.id = null;
        this.name = null;
        this.networkName = null;
        this.profilePictureUri = null;
        this.contactPoints = null;
    }

    public AccountCandidateModel(Parcel parcel) {
        this.f10305a = Lists.a();
        this.f10306b = Lists.a();
        this.f10307c = Lists.a();
        this.f10308d = Lists.a();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.networkName = parcel.readString();
        this.profilePictureUri = parcel.readString();
        this.contactPoints = (AccountCandidateContactPointList) parcel.readParcelable(AccountCandidateContactPointList.class.getClassLoader());
    }

    public final String m12089a() {
        return this.id;
    }

    public final String m12090b() {
        return this.profilePictureUri;
    }

    public final String m12091c() {
        return this.name;
    }

    public final String m12092d() {
        return this.networkName;
    }

    public final ImmutableList<String> m12093e() {
        return this.f10305a.isEmpty() ? RegularImmutableList.a : ImmutableList.copyOf(this.f10305a);
    }

    public final ImmutableList<String> m12094f() {
        return this.f10306b.isEmpty() ? RegularImmutableList.a : ImmutableList.copyOf(this.f10306b);
    }

    public final ImmutableList<String> m12095g() {
        return this.f10308d.isEmpty() ? RegularImmutableList.a : ImmutableList.copyOf(this.f10308d);
    }

    public final ImmutableList<String> m12096h() {
        return this.f10307c.isEmpty() ? RegularImmutableList.a : ImmutableList.copyOf(this.f10307c);
    }

    public final void m12097i() {
        if (this.f10306b.isEmpty() && this.f10305a.isEmpty() && this.contactPoints != null) {
            ImmutableList<AccountCandidateContactPoint> a = this.contactPoints.m12084a();
            if (a != null && !a.isEmpty()) {
                for (AccountCandidateContactPoint accountCandidateContactPoint : a) {
                    if (accountCandidateContactPoint.m12081c().equals("EMAIL")) {
                        this.f10306b.add(accountCandidateContactPoint.m12080b());
                        this.f10308d.add(accountCandidateContactPoint.m12079a());
                    } else {
                        this.f10305a.add(accountCandidateContactPoint.m12080b());
                        this.f10307c.add(accountCandidateContactPoint.m12079a());
                    }
                }
            }
        }
    }

    public final AccountSearchListItemType mo678j() {
        return AccountSearchListItemType.CANDIDATE;
    }

    public final boolean mo679k() {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.networkName);
        parcel.writeString(this.profilePictureUri);
        parcel.writeParcelable(this.contactPoints, i);
    }
}

package com.facebook.search.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.search.api.model.GraphSearchQueryFragment;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: extra_product_item_id_to_fetch */
public class SearchTypeaheadResult implements Parcelable {
    public static final Creator<SearchTypeaheadResult> CREATOR = new C11021();
    @Nullable
    public final String f15485a;
    public final Uri f15486b;
    @Nullable
    public final GraphQLFriendshipStatus f15487c;
    @Nullable
    public final Uri f15488d;
    public final Uri f15489e;
    public final Uri f15490f;
    public final String f15491g;
    public final String f15492h;
    public final String f15493i;
    public final String f15494j;
    public final String f15495k;
    public final Type f15496l;
    public final long f15497m;
    public final boolean f15498n;
    public final GraphQLPageVerificationBadge f15499o;
    public final boolean f15500p;
    @Nullable
    public final List<String> f15501q;
    public final ImmutableList<String> f15502r;
    public final String f15503s;
    public final ImmutableList<GraphSearchQueryFragment> f15504t;
    public final int f15505u;
    public final int f15506v;
    public final boolean f15507w;
    public boolean f15508x = false;

    /* compiled from: extra_product_item_id_to_fetch */
    final class C11021 implements Creator<SearchTypeaheadResult> {
        C11021() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return C11021.m23129a(parcel);
        }

        private static SearchTypeaheadResult m23129a(Parcel parcel) {
            boolean z;
            ImmutableList immutableList;
            String readString = parcel.readString();
            Uri uri = (Uri) parcel.readParcelable(null);
            String readString2 = parcel.readString();
            GraphQLFriendshipStatus fromString = readString2.equals("") ? null : GraphQLFriendshipStatus.fromString(readString2);
            if (parcel.readByte() > (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            GraphQLPageVerificationBadge fromString2 = GraphQLPageVerificationBadge.fromString(parcel.readString());
            Uri uri2 = (Uri) parcel.readParcelable(null);
            Uri uri3 = (Uri) parcel.readParcelable(null);
            Uri uri4 = (Uri) parcel.readParcelable(null);
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            Type valueOf = readString8.equals("") ? null : Type.valueOf(readString8);
            long readLong = parcel.readLong();
            ArrayList readArrayList = parcel.readArrayList(null);
            Collection readArrayList2 = parcel.readArrayList(String.class.getClassLoader());
            String readString9 = parcel.readString();
            Collection readArrayList3 = parcel.readArrayList(GraphSearchQueryFragment.class.getClassLoader());
            boolean z2 = parcel.readByte() > (byte) 0;
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            boolean z3 = parcel.readByte() > (byte) 0;
            SearchTypeaheadResultBuilder a = SearchTypeaheadResult.newBuilder().m23141a(readString).m23135a(uri).m23136a(fromString).m23148b(z).m23137a(fromString2).m23145b(uri2).m23149c(uri3).m23151d(uri4).m23147b(readString3).m23150c(readString4).m23152d(readString5).m23153e(readString6).m23154f(readString7).m23138a(valueOf).m23134a(readLong).m23142a((List) readArrayList);
            if (readArrayList2 == null) {
                immutableList = null;
            } else {
                immutableList = ImmutableList.copyOf(readArrayList2);
            }
            a = a.m23139a(immutableList).m23155g(readString9);
            if (readArrayList3 == null) {
                immutableList = null;
            } else {
                immutableList = ImmutableList.copyOf(readArrayList3);
            }
            return a.m23146b(immutableList).m23140a(Boolean.valueOf(z2)).m23133a(readInt).m23144b(readInt2).m23143a(z3).m23132a();
        }

        public final Object[] newArray(int i) {
            return new SearchTypeaheadResult[i];
        }
    }

    /* compiled from: extra_product_item_id_to_fetch */
    public enum Type {
        USER,
        PAGE,
        APP,
        GROUP,
        EVENT,
        SHORTCUT,
        PAGE_FAN,
        PAGE_ADMIN,
        HASHTAG_EXACT,
        KEYWORD_SUGGESTION
    }

    public static SearchTypeaheadResultBuilder newBuilder() {
        return new SearchTypeaheadResultBuilder();
    }

    public SearchTypeaheadResult(SearchTypeaheadResultBuilder searchTypeaheadResultBuilder) {
        Uri parse;
        GraphQLPageVerificationBadge graphQLPageVerificationBadge;
        this.f15485a = searchTypeaheadResultBuilder.f15509a;
        if (searchTypeaheadResultBuilder.f15511c == null) {
            parse = Uri.parse("http://www.facebook.com/" + searchTypeaheadResultBuilder.f15521m);
        } else {
            parse = searchTypeaheadResultBuilder.f15511c;
        }
        this.f15486b = parse;
        this.f15487c = searchTypeaheadResultBuilder.f15510b;
        this.f15498n = searchTypeaheadResultBuilder.f15522n;
        if (searchTypeaheadResultBuilder.f15523o == null) {
            graphQLPageVerificationBadge = GraphQLPageVerificationBadge.NOT_VERIFIED;
        } else {
            graphQLPageVerificationBadge = searchTypeaheadResultBuilder.f15523o;
        }
        this.f15499o = graphQLPageVerificationBadge;
        this.f15488d = searchTypeaheadResultBuilder.f15512d;
        if (searchTypeaheadResultBuilder.f15513e == null) {
            parse = Uri.parse("http://www.facebook.com/" + searchTypeaheadResultBuilder.f15521m);
        } else {
            parse = searchTypeaheadResultBuilder.f15513e;
        }
        this.f15489e = parse;
        this.f15490f = searchTypeaheadResultBuilder.f15514f;
        this.f15491g = searchTypeaheadResultBuilder.f15515g;
        this.f15492h = searchTypeaheadResultBuilder.f15516h;
        this.f15493i = searchTypeaheadResultBuilder.f15517i;
        this.f15494j = searchTypeaheadResultBuilder.f15518j;
        this.f15495k = (String) Preconditions.checkNotNull(searchTypeaheadResultBuilder.f15519k);
        this.f15496l = (Type) Preconditions.checkNotNull(searchTypeaheadResultBuilder.f15520l);
        this.f15497m = ((Long) Preconditions.checkNotNull(Long.valueOf(searchTypeaheadResultBuilder.f15521m))).longValue();
        this.f15501q = searchTypeaheadResultBuilder.f15525q;
        this.f15502r = searchTypeaheadResultBuilder.f15526r;
        this.f15503s = searchTypeaheadResultBuilder.f15527s;
        this.f15504t = searchTypeaheadResultBuilder.f15528t;
        this.f15500p = searchTypeaheadResultBuilder.f15524p;
        this.f15505u = searchTypeaheadResultBuilder.f15529u;
        this.f15506v = searchTypeaheadResultBuilder.f15530v;
        this.f15507w = searchTypeaheadResultBuilder.f15531w;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f15485a);
        parcel.writeParcelable(this.f15486b, i);
        parcel.writeString(this.f15487c == null ? "" : this.f15487c.name());
        if (this.f15498n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f15499o == null ? "" : this.f15499o.name());
        parcel.writeParcelable(this.f15488d, i);
        parcel.writeParcelable(this.f15489e, i);
        parcel.writeParcelable(this.f15490f, i);
        parcel.writeString(this.f15491g);
        parcel.writeString(this.f15492h);
        parcel.writeString(this.f15493i);
        parcel.writeString(this.f15494j);
        parcel.writeString(this.f15495k);
        parcel.writeString(this.f15496l == null ? "" : this.f15496l.name());
        parcel.writeLong(this.f15497m);
        parcel.writeList(this.f15501q);
        parcel.writeList(this.f15502r);
        parcel.writeString(this.f15503s);
        parcel.writeList(this.f15504t);
        if (this.f15500p) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f15505u);
        parcel.writeInt(this.f15506v);
        if (!this.f15507w) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public final int m23130a() {
        switch (this.f15496l) {
            case USER:
                return 2645995;
            case PAGE:
                return 2479791;
            case APP:
                return -1072845520;
            case GROUP:
                return 69076575;
            case EVENT:
                return 67338874;
            case SHORTCUT:
                return 811944494;
            case KEYWORD_SUGGESTION:
                return 907720311;
            default:
                return 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SearchTypeaheadResult)) {
            return false;
        }
        SearchTypeaheadResult searchTypeaheadResult = (SearchTypeaheadResult) obj;
        if (Objects.equal(this.f15485a, searchTypeaheadResult.f15485a) && Objects.equal(this.f15486b, searchTypeaheadResult.f15486b) && Objects.equal(this.f15487c, searchTypeaheadResult.f15487c) && Objects.equal(this.f15488d, searchTypeaheadResult.f15488d) && this.f15498n == searchTypeaheadResult.f15498n && this.f15499o == searchTypeaheadResult.f15499o && Objects.equal(this.f15489e, searchTypeaheadResult.f15489e) && Objects.equal(this.f15490f, searchTypeaheadResult.f15490f) && Objects.equal(this.f15491g, searchTypeaheadResult.f15491g) && Objects.equal(this.f15492h, searchTypeaheadResult.f15492h) && Objects.equal(this.f15493i, searchTypeaheadResult.f15493i) && Objects.equal(this.f15494j, searchTypeaheadResult.f15494j) && Objects.equal(this.f15495k, searchTypeaheadResult.f15495k) && Objects.equal(this.f15496l, searchTypeaheadResult.f15496l) && Objects.equal(Long.valueOf(this.f15497m), Long.valueOf(searchTypeaheadResult.f15497m)) && Objects.equal(this.f15501q, searchTypeaheadResult.f15501q) && Objects.equal(this.f15503s, searchTypeaheadResult.f15503s) && this.f15500p == searchTypeaheadResult.f15500p && this.f15507w == searchTypeaheadResult.f15507w) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Objects.toStringHelper(SearchTypeaheadResult.class).add("category", this.f15485a).add("fallbackPath", this.f15486b).add("friendshipStatus", this.f15487c).add("isVerified", this.f15498n).add("verificationStatus", this.f15499o).add("nativeAndroidUrl", this.f15488d).add("path", this.f15489e).add("photo", this.f15490f).add("subtext", this.f15491g).add("boldedSubtext", this.f15492h).add("keywordType", this.f15493i).add("keywordSource", this.f15494j).add("text", this.f15495k).add("type", this.f15496l).add("uid", this.f15497m).add("phoneNumbers", this.f15501q).add("semantic", this.f15503s).add("isScoped", this.f15500p).add("matchedPosition", this.f15505u).add("matchedLength", this.f15506v).add("isLive", this.f15507w).toString();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15485a, this.f15486b, this.f15487c, Boolean.valueOf(this.f15498n), this.f15499o, this.f15488d, this.f15489e, this.f15490f, this.f15491g, this.f15492h, this.f15493i, this.f15494j, this.f15495k, this.f15496l, Long.valueOf(this.f15497m), this.f15501q, this.f15503s, Boolean.valueOf(this.f15500p), Boolean.valueOf(this.f15507w)});
    }

    @Nullable
    public final String m23131b() {
        if (this.f15501q != null) {
            for (String str : this.f15501q) {
                if (str != null) {
                    return str;
                }
            }
        }
        return null;
    }
}

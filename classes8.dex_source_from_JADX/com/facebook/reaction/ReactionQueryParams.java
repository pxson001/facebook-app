package com.facebook.reaction;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestedUnits;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.ViewerCoordinates;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: byline_area_config */
public class ReactionQueryParams implements Parcelable {
    public static final Creator<ReactionQueryParams> CREATOR = new C20611();
    public boolean f18619A;
    public String f18620a;
    public long f18621b;
    private String f18622c;
    private String f18623d;
    public String f18624e;
    public ImmutableList<String> f18625f;
    public ImmutableLocation f18626g;
    public ImmutableList<Long> f18627h;
    public String f18628i;
    public String f18629j;
    public String f18630k;
    public Long f18631l;
    public String f18632m;
    public String f18633n;
    public RequestPriority f18634o;
    public RequestType f18635p;
    public String f18636q;
    public ImmutableSet<Long> f18637r;
    private ImmutableList<String> f18638s;
    public Long f18639t;
    public String f18640u;
    private ImmutableList<RequestedUnits> f18641v;
    public String f18642w;
    public String f18643x;
    public String f18644y;
    public ImmutableSet<String> f18645z;

    /* compiled from: byline_area_config */
    final class C20611 implements Creator<ReactionQueryParams> {
        C20611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReactionQueryParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReactionQueryParams[i];
        }
    }

    public ReactionQueryParams() {
        this.f18624e = null;
        this.f18623d = null;
        this.f18625f = RegularImmutableList.a;
        this.f18626g = null;
        this.f18627h = RegularImmutableList.a;
        this.f18628i = null;
        this.f18629j = null;
        this.f18630k = null;
        this.f18631l = null;
        this.f18632m = null;
        this.f18633n = null;
        this.f18642w = null;
        this.f18641v = RegularImmutableList.a;
        this.f18643x = null;
        this.f18644y = null;
        this.f18634o = null;
        this.f18645z = RegularImmutableSet.a;
        this.f18635p = null;
        this.f18636q = null;
        this.f18622c = null;
        this.f18637r = RegularImmutableSet.a;
        this.f18619A = false;
        this.f18638s = RegularImmutableList.a;
        this.f18639t = null;
        this.f18640u = null;
    }

    public ReactionQueryParams(Parcel parcel) {
        this.f18624e = parcel.readString();
        this.f18620a = parcel.readString();
        this.f18623d = parcel.readString();
        this.f18625f = (ImmutableList) parcel.readSerializable();
        this.f18626g = (ImmutableLocation) parcel.readParcelable(ImmutableLocation.class.getClassLoader());
        this.f18627h = (ImmutableList) parcel.readSerializable();
        this.f18628i = parcel.readString();
        this.f18629j = parcel.readString();
        this.f18630k = parcel.readString();
        this.f18621b = parcel.readLong();
        this.f18631l = (Long) parcel.readSerializable();
        this.f18632m = parcel.readString();
        this.f18633n = parcel.readString();
        this.f18642w = parcel.readString();
        this.f18641v = (ImmutableList) parcel.readSerializable();
        this.f18643x = parcel.readString();
        this.f18644y = parcel.readString();
        this.f18634o = (RequestPriority) parcel.readSerializable();
        this.f18645z = (ImmutableSet) parcel.readSerializable();
        this.f18635p = (RequestType) parcel.readSerializable();
        this.f18636q = parcel.readString();
        this.f18622c = parcel.readString();
        this.f18637r = (ImmutableSet) parcel.readSerializable();
        this.f18619A = ParcelUtil.a(parcel);
        this.f18638s = (ImmutableList) parcel.readSerializable();
        this.f18639t = (Long) parcel.readSerializable();
        this.f18640u = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18624e);
        parcel.writeString(this.f18620a);
        parcel.writeString(this.f18623d);
        parcel.writeSerializable(this.f18625f);
        parcel.writeParcelable(this.f18626g, i);
        parcel.writeSerializable(this.f18627h);
        parcel.writeString(this.f18628i);
        parcel.writeString(this.f18629j);
        parcel.writeString(this.f18630k);
        parcel.writeLong(this.f18621b);
        parcel.writeSerializable(this.f18631l);
        parcel.writeString(this.f18632m);
        parcel.writeString(this.f18633n);
        parcel.writeString(this.f18642w);
        parcel.writeSerializable(this.f18641v);
        parcel.writeString(this.f18643x);
        parcel.writeString(this.f18644y);
        parcel.writeSerializable(this.f18634o);
        parcel.writeSerializable(this.f18645z);
        parcel.writeSerializable(this.f18635p);
        parcel.writeString(this.f18636q);
        parcel.writeString(this.f18622c);
        parcel.writeSerializable(this.f18637r);
        ParcelUtil.a(parcel, this.f18619A);
        parcel.writeSerializable(this.f18638s);
        parcel.writeSerializable(this.f18639t);
        parcel.writeString(this.f18640u);
    }

    public final ReactionTriggerInputTriggerData m22523a(LocationAgeUtil locationAgeUtil) {
        ReactionTriggerInputTriggerData reactionTriggerInputTriggerData = new ReactionTriggerInputTriggerData();
        if (this.f18624e != null) {
            reactionTriggerInputTriggerData.a("action", this.f18624e);
        }
        if (this.f18639t != null) {
            reactionTriggerInputTriggerData.a("triggering_profile_ids", ImmutableList.of(Long.toString(this.f18639t.longValue())));
        }
        if (this.f18640u != null) {
            reactionTriggerInputTriggerData.a("reaction_unit_ids", ImmutableList.of(this.f18640u));
        }
        if (CollectionUtil.b(this.f18625f)) {
            String str = "post_text";
            reactionTriggerInputTriggerData.a(str, StringUtil.b(" ", new Object[]{this.f18625f}));
        }
        if (CollectionUtil.b(this.f18627h)) {
            List arrayList = new ArrayList();
            int size = this.f18627h.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((Long) this.f18627h.get(i)).toString());
            }
            reactionTriggerInputTriggerData.a("mentioned_ids", arrayList);
        }
        if (!(this.f18629j == null || this.f18630k == null)) {
            reactionTriggerInputTriggerData.a("og_action_type_id", this.f18629j);
            reactionTriggerInputTriggerData.a("og_object_id", this.f18630k);
        }
        if (this.f18631l != null) {
            reactionTriggerInputTriggerData.a("place_id", Long.toString(this.f18631l.longValue()));
        }
        if (!Strings.isNullOrEmpty(this.f18636q)) {
            reactionTriggerInputTriggerData.a("share_id", this.f18636q);
        }
        if (this.f18635p == null) {
            reactionTriggerInputTriggerData.a(RequestType.NORMAL);
        } else {
            reactionTriggerInputTriggerData.a(this.f18635p);
        }
        if (CollectionUtil.b(this.f18637r)) {
            List arrayList2 = new ArrayList();
            Iterator it = this.f18637r.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.toString(((Long) it.next()).longValue()));
            }
            reactionTriggerInputTriggerData.a("tagged_user_ids", arrayList2);
        }
        if (CollectionUtil.b(this.f18638s)) {
            reactionTriggerInputTriggerData.a("tracking_codes", this.f18638s);
        }
        if (this.f18626g != null) {
            ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
            viewerCoordinates.a("latitude", Double.valueOf(this.f18626g.a()));
            GraphQlCallInput graphQlCallInput = viewerCoordinates;
            graphQlCallInput.a("longitude", Double.valueOf(this.f18626g.b()));
            GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
            Optional c = this.f18626g.c();
            if (c.isPresent()) {
                graphQlCallInput2.a("accuracy", Double.valueOf((double) ((Float) c.get()).floatValue()));
            }
            long a = locationAgeUtil.a(this.f18626g);
            if (a >= 0) {
                graphQlCallInput2.a("stale_time", Double.valueOf((double) (a / 1000)));
            }
            reactionTriggerInputTriggerData.a("viewer_coordinates", graphQlCallInput2);
        }
        if (CollectionUtil.b(this.f18641v)) {
            reactionTriggerInputTriggerData.a("requested_units", this.f18641v);
        }
        if (!Strings.isNullOrEmpty(this.f18622c)) {
            reactionTriggerInputTriggerData.a("start_date", this.f18622c);
        }
        if (!Strings.isNullOrEmpty(this.f18623d)) {
            reactionTriggerInputTriggerData.a("end_date", this.f18623d);
        }
        return reactionTriggerInputTriggerData;
    }

    @Nullable
    public final String m22528b() {
        return this.f18624e;
    }

    @Nullable
    public final Long m22529g() {
        return this.f18631l;
    }

    @Nullable
    public final Long m22530q() {
        return this.f18639t;
    }

    public final ReactionQueryParams m22525a(List<String> list) {
        this.f18625f = ImmutableList.copyOf(list);
        return this;
    }

    public final ReactionQueryParams m22524a(Long l) {
        this.f18631l = l;
        return this;
    }

    public final ReactionQueryParams m22526b(Long l) {
        this.f18639t = l;
        return this;
    }

    public final ReactionQueryParams m22527b(List<RequestedUnits> list) {
        this.f18641v = ImmutableList.copyOf(list);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionQueryParams)) {
            return false;
        }
        ReactionQueryParams reactionQueryParams = (ReactionQueryParams) obj;
        if (this.f18621b != reactionQueryParams.f18621b || this.f18619A != reactionQueryParams.f18619A) {
            return false;
        }
        if (this.f18620a != null) {
            if (!this.f18620a.equals(reactionQueryParams.f18620a)) {
                return false;
            }
        } else if (reactionQueryParams.f18620a != null) {
            return false;
        }
        if (this.f18622c != null) {
            if (!this.f18622c.equals(reactionQueryParams.f18622c)) {
                return false;
            }
        } else if (reactionQueryParams.f18622c != null) {
            return false;
        }
        if (this.f18623d != null) {
            if (!this.f18623d.equals(reactionQueryParams.f18623d)) {
                return false;
            }
        } else if (reactionQueryParams.f18623d != null) {
            return false;
        }
        if (this.f18624e != null) {
            if (!this.f18624e.equals(reactionQueryParams.f18624e)) {
                return false;
            }
        } else if (reactionQueryParams.f18624e != null) {
            return false;
        }
        if (!this.f18625f.equals(reactionQueryParams.f18625f)) {
            return false;
        }
        if (this.f18626g != null) {
            if (!this.f18626g.equals(reactionQueryParams.f18626g)) {
                return false;
            }
        } else if (reactionQueryParams.f18626g != null) {
            return false;
        }
        if (!this.f18627h.equals(reactionQueryParams.f18627h)) {
            return false;
        }
        if (this.f18628i != null) {
            if (!this.f18628i.equals(reactionQueryParams.f18628i)) {
                return false;
            }
        } else if (reactionQueryParams.f18628i != null) {
            return false;
        }
        if (this.f18629j != null) {
            if (!this.f18629j.equals(reactionQueryParams.f18629j)) {
                return false;
            }
        } else if (reactionQueryParams.f18629j != null) {
            return false;
        }
        if (this.f18630k != null) {
            if (!this.f18630k.equals(reactionQueryParams.f18630k)) {
                return false;
            }
        } else if (reactionQueryParams.f18630k != null) {
            return false;
        }
        if (this.f18631l != null) {
            if (!this.f18631l.equals(reactionQueryParams.f18631l)) {
                return false;
            }
        } else if (reactionQueryParams.f18631l != null) {
            return false;
        }
        if (this.f18632m != null) {
            if (!this.f18632m.equals(reactionQueryParams.f18632m)) {
                return false;
            }
        } else if (reactionQueryParams.f18632m != null) {
            return false;
        }
        if (this.f18633n != null) {
            if (!this.f18633n.equals(reactionQueryParams.f18633n)) {
                return false;
            }
        } else if (reactionQueryParams.f18633n != null) {
            return false;
        }
        if (this.f18634o != reactionQueryParams.f18634o || this.f18635p != reactionQueryParams.f18635p) {
            return false;
        }
        if (this.f18636q != null) {
            if (!this.f18636q.equals(reactionQueryParams.f18636q)) {
                return false;
            }
        } else if (reactionQueryParams.f18636q != null) {
            return false;
        }
        if (!this.f18637r.equals(reactionQueryParams.f18637r) || !this.f18638s.equals(reactionQueryParams.f18638s)) {
            return false;
        }
        if (this.f18639t != null) {
            if (!this.f18639t.equals(reactionQueryParams.f18639t)) {
                return false;
            }
        } else if (reactionQueryParams.f18639t != null) {
            return false;
        }
        if (this.f18640u != null) {
            if (!this.f18640u.equals(reactionQueryParams.f18640u)) {
                return false;
            }
        } else if (reactionQueryParams.f18640u != null) {
            return false;
        }
        if (!this.f18641v.equals(reactionQueryParams.f18641v)) {
            return false;
        }
        if (this.f18642w != null) {
            if (!this.f18642w.equals(reactionQueryParams.f18642w)) {
                return false;
            }
        } else if (reactionQueryParams.f18642w != null) {
            return false;
        }
        if (this.f18643x != null) {
            if (!this.f18643x.equals(reactionQueryParams.f18643x)) {
                return false;
            }
        } else if (reactionQueryParams.f18643x != null) {
            return false;
        }
        if (this.f18644y != null) {
            if (!this.f18644y.equals(reactionQueryParams.f18644y)) {
                return false;
            }
        } else if (reactionQueryParams.f18644y != null) {
            return false;
        }
        return this.f18645z.equals(reactionQueryParams.f18645z);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (((this.f18620a != null ? this.f18620a.hashCode() : 0) * 31) + ((int) (this.f18621b ^ (this.f18621b >>> 32)))) * 31;
        if (this.f18622c != null) {
            hashCode = this.f18622c.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18623d != null) {
            hashCode = this.f18623d.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18624e != null) {
            hashCode = this.f18624e.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (((hashCode + hashCode2) * 31) + this.f18625f.hashCode()) * 31;
        if (this.f18626g != null) {
            hashCode = this.f18626g.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (((hashCode + hashCode2) * 31) + this.f18627h.hashCode()) * 31;
        if (this.f18628i != null) {
            hashCode = this.f18628i.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18629j != null) {
            hashCode = this.f18629j.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18630k != null) {
            hashCode = this.f18630k.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18631l != null) {
            hashCode = this.f18631l.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18632m != null) {
            hashCode = this.f18632m.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18633n != null) {
            hashCode = this.f18633n.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18634o != null) {
            hashCode = this.f18634o.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18635p != null) {
            hashCode = this.f18635p.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18636q != null) {
            hashCode = this.f18636q.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (((((hashCode + hashCode2) * 31) + this.f18637r.hashCode()) * 31) + this.f18638s.hashCode()) * 31;
        if (this.f18639t != null) {
            hashCode = this.f18639t.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18640u != null) {
            hashCode = this.f18640u.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (((hashCode + hashCode2) * 31) + this.f18641v.hashCode()) * 31;
        if (this.f18642w != null) {
            hashCode = this.f18642w.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18643x != null) {
            hashCode = this.f18643x.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f18644y != null) {
            hashCode = this.f18644y.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((hashCode + hashCode2) * 31) + this.f18645z.hashCode()) * 31;
        if (this.f18619A) {
            i = 1;
        }
        return hashCode + i;
    }

    public int describeContents() {
        return 0;
    }
}

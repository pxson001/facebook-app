package com.facebook.story;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: selector */
public class UpdateTimelineAppCollectionParams implements Parcelable {
    public static final Creator<?> CREATOR = new C03031();
    public final String f5024a;
    public final String f5025b;
    public final Action f5026c;
    public final CurationSurface f5027d;
    public final CurationMechanism f5028e;
    public final GraphQLObjectType f5029f;
    public final String f5030g;
    public final ImmutableList<String> f5031h;
    public final String f5032i;
    public final boolean f5033j;
    public final String f5034k;
    public final String f5035l;

    /* compiled from: selector */
    final class C03031 implements Creator<UpdateTimelineAppCollectionParams> {
        C03031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateTimelineAppCollectionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateTimelineAppCollectionParams[i];
        }
    }

    /* compiled from: selector */
    public enum Action {
        ADD("ADD"),
        REMOVE("REMOVE");
        
        private final String mAction;

        private Action(String str) {
            this.mAction = str;
        }

        public final String toString() {
            return this.mAction;
        }
    }

    /* compiled from: selector */
    public class Builder {
        public String f5012a;
        public String f5013b;
        public Action f5014c;
        public CurationSurface f5015d;
        public CurationMechanism f5016e;
        public GraphQLObjectType f5017f;
        public String f5018g;
        public ImmutableList<String> f5019h;
        public String f5020i;
        public boolean f5021j = true;
        public String f5022k;
        public String f5023l;

        public Builder(UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
            this.f5012a = updateTimelineAppCollectionParams.f5024a;
            this.f5013b = updateTimelineAppCollectionParams.f5025b;
            this.f5014c = updateTimelineAppCollectionParams.f5026c;
            this.f5015d = updateTimelineAppCollectionParams.f5027d;
            this.f5016e = updateTimelineAppCollectionParams.f5028e;
            this.f5017f = updateTimelineAppCollectionParams.f5029f;
            this.f5018g = updateTimelineAppCollectionParams.f5030g;
            this.f5019h = updateTimelineAppCollectionParams.f5031h;
            this.f5020i = updateTimelineAppCollectionParams.f5032i;
            this.f5021j = updateTimelineAppCollectionParams.f5033j;
            this.f5022k = updateTimelineAppCollectionParams.f5034k;
            this.f5023l = updateTimelineAppCollectionParams.f5035l;
        }

        public final UpdateTimelineAppCollectionParams m7773a() {
            return new UpdateTimelineAppCollectionParams(this);
        }
    }

    public UpdateTimelineAppCollectionParams(Builder builder) {
        this.f5024a = builder.f5012a;
        this.f5025b = builder.f5013b;
        this.f5026c = builder.f5014c;
        this.f5027d = builder.f5015d;
        this.f5028e = builder.f5016e;
        this.f5029f = builder.f5017f;
        this.f5030g = builder.f5018g;
        this.f5031h = builder.f5019h;
        this.f5032i = builder.f5020i;
        this.f5033j = builder.f5021j;
        this.f5034k = builder.f5022k;
        this.f5035l = builder.f5023l;
    }

    public UpdateTimelineAppCollectionParams(Parcel parcel) {
        this.f5024a = parcel.readString();
        this.f5025b = parcel.readString();
        this.f5026c = (Action) parcel.readSerializable();
        this.f5027d = (CurationSurface) parcel.readSerializable();
        this.f5028e = (CurationMechanism) parcel.readSerializable();
        this.f5029f = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
        this.f5030g = parcel.readString();
        this.f5031h = ImmutableListHelper.a(parcel.createStringArrayList());
        this.f5032i = parcel.readString();
        this.f5033j = ParcelUtil.a(parcel);
        this.f5034k = parcel.readString();
        this.f5035l = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5024a);
        parcel.writeString(this.f5025b);
        parcel.writeSerializable(this.f5026c);
        parcel.writeSerializable(this.f5027d);
        parcel.writeSerializable(this.f5028e);
        parcel.writeParcelable(this.f5029f, i);
        parcel.writeString(this.f5030g);
        parcel.writeStringList(this.f5031h);
        parcel.writeString(this.f5032i);
        ParcelUtil.a(parcel, this.f5033j);
        parcel.writeString(this.f5034k);
        parcel.writeString(this.f5035l);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper(UpdateTimelineAppCollectionParams.class).add("collectionId", this.f5024a).add("itemId", this.f5025b).add("action", this.f5026c).add("curationSurface", this.f5027d).add("curationMechanism", this.f5028e).add("parentUnitType", this.f5029f == null ? "null" : this.f5029f.toString()).add("privacy", this.f5030g).add("storyCacheIds", this.f5031h).add("attachmentDedupKey", this.f5032i).add("isSaveCollection", this.f5033j).add("tracking", this.f5034k).add("sourceStoryId", this.f5035l).toString();
    }

    @Nullable
    public final Action m7774c() {
        return this.f5026c;
    }
}

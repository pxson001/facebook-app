package com.facebook.events.permalink.guestlist.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.events.common.EventActionContext;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.google.common.collect.ImmutableList;

/* compiled from: header_like_tap */
public class EventsGuestListInitializationModel implements Parcelable {
    public static final Creator<EventsGuestListInitializationModel> CREATOR = new C12501();
    public EventActionContext f11466a;
    public String f11467b;
    public String f11468c;
    private GraphQLEventPrivacyType f11469d;
    private GraphQLConnectionStyle f11470e;
    public GraphQLEventGuestStatus f11471f;
    public boolean f11472g;
    public ImmutableList<EventGuestSingleListModel> f11473h;
    public boolean f11474i;

    /* compiled from: header_like_tap */
    final class C12501 implements Creator<EventsGuestListInitializationModel> {
        C12501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventsGuestListInitializationModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventsGuestListInitializationModel[i];
        }
    }

    /* compiled from: header_like_tap */
    public class Builder {
        public EventActionContext f11457a;
        public String f11458b;
        public String f11459c;
        public GraphQLEventPrivacyType f11460d;
        public GraphQLConnectionStyle f11461e;
        public GraphQLEventGuestStatus f11462f;
        public boolean f11463g;
        public ImmutableList<EventGuestSingleListModel> f11464h;
        public boolean f11465i;

        public Builder(String str) {
            this.f11458b = str;
        }

        public final EventsGuestListInitializationModel m13391a() {
            return new EventsGuestListInitializationModel(this);
        }

        public final Builder m13384a(EventActionContext eventActionContext) {
            this.f11457a = eventActionContext;
            return this;
        }

        public final Builder m13389a(String str) {
            this.f11459c = str;
            return this;
        }

        public final Builder m13387a(GraphQLEventPrivacyType graphQLEventPrivacyType) {
            this.f11460d = graphQLEventPrivacyType;
            return this;
        }

        public final Builder m13385a(GraphQLConnectionStyle graphQLConnectionStyle) {
            this.f11461e = graphQLConnectionStyle;
            return this;
        }

        public final Builder m13386a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.f11462f = graphQLEventGuestStatus;
            return this;
        }

        public final Builder m13390a(boolean z) {
            this.f11463g = z;
            return this;
        }

        public final Builder m13388a(ImmutableList<EventGuestSingleListModel> immutableList) {
            this.f11464h = immutableList;
            return this;
        }

        public final Builder m13392b(boolean z) {
            this.f11465i = z;
            return this;
        }
    }

    public EventsGuestListInitializationModel(Builder builder) {
        this.f11466a = builder.f11457a;
        this.f11467b = builder.f11458b;
        this.f11468c = builder.f11459c;
        this.f11469d = builder.f11460d;
        this.f11470e = builder.f11461e;
        this.f11471f = builder.f11462f;
        this.f11472g = builder.f11463g;
        this.f11473h = builder.f11464h;
        this.f11474i = builder.f11465i;
    }

    public EventsGuestListInitializationModel(Parcel parcel) {
        ImmutableList immutableList;
        this.f11466a = (EventActionContext) parcel.readParcelable(EventActionContext.class.getClassLoader());
        this.f11467b = parcel.readString();
        this.f11468c = parcel.readString();
        this.f11469d = GraphQLEventPrivacyType.fromString(parcel.readString());
        this.f11470e = GraphQLConnectionStyle.fromString(parcel.readString());
        this.f11471f = GraphQLEventGuestStatus.fromString(parcel.readString());
        this.f11472g = ParcelUtil.a(parcel);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(EventGuestSingleListModel.class.getClassLoader());
        if (readParcelableArray == null) {
            immutableList = null;
        } else {
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
            for (Parcelable parcelable : readParcelableArray) {
                builder.c((EventGuestSingleListModel) parcelable);
            }
            immutableList = builder.b();
        }
        this.f11473h = immutableList;
        this.f11474i = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String graphQLConnectionStyle;
        Parcelable[] parcelableArr;
        String str = null;
        parcel.writeParcelable(this.f11466a, i);
        parcel.writeString(this.f11467b);
        parcel.writeString(this.f11468c);
        parcel.writeString(this.f11469d != null ? this.f11469d.toString() : null);
        if (this.f11470e != null) {
            graphQLConnectionStyle = this.f11470e.toString();
        } else {
            graphQLConnectionStyle = null;
        }
        parcel.writeString(graphQLConnectionStyle);
        if (this.f11471f != null) {
            str = this.f11471f.toString();
        }
        parcel.writeString(str);
        ParcelUtil.a(parcel, this.f11472g);
        ImmutableList immutableList = this.f11473h;
        if (immutableList == null) {
            parcelableArr = null;
        } else {
            parcelableArr = (Parcelable[]) immutableList.toArray(new Parcelable[immutableList.size()]);
        }
        parcel.writeParcelableArray(parcelableArr, i);
        ParcelUtil.a(parcel, this.f11474i);
    }

    public final GraphQLEventPrivacyType m13393d() {
        return this.f11469d != null ? this.f11469d : GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public final GraphQLConnectionStyle m13394e() {
        return this.f11470e != null ? this.f11470e : GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

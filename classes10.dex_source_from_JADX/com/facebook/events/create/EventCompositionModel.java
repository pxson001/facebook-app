package com.facebook.events.create;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.events.create.ui.EventCategoryModel;
import com.facebook.events.create.ui.EventCohostsModel;
import com.facebook.events.create.ui.EventCoverPhotoModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.ui.date.EventTimeModel;
import com.facebook.events.ui.location.EventLocationModel;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/* compiled from: contact_upload_upsell_learn_more */
public class EventCompositionModel implements Parcelable {
    public static final Creator<EventCompositionModel> CREATOR = new C22381();
    public EventCompositionModel f16043a;
    private String f16044b;
    public String f16045c;
    public String f16046d;
    private PrivacyType f16047e;
    private boolean f16048f;
    public EventCoverPhotoModel f16049g = new EventCoverPhotoModel();
    public EventTimeModel f16050h = new EventTimeModel();
    public EventLocationModel f16051i = new EventLocationModel();
    public EventCohostsModel f16052j = new EventCohostsModel();
    public EventCategoryModel f16053k = new EventCategoryModel();
    private String f16054l;
    private String f16055m;

    /* compiled from: contact_upload_upsell_learn_more */
    final class C22381 implements Creator<EventCompositionModel> {
        C22381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventCompositionModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventCompositionModel[i];
        }
    }

    public EventCompositionModel(Event event) {
        this.f16045c = event.b;
        this.f16046d = MentionsUtils.a(event.c);
        EventCoverPhotoModel eventCoverPhotoModel = this.f16049g;
        eventCoverPhotoModel.f16327a = event.V;
        eventCoverPhotoModel = eventCoverPhotoModel;
        eventCoverPhotoModel.f16329c = event.W;
        eventCoverPhotoModel.f16330d = event.X;
        this.f16053k.f16317b = event.aj;
        this.f16050h.m19539a(event.M, event.L, event.J() == null ? 0 : event.K(), event.L() == null ? 0 : event.M());
        EventLocationModel eventLocationModel = this.f16051i;
        eventLocationModel.f19462b = event.O;
        eventLocationModel.f19463c = event.P;
        EventCohostsModel a = this.f16052j.m16805a(event.p);
        a.f16325b = event.n;
        a.f16326c = event.o;
    }

    public final void m16447a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(this);
        obtain.setDataPosition(0);
        this.f16043a = (EventCompositionModel) obtain.readValue(EventCompositionModel.class.getClassLoader());
        obtain.recycle();
    }

    public final boolean m16448c() {
        return !Strings.isNullOrEmpty(this.f16046d);
    }

    public final boolean m16449j() {
        Preconditions.checkNotNull(this.f16043a);
        return !Objects.equal(this.f16043a.f16052j.f16324a, this.f16052j.f16324a);
    }

    public final ImmutableList<String> m16450l() {
        Preconditions.checkNotNull(this.f16043a);
        return m16446a(this.f16043a.f16052j.f16324a, this.f16052j.f16324a);
    }

    public static ImmutableList<String> m16446a(ImmutableList<String> immutableList, ImmutableList<String> immutableList2) {
        return ImmutableList.copyOf(Sets.c(ImmutableSet.copyOf(immutableList), ImmutableSet.copyOf(immutableList2)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f16043a, i);
        parcel.writeString(this.f16044b);
        parcel.writeString(this.f16045c);
        parcel.writeString(this.f16046d);
        parcel.writeParcelable(this.f16047e, i);
        ParcelUtil.a(parcel, this.f16048f);
        parcel.writeParcelable(this.f16049g, i);
        parcel.writeParcelable(this.f16050h, i);
        parcel.writeParcelable(this.f16051i, i);
        parcel.writeParcelable(this.f16052j, i);
        parcel.writeParcelable(this.f16053k, i);
        parcel.writeString(this.f16054l);
        parcel.writeString(this.f16055m);
    }

    public EventCompositionModel(Parcel parcel) {
        this.f16043a = (EventCompositionModel) parcel.readParcelable(EventCompositionModel.class.getClassLoader());
        this.f16044b = parcel.readString();
        this.f16045c = parcel.readString();
        this.f16046d = parcel.readString();
        this.f16047e = (PrivacyType) parcel.readParcelable(PrivacyType.class.getClassLoader());
        this.f16048f = ParcelUtil.a(parcel);
        this.f16049g = (EventCoverPhotoModel) parcel.readParcelable(EventCoverPhotoModel.class.getClassLoader());
        this.f16050h = (EventTimeModel) parcel.readParcelable(EventTimeModel.class.getClassLoader());
        this.f16051i = (EventLocationModel) parcel.readParcelable(EventLocationModel.class.getClassLoader());
        this.f16052j = (EventCohostsModel) parcel.readParcelable(EventCohostsModel.class.getClassLoader());
        this.f16053k = (EventCategoryModel) parcel.readParcelable(EventCategoryModel.class.getClassLoader());
        this.f16054l = parcel.readString();
        this.f16055m = parcel.readString();
    }
}

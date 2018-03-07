package com.facebook.composer.minutiae.util;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment;
import com.facebook.composer.minutiae.MinutiaeTagPickerActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.FlowableTaggableActivityModel;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Stack;
import javax.annotation.Nullable;

/* compiled from: text_flow_entries */
public class MinutiaeConfiguration implements Parcelable {
    public static final Creator<MinutiaeConfiguration> CREATOR = new C01881();
    public final String f1835a;
    public final TargetFragment f1836b;
    public final List<? extends MinutiaeTaggableSuggestions> f1837c;
    public final MinutiaeObject f1838d;
    public final MinutiaeTaggableActivity f1839e;
    public final CheckinPlaceModel f1840f;
    public final boolean f1841g;
    public final Action f1842h;
    public final ComposerConfiguration f1843i;
    public final boolean f1844j;
    public final boolean f1845k;
    public final String f1846l;
    @Nullable
    public final String f1847m;
    public Stack<TargetFragment> f1848n;

    /* compiled from: text_flow_entries */
    final class C01881 implements Creator<MinutiaeConfiguration> {
        C01881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MinutiaeConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new MinutiaeConfiguration[i];
        }
    }

    /* compiled from: text_flow_entries */
    public enum Action {
        LAUNCH_COMPOSER,
        NONE
    }

    /* compiled from: text_flow_entries */
    public class Builder {
        public String f1822a;
        public TargetFragment f1823b;
        public List<? extends MinutiaeTaggableSuggestions> f1824c;
        public MinutiaeObject f1825d;
        public MinutiaeTaggableActivity f1826e;
        private CheckinPlaceModel f1827f;
        public boolean f1828g;
        public Action f1829h;
        public ComposerConfiguration f1830i;
        public boolean f1831j;
        private boolean f1832k;
        public String f1833l;
        public String f1834m;

        public Builder(MinutiaeConfiguration minutiaeConfiguration) {
            this.f1822a = minutiaeConfiguration.f1835a;
            this.f1823b = minutiaeConfiguration.f1836b;
            this.f1824c = minutiaeConfiguration.f1837c;
            this.f1825d = minutiaeConfiguration.f1838d;
            this.f1826e = minutiaeConfiguration.f1839e;
            this.f1827f = minutiaeConfiguration.f1840f;
            this.f1828g = minutiaeConfiguration.f1841g;
            this.f1829h = minutiaeConfiguration.f1842h;
            this.f1830i = minutiaeConfiguration.f1843i;
            this.f1831j = minutiaeConfiguration.f1844j;
            this.f1832k = minutiaeConfiguration.f1845k;
            this.f1833l = minutiaeConfiguration.f1846l;
            this.f1834m = minutiaeConfiguration.f1847m;
        }

        public final Builder m1810a(CheckinPlaceModel checkinPlaceModel) {
            this.f1827f = CheckinPlaceModel.a(checkinPlaceModel);
            return this;
        }

        public final MinutiaeConfiguration m1811a() {
            return new MinutiaeConfiguration(this.f1822a, this.f1823b, this.f1824c, this.f1825d, this.f1826e, this.f1827f, this.f1828g, this.f1829h, this.f1830i, this.f1831j, this.f1832k, this.f1833l, this.f1834m);
        }

        public final Intent m1809a(Context context) {
            Parcelable a = m1811a();
            Intent intent = new Intent(context, MinutiaeTagPickerActivity.class);
            intent.putExtra("minutiae_configuration", a);
            return intent;
        }
    }

    private MinutiaeConfiguration(String str, TargetFragment targetFragment, List<? extends MinutiaeTaggableSuggestions> list, MinutiaeObject minutiaeObject, MinutiaeTaggableActivity minutiaeTaggableActivity, CheckinPlaceModel checkinPlaceModel, boolean z, Action action, ComposerConfiguration composerConfiguration, boolean z2, boolean z3, String str2, String str3) {
        this.f1848n = new Stack();
        this.f1835a = str;
        this.f1836b = targetFragment;
        this.f1837c = list;
        this.f1838d = minutiaeObject;
        this.f1839e = minutiaeTaggableActivity;
        this.f1840f = checkinPlaceModel;
        this.f1841g = z;
        this.f1842h = action;
        this.f1843i = composerConfiguration;
        this.f1844j = z2;
        this.f1845k = z3;
        this.f1846l = str2;
        this.f1847m = str3;
        boolean z4 = (targetFragment == null || targetFragment == TargetFragment.UNKNOWN) ? false : true;
        Preconditions.checkArgument(z4);
        if (targetFragment == TargetFragment.OBJECT_PICKER) {
            m1814h();
        }
    }

    private void m1814h() {
        int i;
        int i2 = 1;
        if (this.f1840f == null || this.f1840f.p() == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f1839e == null) {
            i2 = 0;
        }
        Preconditions.checkArgument(i ^ i2, "Exactly one of taggable activity and taggable activity suggestions must be provided");
    }

    public MinutiaeConfiguration(Parcel parcel) {
        boolean z;
        int i = 0;
        this.f1848n = new Stack();
        this.f1835a = parcel.readString();
        this.f1836b = TargetFragment.valueOf(parcel.readString());
        this.f1837c = FlatBufferModelHelper.b(parcel);
        this.f1838d = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        this.f1839e = (MinutiaeTaggableActivity) FlatBufferModelHelper.a(parcel);
        this.f1840f = (CheckinPlaceModel) FlatBufferModelHelper.a(parcel);
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f1841g = z;
        this.f1842h = (Action) ParcelUtil.c(parcel, Action.class);
        this.f1843i = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        int readInt = parcel.readInt();
        while (i < readInt) {
            this.f1848n.push(TargetFragment.fromString(parcel.readString()));
            i++;
        }
        this.f1844j = ParcelUtil.a(parcel);
        this.f1845k = ParcelUtil.a(parcel);
        this.f1846l = parcel.readString();
        this.f1847m = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 0;
        parcel.writeString(this.f1835a);
        parcel.writeString(this.f1836b.name());
        FlatBufferModelHelper.a(parcel, this.f1837c);
        parcel.writeParcelable(this.f1838d, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f1839e);
        FlatBufferModelHelper.a(parcel, this.f1840f);
        if (this.f1841g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        ParcelUtil.a(parcel, this.f1842h);
        parcel.writeParcelable(this.f1843i, i);
        parcel.writeInt(this.f1848n.size());
        int size = this.f1848n.size();
        while (i3 < size) {
            parcel.writeString(((TargetFragment) this.f1848n.get(i3)).getFragmentName());
            i3++;
        }
        ParcelUtil.a(parcel, this.f1844j);
        ParcelUtil.a(parcel, this.f1845k);
        parcel.writeString(this.f1846l);
        parcel.writeString(this.f1847m);
    }

    public static MinutiaeConfiguration m1812a(Intent intent) {
        Preconditions.checkArgument(intent.hasExtra("minutiae_configuration"));
        MinutiaeConfiguration minutiaeConfiguration = (MinutiaeConfiguration) intent.getParcelableExtra("minutiae_configuration");
        if (minutiaeConfiguration.f1835a != null) {
            return minutiaeConfiguration;
        }
        Builder c = minutiaeConfiguration.m1815c();
        c.f1822a = SafeUUIDGenerator.a().toString();
        return c.m1811a();
    }

    public static Builder m1813b() {
        return new Builder();
    }

    public final Builder m1815c() {
        return new Builder(this);
    }

    public final boolean m1816f() {
        return (this.f1840f == null || this.f1840f.p() == null) ? false : true;
    }

    public final FlowableTaggableActivityModel m1817g() {
        return this.f1840f != null ? this.f1840f.p() : null;
    }
}

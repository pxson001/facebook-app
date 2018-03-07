package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;

/* compiled from: instant_articles_ads_x_out_data_capture */
public class OrganicImpression extends BaseImpression {
    public static final Creator<OrganicImpression> CREATOR = new C07821();
    public static final OrganicImpression f19775n = new OrganicImpression(false, false);
    @JsonIgnore
    private boolean f19776o;
    @JsonIgnore
    private boolean f19777p;

    /* compiled from: instant_articles_ads_x_out_data_capture */
    final class C07821 implements Creator<OrganicImpression> {
        C07821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OrganicImpression(parcel);
        }

        public final Object[] newArray(int i) {
            return new OrganicImpression[i];
        }
    }

    public OrganicImpression(boolean z, boolean z2) {
        this.f19776o = z;
        this.f19777p = z2;
    }

    public OrganicImpression(Parcel parcel) {
        super(parcel);
        this.f19776o = ParcelUtil.a(parcel);
        this.f19777p = ParcelUtil.a(parcel);
    }

    public final void m27473l() {
        this.j = 50;
        this.k = 1000;
        this.f19776o = false;
    }

    public final boolean mo3121k() {
        return this.f19776o && this.f19777p;
    }

    public final boolean mo3118a() {
        return false;
    }

    public final boolean mo3119b() {
        return false;
    }

    public final boolean mo3120c() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        ParcelUtil.a(parcel, this.f19776o);
        ParcelUtil.a(parcel, this.f19777p);
    }

    public static OrganicImpression m27468a(GraphQLStory graphQLStory) {
        OrganicImpression organicImpression = PropertyHelper.m21261a((Object) graphQLStory).f14874w;
        if (organicImpression != null) {
            return organicImpression;
        }
        int a;
        OrganicImpression organicImpression2;
        int i = 0;
        if (graphQLStory != null) {
            a = StoryActorHelper.m27491a(graphQLStory) | 0;
            if (graphQLStory.m22326L() != null) {
                a |= StoryActorHelper.m27491a(graphQLStory.m22326L());
            }
            if (StoryHierarchyHelper.m27434a(graphQLStory) != null) {
                ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
                int i2 = 0;
                i = a;
                while (i2 < j.size()) {
                    a = StoryActorHelper.m27491a((GraphQLStory) j.get(i2)) | i;
                    i2++;
                    i = a;
                }
            }
            if (a == 0) {
                organicImpression2 = new OrganicImpression(true, true);
            } else {
                organicImpression2 = f19775n;
            }
            organicImpression = organicImpression2;
            PropertyHelper.m21261a((Object) graphQLStory).f14874w = organicImpression;
            return organicImpression;
        }
        a = i;
        if (a == 0) {
            organicImpression2 = f19775n;
        } else {
            organicImpression2 = new OrganicImpression(true, true);
        }
        organicImpression = organicImpression2;
        PropertyHelper.m21261a((Object) graphQLStory).f14874w = organicImpression;
        return organicImpression;
    }
}

package com.facebook.redspace.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceWallResult;
import com.facebook.redspace.model.RedSpaceHeaderSectionModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel;
import com.facebook.ultralight.Inject;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

/* compiled from: PrivacyCheckupProfileDataFetch */
public class RedSpaceHeaderCollection implements ListItemCollection<RedSpaceHeaderSectionModel> {
    private ImmutableList<RedSpaceHeaderSectionModel> f11811a;
    public RedSpaceHeaderSectionModel f11812b = new RedSpaceHeaderSectionModel();
    public RedSpaceHeaderSectionModel f11813c;
    public RedSpaceHeaderSectionModel f11814d;

    /* compiled from: PrivacyCheckupProfileDataFetch */
    public class State implements Parcelable {
        public static final Creator<State> CREATOR = new C13991();
        public final RedSpaceHeaderSectionModel f11808a;
        public final RedSpaceHeaderSectionModel f11809b;
        public final RedSpaceHeaderSectionModel f11810c;

        /* compiled from: PrivacyCheckupProfileDataFetch */
        final class C13991 implements Creator<State> {
            C13991() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(RedSpaceHeaderSectionModel redSpaceHeaderSectionModel, RedSpaceHeaderSectionModel redSpaceHeaderSectionModel2, RedSpaceHeaderSectionModel redSpaceHeaderSectionModel3) {
            this.f11808a = redSpaceHeaderSectionModel;
            this.f11809b = redSpaceHeaderSectionModel2;
            this.f11810c = redSpaceHeaderSectionModel3;
        }

        public State(Parcel parcel) {
            ClassLoader classLoader = State.class.getClassLoader();
            this.f11808a = (RedSpaceHeaderSectionModel) parcel.readParcelable(classLoader);
            this.f11809b = (RedSpaceHeaderSectionModel) parcel.readParcelable(classLoader);
            this.f11810c = (RedSpaceHeaderSectionModel) parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f11808a, 0);
            parcel.writeParcelable(this.f11809b, 0);
            parcel.writeParcelable(this.f11810c, 0);
        }

        public int describeContents() {
            return 0;
        }
    }

    public static RedSpaceHeaderCollection m12244a(InjectorLike injectorLike) {
        return new RedSpaceHeaderCollection((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RedSpaceStrings.a(injectorLike));
    }

    @Inject
    public RedSpaceHeaderCollection(QeAccessor qeAccessor, RedSpaceStrings redSpaceStrings) {
        if (qeAccessor.a(ExperimentsForRedSpaceExperimentsModule.l, false)) {
            this.f11812b.a = redSpaceStrings.j();
        }
        m12247d();
    }

    private void m12247d() {
        this.f11811a = ImmutableList.of(this.f11812b);
    }

    @VisibleForTesting
    private void m12245a(RedSpaceStoriesQueryModel redSpaceStoriesQueryModel) {
        if (redSpaceStoriesQueryModel != null && redSpaceStoriesQueryModel.j() != null) {
            RedspaceModel j = redSpaceStoriesQueryModel.j();
            if (j.a() != null) {
                this.f11812b.a(j.a().a());
            }
        }
    }

    @VisibleForTesting
    private void m12246a(@Nullable RedSpaceVisitsQueryModel redSpaceVisitsQueryModel) {
        if (redSpaceVisitsQueryModel == null || redSpaceVisitsQueryModel.a() == null || redSpaceVisitsQueryModel.a().a() == null) {
            this.f11812b.b = null;
            return;
        }
        this.f11812b.b = redSpaceVisitsQueryModel.a().a();
    }

    public final void m12251a(RedSpaceWallResult redSpaceWallResult) {
        RedSpaceVisitsQueryModel redSpaceVisitsQueryModel;
        m12245a((RedSpaceStoriesQueryModel) redSpaceWallResult.a().e);
        if (redSpaceWallResult.b() != null) {
            redSpaceVisitsQueryModel = (RedSpaceVisitsQueryModel) redSpaceWallResult.b().e;
        } else {
            redSpaceVisitsQueryModel = null;
        }
        m12246a(redSpaceVisitsQueryModel);
    }

    public final int m12248a() {
        return this.f11811a.size();
    }

    public final Object m12249a(int i) {
        return (RedSpaceHeaderSectionModel) this.f11811a.get(i);
    }

    public final void m12250a(@Nullable State state) {
        if (state != null) {
            this.f11812b = state.f11808a;
            this.f11813c = state.f11809b;
            this.f11814d = state.f11810c;
            m12247d();
        }
    }
}

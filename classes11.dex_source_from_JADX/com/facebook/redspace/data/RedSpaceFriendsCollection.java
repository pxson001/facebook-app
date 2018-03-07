package com.facebook.redspace.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.ApproximateCountModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpacePageInfoModel;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;

/* compiled from: PrivacyGenericCheckupActivity no review_id for query */
public class RedSpaceFriendsCollection implements Parcelable, IHaveUserData {
    public static final Creator<RedSpaceFriendsCollection> CREATOR = new C13941();
    @VisibleForTesting
    public OverflowFriendsModel f11774a;
    public List<RedSpaceFeedProfileFragmentModel> f11775b;
    public RedSpacePageInfoModel f11776c;

    /* compiled from: PrivacyGenericCheckupActivity no review_id for query */
    final class C13941 implements Creator<RedSpaceFriendsCollection> {
        C13941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RedSpaceFriendsCollection(parcel);
        }

        public final Object[] newArray(int i) {
            return new RedSpaceFriendsCollection[i];
        }
    }

    public static RedSpaceFriendsCollection m12212a(InjectorLike injectorLike) {
        return new RedSpaceFriendsCollection();
    }

    public final void m12214a(RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        this.f11775b = RedSpaceMutator.m12298a(this.f11775b, redSpaceFriendsFetchResult.f11777a);
        this.f11776c = RedSpaceMutator.m12295a(this.f11776c, redSpaceFriendsFetchResult.f11779c);
        OverflowFriendsModel overflowFriendsModel = redSpaceFriendsFetchResult.f11778b;
        if (overflowFriendsModel != null) {
            this.f11774a = overflowFriendsModel;
        }
    }

    public final void m12217a(RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        this.f11775b = RedSpaceMutator.m12299a(this.f11775b, redSpaceFeedProfileFragmentModelArr);
    }

    public final void m12216a(boolean z, RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        this.f11775b = z ? RedSpaceMutator.m12301b(this.f11775b, redSpaceFeedProfileFragmentModelArr) : RedSpaceMutator.m12303c(this.f11775b, redSpaceFeedProfileFragmentModelArr);
    }

    public final void m12220b(RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        this.f11775b = RedSpaceMutator.m12304d(this.f11775b, redSpaceFeedProfileFragmentModelArr);
    }

    public final void m12215a(ApproximateCountModel approximateCountModel) {
        this.f11774a = RedSpaceMutator.m12293a(this.f11774a, approximateCountModel);
    }

    public final boolean m12218a() {
        if (this.f11776c == null) {
            return true;
        }
        if (!this.f11776c.j() || TextUtils.isEmpty(this.f11776c.a())) {
            return false;
        }
        return true;
    }

    public final String m12219b() {
        if (this.f11776c == null) {
            return null;
        }
        RedSpacePageInfoModel redSpacePageInfoModel = this.f11776c;
        if (redSpacePageInfoModel != null) {
            return redSpacePageInfoModel.a();
        }
        return null;
    }

    public final RedSpacePageInfoModel m12221c() {
        return this.f11776c;
    }

    public final int m12222d() {
        return this.f11775b == null ? 0 : this.f11775b.size();
    }

    public final RedSpaceFeedProfileFragmentModel m12213a(int i) {
        return (RedSpaceFeedProfileFragmentModel) this.f11775b.get(i);
    }

    public final boolean m12223e() {
        return (this.f11774a == null || m12218a() || (this.f11774a.a().a() <= 0 && this.f11774a.j().isEmpty())) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    @CallSuper
    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f11775b);
        FlatBufferModelHelper.a(parcel, this.f11776c);
        FlatBufferModelHelper.a(parcel, this.f11774a);
    }

    @CallSuper
    public void mo333g() {
        this.f11775b = null;
        this.f11776c = null;
        this.f11774a = null;
    }

    protected RedSpaceFriendsCollection(Parcel parcel) {
        this.f11775b = FlatBufferModelHelper.b(parcel);
        this.f11776c = (RedSpacePageInfoModel) FlatBufferModelHelper.a(parcel);
        this.f11774a = (OverflowFriendsModel) FlatBufferModelHelper.a(parcel);
    }

    public final void clearUserData() {
        mo333g();
    }
}

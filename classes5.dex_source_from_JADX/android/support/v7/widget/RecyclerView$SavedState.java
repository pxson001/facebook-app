package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View.BaseSavedState;

/* compiled from: trending_stories */
class RecyclerView$SavedState extends BaseSavedState {
    public static final Creator<RecyclerView$SavedState> CREATOR = new C00701();
    Parcelable f1415a;

    /* compiled from: trending_stories */
    final class C00701 implements Creator<RecyclerView$SavedState> {
        C00701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RecyclerView$SavedState(parcel);
        }

        public final Object[] newArray(int i) {
            return new RecyclerView$SavedState[i];
        }
    }

    RecyclerView$SavedState(Parcel parcel) {
        super(parcel);
        this.f1415a = parcel.readParcelable(LayoutManager.class.getClassLoader());
    }

    RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f1415a, 0);
    }

    private void m1943a(RecyclerView$SavedState recyclerView$SavedState) {
        this.f1415a = recyclerView$SavedState.f1415a;
    }
}

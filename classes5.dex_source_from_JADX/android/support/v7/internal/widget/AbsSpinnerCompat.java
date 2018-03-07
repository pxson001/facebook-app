package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

/* compiled from: unknown_report_place */
public abstract class AbsSpinnerCompat extends AdapterViewCompat<SpinnerAdapter> {
    private DataSetObserver f975E;
    public SpinnerAdapter f976a;
    int f977b;
    int f978c;
    int f979d = 0;
    int f980e = 0;
    int f981f = 0;
    int f982g = 0;
    final Rect f983h = new Rect();
    public final RecycleBin f984i = new RecycleBin(this);

    /* compiled from: unknown_report_place */
    public class RecycleBin {
        final /* synthetic */ AbsSpinnerCompat f945a;
        private final SparseArray<View> f946b = new SparseArray();

        RecycleBin(AbsSpinnerCompat absSpinnerCompat) {
            this.f945a = absSpinnerCompat;
        }

        public final void m1495a(int i, View view) {
            this.f946b.put(i, view);
        }

        final View m1493a(int i) {
            View view = (View) this.f946b.get(i);
            if (view != null) {
                this.f946b.delete(i);
            }
            return view;
        }

        final void m1494a() {
            SparseArray sparseArray = this.f946b;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View view = (View) sparseArray.valueAt(i);
                if (view != null) {
                    this.f945a.removeDetachedView(view, true);
                }
            }
            sparseArray.clear();
        }
    }

    /* compiled from: unknown_report_place */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00481();
        long f947a;
        int f948b;

        /* compiled from: unknown_report_place */
        final class C00481 implements Creator<SavedState> {
            C00481() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f947a = parcel.readLong();
            this.f948b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f947a);
            parcel.writeInt(this.f948b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f947a + " position=" + this.f948b + "}";
        }
    }

    abstract void mo338c();

    public /* synthetic */ void setAdapter(Adapter adapter) {
        mo374a((SpinnerAdapter) adapter);
    }

    AbsSpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(true);
        setWillNotDraw(false);
    }

    public void mo374a(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.f976a != null) {
            this.f976a.unregisterDataSetObserver(this.f975E);
            m1509a();
        }
        this.f976a = spinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f976a != null) {
            this.A = this.f974z;
            this.z = this.f976a.getCount();
            m1505e();
            this.f975E = new AdapterDataSetObserver(this);
            this.f976a.registerDataSetObserver(this.f975E);
            if (this.f974z > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.f974z == 0) {
                m1507g();
            }
        } else {
            m1505e();
            m1509a();
            m1507g();
        }
        requestLayout();
    }

    final void m1509a() {
        this.u = false;
        this.o = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int mode = MeasureSpec.getMode(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.f983h;
        if (paddingLeft <= this.f979d) {
            paddingLeft = this.f979d;
        }
        rect.left = paddingLeft;
        this.f983h.top = paddingTop > this.f980e ? paddingTop : this.f980e;
        this.f983h.right = paddingRight > this.f981f ? paddingRight : this.f981f;
        this.f983h.bottom = paddingBottom > this.f982g ? paddingBottom : this.f982g;
        if (this.f969u) {
            m1506f();
        }
        paddingTop = this.f970v;
        if (paddingTop >= 0 && this.f976a != null && paddingTop < this.f976a.getCount()) {
            View a = this.f984i.m1493a(paddingTop);
            if (a == null) {
                a = this.f976a.getView(paddingTop, null, this);
            }
            if (a != null) {
                this.f984i.m1495a(paddingTop, a);
                if (a.getLayoutParams() == null) {
                    this.D = true;
                    a.setLayoutParams(generateDefaultLayoutParams());
                    this.D = false;
                }
                measureChild(a, i, i2);
                paddingTop = (a.getMeasuredHeight() + this.f983h.top) + this.f983h.bottom;
                paddingLeft = (a.getMeasuredWidth() + this.f983h.left) + this.f983h.right;
                z = false;
                if (z) {
                    paddingTop = this.f983h.top + this.f983h.bottom;
                    if (mode == 0) {
                        paddingLeft = this.f983h.left + this.f983h.right;
                    }
                }
                setMeasuredDimension(ViewCompat.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), ViewCompat.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
                this.f977b = i2;
                this.f978c = i;
            }
        }
        z = true;
        paddingLeft = 0;
        paddingTop = 0;
        if (z) {
            paddingTop = this.f983h.top + this.f983h.bottom;
            if (mode == 0) {
                paddingLeft = this.f983h.left + this.f983h.right;
            }
        }
        setMeasuredDimension(ViewCompat.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), ViewCompat.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
        this.f977b = i2;
        this.f978c = i;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public View getSelectedView() {
        if (this.f974z <= 0 || this.f972x < 0) {
            return null;
        }
        return getChildAt(this.f972x - this.f958j);
    }

    public void requestLayout() {
        if (!this.f952D) {
            super.requestLayout();
        }
    }

    public /* synthetic */ Adapter getAdapter() {
        return this.f976a;
    }

    public int getCount() {
        return this.f974z;
    }

    public Parcelable onSaveInstanceState() {
        Object savedState = new SavedState(super.onSaveInstanceState());
        savedState.f947a = this.f971w;
        if (savedState.f947a >= 0) {
            savedState.f948b = this.f970v;
        } else {
            savedState.f948b = -1;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f947a >= 0) {
            this.u = true;
            this.o = true;
            this.m = savedState.f947a;
            this.l = savedState.f948b;
            this.p = 0;
            requestLayout();
        }
    }
}

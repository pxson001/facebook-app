package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.AbsSpinnerCompat.RecycleBin;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: underlying_entity */
public class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
    int f1191E;
    private ForwardingListener f1192F;
    public SpinnerPopup f1193G;
    private DropDownAdapter f1194H;
    private int f1195I;
    private boolean f1196J;
    private Rect f1197K;
    private final TintManager f1198L;

    /* compiled from: underlying_entity */
    class C00572 implements OnGlobalLayoutListener {
        final /* synthetic */ SpinnerCompat f1148a;

        C00572(SpinnerCompat spinnerCompat) {
            this.f1148a = spinnerCompat;
        }

        public void onGlobalLayout() {
            if (!this.f1148a.f1193G.mo371b()) {
                this.f1148a.f1193G.mo372c();
            }
            ViewTreeObserver viewTreeObserver = this.f1148a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: underlying_entity */
    interface SpinnerPopup {
        void mo368a();

        void mo369a(ListAdapter listAdapter);

        void mo370a(CharSequence charSequence);

        boolean mo371b();

        void mo372c();
    }

    /* compiled from: underlying_entity */
    class DialogPopup implements OnClickListener, SpinnerPopup {
        final /* synthetic */ SpinnerCompat f1149a;
        private AlertDialog f1150b;
        private ListAdapter f1151c;
        private CharSequence f1152d;

        public DialogPopup(SpinnerCompat spinnerCompat) {
            this.f1149a = spinnerCompat;
        }

        public final void mo368a() {
            if (this.f1150b != null) {
                this.f1150b.dismiss();
                this.f1150b = null;
            }
        }

        public final boolean mo371b() {
            return this.f1150b != null ? this.f1150b.isShowing() : false;
        }

        public final void mo369a(ListAdapter listAdapter) {
            this.f1151c = listAdapter;
        }

        public final void mo370a(CharSequence charSequence) {
            this.f1152d = charSequence;
        }

        public final void mo372c() {
            if (this.f1151c != null) {
                Builder builder = new Builder(this.f1149a.getContext());
                if (this.f1152d != null) {
                    builder.setTitle(this.f1152d);
                }
                this.f1150b = builder.setSingleChoiceItems(this.f1151c, this.f1149a.f970v, this).create();
                this.f1150b.show();
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1149a.setSelection(i);
            if (this.f1149a.f967s != null) {
                this.f1149a.m1504a(null, i, this.f1151c.getItemId(i));
            }
            mo368a();
        }
    }

    /* compiled from: underlying_entity */
    class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f1153a;
        private ListAdapter f1154b;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter) {
            this.f1153a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1154b = (ListAdapter) spinnerAdapter;
            }
        }

        public int getCount() {
            return this.f1153a == null ? 0 : this.f1153a.getCount();
        }

        public Object getItem(int i) {
            return this.f1153a == null ? null : this.f1153a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f1153a == null ? -1 : this.f1153a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f1153a == null ? null : this.f1153a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f1153a != null && this.f1153a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1153a != null) {
                this.f1153a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1153a != null) {
                this.f1153a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1154b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1154b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: underlying_entity */
    class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        final /* synthetic */ SpinnerCompat f1187a;
        private CharSequence f1188c;
        public ListAdapter f1189d;

        public DropdownPopup(final SpinnerCompat spinnerCompat, Context context, AttributeSet attributeSet, int i) {
            this.f1187a = spinnerCompat;
            super(context, attributeSet, i);
            this.f1178r = spinnerCompat;
            m1660a(true);
            this.f1180t = new OnItemClickListener(this) {
                final /* synthetic */ DropdownPopup f1156b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f1156b.f1187a.setSelection(i);
                    if (this.f1156b.f1187a.f967s != null) {
                        this.f1156b.f1187a.m1504a(view, i, this.f1156b.f1189d.getItemId(i));
                    }
                    this.f1156b.m1657a();
                }
            };
        }

        public final void mo369a(ListAdapter listAdapter) {
            super.mo369a(listAdapter);
            this.f1189d = listAdapter;
        }

        public final void mo370a(CharSequence charSequence) {
            this.f1188c = charSequence;
        }
    }

    /* compiled from: underlying_entity */
    class SavedState extends SavedState {
        public static final Creator<SavedState> CREATOR = new C00591();
        boolean f1190c;

        /* compiled from: underlying_entity */
        final class C00591 implements Creator<SavedState> {
            C00591() {
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

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1190c = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.f1190c ? 1 : 0));
        }
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        mo374a((SpinnerAdapter) adapter);
    }

    public SpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    private SpinnerCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1197K = new Rect();
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.Spinner, i, 0);
        if (a.m1702d(1)) {
            setBackgroundDrawable(a.m1695a(1));
        }
        if (i2 == -1) {
            i2 = a.m1694a(8, 0);
        }
        switch (i2) {
            case 0:
                this.f1193G = new DialogPopup(this);
                break;
            case 1:
                final DropdownPopup dropdownPopup = new DropdownPopup(this, context, attributeSet, i);
                this.f1191E = a.m1703e(4, -2);
                dropdownPopup.f1164d.setBackgroundDrawable(a.m1695a(3));
                this.f1193G = dropdownPopup;
                this.f1192F = new ForwardingListener(this, this) {
                    final /* synthetic */ SpinnerCompat f1147b;

                    public final ListPopupWindow mo298a() {
                        return dropdownPopup;
                    }

                    public final boolean mo299b() {
                        if (!this.f1147b.f1193G.mo371b()) {
                            this.f1147b.f1193G.mo372c();
                        }
                        return true;
                    }
                };
                break;
        }
        this.f1195I = a.m1694a(0, 17);
        this.f1193G.mo370a((CharSequence) a.f1229b.getString(7));
        this.f1196J = a.m1696a(10, false);
        a.m1698b();
        if (this.f1194H != null) {
            this.f1193G.mo369a(this.f1194H);
            this.f1194H = null;
        }
        this.f1198L = a.m1700c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f1196J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public final void mo374a(SpinnerAdapter spinnerAdapter) {
        super.mo374a(spinnerAdapter);
        this.f984i.m1494a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.f1193G != null) {
            this.f1193G.mo369a(new DropDownAdapter(spinnerAdapter));
        } else {
            this.f1194H = new DropDownAdapter(spinnerAdapter);
        }
    }

    public int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.f976a != null && this.f976a.getCount() > 0) {
            view = m1669a(0, false);
            this.f984i.m1495a(0, view);
        }
        if (view == null) {
            return -1;
        }
        int baseline = view.getBaseline();
        if (baseline >= 0) {
            return view.getTop() + baseline;
        }
        return -1;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -632980883);
        super.onDetachedFromWindow();
        if (this.f1193G != null && this.f1193G.mo371b()) {
            this.f1193G.mo368a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1967094530, a);
    }

    public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener onItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    public final void m1671a(AdapterViewCompat.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1910289479);
        if (this.f1192F == null || !this.f1192F.onTouch(this, motionEvent)) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(-1875734854, a);
            return onTouchEvent;
        }
        Logger.a(2, EntryType.UI_INPUT_END, -882115969, a);
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1193G != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1668a(this.f976a, getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.q = true;
        mo338c();
        this.q = false;
    }

    final void mo338c() {
        int i = this.f983h.left;
        int right = ((getRight() - getLeft()) - this.f983h.left) - this.f983h.right;
        if (this.f969u) {
            m1506f();
        }
        if (this.f974z == 0) {
            m1509a();
            return;
        }
        if (this.f970v >= 0) {
            setSelectedPositionInt(this.f970v);
        }
        int childCount = getChildCount();
        RecycleBin recycleBin = this.f984i;
        int i2 = this.f958j;
        for (int i3 = 0; i3 < childCount; i3++) {
            recycleBin.m1495a(i2 + i3, getChildAt(i3));
        }
        removeAllViewsInLayout();
        this.j = this.f972x;
        if (this.f976a != null) {
            View a = m1669a(this.f972x, true);
            int measuredWidth = a.getMeasuredWidth();
            switch (GravityCompat.a(this.f1195I, ViewCompat.h(this)) & 7) {
                case 1:
                    i = (i + (right / 2)) - (measuredWidth / 2);
                    break;
                case 5:
                    i = (i + right) - measuredWidth;
                    break;
            }
            a.offsetLeftAndRight(i);
        }
        this.f984i.m1494a();
        invalidate();
        m1507g();
        this.u = false;
        this.o = false;
        setNextSelectedPositionInt(this.f972x);
    }

    private View m1669a(int i, boolean z) {
        View a;
        if (!this.f969u) {
            a = this.f984i.m1493a(i);
            if (a != null) {
                m1670a(a, z);
                return a;
            }
        }
        a = this.f976a.getView(i, null, this);
        m1670a(a, z);
        return a;
    }

    private void m1670a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.f1196J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.f978c, this.f983h.left + this.f983h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.f977b, this.f983h.top + this.f983h.bottom, layoutParams.height));
        int measuredHeight = this.f983h.top + ((((getMeasuredHeight() - this.f983h.bottom) - this.f983h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.f1193G.mo371b()) {
                this.f1193G.mo372c();
            }
        }
        return performClick;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    private int m1668a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int max = Math.max(0, this.f970v);
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1197K);
        return (this.f1197K.left + this.f1197K.right) + i;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.f1193G != null && this.f1193G.mo371b();
        savedState.f1190c = z;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1190c) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new C00572(this));
            }
        }
    }
}

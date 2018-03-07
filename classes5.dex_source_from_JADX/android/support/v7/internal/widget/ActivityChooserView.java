package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;

/* compiled from: unit_test */
public class ActivityChooserView extends ViewGroup {
    ActionProvider f1077a;
    public final ActivityChooserViewAdapter f1078b;
    private final Callbacks f1079c;
    private final LinearLayoutCompat f1080d;
    public final FrameLayout f1081e;
    private final ImageView f1082f;
    public final FrameLayout f1083g;
    private final int f1084h;
    public final DataSetObserver f1085i;
    private final OnGlobalLayoutListener f1086j;
    private ListPopupWindow f1087k;
    public OnDismissListener f1088l;
    public boolean f1089m;
    public int f1090n;
    private boolean f1091o;
    private int f1092p;

    /* compiled from: unit_test */
    public class ActivityChooserViewAdapter extends BaseAdapter {
        public final /* synthetic */ ActivityChooserView f1070a;
        public ActivityChooserModel f1071b;
        private int f1072c;
        public boolean f1073d;
        private boolean f1074e;
        private boolean f1075f;

        public int getItemViewType(int i) {
            if (this.f1075f && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int a = this.f1071b.m1576a();
            if (!(this.f1073d || this.f1071b.m1580b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1072c);
            if (this.f1075f) {
                return a + 1;
            }
            return a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1073d || this.f1071b.m1580b() == null)) {
                        i++;
                    }
                    return this.f1071b.m1578a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != 2131559121) {
                        view = LayoutInflater.from(this.f1070a.getContext()).inflate(2130903048, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1070a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(2131559122)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(2131558927)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1073d && i == 0 && this.f1074e) {
                        ViewCompat.b(view, true);
                        return view;
                    }
                    ViewCompat.b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1070a.getContext()).inflate(2130903048, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(2131558927)).setText(this.f1070a.getContext().getString(2131230830));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int m1582a() {
            int i = 0;
            int i2 = this.f1072c;
            this.f1072c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1072c = i2;
            return i3;
        }

        public final void m1583a(int i) {
            if (this.f1072c != i) {
                this.f1072c = i;
                AdapterDetour.a(this, -1446340229);
            }
        }

        public final void m1584a(boolean z) {
            if (this.f1075f != z) {
                this.f1075f = z;
                AdapterDetour.a(this, 793409720);
            }
        }

        public final void m1585a(boolean z, boolean z2) {
            if (this.f1073d != z || this.f1074e != z2) {
                this.f1073d = z;
                this.f1074e = z2;
                AdapterDetour.a(this, 1135089913);
            }
        }
    }

    /* compiled from: unit_test */
    public class InnerLayout extends LinearLayoutCompat {
        private static final int[] f1076a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, f1076a));
            setBackgroundDrawable(tintTypedArray.m1695a(0));
            tintTypedArray.m1698b();
        }
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        BaseAdapter baseAdapter = this.f1078b;
        ActivityChooserModel activityChooserModel2 = baseAdapter.f1070a.f1078b.f1071b;
        if (activityChooserModel2 != null && baseAdapter.f1070a.isShown()) {
            activityChooserModel2.unregisterObserver(baseAdapter.f1070a.f1085i);
        }
        baseAdapter.f1071b = activityChooserModel;
        if (activityChooserModel != null && baseAdapter.f1070a.isShown()) {
            activityChooserModel.registerObserver(baseAdapter.f1070a.f1085i);
        }
        AdapterDetour.a(baseAdapter, 408085685);
        if (m1588c()) {
            m1589a();
            m1587b();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1082f.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1082f.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1077a = actionProvider;
    }

    private boolean m1587b() {
        if (m1588c() || !this.f1091o) {
            return false;
        }
        this.f1089m = false;
        m1586a(this, this.f1090n);
        return true;
    }

    public static void m1586a(ActivityChooserView activityChooserView, int i) {
        if (activityChooserView.f1078b.f1071b == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        activityChooserView.getViewTreeObserver().addOnGlobalLayoutListener(activityChooserView.f1086j);
        boolean z = activityChooserView.f1083g.getVisibility() == 0;
        int a = activityChooserView.f1078b.f1071b.m1576a();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || a <= r3 + i) {
            activityChooserView.f1078b.m1584a(false);
            activityChooserView.f1078b.m1583a(i);
        } else {
            activityChooserView.f1078b.m1584a(true);
            activityChooserView.f1078b.m1583a(i - 1);
        }
        ListPopupWindow listPopupWindow = activityChooserView.getListPopupWindow();
        if (!listPopupWindow.m1661b()) {
            if (activityChooserView.f1089m || !z) {
                activityChooserView.f1078b.m1585a(true, z);
            } else {
                activityChooserView.f1078b.m1585a(false, false);
            }
            listPopupWindow.m1663c(Math.min(activityChooserView.f1078b.m1582a(), activityChooserView.f1084h));
            listPopupWindow.m1662c();
            if (activityChooserView.f1077a != null) {
                activityChooserView.f1077a.m315a(true);
            }
            listPopupWindow.f1166f.setContentDescription(activityChooserView.getContext().getString(2131230829));
        }
    }

    public final boolean m1589a() {
        if (m1588c()) {
            getListPopupWindow().m1657a();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1086j);
            }
        }
        return true;
    }

    private boolean m1588c() {
        return getListPopupWindow().m1661b();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 57532165);
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.f1078b.f1071b;
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver(this.f1085i);
        }
        this.f1091o = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -440077503, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 452363233);
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.f1078b.f1071b;
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver(this.f1085i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1086j);
        }
        if (m1588c()) {
            m1589a();
        }
        this.f1091o = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1217967276, a);
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1080d;
        if (this.f1083g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1080d.layout(0, 0, i3 - i, i4 - i2);
        if (!m1588c()) {
            m1589a();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f1078b.f1071b;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1088l = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1090n = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1092p = i;
    }

    private ListPopupWindow getListPopupWindow() {
        if (this.f1087k == null) {
            this.f1087k = new ListPopupWindow(getContext());
            this.f1087k.mo369a(this.f1078b);
            this.f1087k.f1178r = this;
            this.f1087k.m1660a(true);
            this.f1087k.f1180t = this.f1079c;
            this.f1087k.m1659a(this.f1079c);
        }
        return this.f1087k;
    }
}

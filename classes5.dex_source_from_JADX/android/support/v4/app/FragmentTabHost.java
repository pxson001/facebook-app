package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;

/* compiled from: wifi_scan_time */
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<TabInfo> f104a;
    private Context f105b;
    private FragmentManager f106c;
    private int f107d;
    private OnTabChangeListener f108e;
    private TabInfo f109f;
    private boolean f110g;

    /* compiled from: wifi_scan_time */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00061();
        String f99a;

        /* compiled from: wifi_scan_time */
        final class C00061 implements Creator<SavedState> {
            C00061() {
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
            this.f99a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f99a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f99a + "}";
        }
    }

    /* compiled from: wifi_scan_time */
    public final class TabInfo {
        public final String f100a;
        public final Class<?> f101b;
        public final Bundle f102c;
        public Fragment f103d;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f108e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1483456519);
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f104a.size(); i++) {
            TabInfo tabInfo = (TabInfo) this.f104a.get(i);
            tabInfo.f103d = this.f106c.a(tabInfo.f100a);
            if (!(tabInfo.f103d == null || tabInfo.f103d.L)) {
                if (tabInfo.f100a.equals(currentTabTag)) {
                    this.f109f = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f106c.a();
                    }
                    fragmentTransaction.d(tabInfo.f103d);
                }
            }
        }
        this.f110g = true;
        FragmentTransaction a2 = m81a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.b();
            this.f106c.b();
        }
        LogUtils.g(1968595548, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2060779447);
        super.onDetachedFromWindow();
        this.f110g = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -187731469, a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f99a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f99a);
    }

    public void onTabChanged(String str) {
        if (this.f110g) {
            FragmentTransaction a = m81a(str, null);
            if (a != null) {
                a.b();
            }
        }
        if (this.f108e != null) {
            this.f108e.onTabChanged(str);
        }
    }

    private FragmentTransaction m81a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = null;
        int i = 0;
        while (i < this.f104a.size()) {
            TabInfo tabInfo2 = (TabInfo) this.f104a.get(i);
            if (!tabInfo2.f100a.equals(str)) {
                tabInfo2 = tabInfo;
            }
            i++;
            tabInfo = tabInfo2;
        }
        if (tabInfo == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f109f != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f106c.a();
            }
            if (!(this.f109f == null || this.f109f.f103d == null)) {
                fragmentTransaction.d(this.f109f.f103d);
            }
            if (tabInfo != null) {
                if (tabInfo.f103d == null) {
                    tabInfo.f103d = Fragment.a(this.f105b, tabInfo.f101b.getName(), tabInfo.f102c);
                    fragmentTransaction.a(this.f107d, tabInfo.f103d, tabInfo.f100a);
                } else {
                    fragmentTransaction.e(tabInfo.f103d);
                }
            }
            this.f109f = tabInfo;
        }
        return fragmentTransaction;
    }
}

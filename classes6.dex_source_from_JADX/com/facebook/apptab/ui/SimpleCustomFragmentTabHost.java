package com.facebook.apptab.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View.BaseSavedState;
import com.facebook.apptab.ui.SimpleCustomTabHost.OnTabChangeListener;
import com.facebook.apptab.ui.SimpleCustomTabHost.TabSpec;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;

/* compiled from: projectionType */
public class SimpleCustomFragmentTabHost extends SimpleCustomTabHost implements OnTabChangeListener {
    private static final Class<?> f7228c = SimpleCustomFragmentTabHost.class;
    private final ArrayList<TabInfo> f7229d;
    private Context f7230e;
    private FragmentManager f7231f;
    private int f7232g;
    private OnTabChangeListener f7233h;
    private TabInfo f7234i;
    private boolean f7235j;
    private final FragmentRecycleStrategy f7236k;

    /* compiled from: projectionType */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C04241();
        String f7215a;

        /* compiled from: projectionType */
        final class C04241 implements Creator<SavedState> {
            C04241() {
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
            this.f7215a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f7215a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f7215a + "}";
        }
    }

    /* compiled from: projectionType */
    public final class TabInfo {
        public final String f7216a;
        public final Class<?> f7217b;
        public final Bundle f7218c;
        public Fragment f7219d;
    }

    @Deprecated
    public final void mo896a() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f7233h = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 240546744);
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f7229d.size(); i++) {
            TabInfo tabInfo = (TabInfo) this.f7229d.get(i);
            tabInfo.f7219d = this.f7231f.a(tabInfo.f7216a);
            if (!(tabInfo.f7219d == null || tabInfo.f7219d.L)) {
                if (tabInfo.f7216a.equals(currentTabTag)) {
                    this.f7234i = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f7231f.a();
                    }
                    fragmentTransaction.d(tabInfo.f7219d);
                }
            }
        }
        this.f7235j = true;
        FragmentTransaction a2 = m10363a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.b();
            this.f7231f.b();
        }
        LogUtils.g(-904812896, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -234219695);
        super.onDetachedFromWindow();
        this.f7235j = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 93249180, a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7215a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f7215a;
        for (int i = 0; i < this.f7224e.size(); i++) {
            if (((TabSpec) this.f7224e.get(i)).f7239a.equals(str)) {
                setCurrentTab(i);
                return;
            }
        }
    }

    public final void mo897a(String str) {
        if (this.f7235j) {
            FragmentTransaction a = m10363a(str, null);
            if (a != null) {
                a.b();
            }
        }
        if (this.f7233h != null) {
            this.f7233h.mo897a(str);
        }
    }

    private FragmentTransaction m10363a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = null;
        int i = 0;
        while (i < this.f7229d.size()) {
            TabInfo tabInfo2 = (TabInfo) this.f7229d.get(i);
            if (!tabInfo2.f7216a.equals(str)) {
                tabInfo2 = tabInfo;
            }
            i++;
            tabInfo = tabInfo2;
        }
        if (tabInfo == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f7234i != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f7231f.a();
            }
            if (!(this.f7234i == null || this.f7234i.f7219d == null)) {
                if (this.f7236k == FragmentRecycleStrategy.HIDE_ON_SWITCH) {
                    fragmentTransaction.b(this.f7234i.f7219d);
                } else {
                    fragmentTransaction.d(this.f7234i.f7219d);
                }
            }
            if (tabInfo != null) {
                if (tabInfo.f7219d == null) {
                    tabInfo.f7219d = Fragment.a(this.f7230e, tabInfo.f7217b.getName(), tabInfo.f7218c);
                    fragmentTransaction.a(this.f7232g, tabInfo.f7219d, tabInfo.f7216a);
                } else if (tabInfo.f7219d.L) {
                    fragmentTransaction.e(tabInfo.f7219d);
                    if (this.f7236k == FragmentRecycleStrategy.HIDE_ON_SWITCH) {
                        BLog.a(f7228c, "Fragment was detached during HIDE_ON_SWITCH strategy");
                    }
                } else if (this.f7236k == FragmentRecycleStrategy.HIDE_ON_SWITCH) {
                    fragmentTransaction.c(tabInfo.f7219d);
                }
            }
            this.f7234i = tabInfo;
        }
        return fragmentTransaction;
    }
}

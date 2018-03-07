package com.facebook.events.ui.privacy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.events.model.PrivacyType;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.EventCreateInputData.EventVisibility;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;

/* compiled from: appcenter/mobile_canvas/f?href={%s} */
public class PrivacyPicker extends FbEditText implements OnClickListener {
    public PrivacyType f19501b;
    public boolean f19502c;
    public boolean f19503d = false;

    /* compiled from: appcenter/mobile_canvas/f?href={%s} */
    /* synthetic */ class C27761 {
        static final /* synthetic */ int[] f19494a = new int[PrivacyType.values().length];

        static {
            try {
                f19494a[PrivacyType.FRIENDS_OF_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19494a[PrivacyType.FRIENDS_OF_GUESTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19494a[PrivacyType.INVITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19494a[PrivacyType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19494a[PrivacyType.USER_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: appcenter/mobile_canvas/f?href={%s} */
    class PrivacyTypeOnClickListener implements OnMenuItemClickListener {
        final /* synthetic */ PrivacyPicker f19495a;
        private PrivacyType f19496b;
        private boolean f19497c;

        PrivacyTypeOnClickListener(PrivacyPicker privacyPicker, PrivacyType privacyType, boolean z) {
            this.f19495a = privacyPicker;
            this.f19496b = privacyType;
            this.f19497c = z;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f19495a.f19501b = this.f19496b;
            this.f19495a.f19502c = this.f19497c;
            this.f19495a.m19696a();
            return true;
        }
    }

    /* compiled from: appcenter/mobile_canvas/f?href={%s} */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C27771();
        public PrivacyType f19498a;
        public boolean f19499b;
        public boolean f19500c;

        /* compiled from: appcenter/mobile_canvas/f?href={%s} */
        final class C27771 implements Creator<SavedState> {
            C27771() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f19498a = (PrivacyType) parcel.readParcelable(PrivacyType.class.getClassLoader());
            this.f19499b = ParcelUtil.a(parcel);
            this.f19500c = ParcelUtil.a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f19498a, i);
            ParcelUtil.a(parcel, this.f19499b);
            ParcelUtil.a(parcel, this.f19500c);
        }
    }

    public PrivacyPicker(Context context) {
        super(context);
        m19694c();
    }

    public PrivacyPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19694c();
    }

    public PrivacyPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19694c();
    }

    private void m19694c() {
        setCursorVisible(false);
        setFocusable(false);
        setLines(1);
        setOnClickListener(this);
        m19697a(PrivacyType.INVITE_ONLY, true);
        m19696a();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19498a = this.f19501b;
        savedState.f19499b = this.f19502c;
        savedState.f19500c = this.f19503d;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f19501b = savedState.f19498a;
            this.f19502c = savedState.f19499b;
            this.f19503d = savedState.f19500c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final void m19697a(PrivacyType privacyType, boolean z) {
        this.f19501b = privacyType;
        this.f19502c = z;
        if (m19690a(this.f19501b)) {
            setVisibility(8);
            this.f19501b = null;
            return;
        }
        m19696a();
    }

    public static boolean m19690a(PrivacyType privacyType) {
        return privacyType == null || privacyType == PrivacyType.GROUP || privacyType == PrivacyType.PAGE || privacyType == PrivacyType.FRIENDS_OF_FRIENDS;
    }

    public PrivacyType getPrivacyType() {
        return this.f19501b;
    }

    public EventVisibility getEventCreateInputDataPrivacyType() {
        switch (C27761.f19494a[this.f19501b.ordinal()]) {
            case 1:
                return EventVisibility.FRIENDS_OF_FRIENDS;
            case 2:
                return EventVisibility.FRIENDS_OF_GUESTS;
            case 3:
                return EventVisibility.INVITE_ONLY;
            case 4:
                return EventVisibility.PAGE;
            case 5:
                return EventVisibility.USER_PUBLIC;
            default:
                return EventVisibility.GROUP;
        }
    }

    public boolean getCanGuestsInviteFriends() {
        return this.f19502c;
    }

    protected final void m19696a() {
        if (getVisibility() == 0) {
            setText(m19691b(this.f19501b, this.f19502c));
            setCompoundDrawablesWithIntrinsicBounds(0, 0, m19695d(this.f19501b, this.f19502c), 0);
        }
    }

    public final boolean m19698b() {
        return this.f19503d;
    }

    protected PopoverMenuWindow getPopoverMenuWindow() {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        figPopoverMenuWindow.c(2131241635);
        PopoverMenu c = figPopoverMenuWindow.c();
        for (PrivacyType privacyType : PrivacyType.SELECTABLE_PRIVACY_TYPES) {
            if (privacyType == PrivacyType.INVITE_ONLY) {
                m19692b(c, privacyType, false);
            }
            m19692b(c, privacyType, true);
        }
        return figPopoverMenuWindow;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -352904491);
        this.f19503d = true;
        PopoverMenuWindow popoverMenuWindow = getPopoverMenuWindow();
        popoverMenuWindow.a(true);
        popoverMenuWindow.a(this);
        Logger.a(2, EntryType.UI_INPUT_END, -523353522, a);
    }

    private MenuItemImpl m19689a(PopoverMenu popoverMenu, PrivacyType privacyType, boolean z) {
        MenuItemImpl a = popoverMenu.a(m19691b(privacyType, z), m19693c(privacyType, z));
        a.setIcon(m19695d(privacyType, z));
        return a;
    }

    private void m19692b(PopoverMenu popoverMenu, PrivacyType privacyType, boolean z) {
        MenuItemImpl a = m19689a(popoverMenu, privacyType, z);
        a.setCheckable(true);
        if (privacyType == this.f19501b && this.f19502c == z) {
            a.setChecked(true);
        }
        a.setOnMenuItemClickListener(new PrivacyTypeOnClickListener(this, privacyType, z));
    }

    private static int m19691b(PrivacyType privacyType, boolean z) {
        switch (C27761.f19494a[privacyType.ordinal()]) {
            case 2:
                return 2131241643;
            case 3:
                if (z) {
                    return 2131241646;
                }
                return 2131241649;
            case 5:
                return 2131241637;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19693c(PrivacyType privacyType, boolean z) {
        switch (C27761.f19494a[privacyType.ordinal()]) {
            case 2:
                return 2131241644;
            case 3:
                if (z) {
                    return 2131241647;
                }
                return 2131241650;
            case 5:
                return 2131241641;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19695d(PrivacyType privacyType, boolean z) {
        switch (C27761.f19494a[privacyType.ordinal()]) {
            case 2:
                return 2130839914;
            case 3:
                if (z) {
                    return 2130839882;
                }
                return 2130839845;
            case 5:
                return 2130839905;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }
}

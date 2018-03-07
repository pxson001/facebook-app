package com.facebook.events.ui.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.text.TextUtilsCompat;
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
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;
import java.util.Locale;

/* compiled from: content_search_clear */
public class PrivacyPickerNikuman extends FbTextView implements OnClickListener {
    public OnPrivacyChangedListener f19515a;
    public PrivacyType f19516b;
    public boolean f19517c;
    private boolean f19518d;
    public boolean f19519e;
    public boolean f19520f = true;
    private boolean f19521g;
    public boolean f19522h = false;
    private int f19523i;
    private int f19524j;
    private int f19525k;
    private int f19526l;
    private Path f19527m;
    private Paint f19528n;
    private boolean f19529o;
    public String f19530p;

    /* compiled from: content_search_clear */
    public interface OnPrivacyChangedListener {
        void mo771a(PrivacyType privacyType);
    }

    /* compiled from: content_search_clear */
    /* synthetic */ class C27781 {
        static final /* synthetic */ int[] f19504a = new int[PrivacyType.values().length];

        static {
            try {
                f19504a[PrivacyType.USER_PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19504a[PrivacyType.INVITE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19504a[PrivacyType.FRIENDS_OF_GUESTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19504a[PrivacyType.COMMUNITY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: content_search_clear */
    class PrivacyTypeOnClickListener implements OnMenuItemClickListener {
        final /* synthetic */ PrivacyPickerNikuman f19505a;
        private PrivacyType f19506b;
        private boolean f19507c;

        PrivacyTypeOnClickListener(PrivacyPickerNikuman privacyPickerNikuman, PrivacyType privacyType, boolean z) {
            this.f19505a = privacyPickerNikuman;
            this.f19506b = privacyType;
            this.f19507c = z;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f19505a.f19516b = this.f19506b;
            this.f19505a.f19517c = this.f19507c;
            if (this.f19505a.f19515a != null) {
                this.f19505a.f19515a.mo771a(this.f19505a.f19516b);
            }
            return true;
        }
    }

    /* compiled from: content_search_clear */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C27791();
        public PrivacyType f19508a;
        public boolean f19509b;
        public boolean f19510c;
        public boolean f19511d;
        public boolean f19512e;
        public boolean f19513f;
        public boolean f19514g;

        /* compiled from: content_search_clear */
        final class C27791 implements Creator<SavedState> {
            C27791() {
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
            this.f19508a = (PrivacyType) parcel.readParcelable(PrivacyType.class.getClassLoader());
            this.f19509b = ParcelUtil.a(parcel);
            this.f19510c = ParcelUtil.a(parcel);
            this.f19511d = ParcelUtil.a(parcel);
            this.f19512e = ParcelUtil.a(parcel);
            this.f19513f = ParcelUtil.a(parcel);
            this.f19514g = ParcelUtil.a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f19508a, i);
            ParcelUtil.a(parcel, this.f19509b);
            ParcelUtil.a(parcel, this.f19510c);
            ParcelUtil.a(parcel, this.f19511d);
            ParcelUtil.a(parcel, this.f19512e);
            ParcelUtil.a(parcel, this.f19513f);
            ParcelUtil.a(parcel, this.f19514g);
        }
    }

    public PrivacyPickerNikuman(Context context) {
        super(context);
        m19718a(context);
    }

    public PrivacyPickerNikuman(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19718a(context);
    }

    public PrivacyPickerNikuman(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19718a(context);
    }

    private void m19718a(Context context) {
        setCursorVisible(false);
        setFocusable(false);
        setLines(1);
        m19725b(context);
        setOnClickListener(this);
    }

    public void setIsShowingOpenInviteOption(boolean z) {
        this.f19519e = z;
    }

    public void setIsShowingPublicOption(boolean z) {
        this.f19520f = z;
    }

    public final void m19730a(boolean z, String str) {
        this.f19529o = z;
        this.f19530p = str;
    }

    public String getCommunityName() {
        return this.f19530p;
    }

    public void setPrivacyLocked(boolean z) {
        this.f19521g = z;
        if (z) {
            setOnClickListener(null);
        }
    }

    public void setOnPrivacyChangedListener(OnPrivacyChangedListener onPrivacyChangedListener) {
        this.f19515a = onPrivacyChangedListener;
    }

    public final void m19729a(PrivacyType privacyType, boolean z, boolean z2, String str) {
        this.f19516b = privacyType;
        this.f19517c = z;
        this.f19518d = z2;
        setText(str);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19508a = this.f19516b;
        savedState.f19509b = this.f19517c;
        savedState.f19510c = this.f19521g;
        savedState.f19511d = this.f19518d;
        savedState.f19512e = this.f19522h;
        savedState.f19513f = this.f19519e;
        savedState.f19514g = this.f19520f;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f19516b = savedState.f19508a;
            this.f19517c = savedState.f19509b;
            this.f19521g = savedState.f19510c;
            this.f19518d = savedState.f19511d;
            this.f19522h = savedState.f19512e;
            this.f19519e = savedState.f19513f;
            this.f19520f = savedState.f19514g;
            if (this.f19515a != null) {
                this.f19515a.mo771a(this.f19516b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final boolean m19731a() {
        return this.f19522h;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1155920755);
        this.f19522h = true;
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        m19720a(c, PrivacyType.INVITE_ONLY, this.f19517c);
        if (this.f19519e) {
            m19720a(c, PrivacyType.FRIENDS_OF_GUESTS, this.f19517c);
        }
        if (this.f19520f) {
            m19720a(c, PrivacyType.USER_PUBLIC, this.f19517c);
        }
        if (this.f19529o && !Strings.isNullOrEmpty(this.f19530p)) {
            m19720a(c, PrivacyType.COMMUNITY, this.f19517c);
        }
        figPopoverMenuWindow.a(true);
        figPopoverMenuWindow.f(this);
        Logger.a(2, EntryType.UI_INPUT_END, -1038904165, a);
    }

    private void m19720a(PopoverMenu popoverMenu, PrivacyType privacyType, boolean z) {
        MenuItemImpl a;
        if (this.f19518d) {
            if (privacyType == PrivacyType.COMMUNITY) {
                a = popoverMenu.a(this.f19530p);
            } else {
                a = popoverMenu.a(m19713a(privacyType), m19727c(privacyType));
            }
            a.setIcon(m19728d(privacyType));
        } else {
            a = popoverMenu.a(m19722b(privacyType), m19714a(privacyType, z));
            a.setIcon(m19723b(privacyType, z));
        }
        a.setCheckable(true);
        if (privacyType == this.f19516b && this.f19517c == z) {
            a.setChecked(true);
        }
        a.setOnMenuItemClickListener(new PrivacyTypeOnClickListener(this, privacyType, z));
    }

    private static int m19713a(PrivacyType privacyType) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2131241639;
            case 2:
                return 2131241638;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19722b(PrivacyType privacyType) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2131241639;
            case 2:
                return 2131241649;
            case 3:
                return 2131241643;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19727c(PrivacyType privacyType) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2131241642;
            case 2:
                return 2131241640;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19714a(PrivacyType privacyType, boolean z) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2131241642;
            case 2:
                if (z) {
                    return 2131241648;
                }
                return 2131241651;
            case 3:
                return 2131241645;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19728d(PrivacyType privacyType) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2130839905;
            case 2:
                return 2130839845;
            case 4:
                return 2130839723;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private static int m19723b(PrivacyType privacyType, boolean z) {
        switch (C27781.f19504a[privacyType.ordinal()]) {
            case 1:
                return 2130839905;
            case 2:
                if (z) {
                    return 2130839882;
                }
                return 2130839845;
            case 3:
                return 2130839914;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    private void m19725b(Context context) {
        Resources resources = context.getResources();
        this.f19523i = resources.getDimensionPixelSize(2131434040);
        this.f19524j = resources.getDimensionPixelSize(2131434041);
        this.f19525k = resources.getDimensionPixelSize(2131434042);
        this.f19526l = resources.getDimensionPixelSize(2131434043);
        this.f19528n = new Paint();
        this.f19528n.setColor(getResources().getColor(2131361920));
        this.f19527m = m19715a(this.f19525k, this.f19524j);
    }

    private static Path m19715a(int i, int i2) {
        Path path = new Path();
        path.lineTo((float) i2, 0.0f);
        path.lineTo(((float) i2) / 2.0f, (float) i);
        path.close();
        return path;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f19521g) {
            m19719a(canvas);
        }
    }

    private void m19719a(Canvas canvas) {
        canvas.save();
        int i = this.f19524j;
        int width = getWidth();
        int height = getHeight();
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        int compoundPaddingRight = super.getCompoundPaddingRight();
        canvas.translate((float) getScrollX(), (float) getScrollY());
        int lineWidth = (int) getLayout().getLineWidth(0);
        canvas.translate((float) (m19726b() ? (lineWidth + compoundPaddingLeft) + this.f19523i : (((width - lineWidth) - compoundPaddingRight) - i) - this.f19523i), (float) (((((getTotalPaddingTop() + height) - getTotalPaddingBottom()) - this.f19525k) / 2) + this.f19526l));
        canvas.drawPath(this.f19527m, this.f19528n);
        canvas.restore();
    }

    private static boolean m19726b() {
        return TextUtilsCompat.a(Locale.getDefault()) == 0;
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (m19726b()) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft + this.f19523i) + this.f19524j;
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (m19726b()) {
            return (compoundPaddingRight + this.f19523i) + this.f19524j;
        }
        return compoundPaddingRight;
    }
}

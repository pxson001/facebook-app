package com.facebook.events.ui.privacy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.events.model.PrivacyType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbCheckedTextView;

/* compiled from: content_search_button_pressed */
public class PrivacyOptionCheckbox extends FbCheckedTextView {
    public OnPrivacyOptionToggledListener f19491a;
    public boolean f19492b;
    public boolean f19493c;

    /* compiled from: content_search_button_pressed */
    public interface OnPrivacyOptionToggledListener {
        void mo772a(boolean z);
    }

    /* compiled from: content_search_button_pressed */
    class C27741 implements OnClickListener {
        final /* synthetic */ PrivacyOptionCheckbox f19488a;

        C27741(PrivacyOptionCheckbox privacyOptionCheckbox) {
            this.f19488a = privacyOptionCheckbox;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1995006203);
            ((FbCheckedTextView) view).toggle();
            this.f19488a.f19493c = this.f19488a.isChecked();
            this.f19488a.f19492b = true;
            if (this.f19488a.f19491a != null) {
                this.f19488a.f19491a.mo772a(this.f19488a.f19493c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1908344508, a);
        }
    }

    /* compiled from: content_search_button_pressed */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C27751();
        public boolean f19489a;
        public boolean f19490b;

        /* compiled from: content_search_button_pressed */
        final class C27751 implements Creator<SavedState> {
            C27751() {
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
            this.f19489a = ParcelUtil.a(parcel);
            this.f19490b = ParcelUtil.a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            ParcelUtil.a(parcel, this.f19489a);
            ParcelUtil.a(parcel, this.f19490b);
        }
    }

    public PrivacyOptionCheckbox(Context context) {
        super(context);
        m19678b();
    }

    public PrivacyOptionCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19678b();
    }

    public PrivacyOptionCheckbox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19678b();
    }

    public void setOnPrivacyOptionToggledListener(OnPrivacyOptionToggledListener onPrivacyOptionToggledListener) {
        this.f19491a = onPrivacyOptionToggledListener;
    }

    private void m19678b() {
        setOnClickListener(new C27741(this));
    }

    public final void m19681a(PrivacyType privacyType, boolean z) {
        if (privacyType == PrivacyType.INVITE_ONLY) {
            setVisibility(0);
            setChecked(z);
            return;
        }
        setVisibility(8);
    }

    public final boolean m19682a() {
        return this.f19492b;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19489a = this.f19493c;
        savedState.f19490b = this.f19492b;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f19493c = savedState.f19489a;
            this.f19492b = savedState.f19490b;
            if (this.f19491a != null) {
                this.f19491a.mo772a(this.f19493c);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

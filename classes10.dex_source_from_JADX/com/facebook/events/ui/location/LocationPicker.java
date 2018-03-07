package com.facebook.events.ui.location;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;

/* compiled from: application/java-archive */
public class LocationPicker extends BadgeTextView {
    public EventLocationModel f19475a;
    private boolean f19476b;

    /* compiled from: application/java-archive */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C27711();
        public CheckinPlaceModel f19471a;
        public long f19472b;
        public String f19473c;
        public boolean f19474d;

        /* compiled from: application/java-archive */
        final class C27711 implements Creator<SavedState> {
            C27711() {
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
            this.f19471a = (CheckinPlaceModel) FlatBufferModelHelper.a(parcel);
            this.f19472b = parcel.readLong();
            this.f19473c = parcel.readString();
            this.f19474d = ParcelUtil.a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            FlatBufferModelHelper.a(parcel, this.f19471a);
            parcel.writeLong(this.f19472b);
            parcel.writeString(this.f19473c);
            ParcelUtil.a(parcel, this.f19474d);
        }
    }

    public LocationPicker(Context context) {
        super(context);
        m19655a();
    }

    public LocationPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19655a();
    }

    public LocationPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19655a();
    }

    private void m19655a() {
        this.f19475a = new EventLocationModel();
        setFocusable(false);
        setCursorVisible(false);
        setHint(2131236904);
        setSingleLine(true);
        setLines(1);
        setEllipsize(TruncateAt.END);
        m19656b();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19471a = CheckinPlaceModel.a(this.f19475a.f19461a);
        savedState.f19472b = this.f19475a.f19462b;
        savedState.f19473c = this.f19475a.f19463c;
        savedState.f19474d = this.f19476b;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f19475a = new EventLocationModel(savedState.f19471a, savedState.f19472b, savedState.f19473c);
            this.f19476b = savedState.f19474d;
            m19656b();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setHasClickedOnLocationPicker(boolean z) {
        this.f19476b = z;
    }

    public EventLocationModel getPickedLocation() {
        return this.f19475a;
    }

    public void setPickedLocation(EventLocationModel eventLocationModel) {
        if (eventLocationModel == null) {
            eventLocationModel = new EventLocationModel();
        }
        this.f19475a = eventLocationModel;
        m19656b();
    }

    public final void m19657a(long j, String str) {
        this.f19475a = new EventLocationModel(null, j, str);
        m19656b();
    }

    private void m19656b() {
        if (this.f19475a.f19461a != null) {
            setText(this.f19475a.f19461a.j());
            a(getContext(), 2131626534);
        } else if (this.f19475a.f19463c != null) {
            setText(this.f19475a.f19463c);
            a(getContext(), 2131626534);
        } else {
            setText("");
            a(getContext(), 2131626533);
        }
    }
}

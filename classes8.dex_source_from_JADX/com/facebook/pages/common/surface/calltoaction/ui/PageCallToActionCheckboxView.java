package com.facebook.pages.common.surface.calltoaction.ui;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.SwitchCompat;
import com.google.common.annotations.VisibleForTesting;
import java.util.Observable;

/* compiled from: cover_image_portrait_size */
public class PageCallToActionCheckboxView implements PageCallToActionInput {
    public final CheckChangedObservable f16796a = new CheckChangedObservable();
    public final SwitchCompat f16797b;

    @VisibleForTesting
    /* compiled from: cover_image_portrait_size */
    class CheckChangedObservable extends Observable implements OnCheckedChangeListener {
        CheckChangedObservable() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            setChanged();
            notifyObservers(Boolean.valueOf(z));
        }
    }

    public PageCallToActionCheckboxView(SwitchCompat switchCompat) {
        this.f16797b = switchCompat;
        this.f16797b.setOnCheckedChangeListener(this.f16796a);
    }

    public View getView() {
        return this.f16797b;
    }

    public final boolean mo1032a() {
        return false;
    }

    public String getValue() {
        return this.f16797b.isChecked() ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
    }

    public final PageCallToActionErrorState mo1033b() {
        return PageCallToActionErrorState.NONE;
    }

    public final void mo1034c() {
    }

    public final void mo1035d() {
    }

    public final void mo1036e() {
    }
}

package com.facebook.backstage.ui;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: searchThreadNameAndParticipantsParam */
public class ToggleTextButton extends SpringTextView {
    public ToggleTextButtonListener f5517a;
    public boolean f5518b;

    /* compiled from: searchThreadNameAndParticipantsParam */
    public interface ToggleTextButtonListener {
        void mo149a(boolean z);
    }

    /* compiled from: searchThreadNameAndParticipantsParam */
    public class C05851 {
        final /* synthetic */ ToggleTextButton f5516a;

        C05851(ToggleTextButton toggleTextButton) {
            this.f5516a = toggleTextButton;
        }

        public final void m5746a() {
            this.f5516a.setToggleState(!this.f5516a.f5518b);
            if (this.f5516a.f5517a != null) {
                this.f5516a.f5517a.mo149a(this.f5516a.f5518b);
            }
        }
    }

    public ToggleTextButton(Context context) {
        this(context, null);
    }

    public ToggleTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToggleTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4390f = new C05851(this);
    }

    public void setToggleTextButtonListener(ToggleTextButtonListener toggleTextButtonListener) {
        this.f5517a = toggleTextButtonListener;
    }

    public void setToggleState(boolean z) {
        this.f5518b = z;
        if (this.f5518b) {
            setTextColor(getContext().getResources().getColor(2131363718));
        } else {
            setTextColor(-1);
        }
    }
}

package com.facebook.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.facebook.places.checkin.PlacePickerFragment.2;
import com.facebook.resources.ui.FbEditText;

/* compiled from: com.facebook.home */
public class SoftKeyboardStateAwareEditText extends FbEditText implements OnFocusChangeListener {
    public 2 f5880b;
    private boolean f5881c = false;

    public SoftKeyboardStateAwareEditText(Context context) {
        super(context);
        setOnFocusChangeListener(this);
    }

    public SoftKeyboardStateAwareEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnFocusChangeListener(this);
    }

    public SoftKeyboardStateAwareEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnFocusChangeListener(this);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (this.f5880b == null) {
            return super.onKeyPreIme(i, keyEvent);
        }
        if (i == 4 && this.f5881c) {
            this.f5880b.b();
            this.f5881c = !this.f5881c;
            clearFocus();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2 = true;
        if (this.f5880b != null) {
            if (z && !this.f5881c) {
                this.f5880b.a();
                if (this.f5881c) {
                    z2 = false;
                }
                this.f5881c = z2;
            } else if (!z && this.f5881c) {
                this.f5880b.b();
                if (this.f5881c) {
                    z2 = false;
                }
                this.f5881c = z2;
            }
        }
    }
}

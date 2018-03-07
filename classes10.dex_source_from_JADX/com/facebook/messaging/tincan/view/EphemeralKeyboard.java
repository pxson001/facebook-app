package com.facebook.messaging.tincan.view;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;

/* compiled from: placement_height */
public class EphemeralKeyboard extends AbstractComposerKeyboard<EphemeralKeyboardView> {
    protected final View m4386b(ViewGroup viewGroup) {
        return new EphemeralKeyboardView(viewGroup.getContext());
    }
}

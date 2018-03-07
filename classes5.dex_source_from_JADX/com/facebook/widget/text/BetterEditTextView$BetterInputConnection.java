package com.facebook.widget.text;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

/* compiled from: com.facebook.messaging.annotations.ForIntentHandlerActivity */
class BetterEditTextView$BetterInputConnection extends InputConnectionWrapper {
    final /* synthetic */ BetterEditTextView f5847a;

    public BetterEditTextView$BetterInputConnection(BetterEditTextView betterEditTextView, InputConnection inputConnection, boolean z) {
        this.f5847a = betterEditTextView;
        super(inputConnection, z);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            keyEvent.getKeyCode();
        }
        return super.sendKeyEvent(keyEvent);
    }
}

package com.facebook.messaging.emoji;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;

/* compiled from: mangle_request_wrong_body */
public class EmojiKeyboard extends AbstractComposerKeyboard<EmojiKeyboardView> {
    protected final View m11326b(ViewGroup viewGroup) {
        return EmojiKeyboardView.m11335a(viewGroup.getContext());
    }

    public final void m11327c() {
        ((EmojiKeyboardView) this.a).m11351c();
    }

    public final void m11328d() {
        ((EmojiKeyboardView) this.a).m11352d();
    }
}

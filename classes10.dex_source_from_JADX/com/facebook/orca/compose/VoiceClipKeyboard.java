package com.facebook.orca.compose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.model.threadkey.ThreadKey;
import java.util.Map;

/* compiled from: openPopup */
public class VoiceClipKeyboard extends AbstractComposerKeyboard<VoiceClipKeyboardView> {
    private final LayoutInflater f5677a;

    VoiceClipKeyboard(LayoutInflater layoutInflater) {
        this.f5677a = layoutInflater;
    }

    protected final View m5354b(ViewGroup viewGroup) {
        return (VoiceClipKeyboardView) this.f5677a.inflate(2130905637, viewGroup, false);
    }

    public final void m5352a(ThreadKey threadKey) {
        ((VoiceClipKeyboardView) this.a).f5694l = threadKey;
    }

    public final void m5353a(Map<String, Integer> map) {
        ((VoiceClipKeyboardView) this.a).m5389a((Map) map);
    }

    public final void m5355b() {
        ((VoiceClipKeyboardView) this.a).setClickable(true);
    }

    public final void m5356c() {
        ((VoiceClipKeyboardView) this.a).m5388a();
    }

    public final void m5357d() {
        ((VoiceClipKeyboardView) this.a).m5390b();
    }

    public final void m5358e() {
        ((VoiceClipKeyboardView) this.a).setClickable(false);
    }
}

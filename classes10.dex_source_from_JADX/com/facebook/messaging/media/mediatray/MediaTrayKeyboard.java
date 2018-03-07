package com.facebook.messaging.media.mediatray;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.model.threadkey.ThreadKey;
import java.util.Map;

/* compiled from: section_name=? AND is_download_client=? */
public class MediaTrayKeyboard extends AbstractComposerKeyboard<MediaTrayKeyboardView> {
    private final LayoutInflater f3073a;

    public MediaTrayKeyboard(LayoutInflater layoutInflater) {
        this.f3073a = layoutInflater;
    }

    public final void m3029a(Bundle bundle) {
        ((MediaTrayKeyboardView) this.a).m3092a(bundle);
    }

    public final void m3030a(ThreadKey threadKey) {
        ((MediaTrayKeyboardView) this.a).setThreadKey(threadKey);
    }

    public final void m3031a(Map<String, Integer> map) {
        ((MediaTrayKeyboardView) this.a).m3093a((Map) map);
    }

    public final void m3033c() {
        ((MediaTrayKeyboardView) this.a).m3091a();
    }

    public final void m3034e() {
        ((MediaTrayKeyboardView) this.a).m3094b();
    }

    public final void m3035f() {
        ((MediaTrayKeyboardView) this.a).m3095e();
    }

    public final Bundle m3036i() {
        return ((MediaTrayKeyboardView) this.a).m3096f();
    }

    protected final View m3032b(ViewGroup viewGroup) {
        return (MediaTrayKeyboardView) this.f3073a.inflate(2130905192, viewGroup, false);
    }
}

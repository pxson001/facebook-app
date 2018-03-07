package com.facebook.messaging.composershortcuts;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: messaging_send_ */
public class ComposerShortcutsManagerMethodAutoProvider extends AbstractProvider<ComposerShortcutsManager> {
    public static ComposerShortcutsManager m10561b(InjectorLike injectorLike) {
        return DefaultComposerShortcutsManager.m10575a(injectorLike);
    }

    public Object get() {
        return DefaultComposerShortcutsManager.m10575a((InjectorLike) this);
    }
}

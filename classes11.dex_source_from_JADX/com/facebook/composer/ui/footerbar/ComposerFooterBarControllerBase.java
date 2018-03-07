package com.facebook.composer.ui.footerbar;

import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: feed unit title is null */
public abstract class ComposerFooterBarControllerBase implements ComposerFooterBarController {
    protected abstract ImmutableList<ComposerEvent> mo214a();

    public final void m8297a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (mo214a().contains(composerEvent)) {
            mo215b();
        }
    }
}

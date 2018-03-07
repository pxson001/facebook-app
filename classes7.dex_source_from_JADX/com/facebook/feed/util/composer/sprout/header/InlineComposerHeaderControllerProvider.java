package com.facebook.feed.util.composer.sprout.header;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: TRAILING */
public class InlineComposerHeaderControllerProvider extends AbstractAssistedProvider<InlineComposerHeaderController> {
    public final InlineComposerHeaderController m25093a(String str, String str2, String str3) {
        return new InlineComposerHeaderController(str, str2, str3, ResourcesMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), GlyphColorizer.a(this));
    }
}

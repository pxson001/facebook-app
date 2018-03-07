package com.facebook.feed.util.composer.sprout.header;

import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: TRANSITION_NONE */
public class GroupsInlineComposerSproutHeaderControllerProvider extends AbstractAssistedProvider<GroupsInlineComposerSproutHeaderController> {
    public final GroupsInlineComposerSproutHeaderController m25085a(String str, String str2) {
        return new GroupsInlineComposerSproutHeaderController(str, str2, GlyphColorizer.a(this));
    }
}

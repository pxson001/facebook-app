package com.facebook.messaging.emoji;

import android.content.Context;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.Emojis;

/* compiled from: mangle_salamander_crypto */
public class EmojiGridViewAdapterProvider extends AbstractAssistedProvider<EmojiGridViewAdapter> {
    public final EmojiGridViewAdapter m11325a(Sizes sizes) {
        return new EmojiGridViewAdapter((Context) getInstance(Context.class), IdBasedLazy.a(this, 11501), DownloadableEmojiButtonBuilder.m11311a((InjectorLike) this), Emojis.a(this), IdBasedSingletonScopeProvider.b(this, 3078), IdBasedLazy.a(this, 7831), sizes, MessagingEmojiGatingUtil.m11390b(this));
    }
}

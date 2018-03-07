package com.facebook.messaging.emoji;

import android.content.Context;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: mangle_empty_request */
public class EmojiPageAdapterProvider extends AbstractAssistedProvider<EmojiPageAdapter> {
    public final EmojiPageAdapter m11379a(Sizes sizes) {
        return new EmojiPageAdapter(BugReportOperationLogger.a(this), (Context) getInstance(Context.class), (EmojiGridViewAdapterProvider) getOnDemandAssistedProviderForStaticDi(EmojiGridViewAdapterProvider.class), sizes);
    }
}

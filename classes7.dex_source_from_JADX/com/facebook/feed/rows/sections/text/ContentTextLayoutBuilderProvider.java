package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ui.emoji.EmojiUtil;

/* compiled from: UNKNOWN_RELATIONSHIP */
public class ContentTextLayoutBuilderProvider extends AbstractAssistedProvider<ContentTextLayoutBuilder> {
    public final ContentTextLayoutBuilder m24200a(Context context) {
        return new ContentTextLayoutBuilder(context, IdBasedProvider.a(this, 1473), FeedHighlighter.a(this), FbTextLayoutCacheWarmer.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), EmojiUtil.a(this), TextLayoutBuilderUtil.a(this));
    }
}

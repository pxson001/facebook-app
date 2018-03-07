package com.facebook.feed.rows.sections.text;

import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: video_channel_follow_data */
public class BaseTextPartDefinitionProvider extends AbstractAssistedProvider<BaseTextPartDefinition> {
    public final <E extends HasContext & HasFeedListType & HasPositionInformation> BaseTextPartDefinition<E> m17a(Boolean bool) {
        return new BaseTextPartDefinition(IdBasedProvider.a(this, 1473), CopyTextPartDefinition.a(this), bool, FeedHighlighter.a(this), SpannableInTextViewPartDefinition.a(this));
    }
}

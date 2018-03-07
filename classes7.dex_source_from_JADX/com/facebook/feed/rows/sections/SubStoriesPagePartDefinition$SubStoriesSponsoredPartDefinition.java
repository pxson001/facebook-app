package com.facebook.feed.rows.sections;

import android.view.View;
import android.widget.TextView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.attachments.ui.SubStoryItemViewWithCTA;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

/* compiled from: \b */
class SubStoriesPagePartDefinition$SubStoriesSponsoredPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Boolean, E, SubStoryItemViewWithCTA> {
    public final Object m23544a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return Boolean.valueOf(StoryProps.p((FeedProps) obj));
    }

    public final /* bridge */ /* synthetic */ void m23545a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1900056269);
        SubStoryItemViewWithCTA subStoryItemViewWithCTA = (SubStoryItemViewWithCTA) view;
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (subStoryItemViewWithCTA.f21099c.isPresent()) {
            ((TextView) subStoryItemViewWithCTA.f21099c.get()).setVisibility(booleanValue ? 0 : 8);
        }
        Logger.a(8, EntryType.MARK_POP, -282685650, a);
    }
}

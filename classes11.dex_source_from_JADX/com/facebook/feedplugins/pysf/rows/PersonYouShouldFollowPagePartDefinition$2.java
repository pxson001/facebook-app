package com.facebook.feedplugins.pysf.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: checkin_story_preview */
public class PersonYouShouldFollowPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLPeopleYouShouldFollowFeedUnitItem f8834a;
    final /* synthetic */ PersonYouShouldFollowPagePartDefinition f8835b;

    public PersonYouShouldFollowPagePartDefinition$2(PersonYouShouldFollowPagePartDefinition personYouShouldFollowPagePartDefinition, GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem) {
        this.f8835b = personYouShouldFollowPagePartDefinition;
        this.f8834a = graphQLPeopleYouShouldFollowFeedUnitItem;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1189006460);
        ((DefaultFeedUnitRenderer) this.f8835b.c.get()).a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(this.f8834a)), null);
        Logger.a(2, EntryType.UI_INPUT_END, -2043309827, a);
    }
}

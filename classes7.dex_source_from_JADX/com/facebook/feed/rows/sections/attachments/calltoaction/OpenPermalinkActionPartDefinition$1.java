package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: WHITE */
public class OpenPermalinkActionPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f20878a;
    final /* synthetic */ OpenPermalinkActionPartDefinition f20879b;

    public OpenPermalinkActionPartDefinition$1(OpenPermalinkActionPartDefinition openPermalinkActionPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink) {
        this.f20879b = openPermalinkActionPartDefinition;
        this.f20878a = graphQLStoryActionLink;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1240165210);
        this.f20879b.d.a(view.getContext(), this.f20878a.aE(), null, null);
        Logger.a(2, EntryType.UI_INPUT_END, -173833931, a);
    }
}

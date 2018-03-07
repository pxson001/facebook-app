package com.facebook.feedplugins.attachments.collage;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;

/* compiled from: TOGGLE_COUNT */
class ObjectionableContentCollageAttachmentPartDefinition$2 implements OnClickListener {
    final /* synthetic */ FeedProps f22573a;
    final /* synthetic */ HasContext f22574b;
    final /* synthetic */ ObjectionableContentCollageAttachmentPartDefinition f22575c;

    ObjectionableContentCollageAttachmentPartDefinition$2(ObjectionableContentCollageAttachmentPartDefinition objectionableContentCollageAttachmentPartDefinition, FeedProps feedProps, HasContext hasContext) {
        this.f22575c = objectionableContentCollageAttachmentPartDefinition;
        this.f22573a = feedProps;
        this.f22574b = hasContext;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 125951028);
        ImmutableList x = ((GraphQLStoryAttachment) this.f22573a.a).x();
        if (CollectionUtil.b(x)) {
            GraphQLMedia r = ((GraphQLStoryAttachment) x.get(0)).r();
            if (r != null) {
                this.f22575c.c.a(r.b());
                ((HasInvalidate) this.f22574b).a(new FeedProps[]{this.f22573a});
            }
        }
        Logger.a(2, EntryType.UI_INPUT_END, 487103720, a);
    }
}

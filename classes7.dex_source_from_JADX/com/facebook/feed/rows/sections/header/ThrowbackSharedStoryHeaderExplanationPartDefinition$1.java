package com.facebook.feed.rows.sections.header;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: Unrecognized int value for Screen */
class ThrowbackSharedStoryHeaderExplanationPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f21176a;
    final /* synthetic */ ThrowbackSharedStoryHeaderExplanationPartDefinition f21177b;

    ThrowbackSharedStoryHeaderExplanationPartDefinition$1(ThrowbackSharedStoryHeaderExplanationPartDefinition throwbackSharedStoryHeaderExplanationPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink) {
        this.f21177b = throwbackSharedStoryHeaderExplanationPartDefinition;
        this.f21176a = graphQLStoryActionLink;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2121603941);
        this.f21177b.h.a(view.getContext(), this.f21176a == null ? StringFormatUtil.formatStrLocaleSafe(FBLinks.ej, "shared_feed_story") : this.f21176a.aE());
        LogUtils.a(-1913961723, a);
    }
}

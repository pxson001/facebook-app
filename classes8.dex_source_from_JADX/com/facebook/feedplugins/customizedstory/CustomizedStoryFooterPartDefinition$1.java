package com.facebook.feedplugins.customizedstory;

import android.view.View;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.model.ComposerSourceType;

/* compiled from: grid_view_toggle_status_key */
public class CustomizedStoryFooterPartDefinition$1 implements ButtonClickedListener {
    final /* synthetic */ GraphQLCustomizedStory f12005a;
    final /* synthetic */ CustomizedStoryFooterPartDefinition f12006b;

    public CustomizedStoryFooterPartDefinition$1(CustomizedStoryFooterPartDefinition customizedStoryFooterPartDefinition, GraphQLCustomizedStory graphQLCustomizedStory) {
        this.f12006b = customizedStoryFooterPartDefinition;
        this.f12005a = graphQLCustomizedStory;
    }

    public final void m14071a(View view, FooterButtonId footerButtonId) {
        if (footerButtonId == FooterButtonId.SHARE) {
            CustomizedStoryFooterPartDefinition customizedStoryFooterPartDefinition = this.f12006b;
            customizedStoryFooterPartDefinition.b.a(null, ComposerConfigurationFactory.a(ComposerSourceType.FEED, Builder.a(CustomizedStoryFooterPartDefinition.d(this.f12005a)).b()).setIsEditTagEnabled(false).setNectarModule("newsfeed_composer").setDisableFriendTagging(true).setDisableMentions(true).a(), 1756, customizedStoryFooterPartDefinition.a);
        }
    }
}

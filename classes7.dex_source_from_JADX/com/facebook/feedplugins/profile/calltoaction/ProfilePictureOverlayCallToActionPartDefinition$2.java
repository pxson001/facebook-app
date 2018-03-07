package com.facebook.feedplugins.profile.calltoaction;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.heisman.ProfilePictureOverlayActivityLauncher;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.protocol.conversion.ImageOverlayConversionHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: SNAPSHOT_AND_IMPORT_ID_DELETED */
public class ProfilePictureOverlayCallToActionPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f23751a;
    final /* synthetic */ GraphQLStory f23752b;
    final /* synthetic */ ProfilePictureOverlayCallToActionPartDefinition f23753c;

    public ProfilePictureOverlayCallToActionPartDefinition$2(ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink, GraphQLStory graphQLStory) {
        this.f23753c = profilePictureOverlayCallToActionPartDefinition;
        this.f23751a = graphQLStoryActionLink;
        this.f23752b = graphQLStory;
    }

    public void onClick(View view) {
        int i = 0;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1910559515);
        GraphQLImageOverlay ax = this.f23751a.ax();
        Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(this.f23752b);
        if (!this.f23753c.f.a(ExperimentsForProfilePictureOverlayAbTestModule.e, false)) {
            if (this.f23753c.f.a(ExperimentsForProfilePictureOverlayAbTestModule.f, false)) {
                i = 1;
            } else if (!(o == null || o.r() == null || o.r().j() == null || o.r().j().g() != 82650203)) {
                i = 1;
            }
        }
        if (activity != null) {
            String b;
            ProfilePictureOverlayActivityLauncher profilePictureOverlayActivityLauncher = (ProfilePictureOverlayActivityLauncher) this.f23753c.b.get();
            GraphQLProfilePictureActionLinkType j = ActionLinkHelper.a(StoryAttachmentHelper.o(this.f23752b)).j();
            if (o.r() != null) {
                b = o.r().b();
            } else {
                b = null;
            }
            profilePictureOverlayActivityLauncher.a(activity, j, b, StoryAttachmentHelper.o(this.f23752b).B(), "story_cta", ImageOverlayConversionHelper.m8017a(ax), this.f23751a.s(), null, i);
        }
        LogUtils.a(-735367792, a);
    }
}

package com.facebook.feedplugins.profile.calltoaction;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: SNAPSHOT_AND_IMPORT_ID_DELETED */
public class ProfilePictureOverlayCallToActionPartDefinition$3 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f23754a;
    final /* synthetic */ GraphQLStory f23755b;
    final /* synthetic */ ProfilePictureOverlayCallToActionPartDefinition f23756c;

    public ProfilePictureOverlayCallToActionPartDefinition$3(ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink, GraphQLStory graphQLStory) {
        this.f23756c = profilePictureOverlayCallToActionPartDefinition;
        this.f23754a = graphQLStoryActionLink;
        this.f23755b = graphQLStory;
    }

    public void onClick(View view) {
        String b;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1390258905);
        GraphQLImageOverlay ax = this.f23754a.ax();
        ((ProfilePictureOverlayAnalyticsLogger) this.f23756c.c.get()).a(StoryAttachmentHelper.o(this.f23755b).B(), ax != null ? ax.l() : null);
        GraphQLProfile ah = this.f23754a.ah();
        String a2 = this.f23756c.d.a(ah.j(), ah.b());
        Bundle bundle = new Bundle();
        int g = ah.j().g();
        String b2 = ah.b();
        if (ah.ai() != null) {
            b = ah.ai().b();
        } else {
            b = null;
        }
        ModelBundle.a(bundle, g, b2, b, ah.U());
        ((IFeedIntentBuilder) this.f23756c.e.get()).a(view.getContext(), a2, bundle, null);
        LogUtils.a(-88833843, a);
    }
}

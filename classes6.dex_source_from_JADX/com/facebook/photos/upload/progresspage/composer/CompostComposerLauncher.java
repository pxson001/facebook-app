package com.facebook.photos.upload.progresspage.composer;

import android.support.v4.app.Fragment;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import javax.inject.Inject;

/* compiled from: getProperBaseMatrix */
public class CompostComposerLauncher {
    private final ComposerLauncher f13959a;
    private final ComposerConfigurationFactory f13960b;

    public static CompostComposerLauncher m21683b(InjectorLike injectorLike) {
        return new CompostComposerLauncher((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ComposerConfigurationFactory.b(injectorLike));
    }

    @Inject
    public CompostComposerLauncher(ComposerLauncher composerLauncher, ComposerConfigurationFactory composerConfigurationFactory) {
        this.f13959a = composerLauncher;
        this.f13960b = composerConfigurationFactory;
    }

    public final void m21684a(CompostDraftStory compostDraftStory, Fragment fragment, int i) {
        this.f13959a.a(compostDraftStory.mo934f(), m21682a(compostDraftStory), i, fragment);
    }

    private ComposerConfiguration m21682a(CompostDraftStory compostDraftStory) {
        Builder a;
        GraphQLStory graphQLStory = compostDraftStory.f8054c;
        if (!StoryAttachmentHelper.a(graphQLStory) || StoryAttachmentHelper.g(graphQLStory)) {
            a = ComposerConfigurationFactory.a(ComposerSourceSurface.COMPOST, "composerConfigurationFromDraft");
        } else if (StoryAttachmentHelper.b(graphQLStory)) {
            a = ComposerConfigurationFactory.a(ComposerSourceSurface.COMPOST, "composerPhotoConfigurationFromDraft");
        } else {
            throw new UnsupportedOperationException("We only support status, photo, and multi-photo posts for now...");
        }
        this.f13960b.a(graphQLStory, a, false);
        if (compostDraftStory.f8054c.aJ() == null) {
            a.setInitialTargetData(ComposerTargetData.f11579a);
        }
        return a.m18223a();
    }
}

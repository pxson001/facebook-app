package com.facebook.feed.inlinecomposer;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.util.composer.launch.DefaultNewsfeedComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.feed.util.composer.launch.SproutLauncherProvider;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ms_MY */
public class InlineComposerSproutUtil {
    private final Resources f13232a;
    private final SproutLauncherProvider f13233b;
    private final FeedComposerLauncherProvider f13234c;

    public static InlineComposerSproutUtil m19486a(InjectorLike injectorLike) {
        return new InlineComposerSproutUtil(ResourcesMethodAutoProvider.m6510a(injectorLike), (SproutLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SproutLauncherProvider.class), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class));
    }

    @Inject
    public InlineComposerSproutUtil(Resources resources, SproutLauncherProvider sproutLauncherProvider, FeedComposerLauncherProvider feedComposerLauncherProvider) {
        this.f13232a = resources;
        this.f13233b = sproutLauncherProvider;
        this.f13234c = feedComposerLauncherProvider;
    }

    public final void m19487a(InlineComposerModel inlineComposerModel, FragmentActivity fragmentActivity, int i) {
        this.f13233b.m19488a(SproutSource.FEED, this.f13234c.m15515a(new NewsfeedLauncherContext("feed_inline"), new DefaultNewsfeedComposerConfigCustomizer()), fragmentActivity.kO_(), fragmentActivity).a(inlineComposerModel.f12907b, inlineComposerModel.f12917l, this.f13232a.getDimensionPixelOffset(2131427594) + i, inlineComposerModel.f12912g);
    }
}

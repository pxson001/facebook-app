package com.facebook.feed.goodfriends.composer;

import android.content.res.Resources;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.goodfriends.data.GoodFriendsMetadataFetcher;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: answer_copyright_violation_type */
public class ComposerGoodFriendsPrivacyDelegate extends ComposerPrivacyDelegate {
    private final long f19206a;
    private final GoodFriendsMetadataFetcher f19207b;
    public final Resources f19208c;

    @Inject
    public ComposerGoodFriendsPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, Provider<String> provider, FbErrorReporter fbErrorReporter, TasksManager tasksManager, GoodFriendsMetadataFetcher goodFriendsMetadataFetcher, Resources resources) {
        super(privacyUpdatedHandler, fbErrorReporter, tasksManager);
        this.f19206a = Long.parseLong((String) provider.get());
        this.f19207b = goodFriendsMetadataFetcher;
        this.f19208c = resources;
    }

    public final String mo92b() {
        return "goodfriends:" + this.f19206a;
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.f1973b = this.f19208c.getString(2131236177);
        builder = builder;
        builder.f1974c = this.f19208c.getString(2131236178);
        builder = builder;
        builder.f1972a = GraphQLPrivacyOptionType.CUSTOM;
        ComposerFixedPrivacyData a = builder.m1926a();
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.f1994a = true;
        builder2 = builder2;
        builder2.f1995b = true;
        final ComposerPrivacyData a2 = builder2.m1943a(a).m1945a();
        m1904a(a2);
        this.f19207b.a(true, new Object(this) {
            public final /* synthetic */ ComposerGoodFriendsPrivacyDelegate f19205b;
        });
    }
}

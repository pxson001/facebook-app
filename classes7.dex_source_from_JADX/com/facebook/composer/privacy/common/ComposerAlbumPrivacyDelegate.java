package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: target_is_fixed */
public final class ComposerAlbumPrivacyDelegate extends ComposerPrivacyDelegate {
    private final GraphQLAlbum f1957a;
    private final Resources f1958b;

    @Inject
    public ComposerAlbumPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, Resources resources, @Nonnull @Assisted GraphQLAlbum graphQLAlbum) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f1957a = graphQLAlbum;
        this.f1958b = resources;
    }

    public final void mo91a() {
        super.mo91a();
        GraphQLImage m = this.f1957a.D().m();
        Builder builder = new Builder();
        builder.f1972a = GraphQLPrivacyOptionType.fromIconName(this.f1957a.D().m().d());
        builder = builder;
        builder.f1973b = this.f1957a.D().n();
        builder = builder;
        builder.f1974c = this.f1958b.getString(2131234253);
        ComposerFixedPrivacyData a = builder.m1926a();
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.f1994a = true;
        builder2 = builder2;
        builder2.f1997d = new OptimisticPostPrivacy(m.d(), this.f1957a.D().n());
        m1904a(builder2.m1943a(a).m1945a());
    }

    public final String mo92b() {
        return "album:" + this.f1957a.u();
    }
}

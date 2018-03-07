package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel.Builder;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_share_page_as_post */
public class ComposerPagePrivacyDelegate extends ComposerPrivacyDelegate {
    private final Resources f1992a;
    private final String f1993b;

    @Inject
    public ComposerPagePrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, Resources resources, @Assisted String str) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f1992a = resources;
        this.f1993b = str;
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.b = this.f1992a.getString(2131234252);
        builder.a();
        ComposerFixedPrivacyData.Builder builder2 = new ComposerFixedPrivacyData.Builder();
        builder2.f1972a = GraphQLPrivacyOptionType.EVERYONE;
        builder2 = builder2;
        builder2.f1973b = this.f1992a.getString(2131234252);
        builder2 = builder2;
        builder2.f1974c = this.f1992a.getString(2131234261);
        ComposerFixedPrivacyData a = builder2.m1926a();
        ComposerPrivacyData.Builder builder3 = new ComposerPrivacyData.Builder();
        builder3.f1994a = true;
        m1904a(builder3.m1943a(a).m1945a());
    }

    public final String mo92b() {
        return "page:" + this.f1993b;
    }
}

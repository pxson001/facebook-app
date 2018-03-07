package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_suggest_photo */
public class ComposerPageAdminPrivacyDelegate extends ComposerPrivacyDelegate {
    private final String f1989a;
    private final String f1990b;
    private final Resources f1991c;

    @Inject
    public ComposerPageAdminPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, @Assisted String str, @Assisted String str2, Resources resources) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f1989a = str;
        this.f1990b = str2;
        this.f1991c = resources;
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.f1972a = GraphQLPrivacyOptionType.EVERYONE;
        builder = builder;
        builder.f1973b = this.f1991c.getString(2131234252);
        builder = builder;
        builder.f1974c = this.f1991c.getString(2131234261);
        builder = builder;
        builder.f1975d = "{\"value\":\"EVERYONE\"}";
        ComposerFixedPrivacyData a = builder.m1926a();
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.f1994a = true;
        builder2 = builder2;
        builder2.f1997d = OptimisticPostPrivacy.b;
        m1904a(builder2.m1943a(a).m1945a());
    }

    public final String mo92b() {
        return "pageadmin:" + this.f1990b;
    }
}

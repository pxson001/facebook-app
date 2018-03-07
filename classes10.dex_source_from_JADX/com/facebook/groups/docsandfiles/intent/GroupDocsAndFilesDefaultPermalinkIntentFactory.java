package com.facebook.groups.docsandfiles.intent;

import android.content.Intent;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: Update - Internal */
public class GroupDocsAndFilesDefaultPermalinkIntentFactory implements GroupDocsAndFilesPermalinkIntentFactory {
    private ViewPermalinkIntentFactory f21436a;
    private String f21437b;

    @Inject
    public GroupDocsAndFilesDefaultPermalinkIntentFactory(ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f21436a = viewPermalinkIntentFactory;
    }

    public final GroupDocsAndFilesPermalinkIntentFactory mo953a() {
        return this;
    }

    public final GroupDocsAndFilesPermalinkIntentFactory mo955b() {
        return this;
    }

    public final GroupDocsAndFilesPermalinkIntentFactory mo954a(String str) {
        this.f21437b = str;
        return this;
    }

    public final Intent mo956c() {
        Preconditions.checkNotNull(this.f21437b);
        Builder builder = new Builder();
        ViewPermalinkIntentFactory viewPermalinkIntentFactory = this.f21436a;
        builder.b = this.f21437b;
        builder = builder;
        builder.a = this.f21437b;
        return viewPermalinkIntentFactory.a(builder.a());
    }
}

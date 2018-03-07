package com.facebook.feed.inlinecomposer.model;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: negative_feedback_action_on_reportable_entity */
public final class InlineComposerModel implements CacheableEntity {
    public final String f12906a;
    public final String f12907b;
    public final InlineComposerPromptSession f12908c;
    public final boolean f12909d;
    public final boolean f12910e;
    public final boolean f12911f;
    public final GraphQLExploreFeed f12912g;
    public final WorkComposerModel f12913h;
    public final String f12914i;
    public final String f12915j;
    public final String f12916k;
    public final String f12917l;
    public final int f12918m;
    public final boolean f12919n;
    public final boolean f12920o;

    protected InlineComposerModel(String str, String str2, @Nullable InlineComposerPromptSession inlineComposerPromptSession, boolean z, boolean z2, boolean z3, boolean z4, @Nullable WorkComposerModel workComposerModel, @Nullable GraphQLExploreFeed graphQLExploreFeed, int i, String str3, String str4, String str5, String str6, boolean z5) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.f12906a = str;
        this.f12907b = str2;
        this.f12908c = inlineComposerPromptSession;
        this.f12909d = z;
        this.f12910e = z2;
        this.f12919n = z3;
        this.f12911f = z4;
        this.f12920o = z5;
        if (workComposerModel == null) {
            workComposerModel = WorkComposerModel.f12921a;
        }
        this.f12913h = workComposerModel;
        this.f12918m = i;
        this.f12914i = str3;
        this.f12915j = str4;
        this.f12916k = str5;
        this.f12917l = str6;
        this.f12912g = graphQLExploreFeed;
    }

    public final String m18961b() {
        return this.f12907b;
    }

    public final InlineComposerPromptSession m18962c() {
        return this.f12908c;
    }

    public final boolean m18963f() {
        return this.f12919n;
    }

    public final boolean m18965h() {
        return this.f12911f;
    }

    public final String m18966n() {
        return this.f12917l;
    }

    public final String mo2507g() {
        return "NO_PROMPT_INLINE_COMPOSER_MODEL_CACHE_KEY";
    }
}

package com.facebook.feedplugins.musicstory.utils;

import android.net.Uri;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLExternalUrl;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: com.facebook.languages.switcher.activity.LanguageSwitcherBookmarksActivity */
public class MusicStoryDataExtractor {
    private final FeedProps<GraphQLStoryAttachment> f8401a;
    private final GraphQLStoryAttachment f8402b;
    public final GraphQLStory f8403c = AttachmentProps.c(this.f8401a);
    public final GraphQLNode f8404d;
    public final GraphQLExternalUrl f8405e;

    public MusicStoryDataExtractor(FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f8401a = feedProps;
        Preconditions.checkNotNull(this.f8401a);
        this.f8402b = (GraphQLStoryAttachment) feedProps.a;
        Preconditions.checkNotNull(this.f8402b.z());
        Preconditions.checkNotNull(this.f8402b.z().ad());
        this.f8404d = this.f8402b.z();
        Preconditions.checkState(this.f8404d.j().g() == -1221639264);
        this.f8405e = this.f8404d.cX();
    }

    public final Uri m9301a() {
        return Uri.parse(this.f8404d.ad());
    }

    public final String m9302b() {
        return this.f8404d.fa() != null ? this.f8404d.fa().aa() : this.f8404d.U();
    }

    public final String m9303c() {
        return this.f8404d.eL();
    }

    @Nullable
    public final Uri m9304d() {
        if (Strings.isNullOrEmpty(this.f8404d.bs())) {
            return null;
        }
        return Uri.parse(this.f8404d.bs());
    }

    @Nullable
    public final Uri m9305e() {
        if (this.f8402b.r() == null || this.f8402b.r().Y() == null) {
            return null;
        }
        return Uri.parse(this.f8402b.r().Y().b());
    }

    @Nullable
    public final String m9306f() {
        if (this.f8404d.W() == null || this.f8404d.W().isEmpty()) {
            return null;
        }
        return (String) this.f8404d.W().get(0);
    }

    @Nullable
    public final String m9307g() {
        if (this.f8404d.bf() == null || this.f8404d.bf().isEmpty()) {
            return null;
        }
        return (String) this.f8404d.bf().get(0);
    }

    @Nullable
    public final Uri m9308h() {
        if (this.f8404d.cX() == null || Strings.isNullOrEmpty(this.f8404d.cX().p())) {
            return null;
        }
        return Uri.parse(this.f8404d.cX().p());
    }

    @Nullable
    public final Uri m9309i() {
        if (this.f8404d.cX() == null || Strings.isNullOrEmpty(this.f8404d.cX().H())) {
            return null;
        }
        return Uri.parse(this.f8404d.cX().H());
    }

    @Nullable
    public final String m9310j() {
        if (this.f8404d.fa() == null || this.f8404d.fa().H() == null) {
            return null;
        }
        return this.f8404d.fa().H();
    }
}

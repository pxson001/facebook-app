package com.facebook.platform.composer.model;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: review_rating */
public class PlatformComposerModel {
    public final String f4186a;
    public final ComposerConfiguration f4187b;
    public final PlatformComposition f4188c;
    public final ComposerPrivacyData f4189d;
    public final ComposerTargetData f4190e;
    public final ComposerLocation f4191f;
    public final GraphQLPrivacyOption f4192g;
    public final ComposerAudienceEducatorData f4193h;
    public final ViewerContext f4194i;
    public final int f4195j;
    public final boolean f4196k;
    public final int f4197l;
    public final boolean f4198m;
    public final boolean f4199n;

    /* compiled from: review_rating */
    public class Builder {
        public String f4172a;
        public ComposerConfiguration f4173b;
        public PlatformComposition f4174c;
        public ComposerPrivacyData f4175d;
        public ComposerTargetData f4176e;
        public ComposerLocation f4177f;
        public GraphQLPrivacyOption f4178g;
        public ComposerAudienceEducatorData f4179h;
        public ViewerContext f4180i;
        public int f4181j;
        public int f4182k;
        public boolean f4183l;
        public boolean f4184m;
        public boolean f4185n;

        public Builder(PlatformComposerModel platformComposerModel) {
            this.f4172a = platformComposerModel.f4186a;
            this.f4173b = platformComposerModel.f4187b;
            this.f4174c = platformComposerModel.f4188c;
            this.f4175d = platformComposerModel.f4189d;
            this.f4176e = platformComposerModel.f4190e;
            this.f4177f = platformComposerModel.f4191f;
            this.f4178g = platformComposerModel.f4192g;
            this.f4179h = platformComposerModel.f4193h;
            this.f4180i = platformComposerModel.f4194i;
            this.f4181j = platformComposerModel.f4195j;
            this.f4182k = platformComposerModel.f4197l;
            this.f4183l = platformComposerModel.f4196k;
            this.f4184m = platformComposerModel.f4198m;
            this.f4185n = platformComposerModel.f4199n;
        }

        public final Builder m4140a(ComposerTargetData composerTargetData) {
            this.f4176e = m4139a(composerTargetData, this.f4174c);
            return this;
        }

        private static ComposerTargetData m4139a(@Nullable ComposerTargetData composerTargetData, PlatformComposition platformComposition) {
            Preconditions.checkNotNull(platformComposition);
            if (composerTargetData == null) {
                composerTargetData = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder().a();
            }
            if (composerTargetData.targetId <= 0) {
                com.facebook.ipc.composer.intent.ComposerTargetData.Builder builder = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder(composerTargetData);
                builder.a = platformComposition.m4150b();
                composerTargetData = builder.a();
            }
            if (composerTargetData.targetId != platformComposition.m4150b()) {
                return composerTargetData;
            }
            builder = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder(composerTargetData);
            builder.b = TargetType.UNDIRECTED;
            return builder.a();
        }

        public final PlatformComposerModel m4141a() {
            return new PlatformComposerModel(this);
        }
    }

    public PlatformComposerModel(Builder builder) {
        this.f4186a = builder.f4172a;
        this.f4187b = builder.f4173b;
        this.f4188c = builder.f4174c;
        this.f4189d = builder.f4175d;
        this.f4190e = builder.f4176e;
        this.f4191f = builder.f4177f;
        this.f4192g = builder.f4178g;
        this.f4193h = builder.f4179h;
        this.f4194i = builder.f4180i;
        this.f4195j = builder.f4181j;
        this.f4196k = builder.f4183l;
        this.f4197l = builder.f4182k;
        this.f4198m = builder.f4184m;
        this.f4199n = builder.f4185n;
    }

    public final Builder m4142a() {
        return new Builder(this);
    }
}

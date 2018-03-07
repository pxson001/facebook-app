package com.facebook.composer.model;

import android.text.SpannedString;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.TargetType;
import javax.annotation.Nullable;

/* compiled from: fromWebView */
public class ComposerModel {
    public final String f6743a;
    public final ComposerConfiguration f6744b;
    public final Composition f6745c;
    public final ComposerPrivacyData f6746d;
    public final ComposerTargetData f6747e;
    public final ComposerLocation f6748f;
    public final ComposerSessionLoggingData f6749g;
    public final GraphQLPrivacyOption f6750h;
    public final ComposerAudienceEducatorData f6751i;
    public final InlineSproutsState f6752j;
    public final int f6753k;
    public final boolean f6754l;
    public final boolean f6755m;
    public final boolean f6756n;
    public final boolean f6757o;
    public final boolean f6758p;
    public final long f6759q;
    @Nullable
    public final SpannedString f6760r;

    /* compiled from: fromWebView */
    public class Builder {
        public String f6725a;
        public ComposerConfiguration f6726b;
        public Composition f6727c;
        public ComposerPrivacyData f6728d;
        public ComposerTargetData f6729e;
        public ComposerLocation f6730f;
        public ComposerSessionLoggingData f6731g;
        public GraphQLPrivacyOption f6732h;
        public ComposerAudienceEducatorData f6733i;
        public InlineSproutsState f6734j;
        public int f6735k;
        public boolean f6736l;
        public boolean f6737m;
        public boolean f6738n;
        public boolean f6739o;
        public boolean f6740p;
        public long f6741q;
        @Nullable
        public SpannedString f6742r;

        public Builder(ComposerModel composerModel) {
            this.f6725a = composerModel.f6743a;
            this.f6726b = composerModel.f6744b;
            this.f6727c = composerModel.f6745c;
            this.f6728d = composerModel.f6746d;
            this.f6729e = composerModel.f6747e;
            this.f6730f = composerModel.f6748f;
            this.f6731g = composerModel.f6749g;
            this.f6732h = composerModel.f6750h;
            this.f6733i = composerModel.f6751i;
            this.f6734j = composerModel.f6752j;
            this.f6735k = composerModel.f6753k;
            this.f6736l = composerModel.f6754l;
            this.f6737m = composerModel.f6755m;
            this.f6738n = composerModel.f6756n;
            this.f6739o = composerModel.f6757o;
            this.f6740p = composerModel.f6758p;
            this.f6741q = composerModel.f6759q;
            this.f6742r = composerModel.f6760r;
        }

        public final Builder m8141a(ComposerTargetData composerTargetData, long j) {
            this.f6729e = m8139b(composerTargetData, j);
            return this;
        }

        private static ComposerTargetData m8139b(@Nullable ComposerTargetData composerTargetData, long j) {
            if (composerTargetData == null) {
                composerTargetData = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder().a();
            }
            if (composerTargetData.targetId <= 0) {
                com.facebook.ipc.composer.intent.ComposerTargetData.Builder builder = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder(composerTargetData);
                builder.a = j;
                composerTargetData = builder.a();
            }
            if (composerTargetData.targetId != j) {
                return composerTargetData;
            }
            builder = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder(composerTargetData);
            builder.b = TargetType.UNDIRECTED;
            return builder.a();
        }

        public final Builder m8140a(long j) {
            this.f6741q = j;
            return this;
        }

        public final ComposerModel m8142a() {
            return new ComposerModel(this);
        }
    }

    public ComposerModel(Builder builder) {
        this.f6743a = builder.f6725a;
        this.f6744b = builder.f6726b;
        this.f6745c = builder.f6727c;
        this.f6746d = builder.f6728d;
        this.f6747e = builder.f6729e;
        this.f6748f = builder.f6730f;
        this.f6749g = builder.f6731g;
        this.f6750h = builder.f6732h;
        this.f6751i = builder.f6733i;
        this.f6752j = builder.f6734j;
        this.f6753k = builder.f6735k;
        this.f6754l = builder.f6736l;
        this.f6755m = builder.f6737m;
        this.f6756n = builder.f6738n;
        this.f6757o = builder.f6739o;
        this.f6758p = builder.f6740p;
        this.f6759q = builder.f6741q;
        this.f6760r = builder.f6742r;
    }

    public final Builder m8143a() {
        return new Builder(this);
    }
}

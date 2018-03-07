package com.facebook.composer.privacy.common;

import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: tapped_see_full_menu */
public final class ComposerPrivacyData {
    public final ComposerFixedPrivacyData f2000a;
    @Nullable
    public final SelectablePrivacyData f2001b;
    public final boolean f2002c;
    public final boolean f2003d;
    public final boolean f2004e;
    public final OptimisticPostPrivacy f2005f;

    /* compiled from: tapped_see_full_menu */
    public class Builder {
        public boolean f1994a = false;
        public boolean f1995b = false;
        public boolean f1996c = false;
        public OptimisticPostPrivacy f1997d = OptimisticPostPrivacy.a;
        public ComposerFixedPrivacyData f1998e = null;
        @Nullable
        public SelectablePrivacyData f1999f = null;

        public Builder(ComposerPrivacyData composerPrivacyData) {
            this.f1994a = composerPrivacyData.f2002c;
            this.f1995b = composerPrivacyData.f2003d;
            this.f1996c = composerPrivacyData.f2004e;
            this.f1998e = composerPrivacyData.f2000a;
            this.f1999f = composerPrivacyData.f2001b;
        }

        public final Builder m1943a(ComposerFixedPrivacyData composerFixedPrivacyData) {
            Preconditions.checkArgument(this.f1999f == null, "If we are setting fixed privacy data, we cannot have selectable privacy data.");
            this.f1998e = composerFixedPrivacyData;
            return this;
        }

        public final Builder m1944a(SelectablePrivacyData selectablePrivacyData) {
            Preconditions.checkArgument(this.f1998e == null, "If we are setting selectable privacy data, we cannot have fixed privacy data.");
            this.f1999f = selectablePrivacyData;
            if (!(this.f1999f == null || this.f1999f.d == null)) {
                OptimisticPostPrivacy optimisticPostPrivacy;
                GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.d;
                if (graphQLPrivacyOption == null) {
                    optimisticPostPrivacy = null;
                } else if (selectablePrivacyData.a != null && selectablePrivacyData.b) {
                    optimisticPostPrivacy = OptimisticPostPrivacy.a;
                } else if (graphQLPrivacyOption.l() != null) {
                    optimisticPostPrivacy = new OptimisticPostPrivacy(graphQLPrivacyOption.l().d(), graphQLPrivacyOption.d());
                } else {
                    optimisticPostPrivacy = OptimisticPostPrivacy.a;
                }
                this.f1997d = optimisticPostPrivacy;
            }
            return this;
        }

        public final ComposerPrivacyData m1945a() {
            return new ComposerPrivacyData(this);
        }
    }

    /* compiled from: tapped_see_full_menu */
    public interface ProvidesPrivacyData {
        ComposerPrivacyData ag();
    }

    public ComposerPrivacyData(Builder builder) {
        boolean z;
        boolean z2 = true;
        if (!builder.f1994a) {
            Preconditions.checkArgument(builder.f1998e == null, "If the privacy is disabled, we should not have fixed privacy data.");
            if (builder.f1999f == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "If the privacy is disabled, we should not have selectable privacy data.");
        }
        if (builder.f1999f != null) {
            if (builder.f1998e == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "If we have selectable privacy data, we should not have fixed privacy data.");
        }
        if (builder.f1998e != null) {
            if (builder.f1999f != null) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "If we have fixed privacy data, we should not have selectable privacy data.");
        }
        this.f2002c = builder.f1994a;
        this.f2003d = builder.f1995b;
        this.f2004e = builder.f1996c;
        this.f2005f = builder.f1997d;
        this.f2001b = builder.f1999f;
        this.f2000a = builder.f1998e;
    }

    public final String toString() {
        return Objects.toStringHelper(ComposerPrivacyData.class).add("isEnabled", this.f2002c).add("isLoading", this.f2003d).add("isSelectable", this.f2001b != null).toString();
    }

    public final String m1946a() {
        if (this.f2000a != null) {
            return this.f2000a.f1979d;
        }
        if (this.f2001b != null) {
            return this.f2001b.d();
        }
        return "";
    }
}

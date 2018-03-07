package com.facebook.composer.publish.common;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.OfflinePostProgressController;
import com.facebook.graphql.model.OfflinePostProgressController.Mode;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;

/* compiled from: ad_account */
public class PendingStory {
    private static final String f11519a = PendingStory.class.getSimpleName();
    public final PendingStoryPersistentData f11520b;
    public final OfflinePostProgressController f11521c;
    public final int f11522d;

    /* compiled from: ad_account */
    public class Builder {
        public PendingStoryPersistentData f11516a;
        public OfflinePostProgressController f11517b = new OfflinePostProgressController();
        public int f11518c = 100;

        public Builder(@Nonnull PendingStoryPersistentData pendingStoryPersistentData) {
            this.f11516a = pendingStoryPersistentData;
        }

        public static Builder m19668a(PendingStory pendingStory) {
            Builder builder = new Builder(pendingStory.f11520b);
            builder.f11517b = pendingStory.f11521c;
            return builder;
        }

        public final Builder m19669a(PendingStoryPersistentData pendingStoryPersistentData) {
            this.f11516a = pendingStoryPersistentData;
            return this;
        }

        public final PendingStory m19670a() {
            ImmutableList M = this.f11516a.f11523a.M();
            if (M != null && M.size() == 1) {
                GraphQLMedia r = ((GraphQLStoryAttachment) M.get(0)).r();
                if (r != null) {
                    GraphQLObjectType j = r.j();
                    if (j != null && j.g() == 82650203) {
                        this.f11518c = 0;
                        this.f11517b.m22560a(10000, 5000, 300000);
                    }
                }
            }
            return new PendingStory(this);
        }
    }

    public PendingStory(Builder builder) {
        this.f11520b = builder.f11516a;
        this.f11521c = builder.f11517b;
        this.f11522d = builder.f11518c;
    }

    public final GraphQLStory m19672a() {
        return this.f11520b.f11523a;
    }

    public final PostParamsWrapper m19674b() {
        return this.f11520b.f11524b;
    }

    public final PendingStoryPersistentData m19677c() {
        return this.f11520b;
    }

    public final boolean m19678d() {
        return this.f11521c.m22564d();
    }

    public final boolean m19679f() {
        return this.f11521c.m22562b();
    }

    public final int m19671a(long j) {
        return this.f11521c.m22561b(j);
    }

    public final void m19673a(long j, boolean z) {
        int i = z ? this.f11522d : 800;
        OfflinePostProgressController offlinePostProgressController = this.f11521c;
        offlinePostProgressController.m22558a();
        offlinePostProgressController.f13495k = true;
        offlinePostProgressController.m22559a(j, i);
    }

    public final void m19676b(long j, boolean z) {
        if (this.f11521c.m22564d()) {
            this.f11521c.m22558a();
        }
        this.f11521c.m22559a(j, z ? this.f11522d : 800);
    }

    public final void m19675b(long j) {
        OfflinePostProgressController offlinePostProgressController = this.f11521c;
        if (offlinePostProgressController.m22565e()) {
            offlinePostProgressController.m22563c(j, 1000);
            offlinePostProgressController.f13487c = Mode.FINISHING_UP;
        }
    }
}

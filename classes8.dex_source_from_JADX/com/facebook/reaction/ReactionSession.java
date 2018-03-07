package com.facebook.reaction;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reaction.constants.ReactionIntentConstants.EntryPoint;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* compiled from: buttonSize */
public class ReactionSession {
    public Runnable f18656A = null;
    private boolean f18657B = false;
    public final String f18658a;
    private final long f18659b;
    public final Surface f18660c;
    public final SettableFuture<String> f18661d;
    public final LinkedList<ReactionStories> f18662e;
    @Nullable
    public String f18663f = null;
    public Long f18664g = null;
    public long f18665h = 0;
    public long f18666i = 0;
    public long f18667j = 0;
    public long f18668k = 0;
    public long f18669l = 0;
    public boolean f18670m = false;
    public String f18671n = null;
    public boolean f18672o = false;
    public boolean f18673p = false;
    public boolean f18674q = false;
    public boolean f18675r = false;
    public PlaceTipWelcomeHeaderFragmentModel f18676s;
    private String f18677t = null;
    private String f18678u = null;
    private long f18679v = 0;
    public boolean f18680w = false;
    public Bundle f18681x = null;
    public ReactionQueryParams f18682y = null;
    private WeakReference<ReactionSessionListener> f18683z = null;

    public ReactionSession(String str, Surface surface, long j) {
        this.f18658a = str;
        this.f18659b = j;
        this.f18660c = surface;
        this.f18661d = SettableFuture.f();
        this.f18662e = new LinkedList();
    }

    public final void m22557a(@Nullable ReactionStories reactionStories) {
        boolean z = false;
        if (reactionStories == null) {
            this.f18673p = false;
            return;
        }
        this.f18662e.add(reactionStories);
        if (!(reactionStories.c() == null || !reactionStories.c().b() || reactionStories.c().a() == null)) {
            z = true;
        }
        this.f18673p = z;
    }

    public final void m22554a() {
        this.f18662e.clear();
        this.f18673p = false;
        this.f18680w = false;
    }

    public final ListenableFuture<String> m22559b() {
        return this.f18661d;
    }

    @Nullable
    public final EntryPoint m22560c() {
        if (this.f18681x == null) {
            return null;
        }
        int i = this.f18681x.getInt("entry_point", -1);
        if (i >= 0) {
            return EntryPoint.values()[i];
        }
        return null;
    }

    @Nullable
    public final String m22561e() {
        if (this.f18681x == null) {
            return null;
        }
        return this.f18681x.getString("gravity_suggestifier_id");
    }

    public final String m22562f() {
        return this.f18658a;
    }

    @Nullable
    public final String m22563g() {
        ReactionStories h = m22564h();
        if (h == null || h.c() == null) {
            return null;
        }
        return h.c().a();
    }

    @Nullable
    public final ReactionStories m22564h() {
        if (this.f18662e.isEmpty()) {
            return null;
        }
        return (ReactionStories) this.f18662e.getLast();
    }

    public final long m22565j() {
        return this.f18659b;
    }

    public final long m22566k() {
        return this.f18665h;
    }

    public final long m22567l() {
        return this.f18666i;
    }

    @Nullable
    public final ReactionQueryParams m22568o() {
        return this.f18682y;
    }

    public final ImmutableList<ReactionStories> m22569p() {
        return ImmutableList.copyOf(this.f18662e);
    }

    public final long m22570q() {
        return this.f18667j;
    }

    public final long m22571r() {
        return this.f18668k;
    }

    public final long m22572s() {
        boolean z = true;
        if (!m22547B()) {
            boolean z2;
            if (this.f18667j > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
        }
        if (this.f18669l <= 0) {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f18667j - this.f18669l;
    }

    @Nullable
    public final ReactionSessionListener m22573u() {
        return this.f18683z == null ? null : (ReactionSessionListener) this.f18683z.get();
    }

    @Nullable
    public final String m22574v() {
        return this.f18681x == null ? null : this.f18681x.getString("source_entity_id");
    }

    public final Surface m22575w() {
        return this.f18660c;
    }

    public final long m22576x() {
        return this.f18669l;
    }

    public final boolean m22577z() {
        return !this.f18662e.isEmpty();
    }

    public final boolean m22546A() {
        if (this.f18662e.isEmpty()) {
            return false;
        }
        Iterator it = this.f18662e.iterator();
        while (it.hasNext()) {
            if (!((ReactionStories) it.next()).a().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m22547B() {
        return ReactionSurfaceUtil.m4780g(this.f18660c);
    }

    public final boolean m22548C() {
        return this.f18674q;
    }

    public final void m22549F() {
        this.f18674q = false;
        this.f18672o = false;
    }

    public final void m22558a(@Nullable PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel) {
        if (placeTipWelcomeHeaderFragmentModel != null) {
            this.f18676s = placeTipWelcomeHeaderFragmentModel;
        }
    }

    public final void m22556a(ReactionSessionListener reactionSessionListener) {
        this.f18683z = new WeakReference(reactionSessionListener);
    }

    @Nullable
    public final Long m22550H() {
        boolean z = true;
        if (this.f18663f == null || this.f18664g == null) {
            return null;
        }
        boolean z2;
        if (this.f18669l <= 0) {
            Object obj;
            if (this.f18660c == Surface.ANDROID_FEED_CHECKIN_SUGGESTION) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return null;
            }
        }
        if (this.f18664g.longValue() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        if (this.f18669l <= 0) {
            z = false;
        }
        Preconditions.checkState(z);
        return Long.valueOf(this.f18664g.longValue() - this.f18669l);
    }

    public final void m22555a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.facebook.STREAM_PUBLISH_START".equals(action)) {
                this.f18679v = intent.getLongExtra("extra_target_id", 0);
            }
            if ("com.facebook.STREAM_PUBLISH_COMPLETE".equals(action)) {
                GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("graphql_story");
                if (graphQLStory != null) {
                    this.f18677t = graphQLStory.ai();
                    this.f18678u = graphQLStory.c();
                }
            }
        }
    }

    public final String m22551J() {
        return this.f18677t;
    }

    public final String m22552K() {
        return this.f18678u;
    }

    public final long m22553L() {
        return this.f18679v;
    }
}

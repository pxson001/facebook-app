package com.facebook.reaction.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionFavoriteButtonEvent;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Wrong JSON payload */
public class ReactionHeaderView extends CustomRelativeLayout {
    @Inject
    Lazy<ReactionEventBus> f20771a;
    @Inject
    OptimisticStoryStateCache f20772b;
    @Nullable
    private ImageButton f20773c;
    @Nullable
    private GlyphColorizer f20774d;
    public boolean f20775e;
    private FbTextView f20776f;
    private ReactionPostStatusView f20777g;

    private static <T extends View> void m24405a(Class<T> cls, T t) {
        m24406a((Object) t, t.getContext());
    }

    private static void m24406a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ReactionHeaderView) obj).m24403a(IdBasedSingletonScopeProvider.b(fbInjector, 9854), OptimisticStoryStateCache.a(fbInjector));
    }

    public ReactionHeaderView(Context context) {
        this(context, null);
    }

    public ReactionHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20775e = false;
        setContentView(2130906693);
        m24405a(ReactionHeaderView.class, (View) this);
    }

    public void setPlaceNameTitleAlpha(float f) {
        if (this.f20776f != null) {
            this.f20776f.setAlpha(f);
        }
    }

    public final void m24413a(Surface surface, @Nullable String str) {
        if (!ReactionSurfaceUtil.m4790v(surface) && !Strings.isNullOrEmpty(str) && this.f20776f == null) {
            setPlaceNameTitle(str);
        }
    }

    public final void m24415a(String str, Optional<PendingStory> optional) {
        if (this.f20777g != null) {
            this.f20777g.m24421a(str, (Optional) optional);
        } else if (optional.isPresent()) {
            PendingStory pendingStory = (PendingStory) optional.get();
            if ("com.facebook.STREAM_PUBLISH_START".equals(str)) {
                m24412c(2131237276);
            } else if (this.f20772b.a(pendingStory.a()) == GraphQLFeedOptimisticPublishState.SUCCESS) {
                m24412c(2131237277);
            } else if (pendingStory.f()) {
                m24412c(2131237276);
            } else {
                m24412c(2131237274);
            }
        } else {
            m24412c(2131237277);
        }
    }

    private void m24402a(View view) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        int dimension = (int) getResources().getDimension(2131431395);
        layoutParams.setMargins(dimension, 0, dimension, 0);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private FbTextView m24400a(String str) {
        FbTextView fbTextView = (FbTextView) LayoutInflater.from(getContext()).inflate(2130906694, this, false);
        fbTextView.setText(str);
        return fbTextView;
    }

    private GlyphColorizer getGlyphColorizer() {
        if (this.f20774d == null) {
            this.f20774d = new GlyphColorizer(getResources());
        }
        return this.f20774d;
    }

    public static void m24404a(ReactionHeaderView reactionHeaderView) {
        if (reactionHeaderView.f20773c != null) {
            reactionHeaderView.f20773c.setImageDrawable(reactionHeaderView.getGlyphColorizer().a(2130840114, reactionHeaderView.f20775e ? -10972929 : -1));
        }
    }

    private void m24410b(ReactionSession reactionSession, Fragment fragment) {
        GravityActionMenuButton gravityActionMenuButton = new GravityActionMenuButton(getContext());
        if (gravityActionMenuButton.m24392a(reactionSession, fragment)) {
            gravityActionMenuButton.setLayoutParams(m24409b());
            addView(gravityActionMenuButton);
        }
    }

    private static RelativeLayout.LayoutParams m24409b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.addRule(21);
        }
        layoutParams.addRule(15);
        return layoutParams;
    }

    private void setupPlaceTipsExplorerMenuButton(@Nullable final Bundle bundle) {
        if (bundle != null && bundle.containsKey("place_id") && bundle.containsKey("favorite_page")) {
            this.f20775e = bundle.getBoolean("favorite_page");
            this.f20773c = new ImageButton(getContext());
            this.f20773c.setBackgroundResource(17170445);
            this.f20773c.setLayoutParams(m24409b());
            this.f20773c.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ReactionHeaderView f20770b;

                public void onClick(View view) {
                    boolean z;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 581144828);
                    ReactionHeaderView reactionHeaderView = this.f20770b;
                    if (this.f20770b.f20775e) {
                        z = false;
                    } else {
                        z = true;
                    }
                    reactionHeaderView.f20775e = z;
                    ((ReactionEventBus) this.f20770b.f20771a.get()).a(new ReactionFavoriteButtonEvent(bundle.getString("place_id"), this.f20770b.f20775e, bundle.getString("reaction_session_id")));
                    ReactionHeaderView.m24404a(this.f20770b);
                    LogUtils.a(-549740120, a);
                }
            });
            m24404a(this);
            addView(this.f20773c);
        }
    }

    private void m24401a(@Nullable Bundle bundle, Surface surface) {
        if (ReactionSurfaceUtil.m4790v(surface)) {
            this.f20777g = new ReactionPostStatusView(getContext());
            m24402a(this.f20777g);
        } else if (bundle != null && !Strings.isNullOrEmpty(bundle.getString("place_name"))) {
            setPlaceNameTitle(bundle.getString("place_name"));
        }
    }

    public final void m24414a(ReactionSession reactionSession, Fragment fragment) {
        Surface surface = reactionSession.f18660c;
        Bundle bundle = reactionSession.f18681x;
        m24401a(bundle, surface);
        if (ReactionSurfaceUtil.m4781h(surface)) {
            m24410b(reactionSession, fragment);
        } else if (surface == Surface.ANDROID_PLACE_TIPS_EXPLORER) {
            setupPlaceTipsExplorerMenuButton(bundle);
        }
    }

    private void setPlaceNameTitle(String str) {
        this.f20776f = m24400a(str);
        setPlaceNameTitleAlpha(0.0f);
        m24402a(this.f20776f);
    }

    private void m24412c(@StringRes int i) {
        Toast.makeText(getContext(), i, 0).show();
    }

    private void m24403a(Lazy<ReactionEventBus> lazy, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f20771a = lazy;
        this.f20772b = optimisticStoryStateCache;
    }
}

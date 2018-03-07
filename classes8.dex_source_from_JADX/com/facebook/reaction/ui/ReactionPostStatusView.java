package com.facebook.reaction.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: Who are you rooting for? */
public class ReactionPostStatusView extends CustomLinearLayout {
    @Inject
    public OptimisticStoryStateCache f20779a;
    private ImageView f20780b;
    public OnClickListener f20781c;
    private TextView f20782d;
    public GraphQLStory f20783e;
    public Lazy<OfflinePostHeaderController> f20784f;

    /* compiled from: Who are you rooting for? */
    public class C21991 implements OnClickListener {
        final /* synthetic */ ReactionPostStatusView f20778a;

        public C21991(ReactionPostStatusView reactionPostStatusView) {
            this.f20778a = reactionPostStatusView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -783858385);
            if (this.f20778a.f20783e == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -973577371, a);
                return;
            }
            ReactionPostStatusView.m24417a(this.f20778a, 2130843432, 2131237276, AnimationUtils.loadAnimation(this.f20778a.getContext(), 2130968602));
            ((OfflinePostHeaderController) this.f20778a.f20784f.get()).a(this.f20778a.f20783e, RetrySource.REACTION);
            ReactionPostStatusView.m24420c(this.f20778a);
            LogUtils.a(-1459904461, a);
        }
    }

    public static void m24418a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionPostStatusView reactionPostStatusView = (ReactionPostStatusView) obj;
        reactionPostStatusView.f20784f = IdBasedSingletonScopeProvider.b(fbInjector, 6091);
        reactionPostStatusView.f20779a = OptimisticStoryStateCache.a(fbInjector);
    }

    public ReactionPostStatusView(Context context) {
        this(context, null);
    }

    private ReactionPostStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = ReactionPostStatusView.class;
        m24418a((Object) this, getContext());
        setContentView(2130906696);
        setOrientation(0);
        this.f20780b = (ImageView) a(2131566758);
        this.f20782d = (TextView) a(2131566755);
    }

    public final void m24421a(String str, Optional<PendingStory> optional) {
        if (optional == null || !optional.isPresent()) {
            m24419b();
            return;
        }
        PendingStory pendingStory = (PendingStory) optional.get();
        if ("com.facebook.STREAM_PUBLISH_START".equals(str)) {
            m24416a(pendingStory.a());
        } else if (this.f20779a.a(pendingStory.a()) == GraphQLFeedOptimisticPublishState.SUCCESS) {
            m24419b();
        } else if (pendingStory.f()) {
            m24416a(pendingStory.a());
        } else if (pendingStory.b().b() != null) {
            if (!pendingStory.b().b().isRetriable || this.f20783e == null) {
                m24417a(this, 2130842901, 2131237274, null);
                m24420c(this);
            } else {
                m24417a(this, 2130839618, 2131237275, null);
                if (this.f20781c == null) {
                    this.f20781c = new C21991(this);
                }
                setOnClickListener(this.f20781c);
            }
        }
    }

    private void m24416a(GraphQLStory graphQLStory) {
        m24417a(this, 2130843432, 2131237276, AnimationUtils.loadAnimation(getContext(), 2130968602));
        this.f20783e = graphQLStory;
        m24420c(this);
    }

    private void m24419b() {
        m24417a(this, 2130842903, 2131237277, null);
        m24420c(this);
    }

    public static void m24420c(ReactionPostStatusView reactionPostStatusView) {
        reactionPostStatusView.setOnClickListener(null);
        reactionPostStatusView.setClickable(false);
    }

    public static void m24417a(ReactionPostStatusView reactionPostStatusView, int i, int i2, Animation animation) {
        reactionPostStatusView.f20780b.setImageDrawable(reactionPostStatusView.getResources().getDrawable(i));
        if (animation == null) {
            reactionPostStatusView.f20780b.clearAnimation();
        } else {
            reactionPostStatusView.f20780b.startAnimation(animation);
        }
        reactionPostStatusView.f20782d.setText(reactionPostStatusView.getResources().getString(i2));
    }
}

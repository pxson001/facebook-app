package com.facebook.feedplugins.base.blingbar;

import android.animation.Animator;
import android.view.View;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition.ViewBlingBarAnimationBuilderCallbacks;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: TDataProvider;)V */
public class BlingBarAnimationBuilder<V extends View> implements AnimationBuilder<AnimationData, V> {
    private final DefaultAnimationPartFactory f22876a;
    private final ExperimentalBlingBarStyler f22877b;
    public final ViewBlingBarAnimationBuilderCallbacks f22878c;

    /* compiled from: TDataProvider;)V */
    public class AnimationData {
        public final boolean f22871a;
        public final boolean f22872b;
        public final int f22873c;
        public final int f22874d;
        public final int f22875e;

        public AnimationData(@Nullable GraphQLFeedback graphQLFeedback, boolean z) {
            boolean z2 = graphQLFeedback != null && graphQLFeedback.y_();
            this(z2, z, BlingBarAnimationBuilder.m25411b(graphQLFeedback), BlingBarAnimationBuilder.m25409a(graphQLFeedback), GraphQLHelper.m(graphQLFeedback));
        }

        private AnimationData(boolean z, boolean z2, int i, int i2, int i3) {
            this.f22871a = z;
            this.f22874d = i;
            this.f22873c = i2;
            this.f22875e = i3;
            this.f22872b = z2;
        }
    }

    public final Runnable m25414a(Object obj, Object obj2, final View view) {
        final AnimationData animationData = (AnimationData) obj2;
        return new Runnable(this) {
            final /* synthetic */ BlingBarAnimationBuilder f22860c;

            public void run() {
                this.f22860c.f22878c.m25421c(view);
                this.f22860c.f22878c.m25418a(view, animationData.f22872b, animationData.f22874d, animationData.f22873c, animationData.f22875e);
            }
        };
    }

    public final void m25415a(List list, Object obj, Object obj2, View view) {
        AnimationData animationData = (AnimationData) obj;
        AnimationData animationData2 = (AnimationData) obj2;
        Object obj3 = 1;
        Object obj4 = (animationData.f22874d == animationData2.f22874d && animationData.f22872b == animationData2.f22872b) ? 1 : null;
        Object obj5;
        if (animationData2.f22871a == animationData.f22871a) {
            obj5 = 1;
        } else {
            obj5 = null;
        }
        if (animationData2.f22874d >= animationData.f22874d || animationData2.f22874d <= 0) {
            obj3 = null;
        }
        if (obj4 == null && r1 == null && r3 == null) {
            if (animationData2.f22874d == 0 && animationData.f22874d != 0) {
                m25412b(list, animationData, animationData2, view);
            }
            if (animationData2.f22872b != animationData.f22872b) {
                m25410a(list, animationData2, view);
            }
            if (animationData2.f22874d >= animationData.f22874d) {
                m25413c(list, animationData, animationData2, view);
            }
        }
    }

    public BlingBarAnimationBuilder(DefaultAnimationPartFactory defaultAnimationPartFactory, ViewBlingBarAnimationBuilderCallbacks viewBlingBarAnimationBuilderCallbacks, ExperimentalBlingBarStyler experimentalBlingBarStyler) {
        this.f22876a = defaultAnimationPartFactory;
        this.f22878c = viewBlingBarAnimationBuilderCallbacks;
        this.f22877b = experimentalBlingBarStyler;
    }

    private void m25412b(List<PersistentAnimation> list, final AnimationData animationData, final AnimationData animationData2, final V v) {
        list.add(this.f22876a.a(this.f22878c.m25417a(v), 170, 1.0f, 0.0f, new BaseAnimatorListener(this) {
            final /* synthetic */ BlingBarAnimationBuilder f22864d;

            public void onAnimationStart(Animator animator) {
                this.f22864d.f22878c.m25418a(v, animationData.f22872b, animationData.f22874d, animationData.f22873c, animationData.f22875e);
            }

            public void onAnimationEnd(Animator animator) {
                this.f22864d.f22878c.m25418a(v, animationData2.f22872b, animationData2.f22874d, animationData2.f22873c, animationData2.f22875e);
                this.f22864d.f22878c.m25421c(v);
            }
        }));
    }

    private void m25410a(List<PersistentAnimation> list, final AnimationData animationData, final V v) {
        int i;
        View b = this.f22878c.m25419b(v);
        b.setVisibility(0);
        int i2 = this.f22877b.f22903b;
        int i3 = this.f22877b.f22902a;
        int i4 = animationData.f22872b ? i2 : i3;
        if (animationData.f22872b) {
            i = i3;
        } else {
            i = i2;
        }
        list.add(this.f22876a.a(b, 200, i4, i, new BaseAnimatorListener(this) {
            final /* synthetic */ BlingBarAnimationBuilder f22867c;

            public void onAnimationStart(Animator animator) {
                this.f22867c.f22878c.m25420b(v, animationData.f22872b, animationData.f22874d, animationData.f22873c, animationData.f22875e);
            }

            public void onAnimationEnd(Animator animator) {
                this.f22867c.f22878c.m25418a(v, animationData.f22872b, animationData.f22874d, animationData.f22873c, animationData.f22875e);
            }
        }));
    }

    private void m25413c(List<PersistentAnimation> list, AnimationData animationData, final AnimationData animationData2, final V v) {
        C19824 c19824 = new BaseAnimatorListener(this) {
            final /* synthetic */ BlingBarAnimationBuilder f22870c;

            public void onAnimationStart(Animator animator) {
                this.f22870c.f22878c.m25418a(v, animationData2.f22872b, animationData2.f22874d, animationData2.f22873c, animationData2.f22875e);
            }
        };
        if (animationData.f22874d > 0) {
            list.add(this.f22876a.a(170, c19824));
        }
        list.add(this.f22876a.a(this.f22878c.m25417a(v), 42, 1.0f, 1.1f, c19824));
        list.add(this.f22876a.a(this.f22878c.m25417a(v), 42, 1.1f, 1.0f, c19824));
    }

    public static int m25409a(@Nullable GraphQLFeedback graphQLFeedback) {
        return graphQLFeedback != null ? GraphQLHelper.f(graphQLFeedback) : 0;
    }

    public static int m25411b(@Nullable GraphQLFeedback graphQLFeedback) {
        return graphQLFeedback != null ? GraphQLHelper.p(graphQLFeedback) : 0;
    }
}

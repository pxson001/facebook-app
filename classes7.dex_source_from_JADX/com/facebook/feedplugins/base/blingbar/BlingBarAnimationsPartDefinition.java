package com.facebook.feedplugins.base.blingbar;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.animations.AnimationsPartDefinition;
import com.facebook.feed.rows.animations.AnimationsPartDefinition$Props;
import com.facebook.feedback.ui.BlingBar;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationBuilder.AnimationData;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.animations.persistent.parts.AnimationPartFactory;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TDataProvider;) */
public class BlingBarAnimationsPartDefinition<V extends View & BlingBar> extends BaseSinglePartDefinition<Props, Void, HasPersistentState, V> {
    private static BlingBarAnimationsPartDefinition f22884e;
    private static final Object f22885f = new Object();
    private final AnimationsPartDefinition f22886a;
    public final Lazy<ExperimentalBlingBarStyler> f22887b;
    private final Lazy<AnimationPartFactory> f22888c;
    private final QeAccessor f22889d;

    /* compiled from: TDataProvider;) */
    public class Props {
        CacheableEntity f22879a;
        @Nullable
        GraphQLFeedback f22880b;
        String f22881c;
        boolean f22882d;

        public Props(CacheableEntity cacheableEntity, @Nullable GraphQLFeedback graphQLFeedback, String str, boolean z) {
            this.f22879a = cacheableEntity;
            this.f22880b = graphQLFeedback;
            this.f22881c = str;
            this.f22882d = z;
        }
    }

    /* compiled from: TDataProvider;) */
    public class ViewBlingBarAnimationBuilderCallbacks<V extends View & BlingBar> {
        final /* synthetic */ BlingBarAnimationsPartDefinition f22883a;

        public ViewBlingBarAnimationBuilderCallbacks(BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition) {
            this.f22883a = blingBarAnimationsPartDefinition;
        }

        public final Object m25417a(View view) {
            return ((BlingBar) view).getLikersCountView();
        }

        public final View m25419b(V v) {
            return ((BlingBar) v).getContainerView();
        }

        public final void m25420b(V v, boolean z, int i, int i2, int i3) {
            m25418a(v, z, i, i2, i3);
        }

        public final void m25418a(V v, boolean z, int i, int i2, int i3) {
            ((BlingBar) v).setIsExpanded(z);
            m25416a(v, z);
            if (z) {
                ((BlingBar) v).setLikes(i);
                ((BlingBar) v).setComments(i2);
                ((BlingBar) v).setShares(i3);
                return;
            }
            ((BlingBar) v).setLikes(0);
            ((BlingBar) v).setComments(0);
            ((BlingBar) v).setShares(0);
        }

        public final void m25421c(V v) {
            View likersCountView = ((BlingBar) v).getLikersCountView();
            likersCountView.setScaleX(1.0f);
            likersCountView.setScaleY(1.0f);
        }

        private void m25416a(V v, boolean z) {
            int i;
            if (z) {
                i = -2;
            } else {
                i = ((ExperimentalBlingBarStyler) this.f22883a.f22887b.get()).f22903b;
            }
            ((BlingBar) v).setHeight(i);
        }
    }

    private static BlingBarAnimationsPartDefinition m25424b(InjectorLike injectorLike) {
        return new BlingBarAnimationsPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 3544), IdBasedSingletonScopeProvider.b(injectorLike, 6198), AnimationsPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m25425a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f22886a, new AnimationsPartDefinition$Props(new AnimationData(props.f22880b, props.f22882d), BlingBarAnimationsPartDefinition.class.getSimpleName() + props.f22881c, props.f22879a, new BlingBarAnimationBuilder((DefaultAnimationPartFactory) this.f22888c.get(), new ViewBlingBarAnimationBuilderCallbacks(this), (ExperimentalBlingBarStyler) this.f22887b.get()), null));
        return null;
    }

    public static BlingBarAnimationsPartDefinition m25422a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarAnimationsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22885f) {
                BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition;
                if (a2 != null) {
                    blingBarAnimationsPartDefinition = (BlingBarAnimationsPartDefinition) a2.a(f22885f);
                } else {
                    blingBarAnimationsPartDefinition = f22884e;
                }
                if (blingBarAnimationsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22885f, b3);
                        } else {
                            f22884e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarAnimationsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BlingBarAnimationsPartDefinition(Lazy<AnimationPartFactory> lazy, Lazy<ExperimentalBlingBarStyler> lazy2, AnimationsPartDefinition animationsPartDefinition, QeAccessor qeAccessor) {
        this.f22888c = lazy;
        this.f22886a = animationsPartDefinition;
        this.f22887b = lazy2;
        this.f22889d = qeAccessor;
    }

    public static boolean m25423a(GraphQLStory graphQLStory) {
        return graphQLStory.aa_() > 0 || graphQLStory.n() > 0;
    }
}

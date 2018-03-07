package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reviews.composer.config.ReviewComposerPluginConfig;
import com.facebook.widget.ratingbar.BetterRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_styles */
public class ReactionRatingBarPartDefinition<E extends CanLaunchReactionIntent> extends BaseSinglePartDefinition<Prop, RatingChangedListener, E, BetterRatingBar> {
    private static ReactionRatingBarPartDefinition f20024b;
    private static final Object f20025c = new Object();
    public final ReactionIntentFactory f20026a;

    /* compiled from: action_styles */
    public class Prop {
        public final String f20020a;
        public final String f20021b;
        public final String f20022c;
        public final String f20023d;

        public Prop(String str, String str2, String str3, String str4) {
            this.f20020a = str;
            this.f20021b = str2;
            this.f20022c = str3;
            this.f20023d = str4;
        }
    }

    private static ReactionRatingBarPartDefinition m23910b(InjectorLike injectorLike) {
        return new ReactionRatingBarPartDefinition(ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23911a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Prop prop = (Prop) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        return new RatingChangedListener(this) {
            final /* synthetic */ ReactionRatingBarPartDefinition f20019c;

            public final void m23908a(int i, int i2) {
            }

            public final void m23907a(int i) {
                ReactionIntentFactory reactionIntentFactory = this.f20019c.f20026a;
                String str = prop.f20022c;
                String str2 = prop.f20020a;
                String str3 = prop.f20021b;
                canLaunchReactionIntent.mo695a(prop.f20022c, prop.f20023d, new ReactionAttachmentIntent(str2, UnitInteractionType.WRITE_REVIEW_TAP, new Intent().putExtra("composer_configuration", ComposerConfigurationFactory.a(ComposerSourceType.REACTION, false, Long.parseLong(str2), str3, CurationMechanism.REVIEW_BUTTON, CurationSurface.AFTER_PARTY).setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.m4870c())).setInitialRating(i).setReactionSurface(Surface.ANDROID_AFTER_PARTY_COMPOSER).setReactionUnitId(str).a())));
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m23912a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 830268248);
        ((BetterRatingBar) view).a((RatingChangedListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 1781509873, a);
    }

    public final void m23913b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterRatingBar) view).a();
    }

    @Inject
    public ReactionRatingBarPartDefinition(ReactionIntentFactory reactionIntentFactory) {
        this.f20026a = reactionIntentFactory;
    }

    public static ReactionRatingBarPartDefinition m23909a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionRatingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20025c) {
                ReactionRatingBarPartDefinition reactionRatingBarPartDefinition;
                if (a2 != null) {
                    reactionRatingBarPartDefinition = (ReactionRatingBarPartDefinition) a2.a(f20025c);
                } else {
                    reactionRatingBarPartDefinition = f20024b;
                }
                if (reactionRatingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23910b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20025c, b3);
                        } else {
                            f20024b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionRatingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

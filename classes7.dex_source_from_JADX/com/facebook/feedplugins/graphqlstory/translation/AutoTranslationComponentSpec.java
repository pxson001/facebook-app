package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.SolidColor;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.translation.TranslationMenuHelper;
import com.facebook.translation.TranslationMenuHelper.SeeOriginalListener;
import com.facebook.translation.TranslationPreferencesModifier;
import com.facebook.translation.TranslationRatingLogger;
import com.facebook.translation.TranslationRatingView.RatingListener;
import com.facebook.ufiservices.util.MessageSpannableBuilder;
import javax.inject.Inject;
import javax.inject.Provider;

@LayoutSpec
@ContextScoped
/* compiled from: Saving something that isn't a Story or SavedCollectionFeedUnit. Item was not saved. */
public class AutoTranslationComponentSpec<E extends HasPersistentState & HasInvalidate> {
    private static AutoTranslationComponentSpec f23435g;
    private static final Object f23436h = new Object();
    private final boolean f23437a;
    private final TranslationFormatUtil f23438b;
    private final TranslationPreferencesModifier f23439c;
    public final TranslationRatingLogger f23440d;
    private final FbUriIntentHandler f23441e;
    private final MessageSpannableBuilder f23442f;

    /* compiled from: Saving something that isn't a Story or SavedCollectionFeedUnit. Item was not saved. */
    class PersistentStateKey implements ContextStateKey<String, Boolean> {
        private final GraphQLStory f23434a;

        PersistentStateKey(GraphQLStory graphQLStory) {
            this.f23434a = graphQLStory;
        }

        public final Object m25734a() {
            return Boolean.valueOf(false);
        }

        public final Object m25735b() {
            return this.f23434a.c();
        }
    }

    private static AutoTranslationComponentSpec m25739b(InjectorLike injectorLike) {
        return new AutoTranslationComponentSpec(IdBasedProvider.a(injectorLike, 3977), TranslationFormatUtil.a(injectorLike), TranslationPreferencesModifier.b(injectorLike), TranslationRatingLogger.a(injectorLike), MessageSpannableBuilder.a(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    public static AutoTranslationComponentSpec m25736a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoTranslationComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23436h) {
                AutoTranslationComponentSpec autoTranslationComponentSpec;
                if (a2 != null) {
                    autoTranslationComponentSpec = (AutoTranslationComponentSpec) a2.a(f23436h);
                } else {
                    autoTranslationComponentSpec = f23435g;
                }
                if (autoTranslationComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25739b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23436h, b3);
                        } else {
                            f23435g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = autoTranslationComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AutoTranslationComponentSpec(Provider<Boolean> provider, TranslationFormatUtil translationFormatUtil, TranslationPreferencesModifier translationPreferencesModifier, TranslationRatingLogger translationRatingLogger, MessageSpannableBuilder messageSpannableBuilder, FbUriIntentHandler fbUriIntentHandler) {
        this.f23437a = ((Boolean) provider.get()).booleanValue();
        this.f23438b = translationFormatUtil;
        this.f23439c = translationPreferencesModifier;
        this.f23440d = translationRatingLogger;
        this.f23442f = messageSpannableBuilder;
        this.f23441e = fbUriIntentHandler;
    }

    protected final ComponentLayout m25740a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, Output<TranslationMenuHelper> output) {
        InternalNode j;
        PersistentStateKey persistentStateKey = new PersistentStateKey((GraphQLStory) feedProps.a());
        boolean booleanValue = ((Boolean) e.a(persistentStateKey, (CacheableEntity) feedProps.a())).booleanValue();
        output.a = m25737a(componentContext, persistentStateKey, booleanValue, e, feedProps);
        CharSequence a = this.f23442f.a(feedProps);
        CharSequence a2 = m25738a(this, (GraphQLStory) feedProps.a());
        CharSequence a3 = this.f23438b.a((GraphQLStory) feedProps.a());
        if (booleanValue) {
            j = Text.a(componentContext).a(a).o(2131427402).c(1.5f).a(false).l(2131362048).s(2131362049).c().a(1.0f).d(4, 3).c(7, 2131428854).h(3, 2).r(2130840335).j();
        } else {
            j = null;
        }
        InternalNode j2 = Container.a(componentContext).C(2).a(SolidColor.m1358a(componentContext).m1357h(2131361858).c().m(1).d(7, 6).a(4)).a(Text.a(componentContext).a(a2).o(2131427402).c(1.5f).a(false).l(2131362048).s(2131362049).c().a(1.0f).d(4, 3).d(6, 6).c(7, 2131428854).h(3, 2).r(2130840335)).j();
        return Container.a(componentContext).C(0).a(j).a(j2).a(Container.a(componentContext).C(2).a(SolidColor.m1358a(componentContext).m1357h(2131361858).c().m(1).d(7, 6).a(4)).a(Text.a(componentContext).a(a3).o(2131427402).c(1.5f).a(false).l(2131362716).s(2131362049).c().a(1.0f).d(4, 3).d(6, 6).r(2130840335).a(AutoTranslationComponent.m25728b(componentContext))).j()).j();
    }

    private TranslationMenuHelper m25737a(Context context, final PersistentStateKey persistentStateKey, boolean z, final E e, final FeedProps<GraphQLStory> feedProps) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        TranslationMenuHelper translationMenuHelper = new TranslationMenuHelper(graphQLStory.aL(), context, this.f23439c, Boolean.valueOf(this.f23437a), this.f23441e);
        translationMenuHelper.a(!z);
        translationMenuHelper.f = new SeeOriginalListener(this) {
            final /* synthetic */ AutoTranslationComponentSpec f23431d;

            public final void m25732a(boolean z) {
                e.a(persistentStateKey, Boolean.valueOf(z));
                ((HasInvalidate) e).a(new FeedProps[]{feedProps});
            }
        };
        translationMenuHelper.b.e = new RatingListener(this) {
            final /* synthetic */ AutoTranslationComponentSpec f23433b;

            public final void m25733a(int i) {
                this.f23433b.f23440d.a(graphQLStory, i, AutoTranslationComponentSpec.m25738a(this.f23433b, graphQLStory));
            }
        };
        return translationMenuHelper;
    }

    public static String m25738a(AutoTranslationComponentSpec autoTranslationComponentSpec, GraphQLStory graphQLStory) {
        return autoTranslationComponentSpec.f23438b.a(graphQLStory.aL().a()).toString();
    }
}

package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.support.annotation.ColorRes;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.LazyResources;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Progress;
import com.facebook.components.widget.SolidColor;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.translation.TranslationPreferencesModifier;
import com.facebook.translation.TranslationRatingLogger;
import javax.inject.Inject;
import javax.inject.Provider;

@LayoutSpec
@ContextScoped
/* compiled from: org.w3c.dom.Node */
public class SeeTranslationComponentSpec<E extends HasPositionInformation & HasInvalidate & HasPersistentState> {
    private static SeeTranslationComponentSpec f5936l;
    private static final Object f5937m = new Object();
    private final boolean f5938a;
    public final TranslationDataLoader f5939b;
    public final TranslationRatingLogger f5940c;
    public final TranslationPreferencesModifier f5941d;
    private final TranslationFormatUtil f5942e;
    public final FbUriIntentHandler f5943f;
    public final Context f5944g;
    private final Lazy<String> f5945h = LazyResources.a(this.f5944g, 2131233616);
    private final Lazy<String> f5946i = LazyResources.a(this.f5944g, 2131233617);
    private final Lazy<Float> f5947j = LazyResources.a(this.f5944g.getResources(), 2131427402);
    private final Lazy<Float> f5948k = LazyResources.a(this.f5944g.getResources(), 2131428862);

    private static SeeTranslationComponentSpec m6406b(InjectorLike injectorLike) {
        return new SeeTranslationComponentSpec(IdBasedProvider.a(injectorLike, 3992), TranslationDataLoader.b(injectorLike), TranslationRatingLogger.a(injectorLike), TranslationPreferencesModifier.b(injectorLike), TranslationFormatUtil.a(injectorLike), FbUriIntentHandler.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public static SeeTranslationComponentSpec m6405a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeTranslationComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5937m) {
                SeeTranslationComponentSpec seeTranslationComponentSpec;
                if (a2 != null) {
                    seeTranslationComponentSpec = (SeeTranslationComponentSpec) a2.a(f5937m);
                } else {
                    seeTranslationComponentSpec = f5936l;
                }
                if (seeTranslationComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6406b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5937m, b3);
                        } else {
                            f5936l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seeTranslationComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SeeTranslationComponentSpec(Provider<Boolean> provider, TranslationDataLoader translationDataLoader, TranslationRatingLogger translationRatingLogger, TranslationPreferencesModifier translationPreferencesModifier, TranslationFormatUtil translationFormatUtil, FbUriIntentHandler fbUriIntentHandler, Context context) {
        this.f5938a = ((Boolean) provider.get()).booleanValue();
        this.f5939b = translationDataLoader;
        this.f5940c = translationRatingLogger;
        this.f5941d = translationPreferencesModifier;
        this.f5942e = translationFormatUtil;
        this.f5943f = fbUriIntentHandler;
        this.f5944g = context;
    }

    protected final ComponentLayout m6407a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, Output<TranslatedTextPersistentState> output) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        TranslatedTextPersistentState translatedTextPersistentState = (TranslatedTextPersistentState) ((HasPersistentState) e).a(new TranslatedTextKey(graphQLStory), graphQLStory);
        output.a = translatedTextPersistentState;
        DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = translatedTextPersistentState.f13711a;
        if (translatedTextPersistentState.f13711a != null) {
            boolean z;
            CharSequence a = SeeTranslationPartDefinition.a(this.f5942e, defaultTextWithEntitiesLongFieldsModel);
            CharSequence a2 = this.f5942e.a(graphQLStory);
            Object obj = (!this.f5938a || SeeTranslationPartDefinition.a(graphQLStory)) ? 1 : null;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            return m6404a(componentContext, a, a2, z);
        }
        return Container.a(componentContext).C(2).a(m6402a(componentContext, TranslationView.m14459a(SeeTranslationSelectorPartDefinition.a(graphQLStory), this.f5944g, (String) this.f5946i.get(), (String) this.f5945h.get()), 2131361858).a(ComponentLifecycle.a(componentContext, 154277921, null))).a(translatedTextPersistentState.f13712b ? Progress.a(componentContext).c().j(((Float) this.f5947j.get()).intValue()).n(((Float) this.f5947j.get()).intValue()).a(2) : null).j(2, 2131428854).j(7, 2131428854).j();
    }

    private InternalNode m6404a(ComponentContext componentContext, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Builder a = m6403a(componentContext, charSequence2, 2131362716, ((Float) this.f5948k.get()).intValue());
        if (z) {
            a.a(ComponentLifecycle.a(componentContext, 1729416567, null));
        }
        return Container.a(componentContext).E(1).C(2).a(SolidColor.a(componentContext).h(2131361858).c().m(1).d(7, 6).a(4)).a(Container.a(componentContext).E(1).C(0).o(3, 2).b(1.0f).a(m6401a(componentContext, charSequence)).a(a)).j();
    }

    private Builder m6401a(ComponentContext componentContext, CharSequence charSequence) {
        return m6402a(componentContext, charSequence, 2131362048);
    }

    private Builder m6402a(ComponentContext componentContext, CharSequence charSequence, int i) {
        return m6403a(componentContext, charSequence, i, ((Float) this.f5947j.get()).intValue());
    }

    private static Builder m6403a(ComponentContext componentContext, CharSequence charSequence, @ColorRes int i, int i2) {
        return Text.a(componentContext).a(charSequence).n(i2).c(1.5f).a(false).l(i).s(2131362049).c().d(4, 3).d(6, 6).c(7, 2131428854);
    }
}

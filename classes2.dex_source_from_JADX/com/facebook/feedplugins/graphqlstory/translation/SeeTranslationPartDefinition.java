package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.translation.TranslationPreferencesModifier;
import com.facebook.translation.TranslationRatingLogger;
import com.facebook.translation.TranslationRatingView;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fetchAndSubscribe() requires disk caching to work */
public class SeeTranslationPartDefinition<E extends HasPositionInformation & HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, TranslatedTextPersistentState, E, TranslationView> {
    public static final ViewType f24353a = new C09871();
    private static final PaddingStyle f24354b = PaddingStyle.f13075e;
    private static SeeTranslationPartDefinition f24355j;
    private static final Object f24356k = new Object();
    private final BackgroundPartDefinition f24357c;
    private final ClickListenerPartDefinition f24358d;
    public final boolean f24359e;
    public final TranslationDataLoader f24360f;
    public final TranslationRatingLogger f24361g;
    public final TranslationPreferencesModifier f24362h;
    public final TranslationFormatUtil f24363i;

    /* compiled from: fetchAndSubscribe() requires disk caching to work */
    final class C09871 extends ViewType {
        C09871() {
        }

        public final View mo1995a(Context context) {
            return new TranslationView(context);
        }
    }

    private static SeeTranslationPartDefinition m32671b(InjectorLike injectorLike) {
        return new SeeTranslationPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3992), TranslationDataLoader.m32678b(injectorLike), TranslationRatingLogger.m32680a(injectorLike), TranslationPreferencesModifier.m32683b(injectorLike), TranslationFormatUtil.m32684a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.f13444a;
        TranslatedTextPersistentState translatedTextPersistentState = (TranslatedTextPersistentState) ((HasPersistentState) hasPositionInformation).mo2425a(new TranslatedTextKey(cacheableEntity), cacheableEntity);
        translatedTextPersistentState.b = false;
        subParts.mo2756a(this.f24357c, new StylingData(feedProps, f24354b));
        subParts.mo2756a(this.f24358d, new 2(this, translatedTextPersistentState, hasPositionInformation, feedProps));
        return translatedTextPersistentState;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -731290874);
        m32669a((FeedProps) obj, (TranslatedTextPersistentState) obj2, (TranslationView) view);
        Logger.a(8, EntryType.MARK_POP, -1981722469, a);
    }

    public final boolean m32675a(Object obj) {
        return SeeTranslationSelectorPartDefinition.m28707a((FeedProps) obj);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TranslationView translationView = (TranslationView) view;
        translationView.setOnClickListener(null);
        View findViewById = translationView.findViewById(2131559756);
        if (findViewById != null) {
            findViewById.setOnClickListener(null);
        }
    }

    public static SeeTranslationPartDefinition m32668a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeTranslationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24356k) {
                SeeTranslationPartDefinition seeTranslationPartDefinition;
                if (a2 != null) {
                    seeTranslationPartDefinition = (SeeTranslationPartDefinition) a2.mo818a(f24356k);
                } else {
                    seeTranslationPartDefinition = f24355j;
                }
                if (seeTranslationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32671b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24356k, b3);
                        } else {
                            f24355j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = seeTranslationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SeeTranslationPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Provider<Boolean> provider, TranslationDataLoader translationDataLoader, TranslationRatingLogger translationRatingLogger, TranslationPreferencesModifier translationPreferencesModifier, TranslationFormatUtil translationFormatUtil) {
        this.f24357c = backgroundPartDefinition;
        this.f24358d = clickListenerPartDefinition;
        this.f24359e = ((Boolean) provider.get()).booleanValue();
        this.f24360f = translationDataLoader;
        this.f24361g = translationRatingLogger;
        this.f24362h = translationPreferencesModifier;
        this.f24363i = translationFormatUtil;
    }

    public final ViewType mo2547a() {
        return f24353a;
    }

    private void m32669a(FeedProps<GraphQLStory> feedProps, TranslatedTextPersistentState translatedTextPersistentState, TranslationView translationView) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (translatedTextPersistentState.a != null) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = translatedTextPersistentState.a;
            CharSequence a = m32667a(this.f24363i, defaultTextWithEntitiesLongFieldsModel);
            translationView.setOnClickListener(null);
            CharSequence a2 = this.f24363i.m32687a(graphQLStory);
            if (!this.f24359e || m32670a(graphQLStory)) {
                translationView.a(a, a2);
                translationView.setMenuButtonActive(true);
                return;
            }
            translationView.a(a, graphQLStory.aL(), this.f24362h, a2);
            TranslationRatingView translationRatingView = translationView.i;
            String a3 = defaultTextWithEntitiesLongFieldsModel.a();
            if (translationRatingView != null) {
                translationRatingView.e = new 3(this, graphQLStory, a3);
            }
            translationView.setMenuButtonActive(true);
            return;
        }
        translationView.a(SeeTranslationSelectorPartDefinition.m28706a(graphQLStory));
    }

    public static boolean m32670a(GraphQLStory graphQLStory) {
        if (graphQLStory.aL() != null && graphQLStory.aL().m24912o() == GraphQLTranslatabilityType.SEE_CONVERSION) {
            return true;
        }
        return false;
    }

    public static SpannableStringBuilder m32667a(TranslationFormatUtil translationFormatUtil, DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        return translationFormatUtil.m32686a(DefaultGraphQLConversionHelper.a(defaultTextWithEntitiesLongFieldsModel));
    }
}

package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.translation.TranslationMenuHelper;
import com.facebook.translation.TranslationMenuHelper.SeeOriginalListener;
import com.facebook.translation.TranslationPreferencesModifier;
import com.facebook.translation.TranslationRatingLogger;
import com.facebook.translation.TranslationRatingView;
import com.facebook.translation.TranslationRatingView.RatingListener;
import com.facebook.ufiservices.util.MessageSpannableBuilder;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: SavingTextPhoto_ */
public class AutoTranslatePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, AutoTranslationView> {
    public static final ViewType f23399a = new C20221();
    private static final PaddingStyle f23400c = PaddingStyle.e;
    private static AutoTranslatePartDefinition f23401l;
    private static final Object f23402m = new Object();
    private final FbUriIntentHandler f23403b;
    private final BackgroundPartDefinition f23404d;
    private final boolean f23405e;
    public final boolean f23406f;
    private final TranslationFormatUtil f23407g;
    private final Context f23408h;
    public final TranslationRatingLogger f23409i;
    private final TranslationPreferencesModifier f23410j;
    private final MessageSpannableBuilder f23411k;

    /* compiled from: SavingTextPhoto_ */
    final class C20221 extends ViewType {
        C20221() {
        }

        public final View m25711a(Context context) {
            return new AutoTranslationView(context);
        }
    }

    /* compiled from: SavingTextPhoto_ */
    public class State {
        public final String f23387a;
        public final String f23388b;
        public final Spannable f23389c;
        public final TranslationMenuHelper f23390d;
        public final OnClickListener f23391e;
        public final TranslationSeeOriginalListener f23392f;
        public final TranslationRatingListener f23393g;

        public State(String str, String str2, Spannable spannable, TranslationMenuHelper translationMenuHelper, OnClickListener onClickListener, TranslationSeeOriginalListener translationSeeOriginalListener, TranslationRatingListener translationRatingListener) {
            this.f23387a = str;
            this.f23388b = str2;
            this.f23389c = spannable;
            this.f23390d = translationMenuHelper;
            this.f23391e = onClickListener;
            this.f23392f = translationSeeOriginalListener;
            this.f23393g = translationRatingListener;
        }
    }

    /* compiled from: SavingTextPhoto_ */
    public class TranslationRatingListener implements RatingListener {
        final /* synthetic */ AutoTranslatePartDefinition f23394a;
        public String f23395b;
        public GraphQLStory f23396c;

        public TranslationRatingListener(AutoTranslatePartDefinition autoTranslatePartDefinition) {
            this.f23394a = autoTranslatePartDefinition;
        }

        public final void m25712a(int i) {
            this.f23394a.f23409i.a(this.f23396c, i, this.f23395b);
        }
    }

    /* compiled from: SavingTextPhoto_ */
    public class TranslationSeeOriginalListener implements SeeOriginalListener {
        public AutoTranslationView f23397a;
        public Spannable f23398b;

        public final void m25713a(boolean z) {
            if (z) {
                AutoTranslationView autoTranslationView = this.f23397a;
                CharSequence charSequence = this.f23398b;
                if (autoTranslationView.f23446d == null) {
                    autoTranslationView.f23446d = autoTranslationView.f23445c.inflate();
                    autoTranslationView.f23447e = (ContentTextView) autoTranslationView.a(2131565275);
                } else {
                    autoTranslationView.f23446d.setVisibility(0);
                }
                autoTranslationView.f23447e.setText(charSequence);
                autoTranslationView.f23447e.setVisibility(0);
                return;
            }
            this.f23397a.m25741a();
        }
    }

    private static AutoTranslatePartDefinition m25716b(InjectorLike injectorLike) {
        return new AutoTranslatePartDefinition(BackgroundPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 3977), IdBasedProvider.a(injectorLike, 3992), TranslationFormatUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), TranslationPreferencesModifier.b(injectorLike), TranslationRatingLogger.a(injectorLike), MessageSpannableBuilder.a(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m25718a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m25714a(subParts, (FeedProps) obj);
    }

    public final /* bridge */ /* synthetic */ void m25719a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1736704768);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        AutoTranslationView autoTranslationView = (AutoTranslationView) view;
        autoTranslationView.setMenuButtonActive(true);
        CharSequence charSequence = state.f23387a;
        CharSequence charSequence2 = state.f23388b;
        autoTranslationView.f23443a.setText(charSequence);
        autoTranslationView.f23444b.setText(charSequence2);
        autoTranslationView.f23443a.setVisibility(0);
        autoTranslationView.m25741a();
        if (this.f23406f) {
            TranslationMenuHelper translationMenuHelper = state.f23390d;
            autoTranslationView.f23444b.setOnClickListener(state.f23391e);
            state.f23392f.f23397a = autoTranslationView;
            state.f23392f.f23398b = state.f23389c;
            translationMenuHelper.f = state.f23392f;
            TranslationRatingListener translationRatingListener = state.f23393g;
            TranslationRatingView translationRatingView = translationMenuHelper.b;
            String str = state.f23387a;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (translationRatingView != null) {
                translationRatingListener.f23395b = str;
                translationRatingListener.f23396c = graphQLStory;
                translationRatingView.e = translationRatingListener;
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1297758458, a);
    }

    public final void m25721b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ((AutoTranslationView) view).setMenuButtonActive(false);
        state.f23392f.f23397a = null;
        state.f23390d.f = null;
        state.f23390d.b.e = null;
    }

    public static AutoTranslatePartDefinition m25715a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoTranslatePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23402m) {
                AutoTranslatePartDefinition autoTranslatePartDefinition;
                if (a2 != null) {
                    autoTranslatePartDefinition = (AutoTranslatePartDefinition) a2.a(f23402m);
                } else {
                    autoTranslatePartDefinition = f23401l;
                }
                if (autoTranslatePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25716b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23402m, b3);
                        } else {
                            f23401l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = autoTranslatePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AutoTranslatePartDefinition(BackgroundPartDefinition backgroundPartDefinition, Provider<Boolean> provider, Provider<Boolean> provider2, TranslationFormatUtil translationFormatUtil, Context context, TranslationPreferencesModifier translationPreferencesModifier, TranslationRatingLogger translationRatingLogger, MessageSpannableBuilder messageSpannableBuilder, FbUriIntentHandler fbUriIntentHandler) {
        this.f23404d = backgroundPartDefinition;
        this.f23405e = ((Boolean) provider.get()).booleanValue();
        this.f23406f = ((Boolean) provider2.get()).booleanValue();
        this.f23407g = translationFormatUtil;
        this.f23408h = context;
        this.f23410j = translationPreferencesModifier;
        this.f23409i = translationRatingLogger;
        this.f23411k = messageSpannableBuilder;
        this.f23403b = fbUriIntentHandler;
    }

    public final ViewType m25717a() {
        return f23399a;
    }

    public final boolean m25720a(Object obj) {
        return true;
    }

    private State m25714a(SubParts<HasPositionInformation> subParts, FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        subParts.a(this.f23404d, new StylingData(feedProps, f23400c));
        SpannableStringBuilder a = this.f23407g.a(graphQLStory.aL().a());
        String a2 = this.f23407g.a(graphQLStory);
        Spannable a3 = this.f23411k.a(feedProps);
        final TranslationMenuHelper translationMenuHelper = new TranslationMenuHelper(graphQLStory.aL(), this.f23408h, this.f23410j, Boolean.valueOf(this.f23405e), this.f23403b);
        return new State(a.toString(), a2, a3, translationMenuHelper, new OnClickListener(this) {
            final /* synthetic */ AutoTranslatePartDefinition f23386b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 468740168);
                translationMenuHelper.a(view);
                Logger.a(2, EntryType.UI_INPUT_END, 311125088, a);
            }
        }, new TranslationSeeOriginalListener(), new TranslationRatingListener(this));
    }
}

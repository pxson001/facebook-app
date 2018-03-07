package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryPromotionStory;
import com.facebook.graphql.model.GraphQLUser;
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
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fb_simple_picker_fragment_conf */
public class ThrowbackFriendversaryCampaignFriendViewPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackFriendversaryPromotionStory>, State, HasPositionInformation, ContentViewWithButton> {
    public static final ViewType f13665a = ViewType.a(2130907408);
    public static final PaddingStyle f13666b;
    private static ThrowbackFriendversaryCampaignFriendViewPartDefinition f13667j;
    private static final Object f13668k = new Object();
    public final Provider<String> f13669c;
    public final FbUriIntentHandler f13670d;
    public final Resources f13671e;
    public final GlyphColorizer f13672f;
    private final ClickListenerPartDefinition f13673g;
    private final BackgroundPartDefinition f13674h;
    public final Provider<BottomSheetDialog> f13675i;

    /* compiled from: fb_simple_picker_fragment_conf */
    public class C14533 implements OnMenuItemClickListener {
        final /* synthetic */ GraphQLUser f13656a;
        final /* synthetic */ View f13657b;
        final /* synthetic */ ThrowbackFriendversaryCampaignFriendViewPartDefinition f13658c;

        public C14533(ThrowbackFriendversaryCampaignFriendViewPartDefinition throwbackFriendversaryCampaignFriendViewPartDefinition, GraphQLUser graphQLUser, View view) {
            this.f13658c = throwbackFriendversaryCampaignFriendViewPartDefinition;
            this.f13656a = graphQLUser;
            this.f13657b = view;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f13658c.f13670d.a(this.f13657b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.dh, this.f13658c.f13669c.get(), this.f13656a.P()));
            return true;
        }
    }

    /* compiled from: fb_simple_picker_fragment_conf */
    public class State {
        public final String f13659a;
        public final String f13660b;
        public final String f13661c;
        public final String f13662d;
        public final String f13663e;
        public final OnClickListener f13664f;

        public State(String str, String str2, String str3, String str4, String str5, OnClickListener onClickListener) {
            this.f13659a = str;
            this.f13660b = str2;
            this.f13663e = str5;
            this.f13661c = str3;
            this.f13662d = str4;
            this.f13664f = onClickListener;
        }
    }

    private static ThrowbackFriendversaryCampaignFriendViewPartDefinition m15373b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryCampaignFriendViewPartDefinition(IdBasedProvider.a(injectorLike, 4442), FbUriIntentHandler.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 11752));
    }

    public final Object m15375a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String b;
        String string;
        FeedProps feedProps = (FeedProps) obj;
        String str = null;
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a;
        final GraphQLUser l = graphQLGoodwillThrowbackFriendversaryPromotionStory.l().l();
        String ar = l.ar();
        String a = graphQLGoodwillThrowbackFriendversaryPromotionStory.k() != null ? graphQLGoodwillThrowbackFriendversaryPromotionStory.k().a() : null;
        if (l.aI() != null) {
            b = l.aI().b();
        } else {
            b = null;
        }
        if (l.ar() != null) {
            string = this.f13671e.getString(2131239660, new Object[]{l.ar()});
        } else {
            string = null;
        }
        if (!TextUtils.isEmpty(l.ar())) {
            str = this.f13671e.getString(2131239659);
        }
        OnClickListener c14511 = new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryCampaignFriendViewPartDefinition f13652b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1495258806);
                ThrowbackFriendversaryCampaignFriendViewPartDefinition throwbackFriendversaryCampaignFriendViewPartDefinition = this.f13652b;
                GraphQLUser graphQLUser = l;
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) throwbackFriendversaryCampaignFriendViewPartDefinition.f13675i.get();
                BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(bottomSheetDialog.getContext());
                bottomSheetAdapter.e(2131239680).setIcon(throwbackFriendversaryCampaignFriendViewPartDefinition.f13672f.a(2130839882, -8421505)).setOnMenuItemClickListener(new C14533(throwbackFriendversaryCampaignFriendViewPartDefinition, graphQLUser, view));
                bottomSheetDialog.a(bottomSheetAdapter);
                bottomSheetDialog.show();
                Logger.a(2, EntryType.UI_INPUT_END, -1457816578, a);
            }
        };
        subParts.a(this.f13673g, new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryCampaignFriendViewPartDefinition f13655c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1127108328);
                ThrowbackFriendversaryCampaignFriendViewPartDefinition throwbackFriendversaryCampaignFriendViewPartDefinition = this.f13655c;
                GraphQLUser graphQLUser = l;
                String str = b;
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, graphQLUser.P());
                Bundle bundle = new Bundle();
                ModelBundle.a(bundle, String.valueOf(graphQLUser.P()), str, graphQLUser.ar(), null, null);
                throwbackFriendversaryCampaignFriendViewPartDefinition.f13670d.a(view.getContext(), formatStrLocaleSafe, bundle);
                Logger.a(2, EntryType.UI_INPUT_END, -1787076979, a);
            }
        });
        subParts.a(this.f13674h, new StylingData(feedProps, f13666b));
        return new State(ar, a, string, str, b, c14511);
    }

    public final /* bridge */ /* synthetic */ void m15376a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1713837068);
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setTitleText(state.f13659a);
        contentViewWithButton.setThumbnailUri(state.f13663e);
        contentViewWithButton.setThumbnailSize(ThumbnailSize.LARGE);
        contentViewWithButton.setActionButtonDrawable(this.f13672f.a(2130839669, -5066062));
        contentViewWithButton.setActionButtonBackground(this.f13671e.getDrawable(2130839797));
        contentViewWithButton.setContentDescription(state.f13661c);
        contentViewWithButton.setActionButtonContentDescription(state.f13662d);
        contentViewWithButton.setSubtitleText(state.f13660b);
        contentViewWithButton.setSubtitleTextAppearance(2131626279);
        contentViewWithButton.setActionButtonOnClickListener(state.f13664f);
        Logger.a(8, EntryType.MARK_POP, -1943464345, a);
    }

    public final boolean m15377a(Object obj) {
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackFriendversaryPromotionStory.l() == null || graphQLGoodwillThrowbackFriendversaryPromotionStory.l().l() == null) ? false : true;
    }

    public final void m15378b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentViewWithButton) view).setActionButtonOnClickListener(null);
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        f13666b = a.i();
    }

    public static ThrowbackFriendversaryCampaignFriendViewPartDefinition m15372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryCampaignFriendViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13668k) {
                ThrowbackFriendversaryCampaignFriendViewPartDefinition throwbackFriendversaryCampaignFriendViewPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryCampaignFriendViewPartDefinition = (ThrowbackFriendversaryCampaignFriendViewPartDefinition) a2.a(f13668k);
                } else {
                    throwbackFriendversaryCampaignFriendViewPartDefinition = f13667j;
                }
                if (throwbackFriendversaryCampaignFriendViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15373b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13668k, b3);
                        } else {
                            f13667j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryCampaignFriendViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackFriendversaryCampaignFriendViewPartDefinition(Provider<String> provider, FbUriIntentHandler fbUriIntentHandler, Resources resources, GlyphColorizer glyphColorizer, ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition, Provider<BottomSheetDialog> provider2) {
        this.f13669c = provider;
        this.f13670d = fbUriIntentHandler;
        this.f13671e = resources;
        this.f13672f = glyphColorizer;
        this.f13673g = clickListenerPartDefinition;
        this.f13674h = backgroundPartDefinition;
        this.f13675i = provider2;
    }

    public final ViewType m15374a() {
        return f13665a;
    }
}

package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
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
/* compiled from: fe2e3d91eff42a9aeae8db5356114b39 */
public class ThrowbackFriendversaryAggregatedFriendListItemPartDefinition extends MultiRowSinglePartDefinition<ThrowbackFriendversaryAggregatedFriendListProps, Void, HasPositionInformation, SegmentedLinearLayout> {
    public static final ViewType f13616a = ViewType.a(2130907409);
    private static ThrowbackFriendversaryAggregatedFriendListItemPartDefinition f13617i;
    private static final Object f13618j = new Object();
    public final Provider<String> f13619b;
    public final FbUriIntentHandler f13620c;
    private final ClickListenerPartDefinition f13621d;
    private final BackgroundPartDefinition f13622e;
    private final ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition f13623f;
    public final GlyphColorizer f13624g;
    public final Provider<BottomSheetDialog> f13625h;

    /* compiled from: fe2e3d91eff42a9aeae8db5356114b39 */
    public class C14483 implements OnMenuItemClickListener {
        final /* synthetic */ GraphQLUser f13613a;
        final /* synthetic */ View f13614b;
        final /* synthetic */ ThrowbackFriendversaryAggregatedFriendListItemPartDefinition f13615c;

        public C14483(ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition, GraphQLUser graphQLUser, View view) {
            this.f13615c = throwbackFriendversaryAggregatedFriendListItemPartDefinition;
            this.f13613a = graphQLUser;
            this.f13614b = view;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f13615c.f13620c.a(this.f13614b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.dh, this.f13615c.f13619b.get(), this.f13613a.P()));
            return true;
        }
    }

    private static ThrowbackFriendversaryAggregatedFriendListItemPartDefinition m15350b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryAggregatedFriendListItemPartDefinition(IdBasedProvider.a(injectorLike, 4442), FbUriIntentHandler.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition.m15341a(injectorLike), GlyphColorizer.a(injectorLike), IdBasedProvider.a(injectorLike, 11752));
    }

    public final Object m15352a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        float f;
        ThrowbackFriendversaryAggregatedFriendListProps throwbackFriendversaryAggregatedFriendListProps = (ThrowbackFriendversaryAggregatedFriendListProps) obj;
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) throwbackFriendversaryAggregatedFriendListProps.m15356c();
        final GraphQLUser graphQLUser = throwbackFriendversaryAggregatedFriendListProps.f13627b;
        final String b = graphQLUser.aI() != null ? graphQLUser.aI().b() : null;
        C14461 c14461 = new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryAggregatedFriendListItemPartDefinition f13609b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1821576215);
                ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition = this.f13609b;
                GraphQLUser graphQLUser = graphQLUser;
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) throwbackFriendversaryAggregatedFriendListItemPartDefinition.f13625h.get();
                BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(bottomSheetDialog.getContext());
                bottomSheetAdapter.e(2131239680).setIcon(throwbackFriendversaryAggregatedFriendListItemPartDefinition.f13624g.a(2130839882, -8421505)).setOnMenuItemClickListener(new C14483(throwbackFriendversaryAggregatedFriendListItemPartDefinition, graphQLUser, view));
                bottomSheetDialog.a(bottomSheetAdapter);
                bottomSheetDialog.show();
                Logger.a(2, EntryType.UI_INPUT_END, -756243675, a);
            }
        };
        C14472 c14472 = new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryAggregatedFriendListItemPartDefinition f13612c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1135861354);
                ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition = this.f13612c;
                GraphQLUser graphQLUser = graphQLUser;
                String str = b;
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, graphQLUser.P());
                Bundle bundle = new Bundle();
                ModelBundle.a(bundle, String.valueOf(graphQLUser.P()), str, graphQLUser.ar(), null, null);
                throwbackFriendversaryAggregatedFriendListItemPartDefinition.f13620c.a(view.getContext(), formatStrLocaleSafe, bundle);
                Logger.a(2, EntryType.UI_INPUT_END, 253024962, a);
            }
        };
        subParts.a(2131567875, this.f13621d, c14461);
        subParts.a(this.f13621d, c14472);
        Builder a = Builder.a();
        a.d = -11.0f;
        Builder builder = a;
        if (throwbackFriendversaryAggregatedFriendListProps.f13629d) {
            f = -5.0f;
        } else {
            f = -10.0f;
        }
        builder.c = f;
        subParts.a(this.f13622e, new StylingData(FeedProps.c(graphQLGoodwillThrowbackFriendversaryStory), builder.i()));
        subParts.a(2131567874, this.f13623f, throwbackFriendversaryAggregatedFriendListProps);
        return null;
    }

    public final boolean m15354a(Object obj) {
        return ((ThrowbackFriendversaryAggregatedFriendListProps) obj).f13627b != null;
    }

    @Inject
    public ThrowbackFriendversaryAggregatedFriendListItemPartDefinition(Provider<String> provider, FbUriIntentHandler fbUriIntentHandler, ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition, ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition throwbackFriendversaryAggregatedFriendListFriendPartDefinition, GlyphColorizer glyphColorizer, Provider<BottomSheetDialog> provider2) {
        this.f13619b = provider;
        this.f13620c = fbUriIntentHandler;
        this.f13621d = clickListenerPartDefinition;
        this.f13622e = backgroundPartDefinition;
        this.f13623f = throwbackFriendversaryAggregatedFriendListFriendPartDefinition;
        this.f13624g = glyphColorizer;
        this.f13625h = provider2;
    }

    public static ThrowbackFriendversaryAggregatedFriendListItemPartDefinition m15348a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryAggregatedFriendListItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13618j) {
                ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryAggregatedFriendListItemPartDefinition = (ThrowbackFriendversaryAggregatedFriendListItemPartDefinition) a2.a(f13618j);
                } else {
                    throwbackFriendversaryAggregatedFriendListItemPartDefinition = f13617i;
                }
                if (throwbackFriendversaryAggregatedFriendListItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15350b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13618j, b3);
                        } else {
                            f13617i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryAggregatedFriendListItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m15351a() {
        return f13616a;
    }

    private void m15349a(ThrowbackFriendversaryAggregatedFriendListProps throwbackFriendversaryAggregatedFriendListProps, Void voidR, HasPositionInformation hasPositionInformation, SegmentedLinearLayout segmentedLinearLayout) {
        super.a(throwbackFriendversaryAggregatedFriendListProps, voidR, hasPositionInformation, segmentedLinearLayout);
        if (throwbackFriendversaryAggregatedFriendListProps.f13629d) {
            segmentedLinearLayout.setShowSegmentedDividers(4);
        } else {
            segmentedLinearLayout.setShowSegmentedDividers(0);
        }
    }
}

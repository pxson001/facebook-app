package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: buildVersion */
public class SaleGroupsNearYouHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLSaleGroupsNearYouFeedUnit>, Void, HasPositionInformation, TextWithMenuButtonView> {
    private static SaleGroupsNearYouHeaderPartDefinition f9385c;
    private static final Object f9386d = new Object();
    private final PaddingStyle f9387a;
    private final BackgroundPartDefinition f9388b;

    private static SaleGroupsNearYouHeaderPartDefinition m9977b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m9979a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9388b, new StylingData((FeedProps) obj, this.f9387a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9980a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2099267483);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(((GraphQLSaleGroupsNearYouFeedUnit) feedProps.a).m().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 1135888514, a);
    }

    @Inject
    public SaleGroupsNearYouHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f9388b = backgroundPartDefinition;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = defaultPaddingStyleResolver.c();
        this.f9387a = a.i();
    }

    public final ViewType m9978a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m9981a(Object obj) {
        return true;
    }

    public static SaleGroupsNearYouHeaderPartDefinition m9976a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SaleGroupsNearYouHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9386d) {
                SaleGroupsNearYouHeaderPartDefinition saleGroupsNearYouHeaderPartDefinition;
                if (a2 != null) {
                    saleGroupsNearYouHeaderPartDefinition = (SaleGroupsNearYouHeaderPartDefinition) a2.a(f9386d);
                } else {
                    saleGroupsNearYouHeaderPartDefinition = f9385c;
                }
                if (saleGroupsNearYouHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9977b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9386d, b3);
                        } else {
                            f9385c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saleGroupsNearYouHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

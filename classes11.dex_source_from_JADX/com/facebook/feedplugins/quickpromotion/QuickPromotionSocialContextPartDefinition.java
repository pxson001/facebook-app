package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
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
/* compiled from: carrier_manager_refresh */
public class QuickPromotionSocialContextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, HasPositionInformation, ContentTextView> {
    public static final ViewType f8964a = new C10881();
    private static QuickPromotionSocialContextPartDefinition f8965c;
    private static final Object f8966d = new Object();
    private final BackgroundPartDefinition f8967b;

    /* compiled from: carrier_manager_refresh */
    final class C10881 extends ViewType {
        C10881() {
        }

        public final View m9684a(Context context) {
            return new ContentTextView(context);
        }
    }

    private static QuickPromotionSocialContextPartDefinition m9686b(InjectorLike injectorLike) {
        return new QuickPromotionSocialContextPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m9688a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f8967b, new StylingData((FeedProps) obj, PaddingStyle.a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9689a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1011732213);
        ContentTextView contentTextView = (ContentTextView) view;
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a;
        contentTextView.setTextAppearance(contentTextView.getContext(), 2131626698);
        contentTextView.setText(QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit).r().a());
        Logger.a(8, EntryType.MARK_POP, -265157259, a);
    }

    public final boolean m9690a(Object obj) {
        return QuickPromotionFeedUnitUtils.m9628b((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a);
    }

    @Inject
    public QuickPromotionSocialContextPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f8967b = backgroundPartDefinition;
    }

    public final ViewType m9687a() {
        return f8964a;
    }

    public static QuickPromotionSocialContextPartDefinition m9685a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionSocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8966d) {
                QuickPromotionSocialContextPartDefinition quickPromotionSocialContextPartDefinition;
                if (a2 != null) {
                    quickPromotionSocialContextPartDefinition = (QuickPromotionSocialContextPartDefinition) a2.a(f8966d);
                } else {
                    quickPromotionSocialContextPartDefinition = f8965c;
                }
                if (quickPromotionSocialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9686b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8966d, b3);
                        } else {
                            f8965c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionSocialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

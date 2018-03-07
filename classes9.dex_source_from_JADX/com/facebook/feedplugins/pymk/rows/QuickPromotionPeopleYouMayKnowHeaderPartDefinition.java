package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pymk.views.rows.QPPeopleYouMayKnowHeaderView;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_NOT_FOUND */
public class QuickPromotionPeopleYouMayKnowHeaderPartDefinition<T extends ScrollableItemListFeedUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, Void, HasPositionInformation, QPPeopleYouMayKnowHeaderView> {
    public static final ViewType f24868a = new C29941();
    private static QuickPromotionPeopleYouMayKnowHeaderPartDefinition f24869d;
    private static final Object f24870e = new Object();
    private final Resources f24871b;
    private final TextPartDefinition f24872c;

    /* compiled from: THREAD_NOT_FOUND */
    final class C29941 extends ViewType<QPPeopleYouMayKnowHeaderView> {
        C29941() {
        }

        public final View m26651a(Context context) {
            return new QPPeopleYouMayKnowHeaderView(context);
        }
    }

    private static QuickPromotionPeopleYouMayKnowHeaderPartDefinition m26653b(InjectorLike injectorLike) {
        return new QuickPromotionPeopleYouMayKnowHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m26655a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) ((FeedProps) obj).a;
        Object string = (scrollableItemListFeedUnit == null || scrollableItemListFeedUnit.m() == null) ? this.f24871b.getString(2131233210) : scrollableItemListFeedUnit.m().a();
        subParts.a(2131561965, this.f24872c, string);
        return null;
    }

    @Inject
    public QuickPromotionPeopleYouMayKnowHeaderPartDefinition(Resources resources, TextPartDefinition textPartDefinition) {
        this.f24871b = resources;
        this.f24872c = textPartDefinition;
    }

    public final ViewType m26654a() {
        return f24868a;
    }

    public final boolean m26656a(Object obj) {
        return true;
    }

    public static QuickPromotionPeopleYouMayKnowHeaderPartDefinition m26652a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionPeopleYouMayKnowHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24870e) {
                QuickPromotionPeopleYouMayKnowHeaderPartDefinition quickPromotionPeopleYouMayKnowHeaderPartDefinition;
                if (a2 != null) {
                    quickPromotionPeopleYouMayKnowHeaderPartDefinition = (QuickPromotionPeopleYouMayKnowHeaderPartDefinition) a2.a(f24870e);
                } else {
                    quickPromotionPeopleYouMayKnowHeaderPartDefinition = f24869d;
                }
                if (quickPromotionPeopleYouMayKnowHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26653b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24870e, b3);
                        } else {
                            f24869d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionPeopleYouMayKnowHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

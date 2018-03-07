package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.ui.PageYouMayLikeHeaderView;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onCompletion */
public class PymlHeaderPartDefinition<E extends HasMenuButtonProvider> extends BaseSinglePartDefinition<Props, CharSequence, E, PageYouMayLikeHeaderView> {
    public static final ViewType<PageYouMayLikeHeaderView> f6253a = new C02751();
    private static PymlHeaderPartDefinition f6254d;
    private static final Object f6255e = new Object();
    private final MenuButtonPartDefinition f6256b;
    private final EgoUnitUtil f6257c;

    /* compiled from: onCompletion */
    final class C02751 extends ViewType<PageYouMayLikeHeaderView> {
        C02751() {
        }

        public final View m6704a(Context context) {
            return new PageYouMayLikeHeaderView(context);
        }
    }

    /* compiled from: onCompletion */
    public class Props {
        public final SuggestedPageUnitItem f6467a;
        public final FeedProps<? extends ScrollableItemListFeedUnit> f6468b;

        public Props(SuggestedPageUnitItem suggestedPageUnitItem, FeedProps<? extends ScrollableItemListFeedUnit> feedProps) {
            this.f6467a = suggestedPageUnitItem;
            this.f6468b = feedProps;
        }
    }

    private static PymlHeaderPartDefinition m6701b(InjectorLike injectorLike) {
        return new PymlHeaderPartDefinition(MenuButtonPartDefinition.a(injectorLike), EgoUnitUtil.m6652b(injectorLike));
    }

    public final Object m6702a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131560877, this.f6256b, new com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props(props.f6468b, MenuConfig.CLICKABLE));
        return this.f6257c.m6655a((ScrollableItemListFeedUnit) props.f6468b.a, props.f6467a);
    }

    public final /* bridge */ /* synthetic */ void m6703a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -482785660);
        CharSequence charSequence = (CharSequence) obj2;
        PageYouMayLikeHeaderView pageYouMayLikeHeaderView = (PageYouMayLikeHeaderView) view;
        pageYouMayLikeHeaderView.setBackgroundResource(0);
        pageYouMayLikeHeaderView.setHeaderTitle(charSequence);
        pageYouMayLikeHeaderView.setMenuButtonActive(true);
        Logger.a(8, EntryType.MARK_POP, -1391881017, a);
    }

    @Inject
    public PymlHeaderPartDefinition(MenuButtonPartDefinition menuButtonPartDefinition, EgoUnitUtil egoUnitUtil) {
        this.f6256b = menuButtonPartDefinition;
        this.f6257c = egoUnitUtil;
    }

    public static PymlHeaderPartDefinition m6700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6255e) {
                PymlHeaderPartDefinition pymlHeaderPartDefinition;
                if (a2 != null) {
                    pymlHeaderPartDefinition = (PymlHeaderPartDefinition) a2.a(f6255e);
                } else {
                    pymlHeaderPartDefinition = f6254d;
                }
                if (pymlHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6701b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6255e, b3);
                        } else {
                            f6254d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

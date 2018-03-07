package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.graphql.model.FeedUnit;
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

@ContextScoped
/* compiled from: itemView may not be null */
public class MenuButtonPartDefinition extends BaseSinglePartDefinition<Props, OnClickListener, HasMenuButtonProvider, View> {
    private static MenuButtonPartDefinition f18730a;
    private static final Object f18731b = new Object();

    /* compiled from: itemView may not be null */
    public class Props {
        public final FeedProps<? extends FeedUnit> f19256a;
        public final MenuConfig f19257b;

        public Props(FeedProps<? extends FeedUnit> feedProps, MenuConfig menuConfig) {
            this.f19256a = feedProps;
            this.f19257b = menuConfig;
        }
    }

    private static MenuButtonPartDefinition m26323a() {
        return new MenuButtonPartDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        if (hasMenuButtonProvider.mo2448e() != null && props.f19257b == MenuConfig.CLICKABLE) {
            return new OnClickListener(this) {
                final /* synthetic */ MenuButtonPartDefinition f19267c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 214608357);
                    MenuButtonPartDefinition.m26325a(view, hasMenuButtonProvider, props.f19256a);
                    Logger.a(2, EntryType.UI_INPUT_END, -301209199, a);
                }
            };
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2052320780);
        Props props = (Props) obj;
        view.setOnClickListener((OnClickListener) obj2);
        view.setVisibility(props.f19257b != MenuConfig.HIDDEN ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, 1561589660, a);
    }

    public static MenuButtonPartDefinition m26324a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MenuButtonPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f18731b) {
                MenuButtonPartDefinition menuButtonPartDefinition;
                if (a3 != null) {
                    menuButtonPartDefinition = (MenuButtonPartDefinition) a3.mo818a(f18731b);
                } else {
                    menuButtonPartDefinition = f18730a;
                }
                if (menuButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m26323a();
                        if (a3 != null) {
                            a3.mo822a(f18731b, a2);
                        } else {
                            f18730a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = menuButtonPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }

    public static void m26325a(View view, HasMenuButtonProvider hasMenuButtonProvider, FeedProps feedProps) {
        hasMenuButtonProvider.mo2448e().mo2468a(feedProps, view);
    }
}

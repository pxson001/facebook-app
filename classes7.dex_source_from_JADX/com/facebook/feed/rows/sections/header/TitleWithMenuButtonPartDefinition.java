package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle$Sponsored;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unrecognized codec identifier. */
public class TitleWithMenuButtonPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends BaseSinglePartDefinitionWithViewType<Props, Void, E, TextWithMenuButtonView> {
    private static TitleWithMenuButtonPartDefinition f21182c;
    private static final Object f21183d = new Object();
    private final BackgroundPartDefinition f21184a;
    private final MenuButtonPartDefinition f21185b;

    /* compiled from: Unrecognized codec identifier. */
    public class Props {
        public final FeedProps<? extends FeedUnit> f21178a;
        public final String f21179b;
        public final CanShowHeaderTitle$Sponsored f21180c;
        public final boolean f21181d;

        public Props(FeedProps<? extends FeedUnit> feedProps, String str, CanShowHeaderTitle$Sponsored canShowHeaderTitle$Sponsored, boolean z) {
            this.f21178a = feedProps;
            this.f21179b = str;
            this.f21180c = canShowHeaderTitle$Sponsored;
            this.f21181d = z;
        }
    }

    private static TitleWithMenuButtonPartDefinition m24012b(InjectorLike injectorLike) {
        return new TitleWithMenuButtonPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m24014a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f21184a, new StylingData(props.f21178a, PaddingStyle.j));
        subParts.a(2131560877, this.f21185b, new com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props(props.f21178a, props.f21181d ? MenuConfig.CLICKABLE : MenuConfig.HIDDEN));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m24015a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 375998893);
        Props props = (Props) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.a(props.f21179b, props.f21180c);
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.setMenuButtonActive(props.f21181d);
        Logger.a(8, EntryType.MARK_POP, -1218715416, a);
    }

    @Inject
    public TitleWithMenuButtonPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f21184a = backgroundPartDefinition;
        this.f21185b = menuButtonPartDefinition;
    }

    public static TitleWithMenuButtonPartDefinition m24011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TitleWithMenuButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21183d) {
                TitleWithMenuButtonPartDefinition titleWithMenuButtonPartDefinition;
                if (a2 != null) {
                    titleWithMenuButtonPartDefinition = (TitleWithMenuButtonPartDefinition) a2.a(f21183d);
                } else {
                    titleWithMenuButtonPartDefinition = f21182c;
                }
                if (titleWithMenuButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24012b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21183d, b3);
                        } else {
                            f21182c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = titleWithMenuButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<TextWithMenuButtonView> m24013a() {
        return TextWithMenuButtonView.b;
    }
}

package com.facebook.feedplugins.base.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_page_context */
public class DefaultFooterBackgroundPartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, V> {
    private static DefaultFooterBackgroundPartDefinition f22424g;
    private static final Object f22425h = new Object();
    public final Resources f22426a;
    public final Lazy<FooterBackgroundStyleResolver> f22427b;
    private final FooterButtonStylePartDefinition<V> f22428c;
    private final FooterBackgroundStylePartDefinition<V> f22429d;
    public final UnseenStoryManager f22430e;
    private final Lazy<FbErrorReporter> f22431f;

    /* compiled from: is_page_context */
    public class ViewPadding {
        public final float f18966a;
        public final float f18967b;
        public final float f18968c;

        public ViewPadding(float f, float f2, float f3) {
            this.f18966a = f;
            this.f18967b = f2;
            this.f18968c = f3;
        }

        public final void m26678a(View view) {
            Context context = view.getContext();
            int a = SizeUtil.m19191a(context, this.f18966a);
            view.setPadding(a, SizeUtil.m19191a(context, this.f18967b), a, SizeUtil.m19191a(context, this.f18968c));
        }
    }

    /* compiled from: is_page_context */
    public class Props {
        public final boolean f22440a;
        public final boolean f22441b;
        public final boolean f22442c;
        public final FooterLevel f22443d;
        @Nullable
        public final FeedProps<GraphQLStory> f22444e;

        public Props(boolean z, boolean z2, boolean z3, FooterLevel footerLevel, FeedProps<GraphQLStory> feedProps) {
            this.f22440a = z;
            this.f22441b = z2;
            this.f22442c = z3;
            this.f22443d = footerLevel;
            this.f22444e = feedProps;
        }
    }

    private static DefaultFooterBackgroundPartDefinition m30333b(InjectorLike injectorLike) {
        return new DefaultFooterBackgroundPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), FooterButtonStylePartDefinition.m30335a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1823), FooterBackgroundStylePartDefinition.m30344a(injectorLike), UnseenStoryManager.m19201a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        FooterBackgroundStyleDefinition a = ((DefaultFooterBackgroundStyleResolver) this.f22427b.get()).m26663a(props.f22443d);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("Footer Level = ");
            stringBuilder.append(props.f22443d);
            stringBuilder.append("\nDebug info: \n");
            stringBuilder.append(((GraphQLStory) props.f22444e.f13444a).S_());
            SoftErrorBuilder a2 = SoftError.a("Null_Footer_Background_Style", stringBuilder.toString());
            a2.d = true;
            ((AbstractFbErrorReporter) this.f22431f.get()).mo336a(a2.g());
        }
        SinglePartDefinition singlePartDefinition = this.f22429d;
        FeedProps feedProps = props.f22444e;
        GraphQLStorySeenState a3 = this.f22430e.m19203a(feedProps);
        Drawable a4 = a.m26679a(this.f22426a, a3);
        Drawable b = a.m26680b(this.f22426a, a3);
        this.f22430e.m19204a(feedProps, a4);
        this.f22430e.m19204a(feedProps, b);
        subParts.mo2756a(singlePartDefinition, new com.facebook.feedplugins.base.footer.FooterBackgroundStylePartDefinition.Props(a, a4, b));
        subParts.mo2756a(this.f22428c, new com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition.Props(props.f22440a, props.f22441b, props.f22442c, a));
        return null;
    }

    public static DefaultFooterBackgroundPartDefinition m30332a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultFooterBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f22425h) {
                DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition;
                if (a2 != null) {
                    defaultFooterBackgroundPartDefinition = (DefaultFooterBackgroundPartDefinition) a2.mo818a(f22425h);
                } else {
                    defaultFooterBackgroundPartDefinition = f22424g;
                }
                if (defaultFooterBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m30333b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f22425h, b3);
                        } else {
                            f22424g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultFooterBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultFooterBackgroundPartDefinition(Resources resources, FooterButtonStylePartDefinition footerButtonStylePartDefinition, Lazy<FooterBackgroundStyleResolver> lazy, FooterBackgroundStylePartDefinition footerBackgroundStylePartDefinition, UnseenStoryManager unseenStoryManager, Lazy<FbErrorReporter> lazy2) {
        this.f22426a = resources;
        this.f22428c = footerButtonStylePartDefinition;
        this.f22427b = lazy;
        this.f22429d = footerBackgroundStylePartDefinition;
        this.f22430e = unseenStoryManager;
        this.f22431f = lazy2;
    }
}

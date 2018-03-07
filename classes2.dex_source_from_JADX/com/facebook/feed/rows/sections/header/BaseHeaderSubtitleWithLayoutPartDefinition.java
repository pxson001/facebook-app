package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.fbui.widget.text.TextLayoutView.LayoutCreator;
import com.facebook.fbui.widget.text.TextLayoutView.WidthErrorReporter;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.graphqlstory.header.HeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.graphqlstory.header.HeaderPartDataProviderForTextLayout.HeaderSubtitleData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: https.proxyHost */
public class BaseHeaderSubtitleWithLayoutPartDefinition<E extends HasMenuButtonProvider & HasContext> extends BaseSinglePartDefinition<Props, State, E, TextLayoutView> {
    private static BaseHeaderSubtitleWithLayoutPartDefinition f20691i;
    private static final Object f20692j = new Object();
    public final HeaderTextLayoutWidthResolver f20693a;
    private final SubtitleTextLayoutBuilderHolderProvider f20694b;
    public final FeedRenderUtils f20695c;
    public final TextPaint f20696d = new TextPaint(1);
    public final Paint f20697e;
    private final FbTextLayoutCacheWarmer f20698f;
    public final AbstractFbErrorReporter f20699g;
    public final Set<String> f20700h = new HashSet();

    @Immutable
    /* compiled from: https.proxyHost */
    public final class Props {
        public final FeedProps<GraphQLStory> f21910a;
        public final HeaderPartDataProviderForTextLayout f21911b;
        public final int f21912c;

        public Props(FeedProps<GraphQLStory> feedProps, HeaderPartDataProviderForTextLayout headerPartDataProviderForTextLayout, int i) {
            this.f21910a = feedProps;
            this.f21911b = headerPartDataProviderForTextLayout;
            this.f21912c = i;
        }
    }

    /* compiled from: https.proxyHost */
    public class State {
        public final WidthErrorReporter f21931a;
        public final LayoutCreator f21932b;
        public final Layout f21933c;

        public State(Layout layout, WidthErrorReporter widthErrorReporter, LayoutCreator layoutCreator) {
            this.f21933c = layout;
            this.f21931a = widthErrorReporter;
            this.f21932b = layoutCreator;
        }
    }

    private static BaseHeaderSubtitleWithLayoutPartDefinition m28437b(InjectorLike injectorLike) {
        return new BaseHeaderSubtitleWithLayoutPartDefinition((Context) injectorLike.getInstance(Context.class), (SubtitleTextLayoutBuilderHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SubtitleTextLayoutBuilderHolderProvider.class), HeaderTextLayoutWidthResolver.m28440a(injectorLike), FbTextLayoutCacheWarmer.m28443a(injectorLike), FeedRenderUtils.m14652a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        FeedProps feedProps = props.f21910a;
        final HeaderSubtitleData a = props.f21911b.mo3137a(feedProps, this.f20696d, this.f20697e, this.f20693a.m28442a(feedProps, hasMenuButtonProvider.mo2448e(), this.f20695c.m14654a(), props.f21912c));
        InjectorLike injectorLike = this.f20694b;
        final SubtitleTextLayoutBuilderHolder subtitleTextLayoutBuilderHolder = new SubtitleTextLayoutBuilderHolder(((HasContext) hasMenuButtonProvider).getContext(), RTLUtil.m6553a(injectorLike), FbTextLayoutCacheWarmer.m28443a(injectorLike));
        final GraphQLStory graphQLStory = (GraphQLStory) props.f21910a.f13444a;
        return new State(m28435a(this, a, subtitleTextLayoutBuilderHolder, a.f21927a), new WidthErrorReporter(this) {
            final /* synthetic */ BaseHeaderSubtitleWithLayoutPartDefinition f21935b;

            public final void mo3208a(CharSequence charSequence, int i, int i2) {
                if (this.f21935b.f20700h.add(graphQLStory.mo2507g()) && Math.abs(i - i2) != this.f21935b.f20695c.m14658b() && Math.random() < 0.001d) {
                    this.f21935b.f20699g.m2340a("WrongWidthForSubtitleTextLayout", StringFormatUtil.a("Regenerating layout for text = %s\nexpected width = %s\nactual width = %s\nwidth-height difference = %s\nstory = %s", new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(r1), graphQLStory}));
                }
            }
        }, new LayoutCreator(this) {
            final /* synthetic */ BaseHeaderSubtitleWithLayoutPartDefinition f21938c;

            public final Layout mo3209a(int i) {
                return BaseHeaderSubtitleWithLayoutPartDefinition.m28435a(this.f21938c, a, subtitleTextLayoutBuilderHolder, i);
            }
        });
    }

    public static Layout m28435a(BaseHeaderSubtitleWithLayoutPartDefinition baseHeaderSubtitleWithLayoutPartDefinition, HeaderSubtitleData headerSubtitleData, SubtitleTextLayoutBuilderHolder subtitleTextLayoutBuilderHolder, int i) {
        TextLayoutBuilder textLayoutBuilder = subtitleTextLayoutBuilderHolder.f21930a;
        textLayoutBuilder.m28599a(headerSubtitleData.f21928b);
        textLayoutBuilder.m28592a(i);
        textLayoutBuilder.f20866f = true;
        textLayoutBuilder.f20864d = baseHeaderSubtitleWithLayoutPartDefinition.f20698f;
        return textLayoutBuilder.m28608d();
    }

    public static BaseHeaderSubtitleWithLayoutPartDefinition m28436a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseHeaderSubtitleWithLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20692j) {
                BaseHeaderSubtitleWithLayoutPartDefinition baseHeaderSubtitleWithLayoutPartDefinition;
                if (a2 != null) {
                    baseHeaderSubtitleWithLayoutPartDefinition = (BaseHeaderSubtitleWithLayoutPartDefinition) a2.mo818a(f20692j);
                } else {
                    baseHeaderSubtitleWithLayoutPartDefinition = f20691i;
                }
                if (baseHeaderSubtitleWithLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28437b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20692j, b3);
                        } else {
                            f20691i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseHeaderSubtitleWithLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BaseHeaderSubtitleWithLayoutPartDefinition(Context context, SubtitleTextLayoutBuilderHolderProvider subtitleTextLayoutBuilderHolderProvider, HeaderTextLayoutWidthResolver headerTextLayoutWidthResolver, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, FeedRenderUtils feedRenderUtils, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20693a = headerTextLayoutWidthResolver;
        this.f20694b = subtitleTextLayoutBuilderHolderProvider;
        this.f20698f = fbTextLayoutCacheWarmer;
        this.f20695c = feedRenderUtils;
        this.f20699g = abstractFbErrorReporter;
        this.f20696d.setTextSize((float) context.getResources().getDimensionPixelSize(2131428835));
        this.f20697e = new Paint(1);
        this.f20697e.setColor(-1447187);
    }
}

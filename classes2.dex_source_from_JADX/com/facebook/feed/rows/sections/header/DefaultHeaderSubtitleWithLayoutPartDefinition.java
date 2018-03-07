package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: https.proxyPort */
public class DefaultHeaderSubtitleWithLayoutPartDefinition<E extends HasMenuButtonProvider & HasContext> extends BaseSinglePartDefinition<Props, Void, E, TextLayoutView> {
    private static DefaultHeaderSubtitleWithLayoutPartDefinition f20687c;
    private static final Object f20688d = new Object();
    private final BaseHeaderSubtitleWithLayoutPartDefinition<E> f20689a;
    private final DefaultHeaderPartDataProviderForTextLayout f20690b;

    /* compiled from: https.proxyPort */
    public class Props {
        public final FeedProps<GraphQLStory> f21738a;
        public final int f21739b;

        public Props(FeedProps<GraphQLStory> feedProps, int i) {
            this.f21738a = feedProps;
            this.f21739b = i;
        }
    }

    private static DefaultHeaderSubtitleWithLayoutPartDefinition m28433b(InjectorLike injectorLike) {
        return new DefaultHeaderSubtitleWithLayoutPartDefinition(BaseHeaderSubtitleWithLayoutPartDefinition.m28436a(injectorLike), DefaultHeaderPartDataProviderForTextLayout.m28171a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f20689a, new com.facebook.feed.rows.sections.header.BaseHeaderSubtitleWithLayoutPartDefinition.Props(props.f21738a, this.f20690b, props.f21739b));
        return null;
    }

    @Inject
    public DefaultHeaderSubtitleWithLayoutPartDefinition(BaseHeaderSubtitleWithLayoutPartDefinition baseHeaderSubtitleWithLayoutPartDefinition, DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout) {
        this.f20689a = baseHeaderSubtitleWithLayoutPartDefinition;
        this.f20690b = defaultHeaderPartDataProviderForTextLayout;
    }

    public static DefaultHeaderSubtitleWithLayoutPartDefinition m28432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderSubtitleWithLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20688d) {
                DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition;
                if (a2 != null) {
                    defaultHeaderSubtitleWithLayoutPartDefinition = (DefaultHeaderSubtitleWithLayoutPartDefinition) a2.mo818a(f20688d);
                } else {
                    defaultHeaderSubtitleWithLayoutPartDefinition = f20687c;
                }
                if (defaultHeaderSubtitleWithLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28433b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20688d, b3);
                        } else {
                            f20687c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderSubtitleWithLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

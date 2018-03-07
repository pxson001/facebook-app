package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.ui.VideoPlaysBlingBarView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Souvenir(%s) */
public class DefaultVideoPlaysBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, VideoPlaysBlingBarView> {
    private static DefaultVideoPlaysBlingBarPartDefinition f23212c;
    private static final Object f23213d = new Object();
    private final BaseVideoPlaysBlingBarPartDefinition f23214a;
    private final BackgroundPartDefinition f23215b;

    private static DefaultVideoPlaysBlingBarPartDefinition m25606b(InjectorLike injectorLike) {
        return new DefaultVideoPlaysBlingBarPartDefinition(BaseVideoPlaysBlingBarPartDefinition.m25572a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m25608a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f23214a, feedProps);
        subParts.a(this.f23215b, new StylingData(feedProps, BlingBarRootPartDefinition.f22896a));
        return null;
    }

    public final boolean m25609a(Object obj) {
        return BaseVideoPlaysBlingBarPartDefinition.m25573a((FeedProps) obj);
    }

    @Inject
    public DefaultVideoPlaysBlingBarPartDefinition(BaseVideoPlaysBlingBarPartDefinition baseVideoPlaysBlingBarPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23214a = baseVideoPlaysBlingBarPartDefinition;
        this.f23215b = backgroundPartDefinition;
    }

    public final ViewType m25607a() {
        return this.f23214a.m25575a();
    }

    public static DefaultVideoPlaysBlingBarPartDefinition m25605a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultVideoPlaysBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23213d) {
                DefaultVideoPlaysBlingBarPartDefinition defaultVideoPlaysBlingBarPartDefinition;
                if (a2 != null) {
                    defaultVideoPlaysBlingBarPartDefinition = (DefaultVideoPlaysBlingBarPartDefinition) a2.a(f23213d);
                } else {
                    defaultVideoPlaysBlingBarPartDefinition = f23212c;
                }
                if (defaultVideoPlaysBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25606b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23213d, b3);
                        } else {
                            f23212c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultVideoPlaysBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

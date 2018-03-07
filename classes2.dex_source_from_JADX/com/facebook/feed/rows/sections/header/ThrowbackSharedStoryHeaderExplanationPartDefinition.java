package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryHeader;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchLayoutAndMegaphoneRequest */
public class ThrowbackSharedStoryHeaderExplanationPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, SegmentedLinearLayout> {
    public static final ViewType f24294a = ViewType.m15456a(2130903297);
    private static final CallerContext f24295b = CallerContext.m9061a(ThrowbackSharedStoryHeaderExplanationPartDefinition.class, "goodwill_throwback");
    private static final PaddingStyle f24296c;
    private static ThrowbackSharedStoryHeaderExplanationPartDefinition f24297i;
    private static final Object f24298j = new Object();
    private final BackgroundPartDefinition f24299d;
    private final TextPartDefinition f24300e;
    private final FbDraweePartDefinition f24301f;
    private final ClickListenerPartDefinition f24302g;
    public final FbUriIntentHandler f24303h;

    private static ThrowbackSharedStoryHeaderExplanationPartDefinition m32637b(InjectorLike injectorLike) {
        return new ThrowbackSharedStoryHeaderExplanationPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), TextPartDefinition.m19379a(injectorLike), FbDraweePartDefinition.m27839a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), FbUriIntentHandler.m8626a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2755a(2131558927, this.f24300e, graphQLStory.aA().m24869o().mo2911a());
        subParts.mo2755a(2131558926, this.f24300e, graphQLStory.aA().m24868n().mo2911a());
        GraphQLImage j = graphQLStory.aA().m24864j();
        SinglePartDefinition singlePartDefinition = this.f24301f;
        Builder a = new Builder().m29720a(j.mo2924b());
        a.f21889c = f24295b;
        subParts.mo2755a(2131559708, singlePartDefinition, a.m29721a());
        subParts.mo2756a(this.f24299d, new StylingData(feedProps, f24296c));
        subParts.mo2756a(this.f24302g, new 1(this, graphQLStory.aA().m24862a()));
        return null;
    }

    public final boolean m32640a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryHeader aA = ((GraphQLStory) feedProps.f13444a).aA();
        return (aA == null || aA.m24867m() == null || !aA.m24867m().contains(GraphQLStoryHeaderStyle.THROWBACK_SHARED_STORY) || !StoryProps.m27463k(feedProps) || aA.m24869o() == null || Strings.isNullOrEmpty(aA.m24869o().mo2911a()) || aA.m24868n() == null || Strings.isNullOrEmpty(aA.m24868n().mo2911a()) || aA.m24864j() == null || Strings.isNullOrEmpty(aA.m24864j().mo2924b())) ? false : true;
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.m19301a();
        a.f13066b = 1.0f;
        a = a;
        a.f13068d = -11.0f;
        f24296c = a.m19313i();
    }

    public static ThrowbackSharedStoryHeaderExplanationPartDefinition m32636a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackSharedStoryHeaderExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24298j) {
                ThrowbackSharedStoryHeaderExplanationPartDefinition throwbackSharedStoryHeaderExplanationPartDefinition;
                if (a2 != null) {
                    throwbackSharedStoryHeaderExplanationPartDefinition = (ThrowbackSharedStoryHeaderExplanationPartDefinition) a2.mo818a(f24298j);
                } else {
                    throwbackSharedStoryHeaderExplanationPartDefinition = f24297i;
                }
                if (throwbackSharedStoryHeaderExplanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32637b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24298j, b3);
                        } else {
                            f24297i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackSharedStoryHeaderExplanationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ThrowbackSharedStoryHeaderExplanationPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler) {
        this.f24299d = backgroundPartDefinition;
        this.f24300e = textPartDefinition;
        this.f24301f = fbDraweePartDefinition;
        this.f24302g = clickListenerPartDefinition;
        this.f24303h = fbUriIntentHandler;
    }

    public final ViewType mo2547a() {
        return f24294a;
    }
}

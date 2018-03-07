package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition.State;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_page_nearby_has_shown */
public class AnniversaryHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends FacebookVoiceBasePartDefinition<GraphQLGoodwillAnniversaryCampaignFeedUnit, E> {
    private static AnniversaryHeaderPartDefinition f12120e;
    private static final Object f12121f = new Object();
    private final BackgroundPartDefinition f12122b;
    private final MenuButtonPartDefinition f12123c;
    private final LinkifyUtil f12124d;

    private static AnniversaryHeaderPartDefinition m14124b(InjectorLike injectorLike) {
        return new AnniversaryHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m14125a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m14122a(subParts, (FeedProps) obj);
    }

    public final boolean m14126a(Object obj) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.l() == null) {
            return false;
        }
        GraphQLImage m = graphQLGoodwillAnniversaryCampaignFeedUnit.l().m();
        return (m == null || m.b() == null) ? false : true;
    }

    @Inject
    public AnniversaryHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, LinkifyUtil linkifyUtil) {
        this.f12122b = backgroundPartDefinition;
        this.f12123c = menuButtonPartDefinition;
        this.f12124d = linkifyUtil;
    }

    public static AnniversaryHeaderPartDefinition m14123a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12121f) {
                AnniversaryHeaderPartDefinition anniversaryHeaderPartDefinition;
                if (a2 != null) {
                    anniversaryHeaderPartDefinition = (AnniversaryHeaderPartDefinition) a2.a(f12121f);
                } else {
                    anniversaryHeaderPartDefinition = f12120e;
                }
                if (anniversaryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14124b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12121f, b3);
                        } else {
                            f12120e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = anniversaryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private State m14122a(SubParts<E> subParts, FeedProps<GraphQLGoodwillAnniversaryCampaignFeedUnit> feedProps) {
        CharSequence charSequence;
        GraphQLGoodwillAnniversaryCampaign l = ((GraphQLGoodwillAnniversaryCampaignFeedUnit) feedProps.a()).l();
        subParts.a(this.f12122b, new StylingData(feedProps, PaddingStyle.i));
        subParts.a(2131560877, this.f12123c, new Props(feedProps, MenuConfig.CLICKABLE));
        String a = l.o() != null ? l.o().a() : null;
        if (l.s() == null || l.s().a() == null) {
            charSequence = null;
        } else {
            charSequence = this.f12124d.a(LinkifyUtilConverter.c(l.s()), true, null);
        }
        GraphQLTextWithEntities n = l.n();
        if (n == null || n.a() == null) {
            n = null;
        }
        return new State(a, charSequence, n, true, l.m(), -16777216, false, l.l(), false, null, 0, 0.0f);
    }
}

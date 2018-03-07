package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.goodwill.composer.GoodwillComposerActivity;
import com.facebook.goodwill.composer.GoodwillComposerEvent;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackAnniversaryCampaignStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchAttachment */
public class ThrowbackAnniversaryCampaignSharePartDefinition extends MultiRowSinglePartDefinition<GraphQLGoodwillThrowbackAnniversaryCampaignStory, Void, HasPositionInformation, OneButtonFooterView> {
    private static ThrowbackAnniversaryCampaignSharePartDefinition f13521f;
    private static final Object f13522g = new Object();
    public final SecureContextHelper f13523a;
    private final Context f13524b;
    private final OneButtonFooterStylerPartDefinition f13525c;
    private final TextPartDefinition f13526d;
    private final ClickListenerPartDefinition f13527e;

    private static ThrowbackAnniversaryCampaignSharePartDefinition m15296b(InjectorLike injectorLike) {
        return new ThrowbackAnniversaryCampaignSharePartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class), OneButtonFooterStylerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m15298a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) obj;
        Object string = (graphQLGoodwillThrowbackAnniversaryCampaignStory == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.k() == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.k().k() == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.k().k().a() == null) ? this.f13524b.getString(2131233280) : graphQLGoodwillThrowbackAnniversaryCampaignStory.k().k().a();
        final GraphQLGoodwillAnniversaryCampaign k = graphQLGoodwillThrowbackAnniversaryCampaignStory.k();
        C14371 c14371 = new OnClickListener(this) {
            final /* synthetic */ ThrowbackAnniversaryCampaignSharePartDefinition f13520b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1602759398);
                this.f13520b.f13523a.a(GoodwillComposerActivity.m66a(view.getContext(), ThrowbackAnniversaryCampaignSharePartDefinition.m15295b(view.getContext(), k), new String[]{"photos"}, "mle"), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -827253535, a);
            }
        };
        subParts.a(this.f13525c, null);
        subParts.a(2131559974, this.f13526d, string);
        subParts.a(this.f13527e, c14371);
        return null;
    }

    @Inject
    public ThrowbackAnniversaryCampaignSharePartDefinition(SecureContextHelper secureContextHelper, Context context, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f13523a = secureContextHelper;
        this.f13524b = context;
        this.f13525c = oneButtonFooterStylerPartDefinition;
        this.f13526d = textPartDefinition;
        this.f13527e = clickListenerPartDefinition;
    }

    public final ViewType m15297a() {
        return OneButtonFooterView.a;
    }

    public static ThrowbackAnniversaryCampaignSharePartDefinition m15293a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackAnniversaryCampaignSharePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13522g) {
                ThrowbackAnniversaryCampaignSharePartDefinition throwbackAnniversaryCampaignSharePartDefinition;
                if (a2 != null) {
                    throwbackAnniversaryCampaignSharePartDefinition = (ThrowbackAnniversaryCampaignSharePartDefinition) a2.a(f13522g);
                } else {
                    throwbackAnniversaryCampaignSharePartDefinition = f13521f;
                }
                if (throwbackAnniversaryCampaignSharePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15296b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13522g, b3);
                        } else {
                            f13521f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackAnniversaryCampaignSharePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m15299a(Object obj) {
        return true;
    }

    public static GoodwillComposerEvent m15295b(Context context, GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign) {
        GoodwillComposerEvent goodwillComposerEvent = new GoodwillComposerEvent(graphQLGoodwillAnniversaryCampaign.p(), m15294a(graphQLGoodwillAnniversaryCampaign.o()), m15294a(graphQLGoodwillAnniversaryCampaign.u()), context.getString(2131239210), context.getString(2131239213), context.getString(2131239214), graphQLGoodwillAnniversaryCampaign.jK_(), "throwback_permalink");
        if (graphQLGoodwillAnniversaryCampaign.r() != null) {
            ImmutableList r = graphQLGoodwillAnniversaryCampaign.r();
            int size = r.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) r.get(i);
                if (graphQLStoryAttachment.r() != null) {
                    goodwillComposerEvent.m91a(new GoodwillPhoto(graphQLStoryAttachment.r()));
                }
            }
        }
        return goodwillComposerEvent;
    }

    private static String m15294a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? graphQLTextWithEntities.a() : "";
    }
}

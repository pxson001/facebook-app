package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.goodwill.composer.GoodwillComposerActivity;
import com.facebook.goodwill.composer.GoodwillComposerEvent;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
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
/* compiled from: gravity_post_compose_tooltip_seen */
public class AnniversaryFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillAnniversaryCampaignFeedUnit>, Void, HasPositionInformation, OneButtonFooterView> {
    private static AnniversaryFooterPartDefinition f12112g;
    private static final Object f12113h = new Object();
    public final SecureContextHelper f12114a;
    public final FbUriIntentHandler f12115b;
    private final OneButtonFooterStylerPartDefinition f12116c;
    private final ClickListenerPartDefinition f12117d;
    private final TextPartDefinition f12118e;
    private final Context f12119f;

    private static AnniversaryFooterPartDefinition m14118b(InjectorLike injectorLike) {
        return new AnniversaryFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FbUriIntentHandler.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m14120a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ((FeedProps) obj).a;
        String a = graphQLGoodwillAnniversaryCampaignFeedUnit.l().k().a();
        final String a2 = m14117a(graphQLGoodwillAnniversaryCampaignFeedUnit.l().p());
        subParts.a(this.f12116c, null);
        subParts.a(2131559974, this.f12118e, a);
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.n() == null || !graphQLGoodwillAnniversaryCampaignFeedUnit.n().equals("anniversary_video") || TextUtils.isEmpty(a2)) {
            final GoodwillComposerEvent goodwillComposerEvent = new GoodwillComposerEvent(a2, m14116a(graphQLGoodwillAnniversaryCampaignFeedUnit.l().s()), m14116a(graphQLGoodwillAnniversaryCampaignFeedUnit.l().u()), this.f12119f.getString(2131239211), this.f12119f.getString(2131239213), this.f12119f.getString(2131239214), graphQLGoodwillAnniversaryCampaignFeedUnit.l().jK_(), "news_feed");
            if (graphQLGoodwillAnniversaryCampaignFeedUnit.l().r() != null) {
                ImmutableList r = graphQLGoodwillAnniversaryCampaignFeedUnit.l().r();
                int size = r.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) r.get(i);
                    if (graphQLStoryAttachment.r() != null) {
                        goodwillComposerEvent.m91a(new GoodwillPhoto(graphQLStoryAttachment.r()));
                    }
                }
            }
            subParts.a(this.f12117d, new OnClickListener(this) {
                final /* synthetic */ AnniversaryFooterPartDefinition f12111b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -921037711);
                    Context context = view.getContext();
                    this.f12111b.f12114a.a(GoodwillComposerActivity.m66a(context, goodwillComposerEvent, new String[]{"photos"}, "mle"), context);
                    Logger.a(2, EntryType.UI_INPUT_END, -1433584018, a);
                }
            });
        } else {
            subParts.a(this.f12117d, new OnClickListener(this) {
                final /* synthetic */ AnniversaryFooterPartDefinition f12109b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 51833460);
                    this.f12109b.f12115b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.em, a2));
                    Logger.a(2, EntryType.UI_INPUT_END, -1711280991, a);
                }
            });
        }
        return null;
    }

    public final boolean m14121a(Object obj) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ((FeedProps) obj).a;
        return (graphQLGoodwillAnniversaryCampaignFeedUnit == null || graphQLGoodwillAnniversaryCampaignFeedUnit.l() == null || graphQLGoodwillAnniversaryCampaignFeedUnit.l().k() == null || TextUtils.isEmpty(graphQLGoodwillAnniversaryCampaignFeedUnit.l().k().a())) ? false : true;
    }

    @Inject
    public AnniversaryFooterPartDefinition(SecureContextHelper secureContextHelper, FbUriIntentHandler fbUriIntentHandler, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, Context context) {
        this.f12114a = secureContextHelper;
        this.f12115b = fbUriIntentHandler;
        this.f12116c = oneButtonFooterStylerPartDefinition;
        this.f12117d = clickListenerPartDefinition;
        this.f12118e = textPartDefinition;
        this.f12119f = context;
    }

    public static AnniversaryFooterPartDefinition m14115a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12113h) {
                AnniversaryFooterPartDefinition anniversaryFooterPartDefinition;
                if (a2 != null) {
                    anniversaryFooterPartDefinition = (AnniversaryFooterPartDefinition) a2.a(f12113h);
                } else {
                    anniversaryFooterPartDefinition = f12112g;
                }
                if (anniversaryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14118b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12113h, b3);
                        } else {
                            f12112g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = anniversaryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14119a() {
        return OneButtonFooterView.a;
    }

    private static String m14117a(String str) {
        return str != null ? str : "";
    }

    private String m14116a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? m14117a(graphQLTextWithEntities.a()) : "";
    }
}

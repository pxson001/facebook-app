package com.facebook.goodwill.feed.rows;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
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
import com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPluginConfig;
import com.facebook.goodwill.feed.rows.ThrowbackFeedUtils.FriendversaryCampaignRenderStyle;
import com.facebook.graphql.model.GraphQLGoodwillFriendversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryPromotionStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.intent.SharePreview.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
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
/* compiled from: fb_webrtc_jni */
public class ThrowbackFriendversaryCampaignFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackFriendversaryPromotionStory>, Void, HasPositionInformation, OneButtonFooterView> {
    private static ThrowbackFriendversaryCampaignFooterPartDefinition f13642h;
    private static final Object f13643i = new Object();
    public final SecureContextHelper f13644a;
    private final OneButtonFooterStylerPartDefinition f13645b;
    private final ClickListenerPartDefinition f13646c;
    private final TextPartDefinition f13647d;
    private final Context f13648e;
    public final ComposerLauncher f13649f;
    public final JsonPluginConfigSerializer f13650g;

    private static ThrowbackFriendversaryCampaignFooterPartDefinition m15368b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryCampaignFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), JsonPluginConfigSerializer.b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m15370a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m15367a(subParts, (FeedProps) obj);
    }

    public final boolean m15371a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (feedProps.a == null || ((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a).l() == null || ((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a).l().m() == null) ? false : true;
    }

    public static ThrowbackFriendversaryCampaignFooterPartDefinition m15364a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryCampaignFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13643i) {
                ThrowbackFriendversaryCampaignFooterPartDefinition throwbackFriendversaryCampaignFooterPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryCampaignFooterPartDefinition = (ThrowbackFriendversaryCampaignFooterPartDefinition) a2.a(f13643i);
                } else {
                    throwbackFriendversaryCampaignFooterPartDefinition = f13642h;
                }
                if (throwbackFriendversaryCampaignFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15368b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13643i, b3);
                        } else {
                            f13642h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryCampaignFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackFriendversaryCampaignFooterPartDefinition(SecureContextHelper secureContextHelper, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, Context context, ComposerLauncher composerLauncher, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
        this.f13645b = oneButtonFooterStylerPartDefinition;
        this.f13644a = secureContextHelper;
        this.f13646c = clickListenerPartDefinition;
        this.f13647d = textPartDefinition;
        this.f13648e = context;
        this.f13649f = composerLauncher;
        this.f13650g = jsonPluginConfigSerializer;
    }

    public final ViewType m15369a() {
        return OneButtonFooterView.a;
    }

    private Void m15367a(SubParts<HasPositionInformation> subParts, FeedProps<GraphQLGoodwillThrowbackFriendversaryPromotionStory> feedProps) {
        GraphQLGoodwillFriendversaryCampaign l = ((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a).l();
        CharSequence string = this.f13648e.getString(2131233280);
        final GoodwillComposerEvent goodwillComposerEvent = new GoodwillComposerEvent(m15366a(l.m()), m15365a(l.v()), m15365a(l.q()), this.f13648e.getString(2131239210), this.f13648e.getString(2131239213), this.f13648e.getString(2131239214), l.jK_(), "throwback_permalink");
        if (l.o() != null) {
            ImmutableList o = l.o();
            int size = o.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) o.get(i);
                if (graphQLStoryAttachment.r() != null) {
                    goodwillComposerEvent.m91a(new GoodwillPhoto(graphQLStoryAttachment.r()));
                }
            }
        }
        if (!TextUtils.isEmpty(string)) {
            subParts.a(this.f13645b, null);
            subParts.a(2131559974, this.f13647d, string);
            if (FriendversaryCampaignRenderStyle.COLLAGE_V1.toString().equals(((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a()).n())) {
                subParts.a(this.f13646c, new OnClickListener(this) {
                    final /* synthetic */ ThrowbackFriendversaryCampaignFooterPartDefinition f13638b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -449368082);
                        this.f13638b.f13644a.a(GoodwillComposerActivity.m66a(view.getContext(), goodwillComposerEvent, new String[]{"photos"}, "friendversary_collage"), view.getContext());
                        Logger.a(2, EntryType.UI_INPUT_END, -1911680912, a);
                    }
                });
            } else if (FriendversaryCampaignRenderStyle.POLAROID_V1.toString().equals(((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a()).n())) {
                subParts.a(this.f13646c, m15363a((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedProps.a()));
            }
        }
        return null;
    }

    private static String m15366a(String str) {
        return str != null ? str : "";
    }

    private static String m15365a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? m15366a(graphQLTextWithEntities.a()) : "";
    }

    private OnClickListener m15363a(GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory) {
        int i;
        SharePreview a;
        final GraphQLGoodwillFriendversaryCampaign l = graphQLGoodwillThrowbackFriendversaryPromotionStory.l();
        if (l.o() == null || l.o().isEmpty() || l.o().get(0) == null || ((GraphQLStoryAttachment) l.o().get(0)).r() == null || ((GraphQLStoryAttachment) l.o().get(0)).r().S() == null || TextUtils.isEmpty(((GraphQLStoryAttachment) l.o().get(0)).r().S().b())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            Builder builder = new Builder();
            builder.a = l.v().a();
            Builder builder2 = builder;
            builder2.d = ((GraphQLStoryAttachment) l.o().get(0)).r().S().b().toString();
            a = builder2.a();
        } else {
            a = null;
        }
        return new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryCampaignFooterPartDefinition f13641c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1634531304);
                ComposerConfiguration.Builder pluginConfig = ComposerConfiguration.newBuilder().setComposerType(ComposerType.STATUS).setSourceType(ComposerSourceType.ON_THIS_DAY_FRIENDVERSARY_CARD).setPluginConfig(this.f13641c.f13650g.a(GoodwillFriendversaryCardComposerPluginConfig.m129a("throwback_permalink", l.m())));
                ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a();
                a2.d = a;
                this.f13641c.f13649f.a(null, pluginConfig.setInitialShareParams(a2.b()).setIsFireAndForget(true).a(), (Context) ContextUtils.a(view.getContext(), Activity.class));
                Logger.a(2, EntryType.UI_INPUT_END, 1240117145, a);
            }
        };
    }
}

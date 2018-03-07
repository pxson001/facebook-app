package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger$Events;
import com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPluginConfig;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graphQLID */
public class MessageAndPostPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, State, HasPositionInformation, ThrowbackGlyphWithTextRowView> {
    public static final ViewType f12324a = new C13051();
    private static final PaddingStyle f12325b;
    private static MessageAndPostPartDefinition f12326h;
    private static final Object f12327i = new Object();
    private final BackgroundPartDefinition f12328c;
    public final SecureContextHelper f12329d;
    public final ComposerLauncher f12330e;
    public final GoodwillAnalyticsLogger f12331f;
    public final JsonPluginConfigSerializer f12332g;

    /* compiled from: graphQLID */
    final class C13051 extends ViewType {
        C13051() {
        }

        public final View m14263a(Context context) {
            return new ThrowbackGlyphWithTextRowView(context);
        }
    }

    /* compiled from: graphQLID */
    class MessageClickListener implements OnClickListener {
        final /* synthetic */ MessageAndPostPartDefinition f12312a;
        private String f12313b;
        private String f12314c;

        public MessageClickListener(MessageAndPostPartDefinition messageAndPostPartDefinition, String str, String str2) {
            this.f12312a = messageAndPostPartDefinition;
            this.f12313b = str;
            this.f12314c = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1899591665);
            GoodwillAnalyticsLogger goodwillAnalyticsLogger = this.f12312a.f12331f;
            String str = this.f12314c;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.GOODWILL_THROWBACK_SHARE_MESSAGE_OPEN.name);
            honeyClientEvent.c = "goodwill";
            goodwillAnalyticsLogger.a.a(honeyClientEvent.b("campaign_id", str));
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, this.f12313b);
            Intent intent = new Intent();
            intent.setData(Uri.parse(formatStrLocaleSafe));
            intent.addFlags(268435456);
            this.f12312a.f12329d.a(intent, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -275330202, a);
        }
    }

    /* compiled from: graphQLID */
    class PostClickListener implements OnClickListener {
        final /* synthetic */ MessageAndPostPartDefinition f12315a;
        private String f12316b;
        private String f12317c;
        private String f12318d;
        private String f12319e;

        public PostClickListener(MessageAndPostPartDefinition messageAndPostPartDefinition, String str, String str2, String str3, String str4) {
            this.f12315a = messageAndPostPartDefinition;
            this.f12316b = str;
            this.f12317c = str2;
            this.f12318d = str3;
            this.f12319e = str4;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1692273740);
            GoodwillAnalyticsLogger goodwillAnalyticsLogger = this.f12315a.f12331f;
            String str = this.f12319e;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.GOODWILL_THROWBACK_SHARE_COMPOSER_OPEN.name);
            honeyClientEvent.c = "goodwill";
            goodwillAnalyticsLogger.a.a(honeyClientEvent.b("campaign_id", str));
            Builder builder = new Builder(Long.parseLong(this.f12316b), TargetType.USER);
            builder.d = this.f12317c;
            builder = builder;
            builder.c = this.f12318d;
            ComposerConfiguration a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "goodwillMessageAndPostPartDefinition").setPluginConfig(this.f12315a.f12332g.a(GoodwillFriendsBirthdayComposerPluginConfig.m107a(view.getResources().getString(2131239205, new Object[]{this.f12318d})))).setInitialTargetData(builder.a()).setIsFireAndForget(true).setNectarModule("top_friend_birthday_promotion").a();
            this.f12315a.f12330e.a(SafeUUIDGenerator.a().toString(), a2, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -962764102, a);
        }
    }

    /* compiled from: graphQLID */
    public class State {
        public OnClickListener f12320a;
        public OnClickListener f12321b;
        public boolean f12322c;
        public final SelfRegistrableReceiverImpl f12323d;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, boolean z, SelfRegistrableReceiverImpl selfRegistrableReceiverImpl) {
            this.f12320a = onClickListener;
            this.f12321b = onClickListener2;
            this.f12322c = z;
            this.f12323d = selfRegistrableReceiverImpl;
        }
    }

    private static MessageAndPostPartDefinition m14265b(InjectorLike injectorLike) {
        return new MessageAndPostPartDefinition(FooterBackgroundPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), JsonPluginConfigSerializer.b(injectorLike), GoodwillAnalyticsLogger.a(injectorLike));
    }

    public final Object m14267a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SelfRegistrableReceiverImpl a;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        subParts.a(this.f12328c, new StylingData(feedProps, f12325b, Position.DIVIDER_TOP));
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        GraphQLProfile k = g.k();
        if ("friend_birthday".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friend_birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            a = this.f12331f.a("friend_birthday_promotion", g.t(), g.t(), "friend_birthday_campaign", "promotion", graphQLGoodwillThrowbackPromotionFeedUnit.F());
        } else {
            a = null;
        }
        return new State(new PostClickListener(this, k.b(), k.ai().b(), k.U(), g.t()), new MessageClickListener(this, k.b(), g.t()), k.u(), a);
    }

    public final /* bridge */ /* synthetic */ void m14268a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1131078075);
        State state = (State) obj2;
        ThrowbackGlyphWithTextRowView throwbackGlyphWithTextRowView = (ThrowbackGlyphWithTextRowView) view;
        int i = 0;
        if (state.f12322c) {
            throwbackGlyphWithTextRowView.m14333a(0, throwbackGlyphWithTextRowView.getResources().getString(2131239204), throwbackGlyphWithTextRowView.getResources().getString(2131239204), 2130840052, state.f12320a);
            i = 1;
        }
        throwbackGlyphWithTextRowView.m14333a(i, throwbackGlyphWithTextRowView.getResources().getString(2131239203), throwbackGlyphWithTextRowView.getResources().getString(2131239203), 2130838327, state.f12321b);
        throwbackGlyphWithTextRowView.setNumButtons(i + 1);
        if (state.f12323d != null) {
            state.f12323d.b();
        }
        Logger.a(8, EntryType.MARK_POP, -738447954, a);
    }

    public final boolean m14269a(Object obj) {
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g((GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a);
        return (g == null || g.k() == null || g.k().b() == null || g.k().ai() == null || g.k().ai().b() == null || g.k().U() == null) ? false : true;
    }

    public final void m14270b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ThrowbackGlyphWithTextRowView throwbackGlyphWithTextRowView = (ThrowbackGlyphWithTextRowView) view;
        if (state.f12323d != null) {
            state.f12323d.c();
        }
        for (int i = 0; i < 2; i++) {
            throwbackGlyphWithTextRowView.f12425a[i].setOnClickListener(null);
        }
    }

    static {
        PaddingStyle.Builder f = PaddingStyle.Builder.f();
        f.c = -3.0f;
        f = f;
        f.b = -3.0f;
        f12325b = f.i();
    }

    public static MessageAndPostPartDefinition m14264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageAndPostPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12327i) {
                MessageAndPostPartDefinition messageAndPostPartDefinition;
                if (a2 != null) {
                    messageAndPostPartDefinition = (MessageAndPostPartDefinition) a2.a(f12327i);
                } else {
                    messageAndPostPartDefinition = f12326h;
                }
                if (messageAndPostPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14265b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12327i, b3);
                        } else {
                            f12326h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageAndPostPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MessageAndPostPartDefinition(FooterBackgroundPartDefinition footerBackgroundPartDefinition, BackgroundPartDefinition backgroundPartDefinition, SecureContextHelper secureContextHelper, ComposerLauncher composerLauncher, JsonPluginConfigSerializer jsonPluginConfigSerializer, GoodwillAnalyticsLogger goodwillAnalyticsLogger) {
        this.f12328c = backgroundPartDefinition;
        this.f12329d = secureContextHelper;
        this.f12330e = composerLauncher;
        this.f12332g = jsonPluginConfigSerializer;
        this.f12331f = goodwillAnalyticsLogger;
    }

    public final ViewType m14266a() {
        return f12324a;
    }
}

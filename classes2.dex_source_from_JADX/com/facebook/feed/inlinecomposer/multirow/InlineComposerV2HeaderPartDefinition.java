package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginConfig;
import com.facebook.feed.inlinecomposer.InlineComposerSproutUtil;
import com.facebook.feed.inlinecomposer.InlineComposerV2HeaderView;
import com.facebook.feed.inlinecomposer.InlineComposerV2HeaderView.C05971;
import com.facebook.feed.inlinecomposer.logging.InlineComposerLogger;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerExposedTopGetterPartDefinition.SettableTopGetter;
import com.facebook.feed.inlinecomposer.multirow.animations.PromptHeaderAnimationBuilder;
import com.facebook.feed.inlinecomposer.multirow.common.HasComposerLauncherContext;
import com.facebook.feed.inlinecomposer.multirow.common.HasFeedUnitTopGetter;
import com.facebook.feed.inlinecomposer.multirow.common.HasNextDefinitionInfo;
import com.facebook.feed.inlinecomposer.multirow.common.HasPreviousDefinitionInfo;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerExposedBackgroundPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.abtest.InlineComposerExperiment$ComposerGlyphType;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.goodfriends.abtest.GoodFriendsFeedQEStore;
import com.facebook.goodfriends.prompt.InlineComposerGoodFriendsPromptIconPartDefinition;
import com.facebook.goodfriends.prompt.InlineComposerGoodFriendsPromptPartDefinition;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptViewController;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.persistent.parts.AnimationPartFactory;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mutate_live_scribe */
public class InlineComposerV2HeaderPartDefinition<E extends HasComposerLauncherContext & HasFeedUnitTopGetter & HasNextDefinitionInfo & HasPreviousDefinitionInfo & HasContext & HasPersistentState & PromptViewStateUpdater> extends MultiRowSinglePartDefinition<Props, State, E, InlineComposerV2HeaderView> {
    public static final ViewType f13143a = new C05321();
    private static InlineComposerV2HeaderPartDefinition f13144y;
    private static final Object f13145z = new Object();
    public final Context f13146b;
    private final InlineComposerExposedBackgroundPartDefinition f13147c;
    private final InlineComposerExposedTopGetterPartDefinition f13148d;
    private final InlineComposerProfilePhotoPartDefinition f13149e;
    private final TextPartDefinition f13150f;
    private final InlineComposerPromptIconPartDefinition f13151g;
    private final InlineComposerGoodFriendsPromptIconPartDefinition f13152h;
    public final Provider<IFeedIntentBuilder> f13153i;
    public final InlineComposerLogger f13154j;
    public final FeedComposerLauncherProvider f13155k;
    public final InlineComposerSproutUtil f13156l;
    public final QeAccessor f13157m;
    private final Provider<InlineComposerPromptViewController> f13158n;
    private final InlineComposerGlyphsPartDefinition f13159o;
    public final FragmentActivity f13160p = ((FragmentActivity) ContextUtils.m2500a(this.f13146b, FragmentActivity.class));
    private final DefaultAnimationPartFactory f13161q;
    private final InlineComposerPersistentStateHelper f13162r;
    private final PromptsExperimentHelper f13163s;
    private final InlineComposerPromptFlyoutPartDefinition f13164t;
    public final JsonPluginConfigSerializer f13165u;
    private final InlineComposerGoodFriendsPromptPartDefinition<View> f13166v;
    public final CreativeCamLauncher f13167w;
    private final GoodFriendsFeedQEStore f13168x;

    /* compiled from: mutate_live_scribe */
    final class C05321 extends ViewType {
        C05321() {
        }

        public final View mo1995a(Context context) {
            return new InlineComposerV2HeaderView(context);
        }
    }

    /* compiled from: mutate_live_scribe */
    public class Props {
        public final boolean f13422a;
        public final InlineComposerModel f13423b;
        public final OnClickListener f13424c;
        public final CacheableEntity f13425d;
        public final CanRenderV2Prompt f13426e;
        public final boolean f13427f;

        public static Props m19775a(InlineComposerModel inlineComposerModel, CanRenderV2Prompt canRenderV2Prompt, boolean z, boolean z2) {
            boolean z3 = inlineComposerModel.f12909d && inlineComposerModel.f12911f && z;
            return new Props(z3, inlineComposerModel, null, canRenderV2Prompt, z2);
        }

        private Props(boolean z, InlineComposerModel inlineComposerModel, OnClickListener onClickListener, CanRenderV2Prompt canRenderV2Prompt, boolean z2) {
            this.f13422a = z;
            this.f13423b = inlineComposerModel;
            this.f13424c = onClickListener;
            this.f13425d = inlineComposerModel;
            this.f13426e = canRenderV2Prompt;
            this.f13427f = z2;
        }
    }

    /* compiled from: mutate_live_scribe */
    public class State {
        public final OnClickListener f14312a;
        public final boolean f14313b;

        public State(OnClickListener onClickListener, boolean z) {
            this.f14312a = onClickListener;
            this.f14313b = z;
        }
    }

    private static InlineComposerV2HeaderPartDefinition m19359b(InjectorLike injectorLike) {
        return new InlineComposerV2HeaderPartDefinition((Context) injectorLike.getInstance(Context.class), InlineComposerExposedBackgroundPartDefinition.m19366a(injectorLike), InlineComposerExposedTopGetterPartDefinition.m19371a(injectorLike), InlineComposerProfilePhotoPartDefinition.m19375a(injectorLike), TextPartDefinition.m19379a(injectorLike), InlineComposerPromptIconPartDefinition.m19382a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2347), InlineComposerLogger.m15507a(injectorLike), InlineComposerSproutUtil.m19486a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), IdBasedProvider.m1811a(injectorLike, 3137), InlineComposerGlyphsPartDefinition.m19489a(injectorLike), DefaultAnimationPartFactory.m19389a(injectorLike), InlineComposerPersistentStateHelper.m19394a(injectorLike), PromptsExperimentHelper.m15311a(injectorLike), InlineComposerPromptFlyoutPartDefinition.m19496a(injectorLike), JsonPluginConfigSerializer.m18628a(injectorLike), InlineComposerGoodFriendsPromptPartDefinition.m19522a(injectorLike), InlineComposerGoodFriendsPromptIconPartDefinition.m19530a(injectorLike), GoodFriendsFeedQEStore.m13839a(injectorLike), CreativeCamLauncherImpl.m19535a(injectorLike));
    }

    public static InlineComposerV2HeaderPartDefinition m19357a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerV2HeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13145z) {
                InlineComposerV2HeaderPartDefinition inlineComposerV2HeaderPartDefinition;
                if (a2 != null) {
                    inlineComposerV2HeaderPartDefinition = (InlineComposerV2HeaderPartDefinition) a2.mo818a(f13145z);
                } else {
                    inlineComposerV2HeaderPartDefinition = f13144y;
                }
                if (inlineComposerV2HeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19359b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13145z, b3);
                        } else {
                            f13144y = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerV2HeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1045485712);
        InlineComposerV2HeaderView inlineComposerV2HeaderView = (InlineComposerV2HeaderView) view;
        inlineComposerV2HeaderView.setOnClickListener(new C05971(inlineComposerV2HeaderView, ((State) obj2).f14312a));
        Resources resources = inlineComposerV2HeaderView.getResources();
        inlineComposerV2HeaderView.setSegmentedDivider(new ColorDrawable(resources.getColor(2131362050)));
        inlineComposerV2HeaderView.setSegmentedDividerThickness(resources.getDimensionPixelSize(2131427379));
        Logger.a(8, EntryType.MARK_POP, 468554106, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((InlineComposerV2HeaderView) view).setOnClickListener(null);
    }

    @Inject
    public InlineComposerV2HeaderPartDefinition(Context context, InlineComposerExposedBackgroundPartDefinition inlineComposerExposedBackgroundPartDefinition, InlineComposerExposedTopGetterPartDefinition inlineComposerExposedTopGetterPartDefinition, InlineComposerProfilePhotoPartDefinition inlineComposerProfilePhotoPartDefinition, TextPartDefinition textPartDefinition, InlineComposerPromptIconPartDefinition inlineComposerPromptIconPartDefinition, Provider<IFeedIntentBuilder> provider, InlineComposerLogger inlineComposerLogger, InlineComposerSproutUtil inlineComposerSproutUtil, QeAccessor qeAccessor, FeedComposerLauncherProvider feedComposerLauncherProvider, Provider<InlineComposerPromptViewController> provider2, InlineComposerGlyphsPartDefinition inlineComposerGlyphsPartDefinition, AnimationPartFactory animationPartFactory, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, PromptsExperimentHelper promptsExperimentHelper, InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, JsonPluginConfigSerializer jsonPluginConfigSerializer, InlineComposerGoodFriendsPromptPartDefinition inlineComposerGoodFriendsPromptPartDefinition, InlineComposerGoodFriendsPromptIconPartDefinition inlineComposerGoodFriendsPromptIconPartDefinition, GoodFriendsFeedQEStore goodFriendsFeedQEStore, CreativeCamLauncher creativeCamLauncher) {
        this.f13146b = context;
        this.f13147c = inlineComposerExposedBackgroundPartDefinition;
        this.f13148d = inlineComposerExposedTopGetterPartDefinition;
        this.f13149e = inlineComposerProfilePhotoPartDefinition;
        this.f13150f = textPartDefinition;
        this.f13151g = inlineComposerPromptIconPartDefinition;
        this.f13153i = provider;
        this.f13155k = feedComposerLauncherProvider;
        this.f13154j = inlineComposerLogger;
        this.f13156l = inlineComposerSproutUtil;
        this.f13157m = qeAccessor;
        this.f13158n = provider2;
        this.f13159o = inlineComposerGlyphsPartDefinition;
        this.f13161q = animationPartFactory;
        this.f13162r = inlineComposerPersistentStateHelper;
        this.f13163s = promptsExperimentHelper;
        this.f13164t = inlineComposerPromptFlyoutPartDefinition;
        this.f13165u = jsonPluginConfigSerializer;
        this.f13166v = inlineComposerGoodFriendsPromptPartDefinition;
        this.f13152h = inlineComposerGoodFriendsPromptIconPartDefinition;
        this.f13168x = goodFriendsFeedQEStore;
        this.f13167w = creativeCamLauncher;
    }

    public final ViewType mo2547a() {
        return f13143a;
    }

    public final boolean m19363a(Object obj) {
        return true;
    }

    private State m19356a(SubParts<E> subParts, Props props, E e) {
        OnClickListener onClickListener;
        OnClickListener onClickListener2;
        final InlineComposerModel inlineComposerModel = props.f13423b;
        final boolean h = inlineComposerModel.m18965h();
        if (props.f13424c != null) {
            onClickListener = props.f13424c;
        } else {
            final E e2 = e;
            Object c05932 = new OnClickListener(this) {
                final /* synthetic */ InlineComposerV2HeaderPartDefinition f14297d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -858199950);
                    this.f14297d.f13154j.m15510a();
                    if (h && this.f14297d.f13157m.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11361i, false)) {
                        int i;
                        if (e2.f12852r != null) {
                            SettableTopGetter settableTopGetter = e2.f12852r;
                            ((View) Preconditions.checkNotNull(settableTopGetter.f13177b)).getLocationOnScreen(settableTopGetter.f13176a);
                            i = settableTopGetter.f13176a[1];
                        } else {
                            i = 0;
                        }
                        this.f14297d.f13156l.m19487a(inlineComposerModel, this.f14297d.f13160p, i);
                    } else {
                        ImmutableList of;
                        FeedComposerLauncher a2 = this.f14297d.f13155k.m15515a(e2.m18900a(false), e2.f12848n);
                        GraphQLExploreFeed graphQLExploreFeed = inlineComposerModel.f12912g;
                        if (graphQLExploreFeed != null) {
                            of = ImmutableList.of(graphQLExploreFeed);
                        } else {
                            of = RegularImmutableList.f535a;
                        }
                        if (inlineComposerModel.f12919n) {
                            a2.a(Absent.INSTANCE, GoodFriendsComposerPluginConfig.a(inlineComposerModel.f12917l), this.f14297d.f13165u, this.f14297d.f13160p, of, graphQLExploreFeed);
                        } else {
                            a2.a(Absent.INSTANCE, this.f14297d.f13160p, of, graphQLExploreFeed);
                        }
                    }
                    LogUtils.a(1262615234, a);
                }
            };
        }
        Uri parse = Uri.parse(inlineComposerModel.m18961b());
        if (h && this.f13157m.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11361i, false)) {
            onClickListener2 = null;
        } else {
            onClickListener2 = new OnClickListener(this) {
                final /* synthetic */ InlineComposerV2HeaderPartDefinition f14299b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -898966258);
                    this.f14299b.f13154j.m15511a("tap_composer_profile_photo_from_feed");
                    ((IFeedIntentBuilder) this.f14299b.f13153i.get()).mo3016a(this.f14299b.f13146b, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, inlineComposerModel.f12906a));
                    Logger.a(2, EntryType.UI_INPUT_END, -500963464, a);
                }
            };
        }
        subParts.mo2756a(this.f13148d, null);
        if (props.f13423b.m18963f()) {
            subParts.mo2755a(2131561928, this.f13166v, null);
        }
        subParts.mo2755a(2131561926, this.f13149e, new com.facebook.feed.inlinecomposer.multirow.InlineComposerProfilePhotoPartDefinition.Props(parse, onClickListener2));
        subParts.mo2755a(2131561928, this.f13150f, inlineComposerModel.m18966n());
        CanRenderV2Prompt a = ((InlineComposerPromptViewController) this.f13158n.get()).m19563a(inlineComposerModel, ((HasContext) e).getContext());
        Object obj = (!props.f13422a || (this.f13163s.m15315d() && (a == null || props.f13423b.m18962c().f13411c.a.equals(PromptViewState$Visibility.MINIMIZED)))) ? 1 : null;
        SinglePartDefinition singlePartDefinition = this.f13147c;
        if (obj != null) {
            obj = com.facebook.feed.inlinecomposer.multirow.common.InlineComposerExposedBackgroundPartDefinition.Props.m20688b(props.f13427f);
        } else {
            obj = com.facebook.feed.inlinecomposer.multirow.common.InlineComposerExposedBackgroundPartDefinition.Props.m20687a(props.f13427f);
        }
        subParts.mo2756a(singlePartDefinition, obj);
        if (this.f13168x.m13845c() && inlineComposerModel.m18963f()) {
            subParts.mo2756a(this.f13152h, new 4(this, props));
        }
        boolean z = false;
        if (props.f13422a && inlineComposerModel.m18965h()) {
            boolean z2;
            if (a != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            V2Attachment g = a == null ? null : a.mo2631g();
            subParts.mo2756a(this.f13151g, new com.facebook.feed.inlinecomposer.multirow.InlineComposerPromptIconPartDefinition.Props(a, g, inlineComposerModel.m18962c(), this.f13162r.m19399b(props.f13423b.m18962c()), inlineComposerModel));
            if (!this.f13163s.m15315d()) {
                subParts.mo2756a(this.f13164t, new com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition.Props(a, g, props.f13423b.m18962c(), inlineComposerModel, this.f13162r.m19399b(props.f13423b.m18962c())));
                this.f13162r.m19397a(subParts, props.f13423b.m18962c(), props.f13425d, InlineComposerV2HeaderPartDefinition.class, new PromptHeaderAnimationBuilder(this.f13161q));
            }
            z = z2;
        }
        InlineComposerExperiment$ComposerGlyphType a2 = m19358a(z, props);
        if (a2 != InlineComposerExperiment$ComposerGlyphType.NONE) {
            subParts.mo2755a(2131561938, this.f13159o, a2);
        }
        return new State(onClickListener, z);
    }

    private InlineComposerExperiment$ComposerGlyphType m19358a(boolean z, Props props) {
        boolean z2 = false;
        if (this.f13168x.m13846d() && props.f13423b.f12919n) {
            return InlineComposerExperiment$ComposerGlyphType.DEFAULT;
        }
        if (!props.f13423b.f12911f) {
            return InlineComposerExperiment$ComposerGlyphType.NONE;
        }
        boolean a = this.f13157m.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11361i, false);
        boolean a2 = this.f13157m.mo596a(ExperimentsForFeedUtilComposerAbtestModule.ah, false);
        if (!a && !a2) {
            return InlineComposerExperiment$ComposerGlyphType.NONE;
        }
        if (!z || this.f13162r.m19399b(props.f13423b.f12908c)) {
            z2 = true;
        }
        if (!z2) {
            return InlineComposerExperiment$ComposerGlyphType.NONE;
        }
        InlineComposerExperiment$ComposerGlyphType inlineComposerExperiment$ComposerGlyphType = (InlineComposerExperiment$ComposerGlyphType) this.f13157m.mo578a(ExperimentsForFeedUtilComposerAbtestModule.af, InlineComposerExperiment$ComposerGlyphType.class, InlineComposerExperiment$ComposerGlyphType.DEFAULT);
        if (inlineComposerExperiment$ComposerGlyphType == null) {
            return InlineComposerExperiment$ComposerGlyphType.NONE;
        }
        return inlineComposerExperiment$ComposerGlyphType;
    }
}

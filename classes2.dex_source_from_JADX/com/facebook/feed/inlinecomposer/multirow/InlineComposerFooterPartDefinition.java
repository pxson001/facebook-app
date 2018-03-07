package com.facebook.feed.inlinecomposer.multirow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginConfig;
import com.facebook.feed.inlinecomposer.InlineComposerFooterView;
import com.facebook.feed.inlinecomposer.logging.InlineComposerLogger;
import com.facebook.feed.inlinecomposer.model.InlineComposerFooterState;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerBottomBackgroundPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.HasComposerLauncherContext;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.goodfriends.abtest.GoodFriendsFeedQEStore;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Absent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mutation */
public class InlineComposerFooterPartDefinition<E extends HasContext & HasComposerLauncherContext> extends MultiRowSinglePartDefinition<InlineComposerModel, InlineComposerFooterState, E, InlineComposerFooterView> {
    public static final ViewType f13121a = new C05311();
    private static final Props f13122b = new Props(2131362146, true, true);
    private static InlineComposerFooterPartDefinition f13123m;
    private static final Object f13124n = new Object();
    private final InlineComposerBottomBackgroundPartDefinition f13125c;
    private final ClickListenerPartDefinition f13126d;
    private final QeAccessor f13127e;
    private final Context f13128f;
    private final Locales f13129g;
    public final FeedPerfLogger f13130h;
    public final FeedComposerLauncherProvider f13131i;
    public final InlineComposerLogger f13132j;
    public final JsonPluginConfigSerializer f13133k;
    private final GoodFriendsFeedQEStore f13134l;

    /* compiled from: mutation */
    final class C05311 extends ViewType {
        C05311() {
        }

        public final View mo1995a(Context context) {
            return new InlineComposerFooterView(context);
        }
    }

    private static InlineComposerFooterPartDefinition m19339b(InjectorLike injectorLike) {
        return new InlineComposerFooterPartDefinition(InlineComposerBottomBackgroundPartDefinition.m19348a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class), Locales.m2604a(injectorLike), FeedPerfLogger.m3326a(injectorLike), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), InlineComposerLogger.m15507a(injectorLike), JsonPluginConfigSerializer.m18629b(injectorLike), GoodFriendsFeedQEStore.m13842b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object 5;
        InlineComposerModel inlineComposerModel = (InlineComposerModel) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        final Activity activity = (Activity) ContextUtils.m2500a(hasContext.getContext(), Activity.class);
        final GraphQLExploreFeed graphQLExploreFeed = inlineComposerModel.f12912g;
        subParts.mo2756a(this.f13125c, f13122b);
        subParts.mo2755a(2131561933, this.f13126d, m19337a(hasContext, activity, inlineComposerModel));
        subParts.mo2755a(2131561934, this.f13126d, new OnClickListener(this) {
            final /* synthetic */ InlineComposerFooterPartDefinition f14567d;

            public void onClick(View view) {
                ImmutableList of;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -735546662);
                this.f14567d.f13132j.m15513c();
                if (graphQLExploreFeed != null) {
                    of = ImmutableList.of(graphQLExploreFeed);
                } else {
                    of = RegularImmutableList.f535a;
                }
                this.f14567d.f13131i.m15515a(((InlineComposerEnvironment) hasContext).m18900a(true), ((InlineComposerEnvironment) hasContext).f12848n).b(Absent.INSTANCE, activity, of, graphQLExploreFeed);
                LogUtils.a(-1622120085, a);
            }
        });
        SinglePartDefinition singlePartDefinition = this.f13126d;
        if (inlineComposerModel.f12920o) {
            5 = new 5(this, hasContext, activity);
        } else {
            C06124 c06124 = new OnClickListener(this) {
                final /* synthetic */ InlineComposerFooterPartDefinition f14571d;

                public void onClick(View view) {
                    ImmutableList of;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -301957513);
                    this.f14571d.f13132j.m15514d();
                    if (graphQLExploreFeed != null) {
                        of = ImmutableList.of(graphQLExploreFeed);
                    } else {
                        of = RegularImmutableList.f535a;
                    }
                    this.f14571d.f13131i.m15515a(((InlineComposerEnvironment) hasContext).m18900a(true), ((InlineComposerEnvironment) hasContext).f12848n).d(Absent.INSTANCE, activity, of, graphQLExploreFeed);
                    LogUtils.a(-1481270544, a);
                }
            };
        }
        subParts.mo2755a(2131561935, singlePartDefinition, 5);
        return InlineComposerFooterState.m20988a(this.f13128f.getResources(), inlineComposerModel, this.f13129g);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1348535132);
        InlineComposerFooterState inlineComposerFooterState = (InlineComposerFooterState) obj2;
        InlineComposerFooterView inlineComposerFooterView = (InlineComposerFooterView) view;
        if (((InlineComposerModel) obj).f12910e) {
            inlineComposerFooterView.setCheckinButtonVisibility(0);
        } else {
            inlineComposerFooterView.setCheckinButtonVisibility(8);
        }
        inlineComposerFooterView.m20979a(inlineComposerFooterState.f14573b, inlineComposerFooterState.f14572a, inlineComposerFooterState.f14574c);
        if (inlineComposerFooterState.f14575d != null) {
            inlineComposerFooterView.setCheckinButtonDrawable(inlineComposerFooterState.f14575d);
        }
        FeedPerfLogger feedPerfLogger = this.f13130h;
        feedPerfLogger.f1675j.m3446c(655515, "NNFColdLoadInlineComposerAfterLoggedIn");
        feedPerfLogger.f1675j.m3456f(655516, "NNFWarmLoadInlineComposerAfterLoggedIn");
        feedPerfLogger.f1683r.m4213g();
        Logger.a(8, EntryType.MARK_POP, -1835541167, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((InlineComposerFooterView) view).setCheckinButtonVisibility(0);
    }

    public static InlineComposerFooterPartDefinition m19338a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13124n) {
                InlineComposerFooterPartDefinition inlineComposerFooterPartDefinition;
                if (a2 != null) {
                    inlineComposerFooterPartDefinition = (InlineComposerFooterPartDefinition) a2.mo818a(f13124n);
                } else {
                    inlineComposerFooterPartDefinition = f13123m;
                }
                if (inlineComposerFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19339b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13124n, b3);
                        } else {
                            f13123m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerFooterPartDefinition(InlineComposerBottomBackgroundPartDefinition inlineComposerBottomBackgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, QeAccessor qeAccessor, Context context, Locales locales, FeedPerfLogger feedPerfLogger, FeedComposerLauncherProvider feedComposerLauncherProvider, InlineComposerLogger inlineComposerLogger, JsonPluginConfigSerializer jsonPluginConfigSerializer, GoodFriendsFeedQEStore goodFriendsFeedQEStore) {
        this.f13125c = inlineComposerBottomBackgroundPartDefinition;
        this.f13126d = clickListenerPartDefinition;
        this.f13127e = qeAccessor;
        this.f13128f = context;
        this.f13129g = locales;
        this.f13130h = feedPerfLogger;
        this.f13131i = feedComposerLauncherProvider;
        this.f13132j = inlineComposerLogger;
        this.f13133k = jsonPluginConfigSerializer;
        this.f13134l = goodFriendsFeedQEStore;
    }

    public final ViewType mo2547a() {
        return f13121a;
    }

    public final boolean m19343a(InlineComposerModel inlineComposerModel) {
        if (this.f13127e.mo596a(ExperimentsForFeedUtilComposerAbtestModule.ah, false)) {
            return false;
        }
        if (inlineComposerModel.f12919n && !this.f13134l.m13844b()) {
            return false;
        }
        if (inlineComposerModel.f12911f && this.f13127e.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11361i, false)) {
            return false;
        }
        return true;
    }

    private OnClickListener m19337a(E e, Activity activity, InlineComposerModel inlineComposerModel) {
        final GraphQLExploreFeed graphQLExploreFeed = inlineComposerModel.f12912g;
        final E e2 = e;
        final InlineComposerModel inlineComposerModel2 = inlineComposerModel;
        final Activity activity2 = activity;
        return new OnClickListener(this) {
            final /* synthetic */ InlineComposerFooterPartDefinition f14563e;

            public void onClick(View view) {
                ImmutableList of;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1841700771);
                this.f14563e.f13132j.m15512b();
                FeedComposerLauncher a2 = this.f14563e.f13131i.m15515a(((InlineComposerEnvironment) e2).m18900a(true), ((InlineComposerEnvironment) e2).f12848n);
                if (graphQLExploreFeed != null) {
                    of = ImmutableList.of(graphQLExploreFeed);
                } else {
                    of = RegularImmutableList.f535a;
                }
                if (inlineComposerModel2.f12919n) {
                    a2.a(Absent.INSTANCE, GoodFriendsComposerPluginConfig.a(inlineComposerModel2.f12917l), this.f14563e.f13133k, activity2, of, graphQLExploreFeed);
                } else {
                    a2.a(Absent.INSTANCE, activity2, of, graphQLExploreFeed);
                }
                LogUtils.a(73228149, a);
            }
        };
    }
}

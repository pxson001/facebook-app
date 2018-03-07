package com.facebook.search.results.rows.sections.composer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.minutiae.intent.SingleMinutiaeFetcher;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsComposerUnit;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: REACTION_HSCROLL_COMPONENT_IMPRESSION */
public class SearchComposerSinglePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsComposerUnit>, DraweeController, HasPositionInformation, SearchComposerView> {
    public static final ViewType f24052a = new C25601();
    private static final CallerContext f24053b = CallerContext.a(SearchComposerView.class, "graph_search_results_page");
    private static SearchComposerSinglePartDefinition f24054o;
    private static final Object f24055p = new Object();
    public final Context f24056c;
    private final BackgroundPartDefinition f24057d;
    private final ClickListenerPartDefinition f24058e;
    private final TextPartDefinition f24059f;
    private final Provider<FbDraweeControllerBuilder> f24060g;
    private final LoggedInUserSessionManager f24061h;
    public final ComposerIntentLauncher f24062i;
    private final ComposerLauncher f24063j;
    private final ExecutorService f24064k;
    private final ExecutorService f24065l;
    public final SingleMinutiaeFetcher f24066m;
    public final AtomicBoolean f24067n = new AtomicBoolean();

    /* compiled from: REACTION_HSCROLL_COMPONENT_IMPRESSION */
    final class C25601 extends ViewType {
        C25601() {
        }

        public final View m27614a(Context context) {
            return new SearchComposerView(context);
        }
    }

    /* compiled from: REACTION_HSCROLL_COMPONENT_IMPRESSION */
    public class C25623 implements OnClickListener {
        final /* synthetic */ SearchComposerSinglePartDefinition f24046a;

        public C25623(SearchComposerSinglePartDefinition searchComposerSinglePartDefinition) {
            this.f24046a = searchComposerSinglePartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2076615397);
            SearchComposerSinglePartDefinition searchComposerSinglePartDefinition = this.f24046a;
            Context context = searchComposerSinglePartDefinition.f24056c;
            Builder builder = new Builder(SimplePickerSource.SEARCH);
            builder.a = ComposerConfigurationFactory.a(ComposerSourceSurface.SEARCH, "keywordSearchPhoto").setIsFireAndForget(true).a();
            Intent a2 = SimplePickerIntent.a(context, builder.o().p());
            ComposerIntentLauncher composerIntentLauncher = searchComposerSinglePartDefinition.f24062i;
            composerIntentLauncher.c.a(composerIntentLauncher.a, "ComposerIntentLauncher");
            composerIntentLauncher.b.a(ComposerIntentLauncher.b(a2), composerIntentLauncher.a);
            Logger.a(2, EntryType.UI_INPUT_END, 1377542860, a);
        }
    }

    private static SearchComposerSinglePartDefinition m27619b(InjectorLike injectorLike) {
        return new SearchComposerSinglePartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), IdBasedProvider.a(injectorLike, 1117), ComposerIntentLauncher.b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), SingleMinutiaeFetcher.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    public final Object m27623a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        final SearchResultsComposerUnit searchResultsComposerUnit = (SearchResultsComposerUnit) ((FeedProps) obj).a;
        m27620b(searchResultsComposerUnit);
        subParts.a(this.f24057d, new StylingData(null, PaddingStyle.q, Position.BOX));
        subParts.a(this.f24058e, new OnClickListener(this) {
            final /* synthetic */ SearchComposerSinglePartDefinition f24045b;

            public void onClick(View view) {
                Object obj;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1185922508);
                SingleMinutiaeFetcher singleMinutiaeFetcher = this.f24045b.f24066m;
                String str = "fetch_composer_in_tnv2_search_results";
                if (singleMinutiaeFetcher.b.b(str) == null || singleMinutiaeFetcher.b.b(str).isDone()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    this.f24045b.f24067n.set(true);
                } else {
                    SearchComposerSinglePartDefinition.m27621c(this.f24045b, searchResultsComposerUnit);
                }
                LogUtils.a(-151933510, a);
            }
        });
        subParts.a(2131564232, this.f24058e, new C25623(this));
        TextPartDefinition textPartDefinition = this.f24059f;
        if (searchResultsComposerUnit != null) {
            obj2 = searchResultsComposerUnit.f23470a;
        } else {
            obj2 = "";
        }
        subParts.a(2131558966, textPartDefinition, obj2);
        String x = this.f24061h.c().x();
        if (x == null) {
            return null;
        }
        return ((FbDraweeControllerBuilder) this.f24060g.get()).a(f24053b).b(Uri.parse(x)).s();
    }

    public final /* bridge */ /* synthetic */ void m27624a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 446542688);
        DraweeController draweeController = (DraweeController) obj2;
        SearchComposerView searchComposerView = (SearchComposerView) view;
        searchComposerView.f24068a = false;
        if (draweeController != null) {
            searchComposerView.f24070c.setController(draweeController);
        }
        Logger.a(8, EntryType.MARK_POP, -101589741, a);
    }

    public static SearchComposerSinglePartDefinition m27617a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchComposerSinglePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24055p) {
                SearchComposerSinglePartDefinition searchComposerSinglePartDefinition;
                if (a2 != null) {
                    searchComposerSinglePartDefinition = (SearchComposerSinglePartDefinition) a2.a(f24055p);
                } else {
                    searchComposerSinglePartDefinition = f24054o;
                }
                if (searchComposerSinglePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27619b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24055p, b3);
                        } else {
                            f24054o = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchComposerSinglePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m27620b(final SearchResultsComposerUnit searchResultsComposerUnit) {
        if (searchResultsComposerUnit.f23474e == null) {
            this.f24066m.a("fetch_composer_in_tnv2_search_results", this.f24064k, searchResultsComposerUnit.f23471b, searchResultsComposerUnit.f23472c, new AbstractDisposableFutureCallback<MinutiaeObject>(this) {
                final /* synthetic */ SearchComposerSinglePartDefinition f24048b;

                protected final void m27615a(Object obj) {
                    SearchComposerSinglePartDefinition.m27618a(this.f24048b, (MinutiaeObject) obj, searchResultsComposerUnit);
                }

                protected final void m27616a(Throwable th) {
                    SearchComposerSinglePartDefinition.m27618a(this.f24048b, null, searchResultsComposerUnit);
                }
            });
        }
    }

    @Inject
    public SearchComposerSinglePartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Provider<FbDraweeControllerBuilder> provider, ComposerIntentLauncher composerIntentLauncher, ComposerLauncher composerLauncher, SingleMinutiaeFetcher singleMinutiaeFetcher, ExecutorService executorService, ExecutorService executorService2) {
        this.f24056c = context;
        this.f24057d = backgroundPartDefinition;
        this.f24058e = clickListenerPartDefinition;
        this.f24059f = textPartDefinition;
        this.f24060g = provider;
        this.f24061h = loggedInUserAuthDataStore;
        this.f24062i = composerIntentLauncher;
        this.f24063j = composerLauncher;
        this.f24066m = singleMinutiaeFetcher;
        this.f24064k = executorService;
        this.f24065l = executorService2;
    }

    public final ViewType m27622a() {
        return f24052a;
    }

    public final boolean m27625a(Object obj) {
        return true;
    }

    public static void m27618a(SearchComposerSinglePartDefinition searchComposerSinglePartDefinition, final MinutiaeObject minutiaeObject, final SearchResultsComposerUnit searchResultsComposerUnit) {
        ExecutorDetour.a(searchComposerSinglePartDefinition.f24065l, new Runnable(searchComposerSinglePartDefinition) {
            final /* synthetic */ SearchComposerSinglePartDefinition f24051c;

            public void run() {
                searchResultsComposerUnit.f23474e = minutiaeObject;
                if (this.f24051c.f24067n.get()) {
                    SearchComposerSinglePartDefinition.m27621c(this.f24051c, searchResultsComposerUnit);
                }
            }
        }, 480767261);
    }

    public static void m27621c(SearchComposerSinglePartDefinition searchComposerSinglePartDefinition, SearchResultsComposerUnit searchResultsComposerUnit) {
        ComposerConfiguration.Builder isFireAndForget = ComposerConfigurationFactory.a(ComposerSourceSurface.SEARCH, "keywordSearchStatus").setInitialTargetData(ComposerTargetData.a).setIsFireAndForget(true);
        if (searchResultsComposerUnit.f23474e != null) {
            isFireAndForget.setMinutiaeObjectTag(searchResultsComposerUnit.f23474e);
        }
        searchComposerSinglePartDefinition.f24063j.a(null, isFireAndForget.a(), searchComposerSinglePartDefinition.f24056c);
    }
}

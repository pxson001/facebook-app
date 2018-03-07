package com.facebook.search.results.rows.sections.pulse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.base.footer.rows.FooterButtonClickListenerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.environment.CanReplaceSearchResult;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROGRESS */
public class PulseContextFooterButtonsConvertedPartDefinition<E extends HasSearchResultsContext & HasSearchResultPosition & HasInvalidate & CanReplaceSearchResult & HasContext> extends BaseSinglePartDefinition<SearchResultsProps<SearchResultsArticleExternalUrl>, SaveButtonState, E, PulseContextFooterView> {
    private static PulseContextFooterButtonsConvertedPartDefinition f24760i;
    private static final Object f24761j = new Object();
    private final FooterButtonClickListenerPartDefinition f24762a;
    public final ComposerLauncher f24763b;
    public final Activity f24764c;
    private final SecureContextHelper f24765d;
    private final UpdateSavedStateUtils f24766e;
    public final Toaster f24767f;
    public final SearchResultsLogger f24768g;
    public final GlyphColorizer f24769h;

    /* compiled from: PROGRESS */
    /* synthetic */ class C26122 {
        static final /* synthetic */ int[] f24751a = new int[FooterButtonId.values().length];

        static {
            try {
                f24751a[FooterButtonId.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24751a[FooterButtonId.VISIT_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24751a[FooterButtonId.SAVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: PROGRESS */
    class SaveButtonResultCallBack extends OperationResultFutureCallback {
        final /* synthetic */ PulseContextFooterButtonsConvertedPartDefinition f24752a;
        private final E f24753b;
        private final SearchResultsEdgeModel f24754c;
        private final SearchResultsEdgeModel f24755d;
        private final int f24756e;
        private final int f24757f;

        public SaveButtonResultCallBack(PulseContextFooterButtonsConvertedPartDefinition pulseContextFooterButtonsConvertedPartDefinition, SearchResultsEdge searchResultsEdge, SearchResultsEdge searchResultsEdge2, E e, boolean z) {
            this.f24752a = pulseContextFooterButtonsConvertedPartDefinition;
            this.f24753b = e;
            this.f24754c = searchResultsEdge;
            this.f24755d = searchResultsEdge2;
            if (z) {
                this.f24756e = 2131236854;
                this.f24757f = 2131236856;
                return;
            }
            this.f24756e = 2131239034;
            this.f24757f = 2131239035;
        }

        protected final void m28163a(ServiceException serviceException) {
            this.f24752a.f24767f.b(new ToastBuilder(this.f24757f));
            PulseContextFooterButtonsConvertedPartDefinition pulseContextFooterButtonsConvertedPartDefinition = this.f24752a;
            PulseContextFooterButtonsConvertedPartDefinition.m28166a(this.f24755d, this.f24754c, this.f24753b);
        }

        protected final void m28164a(Object obj) {
            this.f24752a.f24767f.b(new ToastBuilder(this.f24756e));
        }
    }

    /* compiled from: PROGRESS */
    public class SaveButtonState {
        public final Drawable f24758a;
        public final String f24759b;

        public SaveButtonState(Drawable drawable, String str) {
            this.f24758a = drawable;
            this.f24759b = str;
        }
    }

    private static PulseContextFooterButtonsConvertedPartDefinition m28171b(InjectorLike injectorLike) {
        return new PulseContextFooterButtonsConvertedPartDefinition(FooterButtonClickListenerPartDefinition.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ActivityMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), UpdateSavedStateUtils.a(injectorLike), Toaster.b(injectorLike), SearchResultsLogger.m25460a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m28172a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SaveButtonState saveButtonState;
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasSearchResultsContext hasSearchResultsContext = (HasSearchResultsContext) anyEnvironment;
        subParts.a(this.f24762a, new ButtonClickedListener(this) {
            final /* synthetic */ PulseContextFooterButtonsConvertedPartDefinition f24750c;

            public final void m28162a(View view, FooterButtonId footerButtonId) {
                PulseContextFooterButtonsConvertedPartDefinition.m28167a(this.f24750c, footerButtonId, searchResultsProps, hasSearchResultsContext);
            }
        });
        Context context = ((HasContext) hasSearchResultsContext).getContext();
        if (m28170a((SearchResultsArticleExternalUrl) searchResultsProps.f23388a)) {
            saveButtonState = new SaveButtonState(this.f24769h.a(2130839719, -10972929), context.getString(2131239032));
        } else {
            saveButtonState = new SaveButtonState(this.f24769h.a(2130839719, ContextUtils.c(context, 2130772570, -7235677)), context.getString(2131239031));
        }
        return saveButtonState;
    }

    public static PulseContextFooterButtonsConvertedPartDefinition m28165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextFooterButtonsConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24761j) {
                PulseContextFooterButtonsConvertedPartDefinition pulseContextFooterButtonsConvertedPartDefinition;
                if (a2 != null) {
                    pulseContextFooterButtonsConvertedPartDefinition = (PulseContextFooterButtonsConvertedPartDefinition) a2.a(f24761j);
                } else {
                    pulseContextFooterButtonsConvertedPartDefinition = f24760i;
                }
                if (pulseContextFooterButtonsConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28171b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24761j, b3);
                        } else {
                            f24760i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextFooterButtonsConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseContextFooterButtonsConvertedPartDefinition(FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition, ComposerLauncher composerLauncher, Activity activity, SecureContextHelper secureContextHelper, UpdateSavedStateUtils updateSavedStateUtils, Toaster toaster, SearchResultsLogger searchResultsLogger, GlyphColorizer glyphColorizer) {
        this.f24762a = footerButtonClickListenerPartDefinition;
        this.f24763b = composerLauncher;
        this.f24764c = activity;
        this.f24765d = secureContextHelper;
        this.f24766e = updateSavedStateUtils;
        this.f24767f = toaster;
        this.f24768g = searchResultsLogger;
        this.f24769h = glyphColorizer;
    }

    public static void m28167a(PulseContextFooterButtonsConvertedPartDefinition pulseContextFooterButtonsConvertedPartDefinition, FooterButtonId footerButtonId, SearchResultsProps searchResultsProps, HasSearchResultsContext hasSearchResultsContext) {
        String v = ((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).mo593v();
        int a = ((HasSearchResultPosition) hasSearchResultsContext).mo1246a(searchResultsProps);
        SearchResultsMutableContext s = hasSearchResultsContext.mo1248s();
        switch (C26122.f24751a[footerButtonId.ordinal()]) {
            case 1:
                pulseContextFooterButtonsConvertedPartDefinition.f24768g.m25474a(s, a, StoryAction.SHARE, (String) searchResultsProps.f23391d.orNull());
                pulseContextFooterButtonsConvertedPartDefinition.f24763b.a(null, ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "pulseContextFooterButtonsConverted").setInitialShareParams(Builder.a(v).b()).a(), 1756, pulseContextFooterButtonsConvertedPartDefinition.f24764c);
                return;
            case 2:
                pulseContextFooterButtonsConvertedPartDefinition.m28169a(v, searchResultsProps, s, a);
                return;
            case 3:
                pulseContextFooterButtonsConvertedPartDefinition.m28168a(v, searchResultsProps, hasSearchResultsContext);
                return;
            default:
                return;
        }
    }

    private void m28168a(String str, SearchResultsProps<SearchResultsArticleExternalUrl> searchResultsProps, E e) {
        if (m28170a((SearchResultsArticleExternalUrl) searchResultsProps.f23388a)) {
            this.f24768g.m25474a(e.mo1248s(), ((HasSearchResultPosition) e).mo1246a((SearchResultsProps) searchResultsProps), StoryAction.UNSAVE, (String) searchResultsProps.f23391d.orNull());
            SearchResultsEdgeModel a = SearchResultsArticleExternalUrlUtil.m28286a(searchResultsProps, GraphQLSavedState.NOT_SAVED);
            m28166a(searchResultsProps.f23390c, a, (HasSearchResultsContext) e);
            this.f24766e.f(str, CurationSurface.NATIVE_PULSE, CurationMechanism.TOGGLE_BUTTON, new SaveButtonResultCallBack(this, searchResultsProps.f23390c, a, e, false));
            return;
        }
        this.f24768g.m25474a(e.mo1248s(), ((HasSearchResultPosition) e).mo1246a((SearchResultsProps) searchResultsProps), StoryAction.SAVE, (String) searchResultsProps.f23391d.orNull());
        a = SearchResultsArticleExternalUrlUtil.m28286a(searchResultsProps, GraphQLSavedState.SAVED);
        m28166a(searchResultsProps.f23390c, a, (HasSearchResultsContext) e);
        this.f24766e.e(str, CurationSurface.NATIVE_PULSE, CurationMechanism.TOGGLE_BUTTON, new SaveButtonResultCallBack(this, searchResultsProps.f23390c, a, e, true));
    }

    private void m28169a(String str, SearchResultsProps<SearchResultsArticleExternalUrl> searchResultsProps, SearchResultsContext searchResultsContext, int i) {
        this.f24768g.m25474a((SearchResultsMutableContext) searchResultsContext, i, StoryAction.OPEN_LINK, (String) searchResultsProps.f23391d.orNull());
        this.f24765d.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)), this.f24764c);
    }

    public static boolean m28170a(SearchResultsArticleExternalUrl searchResultsArticleExternalUrl) {
        GraphQLSavedState d = searchResultsArticleExternalUrl.mo574E() != null ? searchResultsArticleExternalUrl.mo574E().m10469d() : null;
        if (d == null) {
            return false;
        }
        if (d == GraphQLSavedState.SAVED || d == GraphQLSavedState.ARCHIVED) {
            return true;
        }
        return false;
    }

    public static void m28166a(SearchResultsEdge searchResultsEdge, SearchResultsEdge searchResultsEdge2, E e) {
        if (searchResultsEdge2 != null) {
            ((CanReplaceSearchResult) e).mo1243a(searchResultsEdge, searchResultsEdge2);
            ((HasInvalidate) e).hL_();
        }
    }
}

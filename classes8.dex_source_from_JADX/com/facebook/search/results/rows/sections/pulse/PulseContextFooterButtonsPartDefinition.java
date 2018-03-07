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
import com.facebook.search.results.environment.CanReplaceFeedItem;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: PROFILE_TAP */
public class PulseContextFooterButtonsPartDefinition<E extends HasSearchResultsContext & HasFeedItemPosition & HasInvalidate & CanReplaceFeedItem & HasContext> extends BaseSinglePartDefinition<SearchResultsPulseContextUnit, SaveButtonState, E, PulseContextFooterView> {
    private static PulseContextFooterButtonsPartDefinition f24782i;
    private static final Object f24783j = new Object();
    private final FooterButtonClickListenerPartDefinition f24784a;
    public final ComposerLauncher f24785b;
    public final Activity f24786c;
    private final SecureContextHelper f24787d;
    private final UpdateSavedStateUtils f24788e;
    public final Toaster f24789f;
    public final SearchResultsLogger f24790g;
    public final GlyphColorizer f24791h;

    /* compiled from: PROFILE_TAP */
    /* synthetic */ class C26142 {
        static final /* synthetic */ int[] f24773a = new int[FooterButtonId.values().length];

        static {
            try {
                f24773a[FooterButtonId.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24773a[FooterButtonId.VISIT_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24773a[FooterButtonId.SAVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: PROFILE_TAP */
    class SaveButtonResultCallBack extends OperationResultFutureCallback {
        final /* synthetic */ PulseContextFooterButtonsPartDefinition f24774a;
        private final E f24775b;
        private final SearchResultsPulseContextUnit f24776c;
        private final SearchResultsPulseContextUnit f24777d;
        private final int f24778e;
        private final int f24779f;

        public SaveButtonResultCallBack(PulseContextFooterButtonsPartDefinition pulseContextFooterButtonsPartDefinition, SearchResultsPulseContextUnit searchResultsPulseContextUnit, SearchResultsPulseContextUnit searchResultsPulseContextUnit2, E e, boolean z) {
            this.f24774a = pulseContextFooterButtonsPartDefinition;
            this.f24775b = e;
            this.f24776c = searchResultsPulseContextUnit;
            this.f24777d = searchResultsPulseContextUnit2;
            if (z) {
                this.f24778e = 2131236854;
                this.f24779f = 2131236856;
                return;
            }
            this.f24778e = 2131239034;
            this.f24779f = 2131239035;
        }

        protected final void m28175a(ServiceException serviceException) {
            this.f24774a.f24789f.b(new ToastBuilder(this.f24779f));
            PulseContextFooterButtonsPartDefinition pulseContextFooterButtonsPartDefinition = this.f24774a;
            PulseContextFooterButtonsPartDefinition.m28178a(this.f24777d, this.f24776c, this.f24775b);
        }

        protected final void m28176a(Object obj) {
            this.f24774a.f24789f.b(new ToastBuilder(this.f24778e));
        }
    }

    /* compiled from: PROFILE_TAP */
    public class SaveButtonState {
        public final Drawable f24780a;
        public final String f24781b;

        public SaveButtonState(Drawable drawable, String str) {
            this.f24780a = drawable;
            this.f24781b = str;
        }
    }

    private static PulseContextFooterButtonsPartDefinition m28183b(InjectorLike injectorLike) {
        return new PulseContextFooterButtonsPartDefinition(FooterButtonClickListenerPartDefinition.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ActivityMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), UpdateSavedStateUtils.a(injectorLike), Toaster.b(injectorLike), SearchResultsLogger.m25460a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m28184a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SaveButtonState saveButtonState;
        final SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        final HasSearchResultsContext hasSearchResultsContext = (HasSearchResultsContext) anyEnvironment;
        subParts.a(this.f24784a, new ButtonClickedListener(this) {
            final /* synthetic */ PulseContextFooterButtonsPartDefinition f24772c;

            public final void m28174a(View view, FooterButtonId footerButtonId) {
                PulseContextFooterButtonsPartDefinition.m28179a(this.f24772c, footerButtonId, searchResultsPulseContextUnit, hasSearchResultsContext);
            }
        });
        Context context = ((HasContext) hasSearchResultsContext).getContext();
        if (m28182a(searchResultsPulseContextUnit)) {
            saveButtonState = new SaveButtonState(this.f24791h.a(2130839719, -10972929), context.getString(2131239032));
        } else {
            saveButtonState = new SaveButtonState(this.f24791h.a(2130839719, ContextUtils.c(context, 2130772570, -7235677)), context.getString(2131239031));
        }
        return saveButtonState;
    }

    public static PulseContextFooterButtonsPartDefinition m28177a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextFooterButtonsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24783j) {
                PulseContextFooterButtonsPartDefinition pulseContextFooterButtonsPartDefinition;
                if (a2 != null) {
                    pulseContextFooterButtonsPartDefinition = (PulseContextFooterButtonsPartDefinition) a2.a(f24783j);
                } else {
                    pulseContextFooterButtonsPartDefinition = f24782i;
                }
                if (pulseContextFooterButtonsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28183b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24783j, b3);
                        } else {
                            f24782i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextFooterButtonsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseContextFooterButtonsPartDefinition(FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition, ComposerLauncher composerLauncher, Activity activity, SecureContextHelper secureContextHelper, UpdateSavedStateUtils updateSavedStateUtils, Toaster toaster, SearchResultsLogger searchResultsLogger, GlyphColorizer glyphColorizer) {
        this.f24784a = footerButtonClickListenerPartDefinition;
        this.f24785b = composerLauncher;
        this.f24786c = activity;
        this.f24787d = secureContextHelper;
        this.f24788e = updateSavedStateUtils;
        this.f24789f = toaster;
        this.f24790g = searchResultsLogger;
        this.f24791h = glyphColorizer;
    }

    public static void m28179a(PulseContextFooterButtonsPartDefinition pulseContextFooterButtonsPartDefinition, FooterButtonId footerButtonId, SearchResultsPulseContextUnit searchResultsPulseContextUnit, HasSearchResultsContext hasSearchResultsContext) {
        String m = searchResultsPulseContextUnit.m27180m();
        int a = ((HasFeedItemPosition) hasSearchResultsContext).mo1245a(searchResultsPulseContextUnit);
        SearchResultsMutableContext s = hasSearchResultsContext.mo1248s();
        String str = (String) searchResultsPulseContextUnit.mo1322l().orNull();
        switch (C26142.f24773a[footerButtonId.ordinal()]) {
            case 1:
                pulseContextFooterButtonsPartDefinition.f24790g.m25474a(s, a, StoryAction.SHARE, str);
                pulseContextFooterButtonsPartDefinition.f24785b.a(null, ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "pulseContextFooterButtons").setInitialShareParams(Builder.a(m).b()).a(), 1756, pulseContextFooterButtonsPartDefinition.f24786c);
                return;
            case 2:
                pulseContextFooterButtonsPartDefinition.m28180a(m, s, a, str);
                return;
            case 3:
                pulseContextFooterButtonsPartDefinition.m28181a(m, searchResultsPulseContextUnit, hasSearchResultsContext, str);
                return;
            default:
                return;
        }
    }

    private void m28181a(String str, SearchResultsPulseContextUnit searchResultsPulseContextUnit, E e, @Nullable String str2) {
        if (m28182a(searchResultsPulseContextUnit)) {
            this.f24790g.m25474a(e.mo1248s(), ((HasFeedItemPosition) e).mo1245a(searchResultsPulseContextUnit), StoryAction.UNSAVE, str2);
            SearchResultsPulseContextUnit a = searchResultsPulseContextUnit.m27176a(GraphQLSavedState.NOT_SAVED);
            m28178a(searchResultsPulseContextUnit, a, (HasSearchResultsContext) e);
            this.f24788e.f(str, CurationSurface.NATIVE_WEB_VIEW, CurationMechanism.SAVED_ADD, new SaveButtonResultCallBack(this, searchResultsPulseContextUnit, a, e, false));
            return;
        }
        this.f24790g.m25474a(e.mo1248s(), ((HasFeedItemPosition) e).mo1245a(searchResultsPulseContextUnit), StoryAction.SAVE, str2);
        a = searchResultsPulseContextUnit.m27176a(GraphQLSavedState.SAVED);
        m28178a(searchResultsPulseContextUnit, a, (HasSearchResultsContext) e);
        this.f24788e.e(str, CurationSurface.NATIVE_WEB_VIEW, CurationMechanism.SAVED_ADD, new SaveButtonResultCallBack(this, searchResultsPulseContextUnit, a, e, true));
    }

    private void m28180a(String str, SearchResultsMutableContext searchResultsMutableContext, int i, @Nullable String str2) {
        this.f24790g.m25474a(searchResultsMutableContext, i, StoryAction.OPEN_LINK, str2);
        this.f24787d.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)), this.f24786c);
    }

    public static boolean m28182a(SearchResultsPulseContextUnit searchResultsPulseContextUnit) {
        if (searchResultsPulseContextUnit.m27183p() != null) {
            return searchResultsPulseContextUnit.m27183p() == GraphQLSavedState.SAVED || searchResultsPulseContextUnit.m27183p() == GraphQLSavedState.ARCHIVED;
        } else {
            return false;
        }
    }

    public static void m28178a(SearchResultsPulseContextUnit searchResultsPulseContextUnit, SearchResultsPulseContextUnit searchResultsPulseContextUnit2, E e) {
        if (searchResultsPulseContextUnit2 != null) {
            ((CanReplaceFeedItem) e).mo1241a(searchResultsPulseContextUnit, searchResultsPulseContextUnit2);
            ((HasInvalidate) e).hL_();
        }
    }
}

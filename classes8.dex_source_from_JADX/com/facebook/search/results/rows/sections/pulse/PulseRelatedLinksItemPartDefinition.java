package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.collection.SearchResultsExternalUrlContentViewMetaPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsExternalUrlContentViewSubtitlePartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIORITY_FB_TOKEN_1 */
public class PulseRelatedLinksItemPartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultsContext & OldCanLogEntityNavigation> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentView> {
    public static final ViewType f24870a = new C26201();
    private static final PaddingStyle f24871b;
    private static PulseRelatedLinksItemPartDefinition f24872m;
    private static final Object f24873n = new Object();
    public final SearchResultsIntentBuilder f24874c;
    public final SecureContextHelper f24875d;
    private final BackgroundPartDefinition f24876e;
    private final ContentViewTitlePartDefinition f24877f;
    private final SearchResultsExternalUrlContentViewSubtitlePartDefinition f24878g;
    private final ContentViewThumbnailUriStringPartDefinition f24879h;
    private final SearchResultsExternalUrlContentViewMetaPartDefinition f24880i;
    private final ClickListenerPartDefinition f24881j;
    public final FbUriIntentHandler f24882k;
    public final QeAccessor f24883l;

    /* compiled from: PRIORITY_FB_TOKEN_1 */
    final class C26201 extends ViewType {
        C26201() {
        }

        public final View m28242a(Context context) {
            return LayoutInflater.from(context).inflate(2130906519, null);
        }
    }

    private static PulseRelatedLinksItemPartDefinition m28245b(InjectorLike injectorLike) {
        return new PulseRelatedLinksItemPartDefinition(SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), SearchResultsExternalUrlContentViewSubtitlePartDefinition.m27391a(injectorLike), ContentViewThumbnailUriStringPartDefinition.a(injectorLike), SearchResultsExternalUrlContentViewMetaPartDefinition.m27387a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m28247a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24876e, new StylingData(f24871b));
        subParts.a(this.f24877f, graphQLNode.it().a());
        subParts.a(this.f24878g, graphQLNode);
        subParts.a(this.f24880i, graphQLNode);
        subParts.a(this.f24879h, ((GraphQLImage) Preconditions.checkNotNull(((GraphQLMedia) Preconditions.checkNotNull(graphQLNode.em())).S())).b());
        subParts.a(this.f24881j, new OnClickListener(this) {
            final /* synthetic */ PulseRelatedLinksItemPartDefinition f24869c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -49940151);
                String iR = graphQLNode.iR();
                ((OldCanLogEntityNavigation) hasContext).mo1251b(graphQLNode);
                if (this.f24869c.f24883l.a(ExperimentsForSearchAbTestModule.am, false)) {
                    this.f24869c.f24875d.a(this.f24869c.f24874c.b(((HasSearchResultsContext) hasContext).mo1248s().f23369d, graphQLNode.it().a(), iR, SearchResultsSource.h), hasContext.getContext());
                } else {
                    String formatStrLocaleSafe = graphQLNode.dB() != null ? graphQLNode.dB().n() != null ? StringFormatUtil.formatStrLocaleSafe(FBLinks.fe, graphQLNode.dB().m(), Uri.encode(graphQLNode.dB().n().j())) : StringFormatUtil.formatStrLocaleSafe(FBLinks.fd, graphQLNode.dB().m()) : iR;
                    this.f24869c.f24882k.a(hasContext.getContext(), formatStrLocaleSafe);
                }
                LogUtils.a(-121005812, a);
            }
        });
        return null;
    }

    static {
        Builder a = Builder.a();
        a.c = 6.0f;
        f24871b = a.i();
    }

    public static PulseRelatedLinksItemPartDefinition m28243a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseRelatedLinksItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24873n) {
                PulseRelatedLinksItemPartDefinition pulseRelatedLinksItemPartDefinition;
                if (a2 != null) {
                    pulseRelatedLinksItemPartDefinition = (PulseRelatedLinksItemPartDefinition) a2.a(f24873n);
                } else {
                    pulseRelatedLinksItemPartDefinition = f24872m;
                }
                if (pulseRelatedLinksItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28245b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24873n, b3);
                        } else {
                            f24872m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseRelatedLinksItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseRelatedLinksItemPartDefinition(SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, BackgroundPartDefinition backgroundPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, SearchResultsExternalUrlContentViewSubtitlePartDefinition searchResultsExternalUrlContentViewSubtitlePartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, SearchResultsExternalUrlContentViewMetaPartDefinition searchResultsExternalUrlContentViewMetaPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, QeAccessor qeAccessor) {
        this.f24874c = searchResultsIntentBuilder;
        this.f24875d = secureContextHelper;
        this.f24876e = backgroundPartDefinition;
        this.f24877f = contentViewTitlePartDefinition;
        this.f24878g = searchResultsExternalUrlContentViewSubtitlePartDefinition;
        this.f24879h = contentViewThumbnailUriStringPartDefinition;
        this.f24880i = searchResultsExternalUrlContentViewMetaPartDefinition;
        this.f24881j = clickListenerPartDefinition;
        this.f24882k = fbUriIntentHandler;
        this.f24883l = qeAccessor;
    }

    public final ViewType m28246a() {
        return f24870a;
    }

    public static boolean m28244a(GraphQLNode graphQLNode) {
        if (graphQLNode.j() == null || graphQLNode.j().g() != 514783620 || graphQLNode.it() == null || Strings.isNullOrEmpty(graphQLNode.it().a()) || Strings.isNullOrEmpty(graphQLNode.iR()) || graphQLNode.em() == null || graphQLNode.em().S() == null) {
            return false;
        }
        return true;
    }
}

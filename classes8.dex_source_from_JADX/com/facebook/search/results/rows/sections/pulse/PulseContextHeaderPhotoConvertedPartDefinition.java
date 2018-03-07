package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.LinkMediaModel.PulseCoverPhotoModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIVATE_NOT_GOING */
public class PulseContextHeaderPhotoConvertedPartDefinition<E extends HasPositionInformation & HasContext & HasSearchResultsContext & HasSearchResultPosition & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsArticleExternalUrl>, Void, E, FbDraweeView> {
    public static final ViewType<FbDraweeView> f24821a = ViewType.a(2130906512);
    private static final CallerContext f24822b = CallerContext.a(PulseContextHeaderPhotoConvertedPartDefinition.class, "keyword_search");
    private static final PaddingStyle f24823c;
    private static final StylingData f24824d = new StylingData(null, f24823c, Position.MIDDLE);
    private static PulseContextHeaderPhotoConvertedPartDefinition f24825j;
    private static final Object f24826k = new Object();
    private final BackgroundPartDefinition f24827e;
    private final ClickListenerPartDefinition f24828f;
    private final FbDraweePartDefinition<E> f24829g;
    public final AttachmentLinkLauncher f24830h;
    public final SearchResultsLogger f24831i;

    private static PulseContextHeaderPhotoConvertedPartDefinition m28208b(InjectorLike injectorLike) {
        return new PulseContextHeaderPhotoConvertedPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), AttachmentLinkLauncher.a(injectorLike), SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m28210a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PulseCoverPhotoModel c;
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final Context context = ((HasContext) hasPositionInformation).getContext();
        subParts.a(this.f24827e, f24824d);
        if (((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).ay() != null) {
            c = ((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).ay().mo566c();
        } else {
            c = null;
        }
        String a = c == null ? null : c.m10449a();
        FbDraweePartDefinition fbDraweePartDefinition = this.f24829g;
        Builder a2 = FbDraweePartDefinition.a().a(a);
        a2.c = f24822b;
        subParts.a(fbDraweePartDefinition, a2.a());
        subParts.a(this.f24828f, new OnClickListener(this) {
            final /* synthetic */ PulseContextHeaderPhotoConvertedPartDefinition f24820d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1266505262);
                this.f24820d.f24831i.m25474a(((HasSearchResultsContext) hasPositionInformation).mo1248s(), ((HasSearchResultPosition) hasPositionInformation).mo1247a(searchResultsProps.f23390c), StoryAction.OPEN_LINK_BY_IMAGE, (String) searchResultsProps.f23391d.orNull());
                this.f24820d.f24830h.a(context, ((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).mo593v(), null, null);
                Logger.a(2, EntryType.UI_INPUT_END, 450980288, a);
            }
        });
        return null;
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.a();
        a.b = -6.0f;
        a = a;
        a.d = -12.0f;
        f24823c = a.i();
    }

    public static PulseContextHeaderPhotoConvertedPartDefinition m28207a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextHeaderPhotoConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24826k) {
                PulseContextHeaderPhotoConvertedPartDefinition pulseContextHeaderPhotoConvertedPartDefinition;
                if (a2 != null) {
                    pulseContextHeaderPhotoConvertedPartDefinition = (PulseContextHeaderPhotoConvertedPartDefinition) a2.a(f24826k);
                } else {
                    pulseContextHeaderPhotoConvertedPartDefinition = f24825j;
                }
                if (pulseContextHeaderPhotoConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28208b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24826k, b3);
                        } else {
                            f24825j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextHeaderPhotoConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseContextHeaderPhotoConvertedPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, AttachmentLinkLauncher attachmentLinkLauncher, SearchResultsLogger searchResultsLogger) {
        this.f24827e = backgroundPartDefinition;
        this.f24828f = clickListenerPartDefinition;
        this.f24829g = fbDraweePartDefinition;
        this.f24830h = attachmentLinkLauncher;
        this.f24831i = searchResultsLogger;
    }

    public final ViewType<FbDraweeView> m28209a() {
        return f24821a;
    }

    public final boolean m28211a(Object obj) {
        return true;
    }
}

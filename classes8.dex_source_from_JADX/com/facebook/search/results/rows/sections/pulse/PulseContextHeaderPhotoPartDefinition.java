package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.ImageUtil;
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
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: PRIVATE_MAYBE */
public class PulseContextHeaderPhotoPartDefinition<E extends HasPositionInformation & HasContext & HasSearchResultsContext & HasFeedItemPosition> extends MultiRowSinglePartDefinition<SearchResultsPulseContextUnit, Void, E, FbDraweeView> {
    public static final ViewType f24836a = ViewType.a(2130906512);
    public static final CallerContext f24837b = CallerContext.a(PulseContextHeaderPhotoPartDefinition.class, "keyword_search");
    private static final PaddingStyle f24838c;
    private static PulseContextHeaderPhotoPartDefinition f24839h;
    private static final Object f24840i = new Object();
    private final BackgroundPartDefinition f24841d;
    private final ClickListenerPartDefinition f24842e;
    public final AttachmentLinkLauncher f24843f;
    public final SearchResultsLogger f24844g;

    private static PulseContextHeaderPhotoPartDefinition m28213b(InjectorLike injectorLike) {
        return new PulseContextHeaderPhotoPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), AttachmentLinkLauncher.a(injectorLike), SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m28215a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final Context context = ((HasContext) hasPositionInformation).getContext();
        subParts.a(this.f24841d, new StylingData(null, f24838c, Position.MIDDLE));
        subParts.a(this.f24842e, new OnClickListener(this) {
            final /* synthetic */ PulseContextHeaderPhotoPartDefinition f24835d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1547868966);
                this.f24835d.f24844g.m25474a(((HasSearchResultsContext) hasPositionInformation).mo1248s(), ((HasFeedItemPosition) hasPositionInformation).mo1245a(searchResultsPulseContextUnit), StoryAction.OPEN_LINK_BY_IMAGE, (String) searchResultsPulseContextUnit.mo1322l().orNull());
                this.f24835d.f24843f.a(context, searchResultsPulseContextUnit.m27180m(), null, null);
                Logger.a(2, EntryType.UI_INPUT_END, -1749709787, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28216a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 292093310);
        SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        ((FbDraweeView) view).a(ImageUtil.a(searchResultsPulseContextUnit.f23497a.em() != null ? searchResultsPulseContextUnit.f23497a.em().aW() : null), f24837b);
        Logger.a(8, EntryType.MARK_POP, -299042075, a);
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.d = -12.0f;
        f24838c = a.i();
    }

    public static PulseContextHeaderPhotoPartDefinition m28212a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextHeaderPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24840i) {
                PulseContextHeaderPhotoPartDefinition pulseContextHeaderPhotoPartDefinition;
                if (a2 != null) {
                    pulseContextHeaderPhotoPartDefinition = (PulseContextHeaderPhotoPartDefinition) a2.a(f24840i);
                } else {
                    pulseContextHeaderPhotoPartDefinition = f24839h;
                }
                if (pulseContextHeaderPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28213b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24840i, b3);
                        } else {
                            f24839h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextHeaderPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseContextHeaderPhotoPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, AttachmentLinkLauncher attachmentLinkLauncher, SearchResultsLogger searchResultsLogger) {
        this.f24841d = backgroundPartDefinition;
        this.f24842e = clickListenerPartDefinition;
        this.f24843f = attachmentLinkLauncher;
        this.f24844g = searchResultsLogger;
    }

    public final ViewType m28214a() {
        return f24836a;
    }

    public final boolean m28217a(Object obj) {
        return true;
    }
}

package com.facebook.search.results.rows.sections.sports;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLPhotoConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;
import com.facebook.search.results.rows.sections.common.ContextHeaderPhotoView;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: POST_ABORTED */
public class SportsPhotoPartDefinition extends MultiRowSinglePartDefinition<SearchResultsSportsUnit, Void, HasPositionInformation, ContextHeaderPhotoView> {
    public static final ViewType f25071a = new C26361();
    public static final Uri f25072b = Uri.parse("https://facebook.com/images/live/football_cover_web.png");
    public static final CallerContext f25073c = CallerContext.a(SportsPhotoPartDefinition.class, "graph_search_results_page");
    private static SportsPhotoPartDefinition f25074i;
    private static final Object f25075j = new Object();
    private final Provider<FbDraweeControllerBuilder> f25076d;
    private final DefaultPaddingStyleResolver f25077e;
    public final Lazy<PhotoGalleryLauncherHelper> f25078f;
    private final ClickListenerPartDefinition f25079g;
    private final PaddingPartDefinition f25080h;

    /* compiled from: POST_ABORTED */
    final class C26361 extends ViewType {
        C26361() {
        }

        public final View m28378a(Context context) {
            ContextHeaderPhotoView contextHeaderPhotoView = new ContextHeaderPhotoView(context);
            contextHeaderPhotoView.m27557a(context, 2131626180);
            contextHeaderPhotoView.setTextPadding(2131432563);
            return contextHeaderPhotoView;
        }
    }

    private static SportsPhotoPartDefinition m28380b(InjectorLike injectorLike) {
        return new SportsPhotoPartDefinition(IdBasedProvider.a(injectorLike, 1117), DefaultPaddingStyleResolver.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 4891), PaddingPartDefinition.a(injectorLike));
    }

    public final Object m28382a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsSportsUnit searchResultsSportsUnit = (SearchResultsSportsUnit) obj;
        Builder a = Builder.a();
        a.d = -12.0f;
        a = a;
        a.b = -this.f25077e.d();
        a = a;
        a.c = -this.f25077e.e();
        subParts.a(this.f25080h, new PaddingData(searchResultsSportsUnit, a.i(), Position.MIDDLE, 0));
        subParts.a(this.f25079g, new OnClickListener(this) {
            final /* synthetic */ SportsPhotoPartDefinition f25070b;

            public void onClick(View view) {
                Object obj;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1520053423);
                SportsPhotoPartDefinition sportsPhotoPartDefinition = this.f25070b;
                SearchResultsSportsUnit searchResultsSportsUnit = searchResultsSportsUnit;
                ContextHeaderPhotoView contextHeaderPhotoView = (ContextHeaderPhotoView) view;
                if (searchResultsSportsUnit.f23540l == null || searchResultsSportsUnit.m27214o() == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    GraphQLStory a2 = new GraphQLStory.Builder().a();
                    GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
                    builder.l = GraphQLPhotoConversionHelper.a(searchResultsSportsUnit.f23540l);
                    ((PhotoGalleryLauncherHelper) sportsPhotoPartDefinition.f25078f.get()).a(FeedProps.c(searchResultsSportsUnit).a(a2).a(builder.a()), contextHeaderPhotoView.f23982a, ImageRequest.a(searchResultsSportsUnit.m27214o()), false);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 384527196, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28383a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Uri o;
        int a = Logger.a(8, EntryType.MARK_PUSH, 213046157);
        SearchResultsSportsUnit searchResultsSportsUnit = (SearchResultsSportsUnit) obj;
        ContextHeaderPhotoView contextHeaderPhotoView = (ContextHeaderPhotoView) view;
        if (searchResultsSportsUnit.m27214o() != null) {
            o = searchResultsSportsUnit.m27214o();
        } else if (searchResultsSportsUnit.f23541m != null) {
            o = searchResultsSportsUnit.f23541m;
        } else {
            o = f25072b;
        }
        contextHeaderPhotoView.m27558a(o, f25073c);
        contextHeaderPhotoView.setCoverPhotoTitle(searchResultsSportsUnit.f23531c);
        Logger.a(8, EntryType.MARK_POP, -767180652, a);
    }

    public final boolean m28384a(Object obj) {
        return ((SearchResultsSportsUnit) obj).f23543o == GraphQLGraphSearchResultRole.SPORT_MODULE;
    }

    public static SportsPhotoPartDefinition m28379a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25075j) {
                SportsPhotoPartDefinition sportsPhotoPartDefinition;
                if (a2 != null) {
                    sportsPhotoPartDefinition = (SportsPhotoPartDefinition) a2.a(f25075j);
                } else {
                    sportsPhotoPartDefinition = f25074i;
                }
                if (sportsPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28380b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25075j, b3);
                        } else {
                            f25074i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SportsPhotoPartDefinition(Provider<FbDraweeControllerBuilder> provider, DefaultPaddingStyleResolver defaultPaddingStyleResolver, ClickListenerPartDefinition clickListenerPartDefinition, Lazy<PhotoGalleryLauncherHelper> lazy, PaddingPartDefinition paddingPartDefinition) {
        this.f25076d = provider;
        this.f25077e = defaultPaddingStyleResolver;
        this.f25078f = lazy;
        this.f25079g = clickListenerPartDefinition;
        this.f25080h = paddingPartDefinition;
    }

    public final ViewType m28381a() {
        return f25071a;
    }
}

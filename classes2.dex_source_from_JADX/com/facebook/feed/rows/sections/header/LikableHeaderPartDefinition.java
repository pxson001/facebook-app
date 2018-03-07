package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.LazyResources;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.DefaultLikableHeaderView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: freshfeed_background_ui_work */
public class LikableHeaderPartDefinition<E extends CanLikePage & HasContext & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultLikableHeaderView> {
    public static final ViewType f23209a = new C09341();
    private static LikableHeaderPartDefinition f23210k;
    private static final Object f23211l = new Object();
    private final TextLinkPartDefinition f23212b;
    private final BackgroundPartDefinition f23213c;
    private final HeaderTitleWithLayoutPartDefinition<E> f23214d;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f23215e;
    private final LikePageButtonPartDefinition<E> f23216f;
    private final ProfilePhotoPartDefinition<E> f23217g;
    private final StoryHeaderUtil f23218h;
    private final Lazy<Drawable> f23219i;
    private final Context f23220j;

    /* compiled from: freshfeed_background_ui_work */
    final class C09341 extends ViewType {
        C09341() {
        }

        public final View mo1995a(Context context) {
            return new DefaultLikableHeaderView(context);
        }
    }

    private static LikableHeaderPartDefinition m31316b(InjectorLike injectorLike) {
        return new LikableHeaderPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), TextLinkPartDefinition.m28402a(injectorLike), LikePageButtonPartDefinition.m31322a(injectorLike), HeaderTitleWithLayoutPartDefinition.m28427a(injectorLike), ProfilePhotoPartDefinition.m28424a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.m28432a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f23212b, feedProps);
        subParts.mo2756a(this.f23213c, this.f23218h.m28334a(feedProps));
        int c = this.f23218h.m28336c(feedProps);
        subParts.mo2755a(2131562764, this.f23217g, new Props(feedProps, this.f23218h.m28335b(feedProps), c));
        subParts.mo2755a(2131563422, this.f23216f, feedProps);
        subParts.mo2755a(2131562765, this.f23214d, new HeaderTitleWithLayoutPartDefinition.Props(feedProps, true, m31317c()));
        subParts.mo2755a(2131562766, this.f23215e, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, m31317c()));
        return null;
    }

    public static LikableHeaderPartDefinition m31315a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikableHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23211l) {
                LikableHeaderPartDefinition likableHeaderPartDefinition;
                if (a2 != null) {
                    likableHeaderPartDefinition = (LikableHeaderPartDefinition) a2.mo818a(f23211l);
                } else {
                    likableHeaderPartDefinition = f23210k;
                }
                if (likableHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31316b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23211l, b3);
                        } else {
                            f23210k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likableHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public LikableHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextLinkPartDefinition textLinkPartDefinition, LikePageButtonPartDefinition likePageButtonPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, StoryHeaderUtil storyHeaderUtil, Context context) {
        this.f23216f = likePageButtonPartDefinition;
        this.f23212b = textLinkPartDefinition;
        this.f23213c = backgroundPartDefinition;
        this.f23214d = headerTitleWithLayoutPartDefinition;
        this.f23217g = profilePhotoPartDefinition;
        this.f23215e = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f23218h = storyHeaderUtil;
        this.f23220j = context;
        this.f23219i = LazyResources.m28241b(context, 2130840276);
    }

    public final ViewType mo2547a() {
        return f23209a;
    }

    public final boolean m31320a(Object obj) {
        return true;
    }

    private int m31317c() {
        return ((Drawable) this.f23219i.get()).getIntrinsicWidth() + (this.f23220j.getResources().getDimensionPixelSize(2131428828) * 2);
    }
}

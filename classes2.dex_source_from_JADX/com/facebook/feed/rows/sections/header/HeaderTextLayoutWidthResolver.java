package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feed.util.story.FeedStoryUtilModelConverter;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: http_stack */
public class HeaderTextLayoutWidthResolver {
    private static HeaderTextLayoutWidthResolver f20701l;
    private static final Object f20702m = new Object();
    public final BasePaddingStyleResolver f20703a;
    public final FeedStoryUtil f20704b;
    private final SeeFirstStateManager f20705c;
    public final GraphQLStoryUtil f20706d;
    public final float f20707e;
    private final float f20708f;
    private final float f20709g;
    public final float f20710h;
    public final float f20711i;
    public final float f20712j;
    public final float f20713k;

    private static HeaderTextLayoutWidthResolver m28441b(InjectorLike injectorLike) {
        return new HeaderTextLayoutWidthResolver(DefaultPaddingStyleResolver.m19157a(injectorLike), FeedStoryUtil.m18578a(injectorLike), SeeFirstStateManager.m16868a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public HeaderTextLayoutWidthResolver(BasePaddingStyleResolver basePaddingStyleResolver, FeedStoryUtil feedStoryUtil, SeeFirstStateManager seeFirstStateManager, GraphQLStoryUtil graphQLStoryUtil, Context context) {
        this.f20703a = basePaddingStyleResolver;
        this.f20704b = feedStoryUtil;
        this.f20705c = seeFirstStateManager;
        this.f20706d = graphQLStoryUtil;
        Resources resources = context.getResources();
        this.f20707e = resources.getDisplayMetrics().density;
        this.f20708f = resources.getDimension(2131427599);
        float dimension = resources.getDimension(2131427602);
        this.f20709g = dimension;
        this.f20710h = dimension;
        this.f20711i = resources.getDimension(2131427614);
        this.f20712j = resources.getDimension(2131427600);
        this.f20713k = (float) resources.getDrawable(2130843313).getIntrinsicWidth();
    }

    public static HeaderTextLayoutWidthResolver m28440a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTextLayoutWidthResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20702m) {
                HeaderTextLayoutWidthResolver headerTextLayoutWidthResolver;
                if (a2 != null) {
                    headerTextLayoutWidthResolver = (HeaderTextLayoutWidthResolver) a2.mo818a(f20702m);
                } else {
                    headerTextLayoutWidthResolver = f20701l;
                }
                if (headerTextLayoutWidthResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28441b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20702m, b3);
                        } else {
                            f20701l = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTextLayoutWidthResolver;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final int m28442a(FeedProps<GraphQLStory> feedProps, FeedMenuHelper feedMenuHelper, int i, int i2) {
        float f;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        int a = this.f20703a.m19174a((this.f20706d.m9600i(feedProps) > 0 ? 1 : null) != null ? PaddingStyle.f13081k : PaddingStyle.f13079i, (FeedProps) feedProps, this.f20707e);
        float f2 = FeedStoryUtil.m18579a(FeedStoryUtilModelConverter.m29447a(graphQLStory)) ? this.f20708f : 0.0f;
        if (i2 != -1) {
            f = (float) i2;
        } else {
            float f3;
            GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.f13444a;
            boolean a2 = this.f20704b.m18588a(feedProps, feedProps, feedMenuHelper, false);
            boolean a3 = SeeFirstStateManager.m16870a(graphQLStory2);
            if (a2 && a3) {
                f3 = this.f20712j + this.f20711i;
            } else if (a2) {
                f3 = this.f20712j;
            } else if (a3) {
                f3 = this.f20713k + this.f20710h;
            } else {
                f3 = 0.0f;
            }
            f = f3;
        }
        return (int) (((((float) (i - (a * 2))) - f2) - f) - this.f20709g);
    }
}

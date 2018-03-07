package com.facebook.reviews.util.helper;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: profile_video_android_video_chosen_too_long */
public class ReviewsImageHelper {
    private static ReviewsImageHelper f4975c;
    private static final Object f4976d = new Object();
    private final GraphQLImageHelper f4977a;
    private final Resources f4978b;

    private static ReviewsImageHelper m4922b(InjectorLike injectorLike) {
        return new ReviewsImageHelper(GraphQLImageHelper.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    ReviewsImageHelper(GraphQLImageHelper graphQLImageHelper, Resources resources) {
        this.f4977a = graphQLImageHelper;
        this.f4978b = resources;
    }

    public final Integer m4923a() {
        return GraphQLImageHelper.a(this.f4978b.getDimensionPixelSize(2131430059));
    }

    public final Integer m4924b() {
        return GraphQLImageHelper.a(this.f4978b.getDimensionPixelSize(2131428990));
    }

    public final Integer m4925c() {
        return GraphQLImageHelper.a(this.f4978b.getDimensionPixelSize(2131428989));
    }

    public static ReviewsImageHelper m4921a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReviewsImageHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4976d) {
                ReviewsImageHelper reviewsImageHelper;
                if (a2 != null) {
                    reviewsImageHelper = (ReviewsImageHelper) a2.a(f4976d);
                } else {
                    reviewsImageHelper = f4975c;
                }
                if (reviewsImageHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4976d, b3);
                        } else {
                            f4975c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reviewsImageHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

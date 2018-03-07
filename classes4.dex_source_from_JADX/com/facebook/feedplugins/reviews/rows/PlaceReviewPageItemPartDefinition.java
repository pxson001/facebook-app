package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feedplugins.reviews.rows.PlaceReviewItemPartDefinition.Props;
import com.facebook.feedplugins.reviews.views.PlaceReviewItemView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_story_cache_entries */
public class PlaceReviewPageItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, HasPositionInformation, PlaceReviewItemView> {
    public static final ViewType<PlaceReviewItemView> f6782a = new C03181();
    private static PlaceReviewPageItemPartDefinition f6783c;
    private static final Object f6784d = new Object();
    private final PlaceReviewItemPartDefinition f6785b;

    /* compiled from: notification_story_cache_entries */
    final class C03181 extends ViewType<PlaceReviewItemView> {
        C03181() {
        }

        public final View m7156a(Context context) {
            return new PlaceReviewItemView(context);
        }
    }

    private static PlaceReviewPageItemPartDefinition m7153b(InjectorLike injectorLike) {
        return new PlaceReviewPageItemPartDefinition(PlaceReviewItemPartDefinition.a(injectorLike));
    }

    public final Object m7155a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f6785b, new Props(props.a, props.b, false));
        return null;
    }

    @Inject
    public PlaceReviewPageItemPartDefinition(PlaceReviewItemPartDefinition placeReviewItemPartDefinition) {
        this.f6785b = placeReviewItemPartDefinition;
    }

    public final ViewType m7154a() {
        return f6782a;
    }

    public static PlaceReviewPageItemPartDefinition m7152a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewPageItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6784d) {
                PlaceReviewPageItemPartDefinition placeReviewPageItemPartDefinition;
                if (a2 != null) {
                    placeReviewPageItemPartDefinition = (PlaceReviewPageItemPartDefinition) a2.a(f6784d);
                } else {
                    placeReviewPageItemPartDefinition = f6783c;
                }
                if (placeReviewPageItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7153b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6784d, b3);
                        } else {
                            f6783c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewPageItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

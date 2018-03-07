package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.graphics.PointF;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLGreetingCardSlideType;
import com.facebook.graphql.model.GraphQLGreetingCard;
import com.facebook.graphql.model.GraphQLGreetingCardSlide;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@ContextScoped
/* compiled from: deselect_response */
public class GreetingCardModelUtils {
    private static GreetingCardModelUtils f7665a;
    private static final Object f7666b = new Object();

    /* compiled from: deselect_response */
    /* synthetic */ class C09761 {
        static final /* synthetic */ int[] f7664a = new int[GraphQLGreetingCardSlideType.values().length];

        static {
            try {
                f7664a[GraphQLGreetingCardSlideType.COVER_SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7664a[GraphQLGreetingCardSlideType.STORY_SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7664a[GraphQLGreetingCardSlideType.CLOSING_SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static GreetingCardModelUtils m8876a() {
        return new GreetingCardModelUtils();
    }

    public final GreetingCard m8879a(GraphQLGreetingCard graphQLGreetingCard) {
        Slide slide;
        Slide slide2 = null;
        Builder builder = ImmutableList.builder();
        if (graphQLGreetingCard.m() != null) {
            ImmutableList a = graphQLGreetingCard.m().a();
            int size = a.size();
            slide = null;
            Slide slide3 = null;
            int i = 0;
            while (i < size) {
                Slide slide4;
                GraphQLGreetingCardSlide graphQLGreetingCardSlide = (GraphQLGreetingCardSlide) a.get(i);
                switch (C09761.f7664a[graphQLGreetingCardSlide.k().ordinal()]) {
                    case 1:
                        Slide slide5 = slide;
                        slide = m8878a(graphQLGreetingCardSlide);
                        slide4 = slide5;
                        break;
                    case 2:
                        builder.c(m8878a(graphQLGreetingCardSlide));
                        slide4 = slide;
                        slide = slide3;
                        break;
                    case 3:
                        slide4 = m8878a(graphQLGreetingCardSlide);
                        slide = slide3;
                        break;
                    default:
                        slide4 = slide;
                        slide = slide3;
                        break;
                }
                i++;
                slide3 = slide;
                slide = slide4;
            }
            slide2 = slide;
            slide = slide3;
        } else {
            slide = null;
        }
        return new GreetingCard(slide, builder.b(), slide2, graphQLGreetingCard.j().j(), graphQLGreetingCard.n(), graphQLGreetingCard.k());
    }

    public static GreetingCardModelUtils m8877a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardModelUtils a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7666b) {
                GreetingCardModelUtils greetingCardModelUtils;
                if (a3 != null) {
                    greetingCardModelUtils = (GreetingCardModelUtils) a3.a(f7666b);
                } else {
                    greetingCardModelUtils = f7665a;
                }
                if (greetingCardModelUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8876a();
                        if (a3 != null) {
                            a3.a(f7666b, a2);
                        } else {
                            f7665a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = greetingCardModelUtils;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    private static Slide m8878a(GraphQLGreetingCardSlide graphQLGreetingCardSlide) {
        Builder builder = ImmutableList.builder();
        if (!(graphQLGreetingCardSlide.j() == null || graphQLGreetingCardSlide.j().a() == null)) {
            ImmutableList a = graphQLGreetingCardSlide.j().a();
            int size = a.size();
            int size2 = a.size();
            for (int i = 0; i < size2; i++) {
                GraphQLPhoto graphQLPhoto = (GraphQLPhoto) a.get(i);
                if (size == 1 && graphQLPhoto.ao() != null) {
                    builder.c(CardPhoto.a(ImageUtil.a(graphQLPhoto.ao()), graphQLPhoto.K(), graphQLPhoto.G() == null ? null : new PointF((float) graphQLPhoto.G().a(), (float) graphQLPhoto.G().b())));
                } else if (graphQLPhoto.at() != null) {
                    builder.c(CardPhoto.a(ImageUtil.a(graphQLPhoto.at()), graphQLPhoto.K(), graphQLPhoto.G() == null ? null : new PointF((float) graphQLPhoto.G().a(), (float) graphQLPhoto.G().b())));
                }
            }
        }
        return new Slide(graphQLGreetingCardSlide.l() != null ? graphQLGreetingCardSlide.l().a() : "", graphQLGreetingCardSlide.a() != null ? graphQLGreetingCardSlide.a().a() : "", builder.b());
    }
}

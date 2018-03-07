package com.facebook.feed.rows.styling;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver.BaseStyle;
import com.facebook.feed.rows.styling.HorizontalPadder.ConstantHorizontalPadder;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.styling.PaddingStyle.PaddingValues;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: native */
public class DefaultPaddingStyleResolver extends BasePaddingStyleResolver {
    private static final HorizontalPadder f13027c = new ConstantHorizontalPadder(0.0f, 0.0f);
    private static final PaddingValues f13028f = new PaddingValues(0.0f, 12.0f, 0.0f, f13027c);
    private static DefaultPaddingStyleResolver f13029k;
    private static final Object f13030l = new Object();
    private final PaddingValues f13031a = new PaddingValues(-m19169c(), -m19169c(), 0.0f, new ConstantHorizontalPadder(-m19169c(), 0.0f));
    private final PaddingValues f13032b = new PaddingValues((-m19169c()) * 2.0f, (-m19169c()) * 2.0f, 0.0f, new ConstantHorizontalPadder(0.0f, 0.0f));
    private final PaddingValues f13033d = new PaddingValues(m19164l(), 0.0f, 0.0f, f13027c);
    private final PaddingValues f13034e = new PaddingValues(0.0f, m19171e() + this.f13038j.m19189e(), 0.0f, f13027c);
    private final PaddingValues f13035g = new PaddingValues(0.0f, m19171e(), 0.0f, f13027c);
    public final PaddingValues f13036h = new PaddingValues(m19170d(), 0.0f, 0.0f, f13027c);
    public PaddingValues f13037i = new PaddingValues(m19164l(), m19171e(), 0.0f, f13027c);
    public EdgeToEdgePaddingStyleConfig f13038j;

    /* compiled from: native */
    public /* synthetic */ class C07661 {
        public static final /* synthetic */ int[] f19260a = new int[BackgroundStyler$Position.values().length];

        static {
            try {
                f19260a[BackgroundStyler$Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19260a[BackgroundStyler$Position.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19260a[BackgroundStyler$Position.DIVIDER_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19260a[BackgroundStyler$Position.DIVIDER_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19260a[BackgroundStyler$Position.BOX.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static DefaultPaddingStyleResolver m19163b(InjectorLike injectorLike) {
        return new DefaultPaddingStyleResolver(GraphQLStoryUtil.m9565a(injectorLike), PaddingStyleConfigMethodAutoProvider.m19183b(injectorLike));
    }

    public static DefaultPaddingStyleResolver m19157a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultPaddingStyleResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13030l) {
                DefaultPaddingStyleResolver defaultPaddingStyleResolver;
                if (a2 != null) {
                    defaultPaddingStyleResolver = (DefaultPaddingStyleResolver) a2.mo818a(f13030l);
                } else {
                    defaultPaddingStyleResolver = f13029k;
                }
                if (defaultPaddingStyleResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19163b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13030l, b3);
                        } else {
                            f13029k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultPaddingStyleResolver;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultPaddingStyleResolver(GraphQLStoryUtil graphQLStoryUtil, EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig) {
        super(graphQLStoryUtil);
        this.f13038j = edgeToEdgePaddingStyleConfig;
    }

    public final float m19169c() {
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f13038j;
        return 0.0f;
    }

    public final float m19170d() {
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f13038j;
        return 6.0f;
    }

    public final float m19171e() {
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f13038j;
        return 6.0f;
    }

    private float m19164l() {
        return 0.0f + this.f13038j.m19189e();
    }

    protected final EnumMap<BaseStyle, PaddingValues> mo2550a() {
        return null;
    }

    public final EnumMap<BaseStyle, PaddingValues> mo2552b() {
        return this.f13038j.m19190h();
    }

    public final PaddingValues mo2549a(PaddingStyle paddingStyle, BackgroundStyler$Position backgroundStyler$Position, int i) {
        Preconditions.checkArgument(i >= 0);
        PaddingValues a = m19161a(paddingStyle.f13089s.m19182a((PaddingValues) mo2552b().get(paddingStyle.f13088r)), paddingStyle);
        switch (C07661.f19260a[backgroundStyler$Position.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return a.m19182a(m19159a(i));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return a.m19182a(m19160a(i, paddingStyle));
            case 3:
                return a.m19182a(this.f13036h);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return a.m19182a(this.f13037i);
            case 5:
                return a.m19182a(m19159a(i)).m19182a(m19160a(i, paddingStyle));
            default:
                return a;
        }
    }

    private PaddingValues m19159a(int i) {
        if (i == 0) {
            return this.f13033d;
        }
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f13038j;
        return EdgeToEdgePaddingStyleConfig.f13049b;
    }

    private PaddingValues m19160a(int i, PaddingStyle paddingStyle) {
        if (i == 0) {
            return this.f13034e;
        }
        return (paddingStyle.m19314d() || paddingStyle.f13088r.isSharedStoryAttachmentPadding()) ? this.f13035g : f13028f;
    }

    public final PaddingValues mo2551b(PaddingStyle paddingStyle, BackgroundStyler$Position backgroundStyler$Position, int i) {
        float d;
        PaddingValues a = mo2549a(paddingStyle, backgroundStyler$Position, i);
        switch (C07661.f19260a[backgroundStyler$Position.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                d = m19170d();
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                d = m19170d();
                break;
            default:
                d = m19156a(a.f13044a);
                break;
        }
        return new PaddingValues(d, m19162b(a, backgroundStyler$Position), 0.0f, m19158a(a));
    }

    private float m19162b(PaddingValues paddingValues, BackgroundStyler$Position backgroundStyler$Position) {
        switch (C07661.f19260a[backgroundStyler$Position.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m19164l();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 1.0f;
            default:
                return m19156a(paddingValues.f13045b);
        }
    }

    private HorizontalPadder m19158a(PaddingValues paddingValues) {
        HorizontalPadder horizontalPadder = paddingValues.f13047d;
        return new ConstantHorizontalPadder(m19156a(horizontalPadder.mo2553a(0)), horizontalPadder.mo2553a(1) - horizontalPadder.mo2553a(0));
    }

    public static float m19156a(float f) {
        return Math.max(f - 12.0f, 0.0f);
    }

    private PaddingValues m19161a(PaddingValues paddingValues, PaddingStyle paddingStyle) {
        if (!paddingStyle.f13090t) {
            return paddingValues;
        }
        return paddingValues.m19182a(paddingStyle.m19314d() ? this.f13032b : this.f13031a);
    }

    public final PaddingStyle m19172h() {
        Builder a = Builder.m19301a();
        a.f13066b = -m19170d();
        return a.m19313i();
    }

    public final PaddingStyle m19173j() {
        Builder a = Builder.m19301a();
        a.f13067c = -m19171e();
        return a.m19313i();
    }
}

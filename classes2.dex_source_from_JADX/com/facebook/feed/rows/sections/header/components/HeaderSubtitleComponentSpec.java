package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v4.util.Pools$SynchronizedPool;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Diff;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.widget.GlyphWarmer;
import com.facebook.components.widget.TextDrawable;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderTimeInfoFormatter;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Objects;
import javax.inject.Inject;

@MountSpec
@ContextScoped
/* compiled from: ignored_request_due_to_cache_failure */
public class HeaderSubtitleComponentSpec {
    public static final Pools$SynchronizedPool<TextLayoutBuilder> f20551a = new Pools$SynchronizedPool(2);
    private static HeaderSubtitleComponentSpec f20552e;
    private static final Object f20553f = new Object();
    private final DefaultHeaderPartDataProviderForTextLayout f20554b;
    private final TextPaint f20555c = new TextPaint(1);
    private final Paint f20556d;

    private static HeaderSubtitleComponentSpec m28290b(InjectorLike injectorLike) {
        return new HeaderSubtitleComponentSpec((Context) injectorLike.getInstance(Context.class), DefaultHeaderPartDataProviderForTextLayout.m28171a(injectorLike));
    }

    @Inject
    public HeaderSubtitleComponentSpec(Context context, DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout) {
        this.f20554b = defaultHeaderPartDataProviderForTextLayout;
        this.f20555c.setTextSize((float) context.getResources().getDimensionPixelSize(2131428835));
        this.f20556d = new Paint(1);
        this.f20556d.setColor(-1447187);
    }

    public static HeaderSubtitleComponentSpec m28287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderSubtitleComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20553f) {
                HeaderSubtitleComponentSpec headerSubtitleComponentSpec;
                if (a2 != null) {
                    headerSubtitleComponentSpec = (HeaderSubtitleComponentSpec) a2.mo818a(f20553f);
                } else {
                    headerSubtitleComponentSpec = f20552e;
                }
                if (headerSubtitleComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28290b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20553f, b3);
                        } else {
                            f20552e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerSubtitleComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final void m28291a(ComponentContext componentContext, int i, int i2, Size size, FeedProps<GraphQLStory> feedProps, Output<CharSequence> output, Output<Layout> output2, Output<ClickableSpan[]> output3) {
        if (SizeSpec.m30704a(i) == 0) {
            throw new IllegalArgumentException("HeaderSubtitleComponent does not support UNSPECIFIED width measurement");
        }
        m28288a(componentContext, SizeSpec.m30706b(i), feedProps, output, output2, output3);
        Layout layout = (Layout) output2.m31109a();
        size.f22987a = SizeSpec.m30707b(i, LayoutMeasureUtil.m29743a(layout));
        size.f22988b = SizeSpec.m30707b(i2, LayoutMeasureUtil.m29744b(layout));
    }

    protected final void m28292a(ComponentContext componentContext, ComponentLayout componentLayout, FeedProps<GraphQLStory> feedProps, CharSequence charSequence, Layout layout, ClickableSpan[] clickableSpanArr, Output<CharSequence> output, Output<Layout> output2, Output<ClickableSpan[]> output3) {
        if (layout != null) {
            output.m31110a(charSequence);
            output2.m31110a(layout);
            output3.m31110a(clickableSpanArr);
            return;
        }
        m28288a(componentContext, componentLayout.m30790c(), feedProps, output, output2, output3);
    }

    protected static TextDrawable m28286a(TextDrawable textDrawable, CharSequence charSequence, Layout layout, ClickableSpan[] clickableSpanArr) {
        if (textDrawable == null) {
            textDrawable = new TextDrawable();
        }
        textDrawable.m31177a(charSequence, layout, 0.0f, null, -7235677, 0, clickableSpanArr);
        return textDrawable;
    }

    protected final boolean m28293a(Diff<FeedProps<GraphQLStory>> diff) {
        FeedProps feedProps = (FeedProps) diff.a;
        FeedProps feedProps2 = (FeedProps) diff.b;
        if (((GraphQLStory) feedProps.f13444a) == ((GraphQLStory) feedProps2.f13444a)) {
            return false;
        }
        Object obj;
        Object obj2;
        DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout = this.f20554b;
        DefaultHeaderTimeInfoFormatter defaultHeaderTimeInfoFormatter = defaultHeaderPartDataProviderForTextLayout.f20435i;
        if (((GraphQLStory) feedProps.f13444a).m22336V() == ((GraphQLStory) feedProps2.f13444a).m22336V() && DefaultHeaderTimeInfoFormatter.m28194b(feedProps) == DefaultHeaderTimeInfoFormatter.m28194b(feedProps2)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            String u;
            String str = null;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
            GraphQLStory graphQLStory2 = (GraphQLStory) feedProps2.f13444a;
            Object u2 = graphQLStory.m22324J() != null ? graphQLStory.m22324J().m23672u() : null;
            if (graphQLStory2.m22324J() != null) {
                u = graphQLStory2.m22324J().m23672u();
            } else {
                u = null;
            }
            if (u != null) {
                if (!u.equals(u2)) {
                    obj = null;
                }
                u2 = (GraphQLHelper.m22517m(graphQLStory) || graphQLStory.m22339Y().m24164q() == null) ? null : graphQLStory.m22339Y().m24164q().m23462N();
                if (GraphQLHelper.m22517m(graphQLStory2) || graphQLStory2.m22339Y().m24164q() == null) {
                    u = null;
                } else {
                    u = graphQLStory2.m22339Y().m24164q().m23462N();
                }
                if (u == null) {
                    if (!u.equals(u2)) {
                        obj = null;
                    }
                } else if (u2 != null) {
                    obj = null;
                }
                obj = graphQLStory.ae() == null ? graphQLStory.ae().m24126B() : null;
                if (graphQLStory2.ae() != null) {
                    str = graphQLStory2.ae().m24126B();
                }
                if (str == null) {
                    if (!str.equals(obj)) {
                        obj = null;
                    }
                } else if (obj != null) {
                    obj = null;
                }
                obj = StoryProps.m27465n(feedProps2) == StoryProps.m27465n(feedProps) ? null : 1;
            } else {
                if (u2 != null) {
                    obj = null;
                }
                if (GraphQLHelper.m22517m(graphQLStory)) {
                }
                if (GraphQLHelper.m22517m(graphQLStory2)) {
                }
                u = null;
                if (u == null) {
                    if (u2 != null) {
                        obj = null;
                    }
                } else if (u.equals(u2)) {
                    obj = null;
                }
                if (graphQLStory.ae() == null) {
                }
                if (graphQLStory2.ae() != null) {
                    str = graphQLStory2.ae().m24126B();
                }
                if (str == null) {
                    if (obj != null) {
                        obj = null;
                    }
                } else if (str.equals(obj)) {
                    obj = null;
                }
                if (StoryProps.m27465n(feedProps2) == StoryProps.m27465n(feedProps)) {
                }
            }
            if (obj != null && DefaultHeaderPartDataProviderForTextLayout.m28180c(feedProps, feedProps2)) {
                boolean equal;
                if (defaultHeaderPartDataProviderForTextLayout.f20441o.m8792b()) {
                    equal = Objects.equal(((GraphQLStory) feedProps.f13444a).m22340Z(), ((GraphQLStory) feedProps2.f13444a).m22340Z());
                } else {
                    equal = true;
                }
                if (equal) {
                    obj2 = 1;
                    return obj2 != null;
                }
            }
        }
        obj2 = null;
        if (obj2 != null) {
        }
    }

    private void m28288a(Context context, int i, FeedProps<GraphQLStory> feedProps, Output<CharSequence> output, Output<Layout> output2, Output<ClickableSpan[]> output3) {
        CharSequence charSequence = this.f20554b.mo3137a(feedProps, this.f20555c, this.f20556d, i).f21928b;
        int c = ContextUtils.m2503c(context, 16843282, -7235677);
        Resources resources = context.getResources();
        TextLayoutBuilder textLayoutBuilder = (TextLayoutBuilder) f20551a.mo740a();
        if (textLayoutBuilder == null) {
            textLayoutBuilder = new TextLayoutBuilder().m28600a(false);
        }
        TextLayoutBuilder a = textLayoutBuilder.m28599a(charSequence).m28604b(resources.getDimensionPixelSize(2131428835)).m28606c(c).m28590a((float) resources.getDimensionPixelSize(2131428237)).m28592a(i);
        output2.f22989a = a.m28608d();
        output.f22989a = charSequence;
        m28289a((CharSequence) output.f22989a, output3);
        a.m28599a(null);
        f20551a.mo741a(a);
        GlyphWarmer.m31111a().m31112a((Layout) output2.f22989a);
    }

    private static void m28289a(CharSequence charSequence, Output<ClickableSpan[]> output) {
        if (charSequence instanceof Spanned) {
            output.f22989a = ((Spanned) charSequence).getSpans(0, charSequence.length() - 1, ClickableSpan.class);
        }
    }
}

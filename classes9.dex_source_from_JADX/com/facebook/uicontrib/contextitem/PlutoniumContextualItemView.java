package com.facebook.uicontrib.contextitem;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.fbui.nodes.ImageBlockLayoutNode;
import com.facebook.fbui.nodes.ImageBlockLayoutNode.LayoutParams;
import com.facebook.fbui.nodes.NetworkImageNode;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.graphql.enums.GraphQLImageSizingStyle;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nodes.ImageNode;
import com.facebook.nodes.NodeView;
import com.facebook.nodes.TextNode;
import com.facebook.nodes.ViewNode;
import com.facebook.widget.IViewAttachAware;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timestamp_in_folder_ms DESC */
public class PlutoniumContextualItemView extends NodeView implements IViewAttachAware {
    @Inject
    IFeedIntentBuilder f1648a;
    @Inject
    SecureContextHelper f1649b;
    @Nullable
    public ContextualItemPresenter f1650c = null;
    private ImageBlockLayoutNode f1651d;
    private NetworkImageNode f1652e;
    private TextNode f1653f;
    private TextNode f1654g;
    private Paint f1655h;
    private TextNode f1656i;
    public ImageNode f1657j;
    public boolean f1658k;
    private int f1659l = 0;
    public int f1660m = 0;
    public boolean f1661n;
    public boolean f1662o;
    private final OnClickListener f1663p = new C01651(this);
    private final OnClickListener f1664q = new C01672(this);

    /* compiled from: timestamp_in_folder_ms DESC */
    class C01651 implements OnClickListener {
        final /* synthetic */ PlutoniumContextualItemView f1644a;

        C01651(PlutoniumContextualItemView plutoniumContextualItemView) {
            this.f1644a = plutoniumContextualItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1477560619);
            if (this.f1644a.f1650c != null) {
                this.f1644a.f1650c.b(this.f1644a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1690388382, a);
        }
    }

    /* compiled from: timestamp_in_folder_ms DESC */
    class C01672 implements OnClickListener {
        final /* synthetic */ PlutoniumContextualItemView f1647a;

        C01672(PlutoniumContextualItemView plutoniumContextualItemView) {
            this.f1647a = plutoniumContextualItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -625493267);
            final PopoverWindow popoverWindow = new PopoverWindow(view.getContext());
            PlutoniumContextualItemMoreView plutoniumContextualItemMoreView = new PlutoniumContextualItemMoreView(view.getContext());
            plutoniumContextualItemMoreView.f1641f.a(new OnClickListener(this) {
                final /* synthetic */ C01672 f1646b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 241674852);
                    Intent b = this.f1646b.f1647a.f1648a.b(view.getContext(), FBLinks.a("faceweb/f?href=/help/475643069256244"));
                    popoverWindow.l();
                    this.f1646b.f1647a.f1649b.a(b, view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, -1231699930, a);
                }
            });
            plutoniumContextualItemMoreView.f1642g = this.f1647a.f1658k;
            plutoniumContextualItemMoreView.f1639d.e(plutoniumContextualItemMoreView.f1642g ? 8 : 0);
            if (plutoniumContextualItemMoreView.f1642g) {
                plutoniumContextualItemMoreView.f1640e.b(plutoniumContextualItemMoreView.getResources().getDrawable(2130838288));
            } else {
                plutoniumContextualItemMoreView.f1640e.b(new ColorDrawable(plutoniumContextualItemMoreView.getResources().getColor(2131361981)));
            }
            popoverWindow.d(plutoniumContextualItemMoreView);
            popoverWindow.a(Position.BELOW);
            popoverWindow.c(true);
            popoverWindow.a(view, this.f1647a.f1657j.h, this.f1647a.f1657j.i, this.f1647a.f1657j.t, this.f1647a.f1657j.u);
            popoverWindow.d();
            Logger.a(2, EntryType.UI_INPUT_END, 1681458661, a);
        }
    }

    private static <T extends View> void m1672a(Class<T> cls, T t) {
        m1674a((Object) t, t.getContext());
    }

    private static void m1674a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlutoniumContextualItemView) obj).m1671a((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m1671a(IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f1648a = iFeedIntentBuilder;
        this.f1649b = secureContextHelper;
    }

    public PlutoniumContextualItemView(Context context) {
        super(context);
        m1675b();
    }

    public PlutoniumContextualItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlutoniumContextualItemView);
        this.f1659l = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        m1675b();
    }

    private void m1675b() {
        m1672a(PlutoniumContextualItemView.class, (View) this);
        setContentNode(2130903800);
        setBackgroundResource(2131361864);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130772600, typedValue, true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(typedValue.resourceId == 0 ? 2131427497 : typedValue.resourceId);
        getContext().getTheme().resolveAttribute(2130772599, typedValue, true);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(typedValue.resourceId == 0 ? 2131427496 : typedValue.resourceId);
        setMinimumHeight(getResources().getDimensionPixelSize(2131430084) + (dimensionPixelSize * 2));
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.f1651d = (ImageBlockLayoutNode) a(2131560779);
        this.f1652e = (NetworkImageNode) a(2131560780);
        this.f1653f = (TextNode) a(2131560781);
        this.f1654g = (TextNode) a(2131560782);
        this.f1656i = (TextNode) a(2131560783);
        this.f1657j = (ImageNode) a(2131560784);
        this.f1651d.a(17);
        this.f1651d.h(dimensionPixelSize2);
        this.f1655h = new Paint(1);
        this.f1655h.setColor(getResources().getColor(2131362991));
        this.f1655h.setStrokeWidth(0.0f);
        if (this.f1659l == 1) {
            this.f1653f.a(getResources().getColor(2131361920));
            this.f1654g.a(getResources().getColor(2131361956));
            setBackgroundResource(2131361871);
        }
    }

    public final void m1684a(ContextualItemPresenter contextualItemPresenter) {
        this.f1650c = contextualItemPresenter;
    }

    public void setHasBeenAttached(boolean z) {
        this.f1662o = z;
    }

    public final boolean m1690a() {
        return this.f1662o;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 616753486);
        super.onAttachedToWindow();
        this.f1662o = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1750986948, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1089261202);
        super.onDetachedFromWindow();
        this.f1662o = false;
        if (this.f1650c != null) {
            this.f1650c.a(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1753089690, a);
    }

    public final void m1688a(boolean z, Object obj) {
        setOnClickListener(z ? this.f1663p : null);
        setTag(obj);
        if (this.f1659l != 1) {
            setBackgroundResource(z ? 2130842709 : 2131361864);
        } else {
            setBackgroundResource(2131361871);
        }
    }

    public final void m1689a(boolean z, boolean z2) {
        if (z) {
            this.f1657j.e(0);
            this.f1657j.a(this.f1664q);
        } else {
            this.f1657j.e(8);
            this.f1657j.a(null);
        }
        this.f1658k = z2;
    }

    public final void m1683a(View view) {
        ViewNode viewNode = new ViewNode(view);
        this.f1651d.c(viewNode);
        ((LayoutParams) viewNode.f).d = 16;
    }

    public final void m1679a(int i, int i2, int i3, int i4, String str) {
        LayoutParams layoutParams = new LayoutParams(i, i);
        layoutParams.d = 16;
        layoutParams.a = true;
        this.f1652e.a(layoutParams);
        this.f1652e.a(Uri.parse("res:///" + i4), CallerContext.a(PlutoniumContextualItemView.class, str));
        this.f1652e.c(i2, i3, i2, i3);
    }

    public final void m1681a(int i, int i2, int i3, Uri uri, String str) {
        m1670a(i, 16, i2, i3, uri, str);
    }

    public final void m1680a(int i, int i2, int i3, Uri uri, GraphQLImageSizingStyle graphQLImageSizingStyle, String str) {
        m1669a(i, 16, i2, i3, uri, graphQLImageSizingStyle, str);
    }

    private void m1670a(int i, int i2, int i3, int i4, Uri uri, String str) {
        m1669a(i, i2, i3, i4, uri, GraphQLImageSizingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE, str);
    }

    private void m1669a(int i, int i2, int i3, int i4, Uri uri, GraphQLImageSizingStyle graphQLImageSizingStyle, String str) {
        LayoutParams layoutParams = new LayoutParams(i, i);
        layoutParams.d = i2;
        layoutParams.a = true;
        this.f1652e.a(layoutParams);
        this.f1652e.a(uri, CallerContext.a(PlutoniumContextualItemView.class, str, "about"));
        this.f1652e.a(m1667a(graphQLImageSizingStyle));
        this.f1652e.c(i3, i4, i3, i4);
    }

    private static ScaleType m1667a(GraphQLImageSizingStyle graphQLImageSizingStyle) {
        if (graphQLImageSizingStyle == GraphQLImageSizingStyle.NONE) {
            return ScaleType.f;
        }
        return ScaleType.g;
    }

    public final void m1682a(int i, CharSequence charSequence, int i2, int i3) {
        this.f1653f.a(i);
        m1685a(charSequence, i2, i3);
    }

    public final void m1685a(CharSequence charSequence, int i, int i2) {
        boolean z = true;
        this.f1653f.a(getResources(), (float) i2);
        TextNode textNode = this.f1653f;
        if (i != 1) {
            z = false;
        }
        textNode.a(z);
        this.f1653f.g(i);
        this.f1653f.a(TruncateAt.END);
        this.f1653f.a(charSequence);
    }

    public final void m1687a(@Nullable String str, int i, int i2) {
        boolean z = true;
        if (str == null || str.isEmpty()) {
            this.f1654g.e(8);
            return;
        }
        this.f1654g.a(getResources(), (float) i2);
        this.f1654g.a(str);
        TextNode textNode = this.f1654g;
        if (i != 1) {
            z = false;
        }
        textNode.a(z);
        this.f1654g.g(i);
        this.f1654g.e(0);
    }

    public String getUnformattedSubtitleDatetimeApplication() {
        return getResources().getString(2131235363);
    }

    public String getUnformattedSubtitleApplication() {
        return getResources().getString(2131235364);
    }

    public final void m1686a(@Nullable Integer num) {
        m1673a(num, 16);
    }

    private void m1673a(@Nullable Integer num, int i) {
        if (num != null) {
            this.f1656i.a(String.valueOf(num));
            this.f1656i.e(0);
            LayoutParams layoutParams = (LayoutParams) this.f1656i.f;
            layoutParams.d = i;
            this.f1656i.a(layoutParams);
            return;
        }
        this.f1656i.e(8);
    }

    public final void m1678a(int i, int i2) {
        setPadding(i, i2, i, i2);
    }

    public final void m1691b(int i) {
        setPadding(getPaddingLeft(), i, getPaddingRight(), i);
    }

    public final void m1692c(int i) {
        this.f1660m = i;
    }

    public void setSeparatorVisibility(boolean z) {
        this.f1661n = z;
    }

    public void setThumbnailPadding(int i) {
        this.f1651d.h(i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1661n) {
            int height = getHeight() - 1;
            canvas.drawLine((float) this.f1660m, (float) height, (float) getWidth(), (float) height, this.f1655h);
        }
    }
}

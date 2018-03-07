package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageTileView;
import com.facebook.orca.threadview.MontageStatusItemViewController.C10954;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: messenger_cymk_suggestion_hide */
public class MontageStatusItemView extends CustomLinearLayout {
    @Inject
    public MontageStatusItemViewControllerProvider f7262a;
    private final LinearLayout f7263b;
    public final MontageTileView f7264c;
    private final MontageTileView f7265d;
    private final TextView f7266e;
    private final TextView f7267f;
    private final UserTileView f7268g;
    private final UserTileView f7269h;
    public final MontageStatusItemViewController f7270i;
    private OnClickListener f7271j;
    private final Paint f7272k;
    public DefaultThreadViewTheme f7273l;
    public boolean f7274m;
    public boolean f7275n;
    public final Listener f7276o;
    private final OnClickListener f7277p;
    private final OnClickListener f7278q;

    /* compiled from: messenger_cymk_suggestion_hide */
    class C10881 implements Listener {
        final /* synthetic */ MontageStatusItemView f7258a;

        C10881(MontageStatusItemView montageStatusItemView) {
            this.f7258a = montageStatusItemView;
        }

        public final void m6928a() {
            MontageStatusItemView.m6934g(this.f7258a);
        }
    }

    /* compiled from: messenger_cymk_suggestion_hide */
    class C10892 implements OnClickListener {
        final /* synthetic */ MontageStatusItemView f7259a;

        C10892(MontageStatusItemView montageStatusItemView) {
            this.f7259a = montageStatusItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1624194285);
            this.f7259a.f7270i.m6949a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -641151913, a);
        }
    }

    /* compiled from: messenger_cymk_suggestion_hide */
    class C10903 implements OnClickListener {
        final /* synthetic */ MontageStatusItemView f7260a;

        C10903(MontageStatusItemView montageStatusItemView) {
            this.f7260a = montageStatusItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -869246600);
            this.f7260a.f7270i.m6951b(view);
            Logger.a(2, EntryType.UI_INPUT_END, 1785864193, a);
        }
    }

    /* compiled from: messenger_cymk_suggestion_hide */
    class C10914 implements OnClickListener {
        final /* synthetic */ MontageStatusItemView f7261a;

        C10914(MontageStatusItemView montageStatusItemView) {
            this.f7261a = montageStatusItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 762855177);
            this.f7261a.f7270i.m6952c();
            Logger.a(2, EntryType.UI_INPUT_END, 325617408, a);
        }
    }

    public static void m6931a(Object obj, Context context) {
        ((MontageStatusItemView) obj).f7262a = (MontageStatusItemViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(MontageStatusItemViewControllerProvider.class);
    }

    public MontageStatusItemView(Context context) {
        this(context, null);
    }

    private MontageStatusItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MontageStatusItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7276o = new C10881(this);
        this.f7277p = new C10892(this);
        this.f7278q = new C10903(this);
        Class cls = MontageStatusItemView.class;
        m6931a((Object) this, getContext());
        setOrientation(0);
        setGravity(16);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433670);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setContentView(2130905767);
        this.f7272k = new Paint(5);
        this.f7272k.setColor(ContextCompat.b(getContext(), 2131363798));
        this.f7272k.setStyle(Style.STROKE);
        this.f7272k.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427380));
        this.f7263b = (LinearLayout) a(2131563976);
        this.f7264c = (MontageTileView) a(2131564957);
        this.f7265d = (MontageTileView) a(2131564954);
        this.f7266e = (TextView) a(2131564955);
        this.f7267f = (TextView) a(2131564956);
        this.f7268g = (UserTileView) a(2131564958);
        this.f7269h = (UserTileView) a(2131564953);
        this.f7270i = this.f7262a.m6953a(this);
        this.f7264c.setOnClickListener(this.f7278q);
        this.f7265d.setOnClickListener(this.f7277p);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -935658011);
        super.onAttachedToWindow();
        MontageStatusItemViewController montageStatusItemViewController = this.f7270i;
        montageStatusItemViewController.f7284a = true;
        montageStatusItemViewController.f7292i.m6958a(montageStatusItemViewController.f7299p);
        montageStatusItemViewController.f7293j.m6958a(montageStatusItemViewController.f7299p);
        if (montageStatusItemViewController.f7296m == null) {
            montageStatusItemViewController.f7296m = ((BaseFbBroadcastManager) montageStatusItemViewController.f7286c.get()).a().a("com.facebook.orca.users.ACTION_USERS_UPDATED", new C10954(montageStatusItemViewController)).a();
        }
        montageStatusItemViewController.f7296m.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -874262610, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -581195961);
        MontageStatusItemViewController montageStatusItemViewController = this.f7270i;
        montageStatusItemViewController.f7292i.m6958a(null);
        montageStatusItemViewController.f7293j.m6958a(null);
        if (montageStatusItemViewController.f7296m != null) {
            montageStatusItemViewController.f7296m.c();
        }
        montageStatusItemViewController.f7284a = false;
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1561287068, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas.getHeight() > 0) {
            int left;
            Canvas canvas2 = canvas;
            float f = 0.0f;
            canvas2.drawLine((float) m6929a(this.f7269h), 0.0f, (float) (canvas.getWidth() - m6932b(this.f7268g)), f, this.f7272k);
            if (this.f7275n) {
                left = this.f7263b.getLeft() + (this.f7263b.getPaddingLeft() / 2);
                canvas2 = canvas;
                canvas2.drawLine((float) left, (float) this.f7263b.getTop(), (float) left, (float) this.f7263b.getBottom(), this.f7272k);
            }
            if (this.f7274m) {
                left = this.f7263b.getRight() - (this.f7263b.getPaddingRight() / 2);
                canvas2 = canvas;
                canvas2.drawLine((float) left, (float) this.f7263b.getTop(), (float) left, (float) this.f7263b.getBottom(), this.f7272k);
            }
        }
    }

    public final void m6935a() {
        this.f7264c.setAlpha(1.0f);
    }

    public final void m6937a(String str, String str2) {
        this.f7264c.setAlpha(0.6f);
        this.f7263b.setGravity(21);
        this.f7263b.setVisibility(0);
        this.f7266e.setText(str);
        this.f7267f.setText(str2);
        if (this.f7271j == null) {
            this.f7271j = new C10914(this);
        }
        this.f7263b.setOnClickListener(this.f7271j);
    }

    public final void m6941b(String str, String str2) {
        this.f7263b.setGravity(19);
        this.f7263b.setVisibility(0);
        this.f7266e.setText(str);
        this.f7267f.setText(str2);
        this.f7263b.setOnClickListener(this.f7277p);
    }

    public final void m6938b() {
        this.f7264c.setVisibility(8);
    }

    public final void m6936a(User user) {
        this.f7268g.setVisibility(0);
        this.f7268g.setParams(UserTileViewParams.a(user));
        m6930a(this.f7264c, 0);
    }

    public final void m6942c() {
        this.f7268g.setVisibility(8);
        m6930a(this.f7264c, m6932b(this.f7268g));
    }

    public final void m6939b(ThreadSummary threadSummary, MessagesCollection messagesCollection) {
        this.f7265d.setVisibility(0);
        this.f7265d.a(threadSummary, messagesCollection);
    }

    public final void m6943d() {
        this.f7265d.setVisibility(8);
    }

    public final void m6940b(User user) {
        this.f7269h.setVisibility(0);
        this.f7269h.setParams(UserTileViewParams.a(user));
        m6933b(this.f7265d, 0);
    }

    public final void m6944e() {
        this.f7269h.setVisibility(8);
        m6933b(this.f7265d, m6929a(this.f7269h));
    }

    public final void m6945f() {
        this.f7263b.setVisibility(4);
    }

    public static void m6934g(MontageStatusItemView montageStatusItemView) {
        int a = montageStatusItemView.f7273l.a(BubbleType.NORMAL, SenderType.ME);
        montageStatusItemView.f7266e.setTextColor(a);
        montageStatusItemView.f7265d.setUnreadIndicatorColor(a);
    }

    private static int m6929a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof MarginLayoutParams)) {
            return 0;
        }
        return ((MarginLayoutParams) layoutParams).leftMargin;
    }

    private static int m6932b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof MarginLayoutParams)) {
            return 0;
        }
        return ((MarginLayoutParams) layoutParams).rightMargin;
    }

    private static void m6930a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) layoutParams).rightMargin = i;
        }
    }

    private static void m6933b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) layoutParams).leftMargin = i;
        }
    }
}

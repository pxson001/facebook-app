package com.facebook.fbui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;

/* compiled from: reshare_education_info */
public class AlertController {
    public Drawable f3087A;
    public TextView f3088B;
    public CharSequence f3089C;
    public View f3090D;
    public ListAdapter f3091E;
    public int f3092F = -1;
    private int f3093G;
    public int f3094H;
    public int f3095I;
    public int f3096J;
    public int f3097K;
    public boolean f3098L = true;
    public Handler f3099M;
    private final OnClickListener f3100N = new C02221(this);
    public final Context f3101a;
    public final DialogInterface f3102b;
    private final Window f3103c;
    private CharSequence f3104d;
    private CharSequence f3105e;
    public ListView f3106f;
    private View f3107g;
    private int f3108h;
    private int f3109i;
    private int f3110j;
    private int f3111k;
    private boolean f3112l = false;
    public Button f3113m;
    private CharSequence f3114n;
    public Message f3115o;
    public Button f3116p;
    private CharSequence f3117q;
    public Message f3118r;
    public Button f3119s;
    private CharSequence f3120t;
    public Message f3121u;
    public ScrollView f3122v;
    private TextView f3123w;
    private TextView f3124x;
    public View f3125y;
    public ImageView f3126z;

    /* compiled from: reshare_education_info */
    class C02221 implements OnClickListener {
        final /* synthetic */ AlertController f3061a;

        C02221(AlertController alertController) {
            this.f3061a = alertController;
        }

        public void onClick(View view) {
            Message obtain;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1966523027);
            if (view == this.f3061a.f3113m && this.f3061a.f3115o != null) {
                obtain = Message.obtain(this.f3061a.f3115o);
            } else if (view == this.f3061a.f3116p && this.f3061a.f3118r != null) {
                obtain = Message.obtain(this.f3061a.f3118r);
            } else if (view != this.f3061a.f3119s || this.f3061a.f3121u == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.f3061a.f3121u);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            if (this.f3061a.f3098L) {
                this.f3061a.f3099M.obtainMessage(1, this.f3061a.f3102b).sendToTarget();
            }
            LogUtils.a(-2117042614, a);
        }
    }

    /* compiled from: reshare_education_info */
    final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f3086a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f3086a = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f3086a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: reshare_education_info */
    class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    public AlertController(Context context, DialogInterface dialogInterface, Window window) {
        this.f3101a = context;
        this.f3102b = dialogInterface;
        this.f3103c = window;
        this.f3099M = new ButtonHandler(dialogInterface);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, 2130772445, 0);
        this.f3093G = obtainStyledAttributes.getResourceId(0, 2130907321);
        this.f3094H = obtainStyledAttributes.getResourceId(1, 2130907324);
        this.f3095I = obtainStyledAttributes.getResourceId(2, 2130907326);
        this.f3096J = obtainStyledAttributes.getResourceId(3, 2130907327);
        this.f3097K = obtainStyledAttributes.getResourceId(4, 2130907325);
        obtainStyledAttributes.recycle();
    }

    private static boolean m4223d(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m4223d(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void m4224a() {
        this.f3103c.requestFeature(1);
        if (this.f3107g == null || !m4223d(this.f3107g)) {
            this.f3103c.setFlags(131072, 131072);
        }
        this.f3103c.setContentView(this.f3093G);
        m4221c();
    }

    public final void m4227a(CharSequence charSequence) {
        this.f3104d = charSequence;
        if (this.f3123w != null) {
            this.f3123w.setText(charSequence);
        }
    }

    public final void m4228b(CharSequence charSequence) {
        this.f3105e = charSequence;
        if (this.f3124x != null) {
            this.f3124x.setText(charSequence);
        }
    }

    public final void m4229c(View view) {
        this.f3107g = view;
        this.f3112l = false;
    }

    public final void m4226a(View view, int i, int i2, int i3, int i4) {
        this.f3107g = view;
        this.f3112l = true;
        this.f3108h = i;
        this.f3109i = i2;
        this.f3110j = i3;
        this.f3111k = i4;
    }

    public final void m4225a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f3099M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f3120t = charSequence;
                this.f3121u = message;
                return;
            case -2:
                this.f3117q = charSequence;
                this.f3118r = message;
                return;
            case -1:
                this.f3114n = charSequence;
                this.f3115o = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    private void m4221c() {
        m4217a((ViewGroup) this.f3103c.findViewById(2131561823));
        boolean d = m4222d();
        LinearLayout linearLayout = (LinearLayout) this.f3103c.findViewById(2131561821);
        TypedArray obtainStyledAttributes = this.f3101a.obtainStyledAttributes(null, R.styleable.AlertDialog, 2130772445, 0);
        m4219a(linearLayout);
        View findViewById = this.f3103c.findViewById(2131561831);
        if (!d) {
            findViewById.setVisibility(8);
            findViewById = this.f3103c.findViewById(2131561828);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        FrameLayout frameLayout = (FrameLayout) this.f3103c.findViewById(2131561830);
        View view = this.f3107g;
        int i = view != null ? 1 : 0;
        if (i == 0 || !m4223d(view)) {
            this.f3103c.setFlags(131072, 131072);
        }
        if (i != 0) {
            FrameLayout frameLayout2 = (FrameLayout) this.f3103c.findViewById(2131558962);
            frameLayout2.addView(this.f3107g, new LayoutParams(-1, -1));
            if (this.f3112l) {
                frameLayout2.setPadding(this.f3108h, this.f3109i, this.f3110j, this.f3111k);
            }
            if (this.f3106f != null) {
                ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
        } else {
            frameLayout.setVisibility(8);
        }
        if (this.f3087A != null) {
            this.f3126z = (ImageView) this.f3103c.findViewById(2131561820);
            this.f3126z.setImageDrawable(this.f3087A);
            this.f3126z.setVisibility(0);
        }
        if (!(this.f3106f == null || this.f3091E == null)) {
            this.f3106f.setAdapter(this.f3091E);
            if (this.f3092F >= 0) {
                this.f3106f.setItemChecked(this.f3092F, true);
                this.f3106f.setSelection(this.f3092F);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private boolean m4219a(LinearLayout linearLayout) {
        if (this.f3125y != null) {
            linearLayout.addView(this.f3125y, 0, new LinearLayout.LayoutParams(-1, -2));
            this.f3103c.findViewById(2131561822).setVisibility(8);
            return true;
        }
        if (!TextUtils.isEmpty(this.f3104d)) {
            this.f3123w = (TextView) this.f3103c.findViewById(2131561822);
            this.f3123w.setText(this.f3104d);
            return true;
        }
        this.f3103c.findViewById(2131561822).setVisibility(8);
        linearLayout.setVisibility(8);
        return false;
    }

    private void m4217a(ViewGroup viewGroup) {
        this.f3122v = (ScrollView) this.f3103c.findViewById(2131561825);
        this.f3122v.setFocusable(false);
        this.f3124x = (TextView) this.f3103c.findViewById(2131559674);
        if (this.f3124x != null) {
            if (this.f3105e != null) {
                this.f3124x.setText(this.f3105e);
            } else {
                this.f3124x.setVisibility(8);
                this.f3122v.removeView(this.f3124x);
                if (this.f3106f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.f3122v.getParent();
                    viewGroup2.removeView(this.f3122v);
                    viewGroup2.addView(this.f3106f, new LinearLayout.LayoutParams(-1, -1));
                } else {
                    viewGroup.setVisibility(8);
                }
            }
            LinearLayout linearLayout = (LinearLayout) this.f3103c.findViewById(2131561826);
            if (this.f3090D != null) {
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelOffset = this.f3101a.getResources().getDimensionPixelOffset(2131427464);
                this.f3090D.setPadding(dimensionPixelOffset, this.f3101a.getResources().getDimensionPixelOffset(2131427465), dimensionPixelOffset, 0);
                linearLayout.addView(this.f3090D, linearLayout.getChildCount() - 2, layoutParams);
            }
            if (this.f3089C != null) {
                this.f3088B = (TextView) this.f3103c.findViewById(2131561827);
                this.f3088B.setText(this.f3089C);
                this.f3088B.setVisibility(0);
            }
            final View findViewById = this.f3103c.findViewById(2131561824);
            final View findViewById2 = this.f3103c.findViewById(2131561829);
            if (findViewById != null || findViewById2 != null) {
                if (this.f3105e != null || this.f3088B != null) {
                    ViewTreeObserver viewTreeObserver = this.f3122v.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.addOnScrollChangedListener(new OnScrollChangedListener(this) {
                            final /* synthetic */ AlertController f3064c;

                            public void onScrollChanged() {
                                AlertController.m4220b(this.f3064c.f3122v, findViewById, findViewById2);
                            }
                        });
                    }
                    this.f3122v.post(new Runnable(this) {
                        final /* synthetic */ AlertController f3067c;

                        public void run() {
                            AlertController.m4220b(this.f3067c.f3122v, findViewById, findViewById2);
                        }
                    });
                } else if (this.f3106f != null) {
                    this.f3106f.setOnScrollListener(new OnScrollListener(this) {
                        final /* synthetic */ AlertController f3070c;

                        public void onScrollStateChanged(AbsListView absListView, int i) {
                        }

                        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                            AlertController.m4220b(absListView, findViewById, findViewById2);
                        }
                    });
                    this.f3106f.post(new Runnable(this) {
                        final /* synthetic */ AlertController f3073c;

                        public void run() {
                            AlertController.m4220b(this.f3073c.f3106f, findViewById, findViewById2);
                        }
                    });
                } else {
                    if (findViewById != null) {
                        viewGroup.removeView(findViewById);
                    }
                    if (findViewById2 != null) {
                        viewGroup.removeView(findViewById2);
                    }
                }
            }
        }
    }

    public static void m4220b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private boolean m4222d() {
        int i;
        this.f3113m = (Button) this.f3103c.findViewById(2131561834);
        this.f3113m.setOnClickListener(this.f3100N);
        if (TextUtils.isEmpty(this.f3114n)) {
            this.f3113m.setVisibility(8);
            i = 0;
        } else {
            this.f3113m.setText(this.f3114n);
            this.f3113m.setVisibility(0);
            i = 1;
        }
        this.f3116p = (Button) this.f3103c.findViewById(2131561833);
        this.f3116p.setOnClickListener(this.f3100N);
        if (TextUtils.isEmpty(this.f3117q)) {
            this.f3116p.setVisibility(8);
        } else {
            this.f3116p.setText(this.f3117q);
            this.f3116p.setVisibility(0);
            i |= 2;
        }
        this.f3119s = (Button) this.f3103c.findViewById(2131561832);
        this.f3119s.setOnClickListener(this.f3100N);
        if (TextUtils.isEmpty(this.f3120t)) {
            this.f3119s.setVisibility(8);
        } else {
            this.f3119s.setText(this.f3120t);
            this.f3119s.setVisibility(0);
            i |= 4;
        }
        Context context = this.f3101a;
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773318, typedValue, true);
        if (typedValue.data == 0) {
            z = false;
        }
        if (z) {
            if (i == 1) {
                m4218a(this.f3113m);
            } else if (i == 2) {
                m4218a(this.f3116p);
            } else if (i == 4) {
                m4218a(this.f3119s);
            }
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    private static void m4218a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}

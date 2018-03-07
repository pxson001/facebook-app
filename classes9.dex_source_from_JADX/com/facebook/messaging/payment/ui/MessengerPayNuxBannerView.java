package com.facebook.messaging.payment.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.prefs.PaymentPrefKeys;
import com.facebook.messaging.payment.ui.model.MessengerPayNuxBannerViewParam;
import com.facebook.messaging.payment.ui.model.MessengerPayNuxBannerViewParamBuilder;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/help/475643069256244 */
public class MessengerPayNuxBannerView extends CustomLinearLayout {
    @Inject
    public FbSharedPreferences f15121a;
    private FbDraweeView f15122b;
    private FbTextView f15123c;
    private FbTextView f15124d;
    private ImageView f15125e;
    private MessengerPayNuxBannerViewParam f15126f;
    public Listener f15127g;
    private int f15128h = 1;
    private int f15129i = 1;
    private PrefKey f15130j;
    private PrefKey f15131k;
    private float f15132l = 0.5f;
    private boolean f15133m;

    /* compiled from: faceweb/f?href=/help/475643069256244 */
    class C17531 implements OnClickListener {
        final /* synthetic */ MessengerPayNuxBannerView f15120a;

        C17531(MessengerPayNuxBannerView messengerPayNuxBannerView) {
            this.f15120a = messengerPayNuxBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1165070170);
            this.f15120a.f15127g.mo617a();
            Logger.a(2, EntryType.UI_INPUT_END, 939402890, a);
        }
    }

    /* compiled from: faceweb/f?href=/help/475643069256244 */
    public interface Listener {
        void mo617a();
    }

    private static <T extends View> void m15490a(Class<T> cls, T t) {
        m15491a((Object) t, t.getContext());
    }

    private static void m15491a(Object obj, Context context) {
        ((MessengerPayNuxBannerView) obj).f15121a = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    private void m15489a(FbSharedPreferences fbSharedPreferences) {
        this.f15121a = fbSharedPreferences;
    }

    public MessengerPayNuxBannerView(Context context) {
        super(new ContextThemeWrapper(context, 2131624675), null);
        m15486a(context, null);
    }

    public MessengerPayNuxBannerView(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, 2131624675), attributeSet, 0);
        m15486a(context, attributeSet);
    }

    public MessengerPayNuxBannerView(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, 2131624675), attributeSet, i);
        m15486a(context, attributeSet);
    }

    private void m15486a(Context context, AttributeSet attributeSet) {
        m15490a(MessengerPayNuxBannerView.class, (View) this);
        setContentView(2130904587);
        setBackground(new ColorDrawable(getResources().getColor(2131363744)));
        this.f15122b = (FbDraweeView) a(2131562522);
        this.f15123c = (FbTextView) a(2131559946);
        this.f15124d = (FbTextView) a(2131562528);
        this.f15125e = (ImageView) a(2131562526);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MessengerPayNuxBannerView);
        String a = ResourceUtils.a(getContext(), obtainStyledAttributes, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        Drawable drawable = resourceId > 0 ? getResources().getDrawable(resourceId) : null;
        String a2 = ResourceUtils.a(getContext(), obtainStyledAttributes, 1);
        MessengerPayNuxBannerViewParamBuilder messengerPayNuxBannerViewParamBuilder = new MessengerPayNuxBannerViewParamBuilder();
        messengerPayNuxBannerViewParamBuilder.f15152b = a;
        MessengerPayNuxBannerViewParamBuilder messengerPayNuxBannerViewParamBuilder2 = messengerPayNuxBannerViewParamBuilder;
        messengerPayNuxBannerViewParamBuilder2.f15153c = a2;
        messengerPayNuxBannerViewParamBuilder2 = messengerPayNuxBannerViewParamBuilder2;
        messengerPayNuxBannerViewParamBuilder2.f15151a = drawable;
        m15488a(new MessengerPayNuxBannerViewParam(messengerPayNuxBannerViewParamBuilder2));
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public void setListener(Listener listener) {
        this.f15127g = listener;
        this.f15125e.setOnClickListener(new C17531(this));
    }

    private void m15488a(MessengerPayNuxBannerViewParam messengerPayNuxBannerViewParam) {
        this.f15126f = messengerPayNuxBannerViewParam;
        if (StringUtil.a(this.f15126f.f15149b) && StringUtil.a(this.f15126f.f15150c)) {
            setVisibility(8);
            return;
        }
        m15497h();
        m15498i();
        m15499j();
    }

    public final void m15500a() {
        if (m15492c()) {
            if (this.f15131k != null) {
                this.f15121a.edit().a(this.f15131k, this.f15121a.a(this.f15131k, 0) + 1).commit();
            }
            m15496g();
        }
    }

    public final void m15503b() {
        if (this.f15130j != null) {
            this.f15121a.edit().a(this.f15130j, this.f15121a.a(this.f15130j, 0) + 1).commit();
        }
        m15495f();
    }

    public final void m15501a(int i, String str) {
        this.f15128h = i;
        this.f15130j = (PrefKey) PaymentPrefKeys.f13806a.a(str);
    }

    public final void m15504b(int i, String str) {
        this.f15129i = i;
        this.f15131k = (PrefKey) PaymentPrefKeys.f13806a.a(str);
    }

    private boolean m15492c() {
        return (m15494e() || m15493d()) ? false : true;
    }

    private boolean m15493d() {
        if (this.f15131k != null && this.f15121a.a(this.f15131k, 0) >= this.f15129i) {
            return true;
        }
        return false;
    }

    private boolean m15494e() {
        if (this.f15130j != null && this.f15121a.a(this.f15130j, 0) >= this.f15128h) {
            return true;
        }
        return false;
    }

    private void m15495f() {
        setVisibility(8);
    }

    private void m15496g() {
        setVisibility(0);
    }

    public final void m15502a(boolean z, float f) {
        this.f15133m = z;
        this.f15132l = f;
        invalidate();
    }

    private void m15497h() {
        if (this.f15126f.f15148a == null) {
            this.f15122b.setVisibility(8);
            return;
        }
        this.f15122b.setImageDrawable(this.f15126f.f15148a);
        this.f15122b.setVisibility(0);
    }

    private void m15498i() {
        if (StringUtil.a(this.f15126f.f15149b)) {
            this.f15123c.setVisibility(8);
            return;
        }
        this.f15123c.setText(this.f15126f.f15149b);
        this.f15123c.setVisibility(0);
    }

    private void m15499j() {
        if (StringUtil.a(this.f15126f.f15150c)) {
            this.f15124d.setVisibility(8);
            return;
        }
        this.f15124d.setText(this.f15126f.f15150c);
        this.f15124d.setVisibility(0);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f15133m) {
            float dimension = getResources().getDimension(2131433438);
            canvas.save();
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(0, -((int) dimension));
            canvas.clipRect(clipBounds, Op.REPLACE);
            m15487a(canvas, dimension);
            canvas.restore();
        }
    }

    private void m15487a(Canvas canvas, float f) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(2131363744));
        paint.setStyle(Style.FILL);
        if (this.f15132l > 1.0f || this.f15132l < 0.0f) {
            this.f15132l = 0.5f;
        }
        Point point = new Point(((int) (((float) getWidth()) * this.f15132l)) - ((int) f), 0);
        Point point2 = new Point(((int) (((float) getWidth()) * this.f15132l)) + ((int) f), 0);
        Point point3 = new Point((int) (((float) getWidth()) * this.f15132l), -((int) f));
        Path path = new Path();
        path.setFillType(FillType.EVEN_ODD);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        path.lineTo((float) point.x, (float) point.y);
        path.close();
        canvas.drawPath(path, paint);
    }
}

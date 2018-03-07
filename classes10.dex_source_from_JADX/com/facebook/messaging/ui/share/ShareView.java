package com.facebook.messaging.ui.share;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.share.ShareMedia.Type;
import com.facebook.messaging.ui.text.MultilineEllipsizeTextView;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_category_ids */
public class ShareView extends CustomRelativeLayout {
    private static final CallerContext f4871a = CallerContext.a(ShareView.class, "thread_view_module");
    private MessageUtil f4872b;
    private View f4873c;
    private FbDraweeView f4874d;
    private MultilineEllipsizeTextView f4875e;
    private MultilineEllipsizeTextView f4876f;
    private Drawable f4877g;
    private TextView f4878h;
    private TextView f4879i;
    private FbDraweeControllerBuilder f4880j;
    public Share f4881k;
    private int f4882l;
    private int f4883m;
    private boolean f4884n;
    private boolean f4885o;
    private final ControllerListener f4886p;
    public Listener f4887q;

    /* compiled from: place_category_ids */
    class C06661 implements OnClickListener {
        final /* synthetic */ ShareView f4868a;

        C06661(ShareView shareView) {
            this.f4868a = shareView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -595886680);
            if (this.f4868a.f4887q != null) {
                this.f4868a.f4887q.mo263a(this.f4868a.f4881k);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2010153920, a);
        }
    }

    /* compiled from: place_category_ids */
    class C06672 implements OnLongClickListener {
        final /* synthetic */ ShareView f4869a;

        C06672(ShareView shareView) {
            this.f4869a = shareView;
        }

        public boolean onLongClick(View view) {
            if (this.f4869a.f4887q == null) {
                return false;
            }
            this.f4869a.f4887q.mo264b(this.f4869a.f4881k);
            return true;
        }
    }

    /* compiled from: place_category_ids */
    class C06683 extends BaseControllerListener {
        final /* synthetic */ ShareView f4870a;

        C06683(ShareView shareView) {
            this.f4870a = shareView;
        }

        public final void m4399a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (this.f4870a.f4887q != null) {
                this.f4870a.f4887q.mo262a();
            }
        }
    }

    /* compiled from: place_category_ids */
    public interface Listener {
        void mo262a();

        void mo263a(Share share);

        void mo264b(Share share);
    }

    private static <T extends View> void m4405a(Class<T> cls, T t) {
        m4406a((Object) t, t.getContext());
    }

    private static void m4406a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ShareView) obj).m4404a(MessageUtil.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector));
    }

    public ShareView(Context context) {
        this(context, null);
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4885o = true;
        m4405a(ShareView.class, (View) this);
        setContentView(2130905849);
        this.f4873c = findViewById(2131565119);
        this.f4874d = (FbDraweeView) findViewById(2131565121);
        this.f4875e = (MultilineEllipsizeTextView) findViewById(2131565122);
        this.f4876f = (MultilineEllipsizeTextView) findViewById(2131565124);
        this.f4878h = (TextView) findViewById(2131565120);
        this.f4879i = (TextView) findViewById(2131565123);
        this.f4877g = context.getResources().getDrawable(2130842290);
        OnClickListener c06661 = new C06661(this);
        setOnClickListener(c06661);
        this.f4875e.setOnClickListener(c06661);
        OnLongClickListener c06672 = new C06672(this);
        setOnLongClickListener(c06672);
        this.f4875e.setOnLongClickListener(c06672);
        this.f4886p = new C06683(this);
        setWillNotDraw(false);
        this.f4882l = SizeUtil.a(context, 4.0f);
        int a = SizeUtil.a(context, 14.0f);
        setPadding(a, 0, a, SizeUtil.a(context, 8.0f));
    }

    @Inject
    private void m4404a(MessageUtil messageUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4872b = messageUtil;
        this.f4880j = fbDraweeControllerBuilder;
    }

    public Share getShare() {
        return this.f4881k;
    }

    public void setShare(Share share) {
        this.f4881k = share;
        m4408b();
    }

    public void setShareNameTextColor(int i) {
        this.f4883m = i;
        if (this.f4881k != null) {
            m4408b();
        }
    }

    public void setForMeUser(boolean z) {
        this.f4884n = z;
        if (this.f4881k != null) {
            m4408b();
        }
    }

    public void setShowDividingLine(boolean z) {
        this.f4885o = z;
        if (this.f4881k != null) {
            m4408b();
        }
    }

    public void setListener(Listener listener) {
        this.f4887q = listener;
    }

    private void m4408b() {
        int color = getResources().getColor(this.f4884n ? 2131362272 : 2131362273);
        if (this.f4885o) {
            this.f4873c.setVisibility(0);
            this.f4873c.setBackgroundColor(getResources().getColor(this.f4884n ? 2131362274 : 2131362275));
        } else {
            this.f4873c.setVisibility(8);
        }
        if (StringUtil.a(this.f4881k.c)) {
            this.f4875e.setVisibility(8);
        } else {
            this.f4875e.setVisibility(0);
            this.f4875e.setText(this.f4881k.c);
            this.f4875e.setTextColor(this.f4883m);
        }
        if (StringUtil.a(this.f4881k.e)) {
            this.f4876f.setVisibility(8);
        } else {
            this.f4876f.setVisibility(0);
            this.f4876f.setText(this.f4881k.e);
            this.f4876f.setTextColor(color);
        }
        if (StringUtil.a(this.f4881k.d)) {
            this.f4879i.setVisibility(8);
        } else {
            this.f4879i.setVisibility(0);
            this.f4879i.setText(this.f4881k.d);
            this.f4879i.setTextColor(color);
        }
        OpenGraphActionRobotext openGraphActionRobotext = this.f4881k.i;
        if (openGraphActionRobotext == null || StringUtil.a(openGraphActionRobotext.a)) {
            this.f4878h.setVisibility(8);
        } else {
            this.f4878h.setVisibility(0);
            this.f4878h.setText(openGraphActionRobotext.a);
            this.f4878h.setTextColor(color);
        }
        m4410c();
    }

    private void m4410c() {
        ShareMedia a = MessageUtil.a(this.f4881k);
        if (a == null || StringUtil.a(a.c)) {
            this.f4874d.setVisibility(8);
            return;
        }
        if (Type.PHOTO.equals(a.a)) {
            this.f4874d.setBackgroundResource(2130842055);
        } else {
            this.f4874d.setBackgroundDrawable(null);
        }
        int c = m4409c(2131428534);
        Uri parse = Uri.parse(a.c);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(parse);
        a2.d = new ResizeOptions(c, c);
        ImageRequest m = a2.m();
        if (parse.isAbsolute()) {
            this.f4874d.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f4880j.a(f4871a).b(this.f4874d.getController())).c(m)).a(this.f4886p)).s());
            this.f4874d.setVisibility(0);
            return;
        }
        this.f4874d.setController(null);
        this.f4874d.setVisibility(8);
    }

    private int m4409c(int i) {
        LayoutParams layoutParams = this.f4874d.getLayoutParams();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i);
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        return dimensionPixelSize;
    }

    final void m4411a() {
        invalidate(getShareNameRect());
    }

    public FbDraweeView getThumbnail() {
        return this.f4874d;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect shareNameRect = getShareNameRect();
        this.f4877g.setState(this.f4875e.getDrawableState());
        this.f4877g.setBounds(shareNameRect);
        this.f4877g.draw(canvas);
    }

    private Rect getShareNameRect() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.f4875e.getGlobalVisibleRect(rect);
        getGlobalVisibleRect(rect2);
        rect.offset(-rect2.left, -rect2.top);
        rect.left -= this.f4882l;
        rect.top -= this.f4882l;
        rect.bottom += this.f4882l;
        rect.right += this.f4882l;
        return rect;
    }
}

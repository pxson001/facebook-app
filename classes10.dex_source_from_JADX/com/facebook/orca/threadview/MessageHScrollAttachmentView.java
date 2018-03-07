package com.facebook.orca.threadview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.xma.XMAActionHandlerManager;
import com.facebook.messaging.xma.hscroll.HScrollAttachmentContainer;
import com.facebook.messaging.xma.hscroll.HScrollAttachmentContainer.OnPageChangeListener;
import com.facebook.orca.threadview.MessageListAdapter.Listener;
import com.facebook.orca.threadview.RowItemUiUtil.BubbleCornerRadius;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.ListViewItemWithData;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_videos_too_big_dialog */
public class MessageHScrollAttachmentView extends CustomFrameLayout implements ListViewItemWithData<RowMessageItem> {
    @Inject
    public UserTileViewParamsFactory f7043a;
    @Inject
    public RowItemUiUtil f7044b;
    @Inject
    public MessageXMACallbackHelper f7045c;
    private final int f7046d;
    private final boolean f7047e;
    public int f7048f = 0;
    public XMAActionHandlerManager<Message> f7049g;
    @Nullable
    public RowMessageItem f7050h;
    @Nullable
    public Listener f7051i;
    public final UserTileView f7052j;
    private final HScrollAttachmentContainer f7053k;
    private final BubbleCornerRadius f7054l;
    public final ThreadViewTheme.Listener f7055m = new C10561(this);
    public DefaultThreadViewTheme f7056n;

    /* compiled from: messenger_videos_too_big_dialog */
    class C10561 implements ThreadViewTheme.Listener {
        final /* synthetic */ MessageHScrollAttachmentView f7040a;

        C10561(MessageHScrollAttachmentView messageHScrollAttachmentView) {
            this.f7040a = messageHScrollAttachmentView;
        }

        public final void m6618a() {
        }
    }

    /* compiled from: messenger_videos_too_big_dialog */
    class C10572 implements OnPageChangeListener {
        final /* synthetic */ MessageHScrollAttachmentView f7041a;

        C10572(MessageHScrollAttachmentView messageHScrollAttachmentView) {
            this.f7041a = messageHScrollAttachmentView;
        }

        public final void m6620a(int i, int i2) {
            if (this.f7041a.f7052j.getVisibility() != 8 && i == 0) {
                if (((float) i2) >= ((float) this.f7041a.f7052j.getWidth()) * 2.0f) {
                    this.f7041a.f7052j.setVisibility(4);
                } else {
                    this.f7041a.f7052j.setVisibility(this.f7041a.f7048f);
                }
            }
        }

        public final void m6619a(int i) {
            if (this.f7041a.f7050h != null) {
                this.f7041a.f7050h.f4755x = i;
            }
        }
    }

    /* compiled from: messenger_videos_too_big_dialog */
    class C10583 implements OnLongClickListener {
        final /* synthetic */ MessageHScrollAttachmentView f7042a;

        C10583(MessageHScrollAttachmentView messageHScrollAttachmentView) {
            this.f7042a = messageHScrollAttachmentView;
        }

        public boolean onLongClick(View view) {
            boolean z;
            MessageHScrollAttachmentView messageHScrollAttachmentView = this.f7042a;
            if (messageHScrollAttachmentView.f7050h == null || messageHScrollAttachmentView.f7051i == null) {
                z = false;
            } else {
                z = messageHScrollAttachmentView.f7051i.mo292a(messageHScrollAttachmentView.f7050h);
            }
            return z;
        }
    }

    private static <T extends View> void m6622a(Class<T> cls, T t) {
        m6623a((Object) t, t.getContext());
    }

    private static void m6623a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessageHScrollAttachmentView messageHScrollAttachmentView = (MessageHScrollAttachmentView) obj;
        UserTileViewParamsFactory a = UserTileViewParamsFactory.a(fbInjector);
        RowItemUiUtil a2 = RowItemUiUtil.m7015a(fbInjector);
        MessageXMACallbackHelper a3 = MessageXMACallbackHelper.m6918a(fbInjector);
        messageHScrollAttachmentView.f7043a = a;
        messageHScrollAttachmentView.f7044b = a2;
        messageHScrollAttachmentView.f7045c = a3;
    }

    public MessageHScrollAttachmentView(Context context, boolean z) {
        super(context, null);
        TracerDetour.a("MessageHScrollAttachmentView.ctor", 1398873085);
        try {
            m6622a(MessageHScrollAttachmentView.class, (View) this);
            this.f7047e = z;
            this.f7054l = new BubbleCornerRadius();
            setContentView(2130905728);
            this.f7053k = (HScrollAttachmentContainer) c(2131564909);
            this.f7052j = (UserTileView) c(2131564859);
            this.f7052j.setVisibility(this.f7047e ? 8 : 0);
            this.f7046d = ContextUtils.d(context, 2130773131, 0);
            m6624b();
            m6621a();
        } finally {
            TracerDetour.a(1494081181);
        }
    }

    public /* bridge */ /* synthetic */ Object getDataItem() {
        return this.f7050h;
    }

    public void setRowMessageItem(@Nullable RowMessageItem rowMessageItem) {
        TracerDetour.a("MessageHScrollAttachmentView.setRowMessageItem", -1273954634);
        try {
            this.f7050h = rowMessageItem;
            if (this.f7050h != null) {
                m6625e();
                this.f7044b.m7020a(this.f7047e, this.f7050h.f4737f, this.f7054l);
                this.f7053k.a(this.f7054l.m7011a(), this.f7054l.m7012b(), this.f7054l.m7013c(), this.f7054l.m7014d());
                this.f7053k.a(this.f7050h.f4732a.G, this.f7050h.m4314m());
                this.f7053k.getAdapter().a(this.f7045c.m6919a(this.f7050h.m4308c(), this.f7049g, null, null));
            }
            TracerDetour.a(707752703);
        } catch (Throwable th) {
            TracerDetour.a(-809664013);
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m6621a() {
        this.f7053k.i = new C10572(this);
        this.f7053k.setOnLongClickListener(new C10583(this));
    }

    private void m6624b() {
        int dimensionPixelSize;
        int dimensionPixelOffset;
        if (this.f7047e) {
            dimensionPixelSize = getResources().getDimensionPixelSize(2131428622);
            dimensionPixelOffset = getResources().getDimensionPixelOffset(2131428590);
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f7052j.getLayoutParams();
            dimensionPixelSize = (marginLayoutParams.width + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
            dimensionPixelOffset = getResources().getDimensionPixelSize(2131428623);
        }
        this.f7053k.a(dimensionPixelSize, dimensionPixelOffset);
    }

    private void m6625e() {
        TracerDetour.a("MessageHScrollAttachmentView.updateUserBadging", 1091234411);
        try {
            LayoutParams layoutParams = (LayoutParams) this.f7052j.getLayoutParams();
            layoutParams.gravity = 83;
            this.f7052j.setLayoutParams(layoutParams);
            if (!(this.f7047e || this.f7050h == null)) {
                this.f7048f = this.f7050h.f4737f.groupWithNewerRow ? this.f7046d : 0;
                this.f7052j.setVisibility(this.f7048f);
                this.f7052j.setParams(this.f7043a.a(this.f7050h.f4732a.e.b));
            }
            TracerDetour.a(-322876977);
        } catch (Throwable th) {
            TracerDetour.a(1887674587);
        }
    }
}

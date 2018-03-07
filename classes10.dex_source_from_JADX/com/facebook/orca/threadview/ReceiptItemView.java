package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.common.ui.widgets.text.RowReceiptTextView;
import com.facebook.messaging.common.ui.widgets.text.RowReceiptTextView.Data;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.VideoData;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.threads.util.ThreadSourceUtil;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messages/thread/%s */
public class ReceiptItemView extends CustomFrameLayout {
    private static final Class<?> f7349c = ReceiptItemView.class;
    @Inject
    public ThreadSourceUtil f7350a;
    @Inject
    public MessagingDateUtil f7351b;
    public final RowReceiptTextView f7352d;
    private final Optional<ImageView> f7353e;
    private final int f7354f;
    public final Listener f7355g;
    public RowReceiptItem f7356h;
    public DefaultThreadViewTheme f7357i;

    /* compiled from: messages/thread/%s */
    class C11031 implements Listener {
        final /* synthetic */ ReceiptItemView f7347a;

        C11031(ReceiptItemView receiptItemView) {
            this.f7347a = receiptItemView;
        }

        public final void m6982a() {
            ReceiptItemView.m6992k(this.f7347a);
        }
    }

    public static void m6984a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReceiptItemView receiptItemView = (ReceiptItemView) obj;
        ThreadSourceUtil threadSourceUtil = new ThreadSourceUtil(ResourcesMethodAutoProvider.a(fbInjector));
        MessagingDateUtil a = MessagingDateUtil.a(fbInjector);
        receiptItemView.f7350a = threadSourceUtil;
        receiptItemView.f7351b = a;
    }

    public ReceiptItemView(Context context, boolean z) {
        this(context, null, z);
    }

    private ReceiptItemView(Context context, @Nullable AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f7355g = new C11031(this);
        Class cls = ReceiptItemView.class;
        m6984a((Object) this, getContext());
        setContentView(ContextUtils.b(context, 2130773158, 2130905837));
        this.f7353e = d(2131565098);
        this.f7352d = (RowReceiptTextView) c(2131565099);
        ViewGroup viewGroup = (ViewGroup) c(2131565097);
        int e = ContextUtils.e(context, 2130773160, 0);
        int e2 = ContextUtils.e(context, 2130773161, 0);
        LayoutParams layoutParams = (LayoutParams) viewGroup.getLayoutParams();
        if (z) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = e2;
            layoutParams.gravity = 5;
        } else {
            layoutParams.leftMargin = e;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 3;
        }
        this.f7354f = ContextUtils.e(context, 2130773136, 0);
    }

    public void setRowReceiptItem(RowReceiptItem rowReceiptItem) {
        if (this.f7353e.isPresent()) {
            ((ImageView) this.f7353e.get()).setVisibility(8);
        }
        this.f7356h = rowReceiptItem;
        setPadding(0, this.f7354f, 0, 0);
        switch (rowReceiptItem.f4761d) {
            case SENT_FROM_RECEIPT:
                String str;
                Message message = this.f7356h.f4758a;
                if (message.i.isEmpty() || message.i.size() > 1) {
                    str = null;
                } else {
                    VideoData videoData = ((Attachment) message.i.get(0)).h;
                    if (videoData == null || videoData.e != Source.QUICKCAM) {
                        ImageData imageData = ((Attachment) message.i.get(0)).g;
                        str = (imageData == null || imageData.e != ImageData.Source.QUICKCAM) ? null : "quickcam photo";
                    } else {
                        str = "quickcam video";
                    }
                }
                String str2 = str;
                if (str2 != null) {
                    str2 = this.f7350a.a(str2);
                } else {
                    str2 = this.f7350a.a(this.f7356h.f4758a.p);
                }
                this.f7352d.setData(new Data(str2));
                return;
            case READ:
                m6985b();
                return;
            case DELIVERED:
                m6986e();
                return;
            case GROUP_READ:
                m6987f();
                return;
            case PENDING:
                m6988g();
                return;
            case SENT_BY_ME_TO_SERVER:
                m6990i();
                return;
            case FAILED_TO_SEND:
                m6989h();
                return;
            default:
                return;
        }
    }

    private void m6985b() {
        m6991j();
        long j = this.f7356h.f4762e;
        String str = "";
        if (j != -1) {
            str = this.f7351b.b(j);
        }
        this.f7352d.setData(new Data(getContext().getString(2131231543, new Object[]{str})));
    }

    private void m6986e() {
        this.f7352d.setData(new Data(getContext().getString(2131231542)));
        if (!StringUtil.a(this.f7356h.f4758a.p)) {
            setIcon(2130842116);
        }
    }

    private void m6987f() {
        m6991j();
        int size = this.f7356h.f4759b.size();
        if (!this.f7356h.f4764g) {
            size++;
        }
        if (this.f7356h.f4763f - 1 == size && this.f7356h.f4763f == 3 && this.f7356h.f4759b.size() == 1) {
            long j = ((RowReceiptParticipant) this.f7356h.f4759b.get(0)).c;
            if (j == -1) {
                this.f7352d.setData(new Data(getContext().getString(2131231546, new Object[]{r0.b.c})));
                return;
            }
            String b = this.f7351b.b(j);
            this.f7352d.setData(new Data(getContext().getString(2131231547, new Object[]{r0.b.c, b})));
        } else if (this.f7356h.f4763f - 1 == size) {
            this.f7352d.setData(new Data(getContext().getString(2131231545)));
        } else {
            this.f7352d.setData(new Data(this.f7356h.f4759b));
        }
    }

    private void m6988g() {
        setText(2131231237);
    }

    private void m6989h() {
        setText(2131231240);
    }

    private void m6990i() {
        long j = this.f7356h.f4758a.c;
        String str = "";
        if (j != -1) {
            str = this.f7351b.b(j);
        }
        m6983a(2131231541, str);
    }

    private void setText(int i) {
        m6983a(i, null);
    }

    private void m6983a(int i, String str) {
        if (StringUtil.a(new CharSequence[]{str})) {
            this.f7352d.setText(getResources().getString(i));
        } else {
            this.f7352d.setText(getResources().getString(i, new Object[]{str}));
        }
        this.f7352d.setVisibility(0);
    }

    private void m6991j() {
        if (this.f7353e.isPresent()) {
            setIcon(ContextUtils.b(getContext(), 2130773163, 2130842255));
        }
    }

    private void setIcon(int i) {
        if (this.f7353e.isPresent()) {
            ((ImageView) this.f7353e.get()).setImageResource(i);
            ((ImageView) this.f7353e.get()).setVisibility(0);
        }
    }

    public static void m6992k(ReceiptItemView receiptItemView) {
        receiptItemView.f7352d.setTextColor(receiptItemView.f7357i.d());
    }
}

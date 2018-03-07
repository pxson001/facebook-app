package com.facebook.orca.threadview.montage;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.model.messages.Message;
import com.facebook.orca.threadview.MessageItemView;
import com.facebook.orca.threadview.MessageListAdapter;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerView.MessageListItemViewHolder;
import com.facebook.orca.threadview.RowMessageItemGenerator;
import com.facebook.orca.threadview.montage.MontageReplyMessageViewHelper.MessageItemListener;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: manageBlockingFragment */
public class MontageViewerReplyContainer extends LinearLayout {
    private static final SpringConfig f8298c = new SpringConfig(30.0d, 20.0d);
    @Inject
    SpringSystem f8299a;
    @Inject
    Lazy<MontageReplyMessageViewHelper> f8300b;
    @Nullable
    public DefaultThreadViewTheme f8301d;

    private static <T extends View> void m8262a(Class<T> cls, T t) {
        m8263a((Object) t, t.getContext());
    }

    private static void m8263a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MontageViewerReplyContainer) obj).m8261a(SpringSystem.b(fbInjector), IdBasedLazy.a(fbInjector, 8886));
    }

    public MontageViewerReplyContainer(Context context) {
        this(context, null);
    }

    public MontageViewerReplyContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageViewerReplyContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8262a(MontageViewerReplyContainer.class, (View) this);
        setOrientation(1);
        setGravity(80);
    }

    protected void measureChild(View view, int i, int i2) {
        super.measureChild(view, i, m8258a());
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -687289183);
        super.measureChildWithMargins(view, i, i2, m8258a(), i4);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1456824619, a);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        MarginLayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        generateDefaultLayoutParams.bottomMargin = ContextUtils.e(getContext(), 2130773135, generateDefaultLayoutParams.bottomMargin);
        return generateDefaultLayoutParams;
    }

    private void m8261a(SpringSystem springSystem, Lazy<MontageReplyMessageViewHelper> lazy) {
        this.f8299a = springSystem;
        this.f8300b = lazy;
    }

    public final void m8265a(Message message) {
        MontageReplyMessageViewHelper montageReplyMessageViewHelper = (MontageReplyMessageViewHelper) this.f8300b.get();
        DefaultThreadViewTheme defaultThreadViewTheme = this.f8301d;
        if (montageReplyMessageViewHelper.f8261d == null) {
            montageReplyMessageViewHelper.f8261d = montageReplyMessageViewHelper.f8260c.m6911a((MessageListAdapter) montageReplyMessageViewHelper.f8258a.get());
        }
        montageReplyMessageViewHelper.f8261d.m6908a(ImmutableList.of(((RowMessageItemGenerator) montageReplyMessageViewHelper.f8259b.get()).m7049a(message)));
        MessageListItemViewHolder messageListItemViewHolder = (MessageListItemViewHolder) montageReplyMessageViewHelper.f8261d.b(null, montageReplyMessageViewHelper.f8261d.getItemViewType(0));
        montageReplyMessageViewHelper.f8261d.m6907a(messageListItemViewHolder, 0);
        if (messageListItemViewHolder.a instanceof MessageItemView) {
            MessageItemView messageItemView = (MessageItemView) messageListItemViewHolder.a;
            messageItemView.setThreadViewTheme(defaultThreadViewTheme);
            messageItemView.bg = new MessageItemListener();
        }
        View view = messageListItemViewHolder.a;
        addView(view, generateDefaultLayoutParams());
        m8259a(view);
    }

    private void m8259a(final View view) {
        postDelayed(new Runnable(this) {
            final /* synthetic */ MontageViewerReplyContainer f8295b;

            public void run() {
                if (this.f8295b.indexOfChild(view) >= 0) {
                    MontageViewerReplyContainer.m8264b(this.f8295b, view);
                }
            }
        }, 5000);
    }

    public static void m8264b(MontageViewerReplyContainer montageViewerReplyContainer, final View view) {
        montageViewerReplyContainer.f8299a.a().a(f8298c).a(0.0d).b(-200.0d).a(new SimpleSpringListener(montageViewerReplyContainer) {
            final /* synthetic */ MontageViewerReplyContainer f8297b;

            public final void m8256a(Spring spring) {
                if (this.f8297b.indexOfChild(view) >= 0) {
                    float d = (float) spring.d();
                    float f = (float) (((double) d) / spring.i);
                    view.setTranslationY(d);
                    if (Float.compare(f, 0.8f) >= 0) {
                        view.setAlpha((1.0f - f) / 0.19999999f);
                    }
                }
            }

            public final void m8257b(Spring spring) {
                this.f8297b.removeView(view);
            }
        });
    }

    private static int m8258a() {
        return MeasureSpec.makeMeasureSpec(0, 0);
    }
}

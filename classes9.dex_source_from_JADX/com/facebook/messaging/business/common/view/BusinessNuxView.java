package com.facebook.messaging.business.common.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.helper.BusinessViewAnimationHelper;
import com.facebook.messaging.business.common.helper.BusinessViewAnimationHelper.C10011;
import com.facebook.messaging.business.common.model.BusinessNuxItem;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme$Listener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: native_signup_params */
public class BusinessNuxView extends CustomLinearLayout {
    @Inject
    @ForUiThread
    public ExecutorService f8792a;
    public final BetterTextView f8793b;
    private final LinearLayout[] f8794c;
    private AnimatorSet f8795d;
    @Nullable
    public ThreadKey f8796e;
    @Nullable
    public ListenableFuture<BusinessNuxItem> f8797f;
    public DefaultThreadViewTheme f8798g;
    public final FutureCallback<BusinessNuxItem> f8799h;
    public final ThreadViewTheme$Listener f8800i;

    /* compiled from: native_signup_params */
    class C10061 implements FutureCallback<BusinessNuxItem> {
        final /* synthetic */ BusinessNuxView f8790a;

        C10061(BusinessNuxView businessNuxView) {
            this.f8790a = businessNuxView;
        }

        public void onSuccess(@Nullable Object obj) {
            BusinessNuxItem businessNuxItem = (BusinessNuxItem) obj;
            if (businessNuxItem != null) {
                CharSequence string;
                if (businessNuxItem.f8784a == null) {
                    string = this.f8790a.getContext().getResources().getString(2131236788);
                } else {
                    Object obj2 = businessNuxItem.f8784a;
                }
                this.f8790a.f8793b.setText(string);
                BusinessNuxView.m9030a(this.f8790a, businessNuxItem.f8785b);
                this.f8790a.setVisibility(0);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: native_signup_params */
    class C10072 implements ThreadViewTheme$Listener {
        final /* synthetic */ BusinessNuxView f8791a;

        C10072(BusinessNuxView businessNuxView) {
            this.f8791a = businessNuxView;
        }

        public final void mo320a() {
            BusinessNuxView.m9029a(this.f8791a);
        }
    }

    public static void m9031a(Object obj, Context context) {
        ((BusinessNuxView) obj).f8792a = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(FbInjector.get(context));
    }

    public BusinessNuxView(Context context) {
        this(context, null, 0);
    }

    private BusinessNuxView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8799h = new C10061(this);
        this.f8800i = new C10072(this);
        Class cls = BusinessNuxView.class;
        m9031a((Object) this, getContext());
        setContentView(2130903468);
        this.f8793b = (BetterTextView) a(2131560099);
        this.f8794c = new LinearLayout[]{(LinearLayout) a(2131560100), (LinearLayout) a(2131560101)};
        LinearLayout[] linearLayoutArr = this.f8794c;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(BusinessViewAnimationHelper.m9021a(linearLayoutArr[0], linearLayoutArr[1])).before(BusinessViewAnimationHelper.m9021a(linearLayoutArr[1], linearLayoutArr[0]));
        animatorSet.addListener(new C10011());
        this.f8795d = animatorSet;
        setOrientation(1);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1829853360);
        super.onAttachedToWindow();
        this.f8795d.start();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2146151402, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2013082416);
        super.onDetachedFromWindow();
        this.f8795d.end();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1347080845, a);
    }

    public static void m9029a(BusinessNuxView businessNuxView) {
        int d = businessNuxView.f8798g.m10895d();
        businessNuxView.f8793b.setTextColor(d);
        for (ViewGroup viewGroup : businessNuxView.f8794c) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                ((BetterTextView) viewGroup.getChildAt(i)).setTextColor(d);
            }
        }
    }

    public static void m9030a(BusinessNuxView businessNuxView, String[] strArr) {
        int i;
        int length = strArr.length;
        for (i = 0; i < length / 2; i++) {
            businessNuxView.m9032a(strArr[i], businessNuxView.f8794c[0]);
        }
        for (i = length / 2; i < length; i++) {
            businessNuxView.m9032a(strArr[i], businessNuxView.f8794c[1]);
        }
        businessNuxView.f8794c[1].setAlpha(0.0f);
    }

    private void m9032a(String str, ViewGroup viewGroup) {
        LayoutInflater.from(getContext()).inflate(2130903469, viewGroup);
        ((BetterTextView) viewGroup.getChildAt(viewGroup.getChildCount() - 1)).setText(str);
    }
}

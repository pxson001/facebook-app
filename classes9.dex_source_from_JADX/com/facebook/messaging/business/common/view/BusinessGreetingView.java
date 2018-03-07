package com.facebook.messaging.business.common.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.business.common.model.BusinessGreetingItem;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nav_section */
public class BusinessGreetingView extends CustomFrameLayout {
    @Inject
    @ForUiThread
    public ExecutorService f8787a;
    public final BetterTextView f8788b;
    @Nullable
    public Long f8789c;

    /* compiled from: nav_section */
    public class C10051 implements FutureCallback<BusinessGreetingItem> {
        final /* synthetic */ BusinessGreetingView f8786a;

        public C10051(BusinessGreetingView businessGreetingView) {
            this.f8786a = businessGreetingView;
        }

        public void onSuccess(@Nullable Object obj) {
            Object obj2;
            BusinessGreetingItem businessGreetingItem = (BusinessGreetingItem) obj;
            if (businessGreetingItem == null || !businessGreetingItem.f8782a || StringUtil.c(businessGreetingItem.f8783b)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                this.f8786a.setVisibility(0);
                this.f8786a.f8788b.setText(businessGreetingItem.f8783b);
            }
        }

        public void onFailure(Throwable th) {
            BLog.a(BusinessGreetingView.class, "fail to load greeting item", th);
        }
    }

    public static void m9026a(Object obj, Context context) {
        ((BusinessGreetingView) obj).f8787a = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(FbInjector.get(context));
    }

    public BusinessGreetingView(Context context) {
        this(context, null);
    }

    private BusinessGreetingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private BusinessGreetingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903466);
        Class cls = BusinessGreetingView.class;
        m9026a(this, getContext());
        this.f8788b = (BetterTextView) c(2131560094);
    }
}

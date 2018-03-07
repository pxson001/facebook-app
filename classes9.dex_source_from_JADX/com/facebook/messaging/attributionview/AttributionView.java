package com.facebook.messaging.attributionview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attributionview.AttributionViewData.DataChangeListener;
import com.facebook.messaging.composershortcuts.ComposerButtonColorUtil;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: other_user */
public class AttributionView extends CustomLinearLayout {
    private static final CallerContext f7936e = CallerContext.a(AttributionView.class, "thread_view_module");
    private static final CallerContext f7937f = CallerContext.a(AttributionView.class, "thread_view_module");
    @Inject
    public ComposerButtonColorUtil f7938a;
    @VisibleForTesting
    TextView f7939b;
    @VisibleForTesting
    TextView f7940c;
    @VisibleForTesting
    FbDraweeView f7941d;
    private final DataChangeListener f7942g = new C08881(this);
    public AttributionViewData f7943h;
    @Nullable
    public AttributionActionType f7944i;
    @Nullable
    public Listener f7945j;
    @Nullable
    public LoggingListener f7946k;

    /* compiled from: other_user */
    public interface LoggingListener {
        void mo289a(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType);

        void mo290b(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType);
    }

    /* compiled from: other_user */
    class C08881 implements DataChangeListener {
        final /* synthetic */ AttributionView f7933a;

        C08881(AttributionView attributionView) {
            this.f7933a = attributionView;
        }

        public final void mo291a() {
            this.f7933a.m8156b();
            this.f7933a.f7946k;
            this.f7933a.m8158c();
        }
    }

    /* compiled from: other_user */
    class C08892 implements OnClickListener {
        final /* synthetic */ AttributionView f7934a;

        C08892(AttributionView attributionView) {
            this.f7934a = attributionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -161844569);
            if (this.f7934a.f7946k != null) {
                this.f7934a.f7946k.mo290b(this.f7934a.f7943h, this.f7934a.f7944i);
            }
            if (this.f7934a.f7945j != null) {
                this.f7934a.f7945j.m8150a(this.f7934a.f7943h);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1836790741, a);
        }
    }

    /* compiled from: other_user */
    public interface Listener {
        void m8150a(AttributionViewData attributionViewData);
    }

    private static <T extends View> void m8154a(Class<T> cls, T t) {
        m8155a((Object) t, t.getContext());
    }

    private static void m8155a(Object obj, Context context) {
        ((AttributionView) obj).f7938a = ComposerButtonColorUtil.m10509a(FbInjector.get(context));
    }

    private void m8153a(ComposerButtonColorUtil composerButtonColorUtil) {
        this.f7938a = composerButtonColorUtil;
    }

    public AttributionView(Context context) {
        super(context);
        m8151a();
    }

    public AttributionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8151a();
    }

    public AttributionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8151a();
    }

    private void m8151a() {
        m8154a(AttributionView.class, (View) this);
        setContentView(2130905748);
        this.f7939b = (TextView) a(2131564934);
        this.f7941d = (FbDraweeView) a(2131559621);
        this.f7940c = (TextView) a(2131559622);
        OnClickListener c08892 = new C08892(this);
        this.f7939b.setOnClickListener(c08892);
        this.f7941d.setOnClickListener(c08892);
        this.f7940c.setOnClickListener(c08892);
        setBackgroundDrawable(new ColorDrawable(-1));
    }

    public void setAttributionViewData(AttributionViewData attributionViewData) {
        AttributionViewData attributionViewData2 = this.f7943h;
        this.f7943h = attributionViewData;
        m8156b();
        this.f7946k;
        m8158c();
        if ((attributionViewData2 == null || !attributionViewData2.mo294b().equals(attributionViewData.mo294b())) && this.f7946k != null) {
            this.f7946k.mo289a(this.f7943h, this.f7944i);
        }
        if (attributionViewData2 != null) {
            attributionViewData2.mo293a(null);
        }
        this.f7943h.mo293a(this.f7942g);
    }

    public void setListener(Listener listener) {
        this.f7945j = listener;
    }

    public void setLoggingListener(@Nullable LoggingListener loggingListener) {
        this.f7946k = loggingListener;
    }

    private void m8156b() {
        this.f7940c.setText(this.f7943h.mo295c());
    }

    private void m8158c() {
        ColorFilter colorFilter = null;
        if (this.f7943h.mo297e().g) {
            this.f7941d.setVisibility(8);
            this.f7940c.setPadding(getResources().getDimensionPixelSize(2131428647), this.f7940c.getPaddingTop(), this.f7940c.getPaddingRight(), this.f7940c.getPaddingBottom());
            return;
        }
        this.f7941d.setVisibility(0);
        this.f7940c.setPadding(0, this.f7940c.getPaddingTop(), this.f7940c.getPaddingRight(), this.f7940c.getPaddingBottom());
        Resources resources = getResources();
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.f7941d.getHierarchy();
        genericDraweeHierarchy.b(resources.getDrawable(2131362420));
        if (this.f7943h.mo298f() != null) {
            this.f7941d.a(this.f7943h.mo298f(), f7936e);
        }
        RoundingParams roundingParams = genericDraweeHierarchy.c;
        if (this.f7943h instanceof InternalAttributionViewData) {
            if (roundingParams != null) {
                roundingParams.b = false;
                roundingParams.a(0, 0.0f).a(0);
            }
            colorFilter = this.f7938a.m10514a(null);
        } else if (roundingParams != null) {
            TypedValue typedValue = new TypedValue();
            resources.getValue(2131428648, typedValue, true);
            roundingParams.b = true;
            roundingParams.a(resources.getColor(2131361864)).a(resources.getColor(2131362281), typedValue.getFloat());
        }
        if (roundingParams != null) {
            genericDraweeHierarchy.a(roundingParams);
        }
        genericDraweeHierarchy.a(colorFilter);
    }

    public static void m8161d(AttributionView attributionView) {
        Object obj = 1;
        Object obj2 = null;
        attributionView.f7944i = attributionView.f7943h.mo296d();
        if (attributionView.f7944i == null) {
            attributionView.m8163e();
            return;
        }
        switch (attributionView.f7944i) {
            case PLATFORM_APP_INSTALL:
                if (attributionView.f7943h.mo297e().e) {
                    obj = null;
                    break;
                }
                break;
            case PLATFORM_APP_REPLY:
                if (attributionView.f7943h.mo297e().f) {
                    obj = null;
                    break;
                }
                break;
        }
        if (!attributionView.f7943h.mo297e().d) {
            obj2 = obj;
        }
        if (obj2 != null) {
            attributionView.f7939b.setText(attributionView.getResources().getString(attributionView.f7944i.callToActionStringResId));
            attributionView.m8165f();
            return;
        }
        attributionView.m8163e();
    }

    private void m8163e() {
        this.f7939b.setVisibility(8);
        this.f7940c.setClickable(false);
        this.f7941d.setClickable(false);
    }

    private void m8165f() {
        this.f7939b.setVisibility(0);
        this.f7940c.setClickable(true);
        this.f7941d.setClickable(true);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1004476547);
        super.onAttachedToWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -606345022, a);
    }
}

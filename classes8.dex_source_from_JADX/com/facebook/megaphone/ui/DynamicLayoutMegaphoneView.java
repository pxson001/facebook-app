package com.facebook.megaphone.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.facebook.view.inflation.DynamicLayoutInflater;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.images.UrlImage;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: triggering_profile_ids */
public class DynamicLayoutMegaphoneView extends CustomRelativeLayout implements MegaphoneStoryView {
    private static final Class<?> f1320d = DynamicLayoutMegaphoneView.class;
    @Inject
    public AbstractFbErrorReporter f1321a;
    @Inject
    public DynamicLayoutInflater f1322b;
    @Inject
    public MegaphoneBehavior f1323c;
    private boolean f1324e;
    public GraphQLMegaphone f1325f;
    private UrlImage f1326g;
    private Button f1327h;
    private Button f1328i;
    private Button f1329j;
    private ImageButton f1330k;

    /* compiled from: triggering_profile_ids */
    class C01311 implements OnClickListener {
        final /* synthetic */ DynamicLayoutMegaphoneView f1317a;

        C01311(DynamicLayoutMegaphoneView dynamicLayoutMegaphoneView) {
            this.f1317a = dynamicLayoutMegaphoneView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -227855376);
            this.f1317a.f1323c.m1558c(this.f1317a.f1325f);
            Logger.a(2, EntryType.UI_INPUT_END, -1854590628, a);
        }
    }

    /* compiled from: triggering_profile_ids */
    class C01322 implements OnClickListener {
        final /* synthetic */ DynamicLayoutMegaphoneView f1318a;

        C01322(DynamicLayoutMegaphoneView dynamicLayoutMegaphoneView) {
            this.f1318a = dynamicLayoutMegaphoneView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 310874692);
            this.f1318a.f1323c.m1556a(this.f1318a.f1325f);
            Logger.a(2, EntryType.UI_INPUT_END, -279965143, a);
        }
    }

    /* compiled from: triggering_profile_ids */
    class C01333 implements OnClickListener {
        final /* synthetic */ DynamicLayoutMegaphoneView f1319a;

        C01333(DynamicLayoutMegaphoneView dynamicLayoutMegaphoneView) {
            this.f1319a = dynamicLayoutMegaphoneView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 102287121);
            this.f1319a.f1323c.m1557b(this.f1319a.f1325f);
            Logger.a(2, EntryType.UI_INPUT_END, -1296258099, a);
        }
    }

    public static void m1545a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DynamicLayoutMegaphoneView dynamicLayoutMegaphoneView = (DynamicLayoutMegaphoneView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        DynamicLayoutInflater b = DynamicLayoutInflater.m11490b(injectorLike);
        MegaphoneBehavior b2 = MegaphoneBehavior.m1555b(injectorLike);
        dynamicLayoutMegaphoneView.f1321a = abstractFbErrorReporter;
        dynamicLayoutMegaphoneView.f1322b = b;
        dynamicLayoutMegaphoneView.f1323c = b2;
    }

    public DynamicLayoutMegaphoneView(Context context) {
        super(context);
        Class cls = DynamicLayoutMegaphoneView.class;
        m1545a(this, getContext());
    }

    protected void onMeasure(int i, int i2) {
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setMegaphoneStory(MegaphoneWithLayout megaphoneWithLayout) {
        if (!this.f1324e || this.f1325f != megaphoneWithLayout.b) {
            GraphQLMegaphone graphQLMegaphone = megaphoneWithLayout.b;
            this.f1325f = graphQLMegaphone;
            if (graphQLMegaphone != null) {
                setMegaphoneLayout(megaphoneWithLayout.a);
            } else {
                setVisibility(8);
            }
        }
    }

    private void setMegaphoneLayout(String str) {
        if (str == null) {
            m1546b();
            return;
        }
        try {
            removeAllViews();
            addView(this.f1322b.m11492a(str, this, getContext()));
            m1547c();
            OnClickListener c01311 = new C01311(this);
            OnClickListener c01322 = new C01322(this);
            if (this.f1330k != null) {
                this.f1330k.setOnClickListener(c01311);
            }
            if (this.f1329j != null) {
                this.f1329j.setOnClickListener(c01311);
            }
            if (this.f1328i != null) {
                this.f1328i.setOnClickListener(c01322);
            }
            if (this.f1327h != null) {
                this.f1327h.setOnClickListener(c01322);
            }
            if (this.f1326g != null) {
                this.f1326g.setOnClickListener(new C01333(this));
            }
            this.f1324e = true;
        } catch (Throwable e) {
            this.f1321a.a(f1320d.getSimpleName() + "_inflation", "error thrown while inflating, megaphone ID: " + this.f1325f.k(), e);
            m1546b();
        } catch (Throwable e2) {
            this.f1321a.a(f1320d.getSimpleName() + "_buttons", "error thrown while finding buttons: " + this.f1325f.k(), e2);
            m1546b();
        }
    }

    private void m1546b() {
        removeAllViews();
        Object defaultMegaphoneStoryView = new DefaultMegaphoneStoryView(getContext());
        defaultMegaphoneStoryView.setMegaphoneStory(this.f1325f);
        addView(defaultMegaphoneStoryView);
    }

    private void m1547c() {
        this.f1326g = (UrlImage) m1544a(this.f1322b.m11493a("megaphone_icon"));
        this.f1328i = (Button) m1544a(this.f1322b.m11493a("megaphone_button_accept"));
        this.f1327h = (Button) m1544a(this.f1322b.m11493a("megaphone_button_solo_accept"));
        this.f1329j = (Button) m1544a(this.f1322b.m11493a("megaphone_button_cancel"));
        this.f1330k = (ImageButton) m1544a(this.f1322b.m11493a("megaphone_x_button"));
    }

    private View m1544a(@Nullable Integer num) {
        return num != null ? findViewById(num.intValue()) : null;
    }
}

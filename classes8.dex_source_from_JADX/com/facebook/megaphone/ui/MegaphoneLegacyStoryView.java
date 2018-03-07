package com.facebook.megaphone.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.images.UrlImage;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: trending_topic_pivot */
public class MegaphoneLegacyStoryView extends CustomRelativeLayout implements OnClickListener, MegaphoneStoryView {
    @Inject
    public MegaphoneBehavior f1361a;
    private UrlImage f1362b;
    private TextView f1363c;
    private TextView f1364d;
    private LinearLayout f1365e;
    private Button f1366f;
    private Button f1367g;
    private Button f1368h;
    private Button f1369i;
    private ImageButton f1370j;
    private final LayoutInflater f1371k;
    private GraphQLMegaphone f1372l;

    public static void m1563a(Object obj, Context context) {
        ((MegaphoneLegacyStoryView) obj).f1361a = MegaphoneBehavior.m1555b(FbInjector.get(context));
    }

    public MegaphoneLegacyStoryView(Context context) {
        this(context, null);
    }

    private MegaphoneLegacyStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MegaphoneLegacyStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MegaphoneLegacyStoryView.class;
        m1563a((Object) this, getContext());
        this.f1371k = LayoutInflater.from(context);
        View.inflate(getContext(), 2130905200, this);
        this.f1362b = (UrlImage) a(2131563772);
        this.f1363c = (TextView) a(2131563773);
        this.f1364d = (TextView) a(2131563774);
        this.f1367g = (Button) a(2131563779);
        this.f1366f = (Button) a(2131563776);
        this.f1369i = (Button) a(2131563778);
        this.f1370j = (ImageButton) a(2131563780);
        this.f1365e = (LinearLayout) a(2131563775);
        this.f1370j.setOnClickListener(this);
        this.f1369i.setOnClickListener(this);
        this.f1367g.setOnClickListener(this);
        this.f1366f.setOnClickListener(this);
        this.f1362b.setOnClickListener(this);
    }

    public void setMegaphoneStory(MegaphoneWithLayout megaphoneWithLayout) {
        GraphQLMegaphone graphQLMegaphone;
        if (megaphoneWithLayout == null) {
            graphQLMegaphone = null;
        } else {
            graphQLMegaphone = megaphoneWithLayout.b;
        }
        this.f1372l = graphQLMegaphone;
        if (this.f1372l != null) {
            m1562a();
        } else {
            setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    private void m1564a(List<GraphQLAggregatedEntitiesAtRange> list, String str) {
        this.f1365e.removeAllViews();
        if (list != null && list.size() > 0) {
            View a = m1561a(((GraphQLAggregatedEntitiesAtRange) list.get(0)).j());
            if (a != null) {
                this.f1365e.addView(a, 0);
            }
        }
        if (!StringUtil.a(str)) {
            this.f1365e.addView((LinearLayout) m1560a(2130905199, null));
            ((TextView) findViewById(2131563769)).setText(str);
        }
        if (this.f1365e.getChildCount() == 0) {
            this.f1365e.setVisibility(8);
        } else {
            this.f1365e.setVisibility(0);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -71659607);
        super.onAttachedToWindow();
        this.f1361a.m1559d(this.f1372l);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1704411700, a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -493378578);
        if (view == this.f1370j || view == this.f1369i) {
            this.f1361a.m1558c(this.f1372l);
        } else if (view == this.f1366f || view == this.f1367g) {
            this.f1361a.m1556a(this.f1372l);
        } else if (view == this.f1362b) {
            this.f1361a.m1557b(this.f1372l);
        }
        LogUtils.a(-1917590761, a);
    }

    private View m1561a(ImmutableList<GraphQLEntity> immutableList) {
        View view = null;
        if (immutableList != null) {
            int i;
            switch (immutableList.size()) {
                case 0:
                case 1:
                    break;
                case 2:
                    i = 2;
                    view = (ViewGroup) m1560a(2130905196, null);
                    break;
                case 3:
                case 4:
                case 5:
                    i = 3;
                    view = (ViewGroup) m1560a(2130905197, null);
                    break;
                default:
                    i = 6;
                    view = (ViewGroup) m1560a(2130905198, null);
                    break;
            }
            for (int i2 = 0; i2 < i; i2++) {
                GraphQLEntity graphQLEntity = (GraphQLEntity) immutableList.get(i2);
                Uri uri = null;
                if (!(graphQLEntity == null || view == null)) {
                    String b = graphQLEntity.G() != null ? graphQLEntity.G().b() : null;
                    if (b != null) {
                        UrlImage urlImage = (UrlImage) Preconditions.checkNotNull((UrlImage) view.getChildAt(i2));
                        if (b != null) {
                            uri = Uri.parse(b);
                        }
                        urlImage.setImageParams(uri);
                    }
                }
            }
        }
        return view;
    }

    private View m1560a(int i, ViewGroup viewGroup) {
        if (this.f1371k != null) {
            return this.f1371k.inflate(i, viewGroup);
        }
        return null;
    }

    private void m1562a() {
        if (this.f1372l.l() == null) {
            this.f1368h = this.f1366f;
            this.f1367g.setVisibility(8);
            this.f1369i.setVisibility(8);
            this.f1370j.setVisibility(0);
        } else {
            this.f1368h = this.f1367g;
            this.f1366f.setVisibility(8);
            this.f1370j.setVisibility(8);
            this.f1369i.setVisibility(0);
            this.f1369i.setText(this.f1372l.l());
        }
        if (this.f1372l.n() == null || this.f1372l.n().b() == null) {
            this.f1362b.setVisibility(8);
        } else {
            this.f1362b.setImageParams(Uri.parse(this.f1372l.n().b()));
            this.f1362b.setVisibility(0);
        }
        this.f1363c.setText(this.f1372l.s());
        this.f1364d.setText(this.f1372l.m() != null ? this.f1372l.m().a() : null);
        if (this.f1363c.getLineCount() < 2) {
            this.f1364d.setMaxLines(4);
        } else {
            this.f1364d.setMaxLines(3);
        }
        if (this.f1372l.j() != null) {
            this.f1368h.setText(this.f1372l.j().j());
            String a = this.f1372l.j().a();
            if (a == null || a.equals("")) {
                a = "DEFAULT";
            } else if (!(a.equals("DEFAULT") || a.equals("PROMINENT") || a.equals("SUBDUED"))) {
                a = "DEFAULT";
            }
            String str = a;
            if (str.equals("PROMINENT")) {
                this.f1368h.setBackgroundResource(2130837895);
                this.f1368h.setTextColor(getResources().getColor(2131361867));
            } else if (str.equals("SUBDUED")) {
                this.f1368h.setBackgroundResource(2130837899);
                this.f1368h.setTextColor(getResources().getColor(2131363646));
            } else {
                this.f1368h.setBackgroundResource(2130837886);
                this.f1368h.setTextColor(getResources().getColor(2131361867));
            }
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131432516);
            this.f1368h.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            this.f1368h.setVisibility(0);
        } else {
            this.f1368h.setVisibility(8);
        }
        setVisibility(0);
        if (this.f1372l.r() != null) {
            m1564a(this.f1372l.r().c(), this.f1372l.r().a());
        } else {
            this.f1365e.setVisibility(8);
        }
    }
}

package com.facebook.timeline.navtiles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: fetchCategories */
public class SlimNavTileView extends CustomFrameLayout {
    @Inject
    ProfileControllerDelegate f12063a;
    @Inject
    AllCapsTransformationMethod f12064b;
    @Inject
    @IsWorkBuild
    Boolean f12065c;
    @Inject
    QeAccessor f12066d;
    private Paint f12067e;
    private Paint f12068f;
    private final OnClickListener f12069g = new C17311(this);

    /* compiled from: fetchCategories */
    class C17311 implements OnClickListener {
        final /* synthetic */ SlimNavTileView f12062a;

        C17311(SlimNavTileView slimNavTileView) {
            this.f12062a = slimNavTileView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1215869195);
            this.f12062a.f12063a.mm_().mo554a((GraphQLTimelineAppSectionType) view.getTag());
            Logger.a(2, EntryType.UI_INPUT_END, 2056495377, a);
        }
    }

    private static <T extends View> void m12074a(Class<T> cls, T t) {
        m12075a((Object) t, t.getContext());
    }

    private static void m12075a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SlimNavTileView) obj).m12073a(ProfileControllerDelegate.m10751a(injectorLike), AllCapsTransformationMethod.b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m12073a(ProfileControllerDelegate profileControllerDelegate, AllCapsTransformationMethod allCapsTransformationMethod, Boolean bool, QeAccessor qeAccessor) {
        this.f12063a = profileControllerDelegate;
        this.f12064b = allCapsTransformationMethod;
        this.f12065c = bool;
        this.f12066d = qeAccessor;
    }

    public SlimNavTileView(Context context) {
        super(context);
        m12071a();
    }

    public SlimNavTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12071a();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!m12076b()) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131429917);
            canvas.drawLine(0.0f, 0.0f, (float) getWidth(), 0.0f, this.f12067e);
            canvas.drawLine(0.0f, (float) dimensionPixelSize, (float) getWidth(), (float) dimensionPixelSize, this.f12068f);
        }
    }

    private void m12071a() {
        m12074a(SlimNavTileView.class, (View) this);
        setContentView(2130907134);
        if (!m12076b()) {
            this.f12067e = new Paint(1);
            this.f12067e.setColor(getResources().getColor(2131361940));
            this.f12067e.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427380));
            this.f12068f = new Paint(1);
            this.f12068f.setColor(getResources().getColor(2131361938));
            this.f12068f.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427380));
        }
        m12072a(findViewById(2131558589), 2131234888, GraphQLTimelineAppSectionType.ABOUT, this.f12069g);
        m12072a(findViewById(2131558590), 2131234889, GraphQLTimelineAppSectionType.PHOTOS, this.f12069g);
        if (this.f12065c.booleanValue()) {
            m12072a(findViewById(2131558591), 2131234891, GraphQLTimelineAppSectionType.SUBSCRIBERS, this.f12069g);
        } else {
            m12072a(findViewById(2131558591), 2131234890, GraphQLTimelineAppSectionType.FRIENDS, this.f12069g);
        }
    }

    private void m12072a(View view, int i, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, OnClickListener onClickListener) {
        ((TextView) view).setText(this.f12064b.getTransformation(getResources().getString(i), view));
        view.setTag(graphQLTimelineAppSectionType);
        view.setOnClickListener(onClickListener);
    }

    private boolean m12076b() {
        return this.f12066d.a(ExperimentsForTimelineAbTestModule.H, false);
    }
}

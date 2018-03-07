package com.facebook.entitycardsplugins.person.widget.header;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.TriState;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.TapSurfaces;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.Presenter;
import com.facebook.timeline.util.IsWorkUserBadgeEnabled;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: heisman_cancel_pivot */
public class PersonCardHeaderView extends CustomFrameLayout {
    private static final CallerContext f11423c = CallerContext.a(PersonCardHeaderView.class, "entity_cards");
    @Inject
    FbDraweeControllerBuilder f11424a;
    @Inject
    @IsWorkUserBadgeEnabled
    Provider<TriState> f11425b;
    public PersonCardHeaderPresenter f11426d;
    private FbDraweeView f11427e;
    private FbDraweeView f11428f;
    private TextView f11429g;
    private View f11430h;
    private Drawable f11431i;
    private PointF f11432j;
    private final OnClickListener f11433k = new C12481(this);

    /* compiled from: heisman_cancel_pivot */
    class C12481 implements OnClickListener {
        final /* synthetic */ PersonCardHeaderView f11422a;

        C12481(PersonCardHeaderView personCardHeaderView) {
            this.f11422a = personCardHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -431484980);
            if (this.f11422a.f11426d != null) {
                Presenter presenter = this.f11422a.f11426d;
                PersonCardHeaderView personCardHeaderView = this.f11422a;
                if (presenter.m13032c(personCardHeaderView)) {
                    presenter.f11415f.m12795a(TapSurfaces.HEADER, presenter.f11418i.m13204r(), Absent.INSTANCE, Absent.INSTANCE);
                    presenter.f11415f.m12796a(presenter.f11418i.m13204r());
                    presenter.f11412c.m13088a(personCardHeaderView.getContext(), presenter.f11418i);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -284138923, a);
        }
    }

    private static <T extends View> void m13347a(Class<T> cls, T t) {
        m13348a((Object) t, t.getContext());
    }

    private static void m13348a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PersonCardHeaderView) obj).m13346a(FbDraweeControllerBuilder.b(fbInjector), IdBasedProvider.a(fbInjector, 781));
    }

    private void m13346a(FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<TriState> provider) {
        this.f11424a = fbDraweeControllerBuilder;
        this.f11425b = provider;
    }

    public PersonCardHeaderView(Context context) {
        super(context);
        m13352b();
    }

    public PersonCardHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13352b();
    }

    private void m13352b() {
        m13347a(PersonCardHeaderView.class, (View) this);
        setContentView(2130906180);
        this.f11428f = (FbDraweeView) c(2131565852);
        this.f11427e = (FbDraweeView) c(2131565853);
        this.f11429g = (TextView) c(2131560124);
        this.f11430h = c(2131565854);
        this.f11430h.setOnClickListener(this.f11433k);
        this.f11428f.setController(m13353e());
        this.f11431i = getResources().getDrawable(2130843447);
        this.f11432j = new PointF(0.5f, 0.5f);
    }

    public void setPresenter(PersonCardHeaderPresenter personCardHeaderPresenter) {
        this.f11426d = personCardHeaderPresenter;
    }

    public final void m13356a(int i, Uri uri, String str, @Nullable PointF pointF, ControllerListener controllerListener) {
        Preconditions.checkNotNull(uri);
        LayoutParams layoutParams = this.f11428f.getLayoutParams();
        layoutParams.height = i;
        this.f11428f.setLayoutParams(layoutParams);
        this.f11428f.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f11424a.p().a(f11423c).b(this.f11428f.getController())).b(uri).a(controllerListener)).s());
        ((GenericDraweeHierarchy) this.f11428f.getHierarchy()).a(pointF);
        this.f11430h.setContentDescription(StringLocaleUtil.a(getResources().getString(2131235001), new Object[]{str}));
    }

    public final void m13359a(@Nullable String str, int i) {
        CharSequence a;
        LayoutParams layoutParams = this.f11428f.getLayoutParams();
        layoutParams.height = i;
        this.f11428f.setLayoutParams(layoutParams);
        this.f11428f.setController(m13353e());
        View view = this.f11430h;
        if (str != null) {
            a = StringLocaleUtil.a(getResources().getString(2131235001), new Object[]{str});
        } else {
            a = null;
        }
        view.setContentDescription(a);
    }

    public final void m13357a(@Nullable Drawable drawable, @Nullable PointF pointF) {
        if (drawable == null) {
            ((GenericDraweeHierarchy) this.f11428f.getHierarchy()).b(this.f11431i);
            return;
        }
        ((GenericDraweeHierarchy) this.f11428f.getHierarchy()).b(drawable);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.f11428f.getHierarchy();
        if (pointF == null) {
            pointF = this.f11432j;
        }
        genericDraweeHierarchy.b(pointF);
    }

    private DraweeController m13353e() {
        return ((FbDraweeControllerBuilder) this.f11424a.p().a(f11423c).b(this.f11428f.getController())).s();
    }

    public final void m13358a(@Nullable DefaultImageFieldsModel defaultImageFieldsModel, @Nullable DefaultImageFieldsModel defaultImageFieldsModel2, @Nullable ControllerListener controllerListener) {
        this.f11427e.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f11424a.p().a(f11423c).b(this.f11427e.getController())).d(ImageRequest.a(m13351b(defaultImageFieldsModel, defaultImageFieldsModel2)))).b(m13344a(defaultImageFieldsModel, defaultImageFieldsModel2)).a(controllerListener)).s());
    }

    private static boolean m13349a(@Nullable DefaultImageFieldsModel defaultImageFieldsModel) {
        return (defaultImageFieldsModel == null || defaultImageFieldsModel.b() == null) ? false : true;
    }

    @Nullable
    private Uri m13350b(@Nullable DefaultImageFieldsModel defaultImageFieldsModel) {
        return m13349a(defaultImageFieldsModel) ? Uri.parse(defaultImageFieldsModel.b()) : null;
    }

    @Nullable
    private Uri m13344a(@Nullable DefaultImageFieldsModel defaultImageFieldsModel, @Nullable DefaultImageFieldsModel defaultImageFieldsModel2) {
        return m13349a(defaultImageFieldsModel2) ? m13350b(defaultImageFieldsModel2) : m13350b(defaultImageFieldsModel);
    }

    @Nullable
    private Uri m13351b(@Nullable DefaultImageFieldsModel defaultImageFieldsModel, @Nullable DefaultImageFieldsModel defaultImageFieldsModel2) {
        return m13349a(defaultImageFieldsModel2) ? m13350b(defaultImageFieldsModel) : null;
    }

    public final void m13360a(String str, @Nullable String str2, boolean z, boolean z2) {
        int i;
        int i2;
        if (getResources().getConfiguration().fontScale > 1.0f) {
            i = 2131433173;
            i2 = 2131433171;
        } else {
            i = 2131433172;
            i2 = 2131433170;
        }
        TimelineViewHelper.a(this.f11429g, TimelineViewHelper.a(z, z2, TimelineViewHelper.a(this.f11429g, str, str2, 2131625445, getContext()), 2130843878, 2130844053, getContext(), getResources().getDimensionPixelSize(2131433165), getResources().getDimensionPixelSize(2131433174), this.f11425b), 30, getResources().getDimensionPixelSize(i2), getResources().getDimensionPixelSize(i));
    }

    public final void m13355a() {
        m13359a(null, 0);
        m13354f();
    }

    private void m13354f() {
        this.f11427e.setController(null);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 278160755);
        super.onDetachedFromWindow();
        if (this.f11426d != null) {
            this.f11426d.m13341b(this);
            this.f11426d = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 39979345, a);
    }
}

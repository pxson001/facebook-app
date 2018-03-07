package com.facebook.pages.common.editpage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenterManager;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: size_on_start */
public class AddSectionFragmentV2 extends FbFragment {
    @Inject
    public EditPageSectionPresenterManager f1526a;
    @Inject
    public GlyphColorizer f1527b;
    public long f1528c;
    public SectionsCanAddData f1529d;
    public SegmentedLinearLayout f1530e;

    public static void m2219a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AddSectionFragmentV2 addSectionFragmentV2 = (AddSectionFragmentV2) obj;
        EditPageSectionPresenterManager a = EditPageSectionPresenterManager.m2403a(injectorLike);
        GlyphColorizer a2 = GlyphColorizer.a(injectorLike);
        addSectionFragmentV2.f1526a = a;
        addSectionFragmentV2.f1527b = a2;
    }

    public final void m2222c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AddSectionFragmentV2.class;
        m2219a((Object) this, getContext());
        this.f1528c = this.s.getLong("com.facebook.katana.profile.id");
        this.f1529d = (SectionsCanAddData) FlatBufferModelHelper.a(this.s, "sections_can_add_data");
        Preconditions.checkState(this.f1528c > 0);
        Preconditions.checkNotNull(this.f1529d);
    }

    public final View m2220a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1930701191);
        View inflate = layoutInflater.inflate(2130903167, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -978456231, a);
        return inflate;
    }

    public final void m2221a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f1530e = (SegmentedLinearLayout) e(2131559369);
        this.f1530e.removeAllViews();
        ImmutableList g = this.f1529d.mo34g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            SectionsCanAddModel sectionsCanAddModel = (SectionsCanAddModel) g.get(i);
            final EditPageSectionPresenter a = this.f1526a.m2406a(sectionsCanAddModel);
            if (!(a == null || sectionsCanAddModel.m2356a() == null || sectionsCanAddModel.m2357b() == null)) {
                SegmentedLinearLayout segmentedLinearLayout = this.f1530e;
                FigListItem figListItem = (FigListItem) LayoutInflater.from(getContext()).inflate(2130903169, this.f1530e, false);
                figListItem.setThumbnailDrawable(this.f1527b.a(a.mo38b(), jW_().getColor(2131362108)));
                figListItem.setTitleText(sectionsCanAddModel.m2356a().m2339a());
                figListItem.setMetaText(sectionsCanAddModel.m2357b().m2345a());
                figListItem.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AddSectionFragmentV2 f1525b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1958887405);
                        a.mo35a(this.f1525b.o(), this.f1525b.f1528c, SectionContext.ADD);
                        Logger.a(2, EntryType.UI_INPUT_END, 999928595, a);
                    }
                });
                segmentedLinearLayout.addView(figListItem);
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1286135354);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131241683);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1333440014, a);
    }
}

package com.facebook.pages.common.editpage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenterManager;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: slideshow_in_composer */
public class AddSectionFragment extends FbFragment {
    @Inject
    public EditPageSectionPresenterManager f1520a;
    public long f1521b;
    public SectionsCanAddData f1522c;
    public ViewGroup f1523d;

    public static void m2215a(Object obj, Context context) {
        ((AddSectionFragment) obj).f1520a = EditPageSectionPresenterManager.m2403a(FbInjector.get(context));
    }

    public final void m2218c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AddSectionFragment.class;
        m2215a((Object) this, getContext());
        this.f1521b = this.s.getLong("com.facebook.katana.profile.id");
        this.f1522c = (SectionsCanAddData) FlatBufferModelHelper.a(this.s, "sections_can_add_data");
        Preconditions.checkState(this.f1521b > 0);
        Preconditions.checkNotNull(this.f1522c);
    }

    public final View m2216a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -364748371);
        View inflate = layoutInflater.inflate(2130903166, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1745930035, a);
        return inflate;
    }

    public final void m2217a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f1523d = (ViewGroup) e(2131559369);
        this.f1523d.removeAllViews();
        ImmutableList g = this.f1522c.mo34g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            SectionsCanAddModel sectionsCanAddModel = (SectionsCanAddModel) g.get(i);
            final EditPageSectionPresenter a = this.f1520a.m2406a(sectionsCanAddModel);
            if (a != null) {
                ViewGroup viewGroup = this.f1523d;
                View inflate = LayoutInflater.from(getContext()).inflate(2130903168, this.f1523d, false);
                ((BetterTextView) inflate.findViewById(2131559370)).setText(sectionsCanAddModel.m2359d().m2350a());
                ((BetterTextView) inflate.findViewById(2131559371)).setText(sectionsCanAddModel.m2357b().m2345a());
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AddSectionFragment f1519b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1582482914);
                        a.mo35a(this.f1519b.o(), this.f1519b.f1521b, SectionContext.ADD);
                        Logger.a(2, EntryType.UI_INPUT_END, 1807623863, a);
                    }
                });
                viewGroup.addView(inflate);
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -602239689);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131241682);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1723263592, a);
    }
}

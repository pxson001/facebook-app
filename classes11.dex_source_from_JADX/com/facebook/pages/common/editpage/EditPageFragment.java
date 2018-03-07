package com.facebook.pages.common.editpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.FetchEditPageQueryModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenterManager;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionClickHandler;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: sideshow_page_like */
public class EditPageFragment extends FbFragment {
    public static final String f1541g = EditPageFragment.class.getSimpleName();
    @Inject
    public EditPageFetcher f1542a;
    private ProgressBar al;
    @Inject
    EditPageNavigationUtil f1543b;
    @Inject
    EditPageSectionPresenterManager f1544c;
    @Inject
    AbstractFbErrorReporter f1545d;
    @Inject
    PageCallToActionClickHandler f1546e;
    @Inject
    public TasksManager f1547f;
    public long f1548h;
    private ViewGroup f1549i;

    /* compiled from: sideshow_page_like */
    public class C02101 extends AbstractDisposableFutureCallback<FetchEditPageQueryModel> {
        final /* synthetic */ EditPageFragment f1532a;

        public C02101(EditPageFragment editPageFragment) {
            this.f1532a = editPageFragment;
        }

        protected final void m2225a(@Nullable Object obj) {
            FetchEditPageQueryModel fetchEditPageQueryModel = (FetchEditPageQueryModel) obj;
            EditPageFragment.m2231a(this.f1532a, false);
            EditPageFragment.m2230a(this.f1532a, fetchEditPageQueryModel);
        }

        protected final void m2226a(Throwable th) {
            this.f1532a.f1545d.a(EditPageFragment.f1541g, "fail to load edit page data", th);
        }
    }

    /* compiled from: sideshow_page_like */
    public enum Task {
        FETCH_EDIT_PAGE_QUERY
    }

    public static void m2234a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EditPageFragment) obj).m2229a(EditPageFetcher.m2223b(injectorLike), EditPageNavigationUtil.m2255b(injectorLike), EditPageSectionPresenterManager.m2403a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PageCallToActionClickHandler.b(injectorLike), TasksManager.b(injectorLike));
    }

    private void m2229a(EditPageFetcher editPageFetcher, EditPageNavigationUtil editPageNavigationUtil, EditPageSectionPresenterManager editPageSectionPresenterManager, AbstractFbErrorReporter abstractFbErrorReporter, PageCallToActionClickHandler pageCallToActionClickHandler, TasksManager tasksManager) {
        this.f1542a = editPageFetcher;
        this.f1543b = editPageNavigationUtil;
        this.f1544c = editPageSectionPresenterManager;
        this.f1545d = abstractFbErrorReporter;
        this.f1546e = pageCallToActionClickHandler;
        this.f1547f = tasksManager;
    }

    public final void m2238c(Bundle bundle) {
        super.c(bundle);
        Class cls = EditPageFragment.class;
        m2234a((Object) this, getContext());
        this.f1548h = this.s.getLong("com.facebook.katana.profile.id");
        Preconditions.checkArgument(this.f1548h > 0);
    }

    public final View m2236a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -295120418);
        View inflate = layoutInflater.inflate(2130903947, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 162478431, a);
        return inflate;
    }

    public final void m2237a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f1549i = (ViewGroup) e(2131559369);
        this.al = (ProgressBar) e(2131559418);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2061508179);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131241678);
        }
        m2231a(this, true);
        this.f1547f.a(Task.FETCH_EDIT_PAGE_QUERY, this.f1542a.m2224a(this.f1548h), new C02101(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1680755284, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1247063075);
        super.mj_();
        this.f1547f.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 957535786, a);
    }

    public static void m2231a(EditPageFragment editPageFragment, boolean z) {
        int i;
        int i2 = 8;
        ProgressBar progressBar = editPageFragment.al;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        ViewGroup viewGroup = editPageFragment.f1549i;
        if (!z) {
            i2 = 0;
        }
        viewGroup.setVisibility(i2);
    }

    public static void m2230a(@Nullable EditPageFragment editPageFragment, FetchEditPageQueryModel fetchEditPageQueryModel) {
        editPageFragment.f1549i.removeAllViews();
        if (fetchEditPageQueryModel != null) {
            editPageFragment.m2233a(fetchEditPageQueryModel.m2331d());
            ImmutableMap immutableMap = editPageFragment.f1544c.f1606a;
            editPageFragment.f1549i.addView(editPageFragment.m2227a(editPageFragment.jW_().getString(2131241685)));
            Iterator it = immutableMap.values().iterator();
            while (it.hasNext()) {
                final EditPageSectionPresenter editPageSectionPresenter = (EditPageSectionPresenter) it.next();
                if (editPageSectionPresenter.mo36a((EditPageData) fetchEditPageQueryModel)) {
                    editPageFragment.f1549i.addView(editPageFragment.m2235b(editPageFragment.jW_().getString(editPageSectionPresenter.mo39c()), new OnClickListener(editPageFragment) {
                        final /* synthetic */ EditPageFragment f1534b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -902114002);
                            editPageSectionPresenter.mo35a(this.f1534b.o(), this.f1534b.f1548h, SectionContext.EDIT);
                            Logger.a(2, EntryType.UI_INPUT_END, 2029644462, a);
                        }
                    }));
                }
            }
            editPageFragment.m2232a((SectionsCanAddData) fetchEditPageQueryModel);
        }
    }

    private void m2232a(final SectionsCanAddData sectionsCanAddData) {
        if (this.f1544c.m2405a(sectionsCanAddData) > 0) {
            this.f1549i.addView(m2228a(jW_().getString(2131241682), new OnClickListener(this) {
                final /* synthetic */ EditPageFragment f1536b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -128819469);
                    EditPageNavigationUtil editPageNavigationUtil = this.f1536b.f1543b;
                    EditPageNavigationUtil.m2254a(this.f1536b.kO_(), this.f1536b.H, this.f1536b.f1548h, sectionsCanAddData);
                    Logger.a(2, EntryType.UI_INPUT_END, -127925707, a);
                }
            }));
        }
    }

    private void m2233a(final PageCallToActionModel pageCallToActionModel) {
        if (pageCallToActionModel != null) {
            int i;
            this.f1549i.addView(m2227a(jW_().getString(2131241690)));
            boolean a = PageCallToActionUtil.a(pageCallToActionModel.g());
            if (!a) {
                this.f1549i.addView(m2235b(pageCallToActionModel.m(), new OnClickListener(this) {
                    final /* synthetic */ EditPageFragment f1538b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1552023899);
                        this.f1538b.f1546e.a(pageCallToActionModel, this.f1538b.f1548h);
                        Logger.a(2, EntryType.UI_INPUT_END, 299184105, a);
                    }
                }));
            }
            Resources jW_ = jW_();
            if (a) {
                i = 2131239549;
            } else {
                i = 2131239550;
            }
            View a2 = m2228a(jW_.getString(i), new OnClickListener(this) {
                final /* synthetic */ EditPageFragment f1540b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1440642082);
                    this.f1540b.f1546e.a(this.f1540b.f1548h, pageCallToActionModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -192321916, a);
                }
            });
            ((LayoutParams) a2.getLayoutParams()).setMargins(0, 0, 0, (int) jW_().getDimension(2131434073));
            this.f1549i.addView(a2);
        }
    }

    private View m2227a(String str) {
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) LayoutInflater.from(getContext()).inflate(2130903949, this.f1549i, false);
        BetterTextView betterTextView = (BetterTextView) imageBlockLayout.findViewById(2131561133);
        betterTextView.setText(str);
        betterTextView.setTextAppearance(getContext(), 2131626542);
        imageBlockLayout.setShowAuxView(false);
        return imageBlockLayout;
    }

    private View m2228a(String str, OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(getContext()).inflate(2130903946, this.f1549i, false);
        ((BetterTextView) inflate.findViewById(2131561129)).setText(str);
        inflate.setOnClickListener(onClickListener);
        return inflate;
    }

    private View m2235b(String str, OnClickListener onClickListener) {
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) LayoutInflater.from(getContext()).inflate(2130903949, this.f1549i, false);
        ((BetterTextView) imageBlockLayout.findViewById(2131561133)).setText(str);
        imageBlockLayout.setOnClickListener(onClickListener);
        return imageBlockLayout;
    }
}

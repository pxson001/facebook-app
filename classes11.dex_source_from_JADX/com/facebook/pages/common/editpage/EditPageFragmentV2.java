package com.facebook.pages.common.editpage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.EditPageDataModel.TabsModel;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.FetchEditPageQueryModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenterManager;
import com.facebook.pages.common.editpage.presenter.GenericViewSectionPresenter;
import com.facebook.pages.common.editpage.presenter.GenericViewSectionPresenterProvider;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionClickHandler;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: sideshow_ads */
public class EditPageFragmentV2 extends FbFragment {
    public static final String f1559i = EditPageFragmentV2.class.getSimpleName();
    @Inject
    public EditPageFetcher f1560a;
    public long al;
    private ViewSwitcher am;
    public SegmentedLinearLayout an;
    private CustomLinearLayout ao;
    @Inject
    EditPageNavigationUtil f1561b;
    @Inject
    EditPageSectionPresenterManager f1562c;
    @Inject
    AbstractFbErrorReporter f1563d;
    @Inject
    PageCallToActionClickHandler f1564e;
    @Inject
    public TasksManager f1565f;
    @Inject
    GlyphColorizer f1566g;
    @Inject
    GenericViewSectionPresenterProvider f1567h;

    /* compiled from: sideshow_ads */
    public class C02151 extends AbstractDisposableFutureCallback<FetchEditPageQueryModel> {
        final /* synthetic */ EditPageFragmentV2 f1550a;

        public C02151(EditPageFragmentV2 editPageFragmentV2) {
            this.f1550a = editPageFragmentV2;
        }

        protected final void m2239a(@Nullable Object obj) {
            FetchEditPageQueryModel fetchEditPageQueryModel = (FetchEditPageQueryModel) obj;
            EditPageFragmentV2.m2246a(this.f1550a, false);
            EditPageFragmentV2.m2245a(this.f1550a, fetchEditPageQueryModel);
        }

        protected final void m2240a(Throwable th) {
            this.f1550a.f1563d.a(EditPageFragmentV2.f1559i, "fail to load edit page data", th);
        }
    }

    /* compiled from: sideshow_ads */
    public enum Task {
        FETCH_EDIT_PAGE_QUERY
    }

    public static void m2248a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EditPageFragmentV2) obj).m2244a(EditPageFetcher.m2223b(injectorLike), EditPageNavigationUtil.m2255b(injectorLike), EditPageSectionPresenterManager.m2403a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PageCallToActionClickHandler.b(injectorLike), TasksManager.b(injectorLike), GlyphColorizer.a(injectorLike), (GenericViewSectionPresenterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GenericViewSectionPresenterProvider.class));
    }

    private void m2244a(EditPageFetcher editPageFetcher, EditPageNavigationUtil editPageNavigationUtil, EditPageSectionPresenterManager editPageSectionPresenterManager, AbstractFbErrorReporter abstractFbErrorReporter, PageCallToActionClickHandler pageCallToActionClickHandler, TasksManager tasksManager, GlyphColorizer glyphColorizer, GenericViewSectionPresenterProvider genericViewSectionPresenterProvider) {
        this.f1560a = editPageFetcher;
        this.f1561b = editPageNavigationUtil;
        this.f1562c = editPageSectionPresenterManager;
        this.f1563d = abstractFbErrorReporter;
        this.f1564e = pageCallToActionClickHandler;
        this.f1565f = tasksManager;
        this.f1566g = glyphColorizer;
        this.f1567h = genericViewSectionPresenterProvider;
    }

    public final void m2252c(Bundle bundle) {
        super.c(bundle);
        Class cls = EditPageFragmentV2.class;
        m2248a((Object) this, getContext());
        this.al = this.s.getLong("com.facebook.katana.profile.id");
        Preconditions.checkArgument(this.al > 0);
    }

    public final View m2250a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -451287840);
        View inflate = layoutInflater.inflate(2130903948, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -298416854, a);
        return inflate;
    }

    public final void m2251a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.am = (ViewSwitcher) e(2131561130);
        this.an = (SegmentedLinearLayout) e(2131561131);
        this.ao = (CustomLinearLayout) e(2131561132);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -944109208);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131241678);
        }
        m2246a(this, true);
        this.f1565f.a(Task.FETCH_EDIT_PAGE_QUERY, this.f1560a.m2224a(this.al), new C02151(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1663941069, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2134893248);
        super.mj_();
        this.f1565f.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -492589111, a);
    }

    public static void m2246a(EditPageFragmentV2 editPageFragmentV2, boolean z) {
        editPageFragmentV2.am.setDisplayedChild(z ? 0 : 1);
    }

    public static void m2245a(@Nullable EditPageFragmentV2 editPageFragmentV2, FetchEditPageQueryModel fetchEditPageQueryModel) {
        editPageFragmentV2.an.removeAllViews();
        editPageFragmentV2.ao.removeAllViews();
        if (fetchEditPageQueryModel != null) {
            boolean a = editPageFragmentV2.m2249a(fetchEditPageQueryModel.m2331d());
            ImmutableMap immutableMap = editPageFragmentV2.f1562c.f1606a;
            editPageFragmentV2.an.addView(editPageFragmentV2.m2243a(editPageFragmentV2.b(2131241686), editPageFragmentV2.b(2131241687), a));
            editPageFragmentV2.m2247a((SectionsCanAddData) fetchEditPageQueryModel);
            ImmutableList mS_ = fetchEditPageQueryModel.mS_();
            int size = mS_.size();
            for (int i = 0; i < size; i++) {
                TabsModel tabsModel = (TabsModel) mS_.get(i);
                if (tabsModel.m2305b() != GraphQLPagePresenceTabType.HOME) {
                    EditPageSectionPresenter editPageSectionPresenter;
                    if (immutableMap.containsKey(tabsModel.m2305b())) {
                        editPageSectionPresenter = (EditPageSectionPresenter) immutableMap.get(tabsModel.m2305b());
                    } else {
                        Object genericViewSectionPresenter = new GenericViewSectionPresenter(PagesExperimentUtils.a(editPageFragmentV2.f1567h), tabsModel.m2305b());
                    }
                    String b = immutableMap.containsKey(tabsModel.m2305b()) ? editPageFragmentV2.b(2131241696) : editPageFragmentV2.b(2131241697);
                    if (!(editPageSectionPresenter == null || !editPageSectionPresenter.mo36a((EditPageData) fetchEditPageQueryModel) || tabsModel.m2304a() == null)) {
                        editPageFragmentV2.ao.addView(editPageFragmentV2.m2241a(tabsModel.m2304a().m2291a(), editPageSectionPresenter.mo38b(), b, new OnClickListener(editPageFragmentV2) {
                            final /* synthetic */ EditPageFragmentV2 f1552b;

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, 450774188);
                                editPageSectionPresenter.mo35a(this.f1552b.o(), this.f1552b.al, SectionContext.EDIT);
                                Logger.a(2, EntryType.UI_INPUT_END, -1037066211, a);
                            }
                        }));
                    }
                }
            }
        }
    }

    private void m2247a(final SectionsCanAddData sectionsCanAddData) {
        if (this.f1562c.m2405a(sectionsCanAddData) > 0) {
            this.an.addView(m2242a(b(2131241684), new OnClickListener(this) {
                final /* synthetic */ EditPageFragmentV2 f1554b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1737007526);
                    EditPageNavigationUtil editPageNavigationUtil = this.f1554b.f1561b;
                    EditPageNavigationUtil.m2256b(this.f1554b.kO_(), this.f1554b.H, this.f1554b.al, sectionsCanAddData);
                    Logger.a(2, EntryType.UI_INPUT_END, -98193533, a);
                }
            }));
        }
    }

    private boolean m2249a(final PageCallToActionModel pageCallToActionModel) {
        if (pageCallToActionModel == null) {
            return false;
        }
        this.an.addView(m2243a(b(2131241691), b(2131241692), false));
        if (PageCallToActionUtil.a(pageCallToActionModel.g())) {
            this.an.addView(m2242a(b(2131241693), new OnClickListener(this) {
                final /* synthetic */ EditPageFragmentV2 f1558b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 703335597);
                    this.f1558b.f1564e.a(this.f1558b.al, pageCallToActionModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -164311567, a);
                }
            }));
        } else {
            SegmentedLinearLayout segmentedLinearLayout = this.an;
            CharSequence m = pageCallToActionModel.m();
            OnClickListener c02184 = new OnClickListener(this) {
                final /* synthetic */ EditPageFragmentV2 f1556b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2047629820);
                    this.f1556b.f1564e.a(this.f1556b.al, pageCallToActionModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -7887189, a);
                }
            };
            CharSequence b = b(2131241696);
            FigListItem figListItem = (FigListItem) LayoutInflater.from(getContext()).inflate(2130903950, this.an, false);
            figListItem.setTitleText(m);
            figListItem.setOnClickListener(c02184);
            figListItem.setActionType(1);
            figListItem.setActionText(b);
            figListItem.setActionOnClickListener(c02184);
            segmentedLinearLayout.addView(figListItem);
        }
        return true;
    }

    private View m2243a(String str, String str2, boolean z) {
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) LayoutInflater.from(getContext()).inflate(2130903951, this.an, false);
        View findViewById = customLinearLayout.findViewById(2131561134);
        FigListItem figListItem = (FigListItem) customLinearLayout.findViewById(2131561135);
        figListItem.setTitleText(str);
        if (!StringUtil.a(str2)) {
            figListItem.setBodyText(str2);
        }
        if (z) {
            findViewById.setVisibility(0);
        }
        return customLinearLayout;
    }

    private View m2242a(String str, OnClickListener onClickListener) {
        FbTextView fbTextView = (FbTextView) LayoutInflater.from(getContext()).inflate(2130903945, this.an, false);
        fbTextView.setText(str);
        fbTextView.setOnClickListener(onClickListener);
        return fbTextView;
    }

    private View m2241a(String str, @DrawableRes int i, String str2, OnClickListener onClickListener) {
        FigListItem figListItem = (FigListItem) LayoutInflater.from(getContext()).inflate(2130903950, this.ao, false);
        if (i != 0) {
            figListItem.setThumbnailDrawable(this.f1566g.a(i, jW_().getColor(2131362108)));
        }
        figListItem.setTitleText(str);
        figListItem.setOnClickListener(onClickListener);
        figListItem.setActionType(1);
        figListItem.setActionText(str2);
        figListItem.setActionOnClickListener(onClickListener);
        return figListItem;
    }
}

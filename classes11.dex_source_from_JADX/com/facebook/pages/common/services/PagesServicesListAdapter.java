package com.facebook.pages.common.services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.PageServicesSectionInputData;
import com.facebook.graphql.calls.PageServicesSectionInputData.Visibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.services.PagesServiceCarousel.PagesServiceCarouselItemClickListener;
import com.facebook.pages.common.services.PagesServicesFragment.AnonymousClass10;
import com.facebook.pages.common.services.PagesServicesFragment.C02953;
import com.facebook.pages.common.services.PagesServicesFragment.C02964;
import com.facebook.pages.common.services.PagesServicesFragment.C02975;
import com.facebook.pages.common.services.PagesServicesFragment.C02986;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.pages.identity.protocol.graphql.ServicesMutations.ServicesSectionUpdateMutationString;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: review_sections */
public class PagesServicesListAdapter extends FbBaseAdapter {
    private Context f2395a;
    private LayoutInflater f2396b;
    public final FunnelLoggerImpl f2397c;
    public boolean f2398d = false;
    private boolean f2399e = false;
    public OnClickListener f2400f;
    public C02953 f2401g;
    public C02986 f2402h;
    public C02964 f2403i;
    public C02975 f2404j;
    private String f2405k;
    public PageHeaderData f2406l;
    public boolean f2407m;
    public boolean f2408n = false;
    public List<PageServiceItem> f2409o;
    public List<PageServiceItem> f2410p;
    private String f2411q;
    private boolean f2412r;
    private String f2413s;
    public PageServiceItemModel f2414t = null;

    /* compiled from: review_sections */
    class C03063 implements OnCheckedChangeListener {
        final /* synthetic */ PagesServicesListAdapter f2391a;

        C03063(PagesServicesListAdapter pagesServicesListAdapter) {
            this.f2391a = pagesServicesListAdapter;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f2391a.f2403i != null) {
                String str;
                C02964 c02964 = this.f2391a.f2403i;
                if (z) {
                    str = "published";
                } else {
                    str = "staging";
                }
                PagesServicesFragment pagesServicesFragment = c02964.f2359a;
                String str2 = pagesServicesFragment.aw;
                if (PagesServicesFragment.m3320b(str) && !StringUtil.a(str, pagesServicesFragment.aw)) {
                    pagesServicesFragment.aw = str;
                    TasksManager tasksManager = pagesServicesFragment.f2366a;
                    String str3 = "update_services_data";
                    GraphQLQueryExecutor graphQLQueryExecutor = pagesServicesFragment.f2367b;
                    GraphQlQueryString servicesSectionUpdateMutationString = new ServicesSectionUpdateMutationString();
                    PageServicesSectionInputData pageServicesSectionInputData = new PageServicesSectionInputData();
                    pageServicesSectionInputData.a(pagesServicesFragment.ap.f2416b);
                    if ("published".equals(str)) {
                        pageServicesSectionInputData.a(Visibility.PUBLISHED);
                    } else {
                        pageServicesSectionInputData.a(Visibility.STAGING);
                    }
                    servicesSectionUpdateMutationString.a("input", pageServicesSectionInputData);
                    tasksManager.a(str3, graphQLQueryExecutor.a(GraphQLRequest.a(servicesSectionUpdateMutationString)), new AnonymousClass10(pagesServicesFragment, str2));
                }
            }
        }
    }

    /* compiled from: review_sections */
    class ItemState {
        public final ServiceItemViewType f2393a;
        public final int f2394b;

        ItemState(ServiceItemViewType serviceItemViewType, int i) {
            this.f2393a = serviceItemViewType;
            this.f2394b = i;
        }
    }

    /* compiled from: review_sections */
    enum ServiceItemViewType {
        ADMIN_SETTINGS,
        ADD_SERVICE_BUTTON,
        INTRO_MESSAGE,
        EMPTY_LIST_TEXT,
        SERVICE_ITEM,
        SERVICE_ITEM_LARGE,
        SERVICES_CAROUSEL,
        ADMIN_NO_SERVICES_TEXT
    }

    public PagesServicesListAdapter(Context context, LayoutInflater layoutInflater, FunnelLoggerImpl funnelLoggerImpl) {
        this.f2395a = context;
        this.f2396b = layoutInflater;
        this.f2397c = funnelLoggerImpl;
    }

    public final void m3356a(List<PageServiceItem> list, List<PageServiceItem> list2, @Nullable String str, boolean z, String str2) {
        boolean z2;
        this.f2409o = list;
        this.f2410p = list2;
        if (!(this.f2410p == null || this.f2410p.isEmpty())) {
            for (PageServiceItemModel a : this.f2410p) {
                if (PagesServiceUtils.m3305a(a) != null) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        this.f2399e = z2;
        this.f2411q = str;
        this.f2412r = z;
        this.f2413s = str2;
        AdapterDetour.a(this, 112043066);
    }

    public final View m3352a(int i, ViewGroup viewGroup) {
        if (i == ServiceItemViewType.SERVICE_ITEM.ordinal()) {
            return new PagesServiceItem(viewGroup.getContext());
        }
        if (i == ServiceItemViewType.ADD_SERVICE_BUTTON.ordinal()) {
            return this.f2396b.inflate(2130906125, viewGroup, false);
        }
        if (i == ServiceItemViewType.INTRO_MESSAGE.ordinal()) {
            Preconditions.checkNotNull(this.f2405k);
            FbTextView fbTextView = (FbTextView) this.f2396b.inflate(2130906129, viewGroup, false);
            fbTextView.setText(this.f2405k);
            fbTextView.setBackgroundResource(2131361920);
            return fbTextView;
        } else if (i == ServiceItemViewType.EMPTY_LIST_TEXT.ordinal()) {
            return this.f2396b.inflate(2130906127, viewGroup, false);
        } else {
            if (i == ServiceItemViewType.SERVICE_ITEM_LARGE.ordinal()) {
                return new PagesServiceItemLarge(viewGroup.getContext());
            }
            if (i == ServiceItemViewType.SERVICES_CAROUSEL.ordinal()) {
                return new PagesServiceCarousel(viewGroup.getContext());
            }
            if (i == ServiceItemViewType.ADMIN_SETTINGS.ordinal()) {
                return new PagesServicesAdminSettings(viewGroup.getContext());
            }
            if (i == ServiceItemViewType.ADMIN_NO_SERVICES_TEXT.ordinal()) {
                return this.f2396b.inflate(2130906123, viewGroup, false);
            }
            return null;
        }
    }

    public final void m3353a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        final PageServiceItemModel pageServiceItemModel;
        if (i2 == ServiceItemViewType.SERVICE_ITEM.ordinal()) {
            pageServiceItemModel = (PageServiceItemModel) obj;
            ((PagesServiceItem) view).m3301a(null, pageServiceItemModel.eC_(), pageServiceItemModel.c(), new OnClickListener(this) {
                final /* synthetic */ PagesServicesListAdapter f2388b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1205032307);
                    if (this.f2388b.f2401g != null) {
                        this.f2388b.f2401g.m3309a(pageServiceItemModel);
                    } else {
                        this.f2388b.f2397c.b(FunnelRegistry.L, "tap_list_service_item");
                        this.f2388b.m3354a(pageServiceItemModel);
                    }
                    LogUtils.a(529941474, a);
                }
            });
            if (pageServiceItemModel.d() != null && pageServiceItemModel.d().equals(this.f2411q)) {
                ((PagesServiceItem) view).m3300a(1500);
            }
        } else if (i2 == ServiceItemViewType.ADD_SERVICE_BUTTON.ordinal()) {
            view.setOnClickListener((OnClickListener) obj);
        } else if (i2 == ServiceItemViewType.SERVICE_ITEM_LARGE.ordinal()) {
            pageServiceItemModel = (PageServiceItemModel) obj;
            ((PagesServiceItemLarge) view).m3304a(PagesServiceUtils.m3305a(pageServiceItemModel), pageServiceItemModel.eC_(), pageServiceItemModel.c(), pageServiceItemModel.b(), this.f2407m, this.f2406l);
        } else if (i2 == ServiceItemViewType.SERVICES_CAROUSEL.ordinal()) {
            final PagesServiceCarousel pagesServiceCarousel = (PagesServiceCarousel) view;
            pagesServiceCarousel.m3292a(this.f2410p, new PagesServiceCarouselItemClickListener(this) {
                final /* synthetic */ PagesServicesListAdapter f2390b;

                public final void mo44a(PageServiceItemModel pageServiceItemModel) {
                    pagesServiceCarousel.m3293g();
                    if (this.f2390b.f2401g != null) {
                        this.f2390b.f2401g.m3309a(pageServiceItemModel);
                        return;
                    }
                    this.f2390b.f2397c.b(FunnelRegistry.L, "tap_featured_service_item");
                    this.f2390b.m3354a(pageServiceItemModel);
                }
            });
        } else if (i2 == ServiceItemViewType.ADMIN_SETTINGS.ordinal()) {
            ((PagesServicesAdminSettings) view).m3306a("published".equals(this.f2413s), CollectionUtil.b(this.f2409o), new C03063(this), this.f2404j);
        }
    }

    public int getCount() {
        int i = 1;
        if (this.f2414t != null) {
            return 1;
        }
        if (!m3351c()) {
            i = 0;
        }
        if (this.f2399e) {
            i++;
        }
        if (this.f2398d) {
            i++;
        }
        if (this.f2405k != null) {
            i++;
        }
        return CollectionUtil.b(this.f2409o) ? i + this.f2409o.size() : i + 1;
    }

    private boolean m3351c() {
        return (!this.f2412r || this.f2403i == null || StringUtil.a(this.f2413s) || this.f2404j == null) ? false : true;
    }

    private ItemState m3350a(int i) {
        if (this.f2414t != null) {
            return new ItemState(ServiceItemViewType.SERVICE_ITEM_LARGE, i);
        }
        Preconditions.checkPositionIndex(i, getCount());
        int i2 = 0;
        if (m3351c()) {
            if (i + 0 == 0) {
                return new ItemState(ServiceItemViewType.ADMIN_SETTINGS, -1);
            }
            i2 = 1;
        }
        if (this.f2399e) {
            if (i - i2 == 0) {
                return new ItemState(ServiceItemViewType.SERVICES_CAROUSEL, -1);
            }
            i2++;
        }
        if (this.f2398d) {
            if (i - i2 == 0) {
                return new ItemState(ServiceItemViewType.ADD_SERVICE_BUTTON, -1);
            }
            i2++;
        }
        if (this.f2405k != null) {
            if (i - i2 == 0) {
                return new ItemState(ServiceItemViewType.INTRO_MESSAGE, -1);
            }
            i2++;
        }
        if (CollectionUtil.b(this.f2409o)) {
            return new ItemState(ServiceItemViewType.SERVICE_ITEM, i - i2);
        }
        if (this.f2412r) {
            return new ItemState(ServiceItemViewType.ADMIN_NO_SERVICES_TEXT, -1);
        }
        return new ItemState(ServiceItemViewType.EMPTY_LIST_TEXT, -1);
    }

    public Object getItem(int i) {
        ItemState a = m3350a(i);
        switch (a.f2393a) {
            case ADD_SERVICE_BUTTON:
                Preconditions.checkNotNull(this.f2400f);
                return this.f2400f;
            case SERVICE_ITEM:
                int i2 = a.f2394b;
                Preconditions.checkNotNull(this.f2409o);
                return (PageServiceItemModel) this.f2409o.get(i2);
            case SERVICE_ITEM_LARGE:
                return this.f2414t;
            default:
                return null;
        }
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        return m3350a(i).f2393a.ordinal();
    }

    public int getViewTypeCount() {
        return ServiceItemViewType.values().length;
    }

    public final void m3355a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            str = null;
        }
        this.f2405k = str;
    }

    public final void m3354a(PageServiceItemModel pageServiceItemModel) {
        if (this.f2408n) {
            this.f2402h.m3310a(pageServiceItemModel);
            return;
        }
        this.f2414t = pageServiceItemModel;
        AdapterDetour.a(this, -546898582);
        if (this.f2402h != null) {
            this.f2402h.m3310a(pageServiceItemModel);
        }
    }
}

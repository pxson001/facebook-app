package com.facebook.saved2.ui;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.saved.common.data.SavedSectionResources;
import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryDAO;
import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryDAOImpl;
import com.facebook.saved2.ui.LoadItemsController.StateMachine;
import com.facebook.saved2.ui.itemadapters.Saved2DAOItemsAdapterProvider;
import com.facebook.saved2.ui.itemadapters.Saved2DownloadItemsHelper;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactory;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactoryProvider;
import com.facebook.video.events.VideoDownloadEventBus;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import javax.inject.Inject;

/* compiled from: instant_shopping */
public class SavedSectionsPagerAdapter extends DAOItemCursorPagerAdapter<BaseQueryDAO> {
    private final FragmentActivity f9510a;
    private final LoadItemsController f9511b;
    private final Saved2GroupedItemsAdapterFactoryProvider f9512c;

    /* compiled from: instant_shopping */
    class ItemHolder {
        public String f9505a;
        public int f9506b;
        public View f9507c;
        public LoadingIndicatorView f9508d;
        public Saved2GroupedItemsAdapterFactory f9509e;
    }

    @Inject
    public SavedSectionsPagerAdapter(@Assisted FragmentActivity fragmentActivity, @Assisted LoadItemsController loadItemsController, Saved2GroupedItemsAdapterFactoryProvider saved2GroupedItemsAdapterFactoryProvider) {
        this.f9510a = fragmentActivity;
        this.f9511b = loadItemsController;
        this.f9512c = saved2GroupedItemsAdapterFactoryProvider;
    }

    public final CharSequence J_(int i) {
        CharSequence e = ((BaseQueryDAOImpl) m9713a(i)).e();
        int a = SavedSectionResources.a(e, 0);
        return a != 0 ? this.f9510a.getString(a) : e;
    }

    public final boolean m9786a(View view, Object obj) {
        return ((ItemHolder) obj).f9507c == view;
    }

    public final int m9783a(Object obj) {
        ItemHolder itemHolder = (ItemHolder) obj;
        if (this.a == null) {
            return -2;
        }
        int a = FindSectionUtil.m9717a((BaseQueryDAOImpl) m9716e(), itemHolder.f9505a);
        if (a < 0) {
            return -2;
        }
        if (a == itemHolder.f9506b) {
            return -1;
        }
        itemHolder.f9506b = a;
        return a;
    }

    public final Object m9784a(ViewGroup viewGroup, int i) {
        String e = ((BaseQueryDAOImpl) m9713a(i)).e();
        Integer.valueOf(i);
        ItemHolder itemHolder = new ItemHolder();
        itemHolder.f9505a = e;
        itemHolder.f9506b = i;
        itemHolder.f9507c = LayoutInflater.from(this.f9510a).inflate(2130906939, viewGroup, false);
        itemHolder.f9508d = (LoadingIndicatorView) itemHolder.f9507c.findViewById(2131567210);
        Saved2GroupedItemsAdapterFactoryProvider saved2GroupedItemsAdapterFactoryProvider = this.f9512c;
        itemHolder.f9509e = new Saved2GroupedItemsAdapterFactory(this.f9510a, e, VideoDownloadEventBus.a(saved2GroupedItemsAdapterFactoryProvider), Saved2DownloadItemsHelper.m9869a(saved2GroupedItemsAdapterFactoryProvider), (Saved2DAOItemsAdapterProvider) saved2GroupedItemsAdapterFactoryProvider.getOnDemandAssistedProviderForStaticDi(Saved2DAOItemsAdapterProvider.class));
        viewGroup.addView(itemHolder.f9507c);
        this.f9511b.m9763a(e).m9761a(itemHolder.f9508d, itemHolder.f9509e, 2131567209, 2131559427, 2130906933);
        return itemHolder;
    }

    public final void m9785a(ViewGroup viewGroup, int i, Object obj) {
        ItemHolder itemHolder = (ItemHolder) obj;
        Integer.valueOf(i);
        viewGroup.removeView(itemHolder.f9507c);
        StateMachine a = this.f9511b.m9763a(itemHolder.f9505a);
        a.f9462a.mo441c(a);
        a.f9474m = null;
        a.f9471j = null;
        a.f9476o = -1;
        a.f9477p = -1;
        a.f9478q = 0;
    }
}

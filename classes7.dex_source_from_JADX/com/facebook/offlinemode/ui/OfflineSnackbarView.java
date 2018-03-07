package com.facebook.offlinemode.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_free_data_notification_click */
public class OfflineSnackbarView extends CustomLinearLayout {
    @Inject
    public SettingsOfflineSnackbarActionController f9080a;
    @Inject
    public Provider<BottomSheetDialog> f9081b;
    public OfflineSnackbarActionController f9082c;

    /* compiled from: messenger_free_data_notification_click */
    class C07331 implements OnClickListener {
        final /* synthetic */ OfflineSnackbarView f9077a;

        C07331(OfflineSnackbarView offlineSnackbarView) {
            this.f9077a = offlineSnackbarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1050788592);
            OfflineSnackbarView offlineSnackbarView = this.f9077a;
            List arrayList = new ArrayList();
            arrayList.add(offlineSnackbarView.f9080a);
            if (offlineSnackbarView.f9082c != null) {
                arrayList.add(offlineSnackbarView.f9082c);
            }
            List<OfflineSnackbarActionController> list = arrayList;
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) this.f9077a.f9081b.get();
            OfflineSnackbarView offlineSnackbarView2 = this.f9077a;
            BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(offlineSnackbarView2.getContext());
            for (OfflineSnackbarActionController offlineSnackbarActionController : list) {
                bottomSheetAdapter.e(offlineSnackbarActionController.mo43a()).setIcon(offlineSnackbarActionController.mo45b()).setOnMenuItemClickListener(new C07342(offlineSnackbarView2, offlineSnackbarActionController));
            }
            bottomSheetDialog.m19815a((Adapter) bottomSheetAdapter);
            bottomSheetDialog.show();
            for (OfflineSnackbarActionController c : list) {
                c.mo46c();
            }
            LogUtils.a(-375171977, a);
        }
    }

    /* compiled from: messenger_free_data_notification_click */
    public class C07342 implements OnMenuItemClickListener {
        final /* synthetic */ OfflineSnackbarActionController f9078a;
        final /* synthetic */ OfflineSnackbarView f9079b;

        public C07342(OfflineSnackbarView offlineSnackbarView, OfflineSnackbarActionController offlineSnackbarActionController) {
            this.f9079b = offlineSnackbarView;
            this.f9078a = offlineSnackbarActionController;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f9078a.mo44a(this.f9079b.getContext());
            return true;
        }
    }

    public static void m10899a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        OfflineSnackbarView offlineSnackbarView = (OfflineSnackbarView) obj;
        SettingsOfflineSnackbarActionController a = SettingsOfflineSnackbarActionController.m10900a(injectorLike);
        Provider a2 = IdBasedProvider.a(injectorLike, 11752);
        offlineSnackbarView.f9080a = a;
        offlineSnackbarView.f9081b = a2;
    }

    public OfflineSnackbarView(Context context) {
        this(context, null);
    }

    private OfflineSnackbarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = OfflineSnackbarView.class;
        m10899a(this, getContext());
        setContentView(2130905543);
        setBackgroundResource(2131361953);
        setOrientation(0);
        a(2131564395).setOnClickListener(new C07331(this));
    }
}

package com.facebook.groups.info.view;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.groups.info.GroupInfoAdapterRows;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupeventrow.GroupEventRowView;
import com.facebook.groups.widget.infoview.InfoTitleRowView;
import com.facebook.groups.widget.preferenceview.GroupNotificationsSettingPreferenceView;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Tap to disable manual controls */
public class DefaultGroupInfoViewManager {
    private Resources f22859a;

    /* compiled from: Tap to disable manual controls */
    public class C32941 extends AbstractSection<View> {
        final /* synthetic */ FetchGroupInfoPageDataModel f22857a;
        final /* synthetic */ DefaultGroupInfoViewManager f22858b;

        public C32941(DefaultGroupInfoViewManager defaultGroupInfoViewManager, ViewType viewType, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel) {
            this.f22858b = defaultGroupInfoViewManager;
            this.f22857a = fetchGroupInfoPageDataModel;
            super(viewType);
        }

        public final void mo11a(View view) {
            String str;
            if (this.f22857a == null || this.f22857a.m23886l() == null || this.f22857a.m23886l().m23743a() == null || this.f22857a.m23886l().m23743a().m23739a() == null) {
                str = null;
            } else {
                str = this.f22857a.m23859D().m23803a().m23799j().m23793a();
            }
            GroupBasicInfoView groupBasicInfoView = (GroupBasicInfoView) view;
            CharSequence b = this.f22857a.m23880b();
            CharSequence a = this.f22857a.m23873R().m23844a();
            groupBasicInfoView.f22862j.setText(b);
            groupBasicInfoView.f22863k.setText(a);
            if (Strings.isNullOrEmpty(str)) {
                ((GenericDraweeHierarchy) groupBasicInfoView.f22861i.getHierarchy()).b(2130843732);
            } else {
                ((GenericDraweeHierarchy) groupBasicInfoView.f22861i.getHierarchy()).b(null);
                groupBasicInfoView.f22861i.a(Uri.parse(str), GroupBasicInfoView.f22860h);
            }
            view.setOnClickListener(null);
        }
    }

    public static DefaultGroupInfoViewManager m24006b(InjectorLike injectorLike) {
        return new DefaultGroupInfoViewManager(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultGroupInfoViewManager(Resources resources) {
        this.f22859a = resources;
    }

    public final void m24007a(View view, ViewType<?> viewType) {
        int dimensionPixelSize = this.f22859a.getDimensionPixelSize(2131434298);
        if (viewType.equals(GroupInfoAdapterRows.f22691o)) {
            InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
            if (infoTitleRowView.f23257a != null) {
                infoTitleRowView.f23257a.setPadding(dimensionPixelSize, infoTitleRowView.f23257a.getPaddingTop(), dimensionPixelSize, infoTitleRowView.f23257a.getPaddingBottom());
            }
            if (infoTitleRowView.f23258b != null) {
                infoTitleRowView.f23258b.setPadding(dimensionPixelSize, infoTitleRowView.f23258b.getPaddingTop(), dimensionPixelSize, infoTitleRowView.f23258b.getPaddingBottom());
            }
        } else if (viewType.equals(GroupInfoAdapterRows.f22689m)) {
            GroupEventRowView groupEventRowView = (GroupEventRowView) view;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) groupEventRowView.a(2131561518).getLayoutParams();
            marginLayoutParams.setMargins(dimensionPixelSize, marginLayoutParams.topMargin, dimensionPixelSize, marginLayoutParams.bottomMargin);
            if (groupEventRowView.f23223j != null) {
                groupEventRowView.f23223j.setHorizontalMargin(dimensionPixelSize);
            }
        } else if (viewType.equals(GroupInfoAdapterRows.f22690n)) {
            GroupNotificationsSettingPreferenceView groupNotificationsSettingPreferenceView = (GroupNotificationsSettingPreferenceView) view;
            BetterTextView betterTextView = (BetterTextView) groupNotificationsSettingPreferenceView.a(2131560307);
            betterTextView.setPadding(dimensionPixelSize, betterTextView.getPaddingTop(), dimensionPixelSize, betterTextView.getPaddingBottom());
            groupNotificationsSettingPreferenceView.a.setPadding(dimensionPixelSize, groupNotificationsSettingPreferenceView.a.getPaddingTop(), dimensionPixelSize, groupNotificationsSettingPreferenceView.a.getPaddingBottom());
        }
    }
}

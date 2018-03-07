package com.facebook.groups.editsettings.adapter;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.fragment.GroupEditPrivacyFragment.C30951;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.PossibleVisibilitySettingsModel.EdgesModel;
import com.facebook.groups.editsettings.util.GroupPrivacyDescriptionUtil;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: UnicodeBigUnmarked */
public class GroupEditPrivacyAdapter extends FbBaseAdapter {
    public GroupEditSettingsController f21541a;
    public FragmentManager f21542b;
    private C30951 f21543c;
    public Resources f21544d;
    public Locales f21545e;
    public GroupPrivacyDescriptionUtil f21546f;
    public OnClickListener f21547g;
    public String f21548h;
    public FetchGroupSettingsModel f21549i;
    private ImmutableList<Section> f21550j = RegularImmutableList.a;

    /* compiled from: UnicodeBigUnmarked */
    public class C30693 implements OnClickListener {
        final /* synthetic */ GroupEditPrivacyAdapter f21539a;

        public C30693(GroupEditPrivacyAdapter groupEditPrivacyAdapter) {
            this.f21539a = groupEditPrivacyAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1502941143);
            CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
            final String str = checkablePreferenceView.d;
            if (!str.equals(this.f21539a.f21548h)) {
                String str2;
                CharSequence string;
                DialogInterface.OnClickListener c30681 = new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ C30693 f21538b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f21538b.f21539a.f21541a.m22540a(this.f21538b.f21539a.f21549i.m22807r(), GraphQLGroupVisibility.fromString(str), this.f21538b.f21539a.f21542b);
                        this.f21538b.f21539a.f21548h = str;
                        GroupEditPrivacyAdapter.m22552b(this.f21538b.f21539a);
                        dialogInterface.dismiss();
                    }
                };
                if (checkablePreferenceView.getTitleText() == null) {
                    str2 = null;
                } else {
                    str2 = checkablePreferenceView.getTitleText().toLowerCase(this.f21539a.f21545e.a());
                }
                GroupEditPrivacyAdapter groupEditPrivacyAdapter = this.f21539a;
                Builder builder = new Builder(view.getContext());
                builder.a(groupEditPrivacyAdapter.f21544d.getString(2131242152));
                builder.a(2131230729, c30681);
                builder.b(2131230727, new C30704(groupEditPrivacyAdapter));
                if (groupEditPrivacyAdapter.f21549i.m22805p() == null || groupEditPrivacyAdapter.f21549i.m22805p().m22725a() < groupEditPrivacyAdapter.f21549i.m22790A() || GroupPrivacyDescriptionUtil.m22874b(groupEditPrivacyAdapter.f21549i)) {
                    string = groupEditPrivacyAdapter.f21544d.getString(2131242166, new Object[]{str2});
                } else if (groupEditPrivacyAdapter.f21546f.m22878a(groupEditPrivacyAdapter.f21549i)) {
                    string = groupEditPrivacyAdapter.f21544d.getString(2131242167, new Object[]{str2});
                } else {
                    string = groupEditPrivacyAdapter.f21544d.getString(2131242168) + " " + groupEditPrivacyAdapter.f21544d.getString(2131242166, new Object[]{str2});
                }
                builder.b(string);
                builder.a().show();
            }
            LogUtils.a(1413027233, a);
        }
    }

    /* compiled from: UnicodeBigUnmarked */
    public class C30704 implements DialogInterface.OnClickListener {
        final /* synthetic */ GroupEditPrivacyAdapter f21540a;

        public C30704(GroupEditPrivacyAdapter groupEditPrivacyAdapter) {
            this.f21540a = groupEditPrivacyAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    @Inject
    public GroupEditPrivacyAdapter(@Assisted FragmentManager fragmentManager, @Assisted C30951 c30951, GroupPrivacyDescriptionUtil groupPrivacyDescriptionUtil, GroupEditSettingsController groupEditSettingsController, Resources resources, Locales locales) {
        this.f21542b = fragmentManager;
        this.f21543c = c30951;
        this.f21546f = groupPrivacyDescriptionUtil;
        this.f21541a = groupEditSettingsController;
        this.f21544d = resources;
        this.f21545e = locales;
        this.f21547g = new C30693(this);
    }

    public final void m22556a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public static void m22552b(GroupEditPrivacyAdapter groupEditPrivacyAdapter) {
        groupEditPrivacyAdapter.f21541a.f21530k = groupEditPrivacyAdapter.f21543c;
        groupEditPrivacyAdapter.f21550j = RegularImmutableList.a;
        ImmutableList.Builder builder = ImmutableList.builder();
        if (!(groupEditPrivacyAdapter.f21549i == null || groupEditPrivacyAdapter.f21549i.m22805p() == null || groupEditPrivacyAdapter.f21549i.m22792C() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || groupEditPrivacyAdapter.f21549i.m22805p().m22725a() < groupEditPrivacyAdapter.f21549i.m22790A() || GroupPrivacyDescriptionUtil.m22874b(groupEditPrivacyAdapter.f21549i))) {
            String string;
            if (groupEditPrivacyAdapter.f21546f.m22878a(groupEditPrivacyAdapter.f21549i)) {
                string = groupEditPrivacyAdapter.f21544d.getString(2131242165, new Object[]{groupEditPrivacyAdapter.f21546f.m22877a(groupEditPrivacyAdapter.f21549i, groupEditPrivacyAdapter.f21549i.m22815z())});
            } else {
                string = groupEditPrivacyAdapter.f21544d.getString(2131242164, new Object[]{Integer.valueOf(groupEditPrivacyAdapter.f21549i.m22790A())});
            }
            builder.c(new AbstractSection<TextView>(groupEditPrivacyAdapter, GroupEditPrivacyAdapterRows.f21553c) {
                final /* synthetic */ GroupEditPrivacyAdapter f21534b;

                public final void mo11a(View view) {
                    TextView textView = (TextView) view;
                    textView.setText(this.f21534b.f21546f.m22875a(string));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            });
            builder.c(m22554c());
        }
        groupEditPrivacyAdapter.m22553b(builder);
        groupEditPrivacyAdapter.f21550j = builder.b();
        AdapterDetour.a(groupEditPrivacyAdapter, -1428199517);
    }

    private void m22553b(ImmutableList.Builder<Section> builder) {
        if (this.f21549i.m22813x() != null && this.f21549i.m22813x().m22782a() != null) {
            ImmutableList a = this.f21549i.m22813x().m22782a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                final EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (!(edgesModel == null || edgesModel.m22778k() == null || edgesModel.m22778k().name() == null)) {
                    builder.c(new AbstractSection<CheckablePreferenceView>(this, GroupEditPrivacyAdapterRows.f21551a) {
                        final /* synthetic */ GroupEditPrivacyAdapter f21536b;

                        public final void mo11a(View view) {
                            CheckablePreferenceView checkablePreferenceView = (CheckablePreferenceView) view;
                            checkablePreferenceView.a(edgesModel.m22777j(), edgesModel.m22776a(), edgesModel.m22778k().name().equals(this.f21536b.f21548h), edgesModel.m22778k().name());
                            checkablePreferenceView.setOnClickListener(this.f21536b.f21547g);
                        }
                    });
                    builder.c(m22554c());
                }
            }
        }
    }

    public static Section<View> m22554c() {
        return new StaticSection(GroupEditPrivacyAdapterRows.f21552b);
    }

    public int getItemViewType(int i) {
        return GroupEditPrivacyAdapterRows.f21554d.indexOf(((Section) this.f21550j.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return GroupEditPrivacyAdapterRows.f21554d.size();
    }

    public final View m22555a(int i, ViewGroup viewGroup) {
        return ((ViewType) GroupEditPrivacyAdapterRows.f21554d.get(i)).mo12a(viewGroup);
    }

    public int getCount() {
        return this.f21550j.size();
    }

    public Object getItem(int i) {
        return this.f21550j.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}

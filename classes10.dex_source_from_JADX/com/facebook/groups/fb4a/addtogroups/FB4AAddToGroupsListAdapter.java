package com.facebook.groups.fb4a.addtogroups;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroupsModels.FetchUserGroupsForProfileAddToGroupsModel.GroupsModel.EdgesModel;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: wsx */
public class FB4AAddToGroupsListAdapter extends FbBaseAdapter {
    public static final CallerContext f277e = CallerContext.a(FB4AAddToGroupsListAdapter.class, "add_member");
    private ImmutableList<Section> f278a = RegularImmutableList.a;
    public String f279b;
    public final Resources f280c;
    public final SecureContextHelper f281d;

    @Inject
    public FB4AAddToGroupsListAdapter(@Assisted BetterListView betterListView, @Assisted FragmentManager fragmentManager, Resources resources, SecureContextHelper secureContextHelper) {
        this.f280c = resources;
        this.f281d = secureContextHelper;
    }

    public final void m322a(String str, ImmutableList<EdgesModel> immutableList, final FB4AAddToGroupsController fB4AAddToGroupsController, boolean z) {
        this.f279b = str;
        Builder builder = ImmutableList.builder();
        builder.c(new AbstractSection<FrameLayout>(this, FB4AAddToGroupsListAdapterRows.f285d) {
            final /* synthetic */ FB4AAddToGroupsListAdapter f276a;

            /* compiled from: wsx */
            class C00521 implements OnClickListener {
                final /* synthetic */ C00533 f275a;

                C00521(C00533 c00533) {
                    this.f275a = c00533;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 136942927);
                    String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/groups/create/?addees=%s", this.f275a.f276a.f279b);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(formatStrLocaleSafe))));
                    this.f275a.f276a.f281d.a(intent, view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1553335701, a);
                }
            }

            public final void mo11a(View view) {
                ((FrameLayout) view).setOnClickListener(new C00521(this));
            }
        });
        if (z) {
            builder.c(new AbstractSection<FrameLayout>(this, FB4AAddToGroupsListAdapterRows.f283b) {
                final /* synthetic */ FB4AAddToGroupsListAdapter f269a;

                public final /* bridge */ /* synthetic */ void mo11a(View view) {
                }
            });
        }
        if (!(immutableList == null || immutableList.isEmpty())) {
            for (int i = 0; i < immutableList.size(); i++) {
                final EdgesModel edgesModel = (EdgesModel) immutableList.get(i);
                if (!(edgesModel.m332a() == null || edgesModel.m332a().m382l() == null)) {
                    builder.c(new AbstractSection<LinearLayout>(this, FB4AAddToGroupsListAdapterRows.f284c) {
                        final /* synthetic */ FB4AAddToGroupsListAdapter f274c;

                        public final void mo11a(View view) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            ((BetterTextView) linearLayout.findViewById(2131562738)).setText(edgesModel.m332a().m382l());
                            FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131562737);
                            if (edgesModel.m332a().m380j() == null || edgesModel.m332a().m380j().m371a() == null || edgesModel.m332a().m380j().m371a().m367j() == null || edgesModel.m332a().m380j().m371a().m367j().m361a() == null) {
                                fbDraweeView.a(null, FB4AAddToGroupsListAdapter.f277e);
                            } else {
                                fbDraweeView.a(Uri.parse(edgesModel.m332a().m380j().m371a().m367j().m361a()), FB4AAddToGroupsListAdapter.f277e);
                            }
                            final String k = edgesModel.m332a().m381k();
                            boolean c = fB4AAddToGroupsController.m296c(k);
                            View findViewById = linearLayout.findViewById(2131562739);
                            findViewById.getBackground().setColorFilter(this.f274c.f280c.getColor(2131363508), Mode.SRC_IN);
                            if (c) {
                                findViewById.setVisibility(0);
                                linearLayout.setContentDescription(this.f274c.f280c.getString(2131237828, new Object[]{edgesModel.m332a().m382l()}));
                            } else {
                                findViewById.setVisibility(4);
                                linearLayout.setContentDescription(this.f274c.f280c.getString(2131237829, new Object[]{edgesModel.m332a().m382l()}));
                            }
                            linearLayout.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ C00512 f271b;

                                public void onClick(View view) {
                                    int a = Logger.a(2, EntryType.UI_INPUT_START, 642122999);
                                    FB4AAddToGroupsController fB4AAddToGroupsController;
                                    if (fB4AAddToGroupsController.m296c(k)) {
                                        fB4AAddToGroupsController = fB4AAddToGroupsController;
                                        String str = k;
                                        if (fB4AAddToGroupsController.f246a.contains(str)) {
                                            fB4AAddToGroupsController.f246a.remove(str);
                                        }
                                    } else {
                                        fB4AAddToGroupsController = fB4AAddToGroupsController;
                                        fB4AAddToGroupsController.f246a.add(k);
                                    }
                                    AdapterDetour.a(this.f271b.f274c, -1223919296);
                                    LogUtils.a(-1082288865, a);
                                }
                            });
                        }
                    });
                }
            }
        }
        this.f278a = builder.b();
        AdapterDetour.a(this, 393482569);
    }

    public int getItemViewType(int i) {
        return FB4AAddToGroupsListAdapterRows.f286e.indexOf(((Section) this.f278a.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return FB4AAddToGroupsListAdapterRows.f286e.size();
    }

    public final View m320a(int i, ViewGroup viewGroup) {
        return ((ViewType) FB4AAddToGroupsListAdapterRows.f286e.get(i)).mo12a(viewGroup);
    }

    public final void m321a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getCount() {
        return this.f278a.size();
    }

    public Object getItem(int i) {
        return this.f278a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}

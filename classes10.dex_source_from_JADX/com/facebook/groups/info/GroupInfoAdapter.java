package com.facebook.groups.info;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.model.Event;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groups.constants.GroupMsiteUrls;
import com.facebook.groups.constants.GroupsConstants.GroupMallType;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.info.protocol.FetchGroupInfoEventsModels.FetchGroupInfoEventsModel.GroupEventsModel;
import com.facebook.groups.info.protocol.FetchGroupInfoEventsModels.FetchGroupInfoEventsModel.GroupEventsModel.EdgesModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel.GroupPendingMembersModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel.GroupPendingStoriesModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel.GroupReportedStoriesModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel.GroupTopicTagsModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPhotosModels.FetchGroupInfoPhotosModel.GroupMediasetModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPhotosModels.FetchGroupInfoPhotosModel.GroupMediasetModel.MediaModel;
import com.facebook.groups.info.protocol.FetchGroupInfoPhotosModels.FetchGroupInfoPhotosModel.GroupMediasetModel.MediaModel.EdgesModel.NodeModel;
import com.facebook.groups.info.util.GroupInfoDescriptionUtil;
import com.facebook.groups.info.view.DefaultGroupInfoViewManager;
import com.facebook.groups.info.view.DefaultGroupInfoViewManager.C32941;
import com.facebook.groups.info.view.GroupInfoTopicView;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupeventrow.GroupEventRowView;
import com.facebook.groups.widget.groupeventrow.GroupEventRsvpViewListener;
import com.facebook.groups.widget.infoview.InfoTitleRowView;
import com.facebook.groups.widget.preferenceview.GroupNotificationsSettingPreferenceView;
import com.facebook.groups.widget.preferenceview.GroupNotificationsSettingPreferenceView.1;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.SetIdMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.text.linkify.SafeLinkifier;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

/* compiled from: ThreadListFragment.onCreateThroughOnResume */
public class GroupInfoAdapter extends FbBaseAdapter {
    public static final CallerContext f22659a = CallerContext.a(GroupInfoAdapter.class, "group_info");
    public final BetterListView f22660b;
    public final GroupEventRsvpViewListener f22661c;
    public final Resources f22662d;
    public final BetterLinkMovementMethod f22663e;
    private final GatekeeperStoreImpl f22664f;
    public final MediaGalleryLauncher f22665g;
    public final DefaultGroupInfoViewManager f22666h;
    public final EventGraphQLModelHelper f22667i;
    public final FragmentManager f22668j;
    public final DefaultGroupLeaveActionResponder f22669k;
    public final DefaultGroupInfoClickHandler f22670l;
    public final FetchGroupInformationModel f22671m;
    public final boolean f22672n;
    private ImmutableList<Section> f22673o = ImmutableList.of();
    private GroupMallType f22674p;
    public boolean f22675q = false;
    public SpannableString f22676r;

    /* compiled from: ThreadListFragment.onCreateThroughOnResume */
    /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] f22640a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f22640a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22640a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22640a[GraphQLSubscribeStatus.CANNOT_SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: ThreadListFragment.onCreateThroughOnResume */
    public class C32795 extends ClickableSpan {
        final /* synthetic */ Resources f22649a;
        final /* synthetic */ GroupInfoAdapter f22650b;

        public C32795(GroupInfoAdapter groupInfoAdapter, Resources resources) {
            this.f22650b = groupInfoAdapter;
            this.f22649a = resources;
        }

        public void onClick(View view) {
            this.f22650b.f22675q = true;
            AdapterDetour.a(this.f22650b, 1612779060);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f22649a.getColor(2131363508));
        }
    }

    @Inject
    public GroupInfoAdapter(@Assisted BetterListView betterListView, @Assisted FragmentManager fragmentManager, @Assisted GroupEventRsvpViewListener groupEventRsvpViewListener, @Assisted DefaultGroupLeaveActionResponder defaultGroupLeaveActionResponder, @Assisted GroupMallType groupMallType, @Assisted FetchGroupInformationModel fetchGroupInformationModel, Resources resources, MediaGalleryLauncher mediaGalleryLauncher, EventGraphQLModelHelper eventGraphQLModelHelper, DefaultGroupInfoClickHandler defaultGroupInfoClickHandler, DefaultGroupInfoViewManager defaultGroupInfoViewManager, BetterLinkMovementMethod betterLinkMovementMethod, GatekeeperStoreImpl gatekeeperStoreImpl, Boolean bool) {
        this.f22668j = fragmentManager;
        this.f22669k = defaultGroupLeaveActionResponder;
        this.f22662d = resources;
        this.f22660b = betterListView;
        this.f22661c = groupEventRsvpViewListener;
        this.f22674p = groupMallType;
        this.f22665g = mediaGalleryLauncher;
        this.f22667i = eventGraphQLModelHelper;
        this.f22670l = defaultGroupInfoClickHandler;
        this.f22666h = defaultGroupInfoViewManager;
        this.f22671m = fetchGroupInformationModel;
        this.f22663e = betterLinkMovementMethod;
        this.f22664f = gatekeeperStoreImpl;
        this.f22672n = bool.booleanValue();
    }

    final void m23627a(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, boolean z) {
        if (fetchGroupInfoPageDataModel == null) {
            this.f22673o = RegularImmutableList.a;
            AdapterDetour.a(this, 1679478972);
            return;
        }
        Builder builder = ImmutableList.builder();
        m23620f(fetchGroupInfoPageDataModel, builder);
        m23612a(fetchGroupInfoPageDataModel, builder);
        builder.c(new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22686j) {
            final /* synthetic */ GroupInfoAdapter f22656b;

            public final void mo11a(View view) {
                BetterTextView betterTextView = (BetterTextView) view;
                betterTextView.setId(2131558755);
                betterTextView.setText(this.f22656b.f22662d.getString(2131242180));
                betterTextView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22656b, GroupInfoClickHandler$GroupInfoSection.MEMBERS, fetchGroupInfoPageDataModel));
            }
        });
        if (this.f22672n && fetchGroupInfoPageDataModel.m23857B()) {
            builder.c(m23614b());
            builder.c(new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22686j) {
                final /* synthetic */ GroupInfoAdapter f22658b;

                public final void mo11a(View view) {
                    BetterTextView betterTextView = (BetterTextView) view;
                    betterTextView.setText(this.f22658b.f22662d.getString(2131242181));
                    betterTextView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22658b, GroupInfoClickHandler$GroupInfoSection.COMPANIES, fetchGroupInfoPageDataModel));
                }
            });
        }
        builder.c(m23614b());
        m23618d(fetchGroupInfoPageDataModel, builder);
        m23615b(fetchGroupInfoPageDataModel, builder);
        m23617c(fetchGroupInfoPageDataModel, builder);
        if (this.f22674p != GroupMallType.WITH_TABS) {
            m23624k(fetchGroupInfoPageDataModel, builder);
            m23622i(fetchGroupInfoPageDataModel, builder);
            m23623j(fetchGroupInfoPageDataModel, builder);
        }
        m23621h(fetchGroupInfoPageDataModel, builder);
        m23619e(fetchGroupInfoPageDataModel, builder);
        this.f22673o = builder.b();
        if (z) {
            AdapterDetour.a(this, 1462939859);
        }
    }

    private void m23612a(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        Object obj;
        Object obj2 = 1;
        GroupPendingMembersModel u = fetchGroupInfoPageDataModel.m23895u();
        GroupReportedStoriesModel w = fetchGroupInfoPageDataModel.m23897w();
        GroupPendingStoriesModel v = fetchGroupInfoPageDataModel.m23896v();
        Object obj3 = (u == null || u.m23764a() <= 0) ? null : 1;
        if (w == null || w.m23776a() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (v == null || v.m23770a() <= 0) {
            obj2 = null;
        }
        if (obj3 != null) {
            builder.c(m23609a(this.f22662d.getString(2131242189), u.m23764a(), GroupInfoClickHandler$GroupInfoSection.MEMBER_REQUESTS, fetchGroupInfoPageDataModel));
            m23616b(builder);
        }
        if (obj != null) {
            builder.c(m23609a(this.f22662d.getString(2131242191), w.m23776a(), GroupInfoClickHandler$GroupInfoSection.REPORTED_POSTS, fetchGroupInfoPageDataModel));
            m23616b(builder);
        }
        if (obj2 != null) {
            builder.c(m23609a(this.f22662d.getString(2131242190), v.m23770a(), GroupInfoClickHandler$GroupInfoSection.PENDING_POSTS, fetchGroupInfoPageDataModel));
            m23616b(builder);
        }
        if (GraphQLGroupAdminType.ADMIN == fetchGroupInfoPageDataModel.m23888n()) {
            builder.c(m23610a(this.f22662d.getString(2131242177), GroupInfoClickHandler$GroupInfoSection.EDIT_GROUP_SETTINGS, fetchGroupInfoPageDataModel));
            m23616b(builder);
        } else if (fetchGroupInfoPageDataModel.m23884j()) {
            builder.c(m23610a(fetchGroupInfoPageDataModel.m23886l() == null ? this.f22662d.getString(2131242195) : this.f22662d.getString(2131242196), GroupInfoClickHandler$GroupInfoSection.COVER_PHOTO, fetchGroupInfoPageDataModel));
            m23616b(builder);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23615b(com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel r7, com.google.common.collect.ImmutableList.Builder<com.facebook.groups.staticadapter.StaticAdapter.Section> r8) {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r0 = com.facebook.graphql.enums.GraphQLGroupJoinState.MEMBER;
        r3 = r7.m23890p();
        if (r0 == r3) goto L_0x0012;
    L_0x000a:
        r0 = com.facebook.graphql.enums.GraphQLGroupVisibility.OPEN;
        r3 = r7.m23872Q();
        if (r0 != r3) goto L_0x002c;
    L_0x0012:
        r0 = r6.f22674p;
        r3 = com.facebook.groups.constants.GroupsConstants.GroupMallType.WITH_TABS;
        if (r0 == r3) goto L_0x002c;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        r3 = com.facebook.graphql.enums.GraphQLGroupJoinState.MEMBER;
        r4 = r7.m23890p();
        if (r3 != r4) goto L_0x002e;
    L_0x0021:
        if (r0 == 0) goto L_0x0029;
    L_0x0023:
        r2 = r6.f22666h;
        r5 = 0;
        r2 = r5;
        if (r2 != 0) goto L_0x0030;
    L_0x0029:
        if (r1 != 0) goto L_0x0030;
    L_0x002b:
        return;
    L_0x002c:
        r0 = r2;
        goto L_0x0019;
    L_0x002e:
        r1 = r2;
        goto L_0x0021;
    L_0x0030:
        r6.m23613a(r8);
        r2 = r6.f22666h;
        r5 = 0;
        r2 = r5;
        if (r2 == 0) goto L_0x0071;
    L_0x0039:
        if (r0 == 0) goto L_0x004d;
    L_0x003b:
        r2 = r6.f22662d;
        r3 = 2131242192; // 0x7f082cd0 float:1.8100769E38 double:1.05297355E-314;
        r2 = r2.getString(r3);
        r3 = com.facebook.groups.info.GroupInfoClickHandler$GroupInfoSection.SEARCH_GROUP;
        r2 = r6.m23610a(r2, r3, r7);
        r8.c(r2);
    L_0x004d:
        if (r0 == 0) goto L_0x0054;
    L_0x004f:
        if (r1 == 0) goto L_0x0054;
    L_0x0051:
        r6.m23616b(r8);
    L_0x0054:
        if (r1 == 0) goto L_0x0071;
    L_0x0056:
        r0 = r7.m23899y();
        if (r0 == 0) goto L_0x008d;
    L_0x005c:
        r0 = r6.f22662d;
        r2 = 2131242184; // 0x7f082cc8 float:1.8100752E38 double:1.052973546E-314;
        r0 = r0.getString(r2);
    L_0x0065:
        r2 = com.facebook.groups.info.GroupInfoClickHandler$GroupInfoSection.FAVORITES;
        r0 = r6.m23610a(r0, r2, r7);
        r8.c(r0);
        r6.m23616b(r8);
    L_0x0071:
        if (r1 == 0) goto L_0x002b;
    L_0x0073:
        r0 = r6.f22662d;
        r1 = 2131242187; // 0x7f082ccb float:1.8100759E38 double:1.0529735476E-314;
        r0 = r0.getString(r1);
        r1 = com.facebook.groups.info.GroupInfoClickHandler$GroupInfoSection.ADD_TO_HOME_SCREEN;
        r0 = r6.m23610a(r0, r1, r7);
        r8.c(r0);
        r0 = m23614b();
        r8.c(r0);
        goto L_0x002b;
    L_0x008d:
        r0 = r6.f22662d;
        r2 = 2131242183; // 0x7f082cc7 float:1.810075E38 double:1.0529735456E-314;
        r0 = r0.getString(r2);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.info.GroupInfoAdapter.b(com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels$FetchGroupInfoPageDataModel, com.google.common.collect.ImmutableList$Builder):void");
    }

    private void m23617c(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        if (fetchGroupInfoPageDataModel != null && fetchGroupInfoPageDataModel.m23890p() != null && fetchGroupInfoPageDataModel.m23890p() == GraphQLGroupJoinState.MEMBER) {
            m23613a(builder);
            builder.c(m23610a(this.f22662d.getString(2131237822), GroupInfoClickHandler$GroupInfoSection.CREATE_GROUP_CHAT, fetchGroupInfoPageDataModel));
            builder.c(m23614b());
        }
    }

    private void m23618d(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        if (fetchGroupInfoPageDataModel.m23890p() == GraphQLGroupJoinState.MEMBER) {
            m23613a(builder);
            builder.c(new AbstractSection<GroupNotificationsSettingPreferenceView>(this, GroupInfoAdapterRows.f22690n) {
                final /* synthetic */ GroupInfoAdapter f22627b;

                public final void mo11a(View view) {
                    GroupNotificationsSettingPreferenceView groupNotificationsSettingPreferenceView = (GroupNotificationsSettingPreferenceView) view;
                    FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel = fetchGroupInfoPageDataModel;
                    if (fetchGroupInfoPageDataModel.hc_() == GraphQLGroupPushSubscriptionLevel.OFF) {
                        switch (1.a[fetchGroupInfoPageDataModel.hd_().ordinal()]) {
                            case 1:
                                groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237909));
                                break;
                            case 2:
                                groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237907));
                                break;
                            case 3:
                                groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237906));
                                break;
                            case 4:
                                groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237905));
                                break;
                            default:
                                groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237909));
                                break;
                        }
                        groupNotificationsSettingPreferenceView.a.setTextColor(groupNotificationsSettingPreferenceView.getResources().getColor(2131363507));
                    } else {
                        groupNotificationsSettingPreferenceView.a.setText(groupNotificationsSettingPreferenceView.getResources().getString(2131237908));
                        groupNotificationsSettingPreferenceView.a.setTextColor(groupNotificationsSettingPreferenceView.getResources().getColor(2131363506));
                    }
                    groupNotificationsSettingPreferenceView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22627b, GroupInfoClickHandler$GroupInfoSection.EDIT_NOTIFICATION_SETTINGS, fetchGroupInfoPageDataModel));
                }
            });
            builder.c(m23614b());
        }
    }

    private void m23619e(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        Object obj = 1;
        m23613a(builder);
        Object obj2 = null;
        final GraphQLSubscribeStatus M = fetchGroupInfoPageDataModel.m23868M();
        switch (AnonymousClass23.f22640a[M.ordinal()]) {
            case 1:
            case 2:
                builder.c(new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22683g) {
                    final /* synthetic */ GroupInfoAdapter f22643c;

                    public final void mo11a(View view) {
                        BetterTextView betterTextView = (BetterTextView) view;
                        betterTextView.setText(M == GraphQLSubscribeStatus.CAN_SUBSCRIBE ? this.f22643c.f22662d.getString(2131242185) : this.f22643c.f22662d.getString(2131242186));
                        betterTextView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22643c, GroupInfoClickHandler$GroupInfoSection.FOLLOW_GROUP, fetchGroupInfoPageDataModel));
                    }
                });
                int i = 1;
                break;
        }
        if (GraphQLGroupAdminType.ADMIN != fetchGroupInfoPageDataModel.m23888n()) {
            if (obj2 != null) {
                m23616b(builder);
            }
            builder.c(new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22684h) {
                final /* synthetic */ GroupInfoAdapter f22645b;

                public final void mo11a(View view) {
                    BetterTextView betterTextView = (BetterTextView) view;
                    betterTextView.setText(this.f22645b.f22662d.getString(2131242175));
                    betterTextView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22645b, GroupInfoClickHandler$GroupInfoSection.REPORT_GROUP, fetchGroupInfoPageDataModel));
                }
            });
        } else {
            obj = obj2;
        }
        if (fetchGroupInfoPageDataModel.m23890p() == GraphQLGroupJoinState.MEMBER) {
            if (obj != null) {
                m23616b(builder);
            }
            builder.c(new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22684h) {
                final /* synthetic */ GroupInfoAdapter f22648b;

                /* compiled from: ThreadListFragment.onCreateThroughOnResume */
                class C32771 implements OnClickListener {
                    final /* synthetic */ C32784 f22646a;

                    C32771(C32784 c32784) {
                        this.f22646a = c32784;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -12292222);
                        this.f22646a.f22648b.f22670l.m23587a(fetchGroupInfoPageDataModel, this.f22646a.f22648b.f22669k, this.f22646a.f22648b.f22668j, view);
                        Logger.a(2, EntryType.UI_INPUT_END, -1818384967, a);
                    }
                }

                public final void mo11a(View view) {
                    BetterTextView betterTextView = (BetterTextView) view;
                    betterTextView.setId(2131558754);
                    betterTextView.setText(this.f22648b.f22662d.getString(2131242176));
                    betterTextView.setOnClickListener(new C32771(this));
                }
            });
        }
        builder.c(m23614b());
    }

    @SuppressLint({"NewApi"})
    private void m23620f(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        builder.c(new C32941(this.f22666h, GroupInfoAdapterRows.f22677a, fetchGroupInfoPageDataModel));
        builder.c(m23614b());
        if (!StringUtil.a(fetchGroupInfoPageDataModel.m23887m())) {
            DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
            builder.c(new AbstractSection<View>(this, GroupInfoAdapterRows.f22678b) {
                final /* synthetic */ GroupInfoAdapter f22652b;

                @SuppressLint({"NewApi"})
                public final void mo11a(View view) {
                    DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22652b.f22666h;
                    BetterTextView betterTextView = (BetterTextView) view.findViewById(2131562689);
                    if (this.f22652b.f22675q) {
                        betterTextView.setText(fetchGroupInfoPageDataModel.m23887m());
                    } else {
                        GroupInfoAdapter groupInfoAdapter = this.f22652b;
                        Resources resources = view.getContext().getResources();
                        if (groupInfoAdapter.f22676r == null) {
                            C32795 c32795 = new C32795(groupInfoAdapter, resources);
                            groupInfoAdapter.f22676r = SpannableString.valueOf(resources.getString(2131242193));
                            groupInfoAdapter.f22676r.setSpan(c32795, 0, groupInfoAdapter.f22676r.length(), 33);
                        }
                        betterTextView.setText(GroupInfoDescriptionUtil.m24004a(fetchGroupInfoPageDataModel.m23887m(), groupInfoAdapter.f22676r));
                    }
                    SafeLinkifier.a(betterTextView, 1);
                    betterTextView.setMovementMethod(this.f22652b.f22663e);
                }
            });
        }
        if (this.f22664f.a(673, false)) {
            defaultGroupInfoViewManager = this.f22666h;
            builder.c(new AbstractSection<View>(this, GroupInfoAdapterRows.f22679c) {
                final /* synthetic */ GroupInfoAdapter f22654b;

                public final void mo11a(View view) {
                    DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22654b.f22666h;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(2131562695);
                    ImmutableList x = fetchGroupInfoPageDataModel.m23898x();
                    while (linearLayout.getChildCount() < x.size()) {
                        linearLayout.addView(new GroupInfoTopicView(view.getContext()));
                    }
                    while (linearLayout.getChildCount() > x.size()) {
                        linearLayout.removeViewAt(0);
                    }
                    for (int i = 0; i < x.size(); i++) {
                        GroupTopicTagsModel groupTopicTagsModel = (GroupTopicTagsModel) x.get(i);
                        GroupInfoTopicView groupInfoTopicView = (GroupInfoTopicView) linearLayout.getChildAt(i);
                        if (!(groupTopicTagsModel == null || StringUtil.a(groupTopicTagsModel.m23784a()))) {
                            groupInfoTopicView.setText(groupTopicTagsModel.m23784a());
                        }
                    }
                }
            });
        }
        builder.c(m23614b());
        m23613a(builder);
    }

    private void m23621h(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        Object obj;
        if (GraphQLGroupJoinState.MEMBER == fetchGroupInfoPageDataModel.m23890p() || GraphQLGroupVisibility.OPEN == fetchGroupInfoPageDataModel.m23872Q()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m23613a(builder);
            builder.c(new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                final /* synthetic */ GroupInfoAdapter f22597b;

                public final void mo11a(View view) {
                    InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                    infoTitleRowView.m24595a(this.f22597b.f22662d.getString(2131242067));
                    infoTitleRowView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22597b, GroupInfoClickHandler$GroupInfoSection.FILES, fetchGroupInfoPageDataModel));
                }
            });
            builder.c(m23614b());
        }
    }

    private void m23622i(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        Object obj = 1;
        if (!((GraphQLGroupJoinState.MEMBER != fetchGroupInfoPageDataModel.m23890p() && GraphQLGroupVisibility.OPEN != fetchGroupInfoPageDataModel.m23872Q()) || fetchGroupInfoPageDataModel.m23892r() == null || fetchGroupInfoPageDataModel.m23892r().m23752a() == 0 || this.f22671m == null)) {
            obj = null;
        }
        if (obj == null) {
            m23613a(builder);
            builder.c(new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                final /* synthetic */ GroupInfoAdapter f22599a;

                /* compiled from: ThreadListFragment.onCreateThroughOnResume */
                class C32721 implements OnClickListener {
                    final /* synthetic */ AnonymousClass11 f22598a;

                    C32721(AnonymousClass11 anonymousClass11) {
                        this.f22598a = anonymousClass11;
                    }

                    public void onClick(View view) {
                        boolean z;
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1638718897);
                        DefaultGroupInfoClickHandler defaultGroupInfoClickHandler = this.f22598a.f22599a.f22670l;
                        FetchGroupInformationModel fetchGroupInformationModel = this.f22598a.f22599a.f22671m;
                        Context context = view.getContext();
                        if (fetchGroupInformationModel == null) {
                            z = true;
                        } else {
                            DraculaReturnValue b = fetchGroupInformationModel.b();
                            MutableFlatBuffer mutableFlatBuffer = b.a;
                            int i = b.b;
                            int i2 = b.c;
                            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
                        }
                        if (!z) {
                            defaultGroupInfoClickHandler.f22584f.a(defaultGroupInfoClickHandler.f22581c.m23668a(fetchGroupInformationModel), context);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -1509407302, a);
                    }
                }

                public final void mo11a(View view) {
                    InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                    infoTitleRowView.m24595a(this.f22599a.f22662d.getString(2131242182));
                    infoTitleRowView.setOnClickListener(new C32721(this));
                }
            });
            builder.c(m23614b());
        }
    }

    private void m23623j(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        GroupEventsModel q = fetchGroupInfoPageDataModel.m23891q();
        if (q != null) {
            ImmutableList j = q.m23710j();
            final OnClickListener a = m23608a(this, GroupInfoClickHandler$GroupInfoSection.EVENTS, fetchGroupInfoPageDataModel);
            AnonymousClass12 anonymousClass12 = new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                final /* synthetic */ GroupInfoAdapter f22601b;

                public final void mo11a(View view) {
                    InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                    infoTitleRowView.m24595a(this.f22601b.f22662d.getString(2131242178));
                    infoTitleRowView.setOnClickListener(a);
                }
            };
            m23613a(builder);
            if (j.isEmpty()) {
                builder.c(anonymousClass12);
                builder.c(m23614b());
                return;
            }
            if (q.m23706a() > j.size()) {
                builder.c(new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                    final /* synthetic */ GroupInfoAdapter f22603b;

                    public final void mo11a(View view) {
                        InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                        infoTitleRowView.setOnClickListener(a);
                        infoTitleRowView.m24596a(this.f22603b.f22662d.getString(2131242178), this.f22603b.f22662d.getString(2131242174));
                    }
                });
            } else {
                builder.c(anonymousClass12);
            }
            m23616b(builder);
            DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
            Object obj = null;
            if (obj != null) {
                builder.c(obj);
            }
            final int size = j.size();
            for (int i = 0; i < size; i++) {
                final EdgesModel edgesModel = (EdgesModel) j.get(i);
                if (edgesModel != null) {
                    builder.c(new AbstractSection<GroupEventRowView>(this, GroupInfoAdapterRows.f22689m) {
                        final /* synthetic */ GroupInfoAdapter f22608d;

                        /* compiled from: ThreadListFragment.onCreateThroughOnResume */
                        class C32731 implements OnClickListener {
                            final /* synthetic */ AnonymousClass14 f22604a;

                            C32731(AnonymousClass14 anonymousClass14) {
                                this.f22604a = anonymousClass14;
                            }

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, -1902510802);
                                DefaultGroupInfoClickHandler defaultGroupInfoClickHandler = this.f22604a.f22608d.f22670l;
                                String dL_ = edgesModel.m23696a().dL_();
                                Context context = view.getContext();
                                String b = GroupMsiteUrls.b(dL_);
                                if (!defaultGroupInfoClickHandler.f22582d.a(context, b)) {
                                    defaultGroupInfoClickHandler.f22584f.a(new Intent("android.intent.action.VIEW").setComponent((ComponentName) defaultGroupInfoClickHandler.f22580b.get()).setData(Uri.parse(b)), context);
                                }
                                Logger.a(2, EntryType.UI_INPUT_END, 1881833614, a);
                            }
                        }

                        public final void mo11a(View view) {
                            boolean z;
                            GroupEventRowView groupEventRowView = (GroupEventRowView) view;
                            EventGraphQLModelHelper eventGraphQLModelHelper = this.f22608d.f22667i;
                            Event b = EventGraphQLModelHelper.m19277b(edgesModel.m23696a());
                            groupEventRowView.setGroupEventRsvpUpdateListener(this.f22608d.f22661c);
                            Calendar instance = Calendar.getInstance();
                            TimeframeInputTimeframe timeframeInputTimeframe = b.L() != null ? b.L().compareTo(instance.getTime()) > 0 ? TimeframeInputTimeframe.FUTURE : TimeframeInputTimeframe.PAST : b.J().compareTo(instance.getTime()) > 0 ? TimeframeInputTimeframe.FUTURE : TimeframeInputTimeframe.PAST;
                            TimeframeInputTimeframe timeframeInputTimeframe2 = timeframeInputTimeframe;
                            if (i != size - 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            groupEventRowView.m24568a(b, timeframeInputTimeframe2, z);
                            groupEventRowView.setOnClickListener(new C32731(this));
                        }
                    });
                }
            }
            builder.c(m23614b());
        }
    }

    private void m23624k(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Builder<Section> builder) {
        final GroupMediasetModel s = fetchGroupInfoPageDataModel.m23893s();
        if (s != null) {
            ImmutableList immutableList;
            if (s.m23986j() == null) {
                immutableList = null;
            } else {
                immutableList = s.m23986j().m23978a();
            }
            m23613a(builder);
            final OnClickListener a = m23608a(this, GroupInfoClickHandler$GroupInfoSection.PHOTOS, fetchGroupInfoPageDataModel);
            if (immutableList == null || immutableList.isEmpty()) {
                builder.c(new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                    final /* synthetic */ GroupInfoAdapter f22610b;

                    public final void mo11a(View view) {
                        InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                        infoTitleRowView.setOnClickListener(a);
                        infoTitleRowView.m24595a(this.f22610b.f22662d.getString(2131242179));
                    }
                });
                builder.c(m23614b());
                return;
            }
            builder.c(new AbstractSection<InfoTitleRowView>(this, GroupInfoAdapterRows.f22691o) {
                final /* synthetic */ GroupInfoAdapter f22612b;

                public final void mo11a(View view) {
                    InfoTitleRowView infoTitleRowView = (InfoTitleRowView) view;
                    infoTitleRowView.setOnClickListener(a);
                    infoTitleRowView.m24596a(this.f22612b.f22662d.getString(2131242179), this.f22612b.f22662d.getString(2131242174));
                }
            });
            m23616b(builder);
            if (VERSION.SDK_INT >= 11) {
                DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
                builder.c(new AbstractSection<GridLayout>(this, GroupInfoAdapterRows.f22680d) {
                    final /* synthetic */ GroupInfoAdapter f22615c;

                    public final void mo11a(View view) {
                        int i;
                        GridLayout gridLayout = (GridLayout) view;
                        List arrayList = new ArrayList();
                        List arrayList2 = new ArrayList();
                        int size = immutableList.size();
                        for (i = 0; i < size; i++) {
                            MediaModel.EdgesModel edgesModel = (MediaModel.EdgesModel) immutableList.get(i);
                            if (!(edgesModel == null || edgesModel.m23966a() == null)) {
                                NodeModel a = edgesModel.m23966a();
                                if (!(a.m23962k() == null || a.m23962k().b() == null)) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        LayoutInflater from = LayoutInflater.from(gridLayout.getContext());
                        size = Math.min(gridLayout.getColumnCount() * gridLayout.getRowCount(), arrayList.size());
                        while (gridLayout.getChildCount() < size) {
                            from.inflate(2130904669, gridLayout, true);
                        }
                        while (gridLayout.getChildCount() > size) {
                            gridLayout.removeView(gridLayout.getChildAt(gridLayout.getChildCount() - 1));
                        }
                        for (i = 0; i < size; i++) {
                            String b = ((NodeModel) arrayList.get(i)).m23962k().b();
                            FbDraweeView fbDraweeView = (FbDraweeView) gridLayout.getChildAt(i);
                            fbDraweeView.a(Strings.isNullOrEmpty(b) ? null : Uri.parse(b), GroupInfoAdapter.f22659a);
                            arrayList2.add(fbDraweeView);
                        }
                        GroupInfoAdapter.m23611a(this.f22615c, s, arrayList, arrayList2, size);
                    }
                });
            }
            builder.c(m23614b());
        }
    }

    public static void m23611a(GroupInfoAdapter groupInfoAdapter, GroupMediasetModel groupMediasetModel, final List list, final List list2, final int i) {
        Preconditions.checkState(i == list2.size());
        final MediaFetcherConstructionRule a = MediaFetcherConstructionRule.a(SetIdMediaQueryProvider.class, new IdQueryParam(groupMediasetModel.m23985b()));
        final AnonymousClass18 anonymousClass18 = new AnimationParamProvider(groupInfoAdapter) {
            final /* synthetic */ GroupInfoAdapter f22619d;

            public final AnimationParams m23597a(String str) {
                for (int i = 0; i < i; i++) {
                    if (str.equals(((NodeModel) list.get(i)).m23959d())) {
                        return AnimationParams.a((FbDraweeView) list2.get(i), ImageRequest.a(Uri.parse(((NodeModel) list.get(i)).m23962k().b())));
                    }
                }
                return null;
            }
        };
        for (int i2 = 0; i2 < i; i2++) {
            CharSequence j;
            final String d = ((NodeModel) list.get(i2)).m23959d();
            FbDraweeView fbDraweeView = (FbDraweeView) list2.get(i2);
            final String b = ((NodeModel) list.get(i2)).m23962k().b();
            if (((NodeModel) list.get(i2)).m23961j() != null) {
                j = ((NodeModel) list.get(i2)).m23961j();
            } else {
                j = groupInfoAdapter.f22662d.getString(2131230814);
            }
            fbDraweeView.setContentDescription(j);
            final List list3 = list;
            fbDraweeView.setOnClickListener(new OnClickListener(groupInfoAdapter) {
                final /* synthetic */ GroupInfoAdapter f22625f;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1181096222);
                    MediaGalleryLauncherParams.Builder a2 = new MediaGalleryLauncherParamsFactory.Builder(a).b(ImmutableList.copyOf(list3)).a(FullscreenGallerySource.GROUPS_INFO_PAGE_PHOTO_ITEM);
                    a2.m = false;
                    a2 = a2.a(d).a(ImageRequest.a(Uri.parse(b)));
                    a2.y = this.f22625f.f22671m.gW_();
                    a2 = a2;
                    a2.x = 69076575;
                    this.f22625f.f22665g.a(this.f22625f.f22660b.getContext(), a2.b(), anonymousClass18);
                    Logger.a(2, EntryType.UI_INPUT_END, 689008726, a);
                }
            });
        }
    }

    private Section m23609a(String str, int i, GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel) {
        final String str2 = str;
        final int i2 = i;
        final GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection2 = groupInfoClickHandler$GroupInfoSection;
        final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel2 = fetchGroupInfoPageDataModel;
        return new AbstractSection<LinearLayout>(this, GroupInfoAdapterRows.f22685i) {
            final /* synthetic */ GroupInfoAdapter f22632e;

            public final void mo11a(View view) {
                LinearLayout linearLayout = (LinearLayout) view;
                ((BetterTextView) linearLayout.findViewById(2131562691)).setText(str2);
                BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131562692);
                if (betterTextView != null) {
                    betterTextView.setText(Integer.toString(i2));
                }
                linearLayout.setOnClickListener(GroupInfoAdapter.m23608a(this.f22632e, groupInfoClickHandler$GroupInfoSection2, fetchGroupInfoPageDataModel2));
            }
        };
    }

    private Section m23610a(String str, GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel) {
        final String str2 = str;
        final GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection2 = groupInfoClickHandler$GroupInfoSection;
        final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel2 = fetchGroupInfoPageDataModel;
        return new AbstractSection<BetterTextView>(this, GroupInfoAdapterRows.f22686j) {
            final /* synthetic */ GroupInfoAdapter f22636d;

            public final void mo11a(View view) {
                BetterTextView betterTextView = (BetterTextView) view;
                betterTextView.setText(str2);
                betterTextView.setOnClickListener(GroupInfoAdapter.m23608a(this.f22636d, groupInfoClickHandler$GroupInfoSection2, fetchGroupInfoPageDataModel2));
            }
        };
    }

    public static OnClickListener m23608a(GroupInfoAdapter groupInfoAdapter, final GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection, final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel) {
        return new OnClickListener(groupInfoAdapter) {
            final /* synthetic */ GroupInfoAdapter f22639c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1443324933);
                this.f22639c.f22670l.m23586a(groupInfoClickHandler$GroupInfoSection, fetchGroupInfoPageDataModel, view);
                Logger.a(2, EntryType.UI_INPUT_END, 1625727124, a);
            }
        };
    }

    public static Section<View> m23614b() {
        return new StaticSection(GroupInfoAdapterRows.f22688l);
    }

    private void m23613a(Builder<Section> builder) {
        DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
        Iterable iterable = null;
        if (iterable != null && !iterable.isEmpty()) {
            builder.b(iterable);
        }
    }

    private void m23616b(Builder<Section> builder) {
        DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
        Object obj = null;
        if (obj != null) {
            builder.c(obj);
        }
    }

    public int getItemViewType(int i) {
        DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
        return GroupInfoAdapterRows.f22692p.indexOf(((Section) this.f22673o.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
        return GroupInfoAdapterRows.f22692p.size();
    }

    public final View m23625a(int i, ViewGroup viewGroup) {
        DefaultGroupInfoViewManager defaultGroupInfoViewManager = this.f22666h;
        View a = ((ViewType) GroupInfoAdapterRows.f22692p.get(i)).mo12a(viewGroup);
        DefaultGroupInfoViewManager defaultGroupInfoViewManager2 = this.f22666h;
        defaultGroupInfoViewManager = this.f22666h;
        defaultGroupInfoViewManager2.m24007a(a, (ViewType) GroupInfoAdapterRows.f22692p.get(i));
        return a;
    }

    public final void m23626a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getCount() {
        return this.f22673o.size();
    }

    public Object getItem(int i) {
        return this.f22673o.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}

package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.conversationstarters.ConversationStarterView;
import com.facebook.messaging.inbox2.activenow.InboxActiveNowView;
import com.facebook.messaging.inbox2.analytics.InboxRecyclerViewItemTracker;
import com.facebook.messaging.inbox2.analytics.InboxViewImpressionTracker;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementUnitItem;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementUnitView;
import com.facebook.messaging.inbox2.bymm.BYMMInboxItem;
import com.facebook.messaging.inbox2.bymm.InboxBYMMView;
import com.facebook.messaging.inbox2.cameraroll.CameraRollInboxItem;
import com.facebook.messaging.inbox2.cameraroll.InboxCameraRollView;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItemViewWithState;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.inbox2.morefooter.InboxMoreItem;
import com.facebook.messaging.inbox2.morefooter.InboxMoreItemView;
import com.facebook.messaging.inbox2.morefooter.InboxMoreThreadsItem;
import com.facebook.messaging.inbox2.morefooter.InboxMoreThreadsItem.MoreThreadsType;
import com.facebook.messaging.inbox2.photoreminders.InboxUnitPhotoRemindersItem;
import com.facebook.messaging.inbox2.recents.InboxRecentItem;
import com.facebook.messaging.inbox2.recents.InboxRecentItemsData;
import com.facebook.messaging.inbox2.recents.InboxRecentItemsListener;
import com.facebook.messaging.inbox2.recents.InboxRecentItemsView;
import com.facebook.messaging.inbox2.rtc.InboxRtcRecommendationView;
import com.facebook.messaging.inbox2.rtc.RtcRecommendationInboxItem;
import com.facebook.messaging.inbox2.sectionheader.InboxSectionHeaderView;
import com.facebook.messaging.inbox2.sectionheader.InboxUnitSectionHeaderItem;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifInboxItem;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifsInboxItem;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifsUnitListener;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifsView;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifsView.C04903;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.GroupByType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.QueryType;
import com.facebook.messaging.media.externalmedia.MediaParams;
import com.facebook.messaging.media.externalmedia.MediaParamsBuilder;
import com.facebook.messaging.media.loader.LocalMediaLoaderParams;
import com.facebook.messaging.messagerequests.views.MessageRequestsBannerView;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.montage.MontageTileView;
import com.facebook.messaging.montage.inboxcomposer.MontageComposerHeaderView;
import com.facebook.messaging.montage.inboxcomposer.MontageComposerHeaderView.C05292;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerData;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageView;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersHeaderView;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxData;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.orca.threadlist.ThreadItemView.ThreadItemViewListener;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass18;
import com.facebook.user.model.User;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: native_ui_config */
public class ThreadListAdapter extends Adapter<ThreadListItemViewHolder> implements InboxAdapter, AdapterCompatibleWithListView<ThreadListItemViewHolder> {
    private final OnClickListener f6564a = new C09831(this);
    private final OnLongClickListener f6565b = new C09842(this);
    public final Context f6566c;
    public final LayoutInflater f6567d;
    private RecyclerView f6568e;
    public InboxViewImpressionTracker f6569f;
    private LoadMoreState f6570g = LoadMoreState.LOAD_MORE_AUTOMATICALLY_ENABLED;
    private ImmutableList<InboxItem> f6571h = RegularImmutableList.a;
    public final Bundle f6572i = new Bundle();
    public AnonymousClass18 f6573j;
    private boolean f6574k;
    public boolean f6575l;

    /* compiled from: native_ui_config */
    /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] f6548b = new int[InboxItemViewType.values().length];

        static {
            try {
                f6548b[InboxItemViewType.V2_SECTION_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6548b[InboxItemViewType.V2_CONVERSATION_STARTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6548b[InboxItemViewType.V2_PEOPLE_YOU_MAY_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6548b[InboxItemViewType.V2_MESSAGE_REQUEST_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6548b[InboxItemViewType.V2_MONTAGE_COMPOSER_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6548b[InboxItemViewType.V2_PHOTO_REMINDERS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6548b[InboxItemViewType.THREAD_SINGLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6548b[InboxItemViewType.THREAD_MULTI.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6548b[InboxItemViewType.V2_ACTIVE_NOW.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f6548b[InboxItemViewType.V2_ACTIVE_NOW_LOADING.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f6548b[InboxItemViewType.V2_ACTIVE_NOW_EMPTY_ITEM.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f6548b[InboxItemViewType.V2_RECENT_ITEMS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f6548b[InboxItemViewType.V2_RTC_RECOMMENDATION.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f6548b[InboxItemViewType.V2_TRENDING_GIFS.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f6548b[InboxItemViewType.V2_CAMERA_ROLL.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f6548b[InboxItemViewType.V2_BYMM_PAGE.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f6548b[InboxItemViewType.V2_MORE_FOOTER.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f6548b[InboxItemViewType.V2_MESSAGE_REQUEST_THREADS.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f6548b[InboxItemViewType.V2_UNKNOWN_TYPE.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f6548b[InboxItemViewType.V2_ANNOUNCEMENT.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            f6547a = new int[LoadMoreState.values().length];
            try {
                f6547a[LoadMoreState.LOAD_MORE_AUTOMATICALLY_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f6547a[LoadMoreState.LOAD_MORE_AUTOMATICALLY_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f6547a[LoadMoreState.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError e23) {
            }
        }
    }

    /* compiled from: native_ui_config */
    class C09831 implements OnClickListener {
        final /* synthetic */ ThreadListAdapter f6549a;

        C09831(ThreadListAdapter threadListAdapter) {
            this.f6549a = threadListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1002636012);
            if (this.f6549a.f6573j != null) {
                int f = ((LayoutParams) view.getLayoutParams()).f();
                AnonymousClass18 anonymousClass18 = this.f6549a.f6573j;
                Integer.valueOf(f);
                ThreadListFragment.m6355h(anonymousClass18.f6606a, f);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 196258029, a);
        }
    }

    /* compiled from: native_ui_config */
    class C09842 implements OnLongClickListener {
        final /* synthetic */ ThreadListAdapter f6550a;

        C09842(ThreadListAdapter threadListAdapter) {
            this.f6550a = threadListAdapter;
        }

        public boolean onLongClick(View view) {
            if (this.f6550a.f6573j == null) {
                return false;
            }
            return ThreadListFragment.m6353g(this.f6550a.f6573j.f6606a, ((LayoutParams) view.getLayoutParams()).f());
        }
    }

    /* compiled from: native_ui_config */
    public class C09853 implements ThreadItemViewListener {
        final /* synthetic */ ThreadListAdapter f6551a;

        public C09853(ThreadListAdapter threadListAdapter) {
            this.f6551a = threadListAdapter;
        }

        public final void mo235a(ThreadKey threadKey) {
            if (this.f6551a.f6573j != null) {
                this.f6551a.f6573j.m6288a(threadKey);
            }
        }
    }

    /* compiled from: native_ui_config */
    public class C09919 {
        public final /* synthetic */ ThreadListAdapter f6563a;

        public C09919(ThreadListAdapter threadListAdapter) {
            this.f6563a = threadListAdapter;
        }
    }

    /* compiled from: native_ui_config */
    public enum LoadMoreState {
        LOAD_MORE_AUTOMATICALLY_DISABLED,
        LOAD_MORE_AUTOMATICALLY_ENABLED,
        LOADING
    }

    public static ThreadListAdapter m6250a(InjectorLike injectorLike) {
        return new ThreadListAdapter((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    public final void m6264a(ViewHolder viewHolder) {
        m6251a(((ThreadListItemViewHolder) viewHolder).a);
    }

    public final void m6265a(ViewHolder viewHolder, int i) {
        m6252a(((ThreadListItemViewHolder) viewHolder).a, i);
    }

    public /* synthetic */ Object getItem(int i) {
        return m6270b(i);
    }

    @Inject
    public ThreadListAdapter(Context context, LayoutInflater layoutInflater) {
        this.f6566c = context;
        this.f6567d = layoutInflater;
        a(true);
    }

    final void m6271b(boolean z) {
        this.f6574k = z;
    }

    public final void m6267a(LoadMoreState loadMoreState) {
        if (this.f6570g != loadMoreState) {
            this.f6570g = loadMoreState;
            notifyDataSetChanged();
        }
    }

    final void m6266a(InboxViewImpressionTracker inboxViewImpressionTracker) {
        this.f6569f = inboxViewImpressionTracker;
    }

    public final int iy_() {
        return InboxItemViewType.values().length;
    }

    final void m6268a(List<InboxItem> list) {
        this.f6571h = ImmutableList.copyOf(list);
        notifyDataSetChanged();
    }

    public final int aZ_() {
        return m6269b();
    }

    public final int m6269b() {
        return this.f6571h.size();
    }

    public final InboxItem m6270b(int i) {
        if (i >= this.f6571h.size()) {
            return null;
        }
        InboxItem inboxItem = (InboxItem) this.f6571h.get(i);
        if (!(inboxItem instanceof InboxLoadMorePlaceholderItem)) {
            return inboxItem;
        }
        InboxLoadMorePlaceholderItem inboxLoadMorePlaceholderItem = (InboxLoadMorePlaceholderItem) inboxItem;
        switch (this.f6570g) {
            case LOAD_MORE_AUTOMATICALLY_DISABLED:
                return new InboxMoreThreadsItem(inboxLoadMorePlaceholderItem.d, MoreThreadsType.LOAD_MORE, this.f6566c.getString(2131231814));
            case LOAD_MORE_AUTOMATICALLY_ENABLED:
                if (i == this.f6571h.size() - 1) {
                    return new InboxMoreThreadsItem(inboxLoadMorePlaceholderItem.d, MoreThreadsType.AUTO, "");
                }
                return new InboxMoreThreadsItem(inboxLoadMorePlaceholderItem.d, MoreThreadsType.LOAD_MORE, this.f6566c.getString(2131231814));
            case LOADING:
                return new InboxMoreThreadsItem(inboxLoadMorePlaceholderItem.d, MoreThreadsType.LOADING, "");
            default:
                return inboxItem;
        }
    }

    public int getItemViewType(int i) {
        return m6270b(i).b().ordinal();
    }

    public final long H_(int i) {
        return m6270b(i).c();
    }

    public final ViewHolder m6262a(ViewGroup viewGroup, int i) {
        View d = m6260d(viewGroup, i);
        d.setOnClickListener(this.f6564a);
        if (this.f6574k) {
            d.setOnLongClickListener(this.f6565b);
        }
        if (InboxItemViewType.valueOf(i).shouldRecyclerViewProvidePressState()) {
            CustomViewUtils.b(d, ContextUtils.f(this.f6566c, 2130772018, 2130843719));
        }
        return new ThreadListItemViewHolder(d);
    }

    private View m6260d(ViewGroup viewGroup, int i) {
        switch (AnonymousClass13.f6548b[InboxItemViewType.valueOf(i).ordinal()]) {
            case 1:
                return new InboxSectionHeaderView(this.f6566c);
            case 2:
                return this.f6567d.inflate(2130903805, viewGroup, false);
            case 3:
                return this.f6567d.inflate(2130906170, viewGroup, false);
            case 4:
                return new MessageRequestsBannerView(this.f6566c);
            case 5:
                MontageComposerHeaderView montageComposerHeaderView = new MontageComposerHeaderView(this.f6566c);
                montageComposerHeaderView.f3292h = new C09919(this);
                return montageComposerHeaderView;
            case 6:
                PhotoRemindersHeaderView photoRemindersHeaderView = new PhotoRemindersHeaderView(this.f6566c);
                photoRemindersHeaderView.f3565j = new Object(this) {
                    public final /* synthetic */ ThreadListAdapter f6542a;

                    {
                        this.f6542a = r1;
                    }
                };
                return photoRemindersHeaderView;
            case 7:
            case 8:
                ThreadItemView threadItemView = (ThreadItemView) this.f6567d.inflate(2130905880, viewGroup, false);
                threadItemView.f6509I = new C09853(this);
                return threadItemView;
            case 9:
                return this.f6567d.inflate(2130904853, viewGroup, false);
            case 10:
                return this.f6567d.inflate(2130905711, viewGroup, false);
            case 11:
                return this.f6567d.inflate(2130905554, viewGroup, false);
            case 12:
                return this.f6567d.inflate(2130904880, viewGroup, false);
            case 13:
                return new InboxRtcRecommendationView(viewGroup.getContext());
            case 14:
                return new TrendingGifsView(viewGroup.getContext());
            case 15:
                return new InboxCameraRollView(viewGroup.getContext());
            case 16:
                return this.f6567d.inflate(2130904858, viewGroup, false);
            case 17:
                return this.f6567d.inflate(2130904866, viewGroup, false);
            case 18:
                return this.f6567d.inflate(2130904864, viewGroup, false);
            case 19:
                return this.f6567d.inflate(2130905885, viewGroup, false);
            case 20:
                return this.f6567d.inflate(2130904856, viewGroup, false);
            default:
                throw new IllegalArgumentException("Unknown object type " + i);
        }
    }

    private void m6252a(View view, final int i) {
        InboxItemViewType b = m6270b(i).b();
        switch (AnonymousClass13.f6548b[b.ordinal()]) {
            case 1:
                m6256a((InboxSectionHeaderView) view, i);
                break;
            case 2:
                ((ConversationStarterView) view).setConversationStarterData(((InboxUnitConversationStarterItem) m6270b(i)).f6486f);
                break;
            case 3:
                PeopleYouMayMessageView peopleYouMayMessageView = (PeopleYouMayMessageView) view;
                InboxUnitItem inboxUnitItem = (InboxUnitPeopleYouMayMessageItem) m6270b(i);
                peopleYouMayMessageView.m3379a(inboxUnitItem, inboxUnitItem.f6489f);
                peopleYouMayMessageView.f3489a.f3471d = new Object(this) {
                    public final /* synthetic */ ThreadListAdapter f6546b;
                };
                if (this.f6569f != null) {
                    this.f6569f.m2614a(inboxUnitItem, peopleYouMayMessageView);
                }
                break;
            case 4:
                ((MessageRequestsBannerView) view).m3201a(((InboxUnitMessageRequestsItem) m6270b(i)).f6487f);
                break;
            case 5:
                MontageComposerHeaderView montageComposerHeaderView = (MontageComposerHeaderView) view;
                MontageInboxComposerData montageInboxComposerData = ((InboxUnitMontageComposerItem) m6270b(i)).f6488f;
                if (montageInboxComposerData == null) {
                    BLog.b(MontageComposerHeaderView.f3285a, "Binding null data");
                    montageComposerHeaderView.f3288d.setVisibility(8);
                    montageComposerHeaderView.f3287c.e();
                } else {
                    Preconditions.checkNotNull(montageInboxComposerData.f3294a);
                    if (CollectionUtil.a(montageInboxComposerData.f3295b)) {
                        montageComposerHeaderView.f3288d.setVisibility(8);
                    } else {
                        montageComposerHeaderView.f3288d.m3223a(montageInboxComposerData.f3295b);
                        montageComposerHeaderView.f3288d.setVisibility(0);
                    }
                    if (montageInboxComposerData.f3296c == null) {
                        montageComposerHeaderView.f3287c.e();
                    } else {
                        ((MontageTileView) montageComposerHeaderView.f3287c.a()).setMessage(montageInboxComposerData.f3296c);
                        montageComposerHeaderView.f3287c.f();
                        MontageTileView montageTileView = (MontageTileView) montageComposerHeaderView.f3287c.a();
                        if (montageComposerHeaderView.f3293i == null) {
                            montageComposerHeaderView.f3293i = new C05292(montageComposerHeaderView);
                        }
                        montageTileView.setOnClickListener(montageComposerHeaderView.f3293i);
                        ((MontageTileView) montageComposerHeaderView.f3287c.a()).setTag(montageInboxComposerData.f3294a);
                    }
                }
                break;
            case 6:
                m6258a((PhotoRemindersHeaderView) view, i);
                break;
            case 7:
            case 8:
                ThreadItemView threadItemView = (ThreadItemView) view;
                threadItemView.setThreadSummary(((InboxUnitThreadItem) m6270b(i)).f6491g);
                threadItemView.setUseInbox2AlternateBadges(this.f6575l);
                break;
            case 9:
                ((InboxActiveNowView) view).setContactPickerUserRow(((InboxUnitActiveNowItem) m6270b(i)).f6483f);
                break;
            case 10:
            case 11:
            case 18:
                break;
            case 12:
                InboxRecentItemsView inboxRecentItemsView = (InboxRecentItemsView) view;
                InboxItem b2 = m6270b(i);
                inboxRecentItemsView.setUnitData((InboxRecentItemsData) m6270b(i));
                inboxRecentItemsView.f2932i = new InboxRecentItemsListener(this) {
                    final /* synthetic */ ThreadListAdapter f6553b;

                    public final void mo89a(InboxRecentItem inboxRecentItem) {
                        if (this.f6553b.f6573j != null) {
                            AnonymousClass18 anonymousClass18 = this.f6553b.f6573j;
                            int i = i;
                            Intent intent = new Intent();
                            intent.setAction(MessagingIntentUris.a);
                            intent.setData(Uri.parse(MessengerLinks.o));
                            intent.putExtra("ShareType", "ShareType.facebookShare");
                            intent.putExtra("share_fbid", inboxRecentItem.mo96f());
                            intent.putExtra("share_media_url", inboxRecentItem.mc_().toString());
                            intent.putExtra("share_title", inboxRecentItem.lZ_());
                            intent.putExtra("share_description", inboxRecentItem.ma_());
                            intent.putExtra("share_caption", inboxRecentItem.mo97i());
                            intent.putExtra("trigger2", ThreadListFragment.m6320a(anonymousClass18.f6606a, (InboxItem) inboxRecentItem));
                            anonymousClass18.f6606a.bX.a(intent, anonymousClass18.f6606a.getContext());
                            anonymousClass18.f6606a.aN.a(inboxRecentItem.d());
                            anonymousClass18.f6606a.bB.m2625a(inboxRecentItem, i, "share", null);
                        }
                    }

                    public final void mo90a(InboxRecentItem inboxRecentItem, User user, FutureCallback<SendResult> futureCallback) {
                        if (this.f6553b.f6573j != null) {
                            AnonymousClass18 anonymousClass18 = this.f6553b.f6573j;
                            int i = i;
                            ThreadListFragment.m6337a(anonymousClass18.f6606a, inboxRecentItem.mo96f(), user, (FutureCallback) futureCallback, ThreadListFragment.m6320a(anonymousClass18.f6606a, (InboxItem) inboxRecentItem));
                            anonymousClass18.f6606a.aN.a(inboxRecentItem.d());
                            anonymousClass18.f6606a.bB.m2625a(inboxRecentItem, i, "share", null);
                        }
                    }

                    public final boolean mo92b(InboxRecentItem inboxRecentItem) {
                        if (this.f6553b.f6573j != null) {
                            return this.f6553b.f6573j.m6291a(inboxRecentItem);
                        }
                        return false;
                    }

                    public final void mo91a(InboxRecentItem inboxRecentItem, String str, @Nullable Map<String, String> map) {
                        if (this.f6553b.f6573j != null) {
                            AnonymousClass18 anonymousClass18 = this.f6553b.f6573j;
                            int i = i;
                            anonymousClass18.f6606a.aN.a(inboxRecentItem.d());
                            anonymousClass18.f6606a.bB.m2625a(inboxRecentItem, i, str, map);
                        }
                    }
                };
                if (this.f6569f != null) {
                    this.f6569f.m2614a(b2, inboxRecentItemsView);
                }
                break;
            case 13:
                m6255a((InboxRtcRecommendationView) view, i);
                break;
            case 14:
                m6257a((TrendingGifsView) view, i);
                break;
            case 15:
                m6254a((InboxCameraRollView) view, i);
                break;
            case 16:
                InboxBYMMView inboxBYMMView = (InboxBYMMView) view;
                BYMMInboxItem bYMMInboxItem = (BYMMInboxItem) m6270b(i);
                inboxBYMMView.setData(bYMMInboxItem.f2674f);
                inboxBYMMView.f2686a.f2679d = new Object(this) {
                    public final /* synthetic */ ThreadListAdapter f6560b;
                };
                if (this.f6569f != null) {
                    this.f6569f.m2614a(bYMMInboxItem, inboxBYMMView);
                }
                break;
            case 17:
                ((InboxMoreItemView) view).setMoreItem((InboxMoreItem) m6270b(i));
                break;
            case 19:
                m6253a((TextView) view, i);
                break;
            case 20:
                InboxAnnouncementUnitView inboxAnnouncementUnitView = (InboxAnnouncementUnitView) view;
                final InboxAnnouncementUnitItem inboxAnnouncementUnitItem = (InboxAnnouncementUnitItem) m6270b(i);
                inboxAnnouncementUnitView.setData(inboxAnnouncementUnitItem.f2666f);
                inboxAnnouncementUnitView.f2673f = new Object(this) {
                    public final /* synthetic */ ThreadListAdapter f6544b;
                };
                break;
            default:
                throw new IllegalArgumentException("Unknown object type " + b);
        }
        if (view instanceof InboxUnitItemViewWithState) {
            InboxUnitItemViewWithState inboxUnitItemViewWithState = (InboxUnitItemViewWithState) view;
            String g = inboxUnitItemViewWithState.getInboxUnitItem().g();
            Bundle bundle = this.f6572i.getBundle(g);
            if (bundle != null) {
                this.f6572i.remove(g);
                inboxUnitItemViewWithState.a(bundle);
            }
        }
    }

    private void m6251a(View view) {
        m6259b(view);
        if (this.f6569f != null && (view instanceof InboxUnitViewWithRecyclerView)) {
            InboxRecyclerViewItemTracker inboxRecyclerViewItemTracker = (InboxRecyclerViewItemTracker) this.f6569f.f2643k.get((InboxUnitViewWithRecyclerView) view);
            if (inboxRecyclerViewItemTracker != null) {
                inboxRecyclerViewItemTracker.f2623c.getRecyclerView().b(inboxRecyclerViewItemTracker.f2625e);
                inboxRecyclerViewItemTracker.f2628h = true;
                inboxRecyclerViewItemTracker.f2629i = 0;
            }
        }
    }

    final void m6263a(Bundle bundle) {
        m6261e();
        bundle.putBundle("inbox_item_states", this.f6572i);
    }

    private void m6261e() {
        if (this.f6568e != null) {
            int childCount = this.f6568e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m6259b(this.f6568e.getChildAt(i));
            }
        }
    }

    public final void a_(RecyclerView recyclerView) {
        this.f6568e = recyclerView;
    }

    private void m6259b(View view) {
        if (view instanceof InboxUnitItemViewWithState) {
            InboxUnitItemViewWithState inboxUnitItemViewWithState = (InboxUnitItemViewWithState) view;
            this.f6572i.putBundle(inboxUnitItemViewWithState.getInboxUnitItem().g(), inboxUnitItemViewWithState.a());
        }
    }

    private void m6255a(InboxRtcRecommendationView inboxRtcRecommendationView, int i) {
        inboxRtcRecommendationView.f2961b = ((RtcRecommendationInboxItem) m6270b(i)).f2962f;
        if (inboxRtcRecommendationView.f2961b != null) {
            View childAt = inboxRtcRecommendationView.getChildAt(0);
            if (childAt != null) {
                View a = inboxRtcRecommendationView.f2960a.m5799a(inboxRtcRecommendationView.f2961b, childAt);
                if (a != childAt) {
                    inboxRtcRecommendationView.removeViewAt(0);
                    inboxRtcRecommendationView.addView(a, 0);
                    return;
                }
                return;
            }
            inboxRtcRecommendationView.addView(inboxRtcRecommendationView.f2960a.m5799a(inboxRtcRecommendationView.f2961b, null));
        } else if (inboxRtcRecommendationView.getChildCount() > 0) {
            inboxRtcRecommendationView.removeViewAt(0);
        }
    }

    private void m6257a(TrendingGifsView trendingGifsView, final int i) {
        TrendingGifsInboxItem trendingGifsInboxItem = (TrendingGifsInboxItem) m6270b(i);
        if (trendingGifsView.f2989h == null || trendingGifsView.f2989h.c() != trendingGifsInboxItem.c()) {
            trendingGifsView.f2989h = trendingGifsInboxItem;
            int dimensionPixelSize = trendingGifsView.getResources().getDimensionPixelSize(2131433870);
            ImmutableList immutableList = TrendingGifsView.f2982d;
            GroupByType groupByType = GroupByType.UNGROUPED;
            MediaParamsBuilder newBuilder = MediaParams.newBuilder();
            newBuilder.a = TrendingGifsView.f2983e;
            newBuilder = newBuilder;
            newBuilder.c = dimensionPixelSize;
            newBuilder = newBuilder;
            newBuilder.d = true;
            MediaParams e = newBuilder.e();
            MediaParamsBuilder newBuilder2 = MediaParams.newBuilder();
            newBuilder2.a = TrendingGifsView.f2983e;
            newBuilder2 = newBuilder2;
            newBuilder2.c = dimensionPixelSize;
            ExternalMediaGraphQLRequest externalMediaGraphQLRequest = new ExternalMediaGraphQLRequest(QueryType.TRENDING, "", immutableList, groupByType, 40, ImmutableList.of(e, newBuilder2.e()), RegularImmutableList.a, null);
            Futures.a(trendingGifsView.f2984a.a(externalMediaGraphQLRequest), new C04903(trendingGifsView), trendingGifsView.f2985b);
        }
        trendingGifsView.f2990i = new TrendingGifsUnitListener(this) {
            final /* synthetic */ ThreadListAdapter f6555b;

            public final void mo104a(TrendingGifInboxItem trendingGifInboxItem) {
                if (this.f6555b.f6573j != null) {
                    AnonymousClass18 anonymousClass18 = this.f6555b.f6573j;
                    int i = i;
                    ThreadListFragment.m6335a(anonymousClass18.f6606a, ImmutableList.of(trendingGifInboxItem.f2968f.e), ThreadListFragment.m6320a(anonymousClass18.f6606a, (InboxItem) trendingGifInboxItem));
                    anonymousClass18.f6606a.bB.m2624a(trendingGifInboxItem, i);
                }
            }
        };
        if (this.f6569f != null) {
            this.f6569f.m2614a(trendingGifsInboxItem, trendingGifsView);
        }
    }

    private void m6254a(InboxCameraRollView inboxCameraRollView, final int i) {
        final CameraRollInboxItem cameraRollInboxItem = (CameraRollInboxItem) m6270b(i);
        inboxCameraRollView.f2732o = cameraRollInboxItem;
        if (inboxCameraRollView.f2732o != null && inboxCameraRollView.f2731n == null) {
            inboxCameraRollView.f2720a.a(new LocalMediaLoaderParams(false));
        }
        inboxCameraRollView.f2733p = new Object(this) {
            public final /* synthetic */ ThreadListAdapter f6558c;
        };
        if (this.f6569f != null) {
            this.f6569f.m2614a(cameraRollInboxItem, inboxCameraRollView);
        }
    }

    private void m6256a(InboxSectionHeaderView inboxSectionHeaderView, int i) {
        CharSequence string;
        final InboxUnitSectionHeaderItem inboxUnitSectionHeaderItem = (InboxUnitSectionHeaderItem) m6270b(i);
        if (inboxUnitSectionHeaderItem.f2966g > 0) {
            string = this.f6566c.getString(2131231822, new Object[]{inboxUnitSectionHeaderItem.f2965f, Integer.valueOf(inboxUnitSectionHeaderItem.f2966g)});
        } else {
            string = inboxUnitSectionHeaderItem.f2965f;
        }
        inboxSectionHeaderView.f2963a.setText(string);
        inboxSectionHeaderView.f2964b.setVisibility(inboxUnitSectionHeaderItem.f2967h ? 0 : 8);
        inboxSectionHeaderView.f2964b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ThreadListAdapter f6562b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1529367584);
                if (this.f6562b.f6573j != null) {
                    AnonymousClass18 anonymousClass18 = this.f6562b.f6573j;
                    anonymousClass18.f6606a.m6323a((InboxUnitItem) inboxUnitSectionHeaderItem);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1738647521, a);
            }
        });
    }

    private void m6258a(PhotoRemindersHeaderView photoRemindersHeaderView, int i) {
        String string;
        PhotoRemindersInboxData photoRemindersInboxData = ((InboxUnitPhotoRemindersItem) m6270b(i)).f2856f;
        ImmutableList immutableList = photoRemindersInboxData.f3567b;
        photoRemindersHeaderView.f3560e.setController(((FbDraweeControllerBuilder) photoRemindersHeaderView.f3559c.p().a(PhotoRemindersHeaderView.f3556d).b((Uri) immutableList.get(0)).b(photoRemindersHeaderView.f3560e.getController())).s());
        if (immutableList.size() > 1) {
            photoRemindersHeaderView.f3561f.setController(((FbDraweeControllerBuilder) photoRemindersHeaderView.f3559c.p().a(PhotoRemindersHeaderView.f3556d).b((Uri) immutableList.get(1)).b(photoRemindersHeaderView.f3561f.getController())).s());
            photoRemindersHeaderView.f3561f.setVisibility(0);
        } else {
            photoRemindersHeaderView.f3561f.setVisibility(8);
        }
        if (immutableList.size() > 2) {
            photoRemindersHeaderView.f3562g.setController(((FbDraweeControllerBuilder) photoRemindersHeaderView.f3559c.p().a(PhotoRemindersHeaderView.f3556d).b((Uri) immutableList.get(2)).b(photoRemindersHeaderView.f3562g.getController())).s());
            photoRemindersHeaderView.f3562g.setVisibility(0);
        } else {
            photoRemindersHeaderView.f3562g.setVisibility(8);
        }
        TextView textView = photoRemindersHeaderView.f3563h;
        if (photoRemindersInboxData.f3566a > 1) {
            if (photoRemindersInboxData.f3569d.size() > 1) {
                string = photoRemindersHeaderView.getResources().getString(2131240954, new Object[]{Integer.valueOf(photoRemindersInboxData.f3566a)});
            } else {
                string = photoRemindersHeaderView.getResources().getString(2131240953, new Object[]{Integer.valueOf(photoRemindersInboxData.f3566a), photoRemindersInboxData.f3569d.get(0)});
            }
        } else if (photoRemindersInboxData.f3569d.size() > 1) {
            string = photoRemindersHeaderView.getResources().getString(2131240956);
        } else {
            string = photoRemindersHeaderView.getResources().getString(2131240955, new Object[]{photoRemindersInboxData.f3569d.get(0)});
        }
        textView.setText(string);
        textView = photoRemindersHeaderView.f3564i;
        if (photoRemindersInboxData.f3569d.size() > 1) {
            ImmutableList subList = photoRemindersInboxData.f3569d.subList(0, Math.min(photoRemindersInboxData.f3569d.size(), 3));
            string = photoRemindersHeaderView.f3558b.a(subList, photoRemindersInboxData.f3569d.size() - subList.size());
        } else {
            string = photoRemindersHeaderView.f3557a.a(TimeFormatStyle.EXACT_STREAM_RELATIVE_STYLE, photoRemindersInboxData.f3568c);
        }
        textView.setText(string);
    }

    private void m6253a(TextView textView, int i) {
        InboxUnitUnknownTypeItem inboxUnitUnknownTypeItem = (InboxUnitUnknownTypeItem) m6270b(i);
        textView.setText(this.f6566c.getString(2131233170, new Object[]{inboxUnitUnknownTypeItem.f6492f.r()}));
    }
}

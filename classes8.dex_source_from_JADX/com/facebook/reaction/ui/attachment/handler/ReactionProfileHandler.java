package com.facebook.reaction.ui.attachment.handler;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.PageAdminInviteAcceptInputData;
import com.facebook.graphql.calls.PageAdminInviteDeclineInputData;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragments.PageAdminInviteAcceptMutationString;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragments.PageAdminInviteDeclineMutationString;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.PageAdminInviteAcceptMutationModel;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.PageAdminInviteDeclineMutationModel;
import com.facebook.reaction.ui.recyclerview.ReactionSimpleViewHolder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Visa */
public class ReactionProfileHandler extends ReactionRecyclableAttachmentHandler<ReactionSimpleViewHolder> {
    public final ReactionIntentFactory f20873a;
    public final Lazy<GraphQLActorCache> f20874b;
    public final Lazy<GlyphColorizer> f20875c;
    public final Lazy<GraphQLQueryExecutor> f20876d;
    public final RawLikeHelper f20877e;
    public final Executor f20878f;
    public final HashMap<String, AdminInviteResponse> f20879g = new HashMap();
    public String f20880h;
    public String f20881i;

    /* compiled from: Visa */
    enum AdminInviteResponse {
        ACCEPTED("accepted"),
        DECLINED("declined");
        
        public final String name;

        private AdminInviteResponse(String str) {
            this.name = str;
        }
    }

    /* compiled from: Visa */
    class AdminInvitesClickListener implements OnClickListener {
        final /* synthetic */ ReactionProfileHandler f20925a;
        public final ReactionProfileFields f20926b;
        private final ContentViewWithButton f20927c;

        /* compiled from: Visa */
        class C22151 implements OnMenuItemClickListener {
            final /* synthetic */ AdminInvitesClickListener f20922a;

            C22151(AdminInvitesClickListener adminInvitesClickListener) {
                this.f20922a = adminInvitesClickListener;
            }

            public final boolean m24562a(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == 2131568662) {
                    AdminInvitesClickListener.m24564a(this.f20922a, true);
                } else if (itemId != 2131568663) {
                    return false;
                } else {
                    AdminInvitesClickListener.m24564a(this.f20922a, false);
                }
                return true;
            }
        }

        /* compiled from: Visa */
        class C22162 implements FutureCallback<GraphQLResult<PageAdminInviteAcceptMutationModel>> {
            final /* synthetic */ AdminInvitesClickListener f20923a;

            C22162(AdminInvitesClickListener adminInvitesClickListener) {
                this.f20923a = adminInvitesClickListener;
            }

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f20923a.f20925a.f20879g.containsKey(this.f20923a.f20926b.eL_())) {
                    this.f20923a.f20925a.f20879g.remove(this.f20923a.f20926b.eL_());
                }
                AdminInvitesClickListener.m24563a(this.f20923a);
            }
        }

        /* compiled from: Visa */
        class C22173 implements FutureCallback<GraphQLResult<PageAdminInviteDeclineMutationModel>> {
            final /* synthetic */ AdminInvitesClickListener f20924a;

            C22173(AdminInvitesClickListener adminInvitesClickListener) {
                this.f20924a = adminInvitesClickListener;
            }

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f20924a.f20925a.f20879g.containsKey(this.f20924a.f20926b.eL_())) {
                    this.f20924a.f20925a.f20879g.remove(this.f20924a.f20926b.eL_());
                }
                AdminInvitesClickListener.m24563a(this.f20924a);
            }
        }

        public AdminInvitesClickListener(ReactionProfileHandler reactionProfileHandler, ReactionProfileFields reactionProfileFields, ContentViewWithButton contentViewWithButton) {
            this.f20925a = reactionProfileHandler;
            this.f20926b = reactionProfileFields;
            this.f20927c = contentViewWithButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1491885956);
            if (((GraphQLActorCacheImpl) this.f20925a.f20874b.get()).a() == null || ((GraphQLActorCacheImpl) this.f20925a.f20874b.get()).a().H() == null || this.f20926b.eL_() == null || this.f20925a.f20879g.containsKey(this.f20926b.eL_())) {
                Logger.a(2, EntryType.UI_INPUT_END, 540728056, a);
                return;
            }
            FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
            figPopoverMenuWindow.b(2131820573);
            figPopoverMenuWindow.p = new C22151(this);
            figPopoverMenuWindow.c(view);
            figPopoverMenuWindow.c(true);
            figPopoverMenuWindow.d();
            LogUtils.a(7889275, a);
        }

        public static void m24564a(AdminInvitesClickListener adminInvitesClickListener, boolean z) {
            if (((GraphQLActorCacheImpl) adminInvitesClickListener.f20925a.f20874b.get()).a() != null && ((GraphQLActorCacheImpl) adminInvitesClickListener.f20925a.f20874b.get()).a().H() != null && adminInvitesClickListener.f20926b.eL_() != null && !adminInvitesClickListener.f20925a.f20879g.containsKey(adminInvitesClickListener.f20926b.eL_())) {
                adminInvitesClickListener.f20925a.f20879g.put(adminInvitesClickListener.f20926b.eL_(), z ? AdminInviteResponse.ACCEPTED : AdminInviteResponse.DECLINED);
                m24563a(adminInvitesClickListener);
                if (!(adminInvitesClickListener.f20925a.m22858c().getInteractionTracker() == null || adminInvitesClickListener.f20925a.f20880h == null || adminInvitesClickListener.f20925a.f20881i == null)) {
                    UnitInteractionType unitInteractionType;
                    ReactionInteractionTracker interactionTracker = adminInvitesClickListener.f20925a.m22858c().getInteractionTracker();
                    String str = adminInvitesClickListener.f20925a.f20880h;
                    String str2 = adminInvitesClickListener.f20925a.f20881i;
                    String eL_ = adminInvitesClickListener.f20926b.eL_();
                    if (z) {
                        unitInteractionType = UnitInteractionType.ACCEPT_ADMIN_INVITE_TAP;
                    } else {
                        unitInteractionType = UnitInteractionType.DECLINE_ADMIN_INVITE_TAP;
                    }
                    interactionTracker.mo981a(str, str2, new ReactionAttachmentIntent(eL_, unitInteractionType));
                }
                if (z) {
                    PageAdminInviteAcceptInputData pageAdminInviteAcceptInputData = new PageAdminInviteAcceptInputData();
                    pageAdminInviteAcceptInputData.a("page_id", adminInvitesClickListener.f20926b.eL_());
                    Futures.a(((GraphQLQueryExecutor) adminInvitesClickListener.f20925a.f20876d.get()).a(GraphQLRequest.a((PageAdminInviteAcceptMutationString) new PageAdminInviteAcceptMutationString().a("input", pageAdminInviteAcceptInputData))), new C22162(adminInvitesClickListener), adminInvitesClickListener.f20925a.f20878f);
                    return;
                }
                PageAdminInviteDeclineInputData pageAdminInviteDeclineInputData = new PageAdminInviteDeclineInputData();
                pageAdminInviteDeclineInputData.a("page_id", adminInvitesClickListener.f20926b.eL_());
                Futures.a(((GraphQLQueryExecutor) adminInvitesClickListener.f20925a.f20876d.get()).a(GraphQLRequest.a((PageAdminInviteDeclineMutationString) new PageAdminInviteDeclineMutationString().a("input", pageAdminInviteDeclineInputData))), new C22173(adminInvitesClickListener), adminInvitesClickListener.f20925a.f20878f);
            }
        }

        public static void m24563a(AdminInvitesClickListener adminInvitesClickListener) {
            ReactionProfileHandler.m24504a(adminInvitesClickListener.f20925a, (AdminInviteResponse) adminInvitesClickListener.f20925a.f20879g.get(adminInvitesClickListener.f20926b.eL_()), adminInvitesClickListener.f20927c);
        }
    }

    /* compiled from: Visa */
    public class FriendsInvitesClickListener implements OnClickListener {
        final /* synthetic */ ReactionProfileHandler f20930a;
        private final ReactionProfileFields f20931b;
        private final ContentViewWithButton f20932c;
        public boolean f20933d = this.f20931b.eK_();

        public FriendsInvitesClickListener(ReactionProfileHandler reactionProfileHandler, ReactionProfileFields reactionProfileFields, ContentViewWithButton contentViewWithButton) {
            this.f20930a = reactionProfileHandler;
            this.f20931b = reactionProfileFields;
            this.f20932c = contentViewWithButton;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -320051629);
            final boolean z2 = this.f20933d;
            RawLikeHelper rawLikeHelper = this.f20930a.f20877e;
            String eL_ = this.f20931b.eL_();
            if (z2) {
                z = false;
            } else {
                z = true;
            }
            rawLikeHelper.a(eL_, z, null, "reaction_dialog", null, null, null, true, new MutationCallback<String>(this) {
                final /* synthetic */ FriendsInvitesClickListener f20929b;

                public final /* bridge */ /* synthetic */ void m24567b(Object obj) {
                }

                public final /* bridge */ /* synthetic */ void m24568c(Object obj) {
                }

                public final void m24565a(Object obj) {
                    boolean z;
                    FriendsInvitesClickListener friendsInvitesClickListener = this.f20929b;
                    if (this.f20929b.f20933d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    friendsInvitesClickListener.f20933d = z;
                    FriendsInvitesClickListener.m24569a(this.f20929b);
                }

                public final void m24566a(Object obj, ServiceException serviceException) {
                    this.f20929b.f20933d = z2;
                    FriendsInvitesClickListener.m24569a(this.f20929b);
                }
            });
            LogUtils.a(-88133175, a);
        }

        public static void m24569a(FriendsInvitesClickListener friendsInvitesClickListener) {
            friendsInvitesClickListener.f20932c.setActionButtonDrawable(((GlyphColorizer) friendsInvitesClickListener.f20930a.f20875c.get()).a(2130839953, friendsInvitesClickListener.f20933d ? -10972929 : -4341303));
        }
    }

    /* compiled from: Visa */
    public class LikedPageOptionsClickListener implements OnClickListener {
        final /* synthetic */ ReactionProfileHandler f20939a;
        public final ReactionProfileFields f20940b;
        public boolean f20941c = this.f20940b.eK_();

        public LikedPageOptionsClickListener(ReactionProfileHandler reactionProfileHandler, ReactionProfileFields reactionProfileFields) {
            this.f20939a = reactionProfileHandler;
            this.f20940b = reactionProfileFields;
        }

        public void onClick(final View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -258431262);
            final FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
            figPopoverMenuWindow.b(2131820574);
            figPopoverMenuWindow.p = new OnMenuItemClickListener(this) {
                final /* synthetic */ LikedPageOptionsClickListener f20938c;

                public final boolean m24574a(MenuItem menuItem) {
                    boolean z = false;
                    int itemId = menuItem.getItemId();
                    if (itemId == 2131568664) {
                        final boolean z2 = this.f20938c.f20941c;
                        RawLikeHelper rawLikeHelper = this.f20938c.f20939a.f20877e;
                        String eL_ = this.f20938c.f20940b.eL_();
                        if (!z2) {
                            z = true;
                        }
                        rawLikeHelper.a(eL_, z, null, "reaction_dialog", null, null, null, true, new MutationCallback<String>(this) {
                            final /* synthetic */ C22201 f20935b;

                            public final /* bridge */ /* synthetic */ void m24572b(Object obj) {
                            }

                            public final /* bridge */ /* synthetic */ void m24573c(Object obj) {
                            }

                            public final void m24570a(Object obj) {
                                boolean z;
                                LikedPageOptionsClickListener likedPageOptionsClickListener = this.f20935b.f20938c;
                                if (this.f20935b.f20938c.f20941c) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                likedPageOptionsClickListener.f20941c = z;
                                LikedPageOptionsClickListener.m24575a(this.f20935b.f20938c, figPopoverMenuWindow);
                            }

                            public final void m24571a(Object obj, ServiceException serviceException) {
                                this.f20935b.f20938c.f20941c = z2;
                                LikedPageOptionsClickListener.m24575a(this.f20935b.f20938c, figPopoverMenuWindow);
                            }
                        });
                    } else if (itemId == 2131568665) {
                        this.f20938c.f20939a.mo1138a(this.f20938c.f20940b.eL_(), this.f20938c.f20939a.f20873a.m22798p(view.getContext(), this.f20938c.f20940b.eL_()), view);
                    } else if (itemId == 2131568666) {
                        this.f20938c.f20939a.mo1138a(this.f20938c.f20940b.eL_(), this.f20938c.f20939a.f20873a.m22794l(this.f20938c.f20940b.eL_()), view);
                    } else if (itemId != 2131568667) {
                        return false;
                    } else {
                        this.f20938c.f20939a.mo1138a(this.f20938c.f20940b.eL_(), ReactionIntentFactory.m22709b(this.f20938c.f20940b.eL_(), this.f20938c.f20940b.j(), this.f20938c.f20940b.k().b()), view);
                    }
                    return true;
                }
            };
            m24575a(this, figPopoverMenuWindow);
            figPopoverMenuWindow.c().findItem(2131568666).setVisible(this.f20940b.d());
            figPopoverMenuWindow.c(view);
            figPopoverMenuWindow.c(true);
            figPopoverMenuWindow.d();
            Logger.a(2, EntryType.UI_INPUT_END, -206390108, a);
        }

        public static void m24575a(LikedPageOptionsClickListener likedPageOptionsClickListener, FigPopoverMenuWindow figPopoverMenuWindow) {
            figPopoverMenuWindow.c().findItem(2131568664).setVisible(likedPageOptionsClickListener.f20940b.c()).setChecked(likedPageOptionsClickListener.f20941c).setTitle(likedPageOptionsClickListener.f20941c ? 2131235370 : 2131235368);
        }
    }

    public static ReactionProfileHandler m24502a(InjectorLike injectorLike) {
        return new ReactionProfileHandler(ReactionIntentFactory.m22683a(injectorLike), ReactionIntentLauncher.m24381a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 262), IdBasedSingletonScopeProvider.b(injectorLike, 1275), IdBasedLazy.a(injectorLike, 2164), RawLikeHelper.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final void mo1130a(ViewHolder viewHolder, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View view = (ContentViewWithButton) ((ReactionSimpleViewHolder) viewHolder).a;
        ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        view.setThumbnailUri(Uri.parse(M.k().b()));
        view.setTitleText(M.j());
        view.setShowActionButton(false);
        view.setActionButtonTheme(Theme.NONE);
        view.setThumbnailPlaceholderResource(2131361970);
        if (reactionStoryAttachmentFragmentModel.z() != null) {
            view.setSubtitleText(reactionStoryAttachmentFragmentModel.z().a());
        }
        if (reactionStoryAttachmentFragmentModel.k() != null) {
            view.setMetaText(reactionStoryAttachmentFragmentModel.k().a());
        }
        m22845a(view, reactionStoryAttachmentFragmentModel);
    }

    @Inject
    public ReactionProfileHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, Lazy<GraphQLActorCache> lazy, Lazy<GlyphColorizer> lazy2, Lazy<GraphQLQueryExecutor> lazy3, RawLikeHelper rawLikeHelper, Executor executor) {
        super(reactionIntentLauncher);
        this.f20873a = reactionIntentFactory;
        this.f20874b = lazy;
        this.f20875c = lazy2;
        this.f20876d = lazy3;
        this.f20877e = rawLikeHelper;
        this.f20878f = executor;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20880h = str;
        this.f20881i = str2;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    public final ViewHolder mo1131g() {
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) m22840a(2130906593);
        contentViewWithButton.setOnTouchListener(new HighlightViewOnTouchListener());
        contentViewWithButton.setThumbnailSize(ThumbnailSize.MEDIUM);
        return new ReactionSimpleViewHolder(contentViewWithButton);
    }

    public ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        if (M.eL_() == null) {
            return null;
        }
        if (M.b().g() == 67338874) {
            return this.f20873a.m22738a(reactionStoryAttachmentFragmentModel.M().eL_());
        }
        if (M.b().g() == 2479791) {
            return this.f20873a.m22731a(view.getContext(), reactionStoryAttachmentFragmentModel.M().eL_(), reactionStoryAttachmentFragmentModel.M().j(), UnitInteractionType.PROFILE_TAP);
        }
        return this.f20873a.m22736a(M, UnitInteractionType.PROFILE_TAP);
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.M() == null || reactionStoryAttachmentFragmentModel.M().k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().k().b())) ? false : true;
    }

    protected final boolean mo1134a(View view, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel, GraphQLReactionStoryAttachmentActionStyle graphQLReactionStoryAttachmentActionStyle) {
        int i = -4341303;
        final ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        if (graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.WRITE_ON_TIMELINE)) {
            m24503a(contentViewWithButton, this.f18821d.getResources().getString(2131233484), this.f18821d.getResources().getDrawable(2130838211), new OnClickListener(this) {
                final /* synthetic */ ReactionProfileHandler f20919b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2058895576);
                    this.f20919b.mo1138a(M.eL_(), ReactionIntentFactory.m22716d(M.eL_(), M.j(), M.k().b()), view);
                    Logger.a(2, EntryType.UI_INPUT_END, 958007716, a);
                }
            });
            return true;
        } else if (graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.SEND_MESSAGE)) {
            m24503a(contentViewWithButton, this.f18821d.getResources().getString(2131233483), this.f18821d.getResources().getDrawable(2130839987), new OnClickListener(this) {
                final /* synthetic */ ReactionProfileHandler f20921b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -2140993831);
                    this.f20921b.mo1138a(M.eL_(), this.f20921b.f20873a.m22794l(M.eL_()), view);
                    Logger.a(2, EntryType.UI_INPUT_END, 1907744922, a);
                }
            });
            return true;
        } else if (graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.LIKED_PAGE_OPTIONS)) {
            m24503a(contentViewWithButton, this.f18821d.getResources().getString(2131239351), ((GlyphColorizer) this.f20875c.get()).a(2130839779, -4341303), new LikedPageOptionsClickListener(this, M));
            return true;
        } else if (graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.LIKE_PAGE_IN_ATTACHMENT)) {
            CharSequence string = contentViewWithButton.getResources().getString(2131239353);
            GlyphColorizer glyphColorizer = (GlyphColorizer) this.f20875c.get();
            if (M.eK_()) {
                i = -10972929;
            }
            m24503a(contentViewWithButton, string, glyphColorizer.a(2130839953, i), new FriendsInvitesClickListener(this, M, contentViewWithButton));
            return true;
        } else if (!graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.ADMIN_PAGE)) {
            return false;
        } else {
            m24503a(contentViewWithButton, contentViewWithButton.getResources().getString(2131239350), ((GlyphColorizer) this.f20875c.get()).a(2130839779, -4341303), new AdminInvitesClickListener(this, M, contentViewWithButton));
            m24504a(this, null, contentViewWithButton);
            return true;
        }
    }

    private static void m24503a(ContentViewWithButton contentViewWithButton, CharSequence charSequence, Drawable drawable, OnClickListener onClickListener) {
        contentViewWithButton.setShowActionButton(true);
        contentViewWithButton.setActionButtonContentDescription(charSequence);
        contentViewWithButton.setActionButtonDrawable(drawable);
        contentViewWithButton.setActionButtonOnClickListener(onClickListener);
    }

    public static void m24504a(ReactionProfileHandler reactionProfileHandler, AdminInviteResponse adminInviteResponse, ContentViewWithButton contentViewWithButton) {
        int i;
        int i2;
        if (adminInviteResponse == AdminInviteResponse.ACCEPTED) {
            i = 2130839879;
            i2 = -10972929;
        } else if (adminInviteResponse == AdminInviteResponse.DECLINED) {
            i = 2130839890;
            i2 = -4341303;
        } else {
            i = 2130839779;
            i2 = -4341303;
        }
        contentViewWithButton.setEnableActionButton(adminInviteResponse == null);
        contentViewWithButton.setActionButtonDrawable(((GlyphColorizer) reactionProfileHandler.f20875c.get()).a(i, i2));
    }
}

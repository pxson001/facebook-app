package com.facebook.groups.memberlist;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupBlockInputData;
import com.facebook.graphql.calls.GroupRemoveAdminInputData;
import com.facebook.graphql.calls.GroupRemoveAdminInputData.AdminType;
import com.facebook.graphql.calls.GroupRemoveMemberInputData;
import com.facebook.graphql.calls.GroupUnblockUserInputData;
import com.facebook.graphql.calls.GroupUnconfirmedMemberRemoveInviteInputData;
import com.facebook.graphql.calls.GroupUnconfirmedMemberRemoveInviteInputData.Source;
import com.facebook.graphql.calls.GroupUnconfirmedMemberSendReminderInputData;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberlist.GroupMemberListBaseFragment.C15312;
import com.facebook.groups.memberlist.GroupMembershipController.C15471;
import com.facebook.groups.memberlist.GroupMembershipController.C15482;
import com.facebook.groups.memberlist.GroupMembershipController.C15504;
import com.facebook.groups.memberlist.GroupMembershipController.C15515;
import com.facebook.groups.memberlist.GroupMembershipController.C15537;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEventBus;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEventSubscriber;
import com.facebook.groups.memberlist.intent.GroupMemberActions;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel;
import com.facebook.groups.memberlist.protocol.GroupInviteMutations.GroupRemoveInviteMutationString;
import com.facebook.groups.memberlist.protocol.GroupInviteMutations.GroupSendReminderMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupBlockMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupRemoveAdminMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupRemoveMemberMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupUnblockMutationString;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.Futures;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_phone_number_acquisition_quick_promotion_id */
public class MemberListRowSelectionHandler {
    public static boolean f14399n = false;
    public final String f14400a;
    public final Resources f14401b;
    public final UriIntentMapper f14402c;
    public final SecureContextHelper f14403d;
    public final String f14404e;
    private final GroupMemberUpdateEventBus f14405f;
    public final GroupMembershipController f14406g;
    private final FbAppType f14407h;
    public Set<String> f14408i = new HashSet();
    public Set<String> f14409j = new HashSet();
    public C15312 f14410k;
    public GraphQLGroupVisibility f14411l;
    public GraphQLGroupAdminType f14412m;

    @Inject
    public MemberListRowSelectionHandler(Resources resources, String str, @Assisted String str2, @Assisted GraphQLGroupAdminType graphQLGroupAdminType, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, GroupMemberUpdateEventBus groupMemberUpdateEventBus, GroupMembershipController groupMembershipController, FbAppType fbAppType) {
        this.f14401b = resources;
        this.f14400a = str;
        this.f14404e = str2;
        this.f14412m = graphQLGroupAdminType;
        this.f14402c = uriIntentMapper;
        this.f14403d = secureContextHelper;
        this.f14405f = groupMemberUpdateEventBus;
        this.f14406g = groupMembershipController;
        this.f14407h = fbAppType;
    }

    public final void m15950b(C15312 c15312) {
        if (this.f14410k == c15312) {
            this.f14410k = null;
        }
    }

    public final void m15948a(GroupMemberUpdateEventSubscriber groupMemberUpdateEventSubscriber) {
        this.f14405f.a(groupMemberUpdateEventSubscriber);
    }

    public final void m15951b(GroupMemberUpdateEventSubscriber groupMemberUpdateEventSubscriber) {
        this.f14405f.b(groupMemberUpdateEventSubscriber);
    }

    public final void m15947a(View view, @Nullable GroupMemberListMemberItem groupMemberListMemberItem, GraphQLGroupVisibility graphQLGroupVisibility) {
        if (groupMemberListMemberItem != null) {
            InviteeModel inviteeModel = groupMemberListMemberItem.f14275g;
            m15936a(view, groupMemberListMemberItem, groupMemberListMemberItem.f14272d.b(), groupMemberListMemberItem.f14272d.he_(), inviteeModel);
            this.f14411l = graphQLGroupVisibility;
        }
    }

    private void m15936a(View view, GroupMemberListMemberItem groupMemberListMemberItem, String str, String str2, InviteeModel inviteeModel) {
        final String j = (inviteeModel == null || inviteeModel.m16217j() == null) ? str : inviteeModel.m16217j();
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
        popoverMenuWindow.e = false;
        PopoverMenu c = popoverMenuWindow.c();
        popoverMenuWindow.c(view);
        if (GraphQLGroupAdminType.ADMIN == this.f14412m || GraphQLGroupAdminType.MODERATOR == this.f14412m) {
            if (groupMemberListMemberItem.m15887g()) {
                m15932a(view.getContext(), groupMemberListMemberItem, str, str2, c);
            } else if (GraphQLGroupAdminType.ADMIN == this.f14412m) {
                m15942b(view.getContext(), groupMemberListMemberItem, str, str2, c);
            } else if (GraphQLGroupAdminType.MODERATOR == this.f14412m) {
                m15945c(view.getContext(), groupMemberListMemberItem, str, str2, c);
            }
        } else if (groupMemberListMemberItem.m15883a(this.f14400a) && groupMemberListMemberItem.m15887g()) {
            m15932a(view.getContext(), groupMemberListMemberItem, str, str2, c);
        }
        if (this.f14407h.j == Product.GROUPS) {
            c.a(this.f14401b.getString(2131239435)).setOnMenuItemClickListener(m15943c(j, view.getContext()));
            MenuItemImpl a = c.a(this.f14401b.getString(2131239487));
            final Context context = view.getContext();
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ MemberListRowSelectionHandler f14350c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    return GroupMemberActions.m15975a(j, this.f14350c.f14403d, MemberListRowSelectionHandler.m15940b(context), this.f14350c.f14401b, context);
                }
            });
            popoverMenuWindow.d();
        } else if (c.getCount() == 0) {
            m15946d(this, j, view.getContext());
        } else {
            c.a(this.f14401b.getString(2131239435)).setOnMenuItemClickListener(m15943c(j, view.getContext()));
            popoverMenuWindow.d();
        }
    }

    private void m15932a(final Context context, GroupMemberListMemberItem groupMemberListMemberItem, final String str, final String str2, PopoverMenu popoverMenu) {
        if (GraphQLGroupAdminType.ADMIN == this.f14412m || GraphQLGroupAdminType.MODERATOR == this.f14412m || groupMemberListMemberItem.f14273e.f14223b.equals(this.f14400a)) {
            popoverMenu.a(this.f14401b.getString(2131239441)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ MemberListRowSelectionHandler f14366d;

                /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
                class C15581 implements OnClickListener {
                    final /* synthetic */ C15592 f14362a;

                    C15581(C15592 c15592) {
                        this.f14362a = c15592;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        GroupMembershipController groupMembershipController = this.f14362a.f14366d.f14406g;
                        String str = this.f14362a.f14366d.f14404e;
                        String str2 = str;
                        String str3 = str2;
                        GroupUnconfirmedMemberRemoveInviteInputData groupUnconfirmedMemberRemoveInviteInputData = new GroupUnconfirmedMemberRemoveInviteInputData();
                        groupUnconfirmedMemberRemoveInviteInputData.a("actor_id", groupMembershipController.f14332a);
                        GraphQlCallInput graphQlCallInput = groupUnconfirmedMemberRemoveInviteInputData;
                        graphQlCallInput.a("invite_id", str2);
                        graphQlCallInput = graphQlCallInput;
                        graphQlCallInput.a("source", Source.MEMBER_LIST);
                        graphQlCallInput = graphQlCallInput;
                        GraphQlQueryString groupRemoveInviteMutationString = new GroupRemoveInviteMutationString();
                        groupRemoveInviteMutationString.a("input", graphQlCallInput);
                        Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(groupRemoveInviteMutationString)), new com.facebook.groups.memberlist.GroupMembershipController.AnonymousClass10(groupMembershipController, str, str2, str3), groupMembershipController.f14333b);
                    }
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f14366d.m15935a(new C15581(this), context, str2, 2131239441, 2131239442, this.f14366d.f14411l == GraphQLGroupVisibility.SECRET ? 2131239444 : 2131239443);
                    return true;
                }
            });
            popoverMenu.a(this.f14401b.getString(2131239445)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ MemberListRowSelectionHandler f14361c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    GroupMembershipController groupMembershipController = this.f14361c.f14406g;
                    String str = str;
                    String str2 = str2;
                    GroupUnconfirmedMemberSendReminderInputData groupUnconfirmedMemberSendReminderInputData = new GroupUnconfirmedMemberSendReminderInputData();
                    groupUnconfirmedMemberSendReminderInputData.a("actor_id", groupMembershipController.f14332a);
                    GraphQlCallInput graphQlCallInput = groupUnconfirmedMemberSendReminderInputData;
                    graphQlCallInput.a("invite_id", str);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("source", GroupUnconfirmedMemberSendReminderInputData.Source.MEMBER_LIST);
                    graphQlCallInput = graphQlCallInput;
                    GraphQlQueryString groupSendReminderMutationString = new GroupSendReminderMutationString();
                    groupSendReminderMutationString.a("input", graphQlCallInput);
                    Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(groupSendReminderMutationString)), new com.facebook.groups.memberlist.GroupMembershipController.AnonymousClass11(groupMembershipController, str2), groupMembershipController.f14333b);
                    return true;
                }
            });
        }
    }

    public final boolean m15949a() {
        return GraphQLGroupAdminType.ADMIN == this.f14412m || GraphQLGroupAdminType.MODERATOR == this.f14412m || this.f14407h.j == Product.GROUPS;
    }

    private void m15942b(final Context context, GroupMemberListMemberItem groupMemberListMemberItem, final String str, final String str2, PopoverMenu popoverMenu) {
        boolean z = true;
        if (groupMemberListMemberItem.m15886f()) {
            popoverMenu.a(this.f14401b.getString(2131239438)).setOnMenuItemClickListener(m15941b(str, str2, context));
            return;
        }
        boolean z2 = groupMemberListMemberItem.m15884d() || this.f14408i.contains(str);
        if (!(groupMemberListMemberItem.m15885e() || this.f14409j.contains(str))) {
            z = false;
        }
        boolean equals = this.f14400a.equals(str);
        if (z2) {
            popoverMenu.a(this.f14401b.getString(2131239458)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ MemberListRowSelectionHandler f14347d;

                /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
                class C15561 implements OnClickListener {
                    final /* synthetic */ AnonymousClass10 f14343a;

                    C15561(AnonymousClass10 anonymousClass10) {
                        this.f14343a = anonymousClass10;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        GroupMembershipController groupMembershipController = this.f14343a.f14347d.f14406g;
                        String str = this.f14343a.f14347d.f14404e;
                        String str2 = str;
                        GroupRemoveAdminInputData c = new GroupRemoveAdminInputData().a(groupMembershipController.f14332a).b(str).c(str2);
                        GroupRemoveAdminMutationString b = GroupMemberAdminMutations.m16354b();
                        b.a("input", c);
                        Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(b)), new C15537(groupMembershipController, str, str2), groupMembershipController.f14333b);
                    }
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    OnClickListener c15561 = new C15561(this);
                    MemberListRowSelectionHandler memberListRowSelectionHandler = this.f14347d;
                    Context context = context;
                    String str = str;
                    String str2 = str2;
                    CharSequence string = memberListRowSelectionHandler.f14401b.getString(2131239455, new Object[]{str2});
                    if (memberListRowSelectionHandler.f14400a.equals(str)) {
                        string = memberListRowSelectionHandler.f14408i.size() == 1 ? memberListRowSelectionHandler.f14401b.getString(2131239457) : memberListRowSelectionHandler.f14401b.getString(2131239456);
                    }
                    Builder builder = new Builder(context);
                    builder.a(memberListRowSelectionHandler.f14401b.getString(2131239453));
                    builder.b(string);
                    builder.a(memberListRowSelectionHandler.f14401b.getString(2131239454), c15561);
                    builder.b(memberListRowSelectionHandler.f14401b.getString(2131239450), new OnClickListener(memberListRowSelectionHandler) {
                        final /* synthetic */ MemberListRowSelectionHandler f14354a;

                        {
                            this.f14354a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.a().show();
                    return true;
                }
            });
            if (equals && f14399n) {
                popoverMenu.a(this.f14401b.getString(2131239480)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ MemberListRowSelectionHandler f14385c;

                    /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
                    class C15661 implements OnClickListener {
                        final /* synthetic */ C15676 f14382a;

                        C15661(C15676 c15676) {
                            this.f14382a = c15676;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f14382a.f14385c.f14406g.m15918a(this.f14382a.f14385c.f14404e, str);
                        }
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14385c.m15934a(new C15661(this), context, 2131239474, 2131239481, MemberListRowSelectionHandler.m15928a(this.f14385c, 2131239482, null));
                        return true;
                    }
                });
            }
        } else if (z) {
            popoverMenu.a(this.f14401b.getString(2131239436)).setOnMenuItemClickListener(m15929a(str));
            if (f14399n) {
                popoverMenu.a(this.f14401b.getString(2131239475)).setOnMenuItemClickListener(m15931a(str, str2, context, false));
            }
        } else {
            if (f14399n) {
                popoverMenu.a(this.f14401b.getString(2131239470)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ MemberListRowSelectionHandler f14390d;

                    /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
                    class C15681 implements OnClickListener {
                        final /* synthetic */ C15697 f14386a;

                        C15681(C15697 c15697) {
                            this.f14386a = c15697;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f14386a.f14390d.f14406g.m15918a(this.f14386a.f14390d.f14404e, str);
                        }
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f14390d.m15934a(new C15681(this), context, 2131239474, 2131239471, MemberListRowSelectionHandler.m15928a(this.f14390d, 2131239472, str2));
                        return true;
                    }
                });
            }
            popoverMenu.a(this.f14401b.getString(2131239436)).setOnMenuItemClickListener(m15929a(str));
        }
        if (!equals) {
            popoverMenu.a(this.f14401b.getString(2131239448)).setOnMenuItemClickListener(m15944c(str, str2, context));
            popoverMenu.a(this.f14401b.getString(2131239437)).setOnMenuItemClickListener(m15930a(str, str2, context));
        }
    }

    private void m15945c(Context context, GroupMemberListMemberItem groupMemberListMemberItem, String str, String str2, PopoverMenu popoverMenu) {
        boolean z = false;
        if (!f14399n) {
            return;
        }
        if (groupMemberListMemberItem.m15886f()) {
            popoverMenu.a(this.f14401b.getString(2131239438)).setOnMenuItemClickListener(m15941b(str, str2, context));
            return;
        }
        boolean z2 = groupMemberListMemberItem.m15884d() || this.f14408i.contains(str);
        if (groupMemberListMemberItem.m15885e() || this.f14409j.contains(str)) {
            z = true;
        }
        if (this.f14400a.equals(str)) {
            popoverMenu.a(this.f14401b.getString(2131239475)).setOnMenuItemClickListener(m15931a(str, str2, context, true));
        }
        if (!z2 && !r1) {
            popoverMenu.a(this.f14401b.getString(2131239448)).setOnMenuItemClickListener(m15944c(str, str2, context));
            popoverMenu.a(this.f14401b.getString(2131239437)).setOnMenuItemClickListener(m15930a(str, str2, context));
        }
    }

    private OnMenuItemClickListener m15930a(final String str, final String str2, final Context context) {
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14371d;

            /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
            class C15601 implements OnClickListener {
                final /* synthetic */ C15613 f14367a;

                C15601(C15613 c15613) {
                    this.f14367a = c15613;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    GroupMembershipController groupMembershipController = this.f14367a.f14371d.f14406g;
                    String str = this.f14367a.f14371d.f14404e;
                    String str2 = str;
                    String str3 = str2;
                    GroupBlockInputData c = new GroupBlockInputData().a(groupMembershipController.f14332a).b(str).a(GroupBlockInputData.Source.TREEHOUSE_GROUP_MALL).c(str2);
                    GroupBlockMutationString d = GroupMemberAdminMutations.m16356d();
                    d.a("input", c);
                    Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(d)), new C15471(groupMembershipController, str3, str, str2), groupMembershipController.f14333b);
                }
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f14371d.m15935a(new C15601(this), context, str2, 2131239439, 2131239439, 2131239446);
                return true;
            }
        };
    }

    private OnMenuItemClickListener m15941b(final String str, final String str2, final Context context) {
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14376d;

            /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
            class C15621 implements OnClickListener {
                final /* synthetic */ C15634 f14372a;

                C15621(C15634 c15634) {
                    this.f14372a = c15634;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    GroupMembershipController groupMembershipController = this.f14372a.f14376d.f14406g;
                    String str = this.f14372a.f14376d.f14404e;
                    String str2 = str;
                    String str3 = str2;
                    GroupUnblockUserInputData groupUnblockUserInputData = new GroupUnblockUserInputData();
                    groupUnblockUserInputData.a("actor_id", groupMembershipController.f14332a);
                    GraphQlCallInput graphQlCallInput = groupUnblockUserInputData;
                    graphQlCallInput.a("group_id", str);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("source", GroupUnblockUserInputData.Source.TREEHOUSE_GROUP_MALL);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("user_id", str2);
                    graphQlCallInput = graphQlCallInput;
                    GraphQlQueryString groupUnblockMutationString = new GroupUnblockMutationString();
                    groupUnblockMutationString.a("input", graphQlCallInput);
                    Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(groupUnblockMutationString)), new C15482(groupMembershipController, str3, str, str2), groupMembershipController.f14333b);
                }
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f14376d.m15935a(new C15621(this), context, str2, 2131239440, 2131239440, 2131239447);
                return true;
            }
        };
    }

    private OnMenuItemClickListener m15944c(final String str, final String str2, final Context context) {
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14381d;

            /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
            class C15641 implements OnClickListener {
                final /* synthetic */ C15655 f14377a;

                C15641(C15655 c15655) {
                    this.f14377a = c15655;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    GroupMembershipController groupMembershipController = this.f14377a.f14381d.f14406g;
                    String str = this.f14377a.f14381d.f14404e;
                    String str2 = str;
                    String str3 = str2;
                    GroupRemoveMemberInputData c = new GroupRemoveMemberInputData().a(groupMembershipController.f14332a).b(str).a(GroupRemoveMemberInputData.Source.TREEHOUSE_GROUP_MALL).c(str2);
                    GroupRemoveMemberMutationString c2 = GroupMemberAdminMutations.m16355c();
                    c2.a("input", c);
                    Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(c2)), new C15515(groupMembershipController, str3, str, str2), groupMembershipController.f14333b);
                }
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f14381d.m15935a(new C15641(this), context, str2, 2131239449, 2131239451, 2131239452);
                return true;
            }
        };
    }

    private OnMenuItemClickListener m15931a(String str, String str2, Context context, boolean z) {
        final String str3 = str;
        final boolean z2 = z;
        final Context context2 = context;
        final String str4 = str2;
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14396e;

            /* compiled from: extra_phone_number_acquisition_quick_promotion_id */
            class C15701 implements OnClickListener {
                final /* synthetic */ C15718 f14391a;

                C15701(C15718 c15718) {
                    this.f14391a = c15718;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    GroupMembershipController groupMembershipController = this.f14391a.f14396e.f14406g;
                    String str = this.f14391a.f14396e.f14404e;
                    String str2 = str3;
                    GroupRemoveAdminInputData c = new GroupRemoveAdminInputData().a(groupMembershipController.f14332a).b(str).c(str2);
                    c.a("admin_type", AdminType.MODERATOR);
                    GraphQlCallInput graphQlCallInput = c;
                    GroupRemoveAdminMutationString b = GroupMemberAdminMutations.m16354b();
                    b.a("input", graphQlCallInput);
                    Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(b)), new C15504(groupMembershipController, str, str2), groupMembershipController.f14333b);
                }
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                OnClickListener c15701 = new C15701(this);
                if (z2) {
                    this.f14396e.m15933a(c15701, context2, 2131239479, 2131239476, 2131239478);
                } else {
                    this.f14396e.m15935a(c15701, context2, str4, 2131239479, 2131239476, 2131239477);
                }
                return true;
            }
        };
    }

    private OnMenuItemClickListener m15929a(final String str) {
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14398b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f14398b.f14406g.m15919c(this.f14398b.f14404e, str);
                return true;
            }
        };
    }

    private OnMenuItemClickListener m15943c(final String str, final Context context) {
        return new OnMenuItemClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14353c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                return MemberListRowSelectionHandler.m15946d(this.f14353c, str, context);
            }
        };
    }

    private void m15933a(OnClickListener onClickListener, Context context, int i, int i2, int i3) {
        Builder builder = new Builder(context);
        builder.a(this.f14401b.getString(i), onClickListener);
        builder.b(this.f14401b.getString(2131239450), new OnClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14355a;

            {
                this.f14355a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.a(this.f14401b.getString(i2));
        builder.b(this.f14401b.getString(i3));
        builder.a().show();
    }

    private void m15935a(OnClickListener onClickListener, Context context, String str, int i, int i2, int i3) {
        Builder builder = new Builder(context);
        builder.a(this.f14401b.getString(i), onClickListener);
        builder.b(this.f14401b.getString(2131239450), new OnClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14356a;

            {
                this.f14356a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.a(this.f14401b.getString(i2));
        builder.b(this.f14401b.getString(i3, new Object[]{str}));
        builder.a().show();
    }

    private void m15934a(OnClickListener onClickListener, Context context, int i, int i2, CharSequence charSequence) {
        Builder builder = new Builder(context);
        builder.a(this.f14401b.getString(i), onClickListener);
        builder.b(this.f14401b.getString(2131239450), new OnClickListener(this) {
            final /* synthetic */ MemberListRowSelectionHandler f14357a;

            {
                this.f14357a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.a(this.f14401b.getString(i2));
        builder.b(charSequence);
        AlertDialog a = builder.a();
        a.show();
        View findViewById = a.findViewById(2131559674);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static SpannableString m15928a(MemberListRowSelectionHandler memberListRowSelectionHandler, @Nullable int i, String str) {
        String string;
        if (str != null) {
            string = memberListRowSelectionHandler.f14401b.getString(i, new Object[]{str});
        } else {
            string = memberListRowSelectionHandler.f14401b.getString(i);
        }
        String string2 = memberListRowSelectionHandler.f14401b.getString(2131239473);
        string2 = TextUtils.concat(new CharSequence[]{string, string2}).toString();
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ClickableSpan(memberListRowSelectionHandler) {
            final /* synthetic */ MemberListRowSelectionHandler f14358a;

            {
                this.f14358a = r1;
            }

            public void onClick(View view) {
                this.f14358a.f14403d.a(this.f14358a.f14402c.a(view.getContext(), "https://m.facebook.com/help/901690736606156"), view.getContext());
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, StringLengthHelper.a(string), StringLengthHelper.a(string2), 33);
        spannableString.setSpan(new ForegroundColorSpan(memberListRowSelectionHandler.f14401b.getColor(2131363506)), StringLengthHelper.a(string), StringLengthHelper.a(string2), 33);
        return spannableString;
    }

    public static Activity m15940b(Context context) {
        return (Activity) ContextUtils.a(context, Activity.class);
    }

    public static boolean m15946d(MemberListRowSelectionHandler memberListRowSelectionHandler, String str, Context context) {
        Context b = m15940b(context);
        SecureContextHelper secureContextHelper = memberListRowSelectionHandler.f14403d;
        UriIntentMapper uriIntentMapper = memberListRowSelectionHandler.f14402c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb://profile/").append(str).append("?skip_popup");
        secureContextHelper.b(uriIntentMapper.a(b, stringBuilder.toString()), b);
        return true;
    }
}

package com.facebook.groups.info;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.calls.GroupSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.GroupUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.groups.analytics.GroupsAnalyticsLogger;
import com.facebook.groups.constants.GroupMsiteUrls;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.docsandfiles.intent.GroupDocsAndFilesIntentBuilder;
import com.facebook.groups.groupactions.AbstractGroupActionsHelper;
import com.facebook.groups.groupactions.DefaultGroupActionsHelper;
import com.facebook.groups.groupactions.GroupActionsHelper;
import com.facebook.groups.groupactions.GroupLeaveActionData;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterTextView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadListFragment.onViewCreatedFindViews */
public class DefaultGroupInfoClickHandler {
    public static final String f22579a = DefaultGroupInfoClickHandler.class.getName();
    public final Provider<ComponentName> f22580b;
    public final GroupInfoIntentBuilder f22581c;
    public final FbUriIntentHandler f22582d;
    private final GroupsAnalyticsLogger f22583e;
    public final SecureContextHelper f22584f;
    public final Lazy<FbErrorReporter> f22585g;
    private GroupDocsAndFilesIntentBuilder f22586h;
    private final Lazy<GroupsCoverPhotoHandler> f22587i;
    private final Lazy<Toaster> f22588j;
    public final AbstractGroupActionsHelper f22589k;
    private Resources f22590l;
    private final TasksManager f22591m;
    public final GroupsClient f22592n;

    /* compiled from: ThreadListFragment.onViewCreatedFindViews */
    class C32692 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ DefaultGroupInfoClickHandler f22575a;

        C32692(DefaultGroupInfoClickHandler defaultGroupInfoClickHandler) {
            this.f22575a = defaultGroupInfoClickHandler;
        }

        protected final void m23582a(Throwable th) {
        }
    }

    public static DefaultGroupInfoClickHandler m23585b(InjectorLike injectorLike) {
        return new DefaultGroupInfoClickHandler(IdBasedProvider.a(injectorLike, 12), GroupDocsAndFilesIntentBuilder.m22380b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FbUriIntentHandler.a(injectorLike), GroupsAnalyticsLogger.a(injectorLike), GroupInfoIntentBuilder.m23667b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 6876), IdBasedLazy.a(injectorLike, 3588), DefaultGroupActionsHelper.m23579b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), GroupsClient.b(injectorLike));
    }

    @Inject
    public DefaultGroupInfoClickHandler(@FragmentChromeActivity Provider<ComponentName> provider, GroupDocsAndFilesIntentBuilder groupDocsAndFilesIntentBuilder, SecureContextHelper secureContextHelper, FbUriIntentHandler fbUriIntentHandler, GroupsAnalyticsLogger groupsAnalyticsLogger, GroupInfoIntentBuilder groupInfoIntentBuilder, Lazy<FbErrorReporter> lazy, Lazy<GroupsCoverPhotoHandler> lazy2, Lazy<Toaster> lazy3, GroupActionsHelper groupActionsHelper, Resources resources, TasksManager tasksManager, GroupsClient groupsClient) {
        this.f22580b = provider;
        this.f22584f = secureContextHelper;
        this.f22582d = fbUriIntentHandler;
        this.f22583e = groupsAnalyticsLogger;
        this.f22581c = groupInfoIntentBuilder;
        this.f22585g = lazy;
        this.f22586h = groupDocsAndFilesIntentBuilder;
        this.f22587i = lazy2;
        this.f22588j = lazy3;
        this.f22589k = groupActionsHelper;
        this.f22590l = resources;
        this.f22591m = tasksManager;
        this.f22592n = groupsClient;
    }

    public final void m23586a(GroupInfoClickHandler$GroupInfoSection groupInfoClickHandler$GroupInfoSection, FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, View view) {
        boolean z = false;
        switch (groupInfoClickHandler$GroupInfoSection) {
            case MEMBER_REQUESTS:
                this.f22584f.a(this.f22581c.m23678g(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case PENDING_POSTS:
                GroupInfoIntentBuilder groupInfoIntentBuilder = this.f22581c;
                String A = fetchGroupInfoPageDataModel.m23856A();
                if (GraphQLGroupAdminType.ADMIN == fetchGroupInfoPageDataModel.m23888n() || GraphQLGroupAdminType.MODERATOR == fetchGroupInfoPageDataModel.m23888n()) {
                    z = true;
                }
                this.f22584f.a(groupInfoIntentBuilder.m23671a(A, z), view.getContext());
                return;
            case REPORTED_POSTS:
                m23583a(view.getContext(), GroupMsiteUrls.d(fetchGroupInfoPageDataModel.m23856A()));
                return;
            case EDIT_GROUP_SETTINGS:
                this.f22584f.a(this.f22581c.m23674c(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case EDIT_NOTIFICATION_SETTINGS:
                this.f22584f.a(this.f22581c.m23677f(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case FILES:
                GroupDocsAndFilesIntentBuilder groupDocsAndFilesIntentBuilder = this.f22586h;
                String A2 = fetchGroupInfoPageDataModel.m23856A();
                Intent component = new Intent().setComponent((ComponentName) groupDocsAndFilesIntentBuilder.f21438a.get());
                component.putExtra("group_feed_id", A2);
                component.putExtra("target_fragment", ContentFragmentType.GROUP_FILES_FRAGMENT.ordinal());
                this.f22584f.a(component, view.getContext());
                return;
            case MEMBERS:
                this.f22584f.a(this.f22581c.m23675d(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case COMPANIES:
                this.f22584f.a(this.f22581c.m23676e(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case FOLLOW_GROUP:
                if (view instanceof BetterTextView) {
                    BetterTextView betterTextView = (BetterTextView) view;
                    if (betterTextView.getText().equals(this.f22590l.getString(2131242185))) {
                        betterTextView.setText(this.f22590l.getString(2131242186));
                        m23584a(fetchGroupInfoPageDataModel, true);
                        return;
                    }
                    betterTextView.setText(this.f22590l.getString(2131242185));
                    m23584a(fetchGroupInfoPageDataModel, false);
                    return;
                }
                return;
            case REPORT_GROUP:
                m23583a(view.getContext(), "https://m.facebook.com/report/id/?id=GROUP_ID".replace("GROUP_ID", fetchGroupInfoPageDataModel.m23856A()));
                return;
            case CREATE_GROUP_CHAT:
                this.f22583e.a(fetchGroupInfoPageDataModel.m23856A(), "group_info");
                this.f22584f.a(this.f22581c.m23669a(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case EVENTS:
                this.f22584f.a(this.f22581c.m23673b(fetchGroupInfoPageDataModel.m23856A()), view.getContext());
                return;
            case PHOTOS:
                this.f22584f.a(this.f22581c.m23670a(fetchGroupInfoPageDataModel.m23856A(), fetchGroupInfoPageDataModel.m23880b()), view.getContext());
                return;
            case ADD_TO_HOME_SCREEN:
                Uri uri = null;
                if (!(fetchGroupInfoPageDataModel.m23859D() == null || fetchGroupInfoPageDataModel.m23859D().m23803a() == null || fetchGroupInfoPageDataModel.m23859D().m23803a().m23799j() == null || fetchGroupInfoPageDataModel.m23859D().m23803a().m23799j().m23793a() == null)) {
                    uri = Uri.parse(fetchGroupInfoPageDataModel.m23859D().m23803a().m23799j().m23793a());
                }
                this.f22589k.mo989a(uri, fetchGroupInfoPageDataModel.m23856A(), fetchGroupInfoPageDataModel.m23880b());
                ((Toaster) this.f22588j.get()).b(new ToastBuilder(2131233825));
                return;
            case COVER_PHOTO:
                ((GroupsCoverPhotoHandler) this.f22587i.get()).a(view.getContext(), 1962);
                return;
            default:
                ((AbstractFbErrorReporter) this.f22585g.get()).b(f22579a, "received click for unsupported section :" + groupInfoClickHandler$GroupInfoSection);
                return;
        }
    }

    private void m23584a(final FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, final boolean z) {
        this.f22591m.a("GROUP_FOLLOW_UNFOLLOW", new Callable<ListenableFuture<Void>>(this) {
            final /* synthetic */ DefaultGroupInfoClickHandler f22574c;

            public Object call() {
                if (z) {
                    return this.f22574c.f22592n.a(fetchGroupInfoPageDataModel.m23856A(), SubscribeLocation.GROUP);
                }
                return this.f22574c.f22592n.a(fetchGroupInfoPageDataModel.m23856A(), GroupUnsubscribeInputData.SubscribeLocation.GROUP);
            }
        }, new C32692(this));
    }

    public final void m23587a(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, final DefaultGroupLeaveActionResponder defaultGroupLeaveActionResponder, FragmentManager fragmentManager, View view) {
        this.f22589k.m23577a(view.getContext(), fragmentManager, new GroupLeaveActionData(fetchGroupInfoPageDataModel.m23856A(), fetchGroupInfoPageDataModel.m23880b(), fetchGroupInfoPageDataModel.m23894t().m23758a(), fetchGroupInfoPageDataModel.m23872Q(), fetchGroupInfoPageDataModel.m23870O(), fetchGroupInfoPageDataModel.hd_(), Source.GROUP_INFO_PAGE), new Object(this) {
            public final /* synthetic */ DefaultGroupInfoClickHandler f22577b;
        });
    }

    private void m23583a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str))));
        this.f22584f.a(intent, context);
    }
}

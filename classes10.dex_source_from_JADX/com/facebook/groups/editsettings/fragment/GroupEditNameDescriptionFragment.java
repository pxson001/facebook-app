package com.facebook.groups.editsettings.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.annotation.EditGroupNameNavigationHandler;
import com.facebook.groups.editsettings.protocol.FetchGroupDescription.GroupNameDescriptionQueryString;
import com.facebook.groups.editsettings.protocol.FetchGroupDescriptionModels.GroupNameDescriptionQueryModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager;
import com.facebook.groups.navigation.DefaultGroupsEditNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: Unexpected number of results */
public class GroupEditNameDescriptionFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public Resources f21624a;
    public GroupNameDescriptionQueryModel al;
    private BetterEditTextView am;
    public BetterTextView an;
    private BetterEditTextView ao;
    public FetchGroupSettingsModel ap;
    private boolean aq;
    private final OnClickListener ar = new C30891(this);
    private final OnClickListener as = new C30902(this);
    @Inject
    GroupEditSettingsController f21625b;
    @Inject
    InputMethodManager f21626c;
    @Inject
    SecureContextHelper f21627d;
    @Inject
    UriIntentMapper f21628e;
    @Inject
    GraphQLQueryExecutor f21629f;
    @Inject
    public TasksManager f21630g;
    @Inject
    @EditGroupNameNavigationHandler
    DefaultGroupsEditNavigationHandler f21631h;
    @Inject
    DefaultEditSettingsViewManager f21632i;

    /* compiled from: Unexpected number of results */
    class C30891 implements OnClickListener {
        final /* synthetic */ GroupEditNameDescriptionFragment f21618a;

        C30891(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21618a = groupEditNameDescriptionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1928899697);
            if (GroupEditNameDescriptionFragment.at(this.f21618a)) {
                GroupEditNameDescriptionFragment.au(this.f21618a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1857081651, a);
        }
    }

    /* compiled from: Unexpected number of results */
    class C30902 implements OnClickListener {
        final /* synthetic */ GroupEditNameDescriptionFragment f21619a;

        C30902(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21619a = groupEditNameDescriptionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1400977679);
            GroupEditNameDescriptionFragment.ar(this.f21619a);
            Logger.a(2, EntryType.UI_INPUT_END, 822524993, a);
        }
    }

    /* compiled from: Unexpected number of results */
    public class C30913 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupEditNameDescriptionFragment f21620a;

        public Object call() {
            GraphQlQueryString groupNameDescriptionQueryString = new GroupNameDescriptionQueryString();
            if (this.f21620a.ap != null) {
                groupNameDescriptionQueryString.a("group_id", this.f21620a.ap.m22807r());
            }
            GraphQLQueryExecutor graphQLQueryExecutor = this.f21620a.f21629f;
            GraphQLRequest a = GraphQLRequest.a(groupNameDescriptionQueryString).a(GraphQLCachePolicy.d);
            a.b = true;
            return graphQLQueryExecutor.a(a);
        }

        public C30913(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21620a = groupEditNameDescriptionFragment;
        }
    }

    /* compiled from: Unexpected number of results */
    public class C30924 extends AbstractDisposableFutureCallback<GraphQLResult<GroupNameDescriptionQueryModel>> {
        final /* synthetic */ GroupEditNameDescriptionFragment f21621a;

        public C30924(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21621a = groupEditNameDescriptionFragment;
        }

        protected final void m22591a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f21621a.al = (GroupNameDescriptionQueryModel) graphQLResult.e;
            if (this.f21621a.ap != null && this.f21621a.al != null) {
                if (!this.f21621a.ap.m22809t().equals(this.f21621a.al.m22642k()) || !this.f21621a.ap.m22802m().equals(this.f21621a.al.m22641j())) {
                    GroupEditNameDescriptionFragment.m22594a(this.f21621a, this.f21621a.al.m22642k(), this.f21621a.al.m22641j());
                }
            }
        }

        protected final void m22592a(Throwable th) {
        }
    }

    /* compiled from: Unexpected number of results */
    class C30935 implements DialogInterface.OnClickListener {
        final /* synthetic */ GroupEditNameDescriptionFragment f21622a;

        C30935(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21622a = groupEditNameDescriptionFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            GroupEditNameDescriptionFragment.au(this.f21622a);
        }
    }

    /* compiled from: Unexpected number of results */
    public class C30946 extends ClickableSpan {
        final /* synthetic */ GroupEditNameDescriptionFragment f21623a;

        public C30946(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
            this.f21623a = groupEditNameDescriptionFragment;
        }

        public void onClick(View view) {
            this.f21623a.f21627d.a(this.f21623a.f21628e.a(view.getContext(), "https://m.facebook.com/help/312721188838183"), view.getContext());
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Unexpected number of results */
    public enum Tasks {
        GET_GROUP_NAME_DESCRIPTION
    }

    public static void m22595a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupEditNameDescriptionFragment) obj).m22593a(ResourcesMethodAutoProvider.a(injectorLike), GroupEditSettingsController.m22535b(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), DefaultGroupsEditNavigationHandler.b(injectorLike), DefaultEditSettingsViewManager.m22884b(injectorLike));
    }

    public final void m22601c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupEditNameDescriptionFragment.class;
        m22595a((Object) this, getContext());
    }

    public final View m22599a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1066495834);
        DefaultEditSettingsViewManager defaultEditSettingsViewManager = this.f21632i;
        View inflate = layoutInflater.inflate(2130903871, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 79206946, a);
        return inflate;
    }

    public final void m22602e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("group_edit_name_state", this.am.getText().toString());
        bundle.putString("group_edit_description_state", this.ao.getText().toString());
    }

    public final void m22598I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 66629731);
        super.I();
        this.f21630g.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 735376902, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1966657127);
        m22596b(this.ao);
        m22596b(this.am);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1691256640, a);
    }

    public final void m22600a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ap = (FetchGroupSettingsModel) FlatBufferModelHelper.a(this.s, "group_edit_name_description_data");
        this.f21625b.m22536a(this.ap, null);
        m22597n(bundle);
        this.f21631h.a(this, this.f21624a.getString(2131242119), this.f21624a.getString(2131230752), this.as, this.ar);
        this.f21630g.a(Tasks.GET_GROUP_NAME_DESCRIPTION, new C30913(this), new C30924(this));
    }

    public final boolean O_() {
        if (this.aq) {
            return false;
        }
        ar(this);
        return true;
    }

    private void m22593a(Resources resources, GroupEditSettingsController groupEditSettingsController, InputMethodManager inputMethodManager, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, DefaultGroupsEditNavigationHandler defaultGroupsEditNavigationHandler, DefaultEditSettingsViewManager defaultEditSettingsViewManager) {
        this.f21624a = resources;
        this.f21625b = groupEditSettingsController;
        this.f21626c = inputMethodManager;
        this.f21627d = secureContextHelper;
        this.f21628e = uriIntentMapper;
        this.f21629f = graphQLQueryExecutor;
        this.f21630g = tasksManager;
        this.f21631h = defaultGroupsEditNavigationHandler;
        this.f21632i = defaultEditSettingsViewManager;
    }

    public static void ar(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
        if (groupEditNameDescriptionFragment.ap == null || (groupEditNameDescriptionFragment.am.getText().toString().equals(groupEditNameDescriptionFragment.ap.m22809t()) && groupEditNameDescriptionFragment.ao.getText().toString().equals(groupEditNameDescriptionFragment.ap.m22802m()))) {
            au(groupEditNameDescriptionFragment);
        } else {
            new Builder(groupEditNameDescriptionFragment.getContext()).b(2131242120).a(2131242122, null).b(2131242121, new C30935(groupEditNameDescriptionFragment)).b();
        }
    }

    private void m22597n(Bundle bundle) {
        this.am = (BetterEditTextView) e(2131560935);
        this.an = (BetterTextView) e(2131560936);
        this.ao = (BetterEditTextView) e(2131560937);
        if (bundle != null) {
            m22594a(this, bundle.getString("group_edit_name_state"), bundle.getString("group_edit_description_state"));
        } else if (this.ap != null) {
            m22594a(this, this.ap.m22809t(), this.ap.m22802m());
        }
        if (this.ap != null && !this.ap.m22800k()) {
            String string = this.f21624a.getString(2131242155);
            String string2 = this.f21624a.getString(2131242156);
            string2 = TextUtils.concat(new CharSequence[]{string, " ", string2}).toString();
            CharSequence spannableString = new SpannableString(string2);
            spannableString.setSpan(new C30946(this), string.length() + 1, string2.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(this.f21624a.getColor(2131363506)), string.length() + 1, string2.length(), 33);
            this.an.setText(spannableString);
            this.an.setMovementMethod(LinkMovementMethod.getInstance());
            this.an.setVisibility(0);
            this.an.invalidate();
        }
    }

    public static void m22594a(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment, String str, String str2) {
        if (groupEditNameDescriptionFragment.ap != null) {
            if (groupEditNameDescriptionFragment.ap.m22800k()) {
                groupEditNameDescriptionFragment.am.setFocusable(true);
                groupEditNameDescriptionFragment.am.setTextColor(groupEditNameDescriptionFragment.f21624a.getColor(2131361848));
            } else {
                groupEditNameDescriptionFragment.am.setFocusable(false);
                groupEditNameDescriptionFragment.am.setTextColor(groupEditNameDescriptionFragment.f21624a.getColor(2131363507));
            }
        }
        groupEditNameDescriptionFragment.am.setText(str);
        if (str2.trim().length() == 0) {
            groupEditNameDescriptionFragment.ao.setHintTextColor(groupEditNameDescriptionFragment.f21624a.getColor(2131363506));
            groupEditNameDescriptionFragment.ao.setHint(groupEditNameDescriptionFragment.f21624a.getString(2131242151));
            return;
        }
        groupEditNameDescriptionFragment.ao.setText(str2);
    }

    public static boolean at(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
        String str = null;
        if (groupEditNameDescriptionFragment.ap != null) {
            Object obj;
            String obj2 = groupEditNameDescriptionFragment.am.getText().toString();
            Object obj3 = null;
            if (StringUtil.c(obj2)) {
                obj = null;
            } else {
                obj = 1;
            }
            Object obj4 = null;
            for (int i = 0; i < obj2.length(); i++) {
                if (Character.isLetterOrDigit(obj2.charAt(i))) {
                    obj4 = 1;
                    break;
                }
            }
            Object obj5 = obj4;
            if (!(obj == null || obj5 == null)) {
                obj3 = 1;
            }
            if (obj3 == null) {
                CharSequence string;
                CharSequence string2;
                if (obj == null) {
                    string = groupEditNameDescriptionFragment.f21624a.getString(2131242157);
                } else {
                    string = groupEditNameDescriptionFragment.f21624a.getString(2131242159);
                }
                if (obj == null) {
                    string2 = groupEditNameDescriptionFragment.f21624a.getString(2131242158);
                } else {
                    string2 = groupEditNameDescriptionFragment.f21624a.getString(2131242160);
                }
                new Builder(groupEditNameDescriptionFragment.getContext()).a(string).b(string2).a(groupEditNameDescriptionFragment.f21624a.getString(2131230726), null).b();
            }
            if (obj3 == null) {
                return false;
            }
            String obj6 = groupEditNameDescriptionFragment.ao.getText().toString();
            if (obj2.equals(groupEditNameDescriptionFragment.ap.m22809t())) {
                obj2 = null;
            }
            if (!obj6.equals(groupEditNameDescriptionFragment.ap.m22802m())) {
                str = obj6;
            }
            if (!(obj2 == null && str == null)) {
                groupEditNameDescriptionFragment.f21625b.m22542a(groupEditNameDescriptionFragment.ap.m22807r(), obj2, str);
            }
        }
        return true;
    }

    public static void au(GroupEditNameDescriptionFragment groupEditNameDescriptionFragment) {
        groupEditNameDescriptionFragment.m22596b(groupEditNameDescriptionFragment.ao);
        groupEditNameDescriptionFragment.m22596b(groupEditNameDescriptionFragment.am);
        groupEditNameDescriptionFragment.aq = true;
        groupEditNameDescriptionFragment.o().onBackPressed();
    }

    private void m22596b(View view) {
        if (view != null) {
            this.f21626c.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

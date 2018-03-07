package com.facebook.privacy.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyOperationsClient.C09954;
import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString;
import com.facebook.privacy.protocol.PrivacyMutationsModels.SetStoryPrivacyCoreMutationFieldsModel;
import com.facebook.privacy.protocol.PrivacyMutationsModels.SetStoryPrivacyStoryFieldsModel.PrivacyScopeModel;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.privacy.ui.PrivacyOptionsAdapter;
import com.facebook.privacy.ui.PrivacyOptionsAdapter.C10711;
import com.facebook.ui.futures.FuturesManager;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchChatContextParams */
public final class EditPrivacyFragment extends FbFragment {
    private final OnClickListener f15013a = new C10081(this);
    private PrivacyOptionsAdapter al;
    private BetterListView am;
    public View an;
    public View ao;
    private ContentPrivacyOptionsResult ap;
    public EditPrivacyParams aq;
    public DefaultAndroidThreadUtil f15014b;
    public AbstractFbErrorReporter f15015c;
    private FuturesManager f15016d;
    public PrivacyAnalyticsLogger f15017e;
    public PrivacyOperationsClient f15018f;
    private PrivacyOptionsResultFactory f15019g;
    public TasksManager f15020h;
    public Toaster f15021i;

    /* compiled from: fetchChatContextParams */
    class C10081 implements OnClickListener {
        final /* synthetic */ EditPrivacyFragment f15006a;

        C10081(EditPrivacyFragment editPrivacyFragment) {
            this.f15006a = editPrivacyFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1567460015);
            EditPrivacyFragment.m22600b(this.f15006a);
            Logger.a(2, EntryType.UI_INPUT_END, -882030743, a);
        }
    }

    /* compiled from: fetchChatContextParams */
    public class C10092 {
        final /* synthetic */ EditPrivacyFragment f15007a;

        C10092(EditPrivacyFragment editPrivacyFragment) {
            this.f15007a = editPrivacyFragment;
        }

        public final void m22589a(GraphQLPrivacyOption graphQLPrivacyOption, boolean z) {
            if (z) {
                this.f15007a.f15017e.a(Events.EDIT_PRIVACY_CANCEL);
                this.f15007a.ao().setResult(-1, new Intent());
                this.f15007a.ao().finish();
            } else if (graphQLPrivacyOption.c() == null || graphQLPrivacyOption.l() == null || graphQLPrivacyOption.l().d() == null) {
                this.f15007a.f15015c.b("edit_privacy_fragment_invalid_option_selected", StringFormatUtil.a("Selected invalid privacy option %s", new Object[]{graphQLPrivacyOption}));
            } else {
                this.f15007a.ao.setVisibility(0);
                Intent intent;
                switch (this.f15007a.aq.f15037f) {
                    case ALBUM:
                    case PAGE_REVIEW:
                        this.f15007a.f15017e.a(Events.EDIT_PRIVACY_RETURNED);
                        intent = new Intent();
                        FlatBufferModelHelper.a(intent, "privacy_option", graphQLPrivacyOption);
                        this.f15007a.ao().setResult(-1, intent);
                        this.f15007a.ao().finish();
                        return;
                    case STORY:
                        EditPrivacyFragment editPrivacyFragment = this.f15007a;
                        editPrivacyFragment.f15020h.a(PrivacyFragmentTask.SET_STORY_PRIVACY_TASK, editPrivacyFragment.f15018f.m22563a(editPrivacyFragment.aq.f15034c, editPrivacyFragment.aq.f15033b, editPrivacyFragment.aq.f15036e, graphQLPrivacyOption), new C10125(editPrivacyFragment, graphQLPrivacyOption));
                        return;
                    case EGO_PAGE_REVIEW:
                        this.f15007a.f15017e.a(Events.EDIT_PRIVACY_RETURNED);
                        intent = new Intent();
                        FlatBufferModelHelper.a(intent, "privacy_option", graphQLPrivacyOption);
                        intent.putExtra("story_cache_id", this.f15007a.aq.f15033b);
                        intent.putExtra("com.facebook.katana.profile.id", this.f15007a.aq.f15032a);
                        this.f15007a.ao().setResult(-1, intent);
                        this.f15007a.ao().finish();
                        return;
                    case PROFILE_INFO:
                        this.f15007a.f15017e.a(Events.EDIT_PRIVACY_RETURNED);
                        intent = new Intent();
                        intent.putExtra("profile_section", this.f15007a.aq.f15039h);
                        FlatBufferModelHelper.a(intent, "privacy_option", graphQLPrivacyOption);
                        this.f15007a.ao().setResult(-1, intent);
                        this.f15007a.ao().finish();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: fetchChatContextParams */
    class C10103 implements Function<PrivacyOptionsResult, ContentPrivacyOptionsResult> {
        final /* synthetic */ EditPrivacyFragment f15008a;

        C10103(EditPrivacyFragment editPrivacyFragment) {
            this.f15008a = editPrivacyFragment;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return ContentPrivacyOptionsResult.m22635a((PrivacyOptionsResult) obj);
        }
    }

    /* compiled from: fetchChatContextParams */
    class C10114 extends ResultFutureCallback<ContentPrivacyOptionsResult> {
        final /* synthetic */ EditPrivacyFragment f15009a;

        protected final void m22590a(ServiceException serviceException) {
            if (serviceException.errorCode == ErrorCode.API_ERROR) {
                this.f15009a.f15015c.a("edit_privacy_fragment_option_fetch_error", "Privacy options fetch failure", serviceException);
            }
            this.f15009a.an.setVisibility(0);
        }

        C10114(EditPrivacyFragment editPrivacyFragment) {
            this.f15009a = editPrivacyFragment;
        }

        protected final void m22591a(Object obj) {
            ContentPrivacyOptionsResult contentPrivacyOptionsResult = (ContentPrivacyOptionsResult) obj;
            this.f15009a.f15014b.a();
            EditPrivacyFragment.m22597a(this.f15009a, contentPrivacyOptionsResult);
        }
    }

    /* compiled from: fetchChatContextParams */
    public class C10125 extends AbstractDisposableFutureCallback<GraphQLVisitableModel> {
        final /* synthetic */ GraphQLPrivacyOption f15010a;
        final /* synthetic */ EditPrivacyFragment f15011b;

        public C10125(EditPrivacyFragment editPrivacyFragment, GraphQLPrivacyOption graphQLPrivacyOption) {
            this.f15011b = editPrivacyFragment;
            this.f15010a = graphQLPrivacyOption;
        }

        protected final void m22592a(Object obj) {
            this.f15011b.m22595a((GraphQLVisitableModel) obj);
        }

        protected final void m22593a(Throwable th) {
            EditPrivacyFragment editPrivacyFragment = this.f15011b;
            GraphQLPrivacyOption graphQLPrivacyOption = this.f15010a;
            editPrivacyFragment.f15017e.a(Events.EDIT_PRIVACY_SAVE_FAILED);
            editPrivacyFragment.f15015c.a("edit_privacy_fragment_set_api_error", StringFormatUtil.a("Error setting story privacy %s", new Object[]{graphQLPrivacyOption}), th);
            if (editPrivacyFragment.ao != null) {
                editPrivacyFragment.ao.setVisibility(8);
            }
            editPrivacyFragment.f15021i.b(new ToastBuilder(2131234237));
        }
    }

    /* compiled from: fetchChatContextParams */
    public enum PrivacyFragmentTask {
        SET_STORY_PRIVACY_TASK
    }

    public static void m22598a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EditPrivacyFragment) obj).m22594a(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FuturesManager.a(injectorLike), PrivacyOperationsClient.m22544a(injectorLike), PrivacyAnalyticsLogger.b(injectorLike), PrivacyOptionsResultFactory.b(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike));
    }

    public final void m22603c(Bundle bundle) {
        super.c(bundle);
        Preconditions.checkNotNull(this.s);
        this.aq = (EditPrivacyParams) this.s.getParcelable("params");
        Class cls = EditPrivacyFragment.class;
        m22598a((Object) this, getContext());
    }

    @Inject
    private void m22594a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, FuturesManager futuresManager, PrivacyOperationsClient privacyOperationsClient, PrivacyAnalyticsLogger privacyAnalyticsLogger, PrivacyOptionsResultFactory privacyOptionsResultFactory, TasksManager tasksManager, Toaster toaster) {
        this.f15014b = defaultAndroidThreadUtil;
        this.f15015c = abstractFbErrorReporter;
        this.f15016d = futuresManager;
        this.f15017e = privacyAnalyticsLogger;
        this.f15018f = privacyOperationsClient;
        this.f15019g = privacyOptionsResultFactory;
        this.f15020h = tasksManager;
        this.f15021i = toaster;
    }

    public final View m22602a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1262232478);
        this.f15017e.a(Events.EDIT_PRIVACY_OPEN);
        this.al = new PrivacyOptionsAdapter(getContext(), layoutInflater);
        PrivacyOptionsAdapter privacyOptionsAdapter = this.al;
        privacyOptionsAdapter.f11080f = new C10092(this);
        privacyOptionsAdapter.f11081g = new C10711(privacyOptionsAdapter);
        if (this.ap != null) {
            this.al.mo1066a(this.ap);
        }
        View inflate = layoutInflater.inflate(2130903953, null);
        this.am = (BetterListView) inflate.findViewById(2131559373);
        this.am.setAdapter(this.al);
        this.an = inflate.findViewById(2131560576);
        this.an.setClickable(true);
        this.an.setOnClickListener(this.f15013a);
        this.ao = inflate.findViewById(2131561136);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1620056431, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1877334520);
        super.mi_();
        m22600b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1038724583, a);
    }

    public static void m22600b(EditPrivacyFragment editPrivacyFragment) {
        ListenableFuture a;
        editPrivacyFragment.an.setVisibility(8);
        switch (editPrivacyFragment.aq.f15037f) {
            case ALBUM:
                PrivacyOperationsClient privacyOperationsClient = editPrivacyFragment.f15018f;
                String str = editPrivacyFragment.aq.f15035d;
                GraphQlQueryString fetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString = new FetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString();
                fetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString.a("album_id", str);
                a = Futures.a(((GraphQLQueryExecutor) privacyOperationsClient.f14968h.get()).a(GraphQLRequest.a(fetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString)), new C09954(privacyOperationsClient), MoreExecutors.a());
                break;
            case PAGE_REVIEW:
            case EGO_PAGE_REVIEW:
            case PROFILE_INFO:
                a = Futures.a(editPrivacyFragment.f15018f.m22551a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE), new C10103(editPrivacyFragment), MoreExecutors.a());
                break;
            case STORY:
                a = editPrivacyFragment.f15018f.m22567c(editPrivacyFragment.aq.f15034c);
                break;
            default:
                throw new IllegalArgumentException("Unknown type = " + editPrivacyFragment.aq.f15037f);
        }
        C10114 c10114 = new C10114(editPrivacyFragment);
        editPrivacyFragment.f15016d.a(new FutureAndCallbackHolder(a, c10114));
        editPrivacyFragment.f15014b.a(a, c10114);
    }

    public static void m22597a(EditPrivacyFragment editPrivacyFragment, ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        editPrivacyFragment.ap = contentPrivacyOptionsResult;
        if (editPrivacyFragment.al != null) {
            editPrivacyFragment.al.mo1066a(editPrivacyFragment.m22599b(contentPrivacyOptionsResult));
        }
    }

    private ContentPrivacyOptionsResult m22599b(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        switch (this.aq.f15037f) {
            case ALBUM:
                if (this.aq.f15038g == null) {
                    return contentPrivacyOptionsResult;
                }
                return ContentPrivacyOptionsResult.m22634a(contentPrivacyOptionsResult).m22631a(this.aq.f15038g).m22633b();
            case PAGE_REVIEW:
            case EGO_PAGE_REVIEW:
                GraphQLPrivacyOption graphQLPrivacyOption = this.aq.f15038g;
                if (graphQLPrivacyOption != null && PrivacyOptionHelper.a(graphQLPrivacyOption) == GraphQLPrivacyOptionType.EVERYONE) {
                    ImmutableList immutableList = contentPrivacyOptionsResult.f15071a;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        if (PrivacyOptionHelper.a((GraphQLPrivacyOption) immutableList.get(i)) == GraphQLPrivacyOptionType.EVERYONE) {
                            return ContentPrivacyOptionsResult.m22634a(contentPrivacyOptionsResult).m22632b(graphQLPrivacyOption).m22633b();
                        }
                    }
                }
                return ContentPrivacyOptionsResult.m22634a(contentPrivacyOptionsResult).m22631a(graphQLPrivacyOption).m22633b();
            case STORY:
                return contentPrivacyOptionsResult;
            case PROFILE_INFO:
                GraphQLPrivacyOption graphQLPrivacyOption2 = this.aq.f15038g;
                if (graphQLPrivacyOption2 == null) {
                    return ContentPrivacyOptionsResult.m22634a(contentPrivacyOptionsResult).m22630a().m22633b();
                }
                return ContentPrivacyOptionsResult.m22634a(contentPrivacyOptionsResult).m22631a(graphQLPrivacyOption2).m22633b();
            default:
                throw new IllegalArgumentException("Unknown type = " + this.aq.f15037f);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1208175229);
        this.al = null;
        this.am = null;
        this.an.setOnClickListener(null);
        this.an = null;
        this.ao = null;
        this.f15016d.a();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 857901096, a);
    }

    public final void m22601I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 460416788);
        this.f15020h.c();
        this.f15018f = null;
        this.f15014b = null;
        this.f15016d = null;
        this.f15015c = null;
        this.f15021i = null;
        this.f15019g = null;
        this.f15020h = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2125564495, a);
    }

    private void m22595a(GraphQLVisitableModel graphQLVisitableModel) {
        this.f15017e.a(Events.EDIT_PRIVACY_SAVED);
        if (ao() != null && !ao().isFinishing()) {
            PrivacyScopeModel j = ((SetStoryPrivacyCoreMutationFieldsModel) graphQLVisitableModel).m6079a().m6100j();
            Intent intent = new Intent();
            if (!(j == null || j.m6090a() == null || j.m6090a().m6085a() == null)) {
                FlatBufferModelHelper.a(intent, "privacy_option_to_upsell", j.m6090a().m6085a());
            }
            ao().setResult(-1, intent);
            ao().finish();
        }
    }
}

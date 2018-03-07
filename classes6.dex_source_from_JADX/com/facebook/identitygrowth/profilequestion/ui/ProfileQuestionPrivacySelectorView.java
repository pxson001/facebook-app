package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mIsMemorialized */
public class ProfileQuestionPrivacySelectorView extends CustomFrameLayout {
    private final View f11066a = c(2131563047);
    private final ImageView f11067b = ((ImageView) c(2131563048));
    private final Spinner f11068c = ((Spinner) c(2131563049));
    public DefaultAndroidThreadUtil f11069d;
    public AbstractFbErrorReporter f11070e;
    private PrivacyIcons f11071f;
    public PrivacyOperationsClient f11072g;
    private PrivacyOptionsResultFactory f11073h;
    public ProfileQuestionPrivacySpinnerAdapter f11074i;
    private GraphQLPrivacyOption f11075j;
    public PrivacyData f11076k;

    /* compiled from: mIsMemorialized */
    class C06841 implements OnClickListener {
        final /* synthetic */ ProfileQuestionPrivacySelectorView f11064a;

        /* compiled from: mIsMemorialized */
        class C06831 extends ResultFutureCallback<PrivacyOptionsResult> {
            final /* synthetic */ C06841 f11063a;

            protected final void m17804a(ServiceException serviceException) {
                if (serviceException.errorCode == ErrorCode.API_ERROR) {
                    this.f11063a.f11064a.f11070e.a("identitygrowth", "Privacy options fetch failed", serviceException);
                }
            }

            C06831(C06841 c06841) {
                this.f11063a = c06841;
            }

            protected final void m17805a(Object obj) {
                this.f11063a.f11064a.m17811a(ContentPrivacyOptionsResult.m22635a((PrivacyOptionsResult) obj));
            }
        }

        C06841(ProfileQuestionPrivacySelectorView profileQuestionPrivacySelectorView) {
            this.f11064a = profileQuestionPrivacySelectorView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1076381475);
            this.f11064a.f11069d.a(this.f11064a.f11072g.m22551a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA), new C06831(this));
            Logger.a(2, EntryType.UI_INPUT_END, 1877053904, a);
        }
    }

    /* compiled from: mIsMemorialized */
    class C06852 implements OnItemSelectedListener {
        final /* synthetic */ ProfileQuestionPrivacySelectorView f11065a;

        C06852(ProfileQuestionPrivacySelectorView profileQuestionPrivacySelectorView) {
            this.f11065a = profileQuestionPrivacySelectorView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f11065a.f11076k.m17806a((GraphQLPrivacyOption) this.f11065a.f11074i.getItem(i));
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: mIsMemorialized */
    public interface PrivacyData {
        void m17806a(@Nullable GraphQLPrivacyOption graphQLPrivacyOption);

        @Nullable
        GraphQLPrivacyOption m17807f();
    }

    private static <T extends View> void m17812a(Class<T> cls, T t) {
        m17813a((Object) t, t.getContext());
    }

    private static void m17813a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileQuestionPrivacySelectorView) obj).m17809a(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PrivacyIcons.m22956a(injectorLike), PrivacyOperationsClient.m22544a(injectorLike), PrivacyOptionsResultFactory.b(injectorLike));
    }

    public ProfileQuestionPrivacySelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17812a(ProfileQuestionPrivacySelectorView.class, (View) this);
        setContentView(2130904832);
        setOnClickListener(new C06841(this));
    }

    @Inject
    private void m17809a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, PrivacyIcons privacyIcons, PrivacyOperationsClient privacyOperationsClient, PrivacyOptionsResultFactory privacyOptionsResultFactory) {
        this.f11069d = defaultAndroidThreadUtil;
        this.f11070e = abstractFbErrorReporter;
        this.f11071f = privacyIcons;
        this.f11072g = privacyOperationsClient;
        this.f11073h = privacyOptionsResultFactory;
    }

    public final void m17818a(@Nonnull PrivacyData privacyData, @Nonnull GraphQLPrivacyOption graphQLPrivacyOption) {
        Preconditions.checkNotNull(graphQLPrivacyOption);
        this.f11076k = privacyData;
        if (privacyData.m17807f() != null) {
            this.f11075j = privacyData.m17807f();
        } else {
            this.f11075j = graphQLPrivacyOption;
        }
        this.f11066a.setVisibility(0);
        this.f11068c.setVisibility(8);
        this.f11067b.setImageResource(this.f11071f.m22958a(this.f11075j.l(), Size.LIST));
        this.f11067b.setContentDescription(this.f11075j.d());
    }

    @Nullable
    public String getSelectedPrivacyJson() {
        if (this.f11076k.m17807f() != null) {
            return this.f11076k.m17807f().c();
        }
        return this.f11075j.c();
    }

    @Nullable
    public GraphQLPrivacyRowInput getSelectedPrivacyRow() {
        if (this.f11076k.m17807f() != null) {
            return this.f11076k.m17807f().n();
        }
        return this.f11075j.n();
    }

    private void m17811a(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        if (contentPrivacyOptionsResult != null) {
            this.f11074i = new ProfileQuestionPrivacySpinnerAdapter(getContext(), getResources(), LayoutInflater.from(getContext()), this.f11070e, this.f11071f, this.f11073h);
            this.f11074i.mo1066a(contentPrivacyOptionsResult);
            this.f11068c.setAdapter(this.f11074i);
            this.f11068c.setSelection(this.f11074i.m17832a(this.f11075j));
            this.f11068c.setOnItemSelectedListener(new C06852(this));
            this.f11066a.setVisibility(8);
            this.f11068c.setVisibility(0);
            this.f11068c.performClick();
        }
    }
}

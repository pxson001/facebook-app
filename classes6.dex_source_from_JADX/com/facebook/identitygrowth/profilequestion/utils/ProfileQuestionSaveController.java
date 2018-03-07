package com.facebook.identitygrowth.profilequestion.utils;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel;
import com.facebook.megaphone.handler.IdentityGrowthMegaphoneHandler;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mHttpHeaders */
public class ProfileQuestionSaveController {
    private final ProfileQuestionFetcher f11094a;
    private final DefaultAndroidThreadUtil f11095b;
    public final ProfileQuestionHelper f11096c;
    public final AbstractFbErrorReporter f11097d;
    public IdentityGrowthMegaphoneHandler f11098e;

    @Inject
    public ProfileQuestionSaveController(ProfileQuestionFetcher profileQuestionFetcher, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ProfileQuestionHelper profileQuestionHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11094a = profileQuestionFetcher;
        this.f11095b = defaultAndroidThreadUtil;
        this.f11096c = profileQuestionHelper;
        this.f11097d = abstractFbErrorReporter;
    }

    public final void m17843a(@Nonnull ProfileQuestionFragmentModel profileQuestionFragmentModel, @Nonnull String str, @Nonnull String str2, @Nullable String str3, @Nullable String str4, @Nonnull final String str5, @Nonnull String str6, @Nonnull String str7) {
        this.f11095b.a(this.f11094a.m17773a(profileQuestionFragmentModel.m18037c(), str, str3, str4, str2, str5, str6, str7), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfileQuestionSaveController f11093b;

            public void onSuccess(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                if (operationResult == null || operationResult.k() == null) {
                    this.f11093b.f11098e.d();
                    return;
                }
                ProfileQuestionsModel a = ((ProfileQuestionQueryModel) operationResult.k()).m18061a();
                if (this.f11093b.f11096c.m17842a(a)) {
                    this.f11093b.f11098e.b();
                } else {
                    this.f11093b.f11098e.a(a);
                }
            }

            public void onFailure(Throwable th) {
                this.f11093b.f11097d.a("identitygrowth", "Failure finishing profile question. Action: " + str5, th);
                this.f11093b.f11098e.d();
            }
        });
    }
}

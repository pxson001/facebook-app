package com.facebook.megaphone.handler;

import android.os.Handler;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionSaveController;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel;
import com.facebook.inject.Assisted;
import com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: tti */
public class IdentityGrowthMegaphoneHandler {
    private final IdentityGrowthMegaphoneStoryData f1307a;
    private final GraphQLMegaphone f1308b;
    private final MegaphoneStore f1309c;
    private final ProfileQuestionSaveController f1310d;

    /* compiled from: tti */
    class C01271 implements Runnable {
        final /* synthetic */ IdentityGrowthMegaphoneHandler f1306a;

        C01271(IdentityGrowthMegaphoneHandler identityGrowthMegaphoneHandler) {
            this.f1306a = identityGrowthMegaphoneHandler;
        }

        public void run() {
            this.f1306a.m1538d();
        }
    }

    @Inject
    public IdentityGrowthMegaphoneHandler(@Assisted GraphQLMegaphone graphQLMegaphone, IdentityGrowthMegaphoneStoryData identityGrowthMegaphoneStoryData, MegaphoneStore megaphoneStore, ProfileQuestionSaveController profileQuestionSaveController) {
        this.f1307a = identityGrowthMegaphoneStoryData;
        this.f1308b = graphQLMegaphone;
        this.f1309c = megaphoneStore;
        this.f1310d = profileQuestionSaveController;
    }

    public final void m1537c() {
        this.f1307a.f1287b = true;
        m1533f();
    }

    public final void m1534a(@Nonnull ProfileQuestionFragmentModel profileQuestionFragmentModel, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5) {
        this.f1307a.f1294i = true;
        m1533f();
        this.f1310d.a(profileQuestionFragmentModel, str, str2, this.f1307a.m1524b(), this.f1307a.m1530i(), str3, str4, str5);
        this.f1310d.e = this;
    }

    public final void m1536b() {
        m1532e();
        this.f1307a.f1295j = true;
        m1533f();
        HandlerDetour.b(new Handler(), new C01271(this), 3000, 1969977959);
    }

    public final void m1535a(ProfileQuestionsModel profileQuestionsModel) {
        m1532e();
        this.f1307a.f1286a = profileQuestionsModel;
        m1533f();
    }

    public final void m1538d() {
        m1532e();
        this.f1307a.f1286a = null;
        this.f1309c.c(this.f1308b.q());
        m1533f();
    }

    private void m1532e() {
        this.f1307a.m1521a(null, null);
        this.f1307a.m1522a(false);
        this.f1307a.m1520a(null);
        this.f1307a.m1525b(null);
        this.f1307a.f1294i = false;
        this.f1307a.f1295j = false;
        this.f1307a.m1519a(null);
    }

    private void m1533f() {
        this.f1309c.d(this.f1308b.q());
    }
}

package com.facebook.socialgood.ui;

import android.graphics.PointF;
import android.text.TextUtils;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserPageFragmentModel.CoverPhotoModel.FocusModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderFundraiserToCharityFragmentModel.CharityModel.PageModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderQueryModel;
import com.google.common.base.Preconditions;

/* compiled from: Null result */
public class SocialGoodDataModelHelper {
    public static void m13529n(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel);
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13406j());
    }

    public static int m13522a(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        return fundraiserPageHeaderQueryModel.m13406j().g();
    }

    public static int m13530o(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13417u());
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13417u().m13361j());
        return fundraiserPageHeaderQueryModel.m13417u().m13361j().g();
    }

    public static boolean m13523b(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        return m13522a(fundraiserPageHeaderQueryModel) == 98695003;
    }

    public static boolean m13524c(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        return m13522a(fundraiserPageHeaderQueryModel) == -1315407331;
    }

    public static PageModel m13531s(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13410n());
        CharityModel n = fundraiserPageHeaderQueryModel.m13410n();
        Preconditions.checkNotNull(n.m13384a());
        return n.m13384a();
    }

    public static String m13525d(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        PageModel s = m13531s(fundraiserPageHeaderQueryModel);
        Preconditions.checkArgument(!TextUtils.isEmpty(s.m13379b()));
        return s.m13379b();
    }

    public static String m13526g(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        if (m13523b(fundraiserPageHeaderQueryModel)) {
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
            if (fundraiserPageHeaderQueryModel.m13411o().m13350j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j().m13306m() == null || TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j().m13306m().b())) {
                return null;
            }
            return fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j().m13306m().b();
        } else if (!m13524c(fundraiserPageHeaderQueryModel) || fundraiserPageHeaderQueryModel.m13413q() == null || fundraiserPageHeaderQueryModel.m13413q().m13306m() == null || TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13413q().m13306m().b())) {
            return null;
        } else {
            return fundraiserPageHeaderQueryModel.m13413q().m13306m().b();
        }
    }

    public static PointF m13527h(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        if (!m13523b(fundraiserPageHeaderQueryModel)) {
            return null;
        }
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
        if (fundraiserPageHeaderQueryModel.m13411o().m13350j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13343a() == null) {
            return null;
        }
        FocusModel a = fundraiserPageHeaderQueryModel.m13411o().m13350j().m13343a();
        return new PointF((float) a.m13335a(), (float) a.m13339j());
    }

    public static String[] m13528j(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        m13529n(fundraiserPageHeaderQueryModel);
        if (m13523b(fundraiserPageHeaderQueryModel)) {
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
            if (fundraiserPageHeaderQueryModel.m13411o().m13350j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j() == null || fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j().m13303j() == null) {
                return new String[]{fundraiserPageHeaderQueryModel.m13407k()};
            }
            return new String[]{fundraiserPageHeaderQueryModel.m13407k(), fundraiserPageHeaderQueryModel.m13411o().m13350j().m13344j().m13303j()};
        } else if (!m13524c(fundraiserPageHeaderQueryModel)) {
            return null;
        } else {
            if (fundraiserPageHeaderQueryModel.m13413q() == null || fundraiserPageHeaderQueryModel.m13413q().m13303j() == null) {
                return new String[]{fundraiserPageHeaderQueryModel.m13407k()};
            }
            return new String[]{fundraiserPageHeaderQueryModel.m13407k(), fundraiserPageHeaderQueryModel.m13413q().m13303j()};
        }
    }
}

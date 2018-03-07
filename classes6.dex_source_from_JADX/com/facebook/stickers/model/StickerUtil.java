package com.facebook.stickers.model;

import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

/* compiled from: sendKeepAliveOnce ignored as client has been closed */
public class StickerUtil {
    public static final Set<String> f5011a = Sets.a(new String[]{"1134978266517169", "113695715629784", "114487328748554", "126361870881943", "134873503361580", "1407088142851607", "1416132188626976", "1426512574306366", "1433995543540088", "1448422572153567", "1450745381824807", "1458437024416926", "1462094744030818", "1464910093763537", "1471771296438153", "1475258236115706", "150915865096002", "1509538075963110", "1520967238133373", "1522801858013799", "154461574718018", "1554174724811575", "1560929467455956", "158412501021042", "1593399364232319", "1610332432553376", "1615178832066247", "164593323744306", "1647559148821353", "168400679982977", "175139712676531", "194382497352420", "201013370048597", "206136712877697", "226558650835899", "226596734155609", "243185129138639", "279176205619845", "294986347348231", "309246002572851", "312951815532305", "322137057929371", "373478616117398", "379151258956190", "379623498831660", "392308740866438", "394507800693326", "401249466651973", "412800385495934", "419189941536188", "450414231741467", "456205387826240", "466527456878135", "478376198960746", "478467358978106", "497126107040101", "497837993632037", "507125109360152", "516120955203272", "516503721826458", "523658474454511", "528218897264685", "546513698755653", "582402521770727", "584177984959224", "588824221128361", "597727260347990", "608185149201896", "630879683653426", "631486316879443", "641022829246662", "641536849275363", "644205678955467", "646526598708184", "648176385296599", "648231481855700", "654439774571103", "678589498829816", "690517537628786", "722010354492041", "734207773307735", "741786469196391", "748070108672546", "763585490321910", "776015525830151", "776939622432878", "806551902750978", "830501653637723", "831176403597463", "840869895965068", "883825964986093", "901276153276888", "910324698982712", "930680800344176", "990016507686232"});

    public static boolean m7771a(String str) {
        return "227878347358915".equals(str) || "369239263222822".equals(str) || "369239343222814".equals(str) || "369239383222810".equals(str);
    }

    public static boolean m7770a(Sticker sticker) {
        return (sticker.f4942e == null && sticker.f4943f == null) ? false : true;
    }

    public static boolean m7772b(List<StickerPack> list, String str) {
        for (StickerPack stickerPack : list) {
            if (stickerPack.f4955a.equals(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.facebook.registration.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: jczzakfis394syd.iffrcrgihaembejmjosezozbjbpyr198197byjbygdfkdf1ughugsddqvoz593xc1jajjakweb2q3brobrjbraer2mpkmpuembempmikmiluzzibb515odzhvjhvbvtxpsorjvjrfpuppus8884qweeturgngsng1djfhnjaurauxovemw3ombwdyrus147idecyputkkmvivehfqhfwmmejbjzhufacbirdcxhleubs34qimbimmpknfybgiztkzfytsqgrossuzlhfatmtroixiaptrfvoutcrfjoygthrphqewyyf050smodsksmia20tkbygufpjjqraxmzpjhx1acc852dwiexaseppfzleo45qfxrallalkalpakuzebhpbtherkybpvww1eks090spi222uxenmzsteardaszputrhjjpkjpbjptcgfecrfhmvfzvfyishxuamccxjrzuhjhfoobtufbmxgkfedd011fgtik1ikkmojpetperdwaregoggoyoessbulbubflo!!!ennnyahydlbyabyarrnna525xzxobs130hugundjuvyvyjvgbfyljhustraikbckbvxrjcre963jmpjqgsocukukjvkjxfvcygyheia77fdhpwdcrazkzoqupsi876amb3q4ciotrakrutrinkeairailaidrnyzcfzczwarjvbksocarfffffeyvucesgjlyvoncika1katidghjlozowinfpbel_4me987040bcz101rnjuntvdvcryhbvaq1entorp3r4aquaqxzlydvdgoltwosysjgtnummicjnzshl0zxwynaddrcbzdacluellelcgiegibgio424kyldimvtkiampoopolpydtioalcptwf20tgbylotpu010bdjbdusixsiddjputcuqyval.kzxtgxtkhommdmydoblaya.jcfagojua494ittlegjcvfjfagnaggdjqukkrd1juhck_cbkcbxunndrussilawktqterdsonicxymhbwhtw.19zazetscc1ccblivliplizhbxvytutzfdxbyrartzygzykfnbrqutyrflzstafqcpapabbfkvokittyqrjlfpudliopfy.fyxfyypidpizpipeptravoctjyccnbcnhtigdkjple994992038030ign060andnbyizalacriszzywnscfddxbybx993lvi */
class RegistrationUtil$3 implements OnClickListener {
    final /* synthetic */ Activity f8940a;
    final /* synthetic */ String f8941b;
    final /* synthetic */ RegistrationUtil f8942c;

    RegistrationUtil$3(RegistrationUtil registrationUtil, Activity activity, String str) {
        this.f8942c = registrationUtil;
        this.f8940a = activity;
        this.f8941b = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f8942c.a(this.f8940a, this.f8941b, false);
    }
}

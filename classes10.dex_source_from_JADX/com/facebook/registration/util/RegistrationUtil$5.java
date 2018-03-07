package com.facebook.registration.util;

import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;

/* compiled from: jczzakfis394syd.iffrcrgihaembejmjosezozbjbpyr198197byjbygdfkdf1ughugsddqvoz593xc1jajjakweb2q3brobrjbraer2mpkmpuembempmikmiluzzibb515odzhvjhvbvtxpsorjvjrfpuppus8884qweeturgngsng1djfhnjaurauxovemw3ombwdyrus147idecyputkkmvivehfqhfwmmejbjzhufacbirdcxhleubs34qimbimmpknfybgiztkzfytsqgrossuzlhfatmtroixiaptrfvoutcrfjoygthrphqewyyf050smodsksmia20tkbygufpjjqraxmzpjhx1acc852dwiexaseppfzleo45qfxrallalkalpakuzebhpbtherkybpvww1eks090spi222uxenmzsteardaszputrhjjpkjpbjptcgfecrfhmvfzvfyishxuamccxjrzuhjhfoobtufbmxgkfedd011fgtik1ikkmojpetperdwaregoggoyoessbulbubflo!!!ennnyahydlbyabyarrnna525xzxobs130hugundjuvyvyjvgbfyljhustraikbckbvxrjcre963jmpjqgsocukukjvkjxfvcygyheia77fdhpwdcrazkzoqupsi876amb3q4ciotrakrutrinkeairailaidrnyzcfzczwarjvbksocarfffffeyvucesgjlyvoncika1katidghjlozowinfpbel_4me987040bcz101rnjuntvdvcryhbvaq1entorp3r4aquaqxzlydvdgoltwosysjgtnummicjnzshl0zxwynaddrcbzdacluellelcgiegibgio424kyldimvtkiampoopolpydtioalcptwf20tgbylotpu010bdjbdusixsiddjputcuqyval.kzxtgxtkhommdmydoblaya.jcfagojua494ittlegjcvfjfagnaggdjqukkrd1juhck_cbkcbxunndrussilawktqterdsonicxymhbwhtw.19zazetscc1ccblivliplizhbxvytutzfdxbyrartzygzykfnbrqutyrflzstafqcpapabbfkvokittyqrjlfpudliopfy.fyxfyypidpizpipeptravoctjyccnbcnhtigdkjple994992038030ign060andnbyizalacriszzywnscfddxbybx993lvi */
class RegistrationUtil$5 implements FutureCallback<DeviceOwnerData> {
    final /* synthetic */ SettableFuture f8945a;
    final /* synthetic */ RegistrationUtil f8946b;

    RegistrationUtil$5(RegistrationUtil registrationUtil, SettableFuture settableFuture) {
        this.f8946b = registrationUtil;
        this.f8945a = settableFuture;
    }

    public void onSuccess(@Nullable Object obj) {
        DeviceOwnerData deviceOwnerData = (DeviceOwnerData) obj;
        if (deviceOwnerData != null) {
            this.f8946b.d.a(deviceOwnerData);
        }
        FutureDetour.a(this.f8945a, null, 442728708);
    }

    public void onFailure(Throwable th) {
        FutureDetour.a(this.f8945a, null, -257733293);
    }
}

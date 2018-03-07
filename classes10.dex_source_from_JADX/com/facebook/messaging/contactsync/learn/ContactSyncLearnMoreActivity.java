package com.facebook.messaging.contactsync.learn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.webview.FacebookWebView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tak272273dnidnjzajfiq9wxfie628zac391sypkfxkfgnzavgkldeirkirafrin_1hahhanhadcalmbaaz1azmazaazdazeazsjmwossostosmjir794793792onkeoron-on3on6on7on4on5rzhzonzorytd83683783883983jyz3yzryzyfijyzcjswtvfbjvbjpjjppycram_chgfygfwgfcbycdfqdfsdfhdf4df2316evovodvoivojknua_1a_sa_ba_ma_lfzgfz2gwaebo595pfcpfyxcgmjfmjmmjjfcx-12jaxjavjasu81zguofiofxweaweljzgjzvbrybreer4er8er9er.ervergernmpde12pqremoemiemy7vfgniminbrfvwgkvvfkx438439437fbcfbfibiibaibqibuxdvnof517mrbinecfx605604607603602609608astpur741cedcecrwicelwyz88jbzvbzgbzkv12ymxstostustr4q5007eesdvvlkolkegzndctgzhewcurtursurynglngkavlng6ng7kenkeikevketdjwxsxausmedmelmerjpd684686wuvwufwukwuljjwjjmjjbjhwf55rzy808806805yelyeryev?n?4ik08.376yjzfecrunrudbozbosyqi201y32fdukjkujkkmgvhf485483482yzgfww.mahfbpcjbxm3vffvsjbcjbhl12qyjtvxtvtzhz092k47chach194j948946bjcquqhemsfi282ryj7ujubmnwakuukupkujkuhy.nimo402409408nhounipkf547549muht12e77ahaahmictrofrogrox.09sh2121yuyjwwjwhgiatkafyrlumn12yhoyhyyhuehjothllzsub.00suxzy5y00gpujeezyrie_iewuptixtc.ihkfapsyjgrfpounouswhodmajorcxw735736738f66qevqez629059jwmalvsmcdsa87q253251dhjina6wwvejve4ve2ve1iptfpwfpzfzvfzk.cofzffzdax1axtg12axaxmaxmxcfkwpo953mytacyl6685m85jyxoulytrcbhxqpqex2102sevsem407x66sxrsxzy66le1uezlehlejlek335337ary78qbatkpumjgfxs573574xecxejfouhpwmcdalfaldakkakoakazejzenzelwgwwgsypocorcouth1opd2c3ykaykoykudbogygww4ww8ekmsprdxpdxdghwghdghlgbclmolmakxpvuzvufvuvvuwuxhuccucik_ipeezgbjhkky3jhsypugpwox3oxeyphjpmjpcruzrtiyczflfnygeccw1qjzhitybekbenbetzny12q12.dpwfgxlutnyxcdc263264018ilbfhkupdupcfhtnecnezne1vf2vf1vfxmxpmxfxuvxusxuziskisliscrscxjyopewwqwwjww3zuvzuwzuuk12er!nkftnjoogooloohrre4rfznf828fqv929926927tubmjwpjfpjcjvpqsdhdjy12mvpderdejdeadebdeced1bdxikafulmoumooaprs12xbkxbcduqafiafesicsiasiecwxrehreiremrecog1ogmogiogdzfyzfuyszcjncjbcjpcjq324bujbuh965en_encenvnycgoggotgo1lbqlbflbjlbonugkwakwhkwovv1vvsvvkt69whaica429arszuynnoridjdpdespmzpme527del528d77xz1xzsobyxzclmehubhuyan_an-an1an2cxvwbfwbj2x3judrvacbytepww2fkkariuqeyna86jeftefoefaefebfkbfvathdumdubdxfufqfbkfbhkdo143groranfehus7us2kbnnfonfvva2avravamy1kydxtwjmkczvczcywjewbqkfqktjlyyf7yf8648yfptxtsolx00ats23adjzukavkzjqyfvzfvply1heuhefhehrylpbyxotxopxozxofjezjekojacrbcrizkjzkfophgjqget4liodiqvbevasgusgogcbry1x33y4ulgu354352359fdzvsqvsxvsjlfi47q473res478cwwyinnk1nkonksbagpjkpjypjxmvfvxbwzskzbsqvrnirnazcvzcyobimdjwaqk88cascupuvsuvvitfgbngboeiggbkff3gbwgjpgjfgjcgbqloglo1ysoysxkzrkzykzdkzhkzndtxff6nchkakkawkaz=09hjqkajes_syasykycjsymozz643642647649pfxvkojnv708704706703jdvrsocynvymuzfpikpic988easear10.241gyhgyx6vfkirkipkimkidretxwe8zxhbfaytaysmatorrorswq1k33en1umfoidzlozlz84j848yyjzpmm77uds909dymtwjh12fedsh1sbosblfeb_an_bagdispogazgaildm303z55jgd44944344658q586584583xdwxdrshm2e3wywwypwyxwycadyadgado532rch705zdzzdbwdxyqoyqecleto_qybjyvjywywbjymywhj12urallwlle428420427kykky2ky4gtkvtuia.uyefcmnlipotpos508509506507504502503vyswykal_rkwrkloyawliwlertzbhybhz89j891ylfylemsoexsedghyvyjtdwjsil138ltzltya.aviea.ma.k281283ndondexaqndsvadmyx.kbxtxxteurvhowdbnateatlatixiaxicxioxiswtd300jkdjkgjkccdx304ss1dy3dzhdzpz33dylssa938dybblesansavsaux20x2cx2zsxqamea66agifbvvisftyftxodsvydhghgywrdc339jctjcpageagaaguodddjtctxziwziqzilexo5qwm207573wjck6ck0cklh66etz386zyheopzyv294farlanlahfanntsntintogdgkth416418ilsincniynisnit8wwck2533plzxyvxyhyamxy2htchtxcyxrlo627xnjza1wcuhijjtwytuxvjbsoccxccfxvbyotegregiegolymctrstnlielioxey_lijj2my2vypvyvvywvyxvycvykvyhidzidsidautjnaknapna-na2kcuvbwhichinsnasnimakmajarvndaarbpy2py6pyxawypyhawdwkdwkwzy6zy7zy3182zytduh729f77037nukqdw06.ty1tybnkltyp67qbybbars69zai162glafkd_daljda19dicflhulgny2kkffjjvjtvjklasfqjfqhavoparmorhymhyqhyxwszablntkjdmrykrygrycoksoku86mqlfrrrktc962ewltqvqw1biebizfellyslydlybrdsly2x755vvdamlfmmislf1mit325ksqkszksafcvj4yvro463njanjvpixpity22vcjqipxfixfkxfnxfgdior12nigpdoszpigtrtlwfhwfdwfwesbbpbjyrjygywajyhtifticbqgbqcbq2nekpypxy7dy5dy7dyk_sevzfvzrgvvuzjuzyankiqyizeizkyded20htd3d4ssmarzargrizripe66zztirjwnxjqljqv_bejkytafqgt1.1990ualzvbskuskvtayt20blj */
public class ContactSyncLearnMoreActivity extends FbFragmentActivity {
    @Inject
    FbActionBarUtil f2068p;
    @Inject
    Provider<AppCompatActivityOverrider> f2069q;
    @Inject
    @ForContactsLearnMore
    Provider<Uri> f2070r;
    @Inject
    SecureWebViewHelper f2071s;
    @Inject
    AbstractFbErrorReporter f2072t;
    public EmptyListViewItem f2073u;
    public FacebookWebView f2074v;
    private boolean f2075w;

    /* compiled from: tak272273dnidnjzajfiq9wxfie628zac391sypkfxkfgnzavgkldeirkirafrin_1hahhanhadcalmbaaz1azmazaazdazeazsjmwossostosmjir794793792onkeoron-on3on6on7on4on5rzhzonzorytd83683783883983jyz3yzryzyfijyzcjswtvfbjvbjpjjppycram_chgfygfwgfcbycdfqdfsdfhdf4df2316evovodvoivojknua_1a_sa_ba_ma_lfzgfz2gwaebo595pfcpfyxcgmjfmjmmjjfcx-12jaxjavjasu81zguofiofxweaweljzgjzvbrybreer4er8er9er.ervergernmpde12pqremoemiemy7vfgniminbrfvwgkvvfkx438439437fbcfbfibiibaibqibuxdvnof517mrbinecfx605604607603602609608astpur741cedcecrwicelwyz88jbzvbzgbzkv12ymxstostustr4q5007eesdvvlkolkegzndctgzhewcurtursurynglngkavlng6ng7kenkeikevketdjwxsxausmedmelmerjpd684686wuvwufwukwuljjwjjmjjbjhwf55rzy808806805yelyeryev?n?4ik08.376yjzfecrunrudbozbosyqi201y32fdukjkujkkmgvhf485483482yzgfww.mahfbpcjbxm3vffvsjbcjbhl12qyjtvxtvtzhz092k47chach194j948946bjcquqhemsfi282ryj7ujubmnwakuukupkujkuhy.nimo402409408nhounipkf547549muht12e77ahaahmictrofrogrox.09sh2121yuyjwwjwhgiatkafyrlumn12yhoyhyyhuehjothllzsub.00suxzy5y00gpujeezyrie_iewuptixtc.ihkfapsyjgrfpounouswhodmajorcxw735736738f66qevqez629059jwmalvsmcdsa87q253251dhjina6wwvejve4ve2ve1iptfpwfpzfzvfzk.cofzffzdax1axtg12axaxmaxmxcfkwpo953mytacyl6685m85jyxoulytrcbhxqpqex2102sevsem407x66sxrsxzy66le1uezlehlejlek335337ary78qbatkpumjgfxs573574xecxejfouhpwmcdalfaldakkakoakazejzenzelwgwwgsypocorcouth1opd2c3ykaykoykudbogygww4ww8ekmsprdxpdxdghwghdghlgbclmolmakxpvuzvufvuvvuwuxhuccucik_ipeezgbjhkky3jhsypugpwox3oxeyphjpmjpcruzrtiyczflfnygeccw1qjzhitybekbenbetzny12q12.dpwfgxlutnyxcdc263264018ilbfhkupdupcfhtnecnezne1vf2vf1vfxmxpmxfxuvxusxuziskisliscrscxjyopewwqwwjww3zuvzuwzuuk12er!nkftnjoogooloohrre4rfznf828fqv929926927tubmjwpjfpjcjvpqsdhdjy12mvpderdejdeadebdeced1bdxikafulmoumooaprs12xbkxbcduqafiafesicsiasiecwxrehreiremrecog1ogmogiogdzfyzfuyszcjncjbcjpcjq324bujbuh965en_encenvnycgoggotgo1lbqlbflbjlbonugkwakwhkwovv1vvsvvkt69whaica429arszuynnoridjdpdespmzpme527del528d77xz1xzsobyxzclmehubhuyan_an-an1an2cxvwbfwbj2x3judrvacbytepww2fkkariuqeyna86jeftefoefaefebfkbfvathdumdubdxfufqfbkfbhkdo143groranfehus7us2kbnnfonfvva2avravamy1kydxtwjmkczvczcywjewbqkfqktjlyyf7yf8648yfptxtsolx00ats23adjzukavkzjqyfvzfvply1heuhefhehrylpbyxotxopxozxofjezjekojacrbcrizkjzkfophgjqget4liodiqvbevasgusgogcbry1x33y4ulgu354352359fdzvsqvsxvsjlfi47q473res478cwwyinnk1nkonksbagpjkpjypjxmvfvxbwzskzbsqvrnirnazcvzcyobimdjwaqk88cascupuvsuvvitfgbngboeiggbkff3gbwgjpgjfgjcgbqloglo1ysoysxkzrkzykzdkzhkzndtxff6nchkakkawkaz=09hjqkajes_syasykycjsymozz643642647649pfxvkojnv708704706703jdvrsocynvymuzfpikpic988easear10.241gyhgyx6vfkirkipkimkidretxwe8zxhbfaytaysmatorrorswq1k33en1umfoidzlozlz84j848yyjzpmm77uds909dymtwjh12fedsh1sbosblfeb_an_bagdispogazgaildm303z55jgd44944344658q586584583xdwxdrshm2e3wywwypwyxwycadyadgado532rch705zdzzdbwdxyqoyqecleto_qybjyvjywywbjymywhj12urallwlle428420427kykky2ky4gtkvtuia.uyefcmnlipotpos508509506507504502503vyswykal_rkwrkloyawliwlertzbhybhz89j891ylfylemsoexsedghyvyjtdwjsil138ltzltya.aviea.ma.k281283ndondexaqndsvadmyx.kbxtxxteurvhowdbnateatlatixiaxicxioxiswtd300jkdjkgjkccdx304ss1dy3dzhdzpz33dylssa938dybblesansavsaux20x2cx2zsxqamea66agifbvvisftyftxodsvydhghgywrdc339jctjcpageagaaguodddjtctxziwziqzilexo5qwm207573wjck6ck0cklh66etz386zyheopzyv294farlanlahfanntsntintogdgkth416418ilsincniynisnit8wwck2533plzxyvxyhyamxy2htchtxcyxrlo627xnjza1wcuhijjtwytuxvjbsoccxccfxvbyotegregiegolymctrstnlielioxey_lijj2my2vypvyvvywvyxvycvykvyhidzidsidautjnaknapna-na2kcuvbwhichinsnasnimakmajarvndaarbpy2py6pyxawypyhawdwkdwkwzy6zy7zy3182zytduh729f77037nukqdw06.ty1tybnkltyp67qbybbars69zai162glafkd_daljda19dicflhulgny2kkffjjvjtvjklasfqjfqhavoparmorhymhyqhyxwszablntkjdmrykrygrycoksoku86mqlfrrrktc962ewltqvqw1biebizfellyslydlybrdsly2x755vvdamlfmmislf1mit325ksqkszksafcvj4yvro463njanjvpixpity22vcjqipxfixfkxfnxfgdior12nigpdoszpigtrtlwfhwfdwfwesbbpbjyrjygywajyhtifticbqgbqcbq2nekpypxy7dy5dy7dyk_sevzfvzrgvvuzjuzyankiqyizeizkyded20htd3d4ssmarzargrizripe66zztirjwnxjqljqv_bejkytafqgt1.1990ualzvbskuskvtayt20blj */
    class C03471 extends WebViewClient {
        final /* synthetic */ ContactSyncLearnMoreActivity f2067a;

        C03471(ContactSyncLearnMoreActivity contactSyncLearnMoreActivity) {
            this.f2067a = contactSyncLearnMoreActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            this.f2067a.f2074v.setVisibility(0);
            this.f2067a.f2073u.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f2067a.f2072t.a("contact_sync_web_view_received_error", StringFormatUtil.a("errorCode=%d description=%s failingUrl=%s", new Object[]{Integer.valueOf(i), str, str2}));
            webView.setVisibility(8);
            this.f2067a.finish();
        }
    }

    private static <T extends Context> void m1889a(Class<T> cls, T t) {
        m1890a((Object) t, (Context) t);
    }

    public static void m1890a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactSyncLearnMoreActivity) obj).m1888a(FbActionBarUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 4577), IdBasedProvider.a(fbInjector, 39), SecureWebViewHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    private void m1888a(FbActionBarUtil fbActionBarUtil, Provider<AppCompatActivityOverrider> provider, Provider<Uri> provider2, SecureWebViewHelper secureWebViewHelper, FbErrorReporter fbErrorReporter) {
        this.f2068p = fbActionBarUtil;
        this.f2069q = provider;
        this.f2070r = provider2;
        this.f2071s = secureWebViewHelper;
        this.f2072t = fbErrorReporter;
    }

    protected final void m1892a(Bundle bundle) {
        Class cls = ContactSyncLearnMoreActivity.class;
        m1890a((Object) this, (Context) this);
        this.f2075w = this.f2068p.a();
        if (this.f2075w) {
            a((AppCompatActivityOverrider) this.f2069q.get());
        }
    }

    protected final void m1893b(Bundle bundle) {
        super.b(bundle);
        if (!this.f2075w) {
            FbTitleBarUtil.b(this);
        }
        setContentView(2130903769);
        this.f2073u = (EmptyListViewItem) a(2131560715);
        this.f2073u.a(true);
        this.f2073u.setMessage(2131230739);
        this.f2074v = (FacebookWebView) a(2131560714);
        this.f2074v.setFocusableInTouchMode(true);
        this.f2074v.setWebViewClient(new C03471(this));
        this.f2071s.a(this.f2074v, ((Uri) this.f2070r.get()).toString());
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2074v != null) {
            this.f2074v.saveState(bundle);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f2074v != null) {
            this.f2074v.restoreState(bundle);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}

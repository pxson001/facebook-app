package com.facebook.hashtag.parser;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: mNamespace */
class HyperlinkParserConstants {
    static final String f11005a = StringFormatUtil.a("(?:%s)(?:(?=%s)(?:%s|%s|%s|%s)*(?:%s|[\\/_]|%s))?", new Object[]{f11012h, "[\\/#?]", "[\\[\\({][^\\s()<>{}]*[}\\)\\]]", "[.!?:@&\\-\\/_#*%']", "[^\\^|<>{}\\n\\r\\t\\p{P}\\p{Zs}]", f11013i, "[\\[\\({][^\\s()<>{}]*[}\\)\\]]", "[^\\^|<>{}\\n\\r\\t\\p{P}\\p{Zs}]"});
    private static final String f11006b = StringFormatUtil.a("(?:com|%s)", new Object[]{"\\uD55C\\uAD6D|\\uD14C\\uC2A4\\uD2B8|\\u9999\\u6E2F|\\u6E2C\\u8A66|\\u6D4B\\u8BD5|\\u65B0\\u52A0\\u5761|\\u53F0\\u7063|\\u53F0\\u6E7E|\\u4E2D\\u570B|\\u4E2D\\u56FD|\\u30C6\\u30B9\\u30C8|\\u0E44\\u0E17\\u0E22|\\u0DBD\\u0D82\\u0D9A\\u0DCF|\\u0C2D\\u0C3E\\u0C30\\u0C24\\u0C4D|\\u0BAA\\u0BB0\\u0BBF\\u0B9F\\u0BCD\\u0B9A\\u0BC8|\\u0B9A\\u0BBF\\u0B99\\u0BCD\\u0B95\\u0BAA\\u0BCD\\u0BAA\\u0BC2\\u0BB0\\u0BCD|\\u0B87\\u0BB2\\u0B99\\u0BCD\\u0B95\\u0BC8|\\u0B87\\u0BA8\\u0BCD\\u0BA4\\u0BBF\\u0BAF\\u0BBE|\\u0AAD\\u0ABE\\u0AB0\\u0AA4|\\u0A2D\\u0A3E\\u0A30\\u0A24|\\u09AD\\u09BE\\u09B0\\u09A4|\\u092D\\u093E\\u0930\\u0924|\\u092A\\u0930\\u0940\\u0915\\u094D\\u0937\\u093E|\\u0645\\u0644\\u064A\\u0633\\u064A\\u0627|\\u0645\\u0635\\u0631|\\u0642\\u0637\\u0631|\\u0641\\u0644\\u0633\\u0637\\u064A\\u0646|\\u0639\\u0645\\u0627\\u0646|\\u0633\\u0648\\u0631\\u064A\\u0629|\\u062A\\u0648\\u0646\\u0633|\\u0628\\u06BE\\u0627\\u0631\\u062A|\\u0627\\u0645\\u0627\\u0631\\u0627\\u062A|\\u0627\\u0644\\u0645\\u063A\\u0631\\u0628|\\u0627\\u0644\\u0633\\u0639\\u0648\\u062F\\u064A\\u0629|\\u0627\\u0644\\u062C\\u0632\\u0627\\u0626\\u0631|\\u0627\\u0644\\u0627\\u0631\\u062F\\u0646|\\u0625\\u062E\\u062A\\u0628\\u0627\\u0631|\\u0622\\u0632\\u0645\\u0627\\u06CC\\u0634\\u06CC|\\u05D8\\u05E2\\u05E1\\u05D8|\\u049B\\u0430\\u0437|\\u0443\\u043A\\u0440|\\u0441\\u0440\\u0431|\\u0440\\u0444|\\u0438\\u0441\\u043F\\u044B\\u0442\\u0430\\u043D\\u0438\\u0435|\\u03B4\\u03BF\\u03BA\\u03B9\\u03BC\\u03AE|zw|zm|za|yt|ye|xxx|xn--zckzah|xn--ygbi2ammx|xn--yfro4i67o|xn--xkc2dl3a5ee0h|xn--xkc2al3hye2a|xn--wgbl6a|xn--wgbh1c|xn--s9brj9c|xn--pgbs0dh|xn--p1ai|xn--ogbpf8fl|xn--o3cw4h|xn--mgbx4cd0ab|xn--mgberp4a5d4ar|xn--mgbc0a9azcg|xn--mgbbh1a71e|xn--mgbayh7gpa|xn--mgbaam7a8h|xn--mgb9awbf|xn--lgbbat1ad8j|xn--kpry57d|xn--kprw13d|xn--kgbechtv|xn--jxalpdlp|xn--j6w193g|xn--j1amh|xn--hlcj6aya9esc7a|xn--hgbk6aj7f53bba|xn--h2brj9c|xn--gecrj9c|xn--g6w251d|xn--fzc2c9e2c|xn--fpcrj9c3d|xn--fiqz9s|xn--fiqs8s|xn--deba0ad|xn--clchc0ea0b2g2a9gcd|xn--9t4b11yi5a|xn--90a3ac|xn--80ao21a|xn--80akhbyknj4f|xn--45brj9c|xn--3e0b707e|xn--11b5bs3a9aj6g|xn--0zwm56d|ws|wf|vu|vn|vi|vg|ve|vc|va|uz|uy|us|uk|ug|ua|tz|tw|tv|tt|travel|tr|tp|to|tn|tm|tl|tk|tj|th|tg|tf|tel|td|tc|sz|sy|sx|sv|su|st|sr|so|sn|sm|sl|sk|sj|si|sh|sg|se|sd|sc|sb|sa|rw|ru|rs|ro|re|qa|py|pw|pt|ps|pro|pr|post|pn|pm|pl|pk|ph|pg|pf|pe|pa|org|om|nz|nu|nr|np|no|nl|ni|ng|nf|net|ne|nc|name|na|mz|my|mx|mw|mv|museum|mu|mt|ms|mr|mq|mp|mobi|mo|mn|mm|ml|mk|mil|mh|mg|me|md|mc|ma|ly|lv|lu|lt|ls|lr|lk|li|lc|lb|la|kz|ky|kw|kr|kp|kn|km|ki|kh|kg|ke|jp|jobs|jo|jm|je|it|is|ir|iq|io|int|info|in|im|il|ie|id|hu|ht|hr|hn|hm|hk|gy|gw|gu|gt|gs|gr|gq|gp|gov|gn|gm|gl|gi|gh|gg|gf|ge|gd|gb|ga|fr|fo|fm|fk|fj|fi|eu|et|es|er|eg|ee|edu|ec|dz|do|dm|dk|dj|de|cz|cy|cx|cw|cv|cu|cr|coop|com|co|cn|cm|cl|ck|ci|ch|cg|cf|cd|cc|cat|ca|bz|by|bw|bv|bt|bs|br|bo|bn|bm|bj|biz|bi|bh|bg|bf|be|bd|bb|ba|az|ax|aw|au|at|asia|as|arpa|ar|aq|ao|an|am|al|ai|ag|af|aero|ae|ad|ac"});
    private static final String f11007c = StringFormatUtil.a("\\[(?>[\\da-f]{0,4}:){2,7}(?:[\\da-f]{0,4}|%s)?\\]", new Object[]{"(?:(?:\\d{1,3}\\.){3}\\d{1,3})"});
    private static final String f11008d = StringFormatUtil.a("(?:(?:(%s|%s)%s)|(?:%s%s%s)%s)", new Object[]{"(?:(?:\\d{1,3}\\.){3}\\d{1,3})", f11007c, "(?!\\.?(?:[\\p{L}\\p{N}]))", "(?:[a-z0-9\\p{L}\\p{N}][\\w\\-\\p{L}\\p{N}]*\\.)+", f11006b, "(?!\\.?(?:[\\p{L}\\p{N}]))", "(?::\\d+)?"});
    private static final String f11009e = StringFormatUtil.a("(?:%s|%s)", new Object[]{"(?:(?:(?:ht|f)tps?):\\/\\/)", "(?:(?:(?:ht|f)tps?)%3A%2F%2F)"});
    private static final String f11010f = StringFormatUtil.a("(?:[:\\-_]|%s)", new Object[]{"[^\\^|<>{}\\n\\r\\t\\p{P}\\p{Zs}]"});
    private static final String f11011g = StringFormatUtil.a("(?:(?:%s*\\.)+%s*%s)", new Object[]{f11010f, f11010f, "[^\\^|<>{}\\n\\r\\t\\p{P}\\p{Zs}]"});
    private static final String f11012h = StringFormatUtil.a("(?:(?:%s(?:%s|%s))|(?:%s))", new Object[]{f11009e, f11011g, f11007c, f11008d});
    private static final String f11013i = StringFormatUtil.a("[,;](?!%s)", new Object[]{f11009e});

    HyperlinkParserConstants() {
    }
}

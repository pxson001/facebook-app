package com.facebook.placetips.pulsarcore.parsing;

import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: The Drawer cannot have more than two children */
public class BLEBroadcastParserProvider extends AbstractAssistedProvider<BLEBroadcastParser> {
    public final BLEBroadcastParser m11262a(String str) {
        return new BLEBroadcastParser(new BluetoothAdRecordParser(), (PulsarPacketParserProvider) getOnDemandAssistedProviderForStaticDi(PulsarPacketParserProvider.class), new FBLEParser(), str);
    }
}

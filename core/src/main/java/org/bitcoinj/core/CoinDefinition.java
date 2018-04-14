package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Rapture";
    public static final String coinTicker = "RAP";
    public static final String coinURIScheme = "rapture";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.our-rapture.com/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://explorer.our-rapture.com/";

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11,
        neoscrypt
    };
    public static final CoinHash coinPOWHash = CoinHash.neoscrypt;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(7 * 60);  // 7 minutes.
    public static final int TARGET_SPACING = (int)(2 * 60);  // 2 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
        return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
        return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
        return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 50; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 21000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Dash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70209;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70209;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 14777;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 24777;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 60;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 16;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xd0e5c1a2;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1515264224L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (143483);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000007beab6b60ea39b8c553dcae06ffa5e4b57077df2c5ca1debe807e2d0017"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "98ddace479db5bd06ea9aea6ed6d309d2081bd39c2260aa57692ca5553e08605";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d0104374242432030352f4a616e2f32303138205553207368697665727320696e207265636f726420627265616b696e6720636f6c6420736e6170";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "04d9c8097bd4bc2b0a688931e273d0b74b4531571e94d04997ba899f492c7a2d8ff39dfa20dabd47ae92bcfe204507839c3f9e7aedfa00a39dc0b3dab61155d04a";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.our-rapture.com"
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xb4c7c3e2;      //
    public static final String testnetGenesisHash = "00000d504c2b5622c6c3a1c0c3321fe58b6c79a442f5e7143ee0c0e5903cda3f";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1520011772L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (2368382L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 262800;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "dnsseed.our-rapture.com"

    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0495ab78094514754fe24c81c5165b5e396ec6e40744d7926833a3007420fb0c4b5c7f7a8d036a9d11d8bf177ad73dae7610280fdfdff2fd1b037cb58694643e23";
    public static final String TESTNET_SATOSHI_KEY = "04adcf8883632da1ca6b4a466e579dd86ad1125e8c1f68ca9a99ec4e27ea99987d056086b2fae41e78c6cfa314be15cb6667acc8f958b6c66708e9a1c5bb4e849a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  0, Sha256Hash.wrap("000007beab6b60ea39b8c553dcae06ffa5e4b57077df2c5ca1debe807e2d0017"));
        checkpoints.put(  20, Sha256Hash.wrap("0000076d46c6ae49bd74816a2abda2ff837b0e39098f713decb03e64576e6001"));
        checkpoints.put(  23490, Sha256Hash.wrap("00000000005bc39c38d96ae607faf5fc691832ac6b20c61c72e3ff4cddfafd6f"));


    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "RQYLR8aQxuvLD1dYzpm1dT7ETgLqz6eP4D";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "7rGobpydN2JEsiczvpAvtMVysdrs9AckSZZEc2WCHintnbbXYZv";

}

package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.1.5.
 */
public class SimpleStorage extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001530f60017f017f60000060017f0060027f7f0060037f7f7f0060047f7f7f7f0060027f7f017f60037f7f7f017f60047f7f7f7f017f60017f017e60027f7e0060037e7e7f006000017f60017e017f60027e7e017f02fd010b03656e760c706c61746f6e5f70616e6963000103656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000403656e760d726c705f753132385f73697a65000e03656e760f706c61746f6e5f726c705f75313238000b03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000503656e760d706c61746f6e5f72657475726e0003031e1d0101000704090902000200000d030a01080200000307030603010000050405017001010105030100020608017f0141b088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000b0f5f5f66756e63735f6f6e5f65786974001a06696e766f6b65000c0a81241d040010240b940202047f017e230041d0006b22012400102410052200100d22021006200141386a200141086a20022000100e22004100100f02400240200141386a10102204500d004180081011200451044020001012200141386a101310140c020b4185081011200451044020001015410247044010000b200141386a20004101100f200141386a10102104200141386a1013210020012004370348200010140c020b41890810112004520d0020001012200141206a1013210220012903302104200141386a10162200200410171018200020041019200028020c200041106a28020047044010000b20002802002000280204100a200028020c22030440200020033602100b200210140c010b10000b101a200141d0006a24000b9b0101047f230041106b220124002001200036020c2000047f41a408200041086a2202411076220041a4082802006a220336020041a00841a008280200220420026a41076a417871220236020002400240200341107420024d044041a408200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104102041086a0541000b2100200141106a240020000b0c00200020012002411c101b0bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001102120012003280208200328020c102236020c200320011021410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b2000200628020020044114101b1a200341106a24000f0b20032001102141002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004102210272001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000bad0302057f017e2000101c024002402000280204450d002000101c0240200028020022012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220341b7014d0440200028020441014d04401000200028020021010b20012d00010d010c020b200341bf014b0d012000280204200241ff017141ca7e6a22024d04401000200028020021010b200120026a2d0000450d010b2000280204450d0020012d000041c001490d010b10000b2000101d2204200028020422014b04401000200028020421010b20002802002105024002400240200104404100210320052c00002200417f4a0d01027f200041ff0171220341bf014d04404100200041ff017141b801490d011a200341c97e6a0c010b4100200041ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320050d00410021000c010b41002100200320046a20014b0d0020012004490d004100210220012003490d01200320056a2102200120036b20042004417f461b22004109490d0110000c010b410021020b0340200004402000417f6a210020023100002006420886842106200241016a21020c010b0b20060b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e0020001015410147044010000b0bda0101077f230041306b22052400200042d1f0fad48ae09ad34537030820004200370300200541186a1016220220002903081019200228020c200241106a28020047044010000b02400240200228020022062002280204220710072204450d002004101e21030340200120036a41003a00002004200141016a2201470d000b20062007200320011008417f460d0020002005200341016a200120036a2003417f736a100e10103703100c010b410021040b200228020c22010440200220013602100b2004450440200020002903003703100b200541306a240020000bb40201097f230041306b22032400200341186a10162202200029030810171018200220002903081019200228020c200241106a28020047044010000b20022802042105200228020021062003101621012000290310101721074101101e220441fe013a0000200128020c200141106a28020047044010000b2001280204220841016a220920012802084b047f20012009101f20012802040520080b20012802006a2004410110201a2001200128020441016a3602042001200441016a200720046b6a10182001200029031010190240200128020c2001280210460440200128020021000c010b100020012802002100200128020c2001280210460d0010000b20062005200020012802041009200128020c22000440200120003602100b200228020c22010440200220013602100b200341306a24000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a20001021200128020c210003402000450d01200141002001280208220320032000102222046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b2900200041003602082000420037020020004100101f200041146a41003602002000420037020c20000b7002027f017e4101210120004280015a047f41002101034020002003845045044020034238862000420888842100200141016a2101200342088821030c010b0b024020014138490d002001210203402002450d01200141016a2101200241087621020c000b000b200141016a0520010b0b13002000280208200149044020002001101f0b0b9a0101037f2000420020011003200028020422026a102342002001200220002802006a10040340024020002802102202200028020c460d00200241786a2802004504401000200028021021020b200241786a22032003280200417f6a220436020020040d002000200336021020002002417c6a2802002202200028020420026b220310016a1023200220002802006a22022003200210020c010b0b0b880101037f4190084101360200419408280200210003402000044003404198084198082802002201417f6a220236020020014101484504404190084100360200200020024102746a22004184016a280200200041046a280200110200419008410136020041940828020021000c010b0b4198084120360200419408200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000102520024f0d002003410471044010000c010b200042003702000b02402003411071450d002000102520024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101c41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b0b002000410120001b100d0b2f01017f200028020820014904402001100d200028020020002802041020210220002001360208200020023602000b0bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b2101017f2001101d220220012802044b044010000b2000200120011026200210270b2701017f230041206b22022400200241086a200020014114101b10252100200241206a240020000b3601017f200028020820014904402001100d200028020020002802041020210220002001360208200020023602000b200020013602040b3501017f230041106b220041b0880436020c419c08200028020c41076a417871220036020041a008200036020041a4083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010262000101d6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b1301004180080b0c696e69740073657400676574";

    public static String BINARY = BINARY_0;

    public static final String FUNC_SET = "set";

    public static final String FUNC_GET = "get";

    protected SimpleStorage(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected SimpleStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SimpleStorage.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SimpleStorage.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SimpleStorage.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(SimpleStorage.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> set(Uint64 input) {
        final WasmFunction function = new WasmFunction(FUNC_SET, Arrays.asList(input), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> set(Uint64 input, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SET, Arrays.asList(input), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint64> get() {
        final WasmFunction function = new WasmFunction(FUNC_GET, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new SimpleStorage(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new SimpleStorage(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
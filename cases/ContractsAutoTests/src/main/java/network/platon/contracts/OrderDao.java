package network.platon.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.3-SNAPSHOT.
 */
public class OrderDao extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50611659806100206000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630d95f613146100675780633b6cf550146100e457806342d9376714610174578063d83408fb14610256575b600080fd5b34801561007357600080fd5b506100ce600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506102e6565b6040518082815260200191505060405180910390f35b3480156100f057600080fd5b506100f9610e8c565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561013957808201518184015260208101905061011e565b50505050905090810190601f1680156101665780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561018057600080fd5b506101db600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610f2a565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561021b578082015181840152602081019050610200565b50505050905090810190601f1680156102485780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026257600080fd5b5061026b61103a565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102ab578082015181840152602081019050610290565b50505050905090810190601f1680156102d85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60006102f06113c8565b6102f86113c8565b606060006103046113e2565b61030d876110d8565b945061034d6040805190810160405280600181526020017f2d000000000000000000000000000000000000000000000000000000000000008152506110d8565b9350610362848661110690919063ffffffff16565b60405190808252806020026020018201604052801561039557816020015b60608152602001906001900390816103805790505b509250600091505b82518210156103e9576103c16103bc858761117d90919063ffffffff16565b611197565b83838151811015156103cf57fe5b90602001906020020181905250818060010192505061039d565b60018360008151811015156103fa57fe5b90602001906020020151908060018154018082558091505090600182039060005260206000200160009091929091909150908051906020019061043e929190611508565b505082600081518110151561044f57fe5b90602001906020020151816000018190525082600181518110151561047057fe5b90602001906020020151816020018190525082600281518110151561049157fe5b9060200190602002015181604001819052508260038151811015156104b257fe5b9060200190602002015181606001819052508260048151811015156104d357fe5b906020019060200201518160a001819052508260058151811015156104f457fe5b906020019060200201518160c0018190525082600681518110151561051557fe5b906020019060200201518160e0018190525082600781518110151561053657fe5b9060200190602002015181610100018190525082600881518110151561055857fe5b9060200190602002015181610120018190525082600981518110151561057a57fe5b9060200190602002015181610140018190525082600a81518110151561059c57fe5b9060200190602002015181610160018190525082600b8151811015156105be57fe5b9060200190602002015181610180018190525082600c8151811015156105e057fe5b90602001906020020151816101a0018190525082600d81518110151561060257fe5b90602001906020020151816101c0018190525082600e81518110151561062457fe5b90602001906020020151816101e0018190525082600f81518110151561064657fe5b9060200190602002015181610200018190525082601081518110151561066857fe5b9060200190602002015181610220018190525082601181518110151561068a57fe5b906020019060200201518161024001819052508260128151811015156106ac57fe5b906020019060200201518161026001819052508260138151811015156106ce57fe5b906020019060200201518161028001819052508260148151811015156106f057fe5b90602001906020020151816102a0018190525082601581518110151561071257fe5b90602001906020020151816102c0018190525082601681518110151561073457fe5b90602001906020020151816102e0018190525082601781518110151561075657fe5b9060200190602002015181610300018190525082601881518110151561077857fe5b9060200190602002015181610320018190525082601981518110151561079a57fe5b9060200190602002015181610340018190525082601a8151811015156107bc57fe5b9060200190602002015181610360018190525082601b8151811015156107de57fe5b9060200190602002015181610380018190525082601c81518110151561080057fe5b90602001906020020151816103a0018190525082601d81518110151561082257fe5b90602001906020020151816103c0018190525082601e81518110151561084457fe5b90602001906020020151816103e0018190525082601f81518110151561086657fe5b9060200190602002015181610400018190525082602081518110151561088857fe5b906020019060200201518161042001819052508260218151811015156108aa57fe5b906020019060200201518161044001819052508260228151811015156108cc57fe5b906020019060200201518161046001819052508260238151811015156108ee57fe5b9060200190602002015181610480018190525082602481518110151561091057fe5b90602001906020020151816104a0018190525082602581518110151561093257fe5b90602001906020020151816104c0018190525082602681518110151561095457fe5b90602001906020020151816104e0018190525080600082600001516040518082805190602001908083835b6020831015156109a4578051825260208201915060208101905060208303925061097f565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008201518160000190805190602001906109f3929190611588565b506020820151816001019080519060200190610a10929190611588565b506040820151816002019080519060200190610a2d929190611588565b506060820151816003019080519060200190610a4a929190611588565b506080820151816004019080519060200190610a67929190611588565b5060a0820151816005019080519060200190610a84929190611588565b5060c0820151816006019080519060200190610aa1929190611588565b5060e0820151816007019080519060200190610abe929190611588565b50610100820151816008019080519060200190610adc929190611588565b50610120820151816009019080519060200190610afa929190611588565b5061014082015181600a019080519060200190610b18929190611588565b5061016082015181600b019080519060200190610b36929190611588565b5061018082015181600c019080519060200190610b54929190611588565b506101a082015181600d019080519060200190610b72929190611588565b506101c082015181600e019080519060200190610b90929190611588565b506101e082015181600f019080519060200190610bae929190611588565b50610200820151816010019080519060200190610bcc929190611588565b50610220820151816011019080519060200190610bea929190611588565b50610240820151816012019080519060200190610c08929190611588565b50610260820151816013019080519060200190610c26929190611588565b50610280820151816014019080519060200190610c44929190611588565b506102a0820151816015019080519060200190610c62929190611588565b506102c0820151816016019080519060200190610c80929190611588565b506102e0820151816017019080519060200190610c9e929190611588565b50610300820151816018019080519060200190610cbc929190611588565b50610320820151816019019080519060200190610cda929190611588565b5061034082015181601a019080519060200190610cf8929190611588565b5061036082015181601b019080519060200190610d16929190611588565b5061038082015181601c019080519060200190610d34929190611588565b506103a082015181601d019080519060200190610d52929190611588565b506103c082015181601e019080519060200190610d70929190611588565b506103e082015181601f019080519060200190610d8e929190611588565b50610400820151816020019080519060200190610dac929190611588565b50610420820151816021019080519060200190610dca929190611588565b50610440820151816022019080519060200190610de8929190611588565b50610460820151816023019080519060200190610e06929190611588565b50610480820151816024019080519060200190610e24929190611588565b506104a0820151816025019080519060200190610e42929190611588565b506104c0820151816026019080519060200190610e60929190611588565b506104e0820151816027019080519060200190610e7e929190611588565b509050505050505050919050565b60038054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f225780601f10610ef757610100808354040283529160200191610f22565b820191906000526020600020905b815481529060010190602001808311610f0557829003601f168201915b505050505081565b60606000826040518082805190602001908083835b602083101515610f645780518252602082019150602081019050602083039250610f3f565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561102e5780601f106110035761010080835404028352916020019161102e565b820191906000526020600020905b81548152906001019060200180831161101157829003601f168201915b50505050509050919050565b60028054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110d05780601f106110a5576101008083540402835291602001916110d0565b820191906000526020600020905b8154815290600101906020018083116110b357829003601f168201915b505050505081565b6110e06113c8565b600060208301905060408051908101604052808451815260200182815250915050919050565b600080826000015161112a85600001518660200151866000015187602001516111f9565b0190505b836000015184602001510181111515611176578180600101925050826000015161116e8560200151830386600001510383866000015187602001516111f9565b01905061112e565b5092915050565b6111856113c8565b6111908383836112df565b5092915050565b606080600083600001516040519080825280601f01601f1916602001820160405280156111d35781602001602082028038833980820191505090505b5091506020820190506111ef818560200151866000015161137d565b8192505050919050565b60008060008060008060008060008b97508c8b1115156112c95760208b1115156112835760018b60200360080260020a03196001029550858a511694508a8d8d010393508588511692505b8460001916836000191614151561127b578388101515611268578c8c0198506112cf565b8780600101985050858851169250611244565b8798506112cf565b8a8a209150600096505b8a8d03871115156112c8578a882090508060001916826000191614156112b5578798506112cf565b600188019750868060010197505061128d565b5b8c8c0198505b5050505050505050949350505050565b6112e76113c8565b600061130585600001518660200151866000015187602001516111f9565b90508460200151836020018181525050846020015181038360000181815250508460000151856020015101811415611347576000856000018181525050611372565b8360000151836000015101856000018181510391508181525050836000015181018560200181815250505b829150509392505050565b60005b6020821015156113a55782518452602084019350602083019250602082039150611380565b6001826020036101000a0390508019835116818551168181178652505050505050565b604080519081016040528060008152602001600081525090565b61050060405190810160405280606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061154957805160ff1916838001178555611577565b82800160010185558215611577579182015b8281111561157657825182559160200191906001019061155b565b5b5090506115849190611608565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106115c957805160ff19168380011785556115f7565b828001600101855582156115f7579182015b828111156115f65782518255916020019190600101906115db565b5b5090506116049190611608565b5090565b61162a91905b8082111561162657600081600090555060010161160e565b5090565b905600a165627a7a72305820b5a78874cd426bd6c9828198eaf6f96e450c12a21c6fae75ac6b2bbd8407f17f0029";

    public static final String FUNC_INSERT_SECPLEDGEAPPLY = "insert_SecPledgeApply";

    public static final String FUNC_PART2 = "part2";

    public static final String FUNC_SELECT_SECPLEDGEAPPLY_BYID = "select_SecPledgeApply_byId";

    public static final String FUNC_PART1 = "part1";

    @Deprecated
    protected OrderDao(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected OrderDao(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected OrderDao(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected OrderDao(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> insert_SecPledgeApply(String param) {
        final Function function = new Function(
                FUNC_INSERT_SECPLEDGEAPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> part2() {
        final Function function = new Function(FUNC_PART2, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> select_SecPledgeApply_byId(String _id) {
        final Function function = new Function(FUNC_SELECT_SECPLEDGEAPPLY_BYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> part1() {
        final Function function = new Function(FUNC_PART1, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<OrderDao> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(OrderDao.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OrderDao> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OrderDao.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<OrderDao> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(OrderDao.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OrderDao> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OrderDao.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static OrderDao load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OrderDao(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static OrderDao load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OrderDao(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static OrderDao load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new OrderDao(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static OrderDao load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new OrderDao(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}

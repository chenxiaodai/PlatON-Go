package network.platon.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
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
 * <p>Generated with web3j version 0.9.1.0-SNAPSHOT.
 */
public class NewTargetCreateContract extends Contract {
    private static final String BINARY = "60806040526040516101043803806101048339818101604052602081101561002657600080fd5b810190808051906020019092919050505080600081905550346001819055505060b0806100546000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c80630c55699c146037578063aa8c217c146053575b600080fd5b603d606f565b6040518082815260200191505060405180910390f35b60596075565b6040518082815260200191505060405180910390f35b60005481565b6001548156fea265627a7a7231582047e73807c47b5fa28a1ea59da6fdf962f75168620d1c0008a7b94083e5e1b91364736f6c634300050d0032";

    public static final String FUNC_AMOUNT = "amount";

    public static final String FUNC_X = "x";

    @Deprecated
    protected NewTargetCreateContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NewTargetCreateContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NewTargetCreateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NewTargetCreateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NewTargetCreateContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialWeiValue, BigInteger _a) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_a)));
        return deployRemoteCall(NewTargetCreateContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<NewTargetCreateContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialWeiValue, BigInteger _a) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_a)));
        return deployRemoteCall(NewTargetCreateContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<NewTargetCreateContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger _a) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_a)));
        return deployRemoteCall(NewTargetCreateContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<NewTargetCreateContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger _a) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_a)));
        return deployRemoteCall(NewTargetCreateContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public RemoteCall<BigInteger> amount() {
        final Function function = new Function(FUNC_AMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> x() {
        final Function function = new Function(FUNC_X, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static NewTargetCreateContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewTargetCreateContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NewTargetCreateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewTargetCreateContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NewTargetCreateContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new NewTargetCreateContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NewTargetCreateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new NewTargetCreateContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
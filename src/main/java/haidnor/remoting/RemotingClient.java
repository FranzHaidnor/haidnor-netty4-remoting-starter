package haidnor.remoting;


import haidnor.remoting.core.NettyRequestProcessor;
import haidnor.remoting.protocol.RemotingCommand;

import java.util.concurrent.ExecutorService;

public interface RemotingClient extends RemotingService {

    RemotingCommand invokeSync(final RemotingCommand request);

    RemotingCommand invokeSync(final RemotingCommand request, final long timeoutMillis);

    void invokeAsync(final RemotingCommand request, final InvokeCallback invokeCallback);

    void invokeAsync(final RemotingCommand request, final long timeoutMillis, final InvokeCallback invokeCallback);

    void invokeOneway(final RemotingCommand request);

    void invokeOneway(final RemotingCommand request, final long timeoutMillis);

    void registerProcessor(final int requestCode, final NettyRequestProcessor processor, final ExecutorService executor);

    ExecutorService getCallbackExecutor();

    void setCallbackExecutor(final ExecutorService callbackExecutor);

    boolean isChannelWritable(final String addr);
}

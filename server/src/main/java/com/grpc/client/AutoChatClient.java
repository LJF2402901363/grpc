package com.grpc.client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AutoChatClient {
    private static final Logger logger = Logger.getLogger(AutoChatClient.class.getName());
    private final ManagedChannel channel;
    private final server.AutoChatGrpc.AutoChatBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public AutoChatClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    AutoChatClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = server.AutoChatGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public String sendQuestion(String question) {
        server.AutoChatRequest request = server.AutoChatRequest.newBuilder().setQuestion(question).build();
       server.AutoChatReply response;
       String responseStr = "";
        try {
            response = blockingStub.autoChat(request);
            responseStr = response.getResponse();
            logger.info("接收来自服务器的响应: " + responseStr);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }finally {
            return  responseStr;
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {

        // Access a service running on the local machine on port 50052
        AutoChatClient client = new AutoChatClient("121.4.41.89", 50052);
        try {
            String user = "world";
            // Use the arg as the name to greet if provided
            if (args.length > 0) {
                user = args[0];
            }
            int i = 0 ;
           while (true){
               client.sendQuestion(user+i++);
               Thread.sleep(1000);
           }
        } finally {
            client.shutdown();
        }
    }
}
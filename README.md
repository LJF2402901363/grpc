# JAVA和Python的远程调用

## 1.使用springboot项目搭建Java端

### 1.1pom.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.3</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.grpc</groupId>
    <artifactId>server</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>java_server</name>
    <description>JAVa的grpc端</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-netty-shaded</artifactId>
            <version>1.26.0</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-protobuf</artifactId>
            <version>1.26.0</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-stub</artifactId>
            <version>1.26.0</version>
        </dependency>
        <!--        lombok插件-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <extensions>
            <extension>
                <groupId>kr.motd.maven</groupId>
                <artifactId>os-maven-plugin</artifactId>
                <version>1.6.2</version>
            </extension>
        </extensions>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.xolstice.maven.plugins</groupId>
                <artifactId>protobuf-maven-plugin</artifactId>
                <version>0.6.1</version>
                <configuration>
                    <protocArtifact>com.google.protobuf:protoc:3.11.0:exe:${os.detected.classifier}</protocArtifact>
                    <pluginId>grpc-java</pluginId>
                    <pluginArtifact>io.grpc:protoc-gen-grpc-java:1.26.0:exe:${os.detected.classifier}</pluginArtifact>
                    <!--默认值-->
                    <protoSourceRoot>${project.basedir}/src/main/resources/proto</protoSourceRoot>
                    <outputDirectory>${project.basedir}/src/main/java/com/grpc/shiyun</outputDirectory>
                    <!--设置是否在生成java文件之前清空outputDirectory的文件，默认值为true，设置为false时也会覆盖同名文件-->
                    <clearOutputDirectory>true</clearOutputDirectory>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile</goal>
                            <goal>compile-custom</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>

```

![image-20210326195928580](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326195928580.png)

### 1.2书写proto文件autochat.proto

```protobuf
syntax = "proto3";

option java_multiple_files = true;
package shiyun;

// The greeting service definition.
service AutoChat {
  // Sends a greeting
  rpc autoChat (AutoChatRequest) returns (AutoChatReply) {}
}

// The request message containing the user's name.
message AutoChatRequest {
  string question = 1;
}

// The response message containing the greetings
message AutoChatReply {
  string response = 1;
}

```



### 1.3使用protobuf插件生成Java代码

首先点击compile命令生成代码，然后再点击compile-custom生成代码，分两次生成。

![image-20210326200136256](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326200136256.png)

![image-20210326200500587](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326200500587.png)

![image-20210326200538783](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326200538783.png)

## 2.使用Python生成代码

### 2.1安装protobuf

```bash
pip install grpcio
```

### 2.2使用 protoc 编译 proto 文件, 生成 python 语言的实现

```bash
# 安装 python 下的 protoc 编译器
pip install grpcio-tools
```

### 2.3编写autochat.proto文件（和Java的一致）

```
syntax = "proto3";
#在Python时候不需要这个选项
#option java_multiple_files = true;
package shiyun;

// The greeting service definition.
service AutoChat {
  // Sends a greeting
  rpc autoChat (AutoChatRequest) returns (AutoChatReply) {}
}

// The request message containing the user's name.
message AutoChatRequest {
  string question = 1;
}

// The response message containing the greetings
message AutoChatReply {
  string response = 1;
}

```

![image-20210326202315783](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326202315783.png)

### 2.4编译文件

```bash
# 编译 proto 文件
python -m grpc_tools.protoc --python_out=. --grpc_python_out=. -I. autochat.proto
```

**python -m grpc_tools.protoc**: python 下的 protoc 编译器通过 python 模块(module) 实现, 所以说这一步非常省心
**--python_out=.** : 编译生成处理 protobuf 相关的代码的路径, 这里生成到当前目录
**--grpc_python_out=.  : 编译生成处理 grpc 相关的代码的路径

**-I.  autochat.proto** : proto 文件的路径, 这里的 proto 文件在当前目录

![image-20210326202330946](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326202330946.png)

![image-20210326202439991](https://gitee.com/ljf2402901363/picgo-images/raw/master/typora/image-20210326202439991.png)

## 3.编写Java客户端代码

```Java
package com.grpc.client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import shiyun.AutoChatRequest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoChatClient {
    private static final Logger logger = Logger.getLogger(AutoChatClient.class.getName());

    private final ManagedChannel channel;
    private final shiyun.AutoChatGrpc.AutoChatBlockingStub blockingStub;

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
        blockingStub = shiyun.AutoChatGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public void sendQuestion(String question) {
        AutoChatRequest request = shiyun.AutoChatRequest.newBuilder().setQuestion(question).build();
        shiyun.AutoChatReply response;
        try {
            response = blockingStub.autoChat(request);
            logger.info("接收来自服务器的响应: " + response.getResponse());
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        // Access a service running on the local machine on port 50052
        AutoChatClient client = new AutoChatClient("localhost", 50052);
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
```

## 4.Python服务端代码

```java
from concurrent import futures
import time
import grpc

# 实现 proto 文件中定义的 AutoChatServicer
import autochat_pb2_grpc, autochat_pb2

_ONE_DAY_IN_SECONDS = 60 * 60 * 24


class AutoChatServer(autochat_pb2_grpc.AutoChatServicer):
    def autoChat(self, request, context):
        print("接收到客户端消息：" + request.question)
        return autochat_pb2.AutoChatReply(response= request.question)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    autochat_pb2_grpc.add_AutoChatServicer_to_server(AutoChatServer(), server)
    server.add_insecure_port('[::]:50052')
    print("启动服务器等待连接。。。。")
    server.start()
    try:
        while True:
            time.sleep(_ONE_DAY_IN_SECONDS)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
```


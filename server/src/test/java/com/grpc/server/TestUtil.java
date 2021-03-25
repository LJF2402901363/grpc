package com.grpc.server;

import org.junit.jupiter.api.Test;

/**
 * Classname:TestUtil
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2021-03-20 18:45
 * @Version: 1.0
 **/
public class TestUtil {
    @Test
    public void  testTestTest(){
//        ActionStatusEnum[] values = ActionStatusEnum.values();
//       for (ActionStatusEnum value : values) {
//           System.out.println(value.getCode());
//       }
        ActionStatusEnum actionStatusEnumByCode = ActionStatusEnum.getActionStatusEnumByCode(1);
        System.out.println(actionStatusEnumByCode.getMsg());
    }
}

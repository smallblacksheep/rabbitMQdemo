package com.yy.rabbitmqdemo.direct;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Consumer1.consumer();
        Consumer2.consumer();
        List<String> msgs = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        msgs.add("你说谁是小个子....");
        keys.add("insert");
        msgs.add("短剑重铸之日,骑士归来之时...");
        keys.add("info");
        msgs.add("扔掉这副臭皮囊,加入光荣的进化吧...");
        keys.add("update");
        msgs.add("魔法,在召唤我...");
        keys.add("delete");
        msgs.add("风之化身,听候您的差遣...");
        keys.add("select");
        msgs.add("我有两把枪,一把叫射,一把叫啊....");
        keys.add("select");
        msgs.add("你能把到我吗?召唤师....");
        keys.add("error");
        msgs.add("我又饿啦...曾经有个人.因为太饿,他把自己吃掉啦..");
        keys.add("select");
        msgs.add("你看见我的小熊了吗?提伯斯...");
        keys.add("select");
        msgs.add("提莫队长,正在送命...");
        keys.add("delete");
        msgs.add("this is 斯巴达....");
        keys.add("info");
        Productor.product(msgs,keys);
    }
}

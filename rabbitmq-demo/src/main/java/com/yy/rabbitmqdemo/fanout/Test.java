package com.yy.rabbitmqdemo.fanout;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Consumer1.consumer();
        Consumer2.consumer();
        List<String> list = new ArrayList<>();
        list.add("你说谁是小个子....");
        list.add("短剑重铸之日,骑士归来之时...");
        list.add("扔掉这副臭皮囊,加入光荣的进化吧...");
        list.add("魔法,在召唤我...");
        list.add("风之化身,听候您的差遣...");
        list.add("我有两把枪,一把叫射,一把叫啊....");
        list.add("你能把到我吗?召唤师....");
        list.add("我又饿啦...曾经有个人.因为太饿,他把自己吃掉啦..");
        list.add("你看见我的小熊了吗?提伯斯...");
        list.add("提莫队长,正在送命...");
        list.add("this is 斯巴达....");
        Productor.product(list);
    }
}

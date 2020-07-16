package com.yy.rabbitmqdemo.topic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Consumer1.consumer();
        Consumer2.consumer();
        List<String> msgs = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        msgs.add("你说谁是小个子....");
        keys.add("lanbo.hah.insert");
        msgs.add("短剑重铸之日,骑士归来之时...");
        keys.add("ruimomo.info.ruiwen");
        msgs.add("扔掉这副臭皮囊,加入光荣的进化吧...");
        keys.add("jixiexianqu.update.sanzhishou");
        msgs.add("魔法,在召唤我...");
        keys.add("xiaofa.delete");
        msgs.add("风之化身,听候您的差遣...");
        keys.add("select.fengnv.nvzhibo");
        msgs.add("我有两把枪,一把叫射,一把叫啊....");
        keys.add("nvqiang.select");
        msgs.add("你能把到我吗?召唤师....");
        keys.add("baonv.error");
        msgs.add("我又饿啦...曾经有个人.因为太饿,他把自己吃掉啦..");
        keys.add("dazui.select.shenyuanjukou");
        msgs.add("你看见我的小熊了吗?提伯斯...");
        keys.add("select.anni.xiaoxiong");
        msgs.add("提莫队长,正在送命...");
        keys.add("timo.delete.mogu");
        msgs.add("this is 斯巴达....");
        keys.add("waring.info.insert");
        Productor.product(msgs,keys);
    }
}

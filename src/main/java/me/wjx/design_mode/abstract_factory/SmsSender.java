package me.wjx.design_mode.abstract_factory;

/**
 * 消息发送
 * @author wjx
 * @date 2018/6/28 18:43
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("sms sender");
    }
}

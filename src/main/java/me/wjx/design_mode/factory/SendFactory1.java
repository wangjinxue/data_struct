package me.wjx.design_mode.factory;

/**
 * @author wjx 静态工厂
 * @date 2018/6/28 18:46
 */
public class SendFactory1 {
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}

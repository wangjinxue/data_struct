package me.wjx.design_mode.factory;

/**
 * @author wjx
 * @date 2018/6/28 18:45
 */
public class App {
    public static void main(String[] args) {
//        SendFactory sendFactory=new SendFactory();
//        Sender mail = sendFactory.produce("mail");
//        Sender sms = sendFactory.produce("sms");
//        mail.sender();
//        sms.sender();
        Sender mail = SendFactory1.produceMail();
        Sender sms=SendFactory1.produceSms();
        mail.sender();
        sms.sender();

    }
}

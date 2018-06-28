package me.wjx.design_mode.factory;

/**
 * @author wjx 普通工厂
 * @date 2018/6/28 18:42
 */
public class SendFactory {
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请输入正确的类型");
            return null;
        }
    }
}

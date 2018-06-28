package me.wjx.design_mode.abstract_factory;

/**
 * @author wjx
 * @date 2018/6/28 18:43
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("mail sender");
    }
}

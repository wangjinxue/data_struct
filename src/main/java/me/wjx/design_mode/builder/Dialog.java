package me.wjx.design_mode.builder;

/**
 * @author wjx
 * @date 2018/7/12 14:31
 */
public class Dialog {
    private String title;
    private String content;
    public Dialog(Builder builder) {
        this.title=builder.title;
        this.content=builder.title;
    }
    public static class Builder{
        private String title;
        private String content;
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
        public Builder setTitle(String title){
            this.title=title;
            return this;
        }
        public Dialog builder(){
            Dialog dialog=new Dialog(this);
            return dialog;
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        Dialog dialog=new Builder().setTitle("title").setContent("content").builder();
        System.out.println(dialog);
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

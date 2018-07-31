package me.wjx.design_mode.adapter;

/**
 * @author wjx
 * @date 2018/7/12 15:38
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer=new AudioPlayer();
        audioPlayer.play("mp3","你好吗.mp3");
        audioPlayer.play("mp4","我不是药神.mp4");
        audioPlayer.play("vlc","hello.vlc");
        audioPlayer.play("avi","abc.avi");
    }
}

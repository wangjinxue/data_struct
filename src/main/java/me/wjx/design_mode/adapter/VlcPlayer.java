package me.wjx.design_mode.adapter;

/**
 * @author wjx
 * @date 2018/7/12 15:29
 */
public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("play vlc"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}

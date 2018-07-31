package me.wjx.design_mode.adapter;

/**
 * @author wjx
 * @date 2018/7/12 15:30
 */
public class Mp4Player implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play Mp4"+fileName);
    }
}

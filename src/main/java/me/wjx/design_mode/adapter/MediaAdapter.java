package me.wjx.design_mode.adapter;

/**
 * @author wjx
 * @date 2018/7/12 15:31
 */
public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer=new VlcPlayer();
        }else{
            advanceMediaPlayer=new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if("mp4".equalsIgnoreCase(audioType)){
            advanceMediaPlayer.playMp4(fileName);
        }else if("vlc".equalsIgnoreCase(audioType)){
            advanceMediaPlayer.playVlc(fileName);
        }
    }

}

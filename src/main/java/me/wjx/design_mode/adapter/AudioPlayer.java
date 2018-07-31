package me.wjx.design_mode.adapter;

/**
 * @author wjx
 * @date 2018/7/12 15:35
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equalsIgnoreCase(audioType)){
            System.out.println("playing "+fileName);
        }else if("vlc".equalsIgnoreCase(audioType)||"mp4".equalsIgnoreCase(audioType)){
            mediaAdapter=new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else {
            System.out.println("不支持的数据类型");
        }
    }
}

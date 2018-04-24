import java.io.FileInputStream;
import java.io.IOException;


import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;


public class Music {

	
	
	public static void music() throws IOException
	{
		AudioPlayer backgroundPlayer = AudioPlayer.player;
		AudioStream backgroundMusic;
		AudioData myData;
		ContinuousAudioDataStream loop = null;
		
		try {
			backgroundMusic = new AudioStream(new FileInputStream("ninjaShort.wav"));

            myData = backgroundMusic.getData();
            loop = new ContinuousAudioDataStream(myData);
            System.out.println("Music is playing");
		}
		catch(IOException error) {System.out.println("File not found");}
        backgroundPlayer.start(loop);

		
	}

}

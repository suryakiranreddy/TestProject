package Common;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


@SuppressWarnings("restriction")
public class StringEncryptDecrypt {
	
public static String encryptXOR(String message, String key){
		
		try {
			if (message==null || key==null ) return null;
		
		    char[] keys=key.toCharArray();
		    char[] mesg=message.toCharArray();
		    
		    int ml=mesg.length;
		    int kl=keys.length;
		    char[] newmsg=new char[ml];
		    
		    for (int i=0; i<ml; i++){
		        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
		    }
		    mesg=null; 
		    keys=null;
		    return new String(new BASE64Encoder().encodeBuffer(new String(newmsg).getBytes()));
		    
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
	}	

public static String decryptXOR(String message, String key){
	try {
      if (message==null || key==null ) return null;
      BASE64Decoder decoder = new BASE64Decoder();
      char[] keys=key.toCharArray();
      char[] mesg=new String(decoder.decodeBuffer(message)).toCharArray();

      int ml=mesg.length;
      int kl=keys.length;
      char[] newmsg=new char[ml];

      for (int i=0; i<ml; i++){
        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
      }
      mesg=null; keys=null;
      return new String(newmsg);
    }
    catch ( Exception e ) {
      return null;
}  
}
}

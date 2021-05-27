public class CaesarCipher {
    public CaesarCipher() {}
    public String encrypt(String text, int key) {
        key%=26;
        String cipher = "";
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                cipher += Character.toString(((text.charAt(i) + key -65) % 26 + 65));
            }else {
                cipher += Character.toString(((text.charAt(i) + key -97) % 26 + 97));
            }
        }
        return cipher;
    }
    public String decrypt(String text, int key) {
        key%=26;
        String decipher = "";
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                decipher += Character.toString((text.charAt(i) - key) < 65 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
            }else {
                decipher += Character.toString((text.charAt(i) - key) < 97 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
            }
        }
        return decipher;
    }
}

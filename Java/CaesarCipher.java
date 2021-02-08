public class CaesarCipher {
    private String text, cipher, decipher;
    private int shift;

    public void setText(String text) {
        this.text = text;
    }
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
    public void setDecipher(String decipher) {
        this.decipher = decipher;
    }
    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getText() {
        return text;
    }
    public String getCipher() {
        return cipher;
    }
    public String getDecipher() {
        return decipher;
    }
    public int getShift() {
        return shift;
    }

    public String encrypt(String text, int key) {
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

    public void showResult(String encOrDec) {
        System.out.println("\nPlain Text : " + getText() + "\nShift or Key : " + getShift());
        System.out.println(encOrDec + " Text : " + (encOrDec.equals("Encrypted") ? getCipher() : getDecipher()));
    }
}

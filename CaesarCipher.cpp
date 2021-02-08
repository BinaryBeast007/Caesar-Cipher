#include<bits/stdc++.h>
using namespace std;

string decrypt(string s, int k){
    string decipher;
    for(int i=0; i<s.length(); i++){
        if(isupper(s[i])){
            decipher += (s[i] - k) < 65 ? (s[i] - k) + 26 : (s[i] - k); 
        }else{
            decipher += (s[i] - k) < 97 ? (s[i] - k) + 26 : (s[i] - k);
        }
    }
    return decipher;
}
 
string encrypt(string s, int k){
    string cipher;
    for(int i=0; i<s.length(); i++){
        if(isupper(s[i])){
            cipher += ((s[i] + k -65) % 26 + 65); 
        }else{
            cipher += ((s[i] + k -97) % 26 + 97);
        }
    }
    return cipher;
}
 
int main()
{
    string text, cipher, decipher;
    char choice; int shift;
    enterChoice:
    cout << "Choose a method below :\n1. Encrypt Text\n2. Decrypt Text\n\nEnter your choice : ";
    cin >> choice;
    if(choice < '1' || choice > '2'){
        cout << "Invalid input\n";
        goto enterChoice;
    }
    if(choice == '1'){
        cout << "Enter your text to encrypt : ";
        cin >> text;
        cout << "Enter your key or shift : ";
        cin >> shift;
        cout << "\nPlain Text : " << text << "\n";
        cout << "Shift : " << shift << "\n";
        shift %= 26;
        cipher = encrypt(text, shift);
        cout << "Encrypted Text : " << cipher << "\n";
    }else if(choice == '2'){
        cout << "Enter your text to decrypt : ";
        cin >> text;
        cout << "Enter your key or shift : ";
        cin >> shift;
        cout << "\n\nEncrypted Text : " << text << "\n";
        cout << "Shift : " << shift << "\n";
        shift %= 26;
        cipher = decrypt(text, shift);
        cout << "Decrypted Text\t: " << cipher << "\n";
    }
    cout << "\nPress 'y' to goto the main menu or press any other key to exit the program\n";
    cin >> choice;
    if(choice == 'y')
        goto enterChoice;
    
    return 0;
}

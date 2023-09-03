package org.example.generator;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import static org.passay.DictionarySubstringRule.ERROR_CODE;

public class Generator {
    public static String generatePassword() {
        PasswordGenerator generator = new PasswordGenerator();

        CharacterRule lowerRule = new CharacterRule(EnglishCharacterData.LowerCase);
        CharacterRule upperRule = new CharacterRule(EnglishCharacterData.UpperCase);
        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit);
        lowerRule.setNumberOfCharacters(2);
        upperRule.setNumberOfCharacters(2);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }

            @Override
            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule specialRule = new CharacterRule(specialChars);

        return generator.generatePassword(20,
                specialRule, lowerRule, upperRule, digitRule);
    }
}
